package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class TalabatSpinnerItemBinding implements ViewBinding {
    @NonNull
    private final TalabatTextView rootView;
    @NonNull
    public final TalabatTextView text1;

    private TalabatSpinnerItemBinding(@NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = talabatTextView;
        this.text1 = talabatTextView2;
    }

    @NonNull
    public static TalabatSpinnerItemBinding bind(@NonNull View view) {
        if (view != null) {
            TalabatTextView talabatTextView = (TalabatTextView) view;
            return new TalabatSpinnerItemBinding(talabatTextView, talabatTextView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static TalabatSpinnerItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TalabatSpinnerItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.talabat_spinner_item, viewGroup, false);
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
