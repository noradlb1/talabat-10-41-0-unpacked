package com.talabat.talabatcommon.model.wallet;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.talabatcommon.feature.walletCardList.model.response.WalletCreditCardGetListItemModel;
import com.talabat.talabatcommon.feature.walletCardList.model.response.WalletCreditCardGetListResponse;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/model/wallet/WalletCardListMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardListMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/model/wallet/WalletCardListMapper$Companion;", "", "()V", "formatCardExpiryDate", "", "expiryMonth", "expiryYear", "hasCardExpired", "", "mapToDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "model", "Lcom/talabat/talabatcommon/feature/walletCardList/model/response/WalletCreditCardGetListItemModel;", "mapWalletCardListResponse", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "response", "Lcom/talabat/talabatcommon/feature/walletCardList/model/response/WalletCreditCardGetListResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String formatCardExpiryDate(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
            Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
            String take = StringsKt___StringsKt.take(String.valueOf(Calendar.getInstance().get(1)), 2);
            return str + "/" + take + str2;
        }

        public final boolean hasCardExpired(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
            Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
            try {
                String substring = String.valueOf(Calendar.getInstance().get(1)).substring(2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                int parseInt = Integer.parseInt(substring);
                int i11 = Calendar.getInstance().get(2) + 1;
                if (parseInt > Integer.parseInt(str2)) {
                    return true;
                }
                if (i11 < Integer.parseInt(str) || parseInt != Integer.parseInt(str2)) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return true;
            }
        }

        @NotNull
        public final WalletCardDisplayModel mapToDisplayModel(@NotNull WalletCreditCardGetListItemModel walletCreditCardGetListItemModel) {
            String str;
            Intrinsics.checkNotNullParameter(walletCreditCardGetListItemModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            WalletCardDisplayModel walletCardDisplayModel = new WalletCardDisplayModel((String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (PaymentMethod) null, false, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
            String token = walletCreditCardGetListItemModel.getToken();
            String str2 = "";
            if (token == null) {
                token = str2;
            }
            walletCardDisplayModel.setToken(token);
            String tokenId = walletCreditCardGetListItemModel.getTokenId();
            if (tokenId == null) {
                tokenId = str2;
            }
            walletCardDisplayModel.setTokenId(tokenId);
            String cardNumber = walletCreditCardGetListItemModel.getCardNumber();
            if (cardNumber == null) {
                cardNumber = str2;
            }
            walletCardDisplayModel.setCardNumber(cardNumber);
            String cardType = walletCreditCardGetListItemModel.getCardType();
            if (cardType == null) {
                cardType = str2;
            }
            walletCardDisplayModel.setCardType(cardType);
            String binNumber = walletCreditCardGetListItemModel.getBinNumber();
            if (binNumber == null) {
                binNumber = str2;
            }
            walletCardDisplayModel.setBinNumber(binNumber);
            String expiryDate = walletCreditCardGetListItemModel.getExpiryDate();
            if (expiryDate == null) {
                expiryDate = str2;
            }
            walletCardDisplayModel.setExpiryDate(expiryDate);
            String expiryMonth = walletCreditCardGetListItemModel.getExpiryMonth();
            if (expiryMonth == null) {
                expiryMonth = str2;
            }
            walletCardDisplayModel.setExpiryMonth(expiryMonth);
            String expiryYear = walletCreditCardGetListItemModel.getExpiryYear();
            if (expiryYear == null) {
                expiryYear = str2;
            }
            walletCardDisplayModel.setExpiryYear(expiryYear);
            String cardNumber2 = walletCreditCardGetListItemModel.getCardNumber();
            if (cardNumber2 != null) {
                str = StringsKt___StringsKt.takeLast(cardNumber2, 4);
            } else {
                str = null;
            }
            if (str != null) {
                str2 = str;
            }
            walletCardDisplayModel.setCard4Digits(str2);
            walletCardDisplayModel.setPaymentMethod(PaymentMethod.CARD);
            Boolean isCardDefault = walletCreditCardGetListItemModel.isCardDefault();
            if (isCardDefault != null) {
                walletCardDisplayModel.setDefaultCard(isCardDefault.booleanValue());
            }
            return walletCardDisplayModel;
        }

        @NotNull
        public final WalletCardListDisplayModel mapWalletCardListResponse(@Nullable WalletCreditCardGetListResponse walletCreditCardGetListResponse) {
            List<WalletCreditCardGetListItemModel> result;
            ArrayList arrayList = new ArrayList();
            if (walletCreditCardGetListResponse == null || (result = walletCreditCardGetListResponse.getResult()) == null) {
                return new WalletCardListDisplayModel((List) null, false, 0, 7, (DefaultConstructorMarker) null);
            }
            for (WalletCreditCardGetListItemModel walletCreditCardGetListItemModel : result) {
                if (walletCreditCardGetListItemModel.isCardDefault() != null) {
                    Boolean isCardDefault = walletCreditCardGetListItemModel.isCardDefault();
                    Intrinsics.checkNotNull(isCardDefault);
                    if (isCardDefault.booleanValue()) {
                        arrayList.add(0, WalletCardListMapper.Companion.mapToDisplayModel(walletCreditCardGetListItemModel));
                    }
                }
                if (walletCreditCardGetListItemModel.isCardDefault() != null) {
                    arrayList.add(WalletCardListMapper.Companion.mapToDisplayModel(walletCreditCardGetListItemModel));
                }
            }
            WalletCardListDisplayModel walletCardListDisplayModel = new WalletCardListDisplayModel((List) null, false, 0, 7, (DefaultConstructorMarker) null);
            walletCardListDisplayModel.setCardList(arrayList);
            walletCardListDisplayModel.setServiceSuccessful(true);
            return walletCardListDisplayModel;
        }
    }
}
