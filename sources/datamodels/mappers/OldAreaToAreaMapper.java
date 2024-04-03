package datamodels.mappers;

import com.talabat.mapper.CollectionModelMapper;
import dagger.Reusable;
import datamodels.Area;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¨\u0006\t"}, d2 = {"Ldatamodels/mappers/OldAreaToAreaMapper;", "Lcom/talabat/mapper/CollectionModelMapper;", "Ldatamodels/Area;", "Lcom/talabat/configuration/location/Area;", "()V", "apply", "source", "map", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class OldAreaToAreaMapper implements CollectionModelMapper<Area, com.talabat.configuration.location.Area> {
    @NotNull
    public Collection<com.talabat.configuration.location.Area> map(@NotNull Collection<Area> collection) {
        Intrinsics.checkNotNullParameter(collection, "source");
        Iterable<Area> iterable = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Area apply : iterable) {
            arrayList.add(apply(apply));
        }
        return CollectionsKt___CollectionsKt.toMutableList(arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.configuration.location.Area apply(@org.jetbrains.annotations.NotNull datamodels.Area r10) {
        /*
            r9 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r2 = r10.f13835id
            java.lang.String r3 = r10.areCenterPoint
            if (r3 == 0) goto L_0x004f
            java.lang.String r0 = ","
            java.lang.String[] r4 = new java.lang.String[]{r0}
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            java.util.List r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r3, (java.lang.String[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
            int r1 = r0.size()
            r3 = 2
            r4 = 1
            if (r1 != r3) goto L_0x0023
            r1 = r4
            goto L_0x0024
        L_0x0023:
            r1 = r5
        L_0x0024:
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x0044
            com.talabat.domain.location.GeoCoordinate r1 = new com.talabat.domain.location.GeoCoordinate
            java.lang.Object r3 = r0.get(r5)
            java.lang.String r3 = (java.lang.String) r3
            double r5 = java.lang.Double.parseDouble(r3)
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            double r3 = java.lang.Double.parseDouble(r0)
            r1.<init>(r5, r3)
            goto L_0x004a
        L_0x0044:
            com.talabat.domain.location.GeoCoordinate$Companion r0 = com.talabat.domain.location.GeoCoordinate.Companion
            com.talabat.domain.location.GeoCoordinate r1 = r0.getZERO()
        L_0x004a:
            if (r1 != 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r3 = r1
            goto L_0x0056
        L_0x004f:
            com.talabat.domain.location.GeoCoordinate$Companion r0 = com.talabat.domain.location.GeoCoordinate.Companion
            com.talabat.domain.location.GeoCoordinate r0 = r0.getZERO()
            r3 = r0
        L_0x0056:
            java.lang.String r0 = r10.areaName
            if (r0 != 0) goto L_0x005c
            java.lang.String r0 = ""
        L_0x005c:
            r4 = r0
            int r5 = r10.cityId
            boolean r6 = r10.isPolygonServiseEnabled
            com.talabat.configuration.location.Area r10 = new com.talabat.configuration.location.Area
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.mappers.OldAreaToAreaMapper.apply(datamodels.Area):com.talabat.configuration.location.Area");
    }
}
