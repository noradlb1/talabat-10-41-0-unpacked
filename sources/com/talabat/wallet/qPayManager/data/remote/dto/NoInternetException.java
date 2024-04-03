package com.talabat.wallet.qPayManager.data.remote.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/qPayManager/data/remote/dto/NoInternetException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/String;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NoInternetException extends Exception {
    @NotNull
    private final String msg;

    public NoInternetException() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoInternetException(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "msg");
        this.msg = str;
    }

    private final String component1() {
        return this.msg;
    }

    public static /* synthetic */ NoInternetException copy$default(NoInternetException noInternetException, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = noInternetException.msg;
        }
        return noInternetException.copy(str);
    }

    @NotNull
    public final NoInternetException copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        return new NoInternetException(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NoInternetException) && Intrinsics.areEqual((Object) this.msg, (Object) ((NoInternetException) obj).msg);
    }

    public int hashCode() {
        return this.msg.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.msg;
        return "NoInternetException(msg=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoInternetException(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str);
    }
}
