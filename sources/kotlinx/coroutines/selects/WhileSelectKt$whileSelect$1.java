package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", i = {0}, l = {37}, m = "whileSelect", n = {"builder"}, s = {"L$0"})
public final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26362h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26363i;

    /* renamed from: j  reason: collision with root package name */
    public int f26364j;

    public WhileSelectKt$whileSelect$1(Continuation<? super WhileSelectKt$whileSelect$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26363i = obj;
        this.f26364j |= Integer.MIN_VALUE;
        return WhileSelectKt.whileSelect((Function1<? super SelectBuilder<? super Boolean>, Unit>) null, this);
    }
}
