package com.example.project;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer media,sound;

    public MyService() {
    }

    @Override
    public void onCreate() {
        media= MediaPlayer.create(this,R.raw.bgmusic);
       // sound = MediaPlayer.create(this,R.raw.bgmusic);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!media.isPlaying())
            media.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {

        if(media.isPlaying())
            media.stop();
        media.release();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}