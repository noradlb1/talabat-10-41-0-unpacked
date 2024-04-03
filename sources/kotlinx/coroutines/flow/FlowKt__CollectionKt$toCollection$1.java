package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", i = {0}, l = {26}, m = "toCollection", n = {"destination"}, s = {"L$0"})
public final class FlowKt__CollectionKt$toCollection$1<T, C extends Collection<? super T>> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25511h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25512i;

    /* renamed from: j  reason: collision with root package name */
    public int f25513j;

    public FlowKt__CollectionKt$toCollection$1(Continuation<? super FlowKt__CollectionKt$toCollection$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25512i = obj;
        this.f25513j |= Integer.MIN_VALUE;
        return FlowKt.toCollection((Flow) null, null, this);
    }
}
