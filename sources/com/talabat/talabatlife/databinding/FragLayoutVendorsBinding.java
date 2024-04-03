package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.talabat.talabatcommon.databinding.ViewEmptyRestaurantSearchResultBinding;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.cuisine.TDineCuisineButton;

public final class FragLayoutVendorsBinding implements ViewBinding {
    @NonNull
    public final Toolbar animToolbar;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final TextView cancelBtn;
    @NonNull
    public final ImageView clearBtn;
    @NonNull
    public final TDineCuisineButton cuisineButton;
    @NonNull
    public final LinearLayout filtersContainer;
    @NonNull
    public final TextView getHelpButton;
    @NonNull
    public final CardView loyaltyWidgetContainer;
    @NonNull
    public final ImageView loyaltyWidgetImageView;
    @NonNull
    public final ImageButton offersBackButton;
    @NonNull
    public final Button offersFilterButton;
    @NonNull
    public final RelativeLayout relativeLayout;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final EditText searchEdt;
    @NonNull
    public final ViewEmptyRestaurantSearchResultBinding searchEmptyView;
    @NonNull
    public final RecyclerView tLifeOffersRecyclerView;
    @NonNull
    public final LinearLayout vendorsListSearchLinearLayout;

    private FragLayoutVendorsBinding(@NonNull LinearLayout linearLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout2, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TDineCuisineButton tDineCuisineButton, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull CardView cardView, @NonNull ImageView imageView2, @NonNull ImageButton imageButton, @NonNull Button button, @NonNull RelativeLayout relativeLayout2, @NonNull EditText editText, @NonNull ViewEmptyRestaurantSearchResultBinding viewEmptyRestaurantSearchResultBinding, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.animToolbar = toolbar;
        this.appBarLayout = appBarLayout2;
        this.cancelBtn = textView;
        this.clearBtn = imageView;
        this.cuisineButton = tDineCuisineButton;
        this.filtersContainer = linearLayout2;
        this.getHelpButton = textView2;
        this.loyaltyWidgetContainer = cardView;
        this.loyaltyWidgetImageView = imageView2;
        this.offersBackButton = imageButton;
        this.offersFilterButton = button;
        this.relativeLayout = relativeLayout2;
        this.searchEdt = editText;
        this.searchEmptyView = viewEmptyRestaurantSearchResultBinding;
        this.tLifeOffersRecyclerView = recyclerView;
        this.vendorsListSearchLinearLayout = linearLayout3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r1 = com.talabat.talabatlife.R.id.searchEmptyView;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatlife.databinding.FragLayoutVendorsBinding bind(@androidx.annotation.NonNull android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.talabat.talabatlife.R.id.anim_toolbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.appcompat.widget.Toolbar r5 = (androidx.appcompat.widget.Toolbar) r5
            if (r5 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.app_bar_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.google.android.material.appbar.AppBarLayout r6 = (com.google.android.material.appbar.AppBarLayout) r6
            if (r6 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.cancelBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.clearBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.cuisineButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.talabat.talabatlife.ui.cuisine.TDineCuisineButton r9 = (com.talabat.talabatlife.ui.cuisine.TDineCuisineButton) r9
            if (r9 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.filtersContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.getHelpButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.loyaltyWidgetContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.cardview.widget.CardView r12 = (androidx.cardview.widget.CardView) r12
            if (r12 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.loyaltyWidgetImageView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.offersBackButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageButton r14 = (android.widget.ImageButton) r14
            if (r14 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.offersFilterButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.Button r15 = (android.widget.Button) r15
            if (r15 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.relativeLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.RelativeLayout r16 = (android.widget.RelativeLayout) r16
            if (r16 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.searchEdt
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.EditText r17 = (android.widget.EditText) r17
            if (r17 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.searchEmptyView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00c1
            com.talabat.talabatcommon.databinding.ViewEmptyRestaurantSearchResultBinding r18 = com.talabat.talabatcommon.databinding.ViewEmptyRestaurantSearchResultBinding.bind(r2)
            int r1 = com.talabat.talabatlife.R.id.tLifeOffersRecyclerView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            androidx.recyclerview.widget.RecyclerView r19 = (androidx.recyclerview.widget.RecyclerView) r19
            if (r19 == 0) goto L_0x00c1
            int r1 = com.talabat.talabatlife.R.id.vendorsListSearchLinearLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.LinearLayout r20 = (android.widget.LinearLayout) r20
            if (r20 == 0) goto L_0x00c1
            com.talabat.talabatlife.databinding.FragLayoutVendorsBinding r1 = new com.talabat.talabatlife.databinding.FragLayoutVendorsBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x00c1:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.databinding.FragLayoutVendorsBinding.bind(android.view.View):com.talabat.talabatlife.databinding.FragLayoutVendorsBinding");
    }

    @NonNull
    public static FragLayoutVendorsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragLayoutVendorsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_layout_vendors, viewGroup, false);
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
