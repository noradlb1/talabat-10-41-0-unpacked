package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class CountryCodeHeaderBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatTextView txtCountryCodeHeader;
    @NonNull
    public final RelativeLayout txtCountryCodeHeaderView;

    private CountryCodeHeaderBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.txtCountryCodeHeader = talabatTextView;
        this.txtCountryCodeHeaderView = relativeLayout2;
    }

    @NonNull
    public static CountryCodeHeaderBinding bind(@NonNull View view) {
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txtCountryCodeHeader);
        if (talabatTextView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new CountryCodeHeaderBinding(relativeLayout, talabatTextView, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.txtCountryCodeHeader)));
    }

    @NonNull
    public static CountryCodeHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CountryCodeHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.country_code_header, viewGroup, false);
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
