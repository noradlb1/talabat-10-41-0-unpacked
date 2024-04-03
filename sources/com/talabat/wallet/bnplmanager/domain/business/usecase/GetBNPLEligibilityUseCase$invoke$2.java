package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLEligibilityDetail;
import com.talabat.wallet.bnplmanager.domain.entity.mapper.BNPLEntityMapper;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligibilityDetail;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligibilityUseCase$invoke$2", f = "GetBNPLEligibilityUseCase.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
public final class GetBNPLEligibilityUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BNPLEligibilityDetail>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12467h;

    /* renamed from: i  reason: collision with root package name */
    public int f12468i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetBNPLEligibilityUseCase f12469j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BNPLEligibilityRequestDto f12470k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetBNPLEligibilityUseCase$invoke$2(GetBNPLEligibilityUseCase getBNPLEligibilityUseCase, BNPLEligibilityRequestDto bNPLEligibilityRequestDto, Continuation<? super GetBNPLEligibilityUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12469j = getBNPLEligibilityUseCase;
        this.f12470k = bNPLEligibilityRequestDto;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetBNPLEligibilityUseCase$invoke$2(this.f12469j, this.f12470k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BNPLEligibilityDetail> continuation) {
        return ((GetBNPLEligibilityUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BNPLEntityMapper bNPLEntityMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12468i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            BNPLEntityMapper bNPLEntityMapper2 = BNPLEntityMapper.INSTANCE;
            BNPLManagerRepository access$getBNPLManagerRepository$p = this.f12469j.bNPLManagerRepository;
            BNPLEligibilityRequestDto bNPLEligibilityRequestDto = this.f12470k;
            this.f12467h = bNPLEntityMapper2;
            this.f12468i = 1;
            Object bNPLEligibilityStatus = access$getBNPLManagerRepository$p.getBNPLEligibilityStatus(bNPLEligibilityRequestDto, this);
            if (bNPLEligibilityStatus == coroutine_suspended) {
                return coroutine_suspended;
            }
            bNPLEntityMapper = bNPLEntityMapper2;
            obj = bNPLEligibilityStatus;
        } else if (i11 == 1) {
            bNPLEntityMapper = (BNPLEntityMapper) this.f12467h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (HttpException e11) {
                this.f12469j.sendErrorMessage(e11);
                BNPLEligibilityDetail mapToBNPLEligibilityDetail = BNPLEntityMapper.INSTANCE.mapToBNPLEligibilityDetail(this.f12469j.convertErrorBody(e11));
                this.f12469j.bnplTracker.onBNPLValidationError(mapToBNPLEligibilityDetail.getBNPLValidationError().getCode(), mapToBNPLEligibilityDetail.getBNPLValidationError().getDescription());
                return mapToBNPLEligibilityDetail;
            } catch (Throwable th2) {
                this.f12469j.sendErrorMessage(th2);
                return BNPLEntityMapper.INSTANCE.mapToBNPLEligibilityDetail((BNPLEligibilityRemoteDto) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return bNPLEntityMapper.mapToBNPLEligibilityDetail((BNPLEligibilityRemoteDto) obj);
    }
}
