package com.basic.message;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/11/25 22:00
 */
public class Message {
    private String message;

    public Message() {}

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
