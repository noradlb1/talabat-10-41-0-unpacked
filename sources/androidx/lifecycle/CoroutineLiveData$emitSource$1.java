package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"T", "Landroidx/lifecycle/LiveData;", "source", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/DisposableHandle;", "continuation", "", "emitSource"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", i = {0, 0, 1}, l = {227, 228}, m = "emitSource$lifecycle_livedata_ktx_release", n = {"this", "source", "this"}, s = {"L$0", "L$1", "L$0"})
public final class CoroutineLiveData$emitSource$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f35994h;

    /* renamed from: i  reason: collision with root package name */
    public int f35995i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CoroutineLiveData f35996j;

    /* renamed from: k  reason: collision with root package name */
    public Object f35997k;

    /* renamed from: l  reason: collision with root package name */
    public Object f35998l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$emitSource$1(CoroutineLiveData coroutineLiveData, Continuation continuation) {
        super(continuation);
        this.f35996j = coroutineLiveData;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35994h = obj;
        this.f35995i |= Integer.MIN_VALUE;
        return this.f35996j.emitSource$lifecycle_livedata_ktx_release((LiveData) null, this);
    }
}
