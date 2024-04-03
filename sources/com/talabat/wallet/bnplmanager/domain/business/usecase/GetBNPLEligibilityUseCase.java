package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import com.talabat.wallet.bnplmanager.domain.tracking.BNPLTracker;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012HBø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligibilityUseCase;", "", "bNPLManagerRepository", "Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "bnplTracker", "Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTracker;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/wallet/bnplmanager/domain/tracking/BNPLTracker;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "convertErrorBody", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;", "throwable", "Lretrofit2/HttpException;", "invoke", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligibilityDetail;", "bNPLEligibilityRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendErrorMessage", "", "ex", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetBNPLEligibilityUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final BNPLManagerRepository bNPLManagerRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final BNPLTracker bnplTracker;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final IObservabilityManager observabilityManager;

    public GetBNPLEligibilityUseCase(@NotNull BNPLManagerRepository bNPLManagerRepository2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull BNPLTracker bNPLTracker, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(bNPLManagerRepository2, "bNPLManagerRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(bNPLTracker, "bnplTracker");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.bNPLManagerRepository = bNPLManagerRepository2;
        this.dispatcher = coroutineDispatcher;
        this.bnplTracker = bNPLTracker;
        this.observabilityManager = iObservabilityManager;
    }

    /* access modifiers changed from: private */
    public final BNPLEligibilityRemoteDto convertErrorBody(HttpException httpException) {
        ResponseBody errorBody;
        try {
            Response<?> response = httpException.response();
            if (response == null || (errorBody = response.errorBody()) == null) {
                return null;
            }
            return (BNPLEligibilityRemoteDto) GsonInstrumentation.fromJson(new Gson(), errorBody.string(), BNPLEligibilityRemoteDto.class);
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
        iObservabilityManager.trackUnExpectedScenario("BNPL get Eligibility API failed", MapsKt__MapsKt.mutableMapOf(pairArr));
    }

    @Nullable
    public final Object invoke(@NotNull BNPLEligibilityRequestDto bNPLEligibilityRequestDto, @NotNull Continuation<? super BNPLEligibilityDetail> continuation) {
        return BuildersKt.withContext(this.dispatcher, new GetBNPLEligibilityUseCase$invoke$2(this, bNPLEligibilityRequestDto, (Continuation<? super GetBNPLEligibilityUseCase$invoke$2>) null), continuation);
    }
}
