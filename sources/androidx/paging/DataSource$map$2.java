package androidx.paging;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00032\u000e\u0010\u0006\u001a\n \u0002*\u0004\u0018\u0001H\u0005H\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "ToValue", "kotlin.jvm.PlatformType", "", "Key", "Value", "it", "apply", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
public final class DataSource$map$2<I, O> implements Function<Value, ToValue> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36550a;

    public DataSource$map$2(Function1 function1) {
        this.f36550a = function1;
    }

    public final ToValue apply(Value value) {
        Function1 function1 = this.f36550a;
        Intrinsics.checkNotNullExpressionValue(value, "it");
        return function1.invoke(value);
    }
}
