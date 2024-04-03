package androidx.paging;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004B[\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010(\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001f\u0012\u0018\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0\u0013\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b)\u0010*J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0002J\b\u0010\r\u001a\u00020\bH\u0014R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R&\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0015R\u0014\u0010%\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010&¨\u0006+"}, d2 = {"Landroidx/paging/LivePagedList;", "", "Key", "Value", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "", "force", "", "invalidate", "previous", "next", "onItemUpdate", "e", "currentData", "Landroidx/paging/PagedList;", "Lkotlinx/coroutines/Job;", "currentJob", "Lkotlinx/coroutines/Job;", "Lkotlin/Function0;", "callback", "Lkotlin/jvm/functions/Function0;", "Ljava/lang/Runnable;", "refreshRetryCallback", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/paging/PagedList$Config;", "config", "Landroidx/paging/PagedList$Config;", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "Landroidx/paging/PagingSource;", "pagingSourceFactory", "Lkotlinx/coroutines/CoroutineDispatcher;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetchDispatcher", "initialKey", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Object;Landroidx/paging/PagedList$Config;Landroidx/paging/PagedList$BoundaryCallback;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
public final class LivePagedList<Key, Value> extends LiveData<PagedList<Value>> {
    /* access modifiers changed from: private */
    public final PagedList.BoundaryCallback<Value> boundaryCallback;
    /* access modifiers changed from: private */
    public final Function0<Unit> callback = new LivePagedList$callback$1(this);
    /* access modifiers changed from: private */
    public final PagedList.Config config;
    /* access modifiers changed from: private */
    public final CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    public PagedList<Value> currentData;
    private Job currentJob;
    /* access modifiers changed from: private */
    public final CoroutineDispatcher fetchDispatcher;
    /* access modifiers changed from: private */
    public final CoroutineDispatcher notifyDispatcher;
    /* access modifiers changed from: private */
    public final Function0<PagingSource<Key, Value>> pagingSourceFactory;
    private final Runnable refreshRetryCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LivePagedList(@NotNull CoroutineScope coroutineScope2, @Nullable Key key, @NotNull PagedList.Config config2, @Nullable PagedList.BoundaryCallback<Value> boundaryCallback2, @NotNull Function0<? extends PagingSource<Key, Value>> function0, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CoroutineDispatcher coroutineDispatcher2) {
        super(new InitialPagedList(new InitialPagingSource(), coroutineScope2, coroutineDispatcher, coroutineDispatcher2, config2, key));
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(config2, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(function0, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "fetchDispatcher");
        this.coroutineScope = coroutineScope2;
        this.config = config2;
        this.boundaryCallback = boundaryCallback2;
        this.pagingSourceFactory = function0;
        this.notifyDispatcher = coroutineDispatcher;
        this.fetchDispatcher = coroutineDispatcher2;
        LivePagedList$refreshRetryCallback$1 livePagedList$refreshRetryCallback$1 = new LivePagedList$refreshRetryCallback$1(this);
        this.refreshRetryCallback = livePagedList$refreshRetryCallback$1;
        PagedList<Value> pagedList = (PagedList) getValue();
        Intrinsics.checkNotNull(pagedList);
        this.currentData = pagedList;
        pagedList.setRetryCallback(livePagedList$refreshRetryCallback$1);
    }

    /* access modifiers changed from: private */
    public final void invalidate(boolean z11) {
        Job job = this.currentJob;
        if (job == null || z11) {
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.currentJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.fetchDispatcher, (CoroutineStart) null, new LivePagedList$invalidate$1(this, (Continuation) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void onItemUpdate(PagedList<Value> pagedList, PagedList<Value> pagedList2) {
        pagedList.setRetryCallback((Runnable) null);
        pagedList2.setRetryCallback(this.refreshRetryCallback);
    }

    public void e() {
        super.e();
        invalidate(false);
    }
}
