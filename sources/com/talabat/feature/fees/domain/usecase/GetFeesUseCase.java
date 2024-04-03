package com.talabat.feature.fees.domain.usecase;

import com.talabat.feature.fees.domain.model.Fee;
import com.talabat.feature.fees.domain.model.Fees;
import com.talabat.feature.fees.domain.repository.IPricingRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J9\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fHBø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/fees/domain/usecase/GetFeesUseCase;", "", "pricingRepository", "Lcom/talabat/feature/fees/domain/repository/IPricingRepository;", "(Lcom/talabat/feature/fees/domain/repository/IPricingRepository;)V", "getFallbackFess", "Lcom/talabat/feature/fees/domain/model/Fees;", "feesAndDescriptions", "subTotal", "", "invoke", "subtotalBeforeDiscounts", "subtotal", "couponDiscount", "latitude", "", "longitude", "(FFFDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_pricing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetFeesUseCase {
    @NotNull
    private final IPricingRepository pricingRepository;

    @Inject
    public GetFeesUseCase(@NotNull IPricingRepository iPricingRepository) {
        Intrinsics.checkNotNullParameter(iPricingRepository, "pricingRepository");
        this.pricingRepository = iPricingRepository;
    }

    private final Fees getFallbackFess(Fees fees, float f11) {
        if (fees == null) {
            return null;
        }
        Iterable<Fee> fees2 = fees.getFees();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(fees2, 10));
        for (Fee fee : fees2) {
            if (Intrinsics.areEqual((Object) fee.getFeeType(), (Object) "ServiceFee")) {
                fee = new ServiceFeeFallback(fee, f11).calculate();
            }
            arrayList.add(fee);
        }
        return Fees.copy$default(fees, arrayList, (List) null, 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(float r15, float r16, float r17, double r18, double r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.fees.domain.model.Fees> r22) {
        /*
            r14 = this;
            r0 = r14
            r1 = r22
            boolean r2 = r1 instanceof com.talabat.feature.fees.domain.usecase.GetFeesUseCase$invoke$1
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.talabat.feature.fees.domain.usecase.GetFeesUseCase$invoke$1 r2 = (com.talabat.feature.fees.domain.usecase.GetFeesUseCase$invoke$1) r2
            int r3 = r2.f58536l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f58536l = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.feature.fees.domain.usecase.GetFeesUseCase$invoke$1 r2 = new com.talabat.feature.fees.domain.usecase.GetFeesUseCase$invoke$1
            r2.<init>(r14, r1)
        L_0x001b:
            r12 = r2
            java.lang.Object r1 = r12.f58534j
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r12.f58536l
            r4 = 1
            if (r3 == 0) goto L_0x003f
            if (r3 != r4) goto L_0x0037
            float r2 = r12.f58533i
            java.lang.Object r3 = r12.f58532h
            com.talabat.feature.fees.domain.usecase.GetFeesUseCase r3 = (com.talabat.feature.fees.domain.usecase.GetFeesUseCase) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r3
            r3 = r1
            r1 = r2
            r2 = r13
            goto L_0x0064
        L_0x0037:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r1)
            com.talabat.feature.fees.domain.repository.IPricingRepository r3 = r0.pricingRepository
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r15)
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r16)
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r17)
            r11 = 1
            r12.f58532h = r0
            r1 = r15
            r12.f58533i = r1
            r12.f58536l = r4
            r4 = r18
            r6 = r20
            java.lang.Object r3 = r3.getFees(r4, r6, r8, r9, r10, r11, r12)
            if (r3 != r2) goto L_0x0063
            return r2
        L_0x0063:
            r2 = r0
        L_0x0064:
            com.talabat.feature.fees.domain.repository.FeesResult r3 = (com.talabat.feature.fees.domain.repository.FeesResult) r3
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            com.talabat.feature.fees.domain.model.Fees r5 = r3.getFees()
            r4.element = r5
            if (r5 != 0) goto L_0x007f
            com.talabat.feature.fees.domain.model.Fees r3 = r3.getCachedFees()
            if (r3 == 0) goto L_0x007f
            com.talabat.feature.fees.domain.model.Fees r1 = r2.getFallbackFess(r3, r1)
            r4.element = r1
        L_0x007f:
            T r1 = r4.element
            com.talabat.feature.fees.domain.model.Fees r1 = (com.talabat.feature.fees.domain.model.Fees) r1
            if (r1 != 0) goto L_0x0092
            com.talabat.feature.fees.domain.model.Fees r1 = new com.talabat.feature.fees.domain.model.Fees
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r1.<init>(r2, r3)
        L_0x0092:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.fees.domain.usecase.GetFeesUseCase.invoke(float, float, float, double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
