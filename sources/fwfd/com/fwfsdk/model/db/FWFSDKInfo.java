package fwfd.com.fwfsdk.model.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

@Entity(primaryKeys = {"sdkVersion"}, tableName = "FWFSDKInfo")
public class FWFSDKInfo {
    @NonNull
    private String sdkVersion;
    private Integer versionNumber;

    public FWFSDKInfo(@NotNull String str, Integer num) {
        this.sdkVersion = str;
        this.versionNumber = num;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public Integer getVersionNumber() {
        return this.versionNumber;
    }

    public String toString() {
        return "FWFSDKInfo{sdkVersion='" + this.sdkVersion + '\'' + ", versionNumber=" + this.versionNumber + AbstractJsonLexerKt.END_OBJ;
    }
}
