package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "invoke", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Runnable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DispatcherScheduler$scheduleDirect$1 extends Lambda implements Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DispatcherScheduler f26273g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DispatcherScheduler$scheduleDirect$1(DispatcherScheduler dispatcherScheduler) {
        super(1);
        this.f26273g = dispatcherScheduler;
    }

    @NotNull
    public final Runnable invoke(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        return new DispatcherScheduler$scheduleDirect$1$invoke$$inlined$Runnable$1(this.f26273g, function1);
    }
}
