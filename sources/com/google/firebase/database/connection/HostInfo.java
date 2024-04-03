package com.google.firebase.database.connection;

import androidx.webkit.ProxyConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URI;

public class HostInfo {
    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    private final String host;
    private final String namespace;
    private final boolean secure;

    public HostInfo(String str, String str2, boolean z11) {
        this.host = str;
        this.namespace = str2;
        this.secure = z11;
    }

    public static URI getConnectionUrl(String str, boolean z11, String str2, String str3) {
        String str4;
        if (z11) {
            str4 = "wss";
        } else {
            str4 = "ws";
        }
        String str5 = str4 + "://" + str + "/.ws?ns=" + str2 + ContainerUtils.FIELD_DELIMITER + "v" + "=" + "5";
        if (str3 != null) {
            str5 = str5 + "&ls=" + str3;
        }
        return URI.create(str5);
    }

    public String getHost() {
        return this.host;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ProxyConfig.MATCH_HTTP);
        sb2.append(this.secure ? "s" : "");
        sb2.append("://");
        sb2.append(this.host);
        return sb2.toString();
    }
}
