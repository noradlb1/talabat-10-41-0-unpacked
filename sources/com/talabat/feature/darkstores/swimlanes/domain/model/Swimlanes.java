package com.talabat.feature.darkstores.swimlanes.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/domain/model/Swimlanes;", "", "id", "", "name", "products", "", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesProduct;", "tracking", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesTracking;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesTracking;)V", "getId", "()Ljava/lang/String;", "getName", "getProducts", "()Ljava/util/List;", "getTracking", "()Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesTracking;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-swimlanes_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Swimlanes {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58411id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58412name;
    @NotNull
    private final List<SwimlanesProduct> products;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final SwimlanesTracking f58413tracking;

    public Swimlanes(@NotNull String str, @NotNull String str2, @NotNull List<SwimlanesProduct> list, @Nullable SwimlanesTracking swimlanesTracking) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list, "products");
        this.f58411id = str;
        this.f58412name = str2;
        this.products = list;
        this.f58413tracking = swimlanesTracking;
    }

    public static /* synthetic */ Swimlanes copy$default(Swimlanes swimlanes, String str, String str2, List<SwimlanesProduct> list, SwimlanesTracking swimlanesTracking, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swimlanes.f58411id;
        }
        if ((i11 & 2) != 0) {
            str2 = swimlanes.f58412name;
        }
        if ((i11 & 4) != 0) {
            list = swimlanes.products;
        }
        if ((i11 & 8) != 0) {
            swimlanesTracking = swimlanes.f58413tracking;
        }
        return swimlanes.copy(str, str2, list, swimlanesTracking);
    }

    @NotNull
    public final String component1() {
        return this.f58411id;
    }

    @NotNull
    public final String component2() {
        return this.f58412name;
    }

    @NotNull
    public final List<SwimlanesProduct> component3() {
        return this.products;
    }

    @Nullable
    public final SwimlanesTracking component4() {
        return this.f58413tracking;
    }

    @NotNull
    public final Swimlanes copy(@NotNull String str, @NotNull String str2, @NotNull List<SwimlanesProduct> list, @Nullable SwimlanesTracking swimlanesTracking) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list, "products");
        return new Swimlanes(str, str2, list, swimlanesTracking);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Swimlanes)) {
            return false;
        }
        Swimlanes swimlanes = (Swimlanes) obj;
        return Intrinsics.areEqual((Object) this.f58411id, (Object) swimlanes.f58411id) && Intrinsics.areEqual((Object) this.f58412name, (Object) swimlanes.f58412name) && Intrinsics.areEqual((Object) this.products, (Object) swimlanes.products) && Intrinsics.areEqual((Object) this.f58413tracking, (Object) swimlanes.f58413tracking);
    }

    @NotNull
    public final String getId() {
        return this.f58411id;
    }

    @NotNull
    public final String getName() {
        return this.f58412name;
    }

    @NotNull
    public final List<SwimlanesProduct> getProducts() {
        return this.products;
    }

    @Nullable
    public final SwimlanesTracking getTracking() {
        return this.f58413tracking;
    }

    public int hashCode() {
        int hashCode = ((((this.f58411id.hashCode() * 31) + this.f58412name.hashCode()) * 31) + this.products.hashCode()) * 31;
        SwimlanesTracking swimlanesTracking = this.f58413tracking;
        return hashCode + (swimlanesTracking == null ? 0 : swimlanesTracking.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.f58411id;
        String str2 = this.f58412name;
        List<SwimlanesProduct> list = this.products;
        SwimlanesTracking swimlanesTracking = this.f58413tracking;
        return "Swimlanes(id=" + str + ", name=" + str2 + ", products=" + list + ", tracking=" + swimlanesTracking + ")";
    }
}
