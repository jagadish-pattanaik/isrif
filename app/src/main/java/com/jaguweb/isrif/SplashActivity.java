package com.jaguweb.isrif;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.content.Intent;
import android.net.Uri;

public class SplashActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private ImageView imageview1;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	
	private TimerTask t;
	private ObjectAnimator anime = new ObjectAnimator();
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.splash);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
	}
	private void initializeLogic() {
		SketchwareUtil.showMessage(getApplicationContext(), "Welcome To ISRIF");
		imageview1.setElevation(20f);
		anime.setTarget(linear1);
		anime.setPropertyName("alpha");
		anime.setFloatValues((float)(0), (float)(1));
		anime.setDuration((int)(1000));
		anime.start();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						anime.setTarget(linear1);
						anime.setPropertyName("alpha");
						anime.setFloatValues((float)(1), (float)(0));
						anime.setDuration((int)(1000));
						anime.start();
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										SketchwareUtil.showMessage(getApplicationContext(), "Indian Scientific Research and Innovation Forum");
										finish();
									}
								});
							}
						};
						_timer.schedule(t, (int)(1000));
					}
				});
			}
		};
		_timer.schedule(t, (int)(3000));
		Bitmap bm5 = ((android.graphics.drawable.BitmapDrawable)
		imageview1.getDrawable()).getBitmap();
		imageview1.setImageBitmap(getRoundedCornerBitmap(bm5,360));
	}
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) { Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888); Canvas canvas = new Canvas(output); final int color = 0xff424242; final Paint paint = new Paint(); final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()); final RectF rectF = new RectF(rect); final float roundPx = pixels; paint.setAntiAlias(true); canvas.drawARGB(0, 0, 0, 0); paint.setColor(color); canvas.drawRoundRect(rectF, roundPx, roundPx, paint); paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN)); canvas.drawBitmap(bitmap, rect, rect, paint); return output;
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
