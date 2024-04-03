package com.huawei.location.crowdsourcing.upload;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.activity.model.Vw;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.Map;

public class FB {

    public static class yn extends com.huawei.location.crowdsourcing.upload.http.yn {
        @SerializedName("resCode")

        /* renamed from: yn  reason: collision with root package name */
        private int f50066yn = -1;

        private yn() {
        }

        public boolean Vw() {
            return Vw.Vw(this.f50066yn);
        }

        @NonNull
        public String a() {
            return Vw.yn(this.f50066yn);
        }
    }

    public boolean yn(Map<String, String> map, @NonNull com.huawei.location.crowdsourcing.upload.entity.Vw vw2, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        LogConsole.i("NotifySuccess", "doNotifySuccess start");
        com.huawei.location.crowdsourcing.upload.http.FB fb2 = new com.huawei.location.crowdsourcing.upload.http.FB(vw2.f50082yn, "/v2/notifyUploadSucc");
        fb2.yn(map).FB("fileUniqueFlag", str2).FB("uploadTime", str3).dC(vw2.Vw, str).Vw("appID", str);
        yn ynVar = (yn) fb2.yn(yn.class);
        return ynVar != null && ynVar.Vw();
    }
}
