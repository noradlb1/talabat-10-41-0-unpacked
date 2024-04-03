package com.talabat.growth.ui.vouchers.entrypoint.viewmodel;

import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ActiveVouchersUseCase;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel$getActiveVouchers$1", f = "VoucherEntryPointViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoucherEntryPointViewModel$getActiveVouchers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f60711h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VoucherEntryPointViewModel f60712i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoucherEntryPointViewModel$getActiveVouchers$1(VoucherEntryPointViewModel voucherEntryPointViewModel, Continuation<? super VoucherEntryPointViewModel$getActiveVouchers$1> continuation) {
        super(2, continuation);
        this.f60712i = voucherEntryPointViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VoucherEntryPointViewModel$getActiveVouchers$1 voucherEntryPointViewModel$getActiveVouchers$1 = new VoucherEntryPointViewModel$getActiveVouchers$1(this.f60712i, continuation);
        voucherEntryPointViewModel$getActiveVouchers$1.L$0 = obj;
        return voucherEntryPointViewModel$getActiveVouchers$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoucherEntryPointViewModel$getActiveVouchers$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        boolean z11;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60711h == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            VoucherEntryPointViewModel voucherEntryPointViewModel = this.f60712i;
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.m6329constructorimpl(Boxing.boxInt(voucherEntryPointViewModel.activeVouchersUseCase.invoke(voucherEntryPointViewModel.configurationLocalCoreLibApi.getRepository().selectedCountry().getCountryId()).getTotalActiveCount()));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            VoucherEntryPointViewModel voucherEntryPointViewModel2 = this.f60712i;
            if (Result.m6336isSuccessimpl(obj2)) {
                int intValue = ((Number) obj2).intValue();
                if (intValue == ActiveVouchersUseCase.Companion.getNO_ACTIVE_VOUCHERS().getTotalActiveCount()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                voucherEntryPointViewModel2.getActiveVouchersCount().postValue(Boxing.boxInt(intValue));
                voucherEntryPointViewModel2.getActiveVouchers().postValue(voucherEntryPointViewModel2.voucherCountTextUseCase.invoke(intValue));
                voucherEntryPointViewModel2.getHideActiveVouchers().postValue(Boxing.boxBoolean(z11));
            }
            VoucherEntryPointViewModel voucherEntryPointViewModel3 = this.f60712i;
            if (Result.m6332exceptionOrNullimpl(obj2) != null) {
                voucherEntryPointViewModel3.getHideActiveVouchers().postValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
