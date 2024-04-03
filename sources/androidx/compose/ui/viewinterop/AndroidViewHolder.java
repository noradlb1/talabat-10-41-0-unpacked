package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0017\b \u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010M\u001a\u00020\u00122\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\n\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020\u0014H\u0016J\u001e\u0010S\u001a\u0004\u0018\u00010T2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020\u0012H\u0016J \u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\u00142\u0006\u0010[\u001a\u00020\u0014H\u0002J\b\u0010\\\u001a\u00020,H\u0014J\u0018\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020GH\u0016J\b\u0010`\u001a\u00020,H\u0014J0\u0010a\u001a\u00020,2\u0006\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u00142\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u0014H\u0014J\u0018\u0010g\u001a\u00020,2\u0006\u0010h\u001a\u00020\u00142\u0006\u0010i\u001a\u00020\u0014H\u0014J(\u0010j\u001a\u00020\u00122\u0006\u0010_\u001a\u00020G2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020l2\u0006\u0010n\u001a\u00020\u0012H\u0016J \u0010o\u001a\u00020\u00122\u0006\u0010_\u001a\u00020G2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020lH\u0016J0\u0010p\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010q\u001a\u00020\u00142\u0006\u0010r\u001a\u00020\u00142\u0006\u0010n\u001a\u00020!2\u0006\u0010s\u001a\u00020\u0014H\u0016J8\u0010t\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010u\u001a\u00020\u00142\u0006\u0010v\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u0014H\u0016J@\u0010t\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010u\u001a\u00020\u00142\u0006\u0010v\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u00142\u0006\u0010n\u001a\u00020!H\u0016J(\u0010y\u001a\u00020,2\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020G2\u0006\u0010z\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u0014H\u0016J(\u0010{\u001a\u00020\u00122\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020G2\u0006\u0010z\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u0014H\u0016J\u0018\u0010|\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010s\u001a\u00020\u0014H\u0016J\u0010\u0010}\u001a\u00020,2\u0006\u0010~\u001a\u00020\u0014H\u0014J\u0006\u0010\u001a\u00020,J\u0012\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0001\u001a\u00020\u0012H\u0016R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u001a@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\"@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000R(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R(\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020,09X\u0004¢\u0006\u0002\n\u0000R(\u0010;\u001a\u0004\u0018\u00010:2\b\u0010\n\u001a\u0004\u0018\u00010:@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R0\u0010B\u001a\b\u0012\u0004\u0012\u00020,092\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020,09@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\n\u001a\u0004\u0018\u00010G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "hasUpdateBlock", "", "lastHeightMeasureSpec", "", "lastWidthMeasureSpec", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "location", "", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onCommitAffectingUpdate", "Lkotlin/Function1;", "", "onDensityChanged", "getOnDensityChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnDensityChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onModifierChanged", "getOnModifierChanged$ui_release", "setOnModifierChanged$ui_release", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "runUpdate", "Lkotlin/Function0;", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "snapshotObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "update", "getUpdate", "()Lkotlin/jvm/functions/Function0;", "setUpdate", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "setView$ui_release", "(Landroid/view/View;)V", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getNestedScrollAxes", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "isNestedScrollingEnabled", "obtainMeasureSpec", "min", "max", "preferred", "onAttachedToWindow", "onDescendantInvalidated", "child", "target", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "velocityX", "", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "axes", "onStartNestedScroll", "onStopNestedScroll", "onWindowVisibilityChanged", "visibility", "remeasure", "requestDisallowInterceptTouchEvent", "disallowIntercept", "shouldDelayChildPressedState", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3 {
    @NotNull
    private Density density;
    /* access modifiers changed from: private */
    @NotNull
    public final NestedScrollDispatcher dispatcher;
    /* access modifiers changed from: private */
    public boolean hasUpdateBlock;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    @NotNull
    private final LayoutNode layoutNode;
    @Nullable
    private LifecycleOwner lifecycleOwner;
    @NotNull
    private final int[] location;
    @NotNull
    private Modifier modifier;
    @NotNull
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<AndroidViewHolder, Unit> onCommitAffectingUpdate;
    @Nullable
    private Function1<? super Density, Unit> onDensityChanged;
    @Nullable
    private Function1<? super Modifier, Unit> onModifierChanged;
    @Nullable
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Unit> runUpdate;
    @Nullable
    private SavedStateRegistryOwner savedStateRegistryOwner;
    /* access modifiers changed from: private */
    @NotNull
    public final SnapshotStateObserver snapshotObserver;
    @NotNull
    private Function0<Unit> update;
    @Nullable
    private View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder(@NotNull Context context, @Nullable CompositionContext compositionContext, @NotNull NestedScrollDispatcher nestedScrollDispatcher) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "dispatcher");
        this.dispatcher = nestedScrollDispatcher;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        this.update = AndroidViewHolder$update$1.INSTANCE;
        Modifier.Companion companion = Modifier.Companion;
        this.modifier = companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
        this.snapshotObserver = new SnapshotStateObserver(new AndroidViewHolder$snapshotObserver$1(this));
        this.onCommitAffectingUpdate = new AndroidViewHolder$onCommitAffectingUpdate$1(this);
        this.runUpdate = new AndroidViewHolder$runUpdate$1(this);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        LayoutNode layoutNode2 = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(companion, this), new AndroidViewHolder$layoutNode$1$coreModifier$1(layoutNode2, this)), new AndroidViewHolder$layoutNode$1$coreModifier$2(this, layoutNode2));
        layoutNode2.setModifier(this.modifier.then(onGloballyPositioned));
        this.onModifierChanged = new AndroidViewHolder$layoutNode$1$1(layoutNode2, onGloballyPositioned);
        layoutNode2.setDensity(this.density);
        this.onDensityChanged = new AndroidViewHolder$layoutNode$1$2(layoutNode2);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        layoutNode2.setOnAttach$ui_release(new AndroidViewHolder$layoutNode$1$3(this, layoutNode2, objectRef));
        layoutNode2.setOnDetach$ui_release(new AndroidViewHolder$layoutNode$1$4(this, objectRef));
        layoutNode2.setMeasurePolicy(new AndroidViewHolder$layoutNode$1$5(this, layoutNode2));
        this.layoutNode = layoutNode2;
    }

    /* access modifiers changed from: private */
    public final int obtainMeasureSpec(int i11, int i12, int i13) {
        if (i13 >= 0 || i11 == i12) {
            return View.MeasureSpec.makeMeasureSpec(RangesKt___RangesKt.coerceIn(i13, i11, i12), 1073741824);
        }
        if (i13 == -2 && i12 != Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
        }
        if (i13 != -1 || i12 == Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
    }

    public boolean gatherTransparentRegion(@Nullable Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        int i11 = iArr[0];
        region.op(i11, iArr[1], i11 + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Nullable
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams;
        View view2 = this.view;
        if (view2 == null || (layoutParams = view2.getLayoutParams()) == null) {
            return new ViewGroup.LayoutParams(-1, -1);
        }
        return layoutParams;
    }

    @Nullable
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Nullable
    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    @Nullable
    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    @Nullable
    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    @Nullable
    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    @NotNull
    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    @Nullable
    public final View getView() {
        return this.view;
    }

    @Nullable
    public ViewParent invalidateChildInParent(@Nullable int[] iArr, @Nullable Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        this.layoutNode.invalidateLayer$ui_release();
        return null;
    }

    public boolean isNestedScrollingEnabled() {
        View view2 = this.view;
        return view2 != null ? view2.isNestedScrollingEnabled() : super.isNestedScrollingEnabled();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotObserver.start();
    }

    public void onDescendantInvalidated(@NotNull View view2, @NotNull View view3) {
        Intrinsics.checkNotNullParameter(view2, "child");
        Intrinsics.checkNotNullParameter(view3, "target");
        super.onDescendantInvalidated(view2, view3);
        this.layoutNode.invalidateLayer$ui_release();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotObserver.stop();
        this.snapshotObserver.clear();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        View view2 = this.view;
        if (view2 != null) {
            view2.layout(0, 0, i13 - i11, i14 - i12);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        View view2 = this.view;
        if (view2 != null) {
            view2.measure(i11, i12);
        }
        View view3 = this.view;
        int i14 = 0;
        if (view3 != null) {
            i13 = view3.getMeasuredWidth();
        } else {
            i13 = 0;
        }
        View view4 = this.view;
        if (view4 != null) {
            i14 = view4.getMeasuredHeight();
        }
        setMeasuredDimension(i13, i14);
        this.lastWidthMeasureSpec = i11;
        this.lastHeightMeasureSpec = i12;
    }

    public boolean onNestedFling(@NotNull View view2, float f11, float f12, boolean z11) {
        View view3 = view2;
        Intrinsics.checkNotNullParameter(view2, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        long Velocity = VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f11), AndroidViewHolder_androidKt.toComposeVelocity(f12));
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidViewHolder$onNestedFling$1(z11, this, Velocity, (Continuation<? super AndroidViewHolder$onNestedFling$1>) null), 3, (Object) null);
        return false;
    }

    public boolean onNestedPreFling(@NotNull View view2, float f11, float f12) {
        Intrinsics.checkNotNullParameter(view2, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidViewHolder$onNestedPreFling$1(this, VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f11), AndroidViewHolder_androidKt.toComposeVelocity(f12)), (Continuation<? super AndroidViewHolder$onNestedPreFling$1>) null), 3, (Object) null);
        return false;
    }

    public void onNestedPreScroll(@NotNull View view2, int i11, int i12, @NotNull int[] iArr, int i13) {
        Intrinsics.checkNotNullParameter(view2, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (isNestedScrollingEnabled()) {
            long r22 = this.dispatcher.m4205dispatchPreScrollOzD1aCk(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i11), AndroidViewHolder_androidKt.toComposeOffset(i12)), AndroidViewHolder_androidKt.toNestedScrollSource(i13));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2676getXimpl(r22));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2677getYimpl(r22));
        }
    }

    public void onNestedScroll(@NotNull View view2, int i11, int i12, int i13, int i14, int i15, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(view2, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (isNestedScrollingEnabled()) {
            long r72 = this.dispatcher.m4203dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i11), AndroidViewHolder_androidKt.toComposeOffset(i12)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i13), AndroidViewHolder_androidKt.toComposeOffset(i14)), AndroidViewHolder_androidKt.toNestedScrollSource(i15));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2676getXimpl(r72));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2677getYimpl(r72));
        }
    }

    public void onNestedScrollAccepted(@NotNull View view2, @NotNull View view3, int i11, int i12) {
        Intrinsics.checkNotNullParameter(view2, "child");
        Intrinsics.checkNotNullParameter(view3, "target");
        this.nestedScrollingParentHelper.onNestedScrollAccepted(view2, view3, i11, i12);
    }

    public boolean onStartNestedScroll(@NotNull View view2, @NotNull View view3, int i11, int i12) {
        Intrinsics.checkNotNullParameter(view2, "child");
        Intrinsics.checkNotNullParameter(view3, "target");
        return ((i11 & 2) == 0 && (i11 & 1) == 0) ? false : true;
    }

    public void onStopNestedScroll(@NotNull View view2, int i11) {
        Intrinsics.checkNotNullParameter(view2, "target");
        this.nestedScrollingParentHelper.onStopNestedScroll(view2, i11);
    }

    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
    }

    public final void remeasure() {
        int i11;
        int i12 = this.lastWidthMeasureSpec;
        if (i12 != Integer.MIN_VALUE && (i11 = this.lastHeightMeasureSpec) != Integer.MIN_VALUE) {
            measure(i12, i11);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z11) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z11));
        }
        super.requestDisallowInterceptTouchEvent(z11);
    }

    public final void setDensity(@NotNull Density density2) {
        Intrinsics.checkNotNullParameter(density2, "value");
        if (density2 != this.density) {
            this.density = density2;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(density2);
            }
        }
    }

    public final void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner2) {
        if (lifecycleOwner2 != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner2;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner2);
        }
    }

    public final void setModifier(@NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier2, "value");
        if (modifier2 != this.modifier) {
            this.modifier = modifier2;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(modifier2);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(@Nullable Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final void setOnModifierChanged$ui_release(@Nullable Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(@Nullable Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    public final void setSavedStateRegistryOwner(@Nullable SavedStateRegistryOwner savedStateRegistryOwner2) {
        if (savedStateRegistryOwner2 != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner2);
        }
    }

    public final void setUpdate(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "value");
        this.update = function0;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final void setView$ui_release(@Nullable View view2) {
        if (view2 != this.view) {
            this.view = view2;
            removeAllViewsInLayout();
            if (view2 != null) {
                addView(view2);
                this.runUpdate.invoke();
            }
        }
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public void onNestedScroll(@NotNull View view2, int i11, int i12, int i13, int i14, int i15) {
        Intrinsics.checkNotNullParameter(view2, "target");
        if (isNestedScrollingEnabled()) {
            this.dispatcher.m4203dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i11), AndroidViewHolder_androidKt.toComposeOffset(i12)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i13), AndroidViewHolder_androidKt.toComposeOffset(i14)), AndroidViewHolder_androidKt.toNestedScrollSource(i15));
        }
    }
}
