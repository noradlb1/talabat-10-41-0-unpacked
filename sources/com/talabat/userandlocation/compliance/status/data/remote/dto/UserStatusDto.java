package com.talabat.userandlocation.compliance.status.data.remote.dto;

import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/remote/dto/UserStatusDto;", "", "clientId", "", "userId", "", "userStatus", "Lcom/talabat/userandlocation/compliance/status/data/remote/dto/UserStatusDto$UserStatus;", "(Ljava/lang/String;ILcom/talabat/userandlocation/compliance/status/data/remote/dto/UserStatusDto$UserStatus;)V", "getClientId", "()Ljava/lang/String;", "getUserId", "()I", "getUserStatus", "()Lcom/talabat/userandlocation/compliance/status/data/remote/dto/UserStatusDto$UserStatus;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "UserStatus", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserStatusDto {
    @NotNull
    private final String clientId;
    private final int userId;
    @NotNull
    private final UserStatus userStatus;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/remote/dto/UserStatusDto$UserStatus;", "", "(Ljava/lang/String;I)V", "PASS", "PENDING", "FAIL", "ERROR", "UNINITIALIZED", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum UserStatus {
        PASS,
        PENDING,
        FAIL,
        ERROR,
        UNINITIALIZED
    }

    public UserStatusDto(@NotNull String str, int i11, @NotNull UserStatus userStatus2) {
        Intrinsics.checkNotNullParameter(str, Profile.CLIENT_ID);
        Intrinsics.checkNotNullParameter(userStatus2, "userStatus");
        this.clientId = str;
        this.userId = i11;
        this.userStatus = userStatus2;
    }

    public static /* synthetic */ UserStatusDto copy$default(UserStatusDto userStatusDto, String str, int i11, UserStatus userStatus2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = userStatusDto.clientId;
        }
        if ((i12 & 2) != 0) {
            i11 = userStatusDto.userId;
        }
        if ((i12 & 4) != 0) {
            userStatus2 = userStatusDto.userStatus;
        }
        return userStatusDto.copy(str, i11, userStatus2);
    }

    @NotNull
    public final String component1() {
        return this.clientId;
    }

    public final int component2() {
        return this.userId;
    }

    @NotNull
    public final UserStatus component3() {
        return this.userStatus;
    }

    @NotNull
    public final UserStatusDto copy(@NotNull String str, int i11, @NotNull UserStatus userStatus2) {
        Intrinsics.checkNotNullParameter(str, Profile.CLIENT_ID);
        Intrinsics.checkNotNullParameter(userStatus2, "userStatus");
        return new UserStatusDto(str, i11, userStatus2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserStatusDto)) {
            return false;
        }
        UserStatusDto userStatusDto = (UserStatusDto) obj;
        return Intrinsics.areEqual((Object) this.clientId, (Object) userStatusDto.clientId) && this.userId == userStatusDto.userId && this.userStatus == userStatusDto.userStatus;
    }

    @NotNull
    public final String getClientId() {
        return this.clientId;
    }

    public final int getUserId() {
        return this.userId;
    }

    @NotNull
    public final UserStatus getUserStatus() {
        return this.userStatus;
    }

    public int hashCode() {
        return (((this.clientId.hashCode() * 31) + this.userId) * 31) + this.userStatus.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.clientId;
        int i11 = this.userId;
        UserStatus userStatus2 = this.userStatus;
        return "UserStatusDto(clientId=" + str + ", userId=" + i11 + ", userStatus=" + userStatus2 + ")";
    }
}
