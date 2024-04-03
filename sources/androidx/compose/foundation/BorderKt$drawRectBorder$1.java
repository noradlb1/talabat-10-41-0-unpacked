package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BorderKt$drawRectBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Brush f1465g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f1466h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f1467i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DrawStyle f1468j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BorderKt$drawRectBorder$1(Brush brush, long j11, long j12, DrawStyle drawStyle) {
        super(1);
        this.f1465g = brush;
        this.f1466h = j11;
        this.f1467i = j12;
        this.f1468j = drawStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        b.J(contentDrawScope, this.f1465g, this.f1466h, this.f1467i, 0.0f, this.f1468j, (ColorFilter) null, 0, 104, (Object) null);
    }
}
