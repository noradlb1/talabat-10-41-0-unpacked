package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class ItemChoicesSubmitbuttonBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatFillButton submitChoices;

    private ItemChoicesSubmitbuttonBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatFillButton talabatFillButton) {
        this.rootView = linearLayout;
        this.submitChoices = talabatFillButton;
    }

    @NonNull
    public static ItemChoicesSubmitbuttonBinding bind(@NonNull View view) {
        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.submit_choices);
        if (talabatFillButton != null) {
            return new ItemChoicesSubmitbuttonBinding((LinearLayout) view, talabatFillButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.submit_choices)));
    }

    @NonNull
    public static ItemChoicesSubmitbuttonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemChoicesSubmitbuttonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_choices_submitbutton, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
