package androidx.compose.animation;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Landroidx/compose/animation/TransitionData;", "", "fade", "Landroidx/compose/animation/Fade;", "slide", "Landroidx/compose/animation/Slide;", "changeSize", "Landroidx/compose/animation/ChangeSize;", "scale", "Landroidx/compose/animation/Scale;", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;Landroidx/compose/animation/Scale;)V", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "getFade", "()Landroidx/compose/animation/Fade;", "getScale", "()Landroidx/compose/animation/Scale;", "getSlide", "()Landroidx/compose/animation/Slide;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TransitionData {
    @Nullable
    private final ChangeSize changeSize;
    @Nullable
    private final Fade fade;
    @Nullable
    private final Scale scale;
    @Nullable
    private final Slide slide;

    public TransitionData() {
        this((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, 15, (DefaultConstructorMarker) null);
    }

    public TransitionData(@Nullable Fade fade2, @Nullable Slide slide2, @Nullable ChangeSize changeSize2, @Nullable Scale scale2) {
        this.fade = fade2;
        this.slide = slide2;
        this.changeSize = changeSize2;
        this.scale = scale2;
    }

    public static /* synthetic */ TransitionData copy$default(TransitionData transitionData, Fade fade2, Slide slide2, ChangeSize changeSize2, Scale scale2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            fade2 = transitionData.fade;
        }
        if ((i11 & 2) != 0) {
            slide2 = transitionData.slide;
        }
        if ((i11 & 4) != 0) {
            changeSize2 = transitionData.changeSize;
        }
        if ((i11 & 8) != 0) {
            scale2 = transitionData.scale;
        }
        return transitionData.copy(fade2, slide2, changeSize2, scale2);
    }

    @Nullable
    public final Fade component1() {
        return this.fade;
    }

    @Nullable
    public final Slide component2() {
        return this.slide;
    }

    @Nullable
    public final ChangeSize component3() {
        return this.changeSize;
    }

    @Nullable
    public final Scale component4() {
        return this.scale;
    }

    @NotNull
    public final TransitionData copy(@Nullable Fade fade2, @Nullable Slide slide2, @Nullable ChangeSize changeSize2, @Nullable Scale scale2) {
        return new TransitionData(fade2, slide2, changeSize2, scale2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransitionData)) {
            return false;
        }
        TransitionData transitionData = (TransitionData) obj;
        return Intrinsics.areEqual((Object) this.fade, (Object) transitionData.fade) && Intrinsics.areEqual((Object) this.slide, (Object) transitionData.slide) && Intrinsics.areEqual((Object) this.changeSize, (Object) transitionData.changeSize) && Intrinsics.areEqual((Object) this.scale, (Object) transitionData.scale);
    }

    @Nullable
    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    @Nullable
    public final Fade getFade() {
        return this.fade;
    }

    @Nullable
    public final Scale getScale() {
        return this.scale;
    }

    @Nullable
    public final Slide getSlide() {
        return this.slide;
    }

    public int hashCode() {
        Fade fade2 = this.fade;
        int i11 = 0;
        int hashCode = (fade2 == null ? 0 : fade2.hashCode()) * 31;
        Slide slide2 = this.slide;
        int hashCode2 = (hashCode + (slide2 == null ? 0 : slide2.hashCode())) * 31;
        ChangeSize changeSize2 = this.changeSize;
        int hashCode3 = (hashCode2 + (changeSize2 == null ? 0 : changeSize2.hashCode())) * 31;
        Scale scale2 = this.scale;
        if (scale2 != null) {
            i11 = scale2.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransitionData(Fade fade2, Slide slide2, ChangeSize changeSize2, Scale scale2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : fade2, (i11 & 2) != 0 ? null : slide2, (i11 & 4) != 0 ? null : changeSize2, (i11 & 8) != 0 ? null : scale2);
    }
}
