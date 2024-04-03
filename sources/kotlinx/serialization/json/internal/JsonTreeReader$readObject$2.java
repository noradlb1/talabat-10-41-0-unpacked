package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", i = {0, 0, 0, 0}, l = {23}, m = "readObject", n = {"$this$readObject", "this_$iv", "result$iv", "key$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class JsonTreeReader$readObject$2 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26446h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26447i;

    /* renamed from: j  reason: collision with root package name */
    public Object f26448j;

    /* renamed from: k  reason: collision with root package name */
    public Object f26449k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f26450l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ JsonTreeReader f26451m;

    /* renamed from: n  reason: collision with root package name */
    public int f26452n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readObject$2> continuation) {
        super(continuation);
        this.f26451m = jsonTreeReader;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26450l = obj;
        this.f26452n |= Integer.MIN_VALUE;
        return this.f26451m.readObject((DeepRecursiveScope<Unit, JsonElement>) null, this);
    }
}
