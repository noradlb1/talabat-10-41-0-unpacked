package coil.size;

import android.view.ViewTreeObserver;
import coil.size.ViewSizeResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n"}, d2 = {"Landroid/view/View;", "T", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ViewSizeResolver$size$3$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ViewSizeResolver<T> f39799g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver f39800h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ViewSizeResolver$size$3$preDrawListener$1 f39801i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewSizeResolver$size$3$1(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, ViewSizeResolver$size$3$preDrawListener$1 viewSizeResolver$size$3$preDrawListener$1) {
        super(1);
        this.f39799g = viewSizeResolver;
        this.f39800h = viewTreeObserver;
        this.f39801i = viewSizeResolver$size$3$preDrawListener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        ViewSizeResolver<T> viewSizeResolver = this.f39799g;
        ViewTreeObserver viewTreeObserver = this.f39800h;
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
        ViewSizeResolver.DefaultImpls.removePreDrawListenerSafe(viewSizeResolver, viewTreeObserver, this.f39801i);
    }
}
