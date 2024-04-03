package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/internal/CharMappings;", "", "()V", "CHAR_TO_TOKEN", "", "ESCAPE_2_CHAR", "", "initC2ESC", "", "c", "", "esc", "", "initC2TC", "cl", "", "initCharToToken", "initEscape", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CharMappings {
    @NotNull
    @JvmField
    public static final byte[] CHAR_TO_TOKEN = new byte[126];
    @NotNull
    @JvmField
    public static final char[] ESCAPE_2_CHAR = new char[117];
    @NotNull
    public static final CharMappings INSTANCE;

    static {
        CharMappings charMappings = new CharMappings();
        INSTANCE = charMappings;
        charMappings.initEscape();
        charMappings.initCharToToken();
    }

    private CharMappings() {
    }

    private final void initC2ESC(int i11, char c11) {
        if (c11 != 'u') {
            ESCAPE_2_CHAR[c11] = (char) i11;
        }
    }

    private final void initC2TC(int i11, byte b11) {
        CHAR_TO_TOKEN[i11] = b11;
    }

    private final void initCharToToken() {
        for (int i11 = 0; i11 < 33; i11++) {
            initC2TC(i11, Byte.MAX_VALUE);
        }
        initC2TC(9, (byte) 3);
        initC2TC(10, (byte) 3);
        initC2TC(13, (byte) 3);
        initC2TC(32, (byte) 3);
        initC2TC((char) AbstractJsonLexerKt.COMMA, (byte) 4);
        initC2TC((char) AbstractJsonLexerKt.COLON, (byte) 5);
        initC2TC((char) AbstractJsonLexerKt.BEGIN_OBJ, (byte) 6);
        initC2TC((char) AbstractJsonLexerKt.END_OBJ, (byte) 7);
        initC2TC('[', (byte) 8);
        initC2TC((char) AbstractJsonLexerKt.END_LIST, (byte) 9);
        initC2TC('\"', (byte) 1);
        initC2TC('\\', (byte) 2);
    }

    private final void initEscape() {
        for (int i11 = 0; i11 < 32; i11++) {
            initC2ESC(i11, (char) AbstractJsonLexerKt.UNICODE_ESC);
        }
        initC2ESC(8, 'b');
        initC2ESC(9, (char) Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL);
        initC2ESC(10, 'n');
        initC2ESC(12, 'f');
        initC2ESC(13, (char) Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL);
        initC2ESC('/', '/');
        initC2ESC('\"', '\"');
        initC2ESC('\\', '\\');
    }

    private final void initC2ESC(char c11, char c12) {
        initC2ESC((int) c11, c12);
    }

    private final void initC2TC(char c11, byte b11) {
        initC2TC((int) c11, b11);
    }
}
