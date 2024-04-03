package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.response.BNPLOrderPaymentRemoteDto;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLOrderPaymentError;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLOrderPaymentStatus;
import com.talabat.wallet.bnplmanager.domain.entity.mapper.BNPLEntityMapper;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentStatus;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.domain.business.usecase.GetPayOrderWithBNPLUseCase$invoke$2", f = "GetPayOrderWithBNPLUseCase.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
public final class GetPayOrderWithBNPLUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BNPLOrderPaymentStatus>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12481h;

    /* renamed from: i  reason: collision with root package name */
    public int f12482i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetPayOrderWithBNPLUseCase f12483j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BNPLOrderPaymentRequestDto f12484k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetPayOrderWithBNPLUseCase$invoke$2(GetPayOrderWithBNPLUseCase getPayOrderWithBNPLUseCase, BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto, Continuation<? super GetPayOrderWithBNPLUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12483j = getPayOrderWithBNPLUseCase;
        this.f12484k = bNPLOrderPaymentRequestDto;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetPayOrderWithBNPLUseCase$invoke$2(this.f12483j, this.f12484k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BNPLOrderPaymentStatus> continuation) {
        return ((GetPayOrderWithBNPLUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BNPLEntityMapper bNPLEntityMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12482i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            BNPLEntityMapper bNPLEntityMapper2 = BNPLEntityMapper.INSTANCE;
            BNPLManagerRepository access$getBNPLManagerRepository$p = this.f12483j.bNPLManagerRepository;
            BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto = this.f12484k;
            this.f12481h = bNPLEntityMapper2;
            this.f12482i = 1;
            Object payOrderWithBNPL = access$getBNPLManagerRepository$p.payOrderWithBNPL(bNPLOrderPaymentRequestDto, this);
            if (payOrderWithBNPL == coroutine_suspended) {
                return coroutine_suspended;
            }
            bNPLEntityMapper = bNPLEntityMapper2;
            obj = payOrderWithBNPL;
        } else if (i11 == 1) {
            bNPLEntityMapper = (BNPLEntityMapper) this.f12481h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (HttpException e11) {
                this.f12483j.sendErrorMessage(e11);
                return BNPLEntityMapper.INSTANCE.mapToBNPLOrderPaymentStatus(this.f12483j.convertErrorBody(e11));
            } catch (Throwable th2) {
                this.f12483j.sendErrorMessage(th2);
                return new BNPLOrderPaymentStatus(false, (BNPLOrderPaymentError) null, true, 3, (DefaultConstructorMarker) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return bNPLEntityMapper.mapToBNPLOrderPaymentStatus((BNPLOrderPaymentRemoteDto) obj);
    }
}
