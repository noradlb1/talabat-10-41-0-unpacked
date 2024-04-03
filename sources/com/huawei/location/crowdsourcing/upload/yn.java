package com.huawei.location.crowdsourcing.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.activity.model.Vw;
import com.huawei.location.crowdsourcing.upload.http.FB;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.Map;

public class yn {

    /* renamed from: com.huawei.location.crowdsourcing.upload.yn$yn  reason: collision with other inner class name */
    public static class C0080yn extends com.huawei.location.crowdsourcing.upload.http.yn {
        @SerializedName("serverDomain")
        private String FB;
        @SerializedName("accessToken")
        private String LW;
        @SerializedName("resCode")
        private int Vw = -1;
        @SerializedName("reason")

        /* renamed from: yn  reason: collision with root package name */
        private String f50088yn;

        private C0080yn() {
        }

        public String FB() {
            String str = this.LW;
            return str == null ? "" : str;
        }

        public String LW() {
            String str = this.FB;
            return str == null ? "" : str;
        }

        public boolean Vw() {
            return Vw.Vw(this.Vw);
        }

        @NonNull
        public String a() {
            return Vw.yn(this.Vw);
        }
    }

    @Nullable
    public com.huawei.location.crowdsourcing.upload.entity.Vw yn(@NonNull com.huawei.location.crowdsourcing.upload.entity.Vw vw2, Map<String, String> map, String str) {
        LogConsole.i("GetServerDomain", "getDomainFromCloud start");
        FB fb2 = new FB(vw2.f50082yn, "/v2/getServerDomain");
        fb2.yn(map).dC(vw2.Vw, str).Vw("appID", str);
        C0080yn ynVar = (C0080yn) fb2.yn(C0080yn.class);
        if (ynVar != null) {
            return new com.huawei.location.crowdsourcing.upload.entity.Vw(ynVar.LW(), ynVar.FB());
        }
        LogConsole.i("GetServerDomain", "resp is null:");
        return null;
    }
}
