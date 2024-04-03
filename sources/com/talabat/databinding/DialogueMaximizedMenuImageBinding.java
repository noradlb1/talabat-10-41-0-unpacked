package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class DialogueMaximizedMenuImageBinding implements ViewBinding {
    @NonNull
    public final FrameLayout flImage;
    @NonNull
    public final ImageView ivBackground;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    public final ImageView ivItemImage;
    @NonNull
    public final LinearLayout llContainer;
    @NonNull
    public final LinearLayout llTouchable;
    @NonNull
    public final ProgressBar progress;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final TalabatTextView tvItemName;

    private DialogueMaximizedMenuImageBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar, @NonNull TalabatTextView talabatTextView) {
        this.rootView = frameLayout;
        this.flImage = frameLayout2;
        this.ivBackground = imageView;
        this.ivClose = imageView2;
        this.ivItemImage = imageView3;
        this.llContainer = linearLayout;
        this.llTouchable = linearLayout2;
        this.progress = progressBar;
        this.tvItemName = talabatTextView;
    }

    @NonNull
    public static DialogueMaximizedMenuImageBinding bind(@NonNull View view) {
        int i11 = R.id.fl_image;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.fl_image);
        if (frameLayout != null) {
            i11 = R.id.iv_background;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_background);
            if (imageView != null) {
                i11 = R.id.iv_close;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close);
                if (imageView2 != null) {
                    i11 = R.id.iv_item_image;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_item_image);
                    if (imageView3 != null) {
                        i11 = R.id.ll_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_container);
                        if (linearLayout != null) {
                            i11 = R.id.ll_touchable;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_touchable);
                            if (linearLayout2 != null) {
                                i11 = R.id.progress;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress);
                                if (progressBar != null) {
                                    i11 = R.id.tv_item_name;
                                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_item_name);
                                    if (talabatTextView != null) {
                                        return new DialogueMaximizedMenuImageBinding((FrameLayout) view, frameLayout, imageView, imageView2, imageView3, linearLayout, linearLayout2, progressBar, talabatTextView);
                                    }
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
    public static DialogueMaximizedMenuImageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogueMaximizedMenuImageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.dialogue_maximized_menu_image, viewGroup, false);
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
