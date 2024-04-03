package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"LJsonModels/Response/WalletTopUpAmountSuggestionResultModel;", "", "topUpAmountSuggestions", "", "LJsonModels/Response/WalletTopUpAmountSuggestion;", "(Ljava/util/List;)V", "getTopUpAmountSuggestions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpAmountSuggestionResultModel {
    @SerializedName("topupSuggestions")
    @Nullable
    private final List<WalletTopUpAmountSuggestion> topUpAmountSuggestions;

    public WalletTopUpAmountSuggestionResultModel(@Nullable List<WalletTopUpAmountSuggestion> list) {
        this.topUpAmountSuggestions = list;
    }

    public static /* synthetic */ WalletTopUpAmountSuggestionResultModel copy$default(WalletTopUpAmountSuggestionResultModel walletTopUpAmountSuggestionResultModel, List<WalletTopUpAmountSuggestion> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = walletTopUpAmountSuggestionResultModel.topUpAmountSuggestions;
        }
        return walletTopUpAmountSuggestionResultModel.copy(list);
    }

    @Nullable
    public final List<WalletTopUpAmountSuggestion> component1() {
        return this.topUpAmountSuggestions;
    }

    @NotNull
    public final WalletTopUpAmountSuggestionResultModel copy(@Nullable List<WalletTopUpAmountSuggestion> list) {
        return new WalletTopUpAmountSuggestionResultModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletTopUpAmountSuggestionResultModel) && Intrinsics.areEqual((Object) this.topUpAmountSuggestions, (Object) ((WalletTopUpAmountSuggestionResultModel) obj).topUpAmountSuggestions);
    }

    @Nullable
    public final List<WalletTopUpAmountSuggestion> getTopUpAmountSuggestions() {
        return this.topUpAmountSuggestions;
    }

    public int hashCode() {
        List<WalletTopUpAmountSuggestion> list = this.topUpAmountSuggestions;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<WalletTopUpAmountSuggestion> list = this.topUpAmountSuggestions;
        return "WalletTopUpAmountSuggestionResultModel(topUpAmountSuggestions=" + list + ")";
    }
}
