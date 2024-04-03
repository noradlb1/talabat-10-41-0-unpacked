package com.talabat.wallet.bnplmanager.data.remote.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPaymentStatus;", "", "value", "", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "SUCCESS", "FAILURE", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum BNPLPaymentStatus {
    SUCCESS(0),
    FAILURE(1);
    
    @NotNull
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    @NotNull
    public static final BNPLPaymentStatus[] values = null;
    @Nullable
    private final Integer value;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPaymentStatus$Companion;", "", "()V", "values", "", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPaymentStatus;", "[Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPaymentStatus;", "getBNPLPaymentStatus", "value", "", "(Ljava/lang/Integer;)Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPaymentStatus;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BNPLPaymentStatus getBNPLPaymentStatus(@Nullable Integer num) {
            BNPLPaymentStatus bNPLPaymentStatus;
            BNPLPaymentStatus[] access$getValues$cp = BNPLPaymentStatus.values;
            int length = access$getValues$cp.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    bNPLPaymentStatus = null;
                    break;
                }
                bNPLPaymentStatus = access$getValues$cp[i11];
                if (Intrinsics.areEqual((Object) bNPLPaymentStatus.getValue(), (Object) num)) {
                    break;
                }
                i11++;
            }
            if (bNPLPaymentStatus == null) {
                return BNPLPaymentStatus.FAILURE;
            }
            return bNPLPaymentStatus;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        values = values();
    }

    private BNPLPaymentStatus(Integer num) {
        this.value = num;
    }

    @Nullable
    public final Integer getValue() {
        return this.value;
    }
}
