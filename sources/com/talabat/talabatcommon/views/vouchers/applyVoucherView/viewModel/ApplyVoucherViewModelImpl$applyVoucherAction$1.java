package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import datamodels.CartMenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$applyVoucherAction$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$applyVoucherAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f11773h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11774i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VoucherDisplayModel f11775j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f11776k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f11777l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f11778m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f11779n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f11780o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ List<CartMenuItem> f11781p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f11782q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$applyVoucherAction$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, VoucherDisplayModel voucherDisplayModel, float f11, String str, String str2, String str3, int i11, List<? extends CartMenuItem> list, int i12, Continuation<? super ApplyVoucherViewModelImpl$applyVoucherAction$1> continuation) {
        super(2, continuation);
        this.f11774i = applyVoucherViewModelImpl;
        this.f11775j = voucherDisplayModel;
        this.f11776k = f11;
        this.f11777l = str;
        this.f11778m = str2;
        this.f11779n = str3;
        this.f11780o = i11;
        this.f11781p = list;
        this.f11782q = i12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ApplyVoucherViewModelImpl$applyVoucherAction$1 applyVoucherViewModelImpl$applyVoucherAction$1 = new ApplyVoucherViewModelImpl$applyVoucherAction$1(this.f11774i, this.f11775j, this.f11776k, this.f11777l, this.f11778m, this.f11779n, this.f11780o, this.f11781p, this.f11782q, continuation);
        applyVoucherViewModelImpl$applyVoucherAction$1.L$0 = obj;
        return applyVoucherViewModelImpl$applyVoucherAction$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ApplyVoucherViewModelImpl$applyVoucherAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11773h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ApplyVoucherViewModelImpl applyVoucherViewModelImpl = this.f11774i;
            VoucherDisplayModel voucherDisplayModel = this.f11775j;
            float f11 = this.f11776k;
            String str = this.f11777l;
            String str2 = this.f11778m;
            String str3 = this.f11779n;
            int i12 = this.f11780o;
            List<CartMenuItem> list = this.f11781p;
            int i13 = this.f11782q;
            Result.Companion companion = Result.Companion;
            CoroutineDispatcher access$getIoDispatcher$p = applyVoucherViewModelImpl.ioDispatcher;
            ApplyVoucherViewModelImpl$applyVoucherAction$1$1$1 applyVoucherViewModelImpl$applyVoucherAction$1$1$1 = new ApplyVoucherViewModelImpl$applyVoucherAction$1$1$1(applyVoucherViewModelImpl, voucherDisplayModel, f11, str, str2, str3, i12, list, i13, (Continuation<? super ApplyVoucherViewModelImpl$applyVoucherAction$1$1$1>) null);
            this.f11773h = 1;
            obj = BuildersKt.withContext(access$getIoDispatcher$p, applyVoucherViewModelImpl$applyVoucherAction$1$1$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((Pair) obj);
        ApplyVoucherViewModelImpl applyVoucherViewModelImpl2 = this.f11774i;
        VoucherDisplayModel voucherDisplayModel2 = this.f11775j;
        String str4 = this.f11778m;
        int i14 = this.f11782q;
        if (Result.m6336isSuccessimpl(obj2)) {
            Pair pair = (Pair) obj2;
            if (applyVoucherViewModelImpl2.isBinRestrictionForAppliedVoucherEnabled()) {
                applyVoucherViewModelImpl2.getPossibleBinRestrictedVoucher(voucherDisplayModel2.getVoucherData().getId(), str4, i14);
            }
            applyVoucherViewModelImpl2.updateViewState(new ApplyVouchersViewStates.ApplyVoucher(pair));
        }
        ApplyVoucherViewModelImpl applyVoucherViewModelImpl3 = this.f11774i;
        Throwable r15 = Result.m6332exceptionOrNullimpl(obj2);
        if (r15 != null) {
            applyVoucherViewModelImpl3.updateViewState(new ApplyVouchersViewStates.ApplyVouchersFailure((VoucherFailures) r15));
        }
        return Unit.INSTANCE;
    }
}
