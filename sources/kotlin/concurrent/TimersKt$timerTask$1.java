package kotlin.concurrent;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 176)
public final class TimersKt$timerTask$1 extends TimerTask {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<TimerTask, Unit> f23851b;

    public TimersKt$timerTask$1(Function1<? super TimerTask, Unit> function1) {
        this.f23851b = function1;
    }

    public void run() {
        this.f23851b.invoke(this);
    }
}
