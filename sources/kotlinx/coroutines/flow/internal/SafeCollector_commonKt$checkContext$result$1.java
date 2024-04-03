package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(ILkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SafeCollector_commonKt$checkContext$result$1 extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SafeCollector<?> f26181g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$checkContext$result$1(SafeCollector<?> safeCollector) {
        super(2);
        this.f26181g = safeCollector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (CoroutineContext.Element) obj2);
    }

    @NotNull
    public final Integer invoke(int i11, @NotNull CoroutineContext.Element element) {
        CoroutineContext.Key key = element.getKey();
        CoroutineContext.Element element2 = this.f26181g.collectContext.get(key);
        if (key != Job.Key) {
            return Integer.valueOf(element != element2 ? Integer.MIN_VALUE : i11 + 1);
        }
        Job job = (Job) element2;
        Job transitiveCoroutineParent = SafeCollector_commonKt.transitiveCoroutineParent((Job) element, job);
        if (transitiveCoroutineParent == job) {
            if (job != null) {
                i11++;
            }
            return Integer.valueOf(i11);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + transitiveCoroutineParent + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
