package com.talabat.sdsquad.ui.vendorslist.displaymodels;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/ActiveEventDisplayModel;", "", "eventMsg", "", "eventValue", "", "eventType", "floodActive", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getEventMsg", "()Ljava/lang/String;", "getEventType", "getEventValue", "()I", "getFloodActive", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveEventDisplayModel {
    @NotNull
    private final String eventMsg;
    @NotNull
    private final String eventType;
    private final int eventValue;
    private final boolean floodActive;

    public ActiveEventDisplayModel(@NotNull String str, int i11, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "eventMsg");
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        this.eventMsg = str;
        this.eventValue = i11;
        this.eventType = str2;
        this.floodActive = z11;
    }

    public static /* synthetic */ ActiveEventDisplayModel copy$default(ActiveEventDisplayModel activeEventDisplayModel, String str, int i11, String str2, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = activeEventDisplayModel.eventMsg;
        }
        if ((i12 & 2) != 0) {
            i11 = activeEventDisplayModel.eventValue;
        }
        if ((i12 & 4) != 0) {
            str2 = activeEventDisplayModel.eventType;
        }
        if ((i12 & 8) != 0) {
            z11 = activeEventDisplayModel.floodActive;
        }
        return activeEventDisplayModel.copy(str, i11, str2, z11);
    }

    @NotNull
    public final String component1() {
        return this.eventMsg;
    }

    public final int component2() {
        return this.eventValue;
    }

    @NotNull
    public final String component3() {
        return this.eventType;
    }

    public final boolean component4() {
        return this.floodActive;
    }

    @NotNull
    public final ActiveEventDisplayModel copy(@NotNull String str, int i11, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "eventMsg");
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        return new ActiveEventDisplayModel(str, i11, str2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveEventDisplayModel)) {
            return false;
        }
        ActiveEventDisplayModel activeEventDisplayModel = (ActiveEventDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.eventMsg, (Object) activeEventDisplayModel.eventMsg) && this.eventValue == activeEventDisplayModel.eventValue && Intrinsics.areEqual((Object) this.eventType, (Object) activeEventDisplayModel.eventType) && this.floodActive == activeEventDisplayModel.floodActive;
    }

    @NotNull
    public final String getEventMsg() {
        return this.eventMsg;
    }

    @NotNull
    public final String getEventType() {
        return this.eventType;
    }

    public final int getEventValue() {
        return this.eventValue;
    }

    public final boolean getFloodActive() {
        return this.floodActive;
    }

    public int hashCode() {
        int hashCode = ((((this.eventMsg.hashCode() * 31) + this.eventValue) * 31) + this.eventType.hashCode()) * 31;
        boolean z11 = this.floodActive;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        String str = this.eventMsg;
        int i11 = this.eventValue;
        String str2 = this.eventType;
        boolean z11 = this.floodActive;
        return "ActiveEventDisplayModel(eventMsg=" + str + ", eventValue=" + i11 + ", eventType=" + str2 + ", floodActive=" + z11 + ")";
    }
}
