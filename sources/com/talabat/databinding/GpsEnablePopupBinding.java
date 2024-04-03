package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class GpsEnablePopupBinding implements ViewBinding {
    @NonNull
    public final LinearLayout buttonsView;
    @NonNull
    public final LinearLayout goToSettings;
    @NonNull
    public final TalabatTextView gpsSteps2;
    @NonNull
    public final TalabatTextView gpsSteps3;
    @NonNull
    public final TalabatTextView gpsStepsX1;
    @NonNull
    public final TalabatTextView msgTxt;
    @NonNull
    public final LinearLayout noThanks;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView settingsNotificationSwitch;
    @NonNull
    public final LinearLayout textSection;
    @NonNull
    public final TalabatTextView title;

    private GpsEnablePopupBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout4, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView5) {
        this.rootView = linearLayout;
        this.buttonsView = linearLayout2;
        this.goToSettings = linearLayout3;
        this.gpsSteps2 = talabatTextView;
        this.gpsSteps3 = talabatTextView2;
        this.gpsStepsX1 = talabatTextView3;
        this.msgTxt = talabatTextView4;
        this.noThanks = linearLayout4;
        this.settingsNotificationSwitch = imageView;
        this.textSection = linearLayout5;
        this.title = talabatTextView5;
    }

    @NonNull
    public static GpsEnablePopupBinding bind(@NonNull View view) {
        int i11 = R.id.buttons_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.buttons_view);
        if (linearLayout != null) {
            i11 = R.id.go_to_settings;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.go_to_settings);
            if (linearLayout2 != null) {
                i11 = R.id.gps_steps_2;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.gps_steps_2);
                if (talabatTextView != null) {
                    i11 = R.id.gps_steps_3;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.gps_steps_3);
                    if (talabatTextView2 != null) {
                        i11 = R.id.gps_steps_x1;
                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.gps_steps_x1);
                        if (talabatTextView3 != null) {
                            i11 = R.id.msg_txt;
                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.msg_txt);
                            if (talabatTextView4 != null) {
                                i11 = R.id.no_thanks;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.no_thanks);
                                if (linearLayout3 != null) {
                                    i11 = R.id.settings_notification_switch;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.settings_notification_switch);
                                    if (imageView != null) {
                                        i11 = R.id.text_section;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.text_section);
                                        if (linearLayout4 != null) {
                                            i11 = R.id.title;
                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.title);
                                            if (talabatTextView5 != null) {
                                                return new GpsEnablePopupBinding((LinearLayout) view, linearLayout, linearLayout2, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4, linearLayout3, imageView, linearLayout4, talabatTextView5);
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
    public static GpsEnablePopupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GpsEnablePopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.gps_enable_popup, viewGroup, false);
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
