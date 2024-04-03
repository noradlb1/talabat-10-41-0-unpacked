package com.talabat.sdsquad.data.restaurantsearch;

import com.talabat.sdsquad.data.restaurantsearch.requests.ResturantSearchRequest;
import com.talabat.sdsquad.data.restaurantsearch.responses.RestaurantsSearchResponse;
import com.talabat.sdsquad.data.vendorslist.VendorsApi;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/sdsquad/data/restaurantsearch/RestaurantSearchRepositoryImp;", "Lcom/talabat/sdsquad/data/restaurantsearch/RestaurantSearchRepository;", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;)V", "getVendorsResults", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "countryId", "", "requestModel", "Lcom/talabat/sdsquad/data/restaurantsearch/requests/ResturantSearchRequest;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantSearchRepositoryImp implements RestaurantSearchRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static RestaurantSearchRepositoryImp INSTANCE;
    @NotNull
    private final VendorsApi vendorsApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/data/restaurantsearch/RestaurantSearchRepositoryImp$Companion;", "", "()V", "INSTANCE", "Lcom/talabat/sdsquad/data/restaurantsearch/RestaurantSearchRepositoryImp;", "destroyInstance", "", "getInstance", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void destroyInstance() {
            RestaurantSearchRepositoryImp.INSTANCE = null;
        }

        @JvmStatic
        @NotNull
        public final RestaurantSearchRepositoryImp getInstance(@NotNull VendorsApi vendorsApi) {
            RestaurantSearchRepositoryImp access$getINSTANCE$cp;
            Intrinsics.checkNotNullParameter(vendorsApi, "vendorsApi");
            RestaurantSearchRepositoryImp access$getINSTANCE$cp2 = RestaurantSearchRepositoryImp.INSTANCE;
            if (access$getINSTANCE$cp2 != null) {
                return access$getINSTANCE$cp2;
            }
            synchronized (RestaurantSearchRepositoryImp.class) {
                access$getINSTANCE$cp = RestaurantSearchRepositoryImp.INSTANCE;
                if (access$getINSTANCE$cp == null) {
                    access$getINSTANCE$cp = new RestaurantSearchRepositoryImp(vendorsApi, (DefaultConstructorMarker) null);
                    RestaurantSearchRepositoryImp.INSTANCE = access$getINSTANCE$cp;
                }
            }
            return access$getINSTANCE$cp;
        }
    }

    private RestaurantSearchRepositoryImp(VendorsApi vendorsApi2) {
        this.vendorsApi = vendorsApi2;
    }

    public /* synthetic */ RestaurantSearchRepositoryImp(VendorsApi vendorsApi2, DefaultConstructorMarker defaultConstructorMarker) {
        this(vendorsApi2);
    }

    @JvmStatic
    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    @JvmStatic
    @NotNull
    public static final RestaurantSearchRepositoryImp getInstance(@NotNull VendorsApi vendorsApi2) {
        return Companion.getInstance(vendorsApi2);
    }

    @NotNull
    public Flowable<List<RestaurantsSearchResponse>> getVendorsResults(int i11, @NotNull ResturantSearchRequest resturantSearchRequest) {
        Intrinsics.checkNotNullParameter(resturantSearchRequest, "requestModel");
        return this.vendorsApi.restaurantsSearch(i11, resturantSearchRequest);
    }
}
