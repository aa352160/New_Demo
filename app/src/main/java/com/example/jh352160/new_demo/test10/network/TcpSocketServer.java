package com.example.jh352160.new_demo.test10.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jh352160 on 2016/10/13.
 */

public class TcpSocketServer {
    //端口号
    private final static int serverPort=9999;
    //tcp套接字列表
    private List<Socket> mList=new ArrayList<Socket>();
    //套接字服务
    private ServerSocket server=null;
    //线程池
    private ExecutorService mExecutorService=null;

    /**
     * 主函数入口
     */
    public static void main(String[] args){
        //启动tcp套接字服务
        new TcpSocketServer();
    }

    /**
     * 启动tcp套接字服务
     */
    public TcpSocketServer(){
        try{
            server=new ServerSocket(serverPort);
            System.out.print("server start.....");
            Socket client=null;
            //create a thread pool
            mExecutorService= Executors.newCachedThreadPool();
            while(true){
                client=server.accept();
                mList.add(client);
                mExecutorService.execute(new TcpSocketService(client));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * tcp套接字服务
     */
    class TcpSocketService implements Runnable{

        //套接字
        private Socket socket;
        //缓冲区读取
        private BufferedReader in=null;
        //消息
        private String msg="";

        /**
         * 构造函数
         */
        public TcpSocketService(Socket socket){
            this.socket=socket;
            try{
                in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                msg="tips:user"+this.socket.getInetAddress()+"come";
                this.sendmsg();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        // TODO: 2016/10/13 当应用被强制关闭时不会显示break
        @Override
        public void run() {
            try{
                while(true){
                    if (socket.isConnected()) {
                        if ((msg = in.readLine()) != null) {
                            if (msg.equals("exit")) {
                                mList.remove(socket);
                                in.close();
                                msg = "tips:user" + this.socket.getInetAddress() + " exit";
                                socket.close();
                                this.sendmsg();
                                break;
                            } else {
                                msg = socket.getInetAddress() + ":" + msg;
                                this.sendmsg();
                            }
                        }
                    }else{
                        msg = "tips:user" + this.socket.getInetAddress() + " break";
                        this.sendmsg();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        /**
         * 发送消息
         */
        public void sendmsg(){
            System.out.println(msg);
            int num=mList.size();
            for (int index = 0; index < num; index++) {
                Socket mSocket=mList.get(index);
                PrintWriter pout=null;
                try {
                    pout=new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream())),true);
                    pout.println(msg);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
