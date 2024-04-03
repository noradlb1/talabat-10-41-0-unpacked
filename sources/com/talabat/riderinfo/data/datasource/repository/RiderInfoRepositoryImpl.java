package com.talabat.riderinfo.data.datasource.repository;

import com.talabat.riderinfo.data.datasource.remote.PoeRetrofitService;
import com.talabat.riderinfo.domain.repository.RiderInfoRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/riderinfo/data/datasource/repository/RiderInfoRepositoryImpl;", "Lcom/talabat/riderinfo/domain/repository/RiderInfoRepository;", "poeRetrofitService", "Lcom/talabat/riderinfo/data/datasource/remote/PoeRetrofitService;", "(Lcom/talabat/riderinfo/data/datasource/remote/PoeRetrofitService;)V", "getRiderInfo", "Lcom/talabat/riderinfo/domain/entity/RiderInfo;", "orderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderInfoRepositoryImpl implements RiderInfoRepository {
    @NotNull
    private final PoeRetrofitService poeRetrofitService;

    public RiderInfoRepositoryImpl(@NotNull PoeRetrofitService poeRetrofitService2) {
        Intrinsics.checkNotNullParameter(poeRetrofitService2, "poeRetrofitService");
        this.poeRetrofitService = poeRetrofitService2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getRiderInfo(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.riderinfo.domain.entity.RiderInfo> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.riderinfo.data.datasource.repository.RiderInfoRepositoryImpl$getRiderInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.riderinfo.data.datasource.repository.RiderInfoRepositoryImpl$getRiderInfo$1 r0 = (com.talabat.riderinfo.data.datasource.repository.RiderInfoRepositoryImpl$getRiderInfo$1) r0
            int r1 = r0.f61290j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61290j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.riderinfo.data.datasource.repository.RiderInfoRepositoryImpl$getRiderInfo$1 r0 = new com.talabat.riderinfo.data.datasource.repository.RiderInfoRepositoryImpl$getRiderInfo$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f61288h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61290j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.riderinfo.data.datasource.remote.PoeRetrofitService r8 = r6.poeRetrofitService
            r0.f61290j = r3
            java.lang.Object r8 = r8.getRiderInfo(r7, r0)
            if (r8 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.talabat.riderinfo.data.dto.RiderInfoDto r8 = (com.talabat.riderinfo.data.dto.RiderInfoDto) r8
            com.talabat.riderinfo.domain.entity.RiderInfo r7 = new com.talabat.riderinfo.domain.entity.RiderInfo
            java.lang.String r1 = r8.getChannelId()
            java.lang.String r2 = r8.getCustomerId()
            java.lang.String r3 = r8.getSessionToken()
            java.lang.String r4 = r8.getRiderPhone()
            java.lang.String r5 = r8.getRiderName()
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.riderinfo.data.datasource.repository.RiderInfoRepositoryImpl.getRiderInfo(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
