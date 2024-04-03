package com.huawei.location.nlp.network.request;

import com.huawei.location.nlp.network.request.cell.CellExtraInfo;
import com.huawei.location.nlp.network.request.wifi.WifiExtraInfo;

public class ResponseExtraInfo {
    private CellExtraInfo cellExtraInfo;
    private IndoorLocation indoorGlobalLocation;
    private IndoorLocation indoorLocalLocation;
    private WifiExtraInfo wifiExtraInfo;

    public CellExtraInfo getCellExtraInfo() {
        return this.cellExtraInfo;
    }

    public IndoorLocation getIndoorGlobalLocation() {
        return this.indoorGlobalLocation;
    }

    public IndoorLocation getIndoorLocalLocation() {
        return this.indoorLocalLocation;
    }

    public WifiExtraInfo getWifiExtraInfo() {
        return this.wifiExtraInfo;
    }

    public void setCellExtraInfo(CellExtraInfo cellExtraInfo2) {
        this.cellExtraInfo = cellExtraInfo2;
    }

    public void setIndoorGlobalLocation(IndoorLocation indoorLocation) {
        this.indoorGlobalLocation = indoorLocation;
    }

    public void setIndoorLocalLocation(IndoorLocation indoorLocation) {
        this.indoorLocalLocation = indoorLocation;
    }

    public void setWifiExtraInfo(WifiExtraInfo wifiExtraInfo2) {
        this.wifiExtraInfo = wifiExtraInfo2;
    }
}
