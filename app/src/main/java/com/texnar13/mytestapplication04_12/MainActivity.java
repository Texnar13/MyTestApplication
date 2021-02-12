package com.texnar13.mytestapplication04_12;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MyTestApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.big_rect).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:// 0
                        Log.e(TAG, "x=" + event.getX() + " y=" + event.getY());
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:// 1-9
                        Log.e(TAG, "x=" + event.getX() + " y=" + event.getY());
                        break;

                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "-");
                        break;

                    case MotionEvent.ACTION_POINTER_UP:
                        Log.e(TAG, "x=" + event.getX() + " y=" + event.getY());
                        event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "x=" + event.getX() + " y=" + event.getY());
                        break;


                }

                int pointerCount = 3;
                // {0:{PointerId, x, y} , , , , };

                for (int i = 0; i < 10; i++) {
                    Log.i(TAG, "Index = " + i);
                    if (i < pointerCount) {
                        Log.i(TAG, ", ID = " + event.getPointerId(i));
                        Log.i(TAG, ", X = " + event.getX(i));
                        Log.i(TAG, ", Y = " + event.getY(i));
                    } else {
                        Log.i(TAG, ", ID = ");
                        Log.i(TAG, ", X = ");
                        Log.i(TAG, ", Y = ");
                    }
                    Log.i(TAG, "\n-");
                    Log.i(TAG, "\n-");
                }

                return true;
            }
        });


    }


    public int pxFromDp(float dp) {
        return (int) (dp * this.getResources().getDisplayMetrics().density);
    }
}