package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class ActivityTlifeTermsAndConditionsBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final WebView tLifeTermsAndConditionsWebView;

    private ActivityTlifeTermsAndConditionsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull WebView webView) {
        this.rootView = constraintLayout;
        this.tLifeTermsAndConditionsWebView = webView;
    }

    @NonNull
    public static ActivityTlifeTermsAndConditionsBinding bind(@NonNull View view) {
        int i11 = R.id.tLife_terms_and_conditions_web_view;
        WebView webView = (WebView) ViewBindings.findChildViewById(view, i11);
        if (webView != null) {
            return new ActivityTlifeTermsAndConditionsBinding((ConstraintLayout) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityTlifeTermsAndConditionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityTlifeTermsAndConditionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_tlife_terms_and_conditions, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
