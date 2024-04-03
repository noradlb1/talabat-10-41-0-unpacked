package com.talabat.wallet.bnplmanager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLTrackingStatus;", "", "status", "", "variantName", "", "variantId", "numberOfPayments", "intervals", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;II)V", "getIntervals", "()I", "getNumberOfPayments", "getStatus", "getVariantId", "()Ljava/lang/String;", "getVariantName", "DEFERRED_14X1", "DEFERRED_30X1", "INSTALLMENT_14X4", "INSTALLMENT_30X2", "HIDDEN", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum BNPLTrackingStatus {
    DEFERRED_14X1(1, "deferred-14days", "2703301", 1, 14),
    DEFERRED_30X1(2, "deferred-30days", "2703311", 1, 30),
    INSTALLMENT_14X4(3, "installments-4payments-14days-interval", "2703321", 4, 14),
    INSTALLMENT_30X2(4, "installments-2payments-30days-interval", "2703331", 2, 30),
    HIDDEN(0, "original", "2703291", 0, 0);
    
    @NotNull
    public static final Companion Companion = null;
    private final int intervals;
    private final int numberOfPayments;
    private final int status;
    @NotNull
    private final String variantId;
    @NotNull
    private final String variantName;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLTrackingStatus$Companion;", "", "()V", "getBNPLTrackingStatus", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLTrackingStatus;", "value", "", "(Ljava/lang/Integer;)Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLTrackingStatus;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BNPLTrackingStatus getBNPLTrackingStatus(@Nullable Integer num) {
            BNPLTrackingStatus bNPLTrackingStatus;
            boolean z11;
            BNPLTrackingStatus[] values = BNPLTrackingStatus.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    bNPLTrackingStatus = null;
                    break;
                }
                bNPLTrackingStatus = values[i11];
                int status = bNPLTrackingStatus.getStatus();
                if (num != null && status == num.intValue()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i11++;
            }
            if (bNPLTrackingStatus == null) {
                return BNPLTrackingStatus.HIDDEN;
            }
            return bNPLTrackingStatus;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private BNPLTrackingStatus(int i11, String str, String str2, int i12, int i13) {
        this.status = i11;
        this.variantName = str;
        this.variantId = str2;
        this.numberOfPayments = i12;
        this.intervals = i13;
    }

    public final int getIntervals() {
        return this.intervals;
    }

    public final int getNumberOfPayments() {
        return this.numberOfPayments;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getVariantId() {
        return this.variantId;
    }

    @NotNull
    public final String getVariantName() {
        return this.variantName;
    }
}
