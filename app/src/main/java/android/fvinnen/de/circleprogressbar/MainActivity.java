package android.fvinnen.de.circleprogressbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CircleProgressBar circleProgressBar = (CircleProgressBar) findViewById(R.id.circleProgress);
        circleProgressBar.setMax(10000);
        circleProgressBar.setProgress(100);
        CountDownTimer timer = new CountDownTimer(10000, 100) {


            @Override
            public void onTick(long millisUntilFinished) {
                circleProgressBar.setProgressWithAnimation(millisUntilFinished, 100);
                circleProgressBar.setText("" + (1 + Math.round(millisUntilFinished / 1000)));
            }

            @Override
            public void onFinish() {
                circleProgressBar.setProgressWithAnimation(0, 100);
                circleProgressBar.setText("0");
            }
        };

        timer.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
