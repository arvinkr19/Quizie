package com.example.a1605265.quizie;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a1605265.quizie.Model.Question;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView t1_question, timertxt;
    int total=0;
    int correct=0;
    int wrong=0;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b1=(Button)findViewById(R.id.button1);
    b2=(Button)findViewById(R.id.button2);
    b3=(Button)findViewById(R.id.button3);
    b4=(Button)findViewById(R.id.button4);

    t1_question=(TextView)findViewById(R.id.questionsText);
    timertxt=(TextView)findViewById(R.id.timerTxt);

    updateQuestion();
    reverseTimer(30,timertxt);
    }

    private void updateQuestion() {
        total++;
    if (total>4){
        //open the result Activity
        Intent i = new Intent(MainActivity.this,ResultActivity.class);
        i.putExtra("total",String.valueOf(total-1));
        i.putExtra("correct",String.valueOf(correct));
        i.putExtra("wrong",String.valueOf(wrong));
        startActivity(i);
    }

    else{
        Log.i("Question", String.valueOf(total));
        reference= FirebaseDatabase.getInstance().getReference().child("Question").child(String.valueOf(total));
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final Question question = dataSnapshot.getValue(Question.class);

                t1_question.setText(question.getQuestion());
                b1.setText(question.getOptions1());
                b2.setText(question.getOption2());
                b3.setText(question.getOption3());
                b4.setText(question.getOption4());


                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(b1.getText().toString().equals(question.getAnswer()))
                        {
                            correct++;
                            b1.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    b1.setBackgroundColor(Color.parseColor("#03A9F4"));

                                 updateQuestion();
                                }
                            },1000);
                        }

                        else
                        {
                            //answer is wrong...we wil find correct answer and make ir green

                            wrong++;
                            b1.setBackgroundColor(Color.RED);
                            if(b2.getText().toString().equals(question.getAnswer()))
                            {
                                b2.setBackgroundColor(Color.GREEN);
                            }
                            else if(b3.getText().toString().equals(question.getAnswer()))
                            {
                                b3.setBackgroundColor(Color.GREEN);
                            }
                            else if(b4.getText().toString().equals(question.getAnswer()))
                            {
                                b4.setBackgroundColor(Color.GREEN);
                            }

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                    updateQuestion();
                                }
                            },1000);
                            }
                    }
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(b2.getText().toString().equals(question.getAnswer()))
                        {
                            correct++;
                            b2.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    b2.setBackgroundColor(Color.parseColor("#03A9F4"));

                                    updateQuestion();
                                }
                            },1000);
                        }

                        else
                        {
                            //answer is wrong...we wil find correct answer and make ir green

                            wrong++;
                            b2.setBackgroundColor(Color.RED);
                            if(b1.getText().toString().equals(question.getAnswer()))
                            {
                                b1.setBackgroundColor(Color.GREEN);
                            }
                            else if(b3.getText().toString().equals(question.getAnswer()))
                            {
                                b3.setBackgroundColor(Color.GREEN);
                            }
                            else if(b4.getText().toString().equals(question.getAnswer()))
                            {
                                b4.setBackgroundColor(Color.GREEN);
                            }

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                    updateQuestion();
                                }
                            },1000);
                        }
                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(b3.getText().toString().equals(question.getAnswer()))
                        {
                            correct++;
                            b3.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    b3.setBackgroundColor(Color.parseColor("#03A9F4"));

                                    updateQuestion();
                                }
                            },1000);
                        }

                        else
                        {
                            //answer is wrong...we wil find correct answer and make ir green

                            wrong++;
                            b3.setBackgroundColor(Color.RED);
                            if(b1.getText().toString().equals(question.getAnswer()))
                            {
                                b1.setBackgroundColor(Color.GREEN);
                            }
                            else if(b2.getText().toString().equals(question.getAnswer()))
                            {
                                b2.setBackgroundColor(Color.GREEN);
                            }
                            else if(b4.getText().toString().equals(question.getAnswer()))
                            {
                                b4.setBackgroundColor(Color.GREEN);
                            }

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                    updateQuestion();
                                }
                            },1000);
                        }
                    }
                });




                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(b4.getText().toString().equals(question.getAnswer()))
                        {
                            correct++;
                            b4.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                    updateQuestion();
                                }
                            },1500);
                        }

                        else
                        {
                            //answer is wrong...we wil find correct answer and make ir green

                            wrong++;
                            b4.setBackgroundColor(Color.RED);
                            if(b1.getText().toString().equals(question.getAnswer()))
                            {
                                b1.setBackgroundColor(Color.GREEN);
                            }
                            else if(b2.getText().toString().equals(question.getAnswer()))
                            {
                                b2.setBackgroundColor(Color.GREEN);
                            }
                            else if(b3.getText().toString().equals(question.getAnswer()))
                            {
                                b3.setBackgroundColor(Color.GREEN);
                            }

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                    updateQuestion();
                                }
                            },1500);
                        }
                    }
                });
                }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                }
             });
        }

    }

     public  void reverseTimer(int seconds, final TextView tv){

        new CountDownTimer(seconds*1000+1000,1000){
            public void onTick(long milliUnitsFinished){
                int seconds= (int)(milliUnitsFinished/1000);
                int minutes = seconds/60;
                seconds = seconds %60;
                tv.setText(String.format("%02d",minutes)
                        + ":"+String.format("%02d",seconds));
            }
            public  void onFinish(){
                tv.setText("Completed");
                Intent myIntent = new Intent(MainActivity.this,ResultActivity.class);
                myIntent.putExtra("total",String.valueOf(total));
                myIntent.putExtra("correct",String.valueOf(correct));
                myIntent.putExtra("incorrect",String.valueOf(wrong));

            }

        }.start();
     }
}

