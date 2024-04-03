package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class SpecialOffersDialogFragmentBinding implements ViewBinding {
    @NonNull
    public final ImageView ivBackground;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    public final LinearLayout llContainer;
    @NonNull
    public final LinearLayout llTouchable;
    @NonNull
    public final RecyclerView rcvOffers;
    @NonNull
    private final FrameLayout rootView;

    private SpecialOffersDialogFragmentBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.ivBackground = imageView;
        this.ivClose = imageView2;
        this.llContainer = linearLayout;
        this.llTouchable = linearLayout2;
        this.rcvOffers = recyclerView;
    }

    @NonNull
    public static SpecialOffersDialogFragmentBinding bind(@NonNull View view) {
        int i11 = R.id.iv_background;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_background);
        if (imageView != null) {
            i11 = R.id.iv_close;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close);
            if (imageView2 != null) {
                i11 = R.id.ll_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_container);
                if (linearLayout != null) {
                    i11 = R.id.ll_touchable;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_touchable);
                    if (linearLayout2 != null) {
                        i11 = R.id.rcv_offers;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rcv_offers);
                        if (recyclerView != null) {
                            return new SpecialOffersDialogFragmentBinding((FrameLayout) view, imageView, imageView2, linearLayout, linearLayout2, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SpecialOffersDialogFragmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SpecialOffersDialogFragmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.special_offers_dialog_fragment, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
