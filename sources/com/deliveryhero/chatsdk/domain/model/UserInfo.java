package com.deliveryhero.chatsdk.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/UserInfo;", "", "userId", "", "userAuthToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserAuthToken", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserInfo {
    @NotNull
    private final String userAuthToken;
    @NotNull
    private final String userId;

    public UserInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "userAuthToken");
        this.userId = str;
        this.userAuthToken = str2;
    }

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = userInfo.userId;
        }
        if ((i11 & 2) != 0) {
            str2 = userInfo.userAuthToken;
        }
        return userInfo.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @NotNull
    public final String component2() {
        return this.userAuthToken;
    }

    @NotNull
    public final UserInfo copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "userAuthToken");
        return new UserInfo(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) userInfo.userId) && Intrinsics.areEqual((Object) this.userAuthToken, (Object) userInfo.userAuthToken);
    }

    @NotNull
    public final String getUserAuthToken() {
        return this.userAuthToken;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.userAuthToken.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserInfo(userId=" + this.userId + ", userAuthToken=" + this.userAuthToken + ')';
    }
}
