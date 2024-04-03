package com.instabug.library.model.session;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Keep
public class SessionsBatchDTO {
    @NonNull
    private final Map<String, Object> commonKeys;
    @Nullable
    private String productionUsage;
    @NonNull
    private final List<SessionRemoteEntity> sessions;

    public SessionsBatchDTO(@NonNull Map<String, Object> map, @NonNull List<SessionRemoteEntity> list) {
        this.commonKeys = map;
        this.sessions = list;
    }

    @NonNull
    public Map<String, Object> getCommonKeys() {
        return Collections.unmodifiableMap(this.commonKeys);
    }

    @Nullable
    public String getProductionUsage() {
        return this.productionUsage;
    }

    @NonNull
    public List<SessionRemoteEntity> getSessions() {
        return Collections.unmodifiableList(this.sessions);
    }

    public void setProductionUsage(@Nullable String str) {
        this.productionUsage = str;
    }
}
