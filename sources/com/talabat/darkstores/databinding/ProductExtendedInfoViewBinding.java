package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class ProductExtendedInfoViewBinding implements ViewBinding {
    @NonNull
    public final View contentUnitDivider;
    @NonNull
    public final ImageView imgCountry;
    @NonNull
    public final ImageView infoIcon;
    @NonNull
    public final LinearLayout llContentUnit;
    @NonNull
    public final LinearLayout llCountry;
    @NonNull
    public final LinearLayout llShelfLife;
    @NonNull
    public final LinearLayout llStoredAt;
    @NonNull
    private final View rootView;
    @NonNull
    public final View shelfLifeDivider;
    @NonNull
    public final View storedAtDivider;
    @NonNull
    public final TextView txtContentUnit;
    @NonNull
    public final TextView txtCountry;
    @NonNull
    public final TextView txtShelfLife;
    @NonNull
    public final TextView txtStoredAt;

    private ProductExtendedInfoViewBinding(@NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull View view3, @NonNull View view4, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = view;
        this.contentUnitDivider = view2;
        this.imgCountry = imageView;
        this.infoIcon = imageView2;
        this.llContentUnit = linearLayout;
        this.llCountry = linearLayout2;
        this.llShelfLife = linearLayout3;
        this.llStoredAt = linearLayout4;
        this.shelfLifeDivider = view3;
        this.storedAtDivider = view4;
        this.txtContentUnit = textView;
        this.txtCountry = textView2;
        this.txtShelfLife = textView3;
        this.txtStoredAt = textView4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r0 = com.talabat.darkstores.R.id.shelfLifeDivider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r0 = com.talabat.darkstores.R.id.storedAtDivider;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.ProductExtendedInfoViewBinding bind(@androidx.annotation.NonNull android.view.View r16) {
        /*
            r1 = r16
            int r0 = com.talabat.darkstores.R.id.contentUnitDivider
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            if (r2 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.imgCountry
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            if (r3 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.infoIcon
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.llContentUnit
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.llCountry
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.llShelfLife
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.llStoredAt
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.shelfLifeDivider
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            if (r9 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.storedAtDivider
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            if (r10 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.txtContentUnit
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.txtCountry
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.txtShelfLife
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0087
            int r0 = com.talabat.darkstores.R.id.txtStoredAt
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0087
            com.talabat.darkstores.databinding.ProductExtendedInfoViewBinding r15 = new com.talabat.darkstores.databinding.ProductExtendedInfoViewBinding
            r0 = r15
            r1 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r15
        L_0x0087:
            android.content.res.Resources r1 = r16.getResources()
            java.lang.String r0 = r1.getResourceName(r0)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.ProductExtendedInfoViewBinding.bind(android.view.View):com.talabat.darkstores.databinding.ProductExtendedInfoViewBinding");
    }

    @NonNull
    public static ProductExtendedInfoViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.product_extended_info_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
