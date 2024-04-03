package com.baseflow.geolocator.location;

import java.util.Map;

public class AndroidIconResource {
    private final String defType;

    /* renamed from: name  reason: collision with root package name */
    private final String f43227name;

    private AndroidIconResource(String str, String str2) {
        this.f43227name = str;
        this.defType = str2;
    }

    public static AndroidIconResource parseArguments(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new AndroidIconResource((String) map.get("name"), (String) map.get("defType"));
    }

    public String getDefType() {
        return this.defType;
    }

    public String getName() {
        return this.f43227name;
    }
}
