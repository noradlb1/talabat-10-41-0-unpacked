package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import java.io.File;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SingleProcessDataStore$file$2 extends Lambda implements Function0<File> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35643g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$file$2(SingleProcessDataStore<T> singleProcessDataStore) {
        super(0);
        this.f35643g = singleProcessDataStore;
    }

    @NotNull
    public final File invoke() {
        File file = (File) this.f35643g.produceFile.invoke();
        String absolutePath = file.getAbsolutePath();
        SingleProcessDataStore.Companion companion = SingleProcessDataStore.Companion;
        synchronized (companion.getActiveFilesLock$datastore_core()) {
            if (!companion.getActiveFiles$datastore_core().contains(absolutePath)) {
                Set<String> activeFiles$datastore_core = companion.getActiveFiles$datastore_core();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "it");
                activeFiles$datastore_core.add(absolutePath);
            } else {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
        }
        return file;
    }
}
