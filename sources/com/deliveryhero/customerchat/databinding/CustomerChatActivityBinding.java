package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;

public final class CustomerChatActivityBinding implements ViewBinding {
    @NonNull
    public final FrameLayout containerOpenChannel;
    @NonNull
    private final LinearLayout rootView;

    private CustomerChatActivityBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.containerOpenChannel = frameLayout;
    }

    @NonNull
    public static CustomerChatActivityBinding bind(@NonNull View view) {
        int i11 = R.id.container_open_channel;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
        if (frameLayout != null) {
            return new CustomerChatActivityBinding((LinearLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatActivityBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatActivityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_activity, viewGroup, false);
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
