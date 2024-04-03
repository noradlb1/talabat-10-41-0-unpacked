package com.talabat.flutter.domain.vendorcollections;

import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"toFlutterMap", "", "", "", "Lcom/talabat/flutter/domain/vendorcollections/VendorCollection;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VendorCollectionKt {
    @NotNull
    public static final Map<String, Object> toFlutterMap(@NotNull VendorCollection vendorCollection) {
        Intrinsics.checkNotNullParameter(vendorCollection, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("id", Integer.valueOf(vendorCollection.getId())), TuplesKt.to("name", vendorCollection.getName()), TuplesKt.to(ObservableAttributesNames.IMAGE_URL_V2, vendorCollection.getImageUrl()), TuplesKt.to(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, vendorCollection.getBackgroundColor()));
    }
}
