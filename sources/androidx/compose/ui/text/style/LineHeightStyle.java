package androidx.compose.ui.text.style;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0003\u0014\u0015\u0016B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle;", "", "alignment", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "trim", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "(FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment-PIaL0Z0", "()F", "F", "getTrim-EVpEnUU", "()I", "I", "equals", "", "other", "hashCode", "", "toString", "", "Alignment", "Companion", "Trim", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LineHeightStyle {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final LineHeightStyle Default = new LineHeightStyle(Alignment.Companion.m5344getProportionalPIaL0Z0(), Trim.Companion.m5355getBothEVpEnUU(), (DefaultConstructorMarker) null);
    private final float alignment;
    private final int trim;

    @JvmInline
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0014\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "", "topRatio", "", "constructor-impl", "(F)F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Alignment {
        /* access modifiers changed from: private */
        public static final float Bottom = m5332constructorimpl(1.0f);
        /* access modifiers changed from: private */
        public static final float Center = m5332constructorimpl(0.5f);
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final float Proportional = m5332constructorimpl(-1.0f);
        /* access modifiers changed from: private */
        public static final float Top = m5332constructorimpl(0.0f);
        private final float topRatio;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R\"\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R\"\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "", "()V", "Bottom", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "getBottom-PIaL0Z0$annotations", "getBottom-PIaL0Z0", "()F", "F", "Center", "getCenter-PIaL0Z0$annotations", "getCenter-PIaL0Z0", "Proportional", "getProportional-PIaL0Z0$annotations", "getProportional-PIaL0Z0", "Top", "getTop-PIaL0Z0$annotations", "getTop-PIaL0Z0", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBottom-PIaL0Z0$annotations  reason: not valid java name */
            public static /* synthetic */ void m5338getBottomPIaL0Z0$annotations() {
            }

            /* renamed from: getCenter-PIaL0Z0$annotations  reason: not valid java name */
            public static /* synthetic */ void m5339getCenterPIaL0Z0$annotations() {
            }

            /* renamed from: getProportional-PIaL0Z0$annotations  reason: not valid java name */
            public static /* synthetic */ void m5340getProportionalPIaL0Z0$annotations() {
            }

            /* renamed from: getTop-PIaL0Z0$annotations  reason: not valid java name */
            public static /* synthetic */ void m5341getTopPIaL0Z0$annotations() {
            }

            /* renamed from: getBottom-PIaL0Z0  reason: not valid java name */
            public final float m5342getBottomPIaL0Z0() {
                return Alignment.Bottom;
            }

            /* renamed from: getCenter-PIaL0Z0  reason: not valid java name */
            public final float m5343getCenterPIaL0Z0() {
                return Alignment.Center;
            }

            /* renamed from: getProportional-PIaL0Z0  reason: not valid java name */
            public final float m5344getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }

            /* renamed from: getTop-PIaL0Z0  reason: not valid java name */
            public final float m5345getTopPIaL0Z0() {
                return Alignment.Top;
            }
        }

        @ExperimentalTextApi
        private /* synthetic */ Alignment(float f11) {
            this.topRatio = f11;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Alignment m5331boximpl(float f11) {
            return new Alignment(f11);
        }

        @ExperimentalTextApi
        /* renamed from: constructor-impl  reason: not valid java name */
        public static float m5332constructorimpl(float f11) {
            boolean z11 = true;
            if (!(0.0f <= f11 && f11 <= 1.0f)) {
                if (!(f11 == -1.0f)) {
                    z11 = false;
                }
            }
            if (z11) {
                return f11;
            }
            throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5333equalsimpl(float f11, Object obj) {
            if (!(obj instanceof Alignment)) {
                return false;
            }
            return Intrinsics.areEqual((Object) Float.valueOf(f11), (Object) Float.valueOf(((Alignment) obj).m5337unboximpl()));
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5334equalsimpl0(float f11, float f12) {
            return Intrinsics.areEqual((Object) Float.valueOf(f11), (Object) Float.valueOf(f12));
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5335hashCodeimpl(float f11) {
            return Float.floatToIntBits(f11);
        }

        @NotNull
        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5336toStringimpl(float f11) {
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14 = true;
            if (f11 == Top) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f11 == Center) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f11 == Proportional) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f11 != Bottom) {
                z14 = false;
            }
            if (z14) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f11 + ')';
        }

        public boolean equals(Object obj) {
            return m5333equalsimpl(this.topRatio, obj);
        }

        public int hashCode() {
            return m5335hashCodeimpl(this.topRatio);
        }

        @NotNull
        public String toString() {
            return m5336toStringimpl(this.topRatio);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ float m5337unboximpl() {
            return this.topRatio;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefault", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isTrimFirstLineTop", "isTrimFirstLineTop-impl$ui_text_release", "(I)Z", "isTrimLastLineBottom", "isTrimLastLineBottom-impl$ui_text_release", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Trim {
        /* access modifiers changed from: private */
        public static final int Both = m5347constructorimpl(17);
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int FirstLineTop = m5347constructorimpl(1);
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;
        /* access modifiers changed from: private */
        public static final int LastLineBottom = m5347constructorimpl(16);
        /* access modifiers changed from: private */
        public static final int None = m5347constructorimpl(0);
        private final int value;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "", "()V", "Both", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "getBoth-EVpEnUU", "()I", "I", "FirstLineTop", "getFirstLineTop-EVpEnUU", "FlagTrimBottom", "", "FlagTrimTop", "LastLineBottom", "getLastLineBottom-EVpEnUU", "None", "getNone-EVpEnUU", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBoth-EVpEnUU  reason: not valid java name */
            public final int m5355getBothEVpEnUU() {
                return Trim.Both;
            }

            /* renamed from: getFirstLineTop-EVpEnUU  reason: not valid java name */
            public final int m5356getFirstLineTopEVpEnUU() {
                return Trim.FirstLineTop;
            }

            /* renamed from: getLastLineBottom-EVpEnUU  reason: not valid java name */
            public final int m5357getLastLineBottomEVpEnUU() {
                return Trim.LastLineBottom;
            }

            /* renamed from: getNone-EVpEnUU  reason: not valid java name */
            public final int m5358getNoneEVpEnUU() {
                return Trim.None;
            }
        }

        private /* synthetic */ Trim(int i11) {
            this.value = i11;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Trim m5346boximpl(int i11) {
            return new Trim(i11);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static int m5347constructorimpl(int i11) {
            return i11;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5348equalsimpl(int i11, Object obj) {
            return (obj instanceof Trim) && i11 == ((Trim) obj).m5354unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5349equalsimpl0(int i11, int i12) {
            return i11 == i12;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5350hashCodeimpl(int i11) {
            return i11;
        }

        /* renamed from: isTrimFirstLineTop-impl$ui_text_release  reason: not valid java name */
        public static final boolean m5351isTrimFirstLineTopimpl$ui_text_release(int i11) {
            return (i11 & 1) > 0;
        }

        /* renamed from: isTrimLastLineBottom-impl$ui_text_release  reason: not valid java name */
        public static final boolean m5352isTrimLastLineBottomimpl$ui_text_release(int i11) {
            return (i11 & 16) > 0;
        }

        @NotNull
        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5353toStringimpl(int i11) {
            if (i11 == FirstLineTop) {
                return "LineHeightStyle.Trim.FirstLineTop";
            }
            if (i11 == LastLineBottom) {
                return "LineHeightStyle.Trim.LastLineBottom";
            }
            if (i11 == Both) {
                return "LineHeightStyle.Trim.Both";
            }
            if (i11 == None) {
                return "LineHeightStyle.Trim.None";
            }
            return "Invalid";
        }

        public boolean equals(Object obj) {
            return m5348equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5350hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m5353toStringimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m5354unboximpl() {
            return this.value;
        }
    }

    private LineHeightStyle(float f11, int i11) {
        this.alignment = f11;
        this.trim = i11;
    }

    public /* synthetic */ LineHeightStyle(float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        if (Alignment.m5334equalsimpl0(this.alignment, lineHeightStyle.alignment) && Trim.m5349equalsimpl0(this.trim, lineHeightStyle.trim)) {
            return true;
        }
        return false;
    }

    /* renamed from: getAlignment-PIaL0Z0  reason: not valid java name */
    public final float m5329getAlignmentPIaL0Z0() {
        return this.alignment;
    }

    /* renamed from: getTrim-EVpEnUU  reason: not valid java name */
    public final int m5330getTrimEVpEnUU() {
        return this.trim;
    }

    public int hashCode() {
        return (Alignment.m5335hashCodeimpl(this.alignment) * 31) + Trim.m5350hashCodeimpl(this.trim);
    }

    @NotNull
    public String toString() {
        return "LineHeightStyle(alignment=" + Alignment.m5336toStringimpl(this.alignment) + ", trim=" + Trim.m5353toStringimpl(this.trim) + ')';
    }
}
