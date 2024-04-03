package com.huawei.location.lite.common.log.logwrite;

import java.io.File;

public class LogWriteConstants {
    public static final String ACC = "accuracy";
    public static final String BUILDING_ID = "buildingId";
    public static final String DEBUG_PATH;
    public static final String FILE_SEPARATOR;
    public static final String FLOOR = "floor";
    public static final String FLOOR_ACC = "floorAcc";
    public static final String INNER_PATH_DATA_DATA = "data/data/";
    public static final String INNER_PATH_DATA_DATA1 = "/data/data/";
    public static final String INNER_PATH_DATA_USER = "data/user/";
    public static final String INNER_PATH_DATA_USER1 = "/data/user/";
    public static final String LATITUDE = "latitude";
    public static final String LOCATE_TYPE = "locateType";
    public static final String LOCATION_MSG_FORMAT = "%s";
    public static final String LOCATION_PATH;
    public static final String LOCATION_TIME = "locationTime";
    public static final String LOCATION_TYPE = "location";
    public static final String LOG_MSG_FORMAT = "%s: %s/%s: %s";
    public static final String LOG_TYPE = "log";
    public static final String LONGITUDE = "longitude";
    public static final String OUTTER_PATH_MNT_SD = "mnt/sdcard/";
    public static final String OUTTER_PATH_MNT_SD1 = "/mnt/sdcard/";
    public static final String OUTTER_PATH_STORAGE_B3E4 = "storage/B3E4-1711";
    public static final String OUTTER_PATH_STORAGE_B3E41 = "/storage/B3E4-1711";
    public static final String OUTTER_PATH_STORAGE_EMULATED = "storage/emulated";
    public static final String OUTTER_PATH_STORAGE_EMULATED1 = "/storage/emulated";
    public static final String OUTTER_PATH_STORAGE_SD = "storage/sdcard";
    public static final String OUTTER_PATH_STORAGE_SD1 = "/storage/sdcard";
    public static final String PRODUCT = "product";
    public static final String PROVIDER = "provider";
    public static final String SESSION_ID = "sessionId";
    public static final String SOURCE_TYPE = "sourceType";
    public static final String SPEED = "speed";
    public static final String SPLIT = ",";
    public static final String SRC = "src";
    public static final String SWITCH_HD = "switchHd";
    public static final String TRANS_ID = "transId";
    public static final String VENDOR_TYPE = "vendorType";
    public static final String WRITE_TIME = "writeTime";

    static {
        String str = File.separator;
        FILE_SEPARATOR = str;
        DEBUG_PATH = str + "debug" + str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("location");
        sb2.append(str);
        LOCATION_PATH = sb2.toString();
    }
}
