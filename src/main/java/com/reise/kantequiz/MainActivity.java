package com.reise.kantequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtQuestion,txtQuestionNumber;
    private Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4,btnAnswer5;
    private ArrayList<QuizModel> mQuizModels;

    int currentScore = 0;
    int questionAttempted = 0;
    int currentPos;
    Random mRandom;
    AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        setQuizQuestions(mQuizModels);

        currentPos = mRandom.nextInt(mQuizModels.size());

        setDataToViews(currentPos);

//ads setup
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);
//ads setup
        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuizModels.get(currentPos).getCorrectAnswer().trim().toLowerCase().equals(btnAnswer1.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }

                questionAttempted++;
                currentPos = mRandom.nextInt(mQuizModels.size());
                setDataToViews(currentPos);
            }
        });

        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuizModels.get(currentPos).getCorrectAnswer().trim().toLowerCase().equals(btnAnswer2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }

                questionAttempted++;
                currentPos = mRandom.nextInt(mQuizModels.size());
                setDataToViews(currentPos);
            }
        });

        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuizModels.get(currentPos).getCorrectAnswer().trim().toLowerCase().equals(btnAnswer3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }

                questionAttempted++;
                currentPos = mRandom.nextInt(mQuizModels.size());
                setDataToViews(currentPos);
            }
        });

        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuizModels.get(currentPos).getCorrectAnswer().trim().toLowerCase().equals(btnAnswer4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }

                questionAttempted++;
                currentPos = mRandom.nextInt(mQuizModels.size());
                setDataToViews(currentPos);
            }
        });

        btnAnswer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuizModels.get(currentPos).getCorrectAnswer().trim().toLowerCase().equals(btnAnswer5.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }

                questionAttempted++;
                currentPos = mRandom.nextInt(mQuizModels.size());
                setDataToViews(currentPos);
            }
        });
    }





   private void showResultSheet(){

       final Dialog resultDialog = new Dialog(MainActivity.this);

       View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet,(LinearLayout)findViewById(R.id.idResultsLayout));
       TextView results = sheetView.findViewById(R.id.idScore);
       Button btnRestart = sheetView.findViewById(R.id.btnRestart);
       Button btnClose = sheetView.findViewById(R.id.btnClose);

       results.setText("Your Score Is : "+currentScore+"/6");



       btnRestart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               currentPos  = mRandom.nextInt(mQuizModels.size());

               questionAttempted = 0;
               currentScore = 0;
               resultDialog.dismiss();
               setDataToViews(currentPos);
           }
       });

       btnClose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               resultDialog.dismiss();
               finish();
           }
       });

       resultDialog.setCancelable(false);
       resultDialog.setContentView(sheetView);
       resultDialog.show();
   }




    private void setDataToViews(int currentPos) {

        txtQuestionNumber.setText("Questions Attempted :" + questionAttempted+"/6");

        if(questionAttempted == 6){
            showResultSheet();
        }else{
            txtQuestion.setText(mQuizModels.get(currentPos).getQuestion());

            btnAnswer1.setText(mQuizModels.get(currentPos).getAnswer1());
            btnAnswer2.setText(mQuizModels.get(currentPos).getAnswer2());
            btnAnswer3.setText(mQuizModels.get(currentPos).getAnswer3());
            btnAnswer4.setText(mQuizModels.get(currentPos).getAnswer4());
            btnAnswer5.setText(mQuizModels.get(currentPos).getAnswer5());
        }



    }

    private void setQuizQuestions(ArrayList<QuizModel> quizModels) {
        quizModels.add(new QuizModel("What's N'Golo Kante's Full Name?","Nicolas Golo Kante","Norman Golo Kante","Noel Golo Kante","N'Golo Kante","Nigel Golo Kante","N'Golo Kante"));
        quizModels.add(new QuizModel("Which Year Was He Born?","1981","1991","1990","1987","1995","1991"));
        quizModels.add(new QuizModel("What Is His First Senior Career Team?","Boulogne","Leicester City","Chelsea","West Ham","Liverpool","Boulogne"));
        quizModels.add(new QuizModel("When Did He Join Ligue 2?","2011","2010","2013","2016","2015","2013"));
        quizModels.add(new QuizModel("Which Team Did He Play For In Ligue 2?","RC Lens","Amiens SC","Caen","Paris FC","FC Metz","Caen"));

        quizModels.add(new QuizModel("When Did He Join Leicester City?","3 August 2015","10 May 2016","18 May 2012","12 March 2017","22 June 2017","3 August 2015"));
        quizModels.add(new QuizModel("Which Team Won The 2015-2016 Premier League with Kante?","Leicester City","Chelsea","Liverpool","Manchester United","Manchester City","Leicester City"));
        quizModels.add(new QuizModel("How Many Successful Tackles Did He Make In the 2015-16 Premier League Season?","31","70","124","175","101","175"));
        quizModels.add(new QuizModel("When Was He Nominated For The Ballon d'Or?","October 2017","May 2015","June 2011","July 2017","July 2019","October 2017"));
        quizModels.add(new QuizModel("When Did He Join Chelsea?","2015","2016","2020","2011","2013","2016"));

        quizModels.add(new QuizModel("Where Was He Born?","Marseille","Paris","Lyon","Nice","Bordeaux","Paris"));
        quizModels.add(new QuizModel("The National Team He Plays For Is : ____","Germany","Italy","Portugal","France","England","France"));
        quizModels.add(new QuizModel("His Favourite Dish Is : ______","Confit de canard","Flamiche","Cassoulet","Coq au vin","Thieboudienne","Thieboudienne"));
        quizModels.add(new QuizModel("Besides Football He Enjoys Playing : ____","Boxing","Karate","Poker","Tennis","Table Tennis","Tennis"));
        quizModels.add(new QuizModel("What Is His Preferred Foot?","Left","Both Left & Right","Right","None","Left Sometimes Right","Right"));

        quizModels.add(new QuizModel("Which Players Got Dribbled When Kante Scored His First Chelsea Goal?","Pogba & Jones","Pogba & Valencia","Pogba & Smalling","Valencia & Smalling","Valencia & Jones","Pogba & Smalling"));
        quizModels.add(new QuizModel("Who Said This About Kante : `There's not a game i don't enjoy playing next to him`?","Eden Hazard","Frank Lampard","Kylian Mbappe","Danny Drinkwater","Paul Pogba","Danny Drinkwater"));




    }

    private void initialize() {

        txtQuestion = findViewById(R.id.idQuestions);
        txtQuestionNumber = findViewById(R.id.idQuestionsAttempted);
        btnAnswer1 = findViewById(R.id.btnAnswer1);
        btnAnswer2 = findViewById(R.id.btnAnswer2);
        btnAnswer3 = findViewById(R.id.btnAnswer3);
        btnAnswer4 = findViewById(R.id.btnAnswer4);
        btnAnswer5 = findViewById(R.id.btnAnswer5);


        mQuizModels = new ArrayList<>();
        mRandom = new Random();
    }
}
