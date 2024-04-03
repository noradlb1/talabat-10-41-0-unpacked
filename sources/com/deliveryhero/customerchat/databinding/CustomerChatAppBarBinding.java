package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;
import com.google.android.material.appbar.AppBarLayout;

public final class CustomerChatAppBarBinding implements ViewBinding {
    @NonNull
    public final AppBarLayout appbarLayoutBasic;
    @NonNull
    private final AppBarLayout rootView;
    @NonNull
    public final Toolbar toolbar;

    private CustomerChatAppBarBinding(@NonNull AppBarLayout appBarLayout, @NonNull AppBarLayout appBarLayout2, @NonNull Toolbar toolbar2) {
        this.rootView = appBarLayout;
        this.appbarLayoutBasic = appBarLayout2;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static CustomerChatAppBarBinding bind(@NonNull View view) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        int i11 = R.id.toolbar;
        Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i11);
        if (toolbar2 != null) {
            return new CustomerChatAppBarBinding(appBarLayout, appBarLayout, toolbar2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatAppBarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatAppBarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_app_bar, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public AppBarLayout getRoot() {
        return this.rootView;
    }
}
