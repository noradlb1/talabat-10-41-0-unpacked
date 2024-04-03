package androidx.compose.ui.layout;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"androidx/compose/ui/layout/LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1 implements MeasureResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MeasureResult f9853a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeSubcompositionsState f9854b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f9855c;

    public LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1(MeasureResult measureResult, LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i11) {
        this.f9853a = measureResult;
        this.f9854b = layoutNodeSubcompositionsState;
        this.f9855c = i11;
    }

    @NotNull
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.f9853a.getAlignmentLines();
    }

    public int getHeight() {
        return this.f9853a.getHeight();
    }

    public int getWidth() {
        return this.f9853a.getWidth();
    }

    public void placeChildren() {
        this.f9854b.currentIndex = this.f9855c;
        this.f9853a.placeChildren();
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.f9854b;
        layoutNodeSubcompositionsState.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState.currentIndex);
    }
}
