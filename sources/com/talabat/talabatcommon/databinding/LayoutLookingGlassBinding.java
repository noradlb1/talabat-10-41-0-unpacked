package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.ramadan.RamadanView;

public final class LayoutLookingGlassBinding implements ViewBinding {
    @NonNull
    public final FrameLayout frameLayoutStatusContainer;
    @NonNull
    public final AppCompatTextView glassSubtitle;
    @NonNull
    public final AppCompatTextView glassTitle;
    @NonNull
    public final RecyclerView headlines;
    @NonNull
    public final RelativeLayout imageViewTmart;
    @NonNull
    public final ConstraintLayout layoutLookingGlassHeader;
    @NonNull
    public final ConstraintLayout layoutMain;
    @NonNull
    public final RamadanView layoutRamadanHeader;
    @NonNull
    public final LinearLayout logoContainer;
    @NonNull
    public final RecyclerView products;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView talabatDailyLogo;
    @NonNull
    public final TextView textViewStatus;
    @NonNull
    public final TalabatFillButton viewAllProductsBtn;
    @NonNull
    public final View viewSeparator;

    private LayoutLookingGlassBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull RecyclerView recyclerView, @NonNull RelativeLayout relativeLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull RamadanView ramadanView, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TalabatFillButton talabatFillButton, @NonNull View view) {
        this.rootView = constraintLayout;
        this.frameLayoutStatusContainer = frameLayout;
        this.glassSubtitle = appCompatTextView;
        this.glassTitle = appCompatTextView2;
        this.headlines = recyclerView;
        this.imageViewTmart = relativeLayout;
        this.layoutLookingGlassHeader = constraintLayout2;
        this.layoutMain = constraintLayout3;
        this.layoutRamadanHeader = ramadanView;
        this.logoContainer = linearLayout;
        this.products = recyclerView2;
        this.talabatDailyLogo = imageView;
        this.textViewStatus = textView;
        this.viewAllProductsBtn = talabatFillButton;
        this.viewSeparator = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        r1 = com.talabat.talabatcommon.R.id.view_separator;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatcommon.databinding.LayoutLookingGlassBinding bind(@androidx.annotation.NonNull android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.talabat.talabatcommon.R.id.frameLayout_statusContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.glass_subtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.appcompat.widget.AppCompatTextView r6 = (androidx.appcompat.widget.AppCompatTextView) r6
            if (r6 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.glass_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            if (r7 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.headlines
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            if (r8 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.imageView_tmart
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            if (r9 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.layout_looking_glass_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            if (r10 == 0) goto L_0x009b
            r11 = r0
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            int r1 = com.talabat.talabatcommon.R.id.layout_ramadan_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.talabat.talabatcommon.views.ramadan.RamadanView r12 = (com.talabat.talabatcommon.views.ramadan.RamadanView) r12
            if (r12 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.logo_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.products
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            if (r14 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.talabat_daily_logo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.textView_status
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.viewAllProductsBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.talabat.talabatcommon.views.TalabatFillButton r17 = (com.talabat.talabatcommon.views.TalabatFillButton) r17
            if (r17 == 0) goto L_0x009b
            int r1 = com.talabat.talabatcommon.R.id.view_separator
            android.view.View r18 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r18 == 0) goto L_0x009b
            com.talabat.talabatcommon.databinding.LayoutLookingGlassBinding r0 = new com.talabat.talabatcommon.databinding.LayoutLookingGlassBinding
            r3 = r0
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x009b:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.databinding.LayoutLookingGlassBinding.bind(android.view.View):com.talabat.talabatcommon.databinding.LayoutLookingGlassBinding");
    }

    @NonNull
    public static LayoutLookingGlassBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutLookingGlassBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_looking_glass, viewGroup, false);
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
