package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
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
public final class BorderKt$drawGenericBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Outline.Generic f1459g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Brush f1460h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BorderKt$drawGenericBorder$1(Outline.Generic generic, Brush brush) {
        super(1);
        this.f1459g = generic;
        this.f1460h = brush;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        b.F(contentDrawScope, this.f1459g.getPath(), this.f1460h, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
    }
}
