package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresProductTileNewPlaceholderBinding implements ViewBinding {
    @NonNull
    public final View placeholderImage;
    @NonNull
    public final View placeholderSubtitle;
    @NonNull
    public final View placeholderTitle;
    @NonNull
    private final ConstraintLayout rootView;

    private DarkstoresProductTileNewPlaceholderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull View view3) {
        this.rootView = constraintLayout;
        this.placeholderImage = view;
        this.placeholderSubtitle = view2;
        this.placeholderTitle = view3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.talabat.darkstores.R.id.placeholder_subtitle;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = com.talabat.darkstores.R.id.placeholder_title;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresProductTileNewPlaceholderBinding bind(@androidx.annotation.NonNull android.view.View r4) {
        /*
            int r0 = com.talabat.darkstores.R.id.placeholder_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r1 == 0) goto L_0x0020
            int r0 = com.talabat.darkstores.R.id.placeholder_subtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r2 == 0) goto L_0x0020
            int r0 = com.talabat.darkstores.R.id.placeholder_title
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r3 == 0) goto L_0x0020
            com.talabat.darkstores.databinding.DarkstoresProductTileNewPlaceholderBinding r0 = new com.talabat.darkstores.databinding.DarkstoresProductTileNewPlaceholderBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0020:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresProductTileNewPlaceholderBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresProductTileNewPlaceholderBinding");
    }

    @NonNull
    public static DarkstoresProductTileNewPlaceholderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresProductTileNewPlaceholderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_product_tile_new_placeholder, viewGroup, false);
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
