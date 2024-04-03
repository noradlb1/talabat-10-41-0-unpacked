package androidx.compose.material3.internal;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.google.android.material.badge.BadgeDrawable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m0.d2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B=\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\r\u0010P\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020)H\u0002J\u0006\u0010S\u001a\u00020\u0006J\u0010\u0010T\u001a\u00020\u00132\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020\u0006H\u0016J\u0012\u0010X\u001a\u00020\u00132\b\u0010U\u001a\u0004\u0018\u00010YH\u0016J&\u0010\u001d\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020[2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0019¢\u0006\u0002\u0010\\J\u0010\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020_H\u0016J\u0006\u0010`\u001a\u00020\u0006J\u0010\u0010a\u001a\u00020\u00062\u0006\u0010^\u001a\u000201H\u0002J&\u0010b\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010^\u001a\u000201J\u0006\u0010c\u001a\u00020\u0006J\f\u0010d\u001a\u00020$*\u00020CH\u0002R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000RA\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00198B@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR%\u0010!\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00130\"X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0019\u0010%\u001a\u00020&X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R/\u0010*\u001a\u0004\u0018\u00010$2\b\u0010\u0018\u001a\u0004\u0018\u00010$8F@FX\u0002¢\u0006\u0012\n\u0004\b/\u0010 \u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R8\u00107\u001a\u0004\u0018\u0001062\b\u0010\u0018\u001a\u0004\u0018\u0001068F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b<\u0010 \u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010=\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0015R\u0014\u0010F\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020CX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, d2 = {"Landroidx/compose/material3/internal/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onDismissRequest", "Lkotlin/Function0;", "", "testTag", "", "composeView", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupId", "Ljava/util/UUID;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroid/view/View;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/window/PopupPositionProvider;Ljava/util/UUID;)V", "canCalculatePosition", "", "getCanCalculatePosition", "()Z", "canCalculatePosition$delegate", "Landroidx/compose/runtime/State;", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "dismissOnOutsideClick", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/IntRect;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "params", "Landroid/view/WindowManager$LayoutParams;", "parentBounds", "getParentBounds", "()Landroidx/compose/ui/unit/IntRect;", "setParentBounds", "(Landroidx/compose/ui/unit/IntRect;)V", "parentBounds$delegate", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setParentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/unit/IntSize;", "popupContentSize", "getPopupContentSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPopupContentSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "popupContentSize$delegate", "positionProvider", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "setPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "previousWindowVisibleFrame", "Landroid/graphics/Rect;", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "subCompositionView", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "tmpWindowVisibleFrame", "windowManager", "Landroid/view/WindowManager;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "createLayoutParams", "dismiss", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "onGlobalLayout", "onTouchEvent", "Landroid/view/MotionEvent;", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "layoutDirection", "", "show", "superSetLayoutDirection", "updateParameters", "updatePosition", "toIntBounds", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ViewConstructor"})
final class PopupLayout extends AbstractComposeView implements ViewRootForInspector, ViewTreeObserver.OnGlobalLayoutListener {
    @NotNull
    private final State canCalculatePosition$delegate;
    @NotNull
    private final View composeView;
    @NotNull
    private final MutableState content$delegate;
    @NotNull
    private final Function2<Offset, IntRect, Boolean> dismissOnOutsideClick;
    private final float maxSupportedElevation;
    @Nullable
    private Function0<Unit> onDismissRequest;
    @NotNull
    private final WindowManager.LayoutParams params = createLayoutParams();
    @NotNull
    private final MutableState parentBounds$delegate;
    @NotNull
    private LayoutDirection parentLayoutDirection;
    @NotNull
    private final MutableState popupContentSize$delegate;
    @NotNull
    private PopupPositionProvider positionProvider;
    @NotNull
    private final Rect previousWindowVisibleFrame;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    @NotNull
    private String testTag;
    @NotNull
    private final Rect tmpWindowVisibleFrame;
    @NotNull
    private final WindowManager windowManager;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PopupLayout(@org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull android.view.View r10, @org.jetbrains.annotations.NotNull androidx.compose.ui.unit.Density r11, @org.jetbrains.annotations.NotNull androidx.compose.ui.window.PopupPositionProvider r12, @org.jetbrains.annotations.NotNull java.util.UUID r13) {
        /*
            r7 = this;
            java.lang.String r0 = "testTag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "composeView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "initialPositionProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "popupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            android.content.Context r2 = r10.getContext()
            java.lang.String r0 = "composeView.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r7.onDismissRequest = r8
            r7.testTag = r9
            r7.composeView = r10
            android.content.Context r8 = r10.getContext()
            java.lang.String r9 = "window"
            java.lang.Object r8 = r8.getSystemService(r9)
            java.lang.String r9 = "null cannot be cast to non-null type android.view.WindowManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r9)
            android.view.WindowManager r8 = (android.view.WindowManager) r8
            r7.windowManager = r8
            android.view.WindowManager$LayoutParams r8 = r7.createLayoutParams()
            r7.params = r8
            r7.positionProvider = r12
            androidx.compose.ui.unit.LayoutDirection r8 = androidx.compose.ui.unit.LayoutDirection.Ltr
            r7.parentLayoutDirection = r8
            r8 = 0
            r9 = 2
            androidx.compose.runtime.MutableState r12 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r8, r8, r9, r8)
            r7.parentBounds$delegate = r12
            androidx.compose.runtime.MutableState r12 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r8, r8, r9, r8)
            r7.popupContentSize$delegate = r12
            androidx.compose.material3.internal.PopupLayout$canCalculatePosition$2 r12 = new androidx.compose.material3.internal.PopupLayout$canCalculatePosition$2
            r12.<init>(r7)
            androidx.compose.runtime.State r12 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r12)
            r7.canCalculatePosition$delegate = r12
            r12 = 8
            float r12 = (float) r12
            float r12 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r12)
            r7.maxSupportedElevation = r12
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.previousWindowVisibleFrame = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.tmpWindowVisibleFrame = r0
            androidx.compose.material3.internal.PopupLayout$dismissOnOutsideClick$1 r0 = androidx.compose.material3.internal.PopupLayout$dismissOnOutsideClick$1.INSTANCE
            r7.dismissOnOutsideClick = r0
            r0 = 16908290(0x1020002, float:2.3877235E-38)
            r7.setId(r0)
            androidx.lifecycle.LifecycleOwner r0 = androidx.lifecycle.ViewTreeLifecycleOwner.get(r10)
            androidx.lifecycle.ViewTreeLifecycleOwner.set(r7, r0)
            androidx.lifecycle.ViewModelStoreOwner r0 = androidx.lifecycle.ViewTreeViewModelStoreOwner.get(r10)
            androidx.lifecycle.ViewTreeViewModelStoreOwner.set(r7, r0)
            androidx.savedstate.SavedStateRegistryOwner r0 = androidx.savedstate.ViewTreeSavedStateRegistryOwner.get(r10)
            androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(r7, r0)
            android.view.ViewTreeObserver r10 = r10.getViewTreeObserver()
            r10.addOnGlobalLayoutListener(r7)
            int r10 = androidx.compose.ui.R.id.compose_view_saveable_id_tag
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Popup:"
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r7.setTag(r10, r13)
            r10 = 0
            r7.setClipChildren(r10)
            float r10 = r11.m5447toPx0680j_4(r12)
            r7.setElevation(r10)
            androidx.compose.material3.internal.PopupLayout$2 r10 = new androidx.compose.material3.internal.PopupLayout$2
            r10.<init>()
            r7.setOutlineProvider(r10)
            androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopupKt r10 = androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopupKt.INSTANCE
            kotlin.jvm.functions.Function2 r10 = r10.m2012getLambda1$material3_release()
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r10, r8, r9, r8)
            r7.content$delegate = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.PopupLayout.<init>(kotlin.jvm.functions.Function0, java.lang.String, android.view.View, androidx.compose.ui.unit.Density, androidx.compose.ui.window.PopupPositionProvider, java.util.UUID):void");
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.flags = 393248;
        layoutParams.softInputMode = 1;
        layoutParams.type = 1000;
        layoutParams.token = this.composeView.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(this.composeView.getContext().getResources().getString(R.string.default_popup_window_title));
        return layoutParams;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content$delegate.setValue(function2);
    }

    private final void superSetLayoutDirection(LayoutDirection layoutDirection) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i12 = 1;
        if (i11 == 1) {
            i12 = 0;
        } else if (i11 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        super.setLayoutDirection(i12);
    }

    private final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-797839545);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-797839545, i11, -1, "androidx.compose.material3.internal.PopupLayout.Content (ExposedDropdownMenuPopup.kt:300)");
        }
        getContent().invoke(startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PopupLayout$Content$4(this, i11));
        }
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.set(this, (LifecycleOwner) null);
        this.composeView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.windowManager.removeViewImmediate(this);
    }

    public boolean dispatchKeyEvent(@NotNull KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (keyEvent.getKeyCode() == 4) {
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                }
                return true;
            } else if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                Function0<Unit> function0 = this.onDismissRequest;
                if (function0 != null) {
                    function0.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final IntRect getParentBounds() {
        return (IntRect) this.parentBounds$delegate.getValue();
    }

    @NotNull
    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    @Nullable
    /* renamed from: getPopupContentSize-bOM6tXw  reason: not valid java name */
    public final IntSize m2018getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize$delegate.getValue();
    }

    @NotNull
    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @NotNull
    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    @NotNull
    public final String getTestTag() {
        return this.testTag;
    }

    public /* synthetic */ View getViewRoot() {
        return d2.b(this);
    }

    public void onGlobalLayout() {
        this.composeView.getWindowVisibleDisplayFrame(this.tmpWindowVisibleFrame);
        if (!Intrinsics.areEqual((Object) this.tmpWindowVisibleFrame, (Object) this.previousWindowVisibleFrame)) {
            updatePosition();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008c, code lost:
        if (r3.invoke(r1, r0).booleanValue() == false) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0007
            boolean r9 = super.onTouchEvent(r9)
            return r9
        L_0x0007:
            int r0 = r9.getAction()
            r1 = 0
            if (r0 != 0) goto L_0x0038
            float r0 = r9.getX()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x003f
            float r0 = r9.getX()
            int r2 = r8.getWidth()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x003f
            float r0 = r9.getY()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x003f
            float r0 = r9.getY()
            int r2 = r8.getHeight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x003f
        L_0x0038:
            int r0 = r9.getAction()
            r2 = 4
            if (r0 != r2) goto L_0x0099
        L_0x003f:
            androidx.compose.ui.unit.IntRect r0 = r8.getParentBounds()
            r2 = 1
            if (r0 == 0) goto L_0x008e
            kotlin.jvm.functions.Function2<androidx.compose.ui.geometry.Offset, androidx.compose.ui.unit.IntRect, java.lang.Boolean> r3 = r8.dismissOnOutsideClick
            float r4 = r9.getX()
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r5 = 0
            if (r4 != 0) goto L_0x0053
            r4 = r2
            goto L_0x0054
        L_0x0053:
            r4 = r5
        L_0x0054:
            if (r4 == 0) goto L_0x0066
            float r4 = r9.getY()
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0060
            r1 = r2
            goto L_0x0061
        L_0x0060:
            r1 = r5
        L_0x0061:
            if (r1 != 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r1 = 0
            goto L_0x0082
        L_0x0066:
            android.view.WindowManager$LayoutParams r1 = r8.params
            int r1 = r1.x
            float r1 = (float) r1
            float r4 = r9.getX()
            float r1 = r1 + r4
            android.view.WindowManager$LayoutParams r4 = r8.params
            int r4 = r4.y
            float r4 = (float) r4
            float r6 = r9.getY()
            float r4 = r4 + r6
            long r6 = androidx.compose.ui.geometry.OffsetKt.Offset(r1, r4)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m2665boximpl(r6)
        L_0x0082:
            java.lang.Object r0 = r3.invoke(r1, r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x008f
        L_0x008e:
            r5 = r2
        L_0x008f:
            if (r5 == 0) goto L_0x0099
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r8.onDismissRequest
            if (r9 == 0) goto L_0x0098
            r9.invoke()
        L_0x0098:
            return r2
        L_0x0099:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.PopupLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setLayoutDirection(int i11) {
    }

    public final void setParentBounds(@Nullable IntRect intRect) {
        this.parentBounds$delegate.setValue(intRect);
    }

    public final void setParentLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.parentLayoutDirection = layoutDirection;
    }

    /* renamed from: setPopupContentSize-fhxjrPA  reason: not valid java name */
    public final void m2019setPopupContentSizefhxjrPA(@Nullable IntSize intSize) {
        this.popupContentSize$delegate.setValue(intSize);
    }

    public final void setPositionProvider(@NotNull PopupPositionProvider popupPositionProvider) {
        Intrinsics.checkNotNullParameter(popupPositionProvider, "<set-?>");
        this.positionProvider = popupPositionProvider;
    }

    public final void setTestTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testTag = str;
    }

    public final void show() {
        this.windowManager.addView(this, this.params);
    }

    public final void updateParameters(@Nullable Function0<Unit> function0, @NotNull String str, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(str, "testTag");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.onDismissRequest = function0;
        this.testTag = str;
        superSetLayoutDirection(layoutDirection);
    }

    public final void updatePosition() {
        IntSize r02;
        IntRect parentBounds = getParentBounds();
        if (parentBounds != null && (r02 = m2018getPopupContentSizebOM6tXw()) != null) {
            long r52 = r02.m5642unboximpl();
            Rect rect = this.previousWindowVisibleFrame;
            this.composeView.getWindowVisibleDisplayFrame(rect);
            IntRect intBounds = toIntBounds(rect);
            long r03 = this.positionProvider.m5737calculatePositionllwVHH4(parentBounds, IntSizeKt.IntSize(intBounds.getWidth(), intBounds.getHeight()), this.parentLayoutDirection, r52);
            this.params.x = IntOffset.m5596getXimpl(r03);
            this.params.y = IntOffset.m5597getYimpl(r03);
            this.windowManager.updateViewLayout(this, this.params);
        }
    }

    public final void setContent(@NotNull CompositionContext compositionContext, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(compositionContext, "parent");
        Intrinsics.checkNotNullParameter(function2, "content");
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }
}
