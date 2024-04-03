package com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl;

import com.talabat.userandlocation.compliance.verification.domain.usecase.business.UpdateUserProfileUseCase;
import com.talabat.userandlocation.customerinfo.CustomerInfoUpdateDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/impl/UpdateUserProfileUseCaseImpl;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "customerInfoUpdateDelegate", "Lcom/talabat/userandlocation/customerinfo/CustomerInfoUpdateDelegate;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/userandlocation/customerinfo/CustomerInfoUpdateDelegate;)V", "updateDetails", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase$Result;", "firstName", "", "lastName", "dateOfBirth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateUserProfileUseCaseImpl implements UpdateUserProfileUseCase {
    @NotNull
    private final CustomerInfoUpdateDelegate customerInfoUpdateDelegate;
    @NotNull
    private final CoroutineDispatcher dispatcher;

    public UpdateUserProfileUseCaseImpl(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CustomerInfoUpdateDelegate customerInfoUpdateDelegate2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(customerInfoUpdateDelegate2, "customerInfoUpdateDelegate");
        this.dispatcher = coroutineDispatcher;
        this.customerInfoUpdateDelegate = customerInfoUpdateDelegate2;
    }

    /* access modifiers changed from: private */
    public final Object updateDetails(String str, String str2, String str3, Continuation<? super UpdateUserProfileUseCase.Result> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.customerInfoUpdateDelegate.updateCustomerInfo(str, str2, str3, new UpdateUserProfileUseCaseImpl$updateDetails$2$1(safeContinuation), new UpdateUserProfileUseCaseImpl$updateDetails$2$2(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public Object updateUserProfile(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super UpdateUserProfileUseCase.Result> continuation) {
        return BuildersKt.withContext(this.dispatcher, new UpdateUserProfileUseCaseImpl$updateUserProfile$2(this, str, str2, str3, (Continuation<? super UpdateUserProfileUseCaseImpl$updateUserProfile$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpdateUserProfileUseCaseImpl(CoroutineDispatcher coroutineDispatcher, CustomerInfoUpdateDelegate customerInfoUpdateDelegate2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher, customerInfoUpdateDelegate2);
    }
}
