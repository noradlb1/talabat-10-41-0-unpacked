package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel;
import datamodels.CartMenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$applyVoucherAction$1$1$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$applyVoucherAction$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends VoucherData, ? extends VoucherItemsDisplayModel>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11783h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11784i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VoucherDisplayModel f11785j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f11786k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f11787l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f11788m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f11789n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f11790o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ List<CartMenuItem> f11791p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f11792q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$applyVoucherAction$1$1$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, VoucherDisplayModel voucherDisplayModel, float f11, String str, String str2, String str3, int i11, List<? extends CartMenuItem> list, int i12, Continuation<? super ApplyVoucherViewModelImpl$applyVoucherAction$1$1$1> continuation) {
        super(2, continuation);
        this.f11784i = applyVoucherViewModelImpl;
        this.f11785j = voucherDisplayModel;
        this.f11786k = f11;
        this.f11787l = str;
        this.f11788m = str2;
        this.f11789n = str3;
        this.f11790o = i11;
        this.f11791p = list;
        this.f11792q = i12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyVoucherViewModelImpl$applyVoucherAction$1$1$1(this.f11784i, this.f11785j, this.f11786k, this.f11787l, this.f11788m, this.f11789n, this.f11790o, this.f11791p, this.f11792q, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<VoucherData, VoucherItemsDisplayModel>> continuation) {
        return ((ApplyVoucherViewModelImpl$applyVoucherAction$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11783h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ApplyVoucherUseCaseOutput access$getApplyVoucherUseCaseOutput$p = this.f11784i.applyVoucherUseCaseOutput;
            VoucherData voucherData = this.f11785j.getVoucherData();
            float f11 = this.f11786k;
            String str = this.f11787l;
            String str2 = this.f11788m;
            String str3 = this.f11789n;
            int i12 = this.f11790o;
            List<CartMenuItem> list = this.f11791p;
            int i13 = this.f11792q;
            this.f11783h = 1;
            obj = access$getApplyVoucherUseCaseOutput$p.invoke(voucherData, f11, str, str2, str3, i12, list, i13, this);
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
