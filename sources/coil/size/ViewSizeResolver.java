package coil.size;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001d*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001dJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0011\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcoil/size/ViewSizeResolver;", "T", "Landroid/view/View;", "Lcoil/size/SizeResolver;", "subtractPadding", "", "getSubtractPadding", "()Z", "view", "getView", "()Landroid/view/View;", "getDimension", "", "paramSize", "viewSize", "paddingSize", "isWidth", "getHeight", "getSize", "Lcoil/size/PixelSize;", "getWidth", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removePreDrawListenerSafe", "", "Landroid/view/ViewTreeObserver;", "victim", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ViewSizeResolver<T extends View> extends SizeResolver {
    @NotNull
    public static final Companion Companion = Companion.f39798a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcoil/size/ViewSizeResolver$Companion;", "", "()V", "invoke", "Lcoil/size/ViewSizeResolver;", "T", "Landroid/view/View;", "view", "subtractPadding", "", "create", "(Landroid/view/View;Z)Lcoil/size/ViewSizeResolver;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39798a = new Companion();

        private Companion() {
        }

        public static /* synthetic */ ViewSizeResolver create$default(Companion companion, View view, boolean z11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z11 = true;
            }
            return companion.create(view, z11);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "create")
        public final <T extends View> ViewSizeResolver<T> create(@NotNull T t11) {
            Intrinsics.checkNotNullParameter(t11, "view");
            return create$default(this, t11, false, 2, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "create")
        public final <T extends View> ViewSizeResolver<T> create(@NotNull T t11, boolean z11) {
            Intrinsics.checkNotNullParameter(t11, "view");
            return new RealViewSizeResolver(t11, z11);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        private static <T extends View> int getDimension(ViewSizeResolver<T> viewSizeResolver, int i11, int i12, int i13, boolean z11) {
            int i14 = i11 - i13;
            if (i14 > 0) {
                return i14;
            }
            int i15 = i12 - i13;
            if (i15 > 0) {
                return i15;
            }
            if (i11 != -2) {
                return -1;
            }
            DisplayMetrics displayMetrics = viewSizeResolver.getView().getContext().getResources().getDisplayMetrics();
            return z11 ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        }

        private static <T extends View> int getHeight(ViewSizeResolver<T> viewSizeResolver) {
            int i11;
            int i12;
            ViewGroup.LayoutParams layoutParams = viewSizeResolver.getView().getLayoutParams();
            if (layoutParams == null) {
                i11 = -1;
            } else {
                i11 = layoutParams.height;
            }
            int height = viewSizeResolver.getView().getHeight();
            if (viewSizeResolver.getSubtractPadding()) {
                i12 = viewSizeResolver.getView().getPaddingTop() + viewSizeResolver.getView().getPaddingBottom();
            } else {
                i12 = 0;
            }
            return getDimension(viewSizeResolver, i11, height, i12, false);
        }

        /* access modifiers changed from: private */
        public static <T extends View> PixelSize getSize(ViewSizeResolver<T> viewSizeResolver) {
            int height;
            int width = getWidth(viewSizeResolver);
            if (width > 0 && (height = getHeight(viewSizeResolver)) > 0) {
                return new PixelSize(width, height);
            }
            return null;
        }

        public static <T extends View> boolean getSubtractPadding(@NotNull ViewSizeResolver<T> viewSizeResolver) {
            Intrinsics.checkNotNullParameter(viewSizeResolver, "this");
            return true;
        }

        private static <T extends View> int getWidth(ViewSizeResolver<T> viewSizeResolver) {
            int i11;
            int i12;
            ViewGroup.LayoutParams layoutParams = viewSizeResolver.getView().getLayoutParams();
            if (layoutParams == null) {
                i11 = -1;
            } else {
                i11 = layoutParams.width;
            }
            int width = viewSizeResolver.getView().getWidth();
            if (viewSizeResolver.getSubtractPadding()) {
                i12 = viewSizeResolver.getView().getPaddingLeft() + viewSizeResolver.getView().getPaddingRight();
            } else {
                i12 = 0;
            }
            return getDimension(viewSizeResolver, i11, width, i12, true);
        }

        /* access modifiers changed from: private */
        public static <T extends View> void removePreDrawListenerSafe(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            } else {
                viewSizeResolver.getView().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
        }

        @Nullable
        public static <T extends View> Object size(@NotNull ViewSizeResolver<T> viewSizeResolver, @NotNull Continuation<? super Size> continuation) {
            PixelSize size = getSize(viewSizeResolver);
            if (size != null) {
                return size;
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            ViewTreeObserver viewTreeObserver = viewSizeResolver.getView().getViewTreeObserver();
            ViewSizeResolver$size$3$preDrawListener$1 viewSizeResolver$size$3$preDrawListener$1 = new ViewSizeResolver$size$3$preDrawListener$1(viewSizeResolver, viewTreeObserver, cancellableContinuationImpl);
            viewTreeObserver.addOnPreDrawListener(viewSizeResolver$size$3$preDrawListener$1);
            cancellableContinuationImpl.invokeOnCancellation(new ViewSizeResolver$size$3$1(viewSizeResolver, viewTreeObserver, viewSizeResolver$size$3$preDrawListener$1));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    boolean getSubtractPadding();

    @NotNull
    T getView();

    @Nullable
    Object size(@NotNull Continuation<? super Size> continuation);
}
