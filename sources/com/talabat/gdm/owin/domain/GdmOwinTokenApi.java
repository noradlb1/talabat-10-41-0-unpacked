package com.talabat.gdm.owin.domain;

import com.talabat.core.di.Api;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/gdm/owin/domain/GdmOwinTokenApi;", "Lcom/talabat/core/di/Api;", "gdmOwinTokenRepository", "Lcom/talabat/gdm/owin/domain/GdmOwinTokenRepository;", "getGdmOwinTokenRepository", "()Lcom/talabat/gdm/owin/domain/GdmOwinTokenRepository;", "com_talabat_core_gdm_owin-token_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GdmOwinTokenApi extends Api {
    @NotNull
    GdmOwinTokenRepository getGdmOwinTokenRepository();
}
