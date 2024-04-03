package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class FragmentCurrentLocationFetchBinding implements ViewBinding {
    @NonNull
    public final TalabatFillButton allowLocation;
    @NonNull
    public final LinearLayout contentContainer;
    @NonNull
    public final TalabatTextView locationMsgTxt;
    @NonNull
    public final TalabatTextView locationTitleText;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final TalabatButton skipNow;

    private FragmentCurrentLocationFetchBinding(@NonNull FrameLayout frameLayout, @NonNull TalabatFillButton talabatFillButton, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatButton talabatButton) {
        this.rootView = frameLayout;
        this.allowLocation = talabatFillButton;
        this.contentContainer = linearLayout;
        this.locationMsgTxt = talabatTextView;
        this.locationTitleText = talabatTextView2;
        this.skipNow = talabatButton;
    }

    @NonNull
    public static FragmentCurrentLocationFetchBinding bind(@NonNull View view) {
        int i11 = R.id.allow_location;
        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.allow_location);
        if (talabatFillButton != null) {
            i11 = R.id.content_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.content_container);
            if (linearLayout != null) {
                i11 = R.id.location_msg_txt;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.location_msg_txt);
                if (talabatTextView != null) {
                    i11 = R.id.location_title_text;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.location_title_text);
                    if (talabatTextView2 != null) {
                        i11 = R.id.skip_now;
                        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view, R.id.skip_now);
                        if (talabatButton != null) {
                            return new FragmentCurrentLocationFetchBinding((FrameLayout) view, talabatFillButton, linearLayout, talabatTextView, talabatTextView2, talabatButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentCurrentLocationFetchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentCurrentLocationFetchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_current_location_fetch, viewGroup, false);
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
