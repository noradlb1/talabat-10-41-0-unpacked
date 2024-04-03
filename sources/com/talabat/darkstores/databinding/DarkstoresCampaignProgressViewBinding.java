package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.talabat.darkstores.R;

public final class DarkstoresCampaignProgressViewBinding implements ViewBinding {
    @NonNull
    public final TextView campaignLimit;
    @NonNull
    public final LinearProgressIndicator campaignProgress;
    @NonNull
    public final AppCompatTextView campaignProgressLabel;
    @NonNull
    private final View rootView;

    private DarkstoresCampaignProgressViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull LinearProgressIndicator linearProgressIndicator, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = view;
        this.campaignLimit = textView;
        this.campaignProgress = linearProgressIndicator;
        this.campaignProgressLabel = appCompatTextView;
    }

    @NonNull
    public static DarkstoresCampaignProgressViewBinding bind(@NonNull View view) {
        int i11 = R.id.campaign_limit;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.campaign_progress;
            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i11);
            if (linearProgressIndicator != null) {
                i11 = R.id.campaign_progress_label;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                if (appCompatTextView != null) {
                    return new DarkstoresCampaignProgressViewBinding(view, textView, linearProgressIndicator, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresCampaignProgressViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_campaign_progress_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
