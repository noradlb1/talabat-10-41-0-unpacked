package com.talabat.fluid.homescreen.domain.tracking.events.replacementbottomsheet;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/events/replacementbottomsheet/ItemReplacementBsClosedEvent;", "Lcom/talabat/fluid/homescreen/domain/tracking/events/replacementbottomsheet/ItemReplacementAction;", "shopId", "", "eventOrigin", "screenName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "name", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "uniqueAttributes", "", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemReplacementBsClosedEvent extends ItemReplacementAction {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemReplacementBsClosedEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        super(str, str2, str3, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "screenName");
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "popup_closed";
    }

    @NotNull
    public Map<String, Object> uniqueAttributes() {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ConstantsKt.POPUP_TYPE, "grocery_replacement"), TuplesKt.to(ConstantsKt.POPUP_BUTTON, "clicked_closed"));
    }
}
