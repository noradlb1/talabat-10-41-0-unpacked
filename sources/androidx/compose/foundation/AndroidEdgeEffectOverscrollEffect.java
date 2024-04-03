package androidx.compose.foundation;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00101\u001a\u00020&H\u0002J!\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b5\u00106J-\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J!\u0010>\u001a\u0002042\u0006\u00103\u001a\u000204H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b?\u00106J%\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\b\u0010D\u001a\u00020&H\u0002J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ%\u0010K\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010JJ%\u0010M\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010JJ%\u0010O\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010JJ\u001d\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010TJ\b\u0010U\u001a\u00020\u0014H\u0002J \u0010V\u001a\u00020\u0014*\u00020W2\u0006\u0010X\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002J \u0010\\\u001a\u00020\u0014*\u00020W2\u0006\u0010]\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002J\n\u0010^\u001a\u00020&*\u00020WJ \u0010_\u001a\u00020\u0014*\u00020W2\u0006\u0010`\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002J \u0010a\u001a\u00020\u0014*\u00020W2\u0006\u0010b\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00148V@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u000e\u0010!\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010'\u001a\u0004\u0018\u00010(X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010)\u001a\u0004\u0018\u00010*X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020&0\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006c"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "value", "isEnabled", "setEnabled", "isEnabledState", "Landroidx/compose/runtime/MutableState;", "isInProgress", "leftEffect", "leftEffectNegation", "onNewSize", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "rightEffect", "rightEffectNegation", "scrollCycleInProgress", "topEffect", "topEffectNegation", "animateToRelease", "consumePostFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "consumePostFling-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePostScroll", "initialDragDelta", "overscrollDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "consumePostScroll-OMhpSzk", "(JJI)V", "consumePreFling", "consumePreFling-QWom1Mo", "consumePreScroll", "scrollDelta", "consumePreScroll-OzD1aCk", "(JI)J", "invalidateOverscroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "releaseOppositeOverscroll", "delta", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverscroll", "drawRight", "right", "drawTop", "top", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    @NotNull
    private final List<EdgeEffect> allEffects;
    /* access modifiers changed from: private */
    @NotNull
    public final EdgeEffect bottomEffect;
    /* access modifiers changed from: private */
    @NotNull
    public final EdgeEffect bottomEffectNegation;
    /* access modifiers changed from: private */
    public long containerSize;
    @NotNull
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private boolean isEnabled;
    @NotNull
    private final MutableState<Boolean> isEnabledState;
    /* access modifiers changed from: private */
    @NotNull
    public final EdgeEffect leftEffect;
    /* access modifiers changed from: private */
    @NotNull
    public final EdgeEffect leftEffectNegation;
    @NotNull
    private final Function1<IntSize, Unit> onNewSize;
    @NotNull
    private final OverscrollConfiguration overscrollConfig;
    /* access modifiers changed from: private */
    @Nullable
    public PointerId pointerId;
    /* access modifiers changed from: private */
    @Nullable
    public Offset pointerPosition;
    @NotNull
    private final MutableState<Unit> redrawSignal;
    /* access modifiers changed from: private */
    @NotNull
    public final EdgeEffect rightEffect;
    /* access modifiers changed from: private */
    @NotNull
    public final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    /* access modifiers changed from: private */
    @NotNull
    public final EdgeEffect topEffect;
    /* access modifiers changed from: private */
    @NotNull
    public final EdgeEffect topEffectNegation;

    public AndroidEdgeEffectOverscrollEffect(@NotNull Context context, @NotNull OverscrollConfiguration overscrollConfiguration) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(overscrollConfiguration, "overscrollConfig");
        this.overscrollConfig = overscrollConfiguration;
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        EdgeEffect create = edgeEffectCompat.create(context, (AttributeSet) null);
        this.topEffect = create;
        EdgeEffect create2 = edgeEffectCompat.create(context, (AttributeSet) null);
        this.bottomEffect = create2;
        EdgeEffect create3 = edgeEffectCompat.create(context, (AttributeSet) null);
        this.leftEffect = create3;
        EdgeEffect create4 = edgeEffectCompat.create(context, (AttributeSet) null);
        this.rightEffect = create4;
        List<EdgeEffect> listOf = CollectionsKt__CollectionsKt.listOf(create3, create, create4, create2);
        this.allEffects = listOf;
        this.topEffectNegation = edgeEffectCompat.create(context, (AttributeSet) null);
        this.bottomEffectNegation = edgeEffectCompat.create(context, (AttributeSet) null);
        this.leftEffectNegation = edgeEffectCompat.create(context, (AttributeSet) null);
        this.rightEffectNegation = edgeEffectCompat.create(context, (AttributeSet) null);
        int size = listOf.size();
        for (int i11 = 0; i11 < size; i11++) {
            listOf.get(i11).setColor(ColorKt.m2974toArgb8_81llA(this.overscrollConfig.m250getGlowColor0d7_KjU()));
        }
        Unit unit = Unit.INSTANCE;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(unit, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m2754getZeroNHjbRc();
        this.isEnabledState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        AndroidEdgeEffectOverscrollEffect$onNewSize$1 androidEdgeEffectOverscrollEffect$onNewSize$1 = new AndroidEdgeEffectOverscrollEffect$onNewSize$1(this);
        this.onNewSize = androidEdgeEffectOverscrollEffect$onNewSize$1;
        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.then(AndroidOverscrollKt.StretchOverscrollNonClippingLayer), (Object) unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, (Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1>) null)), androidEdgeEffectOverscrollEffect$onNewSize$1);
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1(this);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        this.effectModifier = onSizeChanged.then(new DrawOverscrollModifier(this, function1));
    }

    /* access modifiers changed from: private */
    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            EdgeEffect edgeEffect = list.get(i11);
            edgeEffect.onRelease();
            if (edgeEffect.isFinished() || z11) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (z11) {
            invalidateOverscroll();
        }
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m2745getWidthimpl(this.containerSize), (-Size.m2742getHeightimpl(this.containerSize)) + drawScope.m5447toPx0680j_4(this.overscrollConfig.getDrawPadding().m496calculateBottomPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m2742getHeightimpl(this.containerSize), drawScope.m5447toPx0680j_4(this.overscrollConfig.getDrawPadding().m497calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        int roundToInt = MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(this.containerSize));
        float r22 = this.overscrollConfig.getDrawPadding().m498calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-((float) roundToInt)) + drawScope.m5447toPx0680j_4(r22));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.translate(0.0f, drawScope.m5447toPx0680j_4(this.overscrollConfig.getDrawPadding().m499calculateTopPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    /* access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    /* renamed from: pullBottom-0a9Yr6o  reason: not valid java name */
    private final float m160pullBottom0a9Yr6o(long j11, long j12) {
        float r52 = Offset.m2676getXimpl(j12) / Size.m2745getWidthimpl(this.containerSize);
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.m2677getYimpl(j11) / Size.m2742getHeightimpl(this.containerSize)), ((float) 1) - r52)) * Size.m2742getHeightimpl(this.containerSize);
    }

    /* renamed from: pullLeft-0a9Yr6o  reason: not valid java name */
    private final float m161pullLeft0a9Yr6o(long j11, long j12) {
        float r52 = Offset.m2677getYimpl(j12) / Size.m2742getHeightimpl(this.containerSize);
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.m2676getXimpl(j11) / Size.m2745getWidthimpl(this.containerSize), ((float) 1) - r52) * Size.m2745getWidthimpl(this.containerSize);
    }

    /* renamed from: pullRight-0a9Yr6o  reason: not valid java name */
    private final float m162pullRight0a9Yr6o(long j11, long j12) {
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.m2676getXimpl(j11) / Size.m2745getWidthimpl(this.containerSize)), Offset.m2677getYimpl(j12) / Size.m2742getHeightimpl(this.containerSize))) * Size.m2745getWidthimpl(this.containerSize);
    }

    /* renamed from: pullTop-0a9Yr6o  reason: not valid java name */
    private final float m163pullTop0a9Yr6o(long j11, long j12) {
        float r52 = Offset.m2676getXimpl(j12) / Size.m2745getWidthimpl(this.containerSize);
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.m2677getYimpl(j11) / Size.m2742getHeightimpl(this.containerSize), r52) * Size.m2742getHeightimpl(this.containerSize);
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M  reason: not valid java name */
    private final boolean m164releaseOppositeOverscrollk4lQ0M(long j11) {
        boolean z11;
        boolean z12 = false;
        if (this.leftEffect.isFinished() || Offset.m2676getXimpl(j11) >= 0.0f) {
            z11 = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.m2676getXimpl(j11));
            z11 = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m2676getXimpl(j11) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.m2676getXimpl(j11));
            if (z11 || this.rightEffect.isFinished()) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (!this.topEffect.isFinished() && Offset.m2677getYimpl(j11) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.m2677getYimpl(j11));
            if (z11 || this.topEffect.isFinished()) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        if (this.bottomEffect.isFinished() || Offset.m2677getYimpl(j11) <= 0.0f) {
            return z11;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.m2677getYimpl(j11));
        if (z11 || this.bottomEffect.isFinished()) {
            z12 = true;
        }
        return z12;
    }

    private final boolean stopOverscrollAnimation() {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        long r02 = SizeKt.m2755getCenteruvyYCjk(this.containerSize);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        boolean z15 = false;
        if (edgeEffectCompat.getDistanceCompat(this.leftEffect) == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            m161pullLeft0a9Yr6o(Offset.Companion.m2692getZeroF1C5BW0(), r02);
            z12 = true;
        } else {
            z12 = false;
        }
        if (edgeEffectCompat.getDistanceCompat(this.rightEffect) == 0.0f) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            m162pullRight0a9Yr6o(Offset.Companion.m2692getZeroF1C5BW0(), r02);
            z12 = true;
        }
        if (edgeEffectCompat.getDistanceCompat(this.topEffect) == 0.0f) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (!z14) {
            m163pullTop0a9Yr6o(Offset.Companion.m2692getZeroF1C5BW0(), r02);
            z12 = true;
        }
        if (edgeEffectCompat.getDistanceCompat(this.bottomEffect) == 0.0f) {
            z15 = true;
        }
        if (z15) {
            return z12;
        }
        m160pullBottom0a9Yr6o(Offset.Companion.m2692getZeroF1C5BW0(), r02);
        return true;
    }

    @Nullable
    /* renamed from: consumePostFling-sF-c-tU  reason: not valid java name */
    public Object m165consumePostFlingsFctU(long j11, @NotNull Continuation<? super Unit> continuation) {
        if (Size.m2747isEmptyimpl(this.containerSize)) {
            return Unit.INSTANCE;
        }
        this.scrollCycleInProgress = false;
        if (Velocity.m5703getXimpl(j11) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, MathKt__MathJVMKt.roundToInt(Velocity.m5703getXimpl(j11)));
        } else if (Velocity.m5703getXimpl(j11) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -MathKt__MathJVMKt.roundToInt(Velocity.m5703getXimpl(j11)));
        }
        if (Velocity.m5704getYimpl(j11) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, MathKt__MathJVMKt.roundToInt(Velocity.m5704getYimpl(j11)));
        } else if (Velocity.m5704getYimpl(j11) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -MathKt__MathJVMKt.roundToInt(Velocity.m5704getYimpl(j11)));
        }
        if (!Velocity.m5702equalsimpl0(j11, Velocity.Companion.m5714getZero9UxMQ8M())) {
            invalidateOverscroll();
        }
        animateToRelease();
        return Unit.INSTANCE;
    }

    /* renamed from: consumePostScroll-OMhpSzk  reason: not valid java name */
    public void m166consumePostScrollOMhpSzk(long j11, long j12, int i11) {
        boolean z11;
        long j13;
        if (!Size.m2747isEmptyimpl(this.containerSize)) {
            boolean z12 = true;
            if (NestedScrollSource.m4213equalsimpl0(i11, NestedScrollSource.Companion.m4218getDragWNlRxjI())) {
                Offset offset = this.pointerPosition;
                if (offset != null) {
                    j13 = offset.m2686unboximpl();
                } else {
                    j13 = SizeKt.m2755getCenteruvyYCjk(this.containerSize);
                }
                if (Offset.m2676getXimpl(j12) > 0.0f) {
                    m161pullLeft0a9Yr6o(j12, j13);
                } else if (Offset.m2676getXimpl(j12) < 0.0f) {
                    m162pullRight0a9Yr6o(j12, j13);
                }
                if (Offset.m2677getYimpl(j12) > 0.0f) {
                    m163pullTop0a9Yr6o(j12, j13);
                } else if (Offset.m2677getYimpl(j12) < 0.0f) {
                    m160pullBottom0a9Yr6o(j12, j13);
                }
                z11 = !Offset.m2673equalsimpl0(j12, Offset.Companion.m2692getZeroF1C5BW0());
            } else {
                z11 = false;
            }
            if (!m164releaseOppositeOverscrollk4lQ0M(j11) && !z11) {
                z12 = false;
            }
            if (z12) {
                invalidateOverscroll();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d3  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: consumePreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m167consumePreFlingQWom1Mo(long r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r8) {
        /*
            r5 = this;
            long r0 = r5.containerSize
            boolean r8 = androidx.compose.ui.geometry.Size.m2747isEmptyimpl(r0)
            if (r8 == 0) goto L_0x0013
            androidx.compose.ui.unit.Velocity$Companion r6 = androidx.compose.ui.unit.Velocity.Companion
            long r6 = r6.m5714getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m5694boximpl(r6)
            return r6
        L_0x0013:
            float r8 = androidx.compose.ui.unit.Velocity.m5703getXimpl(r6)
            r0 = 0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r8 <= 0) goto L_0x0041
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.leftEffect
            float r3 = r8.getDistanceCompat(r3)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x002c
            r3 = r1
            goto L_0x002d
        L_0x002c:
            r3 = r2
        L_0x002d:
            if (r3 != 0) goto L_0x0041
            android.widget.EdgeEffect r3 = r5.leftEffect
            float r4 = androidx.compose.ui.unit.Velocity.m5703getXimpl(r6)
            int r4 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r4)
            r8.onAbsorbCompat(r3, r4)
            float r8 = androidx.compose.ui.unit.Velocity.m5703getXimpl(r6)
            goto L_0x006e
        L_0x0041:
            float r8 = androidx.compose.ui.unit.Velocity.m5703getXimpl(r6)
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x006d
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.rightEffect
            float r3 = r8.getDistanceCompat(r3)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x0057
            r3 = r1
            goto L_0x0058
        L_0x0057:
            r3 = r2
        L_0x0058:
            if (r3 != 0) goto L_0x006d
            android.widget.EdgeEffect r3 = r5.rightEffect
            float r4 = androidx.compose.ui.unit.Velocity.m5703getXimpl(r6)
            int r4 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r4)
            int r4 = -r4
            r8.onAbsorbCompat(r3, r4)
            float r8 = androidx.compose.ui.unit.Velocity.m5703getXimpl(r6)
            goto L_0x006e
        L_0x006d:
            r8 = r0
        L_0x006e:
            float r3 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r6)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0099
            androidx.compose.foundation.EdgeEffectCompat r3 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r5.topEffect
            float r4 = r3.getDistanceCompat(r4)
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x0084
            r4 = r1
            goto L_0x0085
        L_0x0084:
            r4 = r2
        L_0x0085:
            if (r4 != 0) goto L_0x0099
            android.widget.EdgeEffect r0 = r5.topEffect
            float r1 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r6)
            int r1 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r1)
            r3.onAbsorbCompat(r0, r1)
            float r0 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r6)
            goto L_0x00c3
        L_0x0099:
            float r3 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r6)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x00c3
            androidx.compose.foundation.EdgeEffectCompat r3 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r5.bottomEffect
            float r4 = r3.getDistanceCompat(r4)
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x00ae
            goto L_0x00af
        L_0x00ae:
            r1 = r2
        L_0x00af:
            if (r1 != 0) goto L_0x00c3
            android.widget.EdgeEffect r0 = r5.bottomEffect
            float r1 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r6)
            int r1 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r1)
            int r1 = -r1
            r3.onAbsorbCompat(r0, r1)
            float r0 = androidx.compose.ui.unit.Velocity.m5704getYimpl(r6)
        L_0x00c3:
            long r6 = androidx.compose.ui.unit.VelocityKt.Velocity(r8, r0)
            androidx.compose.ui.unit.Velocity$Companion r8 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r8.m5714getZero9UxMQ8M()
            boolean r8 = androidx.compose.ui.unit.Velocity.m5702equalsimpl0(r6, r0)
            if (r8 != 0) goto L_0x00d6
            r5.invalidateOverscroll()
        L_0x00d6:
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m5694boximpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m167consumePreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f9  */
    /* renamed from: consumePreScroll-OzD1aCk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m168consumePreScrollOzD1aCk(long r8, int r10) {
        /*
            r7 = this;
            long r0 = r7.containerSize
            boolean r10 = androidx.compose.ui.geometry.Size.m2747isEmptyimpl(r0)
            if (r10 == 0) goto L_0x000f
            androidx.compose.ui.geometry.Offset$Companion r8 = androidx.compose.ui.geometry.Offset.Companion
            long r8 = r8.m2692getZeroF1C5BW0()
            return r8
        L_0x000f:
            boolean r10 = r7.scrollCycleInProgress
            r0 = 1
            if (r10 != 0) goto L_0x0019
            r7.stopOverscrollAnimation()
            r7.scrollCycleInProgress = r0
        L_0x0019:
            androidx.compose.ui.geometry.Offset r10 = r7.pointerPosition
            if (r10 == 0) goto L_0x0022
            long r1 = r10.m2686unboximpl()
            goto L_0x0028
        L_0x0022:
            long r1 = r7.containerSize
            long r1 = androidx.compose.ui.geometry.SizeKt.m2755getCenteruvyYCjk(r1)
        L_0x0028:
            float r10 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r8)
            r3 = 0
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            r4 = 0
            if (r10 != 0) goto L_0x0034
            r10 = r0
            goto L_0x0035
        L_0x0034:
            r10 = r4
        L_0x0035:
            if (r10 == 0) goto L_0x0039
        L_0x0037:
            r5 = r3
            goto L_0x008a
        L_0x0039:
            androidx.compose.foundation.EdgeEffectCompat r10 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r5 = r7.topEffect
            float r5 = r10.getDistanceCompat(r5)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0047
            r5 = r0
            goto L_0x0048
        L_0x0047:
            r5 = r4
        L_0x0048:
            if (r5 != 0) goto L_0x0063
            float r5 = r7.m163pullTop0a9Yr6o(r8, r1)
            android.widget.EdgeEffect r6 = r7.topEffect
            float r10 = r10.getDistanceCompat(r6)
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 != 0) goto L_0x005a
            r10 = r0
            goto L_0x005b
        L_0x005a:
            r10 = r4
        L_0x005b:
            if (r10 == 0) goto L_0x008a
            android.widget.EdgeEffect r10 = r7.topEffect
            r10.onRelease()
            goto L_0x008a
        L_0x0063:
            android.widget.EdgeEffect r5 = r7.bottomEffect
            float r5 = r10.getDistanceCompat(r5)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x006f
            r5 = r0
            goto L_0x0070
        L_0x006f:
            r5 = r4
        L_0x0070:
            if (r5 != 0) goto L_0x0037
            float r5 = r7.m160pullBottom0a9Yr6o(r8, r1)
            android.widget.EdgeEffect r6 = r7.bottomEffect
            float r10 = r10.getDistanceCompat(r6)
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 != 0) goto L_0x0082
            r10 = r0
            goto L_0x0083
        L_0x0082:
            r10 = r4
        L_0x0083:
            if (r10 == 0) goto L_0x008a
            android.widget.EdgeEffect r10 = r7.bottomEffect
            r10.onRelease()
        L_0x008a:
            float r10 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r8)
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 != 0) goto L_0x0094
            r10 = r0
            goto L_0x0095
        L_0x0094:
            r10 = r4
        L_0x0095:
            if (r10 == 0) goto L_0x0098
            goto L_0x00e9
        L_0x0098:
            androidx.compose.foundation.EdgeEffectCompat r10 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r6 = r7.leftEffect
            float r6 = r10.getDistanceCompat(r6)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x00a6
            r6 = r0
            goto L_0x00a7
        L_0x00a6:
            r6 = r4
        L_0x00a7:
            if (r6 != 0) goto L_0x00c2
            float r8 = r7.m161pullLeft0a9Yr6o(r8, r1)
            android.widget.EdgeEffect r9 = r7.leftEffect
            float r9 = r10.getDistanceCompat(r9)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r0 = r4
        L_0x00b9:
            if (r0 == 0) goto L_0x00c0
            android.widget.EdgeEffect r9 = r7.leftEffect
            r9.onRelease()
        L_0x00c0:
            r3 = r8
            goto L_0x00e9
        L_0x00c2:
            android.widget.EdgeEffect r6 = r7.rightEffect
            float r6 = r10.getDistanceCompat(r6)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x00ce
            r6 = r0
            goto L_0x00cf
        L_0x00ce:
            r6 = r4
        L_0x00cf:
            if (r6 != 0) goto L_0x00e9
            float r8 = r7.m162pullRight0a9Yr6o(r8, r1)
            android.widget.EdgeEffect r9 = r7.rightEffect
            float r9 = r10.getDistanceCompat(r9)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x00e0
            goto L_0x00e1
        L_0x00e0:
            r0 = r4
        L_0x00e1:
            if (r0 == 0) goto L_0x00c0
            android.widget.EdgeEffect r9 = r7.rightEffect
            r9.onRelease()
            goto L_0x00c0
        L_0x00e9:
            long r8 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r5)
            androidx.compose.ui.geometry.Offset$Companion r10 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r10.m2692getZeroF1C5BW0()
            boolean r10 = androidx.compose.ui.geometry.Offset.m2673equalsimpl0(r8, r0)
            if (r10 != 0) goto L_0x00fc
            r7.invalidateOverscroll()
        L_0x00fc:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m168consumePreScrollOzD1aCk(long, int):long");
    }

    public final void drawOverscroll(@NotNull DrawScope drawScope) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (!Size.m2747isEmptyimpl(this.containerSize)) {
            androidx.compose.ui.graphics.Canvas canvas = drawScope.getDrawContext().getCanvas();
            this.redrawSignal.getValue();
            Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
            EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
            boolean z18 = true;
            if (edgeEffectCompat.getDistanceCompat(this.leftEffectNegation) == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
                this.leftEffectNegation.finish();
            }
            if (!this.leftEffect.isFinished()) {
                z12 = drawLeft(drawScope, this.leftEffect, nativeCanvas);
                edgeEffectCompat.onPullDistanceCompat(this.leftEffectNegation, edgeEffectCompat.getDistanceCompat(this.leftEffect), 0.0f);
            } else {
                z12 = false;
            }
            if (edgeEffectCompat.getDistanceCompat(this.topEffectNegation) == 0.0f) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (!z13) {
                drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
                this.topEffectNegation.finish();
            }
            if (!this.topEffect.isFinished()) {
                if (drawTop(drawScope, this.topEffect, nativeCanvas) || z12) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                edgeEffectCompat.onPullDistanceCompat(this.topEffectNegation, edgeEffectCompat.getDistanceCompat(this.topEffect), 0.0f);
            }
            if (edgeEffectCompat.getDistanceCompat(this.rightEffectNegation) == 0.0f) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (!z14) {
                drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
                this.rightEffectNegation.finish();
            }
            if (!this.rightEffect.isFinished()) {
                if (drawRight(drawScope, this.rightEffect, nativeCanvas) || z12) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                edgeEffectCompat.onPullDistanceCompat(this.rightEffectNegation, edgeEffectCompat.getDistanceCompat(this.rightEffect), 0.0f);
            }
            if (edgeEffectCompat.getDistanceCompat(this.bottomEffectNegation) == 0.0f) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (!z15) {
                drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
                this.bottomEffectNegation.finish();
            }
            if (!this.bottomEffect.isFinished()) {
                if (!drawBottom(drawScope, this.bottomEffect, nativeCanvas) && !z12) {
                    z18 = false;
                }
                edgeEffectCompat.onPullDistanceCompat(this.bottomEffectNegation, edgeEffectCompat.getDistanceCompat(this.bottomEffect), 0.0f);
                z12 = z18;
            }
            if (z12) {
                invalidateOverscroll();
            }
        }
    }

    @NotNull
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    public boolean isEnabled() {
        return this.isEnabledState.getValue().booleanValue();
    }

    public boolean isInProgress() {
        boolean z11;
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(list.get(i11)) == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                return true;
            }
        }
        return false;
    }

    public void setEnabled(boolean z11) {
        boolean z12;
        if (this.isEnabled != z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.isEnabledState.setValue(Boolean.valueOf(z11));
        this.isEnabled = z11;
        if (z12) {
            this.scrollCycleInProgress = false;
            animateToRelease();
        }
    }

    public final void setInvalidationEnabled$foundation_release(boolean z11) {
        this.invalidationEnabled = z11;
    }
}
