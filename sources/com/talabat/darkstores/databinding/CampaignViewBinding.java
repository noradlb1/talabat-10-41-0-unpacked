package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class CampaignViewBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView imgIcon;
    @NonNull
    private final View rootView;
    @NonNull
    public final AppCompatTextView txtInfo;

    private CampaignViewBinding(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = view;
        this.imgIcon = appCompatImageView;
        this.txtInfo = appCompatTextView;
    }

    @NonNull
    public static CampaignViewBinding bind(@NonNull View view) {
        int i11 = R.id.imgIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.txtInfo;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
            if (appCompatTextView != null) {
                return new CampaignViewBinding(view, appCompatImageView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CampaignViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.campaign_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
