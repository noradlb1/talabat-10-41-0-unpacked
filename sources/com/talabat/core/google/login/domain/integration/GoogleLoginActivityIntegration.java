package com.talabat.core.google.login.domain.integration;

import android.app.Activity;
import android.content.Intent;
import com.newrelic.agent.android.agentdata.HexAttribute;
import io.reactivex.processors.PublishProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration;", "", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "googleSignInAccountProcessor", "Lio/reactivex/processors/PublishProcessor;", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult;", "getGoogleSignInAccountProcessor", "()Lio/reactivex/processors/PublishProcessor;", "onActivityResult", "", "data", "Landroid/content/Intent;", "GoogleLoginActivityResult", "com_talabat_core_social-login_google_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GoogleLoginActivityIntegration {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult;", "", "()V", "Error", "Success", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult$Success;", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult$Error;", "com_talabat_core_social-login_google_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class GoogleLoginActivityResult {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult$Error;", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult;", "cause", "", "(Ljava/lang/String;)V", "getCause", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_core_social-login_google_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Error extends GoogleLoginActivityResult {
            @NotNull
            private final String cause;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CAUSE);
                this.cause = str;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = error.cause;
                }
                return error.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.cause;
            }

            @NotNull
            public final Error copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CAUSE);
                return new Error(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && Intrinsics.areEqual((Object) this.cause, (Object) ((Error) obj).cause);
            }

            @NotNull
            public final String getCause() {
                return this.cause;
            }

            public int hashCode() {
                return this.cause.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.cause;
                return "Error(cause=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult$Success;", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration$GoogleLoginActivityResult;", "id", "", "idToken", "email", "givenName", "familyName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getFamilyName", "getGivenName", "getId", "getIdToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_core_social-login_google_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Success extends GoogleLoginActivityResult {
            @NotNull
            private final String email;
            @NotNull
            private final String familyName;
            @NotNull
            private final String givenName;
            @NotNull

            /* renamed from: id  reason: collision with root package name */
            private final String f55944id;
            @NotNull
            private final String idToken;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "idToken");
                Intrinsics.checkNotNullParameter(str3, "email");
                Intrinsics.checkNotNullParameter(str4, "givenName");
                Intrinsics.checkNotNullParameter(str5, "familyName");
                this.f55944id = str;
                this.idToken = str2;
                this.email = str3;
                this.givenName = str4;
                this.familyName = str5;
            }

            public static /* synthetic */ Success copy$default(Success success, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = success.f55944id;
                }
                if ((i11 & 2) != 0) {
                    str2 = success.idToken;
                }
                String str6 = str2;
                if ((i11 & 4) != 0) {
                    str3 = success.email;
                }
                String str7 = str3;
                if ((i11 & 8) != 0) {
                    str4 = success.givenName;
                }
                String str8 = str4;
                if ((i11 & 16) != 0) {
                    str5 = success.familyName;
                }
                return success.copy(str, str6, str7, str8, str5);
            }

            @NotNull
            public final String component1() {
                return this.f55944id;
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
            public final Success copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "idToken");
                Intrinsics.checkNotNullParameter(str3, "email");
                Intrinsics.checkNotNullParameter(str4, "givenName");
                Intrinsics.checkNotNullParameter(str5, "familyName");
                return new Success(str, str2, str3, str4, str5);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual((Object) this.f55944id, (Object) success.f55944id) && Intrinsics.areEqual((Object) this.idToken, (Object) success.idToken) && Intrinsics.areEqual((Object) this.email, (Object) success.email) && Intrinsics.areEqual((Object) this.givenName, (Object) success.givenName) && Intrinsics.areEqual((Object) this.familyName, (Object) success.familyName);
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
                return this.f55944id;
            }

            @NotNull
            public final String getIdToken() {
                return this.idToken;
            }

            public int hashCode() {
                return (((((((this.f55944id.hashCode() * 31) + this.idToken.hashCode()) * 31) + this.email.hashCode()) * 31) + this.givenName.hashCode()) * 31) + this.familyName.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.f55944id;
                String str2 = this.idToken;
                String str3 = this.email;
                String str4 = this.givenName;
                String str5 = this.familyName;
                return "Success(id=" + str + ", idToken=" + str2 + ", email=" + str3 + ", givenName=" + str4 + ", familyName=" + str5 + ")";
            }
        }

        private GoogleLoginActivityResult() {
        }

        public /* synthetic */ GoogleLoginActivityResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    Activity getActivity();

    @NotNull
    PublishProcessor<GoogleLoginActivityResult> getGoogleSignInAccountProcessor();

    void onActivityResult(@NotNull Intent intent);

    void setActivity(@Nullable Activity activity);
}
