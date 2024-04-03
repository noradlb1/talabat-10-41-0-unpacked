package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class FragOnBoardingBinding implements ViewBinding {
    @NonNull
    public final ImageButton backButton;
    @NonNull
    public final ImageView offersLifeIconImageView;
    @NonNull
    public final TextView onBoardingNextBillingSubText;
    @NonNull
    public final TextView onBoardingTLifeWaitListSubTitleTextView;
    @NonNull
    public final TextView onBoardingTLifeWaitListTAndC;
    @NonNull
    public final LinearLayout onBoardingTLifeWaitListTextLinearLayout;
    @NonNull
    public final TextView onBoardingTLifeWaitListTitleTextView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final Toolbar toolbar;

    private FragOnBoardingBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageButton imageButton, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull Toolbar toolbar2) {
        this.rootView = relativeLayout;
        this.backButton = imageButton;
        this.offersLifeIconImageView = imageView;
        this.onBoardingNextBillingSubText = textView;
        this.onBoardingTLifeWaitListSubTitleTextView = textView2;
        this.onBoardingTLifeWaitListTAndC = textView3;
        this.onBoardingTLifeWaitListTextLinearLayout = linearLayout;
        this.onBoardingTLifeWaitListTitleTextView = textView4;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static FragOnBoardingBinding bind(@NonNull View view) {
        int i11 = R.id.backButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i11);
        if (imageButton != null) {
            i11 = R.id.offersLifeIconImageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.onBoardingNextBillingSubText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.onBoardingTLifeWaitListSubTitleTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        i11 = R.id.onBoardingTLifeWaitListTAndC;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            i11 = R.id.onBoardingTLifeWaitListTextLinearLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                            if (linearLayout != null) {
                                i11 = R.id.onBoardingTLifeWaitListTitleTextView;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView4 != null) {
                                    i11 = R.id.toolbar;
                                    Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i11);
                                    if (toolbar2 != null) {
                                        return new FragOnBoardingBinding((RelativeLayout) view, imageButton, imageView, textView, textView2, textView3, linearLayout, textView4, toolbar2);
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
    public static FragOnBoardingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragOnBoardingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_on_boarding, viewGroup, false);
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
