package com.i906.mpt.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.FrameLayout;

import com.i906.mpt.extension.PrayerInterface;

import java.util.Date;

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
        PrayerListView plv = new PrayerListView(this);
        plv.setInterface(mInterface);

        mFrameView.addView(plv);
    }
}