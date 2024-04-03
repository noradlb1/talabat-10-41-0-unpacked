package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.talabat.darkstores.R;

public final class DarkstoresErrorBinding implements ViewBinding {
    @NonNull
    public final Guideline endGuideline;
    @NonNull
    public final TextView errorTitle;
    @NonNull
    public final TextView message;
    @NonNull
    public final MaterialButton reloadButton;
    @NonNull
    private final View rootView;
    @NonNull
    public final Guideline startGuideline;

    private DarkstoresErrorBinding(@NonNull View view, @NonNull Guideline guideline, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull Guideline guideline2) {
        this.rootView = view;
        this.endGuideline = guideline;
        this.errorTitle = textView;
        this.message = textView2;
        this.reloadButton = materialButton;
        this.startGuideline = guideline2;
    }

    @NonNull
    public static DarkstoresErrorBinding bind(@NonNull View view) {
        int i11 = R.id.endGuideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
        if (guideline != null) {
            i11 = R.id.errorTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.message;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.reloadButton;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i11);
                    if (materialButton != null) {
                        i11 = R.id.startGuideline;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i11);
                        if (guideline2 != null) {
                            return new DarkstoresErrorBinding(view, guideline, textView, textView2, materialButton, guideline2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresErrorBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_error, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
