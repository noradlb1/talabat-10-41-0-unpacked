package com.talabat.wallet.ui.walletTopUp.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.wallet.ui.walletCardManagement.model.CardMessageHeaderType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "", "()V", "viewTypeId", "", "getViewTypeId", "()I", "AddCardButton", "CardPlaceholder", "EmptyView", "HeaderMessage", "WalletCardAdapterDisplayModel", "WalletCashBackCampaignDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$AddCardButton;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCashBackCampaignDisplayModel;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$HeaderMessage;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$CardPlaceholder;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$EmptyView;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletCreditCardListDataItemDisplayModel {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$AddCardButton;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "()V", "viewTypeId", "", "getViewTypeId", "()I", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AddCardButton extends WalletCreditCardListDataItemDisplayModel {
        private final int viewTypeId = WalletCreditCardListViewType.ITEM_VIEW_TYPE_ADD_CARD.getValue();

        public AddCardButton() {
            super((DefaultConstructorMarker) null);
        }

        public int getViewTypeId() {
            return this.viewTypeId;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$CardPlaceholder;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "()V", "viewTypeId", "", "getViewTypeId", "()I", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CardPlaceholder extends WalletCreditCardListDataItemDisplayModel {
        @NotNull
        public static final CardPlaceholder INSTANCE = new CardPlaceholder();
        private static final int viewTypeId = WalletCreditCardListViewType.ITEM_VIEW_TYPE_EMPTY_CARD.getValue();

        private CardPlaceholder() {
            super((DefaultConstructorMarker) null);
        }

        public int getViewTypeId() {
            return viewTypeId;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$EmptyView;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "()V", "viewTypeId", "", "getViewTypeId", "()I", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EmptyView extends WalletCreditCardListDataItemDisplayModel {
        @NotNull
        public static final EmptyView INSTANCE = new EmptyView();
        private static final int viewTypeId = WalletCreditCardListViewType.ITEM_VIEW_TYPE_EMPTY_VIEW.getValue();

        private EmptyView() {
            super((DefaultConstructorMarker) null);
        }

        public int getViewTypeId() {
            return viewTypeId;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$HeaderMessage;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "()V", "message", "Lcom/talabat/wallet/ui/walletCardManagement/model/CardMessageHeaderType;", "getMessage", "()Lcom/talabat/wallet/ui/walletCardManagement/model/CardMessageHeaderType;", "setMessage", "(Lcom/talabat/wallet/ui/walletCardManagement/model/CardMessageHeaderType;)V", "viewTypeId", "", "getViewTypeId", "()I", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HeaderMessage extends WalletCreditCardListDataItemDisplayModel {
        @NotNull
        private CardMessageHeaderType message = CardMessageHeaderType.DEFAULT;
        private final int viewTypeId = WalletCreditCardListViewType.ITEM_VIEW_TYPE_CARD_HEADER_MESSAGE.getValue();

        public HeaderMessage() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public final CardMessageHeaderType getMessage() {
            return this.message;
        }

        public int getViewTypeId() {
            return this.viewTypeId;
        }

        public final void setMessage(@NotNull CardMessageHeaderType cardMessageHeaderType) {
            Intrinsics.checkNotNullParameter(cardMessageHeaderType, "<set-?>");
            this.message = cardMessageHeaderType;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\"\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u0014\u00100\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'¨\u00062"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "()V", "adTextMessage", "", "getAdTextMessage", "()Ljava/lang/String;", "setAdTextMessage", "(Ljava/lang/String;)V", "binNumber", "getBinNumber", "setBinNumber", "card4Digits", "getCard4Digits", "setCard4Digits", "cardNumber", "getCardNumber", "setCardNumber", "cardType", "getCardType", "setCardType", "expiryMonth", "getExpiryMonth", "setExpiryMonth", "expiryYear", "getExpiryYear", "setExpiryYear", "isAdvertTextMessageShown", "", "()Z", "setAdvertTextMessageShown", "(Z)V", "isDefaultCard", "setDefaultCard", "isEnabled", "setEnabled", "position", "", "getPosition", "()I", "setPosition", "(I)V", "token", "getToken", "setToken", "tokenId", "getTokenId", "setTokenId", "viewTypeId", "getViewTypeId", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WalletCardAdapterDisplayModel extends WalletCreditCardListDataItemDisplayModel {
        @NotNull
        private String adTextMessage;
        @NotNull
        private String binNumber;
        @NotNull
        private String card4Digits;
        @NotNull
        private String cardNumber;
        @NotNull
        private String cardType;
        @NotNull
        private String expiryMonth;
        @NotNull
        private String expiryYear;
        private boolean isAdvertTextMessageShown;
        private boolean isDefaultCard;
        private boolean isEnabled;
        private int position;
        @NotNull
        private String token;
        @NotNull
        private String tokenId;
        private final int viewTypeId = WalletCreditCardListViewType.ITEM_VIEW_TYPE_CREDIT_CARD.getValue();

        public WalletCardAdapterDisplayModel() {
            super((DefaultConstructorMarker) null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            this.token = StringUtils.empty(stringCompanionObject);
            this.tokenId = StringUtils.empty(stringCompanionObject);
            this.cardNumber = StringUtils.empty(stringCompanionObject);
            this.cardType = StringUtils.empty(stringCompanionObject);
            this.binNumber = StringUtils.empty(stringCompanionObject);
            this.expiryMonth = StringUtils.empty(stringCompanionObject);
            this.expiryYear = StringUtils.empty(stringCompanionObject);
            this.adTextMessage = StringUtils.empty(stringCompanionObject);
            this.position = -1;
            this.card4Digits = StringUtils.empty(stringCompanionObject);
            this.isEnabled = true;
        }

        @NotNull
        public final String getAdTextMessage() {
            return this.adTextMessage;
        }

        @NotNull
        public final String getBinNumber() {
            return this.binNumber;
        }

        @NotNull
        public final String getCard4Digits() {
            return this.card4Digits;
        }

        @NotNull
        public final String getCardNumber() {
            return this.cardNumber;
        }

        @NotNull
        public final String getCardType() {
            return this.cardType;
        }

        @NotNull
        public final String getExpiryMonth() {
            return this.expiryMonth;
        }

        @NotNull
        public final String getExpiryYear() {
            return this.expiryYear;
        }

        public final int getPosition() {
            return this.position;
        }

        @NotNull
        public final String getToken() {
            return this.token;
        }

        @NotNull
        public final String getTokenId() {
            return this.tokenId;
        }

        public int getViewTypeId() {
            return this.viewTypeId;
        }

        public final boolean isAdvertTextMessageShown() {
            return this.isAdvertTextMessageShown;
        }

        public final boolean isDefaultCard() {
            return this.isDefaultCard;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final void setAdTextMessage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adTextMessage = str;
        }

        public final void setAdvertTextMessageShown(boolean z11) {
            this.isAdvertTextMessageShown = z11;
        }

        public final void setBinNumber(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.binNumber = str;
        }

        public final void setCard4Digits(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.card4Digits = str;
        }

        public final void setCardNumber(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cardNumber = str;
        }

        public final void setCardType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cardType = str;
        }

        public final void setDefaultCard(boolean z11) {
            this.isDefaultCard = z11;
        }

        public final void setEnabled(boolean z11) {
            this.isEnabled = z11;
        }

        public final void setExpiryMonth(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.expiryMonth = str;
        }

        public final void setExpiryYear(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.expiryYear = str;
        }

        public final void setPosition(int i11) {
            this.position = i11;
        }

        public final void setToken(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.token = str;
        }

        public final void setTokenId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tokenId = str;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCashBackCampaignDisplayModel;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "()V", "bankId", "", "getBankId", "()I", "setBankId", "(I)V", "cardNetwork", "", "getCardNetwork", "()Ljava/lang/String;", "setCardNetwork", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "imgUrl", "getImgUrl", "setImgUrl", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "title", "getTitle", "setTitle", "viewTypeId", "getViewTypeId", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WalletCashBackCampaignDisplayModel extends WalletCreditCardListDataItemDisplayModel {
        private int bankId = -1;
        @NotNull
        private String cardNetwork;
        @NotNull
        private String description;
        @NotNull
        private String imgUrl;
        private boolean isEnabled;
        @NotNull
        private String title;
        private final int viewTypeId;

        public WalletCashBackCampaignDisplayModel() {
            super((DefaultConstructorMarker) null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            this.imgUrl = StringUtils.empty(stringCompanionObject);
            this.title = StringUtils.empty(stringCompanionObject);
            this.description = StringUtils.empty(stringCompanionObject);
            this.cardNetwork = StringUtils.empty(stringCompanionObject);
            this.isEnabled = true;
            this.viewTypeId = WalletCreditCardListViewType.ITEM_VIEW_TYPE_CAMPAIGN.getValue();
        }

        public final int getBankId() {
            return this.bankId;
        }

        @NotNull
        public final String getCardNetwork() {
            return this.cardNetwork;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getImgUrl() {
            return this.imgUrl;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int getViewTypeId() {
            return this.viewTypeId;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final void setBankId(int i11) {
            this.bankId = i11;
        }

        public final void setCardNetwork(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cardNetwork = str;
        }

        public final void setDescription(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.description = str;
        }

        public final void setEnabled(boolean z11) {
            this.isEnabled = z11;
        }

        public final void setImgUrl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imgUrl = str;
        }

        public final void setTitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }
    }

    private WalletCreditCardListDataItemDisplayModel() {
    }

    public /* synthetic */ WalletCreditCardListDataItemDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getViewTypeId();
}
