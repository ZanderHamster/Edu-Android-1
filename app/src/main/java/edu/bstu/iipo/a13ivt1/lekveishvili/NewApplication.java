package edu.bstu.iipo.a13ivt1.lekveishvili;


import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

public class NewApplication extends Application{
    public static final String TAG = "Application";
    //Вызывается при запуске приложения
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate");
    }
    //Вызывается рпи нехватки памяти
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG,"onLowMemory");
    }
    //Вызывается при запуске в эмуляторе
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.i(TAG,"onTerminate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG,"onConfigurationChanged");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i(TAG,"onTrimMemory");
    }
}
