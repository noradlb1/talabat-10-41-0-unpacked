package bo.app;

import android.content.Context;
import com.braze.configuration.BrazeConfigurationProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lbo/app/g0;", "Lcom/braze/configuration/BrazeConfigurationProvider;", "", "a", "()J", "badNetworkFlushIntervalInMilliseconds", "b", "goodNetworkFlushIntervalInMilliseconds", "c", "greatNetworkFlushIntervalInMilliseconds", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class g0 extends BrazeConfigurationProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final a f38532a = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lbo/app/g0$a;", "", "", "DEFAULT_BAD_NETWORK_INTERVAL_S", "I", "DEFAULT_GOOD_NETWORK_INTERVAL_S", "DEFAULT_GREAT_NETWORK_INTERVAL_S", "", "MIN_DATA_FLUSH_INTERVAL_MILLIS", "J", "MS_IN_SEC", "NO_DATA_FLUSH_INTERVAL_VALUE", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g0(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final long a() {
        return ((long) getIntValue(BrazeConfigurationProvider.b.DATA_SYNC_BAD_NETWORK_INTERVAL_KEY.b(), 60)) * 1000;
    }

    public final long b() {
        return ((long) getIntValue(BrazeConfigurationProvider.b.DATA_SYNC_GOOD_NETWORK_INTERVAL_KEY.b(), 30)) * 1000;
    }

    public final long c() {
        return ((long) getIntValue(BrazeConfigurationProvider.b.DATA_SYNC_GREAT_NETWORK_INTERVAL_KEY.b(), 10)) * 1000;
    }
}
