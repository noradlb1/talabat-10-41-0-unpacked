package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class CountryCodeSelectorBinding implements ViewBinding {
    @NonNull
    public final ListView countryList;
    @NonNull
    private final LinearLayout rootView;

    private CountryCodeSelectorBinding(@NonNull LinearLayout linearLayout, @NonNull ListView listView) {
        this.rootView = linearLayout;
        this.countryList = listView;
    }

    @NonNull
    public static CountryCodeSelectorBinding bind(@NonNull View view) {
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.country_list);
        if (listView != null) {
            return new CountryCodeSelectorBinding((LinearLayout) view, listView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.country_list)));
    }

    @NonNull
    public static CountryCodeSelectorBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CountryCodeSelectorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.country_code_selector, viewGroup, false);
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
