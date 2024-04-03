package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"LJsonModels/Response/WalletCashbackCampaign;", "", "bankId", "", "imgUrl", "", "title", "description", "cardNetwork", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBankId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCardNetwork", "()Ljava/lang/String;", "setCardNetwork", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getImgUrl", "setImgUrl", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LJsonModels/Response/WalletCashbackCampaign;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCashbackCampaign {
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

    public WalletCashbackCampaign(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
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
