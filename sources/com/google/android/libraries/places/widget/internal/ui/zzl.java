package com.google.android.libraries.places.widget.internal.ui;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import com.google.android.libraries.places.internal.zzdh;

final class zzl implements View.OnFocusChangeListener {
    private zzl() {
    }

    public /* synthetic */ zzl(zzk zzk) {
    }

    public final void onFocusChange(View view, boolean z11) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(view.getContext(), InputMethodManager.class);
            if (inputMethodManager != null) {
                if (z11) {
                    inputMethodManager.showSoftInput(view, 1);
                } else {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }
}
