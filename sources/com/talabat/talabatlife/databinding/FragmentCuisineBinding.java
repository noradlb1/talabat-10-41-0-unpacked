package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class FragmentCuisineBinding implements ViewBinding {
    @NonNull
    public final ImageButton closeBtn;
    @NonNull
    public final RecyclerView cuisineRecyclerView;
    @NonNull
    public final RelativeLayout headerContent;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textView3;

    private FragmentCuisineBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull RecyclerView recyclerView, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.closeBtn = imageButton;
        this.cuisineRecyclerView = recyclerView;
        this.headerContent = relativeLayout;
        this.textView3 = textView;
    }

    @NonNull
    public static FragmentCuisineBinding bind(@NonNull View view) {
        int i11 = R.id.closeBtn;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i11);
        if (imageButton != null) {
            i11 = R.id.cuisineRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
            if (recyclerView != null) {
                i11 = R.id.headerContent;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
                if (relativeLayout != null) {
                    i11 = R.id.textView3;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        return new FragmentCuisineBinding((ConstraintLayout) view, imageButton, recyclerView, relativeLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentCuisineBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentCuisineBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cuisine, viewGroup, false);
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
