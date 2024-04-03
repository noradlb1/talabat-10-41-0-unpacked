package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class ViewSponsoredChipBinding implements ViewBinding {
    @NonNull
    private final TextView rootView;

    private ViewSponsoredChipBinding(@NonNull TextView textView) {
        this.rootView = textView;
    }

    @NonNull
    public static ViewSponsoredChipBinding bind(@NonNull View view) {
        if (view != null) {
            return new ViewSponsoredChipBinding((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ViewSponsoredChipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewSponsoredChipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_sponsored_chip, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TextView getRoot() {
        return this.rootView;
    }
}
