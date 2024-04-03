package com.talabat.wallet.bnplmanager.domain.application.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/application/usecase/GetBnplFeatureFlagUseCase;", "", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetBnplFeatureFlagUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final ITalabatFeatureFlag featureFlagRepo;

    public GetBnplFeatureFlagUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.featureFlagRepo = iTalabatFeatureFlag;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.dispatcher = coroutineDispatcher;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new GetBnplFeatureFlagUseCase$invoke$2(this, (Continuation<? super GetBnplFeatureFlagUseCase$invoke$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetBnplFeatureFlagUseCase(ITalabatFeatureFlag iTalabatFeatureFlag, ConfigurationLocalRepository configurationLocalRepository2, CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iTalabatFeatureFlag, configurationLocalRepository2, (i11 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
