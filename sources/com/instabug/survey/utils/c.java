package com.instabug.survey.utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public abstract class c {
    public static void a(Activity activity) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static void a(Activity activity, EditText editText) {
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(editText, 1);
    }
}
