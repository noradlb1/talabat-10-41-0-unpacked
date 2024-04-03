package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.internal._ByteStringKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ]2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001]B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0002J,\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0010H\u0010¢\u0006\u0002\b#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0000J\u0013\u0010'\u001a\u00020%2\b\u0010\u001a\u001a\u0004\u0018\u00010(H\u0002J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0002¢\u0006\u0002\b,J\u0015\u0010,\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0007¢\u0006\u0002\b-J\r\u0010.\u001a\u00020\tH\u0010¢\u0006\u0002\b/J\b\u0010\b\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\u001d\u00101\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0000H\u0010¢\u0006\u0002\b3J\u0010\u00104\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00106\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\r\u00109\u001a\u00020\u0004H\u0010¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\tH\u0010¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\u0006\u0010?\u001a\u00020\u0000J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bHJ\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0004J\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0000J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020MH\u0016J\u001c\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010P\u001a\u00020\tH\u0017J\b\u0010Q\u001a\u00020\u0000H\u0016J\b\u0010R\u001a\u00020\u0000H\u0016J\b\u0010S\u001a\u00020\u0004H\u0016J\b\u0010T\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020WH\u0016J%\u0010U\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0010¢\u0006\u0002\bZJ\u0010\u0010[\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\\H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006^"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "copyInto", "", "offset", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "otherOffset", "readObject", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class ByteString implements Serializable, Comparable<ByteString> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    @NotNull
    private final byte[] data;
    private transient int hashCode;
    @Nullable
    private transient String utf8;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007¢\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = 0;
            }
            if ((i13 & 2) != 0) {
                i12 = bArr.length;
            }
            return companion.of(bArr, i11, i12);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @Nullable
        @JvmName(name = "-deprecated_decodeBase64")
        /* renamed from: -deprecated_decodeBase64  reason: not valid java name */
        public final ByteString m8055deprecated_decodeBase64(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            return decodeBase64(str);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @JvmName(name = "-deprecated_decodeHex")
        /* renamed from: -deprecated_decodeHex  reason: not valid java name */
        public final ByteString m8056deprecated_decodeHex(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            return decodeHex(str);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @JvmName(name = "-deprecated_encodeString")
        /* renamed from: -deprecated_encodeString  reason: not valid java name */
        public final ByteString m8057deprecated_encodeString(@NotNull String str, @NotNull Charset charset) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            Intrinsics.checkNotNullParameter(charset, "charset");
            return encodeString(str, charset);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @JvmName(name = "-deprecated_encodeUtf8")
        /* renamed from: -deprecated_encodeUtf8  reason: not valid java name */
        public final ByteString m8058deprecated_encodeUtf8(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            return encodeUtf8(str);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m8059deprecated_of(@NotNull ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
            return of(byteBuffer);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @JvmName(name = "-deprecated_read")
        /* renamed from: -deprecated_read  reason: not valid java name */
        public final ByteString m8061deprecated_read(@NotNull InputStream inputStream, int i11) {
            Intrinsics.checkNotNullParameter(inputStream, "inputstream");
            return read(inputStream, i11);
        }

        @JvmStatic
        @Nullable
        public final ByteString decodeBase64(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final ByteString decodeHex(@NotNull String str) {
            boolean z11;
            Intrinsics.checkNotNullParameter(str, "<this>");
            int i11 = 0;
            if (str.length() % 2 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                int i12 = length - 1;
                if (i12 >= 0) {
                    while (true) {
                        int i13 = i11 + 1;
                        int i14 = i11 * 2;
                        bArr[i11] = (byte) ((_ByteStringKt.decodeHexDigit(str.charAt(i14)) << 4) + _ByteStringKt.decodeHexDigit(str.charAt(i14 + 1)));
                        if (i13 > i12) {
                            break;
                        }
                        i11 = i13;
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected hex string: ", str).toString());
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "encodeString")
        public final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @JvmStatic
        @NotNull
        public final ByteString encodeUtf8(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "of")
        public final ByteString of(@NotNull ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "read")
        public final ByteString read(@NotNull InputStream inputStream, int i11) throws IOException {
            boolean z11;
            Intrinsics.checkNotNullParameter(inputStream, "<this>");
            int i12 = 0;
            if (i11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                byte[] bArr = new byte[i11];
                while (i12 < i11) {
                    int read = inputStream.read(bArr, i12, i11 - i12);
                    if (read != -1) {
                        i12 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Integer.valueOf(i11)).toString());
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m8060deprecated_of(@NotNull byte[] bArr, int i11, int i12) {
            Intrinsics.checkNotNullParameter(bArr, "array");
            return of(bArr, i11, i12);
        }

        @JvmStatic
        @NotNull
        public final ByteString of(@NotNull byte... bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "of")
        public final ByteString of(@NotNull byte[] bArr, int i11, int i12) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i11, (long) i12);
            return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(bArr, i11, i12 + i11));
        }
    }

    public ByteString(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.data = bArr;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i11, byte[] bArr, int i12, int i13, int i14, Object obj) {
        if (obj == null) {
            if ((i14 & 1) != 0) {
                i11 = 0;
            }
            if ((i14 & 4) != 0) {
                i12 = 0;
            }
            byteString.copyInto(i11, bArr, i12, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
    }

    @JvmStatic
    @Nullable
    public static final ByteString decodeBase64(@NotNull String str) {
        return Companion.decodeBase64(str);
    }

    @JvmStatic
    @NotNull
    public static final ByteString decodeHex(@NotNull String str) {
        return Companion.decodeHex(str);
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "encodeString")
    public static final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @JvmStatic
    @NotNull
    public static final ByteString encodeUtf8(@NotNull String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            return byteString.indexOf(byteString2, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.lastIndexOf(byteString2, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "of")
    public static final ByteString of(@NotNull ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static final ByteString of(@NotNull byte... bArr) {
        return Companion.of(bArr);
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "of")
    public static final ByteString of(@NotNull byte[] bArr, int i11, int i12) {
        return Companion.of(bArr, i11, i12);
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "read")
    public static final ByteString read(@NotNull InputStream inputStream, int i11) throws IOException {
        return Companion.read(inputStream, i11);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i11, int i12, int i13, Object obj) {
        if (obj == null) {
            if ((i13 & 1) != 0) {
                i11 = 0;
            }
            if ((i13 & 2) != 0) {
                i12 = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.substring(i11, i12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m8053deprecated_getByte(int i11) {
        return getByte(i11);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m8054deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String base64() {
        return _Base64Kt.encodeBase64$default(getData$okio(), (byte[]) null, 1, (Object) null);
    }

    @NotNull
    public String base64Url() {
        return _Base64Kt.encodeBase64(getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public void copyInto(int i11, @NotNull byte[] bArr, int i12, int i13) {
        Intrinsics.checkNotNullParameter(bArr, "target");
        byte[] unused = ArraysKt___ArraysJvmKt.copyInto(getData$okio(), bArr, i12, i11, i13 + i11);
    }

    @NotNull
    public ByteString digest$okio(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(getData$okio(), 0, size());
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digestBytes");
        return new ByteString(digest);
    }

    public final boolean endsWith(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "suffix");
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int i11) {
        return internalGet$okio(i11);
    }

    @NotNull
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @Nullable
    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode2 = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode2);
        return hashCode2;
    }

    @NotNull
    public String hex() {
        char[] cArr = new char[(getData$okio().length * 2)];
        byte[] data$okio = getData$okio();
        int length = data$okio.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            byte b11 = data$okio[i11];
            i11++;
            int i13 = i12 + 1;
            cArr[i12] = _ByteStringKt.getHEX_DIGIT_CHARS()[(b11 >> 4) & 15];
            i12 = i13 + 1;
            cArr[i13] = _ByteStringKt.getHEX_DIGIT_CHARS()[b11 & Ascii.SI];
        }
        return StringsKt__StringsJVMKt.concatToString(cArr);
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String str, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(str, "algorithm");
        Intrinsics.checkNotNullParameter(byteString, "key");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            byte[] doFinal = instance.doFinal(this.data);
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac$okio("HmacSHA1", byteString);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac$okio("HmacSHA256", byteString);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac$okio("HmacSHA512", byteString);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString byteString, int i11) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return indexOf(byteString.internalArray$okio(), i11);
    }

    @JvmOverloads
    public final int indexOf(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i11) {
        return getData$okio()[i11];
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString byteString, int i11) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return lastIndexOf(byteString.internalArray$okio(), i11);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i11, @NotNull ByteString byteString, int i12, int i13) {
        Intrinsics.checkNotNullParameter(byteString, "other");
        return byteString.rangeEquals(i12, getData$okio(), i11, i13);
    }

    public final void setHashCode$okio(int i11) {
        this.hashCode = i11;
    }

    public final void setUtf8$okio(@Nullable String str) {
        this.utf8 = str;
    }

    @NotNull
    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest$okio(Constants.SHA256);
    }

    @NotNull
    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "prefix");
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(this.data, charset);
    }

    @NotNull
    @JvmOverloads
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ByteString substring(int i11) {
        return substring$default(this, i11, 0, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public ByteString substring(int i11, int i12) {
        boolean z11;
        boolean z12;
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, i12);
        boolean z13 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (resolveDefaultParameter <= getData$okio().length) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (resolveDefaultParameter - i11 < 0) {
                    z13 = false;
                }
                if (!z13) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i11 == 0 && resolveDefaultParameter == getData$okio().length) {
                    return this;
                } else {
                    return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(getData$okio(), i11, resolveDefaultParameter));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        byte b11;
        int i11 = 0;
        while (i11 < getData$okio().length) {
            byte b12 = getData$okio()[i11];
            byte b13 = (byte) 65;
            if (b12 < b13 || b12 > (b11 = (byte) 90)) {
                i11++;
            } else {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i11] = (byte) (b12 + 32);
                for (int i12 = i11 + 1; i12 < copyOf.length; i12++) {
                    byte b14 = copyOf[i12];
                    if (b14 >= b13 && b14 <= b11) {
                        copyOf[i12] = (byte) (b14 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        byte b11;
        int i11 = 0;
        while (i11 < getData$okio().length) {
            byte b12 = getData$okio()[i11];
            byte b13 = (byte) 97;
            if (b12 < b13 || b12 > (b11 = (byte) 122)) {
                i11++;
            } else {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i11] = (byte) (b12 - 32);
                for (int i12 = i11 + 1; i12 < copyOf.length; i12++) {
                    byte b14 = copyOf[i12];
                    if (b14 >= b13 && b14 <= b11) {
                        copyOf[i12] = (byte) (b14 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public String toString() {
        boolean z11;
        boolean z12;
        ByteString byteString;
        String str;
        boolean z13 = true;
        if (getData$okio().length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str = "[size=0]";
        } else {
            int access$codePointIndexToCharIndex = _ByteStringKt.codePointIndexToCharIndex(getData$okio(), 64);
            if (access$codePointIndexToCharIndex != -1) {
                String utf82 = utf8();
                if (utf82 != null) {
                    String substring = utf82.substring(0, access$codePointIndexToCharIndex);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), StringUtils.LF, "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null);
                    if (access$codePointIndexToCharIndex < utf82.length()) {
                        return "[size=" + getData$okio().length + " text=" + replace$default + "…]";
                    }
                    return "[text=" + replace$default + AbstractJsonLexerKt.END_LIST;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } else if (getData$okio().length <= 64) {
                str = "[hex=" + hex() + AbstractJsonLexerKt.END_LIST;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(getData$okio().length);
                sb2.append(" hex=");
                int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, 64);
                if (resolveDefaultParameter <= getData$okio().length) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (resolveDefaultParameter + 0 < 0) {
                        z13 = false;
                    }
                    if (z13) {
                        if (resolveDefaultParameter == getData$okio().length) {
                            byteString = this;
                        } else {
                            byteString = new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(getData$okio(), 0, resolveDefaultParameter));
                        }
                        sb2.append(byteString.hex());
                        sb2.append("…]");
                        return sb2.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
        }
        return str;
    }

    @NotNull
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        outputStream.write(this.data);
    }

    public void write$okio(@NotNull Buffer buffer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        _ByteStringKt.commonWrite(this, buffer, i11, i12);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            return byteString.indexOf(bArr, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (r7 < r8) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (r0 < r1) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(@org.jetbrains.annotations.NotNull okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L_0x0013:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x002b
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0028
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0028:
            if (r7 >= r8) goto L_0x0032
            goto L_0x0030
        L_0x002b:
            if (r0 != r1) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            if (r0 >= r1) goto L_0x0032
        L_0x0030:
            r3 = r5
            goto L_0x0033
        L_0x0032:
            r3 = r6
        L_0x0033:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "suffix");
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] bArr, int i11) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        int length = getData$okio().length - bArr.length;
        int max = Math.max(i11, 0);
        if (max <= length) {
            while (true) {
                int i12 = max + 1;
                if (_UtilKt.arrayRangeEquals(getData$okio(), max, bArr, 0, bArr.length)) {
                    return max;
                }
                if (max == length) {
                    break;
                }
                max = i12;
            }
        }
        return -1;
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] bArr, int i11) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        int min = Math.min(_UtilKt.resolveDefaultParameter(this, i11), getData$okio().length - bArr.length);
        if (min >= 0) {
            while (true) {
                int i12 = min - 1;
                if (_UtilKt.arrayRangeEquals(getData$okio(), min, bArr, 0, bArr.length)) {
                    return min;
                }
                if (i12 < 0) {
                    break;
                }
                min = i12;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i11, @NotNull byte[] bArr, int i12, int i13) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        return i11 >= 0 && i11 <= getData$okio().length - i13 && i12 >= 0 && i12 <= bArr.length - i13 && _UtilKt.arrayRangeEquals(getData$okio(), i11, bArr, i12, i13);
    }

    public final boolean startsWith(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "prefix");
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.lastIndexOf(bArr, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }
}
