package com.basic.network.handler;

import com.basic.common.AccessProcessing;
import com.basic.graphic.map.AbstractNetWorkAccessibleMap;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/5 17:15
 */
public class UserConnectHandler extends  ConnectHandler{
    private Socket sock;

    private String classType;

    private AccessProcessing accessProcessingObj;

    private AbstractNetWorkAccessibleMap map;

    public UserConnectHandler(Socket sock, String classType, AccessProcessing accessProcessingObj, AbstractNetWorkAccessibleMap map) {
        this.sock = sock;
        this.classType = classType;
        this.accessProcessingObj = accessProcessingObj;
        this.map = map;
    }

    @Override
    public void run() {
        try {
            execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void execute() throws IOException {
        InputStream input = sock.getInputStream();
        OutputStream output = sock.getOutputStream();
        try{
            handle(input, output);
        }catch(IOException e){
            try {
                sock.close();
            } catch (IOException ioe) {
            }finally {
                System.out.println("用户:(" + sock.getRemoteSocketAddress() + ") 意外终止连接!");
                accessProcessingObj.removeFromAccessNodeList(sock.getInetAddress().toString() + ":" + sock.getPort());
                return;
            }

        }
        sock.close();
        System.out.println("用户:(" + sock.getRemoteSocketAddress() + ") 已离开");
        accessProcessingObj.removeFromAccessNodeList(sock.getInetAddress().toString() + ":" + sock.getPort());
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        writer.write("已进入(" + (classType == null ? "未知区域":classType) + ")，请选择你的操作：\n");
        writer.flush();
        for (;;) {
            String s = reader.readLine();
            if (s.equals("bye")) {
                writer.write("bye\n");
                writer.flush();
                break;
            }
            switch(parseInput(s)){
                //case 0 是用于测试的分支，时间原因，暂时测试还没有做完
                case 0:
                    int[] coordinates = map.getCoordinatesFrom(s);
                    if(map.checkCoordinatesValidity(coordinates))
                        System.out.println("(" + sock.getRemoteSocketAddress() + ")的位置是" + Arrays.toString(coordinates));
                    else
                        System.out.println("(" + sock.getRemoteSocketAddress() + ")尝试设置违法坐标.");
                    writer.write("服务器已成功解析提交"+"\n");
                    writer.flush();
                    break;
                default:
                    writer.write("下达的指令是:"+s+"\n");
                    writer.flush();
                    break;
            }
        }
    }



    //为了测试方便，暂时定义的方法
    private int parseInput(String str){

        // TODO: 2021/12/12 后续的正式方法，这里要做许多和预先协议好的格式相关的正则模式,用于匹配并获得真正的目的

        return 0;
    }
}

