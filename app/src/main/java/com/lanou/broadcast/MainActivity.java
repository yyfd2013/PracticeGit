package com.lanou.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CodeAirModeRecriver codeAirModeRecriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        findViewById(R.id.btn_send_my_normal).setOnClickListener(this);

        codeAirModeRecriver = new CodeAirModeRecriver();
        registerReceiver(codeAirModeRecriver,intentFilter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send_my_normal:
                Intent sendNormalIntent = new Intent();
                sendNormalIntent.setAction("com.lanou.broadcast.TEXT");
                sendBroadcast(sendNormalIntent);//
                break;
        }
    }


    class CodeAirModeRecriver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "动态注册的广播接收", Toast.LENGTH_SHORT).show();
        }
    }
}
