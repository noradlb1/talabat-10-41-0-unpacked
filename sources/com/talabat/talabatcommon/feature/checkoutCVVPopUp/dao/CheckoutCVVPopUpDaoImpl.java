package com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao;

import com.talabat.talabatcommon.feature.checkoutCVVPopUp.network.CheckoutCVVPopUpApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/dao/CheckoutCVVPopUpDaoImpl;", "Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/dao/CheckoutCVVPopUpDao;", "checkoutCVVPopUpApi", "Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/network/CheckoutCVVPopUpApi;", "(Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/network/CheckoutCVVPopUpApi;)V", "getCheckoutCVVPopUpStatus", "", "binNumber", "", "orderAmount", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutCVVPopUpDaoImpl implements CheckoutCVVPopUpDao {
    @NotNull
    private final CheckoutCVVPopUpApi checkoutCVVPopUpApi;

    public CheckoutCVVPopUpDaoImpl(@NotNull CheckoutCVVPopUpApi checkoutCVVPopUpApi2) {
        Intrinsics.checkNotNullParameter(checkoutCVVPopUpApi2, "checkoutCVVPopUpApi");
        this.checkoutCVVPopUpApi = checkoutCVVPopUpApi2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getCheckoutCVVPopUpStatus(@org.jetbrains.annotations.NotNull java.lang.String r10, float r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao.CheckoutCVVPopUpDaoImpl$getCheckoutCVVPopUpStatus$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao.CheckoutCVVPopUpDaoImpl$getCheckoutCVVPopUpStatus$1 r0 = (com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao.CheckoutCVVPopUpDaoImpl$getCheckoutCVVPopUpStatus$1) r0
            int r1 = r0.f61543j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61543j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao.CheckoutCVVPopUpDaoImpl$getCheckoutCVVPopUpStatus$1 r0 = new com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao.CheckoutCVVPopUpDaoImpl$getCheckoutCVVPopUpStatus$1
            r0.<init>(r9, r12)
        L_0x0018:
            r6 = r0
            java.lang.Object r12 = r6.f61541h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f61543j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0047
        L_0x002a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r12)
            com.talabat.talabatcommon.feature.checkoutCVVPopUp.network.CheckoutCVVPopUpApi r1 = r9.checkoutCVVPopUpApi
            r12 = 0
            r4 = 0
            r7 = 5
            r8 = 0
            r6.f61543j = r2
            r2 = r12
            r3 = r10
            r5 = r11
            java.lang.Object r12 = com.talabat.talabatcommon.feature.checkoutCVVPopUp.network.CheckoutCVVPopUpApi.DefaultImpls.getCanRefundToBankStatus$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L_0x0047
            return r0
        L_0x0047:
            com.talabat.talabatcommon.feature.checkoutCVVPopUp.model.CheckoutCVVPopUpResponse r12 = (com.talabat.talabatcommon.feature.checkoutCVVPopUp.model.CheckoutCVVPopUpResponse) r12
            com.talabat.talabatcommon.feature.checkoutCVVPopUp.model.CheckoutCVVPopUpResult r10 = r12.getResult()
            if (r10 == 0) goto L_0x005a
            java.lang.Boolean r10 = r10.getCanShowCvv()
            if (r10 == 0) goto L_0x005a
            boolean r10 = r10.booleanValue()
            goto L_0x005b
        L_0x005a:
            r10 = 0
        L_0x005b:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao.CheckoutCVVPopUpDaoImpl.getCheckoutCVVPopUpStatus(java.lang.String, float, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
