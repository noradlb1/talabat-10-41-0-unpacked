package com.talabat.feature.fees.data.repository;

import com.talabat.feature.fees.data.local.LocalFeesDataSource;
import com.talabat.feature.fees.data.mapper.FeesMapper;
import com.talabat.feature.fees.data.remote.PricingApi;
import com.talabat.feature.fees.domain.repository.IPricingRepository;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ0\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002JG\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJI\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/fees/data/repository/PricingRepository;", "Lcom/talabat/feature/fees/domain/repository/IPricingRepository;", "pricingApi", "Lcom/talabat/feature/fees/data/remote/PricingApi;", "localFeesDataSource", "Lcom/talabat/feature/fees/data/local/LocalFeesDataSource;", "feesMapper", "Lcom/talabat/feature/fees/data/mapper/FeesMapper;", "countryId", "", "vendorId", "deliveryMode", "", "(Lcom/talabat/feature/fees/data/remote/PricingApi;Lcom/talabat/feature/fees/data/local/LocalFeesDataSource;Lcom/talabat/feature/fees/data/mapper/FeesMapper;IILjava/lang/String;)V", "createCacheKey", "latitude", "", "longitude", "getFees", "Lcom/talabat/feature/fees/domain/repository/FeesResult;", "subtotalBeforeDiscounts", "", "subtotal", "couponDiscount", "forceUpdate", "", "(DDLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteFees", "Lcom/talabat/feature/fees/domain/model/Fees;", "cacheKey", "(DDLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PricingRepository implements IPricingRepository {
    private final int countryId;
    @NotNull
    private final String deliveryMode;
    @NotNull
    private final FeesMapper feesMapper;
    @NotNull
    private final LocalFeesDataSource localFeesDataSource;
    @NotNull
    private final PricingApi pricingApi;
    private final int vendorId;

    @Inject
    public PricingRepository(@NotNull PricingApi pricingApi2, @NotNull LocalFeesDataSource localFeesDataSource2, @NotNull FeesMapper feesMapper2, @Named("countryId") int i11, @Named("branchId") int i12, @NotNull @Named("deliveryMode") String str) {
        Intrinsics.checkNotNullParameter(pricingApi2, "pricingApi");
        Intrinsics.checkNotNullParameter(localFeesDataSource2, "localFeesDataSource");
        Intrinsics.checkNotNullParameter(feesMapper2, "feesMapper");
        Intrinsics.checkNotNullParameter(str, "deliveryMode");
        this.pricingApi = pricingApi2;
        this.localFeesDataSource = localFeesDataSource2;
        this.feesMapper = feesMapper2;
        this.countryId = i11;
        this.vendorId = i12;
        this.deliveryMode = str;
    }

    private final String createCacheKey(int i11, int i12, double d11, double d12, String str) {
        return i11 + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + i12 + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + d11 + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + d12 + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getRemoteFees(double r17, double r19, java.lang.Float r21, java.lang.Float r22, java.lang.Float r23, java.lang.String r24, kotlin.coroutines.Continuation<? super com.talabat.feature.fees.domain.model.Fees> r25) {
        /*
            r16 = this;
            r1 = r16
            r0 = r25
            boolean r2 = r0 instanceof com.talabat.feature.fees.data.repository.PricingRepository$getRemoteFees$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.talabat.feature.fees.data.repository.PricingRepository$getRemoteFees$1 r2 = (com.talabat.feature.fees.data.repository.PricingRepository$getRemoteFees$1) r2
            int r3 = r2.f58528l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f58528l = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.feature.fees.data.repository.PricingRepository$getRemoteFees$1 r2 = new com.talabat.feature.fees.data.repository.PricingRepository$getRemoteFees$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f58526j
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.f58528l
            r14 = 2
            r4 = 1
            if (r3 == 0) goto L_0x004d
            if (r3 == r4) goto L_0x003d
            if (r3 != r14) goto L_0x0035
            java.lang.Object r2 = r2.f58524h
            com.talabat.feature.fees.domain.model.Fees r2 = (com.talabat.feature.fees.domain.model.Fees) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00b9
        L_0x0035:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003d:
            java.lang.Object r3 = r2.f58525i
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.f58524h
            com.talabat.feature.fees.data.repository.PricingRepository r4 = (com.talabat.feature.fees.data.repository.PricingRepository) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x004a }
            r1 = r14
            goto L_0x007a
        L_0x004a:
            r0 = move-exception
            r1 = r14
            goto L_0x008b
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0085 }
            com.talabat.feature.fees.data.remote.PricingApi r3 = r1.pricingApi     // Catch:{ all -> 0x0085 }
            int r0 = r1.vendorId     // Catch:{ all -> 0x0085 }
            int r5 = r1.countryId     // Catch:{ all -> 0x0085 }
            java.lang.String r10 = r1.deliveryMode     // Catch:{ all -> 0x0085 }
            r2.f58524h = r1     // Catch:{ all -> 0x0085 }
            r13 = r24
            r2.f58525i = r13     // Catch:{ all -> 0x0085 }
            r2.f58528l = r4     // Catch:{ all -> 0x0085 }
            r4 = r0
            r6 = r17
            r8 = r19
            r11 = r21
            r12 = r22
            r13 = r23
            r1 = r14
            r14 = r2
            java.lang.Object r0 = r3.getFees(r4, r5, r6, r8, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0083 }
            if (r0 != r15) goto L_0x0076
            return r15
        L_0x0076:
            r4 = r16
            r3 = r24
        L_0x007a:
            com.talabat.feature.fees.data.remote.dto.FeesResponse r0 = (com.talabat.feature.fees.data.remote.dto.FeesResponse) r0     // Catch:{ all -> 0x0081 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0081 }
            goto L_0x0095
        L_0x0081:
            r0 = move-exception
            goto L_0x008b
        L_0x0083:
            r0 = move-exception
            goto L_0x0087
        L_0x0085:
            r0 = move-exception
            r1 = r14
        L_0x0087:
            r4 = r16
            r3 = r24
        L_0x008b:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x0095:
            boolean r5 = kotlin.Result.m6335isFailureimpl(r0)
            r6 = 0
            if (r5 == 0) goto L_0x009d
            r0 = r6
        L_0x009d:
            com.talabat.feature.fees.data.remote.dto.FeesResponse r0 = (com.talabat.feature.fees.data.remote.dto.FeesResponse) r0
            if (r0 == 0) goto L_0x00ba
            com.talabat.feature.fees.data.mapper.FeesMapper r5 = r4.feesMapper
            com.talabat.feature.fees.domain.model.Fees r0 = r5.map(r0)
            if (r0 == 0) goto L_0x00ba
            com.talabat.feature.fees.data.local.LocalFeesDataSource r4 = r4.localFeesDataSource
            r2.f58524h = r0
            r2.f58525i = r6
            r2.f58528l = r1
            java.lang.Object r1 = r4.putFees(r3, r0, r2)
            if (r1 != r15) goto L_0x00b8
            return r15
        L_0x00b8:
            r2 = r0
        L_0x00b9:
            r6 = r2
        L_0x00ba:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.fees.data.repository.PricingRepository.getRemoteFees(double, double, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.talabat.feature.fees.domain.model.Fees] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getFees(double r21, double r23, @org.jetbrains.annotations.Nullable java.lang.Float r25, @org.jetbrains.annotations.Nullable java.lang.Float r26, @org.jetbrains.annotations.Nullable java.lang.Float r27, boolean r28, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.fees.domain.repository.FeesResult> r29) {
        /*
            r20 = this;
            r8 = r20
            r0 = r29
            boolean r1 = r0 instanceof com.talabat.feature.fees.data.repository.PricingRepository$getFees$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.talabat.feature.fees.data.repository.PricingRepository$getFees$1 r1 = (com.talabat.feature.fees.data.repository.PricingRepository$getFees$1) r1
            int r2 = r1.f58523r
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f58523r = r2
            goto L_0x001c
        L_0x0017:
            com.talabat.feature.fees.data.repository.PricingRepository$getFees$1 r1 = new com.talabat.feature.fees.data.repository.PricingRepository$getFees$1
            r1.<init>(r8, r0)
        L_0x001c:
            r15 = r1
            java.lang.Object r0 = r15.f58521p
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r15.f58523r
            r9 = 3
            r10 = 1
            r12 = 2
            if (r1 == 0) goto L_0x0073
            if (r1 == r10) goto L_0x0049
            if (r1 == r12) goto L_0x0040
            if (r1 != r9) goto L_0x0038
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r0
            r0 = r12
            r1 = 0
            goto L_0x010c
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            java.lang.Object r1 = r15.f58513h
            com.talabat.feature.fees.domain.model.Fees r1 = (com.talabat.feature.fees.domain.model.Fees) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00d9
        L_0x0049:
            boolean r1 = r15.f58520o
            double r2 = r15.f58519n
            double r4 = r15.f58518m
            java.lang.Object r6 = r15.f58517l
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r15.f58516k
            java.lang.Float r7 = (java.lang.Float) r7
            java.lang.Object r10 = r15.f58515j
            java.lang.Float r10 = (java.lang.Float) r10
            java.lang.Object r11 = r15.f58514i
            java.lang.Float r11 = (java.lang.Float) r11
            java.lang.Object r9 = r15.f58513h
            com.talabat.feature.fees.data.repository.PricingRepository r9 = (com.talabat.feature.fees.data.repository.PricingRepository) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r12 = r2
            r17 = r6
            r3 = r10
            r2 = r11
            r10 = r4
            r4 = r7
            r19 = r9
            r9 = r1
            r1 = r19
            goto L_0x00b2
        L_0x0073:
            kotlin.ResultKt.throwOnFailure(r0)
            int r1 = r8.vendorId
            int r2 = r8.countryId
            java.lang.String r7 = r8.deliveryMode
            r0 = r20
            r3 = r21
            r5 = r23
            java.lang.String r0 = r0.createCacheKey(r1, r2, r3, r5, r7)
            com.talabat.feature.fees.data.local.LocalFeesDataSource r1 = r8.localFeesDataSource
            r15.f58513h = r8
            r2 = r25
            r15.f58514i = r2
            r3 = r26
            r15.f58515j = r3
            r4 = r27
            r15.f58516k = r4
            r15.f58517l = r0
            r5 = r21
            r15.f58518m = r5
            r12 = r23
            r15.f58519n = r12
            r9 = r28
            r15.f58520o = r9
            r15.f58523r = r10
            java.lang.Object r1 = r1.getFees(r0, r15)
            if (r1 != r14) goto L_0x00ad
            return r14
        L_0x00ad:
            r17 = r0
            r0 = r1
            r10 = r5
            r1 = r8
        L_0x00b2:
            com.talabat.feature.fees.domain.model.Fees r0 = (com.talabat.feature.fees.domain.model.Fees) r0
            if (r9 == 0) goto L_0x00e1
            r15.f58513h = r0
            r5 = 0
            r15.f58514i = r5
            r15.f58515j = r5
            r15.f58516k = r5
            r15.f58517l = r5
            r5 = 2
            r15.f58523r = r5
            r9 = r1
            r5 = r14
            r14 = r2
            r6 = r15
            r15 = r3
            r16 = r4
            r18 = r6
            java.lang.Object r1 = r9.getRemoteFees(r10, r12, r14, r15, r16, r17, r18)
            if (r1 != r5) goto L_0x00d4
            return r5
        L_0x00d4:
            r19 = r1
            r1 = r0
            r0 = r19
        L_0x00d9:
            com.talabat.feature.fees.domain.model.Fees r0 = (com.talabat.feature.fees.domain.model.Fees) r0
            com.talabat.feature.fees.domain.repository.FeesResult r2 = new com.talabat.feature.fees.domain.repository.FeesResult
            r2.<init>(r0, r1)
            return r2
        L_0x00e1:
            r5 = r14
            r6 = r15
            if (r0 == 0) goto L_0x00ed
            com.talabat.feature.fees.domain.repository.FeesResult r1 = new com.talabat.feature.fees.domain.repository.FeesResult
            r7 = 2
            r14 = 0
            r1.<init>(r0, r14, r7, r14)
            goto L_0x0114
        L_0x00ed:
            r7 = 2
            r14 = 0
            r6.f58513h = r14
            r6.f58514i = r14
            r6.f58515j = r14
            r6.f58516k = r14
            r6.f58517l = r14
            r0 = 3
            r6.f58523r = r0
            r9 = r1
            r0 = r7
            r1 = r14
            r14 = r2
            r15 = r3
            r16 = r4
            r18 = r6
            java.lang.Object r2 = r9.getRemoteFees(r10, r12, r14, r15, r16, r17, r18)
            if (r2 != r5) goto L_0x010c
            return r5
        L_0x010c:
            com.talabat.feature.fees.domain.model.Fees r2 = (com.talabat.feature.fees.domain.model.Fees) r2
            com.talabat.feature.fees.domain.repository.FeesResult r3 = new com.talabat.feature.fees.domain.repository.FeesResult
            r3.<init>(r2, r1, r0, r1)
            r1 = r3
        L_0x0114:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.fees.data.repository.PricingRepository.getFees(double, double, java.lang.Float, java.lang.Float, java.lang.Float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
