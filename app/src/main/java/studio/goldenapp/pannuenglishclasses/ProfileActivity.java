package studio.goldenapp.pannuenglishclasses;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private Button continueRegister ;
    private EditText name;
    private EditText age;
    private EditText email;
    private EditText place;
    private EditText gender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        continueRegister = findViewById(R.id.continueRegister);
        name = findViewById(R.id.fullname);
        age = findViewById(R.id.age);
        email = findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        place = findViewById(R.id.birthpalce);
        name = findViewById(R.id.fullname);


        continueRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}