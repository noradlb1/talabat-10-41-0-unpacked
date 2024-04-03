package com.instabug.library.util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeyboardUtils {
    public static void hide(Activity activity) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static void showKeyboard(Activity activity, EditText editText) {
        if (activity != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(editText, 1);
        }
    }
}
