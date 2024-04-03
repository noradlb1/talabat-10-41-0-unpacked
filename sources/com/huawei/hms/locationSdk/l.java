package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.GetFromLocationNameRequest;
import com.huawei.hms.location.GetFromLocationRequest;
import com.huawei.hms.location.HWLocation;
import java.util.List;

public interface l {
    Task<List<HWLocation>> a(GetFromLocationNameRequest getFromLocationNameRequest);

    Task<List<HWLocation>> a(GetFromLocationRequest getFromLocationRequest);
}
