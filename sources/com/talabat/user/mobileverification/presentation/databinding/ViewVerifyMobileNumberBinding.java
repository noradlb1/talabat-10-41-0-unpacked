package com.talabat.user.mobileverification.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button.DSPrimaryButton;
import com.talabat.user.mobileverification.presentation.R;

public final class ViewVerifyMobileNumberBinding implements ViewBinding {
    @NonNull
    public final TextView body;
    @NonNull
    public final TextView heading;
    @NonNull
    public final ImageView image;
    @NonNull
    public final DSPrimaryButton placeAnOrderButtonLoggedIn;
    @NonNull
    private final View rootView;

    private ViewVerifyMobileNumberBinding(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull DSPrimaryButton dSPrimaryButton) {
        this.rootView = view;
        this.body = textView;
        this.heading = textView2;
        this.image = imageView;
        this.placeAnOrderButtonLoggedIn = dSPrimaryButton;
    }

    @NonNull
    public static ViewVerifyMobileNumberBinding bind(@NonNull View view) {
        int i11 = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.heading;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    i11 = R.id.placeAnOrderButton_loggedIn;
                    DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
                    if (dSPrimaryButton != null) {
                        return new ViewVerifyMobileNumberBinding(view, textView, textView2, imageView, dSPrimaryButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewVerifyMobileNumberBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_verify_mobile_number, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
