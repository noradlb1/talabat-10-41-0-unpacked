package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "T", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "previousList", "Landroidx/paging/PagedList;", "currentList", "invoke"}, k = 3, mv = {1, 4, 2})
final class PagedListAdapter$listener$1 extends Lambda implements Function2<PagedList<Object>, PagedList<Object>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PagedListAdapter f36863g;

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PagedList<Object>) (PagedList) obj, (PagedList<Object>) (PagedList) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable PagedList<Object> pagedList, @Nullable PagedList<Object> pagedList2) {
        this.f36863g.onCurrentListChanged(pagedList2);
        this.f36863g.onCurrentListChanged(pagedList, pagedList2);
    }
}
