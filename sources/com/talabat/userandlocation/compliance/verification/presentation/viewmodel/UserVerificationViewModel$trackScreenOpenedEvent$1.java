package com.talabat.userandlocation.compliance.verification.presentation.viewmodel;

import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackComplianceVerificationScreenOpenedUseCase;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.compliance.verification.presentation.viewmodel.UserVerificationViewModel$trackScreenOpenedEvent$1", f = "UserVerificationViewModel.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class UserVerificationViewModel$trackScreenOpenedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12319h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UserVerificationViewModel f12320i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ComplianceUserVerificationExtras.Mode f12321j;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ComplianceUserVerificationExtras.Mode.values().length];
            iArr[ComplianceUserVerificationExtras.Mode.EXISTING_USER.ordinal()] = 1;
            iArr[ComplianceUserVerificationExtras.Mode.NEW_USER.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserVerificationViewModel$trackScreenOpenedEvent$1(UserVerificationViewModel userVerificationViewModel, ComplianceUserVerificationExtras.Mode mode, Continuation<? super UserVerificationViewModel$trackScreenOpenedEvent$1> continuation) {
        super(2, continuation);
        this.f12320i = userVerificationViewModel;
        this.f12321j = mode;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserVerificationViewModel$trackScreenOpenedEvent$1(this.f12320i, this.f12321j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UserVerificationViewModel$trackScreenOpenedEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TrackComplianceVerificationScreenOpenedUseCase.Type type;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12319h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TrackComplianceVerificationScreenOpenedUseCase access$getTrackComplianceVerificationScreenOpenedUseCase$p = this.f12320i.trackComplianceVerificationScreenOpenedUseCase;
            int i12 = WhenMappings.$EnumSwitchMapping$0[this.f12321j.ordinal()];
            if (i12 == 1) {
                type = TrackComplianceVerificationScreenOpenedUseCase.Type.EXISTING_ACCOUNT;
            } else if (i12 == 2) {
                type = TrackComplianceVerificationScreenOpenedUseCase.Type.NEW_ACCOUNT;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.f12319h = 1;
            if (access$getTrackComplianceVerificationScreenOpenedUseCase$p.trackComplianceVerificationScreenOpened(type, this) == coroutine_suspended) {
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
