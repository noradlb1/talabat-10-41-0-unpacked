package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0018\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R \u0010\b\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "getStart-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final ULongRange EMPTY = new ULongRange(-1, 0, (DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ULongRange getEMPTY() {
            return ULongRange.EMPTY;
        }
    }

    private ULongRange(long j11, long j12) {
        super(j11, j12, 1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ULongRange(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    /* renamed from: getEndExclusive-s-VKNKU$annotations  reason: not valid java name */
    public static /* synthetic */ void m9038getEndExclusivesVKNKU$annotations() {
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return m9039containsVKZWuLQ(((ULong) comparable).m6552unboximpl());
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m9039containsVKZWuLQ(long j11) {
        return UnsignedKt.ulongCompare(m9034getFirstsVKNKU(), j11) <= 0 && UnsignedKt.ulongCompare(j11, m9035getLastsVKNKU()) <= 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ULongRange) {
            if (!isEmpty() || !((ULongRange) obj).isEmpty()) {
                ULongRange uLongRange = (ULongRange) obj;
                if (!(m9034getFirstsVKNKU() == uLongRange.m9034getFirstsVKNKU() && m9035getLastsVKNKU() == uLongRange.m9035getLastsVKNKU())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return ULong.m6495boximpl(m9040getEndExclusivesVKNKU());
    }

    /* renamed from: getEndExclusive-s-VKNKU  reason: not valid java name */
    public long m9040getEndExclusivesVKNKU() {
        if (m9035getLastsVKNKU() != -1) {
            return ULong.m6501constructorimpl(m9035getLastsVKNKU() + ULong.m6501constructorimpl(((long) 1) & 4294967295L));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return ULong.m6495boximpl(m9041getEndInclusivesVKNKU());
    }

    /* renamed from: getEndInclusive-s-VKNKU  reason: not valid java name */
    public long m9041getEndInclusivesVKNKU() {
        return m9035getLastsVKNKU();
    }

    public /* bridge */ /* synthetic */ Comparable getStart() {
        return ULong.m6495boximpl(m9042getStartsVKNKU());
    }

    /* renamed from: getStart-s-VKNKU  reason: not valid java name */
    public long m9042getStartsVKNKU() {
        return m9034getFirstsVKNKU();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) ULong.m6501constructorimpl(m9034getFirstsVKNKU() ^ ULong.m6501constructorimpl(m9034getFirstsVKNKU() >>> 32))) * 31) + ((int) ULong.m6501constructorimpl(m9035getLastsVKNKU() ^ ULong.m6501constructorimpl(m9035getLastsVKNKU() >>> 32)));
    }

    public boolean isEmpty() {
        return UnsignedKt.ulongCompare(m9034getFirstsVKNKU(), m9035getLastsVKNKU()) > 0;
    }

    @NotNull
    public String toString() {
        return ULong.m6546toStringimpl(m9034getFirstsVKNKU()) + ".." + ULong.m6546toStringimpl(m9035getLastsVKNKU());
    }
}
