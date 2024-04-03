package com.huawei.location.tiles.store;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Vw {
    @SerializedName("tileInfoList")
    private List<FB> Vw;
    @SerializedName("code")

    /* renamed from: yn  reason: collision with root package name */
    private String f50247yn;

    public Vw(String str, List<FB> list) {
        this.f50247yn = str;
        this.Vw = list;
    }

    public List<FB> Vw() {
        return this.Vw;
    }

    public String yn() {
        return this.f50247yn;
    }
}
