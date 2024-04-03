package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ~2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002~B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0010\u000eJ\b\u00106\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H\u0014J\u0010\u0010:\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020\u000bH\u0016J\b\u0010<\u001a\u00020\u000bH\u0016J\u001d\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020?H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001d\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u0018\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u001bH\u0016J%\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020D2\u0006\u0010J\u001a\u00020\u001bH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u001d\u0010O\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020PH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ0\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020VH\u0014J\b\u0010Z\u001a\u00020\u000bH\u0002J\u001d\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020]H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010RJ*\u0010_\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u001d\u0010`\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020?H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010AJ\b\u0010b\u001a\u00020\u000bH\u0016J§\u0001\u0010c\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u00102\u0006\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u00102\u0006\u0010m\u001a\u00020\u00102\u0006\u0010n\u001a\u00020(2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u001b2\b\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020u2\u0006\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b{\u0010|J\b\u0010}\u001a\u00020\u000bH\u0002R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u001b@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0019\u0010'\u001a\u00020(X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010+8BX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010&\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "container", "Landroidx/compose/ui/platform/DrawChildContainer;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "value", "", "cameraDistancePx", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipBoundsCache", "Landroid/graphics/Rect;", "clipToBounds", "", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "drawnWithZ", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "layerId", "", "getLayerId", "()J", "mTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "manualClipPath", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "destroy", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawLayer", "forceLayout", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "onLayout", "changed", "l", "", "t", "r", "b", "resetClipBounds", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scaleX", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "updateLayerProperties-NHXXZp8", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)V", "updateOutlineResolver", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final ViewOutlineProvider OutlineProvider = new ViewLayer$Companion$OutlineProvider$1();
    @NotNull
    private static final Function2<View, Matrix, Unit> getMatrix = ViewLayer$Companion$getMatrix$1.INSTANCE;
    /* access modifiers changed from: private */
    public static boolean hasRetrievedMethod;
    /* access modifiers changed from: private */
    @Nullable
    public static Field recreateDisplayList;
    /* access modifiers changed from: private */
    public static boolean shouldUseDispatchDraw;
    /* access modifiers changed from: private */
    @Nullable
    public static Method updateDisplayListIfDirtyMethod;
    @NotNull
    private final CanvasHolder canvasHolder = new CanvasHolder();
    @Nullable
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    @NotNull
    private final DrawChildContainer container;
    @Nullable
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;
    @Nullable
    private Function0<Unit> invalidateParentLayer;
    private boolean isInvalidated;
    private long mTransformOrigin = TransformOrigin.Companion.m3292getCenterSzJe1aQ();
    @NotNull
    private final LayerMatrixCache<View> matrixCache = new LayerMatrixCache<>(getMatrix);
    /* access modifiers changed from: private */
    @NotNull
    public final OutlineResolver outlineResolver;
    @NotNull
    private final AndroidComposeView ownerView;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$Companion;", "", "()V", "OutlineProvider", "Landroid/view/ViewOutlineProvider;", "getOutlineProvider", "()Landroid/view/ViewOutlineProvider;", "getMatrix", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/Matrix;", "", "<set-?>", "", "hasRetrievedMethod", "getHasRetrievedMethod", "()Z", "recreateDisplayList", "Ljava/lang/reflect/Field;", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui_release", "(Z)V", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "updateDisplayList", "view", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        @NotNull
        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z11) {
            ViewLayer.shouldUseDispatchDraw = z11;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final void updateDisplayList(@NotNull View view) {
            Class<String> cls = String.class;
            Class<Class> cls2 = Class.class;
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    Class<View> cls3 = View.class;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.updateDisplayListIfDirtyMethod = cls3.getDeclaredMethod("updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = cls3.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.updateDisplayListIfDirtyMethod = (Method) cls2.getDeclaredMethod("getDeclaredMethod", new Class[]{cls, new Class[0].getClass()}).invoke(cls3, new Object[]{"updateDisplayListIfDirty", new Class[0]});
                        ViewLayer.recreateDisplayList = (Field) cls2.getDeclaredMethod("getDeclaredField", new Class[]{cls}).invoke(cls3, new Object[]{"mRecreateDisplayList"});
                    }
                    Method access$getUpdateDisplayListIfDirtyMethod$cp = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (access$getUpdateDisplayListIfDirtyMethod$cp != null) {
                        access$getUpdateDisplayListIfDirtyMethod$cp.setAccessible(true);
                    }
                    Field access$getRecreateDisplayList$cp = ViewLayer.recreateDisplayList;
                    if (access$getRecreateDisplayList$cp != null) {
                        access$getRecreateDisplayList$cp.setAccessible(true);
                    }
                }
                Field access$getRecreateDisplayList$cp2 = ViewLayer.recreateDisplayList;
                if (access$getRecreateDisplayList$cp2 != null) {
                    access$getRecreateDisplayList$cp2.setBoolean(view, true);
                }
                Method access$getUpdateDisplayListIfDirtyMethod$cp2 = ViewLayer.updateDisplayListIfDirtyMethod;
                if (access$getUpdateDisplayListIfDirtyMethod$cp2 != null) {
                    access$getUpdateDisplayListIfDirtyMethod$cp2.invoke(view, new Object[0]);
                }
            } catch (Throwable unused) {
                setShouldUseDispatchDraw$ui_release(true);
            }
        }
    }

    @RequiresApi(29)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class UniqueDrawingIdApi29 {
        @NotNull
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        @DoNotInline
        public static final long getUniqueDrawingId(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getUniqueDrawingId();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewLayer(@NotNull AndroidComposeView androidComposeView, @NotNull DrawChildContainer drawChildContainer, @NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        super(androidComposeView.getContext());
        Intrinsics.checkNotNullParameter(androidComposeView, "ownerView");
        Intrinsics.checkNotNullParameter(drawChildContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        this.ownerView = androidComposeView;
        this.container = drawChildContainer;
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new OutlineResolver(androidComposeView.getDensity());
        setWillNotDraw(false);
        setId(View.generateViewId());
        drawChildContainer.addView(this);
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    private final void setInvalidated(boolean z11) {
        if (z11 != this.isInvalidated) {
            this.isInvalidated = z11;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z11);
        }
    }

    private final void updateOutlineResolver() {
        ViewOutlineProvider viewOutlineProvider;
        if (this.outlineResolver.getOutline() != null) {
            viewOutlineProvider = OutlineProvider;
        } else {
            viewOutlineProvider = null;
        }
        setOutlineProvider(viewOutlineProvider);
    }

    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    public void dispatchDraw(@NotNull android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        boolean z11 = false;
        setInvalidated(false);
        CanvasHolder canvasHolder2 = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
        AndroidCanvas androidCanvas = canvasHolder2.getAndroidCanvas();
        if (getManualClipPath() != null || !canvas.isHardwareAccelerated()) {
            androidCanvas.save();
            this.outlineResolver.clipToOutline(androidCanvas);
            z11 = true;
        }
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(androidCanvas);
        }
        if (z11) {
            androidCanvas.restore();
        }
        canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
    }

    public void drawLayer(@NotNull Canvas canvas) {
        boolean z11;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getElevation() > 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.drawnWithZ = z11;
        if (z11) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    public void forceLayout() {
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / ((float) getResources().getDisplayMetrics().densityDpi);
    }

    @NotNull
    public final DrawChildContainer getContainer() {
        return this.container;
    }

    public long getLayerId() {
        return (long) getId();
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1;
    }

    public void invalidate() {
        if (!this.isInvalidated) {
            setInvalidated(true);
            super.invalidate();
            this.ownerView.invalidate();
        }
    }

    /* renamed from: inverseTransform-58bKbWc  reason: not valid java name */
    public void m4883inverseTransform58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        float[] r02 = this.matrixCache.m4843calculateInverseMatrixbWbORWo(this);
        if (r02 != null) {
            androidx.compose.ui.graphics.Matrix.m3117timesAssign58bKbWc(fArr, r02);
        }
    }

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    public boolean m4884isInLayerk4lQ0M(long j11) {
        float r02 = Offset.m2676getXimpl(j11);
        float r12 = Offset.m2677getYimpl(j11);
        if (this.clipToBounds) {
            if (0.0f > r02 || r02 >= ((float) getWidth()) || 0.0f > r12 || r12 >= ((float) getHeight())) {
                return false;
            }
            return true;
        } else if (getClipToOutline()) {
            return this.outlineResolver.m4870isInOutlinek4lQ0M(j11);
        } else {
            return true;
        }
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    public void mapBounds(@NotNull MutableRect mutableRect, boolean z11) {
        Intrinsics.checkNotNullParameter(mutableRect, "rect");
        if (z11) {
            float[] r32 = this.matrixCache.m4843calculateInverseMatrixbWbORWo(this);
            if (r32 != null) {
                androidx.compose.ui.graphics.Matrix.m3108mapimpl(r32, mutableRect);
            } else {
                mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        } else {
            androidx.compose.ui.graphics.Matrix.m3108mapimpl(this.matrixCache.m4844calculateMatrixGrdbGEg(this), mutableRect);
        }
    }

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    public long m4885mapOffset8S9VItk(long j11, boolean z11) {
        if (!z11) {
            return androidx.compose.ui.graphics.Matrix.m3106mapMKHz9U(this.matrixCache.m4844calculateMatrixGrdbGEg(this), j11);
        }
        float[] r32 = this.matrixCache.m4843calculateInverseMatrixbWbORWo(this);
        if (r32 != null) {
            return androidx.compose.ui.graphics.Matrix.m3106mapMKHz9U(r32, j11);
        }
        return Offset.Companion.m2690getInfiniteF1C5BW0();
    }

    /* renamed from: move--gyyYBs  reason: not valid java name */
    public void m4886movegyyYBs(long j11) {
        int r02 = IntOffset.m5596getXimpl(j11);
        if (r02 != getLeft()) {
            offsetLeftAndRight(r02 - getLeft());
            this.matrixCache.invalidate();
        }
        int r32 = IntOffset.m5597getYimpl(j11);
        if (r32 != getTop()) {
            offsetTopAndBottom(r32 - getTop());
            this.matrixCache.invalidate();
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
    }

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    public void m4887resizeozmzZPI(long j11) {
        int r02 = IntSize.m5638getWidthimpl(j11);
        int r52 = IntSize.m5637getHeightimpl(j11);
        if (r02 != getWidth() || r52 != getHeight()) {
            float f11 = (float) r02;
            setPivotX(TransformOrigin.m3287getPivotFractionXimpl(this.mTransformOrigin) * f11);
            float f12 = (float) r52;
            setPivotY(TransformOrigin.m3288getPivotFractionYimpl(this.mTransformOrigin) * f12);
            this.outlineResolver.m4871updateuvyYCjk(SizeKt.Size(f11, f12));
            updateOutlineResolver();
            layout(getLeft(), getTop(), getLeft() + r02, getTop() + r52);
            resetClipBounds();
            this.matrixCache.invalidate();
        }
    }

    public void reuseLayer(@NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.Companion.m3292getCenterSzJe1aQ();
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
    }

    public final void setCameraDistancePx(float f11) {
        setCameraDistance(f11 * ((float) getResources().getDisplayMetrics().densityDpi));
    }

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    public void m4888transform58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        androidx.compose.ui.graphics.Matrix.m3117timesAssign58bKbWc(fArr, this.matrixCache.m4844calculateMatrixGrdbGEg(this));
    }

    public void updateDisplayList() {
        if (this.isInvalidated && !shouldUseDispatchDraw) {
            setInvalidated(false);
            Companion.updateDisplayList(this);
        }
    }

    /* renamed from: updateLayerProperties-NHXXZp8  reason: not valid java name */
    public void m4889updateLayerPropertiesNHXXZp8(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, @NotNull Shape shape, boolean z11, @Nullable RenderEffect renderEffect, long j12, long j13, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Function0<Unit> function0;
        Shape shape2 = shape;
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        this.mTransformOrigin = j11;
        setScaleX(f11);
        float f22 = f12;
        setScaleY(f12);
        float f23 = f13;
        setAlpha(f13);
        float f24 = f14;
        setTranslationX(f14);
        setTranslationY(f15);
        setElevation(f16);
        setRotation(f19);
        setRotationX(f17);
        setRotationY(f18);
        setPivotX(TransformOrigin.m3287getPivotFractionXimpl(this.mTransformOrigin) * ((float) getWidth()));
        setPivotY(TransformOrigin.m3288getPivotFractionYimpl(this.mTransformOrigin) * ((float) getHeight()));
        setCameraDistancePx(f21);
        boolean z12 = true;
        this.clipToBounds = z11 && shape2 == RectangleShapeKt.getRectangleShape();
        resetClipBounds();
        boolean z13 = getManualClipPath() != null;
        setClipToOutline(z11 && shape2 != RectangleShapeKt.getRectangleShape());
        boolean update = this.outlineResolver.update(shape, getAlpha(), getClipToOutline(), getElevation(), layoutDirection, density);
        updateOutlineResolver();
        if (getManualClipPath() == null) {
            z12 = false;
        }
        if (z13 != z12 || (z12 && update)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        this.matrixCache.invalidate();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            ViewLayerVerificationHelper28 viewLayerVerificationHelper28 = ViewLayerVerificationHelper28.INSTANCE;
            viewLayerVerificationHelper28.setOutlineAmbientShadowColor(this, ColorKt.m2974toArgb8_81llA(j12));
            viewLayerVerificationHelper28.setOutlineSpotShadowColor(this, ColorKt.m2974toArgb8_81llA(j13));
        }
        if (i11 >= 31) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this, renderEffect);
        }
    }
}
