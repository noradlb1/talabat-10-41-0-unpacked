package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class PasswordFldBinding implements ViewBinding {
    @NonNull
    public final MaterialEditText eTPassword;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatTextView showHideTxt;

    private PasswordFldBinding(@NonNull RelativeLayout relativeLayout, @NonNull MaterialEditText materialEditText, @NonNull TalabatTextView talabatTextView) {
        this.rootView = relativeLayout;
        this.eTPassword = materialEditText;
        this.showHideTxt = talabatTextView;
    }

    @NonNull
    public static PasswordFldBinding bind(@NonNull View view) {
        int i11 = R.id.eTPassword;
        MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.eTPassword);
        if (materialEditText != null) {
            i11 = R.id.show_hide_txt;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.show_hide_txt);
            if (talabatTextView != null) {
                return new PasswordFldBinding((RelativeLayout) view, materialEditText, talabatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static PasswordFldBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static PasswordFldBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.password_fld, viewGroup, false);
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
