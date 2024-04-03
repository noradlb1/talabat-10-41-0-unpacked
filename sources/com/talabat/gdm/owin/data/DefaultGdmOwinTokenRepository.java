package com.talabat.gdm.owin.data;

import com.talabat.gdm.owin.domain.GdmOwinTokenRepository;
import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/gdm/owin/data/DefaultGdmOwinTokenRepository;", "Lcom/talabat/gdm/owin/domain/GdmOwinTokenRepository;", "()V", "clearGdmToken", "", "isGdmOwinTokenAvailable", "", "com_talabat_core_gdm_owin-token_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultGdmOwinTokenRepository implements GdmOwinTokenRepository {
    public void clearGdmToken() {
        GlobalDataModel.token = null;
    }

    public boolean isGdmOwinTokenAvailable() {
        return GlobalDataModel.token != null;
    }
}
