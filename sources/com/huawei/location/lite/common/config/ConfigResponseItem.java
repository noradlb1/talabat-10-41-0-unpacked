package com.huawei.location.lite.common.config;

import com.google.gson.annotations.SerializedName;

public class ConfigResponseItem {
    @SerializedName("groupName")
    private String groupName;
    @SerializedName("itemName")
    private String itemName;
    @SerializedName("itemValue")
    private String itemValue;

    public String getGroupName() {
        return this.groupName;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemValue() {
        return this.itemValue;
    }
}
