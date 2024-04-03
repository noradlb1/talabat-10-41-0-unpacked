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

public final class ChangePasswordNewFldBinding implements ViewBinding {
    @NonNull
    public final MaterialEditText changePasswordNew;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatTextView showCurrentNewTxt;

    private ChangePasswordNewFldBinding(@NonNull RelativeLayout relativeLayout, @NonNull MaterialEditText materialEditText, @NonNull TalabatTextView talabatTextView) {
        this.rootView = relativeLayout;
        this.changePasswordNew = materialEditText;
        this.showCurrentNewTxt = talabatTextView;
    }

    @NonNull
    public static ChangePasswordNewFldBinding bind(@NonNull View view) {
        int i11 = R.id.change_password_new;
        MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.change_password_new);
        if (materialEditText != null) {
            i11 = R.id.show_current_new_txt;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.show_current_new_txt);
            if (talabatTextView != null) {
                return new ChangePasswordNewFldBinding((RelativeLayout) view, materialEditText, talabatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ChangePasswordNewFldBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ChangePasswordNewFldBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.change_password_new_fld, viewGroup, false);
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
