package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"androidx/compose/ui/layout/MeasureScope$layout$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MeasureScope$layout$1 implements MeasureResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9870a;
    @NotNull
    private final Map<AlignmentLine, Integer> alignmentLines;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f9871b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1<Placeable.PlacementScope, Unit> f9872c;
    private final int height;
    private final int width;

    public MeasureScope$layout$1(int i11, int i12, Map<AlignmentLine, Integer> map, MeasureScope measureScope, Function1<? super Placeable.PlacementScope, Unit> function1) {
        this.f9870a = i11;
        this.f9871b = measureScope;
        this.f9872c = function1;
        this.width = i11;
        this.height = i12;
        this.alignmentLines = map;
    }

    @NotNull
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.alignmentLines;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void placeChildren() {
        LookaheadCapablePlaceable lookaheadCapablePlaceable;
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int i11 = this.f9870a;
        LayoutDirection layoutDirection = this.f9871b.getLayoutDirection();
        MeasureScope measureScope = this.f9871b;
        if (measureScope instanceof LookaheadCapablePlaceable) {
            lookaheadCapablePlaceable = (LookaheadCapablePlaceable) measureScope;
        } else {
            lookaheadCapablePlaceable = null;
        }
        Function1<Placeable.PlacementScope, Unit> function1 = this.f9872c;
        LayoutCoordinates access$get_coordinates$cp = Placeable.PlacementScope._coordinates;
        int access$getParentWidth = companion.b();
        LayoutDirection access$getParentLayoutDirection = companion.a();
        LayoutNodeLayoutDelegate access$getLayoutDelegate$cp = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.parentWidth = i11;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        boolean access$configureForPlacingForAlignment = companion.configureForPlacingForAlignment(lookaheadCapablePlaceable);
        function1.invoke(companion);
        if (lookaheadCapablePlaceable != null) {
            lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
        }
        Placeable.PlacementScope.parentWidth = access$getParentWidth;
        Placeable.PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
        Placeable.PlacementScope._coordinates = access$get_coordinates$cp;
        Placeable.PlacementScope.layoutDelegate = access$getLayoutDelegate$cp;
    }
}
