package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bJ\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0000¢\u0006\u0002\b#J.\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lokhttp3/internal/http2/Http2;", "", "()V", "BINARY", "", "", "[Ljava/lang/String;", "CONNECTION_PREFACE", "Lokio/ByteString;", "FLAGS", "FLAG_ACK", "", "FLAG_COMPRESSED", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_END_STREAM", "FLAG_NONE", "FLAG_PADDED", "FLAG_PRIORITY", "FRAME_NAMES", "INITIAL_MAX_FRAME_SIZE", "TYPE_CONTINUATION", "TYPE_DATA", "TYPE_GOAWAY", "TYPE_HEADERS", "TYPE_PING", "TYPE_PRIORITY", "TYPE_PUSH_PROMISE", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_WINDOW_UPDATE", "formatFlags", "type", "flags", "formattedType", "formattedType$okhttp", "frameLog", "inbound", "", "streamId", "length", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Http2 {
    @NotNull
    private static final String[] BINARY;
    @NotNull
    @JvmField
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    @NotNull
    private static final String[] FLAGS = new String[64];
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    @NotNull
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    @NotNull
    public static final Http2 INSTANCE = new Http2();
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        String[] strArr = new String[256];
        int i11 = 0;
        for (int i12 = 0; i12 < 256; i12++) {
            String binaryString = Integer.toBinaryString(i12);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(it)");
            strArr[i12] = StringsKt__StringsJVMKt.replace$default(Util.format("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = Intrinsics.stringPlus("END_STREAM", "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i13 = 0;
        while (i13 < 3) {
            int i14 = iArr2[i13];
            i13++;
            int i15 = iArr[0];
            String[] strArr3 = FLAGS;
            int i16 = i15 | i14;
            strArr3[i16] = strArr3[i15] + '|' + strArr3[i14];
            strArr3[i16 | 8] = strArr3[i15] + '|' + strArr3[i14] + "|PADDED";
        }
        int length = FLAGS.length;
        while (i11 < length) {
            int i17 = i11 + 1;
            String[] strArr4 = FLAGS;
            if (strArr4[i11] == null) {
                strArr4[i11] = BINARY[i11];
            }
            i11 = i17;
        }
    }

    private Http2() {
    }

    @NotNull
    public final String formatFlags(int i11, int i12) {
        String str;
        if (i12 == 0) {
            return "";
        }
        if (!(i11 == 2 || i11 == 3)) {
            if (i11 == 4 || i11 == 6) {
                if (i12 == 1) {
                    return "ACK";
                }
                return BINARY[i12];
            } else if (!(i11 == 7 || i11 == 8)) {
                String[] strArr = FLAGS;
                if (i12 < strArr.length) {
                    str = strArr[i12];
                    Intrinsics.checkNotNull(str);
                } else {
                    str = BINARY[i12];
                }
                String str2 = str;
                if (i11 == 5 && (i12 & 4) != 0) {
                    return StringsKt__StringsJVMKt.replace$default(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                }
                if (i11 != 0 || (i12 & 32) == 0) {
                    return str2;
                }
                return StringsKt__StringsJVMKt.replace$default(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
            }
        }
        return BINARY[i12];
    }

    @NotNull
    public final String formattedType$okhttp(int i11) {
        String[] strArr = FRAME_NAMES;
        if (i11 < strArr.length) {
            return strArr[i11];
        }
        return Util.format("0x%02x", Integer.valueOf(i11));
    }

    @NotNull
    public final String frameLog(boolean z11, int i11, int i12, int i13, int i14) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(i13);
        String formatFlags = formatFlags(i13, i14);
        if (z11) {
            str = "<<";
        } else {
            str = ">>";
        }
        return Util.format("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(i11), Integer.valueOf(i12), formattedType$okhttp, formatFlags);
    }
}
