package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00022\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u0001H\u0004H\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Y", "kotlin.jvm.PlatformType", "X", "it", "apply", "(Ljava/lang/Object;)Landroidx/lifecycle/LiveData;"}, k = 3, mv = {1, 4, 1})
public final class TransformationsKt$switchMap$1<I, O> implements Function<X, LiveData<Y>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36120a;

    public TransformationsKt$switchMap$1(Function1 function1) {
        this.f36120a = function1;
    }

    public final LiveData<Y> apply(X x11) {
        return (LiveData) this.f36120a.invoke(x11);
    }
}
