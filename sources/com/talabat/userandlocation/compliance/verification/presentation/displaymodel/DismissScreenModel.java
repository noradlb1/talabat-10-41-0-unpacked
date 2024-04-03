package com.talabat.userandlocation.compliance.verification.presentation.displaymodel;

import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/DismissScreenModel;", "", "()V", "WithCancelResult", "WithSuccessResult", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/DismissScreenModel$WithCancelResult;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/DismissScreenModel$WithSuccessResult;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DismissScreenModel {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/DismissScreenModel$WithCancelResult;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/DismissScreenModel;", "extras", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras;", "(Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras;)V", "getExtras", "()Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WithCancelResult extends DismissScreenModel {
        @NotNull
        private final ComplianceUserVerificationExtras extras;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WithCancelResult(@NotNull ComplianceUserVerificationExtras complianceUserVerificationExtras) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(complianceUserVerificationExtras, "extras");
            this.extras = complianceUserVerificationExtras;
        }

        public static /* synthetic */ WithCancelResult copy$default(WithCancelResult withCancelResult, ComplianceUserVerificationExtras complianceUserVerificationExtras, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                complianceUserVerificationExtras = withCancelResult.extras;
            }
            return withCancelResult.copy(complianceUserVerificationExtras);
        }

        @NotNull
        public final ComplianceUserVerificationExtras component1() {
            return this.extras;
        }

        @NotNull
        public final WithCancelResult copy(@NotNull ComplianceUserVerificationExtras complianceUserVerificationExtras) {
            Intrinsics.checkNotNullParameter(complianceUserVerificationExtras, "extras");
            return new WithCancelResult(complianceUserVerificationExtras);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WithCancelResult) && Intrinsics.areEqual((Object) this.extras, (Object) ((WithCancelResult) obj).extras);
        }

        @NotNull
        public final ComplianceUserVerificationExtras getExtras() {
            return this.extras;
        }

        public int hashCode() {
            return this.extras.hashCode();
        }

        @NotNull
        public String toString() {
            ComplianceUserVerificationExtras complianceUserVerificationExtras = this.extras;
            return "WithCancelResult(extras=" + complianceUserVerificationExtras + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/DismissScreenModel$WithSuccessResult;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/DismissScreenModel;", "result", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationResult;", "(Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationResult;)V", "getResult", "()Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WithSuccessResult extends DismissScreenModel {
        @NotNull
        private final ComplianceUserVerificationResult result;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WithSuccessResult(@NotNull ComplianceUserVerificationResult complianceUserVerificationResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(complianceUserVerificationResult, "result");
            this.result = complianceUserVerificationResult;
        }

        public static /* synthetic */ WithSuccessResult copy$default(WithSuccessResult withSuccessResult, ComplianceUserVerificationResult complianceUserVerificationResult, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                complianceUserVerificationResult = withSuccessResult.result;
            }
            return withSuccessResult.copy(complianceUserVerificationResult);
        }

        @NotNull
        public final ComplianceUserVerificationResult component1() {
            return this.result;
        }

        @NotNull
        public final WithSuccessResult copy(@NotNull ComplianceUserVerificationResult complianceUserVerificationResult) {
            Intrinsics.checkNotNullParameter(complianceUserVerificationResult, "result");
            return new WithSuccessResult(complianceUserVerificationResult);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WithSuccessResult) && Intrinsics.areEqual((Object) this.result, (Object) ((WithSuccessResult) obj).result);
        }

        @NotNull
        public final ComplianceUserVerificationResult getResult() {
            return this.result;
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        @NotNull
        public String toString() {
            ComplianceUserVerificationResult complianceUserVerificationResult = this.result;
            return "WithSuccessResult(result=" + complianceUserVerificationResult + ")";
        }
    }

    private DismissScreenModel() {
    }

    public /* synthetic */ DismissScreenModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
