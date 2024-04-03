package com.huawei.riemann.location.bean.log;

import java.util.ArrayList;
import java.util.List;

public class GpsRtc {
    public int gpsTow23b;
    public List<GpsRtcItem> rtcList = new ArrayList();
    public int satNumber;
    public boolean valid;
    public int weekNumber;
}
