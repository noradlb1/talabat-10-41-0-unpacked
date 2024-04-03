package com.talabat.authentication.aaa;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/authentication/aaa/MigrationExchangeTokenErrorBody;", "", "errors", "", "Lcom/talabat/authentication/aaa/MigrationExchangeTokenErrorBody$Error;", "(Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Error", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MigrationExchangeTokenErrorBody {
    @SerializedName("errors")
    @Nullable
    private final List<Error> errors;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/authentication/aaa/MigrationExchangeTokenErrorBody$Error;", "", "status", "", "code", "title", "details", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getDetails", "getStatus", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error {
        @SerializedName("code")
        @Nullable
        private final String code;
        @SerializedName("detail")
        @Nullable
        private final String details;
        @SerializedName("status")
        @Nullable
        private final String status;
        @SerializedName("title")
        @Nullable
        private final String title;

        public Error(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.status = str;
            this.code = str2;
            this.title = str3;
            this.details = str4;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.status;
            }
            if ((i11 & 2) != 0) {
                str2 = error.code;
            }
            if ((i11 & 4) != 0) {
                str3 = error.title;
            }
            if ((i11 & 8) != 0) {
                str4 = error.details;
            }
            return error.copy(str, str2, str3, str4);
        }

        @Nullable
        public final String component1() {
            return this.status;
        }

        @Nullable
        public final String component2() {
            return this.code;
        }

        @Nullable
        public final String component3() {
            return this.title;
        }

        @Nullable
        public final String component4() {
            return this.details;
        }

        @NotNull
        public final Error copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            return new Error(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.status, (Object) error.status) && Intrinsics.areEqual((Object) this.code, (Object) error.code) && Intrinsics.areEqual((Object) this.title, (Object) error.title) && Intrinsics.areEqual((Object) this.details, (Object) error.details);
        }

        @Nullable
        public final String getCode() {
            return this.code;
        }

        @Nullable
        public final String getDetails() {
            return this.details;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.status;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.code;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.title;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.details;
            if (str4 != null) {
                i11 = str4.hashCode();
            }
            return hashCode3 + i11;
        }

        @NotNull
        public String toString() {
            String str = this.status;
            String str2 = this.code;
            String str3 = this.title;
            String str4 = this.details;
            return "Error(status=" + str + ", code=" + str2 + ", title=" + str3 + ", details=" + str4 + ")";
        }
    }

    public MigrationExchangeTokenErrorBody(@Nullable List<Error> list) {
        this.errors = list;
    }

    public static /* synthetic */ MigrationExchangeTokenErrorBody copy$default(MigrationExchangeTokenErrorBody migrationExchangeTokenErrorBody, List<Error> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = migrationExchangeTokenErrorBody.errors;
        }
        return migrationExchangeTokenErrorBody.copy(list);
    }

    @Nullable
    public final List<Error> component1() {
        return this.errors;
    }

    @NotNull
    public final MigrationExchangeTokenErrorBody copy(@Nullable List<Error> list) {
        return new MigrationExchangeTokenErrorBody(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MigrationExchangeTokenErrorBody) && Intrinsics.areEqual((Object) this.errors, (Object) ((MigrationExchangeTokenErrorBody) obj).errors);
    }

    @Nullable
    public final List<Error> getErrors() {
        return this.errors;
    }

    public int hashCode() {
        List<Error> list = this.errors;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<Error> list = this.errors;
        return "MigrationExchangeTokenErrorBody(errors=" + list + ")";
    }
}
