package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresFragmentBottomSheetAgeRestrictionBinding implements ViewBinding {
    @NonNull
    public final AppCompatTextView ageRestricitonBottomBody;
    @NonNull
    public final AppCompatTextView ageRestricitonBottomTitle;
    @NonNull
    public final ImageView ageRestrictionClose;
    @NonNull
    public final TextView eligible;
    @NonNull
    public final TextView ineligible;
    @NonNull
    public final LinearLayout loggedActions;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresFragmentBottomSheetAgeRestrictionBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.ageRestricitonBottomBody = appCompatTextView;
        this.ageRestricitonBottomTitle = appCompatTextView2;
        this.ageRestrictionClose = imageView;
        this.eligible = textView;
        this.ineligible = textView2;
        this.loggedActions = linearLayout2;
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetAgeRestrictionBinding bind(@NonNull View view) {
        int i11 = R.id.age_restriciton_bottom_body;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
        if (appCompatTextView != null) {
            i11 = R.id.age_restriciton_bottom_title;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R.id.age_restriction_close;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    i11 = R.id.eligible;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.ineligible;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.logged_actions;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                            if (linearLayout != null) {
                                return new DarkstoresFragmentBottomSheetAgeRestrictionBinding((LinearLayout) view, appCompatTextView, appCompatTextView2, imageView, textView, textView2, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetAgeRestrictionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetAgeRestrictionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_bottom_sheet_age_restriction, viewGroup, false);
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
