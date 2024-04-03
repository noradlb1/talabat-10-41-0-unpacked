package bo.app;

import android.content.Context;
import com.braze.Braze;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lbo/app/f5;", "Lbo/app/s2;", "", "a", "Landroid/content/Context;", "applicationContext", "<init>", "(Landroid/content/Context;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class f5 implements s2 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38527a;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f38528b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Content Cards enabled in server config. Requesting Content Cards refresh.";
        }
    }

    public f5(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        this.f38527a = context;
    }

    public void a() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f38528b, 7, (Object) null);
        Braze.Companion.getInstance(this.f38527a).requestContentCardsRefresh(false);
    }
}
