package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "(Ljava/lang/String;ICC)V", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WriteMode {
    OBJ(AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ),
    LIST('[', AbstractJsonLexerKt.END_LIST),
    MAP(AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ),
    POLY_OBJ('[', AbstractJsonLexerKt.END_LIST);
    
    @JvmField
    public final char begin;
    @JvmField
    public final char end;

    private WriteMode(char c11, char c12) {
        this.begin = c11;
        this.end = c12;
    }
}
