package com.talabat.collectiondetails.ui.quickfilter;

import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import JsonModels.Response.TermsResponse;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.collectiondetails.data.AbDataSource;
import com.talabat.collectiondetails.data.MenuDataSource;
import com.talabat.collectiondetails.data.RestaurantsDataSource;
import com.talabat.collectiondetails.data.TermsDataSource;
import com.talabat.helpers.AppUrls;
import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import datamodels.filters.SelectablePopularFilter;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wf.a0;
import wf.b0;
import wf.i;
import wf.j;
import wf.k;
import wf.l;
import wf.m;
import wf.n;
import wf.o;
import wf.p;
import wf.q;
import wf.r;
import wf.s;
import wf.t;
import wf.u;
import wf.v;
import wf.w;
import wf.x;
import wf.y;
import wf.z;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001Bµ\u0001\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010B\u001a\u00020=\u0012&\b\u0002\u0010D\u001a \u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\u0018\u0012 \b\u0002\u0010H\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0018\u0012(\b\u0002\u0010J\u001a\"\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t0\u0018¢\u0006\u0004\bh\u0010iJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J.\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tH\u0002J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0002J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J(\u0010\u0019\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00060\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J0\u0010!\u001a\u00020\u00062\u0010\u0010 \u001a\f\u0012\u0004\u0012\u00020\u001e0\tj\u0002`\u001f2\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00060\u0018H\u0016J\u001e\u0010\"\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00060\u0018H\u0016J\u001e\u0010#\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00060\u0018H\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010'\u001a\u00020&8\u0004X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020+8\u0004X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00101\u001a\u0002008\u0004X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u00106\u001a\u0002058\u0004X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010\u0017\u001a\u00020\u00168\u0004X\u0004¢\u0006\f\n\u0004\b\u0017\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020=8\u0004X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020=8\u0004X\u0004¢\u0006\f\n\u0004\bB\u0010?\u001a\u0004\bC\u0010AR8\u0010D\u001a \u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\u00188\u0004X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR2\u0010H\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00188\u0004X\u0004¢\u0006\f\n\u0004\bH\u0010E\u001a\u0004\bI\u0010GR:\u0010J\u001a\"\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t0\u00188\u0004X\u0004¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010GR,\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001a\u0004\u0018\u00010\u00108\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010X\u001a\u00020W8\u0004X\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8VX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020\\8VX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010^R\u0016\u0010b\u001a\u0004\u0018\u00010\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001e\u0010d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\bc\u0010NR\u0016\u0010f\u001a\u0004\u0018\u00010\u00108VX\u0004¢\u0006\u0006\u001a\u0004\be\u0010TR\u0014\u0010g\u001a\u00020\\8VX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010^¨\u0006j"}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsInteractor;", "Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsInteractor;", "", "terms", "Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsListener;", "listener", "", "termsResponseSuccess", "termsResponseFailed", "", "Ldatamodels/Restaurant;", "restaurantsList", "Ldatamodels/Filter;", "allFilters", "getFilters", "restaurants", "Ldatamodels/RestaurantListModel;", "makeModel", "", "collectionId", "getTerms", "getDarkStoresInfo", "Ldatamodels/QuickFilter;", "quickFilter", "Lkotlin/Function1;", "getRestaurantsForCollection", "handleSearchClick", "unregister", "clearEngineData", "updateCuisines", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "selectablePopularFilters", "handleFilterSelection", "handleCuisineSelection", "handleFilterCancel", "restaurant", "updateSelectedRestaurant", "Lcom/talabat/collectiondetails/data/TermsDataSource;", "termsDataSource", "Lcom/talabat/collectiondetails/data/TermsDataSource;", "getTermsDataSource", "()Lcom/talabat/collectiondetails/data/TermsDataSource;", "Lcom/talabat/collectiondetails/data/RestaurantsDataSource;", "restaurantsDatasource", "Lcom/talabat/collectiondetails/data/RestaurantsDataSource;", "x", "()Lcom/talabat/collectiondetails/data/RestaurantsDataSource;", "Lcom/talabat/collectiondetails/data/AbDataSource;", "abDatasource", "Lcom/talabat/collectiondetails/data/AbDataSource;", "getAbDatasource", "()Lcom/talabat/collectiondetails/data/AbDataSource;", "Lcom/talabat/collectiondetails/data/MenuDataSource;", "menuDataSource", "Lcom/talabat/collectiondetails/data/MenuDataSource;", "getMenuDataSource", "()Lcom/talabat/collectiondetails/data/MenuDataSource;", "Ldatamodels/QuickFilter;", "getQuickFilter", "()Ldatamodels/QuickFilter;", "Lio/reactivex/Scheduler;", "io", "Lio/reactivex/Scheduler;", "v", "()Lio/reactivex/Scheduler;", "main", "w", "filterRestaurants", "Lkotlin/jvm/functions/Function1;", "getFilterRestaurants", "()Lkotlin/jvm/functions/Function1;", "updateSponsoredSlots", "getUpdateSponsoredSlots", "sortRestaurants", "getSortRestaurants", "Ljava/util/List;", "getRestaurants", "()Ljava/util/List;", "z", "(Ljava/util/List;)V", "restaurantListModel", "Ldatamodels/RestaurantListModel;", "getRestaurantListModel", "()Ldatamodels/RestaurantListModel;", "y", "(Ldatamodels/RestaurantListModel;)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "u", "()Lio/reactivex/disposables/CompositeDisposable;", "", "isFromMenuToList", "()Z", "isNewListingSearch", "getSelectedCuisineId", "()Ljava/lang/Integer;", "selectedCuisineId", "getAllCollectionRestaurants", "allCollectionRestaurants", "getRestaurantsModel", "restaurantsModel", "isComingFromMenu", "<init>", "(Lcom/talabat/collectiondetails/data/TermsDataSource;Lcom/talabat/collectiondetails/data/RestaurantsDataSource;Lcom/talabat/collectiondetails/data/AbDataSource;Lcom/talabat/collectiondetails/data/MenuDataSource;Ldatamodels/QuickFilter;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0})
public class QuickFilterRestaurantsInteractor implements IQuickFilterRestaurantsInteractor {
    @NotNull
    private final AbDataSource abDatasource;
    @NotNull
    private final CompositeDisposable compositeDisposable;
    @NotNull
    private final Function1<List<? extends Restaurant>, List<Restaurant>> filterRestaurants;
    @NotNull

    /* renamed from: io  reason: collision with root package name */
    private final Scheduler f55667io;
    @NotNull
    private final Scheduler main;
    @NotNull
    private final MenuDataSource menuDataSource;
    @NotNull
    private final QuickFilter quickFilter;
    @Nullable
    private RestaurantListModel restaurantListModel;
    @Nullable
    private List<? extends Restaurant> restaurants;
    @NotNull
    private final RestaurantsDataSource restaurantsDatasource;
    @NotNull
    private final Function1<List<? extends Restaurant>, List<Restaurant>> sortRestaurants;
    @NotNull
    private final TermsDataSource termsDataSource;
    @NotNull
    private final Function1<List<? extends Restaurant>, List<Restaurant>> updateSponsoredSlots;

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public QuickFilterRestaurantsInteractor(@org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.TermsDataSource r15, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.RestaurantsDataSource r16, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.AbDataSource r17, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.MenuDataSource r18, @org.jetbrains.annotations.NotNull datamodels.QuickFilter r19, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r20, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r21) {
        /*
            r14 = this;
            java.lang.String r0 = "termsDataSource"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "restaurantsDatasource"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "abDatasource"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "menuDataSource"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "quickFilter"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "io"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "main"
            r8 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 896(0x380, float:1.256E-42)
            r13 = 0
            r1 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor.<init>(com.talabat.collectiondetails.data.TermsDataSource, com.talabat.collectiondetails.data.RestaurantsDataSource, com.talabat.collectiondetails.data.AbDataSource, com.talabat.collectiondetails.data.MenuDataSource, datamodels.QuickFilter, io.reactivex.Scheduler, io.reactivex.Scheduler):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public QuickFilterRestaurantsInteractor(@org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.TermsDataSource r15, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.RestaurantsDataSource r16, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.AbDataSource r17, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.MenuDataSource r18, @org.jetbrains.annotations.NotNull datamodels.QuickFilter r19, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r20, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r21, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.List<? extends datamodels.Restaurant>, ? extends java.util.List<? extends datamodels.Restaurant>> r22) {
        /*
            r14 = this;
            java.lang.String r0 = "termsDataSource"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "restaurantsDatasource"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "abDatasource"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "menuDataSource"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "quickFilter"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "io"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "main"
            r8 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "filterRestaurants"
            r9 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r10 = 0
            r11 = 0
            r12 = 768(0x300, float:1.076E-42)
            r13 = 0
            r1 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor.<init>(com.talabat.collectiondetails.data.TermsDataSource, com.talabat.collectiondetails.data.RestaurantsDataSource, com.talabat.collectiondetails.data.AbDataSource, com.talabat.collectiondetails.data.MenuDataSource, datamodels.QuickFilter, io.reactivex.Scheduler, io.reactivex.Scheduler, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public QuickFilterRestaurantsInteractor(@org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.TermsDataSource r15, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.RestaurantsDataSource r16, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.AbDataSource r17, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.MenuDataSource r18, @org.jetbrains.annotations.NotNull datamodels.QuickFilter r19, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r20, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r21, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.List<? extends datamodels.Restaurant>, ? extends java.util.List<? extends datamodels.Restaurant>> r22, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.List<? extends datamodels.Restaurant>, ? extends java.util.List<? extends datamodels.Restaurant>> r23) {
        /*
            r14 = this;
            java.lang.String r0 = "termsDataSource"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "restaurantsDatasource"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "abDatasource"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "menuDataSource"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "quickFilter"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "io"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "main"
            r8 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "filterRestaurants"
            r9 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "updateSponsoredSlots"
            r10 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r11 = 0
            r12 = 512(0x200, float:7.175E-43)
            r13 = 0
            r1 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor.<init>(com.talabat.collectiondetails.data.TermsDataSource, com.talabat.collectiondetails.data.RestaurantsDataSource, com.talabat.collectiondetails.data.AbDataSource, com.talabat.collectiondetails.data.MenuDataSource, datamodels.QuickFilter, io.reactivex.Scheduler, io.reactivex.Scheduler, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    @JvmOverloads
    public QuickFilterRestaurantsInteractor(@NotNull TermsDataSource termsDataSource2, @NotNull RestaurantsDataSource restaurantsDataSource, @NotNull AbDataSource abDataSource, @NotNull MenuDataSource menuDataSource2, @NotNull QuickFilter quickFilter2, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function1, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function12, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function13) {
        Intrinsics.checkNotNullParameter(termsDataSource2, "termsDataSource");
        Intrinsics.checkNotNullParameter(restaurantsDataSource, "restaurantsDatasource");
        Intrinsics.checkNotNullParameter(abDataSource, "abDatasource");
        Intrinsics.checkNotNullParameter(menuDataSource2, "menuDataSource");
        Intrinsics.checkNotNullParameter(quickFilter2, "quickFilter");
        Intrinsics.checkNotNullParameter(scheduler, "io");
        Intrinsics.checkNotNullParameter(scheduler2, "main");
        Intrinsics.checkNotNullParameter(function1, "filterRestaurants");
        Intrinsics.checkNotNullParameter(function12, "updateSponsoredSlots");
        Intrinsics.checkNotNullParameter(function13, "sortRestaurants");
        this.termsDataSource = termsDataSource2;
        this.restaurantsDatasource = restaurantsDataSource;
        this.abDatasource = abDataSource;
        this.menuDataSource = menuDataSource2;
        this.quickFilter = quickFilter2;
        this.f55667io = scheduler;
        this.main = scheduler2;
        this.filterRestaurants = function1;
        this.updateSponsoredSlots = function12;
        this.sortRestaurants = function13;
        this.compositeDisposable = new CompositeDisposable();
    }

    /* access modifiers changed from: private */
    /* renamed from: getDarkStoresInfo$lambda-3  reason: not valid java name */
    public static final Triple m9548getDarkStoresInfo$lambda3(Integer num, String str, String str2) {
        Intrinsics.checkNotNullParameter(num, "t1");
        Intrinsics.checkNotNullParameter(str, "t2");
        Intrinsics.checkNotNullParameter(str2, "t3");
        return new Triple(num, str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: getDarkStoresInfo$lambda-4  reason: not valid java name */
    public static final SingleSource m9549getDarkStoresInfo$lambda4(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, Triple triple) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        Intrinsics.checkNotNullParameter(triple, "src");
        TermsDataSource termsDataSource2 = quickFilterRestaurantsInteractor.termsDataSource;
        String str = AppUrls.DARKSTORES_URL;
        Intrinsics.checkNotNullExpressionValue(str, "DARKSTORES_URL");
        return termsDataSource2.getDarkstoresInfo(str, ((Number) triple.component1()).intValue(), (String) triple.component2(), (String) triple.component3());
    }

    /* access modifiers changed from: private */
    /* renamed from: getDarkStoresInfo$lambda-5  reason: not valid java name */
    public static final void m9550getDarkStoresInfo$lambda5(QuickFilterRestaurantsListener quickFilterRestaurantsListener, DarkStoresEntryPointResponse darkStoresEntryPointResponse) {
        Restaurant restaurant;
        if (darkStoresEntryPointResponse != null) {
            restaurant = darkStoresEntryPointResponse.getResult();
        } else {
            restaurant = null;
        }
        if (restaurant != null) {
            if (quickFilterRestaurantsListener != null) {
                quickFilterRestaurantsListener.onDarkStoresEntrySuccess(darkStoresEntryPointResponse.getResult());
            }
        } else if (quickFilterRestaurantsListener != null) {
            quickFilterRestaurantsListener.onDarkStoresEntryFailure();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getDarkStoresInfo$lambda-6  reason: not valid java name */
    public static final void m9551getDarkStoresInfo$lambda6(QuickFilterRestaurantsListener quickFilterRestaurantsListener, Throwable th2) {
        if (quickFilterRestaurantsListener != null) {
            quickFilterRestaurantsListener.onDarkStoresEntryFailure();
        }
    }

    private final List<Filter> getFilters(List<? extends Restaurant> list, List<? extends Filter> list2) {
        boolean z11;
        if (list2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list2) {
            Filter filter = (Filter) next;
            Iterator it = list.iterator();
            while (true) {
                z11 = false;
                if (it.hasNext()) {
                    ArrayList<Integer> filtersId = ((Restaurant) it.next()).getFiltersId();
                    if (filtersId != null && filtersId.contains(Integer.valueOf(filter.getId()))) {
                        z11 = true;
                        continue;
                    }
                    if (z11) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantsForCollection$lambda-10  reason: not valid java name */
    public static final void m9552getRestaurantsForCollection$lambda10(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, Function1 function1, Pair pair) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$listener");
        List<? extends Restaurant> invoke = quickFilterRestaurantsInteractor.updateSponsoredSlots.invoke(CollectionsKt___CollectionsKt.filterNotNull(quickFilterRestaurantsInteractor.filterRestaurants.invoke(pair.getFirst())));
        quickFilterRestaurantsInteractor.restaurants = invoke;
        quickFilterRestaurantsInteractor.restaurantsDatasource.updateGlobalDataCollectionRestaurants(invoke);
        quickFilterRestaurantsInteractor.restaurantsDatasource.updateGlobalDataCollectionFilters(quickFilterRestaurantsInteractor.getFilters((List) pair.component1(), (List) pair.component2()));
        RestaurantListModel restaurantListModel2 = new RestaurantListModel();
        restaurantListModel2.setIsCollection(true);
        restaurantListModel2.createNewRestautantList(invoke);
        quickFilterRestaurantsInteractor.restaurantListModel = restaurantListModel2;
        function1.invoke(restaurantListModel2);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantsForCollection$lambda-7  reason: not valid java name */
    public static final List m9553getRestaurantsForCollection$lambda7(Restaurant[] restaurantArr) {
        Intrinsics.checkNotNullParameter(restaurantArr, "it");
        return ArraysKt___ArraysKt.toList((T[]) restaurantArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantsForCollection$lambda-8  reason: not valid java name */
    public static final Pair m9554getRestaurantsForCollection$lambda8(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "r");
        Intrinsics.checkNotNullParameter(list2, "f");
        return new Pair(list, list2);
    }

    /* access modifiers changed from: private */
    /* renamed from: getTerms$lambda-0  reason: not valid java name */
    public static final SingleSource m9555getTerms$lambda0(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, int i11, Integer num) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        Intrinsics.checkNotNullParameter(num, "it");
        TermsDataSource termsDataSource2 = quickFilterRestaurantsInteractor.termsDataSource;
        String str = AppUrls.GET_TERMS_URL;
        Intrinsics.checkNotNullExpressionValue(str, "GET_TERMS_URL");
        return termsDataSource2.getTerms(str, i11, num.intValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: getTerms$lambda-1  reason: not valid java name */
    public static final void m9556getTerms$lambda1(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, QuickFilterRestaurantsListener quickFilterRestaurantsListener, TermsResponse termsResponse) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        if (termsResponse == null || termsResponse.getTerms() == null) {
            quickFilterRestaurantsInteractor.termsResponseFailed(quickFilterRestaurantsListener);
            return;
        }
        String terms = termsResponse.getTerms();
        Intrinsics.checkNotNullExpressionValue(terms, "termsResponse.terms");
        quickFilterRestaurantsInteractor.termsResponseSuccess(terms, quickFilterRestaurantsListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: getTerms$lambda-2  reason: not valid java name */
    public static final void m9557getTerms$lambda2(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, QuickFilterRestaurantsListener quickFilterRestaurantsListener, Throwable th2) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        quickFilterRestaurantsInteractor.termsResponseFailed(quickFilterRestaurantsListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleCuisineSelection$lambda-23  reason: not valid java name */
    public static final List m9558handleCuisineSelection$lambda23(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, List list) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return quickFilterRestaurantsInteractor.filterRestaurants.invoke(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleCuisineSelection$lambda-24  reason: not valid java name */
    public static final List m9559handleCuisineSelection$lambda24(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, List list) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return quickFilterRestaurantsInteractor.updateSponsoredSlots.invoke(CollectionsKt___CollectionsKt.filterNotNull(list));
    }

    /* access modifiers changed from: private */
    /* renamed from: handleCuisineSelection$lambda-25  reason: not valid java name */
    public static final List m9560handleCuisineSelection$lambda25(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, List list) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return quickFilterRestaurantsInteractor.sortRestaurants.invoke(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleCuisineSelection$lambda-26  reason: not valid java name */
    public static final void m9561handleCuisineSelection$lambda26(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function1, "$listener");
        RestaurantListModel restaurantListModel2 = new RestaurantListModel();
        restaurantListModel2.setIsCollection(true);
        restaurantListModel2.createNewRestautantList((ArrayList) list);
        function1.invoke(restaurantListModel2);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFilterSelection$lambda-14  reason: not valid java name */
    public static final List m9562handleFilterSelection$lambda14(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, List list) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return quickFilterRestaurantsInteractor.filterRestaurants.invoke(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFilterSelection$lambda-15  reason: not valid java name */
    public static final List m9563handleFilterSelection$lambda15(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return CollectionsKt___CollectionsKt.filterNotNull(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFilterSelection$lambda-19  reason: not valid java name */
    public static final List m9564handleFilterSelection$lambda19(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "$selectablePopularFilters");
        Intrinsics.checkNotNullParameter(list2, "restList");
        ArrayList arrayList = new ArrayList();
        for (Object next : list2) {
            Restaurant restaurant = (Restaurant) next;
            ArrayList arrayList2 = new ArrayList();
            for (Object next2 : list) {
                if (((SelectablePopularFilter) next2).isOn()) {
                    arrayList2.add(next2);
                }
            }
            boolean z11 = true;
            if (!arrayList2.isEmpty()) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((SelectablePopularFilter) it.next()).getFilter().getPredicate().invoke(restaurant).booleanValue()) {
                            z11 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFilterSelection$lambda-20  reason: not valid java name */
    public static final List m9565handleFilterSelection$lambda20(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, List list) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return quickFilterRestaurantsInteractor.updateSponsoredSlots.invoke(CollectionsKt___CollectionsKt.filterNotNull(list));
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFilterSelection$lambda-21  reason: not valid java name */
    public static final List m9566handleFilterSelection$lambda21(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, List list) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsInteractor, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return quickFilterRestaurantsInteractor.sortRestaurants.invoke(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFilterSelection$lambda-22  reason: not valid java name */
    public static final void m9567handleFilterSelection$lambda22(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function1, "$listener");
        RestaurantListModel restaurantListModel2 = new RestaurantListModel();
        restaurantListModel2.setIsCollection(true);
        restaurantListModel2.createNewRestautantList((ArrayList) list);
        function1.invoke(restaurantListModel2);
    }

    private final RestaurantListModel makeModel(List<? extends Restaurant> list) {
        RestaurantListModel restaurantListModel2 = new RestaurantListModel();
        restaurantListModel2.setIsCollection(true);
        if (list != null) {
            restaurantListModel2.createNewRestautantList((ArrayList) list);
            return restaurantListModel2;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<datamodels.Restaurant?>");
    }

    private final void termsResponseFailed(QuickFilterRestaurantsListener quickFilterRestaurantsListener) {
        if (quickFilterRestaurantsListener != null) {
            quickFilterRestaurantsListener.onResponseError();
        }
    }

    private final void termsResponseSuccess(String str, QuickFilterRestaurantsListener quickFilterRestaurantsListener) {
        if (quickFilterRestaurantsListener != null) {
            quickFilterRestaurantsListener.onResponseSuccess(str);
        }
    }

    public void clearEngineData() {
        this.restaurantsDatasource.clearCollectionCuisines();
        this.restaurantsDatasource.clearCollectionFilterEngine();
    }

    @Nullable
    public List<Restaurant> getAllCollectionRestaurants() {
        return this.restaurants;
    }

    public void getDarkStoresInfo(@Nullable QuickFilterRestaurantsListener quickFilterRestaurantsListener) {
        this.compositeDisposable.add(Single.zip(this.termsDataSource.getSelectedAreaId(), this.termsDataSource.getLatitude(), this.termsDataSource.getLongitude(), new j()).flatMap(new k(this)).subscribeOn(this.f55667io).observeOn(this.main).subscribe(new l(quickFilterRestaurantsListener), new m(quickFilterRestaurantsListener)));
    }

    public void getRestaurantsForCollection(@Nullable QuickFilter quickFilter2, @NotNull Function1<? super RestaurantListModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.compositeDisposable.add(this.restaurantsDatasource.getRestaurants().map(new n()).zipWith(this.restaurantsDatasource.getFilters(), new o()).subscribeOn(this.f55667io).observeOn(this.main).subscribe(new p(this, function1)));
    }

    @Nullable
    public RestaurantListModel getRestaurantsModel() {
        return this.restaurantListModel;
    }

    @Nullable
    public Integer getSelectedCuisineId() {
        Cuisine selectedCuisine = this.restaurantsDatasource.getSelectedCuisine();
        if (selectedCuisine != null) {
            return Integer.valueOf(selectedCuisine.f13848id);
        }
        return null;
    }

    public void getTerms(int i11, @Nullable QuickFilterRestaurantsListener quickFilterRestaurantsListener) {
        this.compositeDisposable.add(this.termsDataSource.getCountryId().flatMap(new q(this, i11)).subscribeOn(this.f55667io).observeOn(this.main).subscribe(new r(this, quickFilterRestaurantsListener), new s(this, quickFilterRestaurantsListener)));
    }

    public void handleCuisineSelection(@NotNull Function1<? super RestaurantListModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!this.restaurantsDatasource.hasCollectionFilterEngine()) {
            handleFilterCancel(function1);
        } else if (this.restaurantsDatasource.getSelectedCuisine() != null) {
            this.compositeDisposable.add(this.restaurantsDatasource.getFilteredRestaurantsForCuisine(this.restaurants).map(new y(this)).map(new z(this)).map(new a0(this)).subscribeOn(this.f55667io).observeOn(this.main).subscribe(new b0(function1)));
        }
    }

    public void handleFilterCancel(@NotNull Function1<? super RestaurantListModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        List<? extends Restaurant> list = this.restaurants;
        if (list != null) {
            function1.invoke(makeModel(list));
        }
    }

    public void handleFilterSelection(@NotNull List<SelectablePopularFilter> list, @NotNull Function1<? super RestaurantListModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "selectablePopularFilters");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.compositeDisposable.add(this.restaurantsDatasource.getFilteredRestaurants().subscribeOn(this.f55667io).observeOn(this.main).map(new i(this)).map(new t()).map(new u(list)).map(new v(this)).map(new w(this)).subscribe(new x(function1)));
    }

    public void handleSearchClick() {
        this.restaurantsDatasource.updateGlobalDataCollectionSearchRestaurants(this.restaurants);
    }

    public boolean isComingFromMenu() {
        return this.menuDataSource.isComingFromMenu();
    }

    public boolean isFromMenuToList() {
        return this.menuDataSource.isComingFromMenu();
    }

    public boolean isNewListingSearch() {
        return this.abDatasource.canShowNewListingSearch();
    }

    @NotNull
    public final CompositeDisposable u() {
        return this.compositeDisposable;
    }

    public void unregister() {
        this.compositeDisposable.dispose();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r0 == null) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateCuisines() {
        /*
            r4 = this;
            java.util.List<? extends datamodels.Restaurant> r0 = r4.restaurants
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.talabat.collectiondetails.data.RestaurantsDataSource r1 = r4.restaurantsDatasource
            r2 = 0
            if (r0 == 0) goto L_0x001b
            java.util.Collection r0 = (java.util.Collection) r0
            datamodels.Restaurant[] r3 = new datamodels.Restaurant[r2]
            java.lang.Object[] r0 = r0.toArray(r3)
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            datamodels.Restaurant[] r0 = (datamodels.Restaurant[]) r0
            if (r0 != 0) goto L_0x001d
        L_0x001b:
            datamodels.Restaurant[] r0 = new datamodels.Restaurant[r2]
        L_0x001d:
            java.util.List r0 = r1.getAllCuisines(r0)
            java.util.List r0 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r0)
            r1.updateCollectionCuisines(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor.updateCuisines():void");
    }

    public void updateSelectedRestaurant(@Nullable Restaurant restaurant) {
        this.restaurantsDatasource.updateSelectedRestaurant(restaurant);
    }

    @NotNull
    public final Scheduler v() {
        return this.f55667io;
    }

    @NotNull
    public final Scheduler w() {
        return this.main;
    }

    @NotNull
    public final RestaurantsDataSource x() {
        return this.restaurantsDatasource;
    }

    public final void y(@Nullable RestaurantListModel restaurantListModel2) {
        this.restaurantListModel = restaurantListModel2;
    }

    public final void z(@Nullable List<? extends Restaurant> list) {
        this.restaurants = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QuickFilterRestaurantsInteractor(com.talabat.collectiondetails.data.TermsDataSource r14, final com.talabat.collectiondetails.data.RestaurantsDataSource r15, com.talabat.collectiondetails.data.AbDataSource r16, com.talabat.collectiondetails.data.MenuDataSource r17, datamodels.QuickFilter r18, io.reactivex.Scheduler r19, io.reactivex.Scheduler r20, kotlin.jvm.functions.Function1 r21, kotlin.jvm.functions.Function1 r22, kotlin.jvm.functions.Function1 r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x000f
            com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor$1 r1 = new com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor$1
            r7 = r18
            r1.<init>(r7)
            r10 = r1
            goto L_0x0013
        L_0x000f:
            r7 = r18
            r10 = r21
        L_0x0013:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x001b
            com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor$2 r1 = com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor.AnonymousClass2.INSTANCE
            r11 = r1
            goto L_0x001d
        L_0x001b:
            r11 = r22
        L_0x001d:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0029
            com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor$3 r0 = new com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor$3
            r1 = r15
            r0.<init>(r15)
            r12 = r0
            goto L_0x002c
        L_0x0029:
            r1 = r15
            r12 = r23
        L_0x002c:
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor.<init>(com.talabat.collectiondetails.data.TermsDataSource, com.talabat.collectiondetails.data.RestaurantsDataSource, com.talabat.collectiondetails.data.AbDataSource, com.talabat.collectiondetails.data.MenuDataSource, datamodels.QuickFilter, io.reactivex.Scheduler, io.reactivex.Scheduler, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
