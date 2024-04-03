package com.talabat.cuisines.navigation;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.talabat.cuisines.domain.EntitiesKt;
import datamodels.Cuisine;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"7\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"ALL", "", "ALL_CUISINES_SLUG", "", "cache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getCache", "()Ljava/util/HashMap;", "cache$delegate", "Lkotlin/Lazy;", "cuisinesStubs", "", "Ldatamodels/Cuisine;", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SampleCuisinesActivityKt {
    private static final int ALL = -100;
    @NotNull
    private static final String ALL_CUISINES_SLUG = "All Cuisine";
    @NotNull
    private static final Lazy cache$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, SampleCuisinesActivityKt$cache$2.INSTANCE);

    @NotNull
    public static final List<Cuisine> cuisinesStubs() {
        return CollectionsKt__CollectionsKt.listOf(EntitiesKt.Cuisine(1, "1", "1"), EntitiesKt.Cuisine(2, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_2D), EntitiesKt.Cuisine(3, ExifInterface.GPS_MEASUREMENT_3D, ExifInterface.GPS_MEASUREMENT_3D), EntitiesKt.Cuisine(4, OnlineLocationService.SRC_DEFAULT, OnlineLocationService.SRC_DEFAULT), EntitiesKt.Cuisine(5, "5", "5"));
    }

    /* access modifiers changed from: private */
    public static final HashMap<Object, Object> getCache() {
        return (HashMap) cache$delegate.getValue();
    }
}
