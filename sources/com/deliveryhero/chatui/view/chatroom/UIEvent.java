package com.deliveryhero.chatui.view.chatroom;

import androidx.annotation.StringRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/UIEvent;", "", "ChannelStatusUpdate", "ErrorMessage", "LocalizedErrorMessage", "Lcom/deliveryhero/chatui/view/chatroom/UIEvent$ErrorMessage;", "Lcom/deliveryhero/chatui/view/chatroom/UIEvent$LocalizedErrorMessage;", "Lcom/deliveryhero/chatui/view/chatroom/UIEvent$ChannelStatusUpdate;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UIEvent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/UIEvent$ChannelStatusUpdate;", "Lcom/deliveryhero/chatui/view/chatroom/UIEvent;", "()V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ChannelStatusUpdate implements UIEvent {
        @NotNull
        public static final ChannelStatusUpdate INSTANCE = new ChannelStatusUpdate();

        private ChannelStatusUpdate() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/UIEvent$ErrorMessage;", "Lcom/deliveryhero/chatui/view/chatroom/UIEvent;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ErrorMessage implements UIEvent {
        @Nullable
        private final String message;

        public ErrorMessage(@Nullable String str) {
            this.message = str;
        }

        public static /* synthetic */ ErrorMessage copy$default(ErrorMessage errorMessage, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = errorMessage.message;
            }
            return errorMessage.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.message;
        }

        @NotNull
        public final ErrorMessage copy(@Nullable String str) {
            return new ErrorMessage(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ErrorMessage) && Intrinsics.areEqual((Object) this.message, (Object) ((ErrorMessage) obj).message);
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            String str = this.message;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @NotNull
        public String toString() {
            return "ErrorMessage(message=" + this.message + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/UIEvent$LocalizedErrorMessage;", "Lcom/deliveryhero/chatui/view/chatroom/UIEvent;", "messageReference", "", "(Ljava/lang/Integer;)V", "getMessageReference", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/deliveryhero/chatui/view/chatroom/UIEvent$LocalizedErrorMessage;", "equals", "", "other", "", "hashCode", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LocalizedErrorMessage implements UIEvent {
        @Nullable
        private final Integer messageReference;

        public LocalizedErrorMessage(@Nullable @StringRes Integer num) {
            this.messageReference = num;
        }

        public static /* synthetic */ LocalizedErrorMessage copy$default(LocalizedErrorMessage localizedErrorMessage, Integer num, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                num = localizedErrorMessage.messageReference;
            }
            return localizedErrorMessage.copy(num);
        }

        @Nullable
        public final Integer component1() {
            return this.messageReference;
        }

        @NotNull
        public final LocalizedErrorMessage copy(@Nullable @StringRes Integer num) {
            return new LocalizedErrorMessage(num);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocalizedErrorMessage) && Intrinsics.areEqual((Object) this.messageReference, (Object) ((LocalizedErrorMessage) obj).messageReference);
        }

        @Nullable
        public final Integer getMessageReference() {
            return this.messageReference;
        }

        public int hashCode() {
            Integer num = this.messageReference;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        @NotNull
        public String toString() {
            return "LocalizedErrorMessage(messageReference=" + this.messageReference + ')';
        }
    }
}
