package com.talabat.fluid.homescreen.domain.usecase.business;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H&J\u001c\u0010\b\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H&J\u001c\u0010\t\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\n"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSecondaryBannerUseCases;", "", "resetTracking", "", "trackSecondaryBannerClicked", "params", "", "", "trackSecondaryBannerLoaded", "trackSecondaryBannerShown", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackSecondaryBannerUseCases {
    void resetTracking();

    void trackSecondaryBannerClicked(@NotNull Map<String, String> map);

    void trackSecondaryBannerLoaded(@NotNull Map<String, String> map);

    void trackSecondaryBannerShown(@NotNull Map<String, String> map);
}
