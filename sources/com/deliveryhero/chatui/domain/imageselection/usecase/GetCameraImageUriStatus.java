package com.deliveryhero.chatui.domain.imageselection.usecase;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriStatus;", "", "()V", "Data", "Error", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriStatus$Data;", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriStatus$Error;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class GetCameraImageUriStatus {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriStatus$Data;", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriStatus;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Data extends GetCameraImageUriStatus {
        @NotNull
        private final Uri uri;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Data(@NotNull Uri uri2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(uri2, "uri");
            this.uri = uri2;
        }

        public static /* synthetic */ Data copy$default(Data data, Uri uri2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                uri2 = data.uri;
            }
            return data.copy(uri2);
        }

        @NotNull
        public final Uri component1() {
            return this.uri;
        }

        @NotNull
        public final Data copy(@NotNull Uri uri2) {
            Intrinsics.checkNotNullParameter(uri2, "uri");
            return new Data(uri2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Data) && Intrinsics.areEqual((Object) this.uri, (Object) ((Data) obj).uri);
        }

        @NotNull
        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        @NotNull
        public String toString() {
            return "Data(uri=" + this.uri + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriStatus$Error;", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriStatus;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends GetCameraImageUriStatus {
        @NotNull
        private final Throwable error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull Throwable th2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, "error");
            this.error = th2;
        }

        public static /* synthetic */ Error copy$default(Error error2, Throwable th2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                th2 = error2.error;
            }
            return error2.copy(th2);
        }

        @NotNull
        public final Throwable component1() {
            return this.error;
        }

        @NotNull
        public final Error copy(@NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "error");
            return new Error(th2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.error, (Object) ((Error) obj).error);
        }

        @NotNull
        public final Throwable getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        @NotNull
        public String toString() {
            return "Error(error=" + this.error + ')';
        }
    }

    private GetCameraImageUriStatus() {
    }

    public /* synthetic */ GetCameraImageUriStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
