package com.talabat.userandlocation.compliance.status.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/DismissScreenModel;", "", "()V", "WithCancelResult", "WithSuccessResult", "Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/DismissScreenModel$WithCancelResult;", "Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/DismissScreenModel$WithSuccessResult;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DismissScreenModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/DismissScreenModel$WithCancelResult;", "Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/DismissScreenModel;", "()V", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WithCancelResult extends DismissScreenModel {
        @NotNull
        public static final WithCancelResult INSTANCE = new WithCancelResult();

        private WithCancelResult() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/DismissScreenModel$WithSuccessResult;", "Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/DismissScreenModel;", "()V", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WithSuccessResult extends DismissScreenModel {
        @NotNull
        public static final WithSuccessResult INSTANCE = new WithSuccessResult();

        private WithSuccessResult() {
            super((DefaultConstructorMarker) null);
        }
    }

    private DismissScreenModel() {
    }

    public /* synthetic */ DismissScreenModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
