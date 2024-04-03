package com.talabat.designhelpers.PinEntryEditText;

import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

class DefaultMovementMethod implements MovementMethod {
    private static DefaultMovementMethod sInstance;

    private DefaultMovementMethod() {
    }

    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new DefaultMovementMethod();
        }
        return sInstance;
    }

    public boolean canSelectArbitrarily() {
        return false;
    }

    public void initialize(TextView textView, Spannable spannable) {
        Selection.setSelection(spannable, 0);
    }

    public boolean onGenericMotionEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public boolean onKeyDown(TextView textView, Spannable spannable, int i11, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(TextView textView, Spannable spannable, int i11, KeyEvent keyEvent) {
        return false;
    }

    public void onTakeFocus(TextView textView, Spannable spannable, int i11) {
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public boolean onTrackballEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }
}
