package com.talabat.userandlocation.compliance.status.data.remote.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult;", "", "clientId", "", "userId", "", "status", "Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult$Status;", "error", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult$Status;Ljava/lang/Object;)V", "getClientId", "()Ljava/lang/String;", "getError", "()Ljava/lang/Object;", "getStatus", "()Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult$Status;", "getUserId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult$Status;Ljava/lang/Object;)Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult;", "equals", "", "other", "hashCode", "toString", "Status", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserStatusResult {
    @SerializedName("clientId")
    @Nullable
    private final String clientId;
    @SerializedName("error")
    @Nullable
    private final Object error;
    @SerializedName("status")
    @Nullable
    private final Status status;
    @SerializedName("userId")
    @Nullable
    private final Integer userId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult$Status;", "", "(Ljava/lang/String;I)V", "PASS", "PENDING", "FAIL", "ERROR", "UNINITIALIZED", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Status {
        PASS,
        PENDING,
        FAIL,
        ERROR,
        UNINITIALIZED
    }

    public UserStatusResult(@Nullable String str, @Nullable Integer num, @Nullable Status status2, @Nullable Object obj) {
        this.clientId = str;
        this.userId = num;
        this.status = status2;
        this.error = obj;
    }

    public static /* synthetic */ UserStatusResult copy$default(UserStatusResult userStatusResult, String str, Integer num, Status status2, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            str = userStatusResult.clientId;
        }
        if ((i11 & 2) != 0) {
            num = userStatusResult.userId;
        }
        if ((i11 & 4) != 0) {
            status2 = userStatusResult.status;
        }
        if ((i11 & 8) != 0) {
            obj = userStatusResult.error;
        }
        return userStatusResult.copy(str, num, status2, obj);
    }

    @Nullable
    public final String component1() {
        return this.clientId;
    }

    @Nullable
    public final Integer component2() {
        return this.userId;
    }

    @Nullable
    public final Status component3() {
        return this.status;
    }

    @Nullable
    public final Object component4() {
        return this.error;
    }

    @NotNull
    public final UserStatusResult copy(@Nullable String str, @Nullable Integer num, @Nullable Status status2, @Nullable Object obj) {
        return new UserStatusResult(str, num, status2, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserStatusResult)) {
            return false;
        }
        UserStatusResult userStatusResult = (UserStatusResult) obj;
        return Intrinsics.areEqual((Object) this.clientId, (Object) userStatusResult.clientId) && Intrinsics.areEqual((Object) this.userId, (Object) userStatusResult.userId) && this.status == userStatusResult.status && Intrinsics.areEqual(this.error, userStatusResult.error);
    }

    @Nullable
    public final String getClientId() {
        return this.clientId;
    }

    @Nullable
    public final Object getError() {
        return this.error;
    }

    @Nullable
    public final Status getStatus() {
        return this.status;
    }

    @Nullable
    public final Integer getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.clientId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.userId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Status status2 = this.status;
        int hashCode3 = (hashCode2 + (status2 == null ? 0 : status2.hashCode())) * 31;
        Object obj = this.error;
        if (obj != null) {
            i11 = obj.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.clientId;
        Integer num = this.userId;
        Status status2 = this.status;
        Object obj = this.error;
        return "UserStatusResult(clientId=" + str + ", userId=" + num + ", status=" + status2 + ", error=" + obj + ")";
    }
}
