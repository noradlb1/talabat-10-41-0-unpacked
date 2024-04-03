package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b1\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/compose/foundation/text/MappedKeys;", "", "()V", "A", "Landroidx/compose/ui/input/key/Key;", "getA-EK5gGoQ", "()J", "J", "Backslash", "getBackslash-EK5gGoQ", "Backspace", "getBackspace-EK5gGoQ", "C", "getC-EK5gGoQ", "Cut", "getCut-EK5gGoQ", "Delete", "getDelete-EK5gGoQ", "DirectionDown", "getDirectionDown-EK5gGoQ", "DirectionLeft", "getDirectionLeft-EK5gGoQ", "DirectionRight", "getDirectionRight-EK5gGoQ", "DirectionUp", "getDirectionUp-EK5gGoQ", "Enter", "getEnter-EK5gGoQ", "H", "getH-EK5gGoQ", "Insert", "getInsert-EK5gGoQ", "MoveEnd", "getMoveEnd-EK5gGoQ", "MoveHome", "getMoveHome-EK5gGoQ", "PageDown", "getPageDown-EK5gGoQ", "PageUp", "getPageUp-EK5gGoQ", "Paste", "getPaste-EK5gGoQ", "Tab", "getTab-EK5gGoQ", "V", "getV-EK5gGoQ", "X", "getX-EK5gGoQ", "Z", "getZ-EK5gGoQ", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MappedKeys {
    private static final long A = Key_androidKt.Key(29);
    private static final long Backslash = Key_androidKt.Key(73);
    private static final long Backspace = Key_androidKt.Key(67);
    private static final long C = Key_androidKt.Key(31);
    private static final long Cut = Key_androidKt.Key(277);
    private static final long Delete = Key_androidKt.Key(112);
    private static final long DirectionDown = Key_androidKt.Key(20);
    private static final long DirectionLeft = Key_androidKt.Key(21);
    private static final long DirectionRight = Key_androidKt.Key(22);
    private static final long DirectionUp = Key_androidKt.Key(19);
    private static final long Enter = Key_androidKt.Key(66);
    private static final long H = Key_androidKt.Key(36);
    @NotNull
    public static final MappedKeys INSTANCE = new MappedKeys();
    private static final long Insert = Key_androidKt.Key(124);
    private static final long MoveEnd = Key_androidKt.Key(123);
    private static final long MoveHome = Key_androidKt.Key(122);
    private static final long PageDown = Key_androidKt.Key(93);
    private static final long PageUp = Key_androidKt.Key(92);
    private static final long Paste = Key_androidKt.Key(279);
    private static final long Tab = Key_androidKt.Key(61);
    private static final long V = Key_androidKt.Key(50);
    private static final long X = Key_androidKt.Key(52);
    private static final long Z = Key_androidKt.Key(54);

    private MappedKeys() {
    }

    /* renamed from: getA-EK5gGoQ  reason: not valid java name */
    public final long m866getAEK5gGoQ() {
        return A;
    }

    /* renamed from: getBackslash-EK5gGoQ  reason: not valid java name */
    public final long m867getBackslashEK5gGoQ() {
        return Backslash;
    }

    /* renamed from: getBackspace-EK5gGoQ  reason: not valid java name */
    public final long m868getBackspaceEK5gGoQ() {
        return Backspace;
    }

    /* renamed from: getC-EK5gGoQ  reason: not valid java name */
    public final long m869getCEK5gGoQ() {
        return C;
    }

    /* renamed from: getCut-EK5gGoQ  reason: not valid java name */
    public final long m870getCutEK5gGoQ() {
        return Cut;
    }

    /* renamed from: getDelete-EK5gGoQ  reason: not valid java name */
    public final long m871getDeleteEK5gGoQ() {
        return Delete;
    }

    /* renamed from: getDirectionDown-EK5gGoQ  reason: not valid java name */
    public final long m872getDirectionDownEK5gGoQ() {
        return DirectionDown;
    }

    /* renamed from: getDirectionLeft-EK5gGoQ  reason: not valid java name */
    public final long m873getDirectionLeftEK5gGoQ() {
        return DirectionLeft;
    }

    /* renamed from: getDirectionRight-EK5gGoQ  reason: not valid java name */
    public final long m874getDirectionRightEK5gGoQ() {
        return DirectionRight;
    }

    /* renamed from: getDirectionUp-EK5gGoQ  reason: not valid java name */
    public final long m875getDirectionUpEK5gGoQ() {
        return DirectionUp;
    }

    /* renamed from: getEnter-EK5gGoQ  reason: not valid java name */
    public final long m876getEnterEK5gGoQ() {
        return Enter;
    }

    /* renamed from: getH-EK5gGoQ  reason: not valid java name */
    public final long m877getHEK5gGoQ() {
        return H;
    }

    /* renamed from: getInsert-EK5gGoQ  reason: not valid java name */
    public final long m878getInsertEK5gGoQ() {
        return Insert;
    }

    /* renamed from: getMoveEnd-EK5gGoQ  reason: not valid java name */
    public final long m879getMoveEndEK5gGoQ() {
        return MoveEnd;
    }

    /* renamed from: getMoveHome-EK5gGoQ  reason: not valid java name */
    public final long m880getMoveHomeEK5gGoQ() {
        return MoveHome;
    }

    /* renamed from: getPageDown-EK5gGoQ  reason: not valid java name */
    public final long m881getPageDownEK5gGoQ() {
        return PageDown;
    }

    /* renamed from: getPageUp-EK5gGoQ  reason: not valid java name */
    public final long m882getPageUpEK5gGoQ() {
        return PageUp;
    }

    /* renamed from: getPaste-EK5gGoQ  reason: not valid java name */
    public final long m883getPasteEK5gGoQ() {
        return Paste;
    }

    /* renamed from: getTab-EK5gGoQ  reason: not valid java name */
    public final long m884getTabEK5gGoQ() {
        return Tab;
    }

    /* renamed from: getV-EK5gGoQ  reason: not valid java name */
    public final long m885getVEK5gGoQ() {
        return V;
    }

    /* renamed from: getX-EK5gGoQ  reason: not valid java name */
    public final long m886getXEK5gGoQ() {
        return X;
    }

    /* renamed from: getZ-EK5gGoQ  reason: not valid java name */
    public final long m887getZEK5gGoQ() {
        return Z;
    }
}
