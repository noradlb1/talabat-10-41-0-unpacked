package androidx.paging;

import androidx.paging.PagePresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "T", "", "type", "Landroidx/paging/LoadType;", "fromMediator", "", "state", "Landroidx/paging/LoadState;", "invoke"}, k = 3, mv = {1, 4, 2})
public final class PagePresenter$insertPage$1 extends Lambda implements Function3<LoadType, Boolean, LoadState, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PagePresenter.ProcessPageEventCallback f36853g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagePresenter$insertPage$1(PagePresenter.ProcessPageEventCallback processPageEventCallback) {
        super(3);
        this.f36853g = processPageEventCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((LoadType) obj, ((Boolean) obj2).booleanValue(), (LoadState) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LoadType loadType, boolean z11, @NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "type");
        Intrinsics.checkNotNullParameter(loadState, "state");
        this.f36853g.onStateUpdate(loadType, z11, loadState);
    }
}
