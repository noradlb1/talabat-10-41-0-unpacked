package androidx.compose.ui.platform;

import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidUiFrameClock$withFrameNanos$2$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidUiFrameClock f10019g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Choreographer.FrameCallback f10020h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidUiFrameClock$withFrameNanos$2$2(AndroidUiFrameClock androidUiFrameClock, Choreographer.FrameCallback frameCallback) {
        super(1);
        this.f10019g = androidUiFrameClock;
        this.f10020h = frameCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        this.f10019g.getChoreographer().removeFrameCallback(this.f10020h);
    }
}
