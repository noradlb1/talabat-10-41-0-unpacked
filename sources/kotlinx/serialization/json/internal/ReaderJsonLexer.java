package kotlinx.serialization.json.internal;

import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b)\u0010*B\u001b\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010.\u001a\u00020-¢\u0006\u0004\b)\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0014R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R*\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8\u0014@VX\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00060"}, d2 = {"Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "spaceLeft", "", "preload", "", "tryConsumeComma", "canConsumeValue", "position", "prefetchOrEof", "", "consumeNextToken", "ensureHaveChars", "", "consumeKeyString", "", "char", "startPos", "indexOf", "endPos", "substring", "fromIndex", "toIndex", "a", "Ljava/io/Reader;", "reader", "Ljava/io/Reader;", "", "_source", "[C", "threshold", "I", "", "<set-?>", "source", "Ljava/lang/CharSequence;", "getSource", "()Ljava/lang/CharSequence;", "setSource", "(Ljava/lang/CharSequence;)V", "<init>", "(Ljava/io/Reader;[C)V", "Ljava/io/InputStream;", "i", "Ljava/nio/charset/Charset;", "charset", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
public final class ReaderJsonLexer extends AbstractJsonLexer {
    @NotNull
    private char[] _source;
    @NotNull
    private final Reader reader;
    @NotNull
    private CharSequence source;
    private int threshold;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReaderJsonLexer(Reader reader2, char[] cArr, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(reader2, (i11 & 2) != 0 ? new char[16384] : cArr);
    }

    private final void preload(int i11) {
        char[] cArr = this._source;
        System.arraycopy(cArr, this.f26436a, cArr, 0, i11);
        int length = this._source.length;
        while (true) {
            if (i11 == length) {
                break;
            }
            int read = this.reader.read(cArr, i11, length - i11);
            if (read == -1) {
                char[] copyOf = Arrays.copyOf(this._source, i11);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this._source = copyOf;
                setSource(new ArrayAsSequence(copyOf));
                this.threshold = -1;
                break;
            }
            i11 += read;
        }
        this.f26436a = 0;
    }

    public void a(int i11, int i12) {
        c().append(this._source, i11, i12 - i11);
    }

    public boolean canConsumeValue() {
        ensureHaveChars();
        int i11 = this.f26436a;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i11);
            if (prefetchOrEof != -1) {
                char charAt = getSource().charAt(prefetchOrEof);
                if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                    i11 = prefetchOrEof + 1;
                } else {
                    this.f26436a = prefetchOrEof;
                    return d(charAt);
                }
            } else {
                this.f26436a = prefetchOrEof;
                return false;
            }
        }
    }

    @NotNull
    public String consumeKeyString() {
        consumeNextToken('\"');
        int i11 = this.f26436a;
        int indexOf = indexOf('\"', i11);
        if (indexOf == -1) {
            int prefetchOrEof = prefetchOrEof(i11);
            if (prefetchOrEof != -1) {
                return b(getSource(), this.f26436a, prefetchOrEof);
            }
            fail$kotlinx_serialization_json((byte) 1);
            throw new KotlinNothingValueException();
        }
        for (int i12 = i11; i12 < indexOf; i12++) {
            if (getSource().charAt(i12) == '\\') {
                return b(getSource(), this.f26436a, i12);
            }
        }
        this.f26436a = indexOf + 1;
        return substring(i11, indexOf);
    }

    public byte consumeNextToken() {
        ensureHaveChars();
        CharSequence source2 = getSource();
        int i11 = this.f26436a;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i11);
            if (prefetchOrEof != -1) {
                int i12 = prefetchOrEof + 1;
                byte charToTokenClass = AbstractJsonLexerKt.charToTokenClass(source2.charAt(prefetchOrEof));
                if (charToTokenClass != 3) {
                    this.f26436a = i12;
                    return charToTokenClass;
                }
                i11 = i12;
            } else {
                this.f26436a = prefetchOrEof;
                return 10;
            }
        }
    }

    public void ensureHaveChars() {
        int length = this._source.length - this.f26436a;
        if (length <= this.threshold) {
            preload(length);
        }
    }

    @NotNull
    public CharSequence getSource() {
        return this.source;
    }

    public int indexOf(char c11, int i11) {
        char[] cArr = this._source;
        int length = cArr.length;
        while (i11 < length) {
            if (cArr[i11] == c11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public int prefetchOrEof(int i11) {
        boolean z11;
        if (i11 < getSource().length()) {
            return i11;
        }
        this.f26436a = i11;
        ensureHaveChars();
        if (this.f26436a != 0) {
            return -1;
        }
        if (getSource().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return -1;
        }
        return 0;
    }

    public void setSource(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.source = charSequence;
    }

    @NotNull
    public String substring(int i11, int i12) {
        return new String(this._source, i11, i12 - i11);
    }

    public boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1 || getSource().charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.f26436a++;
        return true;
    }

    public ReaderJsonLexer(@NotNull Reader reader2, @NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(reader2, "reader");
        Intrinsics.checkNotNullParameter(cArr, "_source");
        this.reader = reader2;
        this._source = cArr;
        this.threshold = 128;
        this.source = new ArrayAsSequence(cArr);
        preload(0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReaderJsonLexer(@org.jetbrains.annotations.NotNull java.io.InputStream r2, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r3) {
        /*
            r1 = this;
            java.lang.String r0 = "i"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r2, r3)
            boolean r2 = r0 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x0016
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x001e
        L_0x0016:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r3 = 262144(0x40000, float:3.67342E-40)
            r2.<init>(r0, r3)
            r0 = r2
        L_0x001e:
            r2 = 2
            r3 = 0
            r1.<init>((java.io.Reader) r0, (char[]) r3, (int) r2, (kotlin.jvm.internal.DefaultConstructorMarker) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.ReaderJsonLexer.<init>(java.io.InputStream, java.nio.charset.Charset):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReaderJsonLexer(InputStream inputStream, Charset charset, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputStream, (i11 & 2) != 0 ? Charsets.UTF_8 : charset);
    }
}
