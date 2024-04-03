package com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl;

import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.BenefitManagerRemoteDataSource;
import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.repository.BenefitManagerRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/impl/BenefitManagerRepositoryImpl;", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/repository/BenefitManagerRepository;", "benefitManagerRemoteDataSource", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/BenefitManagerRemoteDataSource;", "(Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/BenefitManagerRemoteDataSource;)V", "getBinsDetails", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBinsDetail;", "bins", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitManagerRepositoryImpl implements BenefitManagerRepository {
    @NotNull
    private final BenefitManagerRemoteDataSource benefitManagerRemoteDataSource;

    public BenefitManagerRepositoryImpl(@NotNull BenefitManagerRemoteDataSource benefitManagerRemoteDataSource2) {
        Intrinsics.checkNotNullParameter(benefitManagerRemoteDataSource2, "benefitManagerRemoteDataSource");
        this.benefitManagerRemoteDataSource = benefitManagerRemoteDataSource2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getBinsDetails(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl.BenefitManagerRepositoryImpl$getBinsDetails$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl.BenefitManagerRepositoryImpl$getBinsDetails$1 r0 = (com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl.BenefitManagerRepositoryImpl$getBinsDetails$1) r0
            int r1 = r0.f11889k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11889k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl.BenefitManagerRepositoryImpl$getBinsDetails$1 r0 = new com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl.BenefitManagerRepositoryImpl$getBinsDetails$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f11887i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f11889k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f11886h
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.mapper.BenefitBinMapper r6 = (com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.mapper.BenefitBinMapper) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.mapper.BenefitBinMapper r7 = com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.mapper.BenefitBinMapper.INSTANCE
            com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.BenefitManagerRemoteDataSource r2 = r5.benefitManagerRemoteDataSource
            r0.f11886h = r7
            r0.f11889k = r3
            java.lang.Object r6 = r2.getBinDetails(r6, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x004a:
            com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto.BenefitBinDetailRemoteDto r7 = (com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto.BenefitBinDetailRemoteDto) r7
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail r6 = r6.mapToBenefitBin(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.benefitmanager.data.impl.BenefitManagerRepositoryImpl.getBinsDetails(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
