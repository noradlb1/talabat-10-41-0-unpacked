package com.talabat.feature.fees.domain.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/fees/domain/repository/IPricingRepository;", "", "getFees", "Lcom/talabat/feature/fees/domain/repository/FeesResult;", "latitude", "", "longitude", "subtotalBeforeDiscounts", "", "subtotal", "couponDiscount", "forceUpdate", "", "(DDLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_pricing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPricingRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getFees$default(IPricingRepository iPricingRepository, double d11, double d12, Float f11, Float f12, Float f13, boolean z11, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                return iPricingRepository.getFees(d11, d12, (i11 & 4) != 0 ? null : f11, (i11 & 8) != 0 ? null : f12, (i11 & 16) != 0 ? null : f13, (i11 & 32) != 0 ? false : z11, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFees");
        }
    }

    @Nullable
    Object getFees(double d11, double d12, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13, boolean z11, @NotNull Continuation<? super FeesResult> continuation);
}
