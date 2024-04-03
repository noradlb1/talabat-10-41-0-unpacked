package com.talabat.growth.ui.vouchers.details;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.growth.features.vouchers.domain.GetVoucherDetailsUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.VoucherDetailDomainModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.logger.LogManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.growth.ui.vouchers.details.VoucherDetailsViewModel$getVoucherDetails$1", f = "VoucherDetailsViewModel.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
public final class VoucherDetailsViewModel$getVoucherDetails$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60698h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VoucherDetailsViewModel f60699i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60700j;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/VoucherDetailDomainModel;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.growth.ui.vouchers.details.VoucherDetailsViewModel$getVoucherDetails$1$1", f = "VoucherDetailsViewModel.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.growth.ui.vouchers.details.VoucherDetailsViewModel$getVoucherDetails$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VoucherDetailDomainModel>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f60701h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(voucherDetailsViewModel, str, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super VoucherDetailDomainModel> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f60701h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                GetVoucherDetailsUseCase access$getGetVoucherDetails$p = voucherDetailsViewModel.getVoucherDetails;
                String str = str;
                this.f60701h = 1;
                obj = access$getGetVoucherDetails$p.invoke(str, this);
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoucherDetailsViewModel$getVoucherDetails$1(VoucherDetailsViewModel voucherDetailsViewModel, String str, Continuation<? super VoucherDetailsViewModel$getVoucherDetails$1> continuation) {
        super(2, continuation);
        this.f60699i = voucherDetailsViewModel;
        this.f60700j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoucherDetailsViewModel$getVoucherDetails$1(this.f60699i, this.f60700j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoucherDetailsViewModel$getVoucherDetails$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60698h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineContext dispatcher = this.f60699i.getDispatcher();
            final VoucherDetailsViewModel voucherDetailsViewModel = this.f60699i;
            final String str = this.f60700j;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f60698h = 1;
            obj = BuildersKt.withContext(dispatcher, r12, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Failure e11) {
                LogManager.error$default(e11, (String) null, 2, (Object) null);
                IObservabilityManager observabilityManager = this.f60699i.getObservabilityManager();
                String message = e11.getMessage();
                if (message == null) {
                    message = "";
                }
                IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(observabilityManager, "FailToLoadVoucherDetails >> failure: " + message, (Map) null, 2, (Object) null);
                this.f60699i.handleFailure(e11);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f60699i.getVoucherDetailsDisplayModelLiveData().setValue((VoucherDetailDomainModel) obj);
        return Unit.INSTANCE;
    }
}
