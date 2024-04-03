package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class LanguageSelectorPopupBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView faqDetailsTitle;
    @NonNull
    public final RecyclerView languageRecyclerView;
    @NonNull
    private final RelativeLayout rootView;

    private LanguageSelectorPopupBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.faqDetailsTitle = talabatTextView;
        this.languageRecyclerView = recyclerView;
    }

    @NonNull
    public static LanguageSelectorPopupBinding bind(@NonNull View view) {
        int i11 = R.id.faq_details_title;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.faq_details_title);
        if (talabatTextView != null) {
            i11 = R.id.language_recyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.language_recyclerView);
            if (recyclerView != null) {
                return new LanguageSelectorPopupBinding((RelativeLayout) view, talabatTextView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LanguageSelectorPopupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LanguageSelectorPopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.language_selector_popup, viewGroup, false);
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
