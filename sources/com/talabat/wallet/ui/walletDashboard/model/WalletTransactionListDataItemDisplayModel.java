package com.talabat.wallet.ui.walletDashboard.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel;", "", "()V", "viewTypeId", "", "getViewTypeId", "()I", "CobrandedCCModel", "ExpiringCreditModel", "TransactionDisplayModel", "TransactionGroupHeaderModel", "TransactionListHeaderModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionGroupHeaderModel;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$ExpiringCreditModel;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionListHeaderModel;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$CobrandedCCModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletTransactionListDataItemDisplayModel {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$CobrandedCCModel;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel;", "()V", "bannerImageUrl", "", "getBannerImageUrl", "()Ljava/lang/String;", "setBannerImageUrl", "(Ljava/lang/String;)V", "bannerName", "getBannerName", "setBannerName", "deepLink", "getDeepLink", "setDeepLink", "shouldShowBanner", "", "getShouldShowBanner", "()Z", "setShouldShowBanner", "(Z)V", "viewTypeId", "", "getViewTypeId", "()I", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CobrandedCCModel extends WalletTransactionListDataItemDisplayModel {
        @Nullable
        private String bannerImageUrl;
        @NotNull
        private String bannerName = "";
        @Nullable
        private String deepLink;
        private boolean shouldShowBanner;
        private final int viewTypeId = WalletTransactionListViewTypes.ITEM_VIEW_TYPE_COBRANDED_CC.getValue();

        public CobrandedCCModel() {
            super((DefaultConstructorMarker) null);
        }

        @Nullable
        public final String getBannerImageUrl() {
            return this.bannerImageUrl;
        }

        @NotNull
        public final String getBannerName() {
            return this.bannerName;
        }

        @Nullable
        public final String getDeepLink() {
            return this.deepLink;
        }

        public final boolean getShouldShowBanner() {
            return this.shouldShowBanner;
        }

        public int getViewTypeId() {
            return this.viewTypeId;
        }

        public final void setBannerImageUrl(@Nullable String str) {
            this.bannerImageUrl = str;
        }

        public final void setBannerName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bannerName = str;
        }

        public final void setDeepLink(@Nullable String str) {
            this.deepLink = str;
        }

        public final void setShouldShowBanner(boolean z11) {
            this.shouldShowBanner = z11;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$ExpiringCreditModel;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel;", "()V", "amount", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "expiryDate", "getExpiryDate", "setExpiryDate", "viewTypeId", "", "getViewTypeId", "()I", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ExpiringCreditModel extends WalletTransactionListDataItemDisplayModel {
        @NotNull
        private String amount;
        @NotNull
        private String expiryDate;
        private final int viewTypeId = WalletTransactionListViewTypes.ITEM_VIEW_TYPE_EXPIRING_CREDIT.getValue();

        public ExpiringCreditModel() {
            super((DefaultConstructorMarker) null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            this.amount = StringUtils.empty(stringCompanionObject);
            this.expiryDate = StringUtils.empty(stringCompanionObject);
        }

        @NotNull
        public final String getAmount() {
            return this.amount;
        }

        @NotNull
        public final String getExpiryDate() {
            return this.expiryDate;
        }

        public int getViewTypeId() {
            return this.viewTypeId;
        }

        public final void setAmount(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.amount = str;
        }

        public final void setExpiryDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.expiryDate = str;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010'\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u0014\u0010*\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018¨\u0006,"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel;", "()V", "amount", "", "getAmount", "()F", "setAmount", "(F)V", "cashBackAmount", "getCashBackAmount", "setCashBackAmount", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "id", "", "getId", "()I", "setId", "(I)V", "imageUrl", "getImageUrl", "setImageUrl", "name", "getName", "setName", "transactionId", "getTransactionId", "setTransactionId", "transactionTypeId", "getTransactionTypeId", "setTransactionTypeId", "transactionTypeName", "getTransactionTypeName", "setTransactionTypeName", "viewTypeId", "getViewTypeId", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TransactionDisplayModel extends WalletTransactionListDataItemDisplayModel {
        private float amount;
        private float cashBackAmount;
        @NotNull
        private String date;
        @NotNull
        private String description;

        /* renamed from: id  reason: collision with root package name */
        private int f12742id = -1;
        @NotNull
        private String imageUrl;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private String f12743name;
        private int transactionId = -1;
        private int transactionTypeId;
        @NotNull
        private String transactionTypeName;
        private final int viewTypeId = WalletTransactionListViewTypes.ITEM_VIEW_TYPE_TRANSACTION.getValue();

        public TransactionDisplayModel() {
            super((DefaultConstructorMarker) null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            this.f12743name = StringUtils.empty(stringCompanionObject);
            this.imageUrl = StringUtils.empty(stringCompanionObject);
            this.description = StringUtils.empty(stringCompanionObject);
            this.transactionTypeId = -1;
            this.transactionTypeName = StringUtils.empty(stringCompanionObject);
            this.date = StringUtils.empty(stringCompanionObject);
        }

        public final float getAmount() {
            return this.amount;
        }

        public final float getCashBackAmount() {
            return this.cashBackAmount;
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        public final int getId() {
            return this.f12742id;
        }

        @NotNull
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @NotNull
        public final String getName() {
            return this.f12743name;
        }

        public final int getTransactionId() {
            return this.transactionId;
        }

        public final int getTransactionTypeId() {
            return this.transactionTypeId;
        }

        @NotNull
        public final String getTransactionTypeName() {
            return this.transactionTypeName;
        }

        public int getViewTypeId() {
            return this.viewTypeId;
        }

        public final void setAmount(float f11) {
            this.amount = f11;
        }

        public final void setCashBackAmount(float f11) {
            this.cashBackAmount = f11;
        }

        public final void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.date = str;
        }

        public final void setDescription(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.description = str;
        }

        public final void setId(int i11) {
            this.f12742id = i11;
        }

        public final void setImageUrl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imageUrl = str;
        }

        public final void setName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f12743name = str;
        }

        public final void setTransactionId(int i11) {
            this.transactionId = i11;
        }

        public final void setTransactionTypeId(int i11) {
            this.transactionTypeId = i11;
        }

        public final void setTransactionTypeName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.transactionTypeName = str;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionGroupHeaderModel;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel;", "()V", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "viewTypeId", "", "getViewTypeId", "()I", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TransactionGroupHeaderModel extends WalletTransactionListDataItemDisplayModel {
        @NotNull
        private String date = StringUtils.empty(StringCompanionObject.INSTANCE);
        private final int viewTypeId = WalletTransactionListViewTypes.ITEM_VIEW_TYPE_MONTH_HEADER.getValue();

        public TransactionGroupHeaderModel() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        public int getViewTypeId() {
            return this.viewTypeId;
        }

        public final void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.date = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionListHeaderModel;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel;", "()V", "viewTypeId", "", "getViewTypeId", "()I", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TransactionListHeaderModel extends WalletTransactionListDataItemDisplayModel {
        private final int viewTypeId = WalletTransactionListViewTypes.ITEM_VIEW_TYPE_LIST_HEADER.getValue();

        public TransactionListHeaderModel() {
            super((DefaultConstructorMarker) null);
        }

        public int getViewTypeId() {
            return this.viewTypeId;
        }
    }

    private WalletTransactionListDataItemDisplayModel() {
    }

    public /* synthetic */ WalletTransactionListDataItemDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getViewTypeId();
}
