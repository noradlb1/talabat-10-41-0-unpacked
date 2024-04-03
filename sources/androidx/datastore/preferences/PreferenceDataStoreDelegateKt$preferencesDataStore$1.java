package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.preferences.core.Preferences;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/content/Context;", "it", "", "Landroidx/datastore/core/DataMigration;", "Landroidx/datastore/preferences/core/Preferences;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreferenceDataStoreDelegateKt$preferencesDataStore$1 extends Lambda implements Function1<Context, List<? extends DataMigration<Preferences>>> {
    public static final PreferenceDataStoreDelegateKt$preferencesDataStore$1 INSTANCE = new PreferenceDataStoreDelegateKt$preferencesDataStore$1();

    public PreferenceDataStoreDelegateKt$preferencesDataStore$1() {
        super(1);
    }

    @NotNull
    public final List<DataMigration<Preferences>> invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
