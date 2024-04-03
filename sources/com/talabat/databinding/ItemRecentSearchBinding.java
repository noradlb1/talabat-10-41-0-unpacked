package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ItemRecentSearchBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView textViewRecent;

    private ItemRecentSearchBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.textViewRecent = textView;
    }

    @NonNull
    public static ItemRecentSearchBinding bind(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView_recent);
        if (textView != null) {
            return new ItemRecentSearchBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.textView_recent)));
    }

    @NonNull
    public static ItemRecentSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemRecentSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_recent_search, viewGroup, false);
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
