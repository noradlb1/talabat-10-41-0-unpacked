package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007¨\u0006\u0012"}, d2 = {"Landroidx/datastore/core/DataStoreFactory;", "", "()V", "create", "Landroidx/datastore/core/DataStore;", "T", "serializer", "Landroidx/datastore/core/Serializer;", "corruptionHandler", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "migrations", "", "Landroidx/datastore/core/DataMigration;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DataStoreFactory {
    @NotNull
    public static final DataStoreFactory INSTANCE = new DataStoreFactory();

    private DataStoreFactory() {
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i11, Object obj) {
        ReplaceFileCorruptionHandler replaceFileCorruptionHandler2;
        if ((i11 & 2) != 0) {
            replaceFileCorruptionHandler2 = null;
        } else {
            replaceFileCorruptionHandler2 = replaceFileCorruptionHandler;
        }
        if ((i11 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        if ((i11 & 8) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        }
        return dataStoreFactory.create(serializer, replaceFileCorruptionHandler2, list2, coroutineScope, function0);
    }

    @NotNull
    @JvmOverloads
    public final <T> DataStore<T> create(@NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<T>> list, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(list, "migrations");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, list, (CoroutineScope) null, function0, 8, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final <T> DataStore<T> create(@NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<T>> list, @NotNull CoroutineScope coroutineScope, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(list, "migrations");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        CorruptionHandler corruptionHandler = replaceFileCorruptionHandler;
        if (replaceFileCorruptionHandler == null) {
            corruptionHandler = new NoOpCorruptionHandler();
        }
        return new SingleProcessDataStore(function0, serializer, CollectionsKt__CollectionsJVMKt.listOf(DataMigrationInitializer.Companion.getInitializer(list)), corruptionHandler, coroutineScope);
    }

    @NotNull
    @JvmOverloads
    public final <T> DataStore<T> create(@NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, (List) null, (CoroutineScope) null, function0, 12, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final <T> DataStore<T> create(@NotNull Serializer<T> serializer, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create$default(this, serializer, (ReplaceFileCorruptionHandler) null, (List) null, (CoroutineScope) null, function0, 14, (Object) null);
    }
}
