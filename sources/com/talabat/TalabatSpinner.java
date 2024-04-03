package com.talabat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;

public class TalabatSpinner extends AppCompatSpinner {

    /* renamed from: d  reason: collision with root package name */
    public int f55084d = -1;
    private OnSpinnerEventsListener mListener;
    private boolean mOpenInitiated = false;

    public interface OnSpinnerEventsListener {
        void onSpinnerClosed();

        void onSpinnerOpened();
    }

    public TalabatSpinner(Context context) {
        super(context);
    }

    public boolean hasBeenOpened() {
        return this.mOpenInitiated;
    }

    public boolean performClick() {
        this.mOpenInitiated = true;
        OnSpinnerEventsListener onSpinnerEventsListener = this.mListener;
        if (onSpinnerEventsListener != null) {
            onSpinnerEventsListener.onSpinnerOpened();
        }
        return super.performClick();
    }

    public void performClosedEvent() {
        this.mOpenInitiated = false;
        OnSpinnerEventsListener onSpinnerEventsListener = this.mListener;
        if (onSpinnerEventsListener != null) {
            onSpinnerEventsListener.onSpinnerClosed();
        }
    }

    public void setSelection(int i11) {
        super.setSelection(i11);
        if (i11 == getSelectedItemPosition() && this.f55084d == i11) {
            getOnItemSelectedListener().onItemSelected((AdapterView) null, (View) null, i11, 0);
        }
        this.f55084d = i11;
    }

    public void setSpinnerEventsListener(OnSpinnerEventsListener onSpinnerEventsListener) {
        this.mListener = onSpinnerEventsListener;
    }

    public TalabatSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TalabatSpinner(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
