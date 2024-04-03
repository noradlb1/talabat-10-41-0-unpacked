package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntSize;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J'\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003ø\u0001\u0000J\u0012\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0003ø\u0001\u0000J\t\u0010\u001a\u001a\u00020\rHÆ\u0003JU\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001ø\u0001\u0000J\u0013\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R/\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/compose/animation/ChangeSize;", "", "alignment", "Landroidx/compose/ui/Alignment;", "size", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "fullSize", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "clip", "", "(Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/FiniteAnimationSpec;Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getClip", "()Z", "getSize", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChangeSize {
    @NotNull
    private final Alignment alignment;
    @NotNull
    private final FiniteAnimationSpec<IntSize> animationSpec;
    private final boolean clip;
    @NotNull
    private final Function1<IntSize, IntSize> size;

    public ChangeSize(@NotNull Alignment alignment2, @NotNull Function1<? super IntSize, IntSize> function1, @NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, boolean z11) {
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(function1, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        this.alignment = alignment2;
        this.size = function1;
        this.animationSpec = finiteAnimationSpec;
        this.clip = z11;
    }

    public static /* synthetic */ ChangeSize copy$default(ChangeSize changeSize, Alignment alignment2, Function1<IntSize, IntSize> function1, FiniteAnimationSpec<IntSize> finiteAnimationSpec, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            alignment2 = changeSize.alignment;
        }
        if ((i11 & 2) != 0) {
            function1 = changeSize.size;
        }
        if ((i11 & 4) != 0) {
            finiteAnimationSpec = changeSize.animationSpec;
        }
        if ((i11 & 8) != 0) {
            z11 = changeSize.clip;
        }
        return changeSize.copy(alignment2, function1, finiteAnimationSpec, z11);
    }

    @NotNull
    public final Alignment component1() {
        return this.alignment;
    }

    @NotNull
    public final Function1<IntSize, IntSize> component2() {
        return this.size;
    }

    @NotNull
    public final FiniteAnimationSpec<IntSize> component3() {
        return this.animationSpec;
    }

    public final boolean component4() {
        return this.clip;
    }

    @NotNull
    public final ChangeSize copy(@NotNull Alignment alignment2, @NotNull Function1<? super IntSize, IntSize> function1, @NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, boolean z11) {
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(function1, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new ChangeSize(alignment2, function1, finiteAnimationSpec, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeSize)) {
            return false;
        }
        ChangeSize changeSize = (ChangeSize) obj;
        return Intrinsics.areEqual((Object) this.alignment, (Object) changeSize.alignment) && Intrinsics.areEqual((Object) this.size, (Object) changeSize.size) && Intrinsics.areEqual((Object) this.animationSpec, (Object) changeSize.animationSpec) && this.clip == changeSize.clip;
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @NotNull
    public final FiniteAnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getClip() {
        return this.clip;
    }

    @NotNull
    public final Function1<IntSize, IntSize> getSize() {
        return this.size;
    }

    public int hashCode() {
        int hashCode = ((((this.alignment.hashCode() * 31) + this.size.hashCode()) * 31) + this.animationSpec.hashCode()) * 31;
        boolean z11 = this.clip;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "ChangeSize(alignment=" + this.alignment + ", size=" + this.size + ", animationSpec=" + this.animationSpec + ", clip=" + this.clip + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChangeSize(Alignment alignment2, Function1 function1, FiniteAnimationSpec finiteAnimationSpec, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment2, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function1, finiteAnimationSpec, (i11 & 8) != 0 ? true : z11);
    }
}
