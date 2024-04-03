package com.opsquad.ui.orderDetail.model.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/opsquad/ui/orderDetail/model/enums/EOrderStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "PLACED", "PREPARING", "DELIVERING", "DELIVERED", "CANCELLED", "Companion", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum EOrderStatus {
    PLACED(1),
    PREPARING(2),
    DELIVERING(3),
    DELIVERED(4),
    CANCELLED(-5);
    
    @NotNull
    public static final Companion Companion = null;
    private final int status;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/opsquad/ui/orderDetail/model/enums/EOrderStatus$Companion;", "", "()V", "create", "Lcom/opsquad/ui/orderDetail/model/enums/EOrderStatus;", "status", "", "(Ljava/lang/Integer;)Lcom/opsquad/ui/orderDetail/model/enums/EOrderStatus;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EOrderStatus create(@Nullable Integer num) {
            if (num != null && num.intValue() == 1) {
                return EOrderStatus.PLACED;
            }
            if (num != null && num.intValue() == 2) {
                return EOrderStatus.PREPARING;
            }
            if (num != null && num.intValue() == 3) {
                return EOrderStatus.DELIVERING;
            }
            if (num != null && num.intValue() == 4) {
                return EOrderStatus.DELIVERED;
            }
            return EOrderStatus.CANCELLED;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private EOrderStatus(int i11) {
        this.status = i11;
    }

    public final int getStatus() {
        return this.status;
    }
}
