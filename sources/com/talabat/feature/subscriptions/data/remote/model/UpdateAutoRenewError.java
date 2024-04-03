package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/UpdateAutoRenewError;", "", "responseCode", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getResponseCode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateAutoRenewError {
    @Nullable
    private String message;
    @Nullable
    private final String responseCode;

    public UpdateAutoRenewError() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public UpdateAutoRenewError(@Nullable @Json(name = "responseCode") String str, @Nullable @Json(name = "message") String str2) {
        this.responseCode = str;
        this.message = str2;
    }

    public static /* synthetic */ UpdateAutoRenewError copy$default(UpdateAutoRenewError updateAutoRenewError, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = updateAutoRenewError.responseCode;
        }
        if ((i11 & 2) != 0) {
            str2 = updateAutoRenewError.message;
        }
        return updateAutoRenewError.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.responseCode;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final UpdateAutoRenewError copy(@Nullable @Json(name = "responseCode") String str, @Nullable @Json(name = "message") String str2) {
        return new UpdateAutoRenewError(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateAutoRenewError)) {
            return false;
        }
        UpdateAutoRenewError updateAutoRenewError = (UpdateAutoRenewError) obj;
        return Intrinsics.areEqual((Object) this.responseCode, (Object) updateAutoRenewError.responseCode) && Intrinsics.areEqual((Object) this.message, (Object) updateAutoRenewError.message);
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getResponseCode() {
        return this.responseCode;
    }

    public int hashCode() {
        String str = this.responseCode;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setMessage(@Nullable String str) {
        this.message = str;
    }

    @NotNull
    public String toString() {
        String str = this.responseCode;
        String str2 = this.message;
        return "UpdateAutoRenewError(responseCode=" + str + ", message=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpdateAutoRenewError(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
