package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class FragmentRestaurntsListBinding implements ViewBinding {
    @NonNull
    public final ImageView imageViewNoRestaurants;
    @NonNull
    public final FragmentContainerView prescriptionFragmentContainer;
    @NonNull
    public final FragmentSkeletonBinding progressShimmer;
    @NonNull
    public final RecyclerView recyclerViewRestaurantsList;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final NestedScrollView scrollViewNoRestaurantsContainer;

    private FragmentRestaurntsListBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentSkeletonBinding fragmentSkeletonBinding, @NonNull RecyclerView recyclerView, @NonNull NestedScrollView nestedScrollView) {
        this.rootView = frameLayout;
        this.imageViewNoRestaurants = imageView;
        this.prescriptionFragmentContainer = fragmentContainerView;
        this.progressShimmer = fragmentSkeletonBinding;
        this.recyclerViewRestaurantsList = recyclerView;
        this.scrollViewNoRestaurantsContainer = nestedScrollView;
    }

    @NonNull
    public static FragmentRestaurntsListBinding bind(@NonNull View view) {
        int i11 = R.id.imageView_noRestaurants;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_noRestaurants);
        if (imageView != null) {
            i11 = R.id.prescription_fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, R.id.prescription_fragment_container);
            if (fragmentContainerView != null) {
                i11 = R.id.progressShimmer;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.progressShimmer);
                if (findChildViewById != null) {
                    FragmentSkeletonBinding bind = FragmentSkeletonBinding.bind(findChildViewById);
                    i11 = R.id.recyclerView_restaurantsList;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView_restaurantsList);
                    if (recyclerView != null) {
                        i11 = R.id.scrollView_noRestaurantsContainer;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scrollView_noRestaurantsContainer);
                        if (nestedScrollView != null) {
                            return new FragmentRestaurntsListBinding((FrameLayout) view, imageView, fragmentContainerView, bind, recyclerView, nestedScrollView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentRestaurntsListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentRestaurntsListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_restaurnts_list, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
