package com.talabat.configuration.areas.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/configuration/areas/model/Areas2Entity;", "", "result", "", "Lcom/talabat/configuration/areas/model/Area2;", "(Ljava/util/List;)V", "getResult", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Areas2Entity {
    @Nullable
    private final List<Area2> result;

    public Areas2Entity() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public Areas2Entity(@Nullable @Json(name = "result") List<Area2> list) {
        this.result = list;
    }

    public static /* synthetic */ Areas2Entity copy$default(Areas2Entity areas2Entity, List<Area2> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = areas2Entity.result;
        }
        return areas2Entity.copy(list);
    }

    @Nullable
    public final List<Area2> component1() {
        return this.result;
    }

    @NotNull
    public final Areas2Entity copy(@Nullable @Json(name = "result") List<Area2> list) {
        return new Areas2Entity(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Areas2Entity) && Intrinsics.areEqual((Object) this.result, (Object) ((Areas2Entity) obj).result);
    }

    @Nullable
    public final List<Area2> getResult() {
        return this.result;
    }

    public int hashCode() {
        List<Area2> list = this.result;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<Area2> list = this.result;
        return "Areas2Entity(result=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Areas2Entity(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }
}
