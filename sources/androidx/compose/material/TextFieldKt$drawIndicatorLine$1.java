package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.unit.Dp;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldKt$drawIndicatorLine$1 extends Lambda implements Function1<ContentDrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f6086g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6087h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKt$drawIndicatorLine$1(float f11, BorderStroke borderStroke) {
        super(1);
        this.f6086g = f11;
        this.f6087h = borderStroke;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
        contentDrawScope.drawContent();
        if (!Dp.m5483equalsimpl0(this.f6086g, Dp.Companion.m5496getHairlineD9Ej5fM())) {
            float density = this.f6086g * contentDrawScope.getDensity();
            float r12 = Size.m2742getHeightimpl(contentDrawScope.m3425getSizeNHjbRc()) - (density / ((float) 2));
            b.B(contentDrawScope, this.f6087h.getBrush(), OffsetKt.Offset(0.0f, r12), OffsetKt.Offset(Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc()), r12), density, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
        }
    }
}
