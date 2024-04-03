package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutResponse;", "", "token", "", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutResponse {
    @NotNull
    private final String token;

    public CheckoutResponse(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        this.token = str;
    }

    public static /* synthetic */ CheckoutResponse copy$default(CheckoutResponse checkoutResponse, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = checkoutResponse.token;
        }
        return checkoutResponse.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.token;
    }

    @NotNull
    public final CheckoutResponse copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        return new CheckoutResponse(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CheckoutResponse) && Intrinsics.areEqual((Object) this.token, (Object) ((CheckoutResponse) obj).token);
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return this.token.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.token;
        return "CheckoutResponse(token=" + str + ")";
    }
}
