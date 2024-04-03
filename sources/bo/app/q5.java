package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "", "prefsFilename", "currentSdkVersion", "Landroid/content/SharedPreferences;", "a", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0})
public final class q5 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39226a = BrazeLogger.INSTANCE.getBrazeLogTag("SharedPrefUtils");

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39227b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f39228c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f39229d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3) {
            super(0);
            this.f39227b = str;
            this.f39228c = str2;
            this.f39229d = str3;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Detected SDK update from '" + this.f39227b + "' -> '" + this.f39228c + "'. Clearing " + this.f39229d + " storage.";
        }
    }

    public static /* synthetic */ SharedPreferences a(Context context, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "23.3.0";
        }
        return a(context, str, str2);
    }

    public static final SharedPreferences a(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "prefsFilename");
        Intrinsics.checkNotNullParameter(str2, "currentSdkVersion");
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        String string = sharedPreferences.getString("last_accessed_sdk_version", "");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (!Intrinsics.areEqual((Object) str2, (Object) string)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f39226a, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new a(string, str2, str), 12, (Object) null);
            edit.clear().apply();
        }
        edit.putString("last_accessed_sdk_version", str2).apply();
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "prefs");
        return sharedPreferences;
    }
}
