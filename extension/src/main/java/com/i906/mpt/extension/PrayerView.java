package com.i906.mpt.extension;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class PrayerView extends FrameLayout {

    protected static final int VERSION = 1;

    protected PrayerInterface mInterface;

    public PrayerView(Context context) {
        this(context, null);
    }

    public PrayerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PrayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public final int getExtensionVersion() {
        return VERSION;
    }

    public final PrayerInterface getInterface() {
        return mInterface;
    }

    public final void setInterface(PrayerInterface prayerInterface) {
        mInterface = prayerInterface;
        onInterfaceLoaded();
    }

    public void onInterfaceLoaded() { }

    public void onPrayerTimesChanged() {
        onPrayerTimesChanged(mInterface.getCurrentPrayerIndex());
    }

    public void onPrayerTimesChanged(@PrayerInterface.PrayerType int currentPrayerIndex) { }

    public void onHijriDateChanged(int[] dates) { }

    public void onMasihiDateChanged(int[] dates) { }

    public void onLocationChanged(String location) { }
}
