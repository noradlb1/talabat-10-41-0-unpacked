package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class HapticFeedbackType {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nø\u0001\u0000R\u001a\u0010\u0003\u001a\u00020\u00048Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00048Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", "()V", "LongPress", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getLongPress-5zf0vsI", "()I", "TextHandleMove", "getTextHandleMove-5zf0vsI", "values", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getLongPress-5zf0vsI  reason: not valid java name */
        public final int m3566getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m3569getLongPress5zf0vsI();
        }

        /* renamed from: getTextHandleMove-5zf0vsI  reason: not valid java name */
        public final int m3567getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m3570getTextHandleMove5zf0vsI();
        }

        @NotNull
        public final List<HapticFeedbackType> values() {
            return CollectionsKt__CollectionsKt.listOf(HapticFeedbackType.m3559boximpl(m3566getLongPress5zf0vsI()), HapticFeedbackType.m3559boximpl(m3567getTextHandleMove5zf0vsI()));
        }
    }

    private /* synthetic */ HapticFeedbackType(int i11) {
        this.value = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m3559boximpl(int i11) {
        return new HapticFeedbackType(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m3560constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3561equalsimpl(int i11, Object obj) {
        return (obj instanceof HapticFeedbackType) && i11 == ((HapticFeedbackType) obj).m3565unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3562equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3563hashCodeimpl(int i11) {
        return i11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3564toStringimpl(int i11) {
        Companion companion = Companion;
        if (m3562equalsimpl0(i11, companion.m3566getLongPress5zf0vsI())) {
            return "LongPress";
        }
        if (m3562equalsimpl0(i11, companion.m3567getTextHandleMove5zf0vsI())) {
            return "TextHandleMove";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return m3561equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3563hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3564toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3565unboximpl() {
        return this.value;
    }
}
