package com.talabat.core.social.login.domain;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/talabat/core/social/login/domain/FacebookUserData;", "", "email", "", "token", "firstName", "lastName", "providerId", "providerKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getFirstName", "getLastName", "getProviderId", "getProviderKey", "getToken", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FacebookUserData {
    @NotNull
    private final String email;
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    private final String providerId;
    @NotNull
    private final String providerKey;
    @NotNull
    private final String token;

    public FacebookUserData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str3, "firstName");
        Intrinsics.checkNotNullParameter(str4, "lastName");
        Intrinsics.checkNotNullParameter(str5, "providerId");
        Intrinsics.checkNotNullParameter(str6, "providerKey");
        this.email = str;
        this.token = str2;
        this.firstName = str3;
        this.lastName = str4;
        this.providerId = str5;
        this.providerKey = str6;
    }

    public static /* synthetic */ FacebookUserData copy$default(FacebookUserData facebookUserData, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = facebookUserData.email;
        }
        if ((i11 & 2) != 0) {
            str2 = facebookUserData.token;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = facebookUserData.firstName;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = facebookUserData.lastName;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = facebookUserData.providerId;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = facebookUserData.providerKey;
        }
        return facebookUserData.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.email;
    }

    @NotNull
    public final String component2() {
        return this.token;
    }

    @NotNull
    public final String component3() {
        return this.firstName;
    }

    @NotNull
    public final String component4() {
        return this.lastName;
    }

    @NotNull
    public final String component5() {
        return this.providerId;
    }

    @NotNull
    public final String component6() {
        return this.providerKey;
    }

    @NotNull
    public final FacebookUserData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str3, "firstName");
        Intrinsics.checkNotNullParameter(str4, "lastName");
        Intrinsics.checkNotNullParameter(str5, "providerId");
        Intrinsics.checkNotNullParameter(str6, "providerKey");
        return new FacebookUserData(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FacebookUserData)) {
            return false;
        }
        FacebookUserData facebookUserData = (FacebookUserData) obj;
        return Intrinsics.areEqual((Object) this.email, (Object) facebookUserData.email) && Intrinsics.areEqual((Object) this.token, (Object) facebookUserData.token) && Intrinsics.areEqual((Object) this.firstName, (Object) facebookUserData.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) facebookUserData.lastName) && Intrinsics.areEqual((Object) this.providerId, (Object) facebookUserData.providerId) && Intrinsics.areEqual((Object) this.providerKey, (Object) facebookUserData.providerKey);
    }

    @NotNull
    public final String getEmail() {
        return this.email;
    }

    @NotNull
    public final String getFirstName() {
        return this.firstName;
    }

    @NotNull
    public final String getLastName() {
        return this.lastName;
    }

    @NotNull
    public final String getProviderId() {
        return this.providerId;
    }

    @NotNull
    public final String getProviderKey() {
        return this.providerKey;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((((((((this.email.hashCode() * 31) + this.token.hashCode()) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.providerId.hashCode()) * 31) + this.providerKey.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.email;
        String str2 = this.token;
        String str3 = this.firstName;
        String str4 = this.lastName;
        String str5 = this.providerId;
        String str6 = this.providerKey;
        return "FacebookUserData(email=" + str + ", token=" + str2 + ", firstName=" + str3 + ", lastName=" + str4 + ", providerId=" + str5 + ", providerKey=" + str6 + ")";
    }
}
