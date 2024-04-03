package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {80}, m = "yieldFrames", n = {}, s = {})
public final class DebugCoroutineInfoImpl$yieldFrames$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25400h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25401i;

    /* renamed from: j  reason: collision with root package name */
    public Object f25402j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f25403k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DebugCoroutineInfoImpl f25404l;

    /* renamed from: m  reason: collision with root package name */
    public int f25405m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$yieldFrames$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, Continuation<? super DebugCoroutineInfoImpl$yieldFrames$1> continuation) {
        super(continuation);
        this.f25404l = debugCoroutineInfoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25403k = obj;
        this.f25405m |= Integer.MIN_VALUE;
        return this.f25404l.yieldFrames((SequenceScope<? super StackTraceElement>) null, (CoroutineStackFrame) null, this);
    }
}
