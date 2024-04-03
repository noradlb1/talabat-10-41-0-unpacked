package library.talabat.mvp.login.data.api.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Llibrary/talabat/mvp/login/data/api/response/Result;", "", "activeEvent", "Llibrary/talabat/mvp/login/data/api/response/ActiveEvent;", "deliveryAreaDetails", "Llibrary/talabat/mvp/login/data/api/response/DeliveryAreaDetails;", "(Llibrary/talabat/mvp/login/data/api/response/ActiveEvent;Llibrary/talabat/mvp/login/data/api/response/DeliveryAreaDetails;)V", "getActiveEvent", "()Llibrary/talabat/mvp/login/data/api/response/ActiveEvent;", "getDeliveryAreaDetails", "()Llibrary/talabat/mvp/login/data/api/response/DeliveryAreaDetails;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Result {
    @SerializedName("active_event")
    @Nullable
    private final ActiveEvent activeEvent;
    @SerializedName("deliveryarea_details")
    @Nullable
    private final DeliveryAreaDetails deliveryAreaDetails;

    public Result(@Nullable ActiveEvent activeEvent2, @Nullable DeliveryAreaDetails deliveryAreaDetails2) {
        this.activeEvent = activeEvent2;
        this.deliveryAreaDetails = deliveryAreaDetails2;
    }

    public static /* synthetic */ Result copy$default(Result result, ActiveEvent activeEvent2, DeliveryAreaDetails deliveryAreaDetails2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            activeEvent2 = result.activeEvent;
        }
        if ((i11 & 2) != 0) {
            deliveryAreaDetails2 = result.deliveryAreaDetails;
        }
        return result.copy(activeEvent2, deliveryAreaDetails2);
    }

    @Nullable
    public final ActiveEvent component1() {
        return this.activeEvent;
    }

    @Nullable
    public final DeliveryAreaDetails component2() {
        return this.deliveryAreaDetails;
    }

    @NotNull
    public final Result copy(@Nullable ActiveEvent activeEvent2, @Nullable DeliveryAreaDetails deliveryAreaDetails2) {
        return new Result(activeEvent2, deliveryAreaDetails2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Result)) {
            return false;
        }
        Result result = (Result) obj;
        return Intrinsics.areEqual((Object) this.activeEvent, (Object) result.activeEvent) && Intrinsics.areEqual((Object) this.deliveryAreaDetails, (Object) result.deliveryAreaDetails);
    }

    @Nullable
    public final ActiveEvent getActiveEvent() {
        return this.activeEvent;
    }

    @Nullable
    public final DeliveryAreaDetails getDeliveryAreaDetails() {
        return this.deliveryAreaDetails;
    }

    public int hashCode() {
        ActiveEvent activeEvent2 = this.activeEvent;
        int i11 = 0;
        int hashCode = (activeEvent2 == null ? 0 : activeEvent2.hashCode()) * 31;
        DeliveryAreaDetails deliveryAreaDetails2 = this.deliveryAreaDetails;
        if (deliveryAreaDetails2 != null) {
            i11 = deliveryAreaDetails2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        ActiveEvent activeEvent2 = this.activeEvent;
        DeliveryAreaDetails deliveryAreaDetails2 = this.deliveryAreaDetails;
        return "Result(activeEvent=" + activeEvent2 + ", deliveryAreaDetails=" + deliveryAreaDetails2 + ")";
    }
}
