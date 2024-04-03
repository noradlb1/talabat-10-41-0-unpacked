package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.exception.Failure;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {401}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f11820h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11821i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f11822j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f11823k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f11824l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f11825m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f11826n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f11827o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ String f11828p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ List<CartMenuItem> f11829q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f11830r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, float f11, String str, String str2, int i11, int i12, String str3, String str4, List<? extends CartMenuItem> list, int i13, Continuation<? super ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1> continuation) {
        super(2, continuation);
        this.f11821i = applyVoucherViewModelImpl;
        this.f11822j = f11;
        this.f11823k = str;
        this.f11824l = str2;
        this.f11825m = i11;
        this.f11826n = i12;
        this.f11827o = str3;
        this.f11828p = str4;
        this.f11829q = list;
        this.f11830r = i13;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1 applyVoucherViewModelImpl$handleAddVoucherCodeAction$1 = new ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1(this.f11821i, this.f11822j, this.f11823k, this.f11824l, this.f11825m, this.f11826n, this.f11827o, this.f11828p, this.f11829q, this.f11830r, continuation);
        applyVoucherViewModelImpl$handleAddVoucherCodeAction$1.L$0 = obj;
        return applyVoucherViewModelImpl$handleAddVoucherCodeAction$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        VoucherFailures voucherFailures;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11820h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ApplyVoucherViewModelImpl applyVoucherViewModelImpl = this.f11821i;
            float f11 = this.f11822j;
            String str = this.f11823k;
            String str2 = this.f11824l;
            int i12 = this.f11825m;
            int i13 = this.f11826n;
            String str3 = this.f11827o;
            String str4 = this.f11828p;
            List<CartMenuItem> list = this.f11829q;
            int i14 = this.f11830r;
            Result.Companion companion = Result.Companion;
            CoroutineDispatcher access$getIoDispatcher$p = applyVoucherViewModelImpl.ioDispatcher;
            ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1 applyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1 = r4;
            ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1 applyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$12 = new ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1(applyVoucherViewModelImpl, f11, str, str2, i12, i13, str3, str4, list, i14, (Continuation<? super ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1>) null);
            this.f11820h = 1;
            obj3 = BuildersKt.withContext(access$getIoDispatcher$p, applyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1, this);
            if (obj3 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
                obj3 = obj;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((Pair) obj3);
        ApplyVoucherViewModelImpl applyVoucherViewModelImpl2 = this.f11821i;
        if (Result.m6336isSuccessimpl(obj2)) {
            applyVoucherViewModelImpl2.updateViewState(new ApplyVouchersViewStates.ApplyVoucher((Pair) obj2));
        }
        ApplyVoucherViewModelImpl applyVoucherViewModelImpl3 = this.f11821i;
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj2);
        if (r02 != null) {
            if (r02 instanceof VoucherFailures) {
                voucherFailures = (VoucherFailures) r02;
            } else {
                voucherFailures = null;
            }
            if (voucherFailures == null) {
                voucherFailures = new VoucherFailures.FailToAddVoucherCode((Failure) null, 1, (DefaultConstructorMarker) null);
            }
            applyVoucherViewModelImpl3.updateViewState(new ApplyVouchersViewStates.ApplyVouchersFailure(voucherFailures));
        }
        return Unit.INSTANCE;
    }
}
