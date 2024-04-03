package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b@\u0010AJT\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022;\u0010\f\u001a7\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0002\b\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJd\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052;\u0010\u0011\u001a7\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0016\u001a\u00020\n*\u00020\u0015H\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0005H\u0014J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014R4\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8@@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010+\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00188@@@X\u0002¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R+\u00102\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00188B@BX\u0002¢\u0006\u0012\n\u0004\b1\u0010 \u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R(\u0010=\u001a\u0004\u0018\u00010\u001a2\b\u00108\u001a\u0004\u0018\u00010\u001a8@@@X\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001d\u0010?\u001a\u00020\u001d8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b>\u0010\"\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/CompositionContext;", "parent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "viewportWidth", "viewportHeight", "", "Landroidx/compose/runtime/Composable;", "composable", "Landroidx/compose/runtime/Composition;", "composeVector", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function4;)Landroidx/compose/runtime/Composition;", "", "content", "RenderVector$ui_release", "(Ljava/lang/String;FFLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "RenderVector", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "d", "alpha", "", "a", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "b", "Landroidx/compose/ui/geometry/Size;", "<set-?>", "size$delegate", "Landroidx/compose/runtime/MutableState;", "getSize-NH-jbRc$ui_release", "()J", "setSize-uvyYCjk$ui_release", "(J)V", "size", "autoMirror$delegate", "getAutoMirror$ui_release", "()Z", "setAutoMirror$ui_release", "(Z)V", "autoMirror", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "composition", "Landroidx/compose/runtime/Composition;", "isDirty$delegate", "isDirty", "setDirty", "currentAlpha", "F", "currentColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "value", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter", "getIntrinsicSize-NH-jbRc", "intrinsicSize", "<init>", "()V", "ui_release"}, k = 1, mv = {1, 7, 1})
public final class VectorPainter extends Painter {
    public static final int $stable = 8;
    @NotNull
    private final MutableState autoMirror$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    @Nullable
    private Composition composition;
    private float currentAlpha;
    @Nullable
    private ColorFilter currentColorFilter;
    @NotNull
    private final MutableState isDirty$delegate;
    @NotNull
    private final MutableState size$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m2733boximpl(Size.Companion.m2754getZeroNHjbRc()), (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public final VectorComponent vector;

    public VectorPainter() {
        VectorComponent vectorComponent = new VectorComponent();
        vectorComponent.setInvalidateCallback$ui_release(new VectorPainter$vector$1$1(this));
        this.vector = vectorComponent;
        this.isDirty$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentAlpha = 1.0f;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    private final Composition composeVector(CompositionContext compositionContext, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4) {
        Composition composition2 = this.composition;
        if (composition2 == null || composition2.isDisposed()) {
            composition2 = CompositionKt.Composition(new VectorApplier(this.vector.getRoot()), compositionContext);
        }
        this.composition = composition2;
        composition2.setContent(ComposableLambdaKt.composableLambdaInstance(-1916507005, true, new VectorPainter$composeVector$1(function4, this)));
        return composition2;
    }

    private final boolean isDirty() {
        return ((Boolean) this.isDirty$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void setDirty(boolean z11) {
        this.isDirty$delegate.setValue(Boolean.valueOf(z11));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public final void RenderVector$ui_release(@NotNull String str, float f11, float f12, @NotNull Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function4, "content");
        Composer startRestartGroup = composer.startRestartGroup(1264894527);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1264894527, i11, -1, "androidx.compose.ui.graphics.vector.VectorPainter.RenderVector (VectorPainter.kt:220)");
        }
        VectorComponent vectorComponent = this.vector;
        vectorComponent.setName(str);
        vectorComponent.setViewportWidth(f11);
        vectorComponent.setViewportHeight(f12);
        Composition composeVector = composeVector(ComposablesKt.rememberCompositionContext(startRestartGroup, 0), function4);
        EffectsKt.DisposableEffect((Object) composeVector, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new VectorPainter$RenderVector$2(composeVector), startRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new VectorPainter$RenderVector$3(this, str, f11, f12, function4, i11));
        }
    }

    public boolean a(float f11) {
        this.currentAlpha = f11;
        return true;
    }

    public boolean b(@Nullable ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }

    public void d(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        VectorComponent vectorComponent = this.vector;
        ColorFilter colorFilter = this.currentColorFilter;
        if (colorFilter == null) {
            colorFilter = vectorComponent.getIntrinsicColorFilter$ui_release();
        }
        if (!getAutoMirror$ui_release() || drawScope.getLayoutDirection() != LayoutDirection.Rtl) {
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
        } else {
            long r22 = drawScope.m3424getCenterF1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long r52 = drawContext.m3403getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m3479scale0AR0LA0(-1.0f, 1.0f, r22);
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
            drawContext.getCanvas().restore();
            drawContext.m3404setSizeuvyYCjk(r52);
        }
        if (isDirty()) {
            setDirty(false);
        }
    }

    public final boolean getAutoMirror$ui_release() {
        return ((Boolean) this.autoMirror$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.vector.getIntrinsicColorFilter$ui_release();
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m3548getIntrinsicSizeNHjbRc() {
        return m3549getSizeNHjbRc$ui_release();
    }

    /* renamed from: getSize-NH-jbRc$ui_release  reason: not valid java name */
    public final long m3549getSizeNHjbRc$ui_release() {
        return ((Size) this.size$delegate.getValue()).m2750unboximpl();
    }

    public final void setAutoMirror$ui_release(boolean z11) {
        this.autoMirror$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setIntrinsicColorFilter$ui_release(@Nullable ColorFilter colorFilter) {
        this.vector.setIntrinsicColorFilter$ui_release(colorFilter);
    }

    /* renamed from: setSize-uvyYCjk$ui_release  reason: not valid java name */
    public final void m3550setSizeuvyYCjk$ui_release(long j11) {
        this.size$delegate.setValue(Size.m2733boximpl(j11));
    }
}
