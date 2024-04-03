package com.talabat.sdsquad.domain.globalsearch;

import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.restaurantsearch.responses.Mitm;
import com.talabat.sdsquad.data.restaurantsearch.responses.RestaurantsSearchResponse;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.DishDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/talabat/sdsquad/domain/globalsearch/ItemsSuggestionsUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/globalsearch/ItemsSuggestionsUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;", "requestValues", "a", "<init>", "()V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class ItemsSuggestionsUseCase extends UseCase<RequestValues, Flowable<List<? extends DishDisplayModel>>> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/talabat/sdsquad/domain/globalsearch/ItemsSuggestionsUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "vendorsList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "resultList", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "(Ljava/util/List;Ljava/util/List;)V", "getResultList", "()Ljava/util/List;", "getVendorsList", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @NotNull
        private final List<RestaurantsSearchResponse> resultList;
        @NotNull
        private final List<VendorDisplayModel> vendorsList;

        public RequestValues(@NotNull List<VendorDisplayModel> list, @NotNull List<RestaurantsSearchResponse> list2) {
            Intrinsics.checkNotNullParameter(list, "vendorsList");
            Intrinsics.checkNotNullParameter(list2, "resultList");
            this.vendorsList = list;
            this.resultList = list2;
        }

        @NotNull
        public final List<RestaurantsSearchResponse> getResultList() {
            return this.resultList;
        }

        @NotNull
        public final List<VendorDisplayModel> getVendorsList() {
            return this.vendorsList;
        }
    }

    @NotNull
    /* renamed from: a */
    public Flowable<List<DishDisplayModel>> executeUseCase(@Nullable RequestValues requestValues) {
        int i11;
        String str;
        String str2;
        int i12;
        double d11;
        Mitm mitm;
        Double prc;
        Mitm mitm2;
        String img;
        Mitm mitm3;
        String minEn;
        Mitm mitm4;
        Integer mid;
        if (requestValues != null) {
            ArrayList<RestaurantsSearchResponse> arrayList = new ArrayList<>();
            Iterator it = requestValues.getResultList().iterator();
            while (true) {
                boolean z11 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                List<Mitm> mitms = ((RestaurantsSearchResponse) next).getMitms();
                if (mitms != null) {
                    z11 = !mitms.isEmpty();
                }
                if (z11) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (RestaurantsSearchResponse restaurantsSearchResponse : arrayList) {
                Iterator<VendorDisplayModel> it2 = requestValues.getVendorsList().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    VendorDisplayModel next2 = it2.next();
                    Integer rid = restaurantsSearchResponse.getRid();
                    int id2 = next2.getId();
                    if (rid != null && rid.intValue() == id2) {
                        List<Mitm> mitms2 = restaurantsSearchResponse.getMitms();
                        if (mitms2 == null || (mitm4 = mitms2.get(0)) == null || (mid = mitm4.getMid()) == null) {
                            i11 = 0;
                        } else {
                            i11 = mid.intValue();
                        }
                        int intValue = restaurantsSearchResponse.getRid().intValue();
                        String vendorName = next2.getVendorName();
                        List<Mitm> mitms3 = restaurantsSearchResponse.getMitms();
                        if (mitms3 == null || (mitm3 = mitms3.get(0)) == null || (minEn = mitm3.getMinEn()) == null) {
                            str = "";
                        } else {
                            str = minEn;
                        }
                        List<Mitm> mitms4 = restaurantsSearchResponse.getMitms();
                        if (mitms4 == null || (mitm2 = mitms4.get(0)) == null || (img = mitm2.getImg()) == null) {
                            str2 = "";
                        } else {
                            str2 = img;
                        }
                        Integer mitmcnt = restaurantsSearchResponse.getMitmcnt();
                        if (mitmcnt != null) {
                            i12 = mitmcnt.intValue();
                        } else {
                            i12 = 0;
                        }
                        String baseUrl = next2.getBaseUrl();
                        List<Mitm> mitms5 = restaurantsSearchResponse.getMitms();
                        if (mitms5 == null || (mitm = mitms5.get(0)) == null || (prc = mitm.getPrc()) == null) {
                            d11 = 0.0d;
                        } else {
                            d11 = prc.doubleValue();
                        }
                        arrayList2.add(new DishDisplayModel(i11, intValue, vendorName, str, str2, i12, baseUrl, d11, next2.isBusy(), next2.isClosed(), next2.isOpen(), next2.getDecimalCount()));
                    }
                }
            }
            Flowable<List<DishDisplayModel>> just = Flowable.just(arrayList2);
            Intrinsics.checkNotNullExpressionValue(just, "just(dishWrapperList)");
            return just;
        }
        throw new RuntimeException("RequestValues can not be null");
    }
}
