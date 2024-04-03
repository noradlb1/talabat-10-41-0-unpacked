package com.talabat.core.facebook.login.domain.repository;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.core.facebook.login.domain.FacebookPermission;
import com.talabat.core.facebook.login.domain.FacebookProfileData;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0010J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\b\u0010\n\u001a\u00020\u0003H&J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH&¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository;", "", "initialize", "", "login", "Lio/reactivex/Single;", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository$LoginResult;", "facebookPermissions", "", "Lcom/talabat/core/facebook/login/domain/FacebookPermission;", "logout", "requestData", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository$DataResult;", "data", "Lcom/talabat/core/facebook/login/domain/FacebookProfileData;", "DataResult", "LoginResult", "com_talabat_core_social-login_facebook_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FacebookLoginRepository {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository$DataResult;", "", "data", "", "Lcom/talabat/core/facebook/login/domain/FacebookProfileData;", "", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_social-login_facebook_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DataResult {
        @NotNull
        private final Map<FacebookProfileData, String> data;

        public DataResult(@NotNull Map<FacebookProfileData, String> map) {
            Intrinsics.checkNotNullParameter(map, "data");
            this.data = map;
        }

        public static /* synthetic */ DataResult copy$default(DataResult dataResult, Map<FacebookProfileData, String> map, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                map = dataResult.data;
            }
            return dataResult.copy(map);
        }

        @NotNull
        public final Map<FacebookProfileData, String> component1() {
            return this.data;
        }

        @NotNull
        public final DataResult copy(@NotNull Map<FacebookProfileData, String> map) {
            Intrinsics.checkNotNullParameter(map, "data");
            return new DataResult(map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DataResult) && Intrinsics.areEqual((Object) this.data, (Object) ((DataResult) obj).data);
        }

        @NotNull
        public final Map<FacebookProfileData, String> getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            Map<FacebookProfileData, String> map = this.data;
            return "DataResult(data=" + map + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository$LoginResult;", "", "userId", "", "token", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_social-login_facebook_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LoginResult {
        @NotNull
        private final String token;
        @NotNull
        private final String userId;

        public LoginResult(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "userId");
            Intrinsics.checkNotNullParameter(str2, LegacyTokenLocalDataSourceImpl.KEY);
            this.userId = str;
            this.token = str2;
        }

        public static /* synthetic */ LoginResult copy$default(LoginResult loginResult, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = loginResult.userId;
            }
            if ((i11 & 2) != 0) {
                str2 = loginResult.token;
            }
            return loginResult.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.userId;
        }

        @NotNull
        public final String component2() {
            return this.token;
        }

        @NotNull
        public final LoginResult copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "userId");
            Intrinsics.checkNotNullParameter(str2, LegacyTokenLocalDataSourceImpl.KEY);
            return new LoginResult(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoginResult)) {
                return false;
            }
            LoginResult loginResult = (LoginResult) obj;
            return Intrinsics.areEqual((Object) this.userId, (Object) loginResult.userId) && Intrinsics.areEqual((Object) this.token, (Object) loginResult.token);
        }

        @NotNull
        public final String getToken() {
            return this.token;
        }

        @NotNull
        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.token.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.userId;
            String str2 = this.token;
            return "LoginResult(userId=" + str + ", token=" + str2 + ")";
        }
    }

    void initialize();

    @NotNull
    Single<LoginResult> login(@NotNull List<? extends FacebookPermission> list);

    void logout();

    @NotNull
    Single<DataResult> requestData(@NotNull List<? extends FacebookProfileData> list);
}
