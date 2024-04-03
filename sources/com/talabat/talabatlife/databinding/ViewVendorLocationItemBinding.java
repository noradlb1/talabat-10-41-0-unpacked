package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatlife.R;

public final class ViewVendorLocationItemBinding implements ViewBinding {
    @NonNull
    public final TextView areaName;
    @NonNull
    public final TextView cityName;
    @NonNull
    public final View divider;
    @NonNull
    public final ImageView locationIcon;
    @NonNull
    public final CheckBox locationSelected;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewVendorLocationItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view, @NonNull ImageView imageView, @NonNull CheckBox checkBox) {
        this.rootView = constraintLayout;
        this.areaName = textView;
        this.cityName = textView2;
        this.divider = view;
        this.locationIcon = imageView;
        this.locationSelected = checkBox;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.talabat.talabatlife.R.id.divider;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatlife.databinding.ViewVendorLocationItemBinding bind(@androidx.annotation.NonNull android.view.View r9) {
        /*
            int r0 = com.talabat.talabatlife.R.id.area_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x003e
            int r0 = com.talabat.talabatlife.R.id.city_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x003e
            int r0 = com.talabat.talabatlife.R.id.divider
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r6 == 0) goto L_0x003e
            int r0 = com.talabat.talabatlife.R.id.location_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x003e
            int r0 = com.talabat.talabatlife.R.id.location_selected
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.CheckBox r8 = (android.widget.CheckBox) r8
            if (r8 == 0) goto L_0x003e
            com.talabat.talabatlife.databinding.ViewVendorLocationItemBinding r0 = new com.talabat.talabatlife.databinding.ViewVendorLocationItemBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003e:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.databinding.ViewVendorLocationItemBinding.bind(android.view.View):com.talabat.talabatlife.databinding.ViewVendorLocationItemBinding");
    }

    @NonNull
    public static ViewVendorLocationItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewVendorLocationItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_vendor_location_item, viewGroup, false);
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
