package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/paging/FlattenedPageController;", "T", "", "()V", "list", "Landroidx/paging/FlattenedPageEventStorage;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "snapshots", "", "Landroidx/paging/TemporaryDownstream;", "createTemporaryDownstream", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "record", "", "event", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 2})
final class FlattenedPageController<T> {
    private final FlattenedPageEventStorage<T> list = new FlattenedPageEventStorage<>();
    private final Mutex lock = MutexKt.Mutex$default(false, 1, (Object) null);
    private List<TemporaryDownstream<T>> snapshots = CollectionsKt__CollectionsKt.emptyList();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088 A[Catch:{ all -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createTemporaryDownstream(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.TemporaryDownstream<T>> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof androidx.paging.FlattenedPageController$createTemporaryDownstream$1
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L_0x0013
            r0 = r13
            androidx.paging.FlattenedPageController$createTemporaryDownstream$1 r0 = (androidx.paging.FlattenedPageController$createTemporaryDownstream$1) r0
            int r2 = r0.f36553i
            r3 = r2 & r1
            if (r3 == 0) goto L_0x0013
            int r2 = r2 - r1
            r0.f36553i = r2
            goto L_0x0018
        L_0x0013:
            androidx.paging.FlattenedPageController$createTemporaryDownstream$1 r0 = new androidx.paging.FlattenedPageController$createTemporaryDownstream$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f36552h
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.f36553i
            r4 = 2
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0058
            if (r3 == r6) goto L_0x004b
            if (r3 != r4) goto L_0x0043
            int r3 = r0.f36559o
            java.lang.Object r6 = r0.f36558n
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r0.f36557m
            androidx.paging.TemporaryDownstream r7 = (androidx.paging.TemporaryDownstream) r7
            java.lang.Object r8 = r0.f36556l
            androidx.paging.TemporaryDownstream r8 = (androidx.paging.TemporaryDownstream) r8
            java.lang.Object r9 = r0.f36555k
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0040 }
            r13 = r3
            goto L_0x0082
        L_0x0040:
            r13 = move-exception
            goto L_0x00bc
        L_0x0043:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x004b:
            java.lang.Object r3 = r0.f36556l
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            java.lang.Object r6 = r0.f36555k
            androidx.paging.FlattenedPageController r6 = (androidx.paging.FlattenedPageController) r6
            kotlin.ResultKt.throwOnFailure(r13)
            r9 = r3
            goto L_0x006c
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlinx.coroutines.sync.Mutex r13 = r12.lock
            r0.f36555k = r12
            r0.f36556l = r13
            r0.f36553i = r6
            java.lang.Object r3 = r13.lock(r5, r0)
            if (r3 != r2) goto L_0x006a
            return r2
        L_0x006a:
            r6 = r12
            r9 = r13
        L_0x006c:
            androidx.paging.TemporaryDownstream r13 = new androidx.paging.TemporaryDownstream     // Catch:{ all -> 0x0040 }
            r13.<init>()     // Catch:{ all -> 0x0040 }
            androidx.paging.FlattenedPageEventStorage<T> r3 = r6.list     // Catch:{ all -> 0x0040 }
            java.util.List r3 = r3.getAsEvents()     // Catch:{ all -> 0x0040 }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x0040 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0040 }
            r6 = 0
            r7 = r13
            r8 = r7
            r13 = r6
            r6 = r3
        L_0x0082:
            boolean r3 = r6.hasNext()     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x00b8
            java.lang.Object r3 = r6.next()     // Catch:{ all -> 0x0040 }
            int r10 = r13 + 1
            if (r13 >= 0) goto L_0x0093
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()     // Catch:{ all -> 0x0040 }
        L_0x0093:
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13)     // Catch:{ all -> 0x0040 }
            androidx.paging.PageEvent r3 = (androidx.paging.PageEvent) r3     // Catch:{ all -> 0x0040 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0040 }
            kotlin.collections.IndexedValue r11 = new kotlin.collections.IndexedValue     // Catch:{ all -> 0x0040 }
            int r13 = r13 + r1
            r11.<init>(r13, r3)     // Catch:{ all -> 0x0040 }
            r0.f36555k = r9     // Catch:{ all -> 0x0040 }
            r0.f36556l = r8     // Catch:{ all -> 0x0040 }
            r0.f36557m = r7     // Catch:{ all -> 0x0040 }
            r0.f36558n = r6     // Catch:{ all -> 0x0040 }
            r0.f36559o = r10     // Catch:{ all -> 0x0040 }
            r0.f36553i = r4     // Catch:{ all -> 0x0040 }
            java.lang.Object r13 = r7.send(r11, r0)     // Catch:{ all -> 0x0040 }
            if (r13 != r2) goto L_0x00b6
            return r2
        L_0x00b6:
            r13 = r10
            goto L_0x0082
        L_0x00b8:
            r9.unlock(r5)
            return r8
        L_0x00bc:
            r9.unlock(r5)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.createTemporaryDownstream(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099 A[Catch:{ all -> 0x0044 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c5 A[Catch:{ all -> 0x0044 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9 A[Catch:{ all -> 0x0044 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object record(@org.jetbrains.annotations.NotNull kotlin.collections.IndexedValue<? extends androidx.paging.PageEvent<T>> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.paging.FlattenedPageController$record$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.paging.FlattenedPageController$record$1 r0 = (androidx.paging.FlattenedPageController$record$1) r0
            int r1 = r0.f36561i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36561i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.FlattenedPageController$record$1 r0 = new androidx.paging.FlattenedPageController$record$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f36560h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36561i
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0061
            if (r2 == r4) goto L_0x004f
            if (r2 != r3) goto L_0x0047
            java.lang.Object r10 = r0.f36568p
            java.lang.Object r2 = r0.f36567o
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.f36566n
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r6 = r0.f36565m
            androidx.paging.FlattenedPageController r6 = (androidx.paging.FlattenedPageController) r6
            java.lang.Object r7 = r0.f36564l
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r0.f36563k
            kotlin.collections.IndexedValue r8 = (kotlin.collections.IndexedValue) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0044 }
            goto L_0x00b5
        L_0x0044:
            r10 = move-exception
            goto L_0x00d5
        L_0x0047:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x004f:
            java.lang.Object r10 = r0.f36565m
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            java.lang.Object r2 = r0.f36564l
            kotlin.collections.IndexedValue r2 = (kotlin.collections.IndexedValue) r2
            java.lang.Object r4 = r0.f36563k
            androidx.paging.FlattenedPageController r4 = (androidx.paging.FlattenedPageController) r4
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            r10 = r2
            goto L_0x0077
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.sync.Mutex r11 = r9.lock
            r0.f36563k = r9
            r0.f36564l = r10
            r0.f36565m = r11
            r0.f36561i = r4
            java.lang.Object r2 = r11.lock(r5, r0)
            if (r2 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r4 = r9
            r7 = r11
        L_0x0077:
            androidx.paging.FlattenedPageEventStorage<T> r11 = r4.list     // Catch:{ all -> 0x0044 }
            java.lang.Object r2 = r10.getValue()     // Catch:{ all -> 0x0044 }
            androidx.paging.PageEvent r2 = (androidx.paging.PageEvent) r2     // Catch:{ all -> 0x0044 }
            r11.add(r2)     // Catch:{ all -> 0x0044 }
            java.util.List<androidx.paging.TemporaryDownstream<T>> r11 = r4.snapshots     // Catch:{ all -> 0x0044 }
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch:{ all -> 0x0044 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0044 }
            r2.<init>()     // Catch:{ all -> 0x0044 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0044 }
            r8 = r10
            r6 = r4
            r4 = r2
            r2 = r11
        L_0x0093:
            boolean r10 = r2.hasNext()     // Catch:{ all -> 0x0044 }
            if (r10 == 0) goto L_0x00c9
            java.lang.Object r10 = r2.next()     // Catch:{ all -> 0x0044 }
            r11 = r10
            androidx.paging.TemporaryDownstream r11 = (androidx.paging.TemporaryDownstream) r11     // Catch:{ all -> 0x0044 }
            r0.f36563k = r8     // Catch:{ all -> 0x0044 }
            r0.f36564l = r7     // Catch:{ all -> 0x0044 }
            r0.f36565m = r6     // Catch:{ all -> 0x0044 }
            r0.f36566n = r4     // Catch:{ all -> 0x0044 }
            r0.f36567o = r2     // Catch:{ all -> 0x0044 }
            r0.f36568p = r10     // Catch:{ all -> 0x0044 }
            r0.f36561i = r3     // Catch:{ all -> 0x0044 }
            java.lang.Object r11 = r11.send(r8, r0)     // Catch:{ all -> 0x0044 }
            if (r11 != r1) goto L_0x00b5
            return r1
        L_0x00b5:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0044 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0044 }
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)     // Catch:{ all -> 0x0044 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0044 }
            if (r11 == 0) goto L_0x0093
            r4.add(r10)     // Catch:{ all -> 0x0044 }
            goto L_0x0093
        L_0x00c9:
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x0044 }
            r6.snapshots = r4     // Catch:{ all -> 0x0044 }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0044 }
            r7.unlock(r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00d5:
            r7.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.record(kotlin.collections.IndexedValue, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
