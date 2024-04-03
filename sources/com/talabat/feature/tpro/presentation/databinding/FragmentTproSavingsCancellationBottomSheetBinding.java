package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class FragmentTproSavingsCancellationBottomSheetBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonText;
    @NonNull
    public final TextView actionCoffeeText;
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final LinearLayout confirmCancelProLayout;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final View ivBackground;
    @NonNull
    public final ImageView ivCancellationImage;
    @NonNull
    public final LinearLayout keepProLayout;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvCancellationHeader;
    @NonNull
    public final TextView tvCancellationText;

    private FragmentTproSavingsCancellationBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull View view, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.actionButtonText = textView;
        this.actionCoffeeText = textView2;
        this.cancelButton = imageView;
        this.confirmCancelProLayout = linearLayout;
        this.container = constraintLayout2;
        this.ivBackground = view;
        this.ivCancellationImage = imageView2;
        this.keepProLayout = linearLayout2;
        this.tvCancellationHeader = textView3;
        this.tvCancellationText = textView4;
    }

    @NonNull
    public static FragmentTproSavingsCancellationBottomSheetBinding bind(@NonNull View view) {
        int i11 = R.id.action_button_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.action_coffee_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.cancel_button;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    i11 = R.id.confirm_cancel_pro_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                    if (linearLayout != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i11 = R.id.iv_background;
                        View findChildViewById = ViewBindings.findChildViewById(view, i11);
                        if (findChildViewById != null) {
                            i11 = R.id.iv_cancellation_image;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                            if (imageView2 != null) {
                                i11 = R.id.keep_pro_layout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                if (linearLayout2 != null) {
                                    i11 = R.id.tv_cancellation_header;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView3 != null) {
                                        i11 = R.id.tv_cancellation_text;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView4 != null) {
                                            return new FragmentTproSavingsCancellationBottomSheetBinding(constraintLayout, textView, textView2, imageView, linearLayout, constraintLayout, findChildViewById, imageView2, linearLayout2, textView3, textView4);
                                        }
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
    public static FragmentTproSavingsCancellationBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproSavingsCancellationBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_savings_cancellation_bottom_sheet, viewGroup, false);
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
