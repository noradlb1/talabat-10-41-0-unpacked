package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "childOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AlignmentLines$recalculate$1 extends Lambda implements Function1<AlignmentLinesOwner, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AlignmentLines f9903g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlignmentLines$recalculate$1(AlignmentLines alignmentLines) {
        super(1);
        this.f9903g = alignmentLines;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AlignmentLinesOwner) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AlignmentLinesOwner alignmentLinesOwner) {
        Intrinsics.checkNotNullParameter(alignmentLinesOwner, "childOwner");
        if (alignmentLinesOwner.isPlaced()) {
            if (alignmentLinesOwner.getAlignmentLines().getDirty$ui_release()) {
                alignmentLinesOwner.layoutChildren();
            }
            Map access$getAlignmentLineMap$p = alignmentLinesOwner.getAlignmentLines().alignmentLineMap;
            AlignmentLines alignmentLines = this.f9903g;
            for (Map.Entry entry : access$getAlignmentLineMap$p.entrySet()) {
                alignmentLines.addAlignmentLine((AlignmentLine) entry.getKey(), ((Number) entry.getValue()).intValue(), alignmentLinesOwner.getInnerCoordinator());
            }
            NodeCoordinator wrappedBy$ui_release = alignmentLinesOwner.getInnerCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            while (!Intrinsics.areEqual((Object) wrappedBy$ui_release, (Object) this.f9903g.getAlignmentLinesOwner().getInnerCoordinator())) {
                Set<AlignmentLine> keySet = this.f9903g.b(wrappedBy$ui_release).keySet();
                AlignmentLines alignmentLines2 = this.f9903g;
                for (AlignmentLine alignmentLine : keySet) {
                    alignmentLines2.addAlignmentLine(alignmentLine, alignmentLines2.c(wrappedBy$ui_release, alignmentLine), wrappedBy$ui_release);
                }
                wrappedBy$ui_release = wrappedBy$ui_release.getWrappedBy$ui_release();
                Intrinsics.checkNotNull(wrappedBy$ui_release);
            }
        }
    }
}
