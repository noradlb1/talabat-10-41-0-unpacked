package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import p.a;
import p.b;
import p.c;

@Immutable
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005EFGHIB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020$H\u0007J-\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J%\u0010/\u001a\u00020&2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b0J-\u00101\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b2J-\u00103\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b4J-\u00105\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b6J-\u00107\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b8J\u001d\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=J%\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?J%\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020$H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010@J/\u0010A\u001a\u00020&*\u00020*2\u0006\u0010B\u001a\u00020-2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020&0DH\bR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0018\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\fR\u001c\u0010\u001b\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0011R\u001c\u0010\u001e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006J"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement;", "", "()V", "Bottom", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getBottom$annotations", "getBottom", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "End", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getEnd$annotations", "getEnd", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "Start", "getStart$annotations", "getStart", "Top", "getTop$annotations", "getTop", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "placeCenter", "", "totalSize", "", "size", "", "outPosition", "reverseInput", "", "placeCenter$foundation_layout_release", "placeLeftOrTop", "placeLeftOrTop$foundation_layout_release", "placeRightOrBottom", "placeRightOrBottom$foundation_layout_release", "placeSpaceAround", "placeSpaceAround$foundation_layout_release", "placeSpaceBetween", "placeSpaceBetween$foundation_layout_release", "placeSpaceEvenly", "placeSpaceEvenly$foundation_layout_release", "spacedBy", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "forEachIndexed", "reversed", "action", "Lkotlin/Function2;", "Absolute", "Horizontal", "HorizontalOrVertical", "SpacedAligned", "Vertical", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Arrangement {
    @NotNull
    private static final Vertical Bottom = new Arrangement$Bottom$1();
    @NotNull
    private static final HorizontalOrVertical Center = new Arrangement$Center$1();
    @NotNull
    private static final Horizontal End = new Arrangement$End$1();
    @NotNull
    public static final Arrangement INSTANCE = new Arrangement();
    @NotNull
    private static final HorizontalOrVertical SpaceAround = new Arrangement$SpaceAround$1();
    @NotNull
    private static final HorizontalOrVertical SpaceBetween = new Arrangement$SpaceBetween$1();
    @NotNull
    private static final HorizontalOrVertical SpaceEvenly = new Arrangement$SpaceEvenly$1();
    @NotNull
    private static final Horizontal Start = new Arrangement$Start$1();
    @NotNull
    private static final Vertical Top = new Arrangement$Top$1();

    @Immutable
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u001d\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J%\u0010\u001a\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010$R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Absolute;", "", "()V", "Center", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Left", "getLeft$annotations", "getLeft", "Right", "getRight$annotations", "getRight", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Absolute {
        @NotNull
        private static final Horizontal Center = new Arrangement$Absolute$Center$1();
        @NotNull
        public static final Absolute INSTANCE = new Absolute();
        @NotNull
        private static final Horizontal Left = new Arrangement$Absolute$Left$1();
        @NotNull
        private static final Horizontal Right = new Arrangement$Absolute$Right$1();
        @NotNull
        private static final Horizontal SpaceAround = new Arrangement$Absolute$SpaceAround$1();
        @NotNull
        private static final Horizontal SpaceBetween = new Arrangement$Absolute$SpaceBetween$1();
        @NotNull
        private static final Horizontal SpaceEvenly = new Arrangement$Absolute$SpaceEvenly$1();

        private Absolute() {
        }

        @Stable
        public static /* synthetic */ void getCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getLeft$annotations() {
        }

        @Stable
        public static /* synthetic */ void getRight$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceAround$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceBetween$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceEvenly$annotations() {
        }

        @NotNull
        @Stable
        public final Horizontal aligned(@NotNull Alignment.Horizontal horizontal) {
            Intrinsics.checkNotNullParameter(horizontal, "alignment");
            return new SpacedAligned(Dp.m5478constructorimpl((float) 0), false, new Arrangement$Absolute$aligned$1(horizontal), (DefaultConstructorMarker) null);
        }

        @NotNull
        public final Horizontal getCenter() {
            return Center;
        }

        @NotNull
        public final Horizontal getLeft() {
            return Left;
        }

        @NotNull
        public final Horizontal getRight() {
            return Right;
        }

        @NotNull
        public final Horizontal getSpaceAround() {
            return SpaceAround;
        }

        @NotNull
        public final Horizontal getSpaceBetween() {
            return SpaceBetween;
        }

        @NotNull
        public final Horizontal getSpaceEvenly() {
            return SpaceEvenly;
        }

        @NotNull
        @Stable
        /* renamed from: spacedBy-0680j_4  reason: not valid java name */
        public final HorizontalOrVertical m397spacedBy0680j_4(float f11) {
            return new SpacedAligned(f11, false, (Function2) null, (DefaultConstructorMarker) null);
        }

        @NotNull
        @Stable
        /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
        public final Horizontal m398spacedByD5KLDUw(float f11, @NotNull Alignment.Horizontal horizontal) {
            Intrinsics.checkNotNullParameter(horizontal, "alignment");
            return new SpacedAligned(f11, false, new Arrangement$Absolute$spacedBy$1(horizontal), (DefaultConstructorMarker) null);
        }

        @NotNull
        @Stable
        /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
        public final Vertical m399spacedByD5KLDUw(float f11, @NotNull Alignment.Vertical vertical) {
            Intrinsics.checkNotNullParameter(vertical, "alignment");
            return new SpacedAligned(f11, false, new Arrangement$Absolute$spacedBy$2(vertical), (DefaultConstructorMarker) null);
        }
    }

    @Stable
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&R\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Horizontal {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m410getSpacingD9Ej5fM(@NotNull Horizontal horizontal) {
                return a.a(horizontal);
            }
        }

        void arrange(@NotNull Density density, int i11, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        float m409getSpacingD9Ej5fM();
    }

    @Stable
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u001d\u0010\u0003\u001a\u00020\u00048VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface HorizontalOrVertical extends Horizontal, Vertical {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m412getSpacingD9Ej5fM(@NotNull HorizontalOrVertical horizontalOrVertical) {
                return b.b(horizontalOrVertical);
            }
        }

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        float m411getSpacingD9Ej5fM();
    }

    @Stable
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Vertical {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m424getSpacingD9Ej5fM(@NotNull Vertical vertical) {
                return c.a(vertical);
            }
        }

        void arrange(@NotNull Density density, int i11, @NotNull int[] iArr, @NotNull int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        float m423getSpacingD9Ej5fM();
    }

    private Arrangement() {
    }

    private final void forEachIndexed(int[] iArr, boolean z11, Function2<? super Integer, ? super Integer, Unit> function2) {
        if (!z11) {
            int length = iArr.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                function2.invoke(Integer.valueOf(i12), Integer.valueOf(iArr[i11]));
                i11++;
                i12++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 < length2) {
                function2.invoke(Integer.valueOf(length2), Integer.valueOf(iArr[length2]));
            } else {
                return;
            }
        }
    }

    @Stable
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Stable
    public static /* synthetic */ void getCenter$annotations() {
    }

    @Stable
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceAround$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceBetween$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceEvenly$annotations() {
    }

    @Stable
    public static /* synthetic */ void getStart$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTop$annotations() {
    }

    @NotNull
    @Stable
    public final Horizontal aligned(@NotNull Alignment.Horizontal horizontal) {
        Intrinsics.checkNotNullParameter(horizontal, "alignment");
        return new SpacedAligned(Dp.m5478constructorimpl((float) 0), true, new Arrangement$aligned$1(horizontal), (DefaultConstructorMarker) null);
    }

    @NotNull
    public final Vertical getBottom() {
        return Bottom;
    }

    @NotNull
    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    @NotNull
    public final Horizontal getEnd() {
        return End;
    }

    @NotNull
    public final HorizontalOrVertical getSpaceAround() {
        return SpaceAround;
    }

    @NotNull
    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    @NotNull
    public final HorizontalOrVertical getSpaceEvenly() {
        return SpaceEvenly;
    }

    @NotNull
    public final Horizontal getStart() {
        return Start;
    }

    @NotNull
    public final Vertical getTop() {
        return Top;
    }

    public final void placeCenter$foundation_layout_release(int i11, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z11) {
        Intrinsics.checkNotNullParameter(iArr, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float f11 = ((float) (i11 - i13)) / ((float) 2);
        if (!z11) {
            int length = iArr.length;
            int i15 = 0;
            while (i12 < length) {
                int i16 = iArr[i12];
                iArr2[i15] = MathKt__MathJVMKt.roundToInt(f11);
                f11 += (float) i16;
                i12++;
                i15++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 < length2) {
                int i17 = iArr[length2];
                iArr2[length2] = MathKt__MathJVMKt.roundToInt(f11);
                f11 += (float) i17;
            } else {
                return;
            }
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(@NotNull int[] iArr, @NotNull int[] iArr2, boolean z11) {
        Intrinsics.checkNotNullParameter(iArr, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i11 = 0;
        if (!z11) {
            int length = iArr.length;
            int i12 = 0;
            int i13 = 0;
            while (i11 < length) {
                int i14 = iArr[i11];
                iArr2[i12] = i13;
                i13 += i14;
                i11++;
                i12++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 < length2) {
                int i15 = iArr[length2];
                iArr2[length2] = i11;
                i11 += i15;
            } else {
                return;
            }
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int i11, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z11) {
        Intrinsics.checkNotNullParameter(iArr, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        int i15 = i11 - i13;
        if (!z11) {
            int length = iArr.length;
            int i16 = 0;
            while (i12 < length) {
                int i17 = iArr[i12];
                iArr2[i16] = i15;
                i15 += i17;
                i12++;
                i16++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 < length2) {
                int i18 = iArr[length2];
                iArr2[length2] = i15;
                i15 += i18;
            } else {
                return;
            }
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int i11, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z11) {
        boolean z12;
        float f11;
        Intrinsics.checkNotNullParameter(iArr, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        if (iArr.length == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            f11 = ((float) (i11 - i13)) / ((float) iArr.length);
        } else {
            f11 = 0.0f;
        }
        float f12 = f11 / ((float) 2);
        if (!z11) {
            int length = iArr.length;
            int i15 = 0;
            while (i12 < length) {
                int i16 = iArr[i12];
                iArr2[i15] = MathKt__MathJVMKt.roundToInt(f12);
                f12 += ((float) i16) + f11;
                i12++;
                i15++;
            }
            return;
        }
        for (int length2 = iArr.length - 1; -1 < length2; length2--) {
            int i17 = iArr[length2];
            iArr2[length2] = MathKt__MathJVMKt.roundToInt(f12);
            f12 += ((float) i17) + f11;
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int i11, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z11) {
        float f11;
        Intrinsics.checkNotNullParameter(iArr, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float f12 = 0.0f;
        if (iArr.length > 1) {
            f11 = ((float) (i11 - i13)) / ((float) (iArr.length - 1));
        } else {
            f11 = 0.0f;
        }
        if (!z11) {
            int length = iArr.length;
            int i15 = 0;
            while (i12 < length) {
                int i16 = iArr[i12];
                iArr2[i15] = MathKt__MathJVMKt.roundToInt(f12);
                f12 += ((float) i16) + f11;
                i12++;
                i15++;
            }
            return;
        }
        for (int length2 = iArr.length - 1; -1 < length2; length2--) {
            int i17 = iArr[length2];
            iArr2[length2] = MathKt__MathJVMKt.roundToInt(f12);
            f12 += ((float) i17) + f11;
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int i11, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z11) {
        Intrinsics.checkNotNullParameter(iArr, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float length = ((float) (i11 - i13)) / ((float) (iArr.length + 1));
        if (!z11) {
            int length2 = iArr.length;
            float f11 = length;
            int i15 = 0;
            while (i12 < length2) {
                int i16 = iArr[i12];
                iArr2[i15] = MathKt__MathJVMKt.roundToInt(f11);
                f11 += ((float) i16) + length;
                i12++;
                i15++;
            }
            return;
        }
        float f12 = length;
        for (int length3 = iArr.length - 1; -1 < length3; length3--) {
            int i17 = iArr[length3];
            iArr2[length3] = MathKt__MathJVMKt.roundToInt(f12);
            f12 += ((float) i17) + length;
        }
    }

    @NotNull
    @Stable
    /* renamed from: spacedBy-0680j_4  reason: not valid java name */
    public final HorizontalOrVertical m394spacedBy0680j_4(float f11) {
        return new SpacedAligned(f11, true, Arrangement$spacedBy$1.INSTANCE, (DefaultConstructorMarker) null);
    }

    @NotNull
    @Stable
    /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
    public final Horizontal m395spacedByD5KLDUw(float f11, @NotNull Alignment.Horizontal horizontal) {
        Intrinsics.checkNotNullParameter(horizontal, "alignment");
        return new SpacedAligned(f11, true, new Arrangement$spacedBy$2(horizontal), (DefaultConstructorMarker) null);
    }

    @NotNull
    @Stable
    /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
    public final Vertical m396spacedByD5KLDUw(float f11, @NotNull Alignment.Vertical vertical) {
        Intrinsics.checkNotNullParameter(vertical, "alignment");
        return new SpacedAligned(f11, false, new Arrangement$spacedBy$3(vertical), (DefaultConstructorMarker) null);
    }

    @NotNull
    @Stable
    public final Vertical aligned(@NotNull Alignment.Vertical vertical) {
        Intrinsics.checkNotNullParameter(vertical, "alignment");
        return new SpacedAligned(Dp.m5478constructorimpl((float) 0), false, new Arrangement$aligned$2(vertical), (DefaultConstructorMarker) null);
    }

    @Immutable
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u0014\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JH\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J,\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020&H\u0016J$\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "rtlMirror", "", "alignment", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "getRtlMirror", "()Z", "getSpace-D9Ej5fM", "()F", "F", "spacing", "getSpacing-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FZLkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "equals", "other", "", "hashCode", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "sizes", "", "layoutDirection", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SpacedAligned implements HorizontalOrVertical {
        @Nullable
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        private SpacedAligned(float f11, boolean z11, Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            this.space = f11;
            this.rtlMirror = z11;
            this.alignment = function2;
            this.spacing = f11;
        }

        public /* synthetic */ SpacedAligned(float f11, boolean z11, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f11, z11, function2);
        }

        /* renamed from: copy-8Feqmps$default  reason: not valid java name */
        public static /* synthetic */ SpacedAligned m416copy8Feqmps$default(SpacedAligned spacedAligned, float f11, boolean z11, Function2<Integer, LayoutDirection, Integer> function2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = spacedAligned.space;
            }
            if ((i11 & 2) != 0) {
                z11 = spacedAligned.rtlMirror;
            }
            if ((i11 & 4) != 0) {
                function2 = spacedAligned.alignment;
            }
            return spacedAligned.m418copy8Feqmps(f11, z11, function2);
        }

        public void arrange(@NotNull Density density, int i11, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2) {
            int i12;
            int i13;
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            if (!(iArr.length == 0)) {
                int r102 = density.m5441roundToPx0680j_4(this.space);
                boolean z11 = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
                Arrangement arrangement = Arrangement.INSTANCE;
                if (!z11) {
                    int length = iArr.length;
                    int i14 = 0;
                    i13 = 0;
                    i12 = 0;
                    int i15 = 0;
                    while (i14 < length) {
                        int i16 = iArr[i14];
                        int min = Math.min(i13, i11 - i16);
                        iArr2[i15] = min;
                        int min2 = Math.min(r102, (i11 - min) - i16);
                        int i17 = iArr2[i15] + i16 + min2;
                        i14++;
                        i15++;
                        int i18 = i17;
                        i12 = min2;
                        i13 = i18;
                    }
                } else {
                    int i19 = 0;
                    int i21 = 0;
                    for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                        int i22 = iArr[length2];
                        int min3 = Math.min(i13, i11 - i22);
                        iArr2[length2] = min3;
                        i21 = Math.min(r102, (i11 - min3) - i22);
                        i19 = iArr2[length2] + i22 + i21;
                    }
                }
                int i23 = i13 - i12;
                Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
                if (function2 != null && i23 < i11) {
                    int intValue = function2.invoke(Integer.valueOf(i11 - i23), layoutDirection).intValue();
                    int length3 = iArr2.length;
                    for (int i24 = 0; i24 < length3; i24++) {
                        iArr2[i24] = iArr2[i24] + intValue;
                    }
                }
            }
        }

        /* renamed from: component1-D9Ej5fM  reason: not valid java name */
        public final float m417component1D9Ej5fM() {
            return this.space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        @Nullable
        public final Function2<Integer, LayoutDirection, Integer> component3() {
            return this.alignment;
        }

        @NotNull
        /* renamed from: copy-8Feqmps  reason: not valid java name */
        public final SpacedAligned m418copy8Feqmps(float f11, boolean z11, @Nullable Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            return new SpacedAligned(f11, z11, function2, (DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) obj;
            return Dp.m5483equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && Intrinsics.areEqual((Object) this.alignment, (Object) spacedAligned.alignment);
        }

        @Nullable
        public final Function2<Integer, LayoutDirection, Integer> getAlignment() {
            return this.alignment;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        /* renamed from: getSpace-D9Ej5fM  reason: not valid java name */
        public final float m419getSpaceD9Ej5fM() {
            return this.space;
        }

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        public float m420getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public int hashCode() {
            int r02 = Dp.m5484hashCodeimpl(this.space) * 31;
            boolean z11 = this.rtlMirror;
            if (z11) {
                z11 = true;
            }
            int i11 = (r02 + (z11 ? 1 : 0)) * 31;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            return i11 + (function2 == null ? 0 : function2.hashCode());
        }

        @NotNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.rtlMirror ? "" : "Absolute");
            sb2.append("Arrangement#spacedAligned(");
            sb2.append(Dp.m5489toStringimpl(this.space));
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(this.alignment);
            sb2.append(')');
            return sb2.toString();
        }

        public void arrange(@NotNull Density density, int i11, @NotNull int[] iArr, @NotNull int[] iArr2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            arrange(density, i11, iArr, LayoutDirection.Ltr, iArr2);
        }
    }
}
