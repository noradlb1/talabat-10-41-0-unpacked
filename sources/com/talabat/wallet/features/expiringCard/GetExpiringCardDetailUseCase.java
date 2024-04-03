package com.talabat.wallet.features.expiringCard;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.functional.EitherKt;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.wallet.features.expiringCard.model.ExpiringCardResponse;
import com.talabat.wallet.features.expiringCard.repository.ExpiringCardRepository;
import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import com.talabat.wallet.ui.expiringCard.model.ExpiringCardMapper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/wallet/features/expiringCard/GetExpiringCardDetailUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "", "expiringCardRepository", "Lcom/talabat/wallet/features/expiringCard/repository/ExpiringCardRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "mapper", "Lkotlin/Function1;", "Lcom/talabat/wallet/features/expiringCard/model/ExpiringCardResponse;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/wallet/features/expiringCard/repository/ExpiringCardRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetExpiringCardDetailUseCase extends UseCase<ExpiringCardDetailDisplayModel, Integer> {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final ExpiringCardRepository expiringCardRepository;
    @NotNull
    private final Function1<ExpiringCardResponse, ExpiringCardDetailDisplayModel> mapper;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetExpiringCardDetailUseCase(ExpiringCardRepository expiringCardRepository2, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, Function1 function1, ConfigurationLocalRepository configurationLocalRepository2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(expiringCardRepository2, coroutineScope, coroutineDispatcher, (i11 & 8) != 0 ? new Function1<ExpiringCardResponse, ExpiringCardDetailDisplayModel>(ExpiringCardMapper.Companion) {
            @NotNull
            public final ExpiringCardDetailDisplayModel invoke(@Nullable ExpiringCardResponse expiringCardResponse) {
                return ((ExpiringCardMapper.Companion) this.receiver).mapExpiringCardResponseToExpiryDetailDisplayModel(expiringCardResponse);
            }
        } : function1, configurationLocalRepository2);
    }

    public /* bridge */ /* synthetic */ Object run(Object obj, Continuation continuation) {
        return run(((Number) obj).intValue(), (Continuation<? super Either<? extends Failure, ExpiringCardDetailDisplayModel>>) continuation);
    }

    @Nullable
    public Object run(int i11, @NotNull Continuation<? super Either<? extends Failure, ExpiringCardDetailDisplayModel>> continuation) {
        return EitherKt.map(this.expiringCardRepository.getExpiringCardDetail(i11), this.mapper);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetExpiringCardDetailUseCase(@NotNull ExpiringCardRepository expiringCardRepository2, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function1<? super ExpiringCardResponse, ExpiringCardDetailDisplayModel> function1, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(expiringCardRepository2, "expiringCardRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.expiringCardRepository = expiringCardRepository2;
        this.mapper = function1;
        this.configurationLocalRepository = configurationLocalRepository2;
    }
}
