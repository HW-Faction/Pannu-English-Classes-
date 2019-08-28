package studio.goldenapp.pannuenglishclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {

    private TextView mScoreView, mQuestions;
    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4, Logout;
    private int mScore = 0, mQueNum = 0;
    private String mAnswer;
    private Firebase mQueRef, mChoice1Ref, mChoice2Ref, mChoice3Ref, mChoice4Ref, mAnsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = findViewById(R.id.score);
        mQuestions = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);
        Logout = findViewById(R.id.out);
        mScoreView = findViewById(R.id.score);
        mScoreView = findViewById(R.id.score);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice1.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore, mQueNum);
                    updateQuestion();
                } else  {
                    updateQuestion();
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice1.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore, mQueNum);
                    updateQuestion();
                } else  {
                    updateQuestion();
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice1.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore, mQueNum);
                    updateQuestion();
                } else  {
                    updateQuestion();
                }
            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice1.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore, mQueNum);
                    updateQuestion();
                } else  {
                    updateQuestion();
                }
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent outIntent = new Intent(QuizActivity.this, Authentication.class);
                startActivity(outIntent);
                finish();
            }
        });


    }

    public void updateScore(int score, int mQueNum){
        mScoreView.setText(""+score+"/"+mQueNum);
    }

    public void updateQuestion() {
        mQueRef = new Firebase("https://pannu-english-classes.firebaseio.com/"+mQueNum+"/question");

        mQueRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                mQuestions.setText(question);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice1Ref = new Firebase("https://pannu-english-classes.firebaseio.com/"+mQueNum+"/choice1");

        mChoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice1 = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice1);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice2Ref = new Firebase("https://pannu-english-classes.firebaseio.com/"+mQueNum+"/choice2");

        mChoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice2 = dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice2);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice3Ref = new Firebase("https://pannu-english-classes.firebaseio.com/" + mQueNum + "/choice3");

        mChoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice3 = dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice3);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice4Ref = new Firebase("https://pannu-english-classes.firebaseio.com/" + mQueNum + "/choice4");

        mChoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FirebaseAuth.getInstance().signOut();


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mAnsRef = new Firebase("https://pannu-english-classes.firebaseio.com/0/answer");

        mAnsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mQueNum++;

    }
}
