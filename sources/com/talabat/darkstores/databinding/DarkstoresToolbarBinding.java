package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresToolbarBinding implements ViewBinding {
    @NonNull
    private final Toolbar rootView;
    @NonNull
    public final Toolbar toolbar;

    private DarkstoresToolbarBinding(@NonNull Toolbar toolbar2, @NonNull Toolbar toolbar3) {
        this.rootView = toolbar2;
        this.toolbar = toolbar3;
    }

    @NonNull
    public static DarkstoresToolbarBinding bind(@NonNull View view) {
        if (view != null) {
            Toolbar toolbar2 = (Toolbar) view;
            return new DarkstoresToolbarBinding(toolbar2, toolbar2);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresToolbarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresToolbarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_toolbar, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public Toolbar getRoot() {
        return this.rootView;
    }
}
