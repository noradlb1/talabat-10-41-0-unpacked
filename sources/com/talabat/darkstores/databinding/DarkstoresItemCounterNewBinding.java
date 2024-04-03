package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresItemCounterNewBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView itemCounterNewAdd;
    @NonNull
    public final TextView itemCounterNewQuantity;
    @NonNull
    public final AppCompatImageView itemCounterNewRemove;
    @NonNull
    public final LinearLayout llCounter;
    @NonNull
    public final View overlayView;
    @NonNull
    private final View rootView;

    private DarkstoresItemCounterNewBinding(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull AppCompatImageView appCompatImageView2, @NonNull LinearLayout linearLayout, @NonNull View view2) {
        this.rootView = view;
        this.itemCounterNewAdd = appCompatImageView;
        this.itemCounterNewQuantity = textView;
        this.itemCounterNewRemove = appCompatImageView2;
        this.llCounter = linearLayout;
        this.overlayView = view2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.talabat.darkstores.R.id.overlayView;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresItemCounterNewBinding bind(@androidx.annotation.NonNull android.view.View r9) {
        /*
            int r0 = com.talabat.darkstores.R.id.item_counter_new_add
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            if (r4 == 0) goto L_0x003c
            int r0 = com.talabat.darkstores.R.id.item_counter_new_quantity
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x003c
            int r0 = com.talabat.darkstores.R.id.item_counter_new_remove
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            if (r6 == 0) goto L_0x003c
            int r0 = com.talabat.darkstores.R.id.llCounter
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x003c
            int r0 = com.talabat.darkstores.R.id.overlayView
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r8 == 0) goto L_0x003c
            com.talabat.darkstores.databinding.DarkstoresItemCounterNewBinding r0 = new com.talabat.darkstores.databinding.DarkstoresItemCounterNewBinding
            r2 = r0
            r3 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003c:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresItemCounterNewBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresItemCounterNewBinding");
    }

    @NonNull
    public static DarkstoresItemCounterNewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_item_counter_new, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
