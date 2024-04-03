package androidx.datastore.preferences;

import androidx.datastore.migrations.SharedPreferencesView;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"Landroidx/datastore/migrations/SharedPreferencesView;", "sharedPrefs", "Landroidx/datastore/preferences/core/Preferences;", "currentData", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getMigrationFunction$1", f = "SharedPreferencesMigration.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SharedPreferencesMigrationKt$getMigrationFunction$1 extends SuspendLambda implements Function3<SharedPreferencesView, Preferences, Continuation<? super Preferences>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f35722h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f35723i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f35724j;

    public SharedPreferencesMigrationKt$getMigrationFunction$1(Continuation<? super SharedPreferencesMigrationKt$getMigrationFunction$1> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull SharedPreferencesView sharedPreferencesView, @NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
        SharedPreferencesMigrationKt$getMigrationFunction$1 sharedPreferencesMigrationKt$getMigrationFunction$1 = new SharedPreferencesMigrationKt$getMigrationFunction$1(continuation);
        sharedPreferencesMigrationKt$getMigrationFunction$1.f35723i = sharedPreferencesView;
        sharedPreferencesMigrationKt$getMigrationFunction$1.f35724j = preferences;
        return sharedPreferencesMigrationKt$getMigrationFunction$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f35722h == 0) {
            ResultKt.throwOnFailure(obj);
            SharedPreferencesView sharedPreferencesView = (SharedPreferencesView) this.f35723i;
            Preferences preferences = (Preferences) this.f35724j;
            Set<Preferences.Key<?>> keySet = preferences.asMap().keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10));
            for (Preferences.Key name2 : keySet) {
                arrayList.add(name2.getName());
            }
            Map<String, Object> all = sharedPreferencesView.getAll();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : all.entrySet()) {
                if (Boxing.boxBoolean(!arrayList.contains((String) next.getKey())).booleanValue()) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            MutablePreferences mutablePreferences = preferences.toMutablePreferences();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Boolean) {
                    mutablePreferences.set(PreferencesKeys.booleanKey(str), value);
                } else if (value instanceof Float) {
                    mutablePreferences.set(PreferencesKeys.floatKey(str), value);
                } else if (value instanceof Integer) {
                    mutablePreferences.set(PreferencesKeys.intKey(str), value);
                } else if (value instanceof Long) {
                    mutablePreferences.set(PreferencesKeys.longKey(str), value);
                } else if (value instanceof String) {
                    mutablePreferences.set(PreferencesKeys.stringKey(str), value);
                } else if (value instanceof Set) {
                    Preferences.Key<Set<String>> stringSetKey = PreferencesKeys.stringSetKey(str);
                    if (value != null) {
                        mutablePreferences.set(stringSetKey, (Set) value);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                    }
                } else {
                    continue;
                }
            }
            return mutablePreferences.toPreferences();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
