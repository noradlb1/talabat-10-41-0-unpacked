package com.deliveryhero.chatsdk.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/model/User;", "", "userId", "", "nickname", "(Ljava/lang/String;Ljava/lang/String;)V", "getNickname", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class User {
    @NotNull
    private final String nickname;
    @NotNull
    private final String userId;

    public User(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "nickname");
        this.userId = str;
        this.nickname = str2;
    }

    public static /* synthetic */ User copy$default(User user, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = user.userId;
        }
        if ((i11 & 2) != 0) {
            str2 = user.nickname;
        }
        return user.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @NotNull
    public final String component2() {
        return this.nickname;
    }

    @NotNull
    public final User copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "nickname");
        return new User(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) user.userId) && Intrinsics.areEqual((Object) this.nickname, (Object) user.nickname);
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.nickname.hashCode();
    }

    @NotNull
    public String toString() {
        return "User(userId=" + this.userId + ", nickname=" + this.nickname + ')';
    }
}
