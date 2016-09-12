package edu.bstu.iipo.a13ivt1.lekveishvili;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onRestart");
    }

    public void onClick(View view) {
        Intent intent=null;
        String textView;
        switch (view.getId()){
            case R.id.button:
                Log.i(TAG,"Сall number");
                textView= ((TextView) findViewById(R.id.value_Phone)).getText().toString();
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+textView));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                break;
            case R.id.value_Phone:
                Log.i(TAG,"Dialing a number");
                textView= ((TextView) findViewById(R.id.value_Phone)).getText().toString();
                intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+textView));
                break;
            case  R.id.value_Email:
                Log.i(TAG,"Send email");
                String emailTo = ((TextView) findViewById(R.id.value_Email)).getText().toString();
                String[] emailToArray = {emailTo};
                String subject = "Тема сообщения";
                String message = "Текст сообщения";


                intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, emailToArray);
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,message);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Выберите клиент для отправки сообщения"));

                break;
        }
        startActivity(intent);
    }
}
