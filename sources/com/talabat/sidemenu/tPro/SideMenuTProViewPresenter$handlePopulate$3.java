package com.talabat.sidemenu.tPro;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "savings", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "emit", "(Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTProViewPresenter$handlePopulate$3<T> implements FlowCollector {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProViewPresenter f61400b;

    public SideMenuTProViewPresenter$handlePopulate$3(SideMenuTProViewPresenter sideMenuTProViewPresenter) {
        this.f61400b = sideMenuTProViewPresenter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(@org.jetbrains.annotations.Nullable com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3$emit$1 r0 = (com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3$emit$1) r0
            int r1 = r0.f61405j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61405j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3$emit$1 r0 = new com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3$emit$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f61403h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61405j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005a
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            if (r6 == 0) goto L_0x005a
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter r7 = r5.f61400b
            float r6 = r6.getOverallSavings()
            r2 = 0
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0043
            r6 = r3
            goto L_0x0044
        L_0x0043:
            r6 = 0
        L_0x0044:
            r7.enabled = r6
            kotlinx.coroutines.MainCoroutineDispatcher r6 = r7.mainDispatcher
            com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3$1$1 r2 = new com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3$1$1
            r4 = 0
            r2.<init>(r7, r4)
            r0.f61405j = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L_0x005a
            return r1
        L_0x005a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$3.emit(com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
