package com.talabat.authentication.aaa;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/authentication/aaa/GenericErrorBody;", "", "statusCode", "", "data", "Lcom/talabat/authentication/aaa/GenericErrorBody$Data;", "(ILcom/talabat/authentication/aaa/GenericErrorBody$Data;)V", "getData", "()Lcom/talabat/authentication/aaa/GenericErrorBody$Data;", "getStatusCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Data", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GenericErrorBody {
    @SerializedName("data")
    @Nullable
    private final Data data;
    @SerializedName("status_code")
    private final int statusCode;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001aB-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/authentication/aaa/GenericErrorBody$Data;", "", "exceptionType", "Lcom/talabat/authentication/aaa/GenericErrorBody$Data$ExceptionType;", "exceptionMessage", "", "developerMessage", "moreInformation", "(Lcom/talabat/authentication/aaa/GenericErrorBody$Data$ExceptionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeveloperMessage", "()Ljava/lang/String;", "getExceptionMessage", "getExceptionType", "()Lcom/talabat/authentication/aaa/GenericErrorBody$Data$ExceptionType;", "getMoreInformation", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ExceptionType", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Data {
        @SerializedName("developer_message")
        @Nullable
        private final String developerMessage;
        @SerializedName("message")
        @Nullable
        private final String exceptionMessage;
        @SerializedName("exception_type")
        @Nullable
        private final ExceptionType exceptionType;
        @SerializedName("more_information")
        @Nullable
        private final String moreInformation;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/authentication/aaa/GenericErrorBody$Data$ExceptionType;", "", "(Ljava/lang/String;I)V", "OAUTH_FAILED_EXCEPTION", "INVALID_EMAIL", "SOCIAL_LOGIN_USER_NOT_FOUND", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public enum ExceptionType {
            OAUTH_FAILED_EXCEPTION,
            INVALID_EMAIL,
            SOCIAL_LOGIN_USER_NOT_FOUND
        }

        public Data(@Nullable ExceptionType exceptionType2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.exceptionType = exceptionType2;
            this.exceptionMessage = str;
            this.developerMessage = str2;
            this.moreInformation = str3;
        }

        public static /* synthetic */ Data copy$default(Data data, ExceptionType exceptionType2, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                exceptionType2 = data.exceptionType;
            }
            if ((i11 & 2) != 0) {
                str = data.exceptionMessage;
            }
            if ((i11 & 4) != 0) {
                str2 = data.developerMessage;
            }
            if ((i11 & 8) != 0) {
                str3 = data.moreInformation;
            }
            return data.copy(exceptionType2, str, str2, str3);
        }

        @Nullable
        public final ExceptionType component1() {
            return this.exceptionType;
        }

        @Nullable
        public final String component2() {
            return this.exceptionMessage;
        }

        @Nullable
        public final String component3() {
            return this.developerMessage;
        }

        @Nullable
        public final String component4() {
            return this.moreInformation;
        }

        @NotNull
        public final Data copy(@Nullable ExceptionType exceptionType2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            return new Data(exceptionType2, str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return this.exceptionType == data.exceptionType && Intrinsics.areEqual((Object) this.exceptionMessage, (Object) data.exceptionMessage) && Intrinsics.areEqual((Object) this.developerMessage, (Object) data.developerMessage) && Intrinsics.areEqual((Object) this.moreInformation, (Object) data.moreInformation);
        }

        @Nullable
        public final String getDeveloperMessage() {
            return this.developerMessage;
        }

        @Nullable
        public final String getExceptionMessage() {
            return this.exceptionMessage;
        }

        @Nullable
        public final ExceptionType getExceptionType() {
            return this.exceptionType;
        }

        @Nullable
        public final String getMoreInformation() {
            return this.moreInformation;
        }

        public int hashCode() {
            ExceptionType exceptionType2 = this.exceptionType;
            int i11 = 0;
            int hashCode = (exceptionType2 == null ? 0 : exceptionType2.hashCode()) * 31;
            String str = this.exceptionMessage;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.developerMessage;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.moreInformation;
            if (str3 != null) {
                i11 = str3.hashCode();
            }
            return hashCode3 + i11;
        }

        @NotNull
        public String toString() {
            ExceptionType exceptionType2 = this.exceptionType;
            String str = this.exceptionMessage;
            String str2 = this.developerMessage;
            String str3 = this.moreInformation;
            return "Data(exceptionType=" + exceptionType2 + ", exceptionMessage=" + str + ", developerMessage=" + str2 + ", moreInformation=" + str3 + ")";
        }
    }

    public GenericErrorBody(int i11, @Nullable Data data2) {
        this.statusCode = i11;
        this.data = data2;
    }

    public static /* synthetic */ GenericErrorBody copy$default(GenericErrorBody genericErrorBody, int i11, Data data2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = genericErrorBody.statusCode;
        }
        if ((i12 & 2) != 0) {
            data2 = genericErrorBody.data;
        }
        return genericErrorBody.copy(i11, data2);
    }

    public final int component1() {
        return this.statusCode;
    }

    @Nullable
    public final Data component2() {
        return this.data;
    }

    @NotNull
    public final GenericErrorBody copy(int i11, @Nullable Data data2) {
        return new GenericErrorBody(i11, data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericErrorBody)) {
            return false;
        }
        GenericErrorBody genericErrorBody = (GenericErrorBody) obj;
        return this.statusCode == genericErrorBody.statusCode && Intrinsics.areEqual((Object) this.data, (Object) genericErrorBody.data);
    }

    @Nullable
    public final Data getData() {
        return this.data;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        int i11 = this.statusCode * 31;
        Data data2 = this.data;
        return i11 + (data2 == null ? 0 : data2.hashCode());
    }

    @NotNull
    public String toString() {
        int i11 = this.statusCode;
        Data data2 = this.data;
        return "GenericErrorBody(statusCode=" + i11 + ", data=" + data2 + ")";
    }
}
