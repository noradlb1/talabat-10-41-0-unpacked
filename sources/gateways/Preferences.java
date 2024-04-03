package gateways;

import JsonModels.parser.UniversalGson;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.lib.Integration;
import io.reactivex.annotations.Experimental;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J%\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u0001H\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J#\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u0001H\b¢\u0006\u0002\u0010\u000fJ+\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u0001H\bH\u0002¢\u0006\u0002\u0010\u0012J)\u0010\u0013\u001a\u00020\f\"\u0004\b\u0000\u0010\b*\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u0001H\bH\u0002¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lgateways/Preferences;", "", "()V", "isSaved", "", "key", "", "load", "T", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "save", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "getValue", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putValue", "Landroid/content/SharedPreferences$Editor;", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/Object;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Experimental
public final class Preferences {
    @NotNull
    public static final Preferences INSTANCE = new Preferences();

    private Preferences() {
    }

    private final <T> T getValue(SharedPreferences sharedPreferences, String str, T t11) throws ClassCastException {
        String str2;
        Object obj;
        if (!sharedPreferences.contains(str)) {
            return t11;
        }
        UniversalGson universalGson = UniversalGson.INSTANCE;
        Gson gson = universalGson.gson;
        PersistentData persistentData = new PersistentData(t11);
        if (!(gson instanceof Gson)) {
            str2 = gson.toJson((Object) persistentData);
        } else {
            str2 = GsonInstrumentation.toJson(gson, (Object) persistentData);
        }
        String string = sharedPreferences.getString(str, str2);
        Gson gson2 = universalGson.gson;
        Class cls = PersistentData.class;
        if (!(gson2 instanceof Gson)) {
            obj = gson2.fromJson(string, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson2, string, cls);
        }
        return ((PersistentData) obj).getValue();
    }

    private final <T> void putValue(SharedPreferences.Editor editor, String str, T t11) {
        Gson gson = UniversalGson.INSTANCE.gson;
        PersistentData persistentData = new PersistentData(t11);
        editor.putString(str, !(gson instanceof Gson) ? gson.toJson((Object) persistentData) : GsonInstrumentation.toJson(gson, (Object) persistentData));
    }

    public final boolean isSaved(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return Integration.getAppContext().getSharedPreferences(SharedPreferencesKt.PREFERENCES_NAME, 0).contains(str);
    }

    @Nullable
    public final <T> T load(@NotNull String str, @Nullable T t11) throws ClassCastException {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences sharedPreferences = Integration.getAppContext().getSharedPreferences(SharedPreferencesKt.PREFERENCES_NAME, 0);
        Preferences preferences = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "");
        return preferences.getValue(sharedPreferences, str, t11);
    }

    public final void remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Integration.getAppContext().getSharedPreferences(SharedPreferencesKt.PREFERENCES_NAME, 0).edit().remove(str).apply();
    }

    public final <T> void save(@NotNull String str, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor edit = Integration.getAppContext().getSharedPreferences(SharedPreferencesKt.PREFERENCES_NAME, 0).edit();
        Preferences preferences = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(edit, "");
        preferences.putValue(edit, str, t11);
        edit.apply();
    }
}
