package com.deliveryhero.contract.location;

import androidx.activity.result.contract.ActivityResultContract;
import com.deliveryhero.contract.model.LocationData;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/contract/location/LocationProvider;", "", "fetchLocation", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Lcom/deliveryhero/contract/model/LocationData;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LocationProvider {
    @NotNull
    ActivityResultContract<Unit, LocationData> fetchLocation();
}
