package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import okhttp3.Headers;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebSocketExtensions {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    @Nullable
    @JvmField
    public final Integer clientMaxWindowBits;
    @JvmField
    public final boolean clientNoContextTakeover;
    @JvmField
    public final boolean perMessageDeflate;
    @Nullable
    @JvmField
    public final Integer serverMaxWindowBits;
    @JvmField
    public final boolean serverNoContextTakeover;
    @JvmField
    public final boolean unknownValues;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WebSocketExtensions parse(@NotNull Headers headers) throws IOException {
            String str;
            Headers headers2 = headers;
            Intrinsics.checkNotNullParameter(headers2, "responseHeaders");
            int size = headers.size();
            int i11 = 0;
            boolean z11 = false;
            Integer num = null;
            boolean z12 = false;
            Integer num2 = null;
            boolean z13 = false;
            boolean z14 = false;
            while (i11 < size) {
                int i12 = i11 + 1;
                if (StringsKt__StringsJVMKt.equals(headers2.name(i11), "Sec-WebSocket-Extensions", true)) {
                    String value = headers2.value(i11);
                    int i13 = 0;
                    while (i13 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, (char) AbstractJsonLexerKt.COMMA, i13, 0, 4, (Object) null);
                        int delimiterOffset = Util.delimiterOffset(value, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, i13, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i13, delimiterOffset);
                        int i14 = delimiterOffset + 1;
                        if (StringsKt__StringsJVMKt.equals(trimSubstring, "permessage-deflate", true)) {
                            if (z11) {
                                z14 = true;
                            }
                            i13 = i14;
                            while (i13 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, i13, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, (char) SignatureVisitor.INSTANCEOF, i13, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i13, delimiterOffset3);
                                if (delimiterOffset3 < delimiterOffset2) {
                                    str = StringsKt__StringsKt.removeSurrounding(Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), (CharSequence) "\"");
                                } else {
                                    str = null;
                                }
                                i13 = delimiterOffset2 + 1;
                                if (StringsKt__StringsJVMKt.equals(trimSubstring2, "client_max_window_bits", true)) {
                                    if (num != null) {
                                        z14 = true;
                                    }
                                    if (str == null) {
                                        num = null;
                                    } else {
                                        num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                                    }
                                    if (num != null) {
                                    }
                                } else if (StringsKt__StringsJVMKt.equals(trimSubstring2, "client_no_context_takeover", true)) {
                                    if (z12) {
                                        z14 = true;
                                    }
                                    if (str != null) {
                                        z14 = true;
                                    }
                                    z12 = true;
                                } else if (StringsKt__StringsJVMKt.equals(trimSubstring2, "server_max_window_bits", true)) {
                                    if (num2 != null) {
                                        z14 = true;
                                    }
                                    if (str == null) {
                                        num2 = null;
                                    } else {
                                        num2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                                    }
                                    if (num2 != null) {
                                    }
                                } else if (StringsKt__StringsJVMKt.equals(trimSubstring2, "server_no_context_takeover", true)) {
                                    if (z13) {
                                        z14 = true;
                                    }
                                    if (str != null) {
                                        z14 = true;
                                    }
                                    z13 = true;
                                }
                                z14 = true;
                            }
                            z11 = true;
                        } else {
                            i13 = i14;
                            z14 = true;
                        }
                    }
                }
                i11 = i12;
            }
            return new WebSocketExtensions(z11, num, z12, num2, z13, z14);
        }
    }

    public WebSocketExtensions() {
        this(false, (Integer) null, false, (Integer) null, false, false, 63, (DefaultConstructorMarker) null);
    }

    public WebSocketExtensions(boolean z11, @Nullable Integer num, boolean z12, @Nullable Integer num2, boolean z13, boolean z14) {
        this.perMessageDeflate = z11;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z12;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z13;
        this.unknownValues = z14;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z11, Integer num, boolean z12, Integer num2, boolean z13, boolean z14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = webSocketExtensions.perMessageDeflate;
        }
        if ((i11 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i11 & 4) != 0) {
            z12 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z15 = z12;
        if ((i11 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i11 & 16) != 0) {
            z13 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z16 = z13;
        if ((i11 & 32) != 0) {
            z14 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z11, num3, z15, num4, z16, z14);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    @Nullable
    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    @Nullable
    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    @NotNull
    public final WebSocketExtensions copy(boolean z11, @Nullable Integer num, boolean z12, @Nullable Integer num2, boolean z13, boolean z14) {
        return new WebSocketExtensions(z11, num, z12, num2, z13, z14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.areEqual((Object) this.clientMaxWindowBits, (Object) webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.areEqual((Object) this.serverMaxWindowBits, (Object) webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        boolean z11 = this.perMessageDeflate;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        Integer num = this.clientMaxWindowBits;
        int i12 = 0;
        int hashCode = (i11 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z13 = this.clientNoContextTakeover;
        if (z13) {
            z13 = true;
        }
        int i13 = (hashCode + (z13 ? 1 : 0)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        if (num2 != null) {
            i12 = num2.hashCode();
        }
        int i14 = (i13 + i12) * 31;
        boolean z14 = this.serverNoContextTakeover;
        if (z14) {
            z14 = true;
        }
        int i15 = (i14 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.unknownValues;
        if (!z15) {
            z12 = z15;
        }
        return i15 + (z12 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z11) {
        if (z11) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    @NotNull
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WebSocketExtensions(boolean r6, java.lang.Integer r7, boolean r8, java.lang.Integer r9, boolean r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            r1 = 0
            if (r6 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r3 = r0
            goto L_0x0017
        L_0x0016:
            r3 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r1
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.<init>(boolean, java.lang.Integer, boolean, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
