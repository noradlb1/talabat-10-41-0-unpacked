package androidx.paging;

import androidx.paging.DataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\b\b\u0002\u0010\u0002*\u00020\u0004\"\b\b\u0003\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource;", "Key", "Value", "", "invoke"}, k = 3, mv = {1, 4, 2})
public final class DataSource$Factory$asPagingSourceFactory$1 extends Lambda implements Function0<PagingSource<Key, Value>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f36542g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CoroutineDispatcher f36543h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataSource$Factory$asPagingSourceFactory$1(DataSource.Factory factory, CoroutineDispatcher coroutineDispatcher) {
        super(0);
        this.f36542g = factory;
        this.f36543h = coroutineDispatcher;
    }

    @NotNull
    public final PagingSource<Key, Value> invoke() {
        return new LegacyPagingSource(this.f36543h, this.f36542g.create());
    }
}
