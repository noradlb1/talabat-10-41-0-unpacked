package com.talabat.feature.swimlanevoucherslist.data;

import com.talabat.feature.swimlanevoucherslist.data.datasource.mapper.CustomerVoucherMapper;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource;
import com.talabat.features.swimlanevoucherslist.domain.repository.CustomerVouchersSwimLaneRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/CustomerVouchersSwimLaneRealRepository;", "Lcom/talabat/features/swimlanevoucherslist/domain/repository/CustomerVouchersSwimLaneRepository;", "vouchersRemoteDataSource", "Lcom/talabat/feature/swimlanevoucherslist/data/datasource/remote/SwimLaneVouchersRemoteDataSource;", "vouchersMapper", "Lcom/talabat/feature/swimlanevoucherslist/data/datasource/mapper/CustomerVoucherMapper;", "(Lcom/talabat/feature/swimlanevoucherslist/data/datasource/remote/SwimLaneVouchersRemoteDataSource;Lcom/talabat/feature/swimlanevoucherslist/data/datasource/mapper/CustomerVoucherMapper;)V", "getCustomerVouchersSwimLane", "", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "vouchersSwimLaneRequest", "Lcom/talabat/features/swimlanevoucherslist/domain/model/VouchersSwimLaneRequest;", "(Lcom/talabat/features/swimlanevoucherslist/domain/model/VouchersSwimLaneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerVouchersSwimLaneRealRepository implements CustomerVouchersSwimLaneRepository {
    @NotNull
    private final CustomerVoucherMapper vouchersMapper;
    @NotNull
    private final SwimLaneVouchersRemoteDataSource vouchersRemoteDataSource;

    @Inject
    public CustomerVouchersSwimLaneRealRepository(@NotNull SwimLaneVouchersRemoteDataSource swimLaneVouchersRemoteDataSource, @NotNull CustomerVoucherMapper customerVoucherMapper) {
        Intrinsics.checkNotNullParameter(swimLaneVouchersRemoteDataSource, "vouchersRemoteDataSource");
        Intrinsics.checkNotNullParameter(customerVoucherMapper, "vouchersMapper");
        this.vouchersRemoteDataSource = swimLaneVouchersRemoteDataSource;
        this.vouchersMapper = customerVoucherMapper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getCustomerVouchersSwimLane(@org.jetbrains.annotations.NotNull com.talabat.features.swimlanevoucherslist.domain.model.VouchersSwimLaneRequest r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository$getCustomerVouchersSwimLane$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository$getCustomerVouchersSwimLane$1 r0 = (com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository$getCustomerVouchersSwimLane$1) r0
            int r1 = r0.f59013k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59013k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository$getCustomerVouchersSwimLane$1 r0 = new com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository$getCustomerVouchersSwimLane$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f59011i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59013k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f59010h
            com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository r5 = (com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0070 }
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0070 }
            com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource r6 = r4.vouchersRemoteDataSource     // Catch:{ all -> 0x0070 }
            r0.f59010h = r4     // Catch:{ all -> 0x0070 }
            r0.f59013k = r3     // Catch:{ all -> 0x0070 }
            java.lang.Object r6 = r6.loadPossibleCustomerVouchersSwimLane(r5, r0)     // Catch:{ all -> 0x0070 }
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r5 = r4
        L_0x0048:
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x0070 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0070 }
            r0.<init>()     // Catch:{ all -> 0x0070 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0070 }
        L_0x0053:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x006b
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x0070 }
            com.talabat.feature.swimlanevoucherslist.data.model.QCSwimLaneVouchers r1 = (com.talabat.feature.swimlanevoucherslist.data.model.QCSwimLaneVouchers) r1     // Catch:{ all -> 0x0070 }
            com.talabat.feature.swimlanevoucherslist.data.datasource.mapper.CustomerVoucherMapper r2 = r5.vouchersMapper     // Catch:{ all -> 0x0070 }
            com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher r1 = r2.apply((com.talabat.feature.swimlanevoucherslist.data.model.QCSwimLaneVouchers) r1)     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0053
            r0.add(r1)     // Catch:{ all -> 0x0070 }
            goto L_0x0053
        L_0x006b:
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0070 }
            goto L_0x007b
        L_0x0070:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x007b:
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            boolean r0 = kotlin.Result.m6335isFailureimpl(r5)
            if (r0 == 0) goto L_0x0086
            r5 = r6
        L_0x0086:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository.getCustomerVouchersSwimLane(com.talabat.features.swimlanevoucherslist.domain.model.VouchersSwimLaneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
