package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo;
import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u001bH\u0002R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimInfoUseCase;", "", "imageFileManager", "Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;", "repository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "(Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;)V", "claimDisplayModel", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "getClaimDisplayModel", "()Lkotlinx/coroutines/flow/Flow;", "screenType", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;", "backgroundPath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "backgroundUrl", "", "backgroundPath-r0oKcjY", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerGettingWidget", "", "voucherId", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthVoucherId;", "triggerGettingWidget-6cUB-Hk", "(Ljava/lang/String;Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;)V", "toDisplayModelFlow", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$Success;", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthClaimInfoUseCase {
    @NotNull
    private final Flow<TMartGrowthClaimDisplayModel> claimDisplayModel;
    /* access modifiers changed from: private */
    @NotNull
    public final ITMartGrowthFileManager imageFileManager;
    @NotNull
    private final ITMartGrowthRepository repository;
    /* access modifiers changed from: private */
    @NotNull
    public TMartGrowthScreenType screenType = TMartGrowthScreenType.HOME;

    @Inject
    public TMartGrowthClaimInfoUseCase(@NotNull ITMartGrowthFileManager iTMartGrowthFileManager, @NotNull ITMartGrowthRepository iTMartGrowthRepository) {
        Intrinsics.checkNotNullParameter(iTMartGrowthFileManager, "imageFileManager");
        Intrinsics.checkNotNullParameter(iTMartGrowthRepository, "repository");
        this.imageFileManager = iTMartGrowthFileManager;
        this.repository = iTMartGrowthRepository;
        this.claimDisplayModel = FlowKt.m7822catch(FlowKt.transformLatest(iTMartGrowthRepository.getClaimInfo(), new TMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1((Continuation) null, this)), new TMartGrowthClaimInfoUseCase$claimDisplayModel$2((Continuation<? super TMartGrowthClaimInfoUseCase$claimDisplayModel$2>) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: backgroundPath-r0oKcjY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m10320backgroundPathr0oKcjY(java.lang.String r5, kotlin.coroutines.Continuation<? super com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$backgroundPath$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$backgroundPath$1 r0 = (com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$backgroundPath$1) r0
            int r1 = r0.f59096j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59096j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$backgroundPath$1 r0 = new com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$backgroundPath$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f59094h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59096j
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0055 }
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r6 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r6     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = r6.m10329unboximpl()     // Catch:{ all -> 0x0055 }
            goto L_0x004a
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager r6 = r4.imageFileManager
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0055 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x0055 }
            r0.f59096j = r3     // Catch:{ all -> 0x0055 }
            java.lang.Object r5 = r6.m10337getFilePathr0oKcjY(r5, r0)     // Catch:{ all -> 0x0055 }
            if (r5 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0055 }
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r5 = com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath.m10323boximpl(r5)     // Catch:{ all -> 0x0055 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0055 }
            goto L_0x0060
        L_0x0055:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0060:
            java.lang.String r6 = ""
            java.lang.String r6 = com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath.m10324constructorimpl(r6)
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r6 = com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath.m10323boximpl(r6)
            boolean r0 = kotlin.Result.m6335isFailureimpl(r5)
            if (r0 == 0) goto L_0x0071
            r5 = r6
        L_0x0071:
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r5 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r5
            java.lang.String r5 = r5.m10329unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase.m10320backgroundPathr0oKcjY(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Flow<TMartGrowthClaimDisplayModel> toDisplayModelFlow(TMartGrowthClaimInfo.Success success) {
        return new TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1(FlowKt.m7822catch(FlowKt.onStart(FlowKt.flow(new TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1(this, success, (Continuation<? super TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1>) null)), new TMartGrowthClaimInfoUseCase$toDisplayModelFlow$2(this, success, (Continuation<? super TMartGrowthClaimInfoUseCase$toDisplayModelFlow$2>) null)), new TMartGrowthClaimInfoUseCase$toDisplayModelFlow$3((Continuation<? super TMartGrowthClaimInfoUseCase$toDisplayModelFlow$3>) null)), success, this);
    }

    @NotNull
    public final Flow<TMartGrowthClaimDisplayModel> getClaimDisplayModel() {
        return this.claimDisplayModel;
    }

    /* renamed from: triggerGettingWidget-6cUB-Hk  reason: not valid java name */
    public final void m10321triggerGettingWidget6cUBHk(@NotNull String str, @NotNull TMartGrowthScreenType tMartGrowthScreenType) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(tMartGrowthScreenType, "screenType");
        this.screenType = tMartGrowthScreenType;
        this.repository.m10299triggerGettingVoucher99KcVpk(str);
    }
}
