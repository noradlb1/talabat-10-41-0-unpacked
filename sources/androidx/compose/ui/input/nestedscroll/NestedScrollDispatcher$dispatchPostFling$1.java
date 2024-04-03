package androidx.compose.ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher", f = "NestedScrollModifier.kt", i = {}, l = {217}, m = "dispatchPostFling-RZ2iAVY", n = {}, s = {})
public final class NestedScrollDispatcher$dispatchPostFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9751h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ NestedScrollDispatcher f9752i;

    /* renamed from: j  reason: collision with root package name */
    public int f9753j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedScrollDispatcher$dispatchPostFling$1(NestedScrollDispatcher nestedScrollDispatcher, Continuation<? super NestedScrollDispatcher$dispatchPostFling$1> continuation) {
        super(continuation);
        this.f9752i = nestedScrollDispatcher;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9751h = obj;
        this.f9753j |= Integer.MIN_VALUE;
        return this.f9752i.m4202dispatchPostFlingRZ2iAVY(0, 0, this);
    }
}
