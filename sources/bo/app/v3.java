package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0007\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lbo/app/v3;", "", "", "userId", "", "a", "()Ljava/lang/String;", "lastUserId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class v3 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f39500b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f39501a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u0012\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\n"}, d2 = {"Lbo/app/v3$a;", "", "", "EMPTY_USER_ID", "Ljava/lang/String;", "LAST_USER_KEY", "getLAST_USER_KEY$annotations", "()V", "SHARED_PREFERENCES_NAME", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39502b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(0);
            this.f39502b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Stored user ID is longer than 997 bytes. Truncating. Original user ID: ", this.f39502b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39503b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "userId is empty in updateLastUserId. Rejecting.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39504b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(0);
            this.f39504b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Offline user storage provider was given user ID longer than 997. Rejecting. User ID: ", this.f39504b);
        }
    }

    public v3(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.offline.storagemap", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.f39501a = sharedPreferences;
    }

    public final String a() {
        String str = "";
        String string = this.f39501a.getString("last_user", str);
        if (string != null) {
            str = string;
        }
        if (StringUtils.getByteSize(str) <= 997) {
            return str;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(str), 6, (Object) null);
        String truncateToByteLength = StringUtils.truncateToByteLength(str, 997);
        a(truncateToByteLength);
        return truncateToByteLength;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        if (str.length() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f39503b, 6, (Object) null);
        } else if (StringUtils.getByteSize(str) > 997) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new d(str), 6, (Object) null);
        } else {
            SharedPreferences.Editor edit = this.f39501a.edit();
            edit.putString("last_user", str);
            edit.apply();
        }
    }
}
