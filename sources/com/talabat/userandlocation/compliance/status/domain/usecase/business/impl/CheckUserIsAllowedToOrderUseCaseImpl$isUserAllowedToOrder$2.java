package com.talabat.userandlocation.compliance.status.domain.usecase.business.impl;

import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import com.talabat.userandlocation.compliance.status.domain.usecase.business.CheckUserIsAllowedToOrderUseCase;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.compliance.status.domain.usecase.business.impl.CheckUserIsAllowedToOrderUseCaseImpl$isUserAllowedToOrder$2", f = "CheckUserIsAllowedToOrderUseCaseImpl.kt", i = {0}, l = {39}, m = "invokeSuspend", n = {"durationStatusIsAllowedToCheck"}, s = {"J$0"})
public final class CheckUserIsAllowedToOrderUseCaseImpl$isUserAllowedToOrder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CheckUserIsAllowedToOrderUseCase.Result>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public long f12286h;

    /* renamed from: i  reason: collision with root package name */
    public int f12287i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CheckUserIsAllowedToOrderUseCaseImpl f12288j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f12289k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f12290l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f12291m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f12292n;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UserStatusRepository.Status.values().length];
            iArr[UserStatusRepository.Status.PASS.ordinal()] = 1;
            iArr[UserStatusRepository.Status.PENDING.ordinal()] = 2;
            iArr[UserStatusRepository.Status.FAIL.ordinal()] = 3;
            iArr[UserStatusRepository.Status.ERROR.ordinal()] = 4;
            iArr[UserStatusRepository.Status.UNINITIALIZED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckUserIsAllowedToOrderUseCaseImpl$isUserAllowedToOrder$2(CheckUserIsAllowedToOrderUseCaseImpl checkUserIsAllowedToOrderUseCaseImpl, String str, String str2, String str3, boolean z11, Continuation<? super CheckUserIsAllowedToOrderUseCaseImpl$isUserAllowedToOrder$2> continuation) {
        super(2, continuation);
        this.f12288j = checkUserIsAllowedToOrderUseCaseImpl;
        this.f12289k = str;
        this.f12290l = str2;
        this.f12291m = str3;
        this.f12292n = z11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckUserIsAllowedToOrderUseCaseImpl$isUserAllowedToOrder$2(this.f12288j, this.f12289k, this.f12290l, this.f12291m, this.f12292n, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CheckUserIsAllowedToOrderUseCase.Result> continuation) {
        return ((CheckUserIsAllowedToOrderUseCaseImpl$isUserAllowedToOrder$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long j11;
        String str;
        String str2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12287i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            long durationStatusCanBeCheckedAgain = UserStatusDomainModule.INSTANCE.getDurationStatusCanBeCheckedAgain();
            CheckUserIsAllowedToOrderUseCaseImpl checkUserIsAllowedToOrderUseCaseImpl = this.f12288j;
            String str3 = this.f12289k;
            String str4 = this.f12290l;
            String str5 = this.f12291m;
            boolean z11 = this.f12292n;
            this.f12286h = durationStatusCanBeCheckedAgain;
            this.f12287i = 1;
            obj = checkUserIsAllowedToOrderUseCaseImpl.checkStatusOfUser(durationStatusCanBeCheckedAgain, str3, str4, str5, z11, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j11 = durationStatusCanBeCheckedAgain;
        } else if (i11 == 1) {
            j11 = this.f12286h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UserStatusRepository.Status status = (UserStatusRepository.Status) obj;
        this.f12288j.setStatusIsNotAllowedToBeCheckedAgain(status, j11);
        int i12 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i12 == 1) {
            return CheckUserIsAllowedToOrderUseCase.Result.AllowedToOrder.INSTANCE;
        }
        if (i12 == 2) {
            return CheckUserIsAllowedToOrderUseCase.Result.Blocked.INSTANCE;
        }
        if (i12 == 3) {
            return CheckUserIsAllowedToOrderUseCase.Result.Blocked.INSTANCE;
        }
        if (i12 == 4) {
            return CheckUserIsAllowedToOrderUseCase.Result.Blocked.INSTANCE;
        }
        if (i12 == 5) {
            CustomerInfo customerInfo = (CustomerInfo) this.f12288j.customerInfoProvider.invoke();
            String str6 = this.f12289k;
            String str7 = this.f12290l;
            String str8 = this.f12291m;
            if (customerInfo != null) {
                str = customerInfo.email;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (customerInfo != null) {
                str2 = customerInfo.mobileNumber;
            } else {
                str2 = null;
            }
            return new CheckUserIsAllowedToOrderUseCase.Result.ShouldVerifyUserInfo(str6, str7, str8, str, str2);
        }
        throw new NoWhenBranchMatchedException();
    }
}
