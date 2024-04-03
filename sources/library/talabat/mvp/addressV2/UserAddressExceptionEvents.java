package library.talabat.mvp.addressV2;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Llibrary/talabat/mvp/addressV2/UserAddressExceptionEvents;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "exception", "", "debugInfo", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAddressExceptionEvents extends TalabatEvent {
    @NotNull
    private final String debugInfo;
    @NotNull
    private final Throwable exception;

    public UserAddressExceptionEvents(@NotNull Throwable th2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(th2, "exception");
        Intrinsics.checkNotNullParameter(str, "debugInfo");
        this.exception = th2;
        this.debugInfo = str;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        StackTraceElement[] stackTrace = this.exception.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "exception.stackTrace");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("exceptionMessage", this.exception.getMessage()), TuplesKt.to("stacktrace", ArraysKt___ArraysKt.take((T[]) stackTrace, 5).toString()), TuplesKt.to("debugInfo", this.debugInfo));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "save_address";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "save_address_client_exceptions";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.NEW_RELIC);
    }
}
