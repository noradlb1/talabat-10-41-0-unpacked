package com.talabat.wallet.bnplmanager.data.local;

import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteResultDto;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/local/BNPLManagerLocalDataSourceImpl;", "Lcom/talabat/wallet/bnplmanager/data/local/BNPLManagerLocalDataSource;", "()V", "eligibilityRemoteDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;", "isIsUserSeenBnplPaymentFallbackOption", "", "getBNPLEligibilityStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIsUserSeenBnplPaymentFallbackOption", "setBNPLEligibilityStatus", "", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setIsUserSeenBnplPaymentFallbackOption", "seenOptions", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLManagerLocalDataSourceImpl implements BNPLManagerLocalDataSource {
    @NotNull
    private BNPLEligibilityRemoteDto eligibilityRemoteDto = new BNPLEligibilityRemoteDto((BNPLEligibilityRemoteResultDto) null, 1, (DefaultConstructorMarker) null);
    private boolean isIsUserSeenBnplPaymentFallbackOption;

    @Nullable
    public Object getBNPLEligibilityStatus(@NotNull Continuation<? super BNPLEligibilityRemoteDto> continuation) {
        return this.eligibilityRemoteDto;
    }

    @Nullable
    public Object getIsUserSeenBnplPaymentFallbackOption(@NotNull Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(this.isIsUserSeenBnplPaymentFallbackOption);
    }

    @Nullable
    public Object setBNPLEligibilityStatus(@NotNull BNPLEligibilityRemoteDto bNPLEligibilityRemoteDto, @NotNull Continuation<? super Unit> continuation) {
        this.eligibilityRemoteDto = bNPLEligibilityRemoteDto;
        return Unit.INSTANCE;
    }

    @Nullable
    public Object setIsUserSeenBnplPaymentFallbackOption(boolean z11, @NotNull Continuation<? super Unit> continuation) {
        this.isIsUserSeenBnplPaymentFallbackOption = z11;
        return Unit.INSTANCE;
    }
}
