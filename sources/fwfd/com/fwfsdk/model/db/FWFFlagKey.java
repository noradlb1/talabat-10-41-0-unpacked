package fwfd.com.fwfsdk.model.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.model.api.FlagKey;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

@Entity(primaryKeys = {"key", "token"}, tableName = "FWFFlagKey")
public class FWFFlagKey {
    private Long date;
    private Boolean enabled;
    @NonNull
    private String key;
    private String kind;
    @NonNull
    private String token;

    public FWFFlagKey(@NotNull String str, @NotNull String str2, String str3, Boolean bool, Long l11) {
        this.key = str;
        this.token = str2;
        this.kind = str3;
        this.enabled = bool;
        this.date = l11;
    }

    public Long getDate() {
        return this.date;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    @NonNull
    public String getKey() {
        return this.key;
    }

    public String getKind() {
        return this.kind;
    }

    @NonNull
    public String getToken() {
        return this.token;
    }

    public Boolean isValid() {
        boolean z11;
        if (this.date.longValue() + TimeUnit.SECONDS.toMillis(FunWithFlags.getInstance().getFlagKeysExpirationTime().longValue()) > System.currentTimeMillis()) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    public FlagKey toFlagKey() {
        return new FlagKey(this.key, this.kind, this.enabled);
    }
}
