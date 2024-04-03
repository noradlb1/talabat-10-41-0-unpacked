package com.talabat.fluid.homescreen.domain.usecase.business;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH&¨\u0006\f"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroCarouselSlideUseCase;", "", "pauseTracking", "", "resetTracking", "resumeTracking", "trackSlide", "bannerId", "", "params", "", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackHeroCarouselSlideUseCase {
    void pauseTracking();

    void resetTracking();

    void resumeTracking();

    void trackSlide(int i11, @NotNull Map<String, String> map);
}
