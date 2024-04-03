package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.b;

public class c implements DynamicModule.VersionPolicy {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48794a = "c";

    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        DynamicModule.LoadingException loadingException;
        Bundle bundle;
        try {
            bundle = DynamicModule.getRemoteModuleInfo(context, str);
            loadingException = null;
        } catch (DynamicModule.LoadingException e11) {
            loadingException = e11.getBundle() != null ? new DynamicModule.LoadingException(e11.getMessage(), e11.getBundle()) : new DynamicModule.LoadingException(e11.getMessage());
            String str2 = f48794a;
            Logger.w(str2, "Get remote module info failed: " + e11.getMessage() + ". try to query local.");
            bundle = new Bundle();
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str3 = f48794a;
        Logger.i(str3, "The version of remote module " + str + CertificateUtil.DELIMITER + bundle.getInt(b.f48768k));
        Logger.i(str3, "The version of local module " + str + CertificateUtil.DELIMITER + localModuleInfo.getInt(b.f48769l));
        if (localModuleInfo.getInt(b.f48769l) > 0 && localModuleInfo.getInt(b.f48769l) >= bundle.getInt(b.f48768k)) {
            Logger.i(str3, "Choose local module info.");
            return localModuleInfo;
        } else if (loadingException == null || bundle.getInt(b.f48768k) != 0) {
            Logger.i(str3, "Choose remote module info.");
            return bundle;
        } else {
            throw loadingException;
        }
    }
}
