package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "clearSource"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", i = {0}, l = {234}, m = "clearSource$lifecycle_livedata_ktx_release", n = {"this"}, s = {"L$0"})
public final class CoroutineLiveData$clearSource$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f35990h;

    /* renamed from: i  reason: collision with root package name */
    public int f35991i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CoroutineLiveData f35992j;

    /* renamed from: k  reason: collision with root package name */
    public Object f35993k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$clearSource$1(CoroutineLiveData coroutineLiveData, Continuation continuation) {
        super(continuation);
        this.f35992j = coroutineLiveData;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35990h = obj;
        this.f35991i |= Integer.MIN_VALUE;
        return this.f35992j.clearSource$lifecycle_livedata_ktx_release(this);
    }
}
