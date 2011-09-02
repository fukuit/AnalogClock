/**
 * 
 */
package jp.gr.java_conf.fukuit.analogclock;

import java.util.Calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class AnalogClockView extends View {
	private int centerX = 0;
	private int centerY = 0;
	private int handLength = 0;

	private HandPoint sec;
	private HandPoint min;
	private HandPoint hour;
	
	public AnalogClockView(Context context) {
		super(context);
		sec = new HandPoint(centerX, centerY);
		min = new HandPoint(centerX, centerY);
		hour = new HandPoint(centerX, centerY);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		getTodayNow();
		
		Paint paint = new Paint();
		paint.setAntiAlias(true);
	
		paint.setColor(Color.WHITE);
		canvas.drawLine(centerX, centerY, sec.X(), sec.Y(), paint);
		paint.setColor(Color.BLUE);
		canvas.drawLine(centerX, centerY, min.X(), min.Y(), paint);
		paint.setColor(Color.RED);
		canvas.drawLine(centerX, centerY, hour.X(), hour.Y(), paint);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		centerX = w / 2;
		centerY = h / 2;
		handLength = Math.min(centerX, centerY);
	}

	private void getTodayNow(){
		Calendar cal = Calendar.getInstance();
		double ss = (double)cal.getTime().getSeconds();
		double mm = (double)cal.getTime().getMinutes();
		double hh = (double)cal.getTime().getHours();
		
		double secAng = 2.0 * Math.PI * ss / 60.0;
		double minAng = 2.0 * Math.PI * (mm + ss/60.0)/60.0;
		double hourAng = 2.0 * Math.PI * (hh+mm/60.0)/12.0;
		
		sec.setPoint((int)(centerX+Math.sin(secAng)*handLength*0.7), (int)(centerY-Math.cos(secAng)*handLength*0.7));
		min.setPoint((int)(centerX+Math.sin(minAng)*handLength*0.9), (int)(centerY-Math.cos(minAng)*handLength*0.9));
		hour.setPoint((int)(centerX+Math.sin(hourAng)*handLength*0.5), (int)(centerY-Math.cos(hourAng)*handLength*0.5));
	}
}
