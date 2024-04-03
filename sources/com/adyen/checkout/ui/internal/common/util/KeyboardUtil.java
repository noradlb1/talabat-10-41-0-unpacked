package com.adyen.checkout.ui.internal.common.util;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class KeyboardUtil {
    private static final int SHOW_KEYBOARD_DELAY = 100;

    private KeyboardUtil() {
        throw new IllegalStateException("No instances.");
    }

    public static void hide(@NonNull final View view) {
        final InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (!inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2)) {
            view.post(new Runnable() {
                public void run() {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
                }
            });
        }
    }

    public static boolean show(@NonNull View view) {
        return show(view, (Runnable) null);
    }

    public static void showAndSelect(@NonNull final EditText editText) {
        show(editText, new Runnable() {
            public void run() {
                EditText editText = editText;
                editText.setSelection(0, editText.getText().length());
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean show(@NonNull final View view, @Nullable final Runnable runnable) {
        view.requestFocus();
        boolean showSoftInput = ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
        if (!showSoftInput) {
            view.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = KeyboardUtil.show(view, runnable);
                }
            }, 100);
        } else if (runnable != null) {
            runnable.run();
        }
        return showSoftInput;
    }
}
