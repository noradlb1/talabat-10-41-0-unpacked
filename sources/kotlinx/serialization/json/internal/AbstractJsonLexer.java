package kotlinx.serialization.json.internal;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bZ\u0010[J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0002H\u0003J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0006\u0010\u0019\u001a\u00020\nJ\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H&J\b\u0010\u001c\u001a\u00020\nH&J\b\u0010\u001d\u001a\u00020\nH&J\b\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H\u0004J\u0006\u0010#\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010$\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010$\u001a\u00020 H\u0004J\u0017\u0010*\u001a\u00020'2\u0006\u0010&\u001a\u00020\u001eH\u0000¢\u0006\u0004\b(\u0010)J\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010,\u001a\u00020\nJ\b\u0010-\u001a\u00020\u0002H\u0016J\u0010\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020\nJ\u0018\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u00103\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0002H\u0016J\b\u00104\u001a\u00020\u0007H&J\u0006\u00105\u001a\u00020\u0007J \u00106\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0005J\u0006\u00107\u001a\u00020\u0007J\u0006\u00108\u001a\u00020\u0007J\u0018\u0010;\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u0002H\u0014J3\u0010A\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070=H\bø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u000e\u0010C\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\nJ\b\u0010D\u001a\u00020\u0007H\u0016J\u000e\u0010F\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\u0007J\"\u0010*\u001a\u00020'2\u0006\u0010>\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010G\u001a\u00020\u0007J\u0006\u0010I\u001a\u00020HJ\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010J\u001a\u00020\nR\u0016\u0010\u0006\u001a\u00020\u00028\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b;\u0010KR\u0014\u0010M\u001a\u00020L8\u0006X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR&\u0010S\u001a\u00060Qj\u0002`R8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\b!\u0010U\"\u0004\bV\u0010WR\u0014\u0010\u000f\u001a\u00020\u000e8$X¤\u0004¢\u0006\u0006\u001a\u0004\bX\u0010Y\u0002\u0007\n\u0005\b20\u0001¨\u0006\\"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "", "lastPosition", "current", "appendEscape", "currentPosition", "", "decodedString", "takePeeked", "", "wasUnquotedString", "startPosition", "appendEsc", "", "source", "startPos", "appendHex", "fromHexChar", "start", "consumeBoolean", "literalSuffix", "", "consumeBooleanLiteral", "ensureHaveChars", "isNotEof", "position", "prefetchOrEof", "tryConsumeComma", "canConsumeValue", "", "consumeNextToken", "", "c", "d", "expectEof", "expected", "e", "expectedToken", "", "fail$kotlinx_serialization_json", "(B)Ljava/lang/Void;", "fail", "peekNextToken", "tryConsumeNotNull", "skipWhitespaces", "isLenient", "peekString", "char", "indexOf", "endPos", "substring", "consumeKeyString", "consumeString", "b", "consumeStringLenientNotNull", "consumeStringLenient", "fromIndex", "toIndex", "a", "condition", "Lkotlin/Function0;", "message", "require$kotlinx_serialization_json", "(ZILkotlin/jvm/functions/Function0;)V", "require", "allowLenientStrings", "skipElement", "toString", "key", "failOnUnknownKey", "hint", "", "consumeNumericLiteral", "consumeBooleanLenient", "I", "Lkotlinx/serialization/json/internal/JsonPath;", "path", "Lkotlinx/serialization/json/internal/JsonPath;", "peekedString", "Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "escapedString", "Ljava/lang/StringBuilder;", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "getSource", "()Ljava/lang/CharSequence;", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
public abstract class AbstractJsonLexer {
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public int f26436a;
    @NotNull
    private StringBuilder escapedString = new StringBuilder();
    @NotNull
    @JvmField
    public final JsonPath path = new JsonPath();
    @Nullable
    private String peekedString;

    private final int appendEsc(int i11) {
        int prefetchOrEof = prefetchOrEof(i11);
        if (prefetchOrEof != -1) {
            int i12 = prefetchOrEof + 1;
            char charAt = getSource().charAt(prefetchOrEof);
            if (charAt == 'u') {
                return appendHex(getSource(), i12);
            }
            char escapeToChar = AbstractJsonLexerKt.escapeToChar(charAt);
            if (escapeToChar != 0) {
                this.escapedString.append(escapeToChar);
                return i12;
            }
            fail$default(this, "Invalid escaped char '" + charAt + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        fail$default(this, "Expected escape sequence to continue, got EOF", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final int appendEscape(int i11, int i12) {
        a(i11, i12);
        return appendEsc(i12 + 1);
    }

    private final int appendHex(CharSequence charSequence, int i11) {
        int i12 = i11 + 4;
        if (i12 >= charSequence.length()) {
            this.f26436a = i11;
            ensureHaveChars();
            if (this.f26436a + 4 < charSequence.length()) {
                return appendHex(charSequence, this.f26436a);
            }
            fail$default(this, "Unexpected EOF during unicode escape", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        this.escapedString.append((char) ((fromHexChar(charSequence, i11) << 12) + (fromHexChar(charSequence, i11 + 1) << 8) + (fromHexChar(charSequence, i11 + 2) << 4) + fromHexChar(charSequence, i11 + 3)));
        return i12;
    }

    private final void consumeBooleanLiteral(String str, int i11) {
        if (getSource().length() - i11 >= str.length()) {
            int length = str.length();
            int i12 = 0;
            while (i12 < length) {
                if (str.charAt(i12) == (getSource().charAt(i11 + i12) | ' ')) {
                    i12++;
                } else {
                    fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            this.f26436a = i11 + str.length();
            return;
        }
        fail$default(this, "Unexpected end of boolean literal", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final String decodedString(int i11, int i12) {
        a(i11, i12);
        String sb2 = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "escapedString.toString()");
        this.escapedString.setLength(0);
        return sb2;
    }

    public static /* synthetic */ Void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i11, String str2, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = abstractJsonLexer.f26436a;
            }
            if ((i12 & 4) != 0) {
                str2 = "";
            }
            return abstractJsonLexer.fail(str, i11, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    private final int fromHexChar(CharSequence charSequence, int i11) {
        boolean z11;
        boolean z12;
        char charAt = charSequence.charAt(i11);
        boolean z13 = true;
        if ('0' > charAt || charAt >= ':') {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return charAt - '0';
        }
        char c11 = 'a';
        if ('a' > charAt || charAt >= 'g') {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z12) {
            c11 = 'A';
            if ('A' > charAt || charAt >= 'G') {
                z13 = false;
            }
            if (!z13) {
                fail$default(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        return (charAt - c11) + 10;
    }

    public static /* synthetic */ void require$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer, boolean z11, int i11, Function0 function0, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = abstractJsonLexer.f26436a;
            }
            int i13 = i11;
            Intrinsics.checkNotNullParameter(function0, "message");
            if (!z11) {
                fail$default(abstractJsonLexer, (String) function0.invoke(), i13, (String) null, 4, (Object) null);
                throw new KotlinNothingValueException();
            }
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: require");
    }

    private final String takePeeked() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.f26436a - 1) != '\"';
    }

    public void a(int i11, int i12) {
        this.escapedString.append(getSource(), i11, i12);
    }

    @NotNull
    public final String b(@NotNull CharSequence charSequence, int i11, int i12) {
        String str;
        int prefetchOrEof;
        Intrinsics.checkNotNullParameter(charSequence, "source");
        char charAt = charSequence.charAt(i12);
        boolean z11 = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                prefetchOrEof = prefetchOrEof(appendEscape(i11, i12));
                if (prefetchOrEof == -1) {
                    fail$default(this, "EOF", prefetchOrEof, (String) null, 4, (Object) null);
                    throw new KotlinNothingValueException();
                }
            } else {
                i12++;
                if (i12 >= charSequence.length()) {
                    a(i11, i12);
                    prefetchOrEof = prefetchOrEof(i12);
                    if (prefetchOrEof == -1) {
                        fail$default(this, "EOF", prefetchOrEof, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = charSequence.charAt(i12);
                }
            }
            z11 = true;
            i11 = prefetchOrEof;
            i12 = i11;
            charAt = charSequence.charAt(i12);
        }
        if (!z11) {
            str = substring(i11, i12);
        } else {
            str = decodedString(i11, i12);
        }
        this.f26436a = i12 + 1;
        return str;
    }

    @NotNull
    public final StringBuilder c() {
        return this.escapedString;
    }

    public abstract boolean canConsumeValue();

    public final boolean consumeBoolean() {
        return consumeBoolean(skipWhitespaces());
    }

    public final boolean consumeBooleanLenient() {
        boolean z11;
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces != getSource().length()) {
            if (getSource().charAt(skipWhitespaces) == '\"') {
                skipWhitespaces++;
                z11 = true;
            } else {
                z11 = false;
            }
            boolean consumeBoolean = consumeBoolean(skipWhitespaces);
            if (z11) {
                if (this.f26436a == getSource().length()) {
                    fail$default(this, "EOF", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                } else if (getSource().charAt(this.f26436a) == '\"') {
                    this.f26436a++;
                } else {
                    fail$default(this, "Expected closing quotation mark", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            return consumeBoolean;
        }
        fail$default(this, "EOF", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    @NotNull
    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public final byte consumeNextToken(byte b11) {
        byte consumeNextToken = consumeNextToken();
        if (consumeNextToken == b11) {
            return consumeNextToken;
        }
        fail$kotlinx_serialization_json(b11);
        throw new KotlinNothingValueException();
    }

    public final long consumeNumericLiteral() {
        boolean z11;
        boolean z12;
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        if (prefetchOrEof >= getSource().length() || prefetchOrEof == -1) {
            fail$default(this, "EOF", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(prefetchOrEof) == '\"') {
            prefetchOrEof++;
            if (prefetchOrEof != getSource().length()) {
                z11 = true;
            } else {
                fail$default(this, "EOF", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        } else {
            z11 = false;
        }
        int i11 = prefetchOrEof;
        long j11 = 0;
        boolean z13 = true;
        boolean z14 = false;
        while (z13) {
            char charAt = getSource().charAt(i11);
            if (charAt != '-') {
                if (AbstractJsonLexerKt.charToTokenClass(charAt) != 0) {
                    break;
                }
                i11++;
                if (i11 != getSource().length()) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                int i12 = charAt - '0';
                if (i12 < 0 || i12 >= 10) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12) {
                    j11 = (j11 * ((long) 10)) - ((long) i12);
                    if (j11 > 0) {
                        fail$default(this, "Numeric value overflow", 0, (String) null, 6, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    fail$default(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            } else if (i11 == prefetchOrEof) {
                i11++;
                z14 = true;
            } else {
                fail$default(this, "Unexpected symbol '-' in numeric literal", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        if (prefetchOrEof == i11 || (z14 && prefetchOrEof == i11 - 1)) {
            fail$default(this, "Expected numeric literal", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        if (z11) {
            if (!z13) {
                fail$default(this, "EOF", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            } else if (getSource().charAt(i11) == '\"') {
                i11++;
            } else {
                fail$default(this, "Expected closing quotation mark", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        this.f26436a = i11;
        if (z14) {
            return j11;
        }
        if (j11 != Long.MIN_VALUE) {
            return -j11;
        }
        fail$default(this, "Numeric value overflow", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    @NotNull
    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }

    @NotNull
    public final String consumeStringLenient() {
        String str;
        if (this.peekedString != null) {
            return takePeeked();
        }
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1) {
            fail$default(this, "EOF", skipWhitespaces, (String) null, 4, (Object) null);
            throw new KotlinNothingValueException();
        }
        byte charToTokenClass = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces));
        if (charToTokenClass == 1) {
            return consumeString();
        }
        if (charToTokenClass == 0) {
            boolean z11 = false;
            while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces)) == 0) {
                skipWhitespaces++;
                if (skipWhitespaces >= getSource().length()) {
                    a(this.f26436a, skipWhitespaces);
                    int prefetchOrEof = prefetchOrEof(skipWhitespaces);
                    if (prefetchOrEof == -1) {
                        this.f26436a = skipWhitespaces;
                        return decodedString(0, 0);
                    }
                    skipWhitespaces = prefetchOrEof;
                    z11 = true;
                }
            }
            if (!z11) {
                str = substring(this.f26436a, skipWhitespaces);
            } else {
                str = decodedString(this.f26436a, skipWhitespaces);
            }
            this.f26436a = skipWhitespaces;
            return str;
        }
        fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(skipWhitespaces), 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    @NotNull
    public final String consumeStringLenientNotNull() {
        String consumeStringLenient = consumeStringLenient();
        if (!Intrinsics.areEqual((Object) consumeStringLenient, (Object) "null") || !wasUnquotedString()) {
            return consumeStringLenient;
        }
        fail$default(this, "Unexpected 'null' value instead of string literal", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final boolean d(char c11) {
        boolean z11 = false;
        if (((c11 == '}' || c11 == ']') || c11 == ':') || c11 == ',') {
            z11 = true;
        }
        return !z11;
    }

    public final void e(char c11) {
        int i11 = this.f26436a - 1;
        this.f26436a = i11;
        if (i11 < 0 || c11 != '\"' || !Intrinsics.areEqual((Object) consumeStringLenient(), (Object) "null")) {
            fail$kotlinx_serialization_json(AbstractJsonLexerKt.charToTokenClass(c11));
            throw new KotlinNothingValueException();
        } else {
            fail("Expected string literal but 'null' literal was found", this.f26436a - 4, AbstractJsonLexerKt.coerceInputValuesHint);
            throw new KotlinNothingValueException();
        }
    }

    public void ensureHaveChars() {
    }

    public final void expectEof() {
        if (consumeNextToken() != 10) {
            fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.f26436a - 1) + " instead", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    @NotNull
    public final Void fail(@NotNull String str, int i11, @NotNull String str2) {
        boolean z11;
        String str3;
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, ViewHierarchyConstants.HINT_KEY);
        if (str2.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str3 = "";
        } else {
            str3 = 10 + str2;
        }
        throw JsonExceptionsKt.JsonDecodingException(i11, str + " at path: " + this.path.getPath() + str3, getSource());
    }

    @NotNull
    public final Void fail$kotlinx_serialization_json(byte b11) {
        String str;
        String str2;
        if (b11 == 1) {
            str = "quotation mark '\"'";
        } else if (b11 == 4) {
            str = "comma ','";
        } else if (b11 == 5) {
            str = "semicolon ':'";
        } else if (b11 == 6) {
            str = "start of the object '{'";
        } else if (b11 == 7) {
            str = "end of the object '}'";
        } else if (b11 == 8) {
            str = "start of the array '['";
        } else if (b11 == 9) {
            str = "end of the array ']'";
        } else {
            str = "valid token";
        }
        if (this.f26436a == getSource().length() || this.f26436a <= 0) {
            str2 = "EOF";
        } else {
            str2 = String.valueOf(getSource().charAt(this.f26436a - 1));
        }
        fail$default(this, "Expected " + str + ", but had '" + str2 + "' instead", this.f26436a - 1, (String) null, 4, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final void failOnUnknownKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) substring(0, this.f26436a), str, 0, false, 6, (Object) null);
        fail("Encountered an unknown key '" + str + '\'', lastIndexOf$default, AbstractJsonLexerKt.ignoreUnknownKeysHint);
        throw new KotlinNothingValueException();
    }

    @NotNull
    public abstract CharSequence getSource();

    public int indexOf(char c11, int i11) {
        return StringsKt__StringsKt.indexOf$default(getSource(), c11, i11, false, 4, (Object) null);
    }

    public final boolean isNotEof() {
        return peekNextToken() != 10;
    }

    public final byte peekNextToken() {
        CharSequence source = getSource();
        int i11 = this.f26436a;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i11);
            if (prefetchOrEof != -1) {
                char charAt = source.charAt(prefetchOrEof);
                if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                    i11 = prefetchOrEof + 1;
                } else {
                    this.f26436a = prefetchOrEof;
                    return AbstractJsonLexerKt.charToTokenClass(charAt);
                }
            } else {
                this.f26436a = prefetchOrEof;
                return 10;
            }
        }
    }

    @Nullable
    public final String peekString(boolean z11) {
        String str;
        byte peekNextToken = peekNextToken();
        if (z11) {
            if (peekNextToken != 1 && peekNextToken != 0) {
                return null;
            }
            str = consumeStringLenient();
        } else if (peekNextToken != 1) {
            return null;
        } else {
            str = consumeString();
        }
        this.peekedString = str;
        return str;
    }

    public abstract int prefetchOrEof(int i11);

    public final void require$kotlinx_serialization_json(boolean z11, int i11, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "message");
        if (!z11) {
            fail$default(this, function0.invoke(), i11, (String) null, 4, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final void skipElement(boolean z11) {
        ArrayList arrayList = new ArrayList();
        byte peekNextToken = peekNextToken();
        if (peekNextToken == 8 || peekNextToken == 6) {
            while (true) {
                byte peekNextToken2 = peekNextToken();
                boolean z12 = true;
                if (peekNextToken2 != 1) {
                    if (!(peekNextToken2 == 8 || peekNextToken2 == 6)) {
                        z12 = false;
                    }
                    if (z12) {
                        arrayList.add(Byte.valueOf(peekNextToken2));
                    } else if (peekNextToken2 == 9) {
                        if (((Number) CollectionsKt___CollectionsKt.last(arrayList)).byteValue() == 8) {
                            Object unused = CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                        } else {
                            int i11 = this.f26436a;
                            throw JsonExceptionsKt.JsonDecodingException(i11, "found ] instead of } at path: " + this.path, getSource());
                        }
                    } else if (peekNextToken2 == 7) {
                        if (((Number) CollectionsKt___CollectionsKt.last(arrayList)).byteValue() == 6) {
                            Object unused2 = CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                        } else {
                            int i12 = this.f26436a;
                            throw JsonExceptionsKt.JsonDecodingException(i12, "found } instead of ] at path: " + this.path, getSource());
                        }
                    } else if (peekNextToken2 == 10) {
                        fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, (String) null, 6, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                    consumeNextToken();
                    if (arrayList.size() == 0) {
                        return;
                    }
                } else if (z11) {
                    consumeStringLenient();
                } else {
                    consumeKeyString();
                }
            }
        } else {
            consumeStringLenient();
        }
    }

    public int skipWhitespaces() {
        int prefetchOrEof;
        char charAt;
        int i11 = this.f26436a;
        while (true) {
            prefetchOrEof = prefetchOrEof(i11);
            if (prefetchOrEof == -1 || !((charAt = getSource().charAt(prefetchOrEof)) == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                this.f26436a = prefetchOrEof;
            } else {
                i11 = prefetchOrEof + 1;
            }
        }
        this.f26436a = prefetchOrEof;
        return prefetchOrEof;
    }

    @NotNull
    public String substring(int i11, int i12) {
        return getSource().subSequence(i11, i12).toString();
    }

    @NotNull
    public String toString() {
        return "JsonReader(source='" + getSource() + "', currentPosition=" + this.f26436a + ')';
    }

    public abstract boolean tryConsumeComma();

    public final boolean tryConsumeNotNull() {
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        int length = getSource().length() - prefetchOrEof;
        if (length < 4 || prefetchOrEof == -1) {
            return true;
        }
        for (int i11 = 0; i11 < 4; i11++) {
            if ("null".charAt(i11) != getSource().charAt(prefetchOrEof + i11)) {
                return true;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.charToTokenClass(getSource().charAt(prefetchOrEof + 4)) == 0) {
            return true;
        }
        this.f26436a = prefetchOrEof + 4;
        return false;
    }

    private final boolean consumeBoolean(int i11) {
        int prefetchOrEof = prefetchOrEof(i11);
        if (prefetchOrEof >= getSource().length() || prefetchOrEof == -1) {
            fail$default(this, "EOF", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        int i12 = prefetchOrEof + 1;
        char charAt = getSource().charAt(prefetchOrEof) | ' ';
        if (charAt == 't') {
            consumeBooleanLiteral("rue", i12);
            return true;
        } else if (charAt == 'f') {
            consumeBooleanLiteral("alse", i12);
            return false;
        } else {
            fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public void consumeNextToken(char c11) {
        ensureHaveChars();
        CharSequence source = getSource();
        int i11 = this.f26436a;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i11);
            if (prefetchOrEof != -1) {
                int i12 = prefetchOrEof + 1;
                char charAt = source.charAt(prefetchOrEof);
                if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                    this.f26436a = i12;
                    if (charAt != c11) {
                        e(c11);
                    } else {
                        return;
                    }
                }
                i11 = i12;
            } else {
                this.f26436a = prefetchOrEof;
                e(c11);
                return;
            }
        }
    }
}
