package com.i906.mpt.extension.countdown.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.i906.mpt.extension.countdown.R;
import com.i906.mpt.extension.countdown.view.CountdownView;
import com.i906.mpt.provider.TestingPrayerInterface;

public class DebugActivity extends AppCompatActivity {

    protected TestingPrayerInterface mInterface;
    protected FrameLayout mFrameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        mFrameView = (FrameLayout) findViewById(R.id.frame);
        mInterface = new TestingPrayerInterface();
        CountdownView plv = new CountdownView(this);
        plv.setInterface(mInterface);

        mFrameView.addView(plv);
    }
}
