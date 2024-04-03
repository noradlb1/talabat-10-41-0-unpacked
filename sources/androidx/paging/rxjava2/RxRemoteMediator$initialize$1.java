package androidx.paging.rxjava2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"", "Key", "Value", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/RemoteMediator$InitializeAction;", "continuation", "initialize"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.rxjava2.RxRemoteMediator", f = "RxRemoteMediator.kt", i = {}, l = {97}, m = "initialize", n = {}, s = {})
public final class RxRemoteMediator$initialize$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37263h;

    /* renamed from: i  reason: collision with root package name */
    public int f37264i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RxRemoteMediator f37265j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxRemoteMediator$initialize$1(RxRemoteMediator rxRemoteMediator, Continuation continuation) {
        super(continuation);
        this.f37265j = rxRemoteMediator;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37263h = obj;
        this.f37264i |= Integer.MIN_VALUE;
        return this.f37265j.initialize(this);
    }
}
