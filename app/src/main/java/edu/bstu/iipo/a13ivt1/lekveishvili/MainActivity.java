package edu.bstu.iipo.a13ivt1.lekveishvili;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent=null;
        String textView;
        switch (view.getId()){
            case R.id.button:
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

                textView= ((TextView) findViewById(R.id.value_Phone)).getText().toString();
                intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+textView));
                break;
            case  R.id.value_Email:
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
