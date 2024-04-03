package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior", f = "Scrollable.kt", i = {0}, l = {555}, m = "performFling", n = {"velocityLeft"}, s = {"L$0"})
public final class DefaultFlingBehavior$performFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f1834h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f1835i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DefaultFlingBehavior f1836j;

    /* renamed from: k  reason: collision with root package name */
    public int f1837k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultFlingBehavior$performFling$1(DefaultFlingBehavior defaultFlingBehavior, Continuation<? super DefaultFlingBehavior$performFling$1> continuation) {
        super(continuation);
        this.f1836j = defaultFlingBehavior;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f1835i = obj;
        this.f1837k |= Integer.MIN_VALUE;
        return this.f1836j.performFling((ScrollScope) null, 0.0f, this);
    }
}
