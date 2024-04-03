package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CacheDrawScope$onDrawBehind$1 extends Lambda implements Function1<ContentDrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<DrawScope, Unit> f9565g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CacheDrawScope$onDrawBehind$1(Function1<? super DrawScope, Unit> function1) {
        super(1);
        this.f9565g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
        this.f9565g.invoke(contentDrawScope);
        contentDrawScope.drawContent();
    }
}
