package com.deliveryhero.contract.configuration;

import com.deliveryhero.contract.model.UserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/contract/configuration/UserRegistrationData;", "", "userInfo", "Lcom/deliveryhero/contract/model/UserInfo;", "onSuccess", "Lkotlin/Function0;", "", "onError", "Lkotlin/Function1;", "", "(Lcom/deliveryhero/contract/model/UserInfo;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnSuccess", "()Lkotlin/jvm/functions/Function0;", "getUserInfo", "()Lcom/deliveryhero/contract/model/UserInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserRegistrationData {
    @NotNull
    private final Function1<Throwable, Unit> onError;
    @NotNull
    private final Function0<Unit> onSuccess;
    @NotNull
    private final UserInfo userInfo;

    public UserRegistrationData(@NotNull UserInfo userInfo2, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(userInfo2, "userInfo");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        this.userInfo = userInfo2;
        this.onSuccess = function0;
        this.onError = function1;
    }

    public static /* synthetic */ UserRegistrationData copy$default(UserRegistrationData userRegistrationData, UserInfo userInfo2, Function0<Unit> function0, Function1<Throwable, Unit> function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            userInfo2 = userRegistrationData.userInfo;
        }
        if ((i11 & 2) != 0) {
            function0 = userRegistrationData.onSuccess;
        }
        if ((i11 & 4) != 0) {
            function1 = userRegistrationData.onError;
        }
        return userRegistrationData.copy(userInfo2, function0, function1);
    }

    @NotNull
    public final UserInfo component1() {
        return this.userInfo;
    }

    @NotNull
    public final Function0<Unit> component2() {
        return this.onSuccess;
    }

    @NotNull
    public final Function1<Throwable, Unit> component3() {
        return this.onError;
    }

    @NotNull
    public final UserRegistrationData copy(@NotNull UserInfo userInfo2, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(userInfo2, "userInfo");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        return new UserRegistrationData(userInfo2, function0, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserRegistrationData)) {
            return false;
        }
        UserRegistrationData userRegistrationData = (UserRegistrationData) obj;
        return Intrinsics.areEqual((Object) this.userInfo, (Object) userRegistrationData.userInfo) && Intrinsics.areEqual((Object) this.onSuccess, (Object) userRegistrationData.onSuccess) && Intrinsics.areEqual((Object) this.onError, (Object) userRegistrationData.onError);
    }

    @NotNull
    public final Function1<Throwable, Unit> getOnError() {
        return this.onError;
    }

    @NotNull
    public final Function0<Unit> getOnSuccess() {
        return this.onSuccess;
    }

    @NotNull
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        return (((this.userInfo.hashCode() * 31) + this.onSuccess.hashCode()) * 31) + this.onError.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserRegistrationData(userInfo=" + this.userInfo + ", onSuccess=" + this.onSuccess + ", onError=" + this.onError + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserRegistrationData(UserInfo userInfo2, Function0 function0, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(userInfo2, function0, (i11 & 4) != 0 ? AnonymousClass1.INSTANCE : function1);
    }
}
