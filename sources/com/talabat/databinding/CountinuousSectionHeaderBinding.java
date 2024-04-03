package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class CountinuousSectionHeaderBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout sectionHeaderView;
    @NonNull
    public final TalabatTextView sectionName;

    private CountinuousSectionHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView) {
        this.rootView = linearLayout;
        this.sectionHeaderView = linearLayout2;
        this.sectionName = talabatTextView;
    }

    @NonNull
    public static CountinuousSectionHeaderBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.section_name);
        if (talabatTextView != null) {
            return new CountinuousSectionHeaderBinding(linearLayout, linearLayout, talabatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.section_name)));
    }

    @NonNull
    public static CountinuousSectionHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CountinuousSectionHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.countinuous_section_header, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
