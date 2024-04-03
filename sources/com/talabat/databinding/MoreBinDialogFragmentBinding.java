package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class MoreBinDialogFragmentBinding implements ViewBinding {
    @NonNull
    public final ImageView closeBinDialog;
    @NonNull
    public final RelativeLayout listContainer;
    @NonNull
    public final RecyclerView moreBinRecyclerView;
    @NonNull
    private final FrameLayout rootView;

    private MoreBinDialogFragmentBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.closeBinDialog = imageView;
        this.listContainer = relativeLayout;
        this.moreBinRecyclerView = recyclerView;
    }

    @NonNull
    public static MoreBinDialogFragmentBinding bind(@NonNull View view) {
        int i11 = R.id.close_bin_dialog;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close_bin_dialog);
        if (imageView != null) {
            i11 = R.id.list_container;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.list_container);
            if (relativeLayout != null) {
                i11 = R.id.more_bin_recyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.more_bin_recyclerView);
                if (recyclerView != null) {
                    return new MoreBinDialogFragmentBinding((FrameLayout) view, imageView, relativeLayout, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MoreBinDialogFragmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MoreBinDialogFragmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.more_bin_dialog_fragment, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
