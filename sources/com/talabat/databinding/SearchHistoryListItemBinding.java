package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class SearchHistoryListItemBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout searchHistoryCell;
    @NonNull
    public final ImageView searchHistoryIcon;
    @NonNull
    public final TalabatTextView searchTerm;

    private SearchHistoryListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView) {
        this.rootView = relativeLayout;
        this.searchHistoryCell = relativeLayout2;
        this.searchHistoryIcon = imageView;
        this.searchTerm = talabatTextView;
    }

    @NonNull
    public static SearchHistoryListItemBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i11 = R.id.search_history_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.search_history_icon);
        if (imageView != null) {
            i11 = R.id.search_term;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.search_term);
            if (talabatTextView != null) {
                return new SearchHistoryListItemBinding(relativeLayout, relativeLayout, imageView, talabatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SearchHistoryListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SearchHistoryListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.search_history_list_item, viewGroup, false);
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
