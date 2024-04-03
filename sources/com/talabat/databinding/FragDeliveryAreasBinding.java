package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBarRelativeLayoutContainer;

public final class FragDeliveryAreasBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView addressTitle;
    @NonNull
    public final ExpandableListView areaExpList;
    @NonNull
    public final LinearLayout areaListView;
    @NonNull
    public final PlaceSearchGpsEnableContainerBinding gpsEnableContainer;
    @NonNull
    public final RelativeLayout locationContainer;
    @NonNull
    private final TalabatToolBarRelativeLayoutContainer rootView;

    private FragDeliveryAreasBinding(@NonNull TalabatToolBarRelativeLayoutContainer talabatToolBarRelativeLayoutContainer, @NonNull TalabatTextView talabatTextView, @NonNull ExpandableListView expandableListView, @NonNull LinearLayout linearLayout, @NonNull PlaceSearchGpsEnableContainerBinding placeSearchGpsEnableContainerBinding, @NonNull RelativeLayout relativeLayout) {
        this.rootView = talabatToolBarRelativeLayoutContainer;
        this.addressTitle = talabatTextView;
        this.areaExpList = expandableListView;
        this.areaListView = linearLayout;
        this.gpsEnableContainer = placeSearchGpsEnableContainerBinding;
        this.locationContainer = relativeLayout;
    }

    @NonNull
    public static FragDeliveryAreasBinding bind(@NonNull View view) {
        int i11 = R.id.address_title;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.address_title);
        if (talabatTextView != null) {
            i11 = R.id.area_exp_list;
            ExpandableListView expandableListView = (ExpandableListView) ViewBindings.findChildViewById(view, R.id.area_exp_list);
            if (expandableListView != null) {
                i11 = R.id.area_list_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.area_list_view);
                if (linearLayout != null) {
                    i11 = R.id.gps_enable_container;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.gps_enable_container);
                    if (findChildViewById != null) {
                        PlaceSearchGpsEnableContainerBinding bind = PlaceSearchGpsEnableContainerBinding.bind(findChildViewById);
                        i11 = R.id.location_container;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.location_container);
                        if (relativeLayout != null) {
                            return new FragDeliveryAreasBinding((TalabatToolBarRelativeLayoutContainer) view, talabatTextView, expandableListView, linearLayout, bind, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragDeliveryAreasBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragDeliveryAreasBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_delivery_areas, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatToolBarRelativeLayoutContainer getRoot() {
        return this.rootView;
    }
}
