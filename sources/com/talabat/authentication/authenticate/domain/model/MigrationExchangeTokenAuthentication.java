package com.talabat.authentication.authenticate.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication;", "", "()V", "Error", "Error404", "Success", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication$Success;", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication$Error404;", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication$Error;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MigrationExchangeTokenAuthentication {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication$Error;", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends MigrationExchangeTokenAuthentication {
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @NotNull
        public final Error copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Error(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.message, (Object) ((Error) obj).message);
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.message;
            return "Error(message=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication$Error404;", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication;", "()V", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error404 extends MigrationExchangeTokenAuthentication {
        @NotNull
        public static final Error404 INSTANCE = new Error404();

        private Error404() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication$Success;", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication;", "()V", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success extends MigrationExchangeTokenAuthentication {
        @NotNull
        public static final Success INSTANCE = new Success();

        private Success() {
            super((DefaultConstructorMarker) null);
        }
    }

    private MigrationExchangeTokenAuthentication() {
    }

    public /* synthetic */ MigrationExchangeTokenAuthentication(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
