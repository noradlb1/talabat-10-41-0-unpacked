package com.talabat.feature.walletcobrandedcc.data.remote;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletStatusResponse;", "", "responseMessages", "result", "Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletStatusResponse$Result;", "(Ljava/lang/Object;Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletStatusResponse$Result;)V", "getResponseMessages", "()Ljava/lang/Object;", "getResult", "()Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletStatusResponse$Result;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Result", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletStatusResponse {
    @SerializedName("responseMessages")
    @NotNull
    private final Object responseMessages;
    @SerializedName("result")
    @NotNull
    private final Result result;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletStatusResponse$Result;", "", "shouldShowNotification", "", "style", "", "text", "(ZLjava/lang/String;Ljava/lang/String;)V", "getShouldShowNotification", "()Z", "getStyle", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Result {
        @SerializedName("shouldShowNotification")
        private final boolean shouldShowNotification;
        @SerializedName("style")
        @NotNull
        private final String style;
        @SerializedName("text")
        @NotNull
        private final String text;

        public Result(boolean z11, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "style");
            Intrinsics.checkNotNullParameter(str2, "text");
            this.shouldShowNotification = z11;
            this.style = str;
            this.text = str2;
        }

        public static /* synthetic */ Result copy$default(Result result, boolean z11, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = result.shouldShowNotification;
            }
            if ((i11 & 2) != 0) {
                str = result.style;
            }
            if ((i11 & 4) != 0) {
                str2 = result.text;
            }
            return result.copy(z11, str, str2);
        }

        public final boolean component1() {
            return this.shouldShowNotification;
        }

        @NotNull
        public final String component2() {
            return this.style;
        }

        @NotNull
        public final String component3() {
            return this.text;
        }

        @NotNull
        public final Result copy(boolean z11, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "style");
            Intrinsics.checkNotNullParameter(str2, "text");
            return new Result(z11, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return this.shouldShowNotification == result.shouldShowNotification && Intrinsics.areEqual((Object) this.style, (Object) result.style) && Intrinsics.areEqual((Object) this.text, (Object) result.text);
        }

        public final boolean getShouldShowNotification() {
            return this.shouldShowNotification;
        }

        @NotNull
        public final String getStyle() {
            return this.style;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            boolean z11 = this.shouldShowNotification;
            if (z11) {
                z11 = true;
            }
            return ((((z11 ? 1 : 0) * true) + this.style.hashCode()) * 31) + this.text.hashCode();
        }

        @NotNull
        public String toString() {
            boolean z11 = this.shouldShowNotification;
            String str = this.style;
            String str2 = this.text;
            return "Result(shouldShowNotification=" + z11 + ", style=" + str + ", text=" + str2 + ")";
        }
    }

    public WalletStatusResponse(@NotNull Object obj, @NotNull Result result2) {
        Intrinsics.checkNotNullParameter(obj, "responseMessages");
        Intrinsics.checkNotNullParameter(result2, "result");
        this.responseMessages = obj;
        this.result = result2;
    }

    public static /* synthetic */ WalletStatusResponse copy$default(WalletStatusResponse walletStatusResponse, Object obj, Result result2, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = walletStatusResponse.responseMessages;
        }
        if ((i11 & 2) != 0) {
            result2 = walletStatusResponse.result;
        }
        return walletStatusResponse.copy(obj, result2);
    }

    @NotNull
    public final Object component1() {
        return this.responseMessages;
    }

    @NotNull
    public final Result component2() {
        return this.result;
    }

    @NotNull
    public final WalletStatusResponse copy(@NotNull Object obj, @NotNull Result result2) {
        Intrinsics.checkNotNullParameter(obj, "responseMessages");
        Intrinsics.checkNotNullParameter(result2, "result");
        return new WalletStatusResponse(obj, result2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletStatusResponse)) {
            return false;
        }
        WalletStatusResponse walletStatusResponse = (WalletStatusResponse) obj;
        return Intrinsics.areEqual(this.responseMessages, walletStatusResponse.responseMessages) && Intrinsics.areEqual((Object) this.result, (Object) walletStatusResponse.result);
    }

    @NotNull
    public final Object getResponseMessages() {
        return this.responseMessages;
    }

    @NotNull
    public final Result getResult() {
        return this.result;
    }

    public int hashCode() {
        return (this.responseMessages.hashCode() * 31) + this.result.hashCode();
    }

    @NotNull
    public String toString() {
        Object obj = this.responseMessages;
        Result result2 = this.result;
        return "WalletStatusResponse(responseMessages=" + obj + ", result=" + result2 + ")";
    }
}
