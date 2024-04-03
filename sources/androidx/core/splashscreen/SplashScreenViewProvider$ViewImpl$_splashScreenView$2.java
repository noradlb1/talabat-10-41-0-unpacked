package androidx.core.splashscreen;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.splashscreen.SplashScreenViewProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SplashScreenViewProvider$ViewImpl$_splashScreenView$2 extends Lambda implements Function0<ViewGroup> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SplashScreenViewProvider.ViewImpl f11413g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashScreenViewProvider$ViewImpl$_splashScreenView$2(SplashScreenViewProvider.ViewImpl viewImpl) {
        super(0);
        this.f11413g = viewImpl;
    }

    @NotNull
    public final ViewGroup invoke() {
        View inflate = View.inflate(this.f11413g.getActivity(), R.layout.splash_screen_view, (ViewGroup) null);
        if (inflate != null) {
            return (ViewGroup) inflate;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
