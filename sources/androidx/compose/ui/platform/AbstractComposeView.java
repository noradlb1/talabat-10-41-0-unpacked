package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.InternalComposeUiApi;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.node.Owner;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010)\u001a\u00020\u0012H'¢\u0006\u0002\u0010*J\u0012\u0010+\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001c\u0010+\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u0010+\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020\u0007H\u0016J$\u0010+\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u0010+\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0016J$\u00103\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J,\u00103\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00104\u001a\u00020\u000fH\u0014J\b\u00105\u001a\u00020\u0012H\u0002J\u0006\u00106\u001a\u00020\u0012J\u0006\u00107\u001a\u00020\u0012J\b\u00108\u001a\u00020\u0012H\u0002J5\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0010¢\u0006\u0002\b?J\u001d\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0010¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0012H\u0014J0\u0010E\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0004J\u0018\u0010F\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0004J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0007H\u0016J\b\u0010I\u001a\u00020\u000bH\u0002J\u0010\u0010J\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010L\u001a\u00020\u00122\u0006\u0010M\u001a\u00020NJ\b\u0010O\u001a\u00020\u000fH\u0016J\f\u0010P\u001a\u00020\u000b*\u00020\u000bH\u0002R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001c@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000f8TX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0017R,\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f8F@FX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010&R\u0018\u0010'\u001a\u00020\u000f*\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006Q"}, d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/runtime/CompositionContext;", "composition", "Landroidx/compose/runtime/Composition;", "creatingComposition", "", "disposeViewCompositionStrategy", "Lkotlin/Function0;", "", "getDisposeViewCompositionStrategy$annotations", "()V", "hasComposition", "getHasComposition", "()Z", "value", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "isAlive", "(Landroidx/compose/runtime/CompositionContext;)Z", "Content", "(Landroidx/compose/runtime/Composer;I)V", "addView", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "addViewInLayout", "preventRequestLayout", "checkAddView", "createComposition", "disposeComposition", "ensureCompositionCreated", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "internalOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "onAttachedToWindow", "onLayout", "onMeasure", "onRtlPropertiesChanged", "layoutDirection", "resolveParentCompositionContext", "setParentCompositionContext", "parent", "setViewCompositionStrategy", "strategy", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "shouldDelayChildPressedState", "cacheIfAlive", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;
    @Nullable
    private WeakReference<CompositionContext> cachedViewTreeCompositionContext;
    @Nullable
    private Composition composition;
    private boolean creatingComposition;
    @Nullable
    private Function0<Unit> disposeViewCompositionStrategy;
    @Nullable
    private CompositionContext parentContext;
    @Nullable
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbstractComposeView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbstractComposeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final CompositionContext cacheIfAlive(CompositionContext compositionContext) {
        CompositionContext compositionContext2;
        if (isAlive(compositionContext)) {
            compositionContext2 = compositionContext;
        } else {
            compositionContext2 = null;
        }
        if (compositionContext2 != null) {
            this.cachedViewTreeCompositionContext = new WeakReference<>(compositionContext2);
        }
        return compositionContext;
    }

    private final void checkAddView() {
        if (!this.creatingComposition) {
            throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
        }
    }

    /* JADX INFO: finally extract failed */
    private final void ensureCompositionCreated() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                this.composition = Wrapper_androidKt.setContent(this, resolveParentCompositionContext(), ComposableLambdaKt.composableLambdaInstance(-656146368, true, new AbstractComposeView$ensureCompositionCreated$1(this)));
                this.creatingComposition = false;
            } catch (Throwable th2) {
                this.creatingComposition = false;
                throw th2;
            }
        }
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    @InternalComposeUiApi
    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    private final boolean isAlive(CompositionContext compositionContext) {
        return !(compositionContext instanceof Recomposer) || ((Recomposer) compositionContext).getCurrentState().getValue().compareTo(Recomposer.State.ShuttingDown) > 0;
    }

    private final CompositionContext resolveParentCompositionContext() {
        CompositionContext compositionContext;
        CompositionContext compositionContext2;
        CompositionContext compositionContext3 = this.parentContext;
        if (compositionContext3 != null) {
            return compositionContext3;
        }
        CompositionContext findViewTreeCompositionContext = WindowRecomposer_androidKt.findViewTreeCompositionContext(this);
        CompositionContext compositionContext4 = null;
        if (findViewTreeCompositionContext != null) {
            compositionContext = cacheIfAlive(findViewTreeCompositionContext);
        } else {
            compositionContext = null;
        }
        if (compositionContext != null) {
            return compositionContext;
        }
        WeakReference<CompositionContext> weakReference = this.cachedViewTreeCompositionContext;
        if (!(weakReference == null || (compositionContext2 = weakReference.get()) == null || !isAlive(compositionContext2))) {
            compositionContext4 = compositionContext2;
        }
        CompositionContext compositionContext5 = compositionContext4;
        if (compositionContext5 == null) {
            return cacheIfAlive(WindowRecomposer_androidKt.getWindowRecomposer(this));
        }
        return compositionContext5;
    }

    private final void setParentContext(CompositionContext compositionContext) {
        if (this.parentContext != compositionContext) {
            this.parentContext = compositionContext;
            if (compositionContext != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            Composition composition2 = this.composition;
            if (composition2 != null) {
                composition2.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    @Composable
    @UiComposable
    public abstract void Content(@Nullable Composer composer, int i11);

    public void addView(@Nullable View view) {
        checkAddView();
        super.addView(view);
    }

    public boolean addViewInLayout(@Nullable View view, int i11, @Nullable ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        return super.addViewInLayout(view, i11, layoutParams);
    }

    public final void createComposition() {
        boolean z11;
        if (this.parentContext != null || isAttachedToWindow()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ensureCompositionCreated();
            return;
        }
        throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString());
    }

    public final void disposeComposition() {
        Composition composition2 = this.composition;
        if (composition2 != null) {
            composition2.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void internalOnLayout$ui_release(boolean z11, int i11, int i12, int i13, int i14) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (i13 - i11) - getPaddingRight(), (i14 - i12) - getPaddingBottom());
        }
    }

    public void internalOnMeasure$ui_release(int i11, int i12) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i11, i12);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i11) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i11)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i12) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(i12)));
        setMeasuredDimension(childAt.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), childAt.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            ensureCompositionCreated();
        }
    }

    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        internalOnLayout$ui_release(z11, i11, i12, i13, i14);
    }

    public final void onMeasure(int i11, int i12) {
        ensureCompositionCreated();
        internalOnMeasure$ui_release(i11, i12);
    }

    public void onRtlPropertiesChanged(int i11) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(i11);
        }
    }

    public final void setParentCompositionContext(@Nullable CompositionContext compositionContext) {
        setParentContext(compositionContext);
    }

    public final void setShowLayoutBounds(boolean z11) {
        this.showLayoutBounds = z11;
        View childAt = getChildAt(0);
        if (childAt != null) {
            ((Owner) childAt).setShowLayoutBounds(z11);
        }
    }

    public final void setViewCompositionStrategy(@NotNull ViewCompositionStrategy viewCompositionStrategy) {
        Intrinsics.checkNotNullParameter(viewCompositionStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        Function0<Unit> function0 = this.disposeViewCompositionStrategy;
        if (function0 != null) {
            function0.invoke();
        }
        this.disposeViewCompositionStrategy = viewCompositionStrategy.installFor(this);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbstractComposeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipChildren(false);
        setClipToPadding(false);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.Companion.getDefault().installFor(this);
    }

    public void addView(@Nullable View view, int i11) {
        checkAddView();
        super.addView(view, i11);
    }

    public boolean addViewInLayout(@Nullable View view, int i11, @Nullable ViewGroup.LayoutParams layoutParams, boolean z11) {
        checkAddView();
        return super.addViewInLayout(view, i11, layoutParams, z11);
    }

    public void addView(@Nullable View view, int i11, int i12) {
        checkAddView();
        super.addView(view, i11, i12);
    }

    public void addView(@Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, layoutParams);
    }

    public void addView(@Nullable View view, int i11, @Nullable ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, i11, layoutParams);
    }
}
