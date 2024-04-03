package com.talabat.wallet.features.walletCashBack;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.functional.EitherKt;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.wallet.features.walletCashBack.model.request.WalletCalculateCashBackRequestModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCalculateCashBackResponse;
import com.talabat.wallet.features.walletCashBack.repository.WalletCashBackRepository;
import com.talabat.wallet.ui.walletTopUp.model.WalletCalculateCashBackDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletTopUpCardListMapper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/GetCalculatedCashBackUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCalculateCashBackDisplayModel;", "Lcom/talabat/wallet/features/walletCashBack/model/request/WalletCalculateCashBackRequestModel;", "walletCashBackRepository", "Lcom/talabat/wallet/features/walletCashBack/repository/WalletCashBackRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "mapper", "Lkotlin/Function1;", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponse;", "(Lcom/talabat/wallet/features/walletCashBack/repository/WalletCashBackRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/wallet/features/walletCashBack/model/request/WalletCalculateCashBackRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCalculatedCashBackUseCase extends UseCase<WalletCalculateCashBackDisplayModel, WalletCalculateCashBackRequestModel> {
    @NotNull
    private final Function1<WalletCalculateCashBackResponse, WalletCalculateCashBackDisplayModel> mapper;
    @NotNull
    private final WalletCashBackRepository walletCashBackRepository;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCalculatedCashBackUseCase(WalletCashBackRepository walletCashBackRepository2, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(walletCashBackRepository2, coroutineScope, coroutineDispatcher, (i11 & 8) != 0 ? new Function1<WalletCalculateCashBackResponse, WalletCalculateCashBackDisplayModel>(WalletTopUpCardListMapper.Companion) {
            @NotNull
            public final WalletCalculateCashBackDisplayModel invoke(@Nullable WalletCalculateCashBackResponse walletCalculateCashBackResponse) {
                return ((WalletTopUpCardListMapper.Companion) this.receiver).mapCalculatedCashBackResponseToDisplayModel(walletCalculateCashBackResponse);
            }
        } : function1);
    }

    @Nullable
    public Object run(@NotNull WalletCalculateCashBackRequestModel walletCalculateCashBackRequestModel, @NotNull Continuation<? super Either<? extends Failure, WalletCalculateCashBackDisplayModel>> continuation) {
        return EitherKt.map(this.walletCashBackRepository.getCalculatedCashBack(walletCalculateCashBackRequestModel), this.mapper);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetCalculatedCashBackUseCase(@NotNull WalletCashBackRepository walletCashBackRepository2, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function1<? super WalletCalculateCashBackResponse, WalletCalculateCashBackDisplayModel> function1) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(walletCashBackRepository2, "walletCashBackRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        this.walletCashBackRepository = walletCashBackRepository2;
        this.mapper = function1;
    }
}
