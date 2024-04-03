package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;

public final class PlaceSearchGpsEnableContainerBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView currentLocationTitle;
    @NonNull
    public final RelativeLayout enableGpsContainer;
    @NonNull
    public final ProgressBar enableLocationProgress;
    @NonNull
    public final TalabatButton gpsEnableBtn;
    @NonNull
    public final ImageView gpsIcon;
    @NonNull
    private final RelativeLayout rootView;

    private PlaceSearchGpsEnableContainerBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2, @NonNull ProgressBar progressBar, @NonNull TalabatButton talabatButton, @NonNull ImageView imageView) {
        this.rootView = relativeLayout;
        this.currentLocationTitle = talabatTextView;
        this.enableGpsContainer = relativeLayout2;
        this.enableLocationProgress = progressBar;
        this.gpsEnableBtn = talabatButton;
        this.gpsIcon = imageView;
    }

    @NonNull
    public static PlaceSearchGpsEnableContainerBinding bind(@NonNull View view) {
        int i11 = R.id.current_location_title;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.current_location_title);
        if (talabatTextView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i11 = R.id.enable_location_progress;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.enable_location_progress);
            if (progressBar != null) {
                i11 = R.id.gps_enable_btn;
                TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view, R.id.gps_enable_btn);
                if (talabatButton != null) {
                    i11 = R.id.gps_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.gps_icon);
                    if (imageView != null) {
                        return new PlaceSearchGpsEnableContainerBinding(relativeLayout, talabatTextView, relativeLayout, progressBar, talabatButton, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static PlaceSearchGpsEnableContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static PlaceSearchGpsEnableContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.place_search_gps_enable_container, viewGroup, false);
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
