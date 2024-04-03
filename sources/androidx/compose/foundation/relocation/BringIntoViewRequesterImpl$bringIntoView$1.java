package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewRequesterImpl", f = "BringIntoViewRequester.kt", i = {0, 0, 0, 0}, l = {121}, m = "bringIntoView", n = {"rect", "content$iv", "size$iv", "i$iv"}, s = {"L$0", "L$1", "I$0", "I$1"})
public final class BringIntoViewRequesterImpl$bringIntoView$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f3179h;

    /* renamed from: i  reason: collision with root package name */
    public Object f3180i;

    /* renamed from: j  reason: collision with root package name */
    public int f3181j;

    /* renamed from: k  reason: collision with root package name */
    public int f3182k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f3183l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BringIntoViewRequesterImpl f3184m;

    /* renamed from: n  reason: collision with root package name */
    public int f3185n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BringIntoViewRequesterImpl$bringIntoView$1(BringIntoViewRequesterImpl bringIntoViewRequesterImpl, Continuation<? super BringIntoViewRequesterImpl$bringIntoView$1> continuation) {
        super(continuation);
        this.f3184m = bringIntoViewRequesterImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f3183l = obj;
        this.f3185n |= Integer.MIN_VALUE;
        return this.f3184m.bringIntoView((Rect) null, this);
    }
}
