package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;
import com.talabat.helpers.OptionalItemLayout;

public final class ItemHolderOptionalBinding implements ViewBinding {
    @NonNull
    public final OptionalItemLayout optionalItemLayout;
    @NonNull
    private final OptionalItemLayout rootView;

    private ItemHolderOptionalBinding(@NonNull OptionalItemLayout optionalItemLayout2, @NonNull OptionalItemLayout optionalItemLayout3) {
        this.rootView = optionalItemLayout2;
        this.optionalItemLayout = optionalItemLayout3;
    }

    @NonNull
    public static ItemHolderOptionalBinding bind(@NonNull View view) {
        if (view != null) {
            OptionalItemLayout optionalItemLayout2 = (OptionalItemLayout) view;
            return new ItemHolderOptionalBinding(optionalItemLayout2, optionalItemLayout2);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ItemHolderOptionalBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemHolderOptionalBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_holder_optional, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public OptionalItemLayout getRoot() {
        return this.rootView;
    }
}
