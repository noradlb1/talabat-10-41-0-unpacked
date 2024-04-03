package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.pickup.presentation.R;

public final class SingleSwimlanesHeaderViewBinding implements ViewBinding {
    @NonNull
    public final TextView headerTv;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView subHeaderTv;
    @NonNull
    public final RecyclerView swimlanesRv;

    private SingleSwimlanesHeaderViewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.headerTv = textView;
        this.subHeaderTv = textView2;
        this.swimlanesRv = recyclerView;
    }

    @NonNull
    public static SingleSwimlanesHeaderViewBinding bind(@NonNull View view) {
        int i11 = R.id.headerTv;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.subHeaderTv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.swimlanesRv;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                if (recyclerView != null) {
                    return new SingleSwimlanesHeaderViewBinding((LinearLayout) view, textView, textView2, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SingleSwimlanesHeaderViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SingleSwimlanesHeaderViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.single_swimlanes_header_view, viewGroup, false);
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
