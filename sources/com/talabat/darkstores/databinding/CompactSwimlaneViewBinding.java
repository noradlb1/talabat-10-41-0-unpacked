package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class CompactSwimlaneViewBinding implements ViewBinding {
    @NonNull
    public final RecyclerView compactSwimlaneRecyclerView;
    @NonNull
    public final TextView compactSwimlaneTitle;
    @NonNull
    private final View rootView;

    private CompactSwimlaneViewBinding(@NonNull View view, @NonNull RecyclerView recyclerView, @NonNull TextView textView) {
        this.rootView = view;
        this.compactSwimlaneRecyclerView = recyclerView;
        this.compactSwimlaneTitle = textView;
    }

    @NonNull
    public static CompactSwimlaneViewBinding bind(@NonNull View view) {
        int i11 = R.id.compact_swimlane_recycler_view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView != null) {
            i11 = R.id.compact_swimlane_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new CompactSwimlaneViewBinding(view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CompactSwimlaneViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.compact_swimlane_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
