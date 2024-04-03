package com.talabat.userandlocation.compliance.verification.domain.usecase.business.impl;

import com.talabat.userandlocation.compliance.verification.domain.usecase.business.VerifyUserDetailsForComplianceUseCase;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/impl/VerifyUserDetailsForComplianceUseCaseImpl;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "createVerificationFailedResult", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult$VerificationFailed;", "mapOfEmptyFields", "", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Field;", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$ValidationError;", "mapOfInvalidFields", "verifyUserDetailsForCompliance", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$UserVerificationForComplianceResult;", "arguments", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Arguments;", "(Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Arguments;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyUserDetailsForComplianceUseCaseImpl implements VerifyUserDetailsForComplianceUseCase {
    @NotNull
    private final CoroutineDispatcher ioDispatcher;

    public VerifyUserDetailsForComplianceUseCaseImpl() {
        this((CoroutineDispatcher) null, 1, (DefaultConstructorMarker) null);
    }

    public VerifyUserDetailsForComplianceUseCaseImpl(@NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.ioDispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult.VerificationFailed createVerificationFailedResult(Map<VerifyUserDetailsForComplianceUseCase.Field, ? extends VerifyUserDetailsForComplianceUseCase.ValidationError> map, Map<VerifyUserDetailsForComplianceUseCase.Field, ? extends VerifyUserDetailsForComplianceUseCase.ValidationError> map2) {
        Sequence<Map.Entry> distinct = SequencesKt___SequencesKt.distinct(SequencesKt___SequencesKt.plus(MapsKt___MapsKt.asSequence(map), MapsKt___MapsKt.asSequence(map2)));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : distinct) {
            VerifyUserDetailsForComplianceUseCase.Field field = (VerifyUserDetailsForComplianceUseCase.Field) entry.getKey();
            Object obj = linkedHashMap.get(field);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(field, obj);
            }
            ((List) obj).add((VerifyUserDetailsForComplianceUseCase.ValidationError) entry.getValue());
        }
        return new VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult.VerificationFailed(linkedHashMap);
    }

    @Nullable
    public Object verifyUserDetailsForCompliance(@NotNull VerifyUserDetailsForComplianceUseCase.Arguments arguments, @NotNull Continuation<? super VerifyUserDetailsForComplianceUseCase.UserVerificationForComplianceResult> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new VerifyUserDetailsForComplianceUseCaseImpl$verifyUserDetailsForCompliance$2(arguments, this, (Continuation<? super VerifyUserDetailsForComplianceUseCaseImpl$verifyUserDetailsForCompliance$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerifyUserDetailsForComplianceUseCaseImpl(CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
