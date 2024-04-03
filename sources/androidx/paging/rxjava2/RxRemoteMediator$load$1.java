package androidx.paging.rxjava2;

import androidx.paging.LoadType;
import androidx.paging.PagingState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@"}, d2 = {"", "Key", "Value", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/PagingState;", "state", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/RemoteMediator$MediatorResult;", "continuation", "load"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.rxjava2.RxRemoteMediator", f = "RxRemoteMediator.kt", i = {}, l = {93}, m = "load", n = {}, s = {})
public final class RxRemoteMediator$load$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37266h;

    /* renamed from: i  reason: collision with root package name */
    public int f37267i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RxRemoteMediator f37268j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxRemoteMediator$load$1(RxRemoteMediator rxRemoteMediator, Continuation continuation) {
        super(continuation);
        this.f37268j = rxRemoteMediator;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37266h = obj;
        this.f37267i |= Integer.MIN_VALUE;
        return this.f37268j.load((LoadType) null, (PagingState) null, this);
    }
}
