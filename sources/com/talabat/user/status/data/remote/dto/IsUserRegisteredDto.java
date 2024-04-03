package com.talabat.user.status.data.remote.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/user/status/data/remote/dto/IsUserRegisteredDto;", "", "status", "Lcom/talabat/user/status/data/remote/dto/IsUserRegisteredDto$Status;", "(Lcom/talabat/user/status/data/remote/dto/IsUserRegisteredDto$Status;)V", "getStatus", "()Lcom/talabat/user/status/data/remote/dto/IsUserRegisteredDto$Status;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Status", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsUserRegisteredDto {
    @NotNull
    private final Status status;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/user/status/data/remote/dto/IsUserRegisteredDto$Status;", "", "(Ljava/lang/String;I)V", "REGISTERED", "NOT_FOUND", "INVALID_KEY", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Status {
        REGISTERED,
        NOT_FOUND,
        INVALID_KEY
    }

    public IsUserRegisteredDto(@NotNull Status status2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        this.status = status2;
    }

    public static /* synthetic */ IsUserRegisteredDto copy$default(IsUserRegisteredDto isUserRegisteredDto, Status status2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            status2 = isUserRegisteredDto.status;
        }
        return isUserRegisteredDto.copy(status2);
    }

    @NotNull
    public final Status component1() {
        return this.status;
    }

    @NotNull
    public final IsUserRegisteredDto copy(@NotNull Status status2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        return new IsUserRegisteredDto(status2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IsUserRegisteredDto) && this.status == ((IsUserRegisteredDto) obj).status;
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    @NotNull
    public String toString() {
        Status status2 = this.status;
        return "IsUserRegisteredDto(status=" + status2 + ")";
    }
}
