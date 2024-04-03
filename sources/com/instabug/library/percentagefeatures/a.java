package com.instabug.library.percentagefeatures;

import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.k;

public abstract class a {
    public static void a(String str, double d11) {
        boolean z11;
        if (str != null && SettingsManager.getInstance() != null) {
            b percentageFeature = SettingsManager.getInstance().getPercentageFeature(str);
            if (percentageFeature.a() != d11) {
                if (percentageFeature.a() == 0.0d || percentageFeature.b() == 0.0d) {
                    percentageFeature.b(k.a(1.0d));
                }
                percentageFeature.a(d11);
                if (percentageFeature.b() < d11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (SettingsManager.getInstance() != null) {
                    SettingsManager.getInstance().savePercentageFeature(str, percentageFeature);
                    SettingsManager.getInstance().setFeatureEnabled(str, z11);
                }
            }
        }
    }
}
