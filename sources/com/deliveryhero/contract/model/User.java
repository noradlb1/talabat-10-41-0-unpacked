package com.deliveryhero.contract.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/contract/model/User;", "", "id", "", "name", "senderType", "Lcom/deliveryhero/contract/model/SenderType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/contract/model/SenderType;)V", "getId", "()Ljava/lang/String;", "getName", "getSenderType", "()Lcom/deliveryhero/contract/model/SenderType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class User {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29721id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f29722name;
    @NotNull
    private final SenderType senderType;

    public User(@NotNull String str, @NotNull String str2, @NotNull SenderType senderType2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(senderType2, "senderType");
        this.f29721id = str;
        this.f29722name = str2;
        this.senderType = senderType2;
    }

    public static /* synthetic */ User copy$default(User user, String str, String str2, SenderType senderType2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = user.f29721id;
        }
        if ((i11 & 2) != 0) {
            str2 = user.f29722name;
        }
        if ((i11 & 4) != 0) {
            senderType2 = user.senderType;
        }
        return user.copy(str, str2, senderType2);
    }

    @NotNull
    public final String component1() {
        return this.f29721id;
    }

    @NotNull
    public final String component2() {
        return this.f29722name;
    }

    @NotNull
    public final SenderType component3() {
        return this.senderType;
    }

    @NotNull
    public final User copy(@NotNull String str, @NotNull String str2, @NotNull SenderType senderType2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(senderType2, "senderType");
        return new User(str, str2, senderType2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return Intrinsics.areEqual((Object) this.f29721id, (Object) user.f29721id) && Intrinsics.areEqual((Object) this.f29722name, (Object) user.f29722name) && this.senderType == user.senderType;
    }

    @NotNull
    public final String getId() {
        return this.f29721id;
    }

    @NotNull
    public final String getName() {
        return this.f29722name;
    }

    @NotNull
    public final SenderType getSenderType() {
        return this.senderType;
    }

    public int hashCode() {
        return (((this.f29721id.hashCode() * 31) + this.f29722name.hashCode()) * 31) + this.senderType.hashCode();
    }

    @NotNull
    public String toString() {
        return "User(id=" + this.f29721id + ", name=" + this.f29722name + ", senderType=" + this.senderType + ')';
    }
}
