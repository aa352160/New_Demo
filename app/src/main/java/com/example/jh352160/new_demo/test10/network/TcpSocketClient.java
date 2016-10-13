package com.example.jh352160.new_demo.test10.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by jh352160 on 2016/10/13.
 */

public class TcpSocketClient {

    //服务端地址
    private String serverIp="192.168.11.182";
    //服务端端口号
    private int serverPort=9999;
    //套接字
    private Socket mSocket =null;
    //缓冲区读取
    private BufferedReader in=null;
    //字符流打印
    private PrintWriter out =null;
    //tcp套接字监听
    private TcpSocketListener mTcpSocketListener;
    //内容
    private String content="";

    /**
     * 构造函数
     * @param mTcpSocketListener
     */
    public TcpSocketClient(TcpSocketListener mTcpSocketListener){
        this.mTcpSocketListener=mTcpSocketListener;
    }

    /**
     * 构造函数
     * @param serverIp 服务端地址
     * @param serverPort 服务端口号
     * @param mTcpSocketListener tcp套接字监听
     */
    public TcpSocketClient(String serverIp,int serverPort,TcpSocketListener mTcpSocketListener){
        this.serverIp=serverIp;
        this.serverPort=serverPort;
        this.mTcpSocketListener=mTcpSocketListener;
    }

    /**
     * 启动tcp套接字连接
     */
    public void startTcpSocketConnect(){
        //开启一个线程启动tcp socket
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    mSocket=new Socket(serverIp,serverPort);
                    in=new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
                    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(mSocket.getOutputStream());
                    out=new PrintWriter(new BufferedWriter(outputStreamWriter),true);
                    while(true){
                        if (mSocket.isConnected()){
                            if (!mSocket.isInputShutdown()){
                                if ((content=in.readLine())!=null){
                                    content+="\n";
                                    if (mTcpSocketListener!=null){
                                        mTcpSocketListener.callBackContent(content);
                                    }
                                }
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 通过tcp套接字发送消息
     */
    public void sendMessageByTcpSocket(String msg){
        if (mSocket!=null&&mSocket.isConnected()){
            if (!mSocket.isOutputShutdown()&&out!=null){
                out.println(msg);
                if (mTcpSocketListener!=null){
                    mTcpSocketListener.clearInputContent();
                }
            }
        }
    }

    /**
     * tcp套接字监听接口
     */
    public interface TcpSocketListener{
        void callBackContent(String content);
        void clearInputContent();
    }

}
