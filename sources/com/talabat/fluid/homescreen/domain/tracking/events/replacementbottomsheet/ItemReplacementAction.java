package com.talabat.fluid.homescreen.domain.tracking.events.replacementbottomsheet;

import com.talabat.core.navigation.domain.screen.itemreplacement.ItemReplacementScreen;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH&R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/events/replacementbottomsheet/ItemReplacementAction;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "shopId", "", "eventOrigin", "screenName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "platforms", "", "uniqueAttributes", "Lcom/talabat/fluid/homescreen/domain/tracking/events/replacementbottomsheet/ItemReplacementBsClickedEvent;", "Lcom/talabat/fluid/homescreen/domain/tracking/events/replacementbottomsheet/ItemReplacementBsClosedEvent;", "Lcom/talabat/fluid/homescreen/domain/tracking/events/replacementbottomsheet/ItemReplacementBsShownEvent;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ItemReplacementAction extends TalabatEvent {
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final String screenName;
    @NotNull
    private final String shopId;

    private ItemReplacementAction(String str, String str2, String str3) {
        this.shopId = str;
        this.eventOrigin = str2;
        this.screenName = str3;
    }

    public /* synthetic */ ItemReplacementAction(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenType", ItemReplacementScreen.EVENT_ORIGIN_BOTTOM_SHEET), TuplesKt.to("eventOrigin", this.eventOrigin), TuplesKt.to("screenName", this.screenName), TuplesKt.to("shopID", this.shopId)), (Map) uniqueAttributes());
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return ItemReplacementScreen.EVENT_ORIGIN_BOTTOM_SHEET;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public abstract Map<String, Object> uniqueAttributes();
}
