package fwfd.com.fwfsdk.model.api;

import com.google.gson.annotations.SerializedName;
import fwfd.com.fwfsdk.model.db.FWFFlagKey;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class FlagKey {
    @SerializedName("enabled")
    private Boolean isEnabled;
    private String key;
    private String kind;

    public FlagKey() {
    }

    public String getKey() {
        return this.key;
    }

    public String getKind() {
        return this.kind;
    }

    public Boolean isEnabled() {
        return this.isEnabled;
    }

    public FWFFlagKey toFWFFlagKey(String str) {
        return new FWFFlagKey(this.key, str, this.kind, this.isEnabled, Long.valueOf(System.currentTimeMillis()));
    }

    public String toString() {
        return "FlagKey{key='" + this.key + '\'' + ", kind='" + this.kind + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    public FlagKey(String str, String str2, Boolean bool) {
        this.key = str;
        this.kind = str2;
        this.isEnabled = bool;
    }
}
