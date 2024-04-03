package com.talabat.darkstores.data.tracking.bottomsheet.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB3\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/data/tracking/bottomsheet/events/DarkStoreBottomSheetClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "storeInfoParams", "", "", "", "additionalParams", "(Ljava/util/Map;Ljava/util/Map;)V", "attributes", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkStoreBottomSheetClickedEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DARKSTORES = "darkstores";
    @NotNull
    private static final String EVENT_NAME_BOTTOM_SHEET_CLICKED = "bottom_sheet_clicked";
    @NotNull
    private final Map<String, Object> additionalParams;
    @NotNull
    private final Map<String, Object> storeInfoParams;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/data/tracking/bottomsheet/events/DarkStoreBottomSheetClickedEvent$Companion;", "", "()V", "DARKSTORES", "", "EVENT_NAME_BOTTOM_SHEET_CLICKED", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DarkStoreBottomSheetClickedEvent(Map map, Map map2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i11 & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.plus(this.storeInfoParams, this.additionalParams);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME_BOTTOM_SHEET_CLICKED;
    }

    public DarkStoreBottomSheetClickedEvent(@NotNull Map<String, ? extends Object> map, @NotNull Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(map, "storeInfoParams");
        Intrinsics.checkNotNullParameter(map2, "additionalParams");
        this.storeInfoParams = map;
        this.additionalParams = map2;
    }
}
