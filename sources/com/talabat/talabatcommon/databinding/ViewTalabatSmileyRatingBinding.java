package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewTalabatSmileyRatingBinding implements ViewBinding {
    @NonNull
    public final RadioButton radio1;
    @NonNull
    public final RadioButton radio2;
    @NonNull
    public final RadioButton radio3;
    @NonNull
    public final RadioButton radio4;
    @NonNull
    public final RadioButton radio5;
    @NonNull
    public final RadioGroup ratingRadioGroup;
    @NonNull
    private final View rootView;

    private ViewTalabatSmileyRatingBinding(@NonNull View view, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull RadioButton radioButton5, @NonNull RadioGroup radioGroup) {
        this.rootView = view;
        this.radio1 = radioButton;
        this.radio2 = radioButton2;
        this.radio3 = radioButton3;
        this.radio4 = radioButton4;
        this.radio5 = radioButton5;
        this.ratingRadioGroup = radioGroup;
    }

    @NonNull
    public static ViewTalabatSmileyRatingBinding bind(@NonNull View view) {
        int i11 = R.id.radio_1;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i11);
        if (radioButton != null) {
            i11 = R.id.radio_2;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i11);
            if (radioButton2 != null) {
                i11 = R.id.radio_3;
                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i11);
                if (radioButton3 != null) {
                    i11 = R.id.radio_4;
                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, i11);
                    if (radioButton4 != null) {
                        i11 = R.id.radio_5;
                        RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, i11);
                        if (radioButton5 != null) {
                            i11 = R.id.rating_radio_group;
                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i11);
                            if (radioGroup != null) {
                                return new ViewTalabatSmileyRatingBinding(view, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioGroup);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewTalabatSmileyRatingBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_talabat_smiley_rating, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
