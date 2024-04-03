package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button.DSPrimaryButton;
import com.talabat.feature.pickup.presentation.R;

public final class ConnectionErrorLayoutBinding implements ViewBinding {
    @NonNull
    public final TextView noNetworkDescriptionTxt;
    @NonNull
    public final TextView noNetworkHeaderTxt;
    @NonNull
    public final ImageView noNetwrkImg;
    @NonNull
    public final DSPrimaryButton retry;
    @NonNull
    private final LinearLayout rootView;

    private ConnectionErrorLayoutBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull DSPrimaryButton dSPrimaryButton) {
        this.rootView = linearLayout;
        this.noNetworkDescriptionTxt = textView;
        this.noNetworkHeaderTxt = textView2;
        this.noNetwrkImg = imageView;
        this.retry = dSPrimaryButton;
    }

    @NonNull
    public static ConnectionErrorLayoutBinding bind(@NonNull View view) {
        int i11 = R.id.no_network_description_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.no_network_header_txt;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.no_netwrk_img;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    i11 = R.id.retry;
                    DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
                    if (dSPrimaryButton != null) {
                        return new ConnectionErrorLayoutBinding((LinearLayout) view, textView, textView2, imageView, dSPrimaryButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ConnectionErrorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ConnectionErrorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.connection_error_layout, viewGroup, false);
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
