package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class LanguageSelectorItemBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout languageRow;
    @NonNull
    public final ImageView languageSelector;
    @NonNull
    public final TalabatTextView languageText;
    @NonNull
    private final RelativeLayout rootView;

    private LanguageSelectorItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView) {
        this.rootView = relativeLayout;
        this.languageRow = relativeLayout2;
        this.languageSelector = imageView;
        this.languageText = talabatTextView;
    }

    @NonNull
    public static LanguageSelectorItemBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i11 = R.id.language_selector;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.language_selector);
        if (imageView != null) {
            i11 = R.id.language_text;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.language_text);
            if (talabatTextView != null) {
                return new LanguageSelectorItemBinding(relativeLayout, relativeLayout, imageView, talabatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LanguageSelectorItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LanguageSelectorItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.language_selector_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
