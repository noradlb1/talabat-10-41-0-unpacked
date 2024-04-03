package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class FragVendorListLocationFilterBinding implements ViewBinding {
    @NonNull
    public final ImageView clearButton;
    @NonNull
    public final ImageView closeFragment;
    @NonNull
    public final ConstraintLayout header;
    @NonNull
    public final ConstraintLayout locationListContainer;
    @NonNull
    public final RelativeLayout relativeLayout;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final EditText searchEdit;
    @NonNull
    public final TextView title;
    @NonNull
    public final RecyclerView vendorLocationList;

    private FragVendorListLocationFilterBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull RelativeLayout relativeLayout2, @NonNull EditText editText, @NonNull TextView textView, @NonNull RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.clearButton = imageView;
        this.closeFragment = imageView2;
        this.header = constraintLayout2;
        this.locationListContainer = constraintLayout3;
        this.relativeLayout = relativeLayout2;
        this.searchEdit = editText;
        this.title = textView;
        this.vendorLocationList = recyclerView;
    }

    @NonNull
    public static FragVendorListLocationFilterBinding bind(@NonNull View view) {
        int i11 = R.id.clear_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.close_fragment;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView2 != null) {
                i11 = R.id.header;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
                if (constraintLayout != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i11 = R.id.relativeLayout;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
                    if (relativeLayout2 != null) {
                        i11 = R.id.search_edit;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i11);
                        if (editText != null) {
                            i11 = R.id.title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView != null) {
                                i11 = R.id.vendor_location_list;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                                if (recyclerView != null) {
                                    return new FragVendorListLocationFilterBinding(constraintLayout2, imageView, imageView2, constraintLayout, constraintLayout2, relativeLayout2, editText, textView, recyclerView);
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
    public static FragVendorListLocationFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragVendorListLocationFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_vendor_list_location_filter, viewGroup, false);
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
