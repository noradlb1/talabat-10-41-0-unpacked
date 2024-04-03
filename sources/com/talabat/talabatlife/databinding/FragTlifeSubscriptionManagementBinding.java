package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatlife.R;

public final class FragTlifeSubscriptionManagementBinding implements ViewBinding {
    @NonNull
    public final ImageButton backButton;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final DefaultCardView defaultCardView;
    @NonNull
    public final ViewErrorMessageBinding errorMessageLayout;
    @NonNull
    public final TextView paymentHeader;
    @NonNull
    public final TextView planHeader;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView subscriptionHeader;
    @NonNull
    public final TextView subscriptionStatusText;
    @NonNull
    public final TextView termsAndConditionLink;
    @NonNull
    public final TextView title;
    @NonNull
    public final TextView tlifeSubscriptionContentMessage;
    @NonNull
    public final Toolbar toolbar;

    private FragTlifeSubscriptionManagementBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ConstraintLayout constraintLayout2, @NonNull DefaultCardView defaultCardView2, @NonNull ViewErrorMessageBinding viewErrorMessageBinding, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull Toolbar toolbar2) {
        this.rootView = constraintLayout;
        this.backButton = imageButton;
        this.container = constraintLayout2;
        this.defaultCardView = defaultCardView2;
        this.errorMessageLayout = viewErrorMessageBinding;
        this.paymentHeader = textView;
        this.planHeader = textView2;
        this.subscriptionHeader = textView3;
        this.subscriptionStatusText = textView4;
        this.termsAndConditionLink = textView5;
        this.title = textView6;
        this.tlifeSubscriptionContentMessage = textView7;
        this.toolbar = toolbar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.talabat.talabatlife.R.id.error_message_layout;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatlife.databinding.FragTlifeSubscriptionManagementBinding bind(@androidx.annotation.NonNull android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.talabat.talabatlife.R.id.backButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.default_card_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView r7 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView) r7
            if (r7 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.error_message_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x0092
            com.talabat.talabatlife.databinding.ViewErrorMessageBinding r8 = com.talabat.talabatlife.databinding.ViewErrorMessageBinding.bind(r2)
            int r1 = com.talabat.talabatlife.R.id.payment_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.plan_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.subscription_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.subscription_status_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.terms_and_condition_link
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.tlife_subscription_content_message
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0092
            int r1 = com.talabat.talabatlife.R.id.toolbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.appcompat.widget.Toolbar r16 = (androidx.appcompat.widget.Toolbar) r16
            if (r16 == 0) goto L_0x0092
            com.talabat.talabatlife.databinding.FragTlifeSubscriptionManagementBinding r1 = new com.talabat.talabatlife.databinding.FragTlifeSubscriptionManagementBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x0092:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.databinding.FragTlifeSubscriptionManagementBinding.bind(android.view.View):com.talabat.talabatlife.databinding.FragTlifeSubscriptionManagementBinding");
    }

    @NonNull
    public static FragTlifeSubscriptionManagementBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragTlifeSubscriptionManagementBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_tlife_subscription_management, viewGroup, false);
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
