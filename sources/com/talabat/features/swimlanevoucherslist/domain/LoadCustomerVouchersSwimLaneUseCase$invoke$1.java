package com.talabat.features.swimlanevoucherslist.domain;

import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import com.talabat.features.swimlanevoucherslist.domain.model.VouchersSwimLaneRequest;
import com.talabat.features.swimlanevoucherslist.domain.repository.CustomerVouchersSwimLaneRepository;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.features.swimlanevoucherslist.domain.LoadCustomerVouchersSwimLaneUseCase$invoke$1", f = "LoadCustomerVouchersSwimLaneUseCase.kt", i = {}, l = {13}, m = "invokeSuspend", n = {}, s = {})
public final class LoadCustomerVouchersSwimLaneUseCase$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends CustomerVoucher>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59459h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LoadCustomerVouchersSwimLaneUseCase f59460i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VouchersSwimLaneRequest f59461j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadCustomerVouchersSwimLaneUseCase$invoke$1(LoadCustomerVouchersSwimLaneUseCase loadCustomerVouchersSwimLaneUseCase, VouchersSwimLaneRequest vouchersSwimLaneRequest, Continuation<? super LoadCustomerVouchersSwimLaneUseCase$invoke$1> continuation) {
        super(2, continuation);
        this.f59460i = loadCustomerVouchersSwimLaneUseCase;
        this.f59461j = vouchersSwimLaneRequest;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LoadCustomerVouchersSwimLaneUseCase$invoke$1(this.f59460i, this.f59461j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<CustomerVoucher>> continuation) {
        return ((LoadCustomerVouchersSwimLaneUseCase$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59459h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CustomerVouchersSwimLaneRepository access$getVouchersSwimLaneRepository$p = this.f59460i.vouchersSwimLaneRepository;
            VouchersSwimLaneRequest vouchersSwimLaneRequest = this.f59461j;
            this.f59459h = 1;
            obj = access$getVouchersSwimLaneRepository$p.getCustomerVouchersSwimLane(vouchersSwimLaneRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
