package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresItemSeachLabelBinding implements ViewBinding {
    @NonNull
    private final View rootView;

    private DarkstoresItemSeachLabelBinding(@NonNull View view) {
        this.rootView = view;
    }

    @NonNull
    public static DarkstoresItemSeachLabelBinding bind(@NonNull View view) {
        if (view != null) {
            return new DarkstoresItemSeachLabelBinding(view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemSeachLabelBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DarkstoresItemSeachLabelBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_seach_label, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
}
