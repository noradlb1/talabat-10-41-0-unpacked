package com.talabat.talabatcommon.constants;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/constants/OrderStatusConstants;", "", "()V", "CANCELED", "", "DELIVERED", "DELIVERING", "OLD_STATUS", "ORDERED", "PREPARING", "REPLACEMENT", "isNewStatusOrNot", "", "orderStatus", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusConstants {
    public static final int CANCELED = 5;
    public static final int DELIVERED = 4;
    public static final int DELIVERING = 3;
    @NotNull
    public static final OrderStatusConstants INSTANCE = new OrderStatusConstants();
    public static final int OLD_STATUS = -5;
    public static final int ORDERED = 1;
    public static final int PREPARING = 2;
    public static final int REPLACEMENT = 6;

    private OrderStatusConstants() {
    }

    public final boolean isNewStatusOrNot(int i11) {
        return i11 == 1 || i11 == 2 || i11 == 4 || i11 == 3;
    }
}
