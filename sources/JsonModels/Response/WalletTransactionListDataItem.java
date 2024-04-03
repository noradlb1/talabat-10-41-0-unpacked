package JsonModels.Response;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"LJsonModels/Response/WalletTransactionListDataItem;", "", "()V", "typeId", "", "getTypeId", "()I", "ExpiringCardModel", "Header", "ListHeader", "TransactionModel", "LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "LJsonModels/Response/WalletTransactionListDataItem$Header;", "LJsonModels/Response/WalletTransactionListDataItem$ExpiringCardModel;", "LJsonModels/Response/WalletTransactionListDataItem$ListHeader;", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletTransactionListDataItem {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\rHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"LJsonModels/Response/WalletTransactionListDataItem$ExpiringCardModel;", "LJsonModels/Response/WalletTransactionListDataItem;", "amount", "", "expiryDate", "(Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getExpiryDate", "setExpiryDate", "typeId", "", "getTypeId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ExpiringCardModel extends WalletTransactionListDataItem {
        @NotNull
        private String amount;
        @NotNull
        private String expiryDate;
        private final int typeId = 3;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ExpiringCardModel(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "amount");
            Intrinsics.checkNotNullParameter(str2, "expiryDate");
            this.amount = str;
            this.expiryDate = str2;
        }

        public static /* synthetic */ ExpiringCardModel copy$default(ExpiringCardModel expiringCardModel, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = expiringCardModel.amount;
            }
            if ((i11 & 2) != 0) {
                str2 = expiringCardModel.expiryDate;
            }
            return expiringCardModel.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.amount;
        }

        @NotNull
        public final String component2() {
            return this.expiryDate;
        }

        @NotNull
        public final ExpiringCardModel copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "amount");
            Intrinsics.checkNotNullParameter(str2, "expiryDate");
            return new ExpiringCardModel(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExpiringCardModel)) {
                return false;
            }
            ExpiringCardModel expiringCardModel = (ExpiringCardModel) obj;
            return Intrinsics.areEqual((Object) this.amount, (Object) expiringCardModel.amount) && Intrinsics.areEqual((Object) this.expiryDate, (Object) expiringCardModel.expiryDate);
        }

        @NotNull
        public final String getAmount() {
            return this.amount;
        }

        @NotNull
        public final String getExpiryDate() {
            return this.expiryDate;
        }

        public int getTypeId() {
            return this.typeId;
        }

        public int hashCode() {
            return (this.amount.hashCode() * 31) + this.expiryDate.hashCode();
        }

        public final void setAmount(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.amount = str;
        }

        public final void setExpiryDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.expiryDate = str;
        }

        @NotNull
        public String toString() {
            String str = this.amount;
            String str2 = this.expiryDate;
            return "ExpiringCardModel(amount=" + str + ", expiryDate=" + str2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"LJsonModels/Response/WalletTransactionListDataItem$Header;", "LJsonModels/Response/WalletTransactionListDataItem;", "date", "", "(Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "typeId", "", "getTypeId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Header extends WalletTransactionListDataItem {
        @Nullable
        private String date;
        private final int typeId = 2;

        public Header(@Nullable String str) {
            super((DefaultConstructorMarker) null);
            this.date = str;
        }

        public static /* synthetic */ Header copy$default(Header header, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = header.date;
            }
            return header.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.date;
        }

        @NotNull
        public final Header copy(@Nullable String str) {
            return new Header(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Header) && Intrinsics.areEqual((Object) this.date, (Object) ((Header) obj).date);
        }

        @Nullable
        public final String getDate() {
            return this.date;
        }

        public int getTypeId() {
            return this.typeId;
        }

        public int hashCode() {
            String str = this.date;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final void setDate(@Nullable String str) {
            this.date = str;
        }

        @NotNull
        public String toString() {
            String str = this.date;
            return "Header(date=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LJsonModels/Response/WalletTransactionListDataItem$ListHeader;", "LJsonModels/Response/WalletTransactionListDataItem;", "()V", "typeId", "", "getTypeId", "()I", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ListHeader extends WalletTransactionListDataItem {
        private final int typeId = 4;

        public ListHeader() {
            super((DefaultConstructorMarker) null);
        }

        public int getTypeId() {
            return this.typeId;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b/\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\t\u0010@\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001aR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u0014\u0010,\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006A"}, d2 = {"LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "LJsonModels/Response/WalletTransactionListDataItem;", "id", "", "transactionId", "name", "", "imageUrl", "description", "transactionTypeId", "transactionTypeName", "amount", "", "cashbackAmount", "date", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Float;", "setAmount", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getCashbackAmount", "setCashbackAmount", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getImageUrl", "setImageUrl", "getName", "setName", "getTransactionId", "setTransactionId", "getTransactionTypeId", "setTransactionTypeId", "getTransactionTypeName", "setTransactionTypeName", "typeId", "getTypeId", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TransactionModel extends WalletTransactionListDataItem {
        @Nullable
        private Float amount;
        @Nullable
        private Float cashbackAmount;
        @Nullable
        private String date;
        @Nullable
        private String description;
        @Nullable

        /* renamed from: id  reason: collision with root package name */
        private Integer f484id;
        @Nullable
        private String imageUrl;
        @Nullable

        /* renamed from: name  reason: collision with root package name */
        private String f485name;
        @Nullable
        private Integer transactionId;
        @Nullable
        private Integer transactionTypeId;
        @Nullable
        private String transactionTypeName;
        private final int typeId = 1;

        public TransactionModel(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num3, @Nullable String str4, @Nullable Float f11, @Nullable Float f12, @Nullable String str5) {
            super((DefaultConstructorMarker) null);
            this.f484id = num;
            this.transactionId = num2;
            this.f485name = str;
            this.imageUrl = str2;
            this.description = str3;
            this.transactionTypeId = num3;
            this.transactionTypeName = str4;
            this.amount = f11;
            this.cashbackAmount = f12;
            this.date = str5;
        }

        public static /* synthetic */ TransactionModel copy$default(TransactionModel transactionModel, Integer num, Integer num2, String str, String str2, String str3, Integer num3, String str4, Float f11, Float f12, String str5, int i11, Object obj) {
            TransactionModel transactionModel2 = transactionModel;
            int i12 = i11;
            return transactionModel.copy((i12 & 1) != 0 ? transactionModel2.f484id : num, (i12 & 2) != 0 ? transactionModel2.transactionId : num2, (i12 & 4) != 0 ? transactionModel2.f485name : str, (i12 & 8) != 0 ? transactionModel2.imageUrl : str2, (i12 & 16) != 0 ? transactionModel2.description : str3, (i12 & 32) != 0 ? transactionModel2.transactionTypeId : num3, (i12 & 64) != 0 ? transactionModel2.transactionTypeName : str4, (i12 & 128) != 0 ? transactionModel2.amount : f11, (i12 & 256) != 0 ? transactionModel2.cashbackAmount : f12, (i12 & 512) != 0 ? transactionModel2.date : str5);
        }

        @Nullable
        public final Integer component1() {
            return this.f484id;
        }

        @Nullable
        public final String component10() {
            return this.date;
        }

        @Nullable
        public final Integer component2() {
            return this.transactionId;
        }

        @Nullable
        public final String component3() {
            return this.f485name;
        }

        @Nullable
        public final String component4() {
            return this.imageUrl;
        }

        @Nullable
        public final String component5() {
            return this.description;
        }

        @Nullable
        public final Integer component6() {
            return this.transactionTypeId;
        }

        @Nullable
        public final String component7() {
            return this.transactionTypeName;
        }

        @Nullable
        public final Float component8() {
            return this.amount;
        }

        @Nullable
        public final Float component9() {
            return this.cashbackAmount;
        }

        @NotNull
        public final TransactionModel copy(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num3, @Nullable String str4, @Nullable Float f11, @Nullable Float f12, @Nullable String str5) {
            return new TransactionModel(num, num2, str, str2, str3, num3, str4, f11, f12, str5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransactionModel)) {
                return false;
            }
            TransactionModel transactionModel = (TransactionModel) obj;
            return Intrinsics.areEqual((Object) this.f484id, (Object) transactionModel.f484id) && Intrinsics.areEqual((Object) this.transactionId, (Object) transactionModel.transactionId) && Intrinsics.areEqual((Object) this.f485name, (Object) transactionModel.f485name) && Intrinsics.areEqual((Object) this.imageUrl, (Object) transactionModel.imageUrl) && Intrinsics.areEqual((Object) this.description, (Object) transactionModel.description) && Intrinsics.areEqual((Object) this.transactionTypeId, (Object) transactionModel.transactionTypeId) && Intrinsics.areEqual((Object) this.transactionTypeName, (Object) transactionModel.transactionTypeName) && Intrinsics.areEqual((Object) this.amount, (Object) transactionModel.amount) && Intrinsics.areEqual((Object) this.cashbackAmount, (Object) transactionModel.cashbackAmount) && Intrinsics.areEqual((Object) this.date, (Object) transactionModel.date);
        }

        @Nullable
        public final Float getAmount() {
            return this.amount;
        }

        @Nullable
        public final Float getCashbackAmount() {
            return this.cashbackAmount;
        }

        @Nullable
        public final String getDate() {
            return this.date;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final Integer getId() {
            return this.f484id;
        }

        @Nullable
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @Nullable
        public final String getName() {
            return this.f485name;
        }

        @Nullable
        public final Integer getTransactionId() {
            return this.transactionId;
        }

        @Nullable
        public final Integer getTransactionTypeId() {
            return this.transactionTypeId;
        }

        @Nullable
        public final String getTransactionTypeName() {
            return this.transactionTypeName;
        }

        public int getTypeId() {
            return this.typeId;
        }

        public int hashCode() {
            Integer num = this.f484id;
            int i11 = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.transactionId;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.f485name;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.imageUrl;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.description;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num3 = this.transactionTypeId;
            int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str4 = this.transactionTypeName;
            int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Float f11 = this.amount;
            int hashCode8 = (hashCode7 + (f11 == null ? 0 : f11.hashCode())) * 31;
            Float f12 = this.cashbackAmount;
            int hashCode9 = (hashCode8 + (f12 == null ? 0 : f12.hashCode())) * 31;
            String str5 = this.date;
            if (str5 != null) {
                i11 = str5.hashCode();
            }
            return hashCode9 + i11;
        }

        public final void setAmount(@Nullable Float f11) {
            this.amount = f11;
        }

        public final void setCashbackAmount(@Nullable Float f11) {
            this.cashbackAmount = f11;
        }

        public final void setDate(@Nullable String str) {
            this.date = str;
        }

        public final void setDescription(@Nullable String str) {
            this.description = str;
        }

        public final void setId(@Nullable Integer num) {
            this.f484id = num;
        }

        public final void setImageUrl(@Nullable String str) {
            this.imageUrl = str;
        }

        public final void setName(@Nullable String str) {
            this.f485name = str;
        }

        public final void setTransactionId(@Nullable Integer num) {
            this.transactionId = num;
        }

        public final void setTransactionTypeId(@Nullable Integer num) {
            this.transactionTypeId = num;
        }

        public final void setTransactionTypeName(@Nullable String str) {
            this.transactionTypeName = str;
        }

        @NotNull
        public String toString() {
            Integer num = this.f484id;
            Integer num2 = this.transactionId;
            String str = this.f485name;
            String str2 = this.imageUrl;
            String str3 = this.description;
            Integer num3 = this.transactionTypeId;
            String str4 = this.transactionTypeName;
            Float f11 = this.amount;
            Float f12 = this.cashbackAmount;
            String str5 = this.date;
            return "TransactionModel(id=" + num + ", transactionId=" + num2 + ", name=" + str + ", imageUrl=" + str2 + ", description=" + str3 + ", transactionTypeId=" + num3 + ", transactionTypeName=" + str4 + ", amount=" + f11 + ", cashbackAmount=" + f12 + ", date=" + str5 + ")";
        }
    }

    private WalletTransactionListDataItem() {
    }

    public /* synthetic */ WalletTransactionListDataItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getTypeId();
}
