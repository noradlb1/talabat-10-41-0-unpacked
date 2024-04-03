package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class SurveryAlertXmlBinding implements ViewBinding {
    @NonNull
    public final LinearLayout contentPanel;
    @NonNull
    public final FrameLayout customPanel;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final LinearLayout list;
    @NonNull
    public final LinearLayout parentPanel;
    @NonNull
    public final TalabatTextView question;
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final TalabatFillButton surveySubmit;
    @NonNull
    public final LinearLayout topPanel;

    private SurveryAlertXmlBinding(@NonNull NestedScrollView nestedScrollView, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TalabatTextView talabatTextView, @NonNull TalabatFillButton talabatFillButton, @NonNull LinearLayout linearLayout4) {
        this.rootView = nestedScrollView;
        this.contentPanel = linearLayout;
        this.customPanel = frameLayout;
        this.icon = imageView;
        this.list = linearLayout2;
        this.parentPanel = linearLayout3;
        this.question = talabatTextView;
        this.surveySubmit = talabatFillButton;
        this.topPanel = linearLayout4;
    }

    @NonNull
    public static SurveryAlertXmlBinding bind(@NonNull View view) {
        int i11 = R.id.contentPanel;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.contentPanel);
        if (linearLayout != null) {
            i11 = R.id.customPanel;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.customPanel);
            if (frameLayout != null) {
                i11 = R.id.icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
                if (imageView != null) {
                    i11 = R.id.list;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.list);
                    if (linearLayout2 != null) {
                        i11 = R.id.parentPanel;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.parentPanel);
                        if (linearLayout3 != null) {
                            i11 = R.id.question;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.question);
                            if (talabatTextView != null) {
                                i11 = R.id.survey_submit;
                                TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.survey_submit);
                                if (talabatFillButton != null) {
                                    i11 = R.id.topPanel;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.topPanel);
                                    if (linearLayout4 != null) {
                                        return new SurveryAlertXmlBinding((NestedScrollView) view, linearLayout, frameLayout, imageView, linearLayout2, linearLayout3, talabatTextView, talabatFillButton, linearLayout4);
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
    public static SurveryAlertXmlBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SurveryAlertXmlBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.survery_alert_xml, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }
}
