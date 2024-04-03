package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;
import com.talabat.TalabatCheckedTextView;

public final class TalabatSpinnerDropDownItemBinding implements ViewBinding {
    @NonNull
    private final TalabatCheckedTextView rootView;
    @NonNull
    public final TalabatCheckedTextView text1;

    private TalabatSpinnerDropDownItemBinding(@NonNull TalabatCheckedTextView talabatCheckedTextView, @NonNull TalabatCheckedTextView talabatCheckedTextView2) {
        this.rootView = talabatCheckedTextView;
        this.text1 = talabatCheckedTextView2;
    }

    @NonNull
    public static TalabatSpinnerDropDownItemBinding bind(@NonNull View view) {
        if (view != null) {
            TalabatCheckedTextView talabatCheckedTextView = (TalabatCheckedTextView) view;
            return new TalabatSpinnerDropDownItemBinding(talabatCheckedTextView, talabatCheckedTextView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static TalabatSpinnerDropDownItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TalabatSpinnerDropDownItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.talabat_spinner_drop_down_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatCheckedTextView getRoot() {
        return this.rootView;
    }
}
