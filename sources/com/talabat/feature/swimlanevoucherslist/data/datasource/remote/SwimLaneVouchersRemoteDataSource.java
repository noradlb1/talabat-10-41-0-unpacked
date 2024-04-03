package com.talabat.feature.swimlanevoucherslist.data.datasource.remote;

import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/datasource/remote/SwimLaneVouchersRemoteDataSource;", "", "vouchersSwimLane", "Ldagger/Lazy;", "Lcom/talabat/feature/swimlanevoucherslist/data/datasource/remote/VouchersSwimLaneApi;", "(Ldagger/Lazy;)V", "loadPossibleCustomerVouchersSwimLane", "", "Lcom/talabat/feature/swimlanevoucherslist/data/model/QCSwimLaneVouchers;", "vouchersSwimLaneRequest", "Lcom/talabat/features/swimlanevoucherslist/domain/model/VouchersSwimLaneRequest;", "(Lcom/talabat/features/swimlanevoucherslist/domain/model/VouchersSwimLaneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimLaneVouchersRemoteDataSource {
    @NotNull
    private final Lazy<VouchersSwimLaneApi> vouchersSwimLane;

    @Inject
    public SwimLaneVouchersRemoteDataSource(@NotNull Lazy<VouchersSwimLaneApi> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "vouchersSwimLane");
        this.vouchersSwimLane = lazy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadPossibleCustomerVouchersSwimLane(@org.jetbrains.annotations.NotNull com.talabat.features.swimlanevoucherslist.domain.model.VouchersSwimLaneRequest r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.talabat.feature.swimlanevoucherslist.data.model.QCSwimLaneVouchers>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource$loadPossibleCustomerVouchersSwimLane$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource$loadPossibleCustomerVouchersSwimLane$1 r0 = (com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource$loadPossibleCustomerVouchersSwimLane$1) r0
            int r1 = r0.f59016j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59016j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource$loadPossibleCustomerVouchersSwimLane$1 r0 = new com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource$loadPossibleCustomerVouchersSwimLane$1
            r0.<init>(r8, r10)
        L_0x0018:
            r6 = r0
            java.lang.Object r10 = r6.f59014h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f59016j
            r7 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r7) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0057
        L_0x002a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)
            dagger.Lazy<com.talabat.feature.swimlanevoucherslist.data.datasource.remote.VouchersSwimLaneApi> r10 = r8.vouchersSwimLane
            java.lang.Object r10 = r10.get()
            r1 = r10
            com.talabat.feature.swimlanevoucherslist.data.datasource.remote.VouchersSwimLaneApi r1 = (com.talabat.feature.swimlanevoucherslist.data.datasource.remote.VouchersSwimLaneApi) r1
            java.lang.String r3 = r9.getVendorId()
            java.lang.String r2 = r9.getCountryId()
            int r4 = r9.getAreaId()
            java.lang.String r5 = r9.getBrandId()
            r6.f59016j = r7
            java.lang.Object r10 = r1.getVouchersSwimLane(r2, r3, r4, r5, r6)
            if (r10 != r0) goto L_0x0057
            return r0
        L_0x0057:
            com.talabat.feature.swimlanevoucherslist.data.model.VouchersSwimLaneResponse r10 = (com.talabat.feature.swimlanevoucherslist.data.model.VouchersSwimLaneResponse) r10
            java.util.List r9 = r10.getPossibleCustomerVouchers()
            r10 = r9
            java.util.Collection r10 = (java.util.Collection) r10
            if (r10 == 0) goto L_0x006b
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r10 = 0
            goto L_0x006c
        L_0x006b:
            r10 = r7
        L_0x006c:
            r10 = r10 ^ r7
            if (r10 == 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r9 = 0
        L_0x0071:
            if (r9 == 0) goto L_0x0074
            return r9
        L_0x0074:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Empty list"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.swimlanevoucherslist.data.datasource.remote.SwimLaneVouchersRemoteDataSource.loadPossibleCustomerVouchersSwimLane(com.talabat.features.swimlanevoucherslist.domain.model.VouchersSwimLaneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
