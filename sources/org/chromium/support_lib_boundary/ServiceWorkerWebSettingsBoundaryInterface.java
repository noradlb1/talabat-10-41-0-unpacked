package org.chromium.support_lib_boundary;

import java.util.Set;

public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    Set<String> getRequestedWithHeaderOriginAllowList();

    void setAllowContentAccess(boolean z11);

    void setAllowFileAccess(boolean z11);

    void setBlockNetworkLoads(boolean z11);

    void setCacheMode(int i11);

    void setRequestedWithHeaderOriginAllowList(Set<String> set);
}
