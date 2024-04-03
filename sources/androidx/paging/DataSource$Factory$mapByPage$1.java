package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/paging/DataSource$Factory$mapByPage$1", "Landroidx/paging/DataSource$Factory;", "create", "Landroidx/paging/DataSource;", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class DataSource$Factory$mapByPage$1 extends DataSource.Factory<Key, ToValue> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f36546a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f36547b;

    public DataSource$Factory$mapByPage$1(DataSource.Factory factory, Function function) {
        this.f36546a = factory;
        this.f36547b = function;
    }

    @NotNull
    public DataSource<Key, ToValue> create() {
        return this.f36546a.create().mapByPage(this.f36547b);
    }
}
