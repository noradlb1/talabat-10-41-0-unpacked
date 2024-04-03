package com.talabat.feature.incentiveautoapplydiscounts.data;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.mapper.IncentiveAutoApplyDiscountsMapper;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource;
import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;
import com.talabat.feature.incentiveautoapplydiscounts.domain.repository.IncentiveAutoApplyDiscountsRepository;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/data/IncentiveAutoApplyDiscountsRealRepository;", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/repository/IncentiveAutoApplyDiscountsRepository;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "incentiveAutoApplyDiscountsRemoteDataSource", "Ldagger/Lazy;", "Lcom/talabat/feature/incentiveautoapplydiscounts/data/datasource/remote/IncentiveAutoApplyDiscountsRemoteDataSource;", "mapper", "Lcom/talabat/feature/incentiveautoapplydiscounts/data/datasource/mapper/IncentiveAutoApplyDiscountsMapper;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Ldagger/Lazy;Lcom/talabat/feature/incentiveautoapplydiscounts/data/datasource/mapper/IncentiveAutoApplyDiscountsMapper;)V", "defaultValue", "", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscount;", "[Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscount;", "getAutoApplyDiscounts", "autoApplyDiscountsRequest", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscountsRequest;", "(Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscountsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_incentive-auto-apply-discounts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncentiveAutoApplyDiscountsRealRepository implements IncentiveAutoApplyDiscountsRepository {
    @NotNull
    private final AutoApplyDiscount[] defaultValue = new AutoApplyDiscount[0];
    @NotNull
    private final ITalabatFeatureFlag featureFlag;
    @NotNull
    private final Lazy<IncentiveAutoApplyDiscountsRemoteDataSource> incentiveAutoApplyDiscountsRemoteDataSource;
    @NotNull
    private final IncentiveAutoApplyDiscountsMapper mapper;

    @Inject
    public IncentiveAutoApplyDiscountsRealRepository(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Lazy<IncentiveAutoApplyDiscountsRemoteDataSource> lazy, @NotNull IncentiveAutoApplyDiscountsMapper incentiveAutoApplyDiscountsMapper) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        Intrinsics.checkNotNullParameter(lazy, "incentiveAutoApplyDiscountsRemoteDataSource");
        Intrinsics.checkNotNullParameter(incentiveAutoApplyDiscountsMapper, "mapper");
        this.featureFlag = iTalabatFeatureFlag;
        this.incentiveAutoApplyDiscountsRemoteDataSource = lazy;
        this.mapper = incentiveAutoApplyDiscountsMapper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089 A[Catch:{ all -> 0x0032 }, LOOP:0: B:27:0x0083->B:29:0x0089, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAutoApplyDiscounts(@org.jetbrains.annotations.NotNull com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount[]> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository$getAutoApplyDiscounts$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository$getAutoApplyDiscounts$1 r0 = (com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository$getAutoApplyDiscounts$1) r0
            int r1 = r0.f58561l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58561l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository$getAutoApplyDiscounts$1 r0 = new com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository$getAutoApplyDiscounts$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f58559j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58561l
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r6 = r0.f58558i
            com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository r6 = (com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository) r6
            java.lang.Object r0 = r0.f58557h
            com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository r0 = (com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0032 }
            goto L_0x0072
        L_0x0032:
            r6 = move-exception
            goto L_0x00ad
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r7 = r5.featureFlag
            com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys r2 = com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys.INCENTIVE_AUTO_APPLY_DISCOUNTS_ENABLED
            boolean r7 = r7.getFeatureFlag(r2, r3)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            boolean r2 = r7.booleanValue()
            if (r2 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r7 = 0
        L_0x0054:
            if (r7 == 0) goto L_0x00c5
            r7.booleanValue()
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x00ab }
            dagger.Lazy<com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource> r7 = r5.incentiveAutoApplyDiscountsRemoteDataSource     // Catch:{ all -> 0x00ab }
            java.lang.Object r7 = r7.get()     // Catch:{ all -> 0x00ab }
            com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource r7 = (com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource) r7     // Catch:{ all -> 0x00ab }
            r0.f58557h = r5     // Catch:{ all -> 0x00ab }
            r0.f58558i = r5     // Catch:{ all -> 0x00ab }
            r0.f58561l = r4     // Catch:{ all -> 0x00ab }
            java.lang.Object r7 = r7.getAutoApplyDiscounts(r6, r0)     // Catch:{ all -> 0x00ab }
            if (r7 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r6 = r5
            r0 = r6
        L_0x0072:
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x0032 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0032 }
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r7, r2)     // Catch:{ all -> 0x0032 }
            r1.<init>(r2)     // Catch:{ all -> 0x0032 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0032 }
        L_0x0083:
            boolean r2 = r7.hasNext()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0099
            java.lang.Object r2 = r7.next()     // Catch:{ all -> 0x0032 }
            com.talabat.feature.incentiveautoapplydiscounts.data.model.AutoApplyDiscountItemResponse r2 = (com.talabat.feature.incentiveautoapplydiscounts.data.model.AutoApplyDiscountItemResponse) r2     // Catch:{ all -> 0x0032 }
            com.talabat.feature.incentiveautoapplydiscounts.data.datasource.mapper.IncentiveAutoApplyDiscountsMapper r4 = r6.mapper     // Catch:{ all -> 0x0032 }
            com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount r2 = r4.apply((com.talabat.feature.incentiveautoapplydiscounts.data.model.AutoApplyDiscountItemResponse) r2)     // Catch:{ all -> 0x0032 }
            r1.add(r2)     // Catch:{ all -> 0x0032 }
            goto L_0x0083
        L_0x0099:
            com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount[] r6 = new com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount[r3]     // Catch:{ all -> 0x0032 }
            java.lang.Object[] r6 = r1.toArray(r6)     // Catch:{ all -> 0x0032 }
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)     // Catch:{ all -> 0x0032 }
            com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount[] r6 = (com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount[]) r6     // Catch:{ all -> 0x0032 }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0032 }
            goto L_0x00b7
        L_0x00ab:
            r6 = move-exception
            r0 = r5
        L_0x00ad:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x00b7:
            com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount[] r7 = r0.defaultValue
            boolean r1 = kotlin.Result.m6335isFailureimpl(r6)
            if (r1 == 0) goto L_0x00c0
            r6 = r7
        L_0x00c0:
            com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount[] r6 = (com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount[]) r6
            if (r6 == 0) goto L_0x00c6
            goto L_0x00c8
        L_0x00c5:
            r0 = r5
        L_0x00c6:
            com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount[] r6 = r0.defaultValue
        L_0x00c8:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository.getAutoApplyDiscounts(com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
