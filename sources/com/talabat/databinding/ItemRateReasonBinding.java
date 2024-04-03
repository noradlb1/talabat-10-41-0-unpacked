package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemRateReasonBinding implements ViewBinding {
    @NonNull
    public final CheckBox reasonCheckbox;
    @NonNull
    public final TalabatTextView reasonText;
    @NonNull
    private final RelativeLayout rootView;

    private ItemRateReasonBinding(@NonNull RelativeLayout relativeLayout, @NonNull CheckBox checkBox, @NonNull TalabatTextView talabatTextView) {
        this.rootView = relativeLayout;
        this.reasonCheckbox = checkBox;
        this.reasonText = talabatTextView;
    }

    @NonNull
    public static ItemRateReasonBinding bind(@NonNull View view) {
        int i11 = R.id.reason_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.reason_checkbox);
        if (checkBox != null) {
            i11 = R.id.reason_text;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.reason_text);
            if (talabatTextView != null) {
                return new ItemRateReasonBinding((RelativeLayout) view, checkBox, talabatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemRateReasonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemRateReasonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_rate_reason, viewGroup, false);
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
