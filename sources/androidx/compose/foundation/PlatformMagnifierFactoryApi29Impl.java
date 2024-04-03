package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(29)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl;", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "()V", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "style", "Landroidx/compose/foundation/MagnifierStyle;", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "PlatformMagnifierImpl", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    @NotNull
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();
    private static final boolean canUpdateZoom = true;

    @RequiresApi(29)
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "magnifier", "Landroid/widget/Magnifier;", "(Landroid/widget/Magnifier;)V", "update", "", "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", "zoom", "", "update-Wko1d7g", "(JJF)V", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PlatformMagnifierImpl(@NotNull Magnifier magnifier) {
            super(magnifier);
            Intrinsics.checkNotNullParameter(magnifier, "magnifier");
        }

        /* renamed from: update-Wko1d7g  reason: not valid java name */
        public void m259updateWko1d7g(long j11, long j12, float f11) {
            if (!Float.isNaN(f11)) {
                getMagnifier().setZoom(f11);
            }
            if (OffsetKt.m2695isSpecifiedk4lQ0M(j12)) {
                getMagnifier().show(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), Offset.m2676getXimpl(j12), Offset.m2677getYimpl(j12));
            } else {
                getMagnifier().show(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
            }
        }
    }

    private PlatformMagnifierFactoryApi29Impl() {
    }

    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    @NotNull
    public PlatformMagnifierImpl create(@NotNull MagnifierStyle magnifierStyle, @NotNull View view, @NotNull Density density, float f11) {
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        if (Intrinsics.areEqual((Object) magnifierStyle, (Object) MagnifierStyle.Companion.getTextDefault())) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long r02 = density.m5448toSizeXkaWNTQ(magnifierStyle.m249getSizeMYxV2XQ$foundation_release());
        float r22 = density.m5447toPx0680j_4(magnifierStyle.m247getCornerRadiusD9Ej5fM$foundation_release());
        float r92 = density.m5447toPx0680j_4(magnifierStyle.m248getElevationD9Ej5fM$foundation_release());
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (r02 != Size.Companion.m2753getUnspecifiedNHjbRc()) {
            Magnifier.Builder unused = builder.setSize(MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(r02)), MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(r02)));
        }
        if (!Float.isNaN(r22)) {
            Magnifier.Builder unused2 = builder.setCornerRadius(r22);
        }
        if (!Float.isNaN(r92)) {
            Magnifier.Builder unused3 = builder.setElevation(r92);
        }
        if (!Float.isNaN(f11)) {
            Magnifier.Builder unused4 = builder.setInitialZoom(f11);
        }
        Magnifier.Builder unused5 = builder.setClippingEnabled(magnifierStyle.getClippingEnabled$foundation_release());
        Magnifier a11 = builder.build();
        Intrinsics.checkNotNullExpressionValue(a11, "Builder(view).run {\n    …    build()\n            }");
        return new PlatformMagnifierImpl(a11);
    }
}
