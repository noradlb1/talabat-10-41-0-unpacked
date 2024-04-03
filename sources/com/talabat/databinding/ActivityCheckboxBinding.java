package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_checkbox_v2.DSCheckbox;
import com.talabat.R;

public final class ActivityCheckboxBinding implements ViewBinding {
    @NonNull
    public final DSCheckbox checkbox1;
    @NonNull
    public final DSCheckbox checkbox2;
    @NonNull
    public final DSCheckbox checkbox3;
    @NonNull
    public final DSCheckbox checkbox4;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivityCheckboxBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSCheckbox dSCheckbox, @NonNull DSCheckbox dSCheckbox2, @NonNull DSCheckbox dSCheckbox3, @NonNull DSCheckbox dSCheckbox4) {
        this.rootView = constraintLayout;
        this.checkbox1 = dSCheckbox;
        this.checkbox2 = dSCheckbox2;
        this.checkbox3 = dSCheckbox3;
        this.checkbox4 = dSCheckbox4;
    }

    @NonNull
    public static ActivityCheckboxBinding bind(@NonNull View view) {
        int i11 = R.id.checkbox_1;
        DSCheckbox dSCheckbox = (DSCheckbox) ViewBindings.findChildViewById(view, R.id.checkbox_1);
        if (dSCheckbox != null) {
            i11 = R.id.checkbox_2;
            DSCheckbox dSCheckbox2 = (DSCheckbox) ViewBindings.findChildViewById(view, R.id.checkbox_2);
            if (dSCheckbox2 != null) {
                i11 = R.id.checkbox_3;
                DSCheckbox dSCheckbox3 = (DSCheckbox) ViewBindings.findChildViewById(view, R.id.checkbox_3);
                if (dSCheckbox3 != null) {
                    i11 = R.id.checkbox_4;
                    DSCheckbox dSCheckbox4 = (DSCheckbox) ViewBindings.findChildViewById(view, R.id.checkbox_4);
                    if (dSCheckbox4 != null) {
                        return new ActivityCheckboxBinding((ConstraintLayout) view, dSCheckbox, dSCheckbox2, dSCheckbox3, dSCheckbox4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityCheckboxBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityCheckboxBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_checkbox, viewGroup, false);
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
