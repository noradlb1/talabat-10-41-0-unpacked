package androidx.datastore.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0002\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0001H@"}, d2 = {"T", "startingData", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", i = {0, 0}, l = {44, 46}, m = "invokeSuspend", n = {"migration", "data"}, s = {"L$2", "L$3"})
public final class DataMigrationInitializer$Companion$runMigrations$2 extends SuspendLambda implements Function2<T, Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f35614h;

    /* renamed from: i  reason: collision with root package name */
    public Object f35615i;

    /* renamed from: j  reason: collision with root package name */
    public Object f35616j;

    /* renamed from: k  reason: collision with root package name */
    public int f35617k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f35618l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ List<DataMigration<T>> f35619m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ List<Function1<Continuation<? super Unit>, Object>> f35620n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$2(List<? extends DataMigration<T>> list, List<Function1<Continuation<? super Unit>, Object>> list2, Continuation<? super DataMigrationInitializer$Companion$runMigrations$2> continuation) {
        super(2, continuation);
        this.f35619m = list;
        this.f35620n = list2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.f35619m, this.f35620n, continuation);
        dataMigrationInitializer$Companion$runMigrations$2.f35618l = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    @Nullable
    public final Object invoke(T t11, @Nullable Continuation<? super T> continuation) {
        return ((DataMigrationInitializer$Companion$runMigrations$2) create(t11, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.f35617k
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            java.lang.Object r1 = r10.f35614h
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r4 = r10.f35618l
            java.util.List r4 = (java.util.List) r4
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            goto L_0x008e
        L_0x001c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0024:
            java.lang.Object r1 = r10.f35616j
            java.lang.Object r4 = r10.f35615i
            androidx.datastore.core.DataMigration r4 = (androidx.datastore.core.DataMigration) r4
            java.lang.Object r5 = r10.f35614h
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r10.f35618l
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            r9 = r6
            r6 = r4
            r4 = r9
            goto L_0x006c
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.f35618l
            java.util.List<androidx.datastore.core.DataMigration<T>> r1 = r10.f35619m
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List<kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r4 = r10.f35620n
            java.util.Iterator r1 = r1.iterator()
            r5 = r10
        L_0x004a:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0093
            java.lang.Object r6 = r1.next()
            androidx.datastore.core.DataMigration r6 = (androidx.datastore.core.DataMigration) r6
            r5.f35618l = r4
            r5.f35614h = r1
            r5.f35615i = r6
            r5.f35616j = r11
            r5.f35617k = r3
            java.lang.Object r7 = r6.shouldMigrate(r11, r5)
            if (r7 != r0) goto L_0x0067
            return r0
        L_0x0067:
            r9 = r1
            r1 = r11
            r11 = r7
            r7 = r5
            r5 = r9
        L_0x006c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0090
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r11 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r8 = 0
            r11.<init>(r6, r8)
            r4.add(r11)
            r7.f35618l = r4
            r7.f35614h = r5
            r7.f35615i = r8
            r7.f35616j = r8
            r7.f35617k = r2
            java.lang.Object r11 = r6.migrate(r1, r7)
            if (r11 != r0) goto L_0x0091
            return r0
        L_0x008e:
            r5 = r7
            goto L_0x004a
        L_0x0090:
            r11 = r1
        L_0x0091:
            r1 = r5
            goto L_0x008e
        L_0x0093:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
