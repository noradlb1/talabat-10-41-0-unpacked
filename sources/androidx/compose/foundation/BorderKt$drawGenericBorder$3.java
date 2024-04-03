package androidx.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BorderKt$drawGenericBorder$3 extends Lambda implements Function1<ContentDrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Rect f1461g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<ImageBitmap> f1462h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f1463i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f1464j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BorderKt$drawGenericBorder$3(Rect rect, Ref.ObjectRef<ImageBitmap> objectRef, long j11, ColorFilter colorFilter) {
        super(1);
        this.f1461g = rect;
        this.f1462h = objectRef;
        this.f1463i = j11;
        this.f1464j = colorFilter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        float left = this.f1461g.getLeft();
        float top = this.f1461g.getTop();
        Ref.ObjectRef<ImageBitmap> objectRef = this.f1462h;
        long j11 = this.f1463i;
        ColorFilter colorFilter = this.f1464j;
        contentDrawScope.getDrawContext().getTransform().translate(left, top);
        b.z(contentDrawScope, (ImageBitmap) objectRef.element, 0, j11, 0, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 0, 890, (Object) null);
        contentDrawScope.getDrawContext().getTransform().translate(-left, -top);
    }
}
