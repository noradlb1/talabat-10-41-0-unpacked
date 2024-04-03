package com.huawei.location.crowdsourcing.upload.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.location.crowdsourcing.upload.http.Vw;
import com.huawei.location.lite.common.log.LogConsole;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class FB extends Vw {
    private final SortedMap<String, String> E5 = new TreeMap();

    /* renamed from: d2  reason: collision with root package name */
    private String f50084d2 = "";

    /* renamed from: zp  reason: collision with root package name */
    private String f50085zp = "";

    public FB(@NonNull String str, @NonNull String str2) {
        super(Vw.yn.POST, str, str2);
        yn("Charset", "UTF-8").yn("Content-Type", "application/x-www-form-urlencoded").yn("Connection", "close");
    }

    public FB FB(@NonNull String str, @NonNull String str2) {
        return LW(Vw.f(str), Vw.f(str2));
    }

    public FB LW(@NonNull String str, @NonNull String str2) {
        if (!str.isEmpty() && !str2.isEmpty()) {
            this.E5.put(str, str2);
        }
        return this;
    }

    @Nullable
    public InputStream b() {
        return new ByteArrayInputStream(Vw.g(this.E5).getBytes(StandardCharsets.UTF_8));
    }

    public boolean d() {
        if (!super.d()) {
            return false;
        }
        String str = "";
        if (this.f50084d2.isEmpty()) {
            LogConsole.d("QueryRequest", "no need authorization");
        } else if (this.f50085zp.isEmpty()) {
            LogConsole.e("QueryRequest", "appId empty, can not gen authorization");
        } else {
            String yn2 = com.huawei.location.crowdsourcing.common.util.FB.yn(String.format(Locale.ENGLISH, "%s&%s&%s&%s&appID=%s", new Object[]{c(), a(), e(), Vw.g(this.E5), this.f50085zp}), this.f50084d2.getBytes(StandardCharsets.UTF_8));
            if (yn2 == null) {
                LogConsole.e("QueryRequest", "HMAC-SHA256 failed");
            } else {
                str = yn2;
            }
            str = MessageFormat.format("HMAC-SHA256 appID={0}, signature=\"{1}\"", new Object[]{this.f50085zp, str});
        }
        if (!str.isEmpty()) {
            yn("Authorization", str);
        }
        return true;
    }

    public FB dC(@NonNull String str, @NonNull String str2) {
        this.f50084d2 = str;
        this.f50085zp = str2;
        return this;
    }

    public FB yn(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            FB((String) next.getKey(), (String) next.getValue());
        }
        return this;
    }
}
