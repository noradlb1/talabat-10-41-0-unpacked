package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.response.BNPLOrderPaymentRemoteDto;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLOrderPaymentStatus;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import retrofit2.Response;

@Instrumented
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010HBø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetPayOrderWithBNPLUseCase;", "", "bNPLManagerRepository", "Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "convertErrorBody", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentRemoteDto;", "throwable", "Lretrofit2/HttpException;", "invoke", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentStatus;", "bNPLOrderPaymentRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendErrorMessage", "", "ex", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPayOrderWithBNPLUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final BNPLManagerRepository bNPLManagerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final IObservabilityManager observabilityManager;

    public GetPayOrderWithBNPLUseCase(@NotNull BNPLManagerRepository bNPLManagerRepository2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(bNPLManagerRepository2, "bNPLManagerRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.bNPLManagerRepository = bNPLManagerRepository2;
        this.dispatcher = coroutineDispatcher;
        this.observabilityManager = iObservabilityManager;
    }

    /* access modifiers changed from: private */
    public final BNPLOrderPaymentRemoteDto convertErrorBody(HttpException httpException) {
        ResponseBody errorBody;
        try {
            Response<?> response = httpException.response();
            if (response == null || (errorBody = response.errorBody()) == null) {
                return null;
            }
            return (BNPLOrderPaymentRemoteDto) GsonInstrumentation.fromJson(new Gson(), errorBody.string(), BNPLOrderPaymentRemoteDto.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void sendErrorMessage(Throwable th2) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        Pair[] pairArr = new Pair[1];
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        pairArr[0] = TuplesKt.to("errorMessage", message);
        iObservabilityManager.trackUnExpectedScenario("BNPL order payment API failed", MapsKt__MapsKt.mutableMapOf(pairArr));
    }

    @Nullable
    public final Object invoke(@NotNull BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto, @NotNull Continuation<? super BNPLOrderPaymentStatus> continuation) {
        return BuildersKt.withContext(this.dispatcher, new GetPayOrderWithBNPLUseCase$invoke$2(this, bNPLOrderPaymentRequestDto, (Continuation<? super GetPayOrderWithBNPLUseCase$invoke$2>) null), continuation);
    }
}
