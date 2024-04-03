package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class FragmentSkeletonBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ShimmerLayout shimmer1;
    @NonNull
    public final ShimmerLayout shimmer2;
    @NonNull
    public final ShimmerLayout shimmer3;
    @NonNull
    public final ShimmerLayout shimmer4;
    @NonNull
    public final ShimmerLayout shimmer5;
    @NonNull
    public final ShimmerLayout shimmer6;
    @NonNull
    public final ShimmerLayout shimmer7;
    @NonNull
    public final ShimmerLayout shimmer8;

    private FragmentSkeletonBinding(@NonNull LinearLayout linearLayout, @NonNull ShimmerLayout shimmerLayout, @NonNull ShimmerLayout shimmerLayout2, @NonNull ShimmerLayout shimmerLayout3, @NonNull ShimmerLayout shimmerLayout4, @NonNull ShimmerLayout shimmerLayout5, @NonNull ShimmerLayout shimmerLayout6, @NonNull ShimmerLayout shimmerLayout7, @NonNull ShimmerLayout shimmerLayout8) {
        this.rootView = linearLayout;
        this.shimmer1 = shimmerLayout;
        this.shimmer2 = shimmerLayout2;
        this.shimmer3 = shimmerLayout3;
        this.shimmer4 = shimmerLayout4;
        this.shimmer5 = shimmerLayout5;
        this.shimmer6 = shimmerLayout6;
        this.shimmer7 = shimmerLayout7;
        this.shimmer8 = shimmerLayout8;
    }

    @NonNull
    public static FragmentSkeletonBinding bind(@NonNull View view) {
        int i11 = R.id.shimmer1;
        ShimmerLayout shimmerLayout = (ShimmerLayout) ViewBindings.findChildViewById(view, R.id.shimmer1);
        if (shimmerLayout != null) {
            i11 = R.id.shimmer2;
            ShimmerLayout shimmerLayout2 = (ShimmerLayout) ViewBindings.findChildViewById(view, R.id.shimmer2);
            if (shimmerLayout2 != null) {
                i11 = R.id.shimmer3;
                ShimmerLayout shimmerLayout3 = (ShimmerLayout) ViewBindings.findChildViewById(view, R.id.shimmer3);
                if (shimmerLayout3 != null) {
                    i11 = R.id.shimmer4;
                    ShimmerLayout shimmerLayout4 = (ShimmerLayout) ViewBindings.findChildViewById(view, R.id.shimmer4);
                    if (shimmerLayout4 != null) {
                        i11 = R.id.shimmer5;
                        ShimmerLayout shimmerLayout5 = (ShimmerLayout) ViewBindings.findChildViewById(view, R.id.shimmer5);
                        if (shimmerLayout5 != null) {
                            i11 = R.id.shimmer6;
                            ShimmerLayout shimmerLayout6 = (ShimmerLayout) ViewBindings.findChildViewById(view, R.id.shimmer6);
                            if (shimmerLayout6 != null) {
                                i11 = R.id.shimmer7;
                                ShimmerLayout shimmerLayout7 = (ShimmerLayout) ViewBindings.findChildViewById(view, R.id.shimmer7);
                                if (shimmerLayout7 != null) {
                                    i11 = R.id.shimmer8;
                                    ShimmerLayout shimmerLayout8 = (ShimmerLayout) ViewBindings.findChildViewById(view, R.id.shimmer8);
                                    if (shimmerLayout8 != null) {
                                        return new FragmentSkeletonBinding((LinearLayout) view, shimmerLayout, shimmerLayout2, shimmerLayout3, shimmerLayout4, shimmerLayout5, shimmerLayout6, shimmerLayout7, shimmerLayout8);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentSkeletonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentSkeletonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_skeleton, viewGroup, false);
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
