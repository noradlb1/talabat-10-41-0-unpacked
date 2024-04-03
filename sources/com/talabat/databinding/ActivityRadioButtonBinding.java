package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_radiobutton.DSRadioButton;
import com.talabat.R;

public final class ActivityRadioButtonBinding implements ViewBinding {
    @NonNull
    public final DSRadioButton radioButton1;
    @NonNull
    public final DSRadioButton radioButton2;
    @NonNull
    public final DSRadioButton radioButton3;
    @NonNull
    public final DSRadioButton radioButton4;
    @NonNull
    public final RadioGroup radioGroup;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivityRadioButtonBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSRadioButton dSRadioButton, @NonNull DSRadioButton dSRadioButton2, @NonNull DSRadioButton dSRadioButton3, @NonNull DSRadioButton dSRadioButton4, @NonNull RadioGroup radioGroup2) {
        this.rootView = constraintLayout;
        this.radioButton1 = dSRadioButton;
        this.radioButton2 = dSRadioButton2;
        this.radioButton3 = dSRadioButton3;
        this.radioButton4 = dSRadioButton4;
        this.radioGroup = radioGroup2;
    }

    @NonNull
    public static ActivityRadioButtonBinding bind(@NonNull View view) {
        int i11 = R.id.radio_button_1;
        DSRadioButton dSRadioButton = (DSRadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_1);
        if (dSRadioButton != null) {
            i11 = R.id.radio_button_2;
            DSRadioButton dSRadioButton2 = (DSRadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_2);
            if (dSRadioButton2 != null) {
                i11 = R.id.radio_button_3;
                DSRadioButton dSRadioButton3 = (DSRadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_3);
                if (dSRadioButton3 != null) {
                    i11 = R.id.radio_button_4;
                    DSRadioButton dSRadioButton4 = (DSRadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_4);
                    if (dSRadioButton4 != null) {
                        i11 = R.id.radio_group;
                        RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(view, R.id.radio_group);
                        if (radioGroup2 != null) {
                            return new ActivityRadioButtonBinding((ConstraintLayout) view, dSRadioButton, dSRadioButton2, dSRadioButton3, dSRadioButton4, radioGroup2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_radio_button, viewGroup, false);
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
