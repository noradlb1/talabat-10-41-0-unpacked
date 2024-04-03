package com.talabat.restaurants.v2.domain.vendors;

import com.talabat.configuration.location.Area;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.GlobalConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/ShouldUsePolygonApiUseCase;", "Lkotlin/Function0;", "", "locationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "selectedAreaId", "", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;Lkotlin/jvm/functions/Function0;)V", "invoke", "()Ljava/lang/Boolean;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShouldUsePolygonApiUseCase implements Function0<Boolean> {
    @NotNull
    private final LocationConfigurationRepository locationRepository;
    @NotNull
    private final Function0<Integer> selectedAreaId;

    public ShouldUsePolygonApiUseCase(@NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationRepository");
        Intrinsics.checkNotNullParameter(function0, GlobalConstants.ExtraNames.SELECTED_AREA_ID);
        this.locationRepository = locationConfigurationRepository;
        this.selectedAreaId = function0;
    }

    @NotNull
    public Boolean invoke() {
        boolean z11;
        Object obj;
        boolean z12;
        int intValue = this.selectedAreaId.invoke().intValue();
        Iterator it = this.locationRepository.areas().iterator();
        while (true) {
            z11 = false;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (intValue == ((Area) obj).getId()) {
                z12 = true;
                continue;
            } else {
                z12 = false;
                continue;
            }
            if (z12) {
                break;
            }
        }
        Area area = (Area) obj;
        if (area != null) {
            z11 = area.isPolygonServiceEnabled();
        }
        return Boolean.valueOf(z11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShouldUsePolygonApiUseCase(LocationConfigurationRepository locationConfigurationRepository, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(locationConfigurationRepository, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
