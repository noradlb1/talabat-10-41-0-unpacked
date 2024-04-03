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

public final class CountryCodeListItemBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout convertView;
    @NonNull
    public final TalabatTextView countryCodeRow;
    @NonNull
    public final TalabatTextView countryNameRow;
    @NonNull
    private final RelativeLayout rootView;

    private CountryCodeListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = relativeLayout;
        this.convertView = relativeLayout2;
        this.countryCodeRow = talabatTextView;
        this.countryNameRow = talabatTextView2;
    }

    @NonNull
    public static CountryCodeListItemBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i11 = R.id.country_code_row;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.country_code_row);
        if (talabatTextView != null) {
            i11 = R.id.country_name_row;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.country_name_row);
            if (talabatTextView2 != null) {
                return new CountryCodeListItemBinding(relativeLayout, relativeLayout, talabatTextView, talabatTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CountryCodeListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CountryCodeListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.country_code_list_item, viewGroup, false);
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
