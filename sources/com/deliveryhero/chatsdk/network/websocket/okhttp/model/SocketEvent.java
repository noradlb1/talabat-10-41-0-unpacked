package com.deliveryhero.chatsdk.network.websocket.okhttp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent;", "", "()V", "Closed", "Closing", "Connecting", "Failed", "Open", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Open;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Connecting;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Closed;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Closing;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Failed;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SocketEvent {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Closed;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent;", "code", "", "reason", "", "(ILjava/lang/String;)V", "getCode", "()I", "getReason", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Closed extends SocketEvent {
        private final int code;
        @NotNull
        private final String reason;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Closed(int i11, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "reason");
            this.code = i11;
            this.reason = str;
        }

        public static /* synthetic */ Closed copy$default(Closed closed, int i11, String str, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = closed.code;
            }
            if ((i12 & 2) != 0) {
                str = closed.reason;
            }
            return closed.copy(i11, str);
        }

        public final int component1() {
            return this.code;
        }

        @NotNull
        public final String component2() {
            return this.reason;
        }

        @NotNull
        public final Closed copy(int i11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "reason");
            return new Closed(i11, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Closed)) {
                return false;
            }
            Closed closed = (Closed) obj;
            return this.code == closed.code && Intrinsics.areEqual((Object) this.reason, (Object) closed.reason);
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return (this.code * 31) + this.reason.hashCode();
        }

        @NotNull
        public String toString() {
            return "Closed(code=" + this.code + ", reason=" + this.reason + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Closing;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent;", "code", "", "reason", "", "(ILjava/lang/String;)V", "getCode", "()I", "getReason", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Closing extends SocketEvent {
        private final int code;
        @NotNull
        private final String reason;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Closing(int i11, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "reason");
            this.code = i11;
            this.reason = str;
        }

        public static /* synthetic */ Closing copy$default(Closing closing, int i11, String str, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = closing.code;
            }
            if ((i12 & 2) != 0) {
                str = closing.reason;
            }
            return closing.copy(i11, str);
        }

        public final int component1() {
            return this.code;
        }

        @NotNull
        public final String component2() {
            return this.reason;
        }

        @NotNull
        public final Closing copy(int i11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "reason");
            return new Closing(i11, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Closing)) {
                return false;
            }
            Closing closing = (Closing) obj;
            return this.code == closing.code && Intrinsics.areEqual((Object) this.reason, (Object) closing.reason);
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return (this.code * 31) + this.reason.hashCode();
        }

        @NotNull
        public String toString() {
            return "Closing(code=" + this.code + ", reason=" + this.reason + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Connecting;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent;", "()V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Connecting extends SocketEvent {
        @NotNull
        public static final Connecting INSTANCE = new Connecting();

        private Connecting() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Failed;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent;", "exception", "", "(Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Failed extends SocketEvent {
        @NotNull
        private final Throwable exception;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failed(@NotNull Throwable th2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, "exception");
            this.exception = th2;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, Throwable th2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                th2 = failed.exception;
            }
            return failed.copy(th2);
        }

        @NotNull
        public final Throwable component1() {
            return this.exception;
        }

        @NotNull
        public final Failed copy(@NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "exception");
            return new Failed(th2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && Intrinsics.areEqual((Object) this.exception, (Object) ((Failed) obj).exception);
        }

        @NotNull
        public final Throwable getException() {
            return this.exception;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failed(exception=" + this.exception + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent$Open;", "Lcom/deliveryhero/chatsdk/network/websocket/okhttp/model/SocketEvent;", "()V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Open extends SocketEvent {
        @NotNull
        public static final Open INSTANCE = new Open();

        private Open() {
            super((DefaultConstructorMarker) null);
        }
    }

    private SocketEvent() {
    }

    public /* synthetic */ SocketEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
