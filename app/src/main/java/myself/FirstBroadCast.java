package myself;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by dllo on 15/12/22.
 */
public class FirstBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "这是啥", Toast.LENGTH_SHORT).show();
        //通过隐式Intent启动Activity
        Intent startMyselfIntent = new Intent();
        startMyselfIntent.setAction("com.lanou.broadcastdemo.MYSELE_ACTIVITY");
        startMyselfIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//添加跳转
        context.startActivity(startMyselfIntent);
    }
}
