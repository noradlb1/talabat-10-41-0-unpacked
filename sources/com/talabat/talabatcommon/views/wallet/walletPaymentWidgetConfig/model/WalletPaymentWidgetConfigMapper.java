package com.talabat.talabatcommon.views.wallet.walletPaymentWidgetConfig.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigResponse;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigResult;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentWidgetConfigMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigMapper$Companion;", "", "()V", "mapWalletPaymentWidgetResponseModelToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigDisplayModel;", "response", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletPaymentWidgetConfigDisplayModel mapWalletPaymentWidgetResponseModelToDisplayModel(@Nullable WalletPaymentWidgetConfigResponse walletPaymentWidgetConfigResponse) {
            WalletPaymentWidgetConfigResult result;
            ArrayList arrayList = new ArrayList();
            WalletPaymentWidgetConfigDisplayModel walletPaymentWidgetConfigDisplayModel = new WalletPaymentWidgetConfigDisplayModel();
            if (!(walletPaymentWidgetConfigResponse == null || (result = walletPaymentWidgetConfigResponse.getResult()) == null)) {
                walletPaymentWidgetConfigDisplayModel.setCashEnabled(BooleanKt.orFalse(result.isCashEnabled()));
                walletPaymentWidgetConfigDisplayModel.setElectronicPaymentEnabled(BooleanKt.orFalse(result.isElectronicPaymentEnabled()));
                walletPaymentWidgetConfigDisplayModel.setWalletEnabled(BooleanKt.orFalse(result.isWalletEnabled()));
                List<Integer> electronicPaymentMethods = result.getElectronicPaymentMethods();
                if (electronicPaymentMethods != null) {
                    for (Number intValue : electronicPaymentMethods) {
                        arrayList.add(PaymentMethod.Companion.fromInt(intValue.intValue()));
                    }
                }
                walletPaymentWidgetConfigDisplayModel.setPaymentMethods(arrayList);
            }
            return walletPaymentWidgetConfigDisplayModel;
        }
    }
}
