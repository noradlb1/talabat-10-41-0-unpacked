package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0005H@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "", "p1", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "invoke", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class CachedPageEventFlow$multicastedSrc$2 extends FunctionReferenceImpl implements Function2<IndexedValue<? extends PageEvent<T>>, Continuation<? super Unit>, Object>, SuspendFunction {
    public CachedPageEventFlow$multicastedSrc$2(FlattenedPageController flattenedPageController) {
        super(2, flattenedPageController, FlattenedPageController.class, "record", "record(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(@NotNull IndexedValue<? extends PageEvent<T>> indexedValue, @NotNull Continuation<? super Unit> continuation) {
        return ((FlattenedPageController) this.receiver).record(indexedValue, continuation);
    }
}
