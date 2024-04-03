package androidx.compose.foundation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BorderKt$border$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f1452g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f1453h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Brush f1454i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BorderKt$border$2(float f11, Shape shape, Brush brush) {
        super(3);
        this.f1452g = f11;
        this.f1453h = shape;
        this.f1454i = brush;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1498088849);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1498088849, i11, -1, "androidx.compose.foundation.border.<anonymous> (Border.kt:93)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Ref();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Ref ref = (Ref) rememberedValue;
        Modifier.Companion companion = Modifier.Companion;
        final float f11 = this.f1452g;
        final Shape shape = this.f1453h;
        final Brush brush = this.f1454i;
        Modifier then = modifier.then(DrawModifierKt.drawWithCache(companion, new Function1<CacheDrawScope, DrawResult>() {
            @NotNull
            public final DrawResult invoke(@NotNull CacheDrawScope cacheDrawScope) {
                Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
                if (!(cacheDrawScope.m2581toPx0680j_4(f11) >= 0.0f && Size.m2744getMinDimensionimpl(cacheDrawScope.m2573getSizeNHjbRc()) > 0.0f)) {
                    return BorderKt.drawContentWithoutBorder(cacheDrawScope);
                }
                float f11 = (float) 2;
                float min = Math.min(Dp.m5483equalsimpl0(f11, Dp.Companion.m5496getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil((double) cacheDrawScope.m2581toPx0680j_4(f11)), (float) Math.ceil((double) (Size.m2744getMinDimensionimpl(cacheDrawScope.m2573getSizeNHjbRc()) / f11)));
                float f12 = min / f11;
                long Offset = OffsetKt.Offset(f12, f12);
                long Size = SizeKt.Size(Size.m2745getWidthimpl(cacheDrawScope.m2573getSizeNHjbRc()) - min, Size.m2742getHeightimpl(cacheDrawScope.m2573getSizeNHjbRc()) - min);
                boolean z11 = f11 * min > Size.m2744getMinDimensionimpl(cacheDrawScope.m2573getSizeNHjbRc());
                Outline r12 = shape.m3232createOutlinePq9zytI(cacheDrawScope.m2573getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                if (r12 instanceof Outline.Generic) {
                    return BorderKt.drawGenericBorder(cacheDrawScope, ref, brush, (Outline.Generic) r12, z11, min);
                } else if (r12 instanceof Outline.Rounded) {
                    return BorderKt.m186drawRoundRectBorderSYlcjDY(cacheDrawScope, ref, brush, (Outline.Rounded) r12, Offset, Size, z11, min);
                } else if (r12 instanceof Outline.Rectangle) {
                    return BorderKt.m185drawRectBorderNsqcLGU(cacheDrawScope, brush, Offset, Size, z11, min);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
