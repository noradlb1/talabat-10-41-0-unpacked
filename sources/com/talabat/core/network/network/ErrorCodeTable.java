package com.talabat.core.network.network;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/talabat/core/network/network/ErrorCodeTable;", "", "code", "", "msg", "viewMessage", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "AuthFailure", "ServerException", "GeneralException", "Companion", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ErrorCodeTable {
    AuthFailure("1", "AuthFailure", "Authentication Failed"),
    ServerException(ExifInterface.GPS_MEASUREMENT_2D, "ServerException", "Internal Server Exception"),
    GeneralException(ExifInterface.GPS_MEASUREMENT_3D, "GeneralError", "Error");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String code;
    @NotNull
    private final String msg;
    /* access modifiers changed from: private */
    @NotNull
    public final String viewMessage;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/network/network/ErrorCodeTable$Companion;", "", "()V", "parseErrorCode", "", "errorCode", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String parseErrorCode(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "errorCode");
            if (Intrinsics.areEqual((Object) str, (Object) "1")) {
                return ErrorCodeTable.AuthFailure.viewMessage;
            }
            if (Intrinsics.areEqual((Object) str, (Object) ExifInterface.GPS_MEASUREMENT_2D)) {
                return ErrorCodeTable.ServerException.viewMessage;
            }
            return ErrorCodeTable.GeneralException.viewMessage;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private ErrorCodeTable(String str, String str2, String str3) {
        this.code = str;
        this.msg = str2;
        this.viewMessage = str3;
    }

    @NotNull
    public String toString() {
        String str = this.code;
        String str2 = this.msg;
        String str3 = this.viewMessage;
        return "ErrorCodeTable{code='" + str + "', msg='" + str2 + "', viewMessage='" + str3 + "'}";
    }
}
