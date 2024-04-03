package com.talabat.wallet.ui.expiringCard.model;

import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.wallet.features.expiringCard.model.ExpiringCardModel;
import com.talabat.wallet.features.expiringCard.model.ExpiringCardResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardMapper;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpiringCardMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardMapper$Companion;", "", "()V", "mapExpiringCardResponseToExpiryDetailDisplayModel", "Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "response", "Lcom/talabat/wallet/features/expiringCard/model/ExpiringCardResponse;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExpiringCardDetailDisplayModel mapExpiringCardResponseToExpiryDetailDisplayModel(@Nullable ExpiringCardResponse expiringCardResponse) {
            ExpiringCardModel result;
            ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel = new ExpiringCardDetailDisplayModel();
            if (!(expiringCardResponse == null || (result = expiringCardResponse.getResult()) == null)) {
                String expiryDate = result.getExpiryDate();
                if (expiryDate == null) {
                    expiryDate = "";
                }
                expiringCardDetailDisplayModel.setExpiryDate(expiryDate);
                expiringCardDetailDisplayModel.setAmount(FloatKt.orZero(result.getAmount()));
                expiringCardDetailDisplayModel.setShouldDisplayView(true);
            }
            expiringCardDetailDisplayModel.setLoadingCompleted(true);
            return expiringCardDetailDisplayModel;
        }
    }
}
