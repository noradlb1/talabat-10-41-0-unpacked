package com.talabat.feature.ridertips.domain;

import com.talabat.feature.ridertips.domain.model.RiderTip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/ridertips/domain/IRiderTipRepository;", "", "getRiderTip", "Lcom/talabat/feature/ridertips/domain/model/RiderTip;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRiderTip", "", "riderTipValue", "", "removeTip", "", "(Ljava/lang/Double;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_ridertips_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IRiderTipRepository {
    @Nullable
    Object getRiderTip(@NotNull Continuation<? super RiderTip> continuation);

    @Nullable
    Object saveRiderTip(@Nullable Double d11, boolean z11, @NotNull Continuation<? super Unit> continuation);
}
