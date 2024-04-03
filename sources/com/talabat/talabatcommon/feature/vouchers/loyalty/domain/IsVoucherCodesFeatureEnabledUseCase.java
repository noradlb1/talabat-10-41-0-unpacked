package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsVoucherCodesFeatureEnabledUseCase;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "iTalabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsVoucherCodesFeatureEnabledUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerRepository customerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final ITalabatFeatureFlag iTalabatFeatureFlag;

    public IsVoucherCodesFeatureEnabledUseCase(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag2, @NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "iTalabatFeatureFlag");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        this.dispatcher = coroutineDispatcher;
        this.iTalabatFeatureFlag = iTalabatFeatureFlag2;
        this.customerRepository = customerRepository2;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new IsVoucherCodesFeatureEnabledUseCase$invoke$2(this, (Continuation<? super IsVoucherCodesFeatureEnabledUseCase$invoke$2>) null), continuation);
    }
}
