package com.i906.mpt.extension;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * A view that need to be subclassed by the extensions. The subclassed view will be then displayed
 * in Malaysia Prayer Times' main view if selected by the user.
 */
public abstract class PrayerView extends FrameLayout implements PrayerInterface.PrayerListener {

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

    /**
     * Used by the host to determine the PrayerView's version.
     */
    public final int getExtensionVersion() {
        return VERSION;
    }

    /**
     * Retrieves the interface to access relevant data from the host.
     *
     * @return The prayer interface
     * @see #setInterface(PrayerInterface)
     */
    public final PrayerInterface getInterface() {
        return mInterface;
    }

    /**
     * Used by the host to provide data to the PrayerView.
     *
     * @see #getInterface()
     */
    public final void setInterface(PrayerInterface prayerInterface) {
        mInterface = prayerInterface;
        onInterfaceLoaded();
        setupListeners();
    }

    protected void setupListeners() {
        mInterface.addPrayerListener(this);
    }

    /**
     * Called when the prayer interface is attached to this PrayerView.
     *
     * <p>Subclasses of PrayerView may want to bind views with the data accessed through the prayer
     * interface as it gets loaded.</p>
     *
     * @see #getInterface()
     */
    public void onInterfaceLoaded() { }

    /**
     * Called when the prayer time has changed.
     */
    @Override
    public void onPrayerTimesChanged() { }

    /**
     * Called when the location has changed.
     */
    @Override
    public void onLocationChanged() { }

    /**
     * Called when an error occured while trying to get prayer times.
     */
    @Override
    public void onError(@PrayerInterface.ErrorType int type, String code) { }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mInterface.removePrayerListener(this);
    }
}
