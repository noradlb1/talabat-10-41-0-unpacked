package androidx.paging;

import androidx.paging.DataSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00070\u0006H@"}, d2 = {"", "Key", "ValueFrom", "ValueTo", "Landroidx/paging/DataSource$Params;", "params", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/DataSource$BaseResult;", "continuation", "load"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.WrapperDataSource", f = "WrapperDataSource.kt", i = {0}, l = {68}, m = "load$paging_common$suspendImpl", n = {"this"}, s = {"L$0"})
public final class WrapperDataSource$load$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37173h;

    /* renamed from: i  reason: collision with root package name */
    public int f37174i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WrapperDataSource f37175j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37176k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrapperDataSource$load$1(WrapperDataSource wrapperDataSource, Continuation continuation) {
        super(continuation);
        this.f37175j = wrapperDataSource;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37173h = obj;
        this.f37174i |= Integer.MIN_VALUE;
        return WrapperDataSource.a(this.f37175j, (DataSource.Params) null, this);
    }
}
