package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.MyPossibleVouchersRequestModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewHolderDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11801h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11802i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f11803j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f11804k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f11805l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f11806m;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0007\u001a\u00020\u0006*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super Either<? extends VoucherFailures, ? extends ApplyVoucherViewHolderDisplayModel>>, Throwable, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f11807h;

        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super Either<? extends VoucherFailures, ApplyVoucherViewHolderDisplayModel>> flowCollector, @NotNull Throwable th2, @Nullable Continuation<? super Unit> continuation) {
            return new AnonymousClass1(applyVoucherViewModelImpl2, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f11807h == 0) {
                ResultKt.throwOnFailure(obj);
                applyVoucherViewModelImpl2.updateViewState(new ApplyVouchersViewStates.ApplyVouchersFailure(new VoucherFailures.FailToLoadPossibleVouchers((Failure) null, 1, (DefaultConstructorMarker) null)));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, int i11, String str, int i12, int i13, Continuation<? super ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1> continuation) {
        super(2, continuation);
        this.f11802i = applyVoucherViewModelImpl;
        this.f11803j = i11;
        this.f11804k = str;
        this.f11805l = i12;
        this.f11806m = i13;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1(this.f11802i, this.f11803j, this.f11804k, this.f11805l, this.f11806m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11801h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ApplyVoucherViewModelImpl applyVoucherViewModelImpl = this.f11802i;
            Flow access$onFlowActionCompleted = applyVoucherViewModelImpl.onFlowActionCompleted(applyVoucherViewModelImpl.onFlowActionStarted(applyVoucherViewModelImpl.getMyPossibleVouchers.invoke(new MyPossibleVouchersRequestModel(this.f11803j, this.f11804k, this.f11805l, this.f11806m))));
            final ApplyVoucherViewModelImpl applyVoucherViewModelImpl2 = this.f11802i;
            Flow flow = FlowKt.m7822catch(access$onFlowActionCompleted, new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
            final ApplyVoucherViewModelImpl applyVoucherViewModelImpl3 = this.f11802i;
            AnonymousClass2 r12 = new FlowCollector() {
                @Nullable
                public final Object emit(@NotNull Either<? extends VoucherFailures, ApplyVoucherViewHolderDisplayModel> either, @NotNull Continuation<? super Unit> continuation) {
                    VoucherData voucherData;
                    Object obj;
                    if (either instanceof Either.Left) {
                        applyVoucherViewModelImpl3.updateViewState(new ApplyVouchersViewStates.ApplyVouchersFailure((VoucherFailures) ((Either.Left) either).getA()));
                    } else if (either instanceof Either.Right) {
                        Either.Right right = (Either.Right) either;
                        if (((ApplyVoucherViewHolderDisplayModel) right.getB()).getMyVouchers().size() > 0) {
                            ApplyVoucherViewModelImpl applyVoucherViewModelImpl = applyVoucherViewModelImpl3;
                            Iterator it = ((ApplyVoucherViewHolderDisplayModel) right.getB()).getMyVouchers().iterator();
                            while (true) {
                                voucherData = null;
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it.next();
                                if (((VoucherDisplayModel) obj).isApplied()) {
                                    break;
                                }
                            }
                            VoucherDisplayModel voucherDisplayModel = (VoucherDisplayModel) obj;
                            if (voucherDisplayModel != null) {
                                voucherData = voucherDisplayModel.getVoucherData();
                            }
                            applyVoucherViewModelImpl.currentAppliedVoucher = voucherData;
                            applyVoucherViewModelImpl3.updateViewState(new ApplyVouchersViewStates.ShowAllMyPossibleVouchers((ApplyVoucherViewHolderDisplayModel) right.getB()));
                        } else {
                            applyVoucherViewModelImpl3.updateViewState(ApplyVouchersViewStates.EmptyMyPossibleVouchers.INSTANCE);
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            this.f11801h = 1;
            if (flow.collect(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
