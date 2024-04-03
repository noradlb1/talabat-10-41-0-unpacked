package com.talabat.fluid.homescreen.domain.tracking.events.replacementbottomsheet;

import com.talabat.core.tracking.domain.TalabatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/events/replacementbottomsheet/ItemReplacementBottomSheetTracker;", "", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "trackClickChooseReplacementButton", "", "chainId", "", "eventOrigin", "screenName", "trackClosingBottomSheet", "navigationOrigin", "trackShowingBottomSheet", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemReplacementBottomSheetTracker {
    @NotNull
    private final TalabatTracker talabatTracker;

    public ItemReplacementBottomSheetTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public final void trackClickChooseReplacementButton(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        this.talabatTracker.track(new ItemReplacementBsClickedEvent(str, str2, str3));
    }

    public final void trackClosingBottomSheet(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "navigationOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        this.talabatTracker.track(new ItemReplacementBsClosedEvent(str, str2, str3));
    }

    public final void trackShowingBottomSheet(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        this.talabatTracker.track(new ItemReplacementBsShownEvent(str, str2, str3));
    }
}
