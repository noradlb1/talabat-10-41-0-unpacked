package com.talabat.user.address.data.remote.api;

import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u001f B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse;", "", "timestamp", "", "result", "Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Result;", "hasError", "", "error", "Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Error;", "(Ljava/lang/String;Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Result;Ljava/lang/Boolean;Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Error;)V", "getError", "()Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Error;", "getHasError", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResult", "()Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Result;", "getTimestamp", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Result;Ljava/lang/Boolean;Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Error;)Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse;", "equals", "other", "hashCode", "", "toString", "Error", "Result", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateAddressResponse {
    @SerializedName("error")
    @Nullable
    private final Error error;
    @SerializedName("has_error")
    @Nullable
    private final Boolean hasError;
    @SerializedName("result")
    @Nullable
    private final Result result;
    @SerializedName("timestamp")
    @Nullable
    private final String timestamp;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Error;", "", "errorCode", "", "title", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getMessage", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error {
        @SerializedName("error_code")
        @Nullable
        private final String errorCode;
        @SerializedName("message")
        @Nullable
        private final String message;
        @SerializedName("title")
        @Nullable
        private final String title;

        public Error(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.errorCode = str;
            this.title = str2;
            this.message = str3;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.errorCode;
            }
            if ((i11 & 2) != 0) {
                str2 = error.title;
            }
            if ((i11 & 4) != 0) {
                str3 = error.message;
            }
            return error.copy(str, str2, str3);
        }

        @Nullable
        public final String component1() {
            return this.errorCode;
        }

        @Nullable
        public final String component2() {
            return this.title;
        }

        @Nullable
        public final String component3() {
            return this.message;
        }

        @NotNull
        public final Error copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            return new Error(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.errorCode, (Object) error.errorCode) && Intrinsics.areEqual((Object) this.title, (Object) error.title) && Intrinsics.areEqual((Object) this.message, (Object) error.message);
        }

        @Nullable
        public final String getErrorCode() {
            return this.errorCode;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.errorCode;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.message;
            if (str3 != null) {
                i11 = str3.hashCode();
            }
            return hashCode2 + i11;
        }

        @NotNull
        public String toString() {
            String str = this.errorCode;
            String str2 = this.title;
            String str3 = this.message;
            return "Error(errorCode=" + str + ", title=" + str2 + ", message=" + str3 + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\bM\b\b\u0018\u00002\u00020\u0001B§\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0015\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010$J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010S\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010T\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010U\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0002\u0010;J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010[\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jê\u0002\u0010c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010dJ\u0013\u0010e\u001a\u00020\u00152\b\u0010f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010g\u001a\u00020\tHÖ\u0001J\t\u0010h\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b0\u0010-R\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b2\u0010-R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u001a\u0010 \u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\n\n\u0002\u00108\u001a\u0004\b \u00107R\u001a\u0010#\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\n\n\u0002\u00108\u001a\u0004\b#\u00107R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\n\n\u0002\u00108\u001a\u0004\b\u0019\u00107R\u001a\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\n\n\u0002\u00108\u001a\u0004\b\"\u00107R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\n\n\u0002\u00108\u001a\u0004\b\u0014\u00107R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\b=\u0010;R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010)R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010)R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010)R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010)R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010)R\u001a\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\bE\u0010-¨\u0006i"}, d2 = {"Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Result;", "", "profileId", "", "profileName", "areaId", "", "areaName", "cityId", "", "cityName", "customerId", "type", "block", "judda", "street", "buildingNo", "floor", "suite", "extraDirections", "isPrimary", "", "phoneNumber", "mobileNumber", "mobileCountryCode", "isOldAddress", "country", "latitude", "", "longitude", "grl", "grlId", "isAreaDisabled", "countryCode", "isPolygonSearchEnabled", "isEligibleForDelivery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAreaId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAreaName", "()Ljava/lang/String;", "getBlock", "getBuildingNo", "getCityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCityName", "getCountry", "getCountryCode", "getCustomerId", "getExtraDirections", "getFloor", "getGrl", "getGrlId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getJudda", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLongitude", "getMobileCountryCode", "getMobileNumber", "getPhoneNumber", "getProfileId", "getProfileName", "getStreet", "getSuite", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse$Result;", "equals", "other", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Result {
        @SerializedName("area_id")
        @Nullable
        private final Long areaId;
        @SerializedName("area_name")
        @Nullable
        private final String areaName;
        @SerializedName("block")
        @Nullable
        private final String block;
        @SerializedName("building_no")
        @Nullable
        private final String buildingNo;
        @SerializedName("city_id")
        @Nullable
        private final Integer cityId;
        @SerializedName("city_name")
        @Nullable
        private final String cityName;
        @SerializedName("country")
        @Nullable
        private final Integer country;
        @SerializedName("country_code")
        @Nullable
        private final String countryCode;
        @SerializedName("cust_id")
        @Nullable
        private final Integer customerId;
        @SerializedName("extra_directions")
        @Nullable
        private final String extraDirections;
        @SerializedName("floor")
        @Nullable
        private final String floor;
        @SerializedName("grl")
        @Nullable
        private final String grl;
        @SerializedName("grl_id")
        @Nullable
        private final String grlId;
        @SerializedName("is_area_disabled")
        @Nullable
        private final Boolean isAreaDisabled;
        @SerializedName("is_eligible_for_delivery")
        @Nullable
        private final Boolean isEligibleForDelivery;
        @SerializedName("is_old_addreses")
        @Nullable
        private final Boolean isOldAddress;
        @SerializedName("is_polygon_search_enabled")
        @Nullable
        private final Boolean isPolygonSearchEnabled;
        @SerializedName("is_primary")
        @Nullable
        private final Boolean isPrimary;
        @SerializedName("judda")
        @Nullable
        private final String judda;
        @SerializedName("latitude")
        @Nullable
        private final Double latitude;
        @SerializedName("longitude")
        @Nullable
        private final Double longitude;
        @SerializedName("mobile_country_code")
        @Nullable
        private final String mobileCountryCode;
        @SerializedName("mobile_number")
        @Nullable
        private final String mobileNumber;
        @SerializedName("phone_number")
        @Nullable
        private final String phoneNumber;
        @SerializedName("id")
        @Nullable
        private final String profileId;
        @SerializedName("profile_name")
        @Nullable
        private final String profileName;
        @SerializedName("street")
        @Nullable
        private final String street;
        @SerializedName("suite")
        @Nullable
        private final String suite;
        @SerializedName("type")
        @Nullable
        private final Integer type;

        public Result(@Nullable String str, @Nullable String str2, @Nullable Long l11, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable Boolean bool, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable Boolean bool2, @Nullable Integer num4, @Nullable Double d11, @Nullable Double d12, @Nullable String str15, @Nullable String str16, @Nullable Boolean bool3, @Nullable String str17, @Nullable Boolean bool4, @Nullable Boolean bool5) {
            this.profileId = str;
            this.profileName = str2;
            this.areaId = l11;
            this.areaName = str3;
            this.cityId = num;
            this.cityName = str4;
            this.customerId = num2;
            this.type = num3;
            this.block = str5;
            this.judda = str6;
            this.street = str7;
            this.buildingNo = str8;
            this.floor = str9;
            this.suite = str10;
            this.extraDirections = str11;
            this.isPrimary = bool;
            this.phoneNumber = str12;
            this.mobileNumber = str13;
            this.mobileCountryCode = str14;
            this.isOldAddress = bool2;
            this.country = num4;
            this.latitude = d11;
            this.longitude = d12;
            this.grl = str15;
            this.grlId = str16;
            this.isAreaDisabled = bool3;
            this.countryCode = str17;
            this.isPolygonSearchEnabled = bool4;
            this.isEligibleForDelivery = bool5;
        }

        public static /* synthetic */ Result copy$default(Result result, String str, String str2, Long l11, String str3, Integer num, String str4, Integer num2, Integer num3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Boolean bool, String str12, String str13, String str14, Boolean bool2, Integer num4, Double d11, Double d12, String str15, String str16, Boolean bool3, String str17, Boolean bool4, Boolean bool5, int i11, Object obj) {
            Result result2 = result;
            int i12 = i11;
            return result.copy((i12 & 1) != 0 ? result2.profileId : str, (i12 & 2) != 0 ? result2.profileName : str2, (i12 & 4) != 0 ? result2.areaId : l11, (i12 & 8) != 0 ? result2.areaName : str3, (i12 & 16) != 0 ? result2.cityId : num, (i12 & 32) != 0 ? result2.cityName : str4, (i12 & 64) != 0 ? result2.customerId : num2, (i12 & 128) != 0 ? result2.type : num3, (i12 & 256) != 0 ? result2.block : str5, (i12 & 512) != 0 ? result2.judda : str6, (i12 & 1024) != 0 ? result2.street : str7, (i12 & 2048) != 0 ? result2.buildingNo : str8, (i12 & 4096) != 0 ? result2.floor : str9, (i12 & 8192) != 0 ? result2.suite : str10, (i12 & 16384) != 0 ? result2.extraDirections : str11, (i12 & 32768) != 0 ? result2.isPrimary : bool, (i12 & 65536) != 0 ? result2.phoneNumber : str12, (i12 & 131072) != 0 ? result2.mobileNumber : str13, (i12 & 262144) != 0 ? result2.mobileCountryCode : str14, (i12 & 524288) != 0 ? result2.isOldAddress : bool2, (i12 & 1048576) != 0 ? result2.country : num4, (i12 & 2097152) != 0 ? result2.latitude : d11, (i12 & 4194304) != 0 ? result2.longitude : d12, (i12 & 8388608) != 0 ? result2.grl : str15, (i12 & 16777216) != 0 ? result2.grlId : str16, (i12 & 33554432) != 0 ? result2.isAreaDisabled : bool3, (i12 & 67108864) != 0 ? result2.countryCode : str17, (i12 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? result2.isPolygonSearchEnabled : bool4, (i12 & 268435456) != 0 ? result2.isEligibleForDelivery : bool5);
        }

        @Nullable
        public final String component1() {
            return this.profileId;
        }

        @Nullable
        public final String component10() {
            return this.judda;
        }

        @Nullable
        public final String component11() {
            return this.street;
        }

        @Nullable
        public final String component12() {
            return this.buildingNo;
        }

        @Nullable
        public final String component13() {
            return this.floor;
        }

        @Nullable
        public final String component14() {
            return this.suite;
        }

        @Nullable
        public final String component15() {
            return this.extraDirections;
        }

        @Nullable
        public final Boolean component16() {
            return this.isPrimary;
        }

        @Nullable
        public final String component17() {
            return this.phoneNumber;
        }

        @Nullable
        public final String component18() {
            return this.mobileNumber;
        }

        @Nullable
        public final String component19() {
            return this.mobileCountryCode;
        }

        @Nullable
        public final String component2() {
            return this.profileName;
        }

        @Nullable
        public final Boolean component20() {
            return this.isOldAddress;
        }

        @Nullable
        public final Integer component21() {
            return this.country;
        }

        @Nullable
        public final Double component22() {
            return this.latitude;
        }

        @Nullable
        public final Double component23() {
            return this.longitude;
        }

        @Nullable
        public final String component24() {
            return this.grl;
        }

        @Nullable
        public final String component25() {
            return this.grlId;
        }

        @Nullable
        public final Boolean component26() {
            return this.isAreaDisabled;
        }

        @Nullable
        public final String component27() {
            return this.countryCode;
        }

        @Nullable
        public final Boolean component28() {
            return this.isPolygonSearchEnabled;
        }

        @Nullable
        public final Boolean component29() {
            return this.isEligibleForDelivery;
        }

        @Nullable
        public final Long component3() {
            return this.areaId;
        }

        @Nullable
        public final String component4() {
            return this.areaName;
        }

        @Nullable
        public final Integer component5() {
            return this.cityId;
        }

        @Nullable
        public final String component6() {
            return this.cityName;
        }

        @Nullable
        public final Integer component7() {
            return this.customerId;
        }

        @Nullable
        public final Integer component8() {
            return this.type;
        }

        @Nullable
        public final String component9() {
            return this.block;
        }

        @NotNull
        public final Result copy(@Nullable String str, @Nullable String str2, @Nullable Long l11, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable Boolean bool, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable Boolean bool2, @Nullable Integer num4, @Nullable Double d11, @Nullable Double d12, @Nullable String str15, @Nullable String str16, @Nullable Boolean bool3, @Nullable String str17, @Nullable Boolean bool4, @Nullable Boolean bool5) {
            return new Result(str, str2, l11, str3, num, str4, num2, num3, str5, str6, str7, str8, str9, str10, str11, bool, str12, str13, str14, bool2, num4, d11, d12, str15, str16, bool3, str17, bool4, bool5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return Intrinsics.areEqual((Object) this.profileId, (Object) result.profileId) && Intrinsics.areEqual((Object) this.profileName, (Object) result.profileName) && Intrinsics.areEqual((Object) this.areaId, (Object) result.areaId) && Intrinsics.areEqual((Object) this.areaName, (Object) result.areaName) && Intrinsics.areEqual((Object) this.cityId, (Object) result.cityId) && Intrinsics.areEqual((Object) this.cityName, (Object) result.cityName) && Intrinsics.areEqual((Object) this.customerId, (Object) result.customerId) && Intrinsics.areEqual((Object) this.type, (Object) result.type) && Intrinsics.areEqual((Object) this.block, (Object) result.block) && Intrinsics.areEqual((Object) this.judda, (Object) result.judda) && Intrinsics.areEqual((Object) this.street, (Object) result.street) && Intrinsics.areEqual((Object) this.buildingNo, (Object) result.buildingNo) && Intrinsics.areEqual((Object) this.floor, (Object) result.floor) && Intrinsics.areEqual((Object) this.suite, (Object) result.suite) && Intrinsics.areEqual((Object) this.extraDirections, (Object) result.extraDirections) && Intrinsics.areEqual((Object) this.isPrimary, (Object) result.isPrimary) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) result.phoneNumber) && Intrinsics.areEqual((Object) this.mobileNumber, (Object) result.mobileNumber) && Intrinsics.areEqual((Object) this.mobileCountryCode, (Object) result.mobileCountryCode) && Intrinsics.areEqual((Object) this.isOldAddress, (Object) result.isOldAddress) && Intrinsics.areEqual((Object) this.country, (Object) result.country) && Intrinsics.areEqual((Object) this.latitude, (Object) result.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) result.longitude) && Intrinsics.areEqual((Object) this.grl, (Object) result.grl) && Intrinsics.areEqual((Object) this.grlId, (Object) result.grlId) && Intrinsics.areEqual((Object) this.isAreaDisabled, (Object) result.isAreaDisabled) && Intrinsics.areEqual((Object) this.countryCode, (Object) result.countryCode) && Intrinsics.areEqual((Object) this.isPolygonSearchEnabled, (Object) result.isPolygonSearchEnabled) && Intrinsics.areEqual((Object) this.isEligibleForDelivery, (Object) result.isEligibleForDelivery);
        }

        @Nullable
        public final Long getAreaId() {
            return this.areaId;
        }

        @Nullable
        public final String getAreaName() {
            return this.areaName;
        }

        @Nullable
        public final String getBlock() {
            return this.block;
        }

        @Nullable
        public final String getBuildingNo() {
            return this.buildingNo;
        }

        @Nullable
        public final Integer getCityId() {
            return this.cityId;
        }

        @Nullable
        public final String getCityName() {
            return this.cityName;
        }

        @Nullable
        public final Integer getCountry() {
            return this.country;
        }

        @Nullable
        public final String getCountryCode() {
            return this.countryCode;
        }

        @Nullable
        public final Integer getCustomerId() {
            return this.customerId;
        }

        @Nullable
        public final String getExtraDirections() {
            return this.extraDirections;
        }

        @Nullable
        public final String getFloor() {
            return this.floor;
        }

        @Nullable
        public final String getGrl() {
            return this.grl;
        }

        @Nullable
        public final String getGrlId() {
            return this.grlId;
        }

        @Nullable
        public final String getJudda() {
            return this.judda;
        }

        @Nullable
        public final Double getLatitude() {
            return this.latitude;
        }

        @Nullable
        public final Double getLongitude() {
            return this.longitude;
        }

        @Nullable
        public final String getMobileCountryCode() {
            return this.mobileCountryCode;
        }

        @Nullable
        public final String getMobileNumber() {
            return this.mobileNumber;
        }

        @Nullable
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        @Nullable
        public final String getProfileId() {
            return this.profileId;
        }

        @Nullable
        public final String getProfileName() {
            return this.profileName;
        }

        @Nullable
        public final String getStreet() {
            return this.street;
        }

        @Nullable
        public final String getSuite() {
            return this.suite;
        }

        @Nullable
        public final Integer getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.profileId;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.profileName;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l11 = this.areaId;
            int hashCode3 = (hashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
            String str3 = this.areaName;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.cityId;
            int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
            String str4 = this.cityName;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num2 = this.customerId;
            int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.type;
            int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str5 = this.block;
            int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.judda;
            int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.street;
            int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.buildingNo;
            int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.floor;
            int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.suite;
            int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.extraDirections;
            int hashCode15 = (hashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Boolean bool = this.isPrimary;
            int hashCode16 = (hashCode15 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str12 = this.phoneNumber;
            int hashCode17 = (hashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
            String str13 = this.mobileNumber;
            int hashCode18 = (hashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
            String str14 = this.mobileCountryCode;
            int hashCode19 = (hashCode18 + (str14 == null ? 0 : str14.hashCode())) * 31;
            Boolean bool2 = this.isOldAddress;
            int hashCode20 = (hashCode19 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Integer num4 = this.country;
            int hashCode21 = (hashCode20 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Double d11 = this.latitude;
            int hashCode22 = (hashCode21 + (d11 == null ? 0 : d11.hashCode())) * 31;
            Double d12 = this.longitude;
            int hashCode23 = (hashCode22 + (d12 == null ? 0 : d12.hashCode())) * 31;
            String str15 = this.grl;
            int hashCode24 = (hashCode23 + (str15 == null ? 0 : str15.hashCode())) * 31;
            String str16 = this.grlId;
            int hashCode25 = (hashCode24 + (str16 == null ? 0 : str16.hashCode())) * 31;
            Boolean bool3 = this.isAreaDisabled;
            int hashCode26 = (hashCode25 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            String str17 = this.countryCode;
            int hashCode27 = (hashCode26 + (str17 == null ? 0 : str17.hashCode())) * 31;
            Boolean bool4 = this.isPolygonSearchEnabled;
            int hashCode28 = (hashCode27 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.isEligibleForDelivery;
            if (bool5 != null) {
                i11 = bool5.hashCode();
            }
            return hashCode28 + i11;
        }

        @Nullable
        public final Boolean isAreaDisabled() {
            return this.isAreaDisabled;
        }

        @Nullable
        public final Boolean isEligibleForDelivery() {
            return this.isEligibleForDelivery;
        }

        @Nullable
        public final Boolean isOldAddress() {
            return this.isOldAddress;
        }

        @Nullable
        public final Boolean isPolygonSearchEnabled() {
            return this.isPolygonSearchEnabled;
        }

        @Nullable
        public final Boolean isPrimary() {
            return this.isPrimary;
        }

        @NotNull
        public String toString() {
            String str = this.profileId;
            String str2 = this.profileName;
            Long l11 = this.areaId;
            String str3 = this.areaName;
            Integer num = this.cityId;
            String str4 = this.cityName;
            Integer num2 = this.customerId;
            Integer num3 = this.type;
            String str5 = this.block;
            String str6 = this.judda;
            String str7 = this.street;
            String str8 = this.buildingNo;
            String str9 = this.floor;
            String str10 = this.suite;
            String str11 = this.extraDirections;
            Boolean bool = this.isPrimary;
            String str12 = this.phoneNumber;
            String str13 = this.mobileNumber;
            String str14 = this.mobileCountryCode;
            Boolean bool2 = this.isOldAddress;
            Integer num4 = this.country;
            Double d11 = this.latitude;
            Double d12 = this.longitude;
            String str15 = this.grl;
            String str16 = this.grlId;
            Boolean bool3 = this.isAreaDisabled;
            String str17 = this.countryCode;
            Boolean bool4 = this.isPolygonSearchEnabled;
            Boolean bool5 = this.isEligibleForDelivery;
            return "Result(profileId=" + str + ", profileName=" + str2 + ", areaId=" + l11 + ", areaName=" + str3 + ", cityId=" + num + ", cityName=" + str4 + ", customerId=" + num2 + ", type=" + num3 + ", block=" + str5 + ", judda=" + str6 + ", street=" + str7 + ", buildingNo=" + str8 + ", floor=" + str9 + ", suite=" + str10 + ", extraDirections=" + str11 + ", isPrimary=" + bool + ", phoneNumber=" + str12 + ", mobileNumber=" + str13 + ", mobileCountryCode=" + str14 + ", isOldAddress=" + bool2 + ", country=" + num4 + ", latitude=" + d11 + ", longitude=" + d12 + ", grl=" + str15 + ", grlId=" + str16 + ", isAreaDisabled=" + bool3 + ", countryCode=" + str17 + ", isPolygonSearchEnabled=" + bool4 + ", isEligibleForDelivery=" + bool5 + ")";
        }
    }

    public UpdateAddressResponse(@Nullable String str, @Nullable Result result2, @Nullable Boolean bool, @Nullable Error error2) {
        this.timestamp = str;
        this.result = result2;
        this.hasError = bool;
        this.error = error2;
    }

    public static /* synthetic */ UpdateAddressResponse copy$default(UpdateAddressResponse updateAddressResponse, String str, Result result2, Boolean bool, Error error2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = updateAddressResponse.timestamp;
        }
        if ((i11 & 2) != 0) {
            result2 = updateAddressResponse.result;
        }
        if ((i11 & 4) != 0) {
            bool = updateAddressResponse.hasError;
        }
        if ((i11 & 8) != 0) {
            error2 = updateAddressResponse.error;
        }
        return updateAddressResponse.copy(str, result2, bool, error2);
    }

    @Nullable
    public final String component1() {
        return this.timestamp;
    }

    @Nullable
    public final Result component2() {
        return this.result;
    }

    @Nullable
    public final Boolean component3() {
        return this.hasError;
    }

    @Nullable
    public final Error component4() {
        return this.error;
    }

    @NotNull
    public final UpdateAddressResponse copy(@Nullable String str, @Nullable Result result2, @Nullable Boolean bool, @Nullable Error error2) {
        return new UpdateAddressResponse(str, result2, bool, error2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateAddressResponse)) {
            return false;
        }
        UpdateAddressResponse updateAddressResponse = (UpdateAddressResponse) obj;
        return Intrinsics.areEqual((Object) this.timestamp, (Object) updateAddressResponse.timestamp) && Intrinsics.areEqual((Object) this.result, (Object) updateAddressResponse.result) && Intrinsics.areEqual((Object) this.hasError, (Object) updateAddressResponse.hasError) && Intrinsics.areEqual((Object) this.error, (Object) updateAddressResponse.error);
    }

    @Nullable
    public final Error getError() {
        return this.error;
    }

    @Nullable
    public final Boolean getHasError() {
        return this.hasError;
    }

    @Nullable
    public final Result getResult() {
        return this.result;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.timestamp;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Result result2 = this.result;
        int hashCode2 = (hashCode + (result2 == null ? 0 : result2.hashCode())) * 31;
        Boolean bool = this.hasError;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Error error2 = this.error;
        if (error2 != null) {
            i11 = error2.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.timestamp;
        Result result2 = this.result;
        Boolean bool = this.hasError;
        Error error2 = this.error;
        return "UpdateAddressResponse(timestamp=" + str + ", result=" + result2 + ", hasError=" + bool + ", error=" + error2 + ")";
    }
}
