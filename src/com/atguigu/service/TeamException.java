package com.atguigu.service;

/**
 * ClassName: TeamException
 * Description:
 *
 * @Author Wei Wang
 * @Create 2024/3/25 14:05
 * @Version 1.0
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -338754229948L;
    public TeamException(){
    }

    public TeamException(String message) {
        super(message);
    }
}
