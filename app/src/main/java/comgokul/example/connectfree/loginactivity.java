package comgokul.example.connectfree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {
 EditText emailBox, passwordBox;
 button loginBtn, signupBtn;

 FirebaseAuth  auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

     auth = FirebaseAuth.getInstance();
        emailBox = findViewById(R.id.emailBox);
        passwordBox = findViewById(R.id.passwordBox);

        logibBtn = findViewById(R.id.loginbtn);

        signupBtn = findViewById(R.id.signupbtn);

       loginBtn.setonClickListener(new view.onClickListner()){
           @Override
                   public void onClick(view v)
            {
                String email,password;
                email = emailBox.getText().tostring();
                password = passwordBox.getText().tostring();
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new MediaPlayer.OnCompletionListener())
            @override
                    public void OnComplete(@NonNull Task<AuthResult> task) {
                    if(tesk.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this,text: "logged in", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
            }
            };



        });
        signupBtn.setonClickListener(new View.OnClickListener() {

            @Override
            public void onClick(view v){
                startActivity(new intent(LoginActivity.this, SignupActivity.class));
            }
        })
    }
}