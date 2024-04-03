package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.deliveryhero.customerchat.R;

public final class CustomerChatFragmentOpenChatBinding implements ViewBinding {
    @NonNull
    public final CustomerChatIncludeLayoutComposeBinding layoutCompose;
    @NonNull
    public final RelativeLayout layoutOpenChatRoot;
    @NonNull
    public final RecyclerView recyclerQuickReply;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final View viewSeparator;

    private CustomerChatFragmentOpenChatBinding(@NonNull RelativeLayout relativeLayout, @NonNull CustomerChatIncludeLayoutComposeBinding customerChatIncludeLayoutComposeBinding, @NonNull RelativeLayout relativeLayout2, @NonNull RecyclerView recyclerView, @NonNull View view) {
        this.rootView = relativeLayout;
        this.layoutCompose = customerChatIncludeLayoutComposeBinding;
        this.layoutOpenChatRoot = relativeLayout2;
        this.recyclerQuickReply = recyclerView;
        this.viewSeparator = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        r0 = com.deliveryhero.customerchat.R.id.view_separator;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.deliveryhero.customerchat.databinding.CustomerChatFragmentOpenChatBinding bind(@androidx.annotation.NonNull android.view.View r8) {
        /*
            int r0 = com.deliveryhero.customerchat.R.id.layout_compose
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r1 == 0) goto L_0x002a
            com.deliveryhero.customerchat.databinding.CustomerChatIncludeLayoutComposeBinding r4 = com.deliveryhero.customerchat.databinding.CustomerChatIncludeLayoutComposeBinding.bind(r1)
            r5 = r8
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            int r0 = com.deliveryhero.customerchat.R.id.recycler_quick_reply
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            if (r6 == 0) goto L_0x002a
            int r0 = com.deliveryhero.customerchat.R.id.view_separator
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r7 == 0) goto L_0x002a
            com.deliveryhero.customerchat.databinding.CustomerChatFragmentOpenChatBinding r8 = new com.deliveryhero.customerchat.databinding.CustomerChatFragmentOpenChatBinding
            r2 = r8
            r3 = r5
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        L_0x002a:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.databinding.CustomerChatFragmentOpenChatBinding.bind(android.view.View):com.deliveryhero.customerchat.databinding.CustomerChatFragmentOpenChatBinding");
    }

    @NonNull
    public static CustomerChatFragmentOpenChatBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatFragmentOpenChatBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_fragment_open_chat, viewGroup, false);
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
