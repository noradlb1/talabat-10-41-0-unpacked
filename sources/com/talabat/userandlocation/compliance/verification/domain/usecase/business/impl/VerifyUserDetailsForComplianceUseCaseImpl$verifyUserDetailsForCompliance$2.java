package com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl;

import com.talabat.userandlocation.compliance.verification.domain.usecase.business.VerifyUserDetailsForComplianceUseCase;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl.VerifyUserDetailsForComplianceUseCaseImpl$verifyUserDetailsForCompliance$2", f = "VerifyUserDetailsForComplianceUseCaseImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VerifyUserDetailsForComplianceUseCaseImpl$verifyUserDetailsForCompliance$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12313h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VerifyUserDetailsForComplianceUseCase.Arguments f12314i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VerifyUserDetailsForComplianceUseCaseImpl f12315j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyUserDetailsForComplianceUseCaseImpl$verifyUserDetailsForCompliance$2(VerifyUserDetailsForComplianceUseCase.Arguments arguments, VerifyUserDetailsForComplianceUseCaseImpl verifyUserDetailsForComplianceUseCaseImpl, Continuation<? super VerifyUserDetailsForComplianceUseCaseImpl$verifyUserDetailsForCompliance$2> continuation) {
        super(2, continuation);
        this.f12314i = arguments;
        this.f12315j = verifyUserDetailsForComplianceUseCaseImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VerifyUserDetailsForComplianceUseCaseImpl$verifyUserDetailsForCompliance$2(this.f12314i, this.f12315j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult> continuation) {
        return ((VerifyUserDetailsForComplianceUseCaseImpl$verifyUserDetailsForCompliance$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f12313h == 0) {
            ResultKt.throwOnFailure(obj);
            VerifyUserDetailsForComplianceUseCase.Arguments arguments = this.f12314i;
            String component1 = arguments.component1();
            String component2 = arguments.component2();
            String component3 = arguments.component3();
            boolean component5 = arguments.component5();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (StringsKt__StringsJVMKt.isBlank(component1)) {
                Pair pair = TuplesKt.to(VerifyUserDetailsForComplianceUseCase.Field.FIRST_NAME, VerifyUserDetailsForComplianceUseCase.ValidationError.EMPTY);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            if (StringsKt__StringsJVMKt.isBlank(component2)) {
                Pair pair2 = TuplesKt.to(VerifyUserDetailsForComplianceUseCase.Field.LAST_NAME, VerifyUserDetailsForComplianceUseCase.ValidationError.EMPTY);
                linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
            }
            if (StringsKt__StringsJVMKt.isBlank(component3)) {
                Pair pair3 = TuplesKt.to(VerifyUserDetailsForComplianceUseCase.Field.DATE_OF_BIRTH, VerifyUserDetailsForComplianceUseCase.ValidationError.EMPTY);
                linkedHashMap.put(pair3.getFirst(), pair3.getSecond());
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (component1.length() > 25) {
                Pair pair4 = TuplesKt.to(VerifyUserDetailsForComplianceUseCase.Field.FIRST_NAME, VerifyUserDetailsForComplianceUseCase.ValidationError.NAME_LENGTH_EXCEEDED);
                linkedHashMap2.put(pair4.getFirst(), pair4.getSecond());
            }
            if (component2.length() > 25) {
                Pair pair5 = TuplesKt.to(VerifyUserDetailsForComplianceUseCase.Field.LAST_NAME, VerifyUserDetailsForComplianceUseCase.ValidationError.NAME_LENGTH_EXCEEDED);
                linkedHashMap2.put(pair5.getFirst(), pair5.getSecond());
            }
            if (!component5) {
                Pair pair6 = TuplesKt.to(VerifyUserDetailsForComplianceUseCase.Field.PRIVACY_TERMS_CONSENT, VerifyUserDetailsForComplianceUseCase.ValidationError.PRIVACY_TERMS_NOT_AGREED);
                linkedHashMap2.put(pair6.getFirst(), pair6.getSecond());
            }
            if (!linkedHashMap.isEmpty() || !linkedHashMap2.isEmpty()) {
                return this.f12315j.createVerificationFailedResult(linkedHashMap, linkedHashMap2);
            }
            return VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult.VerificationSuccess.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
