package com.deliveryhero.chatui.domain;

import com.deliveryhero.contract.model.BaseMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/deliveryhero/chatui/domain/UploadPhotoStatus;", "", "()V", "Error", "Loading", "Success", "Lcom/deliveryhero/chatui/domain/UploadPhotoStatus$Success;", "Lcom/deliveryhero/chatui/domain/UploadPhotoStatus$Loading;", "Lcom/deliveryhero/chatui/domain/UploadPhotoStatus$Error;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class UploadPhotoStatus {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/chatui/domain/UploadPhotoStatus$Error;", "Lcom/deliveryhero/chatui/domain/UploadPhotoStatus;", "fileMessage", "Lcom/deliveryhero/contract/model/BaseMessage;", "error", "", "(Lcom/deliveryhero/contract/model/BaseMessage;Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "getFileMessage", "()Lcom/deliveryhero/contract/model/BaseMessage;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends UploadPhotoStatus {
        @NotNull
        private final Throwable error;
        @Nullable
        private final BaseMessage fileMessage;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@Nullable BaseMessage baseMessage, @NotNull Throwable th2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, "error");
            this.fileMessage = baseMessage;
            this.error = th2;
        }

        public static /* synthetic */ Error copy$default(Error error2, BaseMessage baseMessage, Throwable th2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                baseMessage = error2.fileMessage;
            }
            if ((i11 & 2) != 0) {
                th2 = error2.error;
            }
            return error2.copy(baseMessage, th2);
        }

        @Nullable
        public final BaseMessage component1() {
            return this.fileMessage;
        }

        @NotNull
        public final Throwable component2() {
            return this.error;
        }

        @NotNull
        public final Error copy(@Nullable BaseMessage baseMessage, @NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "error");
            return new Error(baseMessage, th2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error2 = (Error) obj;
            return Intrinsics.areEqual((Object) this.fileMessage, (Object) error2.fileMessage) && Intrinsics.areEqual((Object) this.error, (Object) error2.error);
        }

        @NotNull
        public final Throwable getError() {
            return this.error;
        }

        @Nullable
        public final BaseMessage getFileMessage() {
            return this.fileMessage;
        }

        public int hashCode() {
            BaseMessage baseMessage = this.fileMessage;
            return ((baseMessage == null ? 0 : baseMessage.hashCode()) * 31) + this.error.hashCode();
        }

        @NotNull
        public String toString() {
            return "Error(fileMessage=" + this.fileMessage + ", error=" + this.error + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/chatui/domain/UploadPhotoStatus$Loading;", "Lcom/deliveryhero/chatui/domain/UploadPhotoStatus;", "()V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends UploadPhotoStatus {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/chatui/domain/UploadPhotoStatus$Success;", "Lcom/deliveryhero/chatui/domain/UploadPhotoStatus;", "fileMessage", "Lcom/deliveryhero/contract/model/BaseMessage;", "(Lcom/deliveryhero/contract/model/BaseMessage;)V", "getFileMessage", "()Lcom/deliveryhero/contract/model/BaseMessage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success extends UploadPhotoStatus {
        @NotNull
        private final BaseMessage fileMessage;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull BaseMessage baseMessage) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(baseMessage, "fileMessage");
            this.fileMessage = baseMessage;
        }

        public static /* synthetic */ Success copy$default(Success success, BaseMessage baseMessage, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                baseMessage = success.fileMessage;
            }
            return success.copy(baseMessage);
        }

        @NotNull
        public final BaseMessage component1() {
            return this.fileMessage;
        }

        @NotNull
        public final Success copy(@NotNull BaseMessage baseMessage) {
            Intrinsics.checkNotNullParameter(baseMessage, "fileMessage");
            return new Success(baseMessage);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.fileMessage, (Object) ((Success) obj).fileMessage);
        }

        @NotNull
        public final BaseMessage getFileMessage() {
            return this.fileMessage;
        }

        public int hashCode() {
            return this.fileMessage.hashCode();
        }

        @NotNull
        public String toString() {
            return "Success(fileMessage=" + this.fileMessage + ')';
        }
    }

    private UploadPhotoStatus() {
    }

    public /* synthetic */ UploadPhotoStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
