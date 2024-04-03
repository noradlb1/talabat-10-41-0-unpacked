package androidx.datastore;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"T", "Landroid/content/Context;", "it", "", "Landroidx/datastore/core/DataMigration;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DataStoreDelegateKt$dataStore$1 extends Lambda implements Function1 {
    public static final DataStoreDelegateKt$dataStore$1 INSTANCE = new DataStoreDelegateKt$dataStore$1();

    public DataStoreDelegateKt$dataStore$1() {
        super(1);
    }

    @NotNull
    public final List invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
