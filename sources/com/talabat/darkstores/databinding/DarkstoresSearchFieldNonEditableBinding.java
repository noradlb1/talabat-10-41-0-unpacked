package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresSearchFieldNonEditableBinding implements ViewBinding {
    @NonNull
    public final View btnSearch;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final SearchView searchView;
    @NonNull
    public final ConstraintLayout searchViewLayout;

    private DarkstoresSearchFieldNonEditableBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull SearchView searchView2, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.btnSearch = view;
        this.searchView = searchView2;
        this.searchViewLayout = constraintLayout2;
    }

    @NonNull
    public static DarkstoresSearchFieldNonEditableBinding bind(@NonNull View view) {
        int i11 = R.id.btnSearch;
        View findChildViewById = ViewBindings.findChildViewById(view, i11);
        if (findChildViewById != null) {
            i11 = R.id.searchView;
            SearchView searchView2 = (SearchView) ViewBindings.findChildViewById(view, i11);
            if (searchView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new DarkstoresSearchFieldNonEditableBinding(constraintLayout, findChildViewById, searchView2, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresSearchFieldNonEditableBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresSearchFieldNonEditableBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_search_field_non_editable, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
