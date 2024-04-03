package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class FragmentTproPlanSelectionBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonText;
    @NonNull
    public final LinearLayout btnContinue;
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final LinearLayout multiplanFreeTrialInfo;
    @NonNull
    public final LinearLayout plansContainer;
    @NonNull
    public final ScrollView plansScrollContainer;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvChoosePlan;
    @NonNull
    public final TextView txtFreeTrial;

    private FragmentTproPlanSelectionBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ScrollView scrollView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.actionButtonText = textView;
        this.btnContinue = linearLayout;
        this.cancelButton = imageView;
        this.container = constraintLayout2;
        this.multiplanFreeTrialInfo = linearLayout2;
        this.plansContainer = linearLayout3;
        this.plansScrollContainer = scrollView;
        this.tvChoosePlan = textView2;
        this.txtFreeTrial = textView3;
    }

    @NonNull
    public static FragmentTproPlanSelectionBinding bind(@NonNull View view) {
        int i11 = R.id.action_button_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.btn_continue;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout != null) {
                i11 = R.id.cancel_button;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i11 = R.id.multiplan_free_trial_info;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                    if (linearLayout2 != null) {
                        i11 = R.id.plans_container;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                        if (linearLayout3 != null) {
                            i11 = R.id.plans_scroll_container;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i11);
                            if (scrollView != null) {
                                i11 = R.id.tv_choose_plan;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView2 != null) {
                                    i11 = R.id.txt_free_trial;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView3 != null) {
                                        return new FragmentTproPlanSelectionBinding(constraintLayout, textView, linearLayout, imageView, constraintLayout, linearLayout2, linearLayout3, scrollView, textView2, textView3);
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
    public static FragmentTproPlanSelectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproPlanSelectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_plan_selection, viewGroup, false);
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
