package com.talabat.darkstores.di;

import android.content.Context;
import com.talabat.darkstores.data.darkstores.DarkstoresHeaderInterceptor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tracking.perseus.TalabatPerseus;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/darkstores/di/DarkstoresNetworkModule$provideDarkstoresHeaderInterceptor$1", "Lcom/talabat/darkstores/data/darkstores/DarkstoresHeaderInterceptor$PerseusHandler;", "getClientId", "", "getSessionId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresNetworkModule$provideDarkstoresHeaderInterceptor$1 implements DarkstoresHeaderInterceptor.PerseusHandler {
    @NotNull
    public String getClientId() {
        return TalabatPerseus.Companion.getMyClientId$default(TalabatPerseus.Companion, (Context) null, 1, (Object) null);
    }

    @NotNull
    public String getSessionId() {
        return TalabatPerseus.Companion.getMySessionId();
    }
}
