package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\rHBø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsBasketVouchersFeatureEnabledUseCase;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "iTalabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "selectedRestaurant", "Lkotlin/Function0;", "Ldatamodels/Restaurant;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lkotlin/jvm/functions/Function0;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDarkStore", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsBasketVouchersFeatureEnabledUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerRepository customerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final ITalabatFeatureFlag iTalabatFeatureFlag;
    @NotNull
    private final Function0<Restaurant> selectedRestaurant;

    public IsBasketVouchersFeatureEnabledUseCase(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag2, @NotNull CustomerRepository customerRepository2, @NotNull Function0<? extends Restaurant> function0) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "iTalabatFeatureFlag");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(function0, "selectedRestaurant");
        this.dispatcher = coroutineDispatcher;
        this.iTalabatFeatureFlag = iTalabatFeatureFlag2;
        this.customerRepository = customerRepository2;
        this.selectedRestaurant = function0;
    }

    /* access modifiers changed from: private */
    public final boolean isDarkStore() {
        Restaurant invoke = this.selectedRestaurant.invoke();
        if (invoke == null) {
            return false;
        }
        if (invoke.isDarkStore || invoke.isMigrated) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new IsBasketVouchersFeatureEnabledUseCase$invoke$2(this, (Continuation<? super IsBasketVouchersFeatureEnabledUseCase$invoke$2>) null), continuation);
    }
}
