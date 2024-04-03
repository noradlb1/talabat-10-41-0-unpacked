package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarLinearLayoutContainer;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class ChangeEmailScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatFillButton changeEmailApply;
    @NonNull
    public final MaterialEditText changeEmailNew;
    @NonNull
    public final MaterialEditText changeEmailRetype;
    @NonNull
    private final TalabatToolBarLinearLayoutContainer rootView;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private ChangeEmailScreenBinding(@NonNull TalabatToolBarLinearLayoutContainer talabatToolBarLinearLayoutContainer, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatFillButton talabatFillButton, @NonNull MaterialEditText materialEditText, @NonNull MaterialEditText materialEditText2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = talabatToolBarLinearLayoutContainer;
        this.back = talabatToolBarImageButton;
        this.changeEmailApply = talabatFillButton;
        this.changeEmailNew = materialEditText;
        this.changeEmailRetype = materialEditText2;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static ChangeEmailScreenBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.change_email_apply;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.change_email_apply);
            if (talabatFillButton != null) {
                i11 = R.id.change_email_new;
                MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.change_email_new);
                if (materialEditText != null) {
                    i11 = R.id.change_email_retype;
                    MaterialEditText materialEditText2 = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.change_email_retype);
                    if (materialEditText2 != null) {
                        i11 = R.id.title;
                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
                        if (talabatToolBarTextView != null) {
                            i11 = R.id.toolbar;
                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                            if (talabatToolBar != null) {
                                return new ChangeEmailScreenBinding((TalabatToolBarLinearLayoutContainer) view, talabatToolBarImageButton, talabatFillButton, materialEditText, materialEditText2, talabatToolBarTextView, talabatToolBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ChangeEmailScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ChangeEmailScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.change_email_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatToolBarLinearLayoutContainer getRoot() {
        return this.rootView;
    }
}
