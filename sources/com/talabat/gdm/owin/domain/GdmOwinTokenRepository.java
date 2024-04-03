package com.talabat.gdm.owin.domain;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/gdm/owin/domain/GdmOwinTokenRepository;", "", "clearGdmToken", "", "isGdmOwinTokenAvailable", "", "com_talabat_core_gdm_owin-token_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GdmOwinTokenRepository {
    void clearGdmToken();

    boolean isGdmOwinTokenAvailable();
}
