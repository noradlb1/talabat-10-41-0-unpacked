package com.talabat.growth.ui.loyalty.burn.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/VoucherDiscountType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "UNKNOWN", "FLAT", "PERCENTAGE", "DELIVERY_PERCENTAGE", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum VoucherDiscountType {
    UNKNOWN(0),
    FLAT(1),
    PERCENTAGE(2),
    DELIVERY_PERCENTAGE(3);
    
    @NotNull
    public static final Companion Companion = null;
    private final int type;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/VoucherDiscountType$Companion;", "", "()V", "from", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherDiscountType;", "value", "", "(Ljava/lang/Integer;)Lcom/talabat/growth/ui/loyalty/burn/models/VoucherDiscountType;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VoucherDiscountType from(@Nullable Integer num) {
            VoucherDiscountType voucherDiscountType;
            boolean z11;
            VoucherDiscountType[] values = VoucherDiscountType.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    voucherDiscountType = null;
                    break;
                }
                voucherDiscountType = values[i11];
                int type = voucherDiscountType.getType();
                if (num != null && type == num.intValue()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i11++;
            }
            if (voucherDiscountType == null) {
                return VoucherDiscountType.UNKNOWN;
            }
            return voucherDiscountType;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private VoucherDiscountType(int i11) {
        this.type = i11;
    }

    public final int getType() {
        return this.type;
    }
}
