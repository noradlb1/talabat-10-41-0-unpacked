package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatSpinner;
import com.talabat.TalabatTextView;

public final class MobileNoFldBinding implements ViewBinding {
    @Nullable
    public final TalabatTextView arabicErrorTxt;
    @NonNull
    public final ImageView arrowImg;
    @NonNull
    public final RelativeLayout countryCodeLayout;
    @NonNull
    public final MaterialEditText countryCodeMobile;
    @NonNull
    public final TalabatSpinner countryCodeSpinner;
    @NonNull
    public final MaterialEditText hiddenMobileField;
    @NonNull
    public final MaterialEditText mobileEditText;
    @NonNull
    public final LinearLayout mobileNoFld;
    @NonNull
    private final RelativeLayout rootView;

    private MobileNoFldBinding(@NonNull RelativeLayout relativeLayout, @Nullable TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull MaterialEditText materialEditText, @NonNull TalabatSpinner talabatSpinner, @NonNull MaterialEditText materialEditText2, @NonNull MaterialEditText materialEditText3, @NonNull LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.arabicErrorTxt = talabatTextView;
        this.arrowImg = imageView;
        this.countryCodeLayout = relativeLayout2;
        this.countryCodeMobile = materialEditText;
        this.countryCodeSpinner = talabatSpinner;
        this.hiddenMobileField = materialEditText2;
        this.mobileEditText = materialEditText3;
        this.mobileNoFld = linearLayout;
    }

    @NonNull
    public static MobileNoFldBinding bind(@NonNull View view) {
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.arabic_error_txt);
        int i11 = R.id.arrow_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.arrow_img);
        if (imageView != null) {
            i11 = R.id.countryCodeLayout;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.countryCodeLayout);
            if (relativeLayout != null) {
                i11 = R.id.country_code_mobile;
                MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.country_code_mobile);
                if (materialEditText != null) {
                    i11 = R.id.country_code_spinner;
                    TalabatSpinner talabatSpinner = (TalabatSpinner) ViewBindings.findChildViewById(view, R.id.country_code_spinner);
                    if (talabatSpinner != null) {
                        i11 = R.id.hidden_mobile_field;
                        MaterialEditText materialEditText2 = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.hidden_mobile_field);
                        if (materialEditText2 != null) {
                            i11 = R.id.mobileEditText;
                            MaterialEditText materialEditText3 = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.mobileEditText);
                            if (materialEditText3 != null) {
                                i11 = R.id.mobile_no_fld;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.mobile_no_fld);
                                if (linearLayout != null) {
                                    return new MobileNoFldBinding((RelativeLayout) view, talabatTextView, imageView, relativeLayout, materialEditText, talabatSpinner, materialEditText2, materialEditText3, linearLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MobileNoFldBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MobileNoFldBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mobile_no_fld, viewGroup, false);
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
