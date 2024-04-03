package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.feature.tpro.presentation.R;

public final class FragmentTproCancellationReasonBottomSheetBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonText;
    @NonNull
    public final LinearLayout btnReasonSubmit;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final MaterialEditText etCancellationReasonOther;
    @NonNull
    public final ImageView ivCancellationImage;
    @NonNull
    public final ProgressBar pbReasons;
    @NonNull
    public final ProgressBar pbSendingFeedback;
    @NonNull
    public final LinearLayout reasonsContainer;
    @NonNull
    public final NestedScrollView reasonsScrollContainer;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvReasonHeader;
    @NonNull
    public final TextView tvReasonText;

    private FragmentTproCancellationReasonBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull MaterialEditText materialEditText, @NonNull ImageView imageView, @NonNull ProgressBar progressBar, @NonNull ProgressBar progressBar2, @NonNull LinearLayout linearLayout2, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.actionButtonText = textView;
        this.btnReasonSubmit = linearLayout;
        this.container = constraintLayout2;
        this.etCancellationReasonOther = materialEditText;
        this.ivCancellationImage = imageView;
        this.pbReasons = progressBar;
        this.pbSendingFeedback = progressBar2;
        this.reasonsContainer = linearLayout2;
        this.reasonsScrollContainer = nestedScrollView;
        this.tvReasonHeader = textView2;
        this.tvReasonText = textView3;
    }

    @NonNull
    public static FragmentTproCancellationReasonBottomSheetBinding bind(@NonNull View view) {
        int i11 = R.id.action_button_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.btn_reason_submit;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i11 = R.id.et_cancellation_reason_other;
                MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, i11);
                if (materialEditText != null) {
                    i11 = R.id.iv_cancellation_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView != null) {
                        i11 = R.id.pb_reasons;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                        if (progressBar != null) {
                            i11 = R.id.pb_sending_feedback;
                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                            if (progressBar2 != null) {
                                i11 = R.id.reasons_container;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                if (linearLayout2 != null) {
                                    i11 = R.id.reasons_scroll_container;
                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i11);
                                    if (nestedScrollView != null) {
                                        i11 = R.id.tv_reason_header;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView2 != null) {
                                            i11 = R.id.tv_reason_text;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                            if (textView3 != null) {
                                                return new FragmentTproCancellationReasonBottomSheetBinding(constraintLayout, textView, linearLayout, constraintLayout, materialEditText, imageView, progressBar, progressBar2, linearLayout2, nestedScrollView, textView2, textView3);
                                            }
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
    public static FragmentTproCancellationReasonBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproCancellationReasonBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_cancellation_reason_bottom_sheet, viewGroup, false);
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
