package com.i906.mpt.extension.countdownview.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.FrameLayout;

import com.i906.mpt.extension.countdownview.R;
import com.i906.mpt.extension.countdownview.view.CountdownView;
import com.i906.mpt.extension.countdownview.view.TestingPrayerInterface;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends ActionBarActivity {

    protected TestingPrayerInterface mInterface;

    @InjectView(R.id.frame)
    protected FrameLayout mFrameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mInterface = new TestingPrayerInterface();
        CountdownView plv = new CountdownView(this);
        plv.setInterface(mInterface);

        mFrameView.addView(plv);
    }
}
