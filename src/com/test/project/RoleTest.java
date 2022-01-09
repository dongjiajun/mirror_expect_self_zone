package com.test.project;

import com.basic.role.HumanPlayer;
import org.junit.Test;

import java.io.IOException;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/11/25 4:55
 */
public class RoleTest {
    @Test
    public void test() throws IOException {
        //不加处理的单元测试无法满足多线程的测试，简单起见，就不用单元测试了
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        HumanPlayer humanPlayer = new HumanPlayer();
        new HumanPlayer().connectTo("localhost", 7001);
        System.out.println(humanPlayer.getName());
    }
}
