package com.talabat.authentication.authenticate.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication;", "", "()V", "Error", "Success", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Success;", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Error;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PasswordAuthentication {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Error;", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication;", "message", "", "type", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Error$Type;", "(Ljava/lang/String;Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Error$Type;)V", "getMessage", "()Ljava/lang/String;", "getType", "()Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Error$Type;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Type", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends PasswordAuthentication {
        @NotNull
        private final String message;
        @Nullable
        private final Type type;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Error$Type;", "", "(Ljava/lang/String;I)V", "INVALID_CREDENTIALS", "SOCIAL_LOGIN_USER_NOT_FOUND", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public enum Type {
            INVALID_CREDENTIALS,
            SOCIAL_LOGIN_USER_NOT_FOUND
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str, @Nullable Type type2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
            this.type = type2;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, Type type2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.message;
            }
            if ((i11 & 2) != 0) {
                type2 = error.type;
            }
            return error.copy(str, type2);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @Nullable
        public final Type component2() {
            return this.type;
        }

        @NotNull
        public final Error copy(@NotNull String str, @Nullable Type type2) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Error(str, type2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) error.message) && this.type == error.type;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            int hashCode = this.message.hashCode() * 31;
            Type type2 = this.type;
            return hashCode + (type2 == null ? 0 : type2.hashCode());
        }

        @NotNull
        public String toString() {
            String str = this.message;
            Type type2 = this.type;
            return "Error(message=" + str + ", type=" + type2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Success;", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication;", "()V", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success extends PasswordAuthentication {
        @NotNull
        public static final Success INSTANCE = new Success();

        private Success() {
            super((DefaultConstructorMarker) null);
        }
    }

    private PasswordAuthentication() {
    }

    public /* synthetic */ PasswordAuthentication(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
