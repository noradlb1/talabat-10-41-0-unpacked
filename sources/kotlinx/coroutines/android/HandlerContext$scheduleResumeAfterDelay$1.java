package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HandlerContext$scheduleResumeAfterDelay$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HandlerContext f25146g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Runnable f25147h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandlerContext$scheduleResumeAfterDelay$1(HandlerContext handlerContext, Runnable runnable) {
        super(1);
        this.f25146g = handlerContext;
        this.f25147h = runnable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        this.f25146g.handler.removeCallbacks(this.f25147h);
    }
}
