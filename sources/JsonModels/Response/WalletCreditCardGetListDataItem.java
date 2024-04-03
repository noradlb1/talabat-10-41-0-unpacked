package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListDataItem;", "", "()V", "typeId", "", "getTypeId", "()I", "AddCreditCardButtonObject", "CardPlaceHolderView", "EmptyView", "ErrorResponseObject", "Header", "WalletCashbackCampaign", "WalletCreditCardGetListResponseResult", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "LJsonModels/Response/WalletCreditCardGetListDataItem$Header;", "LJsonModels/Response/WalletCreditCardGetListDataItem$AddCreditCardButtonObject;", "LJsonModels/Response/WalletCreditCardGetListDataItem$ErrorResponseObject;", "LJsonModels/Response/WalletCreditCardGetListDataItem$EmptyView;", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCashbackCampaign;", "LJsonModels/Response/WalletCreditCardGetListDataItem$CardPlaceHolderView;", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletCreditCardGetListDataItem {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListDataItem$AddCreditCardButtonObject;", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "label", "", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "setLabel", "typeId", "", "getTypeId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AddCreditCardButtonObject extends WalletCreditCardGetListDataItem {
        @Nullable
        private String label;
        private final int typeId = 3;

        public AddCreditCardButtonObject(@Nullable String str) {
            super((DefaultConstructorMarker) null);
            this.label = str;
        }

        public static /* synthetic */ AddCreditCardButtonObject copy$default(AddCreditCardButtonObject addCreditCardButtonObject, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = addCreditCardButtonObject.label;
            }
            return addCreditCardButtonObject.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.label;
        }

        @NotNull
        public final AddCreditCardButtonObject copy(@Nullable String str) {
            return new AddCreditCardButtonObject(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AddCreditCardButtonObject) && Intrinsics.areEqual((Object) this.label, (Object) ((AddCreditCardButtonObject) obj).label);
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        public int getTypeId() {
            return this.typeId;
        }

        public int hashCode() {
            String str = this.label;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final void setLabel(@Nullable String str) {
            this.label = str;
        }

        @NotNull
        public String toString() {
            String str = this.label;
            return "AddCreditCardButtonObject(label=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListDataItem$EmptyView;", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "label", "", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "setLabel", "typeId", "", "getTypeId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EmptyView extends WalletCreditCardGetListDataItem {
        @NotNull
        private String label;
        private final int typeId = 5;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmptyView(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "label");
            this.label = str;
        }

        public static /* synthetic */ EmptyView copy$default(EmptyView emptyView, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = emptyView.label;
            }
            return emptyView.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.label;
        }

        @NotNull
        public final EmptyView copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "label");
            return new EmptyView(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof EmptyView) && Intrinsics.areEqual((Object) this.label, (Object) ((EmptyView) obj).label);
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        public int getTypeId() {
            return this.typeId;
        }

        public int hashCode() {
            return this.label.hashCode();
        }

        public final void setLabel(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.label = str;
        }

        @NotNull
        public String toString() {
            String str = this.label;
            return "EmptyView(label=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListDataItem$ErrorResponseObject;", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "label", "", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "setLabel", "typeId", "", "getTypeId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ErrorResponseObject extends WalletCreditCardGetListDataItem {
        @NotNull
        private String label;
        private final int typeId = 4;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ErrorResponseObject(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "label");
            this.label = str;
        }

        public static /* synthetic */ ErrorResponseObject copy$default(ErrorResponseObject errorResponseObject, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = errorResponseObject.label;
            }
            return errorResponseObject.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.label;
        }

        @NotNull
        public final ErrorResponseObject copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "label");
            return new ErrorResponseObject(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ErrorResponseObject) && Intrinsics.areEqual((Object) this.label, (Object) ((ErrorResponseObject) obj).label);
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        public int getTypeId() {
            return this.typeId;
        }

        public int hashCode() {
            return this.label.hashCode();
        }

        public final void setLabel(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.label = str;
        }

        @NotNull
        public String toString() {
            String str = this.label;
            return "ErrorResponseObject(label=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListDataItem$Header;", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "typeId", "", "getTypeId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Header extends WalletCreditCardGetListDataItem {
        @Nullable
        private String title;
        private final int typeId = 2;

        public Header(@Nullable String str) {
            super((DefaultConstructorMarker) null);
            this.title = str;
        }

        public static /* synthetic */ Header copy$default(Header header, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = header.title;
            }
            return header.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final Header copy(@Nullable String str) {
            return new Header(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Header) && Intrinsics.areEqual((Object) this.title, (Object) ((Header) obj).title);
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public int getTypeId() {
            return this.typeId;
        }

        public int hashCode() {
            String str = this.title;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final void setTitle(@Nullable String str) {
            this.title = str;
        }

        @NotNull
        public String toString() {
            String str = this.title;
            return "Header(title=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCashbackCampaign;", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "bankId", "", "imgUrl", "", "title", "description", "cardNetwork", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBankId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCardNetwork", "()Ljava/lang/String;", "setCardNetwork", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getImgUrl", "setImgUrl", "getTitle", "typeId", "getTypeId", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCashbackCampaign;", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WalletCashbackCampaign extends WalletCreditCardGetListDataItem {
        @SerializedName("bankId")
        @Nullable
        private final Integer bankId;
        @SerializedName("cardNetwork")
        @Nullable
        private String cardNetwork;
        @SerializedName("description")
        @Nullable
        private String description;
        @SerializedName("imgUrl")
        @Nullable
        private String imgUrl;
        @SerializedName("title")
        @Nullable
        private final String title;
        private final int typeId = 6;

        public WalletCashbackCampaign(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            super((DefaultConstructorMarker) null);
            this.bankId = num;
            this.imgUrl = str;
            this.title = str2;
            this.description = str3;
            this.cardNetwork = str4;
        }

        public static /* synthetic */ WalletCashbackCampaign copy$default(WalletCashbackCampaign walletCashbackCampaign, Integer num, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                num = walletCashbackCampaign.bankId;
            }
            if ((i11 & 2) != 0) {
                str = walletCashbackCampaign.imgUrl;
            }
            String str5 = str;
            if ((i11 & 4) != 0) {
                str2 = walletCashbackCampaign.title;
            }
            String str6 = str2;
            if ((i11 & 8) != 0) {
                str3 = walletCashbackCampaign.description;
            }
            String str7 = str3;
            if ((i11 & 16) != 0) {
                str4 = walletCashbackCampaign.cardNetwork;
            }
            return walletCashbackCampaign.copy(num, str5, str6, str7, str4);
        }

        @Nullable
        public final Integer component1() {
            return this.bankId;
        }

        @Nullable
        public final String component2() {
            return this.imgUrl;
        }

        @Nullable
        public final String component3() {
            return this.title;
        }

        @Nullable
        public final String component4() {
            return this.description;
        }

        @Nullable
        public final String component5() {
            return this.cardNetwork;
        }

        @NotNull
        public final WalletCashbackCampaign copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            return new WalletCashbackCampaign(num, str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WalletCashbackCampaign)) {
                return false;
            }
            WalletCashbackCampaign walletCashbackCampaign = (WalletCashbackCampaign) obj;
            return Intrinsics.areEqual((Object) this.bankId, (Object) walletCashbackCampaign.bankId) && Intrinsics.areEqual((Object) this.imgUrl, (Object) walletCashbackCampaign.imgUrl) && Intrinsics.areEqual((Object) this.title, (Object) walletCashbackCampaign.title) && Intrinsics.areEqual((Object) this.description, (Object) walletCashbackCampaign.description) && Intrinsics.areEqual((Object) this.cardNetwork, (Object) walletCashbackCampaign.cardNetwork);
        }

        @Nullable
        public final Integer getBankId() {
            return this.bankId;
        }

        @Nullable
        public final String getCardNetwork() {
            return this.cardNetwork;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getImgUrl() {
            return this.imgUrl;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public int getTypeId() {
            return this.typeId;
        }

        public int hashCode() {
            Integer num = this.bankId;
            int i11 = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.imgUrl;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.title;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.description;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.cardNetwork;
            if (str4 != null) {
                i11 = str4.hashCode();
            }
            return hashCode4 + i11;
        }

        public final void setCardNetwork(@Nullable String str) {
            this.cardNetwork = str;
        }

        public final void setDescription(@Nullable String str) {
            this.description = str;
        }

        public final void setImgUrl(@Nullable String str) {
            this.imgUrl = str;
        }

        @NotNull
        public String toString() {
            Integer num = this.bankId;
            String str = this.imgUrl;
            String str2 = this.title;
            String str3 = this.description;
            String str4 = this.cardNetwork;
            return "WalletCashbackCampaign(bankId=" + num + ", imgUrl=" + str + ", title=" + str2 + ", description=" + str3 + ", cardNetwork=" + str4 + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0014J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÎ\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020/HÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\u0012\u0010%R\"\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\u0013\u0010%\"\u0004\b'\u0010(R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\n\u0010%R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\u0010\u0010%\"\u0004\b)\u0010(R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0016R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u0014\u0010.\u001a\u00020/XD¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006O"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "token", "", "cardNumber", "cardType", "expiryDate", "expiryYear", "expiryMonth", "holderName", "isCardValid", "", "email", "checkoutMessage", "binNumber", "menuMessage", "isCvvForced", "tokenId", "isBinDiscountValid", "isCardDefault", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBinNumber", "()Ljava/lang/String;", "setBinNumber", "(Ljava/lang/String;)V", "getCardNumber", "setCardNumber", "getCardType", "getCheckoutMessage", "getEmail", "setEmail", "getExpiryDate", "setExpiryDate", "getExpiryMonth", "setExpiryMonth", "getExpiryYear", "getHolderName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "setCardDefault", "(Ljava/lang/Boolean;)V", "setCvvForced", "getMenuMessage", "getToken", "getTokenId", "setTokenId", "typeId", "", "getTypeId", "()I", "walletCashbackCampaignOfferMessageResponse", "LJsonModels/Response/WalletCashbackCampaignOfferMessageResponse;", "getWalletCashbackCampaignOfferMessageResponse", "()LJsonModels/Response/WalletCashbackCampaignOfferMessageResponse;", "setWalletCashbackCampaignOfferMessageResponse", "(LJsonModels/Response/WalletCashbackCampaignOfferMessageResponse;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "equals", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WalletCreditCardGetListResponseResult extends WalletCreditCardGetListDataItem {
        @SerializedName("binNumber")
        @Nullable
        private String binNumber;
        @SerializedName("cardnumber")
        @Nullable
        private String cardNumber;
        @SerializedName("cardtype")
        @Nullable
        private final String cardType;
        @SerializedName("chkOutMesg")
        @Nullable
        private final String checkoutMessage;
        @SerializedName("email")
        @Nullable
        private String email;
        @SerializedName("expiredate")
        @Nullable
        private String expiryDate;
        @SerializedName("expiremonth")
        @Nullable
        private String expiryMonth;
        @SerializedName("expireyear")
        @Nullable
        private final String expiryYear;
        @SerializedName("holdername")
        @Nullable
        private final String holderName;
        @SerializedName("isBinDiscountValid")
        @Nullable
        private final Boolean isBinDiscountValid;
        @SerializedName("isDefault")
        @Nullable
        private Boolean isCardDefault;
        @SerializedName("isValidCard")
        @Nullable
        private final Boolean isCardValid;
        @SerializedName("isForceCvv")
        @Nullable
        private Boolean isCvvForced;
        @SerializedName("menuMesg")
        @Nullable
        private final String menuMessage;
        @SerializedName("token")
        @Nullable
        private final String token;
        @SerializedName("tokenId")
        @Nullable
        private String tokenId;
        private final int typeId = 1;
        @Nullable
        private WalletCashbackCampaignOfferMessageResponse walletCashbackCampaignOfferMessageResponse;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WalletCreditCardGetListResponseResult(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Boolean bool, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable Boolean bool2, @Nullable String str12, @Nullable Boolean bool3, @Nullable Boolean bool4) {
            super((DefaultConstructorMarker) null);
            this.token = str;
            this.cardNumber = str2;
            this.cardType = str3;
            this.expiryDate = str4;
            this.expiryYear = str5;
            this.expiryMonth = str6;
            this.holderName = str7;
            this.isCardValid = bool;
            this.email = str8;
            this.checkoutMessage = str9;
            this.binNumber = str10;
            this.menuMessage = str11;
            this.isCvvForced = bool2;
            this.tokenId = str12;
            this.isBinDiscountValid = bool3;
            this.isCardDefault = bool4;
        }

        public static /* synthetic */ WalletCreditCardGetListResponseResult copy$default(WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, String str11, Boolean bool2, String str12, Boolean bool3, Boolean bool4, int i11, Object obj) {
            WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult2 = walletCreditCardGetListResponseResult;
            int i12 = i11;
            return walletCreditCardGetListResponseResult.copy((i12 & 1) != 0 ? walletCreditCardGetListResponseResult2.token : str, (i12 & 2) != 0 ? walletCreditCardGetListResponseResult2.cardNumber : str2, (i12 & 4) != 0 ? walletCreditCardGetListResponseResult2.cardType : str3, (i12 & 8) != 0 ? walletCreditCardGetListResponseResult2.expiryDate : str4, (i12 & 16) != 0 ? walletCreditCardGetListResponseResult2.expiryYear : str5, (i12 & 32) != 0 ? walletCreditCardGetListResponseResult2.expiryMonth : str6, (i12 & 64) != 0 ? walletCreditCardGetListResponseResult2.holderName : str7, (i12 & 128) != 0 ? walletCreditCardGetListResponseResult2.isCardValid : bool, (i12 & 256) != 0 ? walletCreditCardGetListResponseResult2.email : str8, (i12 & 512) != 0 ? walletCreditCardGetListResponseResult2.checkoutMessage : str9, (i12 & 1024) != 0 ? walletCreditCardGetListResponseResult2.binNumber : str10, (i12 & 2048) != 0 ? walletCreditCardGetListResponseResult2.menuMessage : str11, (i12 & 4096) != 0 ? walletCreditCardGetListResponseResult2.isCvvForced : bool2, (i12 & 8192) != 0 ? walletCreditCardGetListResponseResult2.tokenId : str12, (i12 & 16384) != 0 ? walletCreditCardGetListResponseResult2.isBinDiscountValid : bool3, (i12 & 32768) != 0 ? walletCreditCardGetListResponseResult2.isCardDefault : bool4);
        }

        @Nullable
        public final String component1() {
            return this.token;
        }

        @Nullable
        public final String component10() {
            return this.checkoutMessage;
        }

        @Nullable
        public final String component11() {
            return this.binNumber;
        }

        @Nullable
        public final String component12() {
            return this.menuMessage;
        }

        @Nullable
        public final Boolean component13() {
            return this.isCvvForced;
        }

        @Nullable
        public final String component14() {
            return this.tokenId;
        }

        @Nullable
        public final Boolean component15() {
            return this.isBinDiscountValid;
        }

        @Nullable
        public final Boolean component16() {
            return this.isCardDefault;
        }

        @Nullable
        public final String component2() {
            return this.cardNumber;
        }

        @Nullable
        public final String component3() {
            return this.cardType;
        }

        @Nullable
        public final String component4() {
            return this.expiryDate;
        }

        @Nullable
        public final String component5() {
            return this.expiryYear;
        }

        @Nullable
        public final String component6() {
            return this.expiryMonth;
        }

        @Nullable
        public final String component7() {
            return this.holderName;
        }

        @Nullable
        public final Boolean component8() {
            return this.isCardValid;
        }

        @Nullable
        public final String component9() {
            return this.email;
        }

        @NotNull
        public final WalletCreditCardGetListResponseResult copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Boolean bool, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable Boolean bool2, @Nullable String str12, @Nullable Boolean bool3, @Nullable Boolean bool4) {
            return new WalletCreditCardGetListResponseResult(str, str2, str3, str4, str5, str6, str7, bool, str8, str9, str10, str11, bool2, str12, bool3, bool4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WalletCreditCardGetListResponseResult)) {
                return false;
            }
            WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult = (WalletCreditCardGetListResponseResult) obj;
            return Intrinsics.areEqual((Object) this.token, (Object) walletCreditCardGetListResponseResult.token) && Intrinsics.areEqual((Object) this.cardNumber, (Object) walletCreditCardGetListResponseResult.cardNumber) && Intrinsics.areEqual((Object) this.cardType, (Object) walletCreditCardGetListResponseResult.cardType) && Intrinsics.areEqual((Object) this.expiryDate, (Object) walletCreditCardGetListResponseResult.expiryDate) && Intrinsics.areEqual((Object) this.expiryYear, (Object) walletCreditCardGetListResponseResult.expiryYear) && Intrinsics.areEqual((Object) this.expiryMonth, (Object) walletCreditCardGetListResponseResult.expiryMonth) && Intrinsics.areEqual((Object) this.holderName, (Object) walletCreditCardGetListResponseResult.holderName) && Intrinsics.areEqual((Object) this.isCardValid, (Object) walletCreditCardGetListResponseResult.isCardValid) && Intrinsics.areEqual((Object) this.email, (Object) walletCreditCardGetListResponseResult.email) && Intrinsics.areEqual((Object) this.checkoutMessage, (Object) walletCreditCardGetListResponseResult.checkoutMessage) && Intrinsics.areEqual((Object) this.binNumber, (Object) walletCreditCardGetListResponseResult.binNumber) && Intrinsics.areEqual((Object) this.menuMessage, (Object) walletCreditCardGetListResponseResult.menuMessage) && Intrinsics.areEqual((Object) this.isCvvForced, (Object) walletCreditCardGetListResponseResult.isCvvForced) && Intrinsics.areEqual((Object) this.tokenId, (Object) walletCreditCardGetListResponseResult.tokenId) && Intrinsics.areEqual((Object) this.isBinDiscountValid, (Object) walletCreditCardGetListResponseResult.isBinDiscountValid) && Intrinsics.areEqual((Object) this.isCardDefault, (Object) walletCreditCardGetListResponseResult.isCardDefault);
        }

        @Nullable
        public final String getBinNumber() {
            return this.binNumber;
        }

        @Nullable
        public final String getCardNumber() {
            return this.cardNumber;
        }

        @Nullable
        public final String getCardType() {
            return this.cardType;
        }

        @Nullable
        public final String getCheckoutMessage() {
            return this.checkoutMessage;
        }

        @Nullable
        public final String getEmail() {
            return this.email;
        }

        @Nullable
        public final String getExpiryDate() {
            return this.expiryDate;
        }

        @Nullable
        public final String getExpiryMonth() {
            return this.expiryMonth;
        }

        @Nullable
        public final String getExpiryYear() {
            return this.expiryYear;
        }

        @Nullable
        public final String getHolderName() {
            return this.holderName;
        }

        @Nullable
        public final String getMenuMessage() {
            return this.menuMessage;
        }

        @Nullable
        public final String getToken() {
            return this.token;
        }

        @Nullable
        public final String getTokenId() {
            return this.tokenId;
        }

        public int getTypeId() {
            return this.typeId;
        }

        @Nullable
        public final WalletCashbackCampaignOfferMessageResponse getWalletCashbackCampaignOfferMessageResponse() {
            return this.walletCashbackCampaignOfferMessageResponse;
        }

        public int hashCode() {
            String str = this.token;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.cardNumber;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.cardType;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.expiryDate;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.expiryYear;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.expiryMonth;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.holderName;
            int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Boolean bool = this.isCardValid;
            int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str8 = this.email;
            int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.checkoutMessage;
            int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.binNumber;
            int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.menuMessage;
            int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Boolean bool2 = this.isCvvForced;
            int hashCode13 = (hashCode12 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str12 = this.tokenId;
            int hashCode14 = (hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
            Boolean bool3 = this.isBinDiscountValid;
            int hashCode15 = (hashCode14 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.isCardDefault;
            if (bool4 != null) {
                i11 = bool4.hashCode();
            }
            return hashCode15 + i11;
        }

        @Nullable
        public final Boolean isBinDiscountValid() {
            return this.isBinDiscountValid;
        }

        @Nullable
        public final Boolean isCardDefault() {
            return this.isCardDefault;
        }

        @Nullable
        public final Boolean isCardValid() {
            return this.isCardValid;
        }

        @Nullable
        public final Boolean isCvvForced() {
            return this.isCvvForced;
        }

        public final void setBinNumber(@Nullable String str) {
            this.binNumber = str;
        }

        public final void setCardDefault(@Nullable Boolean bool) {
            this.isCardDefault = bool;
        }

        public final void setCardNumber(@Nullable String str) {
            this.cardNumber = str;
        }

        public final void setCvvForced(@Nullable Boolean bool) {
            this.isCvvForced = bool;
        }

        public final void setEmail(@Nullable String str) {
            this.email = str;
        }

        public final void setExpiryDate(@Nullable String str) {
            this.expiryDate = str;
        }

        public final void setExpiryMonth(@Nullable String str) {
            this.expiryMonth = str;
        }

        public final void setTokenId(@Nullable String str) {
            this.tokenId = str;
        }

        public final void setWalletCashbackCampaignOfferMessageResponse(@Nullable WalletCashbackCampaignOfferMessageResponse walletCashbackCampaignOfferMessageResponse2) {
            this.walletCashbackCampaignOfferMessageResponse = walletCashbackCampaignOfferMessageResponse2;
        }

        @NotNull
        public String toString() {
            String str = this.token;
            String str2 = this.cardNumber;
            String str3 = this.cardType;
            String str4 = this.expiryDate;
            String str5 = this.expiryYear;
            String str6 = this.expiryMonth;
            String str7 = this.holderName;
            Boolean bool = this.isCardValid;
            String str8 = this.email;
            String str9 = this.checkoutMessage;
            String str10 = this.binNumber;
            String str11 = this.menuMessage;
            Boolean bool2 = this.isCvvForced;
            String str12 = this.tokenId;
            Boolean bool3 = this.isBinDiscountValid;
            Boolean bool4 = this.isCardDefault;
            return "WalletCreditCardGetListResponseResult(token=" + str + ", cardNumber=" + str2 + ", cardType=" + str3 + ", expiryDate=" + str4 + ", expiryYear=" + str5 + ", expiryMonth=" + str6 + ", holderName=" + str7 + ", isCardValid=" + bool + ", email=" + str8 + ", checkoutMessage=" + str9 + ", binNumber=" + str10 + ", menuMessage=" + str11 + ", isCvvForced=" + bool2 + ", tokenId=" + str12 + ", isBinDiscountValid=" + bool3 + ", isCardDefault=" + bool4 + ")";
        }
    }

    private WalletCreditCardGetListDataItem() {
    }

    public /* synthetic */ WalletCreditCardGetListDataItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getTypeId();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"LJsonModels/Response/WalletCreditCardGetListDataItem$CardPlaceHolderView;", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "label", "", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "setLabel", "typeId", "", "getTypeId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CardPlaceHolderView extends WalletCreditCardGetListDataItem {
        @NotNull
        private String label;
        private final int typeId;

        public CardPlaceHolderView() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CardPlaceHolderView(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "label");
            this.label = str;
            this.typeId = 7;
        }

        public static /* synthetic */ CardPlaceHolderView copy$default(CardPlaceHolderView cardPlaceHolderView, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cardPlaceHolderView.label;
            }
            return cardPlaceHolderView.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.label;
        }

        @NotNull
        public final CardPlaceHolderView copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "label");
            return new CardPlaceHolderView(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CardPlaceHolderView) && Intrinsics.areEqual((Object) this.label, (Object) ((CardPlaceHolderView) obj).label);
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        public int getTypeId() {
            return this.typeId;
        }

        public int hashCode() {
            return this.label.hashCode();
        }

        public final void setLabel(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.label = str;
        }

        @NotNull
        public String toString() {
            String str = this.label;
            return "CardPlaceHolderView(label=" + str + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CardPlaceHolderView(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? WalletCreditCardGetListDataItemKt.CARD_PLACE_HOLDER_LABEL : str);
        }
    }
}
