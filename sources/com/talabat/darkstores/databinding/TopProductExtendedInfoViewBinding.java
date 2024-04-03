package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.product.views.ProductExtendedInfoView;

public final class TopProductExtendedInfoViewBinding implements ViewBinding {
    @NonNull
    public final ProductExtendedInfoView productExtendedInfo;
    @NonNull
    private final View rootView;
    @NonNull
    public final View topExtendedInfoBackground;

    private TopProductExtendedInfoViewBinding(@NonNull View view, @NonNull ProductExtendedInfoView productExtendedInfoView, @NonNull View view2) {
        this.rootView = view;
        this.productExtendedInfo = productExtendedInfoView;
        this.topExtendedInfoBackground = view2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.talabat.darkstores.R.id.topExtendedInfoBackground;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.TopProductExtendedInfoViewBinding bind(@androidx.annotation.NonNull android.view.View r3) {
        /*
            int r0 = com.talabat.darkstores.R.id.productExtendedInfo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.talabat.darkstores.feature.product.views.ProductExtendedInfoView r1 = (com.talabat.darkstores.feature.product.views.ProductExtendedInfoView) r1
            if (r1 == 0) goto L_0x0018
            int r0 = com.talabat.darkstores.R.id.topExtendedInfoBackground
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            if (r2 == 0) goto L_0x0018
            com.talabat.darkstores.databinding.TopProductExtendedInfoViewBinding r0 = new com.talabat.darkstores.databinding.TopProductExtendedInfoViewBinding
            r0.<init>(r3, r1, r2)
            return r0
        L_0x0018:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.TopProductExtendedInfoViewBinding.bind(android.view.View):com.talabat.darkstores.databinding.TopProductExtendedInfoViewBinding");
    }

    @NonNull
    public static TopProductExtendedInfoViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.top_product_extended_info_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
