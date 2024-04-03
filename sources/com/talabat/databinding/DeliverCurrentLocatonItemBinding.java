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

public final class DeliverCurrentLocatonItemBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView addressTitle;
    @NonNull
    public final LinearLayout deliverHereContainer;
    @NonNull
    public final ImageView imageView12;
    @NonNull
    private final LinearLayout rootView;

    private DeliverCurrentLocatonItemBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView) {
        this.rootView = linearLayout;
        this.addressTitle = talabatTextView;
        this.deliverHereContainer = linearLayout2;
        this.imageView12 = imageView;
    }

    @NonNull
    public static DeliverCurrentLocatonItemBinding bind(@NonNull View view) {
        int i11 = R.id.address_title;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.address_title);
        if (talabatTextView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView12);
            if (imageView != null) {
                return new DeliverCurrentLocatonItemBinding(linearLayout, talabatTextView, linearLayout, imageView);
            }
            i11 = R.id.imageView12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DeliverCurrentLocatonItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DeliverCurrentLocatonItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.deliver_current_locaton_item, viewGroup, false);
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
