package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/PagingDataDiffer$collectFrom$2$1$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PagingDataDiffer$collectFrom$2$1$1", f = "PagingDataDiffer.kt", i = {0, 0}, l = {142, 180}, m = "invokeSuspend", n = {"newPresenter", "onListPresentableCalled"}, s = {"L$0", "L$1"})
public final class PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f36880h;

    /* renamed from: i  reason: collision with root package name */
    public Object f36881i;

    /* renamed from: j  reason: collision with root package name */
    public int f36882j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PageEvent f36883k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 f36884l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1(PageEvent pageEvent, Continuation continuation, PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1) {
        super(2, continuation);
        this.f36883k = pageEvent;
        this.f36884l = pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1(this.f36883k, continuation, this.f36884l);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0129  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.f36882j
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0028
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00fb
        L_0x0014:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001c:
            java.lang.Object r0 = r12.f36881i
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            java.lang.Object r1 = r12.f36880h
            androidx.paging.PagePresenter r1 = (androidx.paging.PagePresenter) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0086
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r13)
            androidx.paging.PageEvent r13 = r12.f36883k
            boolean r1 = r13 instanceof androidx.paging.PageEvent.Insert
            if (r1 == 0) goto L_0x00e6
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            androidx.paging.LoadType r13 = r13.getLoadType()
            androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH
            if (r13 != r1) goto L_0x00e6
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            r13.lastAccessedIndexUnfulfilled = r4
            androidx.paging.PagePresenter r1 = new androidx.paging.PagePresenter
            androidx.paging.PageEvent r13 = r12.f36883k
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            r1.<init>(r13)
            kotlin.jvm.internal.Ref$BooleanRef r13 = new kotlin.jvm.internal.Ref$BooleanRef
            r13.<init>()
            r13.element = r4
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r2 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r2 = r2.f36879b
            androidx.paging.PagingDataDiffer r5 = r2.f36890i
            androidx.paging.PagePresenter r6 = r5.presenter
            androidx.paging.PageEvent r2 = r12.f36883k
            androidx.paging.PageEvent$Insert r2 = (androidx.paging.PageEvent.Insert) r2
            androidx.paging.CombinedLoadStates r8 = r2.getCombinedLoadStates()
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r2 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r2 = r2.f36879b
            androidx.paging.PagingDataDiffer r2 = r2.f36890i
            int r9 = r2.lastAccessedIndex
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1$1 r10 = new androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1$1
            r10.<init>(r12, r1, r13)
            r12.f36880h = r1
            r12.f36881i = r13
            r12.f36882j = r3
            r7 = r1
            r11 = r12
            java.lang.Object r2 = r5.presentNewList(r6, r7, r8, r9, r10, r11)
            if (r2 != r0) goto L_0x0084
            return r0
        L_0x0084:
            r0 = r13
            r13 = r2
        L_0x0086:
            java.lang.Integer r13 = (java.lang.Integer) r13
            boolean r0 = r0.element
            if (r0 == 0) goto L_0x00da
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r0 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r0 = r0.f36879b
            androidx.paging.PagingDataDiffer r0 = r0.f36890i
            androidx.paging.PageEvent r2 = r12.f36883k
            androidx.paging.PageEvent$Insert r2 = (androidx.paging.PageEvent.Insert) r2
            androidx.paging.CombinedLoadStates r2 = r2.getCombinedLoadStates()
            r0.dispatchLoadStates(r2)
            if (r13 != 0) goto L_0x00b4
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            androidx.paging.UiReceiver r13 = r13.receiver
            if (r13 == 0) goto L_0x0238
            androidx.paging.ViewportHint$Initial r0 = r1.initializeHint()
            r13.accessHint(r0)
            goto L_0x0238
        L_0x00b4:
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r0 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r0 = r0.f36879b
            androidx.paging.PagingDataDiffer r0 = r0.f36890i
            int r2 = r13.intValue()
            r0.lastAccessedIndex = r2
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r0 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r0 = r0.f36879b
            androidx.paging.PagingDataDiffer r0 = r0.f36890i
            androidx.paging.UiReceiver r0 = r0.receiver
            if (r0 == 0) goto L_0x0238
            int r13 = r13.intValue()
            androidx.paging.ViewportHint$Access r13 = r1.accessHintForPresenterIndex(r13)
            r0.accessHint(r13)
            goto L_0x0238
        L_0x00da:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "Missing call to onListPresentable after new list was presented. If you are seeing this exception, it is generally an indication of an issue with Paging. Please file a bug so we can fix it at: https://issuetracker.google.com/issues/new?component=413106"
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x00e6:
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            boolean r13 = r13.postEvents()
            if (r13 == 0) goto L_0x00fb
            r12.f36882j = r2
            java.lang.Object r13 = kotlinx.coroutines.YieldKt.yield(r12)
            if (r13 != r0) goto L_0x00fb
            return r0
        L_0x00fb:
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            androidx.paging.PagePresenter r13 = r13.presenter
            androidx.paging.PageEvent r0 = r12.f36883k
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r1 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r1 = r1.f36879b
            androidx.paging.PagingDataDiffer r1 = r1.f36890i
            androidx.paging.PagingDataDiffer$processPageEventCallback$1 r1 = r1.processPageEventCallback
            r13.processEvent(r0, r1)
            androidx.paging.PageEvent r13 = r12.f36883k
            boolean r13 = r13 instanceof androidx.paging.PageEvent.Drop
            if (r13 == 0) goto L_0x0123
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            r13.lastAccessedIndexUnfulfilled = r4
        L_0x0123:
            androidx.paging.PageEvent r13 = r12.f36883k
            boolean r0 = r13 instanceof androidx.paging.PageEvent.Insert
            if (r0 == 0) goto L_0x0238
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            androidx.paging.CombinedLoadStates r13 = r13.getCombinedLoadStates()
            androidx.paging.LoadState r13 = r13.getPrepend()
            boolean r13 = r13.getEndOfPaginationReached()
            androidx.paging.PageEvent r0 = r12.f36883k
            androidx.paging.PageEvent$Insert r0 = (androidx.paging.PageEvent.Insert) r0
            androidx.paging.CombinedLoadStates r0 = r0.getCombinedLoadStates()
            androidx.paging.LoadState r0 = r0.getAppend()
            boolean r0 = r0.getEndOfPaginationReached()
            androidx.paging.PageEvent r1 = r12.f36883k
            androidx.paging.PageEvent$Insert r1 = (androidx.paging.PageEvent.Insert) r1
            androidx.paging.LoadType r1 = r1.getLoadType()
            androidx.paging.LoadType r2 = androidx.paging.LoadType.PREPEND
            if (r1 != r2) goto L_0x0155
            if (r13 != 0) goto L_0x0164
        L_0x0155:
            androidx.paging.PageEvent r13 = r12.f36883k
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            androidx.paging.LoadType r13 = r13.getLoadType()
            androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND
            if (r13 != r1) goto L_0x0166
            if (r0 != 0) goto L_0x0164
            goto L_0x0166
        L_0x0164:
            r13 = r4
            goto L_0x0167
        L_0x0166:
            r13 = r3
        L_0x0167:
            androidx.paging.PageEvent r0 = r12.f36883k
            androidx.paging.PageEvent$Insert r0 = (androidx.paging.PageEvent.Insert) r0
            java.util.List r0 = r0.getPages()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x0180
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0180
        L_0x017e:
            r0 = r3
            goto L_0x01a3
        L_0x0180:
            java.util.Iterator r0 = r0.iterator()
        L_0x0184:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x017e
            java.lang.Object r1 = r0.next()
            androidx.paging.TransformablePage r1 = (androidx.paging.TransformablePage) r1
            java.util.List r1 = r1.getData()
            boolean r1 = r1.isEmpty()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0184
            r0 = r4
        L_0x01a3:
            if (r13 != 0) goto L_0x01b0
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            r13.lastAccessedIndexUnfulfilled = r4
            goto L_0x0238
        L_0x01b0:
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            boolean r13 = r13.lastAccessedIndexUnfulfilled
            if (r13 != 0) goto L_0x01be
            if (r0 == 0) goto L_0x0238
        L_0x01be:
            if (r0 != 0) goto L_0x0205
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            int r13 = r13.lastAccessedIndex
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r0 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r0 = r0.f36879b
            androidx.paging.PagingDataDiffer r0 = r0.f36890i
            androidx.paging.PagePresenter r0 = r0.presenter
            int r0 = r0.getPlaceholdersBefore()
            if (r13 < r0) goto L_0x0205
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            int r13 = r13.lastAccessedIndex
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r0 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r0 = r0.f36879b
            androidx.paging.PagingDataDiffer r0 = r0.f36890i
            androidx.paging.PagePresenter r0 = r0.presenter
            int r0 = r0.getPlaceholdersBefore()
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r1 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r1 = r1.f36879b
            androidx.paging.PagingDataDiffer r1 = r1.f36890i
            androidx.paging.PagePresenter r1 = r1.presenter
            int r1 = r1.getStorageCount()
            int r0 = r0 + r1
            if (r13 <= r0) goto L_0x0204
            goto L_0x0205
        L_0x0204:
            r3 = r4
        L_0x0205:
            if (r3 == 0) goto L_0x022f
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            androidx.paging.UiReceiver r13 = r13.receiver
            if (r13 == 0) goto L_0x0238
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r0 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r0 = r0.f36879b
            androidx.paging.PagingDataDiffer r0 = r0.f36890i
            androidx.paging.PagePresenter r0 = r0.presenter
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r1 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r1 = r1.f36879b
            androidx.paging.PagingDataDiffer r1 = r1.f36890i
            int r1 = r1.lastAccessedIndex
            androidx.paging.ViewportHint$Access r0 = r0.accessHintForPresenterIndex(r1)
            r13.accessHint(r0)
            goto L_0x0238
        L_0x022f:
            androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 r13 = r12.f36884l
            androidx.paging.PagingDataDiffer$collectFrom$2 r13 = r13.f36879b
            androidx.paging.PagingDataDiffer r13 = r13.f36890i
            r13.lastAccessedIndexUnfulfilled = r4
        L_0x0238:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
