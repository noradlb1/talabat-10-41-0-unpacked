package com.talabat.darkstores.domain.recentsearches.observability;

import com.integration.grocerydiscovery.GroceryDiscoveryObservabilityIntegration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/domain/recentsearches/observability/RecentSearchesObservabilityManagerImpl;", "Lcom/talabat/darkstores/domain/recentsearches/observability/RecentSearchesObservabilityManager;", "observability", "Lcom/integration/grocerydiscovery/GroceryDiscoveryObservabilityIntegration;", "(Lcom/integration/grocerydiscovery/GroceryDiscoveryObservabilityIntegration;)V", "onRecentSearchStorageError", "", "error", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecentSearchesObservabilityManagerImpl implements RecentSearchesObservabilityManager {
    @NotNull
    private final GroceryDiscoveryObservabilityIntegration observability;

    @Inject
    public RecentSearchesObservabilityManagerImpl(@NotNull GroceryDiscoveryObservabilityIntegration groceryDiscoveryObservabilityIntegration) {
        Intrinsics.checkNotNullParameter(groceryDiscoveryObservabilityIntegration, "observability");
        this.observability = groceryDiscoveryObservabilityIntegration;
    }

    public void onRecentSearchStorageError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        GroceryDiscoveryObservabilityIntegration groceryDiscoveryObservabilityIntegration = this.observability;
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        groceryDiscoveryObservabilityIntegration.onRecentSearchStorageError(message);
    }
}
