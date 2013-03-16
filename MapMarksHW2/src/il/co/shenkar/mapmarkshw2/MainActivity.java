package il.co.shenkar.mapmarkshw2;

import java.util.ArrayList;

import il.co.shenkar.mapmarkshw2.entities.Marker;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private int currentMarkId = -1;
	private ImageView mapView;
	private EditText markDesc;
	private Button setBtn, delBtn;
	private ArrayList<Marker> markers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		markers = new ArrayList<Marker>();
		setViews();

		mapView.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(final View v, final MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					if (event.getEventTime() > 800) {
						Marker m = new Marker(convertPixelsToDp(event.getX(), getApplicationContext()), convertPixelsToDp(event.getY(),
								getApplicationContext()));
						markers.add(m);
						currentMarkId = m.getMarkerId();
						createMark(event.getX(), event.getY());
					}
				}
				return true;
			}

		});

	}

	public static float convertPixelsToDp(float px, Context context) {
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float dp = px / (metrics.densityDpi / 160f);
		return dp;

	}

	private void setViews() {
		mapView = (ImageView) findViewById(R.id.mapImg);
		markDesc = (EditText) findViewById(R.id.markerDes);
		setBtn = (Button) findViewById(R.id.setMark);
		delBtn = (Button) findViewById(R.id.delMark);
		markDesc.setEnabled(false);
		setBtn.setEnabled(false);
		delBtn.setEnabled(false);

	}

	@SuppressLint("NewApi")
	private void createMark(float x, float y) {
		LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
		RelativeLayout LayoutId = (RelativeLayout) findViewById(R.id.mapLayout);
		ImageView imv = (ImageView) inflater.inflate(R.layout.mark, null);
		imv.setX(x-35);
		imv.setY(y-35);
		imv.bringToFront();
		LayoutId.addView(imv);
		markDesc.setEnabled(true);
		setBtn.setEnabled(true);
		delBtn.setEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
