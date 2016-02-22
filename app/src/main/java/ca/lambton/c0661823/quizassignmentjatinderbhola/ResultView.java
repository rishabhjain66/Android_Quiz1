package ca.lambton.c0661823.quizassignmentjatinderbhola;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultView extends Activity {

    TextView result;
    Button restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ca.lambton.c0661823.quizassignmentjatinderbhola.R.layout.activity_result_view);

        result = (TextView) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.resultTextView);
        restart = (Button) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.restartButton);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct Answers: "+ QuestionsView.correct);
        sb.append("\nWrong Answers: "+ QuestionsView.wrong);
        sb.append("\nScore : " + QuestionsView.score);

        if(QuestionsView.score == 5)
            sb.append("\n\n\n Awesome!!!!!!");
        else if(QuestionsView.score == 4)
            sb.append("\n\n\n Nice work!!!");
        else if(QuestionsView.score == 3)
            sb.append("\n\n\n Need Focus");
        else
            sb.append("\n\n\n Please try again!!!");
/*
*1.	Score 0/5, 1/5 and 2/5 Message => “Please try again!”
2.	Score 3/5 Message => “Good job!”
3.	Score 4/5 Message => “Excellent work!”
4.	Score 5/5 Message => “You are a genius!”

 *  */
        result.setText(sb.toString());
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionsView.correct = 0;
                QuestionsView.wrong = 0;
                QuestionsView.index = 0;
                Intent i = new Intent(getApplicationContext(),Toggle_Button.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(ca.lambton.c0661823.quizassignmentjatinderbhola.R.menu.menu_result_view, menu);
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
