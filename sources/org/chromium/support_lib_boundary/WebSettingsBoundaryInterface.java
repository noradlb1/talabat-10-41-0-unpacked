package org.chromium.support_lib_boundary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public interface WebSettingsBoundaryInterface {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDarkBehavior {
        public static final int FORCE_DARK_ONLY = 0;
        public static final int MEDIA_QUERY_ONLY = 1;
        public static final int PREFER_MEDIA_QUERY_OVER_FORCE_DARK = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WebAuthnSupport {
        public static final int APP = 1;
        public static final int BROWSER = 2;
        public static final int NONE = 0;
    }

    void enableRestrictSensitiveWebContent();

    int getDisabledActionModeMenuItems();

    boolean getEnterpriseAuthenticationAppLinkPolicyEnabled();

    int getForceDark();

    int getForceDarkBehavior();

    boolean getOffscreenPreRaster();

    Set<String> getRequestedWithHeaderOriginAllowList();

    boolean getSafeBrowsingEnabled();

    int getWebAuthnSupport();

    boolean getWillSuppressErrorPage();

    boolean isAlgorithmicDarkeningAllowed();

    void setAlgorithmicDarkeningAllowed(boolean z11);

    void setDisabledActionModeMenuItems(int i11);

    void setEnterpriseAuthenticationAppLinkPolicyEnabled(boolean z11);

    void setForceDark(int i11);

    void setForceDarkBehavior(int i11);

    void setOffscreenPreRaster(boolean z11);

    void setRequestedWithHeaderOriginAllowList(Set<String> set);

    void setSafeBrowsingEnabled(boolean z11);

    void setWebAuthnSupport(int i11);

    void setWillSuppressErrorPage(boolean z11);
}
