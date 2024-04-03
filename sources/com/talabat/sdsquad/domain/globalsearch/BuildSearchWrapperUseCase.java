package com.talabat.sdsquad.domain.globalsearch;

import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.restaurantsearch.responses.Mitm;
import com.talabat.sdsquad.data.restaurantsearch.responses.RestaurantsSearchResponse;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.DishDisplayModel;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchCellType;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/talabat/sdsquad/domain/globalsearch/BuildSearchWrapperUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/globalsearch/BuildSearchWrapperUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchDisplayModel;", "requestValues", "a", "<init>", "()V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class BuildSearchWrapperUseCase extends UseCase<RequestValues, Flowable<List<? extends GlobalSearchDisplayModel>>> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/talabat/sdsquad/domain/globalsearch/BuildSearchWrapperUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "vendorsList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "resultList", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "(Ljava/util/List;Ljava/util/List;)V", "getResultList", "()Ljava/util/List;", "getVendorsList", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public Flowable<List<GlobalSearchDisplayModel>> executeUseCase(@Nullable RequestValues requestValues) {
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
            ArrayList arrayList = new ArrayList();
            ArrayList<RestaurantsSearchResponse> arrayList2 = new ArrayList<>();
            Iterator it = requestValues.getResultList().iterator();
            while (true) {
                boolean z11 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                List<Mitm> mitms = ((RestaurantsSearchResponse) next).getMitms();
                if (mitms != null) {
                    z11 = mitms.isEmpty();
                }
                if (z11) {
                    arrayList2.add(next);
                }
            }
            ArrayList<RestaurantsSearchResponse> arrayList3 = new ArrayList<>();
            Iterator it2 = requestValues.getResultList().iterator();
            while (true) {
                boolean z12 = false;
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                List<Mitm> mitms2 = ((RestaurantsSearchResponse) next2).getMitms();
                if (mitms2 != null) {
                    z12 = !mitms2.isEmpty();
                }
                if (z12) {
                    arrayList3.add(next2);
                }
            }
            ArrayList<VendorDisplayModel> arrayList4 = new ArrayList<>();
            for (RestaurantsSearchResponse restaurantsSearchResponse : arrayList2) {
                Iterator<VendorDisplayModel> it3 = requestValues.getVendorsList().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    VendorDisplayModel next3 = it3.next();
                    int id2 = next3.getId();
                    Integer rid = restaurantsSearchResponse.getRid();
                    if (rid != null && id2 == rid.intValue()) {
                        arrayList4.add(next3);
                        break;
                    }
                }
            }
            ArrayList<DishDisplayModel> arrayList5 = new ArrayList<>();
            for (RestaurantsSearchResponse restaurantsSearchResponse2 : arrayList3) {
                Iterator<VendorDisplayModel> it4 = requestValues.getVendorsList().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    VendorDisplayModel next4 = it4.next();
                    Integer rid2 = restaurantsSearchResponse2.getRid();
                    int id3 = next4.getId();
                    if (rid2 != null && rid2.intValue() == id3) {
                        List<Mitm> mitms3 = restaurantsSearchResponse2.getMitms();
                        if (mitms3 == null || (mitm4 = mitms3.get(0)) == null || (mid = mitm4.getMid()) == null) {
                            i11 = 0;
                        } else {
                            i11 = mid.intValue();
                        }
                        int intValue = restaurantsSearchResponse2.getRid().intValue();
                        String vendorName = next4.getVendorName();
                        List<Mitm> mitms4 = restaurantsSearchResponse2.getMitms();
                        if (mitms4 == null || (mitm3 = mitms4.get(0)) == null || (minEn = mitm3.getMinEn()) == null) {
                            str = "";
                        } else {
                            str = minEn;
                        }
                        List<Mitm> mitms5 = restaurantsSearchResponse2.getMitms();
                        if (mitms5 == null || (mitm2 = mitms5.get(0)) == null || (img = mitm2.getImg()) == null) {
                            str2 = "";
                        } else {
                            str2 = img;
                        }
                        Integer mitmcnt = restaurantsSearchResponse2.getMitmcnt();
                        if (mitmcnt != null) {
                            i12 = mitmcnt.intValue();
                        } else {
                            i12 = 0;
                        }
                        String baseUrl = next4.getBaseUrl();
                        List<Mitm> mitms6 = restaurantsSearchResponse2.getMitms();
                        if (mitms6 == null || (mitm = mitms6.get(0)) == null || (prc = mitm.getPrc()) == null) {
                            d11 = 0.0d;
                        } else {
                            d11 = prc.doubleValue();
                        }
                        arrayList5.add(new DishDisplayModel(i11, intValue, vendorName, str, str2, i12, baseUrl, d11, next4.isBusy(), next4.isClosed(), next4.isOpen(), next4.getDecimalCount()));
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(new GlobalSearchDisplayModel(GlobalSearchCellType.VendorHeader, (VendorDisplayModel) null, (DishDisplayModel) null, arrayList2.size()));
                for (VendorDisplayModel globalSearchDisplayModel : arrayList4) {
                    arrayList.add(new GlobalSearchDisplayModel(GlobalSearchCellType.Vendor, globalSearchDisplayModel, (DishDisplayModel) null, 0));
                }
            }
            if (!arrayList3.isEmpty()) {
                arrayList.add(new GlobalSearchDisplayModel(GlobalSearchCellType.DishHeader, (VendorDisplayModel) null, (DishDisplayModel) null, arrayList3.size()));
                for (DishDisplayModel globalSearchDisplayModel2 : arrayList5) {
                    arrayList.add(new GlobalSearchDisplayModel(GlobalSearchCellType.Dish, (VendorDisplayModel) null, globalSearchDisplayModel2, 0));
                }
            }
            Flowable<List<GlobalSearchDisplayModel>> just = Flowable.just(arrayList);
            Intrinsics.checkNotNullExpressionValue(just, "just(wrapperList)");
            return just;
        }
        throw new RuntimeException("RequestValues can not be null");
    }
}
