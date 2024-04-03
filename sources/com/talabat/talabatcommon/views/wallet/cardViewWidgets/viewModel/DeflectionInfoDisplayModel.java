package com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;", "", "()V", "Hidden", "ShowBahrainBenefit", "ShowQPay", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel$ShowBahrainBenefit;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel$ShowQPay;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel$Hidden;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DeflectionInfoDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel$Hidden;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends DeflectionInfoDisplayModel {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel$ShowBahrainBenefit;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;", "numbers", "", "", "(Ljava/util/Set;)V", "getNumbers", "()Ljava/util/Set;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowBahrainBenefit extends DeflectionInfoDisplayModel {
        @NotNull
        private final Set<String> numbers;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowBahrainBenefit(@NotNull Set<String> set) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(set, "numbers");
            this.numbers = set;
        }

        @NotNull
        public final Set<String> getNumbers() {
            return this.numbers;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel$ShowQPay;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;", "numbers", "", "", "(Ljava/util/Set;)V", "getNumbers", "()Ljava/util/Set;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowQPay extends DeflectionInfoDisplayModel {
        @NotNull
        private final Set<String> numbers;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowQPay(@NotNull Set<String> set) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(set, "numbers");
            this.numbers = set;
        }

        @NotNull
        public final Set<String> getNumbers() {
            return this.numbers;
        }
    }

    private DeflectionInfoDisplayModel() {
    }

    public /* synthetic */ DeflectionInfoDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
