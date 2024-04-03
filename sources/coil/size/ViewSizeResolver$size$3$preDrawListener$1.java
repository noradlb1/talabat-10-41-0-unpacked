package coil.size;

import android.view.ViewTreeObserver;
import coil.size.ViewSizeResolver;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"coil/size/ViewSizeResolver$size$3$preDrawListener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "isResumed", "", "onPreDraw", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewSizeResolver$size$3$preDrawListener$1 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewSizeResolver<T> f39802b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver f39803c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Size> f39804d;
    private boolean isResumed;

    public ViewSizeResolver$size$3$preDrawListener$1(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, CancellableContinuation<? super Size> cancellableContinuation) {
        this.f39802b = viewSizeResolver;
        this.f39803c = viewTreeObserver;
        this.f39804d = cancellableContinuation;
    }

    public boolean onPreDraw() {
        PixelSize access$getSize = ViewSizeResolver.DefaultImpls.getSize(this.f39802b);
        if (access$getSize != null) {
            ViewSizeResolver<T> viewSizeResolver = this.f39802b;
            ViewTreeObserver viewTreeObserver = this.f39803c;
            Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
            ViewSizeResolver.DefaultImpls.removePreDrawListenerSafe(viewSizeResolver, viewTreeObserver, this);
            if (!this.isResumed) {
                this.isResumed = true;
                this.f39804d.resumeWith(Result.m6329constructorimpl(access$getSize));
            }
        }
        return true;
    }
}
