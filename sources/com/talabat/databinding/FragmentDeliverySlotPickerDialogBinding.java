package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class FragmentDeliverySlotPickerDialogBinding implements ViewBinding {
    @NonNull
    public final TextView btnConfirm;
    @NonNull
    public final AppCompatImageView ivClose;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final RecyclerView rvDeliverySlots;
    @NonNull
    public final AppCompatTextView tvTitle;

    private FragmentDeliverySlotPickerDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull AppCompatImageView appCompatImageView, @NonNull RecyclerView recyclerView, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = linearLayout;
        this.btnConfirm = textView;
        this.ivClose = appCompatImageView;
        this.rvDeliverySlots = recyclerView;
        this.tvTitle = appCompatTextView;
    }

    @NonNull
    public static FragmentDeliverySlotPickerDialogBinding bind(@NonNull View view) {
        int i11 = R.id.btnConfirm;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.btnConfirm);
        if (textView != null) {
            i11 = R.id.ivClose;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, R.id.ivClose);
            if (appCompatImageView != null) {
                i11 = R.id.rvDeliverySlots;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rvDeliverySlots);
                if (recyclerView != null) {
                    i11 = R.id.tvTitle;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, R.id.tvTitle);
                    if (appCompatTextView != null) {
                        return new FragmentDeliverySlotPickerDialogBinding((LinearLayout) view, textView, appCompatImageView, recyclerView, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentDeliverySlotPickerDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentDeliverySlotPickerDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_delivery_slot_picker_dialog, viewGroup, false);
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
