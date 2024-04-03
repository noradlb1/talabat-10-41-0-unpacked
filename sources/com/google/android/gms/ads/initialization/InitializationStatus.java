package com.google.android.gms.ads.initialization;

import androidx.annotation.RecentlyNonNull;
import java.util.Map;

public interface InitializationStatus {
    @RecentlyNonNull
    Map<String, AdapterStatus> getAdapterStatusMap();
}
