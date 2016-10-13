package com.example.jh352160.new_demo.test10.network;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/10/8.
 */

public class Test10_2 extends AppCompatActivity {

    //服务端地址
    private final static String serverIp="192.168.11.182";
    //服务端口号
    private final static int serverPort=9999;
    //控件
    private TextView showTv;
    private EditText contentEdt;
    private Button sendBtn;
    //tcp套接字客户端
    private TcpSocketClient mTcpSocketClient;
    //自定义Handle,用于更新UI
    private Handler mHandler=new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test10_2);
        showTv=(TextView)findViewById(R.id.textView);
        contentEdt=(EditText)findViewById(R.id.editText);
        sendBtn=(Button)findViewById(R.id.button);

        //初始化tcp套接字客户端
        mTcpSocketClient=new TcpSocketClient(serverIp, serverPort, new TcpSocketClient.TcpSocketListener() {
            @Override
            public void callBackContent(final String content) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (showTv!=null){
                            showTv.setText(showTv.getText().toString()+content);
                        }
                    }
                });
            }

            @Override
            public void clearInputContent() {
                if (contentEdt!=null){
                    contentEdt.setText("");
                }
            }
        });

        //启动tcp套接字连接
        mTcpSocketClient.startTcpSocketConnect();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=contentEdt.getText().toString().trim();
                mTcpSocketClient.sendMessageByTcpSocket(msg);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mTcpSocketClient!=null){
            mTcpSocketClient.sendMessageByTcpSocket("exit");
        }
        super.onDestroy();
    }
}
