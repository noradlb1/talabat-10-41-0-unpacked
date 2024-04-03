package com.talabat.growth.ui.lifecyclevoucher;

import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestWelcomeVoucherDomainModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1", f = "LoginLifecycleVoucherViewModel.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60584h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LoginLifecycleVoucherViewModel f60585i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1$1", f = "LoginLifecycleVoucherViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f60586h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(loginLifecycleVoucherViewModel, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f60586h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                LoginLifecycleVoucherViewModel loginLifecycleVoucherViewModel = loginLifecycleVoucherViewModel;
                Result.Companion companion = Result.Companion;
                GuestWelcomeVoucherUseCase access$getWelcomeVoucherUseCase$p = loginLifecycleVoucherViewModel.welcomeVoucherUseCase;
                int countryId = loginLifecycleVoucherViewModel.configurationLocalRepository.selectedCountry().getCountryId();
                this.f60586h = 1;
                obj = access$getWelcomeVoucherUseCase$p.invoke(countryId, this);
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
            obj2 = Result.m6329constructorimpl((GuestWelcomeVoucherDomainModel) obj);
            LoginLifecycleVoucherViewModel loginLifecycleVoucherViewModel2 = loginLifecycleVoucherViewModel;
            if (Result.m6336isSuccessimpl(obj2)) {
                loginLifecycleVoucherViewModel2._voucherDataLiveData.postValue(MapperKt.toDisplayModel((GuestWelcomeVoucherDomainModel) obj2));
            }
            LoginLifecycleVoucherViewModel loginLifecycleVoucherViewModel3 = loginLifecycleVoucherViewModel;
            Throwable r42 = Result.m6332exceptionOrNullimpl(obj2);
            if (r42 != null) {
                if (r42 instanceof Failure) {
                    loginLifecycleVoucherViewModel3.getFailureData().postValue(r42);
                } else {
                    loginLifecycleVoucherViewModel3.getFailureData().postValue(new VoucherFailures.FailToLoadGuestVoucher((Failure) null, 1, (DefaultConstructorMarker) null));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1(LoginLifecycleVoucherViewModel loginLifecycleVoucherViewModel, Continuation<? super LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1> continuation) {
        super(2, continuation);
        this.f60585i = loginLifecycleVoucherViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1(this.f60585i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60584h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher access$getDispatcher$p = this.f60585i.dispatcher;
            final LoginLifecycleVoucherViewModel loginLifecycleVoucherViewModel = this.f60585i;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f60584h = 1;
            if (BuildersKt.withContext(access$getDispatcher$p, r12, this) == coroutine_suspended) {
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
