package comgokul.example.connectfree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class signupactivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText emailBox, passwordBox , nameBox;
    button loginBtn, signupBtn;


     FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        database = FirebaseAuth.getInstance();
        auth = FirebaseAuth.getInstance();

        emailBox = findViewById(R.id.emailBox);
        nameBox = findViewById(R.id.nameBox);
        passwordBox = findViewById(R.id.passwordBox);

        logibBtn = findViewById(R.id.loginbtn);

        signupBtn = findViewById(R.id.signupbtn);


        signupBtn.setonClickListener(new view.OnClicklistner() {
            @override
                    public void onclick(view v){
                String email, pass, name;
            email = emailBox.getText().toString();
            pass = passwordBox.getText().toString();
            name = nameBox.getText().toString();

            user user = new user();
            user.setEmail(email);
            user.setPass(pass);
            user.setName(name);

            auth.createuserWithEmailAndPassword(email, pass). addOnCompleteListener(new .OnCompletionListener<AuthResult>()){
                @override

            public void OnComplete(@NonNull Task<AuthResult> task){
                    if(task.isSuccessful()){
                        database.collection(collectionpath: "users")
                          .document().set(user).addOnSuccessListener(new OnSuccessListener<void>()){

                            startActivity(new Intent(PackageContext: signupActivity.this, LoginActivity.class));
                        });
                        Toast.makeText(signupactivity.this, "Account is created", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context:SignupActivity.this, task.getException().getLocalizedMessage(), toast.LENGTH_SHORT).show();

                    }

                    }
                }
                }

        }
    });
}