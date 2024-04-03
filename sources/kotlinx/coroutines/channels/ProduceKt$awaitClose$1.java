package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", i = {0, 0}, l = {153}, m = "awaitClose", n = {"$this$awaitClose", "block"}, s = {"L$0", "L$1"})
public final class ProduceKt$awaitClose$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25368h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25369i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f25370j;

    /* renamed from: k  reason: collision with root package name */
    public int f25371k;

    public ProduceKt$awaitClose$1(Continuation<? super ProduceKt$awaitClose$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25370j = obj;
        this.f25371k |= Integer.MIN_VALUE;
        return ProduceKt.awaitClose((ProducerScope<?>) null, (Function0<Unit>) null, this);
    }
}
