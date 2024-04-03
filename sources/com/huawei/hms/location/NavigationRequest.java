package com.huawei.hms.location;

import android.os.Parcel;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class NavigationRequest implements IMessageEntity {
    public static final int IS_SUPPORT_EX = 2;
    public static final int OVERPASS = 1;
    @Packed
    private Map<String, String> extras;
    @Packed
    private int type;

    public NavigationRequest(int i11) {
        this.type = i11;
    }

    public NavigationRequest(Parcel parcel) {
        this.type = parcel.readInt();
        HashMap hashMap = new HashMap();
        this.extras = hashMap;
        parcel.readMap(hashMap, NavigationRequest.class.getClassLoader());
    }

    private Map<String, String> getExtras() {
        return this.extras;
    }

    public int getType() {
        return this.type;
    }

    public void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "NavigationRequest{type = " + this.type + AbstractJsonLexerKt.END_OBJ;
    }
}
