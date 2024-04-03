package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresItemSearchSuggestionEmptyBinding implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;

    private DarkstoresItemSearchSuggestionEmptyBinding(@NonNull FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    @NonNull
    public static DarkstoresItemSearchSuggestionEmptyBinding bind(@NonNull View view) {
        if (view != null) {
            return new DarkstoresItemSearchSuggestionEmptyBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemSearchSuggestionEmptyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemSearchSuggestionEmptyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_search_suggestion_empty, viewGroup, false);
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
