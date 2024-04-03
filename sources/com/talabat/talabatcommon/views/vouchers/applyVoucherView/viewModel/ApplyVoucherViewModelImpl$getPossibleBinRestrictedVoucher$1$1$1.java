package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/BinRestrictedVoucherModel;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {284}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BinRestrictedVoucherModel>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11815h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11816i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f11817j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f11818k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f11819l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, String str, String str2, int i11, Continuation<? super ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1> continuation) {
        super(2, continuation);
        this.f11816i = applyVoucherViewModelImpl;
        this.f11817j = str;
        this.f11818k = str2;
        this.f11819l = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1(this.f11816i, this.f11817j, this.f11818k, this.f11819l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BinRestrictedVoucherModel> continuation) {
        return ((ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11815h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            int i12 = this.f11819l;
            this.f11815h = 1;
            obj = this.f11816i.getPossibleBinRestrictedVoucherUseCase.invoke(this.f11817j, this.f11818k, (Integer) this.f11816i.selectedAreaId.invoke(), i12, this);
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
