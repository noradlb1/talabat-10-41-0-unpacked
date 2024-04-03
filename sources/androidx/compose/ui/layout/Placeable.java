package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import j0.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b'\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J@\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b¢\u0006\u0002\b\nH$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R3\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0004@DX\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR3\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u001e8\u0004@DX\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u0014\u0010#\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013R\u0014\u0010%\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0013R\u001d\u0010'\u001a\u00020\u00048DX\u0004ø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b&\u0010\u001b\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "", "recalculateWidthAndHeight", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "d", "(JFLkotlin/jvm/functions/Function1;)V", "", "<set-?>", "width", "I", "getWidth", "()I", "height", "getHeight", "Landroidx/compose/ui/unit/IntSize;", "value", "measuredSize", "J", "b", "()J", "e", "(J)V", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "c", "f", "getMeasuredWidth", "measuredWidth", "getMeasuredHeight", "measuredHeight", "a", "apparentToRealOffset", "<init>", "()V", "PlacementScope", "ui_release"}, k = 1, mv = {1, 7, 1})
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private int height;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private int width;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010(J)\u0010\n\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005J$\u0010\u000e\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005J)\u0010\u000e\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\tJD\u0010\u0016\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0002\b\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u0016\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0002\b\u0012J?\u0010\u0017\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0002\b\u0012JD\u0010\u0017\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0002\b\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0015JJ\u0010\u001a\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u001b\b\b\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010¢\u0006\u0002\b\u0012H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0015JJ\u0010\u001c\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u001b\b\b\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010¢\u0006\u0002\b\u0012H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8$X¤\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010)\u001a\u0004\u0018\u00010$8WX\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006,"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "", "placeRelative-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "placeRelative", "", "x", "y", "place", "place-70tqf50", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeRelativeWithLayer", "placeWithLayer", "placeWithLayer-aW-9-wM", "placeAutoMirrored-aW-9-wM$ui_release", "placeAutoMirrored", "placeApparentToRealOffset-aW-9-wM$ui_release", "placeApparentToRealOffset", "b", "()I", "parentWidth", "Landroidx/compose/ui/unit/LayoutDirection;", "a", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentLayoutDirection", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates$annotations", "()V", "coordinates", "<init>", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class PlacementScope {
        public static final int $stable = 0;
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @Nullable
        public static LayoutCoordinates _coordinates;
        /* access modifiers changed from: private */
        @Nullable
        public static LayoutNodeLayoutDelegate layoutDelegate;
        /* access modifiers changed from: private */
        @NotNull
        public static LayoutDirection parentLayoutDirection = LayoutDirection.Ltr;
        /* access modifiers changed from: private */
        public static int parentWidth;

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JA\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0019\b\u0004\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\bø\u0001\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b8\u0014@RX\u000e¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068\u0014@RX\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00178VX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!\u0002\u0007\n\u0005\b20\u0001¨\u0006#"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope$Companion;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "scope", "", "configureForPlacingForAlignment", "", "parentWidth", "Landroidx/compose/ui/unit/LayoutDirection;", "parentLayoutDirection", "lookaheadCapablePlaceable", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "executeWithRtlMirroringValues", "<set-?>", "Landroidx/compose/ui/unit/LayoutDirection;", "a", "()Landroidx/compose/ui/unit/LayoutDirection;", "I", "b", "()I", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates$annotations", "()V", "coordinates", "_coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "<init>", "ui_release"}, k = 1, mv = {1, 7, 1})
        public static final class Companion extends PlacementScope {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* access modifiers changed from: private */
            public final boolean configureForPlacingForAlignment(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
                boolean z11 = false;
                if (lookaheadCapablePlaceable == null) {
                    PlacementScope._coordinates = null;
                    PlacementScope.layoutDelegate = null;
                    return false;
                }
                boolean isPlacingForAlignment$ui_release = lookaheadCapablePlaceable.isPlacingForAlignment$ui_release();
                LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
                if (parent != null && parent.isPlacingForAlignment$ui_release()) {
                    z11 = true;
                }
                if (z11) {
                    lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(true);
                }
                PlacementScope.layoutDelegate = lookaheadCapablePlaceable.getLayoutNode().getLayoutDelegate$ui_release();
                if (lookaheadCapablePlaceable.isPlacingForAlignment$ui_release() || lookaheadCapablePlaceable.isShallowPlacing$ui_release()) {
                    PlacementScope._coordinates = null;
                } else {
                    PlacementScope._coordinates = lookaheadCapablePlaceable.getCoordinates();
                }
                return isPlacingForAlignment$ui_release;
            }

            @ExperimentalComposeUiApi
            public static /* synthetic */ void getCoordinates$annotations() {
            }

            @NotNull
            public LayoutDirection a() {
                return PlacementScope.parentLayoutDirection;
            }

            public int b() {
                return PlacementScope.parentWidth;
            }

            public final void executeWithRtlMirroringValues(int i11, @NotNull LayoutDirection layoutDirection, @Nullable LookaheadCapablePlaceable lookaheadCapablePlaceable, @NotNull Function1<? super PlacementScope, Unit> function1) {
                Intrinsics.checkNotNullParameter(layoutDirection, "parentLayoutDirection");
                Intrinsics.checkNotNullParameter(function1, "block");
                LayoutCoordinates access$get_coordinates$cp = PlacementScope._coordinates;
                Companion companion = PlacementScope.Companion;
                int access$getParentWidth = companion.b();
                LayoutDirection access$getParentLayoutDirection = companion.a();
                LayoutNodeLayoutDelegate access$getLayoutDelegate$cp = PlacementScope.layoutDelegate;
                PlacementScope.parentWidth = i11;
                PlacementScope.parentLayoutDirection = layoutDirection;
                boolean access$configureForPlacingForAlignment = configureForPlacingForAlignment(lookaheadCapablePlaceable);
                function1.invoke(this);
                if (lookaheadCapablePlaceable != null) {
                    lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
                }
                PlacementScope.parentWidth = access$getParentWidth;
                PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
                PlacementScope._coordinates = access$get_coordinates$cp;
                PlacementScope.layoutDelegate = access$getLayoutDelegate$cp;
            }

            @Nullable
            public LayoutCoordinates getCoordinates() {
                LayoutNodeLayoutDelegate access$getLayoutDelegate$cp = PlacementScope.layoutDelegate;
                if (access$getLayoutDelegate$cp != null) {
                    access$getLayoutDelegate$cp.setCoordinatesAccessedDuringPlacement(true);
                }
                return PlacementScope._coordinates;
            }
        }

        @ExperimentalComposeUiApi
        public static /* synthetic */ void getCoordinates$annotations() {
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i11, int i12, float f11, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 4) != 0) {
                    f11 = 0.0f;
                }
                placementScope.place(placeable, i11, i12, f11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
        }

        /* renamed from: place-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m4529place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j11, float f11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    f11 = 0.0f;
                }
                placementScope.m4533place70tqf50(placeable, j11, f11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i11, int i12, float f11, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 4) != 0) {
                    f11 = 0.0f;
                }
                placementScope.placeRelative(placeable, i11, i12, f11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
        }

        /* renamed from: placeRelative-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m4530placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j11, float f11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    f11 = 0.0f;
                }
                placementScope.m4536placeRelative70tqf50(placeable, j11, f11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i11, int i12, float f11, Function1 function1, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 4) != 0) {
                    f11 = 0.0f;
                }
                float f12 = f11;
                if ((i13 & 8) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.placeRelativeWithLayer(placeable, i11, i12, f12, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m4531placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j11, float f11, Function1 function1, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    f11 = 0.0f;
                }
                float f12 = f11;
                if ((i11 & 4) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.m4537placeRelativeWithLayeraW9wM(placeable, j11, f12, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i11, int i12, float f11, Function1 function1, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 4) != 0) {
                    f11 = 0.0f;
                }
                float f12 = f11;
                if ((i13 & 8) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.placeWithLayer(placeable, i11, i12, f12, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }

        /* renamed from: placeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m4532placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j11, float f11, Function1 function1, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    f11 = 0.0f;
                }
                float f12 = f11;
                if ((i11 & 4) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.m4538placeWithLayeraW9wM(placeable, j11, f12, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        @NotNull
        public abstract LayoutDirection a();

        public abstract int b();

        @ExperimentalComposeUiApi
        @Nullable
        public LayoutCoordinates getCoordinates() {
            return null;
        }

        public final void place(@NotNull Placeable placeable, int i11, int i12, float f11) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(i11, i12);
            long r02 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(IntOffset) + IntOffset.m5597getYimpl(r02)), f11, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50  reason: not valid java name */
        public final void m4533place70tqf50(@NotNull Placeable placeable, long j11, float f11) {
            Intrinsics.checkNotNullParameter(placeable, "$this$place");
            long r02 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(r02)), f11, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release  reason: not valid java name */
        public final void m4534placeApparentToRealOffsetaW9wM$ui_release(@NotNull Placeable placeable, long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeApparentToRealOffset");
            long r02 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(r02)), f11, function1);
        }

        /* renamed from: placeAutoMirrored-aW-9-wM$ui_release  reason: not valid java name */
        public final void m4535placeAutoMirroredaW9wM$ui_release(@NotNull Placeable placeable, long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeAutoMirrored");
            if (a() == LayoutDirection.Ltr || b() == 0) {
                long r02 = placeable.a();
                placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(r02)), f11, function1);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((b() - placeable.getWidth()) - IntOffset.m5596getXimpl(j11), IntOffset.m5597getYimpl(j11));
            long r03 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset) + IntOffset.m5596getXimpl(r03), IntOffset.m5597getYimpl(IntOffset) + IntOffset.m5597getYimpl(r03)), f11, function1);
        }

        public final void placeRelative(@NotNull Placeable placeable, int i11, int i12, float f11) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(i11, i12);
            if (a() == LayoutDirection.Ltr || b() == 0) {
                long r02 = placeable.a();
                placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(IntOffset) + IntOffset.m5597getYimpl(r02)), f11, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((b() - placeable.getWidth()) - IntOffset.m5596getXimpl(IntOffset), IntOffset.m5597getYimpl(IntOffset));
            long r03 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset2) + IntOffset.m5596getXimpl(r03), IntOffset.m5597getYimpl(IntOffset2) + IntOffset.m5597getYimpl(r03)), f11, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: placeRelative-70tqf50  reason: not valid java name */
        public final void m4536placeRelative70tqf50(@NotNull Placeable placeable, long j11, float f11) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeRelative");
            if (a() == LayoutDirection.Ltr || b() == 0) {
                long r02 = placeable.a();
                placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(r02)), f11, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((b() - placeable.getWidth()) - IntOffset.m5596getXimpl(j11), IntOffset.m5597getYimpl(j11));
            long r03 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset) + IntOffset.m5596getXimpl(r03), IntOffset.m5597getYimpl(IntOffset) + IntOffset.m5597getYimpl(r03)), f11, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        public final void placeRelativeWithLayer(@NotNull Placeable placeable, int i11, int i12, float f11, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(i11, i12);
            if (a() == LayoutDirection.Ltr || b() == 0) {
                long r02 = placeable.a();
                placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(IntOffset) + IntOffset.m5597getYimpl(r02)), f11, function1);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((b() - placeable.getWidth()) - IntOffset.m5596getXimpl(IntOffset), IntOffset.m5597getYimpl(IntOffset));
            long r03 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset2) + IntOffset.m5596getXimpl(r03), IntOffset.m5597getYimpl(IntOffset2) + IntOffset.m5597getYimpl(r03)), f11, function1);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m4537placeRelativeWithLayeraW9wM(@NotNull Placeable placeable, long j11, float f11, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeRelativeWithLayer");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            if (a() == LayoutDirection.Ltr || b() == 0) {
                long r02 = placeable.a();
                placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(r02)), f11, function1);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((b() - placeable.getWidth()) - IntOffset.m5596getXimpl(j11), IntOffset.m5597getYimpl(j11));
            long r03 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset) + IntOffset.m5596getXimpl(r03), IntOffset.m5597getYimpl(IntOffset) + IntOffset.m5597getYimpl(r03)), f11, function1);
        }

        public final void placeWithLayer(@NotNull Placeable placeable, int i11, int i12, float f11, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(i11, i12);
            long r02 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(IntOffset) + IntOffset.m5597getYimpl(r02)), f11, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m4538placeWithLayeraW9wM(@NotNull Placeable placeable, long j11, float f11, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeWithLayer");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long r02 = placeable.a();
            placeable.d(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j11) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(j11) + IntOffset.m5597getYimpl(r02)), f11, function1);
        }
    }

    private final void recalculateWidthAndHeight() {
        this.width = RangesKt___RangesKt.coerceIn(IntSize.m5638getWidthimpl(this.measuredSize), Constraints.m5424getMinWidthimpl(this.measurementConstraints), Constraints.m5422getMaxWidthimpl(this.measurementConstraints));
        this.height = RangesKt___RangesKt.coerceIn(IntSize.m5637getHeightimpl(this.measuredSize), Constraints.m5423getMinHeightimpl(this.measurementConstraints), Constraints.m5421getMaxHeightimpl(this.measurementConstraints));
    }

    public final long a() {
        return IntOffsetKt.IntOffset((this.width - IntSize.m5638getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m5637getHeightimpl(this.measuredSize)) / 2);
    }

    public final long b() {
        return this.measuredSize;
    }

    public final long c() {
        return this.measurementConstraints;
    }

    public abstract void d(long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1);

    public final void e(long j11) {
        if (!IntSize.m5636equalsimpl0(this.measuredSize, j11)) {
            this.measuredSize = j11;
            recalculateWidthAndHeight();
        }
    }

    public final void f(long j11) {
        if (!Constraints.m5415equalsimpl0(this.measurementConstraints, j11)) {
            this.measurementConstraints = j11;
            recalculateWidthAndHeight();
        }
    }

    public final int getHeight() {
        return this.height;
    }

    public int getMeasuredHeight() {
        return IntSize.m5637getHeightimpl(this.measuredSize);
    }

    public int getMeasuredWidth() {
        return IntSize.m5638getWidthimpl(this.measuredSize);
    }

    public /* synthetic */ Object getParentData() {
        return e.a(this);
    }

    public final int getWidth() {
        return this.width;
    }
}
