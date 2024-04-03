package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.homescreen.R;
import com.talabat.talabatcommon.views.ramadan.RamadanView;

public final class LayoutRamadanClockWidgetBinding implements ViewBinding {
    @NonNull
    public final RamadanView ramadanView;
    @NonNull
    private final View rootView;

    private LayoutRamadanClockWidgetBinding(@NonNull View view, @NonNull RamadanView ramadanView2) {
        this.rootView = view;
        this.ramadanView = ramadanView2;
    }

    @NonNull
    public static LayoutRamadanClockWidgetBinding bind(@NonNull View view) {
        int i11 = R.id.ramadanView;
        RamadanView ramadanView2 = (RamadanView) ViewBindings.findChildViewById(view, i11);
        if (ramadanView2 != null) {
            return new LayoutRamadanClockWidgetBinding(view, ramadanView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutRamadanClockWidgetBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.layout_ramadan_clock_widget, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
