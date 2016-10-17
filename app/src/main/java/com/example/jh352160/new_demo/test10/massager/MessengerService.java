package com.example.jh352160.new_demo.test10.massager;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jh352160 on 2016/10/17.
 */

public class MessengerService extends Service {

    private static final String TAG="MessengerService";

    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case  1:
                    Log.i(TAG,"receive msg from Client:" +msg.getData().getString("msg"));
                    Messenger client=msg.replyTo;
                    Message relpyMessage=Message.obtain(null,2);
                    Bundle bundle=new Bundle();
                    bundle.putString("reply","please wait sometime,I will reply you later");
                    relpyMessage.setData(bundle);
                    try{
                        client.send(relpyMessage);
                    }catch(RemoteException e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }

    }

    private final Messenger mMessenger=new Messenger(new MessengerHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }
}
