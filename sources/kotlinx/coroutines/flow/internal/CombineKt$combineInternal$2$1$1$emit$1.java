package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", i = {}, l = {35, 36}, m = "emit", n = {}, s = {})
public final class CombineKt$combineInternal$2$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f26139h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CombineKt$combineInternal$2.AnonymousClass1.AnonymousClass1<T> f26140i;

    /* renamed from: j  reason: collision with root package name */
    public int f26141j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2$1$1$emit$1(CombineKt$combineInternal$2.AnonymousClass1.AnonymousClass1<? super T> r12, Continuation<? super CombineKt$combineInternal$2$1$1$emit$1> continuation) {
        super(continuation);
        this.f26140i = r12;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26139h = obj;
        this.f26141j |= Integer.MIN_VALUE;
        return this.f26140i.emit(null, this);
    }
}
