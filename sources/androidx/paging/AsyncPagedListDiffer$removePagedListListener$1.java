package androidx.paging;

import androidx.paging.AsyncPagedListDiffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0006*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "", "it", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
public final class AsyncPagedListDiffer$removePagedListListener$1 extends Lambda implements Function1<AsyncPagedListDiffer.PagedListListener<T>, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2 f36451g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncPagedListDiffer$removePagedListListener$1(Function2 function2) {
        super(1);
        this.f36451g = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((AsyncPagedListDiffer.PagedListListener) obj));
    }

    public final boolean invoke(AsyncPagedListDiffer.PagedListListener<T> pagedListListener) {
        return (pagedListListener instanceof AsyncPagedListDiffer.OnCurrentListChangedWrapper) && ((AsyncPagedListDiffer.OnCurrentListChangedWrapper) pagedListListener).getCallback() == this.f36451g;
    }
}
