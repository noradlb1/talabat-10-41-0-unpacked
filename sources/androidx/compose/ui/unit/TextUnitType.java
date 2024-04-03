package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/unit/TextUnitType;", "", "type", "", "constructor-impl", "(J)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class TextUnitType {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Em = m5685constructorimpl(8589934592L);
    /* access modifiers changed from: private */
    public static final long Sp = m5685constructorimpl(4294967296L);
    /* access modifiers changed from: private */
    public static final long Unspecified = m5685constructorimpl(0);
    private final long type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/unit/TextUnitType$Companion;", "", "()V", "Em", "Landroidx/compose/ui/unit/TextUnitType;", "getEm-UIouoOA", "()J", "J", "Sp", "getSp-UIouoOA", "Unspecified", "getUnspecified-UIouoOA", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getEm-UIouoOA  reason: not valid java name */
        public final long m5691getEmUIouoOA() {
            return TextUnitType.Em;
        }

        /* renamed from: getSp-UIouoOA  reason: not valid java name */
        public final long m5692getSpUIouoOA() {
            return TextUnitType.Sp;
        }

        /* renamed from: getUnspecified-UIouoOA  reason: not valid java name */
        public final long m5693getUnspecifiedUIouoOA() {
            return TextUnitType.Unspecified;
        }
    }

    private /* synthetic */ TextUnitType(long j11) {
        this.type = j11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextUnitType m5684boximpl(long j11) {
        return new TextUnitType(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m5685constructorimpl(long j11) {
        return j11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5686equalsimpl(long j11, Object obj) {
        return (obj instanceof TextUnitType) && j11 == ((TextUnitType) obj).m5690unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5687equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5688hashCodeimpl(long j11) {
        return a.a(j11);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5689toStringimpl(long j11) {
        if (m5687equalsimpl0(j11, Unspecified)) {
            return "Unspecified";
        }
        if (m5687equalsimpl0(j11, Sp)) {
            return "Sp";
        }
        if (m5687equalsimpl0(j11, Em)) {
            return "Em";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return m5686equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m5688hashCodeimpl(this.type);
    }

    @NotNull
    public String toString() {
        return m5689toStringimpl(this.type);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m5690unboximpl() {
        return this.type;
    }
}
