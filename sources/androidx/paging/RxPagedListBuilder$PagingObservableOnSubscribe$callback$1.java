package androidx.paging;

import androidx.paging.RxPagedListBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0002*\u00020\u0003\"\b\b\u0003\u0010\u0004*\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Key", "", "Value", "invoke"}, k = 3, mv = {1, 4, 2})
public final class RxPagedListBuilder$PagingObservableOnSubscribe$callback$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RxPagedListBuilder.PagingObservableOnSubscribe f37080g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxPagedListBuilder$PagingObservableOnSubscribe$callback$1(RxPagedListBuilder.PagingObservableOnSubscribe pagingObservableOnSubscribe) {
        super(0);
        this.f37080g = pagingObservableOnSubscribe;
    }

    public final void invoke() {
        this.f37080g.invalidate(true);
    }
}
