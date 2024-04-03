package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.b;

public class e implements DynamicModule.VersionPolicy {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48796a = "e";

    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        if (remoteModuleInfo.getInt(b.f48768k) > 0) {
            String str2 = f48796a;
            Logger.i(str2, "Prefer remote: The version of remote module " + str + CertificateUtil.DELIMITER + remoteModuleInfo.getInt(b.f48768k));
            return remoteModuleInfo;
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        if (localModuleInfo.getInt(b.f48769l) > 0) {
            String str3 = f48796a;
            Logger.i(str3, "Choose local: The version of local module " + str + CertificateUtil.DELIMITER + localModuleInfo.getInt(b.f48769l));
            return localModuleInfo;
        }
        Logger.i(f48796a, "Cannot get module info in remote or local.");
        return new Bundle();
    }
}
