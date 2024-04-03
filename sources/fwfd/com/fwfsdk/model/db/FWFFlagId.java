package fwfd.com.fwfsdk.model.db;

import androidx.annotation.NonNull;
import fwfd.com.fwfsdk.FunWithFlags;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FWFFlagId {
    @NonNull
    private String accessToken;
    private Long date;
    @NonNull
    private String key;

    public FWFFlagId(String str, String str2, Long l11) {
        this.key = str;
        this.accessToken = str2;
        this.date = l11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FWFFlagId fWFFlagId = (FWFFlagId) obj;
        if (!this.key.equals(fWFFlagId.key) || !this.accessToken.equals(fWFFlagId.accessToken)) {
            return false;
        }
        return true;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long getDate() {
        return this.date;
    }

    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.accessToken});
    }

    public Boolean requiresUpdate() {
        boolean z11;
        if (TimeUnit.MILLISECONDS.toMinutes(Math.abs(Long.valueOf(System.currentTimeMillis()).longValue() - this.date.longValue())) > TimeUnit.SECONDS.toMinutes(FunWithFlags.getInstance().getFeatureExpirationTime().longValue())) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }
}
