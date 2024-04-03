package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentRequestModel;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentsRemoteDto;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLInstallments;
import com.talabat.wallet.bnplmanager.domain.entity.mapper.BNPLEntityMapper;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLInstallments;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLInstallmentsUseCase$invoke$2", f = "GetBNPLInstallmentsUseCase.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
public final class GetBNPLInstallmentsUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BNPLInstallments>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f12476h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetBNPLInstallmentsUseCase f12477i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BNPLInstallmentRequestModel f12478j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetBNPLInstallmentsUseCase$invoke$2(GetBNPLInstallmentsUseCase getBNPLInstallmentsUseCase, BNPLInstallmentRequestModel bNPLInstallmentRequestModel, Continuation<? super GetBNPLInstallmentsUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12477i = getBNPLInstallmentsUseCase;
        this.f12478j = bNPLInstallmentRequestModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetBNPLInstallmentsUseCase$invoke$2 getBNPLInstallmentsUseCase$invoke$2 = new GetBNPLInstallmentsUseCase$invoke$2(this.f12477i, this.f12478j, continuation);
        getBNPLInstallmentsUseCase$invoke$2.L$0 = obj;
        return getBNPLInstallmentsUseCase$invoke$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BNPLInstallments> continuation) {
        return ((GetBNPLInstallmentsUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        BNPLEntityMapper bNPLEntityMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12476h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            GetBNPLInstallmentsUseCase getBNPLInstallmentsUseCase = this.f12477i;
            BNPLInstallmentRequestModel bNPLInstallmentRequestModel = this.f12478j;
            Result.Companion companion = Result.Companion;
            BNPLEntityMapper bNPLEntityMapper2 = BNPLEntityMapper.INSTANCE;
            BNPLManagerRepository access$getBNPLManagerRepository$p = getBNPLInstallmentsUseCase.bNPLManagerRepository;
            this.L$0 = bNPLEntityMapper2;
            this.f12476h = 1;
            obj = access$getBNPLManagerRepository$p.getBNPLInstallments(bNPLInstallmentRequestModel, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            bNPLEntityMapper = bNPLEntityMapper2;
        } else if (i11 == 1) {
            bNPLEntityMapper = (BNPLEntityMapper) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl(bNPLEntityMapper.mapToBNPLInstallments((BNPLInstallmentsRemoteDto) obj));
        GetBNPLInstallmentsUseCase getBNPLInstallmentsUseCase2 = this.f12477i;
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj2);
        if (r12 == null) {
            return obj2;
        }
        IObservabilityManager access$getObservabilityManager$p = getBNPLInstallmentsUseCase2.observabilityManager;
        Pair[] pairArr = new Pair[1];
        String message = r12.getMessage();
        if (message == null) {
            message = "";
        }
        pairArr[0] = TuplesKt.to("errorMessage", message);
        access$getObservabilityManager$p.trackUnExpectedScenario("BNPL get installments API failed", MapsKt__MapsKt.mutableMapOf(pairArr));
        BNPLInstallments bNPLInstallments = new BNPLInstallments();
        bNPLInstallments.setServerError(true);
        return bNPLInstallments;
    }
}
