package androidx.compose.ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal", f = "NestedScrollModifierLocal.kt", i = {0, 0, 0, 1}, l = {94, 96}, m = "onPostFling-RZ2iAVY", n = {"this", "consumed", "available", "selfConsumed"}, s = {"L$0", "J$0", "J$1", "J$0"})
public final class NestedScrollModifierLocal$onPostFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f9762h;

    /* renamed from: i  reason: collision with root package name */
    public long f9763i;

    /* renamed from: j  reason: collision with root package name */
    public long f9764j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f9765k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ NestedScrollModifierLocal f9766l;

    /* renamed from: m  reason: collision with root package name */
    public int f9767m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedScrollModifierLocal$onPostFling$1(NestedScrollModifierLocal nestedScrollModifierLocal, Continuation<? super NestedScrollModifierLocal$onPostFling$1> continuation) {
        super(continuation);
        this.f9766l = nestedScrollModifierLocal;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9765k = obj;
        this.f9767m |= Integer.MIN_VALUE;
        return this.f9766l.m4206onPostFlingRZ2iAVY(0, 0, this);
    }
}
