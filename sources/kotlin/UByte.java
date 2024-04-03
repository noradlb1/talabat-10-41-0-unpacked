package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import org.jetbrains.annotations.NotNull;

@JvmInline
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u000fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0012J\u001b\u0010H\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u0012J\u001b\u0010M\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020\u0003H\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020UH\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020\rH\b¢\u0006\u0004\b]\u0010-J\u0010\u0010^\u001a\u00020_H\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\b¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010\u0005J\u0016\u0010l\u001a\u00020\u0010H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0013H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010aJ\u0016\u0010p\u001a\u00020\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010eJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006u"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class UByte implements Comparable<UByte> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ UByte(byte b11) {
        this.data = b11;
    }

    @InlineOnly
    /* renamed from: and-7apg3OU  reason: not valid java name */
    private static final byte m6340and7apg3OU(byte b11, byte b12) {
        return m6347constructorimpl((byte) (b11 & b12));
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m6341boximpl(byte b11) {
        return new UByte(b11);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m6342compareTo7apg3OU(byte b11) {
        return Intrinsics.compare((int) m6396unboximpl() & 255, (int) b11 & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m6344compareToVKZWuLQ(byte b11, long j11) {
        return UnsignedKt.ulongCompare(ULong.m6501constructorimpl(((long) b11) & 255), j11);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m6345compareToWZ4Q5Ns(byte b11, int i11) {
        return UnsignedKt.uintCompare(UInt.m6423constructorimpl(b11 & 255), i11);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m6346compareToxj2QHRw(byte b11, short s11) {
        return Intrinsics.compare((int) b11 & 255, (int) s11 & UShort.MAX_VALUE);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m6347constructorimpl(byte b11) {
        return b11;
    }

    @InlineOnly
    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    private static final byte m6348decw2LRezQ(byte b11) {
        return m6347constructorimpl((byte) (b11 - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m6349div7apg3OU(byte b11, byte b12) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(b12 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m6350divVKZWuLQ(byte b11, long j11) {
        return UnsignedKt.m6678ulongDivideeb3DHEI(ULong.m6501constructorimpl(((long) b11) & 255), j11);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m6351divWZ4Q5Ns(byte b11, int i11) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), i11);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m6352divxj2QHRw(byte b11, short s11) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6353equalsimpl(byte b11, Object obj) {
        return (obj instanceof UByte) && b11 == ((UByte) obj).m6396unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6354equalsimpl0(byte b11, byte b12) {
        return b11 == b12;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m6355floorDiv7apg3OU(byte b11, byte b12) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(b12 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m6356floorDivVKZWuLQ(byte b11, long j11) {
        return UnsignedKt.m6678ulongDivideeb3DHEI(ULong.m6501constructorimpl(((long) b11) & 255), j11);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m6357floorDivWZ4Q5Ns(byte b11, int i11) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), i11);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m6358floorDivxj2QHRw(byte b11, short s11) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6359hashCodeimpl(byte b11) {
        return b11;
    }

    @InlineOnly
    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    private static final byte m6360incw2LRezQ(byte b11) {
        return m6347constructorimpl((byte) (b11 + 1));
    }

    @InlineOnly
    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    private static final byte m6361invw2LRezQ(byte b11) {
        return m6347constructorimpl((byte) (~b11));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m6362minus7apg3OU(byte b11, byte b12) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(b11 & 255) - UInt.m6423constructorimpl(b12 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m6363minusVKZWuLQ(byte b11, long j11) {
        return ULong.m6501constructorimpl(ULong.m6501constructorimpl(((long) b11) & 255) - j11);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m6364minusWZ4Q5Ns(byte b11, int i11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(b11 & 255) - i11);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m6365minusxj2QHRw(byte b11, short s11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(b11 & 255) - UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m6366mod7apg3OU(byte b11, byte b12) {
        return m6347constructorimpl((byte) UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(b12 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m6367modVKZWuLQ(byte b11, long j11) {
        return UnsignedKt.m6679ulongRemaindereb3DHEI(ULong.m6501constructorimpl(((long) b11) & 255), j11);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m6368modWZ4Q5Ns(byte b11, int i11) {
        return UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), i11);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m6369modxj2QHRw(byte b11, short s11) {
        return UShort.m6607constructorimpl((short) UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE)));
    }

    @InlineOnly
    /* renamed from: or-7apg3OU  reason: not valid java name */
    private static final byte m6370or7apg3OU(byte b11, byte b12) {
        return m6347constructorimpl((byte) (b11 | b12));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m6371plus7apg3OU(byte b11, byte b12) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(b11 & 255) + UInt.m6423constructorimpl(b12 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m6372plusVKZWuLQ(byte b11, long j11) {
        return ULong.m6501constructorimpl(ULong.m6501constructorimpl(((long) b11) & 255) + j11);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m6373plusWZ4Q5Ns(byte b11, int i11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(b11 & 255) + i11);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m6374plusxj2QHRw(byte b11, short s11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(b11 & 255) + UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    private static final UIntRange m6375rangeTo7apg3OU(byte b11, byte b12) {
        return new UIntRange(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(b12 & 255), (DefaultConstructorMarker) null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m6376rem7apg3OU(byte b11, byte b12) {
        return UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(b12 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m6377remVKZWuLQ(byte b11, long j11) {
        return UnsignedKt.m6679ulongRemaindereb3DHEI(ULong.m6501constructorimpl(((long) b11) & 255), j11);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m6378remWZ4Q5Ns(byte b11, int i11) {
        return UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), i11);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m6379remxj2QHRw(byte b11, short s11) {
        return UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m6380times7apg3OU(byte b11, byte b12) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(b11 & 255) * UInt.m6423constructorimpl(b12 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m6381timesVKZWuLQ(byte b11, long j11) {
        return ULong.m6501constructorimpl(ULong.m6501constructorimpl(((long) b11) & 255) * j11);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m6382timesWZ4Q5Ns(byte b11, int i11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(b11 & 255) * i11);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m6383timesxj2QHRw(byte b11, short s11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(b11 & 255) * UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m6384toByteimpl(byte b11) {
        return b11;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m6385toDoubleimpl(byte b11) {
        return (double) (b11 & 255);
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m6386toFloatimpl(byte b11) {
        return (float) (b11 & 255);
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m6387toIntimpl(byte b11) {
        return b11 & 255;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m6388toLongimpl(byte b11) {
        return ((long) b11) & 255;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m6389toShortimpl(byte b11) {
        return (short) (((short) b11) & 255);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6390toStringimpl(byte b11) {
        return String.valueOf(b11 & 255);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m6391toUBytew2LRezQ(byte b11) {
        return b11;
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m6392toUIntpVg5ArA(byte b11) {
        return UInt.m6423constructorimpl(b11 & 255);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m6393toULongsVKNKU(byte b11) {
        return ULong.m6501constructorimpl(((long) b11) & 255);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m6394toUShortMh2AYeg(byte b11) {
        return UShort.m6607constructorimpl((short) (((short) b11) & 255));
    }

    @InlineOnly
    /* renamed from: xor-7apg3OU  reason: not valid java name */
    private static final byte m6395xor7apg3OU(byte b11, byte b12) {
        return m6347constructorimpl((byte) (b11 ^ b12));
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare((int) m6396unboximpl() & 255, (int) ((UByte) obj).m6396unboximpl() & 255);
    }

    public boolean equals(Object obj) {
        return m6353equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m6359hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m6390toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m6396unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static int m6343compareTo7apg3OU(byte b11, byte b12) {
        return Intrinsics.compare((int) b11 & 255, (int) b12 & 255);
    }
}
