package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class DialogFeesDescriptionBottomSheetBinding implements ViewBinding {
    @NonNull
    public final ImageView closeButton;
    @NonNull
    public final TextView descriptionText;
    @NonNull
    public final TalabatFillButton gotItButton;
    @NonNull
    public final View headerBackground;
    @NonNull
    public final ImageView headerImage;
    @NonNull
    public final TextView headerText;
    @NonNull
    public final TalabatStrokeButton readMoreButton;
    @NonNull
    private final LinearLayout rootView;

    private DialogFeesDescriptionBottomSheetBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TalabatFillButton talabatFillButton, @NonNull View view, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TalabatStrokeButton talabatStrokeButton) {
        this.rootView = linearLayout;
        this.closeButton = imageView;
        this.descriptionText = textView;
        this.gotItButton = talabatFillButton;
        this.headerBackground = view;
        this.headerImage = imageView2;
        this.headerText = textView2;
        this.readMoreButton = talabatStrokeButton;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.talabat.talabatcommon.R.id.header_background;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatcommon.databinding.DialogFeesDescriptionBottomSheetBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.talabatcommon.R.id.close_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0054
            int r0 = com.talabat.talabatcommon.R.id.description_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0054
            int r0 = com.talabat.talabatcommon.R.id.got_it_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            com.talabat.talabatcommon.views.TalabatFillButton r6 = (com.talabat.talabatcommon.views.TalabatFillButton) r6
            if (r6 == 0) goto L_0x0054
            int r0 = com.talabat.talabatcommon.R.id.header_background
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r7 == 0) goto L_0x0054
            int r0 = com.talabat.talabatcommon.R.id.header_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0054
            int r0 = com.talabat.talabatcommon.R.id.header_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0054
            int r0 = com.talabat.talabatcommon.R.id.read_more_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            com.talabat.talabatcommon.views.TalabatStrokeButton r10 = (com.talabat.talabatcommon.views.TalabatStrokeButton) r10
            if (r10 == 0) goto L_0x0054
            com.talabat.talabatcommon.databinding.DialogFeesDescriptionBottomSheetBinding r0 = new com.talabat.talabatcommon.databinding.DialogFeesDescriptionBottomSheetBinding
            r3 = r11
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0054:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.databinding.DialogFeesDescriptionBottomSheetBinding.bind(android.view.View):com.talabat.talabatcommon.databinding.DialogFeesDescriptionBottomSheetBinding");
    }

    @NonNull
    public static DialogFeesDescriptionBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogFeesDescriptionBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.dialog_fees_description_bottom_sheet, viewGroup, false);
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
