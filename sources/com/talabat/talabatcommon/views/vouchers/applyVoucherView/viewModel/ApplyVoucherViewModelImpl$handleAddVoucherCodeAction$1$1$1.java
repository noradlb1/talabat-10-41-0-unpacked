package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
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
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends VoucherData, ? extends VoucherItemsDisplayModel>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11831h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11832i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f11833j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f11834k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f11835l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f11836m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f11837n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f11838o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ String f11839p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ List<CartMenuItem> f11840q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f11841r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, float f11, String str, String str2, int i11, int i12, String str3, String str4, List<? extends CartMenuItem> list, int i13, Continuation<? super ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1> continuation) {
        super(2, continuation);
        this.f11832i = applyVoucherViewModelImpl;
        this.f11833j = f11;
        this.f11834k = str;
        this.f11835l = str2;
        this.f11836m = i11;
        this.f11837n = i12;
        this.f11838o = str3;
        this.f11839p = str4;
        this.f11840q = list;
        this.f11841r = i13;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1(this.f11832i, this.f11833j, this.f11834k, this.f11835l, this.f11836m, this.f11837n, this.f11838o, this.f11839p, this.f11840q, this.f11841r, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<VoucherData, VoucherItemsDisplayModel>> continuation) {
        return ((ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11831h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            AddVoucherCodeUseCase access$getAddVoucherCodeUseCase$p = this.f11832i.addVoucherCodeUseCase;
            float f11 = this.f11833j;
            String str = this.f11834k;
            String str2 = this.f11835l;
            int i12 = this.f11836m;
            int i13 = this.f11837n;
            String str3 = this.f11838o;
            String str4 = this.f11839p;
            List<CartMenuItem> list = this.f11840q;
            int i14 = this.f11841r;
            this.f11831h = 1;
            obj = access$getAddVoucherCodeUseCase$p.invoke(f11, str, str2, i12, i13, str3, str4, list, i14, this);
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
