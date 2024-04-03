package com.deliveryhero.chatsdk.network.websocket.okhttp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent;", "", "()V", "ByteReceived", "TextReceived", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent$TextReceived;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent$ByteReceived;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MessageEvent {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent$ByteReceived;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent;", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;)V", "getBytes", "()Lokio/ByteString;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ByteReceived extends MessageEvent {
        @NotNull
        private final ByteString bytes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ByteReceived(@NotNull ByteString byteString) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(byteString, "bytes");
            this.bytes = byteString;
        }

        public static /* synthetic */ ByteReceived copy$default(ByteReceived byteReceived, ByteString byteString, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                byteString = byteReceived.bytes;
            }
            return byteReceived.copy(byteString);
        }

        @NotNull
        public final ByteString component1() {
            return this.bytes;
        }

        @NotNull
        public final ByteReceived copy(@NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "bytes");
            return new ByteReceived(byteString);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ByteReceived) && Intrinsics.areEqual((Object) this.bytes, (Object) ((ByteReceived) obj).bytes);
        }

        @NotNull
        public final ByteString getBytes() {
            return this.bytes;
        }

        public int hashCode() {
            return this.bytes.hashCode();
        }

        @NotNull
        public String toString() {
            return "ByteReceived(bytes=" + this.bytes + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent$TextReceived;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/MessageEvent;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TextReceived extends MessageEvent {
        @NotNull
        private final String text;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TextReceived(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        public static /* synthetic */ TextReceived copy$default(TextReceived textReceived, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = textReceived.text;
            }
            return textReceived.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final TextReceived copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new TextReceived(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TextReceived) && Intrinsics.areEqual((Object) this.text, (Object) ((TextReceived) obj).text);
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        @NotNull
        public String toString() {
            return "TextReceived(text=" + this.text + ')';
        }
    }

    private MessageEvent() {
    }

    public /* synthetic */ MessageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
