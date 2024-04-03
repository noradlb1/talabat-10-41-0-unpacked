package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class InfomapPopupBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView addressUpdateText;
    @NonNull
    public final LinearLayout buttonsView;
    @NonNull
    public final ImageView closePopupButton;
    @NonNull
    public final LinearLayout continueView;
    @NonNull
    public final LinearLayout newAddressView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatTextView talabatTextView10;
    @NonNull
    public final LinearLayout textSection;

    private InfomapPopupBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout5) {
        this.rootView = linearLayout;
        this.addressUpdateText = talabatTextView;
        this.buttonsView = linearLayout2;
        this.closePopupButton = imageView;
        this.continueView = linearLayout3;
        this.newAddressView = linearLayout4;
        this.talabatTextView10 = talabatTextView2;
        this.textSection = linearLayout5;
    }

    @NonNull
    public static InfomapPopupBinding bind(@NonNull View view) {
        int i11 = R.id.address_update_text;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.address_update_text);
        if (talabatTextView != null) {
            i11 = R.id.buttons_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.buttons_view);
            if (linearLayout != null) {
                i11 = R.id.close_popup_button;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close_popup_button);
                if (imageView != null) {
                    i11 = R.id.continue_view;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.continue_view);
                    if (linearLayout2 != null) {
                        i11 = R.id.new_address_view;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.new_address_view);
                        if (linearLayout3 != null) {
                            i11 = R.id.talabatTextView10;
                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.talabatTextView10);
                            if (talabatTextView2 != null) {
                                i11 = R.id.text_section;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.text_section);
                                if (linearLayout4 != null) {
                                    return new InfomapPopupBinding((LinearLayout) view, talabatTextView, linearLayout, imageView, linearLayout2, linearLayout3, talabatTextView2, linearLayout4);
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
    public static InfomapPopupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static InfomapPopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.infomap_popup, viewGroup, false);
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
