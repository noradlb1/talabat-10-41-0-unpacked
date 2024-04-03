package com.talabat.userandlocation.compliance.status.data.remote.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResponse;", "", "timeStamp", "", "result", "Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult;", "(Ljava/lang/String;Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult;)V", "getResult", "()Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult;", "getTimeStamp", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserStatusResponse {
    @Nullable
    private final UserStatusResult result;
    @NotNull
    private final String timeStamp;

    public UserStatusResponse(@NotNull String str, @Nullable UserStatusResult userStatusResult) {
        Intrinsics.checkNotNullParameter(str, "timeStamp");
        this.timeStamp = str;
        this.result = userStatusResult;
    }

    public static /* synthetic */ UserStatusResponse copy$default(UserStatusResponse userStatusResponse, String str, UserStatusResult userStatusResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = userStatusResponse.timeStamp;
        }
        if ((i11 & 2) != 0) {
            userStatusResult = userStatusResponse.result;
        }
        return userStatusResponse.copy(str, userStatusResult);
    }

    @NotNull
    public final String component1() {
        return this.timeStamp;
    }

    @Nullable
    public final UserStatusResult component2() {
        return this.result;
    }

    @NotNull
    public final UserStatusResponse copy(@NotNull String str, @Nullable UserStatusResult userStatusResult) {
        Intrinsics.checkNotNullParameter(str, "timeStamp");
        return new UserStatusResponse(str, userStatusResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserStatusResponse)) {
            return false;
        }
        UserStatusResponse userStatusResponse = (UserStatusResponse) obj;
        return Intrinsics.areEqual((Object) this.timeStamp, (Object) userStatusResponse.timeStamp) && Intrinsics.areEqual((Object) this.result, (Object) userStatusResponse.result);
    }

    @Nullable
    public final UserStatusResult getResult() {
        return this.result;
    }

    @NotNull
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        int hashCode = this.timeStamp.hashCode() * 31;
        UserStatusResult userStatusResult = this.result;
        return hashCode + (userStatusResult == null ? 0 : userStatusResult.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.timeStamp;
        UserStatusResult userStatusResult = this.result;
        return "UserStatusResponse(timeStamp=" + str + ", result=" + userStatusResult + ")";
    }
}
