package com.talabat.core.google.login.domain.repository;

import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository;", "", "initialize", "", "requestIdToken", "", "login", "Lio/reactivex/Single;", "Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository$GoogleLoginResult;", "requestCode", "", "logout", "Lio/reactivex/Completable;", "GoogleLoginResult", "com_talabat_core_social-login_google_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GoogleLoginRepository {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository$GoogleLoginResult;", "", "id", "", "idToken", "email", "givenName", "familyName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getFamilyName", "getGivenName", "getId", "getIdToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_social-login_google_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GoogleLoginResult {
        @NotNull
        private final String email;
        @NotNull
        private final String familyName;
        @NotNull
        private final String givenName;
        @NotNull

        /* renamed from: id  reason: collision with root package name */
        private final String f55945id;
        @NotNull
        private final String idToken;

        public GoogleLoginResult(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "idToken");
            Intrinsics.checkNotNullParameter(str3, "email");
            Intrinsics.checkNotNullParameter(str4, "givenName");
            Intrinsics.checkNotNullParameter(str5, "familyName");
            this.f55945id = str;
            this.idToken = str2;
            this.email = str3;
            this.givenName = str4;
            this.familyName = str5;
        }

        public static /* synthetic */ GoogleLoginResult copy$default(GoogleLoginResult googleLoginResult, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = googleLoginResult.f55945id;
            }
            if ((i11 & 2) != 0) {
                str2 = googleLoginResult.idToken;
            }
            String str6 = str2;
            if ((i11 & 4) != 0) {
                str3 = googleLoginResult.email;
            }
            String str7 = str3;
            if ((i11 & 8) != 0) {
                str4 = googleLoginResult.givenName;
            }
            String str8 = str4;
            if ((i11 & 16) != 0) {
                str5 = googleLoginResult.familyName;
            }
            return googleLoginResult.copy(str, str6, str7, str8, str5);
        }

        @NotNull
        public final String component1() {
            return this.f55945id;
        }

        @NotNull
        public final String component2() {
            return this.idToken;
        }

        @NotNull
        public final String component3() {
            return this.email;
        }

        @NotNull
        public final String component4() {
            return this.givenName;
        }

        @NotNull
        public final String component5() {
            return this.familyName;
        }

        @NotNull
        public final GoogleLoginResult copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "idToken");
            Intrinsics.checkNotNullParameter(str3, "email");
            Intrinsics.checkNotNullParameter(str4, "givenName");
            Intrinsics.checkNotNullParameter(str5, "familyName");
            return new GoogleLoginResult(str, str2, str3, str4, str5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GoogleLoginResult)) {
                return false;
            }
            GoogleLoginResult googleLoginResult = (GoogleLoginResult) obj;
            return Intrinsics.areEqual((Object) this.f55945id, (Object) googleLoginResult.f55945id) && Intrinsics.areEqual((Object) this.idToken, (Object) googleLoginResult.idToken) && Intrinsics.areEqual((Object) this.email, (Object) googleLoginResult.email) && Intrinsics.areEqual((Object) this.givenName, (Object) googleLoginResult.givenName) && Intrinsics.areEqual((Object) this.familyName, (Object) googleLoginResult.familyName);
        }

        @NotNull
        public final String getEmail() {
            return this.email;
        }

        @NotNull
        public final String getFamilyName() {
            return this.familyName;
        }

        @NotNull
        public final String getGivenName() {
            return this.givenName;
        }

        @NotNull
        public final String getId() {
            return this.f55945id;
        }

        @NotNull
        public final String getIdToken() {
            return this.idToken;
        }

        public int hashCode() {
            return (((((((this.f55945id.hashCode() * 31) + this.idToken.hashCode()) * 31) + this.email.hashCode()) * 31) + this.givenName.hashCode()) * 31) + this.familyName.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.f55945id;
            String str2 = this.idToken;
            String str3 = this.email;
            String str4 = this.givenName;
            String str5 = this.familyName;
            return "GoogleLoginResult(id=" + str + ", idToken=" + str2 + ", email=" + str3 + ", givenName=" + str4 + ", familyName=" + str5 + ")";
        }
    }

    void initialize(@NotNull String str);

    @NotNull
    Single<GoogleLoginResult> login(int i11);

    @NotNull
    Completable logout();
}
