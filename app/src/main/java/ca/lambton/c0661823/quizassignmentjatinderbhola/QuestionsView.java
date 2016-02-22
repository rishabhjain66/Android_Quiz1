package ca.lambton.c0661823.quizassignmentjatinderbhola;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class QuestionsView extends Activity {

    String question[] = {
            "Who invented the first steam train?",
            "Who write Computer Language C ?" ,
            "who discovered insulin ? ",
            "Where is CN Tower Located? " ,
            "Who is the President of USA?" ,
            "where is the  Longest Wall in the world Situated?  " ,
            " World Strongest Economy ?" ,
            "Which one of following  is the Founder member of Apple inc ?" ,
            " Where is Niagara Falls Located? " ,
            " World Largest Country in Area?" ,

    };
    String answer[] = {
            "Richard Trevithick",
            "Dennis Ritchie ",
            "Frederick Banting",
            "Toronto,Canada",
            "Barack Obama",
            "China",
            "USA",
            "Steve Jobs",
            "Canada",
            "Russia",
    };

    String options[] = {"Richard Trevithick" , "George Stephenson" , "Neil Lincon" , "George Trevi",
                        "Bjarne Stroustrup","Dennis Ritchie ","james Gosling","Van Rossum",
                        "Frederick Banting","Daniel Gabriel Fahrenheit","Leif Eriksson","james hill",
                        "Toronto,Canada","New York,USA","Berlin,Germany","Paris,France",
                        "Narinder Modi","Barack Obama","Vladimir Putin","Stephen Harper",
                        "USA","China","France","India",
                        "USA","China","France","India",
                        "Alexander Graham Bell","Steve Jobs","Richard Bransom","Nikki haley",
                        "Canada","Netherland","France","Japan",
                        "Russia","Canada","Japan","USA",




    };

    static int index = 0, correct = 0, wrong = 0, score = 0;
    ArrayList<Integer> list;
    int quesIndexNumber = 0;

    TextView ques;
    Button next;
    RadioGroup rg;
    RadioButton optionA, optionB, optionC, optionD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ca.lambton.c0661823.quizassignmentjatinderbhola.R.layout.activity_questions_view);

        ques = (TextView)findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.Question);
        next = (Button) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.nextButton);
        rg = (RadioGroup) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.radioGroup);
        optionA = (RadioButton) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.optionA);
        optionB = (RadioButton) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.optionB);
        optionC = (RadioButton) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.optionC);
        optionD = (RadioButton) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.optionD);

//_-------------------

        list = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<5; i++) {
            //System.out.println(list.get(i));
            Log.d("unique random number", String.valueOf(list.get(i)));
        }


        quesIndexNumber = list.get(index);

        //first question
        ques.setText(question[quesIndexNumber]);
        optionA.setText(options[quesIndexNumber*4+0]);
        optionB.setText(options[quesIndexNumber*4+1]);
        optionC.setText(options[quesIndexNumber*4+2]);
        optionD.setText(options[quesIndexNumber*4+3]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean x = false;
                RadioButton temp  = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                if(answer[quesIndexNumber].equals(temp.getText().toString()))
                {
                    correct++;

                }
                else
                {
                    wrong++;

                }

                index++;
                quesIndexNumber = list.get(index);

                //Toast.makeText(getBaseContext(),String.valueOf(index), Toast.LENGTH_LONG);
                if(index < 5){
                    ques.setText(question[quesIndexNumber]);
                    optionA.setText(options[quesIndexNumber*4+0]);
                    optionB.setText(options[quesIndexNumber*4+1]);
                    optionC.setText(options[quesIndexNumber*4+2]);
                    optionD.setText(options[quesIndexNumber*4+3]);
                }
                else{
                    if(Toggle_Button.flag){
                        score = correct - wrong;
                    }
                    else{
                        score = correct;
                    }
                    Intent i = new Intent(getApplicationContext(),ResultView.class);
                    startActivity(i);
                }
                rg.clearCheck();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(ca.lambton.c0661823.quizassignmentjatinderbhola.R.menu.menu_questions_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
