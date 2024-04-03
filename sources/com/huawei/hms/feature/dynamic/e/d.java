package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.b;

public class d implements DynamicModule.VersionPolicy {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48795a = "d";

    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = f48795a;
        Logger.i(str2, "The version of remote module " + str + CertificateUtil.DELIMITER + remoteModuleInfo.getInt(b.f48768k));
        Logger.i(str2, "The version of local module " + str + CertificateUtil.DELIMITER + localModuleInfo.getInt(b.f48769l));
        if (remoteModuleInfo.getInt(b.f48768k) >= localModuleInfo.getInt(b.f48769l)) {
            Logger.i(str2, "Choose remote module info.");
            return remoteModuleInfo;
        }
        Logger.i(str2, "Choose local module info.");
        return localModuleInfo;
    }
}
