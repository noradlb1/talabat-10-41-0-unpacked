package com.deliveryhero.chatsdk.network.websocket.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0014\b\u0003\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/ConfigData;", "", "name", "", "data", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfigData {
    @NotNull
    private final Map<String, String> data;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f29390name;

    public ConfigData(@NotNull @Json(name = "name") String str, @NotNull @Json(name = "data") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "data");
        this.f29390name = str;
        this.data = map;
    }

    public static /* synthetic */ ConfigData copy$default(ConfigData configData, String str, Map<String, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = configData.f29390name;
        }
        if ((i11 & 2) != 0) {
            map = configData.data;
        }
        return configData.copy(str, map);
    }

    @NotNull
    public final String component1() {
        return this.f29390name;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.data;
    }

    @NotNull
    public final ConfigData copy(@NotNull @Json(name = "name") String str, @NotNull @Json(name = "data") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "data");
        return new ConfigData(str, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigData)) {
            return false;
        }
        ConfigData configData = (ConfigData) obj;
        return Intrinsics.areEqual((Object) this.f29390name, (Object) configData.f29390name) && Intrinsics.areEqual((Object) this.data, (Object) configData.data);
    }

    @NotNull
    public final Map<String, String> getData() {
        return this.data;
    }

    @NotNull
    public final String getName() {
        return this.f29390name;
    }

    public int hashCode() {
        return (this.f29390name.hashCode() * 31) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConfigData(name=" + this.f29390name + ", data=" + this.data + ')';
    }
}
