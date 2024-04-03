package com.talabat.restaurants.v2.ui.viewmodels;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import buisnessmodels.FilterEngine;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListFeatureFlagsKeys;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.inlineads.IAdLoader;
import com.talabat.restaurants.v2.domain.vendors.ApplyVendorListFiltersUseCaseKt;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.wrapper.EventWrapper;
import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import datamodels.Swimlane;
import datamodels.filters.SelectablePopularFilter;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;
import tt.d;
import tt.e;
import tt.f;
import tt.g;
import tt.h;
import tt.i;
import tt.j;
import tt.k;
import tt.l;
import tt.m;
import tt.n;
import tt.o;
import tt.p;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B·\u0002\u0012\u0006\u0010/\u001a\u00020.\u0012\u001e\u00106\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070503\u0012>\b\u0002\u0010>\u001a8\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0007050<\u0012B\u0010E\u001a>\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0007050D\u0012\b\b\u0002\u0010L\u001a\u00020K\u0012\u0010\b\u0002\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P\u0012\u0006\u0010W\u001a\u00020V\u0012\u001c\b\u0002\u0010]\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020[\u0018\u00010\u0007j\u0004\u0018\u0001`\\0P\u0012\"\b\u0002\u0010_\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000703\u0012\b\b\u0002\u0010b\u001a\u00020a\u0012\b\b\u0002\u0010f\u001a\u00020a\u0012\u0006\u0010i\u001a\u00020h¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007H\u0002J\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0002J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J;\u0010\u001d\u001a\u001b\u0012\u0017\u0012\u0015\u0012\t\u0012\u00070\b¢\u0006\u0002\b\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b0\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ;\u0010\u001f\u001a\u001b\u0012\u0017\u0012\u0015\u0012\t\u0012\u00070\b¢\u0006\u0002\b\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b0\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ\b\u0010 \u001a\u00020\u0005H\u0016J0\u0010)\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001eH\u0016J \u0010-\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010,\u001a\u00020'H\u0016R\u001a\u0010/\u001a\u00020.8\u0004X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R:\u00106\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000705038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;RX\u0010>\u001a8\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0007050<8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR^\u0010E\u001a>\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0007050D8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010L\u001a\u00020K8\u0004X\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\"\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P8\u0004X\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001a\u0010W\u001a\u00020V8\u0004X\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR.\u0010]\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020[\u0018\u00010\u0007j\u0004\u0018\u0001`\\0P8\u0004X\u0004¢\u0006\f\n\u0004\b]\u0010S\u001a\u0004\b^\u0010UR4\u0010_\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007038\u0004X\u0004¢\u0006\f\n\u0004\b_\u00107\u001a\u0004\b`\u00109R\u001a\u0010b\u001a\u00020a8\u0004X\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001a\u0010f\u001a\u00020a8\u0004X\u0004¢\u0006\f\n\u0004\bf\u0010c\u001a\u0004\bg\u0010eR\u001a\u0010i\u001a\u00020h8\u0004X\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010t\u001a\u00020m8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bt\u0010o\u001a\u0004\bu\u0010q\"\u0004\bv\u0010sR!\u0010|\u001a\b\u0012\u0004\u0012\u00020=0w8VX\u0002¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R!\u0010\u001a\b\u0012\u0004\u0012\u00020=0w8VX\u0002¢\u0006\f\n\u0004\b}\u0010y\u001a\u0004\b~\u0010{R*\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070w8VX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010y\u001a\u0005\b\u0001\u0010{R=\u0010\u0001\u001a!\u0012\u001d\u0012\u001b\u0012\u0004\u0012\u00020%\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u00010\u001b0w8VX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010y\u001a\u0005\b\u0001\u0010{R0\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u001b0w8VX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010y\u001a\u0005\b\u0001\u0010{R/\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u001b0w8VX\u0002¢\u0006\r\n\u0005\b\u0001\u0010y\u001a\u0004\b>\u0010{R$\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050\u00010w8\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R-\u0010\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050\u00010\u00018\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R'\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u000e¢\u0006\u0017\n\u0005\b\u0004\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/talabat/restaurants/v2/ui/viewmodels/VendorsListFragmentViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "Lcom/talabat/restaurants/v2/ui/viewmodels/IVendorsListFragmentViewModel;", "", "verticalId", "", "showPharmacyPrescriptionCard", "", "Ldatamodels/RestaurantListItemModel;", "restaurantListItemModel", "loadInlineAds", "Llibrary/talabat/inlineadsengine/AdsWrapper;", "adsWrapper", "addAdListModel", "", "restaurantListItemModels", "generateHeader", "Ldatamodels/Restaurant;", "restaurants", "generateVendorsDisplayModels", "allRestaurantListItemModels", "updateWithVendorsSwimlanes", "updateWithFeatureProducts", "loadVendorList", "insertInlineAds", "Ldatamodels/Swimlane;", "swimlanes", "Lkotlin/Pair;", "Lorg/jetbrains/annotations/NotNull;", "getSwimlanePair", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "getFeatureProductsPairList", "onCleared", "Landroid/content/Context;", "context", "position", "listSize", "", "shopClickOrigin", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "featureProduct", "sendFeatureProductClickEvent", "featuredProducts", "sendFeatureProductsAppearedEvent", "featuredProduct", "sendFeatureProductImpressionEvent", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "Lkotlin/Function1;", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase$Params;", "Lio/reactivex/Single;", "getVendorsUseCase", "Lkotlin/jvm/functions/Function1;", "getGetVendorsUseCase", "()Lkotlin/jvm/functions/Function1;", "setGetVendorsUseCase", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function6;", "", "getVendorsSwimlanes", "Lkotlin/jvm/functions/Function6;", "getGetVendorsSwimlanes", "()Lkotlin/jvm/functions/Function6;", "setGetVendorsSwimlanes", "(Lkotlin/jvm/functions/Function6;)V", "Lkotlin/Function7;", "getDisplayFeatureProductsUseCase", "Lkotlin/jvm/functions/Function7;", "getGetDisplayFeatureProductsUseCase", "()Lkotlin/jvm/functions/Function7;", "setGetDisplayFeatureProductsUseCase", "(Lkotlin/jvm/functions/Function7;)V", "Lcom/talabat/restaurants/v2/ui/viewmodels/FeatureProductTracker;", "featureProductTracker", "Lcom/talabat/restaurants/v2/ui/viewmodels/FeatureProductTracker;", "getFeatureProductTracker", "()Lcom/talabat/restaurants/v2/ui/viewmodels/FeatureProductTracker;", "Lkotlin/Function0;", "Lbuisnessmodels/FilterEngine;", "getFilterEngine", "Lkotlin/jvm/functions/Function0;", "getGetFilterEngine", "()Lkotlin/jvm/functions/Function0;", "Lcom/talabat/restaurants/inlineads/IAdLoader;", "adLoader", "Lcom/talabat/restaurants/inlineads/IAdLoader;", "getAdLoader", "()Lcom/talabat/restaurants/inlineads/IAdLoader;", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "popularFilters", "getPopularFilters", "applyFiltersUseCase", "getApplyFiltersUseCase", "Lio/reactivex/Scheduler;", "ioScheduler", "Lio/reactivex/Scheduler;", "n", "()Lio/reactivex/Scheduler;", "mainScheduler", "o", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "Lio/reactivex/disposables/CompositeDisposable;", "mDisposables", "Lio/reactivex/disposables/CompositeDisposable;", "getMDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "setMDisposables", "(Lio/reactivex/disposables/CompositeDisposable;)V", "inlineAdDisposable", "getInlineAdDisposable", "setInlineAdDisposable", "Landroidx/lifecycle/MutableLiveData;", "showNoResult$delegate", "Lkotlin/Lazy;", "getShowNoResult", "()Landroidx/lifecycle/MutableLiveData;", "showNoResult", "loading$delegate", "getLoading", "loading", "vendorList$delegate", "getVendorList", "vendorList", "", "sendEvent$delegate", "getSendEvent", "sendEvent", "inlineAds$delegate", "getInlineAds", "inlineAds", "vendorsSwimlanes$delegate", "vendorsSwimlanes", "Lcom/talabat/wrapper/EventWrapper;", "_showPharmacyPrescription", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "showPharmacyPrescription", "Landroidx/lifecycle/LiveData;", "getShowPharmacyPrescription", "()Landroidx/lifecycle/LiveData;", "I", "getVerticalId", "()I", "setVerticalId", "(I)V", "<init>", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function7;Lcom/talabat/restaurants/v2/ui/viewmodels/FeatureProductTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/restaurants/inlineads/IAdLoader;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0})
public class VendorsListFragmentViewModel extends BaseViewModel implements IVendorsListFragmentViewModel {
    @NotNull
    private final MutableLiveData<EventWrapper<Unit>> _showPharmacyPrescription;
    @NotNull
    private final IAdLoader adLoader;
    @NotNull
    private final Function1<List<? extends Restaurant>, List<Restaurant>> applyFiltersUseCase;
    @NotNull
    private final FeatureProductTracker featureProductTracker;
    @NotNull
    private Function7<? super Boolean, ? super Integer, ? super String, ? super String, ? super Integer, ? super Integer, ? super Integer, ? extends Single<List<FeatureProductListDisplayModel>>> getDisplayFeatureProductsUseCase;
    @NotNull
    private final Function0<FilterEngine> getFilterEngine;
    @NotNull
    private Function6<? super Boolean, ? super String, ? super String, ? super Integer, ? super Integer, ? super Integer, ? extends Single<List<Swimlane>>> getVendorsSwimlanes;
    @NotNull
    private Function1<? super GetVendorsUseCase.Params, ? extends Single<List<Restaurant>>> getVendorsUseCase;
    @NotNull
    private CompositeDisposable inlineAdDisposable;
    @NotNull
    private final Lazy inlineAds$delegate;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final Lazy loading$delegate;
    @NotNull
    private CompositeDisposable mDisposables;
    @NotNull
    private final Scheduler mainScheduler;
    @NotNull
    private final Function0<List<SelectablePopularFilter>> popularFilters;
    @NotNull
    private final Lazy sendEvent$delegate;
    @NotNull
    private final Lazy showNoResult$delegate;
    @NotNull
    private final LiveData<EventWrapper<Unit>> showPharmacyPrescription;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final TalabatTracker talabatTracker;
    @NotNull
    private final Lazy vendorList$delegate;
    @NotNull
    private final Lazy vendorsSwimlanes$delegate;
    private int verticalId;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorsListFragmentViewModel(com.talabat.core.featureflag.domain.ITalabatFeatureFlag r18, kotlin.jvm.functions.Function1 r19, kotlin.jvm.functions.Function6 r20, kotlin.jvm.functions.Function7 r21, com.talabat.restaurants.v2.ui.viewmodels.FeatureProductTracker r22, kotlin.jvm.functions.Function0 r23, com.talabat.restaurants.inlineads.IAdLoader r24, kotlin.jvm.functions.Function0 r25, kotlin.jvm.functions.Function1 r26, io.reactivex.Scheduler r27, io.reactivex.Scheduler r28, com.talabat.core.tracking.domain.TalabatTracker r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r17 = this;
            r0 = r30
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0011
            com.talabat.restaurants.v2.domain.swimlane.GetVendorsSwimlanes r1 = new com.talabat.restaurants.v2.domain.swimlane.GetVendorsSwimlanes
            r3 = 2
            r5 = r18
            r1.<init>(r5, r2, r3, r2)
            r7 = r1
            goto L_0x0015
        L_0x0011:
            r5 = r18
            r7 = r20
        L_0x0015:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0021
            com.talabat.restaurants.v2.ui.viewmodels.FeatureProductTracker r1 = new com.talabat.restaurants.v2.ui.viewmodels.FeatureProductTracker
            r3 = 1
            r1.<init>(r2, r3, r2)
            r9 = r1
            goto L_0x0023
        L_0x0021:
            r9 = r22
        L_0x0023:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002b
            com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel$1 r1 = com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel.AnonymousClass1.INSTANCE
            r10 = r1
            goto L_0x002d
        L_0x002b:
            r10 = r23
        L_0x002d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0035
            com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel$2 r1 = com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel.AnonymousClass2.INSTANCE
            r12 = r1
            goto L_0x0037
        L_0x0035:
            r12 = r25
        L_0x0037:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0042
            com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel$3 r1 = new com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel$3
            r1.<init>(r10, r12)
            r13 = r1
            goto L_0x0044
        L_0x0042:
            r13 = r26
        L_0x0044:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0053
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r2 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r14 = r1
            goto L_0x0055
        L_0x0053:
            r14 = r27
        L_0x0055:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0064
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r1 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r15 = r0
            goto L_0x0066
        L_0x0064:
            r15 = r28
        L_0x0066:
            r4 = r17
            r5 = r18
            r6 = r19
            r8 = r21
            r11 = r24
            r16 = r29
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.ui.viewmodels.VendorsListFragmentViewModel.<init>(com.talabat.core.featureflag.domain.ITalabatFeatureFlag, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function6, kotlin.jvm.functions.Function7, com.talabat.restaurants.v2.ui.viewmodels.FeatureProductTracker, kotlin.jvm.functions.Function0, com.talabat.restaurants.inlineads.IAdLoader, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, io.reactivex.Scheduler, io.reactivex.Scheduler, com.talabat.core.tracking.domain.TalabatTracker, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final void addAdListModel(AdsWrapper adsWrapper, List<? extends RestaurantListItemModel> list) {
        Integer num;
        Object obj;
        Restaurant restaurant;
        boolean z11;
        Object obj2;
        int i11;
        boolean z12;
        boolean z13;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z14 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((RestaurantListItemModel) next).type != 2) {
                z14 = false;
            }
            if (z14) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            num = null;
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((RestaurantListItemModel) obj).restaurant.f13872id == adsWrapper.getVendorId()) {
                z13 = true;
                continue;
            } else {
                z13 = false;
                continue;
            }
            if (z13) {
                break;
            }
        }
        RestaurantListItemModel restaurantListItemModel = (RestaurantListItemModel) obj;
        if (restaurantListItemModel != null) {
            restaurant = restaurantListItemModel.restaurant;
        } else {
            restaurant = null;
        }
        if (restaurant != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            adsWrapper.setRestaurant(restaurant);
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    obj2 = null;
                    break;
                }
                obj2 = listIterator.previous();
                Restaurant restaurant2 = ((RestaurantListItemModel) obj2).restaurant;
                if (restaurant2 != null) {
                    i11 = restaurant2.itemPosition;
                } else {
                    i11 = 0;
                }
                if (i11 == adsWrapper.getAdsPosition()) {
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
            RestaurantListItemModel restaurantListItemModel2 = (RestaurantListItemModel) obj2;
            if (restaurantListItemModel2 != null) {
                num = Integer.valueOf(list.lastIndexOf(restaurantListItemModel2));
            }
            if (num != null) {
                int intValue = num.intValue();
                MutableLiveData<Pair<RestaurantListItemModel, Integer>> inlineAds = getInlineAds();
                RestaurantListItemModel fromAd = RestaurantListItemModel.fromAd(adsWrapper);
                Intrinsics.checkNotNullExpressionValue(fromAd, "fromAd(adsWrapper)");
                inlineAds.setValue(new Pair(fromAd, Integer.valueOf(intValue + 1)));
            }
        }
    }

    private final List<RestaurantListItemModel> generateHeader(List<RestaurantListItemModel> list, int i11) {
        boolean z11;
        int i12 = 1;
        if (!list.isEmpty()) {
            if (!TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_FLUTTER_VL_COLLECTION, false, TalabatExperimentDataSourceStrategy.APPTIMIZE) || i11 != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                RestaurantListItemModel fromFlutterCollections = RestaurantListItemModel.fromFlutterCollections();
                Intrinsics.checkNotNullExpressionValue(fromFlutterCollections, "fromFlutterCollections()");
                list.add(0, fromFlutterCollections);
            } else {
                i12 = 0;
            }
            RestaurantListItemModel fromHeader = RestaurantListItemModel.fromHeader();
            Intrinsics.checkNotNullExpressionValue(fromHeader, "fromHeader()");
            list.add(i12, fromHeader);
        }
        return list;
    }

    /* access modifiers changed from: private */
    public final List<RestaurantListItemModel> generateVendorsDisplayModels(List<? extends Restaurant> list) {
        Iterable<Restaurant> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Restaurant restaurant : iterable) {
            restaurant.itemPosition = list.indexOf(restaurant) + 1;
            arrayList.add(RestaurantListItemModel.fromVendor(restaurant));
        }
        return CollectionsKt___CollectionsKt.toMutableList(arrayList);
    }

    private final void loadInlineAds(List<? extends RestaurantListItemModel> list) {
        Disposable subscribe = this.adLoader.loadAds(getVerticalId(), GlobalDataModel.SelectedCountryId, String.valueOf(GlobalDataModel.SelectedAreaId)).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new f(this, list), new g());
        Intrinsics.checkNotNullExpressionValue(subscribe, "adLoader.loadAds(vertica… }, { logException(it) })");
        this.mDisposables.add(subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadInlineAds$lambda-5  reason: not valid java name */
    public static final void m10761loadInlineAds$lambda5(VendorsListFragmentViewModel vendorsListFragmentViewModel, List list, List list2) {
        Intrinsics.checkNotNullParameter(vendorsListFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "$restaurantListItemModel");
        Intrinsics.checkNotNullExpressionValue(list2, "adsList");
        Iterable<AdsWrapper> iterable = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (AdsWrapper addAdListModel : iterable) {
            vendorsListFragmentViewModel.addAdListModel(addAdListModel, list);
            arrayList.add(Unit.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadInlineAds$lambda-6  reason: not valid java name */
    public static final void m10762loadInlineAds$lambda6(Throwable th2) {
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LogManager.logException(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadVendorList$lambda-0  reason: not valid java name */
    public static final List m10763loadVendorList$lambda0(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (List) function1.invoke(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadVendorList$lambda-1  reason: not valid java name */
    public static final List m10764loadVendorList$lambda1(VendorsListFragmentViewModel vendorsListFragmentViewModel, int i11, List list) {
        Intrinsics.checkNotNullParameter(vendorsListFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return vendorsListFragmentViewModel.generateHeader(list, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadVendorList$lambda-2  reason: not valid java name */
    public static final void m10765loadVendorList$lambda2(VendorsListFragmentViewModel vendorsListFragmentViewModel, int i11, List list) {
        Intrinsics.checkNotNullParameter(vendorsListFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "restaurantListItemModels");
        if (!list.isEmpty()) {
            vendorsListFragmentViewModel.getVendorList().setValue(list);
            vendorsListFragmentViewModel.getShowNoResult().setValue(Boolean.FALSE);
            if (!ApplyVendorListFiltersUseCaseKt.isAnyFilterApplied(vendorsListFragmentViewModel.getFilterEngine.invoke(), vendorsListFragmentViewModel.popularFilters.invoke())) {
                vendorsListFragmentViewModel.updateWithVendorsSwimlanes(i11, list);
                vendorsListFragmentViewModel.updateWithFeatureProducts(i11, list);
                vendorsListFragmentViewModel.loadInlineAds(list);
            }
            vendorsListFragmentViewModel.showPharmacyPrescriptionCard(i11);
            return;
        }
        vendorsListFragmentViewModel.getShowNoResult().setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadVendorList$lambda-3  reason: not valid java name */
    public static final void m10766loadVendorList$lambda3(Throwable th2) {
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LogManager.logException(th2);
    }

    private final void showPharmacyPrescriptionCard(int i11) {
        boolean featureFlag = this.talabatFeatureFlag.getFeatureFlag(VendorListFeatureFlagsKeys.VENDOR_LIST_PHARMACY_EXPERIMENT, false);
        if (i11 == 2 && featureFlag) {
            this._showPharmacyPrescription.postValue(new EventWrapper(Unit.INSTANCE));
        }
    }

    private final void updateWithFeatureProducts(int i11, List<RestaurantListItemModel> list) {
        Disposable subscribe = ((Single) this.getDisplayFeatureProductsUseCase.invoke(Boolean.FALSE, Integer.valueOf(i11), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), Integer.valueOf(GlobalDataModel.SelectedAreaId), Integer.valueOf(GlobalDataModel.SelectedCountryId), Integer.valueOf(GlobalDataModel.SelectedCityId))).map(new d(this, list)).subscribeOn(Schedulers.single()).observeOn(this.mainScheduler).subscribe(new h(this), new i());
        Intrinsics.checkNotNullExpressionValue(subscribe, "getDisplayFeatureProduct…   ) { logException(it) }");
        this.mDisposables.add(subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateWithFeatureProducts$lambda-27  reason: not valid java name */
    public static final List m10767updateWithFeatureProducts$lambda27(VendorsListFragmentViewModel vendorsListFragmentViewModel, List list, List list2) {
        Intrinsics.checkNotNullParameter(vendorsListFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "$allRestaurantListItemModels");
        Intrinsics.checkNotNullParameter(list2, "it");
        return vendorsListFragmentViewModel.getFeatureProductsPairList(list2, list);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateWithFeatureProducts$lambda-30  reason: not valid java name */
    public static final void m10768updateWithFeatureProducts$lambda30(VendorsListFragmentViewModel vendorsListFragmentViewModel, List list) {
        Unit unit;
        Intrinsics.checkNotNullParameter(vendorsListFragmentViewModel, "this$0");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        Iterable<Pair> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Pair pair : iterable) {
            Integer num = (Integer) pair.getSecond();
            if (num != null) {
                vendorsListFragmentViewModel.getVendorsSwimlanes().setValue(new Pair(pair.getFirst(), Integer.valueOf(num.intValue())));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            arrayList.add(unit);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateWithFeatureProducts$lambda-31  reason: not valid java name */
    public static final void m10769updateWithFeatureProducts$lambda31(Throwable th2) {
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LogManager.logException(th2);
    }

    private final void updateWithVendorsSwimlanes(int i11, List<RestaurantListItemModel> list) {
        Disposable subscribe = ((Single) this.getVendorsSwimlanes.invoke(Boolean.FALSE, String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), Integer.valueOf(GlobalDataModel.SelectedAreaId), Integer.valueOf(GlobalDataModel.SelectedCountryId), Integer.valueOf(i11))).map(new j(this, list)).subscribeOn(Schedulers.single()).observeOn(this.mainScheduler).subscribe(new k(this), new l());
        Intrinsics.checkNotNullExpressionValue(subscribe, "getVendorsSwimlanes.invo…   ) { logException(it) }");
        this.mDisposables.add(subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateWithVendorsSwimlanes$lambda-14  reason: not valid java name */
    public static final List m10770updateWithVendorsSwimlanes$lambda14(VendorsListFragmentViewModel vendorsListFragmentViewModel, List list, List list2) {
        Intrinsics.checkNotNullParameter(vendorsListFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "$allRestaurantListItemModels");
        Intrinsics.checkNotNullParameter(list2, "it");
        return vendorsListFragmentViewModel.getSwimlanePair(list2, list);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateWithVendorsSwimlanes$lambda-17  reason: not valid java name */
    public static final void m10771updateWithVendorsSwimlanes$lambda17(VendorsListFragmentViewModel vendorsListFragmentViewModel, List list) {
        Unit unit;
        Intrinsics.checkNotNullParameter(vendorsListFragmentViewModel, "this$0");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        Iterable<Pair> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Pair pair : iterable) {
            Integer num = (Integer) pair.getSecond();
            if (num != null) {
                vendorsListFragmentViewModel.getVendorsSwimlanes().setValue(new Pair(pair.getFirst(), Integer.valueOf(num.intValue())));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            arrayList.add(unit);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateWithVendorsSwimlanes$lambda-18  reason: not valid java name */
    public static final void m10772updateWithVendorsSwimlanes$lambda18(Throwable th2) {
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LogManager.logException(th2);
    }

    @NotNull
    public final List<Pair<RestaurantListItemModel, Integer>> getFeatureProductsPairList(@NotNull List<FeatureProductListDisplayModel> list, @NotNull List<RestaurantListItemModel> list2) {
        Pair pair;
        Integer num;
        Object obj;
        int i11;
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        Intrinsics.checkNotNullParameter(list2, "allRestaurantListItemModels");
        Iterable<FeatureProductListDisplayModel> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (FeatureProductListDisplayModel featureProductListDisplayModel : iterable) {
            if (featureProductListDisplayModel.getPosition() != 0 || list2.size() <= 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list2.iterator();
                while (true) {
                    boolean z12 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((RestaurantListItemModel) next).type != 2) {
                        z12 = false;
                    }
                    if (z12) {
                        arrayList2.add(next);
                    }
                }
                ListIterator listIterator = arrayList2.listIterator(arrayList2.size());
                while (true) {
                    num = null;
                    if (!listIterator.hasPrevious()) {
                        obj = null;
                        break;
                    }
                    obj = listIterator.previous();
                    Restaurant restaurant = ((RestaurantListItemModel) obj).restaurant;
                    if (restaurant != null) {
                        i11 = restaurant.itemPosition;
                    } else {
                        i11 = 0;
                    }
                    if (i11 == featureProductListDisplayModel.getPosition()) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (z11) {
                        break;
                    }
                }
                RestaurantListItemModel restaurantListItemModel = (RestaurantListItemModel) obj;
                if (restaurantListItemModel != null) {
                    num = Integer.valueOf(list2.lastIndexOf(restaurantListItemModel));
                }
                pair = new Pair(new RestaurantListItemModel(14, featureProductListDisplayModel), num);
            } else {
                pair = new Pair(new RestaurantListItemModel(14, featureProductListDisplayModel), 0);
            }
            arrayList.add(pair);
        }
        return arrayList;
    }

    @NotNull
    public final CompositeDisposable getInlineAdDisposable() {
        return this.inlineAdDisposable;
    }

    @NotNull
    public MutableLiveData<Pair<RestaurantListItemModel, Integer>> getInlineAds() {
        return (MutableLiveData) this.inlineAds$delegate.getValue();
    }

    @NotNull
    public MutableLiveData<Boolean> getLoading() {
        return (MutableLiveData) this.loading$delegate.getValue();
    }

    @NotNull
    public MutableLiveData<Pair<String, Map<String, String>>> getSendEvent() {
        return (MutableLiveData) this.sendEvent$delegate.getValue();
    }

    @NotNull
    public MutableLiveData<Boolean> getShowNoResult() {
        return (MutableLiveData) this.showNoResult$delegate.getValue();
    }

    @NotNull
    public LiveData<EventWrapper<Unit>> getShowPharmacyPrescription() {
        return this.showPharmacyPrescription;
    }

    @NotNull
    public final List<Pair<RestaurantListItemModel, Integer>> getSwimlanePair(@NotNull List<Swimlane> list, @NotNull List<RestaurantListItemModel> list2) {
        Pair pair;
        Integer num;
        Object obj;
        int i11;
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        Intrinsics.checkNotNullParameter(list2, "allRestaurantListItemModels");
        Iterable<Swimlane> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Swimlane swimlane : iterable) {
            if (swimlane.getPosition() != 0 || list2.size() <= 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list2.iterator();
                while (true) {
                    boolean z12 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((RestaurantListItemModel) next).type != 2) {
                        z12 = false;
                    }
                    if (z12) {
                        arrayList2.add(next);
                    }
                }
                ListIterator listIterator = arrayList2.listIterator(arrayList2.size());
                while (true) {
                    num = null;
                    if (!listIterator.hasPrevious()) {
                        obj = null;
                        break;
                    }
                    obj = listIterator.previous();
                    Restaurant restaurant = ((RestaurantListItemModel) obj).restaurant;
                    if (restaurant != null) {
                        i11 = restaurant.itemPosition;
                    } else {
                        i11 = 0;
                    }
                    if (i11 == swimlane.getPosition()) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (z11) {
                        break;
                    }
                }
                RestaurantListItemModel restaurantListItemModel = (RestaurantListItemModel) obj;
                if (restaurantListItemModel != null) {
                    num = Integer.valueOf(list2.lastIndexOf(restaurantListItemModel));
                }
                pair = new Pair(RestaurantListItemModel.fromVendorSwimlane(swimlane), num);
            } else {
                RestaurantListItemModel fromVendorSwimlane = RestaurantListItemModel.fromVendorSwimlane(swimlane);
                Intrinsics.checkNotNullExpressionValue(fromVendorSwimlane, "fromVendorSwimlane(swimlane)");
                pair = new Pair(fromVendorSwimlane, 0);
            }
            arrayList.add(pair);
        }
        return arrayList;
    }

    @NotNull
    public MutableLiveData<List<RestaurantListItemModel>> getVendorList() {
        return (MutableLiveData) this.vendorList$delegate.getValue();
    }

    @NotNull
    public MutableLiveData<Pair<RestaurantListItemModel, Integer>> getVendorsSwimlanes() {
        return (MutableLiveData) this.vendorsSwimlanes$delegate.getValue();
    }

    public int getVerticalId() {
        return this.verticalId;
    }

    public void insertInlineAds(@NotNull AdsWrapper adsWrapper) {
        Intrinsics.checkNotNullParameter(adsWrapper, "adsWrapper");
        List value = getVendorList().getValue();
        if (value != null) {
            addAdListModel(adsWrapper, value);
        }
    }

    public void loadVendorList(int i11) {
        setVerticalId(i11);
        Disposable subscribe = ((Single) this.getVendorsUseCase.invoke(new GetVendorsUseCase.Params(false, GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCityId, GlobalDataModel.SelectedCountryId, String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), i11))).map(new m(this.applyFiltersUseCase)).map(new n(this)).map(new o(this, i11)).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new p(this, i11), new e());
        Intrinsics.checkNotNullExpressionValue(subscribe, "getVendorsUseCase.invoke…ion(it)\n                }");
        this.mDisposables.add(subscribe);
    }

    @NotNull
    public final Scheduler n() {
        return this.ioScheduler;
    }

    @NotNull
    public final Scheduler o() {
        return this.mainScheduler;
    }

    public void onCleared() {
        this.mDisposables.dispose();
        this.inlineAdDisposable.dispose();
    }

    public void sendFeatureProductClickEvent(@NotNull Context context, int i11, int i12, @NotNull String str, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "shopClickOrigin");
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featureProduct");
        this.talabatTracker.track(this.featureProductTracker.getFeatureProductClickEvent(i11, i12, str, featureProductDisplayModel));
        this.featureProductTracker.trackShopClickEvent(context, i12, featureProductDisplayModel);
    }

    public void sendFeatureProductImpressionEvent(int i11, int i12, @NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "featuredProduct");
        this.talabatTracker.track(this.featureProductTracker.getShopImpressionLoadedEvent(i11, i12, featureProductDisplayModel));
    }

    public void sendFeatureProductsAppearedEvent(@NotNull FeatureProductListDisplayModel featureProductListDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductListDisplayModel, "featuredProducts");
        this.talabatTracker.track(this.featureProductTracker.getFeatureProductShownEvent(featureProductListDisplayModel));
    }

    public final void setInlineAdDisposable(@NotNull CompositeDisposable compositeDisposable) {
        Intrinsics.checkNotNullParameter(compositeDisposable, "<set-?>");
        this.inlineAdDisposable = compositeDisposable;
    }

    public void setVerticalId(int i11) {
        this.verticalId = i11;
    }

    public VendorsListFragmentViewModel(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function1<? super GetVendorsUseCase.Params, ? extends Single<List<Restaurant>>> function1, @NotNull Function6<? super Boolean, ? super String, ? super String, ? super Integer, ? super Integer, ? super Integer, ? extends Single<List<Swimlane>>> function6, @NotNull Function7<? super Boolean, ? super Integer, ? super String, ? super String, ? super Integer, ? super Integer, ? super Integer, ? extends Single<List<FeatureProductListDisplayModel>>> function7, @NotNull FeatureProductTracker featureProductTracker2, @NotNull Function0<? extends FilterEngine> function0, @NotNull IAdLoader iAdLoader, @NotNull Function0<? extends List<SelectablePopularFilter>> function02, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function12, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(function1, "getVendorsUseCase");
        Intrinsics.checkNotNullParameter(function6, "getVendorsSwimlanes");
        Intrinsics.checkNotNullParameter(function7, "getDisplayFeatureProductsUseCase");
        Intrinsics.checkNotNullParameter(featureProductTracker2, "featureProductTracker");
        Intrinsics.checkNotNullParameter(function0, "getFilterEngine");
        Intrinsics.checkNotNullParameter(iAdLoader, "adLoader");
        Intrinsics.checkNotNullParameter(function02, "popularFilters");
        Intrinsics.checkNotNullParameter(function12, "applyFiltersUseCase");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "mainScheduler");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.getVendorsUseCase = function1;
        this.getVendorsSwimlanes = function6;
        this.getDisplayFeatureProductsUseCase = function7;
        this.featureProductTracker = featureProductTracker2;
        this.getFilterEngine = function0;
        this.adLoader = iAdLoader;
        this.popularFilters = function02;
        this.applyFiltersUseCase = function12;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.talabatTracker = talabatTracker2;
        this.mDisposables = new CompositeDisposable();
        this.inlineAdDisposable = new CompositeDisposable();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.showNoResult$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListFragmentViewModel$showNoResult$2.INSTANCE);
        this.loading$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListFragmentViewModel$loading$2.INSTANCE);
        this.vendorList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListFragmentViewModel$vendorList$2.INSTANCE);
        this.sendEvent$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListFragmentViewModel$sendEvent$2.INSTANCE);
        this.inlineAds$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListFragmentViewModel$inlineAds$2.INSTANCE);
        this.vendorsSwimlanes$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListFragmentViewModel$vendorsSwimlanes$2.INSTANCE);
        MutableLiveData<EventWrapper<Unit>> mutableLiveData = new MutableLiveData<>();
        this._showPharmacyPrescription = mutableLiveData;
        this.showPharmacyPrescription = mutableLiveData;
    }
}
