package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.paging.DataSource;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
final class LegacyPagingSource$sam$androidx_paging_DataSource_InvalidatedCallback$0 implements DataSource.InvalidatedCallback, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    public LegacyPagingSource$sam$androidx_paging_DataSource_InvalidatedCallback$0(Function0 function0) {
        this.function = function0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DataSource.InvalidatedCallback) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual((Object) this.function, (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    @AnyThread
    public final /* synthetic */ void onInvalidated() {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
