package com.example.ths.demobroadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by ths on 12/05/2017.
 */

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service start!", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean stopService(Intent name) {
        Toast.makeText(this, "Service Stop", Toast.LENGTH_SHORT).show();
        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();

    }
}
