package com.example.jh352160.new_demo.test10.massager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/10/17.
 */

public class MessengerActivity extends AppCompatActivity{

    private static final String TAG=" MessengerActivity";

    private Messenger mService;

    private Messenger mGetReplyMessenger=new Messenger(new MessengerHandler());
    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 2:
                    Log.i(TAG,"receive msg from service :" +msg.getData());
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }

    private ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService=new android.os.Messenger(service);
            Message msg=Message.obtain(null,1);
            Bundle data=new Bundle();
            data.putString("msg","hello,this is client");
            msg.setData(data);
            msg.replyTo=mGetReplyMessenger;
            try{
                mService.send(msg);
            }catch (RemoteException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger_activity);
        Intent intent=new Intent(this,MessengerService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }
}
