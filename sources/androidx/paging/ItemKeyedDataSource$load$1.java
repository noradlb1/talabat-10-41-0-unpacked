package androidx.paging;

import androidx.paging.DataSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005H@"}, d2 = {"", "Key", "Value", "Landroidx/paging/DataSource$Params;", "params", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/DataSource$BaseResult;", "continuation", "load"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.ItemKeyedDataSource", f = "ItemKeyedDataSource.kt", i = {}, l = {171, 177, 178}, m = "load$paging_common", n = {}, s = {})
public final class ItemKeyedDataSource$load$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36608h;

    /* renamed from: i  reason: collision with root package name */
    public int f36609i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ItemKeyedDataSource f36610j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemKeyedDataSource$load$1(ItemKeyedDataSource itemKeyedDataSource, Continuation continuation) {
        super(continuation);
        this.f36610j = itemKeyedDataSource;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36608h = obj;
        this.f36609i |= Integer.MIN_VALUE;
        return this.f36610j.load$paging_common((DataSource.Params) null, this);
    }
}
