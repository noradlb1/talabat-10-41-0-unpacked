package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.feature.tpro.presentation.databinding.TproSubscriptionHeaderBinding;

public final class DarkstoresItemHomeTproBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TproSubscriptionHeaderBinding subscriptionHeader;

    private DarkstoresItemHomeTproBinding(@NonNull LinearLayout linearLayout, @NonNull TproSubscriptionHeaderBinding tproSubscriptionHeaderBinding) {
        this.rootView = linearLayout;
        this.subscriptionHeader = tproSubscriptionHeaderBinding;
    }

    @NonNull
    public static DarkstoresItemHomeTproBinding bind(@NonNull View view) {
        int i11 = R.id.subscription_header;
        View findChildViewById = ViewBindings.findChildViewById(view, i11);
        if (findChildViewById != null) {
            return new DarkstoresItemHomeTproBinding((LinearLayout) view, TproSubscriptionHeaderBinding.bind(findChildViewById));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemHomeTproBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomeTproBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_tpro, viewGroup, false);
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
