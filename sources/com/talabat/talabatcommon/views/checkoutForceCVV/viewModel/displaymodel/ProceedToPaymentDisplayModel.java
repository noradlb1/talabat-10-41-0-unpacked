package com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/displaymodel/ProceedToPaymentDisplayModel;", "", "()V", "PayFullAmount", "PayRemainingAmount", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/displaymodel/ProceedToPaymentDisplayModel$PayRemainingAmount;", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/displaymodel/ProceedToPaymentDisplayModel$PayFullAmount;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ProceedToPaymentDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/displaymodel/ProceedToPaymentDisplayModel$PayFullAmount;", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/displaymodel/ProceedToPaymentDisplayModel;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PayFullAmount extends ProceedToPaymentDisplayModel {
        @NotNull
        public static final PayFullAmount INSTANCE = new PayFullAmount();

        private PayFullAmount() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/displaymodel/ProceedToPaymentDisplayModel$PayRemainingAmount;", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/displaymodel/ProceedToPaymentDisplayModel;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PayRemainingAmount extends ProceedToPaymentDisplayModel {
        @NotNull
        public static final PayRemainingAmount INSTANCE = new PayRemainingAmount();

        private PayRemainingAmount() {
            super((DefaultConstructorMarker) null);
        }
    }

    private ProceedToPaymentDisplayModel() {
    }

    public /* synthetic */ ProceedToPaymentDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
