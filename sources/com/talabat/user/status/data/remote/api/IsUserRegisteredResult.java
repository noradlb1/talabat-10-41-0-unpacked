package com.talabat.user.status.data.remote.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/user/status/data/remote/api/IsUserRegisteredResult;", "", "status", "Lcom/talabat/user/status/data/remote/api/IsUserRegisteredResult$Status;", "error", "(Lcom/talabat/user/status/data/remote/api/IsUserRegisteredResult$Status;Ljava/lang/Object;)V", "getError", "()Ljava/lang/Object;", "getStatus", "()Lcom/talabat/user/status/data/remote/api/IsUserRegisteredResult$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Status", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsUserRegisteredResult {
    @SerializedName("error")
    @Nullable
    private final Object error;
    @SerializedName("status")
    @Nullable
    private final Status status;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/user/status/data/remote/api/IsUserRegisteredResult$Status;", "", "(Ljava/lang/String;I)V", "NOT_FOUND", "REGISTERED", "INVALID_KEY", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Status {
        NOT_FOUND,
        REGISTERED,
        INVALID_KEY
    }

    public IsUserRegisteredResult(@Nullable Status status2, @Nullable Object obj) {
        this.status = status2;
        this.error = obj;
    }

    public static /* synthetic */ IsUserRegisteredResult copy$default(IsUserRegisteredResult isUserRegisteredResult, Status status2, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            status2 = isUserRegisteredResult.status;
        }
        if ((i11 & 2) != 0) {
            obj = isUserRegisteredResult.error;
        }
        return isUserRegisteredResult.copy(status2, obj);
    }

    @Nullable
    public final Status component1() {
        return this.status;
    }

    @Nullable
    public final Object component2() {
        return this.error;
    }

    @NotNull
    public final IsUserRegisteredResult copy(@Nullable Status status2, @Nullable Object obj) {
        return new IsUserRegisteredResult(status2, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IsUserRegisteredResult)) {
            return false;
        }
        IsUserRegisteredResult isUserRegisteredResult = (IsUserRegisteredResult) obj;
        return this.status == isUserRegisteredResult.status && Intrinsics.areEqual(this.error, isUserRegisteredResult.error);
    }

    @Nullable
    public final Object getError() {
        return this.error;
    }

    @Nullable
    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        Status status2 = this.status;
        int i11 = 0;
        int hashCode = (status2 == null ? 0 : status2.hashCode()) * 31;
        Object obj = this.error;
        if (obj != null) {
            i11 = obj.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Status status2 = this.status;
        Object obj = this.error;
        return "IsUserRegisteredResult(status=" + status2 + ", error=" + obj + ")";
    }
}
