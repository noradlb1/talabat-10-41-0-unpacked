package tracking.observability.di;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.observability.VendorInfoAPIObservability;
import tracking.observability.VendorInfoAPIObservabilityImpl;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Ltracking/observability/di/VendorInfoAPIObservabilityProvider;", "", "()V", "provideVendorInfoAPIObservability", "Ltracking/observability/VendorInfoAPIObservability;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfoAPIObservabilityProvider {
    @NotNull
    public static final VendorInfoAPIObservabilityProvider INSTANCE = new VendorInfoAPIObservabilityProvider();

    private VendorInfoAPIObservabilityProvider() {
    }

    @NotNull
    public final VendorInfoAPIObservability provideVendorInfoAPIObservability(@NotNull IObservabilityManager iObservabilityManager, @NotNull AppVersionProvider appVersionProvider) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        return new VendorInfoAPIObservabilityImpl(iObservabilityManager, appVersionProvider);
    }
}
