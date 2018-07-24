package customview.learn.com.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    HSeeakBar hSeeakBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hSeeakBar = findViewById(R.id.hseekbar);
        hSeeakBar.setTrungduc(0.5f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        hSeeakBar.setTrungduc(0.3f);
        Log.d("kiemtra", "runed");
        return super.onTouchEvent(event);
    }
}
