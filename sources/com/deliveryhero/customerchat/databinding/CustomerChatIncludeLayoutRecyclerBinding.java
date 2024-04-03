package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;

public final class CustomerChatIncludeLayoutRecyclerBinding implements ViewBinding {
    @NonNull
    public final ProgressBar progressBarRefresh;
    @NonNull
    public final RecyclerView recyclerChat;
    @NonNull
    public final LinearLayout rootView;
    @NonNull
    private final LinearLayout rootView_;
    @NonNull
    public final TextView viewNoInternetConnection;

    private CustomerChatIncludeLayoutRecyclerBinding(@NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.rootView_ = linearLayout;
        this.progressBarRefresh = progressBar;
        this.recyclerChat = recyclerView;
        this.rootView = linearLayout2;
        this.viewNoInternetConnection = textView;
    }

    @NonNull
    public static CustomerChatIncludeLayoutRecyclerBinding bind(@NonNull View view) {
        int i11 = R.id.progress_bar_refresh;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i11);
        if (progressBar != null) {
            i11 = R.id.recycler_chat;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
            if (recyclerView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i11 = R.id.view_no_internet_connection;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    return new CustomerChatIncludeLayoutRecyclerBinding(linearLayout, progressBar, recyclerView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatIncludeLayoutRecyclerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatIncludeLayoutRecyclerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_include_layout_recycler, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView_;
    }
}
