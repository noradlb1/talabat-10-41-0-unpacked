package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00032.\u0010\u0006\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005H@"}, d2 = {"", "R", "T", "Landroidx/paging/TransformablePage;", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "generator", "continuation", "insertInternalSeparators"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.SeparatorsKt", f = "Separators.kt", i = {0, 0, 0, 0, 0}, l = {82}, m = "insertInternalSeparators", n = {"$this$insertInternalSeparators", "generator", "outputList", "outputIndices", "item"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class SeparatorsKt$insertInternalSeparators$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37121h;

    /* renamed from: i  reason: collision with root package name */
    public int f37122i;

    /* renamed from: j  reason: collision with root package name */
    public Object f37123j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37124k;

    /* renamed from: l  reason: collision with root package name */
    public Object f37125l;

    /* renamed from: m  reason: collision with root package name */
    public Object f37126m;

    /* renamed from: n  reason: collision with root package name */
    public Object f37127n;

    /* renamed from: o  reason: collision with root package name */
    public int f37128o;

    /* renamed from: p  reason: collision with root package name */
    public int f37129p;

    public SeparatorsKt$insertInternalSeparators$1(Continuation continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37121h = obj;
        this.f37122i |= Integer.MIN_VALUE;
        return SeparatorsKt.insertInternalSeparators((TransformablePage) null, (Function3) null, this);
    }
}
