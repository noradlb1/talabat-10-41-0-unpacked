package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;

public final class CustomerChatIncludeLayoutAttachmentListBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final RecyclerView rvAttachmentSelectionList;

    private CustomerChatIncludeLayoutAttachmentListBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.rvAttachmentSelectionList = recyclerView;
    }

    @NonNull
    public static CustomerChatIncludeLayoutAttachmentListBinding bind(@NonNull View view) {
        int i11 = R.id.rv_attachment_selection_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView != null) {
            return new CustomerChatIncludeLayoutAttachmentListBinding((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatIncludeLayoutAttachmentListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatIncludeLayoutAttachmentListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_include_layout_attachment_list, viewGroup, false);
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
