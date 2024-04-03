package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_alert.DSAlert;
import com.talabat.growth.R;

public final class FragFeaturedListBinding implements ViewBinding {
    @NonNull
    public final ImageButton backButton;
    @NonNull
    public final DSAlert dsAlert;
    @NonNull
    public final RecyclerView featuredVouchersRecyclerView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView titleTextView;
    @NonNull
    public final Toolbar toolbar;

    private FragFeaturedListBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageButton imageButton, @NonNull DSAlert dSAlert, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull Toolbar toolbar2) {
        this.rootView = relativeLayout;
        this.backButton = imageButton;
        this.dsAlert = dSAlert;
        this.featuredVouchersRecyclerView = recyclerView;
        this.titleTextView = textView;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static FragFeaturedListBinding bind(@NonNull View view) {
        int i11 = R.id.backButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i11);
        if (imageButton != null) {
            i11 = R.id.dsAlert;
            DSAlert dSAlert = (DSAlert) ViewBindings.findChildViewById(view, i11);
            if (dSAlert != null) {
                i11 = R.id.featuredVouchersRecyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                if (recyclerView != null) {
                    i11 = R.id.titleTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.toolbar;
                        Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i11);
                        if (toolbar2 != null) {
                            return new FragFeaturedListBinding((RelativeLayout) view, imageButton, dSAlert, recyclerView, textView, toolbar2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragFeaturedListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragFeaturedListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_featured_list, viewGroup, false);
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
