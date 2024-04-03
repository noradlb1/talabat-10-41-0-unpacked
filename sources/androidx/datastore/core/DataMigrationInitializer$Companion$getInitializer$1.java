package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H@"}, d2 = {"T", "Landroidx/datastore/core/InitializerApi;", "api", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
public final class DataMigrationInitializer$Companion$getInitializer$1 extends SuspendLambda implements Function2<InitializerApi<T>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f35606h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f35607i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List<DataMigration<T>> f35608j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$getInitializer$1(List<? extends DataMigration<T>> list, Continuation<? super DataMigrationInitializer$Companion$getInitializer$1> continuation) {
        super(2, continuation);
        this.f35608j = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DataMigrationInitializer$Companion$getInitializer$1 dataMigrationInitializer$Companion$getInitializer$1 = new DataMigrationInitializer$Companion$getInitializer$1(this.f35608j, continuation);
        dataMigrationInitializer$Companion$getInitializer$1.f35607i = obj;
        return dataMigrationInitializer$Companion$getInitializer$1;
    }

    @Nullable
    public final Object invoke(@NotNull InitializerApi<T> initializerApi, @Nullable Continuation<? super Unit> continuation) {
        return ((DataMigrationInitializer$Companion$getInitializer$1) create(initializerApi, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f35606h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DataMigrationInitializer.Companion companion = DataMigrationInitializer.Companion;
            List<DataMigration<T>> list = this.f35608j;
            this.f35606h = 1;
            if (companion.runMigrations(list, (InitializerApi) this.f35607i, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
