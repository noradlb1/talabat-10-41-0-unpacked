package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus;", "", "()V", "RiderTipIsAvailable", "RiderTipIsUnAvailable", "RiderWasTipped", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus$RiderTipIsAvailable;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus$RiderTipIsUnAvailable;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus$RiderWasTipped;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OrderConfirmationRiderTipStatus {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus$RiderTipIsAvailable;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RiderTipIsAvailable extends OrderConfirmationRiderTipStatus {
        @NotNull
        public static final RiderTipIsAvailable INSTANCE = new RiderTipIsAvailable();

        private RiderTipIsAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus$RiderTipIsUnAvailable;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RiderTipIsUnAvailable extends OrderConfirmationRiderTipStatus {
        @NotNull
        public static final RiderTipIsUnAvailable INSTANCE = new RiderTipIsUnAvailable();

        private RiderTipIsUnAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus$RiderWasTipped;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RiderWasTipped extends OrderConfirmationRiderTipStatus {
        @NotNull
        public static final RiderWasTipped INSTANCE = new RiderWasTipped();

        private RiderWasTipped() {
            super((DefaultConstructorMarker) null);
        }
    }

    private OrderConfirmationRiderTipStatus() {
    }

    public /* synthetic */ OrderConfirmationRiderTipStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
