package com.deliveryhero.customerchat.analytics.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0003\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J-\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0018\b\u0003\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/model/Contact;", "", "id", "", "details", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getDetails", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Contact {
    @Nullable
    private final Map<String, String> details;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29799id;

    public Contact(@NotNull @Json(name = "id") String str, @Nullable @Json(name = "details") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f29799id = str;
        this.details = map;
    }

    public static /* synthetic */ Contact copy$default(Contact contact, String str, Map<String, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = contact.f29799id;
        }
        if ((i11 & 2) != 0) {
            map = contact.details;
        }
        return contact.copy(str, map);
    }

    @NotNull
    public final String component1() {
        return this.f29799id;
    }

    @Nullable
    public final Map<String, String> component2() {
        return this.details;
    }

    @NotNull
    public final Contact copy(@NotNull @Json(name = "id") String str, @Nullable @Json(name = "details") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new Contact(str, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) obj;
        return Intrinsics.areEqual((Object) this.f29799id, (Object) contact.f29799id) && Intrinsics.areEqual((Object) this.details, (Object) contact.details);
    }

    @Nullable
    public final Map<String, String> getDetails() {
        return this.details;
    }

    @NotNull
    public final String getId() {
        return this.f29799id;
    }

    public int hashCode() {
        int hashCode = this.f29799id.hashCode() * 31;
        Map<String, String> map = this.details;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    @NotNull
    public String toString() {
        return "Contact(id=" + this.f29799id + ", details=" + this.details + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Contact(String str, Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : map);
    }
}
