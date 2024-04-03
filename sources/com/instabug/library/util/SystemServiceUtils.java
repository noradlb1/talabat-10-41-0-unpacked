package com.instabug.library.util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class SystemServiceUtils {
    private SystemServiceUtils() {
    }

    public static void hideInputMethod(Activity activity) {
        InputMethodManager inputMethodManager;
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}
