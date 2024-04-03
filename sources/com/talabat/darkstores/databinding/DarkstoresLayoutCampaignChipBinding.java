package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresLayoutCampaignChipBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView imageView3;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView textView;

    private DarkstoresLayoutCampaignChipBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.imageView3 = appCompatImageView;
        this.textView = textView2;
    }

    @NonNull
    public static DarkstoresLayoutCampaignChipBinding bind(@NonNull View view) {
        int i11 = R.id.imageView3;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.textView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                return new DarkstoresLayoutCampaignChipBinding((LinearLayout) view, appCompatImageView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresLayoutCampaignChipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresLayoutCampaignChipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_layout_campaign_chip, viewGroup, false);
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
