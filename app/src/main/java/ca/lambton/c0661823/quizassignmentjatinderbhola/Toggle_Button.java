package ca.lambton.c0661823.quizassignmentjatinderbhola;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;


public class Toggle_Button extends Activity {

    ToggleButton toggleButton;
    Button saveSetting;
    static boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ca.lambton.c0661823.quizassignmentjatinderbhola.R.layout.activity_toggle_button);

        toggleButton = (ToggleButton) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.toggleButton);
        saveSetting = (Button) findViewById(ca.lambton.c0661823.quizassignmentjatinderbhola.R.id.saveSetting);

        saveSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = toggleButton.isChecked();
                Intent i = new Intent(getBaseContext(),QuestionsView.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(ca.lambton.c0661823.quizassignmentjatinderbhola.R.menu.menu_toggle__button, menu);
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
