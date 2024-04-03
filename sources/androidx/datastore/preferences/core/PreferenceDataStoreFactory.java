package androidx.datastore.preferences.core;

import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStoreFactory;", "", "()V", "create", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "corruptionHandler", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "migrations", "", "Landroidx/datastore/core/DataMigration;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PreferenceDataStoreFactory {
    @NotNull
    public static final PreferenceDataStoreFactory INSTANCE = new PreferenceDataStoreFactory();

    private PreferenceDataStoreFactory() {
    }

    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i11 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i11 & 4) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        }
        return preferenceDataStoreFactory.create(replaceFileCorruptionHandler, list, coroutineScope, function0);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(list, "migrations");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create$default(this, replaceFileCorruptionHandler, list, (CoroutineScope) null, function0, 4, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list, @NotNull CoroutineScope coroutineScope, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(list, "migrations");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return new PreferenceDataStore(DataStoreFactory.INSTANCE.create(PreferencesSerializer.INSTANCE, replaceFileCorruptionHandler, list, coroutineScope, new PreferenceDataStoreFactory$create$delegate$1(function0)));
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create$default(this, replaceFileCorruptionHandler, (List) null, (CoroutineScope) null, function0, 6, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (CoroutineScope) null, function0, 7, (Object) null);
    }
}
