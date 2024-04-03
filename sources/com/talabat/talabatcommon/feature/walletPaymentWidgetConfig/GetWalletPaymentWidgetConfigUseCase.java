package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig;

import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigResponse;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.repository.WalletPaymentWidgetRepository;
import com.talabat.talabatcommon.views.wallet.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigMapper;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.functional.EitherKt;
import com.talabat.talabatcore.interactor.UseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/GetWalletPaymentWidgetConfigUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigDisplayModel;", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/WalletPaymentWidgetParam;", "walletPaymentWidgetRepository", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/repository/WalletPaymentWidgetRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "mapper", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResponse;", "(Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/repository/WalletPaymentWidgetRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/WalletPaymentWidgetParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetWalletPaymentWidgetConfigUseCase extends UseCase<WalletPaymentWidgetConfigDisplayModel, WalletPaymentWidgetParam> {
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<WalletPaymentWidgetConfigResponse, WalletPaymentWidgetConfigDisplayModel> mapper;
    @NotNull
    private final WalletPaymentWidgetRepository walletPaymentWidgetRepository;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetWalletPaymentWidgetConfigUseCase(WalletPaymentWidgetRepository walletPaymentWidgetRepository2, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(walletPaymentWidgetRepository2, coroutineScope, coroutineDispatcher, (i11 & 8) != 0 ? new Function1<WalletPaymentWidgetConfigResponse, WalletPaymentWidgetConfigDisplayModel>(WalletPaymentWidgetConfigMapper.Companion) {
            @NotNull
            public final WalletPaymentWidgetConfigDisplayModel invoke(@Nullable WalletPaymentWidgetConfigResponse walletPaymentWidgetConfigResponse) {
                return ((WalletPaymentWidgetConfigMapper.Companion) this.receiver).mapWalletPaymentWidgetResponseModelToDisplayModel(walletPaymentWidgetConfigResponse);
            }
        } : function1);
    }

    @Nullable
    public Object run(@NotNull WalletPaymentWidgetParam walletPaymentWidgetParam, @NotNull Continuation<? super Either<? extends Failure, WalletPaymentWidgetConfigDisplayModel>> continuation) {
        return EitherKt.map(this.walletPaymentWidgetRepository.getWalletPaymentWidgetConfig(walletPaymentWidgetParam.getCountry(), walletPaymentWidgetParam.getComponentId(), walletPaymentWidgetParam.getFeatureId()), new GetWalletPaymentWidgetConfigUseCase$run$2(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetWalletPaymentWidgetConfigUseCase(@NotNull WalletPaymentWidgetRepository walletPaymentWidgetRepository2, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function1<? super WalletPaymentWidgetConfigResponse, WalletPaymentWidgetConfigDisplayModel> function1) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(walletPaymentWidgetRepository2, "walletPaymentWidgetRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        this.walletPaymentWidgetRepository = walletPaymentWidgetRepository2;
        this.mapper = function1;
    }
}
