package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;

public final class FragmentSuccessBottomSheetBinding implements ViewBinding {
    @NonNull
    public final TextView congratulations;
    @NonNull
    public final ConstraintLayout emptyView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ViewPaymentSuccessBottomSheetBinding successLayout;
    @NonNull
    public final TextView tlifeFirstMessage;
    @NonNull
    public final TextView tlifeSecondMessage;

    private FragmentSuccessBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull ViewPaymentSuccessBottomSheetBinding viewPaymentSuccessBottomSheetBinding, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.congratulations = textView;
        this.emptyView = constraintLayout2;
        this.successLayout = viewPaymentSuccessBottomSheetBinding;
        this.tlifeFirstMessage = textView2;
        this.tlifeSecondMessage = textView3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.talabat.talabatcommon.R.id.success_layout;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatcommon.databinding.FragmentSuccessBottomSheetBinding bind(@androidx.annotation.NonNull android.view.View r9) {
        /*
            int r0 = com.talabat.talabatcommon.R.id.congratulations
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0042
            int r0 = com.talabat.talabatcommon.R.id.empty_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0042
            int r0 = com.talabat.talabatcommon.R.id.success_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r1 == 0) goto L_0x0042
            com.talabat.talabatcommon.databinding.ViewPaymentSuccessBottomSheetBinding r6 = com.talabat.talabatcommon.databinding.ViewPaymentSuccessBottomSheetBinding.bind(r1)
            int r0 = com.talabat.talabatcommon.R.id.tlife_first_message
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0042
            int r0 = com.talabat.talabatcommon.R.id.tlife_second_message
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0042
            com.talabat.talabatcommon.databinding.FragmentSuccessBottomSheetBinding r0 = new com.talabat.talabatcommon.databinding.FragmentSuccessBottomSheetBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0042:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.databinding.FragmentSuccessBottomSheetBinding.bind(android.view.View):com.talabat.talabatcommon.databinding.FragmentSuccessBottomSheetBinding");
    }

    @NonNull
    public static FragmentSuccessBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentSuccessBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_success_bottom_sheet, viewGroup, false);
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
