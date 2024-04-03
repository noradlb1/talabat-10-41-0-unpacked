package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0010\u001a\u00020\u000e8\u0014X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "position", "prefetchOrEof", "", "consumeNextToken", "", "tryConsumeComma", "canConsumeValue", "skipWhitespaces", "", "expected", "", "", "consumeKeyString", "source", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
public final class StringJsonLexer extends AbstractJsonLexer {
    @NotNull
    private final String source;

    public StringJsonLexer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.source = str;
    }

    public boolean canConsumeValue() {
        int i11 = this.f26436a;
        if (i11 == -1) {
            return false;
        }
        while (i11 < getSource().length()) {
            char charAt = getSource().charAt(i11);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i11++;
            } else {
                this.f26436a = i11;
                return d(charAt);
            }
        }
        this.f26436a = i11;
        return false;
    }

    @NotNull
    public String consumeKeyString() {
        consumeNextToken('\"');
        int i11 = this.f26436a;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) getSource(), '\"', i11, false, 4, (Object) null);
        if (indexOf$default != -1) {
            for (int i12 = i11; i12 < indexOf$default; i12++) {
                if (getSource().charAt(i12) == '\\') {
                    return b(getSource(), this.f26436a, i12);
                }
            }
            this.f26436a = indexOf$default + 1;
            String substring = getSource().substring(i11, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        fail$kotlinx_serialization_json((byte) 1);
        throw new KotlinNothingValueException();
    }

    public byte consumeNextToken() {
        byte charToTokenClass;
        String f11 = getSource();
        do {
            int i11 = this.f26436a;
            if (i11 == -1 || i11 >= f11.length()) {
                return 10;
            }
            int i12 = this.f26436a;
            this.f26436a = i12 + 1;
            charToTokenClass = AbstractJsonLexerKt.charToTokenClass(f11.charAt(i12));
        } while (charToTokenClass == 3);
        return charToTokenClass;
    }

    @NotNull
    /* renamed from: f */
    public String getSource() {
        return this.source;
    }

    public int prefetchOrEof(int i11) {
        if (i11 < getSource().length()) {
            return i11;
        }
        return -1;
    }

    public int skipWhitespaces() {
        int i11 = this.f26436a;
        if (i11 == -1) {
            return i11;
        }
        while (i11 < getSource().length() && ((r1 = getSource().charAt(i11)) == ' ' || r1 == 10 || r1 == 13 || r1 == 9)) {
            i11++;
        }
        this.f26436a = i11;
        return i11;
    }

    public boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces == getSource().length() || skipWhitespaces == -1 || getSource().charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.f26436a++;
        return true;
    }

    public void consumeNextToken(char c11) {
        if (this.f26436a == -1) {
            e(c11);
        }
        String f11 = getSource();
        while (this.f26436a < f11.length()) {
            int i11 = this.f26436a;
            this.f26436a = i11 + 1;
            char charAt = f11.charAt(i11);
            if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                if (charAt != c11) {
                    e(c11);
                } else {
                    return;
                }
            }
        }
        e(c11);
    }
}
