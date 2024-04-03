package com.talabat.homescreen.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/talabat/homescreen/utils/HomeBannersTrackImpressionValidator;", "", "canTrackImpressionFor", "", "bannerId", "", "didTrackImpressionFor", "", "reset", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HomeBannersTrackImpressionValidator {
    boolean canTrackImpressionFor(@NotNull String str);

    void didTrackImpressionFor(@NotNull String str);

    void reset();
}
