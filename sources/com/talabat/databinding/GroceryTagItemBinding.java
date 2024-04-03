package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class GroceryTagItemBinding implements ViewBinding {
    @NonNull
    private final TalabatTextView rootView;
    @NonNull
    public final TalabatTextView tagTextView;

    private GroceryTagItemBinding(@NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = talabatTextView;
        this.tagTextView = talabatTextView2;
    }

    @NonNull
    public static GroceryTagItemBinding bind(@NonNull View view) {
        if (view != null) {
            TalabatTextView talabatTextView = (TalabatTextView) view;
            return new GroceryTagItemBinding(talabatTextView, talabatTextView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static GroceryTagItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GroceryTagItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.grocery_tag_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatTextView getRoot() {
        return this.rootView;
    }
}
