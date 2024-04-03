package com.talabat.feature.pickup.data.events;

import com.facebook.internal.NativeProtocol;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bHÖ\u0003J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/pickup/data/events/TooltipEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "action", "Lcom/talabat/feature/pickup/data/events/TooltipActions;", "(Lcom/talabat/feature/pickup/data/events/TooltipActions;)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TooltipEvent extends TalabatEvent {
    @NotNull
    private static final String CLICKED_EVENT_NAME = "tooltip_clicked";
    @NotNull
    private static final String CLOSED_EVENT_NAME = "tooltip_closed";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SHOWN_EVENT_NAME = "tooltip_shown";
    @NotNull
    private final TooltipActions action;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/pickup/data/events/TooltipEvent$Companion;", "", "()V", "CLICKED_EVENT_NAME", "", "CLOSED_EVENT_NAME", "SHOWN_EVENT_NAME", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TooltipActions.values().length];
            iArr[TooltipActions.SHOWN.ordinal()] = 1;
            iArr[TooltipActions.CLICKED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TooltipEvent(@NotNull TooltipActions tooltipActions) {
        Intrinsics.checkNotNullParameter(tooltipActions, NativeProtocol.WEB_DIALOG_ACTION);
        this.action = tooltipActions;
    }

    private final TooltipActions component1() {
        return this.action;
    }

    public static /* synthetic */ TooltipEvent copy$default(TooltipEvent tooltipEvent, TooltipActions tooltipActions, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            tooltipActions = tooltipEvent.action;
        }
        return tooltipEvent.copy(tooltipActions);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenType", "shop_list"), TuplesKt.to("screenName", "Restaurant List Screen"), TuplesKt.to(ConstantsKt.TOOLTIP_NAME, "pickup"));
    }

    @NotNull
    public final TooltipEvent copy(@NotNull TooltipActions tooltipActions) {
        Intrinsics.checkNotNullParameter(tooltipActions, NativeProtocol.WEB_DIALOG_ACTION);
        return new TooltipEvent(tooltipActions);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TooltipEvent) && this.action == ((TooltipEvent) obj).action;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
    }

    public int hashCode() {
        return this.action.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.action.ordinal()];
        if (i11 == 1) {
            return SHOWN_EVENT_NAME;
        }
        if (i11 != 2) {
            return CLOSED_EVENT_NAME;
        }
        return CLICKED_EVENT_NAME;
    }

    @NotNull
    public String toString() {
        TooltipActions tooltipActions = this.action;
        return "TooltipEvent(action=" + tooltipActions + ")";
    }
}
