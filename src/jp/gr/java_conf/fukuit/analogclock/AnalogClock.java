package jp.gr.java_conf.fukuit.analogclock;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class AnalogClock extends Activity {
	private Handler handler = new Handler();
	private Runnable runnable;
	private static long CLOCK_INTERVAL=1000;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
        final AnalogClockView view = new AnalogClockView(getApplication());
        setContentView(view);
        
        runnable = new Runnable(){
        @Override
        public void run(){
        	view.invalidate();
        	handler.postDelayed(this, CLOCK_INTERVAL);
        }
        };

    	handler.postDelayed(runnable, CLOCK_INTERVAL);

    }
}