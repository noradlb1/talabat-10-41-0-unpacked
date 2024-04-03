package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001c\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0015J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\u00020\u000e8\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/graphics/OffsetEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "Landroid/graphics/RenderEffect;", "a", "", "other", "", "equals", "", "hashCode", "", "toString", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "Landroidx/compose/ui/geometry/Offset;", "offset", "J", "<init>", "(Landroidx/compose/ui/graphics/RenderEffect;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "ui-graphics_release"}, k = 1, mv = {1, 7, 1})
public final class OffsetEffect extends RenderEffect {
    private final long offset;
    @Nullable
    private final RenderEffect renderEffect;

    private OffsetEffect(RenderEffect renderEffect2, long j11) {
        super((DefaultConstructorMarker) null);
        this.renderEffect = renderEffect2;
        this.offset = j11;
    }

    public /* synthetic */ OffsetEffect(RenderEffect renderEffect2, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderEffect2, j11);
    }

    @RequiresApi(31)
    @NotNull
    public RenderEffect a() {
        return RenderEffectVerificationHelper.INSTANCE.m3197createOffsetEffectUv8p0NA(this.renderEffect, this.offset);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetEffect)) {
            return false;
        }
        OffsetEffect offsetEffect = (OffsetEffect) obj;
        if (Intrinsics.areEqual((Object) this.renderEffect, (Object) offsetEffect.renderEffect) && Offset.m2673equalsimpl0(this.offset, offsetEffect.offset)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        RenderEffect renderEffect2 = this.renderEffect;
        if (renderEffect2 != null) {
            i11 = renderEffect2.hashCode();
        } else {
            i11 = 0;
        }
        return (i11 * 31) + Offset.m2678hashCodeimpl(this.offset);
    }

    @NotNull
    public String toString() {
        return "OffsetEffect(renderEffect=" + this.renderEffect + ", offset=" + Offset.m2684toStringimpl(this.offset) + ')';
    }
}
