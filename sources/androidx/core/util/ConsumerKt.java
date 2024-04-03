package androidx.core.util;

import androidx.annotation.RequiresApi;
import j$.util.function.Consumer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(24)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¨\u0006\u0004"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "j$/util/function/Consumer", "asConsumer", "core-ktx_release"}, k = 2, mv = {1, 7, 1})
public final class ConsumerKt {
    @RequiresApi(24)
    @NotNull
    public static final <T> Consumer<T> asConsumer(@NotNull Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        return new ContinuationConsumer(continuation);
    }
}
