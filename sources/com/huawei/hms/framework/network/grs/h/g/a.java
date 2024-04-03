package com.huawei.hms.framework.network.grs.h.g;

import android.content.Context;
import android.content.res.AssetManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final HostnameVerifier f48947a = new StrictHostnameVerifier();

    public static HostnameVerifier a() {
        return f48947a;
    }

    public static SSLSocketFactory a(Context context) {
        try {
            AssetManager assets = context.getAssets();
            return new SecureSSLSocketFactoryNew(new SecureX509TrustManager(assets.open(GrsApp.getInstance().getBrand("/") + "grs_sp.bks"), ""));
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e11) {
            throw new AssertionError(e11);
        }
    }
}
