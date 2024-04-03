package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0000\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\u001a \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0016\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0000¨\u0006\u0019"}, d2 = {"InvalidFloatingPointDecoded", "Lkotlinx/serialization/json/internal/JsonDecodingException;", "value", "", "key", "", "output", "InvalidFloatingPointEncoded", "Lkotlinx/serialization/json/internal/JsonEncodingException;", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "JsonDecodingException", "offset", "", "message", "input", "", "UnknownKeyException", "unexpectedFpErrorMessage", "minify", "throwInvalidFloatingPointDecoded", "", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "result", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class JsonExceptionsKt {
    @NotNull
    public static final JsonDecodingException InvalidFloatingPointDecoded(@NotNull Number number, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "output");
        return JsonDecodingException(-1, unexpectedFpErrorMessage(number, str, str2));
    }

    @NotNull
    public static final JsonEncodingException InvalidFloatingPointEncoded(@NotNull Number number, @NotNull String str) {
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(str, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + a(str, 0, 1, (Object) null));
    }

    @NotNull
    public static final JsonEncodingException InvalidKeyKindException(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + serialDescriptor.getSerialName() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + serialDescriptor.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    @NotNull
    public static final JsonDecodingException JsonDecodingException(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (i11 >= 0) {
            str = "Unexpected JSON token at offset " + i11 + ": " + str;
        }
        return new JsonDecodingException(str);
    }

    @NotNull
    public static final JsonDecodingException UnknownKeyException(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "input");
        return JsonDecodingException(-1, "Encountered unknown key '" + str + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + a(str2, 0, 1, (Object) null));
    }

    public static /* synthetic */ CharSequence a(CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = -1;
        }
        return minify(charSequence, i11);
    }

    private static final CharSequence minify(CharSequence charSequence, int i11) {
        String str;
        if (charSequence.length() < 200) {
            return charSequence;
        }
        String str2 = ".....";
        if (i11 == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return str2 + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i12 = i11 - 30;
        int i13 = i11 + 30;
        if (i12 <= 0) {
            str = "";
        } else {
            str = str2;
        }
        if (i13 >= charSequence.length()) {
            str2 = "";
        }
        return str + charSequence.subSequence(RangesKt___RangesKt.coerceAtLeast(i12, 0), RangesKt___RangesKt.coerceAtMost(i13, charSequence.length())).toString() + str2;
    }

    @NotNull
    public static final Void throwInvalidFloatingPointDecoded(@NotNull AbstractJsonLexer abstractJsonLexer, @NotNull Number number) {
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "<this>");
        Intrinsics.checkNotNullParameter(number, "result");
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, AbstractJsonLexerKt.specialFlowingValuesHint, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private static final String unexpectedFpErrorMessage(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + a(str2, 0, 1, (Object) null);
    }

    @NotNull
    public static final JsonDecodingException JsonDecodingException(int i11, @NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        return JsonDecodingException(i11, str + "\nJSON input: " + minify(charSequence, i11));
    }

    @NotNull
    public static final JsonEncodingException InvalidFloatingPointEncoded(@NotNull Number number, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "output");
        return new JsonEncodingException(unexpectedFpErrorMessage(number, str, str2));
    }
}
