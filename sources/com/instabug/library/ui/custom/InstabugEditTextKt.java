package com.instabug.library.ui.custom;

import android.content.Context;
import android.view.LayoutInflater;

public final class InstabugEditTextKt {
    /* access modifiers changed from: private */
    public static final LayoutInflater getLayoutInflater(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            return (LayoutInflater) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
