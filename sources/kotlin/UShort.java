package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

@JvmInline
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0010J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0013J\u001b\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0010J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0013J\u001b\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u0013J\u001b\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\b;\u0010\u001fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0010J\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0013J\u001b\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u0010J\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0013J\u001b\u0010H\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0010J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u0013J\u001b\u0010M\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020SH\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020\u0003H\b¢\u0006\u0004\be\u0010\u0005J\u000f\u0010f\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u000eH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010UJ\u0016\u0010l\u001a\u00020\u0011H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0014H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010cJ\u0016\u0010p\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010\u0005J\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006u"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class UShort implements Comparable<UShort> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ UShort(short s11) {
        this.data = s11;
    }

    @InlineOnly
    /* renamed from: and-xj2QHRw  reason: not valid java name */
    private static final short m6600andxj2QHRw(short s11, short s12) {
        return m6607constructorimpl((short) (s11 & s12));
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShort m6601boximpl(short s11) {
        return new UShort(s11);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m6602compareTo7apg3OU(short s11, byte b11) {
        return Intrinsics.compare((int) s11 & MAX_VALUE, (int) b11 & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m6603compareToVKZWuLQ(short s11, long j11) {
        return UnsignedKt.ulongCompare(ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j11);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m6604compareToWZ4Q5Ns(short s11, int i11) {
        return UnsignedKt.uintCompare(UInt.m6423constructorimpl(s11 & MAX_VALUE), i11);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private int m6605compareToxj2QHRw(short s11) {
        return Intrinsics.compare((int) m6656unboximpl() & MAX_VALUE, (int) s11 & MAX_VALUE);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m6607constructorimpl(short s11) {
        return s11;
    }

    @InlineOnly
    /* renamed from: dec-Mh2AYeg  reason: not valid java name */
    private static final short m6608decMh2AYeg(short s11) {
        return m6607constructorimpl((short) (s11 - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m6609div7apg3OU(short s11, byte b11) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), UInt.m6423constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m6610divVKZWuLQ(short s11, long j11) {
        return UnsignedKt.m6678ulongDivideeb3DHEI(ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j11);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m6611divWZ4Q5Ns(short s11, int i11) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), i11);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m6612divxj2QHRw(short s11, short s12) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), UInt.m6423constructorimpl(s12 & MAX_VALUE));
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6613equalsimpl(short s11, Object obj) {
        return (obj instanceof UShort) && s11 == ((UShort) obj).m6656unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6614equalsimpl0(short s11, short s12) {
        return s11 == s12;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m6615floorDiv7apg3OU(short s11, byte b11) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), UInt.m6423constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m6616floorDivVKZWuLQ(short s11, long j11) {
        return UnsignedKt.m6678ulongDivideeb3DHEI(ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j11);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m6617floorDivWZ4Q5Ns(short s11, int i11) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), i11);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m6618floorDivxj2QHRw(short s11, short s12) {
        return UnsignedKt.m6676uintDivideJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), UInt.m6423constructorimpl(s12 & MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6619hashCodeimpl(short s11) {
        return s11;
    }

    @InlineOnly
    /* renamed from: inc-Mh2AYeg  reason: not valid java name */
    private static final short m6620incMh2AYeg(short s11) {
        return m6607constructorimpl((short) (s11 + 1));
    }

    @InlineOnly
    /* renamed from: inv-Mh2AYeg  reason: not valid java name */
    private static final short m6621invMh2AYeg(short s11) {
        return m6607constructorimpl((short) (~s11));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m6622minus7apg3OU(short s11, byte b11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(s11 & MAX_VALUE) - UInt.m6423constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m6623minusVKZWuLQ(short s11, long j11) {
        return ULong.m6501constructorimpl(ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j11);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m6624minusWZ4Q5Ns(short s11, int i11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(s11 & MAX_VALUE) - i11);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m6625minusxj2QHRw(short s11, short s12) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(s11 & MAX_VALUE) - UInt.m6423constructorimpl(s12 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m6626mod7apg3OU(short s11, byte b11) {
        return UByte.m6347constructorimpl((byte) UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), UInt.m6423constructorimpl(b11 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m6627modVKZWuLQ(short s11, long j11) {
        return UnsignedKt.m6679ulongRemaindereb3DHEI(ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j11);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m6628modWZ4Q5Ns(short s11, int i11) {
        return UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), i11);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m6629modxj2QHRw(short s11, short s12) {
        return m6607constructorimpl((short) UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), UInt.m6423constructorimpl(s12 & MAX_VALUE)));
    }

    @InlineOnly
    /* renamed from: or-xj2QHRw  reason: not valid java name */
    private static final short m6630orxj2QHRw(short s11, short s12) {
        return m6607constructorimpl((short) (s11 | s12));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m6631plus7apg3OU(short s11, byte b11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(s11 & MAX_VALUE) + UInt.m6423constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m6632plusVKZWuLQ(short s11, long j11) {
        return ULong.m6501constructorimpl(ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j11);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m6633plusWZ4Q5Ns(short s11, int i11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(s11 & MAX_VALUE) + i11);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m6634plusxj2QHRw(short s11, short s12) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(s11 & MAX_VALUE) + UInt.m6423constructorimpl(s12 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-xj2QHRw  reason: not valid java name */
    private static final UIntRange m6635rangeToxj2QHRw(short s11, short s12) {
        return new UIntRange(UInt.m6423constructorimpl(s11 & MAX_VALUE), UInt.m6423constructorimpl(s12 & MAX_VALUE), (DefaultConstructorMarker) null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m6636rem7apg3OU(short s11, byte b11) {
        return UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), UInt.m6423constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m6637remVKZWuLQ(short s11, long j11) {
        return UnsignedKt.m6679ulongRemaindereb3DHEI(ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j11);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m6638remWZ4Q5Ns(short s11, int i11) {
        return UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), i11);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m6639remxj2QHRw(short s11, short s12) {
        return UnsignedKt.m6677uintRemainderJ1ME1BU(UInt.m6423constructorimpl(s11 & MAX_VALUE), UInt.m6423constructorimpl(s12 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m6640times7apg3OU(short s11, byte b11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(s11 & MAX_VALUE) * UInt.m6423constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m6641timesVKZWuLQ(short s11, long j11) {
        return ULong.m6501constructorimpl(ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j11);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m6642timesWZ4Q5Ns(short s11, int i11) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(s11 & MAX_VALUE) * i11);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m6643timesxj2QHRw(short s11, short s12) {
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl(s11 & MAX_VALUE) * UInt.m6423constructorimpl(s12 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m6644toByteimpl(short s11) {
        return (byte) s11;
    }

    @InlineOnly
    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m6645toDoubleimpl(short s11) {
        return (double) (s11 & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m6646toFloatimpl(short s11) {
        return (float) (s11 & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m6647toIntimpl(short s11) {
        return s11 & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m6648toLongimpl(short s11) {
        return ((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    @InlineOnly
    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m6649toShortimpl(short s11) {
        return s11;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6650toStringimpl(short s11) {
        return String.valueOf(s11 & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m6651toUBytew2LRezQ(short s11) {
        return UByte.m6347constructorimpl((byte) s11);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m6652toUIntpVg5ArA(short s11) {
        return UInt.m6423constructorimpl(s11 & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m6653toULongsVKNKU(short s11) {
        return ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m6654toUShortMh2AYeg(short s11) {
        return s11;
    }

    @InlineOnly
    /* renamed from: xor-xj2QHRw  reason: not valid java name */
    private static final short m6655xorxj2QHRw(short s11, short s12) {
        return m6607constructorimpl((short) (s11 ^ s12));
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare((int) m6656unboximpl() & MAX_VALUE, (int) ((UShort) obj).m6656unboximpl() & MAX_VALUE);
    }

    public boolean equals(Object obj) {
        return m6613equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m6619hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m6650toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m6656unboximpl() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static int m6606compareToxj2QHRw(short s11, short s12) {
        return Intrinsics.compare((int) s11 & MAX_VALUE, (int) s12 & MAX_VALUE);
    }
}
