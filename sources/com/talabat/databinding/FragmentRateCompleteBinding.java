package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class FragmentRateCompleteBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;

    private FragmentRateCompleteBinding(@NonNull RelativeLayout relativeLayout) {
        this.rootView = relativeLayout;
    }

    @NonNull
    public static FragmentRateCompleteBinding bind(@NonNull View view) {
        if (view != null) {
            return new FragmentRateCompleteBinding((RelativeLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static FragmentRateCompleteBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentRateCompleteBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rate_complete, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
