package com.talabat.talabatcommon.views.checkoutForceCVV.view;

import android.text.TextWatcher;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"com/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVFragment$addSecurityCodeListener$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "start", "removed", "added", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutForceCVVFragment$addSecurityCodeListener$1 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckoutForceCVVFragment f11714b;

    public CheckoutForceCVVFragment$addSecurityCodeListener$1(CheckoutForceCVVFragment checkoutForceCVVFragment) {
        this.f11714b = checkoutForceCVVFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r2.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable r2) {
        /*
            r1 = this;
            com.talabat.talabatcommon.views.checkoutForceCVV.view.CheckoutForceCVVFragment r0 = r1.f11714b
            if (r2 == 0) goto L_0x0013
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x0013
            int r2 = r2.length()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            int r2 = com.talabat.talabatcommon.extentions.IntKt.orZero((java.lang.Integer) r2)
            r0.updatePayButtonStatus(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.checkoutForceCVV.view.CheckoutForceCVVFragment$addSecurityCodeListener$1.afterTextChanged(android.text.Editable):void");
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }
}
