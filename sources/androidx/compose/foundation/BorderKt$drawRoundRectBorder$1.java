package androidx.compose.foundation;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BorderKt$drawRoundRectBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1469g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Brush f1470h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f1471i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f1472j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f1473k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f1474l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f1475m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Stroke f1476n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BorderKt$drawRoundRectBorder$1(boolean z11, Brush brush, long j11, float f11, float f12, long j12, long j13, Stroke stroke) {
        super(1);
        this.f1469g = z11;
        this.f1470h = brush;
        this.f1471i = j11;
        this.f1472j = f11;
        this.f1473k = f12;
        this.f1474l = j12;
        this.f1475m = j13;
        this.f1476n = stroke;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        if (this.f1469g) {
            b.L(contentDrawScope, this.f1470h, 0, 0, this.f1471i, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
            return;
        }
        float r12 = CornerRadius.m2651getXimpl(this.f1471i);
        float f11 = this.f1472j;
        if (r12 < f11) {
            float f12 = this.f1473k;
            float r72 = Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc()) - this.f1473k;
            float r82 = Size.m2742getHeightimpl(contentDrawScope.m3425getSizeNHjbRc()) - this.f1473k;
            int r92 = ClipOp.Companion.m2907getDifferencertfAjoo();
            Brush brush = this.f1470h;
            long j11 = this.f1471i;
            DrawContext drawContext = contentDrawScope.getDrawContext();
            long r14 = drawContext.m3403getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m3475clipRectN_I0leg(f12, f12, r72, r82, r92);
            b.L(contentDrawScope, brush, 0, 0, j11, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
            drawContext.getCanvas().restore();
            drawContext.m3404setSizeuvyYCjk(r14);
            return;
        }
        b.L(contentDrawScope, this.f1470h, this.f1474l, this.f1475m, BorderKt.m187shrinkKibmq7A(this.f1471i, f11), 0.0f, this.f1476n, (ColorFilter) null, 0, 208, (Object) null);
    }
}
