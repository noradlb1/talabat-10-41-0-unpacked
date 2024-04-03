package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresSearchCategoryPlaceholderBinding implements ViewBinding {
    @NonNull
    public final View placeholderImageFirst;
    @NonNull
    public final View placeholderImageFour;
    @NonNull
    public final View placeholderImageThree;
    @NonNull
    public final View placeholderImageTwo;
    @NonNull
    public final View placeholderTitleFirst;
    @NonNull
    public final View placeholderTitleFour;
    @NonNull
    public final View placeholderTitleThree;
    @NonNull
    public final View placeholderTitleTwo;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresSearchCategoryPlaceholderBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull View view4, @NonNull View view5, @NonNull View view6, @NonNull View view7, @NonNull View view8) {
        this.rootView = linearLayout;
        this.placeholderImageFirst = view;
        this.placeholderImageFour = view2;
        this.placeholderImageThree = view3;
        this.placeholderImageTwo = view4;
        this.placeholderTitleFirst = view5;
        this.placeholderTitleFour = view6;
        this.placeholderTitleThree = view7;
        this.placeholderTitleTwo = view8;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        r0 = com.talabat.darkstores.R.id.placeholder_title_four;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r0 = com.talabat.darkstores.R.id.placeholder_title_three;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        r0 = com.talabat.darkstores.R.id.placeholder_title_two;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.talabat.darkstores.R.id.placeholder_image_four;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = com.talabat.darkstores.R.id.placeholder_image_three;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r0 = com.talabat.darkstores.R.id.placeholder_image_two;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r0 = com.talabat.darkstores.R.id.placeholder_title_first;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresSearchCategoryPlaceholderBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.darkstores.R.id.placeholder_image_first
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r3 == 0) goto L_0x004a
            int r0 = com.talabat.darkstores.R.id.placeholder_image_four
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r4 == 0) goto L_0x004a
            int r0 = com.talabat.darkstores.R.id.placeholder_image_three
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r5 == 0) goto L_0x004a
            int r0 = com.talabat.darkstores.R.id.placeholder_image_two
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r6 == 0) goto L_0x004a
            int r0 = com.talabat.darkstores.R.id.placeholder_title_first
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r7 == 0) goto L_0x004a
            int r0 = com.talabat.darkstores.R.id.placeholder_title_four
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r8 == 0) goto L_0x004a
            int r0 = com.talabat.darkstores.R.id.placeholder_title_three
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r9 == 0) goto L_0x004a
            int r0 = com.talabat.darkstores.R.id.placeholder_title_two
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r10 == 0) goto L_0x004a
            com.talabat.darkstores.databinding.DarkstoresSearchCategoryPlaceholderBinding r0 = new com.talabat.darkstores.databinding.DarkstoresSearchCategoryPlaceholderBinding
            r2 = r11
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x004a:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresSearchCategoryPlaceholderBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresSearchCategoryPlaceholderBinding");
    }

    @NonNull
    public static DarkstoresSearchCategoryPlaceholderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresSearchCategoryPlaceholderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_search_category_placeholder, viewGroup, false);
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
