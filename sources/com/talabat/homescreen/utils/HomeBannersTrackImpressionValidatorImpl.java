package com.talabat.homescreen.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/homescreen/utils/HomeBannersTrackImpressionValidatorImpl;", "Lcom/talabat/homescreen/utils/HomeBannersTrackImpressionValidator;", "()V", "trackedBannerIds", "", "", "canTrackImpressionFor", "", "bannerId", "didTrackImpressionFor", "", "reset", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeBannersTrackImpressionValidatorImpl implements HomeBannersTrackImpressionValidator {
    @NotNull
    private final List<String> trackedBannerIds = new ArrayList();

    public boolean canTrackImpressionFor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "bannerId");
        return !this.trackedBannerIds.contains(str);
    }

    public void didTrackImpressionFor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "bannerId");
        this.trackedBannerIds.add(str);
    }

    public void reset() {
        this.trackedBannerIds.clear();
    }
}
