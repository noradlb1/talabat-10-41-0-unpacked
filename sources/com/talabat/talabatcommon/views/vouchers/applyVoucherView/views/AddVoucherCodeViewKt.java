package com.talabat.talabatcommon.views.vouchers.applyVoucherView.views;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DISABLED_ALPHA_RATIO", "", "ENABLED_ALPHA_RATIO", "hideKeyboard", "", "Landroid/content/Context;", "view", "Landroid/view/View;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AddVoucherCodeViewKt {
    private static final float DISABLED_ALPHA_RATIO = 0.4f;
    private static final float ENABLED_ALPHA_RATIO = 1.0f;

    /* access modifiers changed from: private */
    public static final void hideKeyboard(Context context, View view) {
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
