package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\u0006HBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetOrderConfirmationRiderTipFeatureUseCase;", "", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "isCustomerLoggedInProvider", "Lkotlin/Function0;", "", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lkotlin/jvm/functions/Function0;)V", "invoke", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOrderConfirmationRiderTipFeatureUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final ITalabatFeatureFlag featureFlagRepo;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Boolean> isCustomerLoggedInProvider;

    public GetOrderConfirmationRiderTipFeatureUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(function0, "isCustomerLoggedInProvider");
        this.featureFlagRepo = iTalabatFeatureFlag;
        this.isCustomerLoggedInProvider = function0;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GetOrderConfirmationRiderTipFeatureUseCase$invoke$2(this, (Continuation<? super GetOrderConfirmationRiderTipFeatureUseCase$invoke$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetOrderConfirmationRiderTipFeatureUseCase(ITalabatFeatureFlag iTalabatFeatureFlag, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iTalabatFeatureFlag, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
