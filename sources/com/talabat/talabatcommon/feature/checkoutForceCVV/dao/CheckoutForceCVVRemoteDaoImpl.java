package com.talabat.talabatcommon.feature.checkoutForceCVV.dao;

import com.talabat.talabatcommon.feature.checkoutForceCVV.network.CheckoutForceCVVApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/checkoutForceCVV/dao/CheckoutForceCVVRemoteDaoImpl;", "Lcom/talabat/talabatcommon/feature/checkoutForceCVV/dao/CheckoutForceCVVRemoteDao;", "checkoutForceCVVApi", "Lcom/talabat/talabatcommon/feature/checkoutForceCVV/network/CheckoutForceCVVApi;", "(Lcom/talabat/talabatcommon/feature/checkoutForceCVV/network/CheckoutForceCVVApi;)V", "getCheckoutCVVPopUpStatus", "", "binNumber", "", "orderAmount", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutForceCVVRemoteDaoImpl implements CheckoutForceCVVRemoteDao {
    @NotNull
    private final CheckoutForceCVVApi checkoutForceCVVApi;

    public CheckoutForceCVVRemoteDaoImpl(@NotNull CheckoutForceCVVApi checkoutForceCVVApi2) {
        Intrinsics.checkNotNullParameter(checkoutForceCVVApi2, "checkoutForceCVVApi");
        this.checkoutForceCVVApi = checkoutForceCVVApi2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getCheckoutCVVPopUpStatus(@org.jetbrains.annotations.NotNull java.lang.String r11, float r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.talabat.talabatcommon.feature.checkoutForceCVV.dao.CheckoutForceCVVRemoteDaoImpl$getCheckoutCVVPopUpStatus$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.talabat.talabatcommon.feature.checkoutForceCVV.dao.CheckoutForceCVVRemoteDaoImpl$getCheckoutCVVPopUpStatus$1 r0 = (com.talabat.talabatcommon.feature.checkoutForceCVV.dao.CheckoutForceCVVRemoteDaoImpl$getCheckoutCVVPopUpStatus$1) r0
            int r1 = r0.f61546j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61546j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.checkoutForceCVV.dao.CheckoutForceCVVRemoteDaoImpl$getCheckoutCVVPopUpStatus$1 r0 = new com.talabat.talabatcommon.feature.checkoutForceCVV.dao.CheckoutForceCVVRemoteDaoImpl$getCheckoutCVVPopUpStatus$1
            r0.<init>(r10, r13)
        L_0x0018:
            r7 = r0
            java.lang.Object r13 = r7.f61544h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f61546j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0049
        L_0x002a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            com.talabat.talabatcommon.feature.checkoutForceCVV.network.CheckoutForceCVVApi r1 = r10.checkoutForceCVVApi
            r13 = 0
            r4 = 0
            r6 = 0
            r8 = 21
            r9 = 0
            r7.f61546j = r2
            r2 = r13
            r3 = r11
            r5 = r12
            java.lang.Object r13 = com.talabat.talabatcommon.feature.checkoutForceCVV.network.CheckoutForceCVVApi.DefaultImpls.getCanRefundToBankStatus$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r13 != r0) goto L_0x0049
            return r0
        L_0x0049:
            com.talabat.talabatcommon.feature.checkoutForceCVV.model.CheckoutCVVPopUpResponse r13 = (com.talabat.talabatcommon.feature.checkoutForceCVV.model.CheckoutCVVPopUpResponse) r13
            com.talabat.talabatcommon.feature.checkoutForceCVV.model.CheckoutCVVPopUpResult r11 = r13.getResult()
            if (r11 == 0) goto L_0x005c
            java.lang.Boolean r11 = r11.getCanShowCvv()
            if (r11 == 0) goto L_0x005c
            boolean r11 = r11.booleanValue()
            goto L_0x005d
        L_0x005c:
            r11 = 0
        L_0x005d:
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.checkoutForceCVV.dao.CheckoutForceCVVRemoteDaoImpl.getCheckoutCVVPopUpStatus(java.lang.String, float, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
