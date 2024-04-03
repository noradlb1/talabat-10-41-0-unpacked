package com.talabat.authentication.token.data.model;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.authentication.token.domain.model.Token;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/authentication/token/data/model/TokenData;", "", "()V", "Error", "Valid", "Lcom/talabat/authentication/token/data/model/TokenData$Valid;", "Lcom/talabat/authentication/token/data/model/TokenData$Error;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TokenData {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/authentication/token/data/model/TokenData$Error;", "Lcom/talabat/authentication/token/data/model/TokenData;", "statusCode", "", "exceptionType", "", "exceptionMessage", "(ILjava/lang/String;Ljava/lang/String;)V", "getExceptionMessage", "()Ljava/lang/String;", "getExceptionType", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ExceptionType", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends TokenData {
        @NotNull
        private final String exceptionMessage;
        @Nullable
        private final String exceptionType;
        private final int statusCode;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/authentication/token/data/model/TokenData$Error$ExceptionType;", "", "(Ljava/lang/String;I)V", "OAUTH_FAILED_EXCEPTION", "INVALID_EMAIL", "SOCIAL_LOGIN_USER_NOT_FOUND", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public enum ExceptionType {
            OAUTH_FAILED_EXCEPTION,
            INVALID_EMAIL,
            SOCIAL_LOGIN_USER_NOT_FOUND
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(int i11, @Nullable String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str2, "exceptionMessage");
            this.statusCode = i11;
            this.exceptionType = str;
            this.exceptionMessage = str2;
        }

        public static /* synthetic */ Error copy$default(Error error, int i11, String str, String str2, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = error.statusCode;
            }
            if ((i12 & 2) != 0) {
                str = error.exceptionType;
            }
            if ((i12 & 4) != 0) {
                str2 = error.exceptionMessage;
            }
            return error.copy(i11, str, str2);
        }

        public final int component1() {
            return this.statusCode;
        }

        @Nullable
        public final String component2() {
            return this.exceptionType;
        }

        @NotNull
        public final String component3() {
            return this.exceptionMessage;
        }

        @NotNull
        public final Error copy(int i11, @Nullable String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str2, "exceptionMessage");
            return new Error(i11, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return this.statusCode == error.statusCode && Intrinsics.areEqual((Object) this.exceptionType, (Object) error.exceptionType) && Intrinsics.areEqual((Object) this.exceptionMessage, (Object) error.exceptionMessage);
        }

        @NotNull
        public final String getExceptionMessage() {
            return this.exceptionMessage;
        }

        @Nullable
        public final String getExceptionType() {
            return this.exceptionType;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public int hashCode() {
            int i11 = this.statusCode * 31;
            String str = this.exceptionType;
            return ((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.exceptionMessage.hashCode();
        }

        @NotNull
        public String toString() {
            int i11 = this.statusCode;
            String str = this.exceptionType;
            String str2 = this.exceptionMessage;
            return "Error(statusCode=" + i11 + ", exceptionType=" + str + ", exceptionMessage=" + str2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/authentication/token/data/model/TokenData$Valid;", "Lcom/talabat/authentication/token/data/model/TokenData;", "token", "Lcom/talabat/authentication/token/domain/model/Token;", "deviceToken", "", "(Lcom/talabat/authentication/token/domain/model/Token;Ljava/lang/String;)V", "getDeviceToken", "()Ljava/lang/String;", "getToken", "()Lcom/talabat/authentication/token/domain/model/Token;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Valid extends TokenData {
        @NotNull
        private final String deviceToken;
        @NotNull
        private final Token token;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Valid(@NotNull Token token2, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(token2, LegacyTokenLocalDataSourceImpl.KEY);
            Intrinsics.checkNotNullParameter(str, "deviceToken");
            this.token = token2;
            this.deviceToken = str;
        }

        public static /* synthetic */ Valid copy$default(Valid valid, Token token2, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                token2 = valid.token;
            }
            if ((i11 & 2) != 0) {
                str = valid.deviceToken;
            }
            return valid.copy(token2, str);
        }

        @NotNull
        public final Token component1() {
            return this.token;
        }

        @NotNull
        public final String component2() {
            return this.deviceToken;
        }

        @NotNull
        public final Valid copy(@NotNull Token token2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(token2, LegacyTokenLocalDataSourceImpl.KEY);
            Intrinsics.checkNotNullParameter(str, "deviceToken");
            return new Valid(token2, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Valid)) {
                return false;
            }
            Valid valid = (Valid) obj;
            return Intrinsics.areEqual((Object) this.token, (Object) valid.token) && Intrinsics.areEqual((Object) this.deviceToken, (Object) valid.deviceToken);
        }

        @NotNull
        public final String getDeviceToken() {
            return this.deviceToken;
        }

        @NotNull
        public final Token getToken() {
            return this.token;
        }

        public int hashCode() {
            return (this.token.hashCode() * 31) + this.deviceToken.hashCode();
        }

        @NotNull
        public String toString() {
            Token token2 = this.token;
            String str = this.deviceToken;
            return "Valid(token=" + token2 + ", deviceToken=" + str + ")";
        }
    }

    private TokenData() {
    }

    public /* synthetic */ TokenData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
