package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "command", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidComposeView$snapshotObserver$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f9986g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$snapshotObserver$1(AndroidComposeView androidComposeView) {
        super(1);
        this.f9986g = androidComposeView;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m4811invoke$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function0<Unit>) (Function0) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "command");
        Handler handler = this.f9986g.getHandler();
        if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
            function0.invoke();
            return;
        }
        Handler handler2 = this.f9986g.getHandler();
        if (handler2 != null) {
            handler2.post(new a(function0));
        }
    }
}
