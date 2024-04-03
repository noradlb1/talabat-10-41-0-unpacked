package com.huawei.riemann.gnsslocation.core.bean.log;

import java.util.ArrayList;
import java.util.List;

public class GpsRti {
    public int gpsTow23b;
    public int gpsWeek;
    public List<GpsRtiItem> rtiList = new ArrayList();
    public int satNumber;
    public boolean valid;
}
