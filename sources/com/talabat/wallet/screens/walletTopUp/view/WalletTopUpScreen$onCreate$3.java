package com.talabat.wallet.screens.walletTopUp.view;

import android.text.TextWatcher;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"com/talabat/wallet/screens/walletTopUp/view/WalletTopUpScreen$onCreate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "start", "removed", "added", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpScreen$onCreate$3 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletTopUpScreen f12704b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12705c;

    public WalletTopUpScreen$onCreate$3(WalletTopUpScreen walletTopUpScreen, String str) {
        this.f12704b = walletTopUpScreen;
        this.f12705c = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[Catch:{ Exception -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[Catch:{ Exception -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0166 A[Catch:{ Exception -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b4 A[Catch:{ Exception -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable r13) {
        /*
            r12 = this;
            r0 = 1
            r1 = 2132020496(0x7f140d10, float:1.9679357E38)
            r2 = 0
            r3 = 2
            r4 = 0
            if (r13 == 0) goto L_0x0018
            java.lang.String r5 = r13.toString()     // Catch:{ Exception -> 0x01d0 }
            if (r5 == 0) goto L_0x0018
            java.lang.CharSequence r5 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r5)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01d0 }
            goto L_0x0019
        L_0x0018:
            r5 = r4
        L_0x0019:
            if (r13 == 0) goto L_0x002a
            java.lang.CharSequence r6 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r13)     // Catch:{ Exception -> 0x01d0 }
            if (r6 == 0) goto L_0x002a
            int r6 = r6.length()     // Catch:{ Exception -> 0x01d0 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x002b
        L_0x002a:
            r6 = r4
        L_0x002b:
            if (r6 == 0) goto L_0x0178
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x01d0 }
            if (r6 <= 0) goto L_0x0178
            if (r5 == 0) goto L_0x0178
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r6 = r6.ZERO_STRING     // Catch:{ Exception -> 0x01d0 }
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r5, r6, r2, r3, r4)     // Catch:{ Exception -> 0x01d0 }
            if (r6 == 0) goto L_0x004b
            if (r13 == 0) goto L_0x0046
            r13.clear()     // Catch:{ Exception -> 0x01d0 }
        L_0x0046:
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            r6.disableTopUpButton()     // Catch:{ Exception -> 0x01d0 }
        L_0x004b:
            java.lang.Float r6 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r5)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r7 = "buttons"
            r8 = 0
            if (r6 == 0) goto L_0x00f6
            java.lang.Float r6 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r5)     // Catch:{ Exception -> 0x01d0 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ Exception -> 0x01d0 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x01d0 }
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00f6
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.presenter.WalletTopUpPresenter r6 = r6.mWalletTopUpPresenter     // Catch:{ Exception -> 0x01d0 }
            if (r6 == 0) goto L_0x0082
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r8 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            int r8 = r8.eventType     // Catch:{ Exception -> 0x01d0 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r9 = r12.f12705c     // Catch:{ Exception -> 0x01d0 }
            if (r9 == 0) goto L_0x007e
            java.lang.Integer r9 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r9)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x007f
        L_0x007e:
            r9 = r4
        L_0x007f:
            r6.getWalletCalculatedCashBack(r5, r8, r9)     // Catch:{ Exception -> 0x01d0 }
        L_0x0082:
            boolean r6 = com.talabat.helpers.TalabatUtils.isArabic()     // Catch:{ Exception -> 0x01d0 }
            r8 = 2132020195(0x7f140be3, float:1.9678746E38)
            java.lang.String r9 = " "
            if (r6 == 0) goto L_0x00bf
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            int r10 = com.talabat.R.id.submit_top_up_button     // Catch:{ Exception -> 0x01d0 }
            android.view.View r6 = r6._$_findCachedViewById(r10)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.talabatcommon.views.TalabatFillButton r6 = (com.talabat.talabatcommon.views.TalabatFillButton) r6     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r10 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r10.getString(r8)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r10 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r10 = r10.amountCurrency     // Catch:{ Exception -> 0x01d0 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d0 }
            r11.<init>()     // Catch:{ Exception -> 0x01d0 }
            r11.append(r8)     // Catch:{ Exception -> 0x01d0 }
            r11.append(r9)     // Catch:{ Exception -> 0x01d0 }
            r11.append(r5)     // Catch:{ Exception -> 0x01d0 }
            r11.append(r9)     // Catch:{ Exception -> 0x01d0 }
            r11.append(r10)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x01d0 }
            r6.setText(r8)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x00f0
        L_0x00bf:
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            int r10 = com.talabat.R.id.submit_top_up_button     // Catch:{ Exception -> 0x01d0 }
            android.view.View r6 = r6._$_findCachedViewById(r10)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.talabatcommon.views.TalabatFillButton r6 = (com.talabat.talabatcommon.views.TalabatFillButton) r6     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r10 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r10.getString(r8)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r10 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r10 = r10.amountCurrency     // Catch:{ Exception -> 0x01d0 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d0 }
            r11.<init>()     // Catch:{ Exception -> 0x01d0 }
            r11.append(r8)     // Catch:{ Exception -> 0x01d0 }
            r11.append(r9)     // Catch:{ Exception -> 0x01d0 }
            r11.append(r10)     // Catch:{ Exception -> 0x01d0 }
            r11.append(r9)     // Catch:{ Exception -> 0x01d0 }
            r11.append(r5)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x01d0 }
            r6.setText(r8)     // Catch:{ Exception -> 0x01d0 }
        L_0x00f0:
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            r6.enableTopUpButton()     // Catch:{ Exception -> 0x01d0 }
            goto L_0x015a
        L_0x00f6:
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            int r9 = com.talabat.R.id.cash_back_label     // Catch:{ Exception -> 0x01d0 }
            android.view.View r6 = r6._$_findCachedViewById(r9)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.TalabatTextView r6 = (com.talabat.TalabatTextView) r6     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r9 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            android.content.res.Resources r9 = r9.getResources()     // Catch:{ Exception -> 0x01d0 }
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r11 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r11 = r11.amountCurrency     // Catch:{ Exception -> 0x01d0 }
            r10[r2] = r11     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r11 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.lang.Float r8 = java.lang.Float.valueOf(r8)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r11.getAmountWithoutCurrency(r8)     // Catch:{ Exception -> 0x01d0 }
            r10[r0] = r8     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r9.getString(r1, r10)     // Catch:{ Exception -> 0x01d0 }
            r6.setText(r8)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            int r8 = com.talabat.R.id.submit_top_up_button     // Catch:{ Exception -> 0x01d0 }
            android.view.View r6 = r6._$_findCachedViewById(r8)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.talabatcommon.views.TalabatFillButton r6 = (com.talabat.talabatcommon.views.TalabatFillButton) r6     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r8 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            r9 = 2132020189(0x7f140bdd, float:1.9678734E38)
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x01d0 }
            r6.setText(r8)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            int r8 = com.talabat.R.id.top_up_amount     // Catch:{ Exception -> 0x01d0 }
            android.view.View r6 = r6._$_findCachedViewById(r8)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.TalabatEditText r6 = (com.talabat.TalabatEditText) r6     // Catch:{ Exception -> 0x01d0 }
            r6.requestFocus()     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            r6.disableTopUpButton()     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.util.ArrayList r8 = r6.buttons     // Catch:{ Exception -> 0x01d0 }
            if (r8 != 0) goto L_0x0157
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)     // Catch:{ Exception -> 0x01d0 }
            r8 = r4
        L_0x0157:
            r6.resetAllButtons(r8)     // Catch:{ Exception -> 0x01d0 }
        L_0x015a:
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.util.HashMap r6 = r6.amountCashBackMap     // Catch:{ Exception -> 0x01d0 }
            boolean r5 = r6.containsKey(r5)     // Catch:{ Exception -> 0x01d0 }
            if (r5 != 0) goto L_0x01ff
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r5 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.util.ArrayList r6 = r5.buttons     // Catch:{ Exception -> 0x01d0 }
            if (r6 != 0) goto L_0x0172
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x0173
        L_0x0172:
            r4 = r6
        L_0x0173:
            r5.resetAllButtons(r4)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ff
        L_0x0178:
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r5 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            int r6 = com.talabat.R.id.cash_back_label     // Catch:{ Exception -> 0x01d0 }
            android.view.View r5 = r5._$_findCachedViewById(r6)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.TalabatTextView r5 = (com.talabat.TalabatTextView) r5     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x01d0 }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r8 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r8.amountCurrency     // Catch:{ Exception -> 0x01d0 }
            r7[r2] = r8     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r8 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            r9 = 1092616192(0x41200000, float:10.0)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r8.getAmountWithoutCurrency(r9)     // Catch:{ Exception -> 0x01d0 }
            r7[r0] = r8     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r6 = r6.getString(r1, r7)     // Catch:{ Exception -> 0x01d0 }
            r5.setText(r6)     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r5 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            r5.disableTopUpButton()     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r5 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.presenter.WalletTopUpPresenter r5 = r5.mWalletTopUpPresenter     // Catch:{ Exception -> 0x01d0 }
            if (r5 == 0) goto L_0x01ff
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r6 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r6 = r6.getEMPTY_STRING()     // Catch:{ Exception -> 0x01d0 }
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r7 = r12.f12704b     // Catch:{ Exception -> 0x01d0 }
            int r7 = r7.eventType     // Catch:{ Exception -> 0x01d0 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r12.f12705c     // Catch:{ Exception -> 0x01d0 }
            if (r8 == 0) goto L_0x01cc
            java.lang.Integer r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r8)     // Catch:{ Exception -> 0x01d0 }
        L_0x01cc:
            r5.getWalletCalculatedCashBack(r6, r7, r4)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ff
        L_0x01d0:
            if (r13 == 0) goto L_0x01d5
            r13.clear()
        L_0x01d5:
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r13 = r12.f12704b
            int r4 = com.talabat.R.id.cash_back_label
            android.view.View r13 = r13._$_findCachedViewById(r4)
            com.talabat.TalabatTextView r13 = (com.talabat.TalabatTextView) r13
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r4 = r12.f12704b
            android.content.res.Resources r4 = r4.getResources()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r5 = r12.f12704b
            java.lang.String r5 = r5.amountCurrency
            r3[r2] = r5
            java.lang.String r2 = "10.0"
            r3[r0] = r2
            java.lang.String r0 = r4.getString(r1, r3)
            r13.setText(r0)
            com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen r13 = r12.f12704b
            r13.disableTopUpButton()
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen$onCreate$3.afterTextChanged(android.text.Editable):void");
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }
}
