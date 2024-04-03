package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003;<=B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0002H\u0016J\u0018\u0010(\u001a\u00020+2\u0006\u0010,\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0002H\u0016J\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0018J\b\u0010/\u001a\u00020+H\u0016J\f\u00100\u001a\b\u0012\u0004\u0012\u00020201J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0002J\u0006\u00104\u001a\u000205J\b\u00106\u001a\u000205H\u0002J\u0011\u00107\u001a\u00020\u00022\u0006\u0010,\u001a\u00020 H\u0002J\u0010\u00108\u001a\u00020\u00022\u0006\u0010,\u001a\u00020 H\u0016J\u000e\u00109\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0018J\u0019\u0010:\u001a\u00020\u00022\u0006\u0010,\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0002H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R$\u0010$\u001a\u00020 2\u0006\u0010#\u001a\u00020 8F@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010'R\u000e\u0010#\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/facebook/GraphRequestBatch;", "Ljava/util/AbstractList;", "Lcom/facebook/GraphRequest;", "()V", "requests", "", "(Ljava/util/Collection;)V", "", "([Lcom/facebook/GraphRequest;)V", "(Lcom/facebook/GraphRequestBatch;)V", "batchApplicationId", "", "getBatchApplicationId", "()Ljava/lang/String;", "setBatchApplicationId", "(Ljava/lang/String;)V", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "<set-?>", "", "Lcom/facebook/GraphRequestBatch$Callback;", "callbacks", "getCallbacks", "()Ljava/util/List;", "id", "getId", "getRequests", "size", "", "getSize", "()I", "timeoutInMilliseconds", "timeout", "getTimeout", "setTimeout", "(I)V", "add", "", "element", "", "index", "addCallback", "callback", "clear", "executeAndWait", "", "Lcom/facebook/GraphResponse;", "executeAndWaitImpl", "executeAsync", "Lcom/facebook/GraphRequestAsyncTask;", "executeAsyncImpl", "get", "removeAt", "removeCallback", "set", "Callback", "Companion", "OnProgressCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GraphRequestBatch extends AbstractList<GraphRequest> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final AtomicInteger idGenerator = new AtomicInteger();
    @Nullable
    private String batchApplicationId;
    @Nullable
    private Handler callbackHandler;
    @NotNull
    private List<Callback> callbacks;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f33572id;
    @NotNull
    private List<GraphRequest> requests;
    private int timeoutInMilliseconds;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequestBatch$Callback;", "", "onBatchCompleted", "", "batch", "Lcom/facebook/GraphRequestBatch;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void onBatchCompleted(@NotNull GraphRequestBatch graphRequestBatch);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/GraphRequestBatch$Companion;", "", "()V", "idGenerator", "Ljava/util/concurrent/atomic/AtomicInteger;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/facebook/GraphRequestBatch$OnProgressCallback;", "Lcom/facebook/GraphRequestBatch$Callback;", "onBatchProgress", "", "batch", "Lcom/facebook/GraphRequestBatch;", "current", "", "max", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnProgressCallback extends Callback {
        void onBatchProgress(@NotNull GraphRequestBatch graphRequestBatch, long j11, long j12);
    }

    public GraphRequestBatch() {
        this.f33572id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
    }

    private final List<GraphResponse> executeAndWaitImpl() {
        return GraphRequest.Companion.executeBatchAndWait(this);
    }

    private final GraphRequestAsyncTask executeAsyncImpl() {
        return GraphRequest.Companion.executeBatchAsync(this);
    }

    public final void addCallback(@NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.callbacks.contains(callback)) {
            this.callbacks.add(callback);
        }
    }

    public void clear() {
        this.requests.clear();
    }

    public /* bridge */ boolean contains(GraphRequest graphRequest) {
        return super.contains(graphRequest);
    }

    @NotNull
    public final List<GraphResponse> executeAndWait() {
        return executeAndWaitImpl();
    }

    @NotNull
    public final GraphRequestAsyncTask executeAsync() {
        return executeAsyncImpl();
    }

    @Nullable
    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    @Nullable
    public final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    @NotNull
    public final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    @NotNull
    public final String getId() {
        return this.f33572id;
    }

    @NotNull
    public final List<GraphRequest> getRequests() {
        return this.requests;
    }

    public int getSize() {
        return this.requests.size();
    }

    public final int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public /* bridge */ int indexOf(GraphRequest graphRequest) {
        return super.indexOf(graphRequest);
    }

    public /* bridge */ int lastIndexOf(GraphRequest graphRequest) {
        return super.lastIndexOf(graphRequest);
    }

    public final /* bridge */ GraphRequest remove(int i11) {
        return removeAt(i11);
    }

    @NotNull
    public GraphRequest removeAt(int i11) {
        return this.requests.remove(i11);
    }

    public final void removeCallback(@NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.remove(callback);
    }

    public final void setBatchApplicationId(@Nullable String str) {
        this.batchApplicationId = str;
    }

    public final void setCallbackHandler(@Nullable Handler handler) {
        this.callbackHandler = handler;
    }

    public final void setTimeout(int i11) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.timeoutInMilliseconds = i11;
            return;
        }
        throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.".toString());
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj == null ? true : obj instanceof GraphRequest)) {
            return false;
        }
        return contains((GraphRequest) obj);
    }

    @NotNull
    public GraphRequest get(int i11) {
        return this.requests.get(i11);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj == null ? true : obj instanceof GraphRequest)) {
            return -1;
        }
        return indexOf((GraphRequest) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj == null ? true : obj instanceof GraphRequest)) {
            return -1;
        }
        return lastIndexOf((GraphRequest) obj);
    }

    @NotNull
    public GraphRequest set(int i11, @NotNull GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "element");
        return this.requests.set(i11, graphRequest);
    }

    public boolean add(@NotNull GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "element");
        return this.requests.add(graphRequest);
    }

    public /* bridge */ boolean remove(GraphRequest graphRequest) {
        return super.remove(graphRequest);
    }

    public void add(int i11, @NotNull GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "element");
        this.requests.add(i11, graphRequest);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj == null ? true : obj instanceof GraphRequest)) {
            return false;
        }
        return remove((GraphRequest) obj);
    }

    public GraphRequestBatch(@NotNull Collection<GraphRequest> collection) {
        Intrinsics.checkNotNullParameter(collection, "requests");
        this.f33572id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(collection);
    }

    public GraphRequestBatch(@NotNull GraphRequest... graphRequestArr) {
        Intrinsics.checkNotNullParameter(graphRequestArr, "requests");
        this.f33572id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(ArraysKt___ArraysJvmKt.asList((T[]) graphRequestArr));
    }

    public GraphRequestBatch(@NotNull GraphRequestBatch graphRequestBatch) {
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
        this.f33572id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(graphRequestBatch);
        this.callbackHandler = graphRequestBatch.callbackHandler;
        this.timeoutInMilliseconds = graphRequestBatch.timeoutInMilliseconds;
        this.callbacks = new ArrayList(graphRequestBatch.callbacks);
    }
}
