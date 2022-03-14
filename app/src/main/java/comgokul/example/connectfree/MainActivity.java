package comgokul.example.connectfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new handler().postDelayed(new Runnable() {
            @Override
            public void run(){
               startActivity(new Intent(MainActivity.this, loginActivity.class));
         },delayMillis:2000);
     }
 }