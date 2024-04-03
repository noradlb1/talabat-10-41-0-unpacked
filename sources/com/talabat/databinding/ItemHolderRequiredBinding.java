package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;
import com.talabat.helpers.RequiredItemLayout;

public final class ItemHolderRequiredBinding implements ViewBinding {
    @NonNull
    public final RequiredItemLayout requiredItemLayout;
    @NonNull
    private final RequiredItemLayout rootView;

    private ItemHolderRequiredBinding(@NonNull RequiredItemLayout requiredItemLayout2, @NonNull RequiredItemLayout requiredItemLayout3) {
        this.rootView = requiredItemLayout2;
        this.requiredItemLayout = requiredItemLayout3;
    }

    @NonNull
    public static ItemHolderRequiredBinding bind(@NonNull View view) {
        if (view != null) {
            RequiredItemLayout requiredItemLayout2 = (RequiredItemLayout) view;
            return new ItemHolderRequiredBinding(requiredItemLayout2, requiredItemLayout2);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ItemHolderRequiredBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemHolderRequiredBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_holder_required, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RequiredItemLayout getRoot() {
        return this.rootView;
    }
}
