package com.basic.common;

import java.net.Socket;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/6 22:30
 */
public interface AccessProcessing {

    /**
     * @param identity       以 “ip地址+":"+端口号” 组成的身份标识
     * @param socket         用户的连接
     * @return
     */

     public boolean addToAccessNodeList(String identity, Socket socket);

     public boolean removeFromAccessNodeList(String identity);

     public boolean updateWhenExistIn(String identity, Socket socket);

}
