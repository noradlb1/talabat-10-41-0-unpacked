package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel;", "", "()V", "HideOrderConfirmationRiderTip", "ShowOrderConfirmationRiderTip", "ShowRiderTipGiven", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel$ShowOrderConfirmationRiderTip;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel$HideOrderConfirmationRiderTip;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel$ShowRiderTipGiven;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OrderConfirmationRiderTipDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel$HideOrderConfirmationRiderTip;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HideOrderConfirmationRiderTip extends OrderConfirmationRiderTipDisplayModel {
        @NotNull
        public static final HideOrderConfirmationRiderTip INSTANCE = new HideOrderConfirmationRiderTip();

        private HideOrderConfirmationRiderTip() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel$ShowOrderConfirmationRiderTip;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowOrderConfirmationRiderTip extends OrderConfirmationRiderTipDisplayModel {
        @NotNull
        public static final ShowOrderConfirmationRiderTip INSTANCE = new ShowOrderConfirmationRiderTip();

        private ShowOrderConfirmationRiderTip() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel$ShowRiderTipGiven;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/displaymodel/OrderConfirmationRiderTipDisplayModel;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowRiderTipGiven extends OrderConfirmationRiderTipDisplayModel {
        @NotNull
        public static final ShowRiderTipGiven INSTANCE = new ShowRiderTipGiven();

        private ShowRiderTipGiven() {
            super((DefaultConstructorMarker) null);
        }
    }

    private OrderConfirmationRiderTipDisplayModel() {
    }

    public /* synthetic */ OrderConfirmationRiderTipDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
