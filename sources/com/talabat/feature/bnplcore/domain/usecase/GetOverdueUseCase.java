package com.talabat.feature.bnplcore.domain.usecase;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦\u0002¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult;", "OverdueResult", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetOverdueUseCase {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult;", "", "()V", "NoOverdue", "Off", "Overdue", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult$Overdue;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult$NoOverdue;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult$Off;", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class OverdueResult {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult$NoOverdue;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult;", "()V", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class NoOverdue extends OverdueResult {
            @NotNull
            public static final NoOverdue INSTANCE = new NoOverdue();

            private NoOverdue() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult$Off;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult;", "()V", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Off extends OverdueResult {
            @NotNull
            public static final Off INSTANCE = new Off();

            private Off() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult$Overdue;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult;", "totalAmount", "", "(D)V", "getTotalAmount", "()D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Overdue extends OverdueResult {
            private final double totalAmount;

            public Overdue() {
                this(0.0d, 1, (DefaultConstructorMarker) null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Overdue(double d11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
                this((i11 & 1) != 0 ? 0.0d : d11);
            }

            public static /* synthetic */ Overdue copy$default(Overdue overdue, double d11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    d11 = overdue.totalAmount;
                }
                return overdue.copy(d11);
            }

            public final double component1() {
                return this.totalAmount;
            }

            @NotNull
            public final Overdue copy(double d11) {
                return new Overdue(d11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Overdue) && Intrinsics.areEqual((Object) Double.valueOf(this.totalAmount), (Object) Double.valueOf(((Overdue) obj).totalAmount));
            }

            public final double getTotalAmount() {
                return this.totalAmount;
            }

            public int hashCode() {
                return Double.doubleToLongBits(this.totalAmount);
            }

            @NotNull
            public String toString() {
                double d11 = this.totalAmount;
                return "Overdue(totalAmount=" + d11 + ")";
            }

            public Overdue(double d11) {
                super((DefaultConstructorMarker) null);
                this.totalAmount = d11;
            }
        }

        private OverdueResult() {
        }

        public /* synthetic */ OverdueResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    Single<OverdueResult> invoke();
}
