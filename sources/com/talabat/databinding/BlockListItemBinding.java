package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class BlockListItemBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView blockSpinnerTxt;
    @NonNull
    public final RelativeLayout convertView;
    @NonNull
    private final RelativeLayout rootView;

    private BlockListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.blockSpinnerTxt = talabatTextView;
        this.convertView = relativeLayout2;
    }

    @NonNull
    public static BlockListItemBinding bind(@NonNull View view) {
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.block_spinner_txt);
        if (talabatTextView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new BlockListItemBinding(relativeLayout, talabatTextView, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.block_spinner_txt)));
    }

    @NonNull
    public static BlockListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BlockListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.block_list_item, viewGroup, false);
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
