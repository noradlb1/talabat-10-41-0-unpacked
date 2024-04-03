package com.talabat.darkstores.feature.categories.subcategories.experiment;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView;
import com.models.ProductTrackingModel;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.entity.QCommerceScreenTracingNames;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.ResultKt;
import com.talabat.darkstores.common.ResultKt$toResult$4;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.common.extensions.SingleExtensionsKt;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.data.discovery.model.TagResponse;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.data.tracking.sort.tracker.SortAndFilterOptionTracker;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase;
import com.talabat.darkstores.feature.cart.BasketLifeTimeTooltipUseCase;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesData;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryHeadline;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryItem;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryProduct;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNewDirections;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfItem;
import com.talabat.darkstores.feature.categories.subcategories.sort.GetSortOnPLPEnabledUseCase;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.talabatcommon.optional.Optional;
import com.talabat.talabatcommon.optional.OptionalKt;
import com.talabat.wrapper.EventWrapper;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zi.a0;
import zi.b0;
import zi.c0;
import zi.d0;
import zi.e0;
import zi.f0;
import zi.g0;
import zi.h0;
import zi.i0;
import zi.j0;
import zi.k0;
import zi.l0;
import zi.m;
import zi.m0;
import zi.n;
import zi.n0;
import zi.o;
import zi.o0;
import zi.p;
import zi.p0;
import zi.q;
import zi.r;
import zi.s;
import zi.t;
import zi.u;
import zi.v;
import zi.w;
import zi.x;
import zi.y;
import zi.z;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0004\u0001\u0001B\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0006\u0010D\u001a\u00020(J\b\u0010E\u001a\u00020FH\u0002J.\u0010G\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\"0H2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\"H\u0002J\b\u0010L\u001a\u00020(H\u0002J\b\u0010M\u001a\u00020(H\u0002J\u0010\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u000200H\u0002J\u0006\u0010P\u001a\u00020(J'\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u0002042\b\u0010U\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0002\u0010VJ'\u0010W\u001a\u00020(2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u0002042\b\u0010U\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0002\u0010VJ\u0016\u0010X\u001a\u00020(2\u0006\u0010R\u001a\u00020S2\u0006\u0010Y\u001a\u000204J\u0006\u0010Z\u001a\u00020(J\b\u0010[\u001a\u00020(H\u0002J\u0006\u0010\\\u001a\u00020(J\u0006\u0010]\u001a\u00020(J\u000e\u0010^\u001a\u00020(2\u0006\u0010_\u001a\u00020\u0006J\u0014\u0010`\u001a\u00020(2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020b0\"J$\u0010c\u001a\b\u0012\u0004\u0012\u00020d0\"2\u0006\u0010e\u001a\u00020\u00062\f\u0010f\u001a\b\u0012\u0004\u0012\u00020S0\"H\u0002J\u0010\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020\u0006H\u0007J\u0012\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0!0'J\u0016\u0010i\u001a\u00020(2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020mJ\u0006\u0010n\u001a\u00020(J\u0006\u0010o\u001a\u00020(J\u0012\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0!0'J\b\u0010p\u001a\u00020(H\u0002J\u0016\u0010p\u001a\u00020(2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020B0rH\u0002J\b\u0010s\u001a\u00020(H\u0002J\u0014\u0010t\u001a\u00020(2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020d0\"J\u000e\u0010v\u001a\u00020(2\u0006\u0010w\u001a\u000204J \u0010x\u001a\b\u0012\u0004\u0012\u00020I0\"*\b\u0012\u0004\u0012\u00020K0\"2\u0006\u0010y\u001a\u00020\u0006H\u0002JN\u0010z\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020d 7*\n\u0012\u0004\u0012\u00020d\u0018\u00010\"0\" 7*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020d 7*\n\u0012\u0004\u0012\u00020d\u0018\u00010\"0\"\u0018\u00010{0{*\b\u0012\u0004\u0012\u00020B0{H\u0002JN\u0010z\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020d 7*\n\u0012\u0004\u0012\u00020d\u0018\u00010\"0\" 7*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020d 7*\n\u0012\u0004\u0012\u00020d\u0018\u00010\"0\"\u0018\u00010{0{*\b\u0012\u0004\u0012\u00020B0rH\u0002JN\u0010|\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020d 7*\n\u0012\u0004\u0012\u00020d\u0018\u00010\"0\" 7*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020d 7*\n\u0012\u0004\u0012\u00020d\u0018\u00010\"0\"\u0018\u00010{0{*\b\u0012\u0004\u0012\u00020B0{H\u0002JN\u0010|\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020d 7*\n\u0012\u0004\u0012\u00020d\u0018\u00010\"0\" 7*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020d 7*\n\u0012\u0004\u0012\u00020d\u0018\u00010\"0\"\u0018\u00010{0{*\b\u0012\u0004\u0012\u00020B0rH\u0002J\u0018\u0010}\u001a\b\u0012\u0004\u0012\u00020%0\"*\b\u0012\u0004\u0012\u00020~0\"H\u0002J\u0012\u0010\u001a\b\u0012\u0004\u0012\u00020d0\"*\u00020BH\u0002J\u0016\u0010\u0001\u001a\u00020I*\u00020S2\u0007\u0010\u0001\u001a\u000204H\u0002R \u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0 X\u0004¢\u0006\u0002\n\u0000R \u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\"0!0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020(0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R#\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0'8F¢\u0006\u0006\u001a\u0004\b-\u0010*R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0'¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u001a\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010(0(06X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u000609X\u000e¢\u0006\u0002\n\u0000R(\u0010:\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 7*\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001090906X\u0004¢\u0006\u0002\n\u0000R#\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\"0!0'8F¢\u0006\u0006\u001a\u0004\b<\u0010*R\u001a\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0!0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R(\u0010?\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 7*\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001090906X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0!0 X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010B0B06X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u0001040406X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "topLevelCategoryId", "", "categoryName", "eventOrigin", "Lcom/talabat/darkstores/data/tracking/EventOrigin;", "darkStoreEventTracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "productTracker", "Lcom/talabat/darkstores/data/tracking/product/ProductTracker;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "impressionTracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "buildSearchNavigationAction", "Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCase;", "basketLifeTimeTooltipUseCase", "Lcom/talabat/darkstores/feature/cart/BasketLifeTimeTooltipUseCase;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "buildCartNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCase;", "getSortOnPLPEnabledUseCase", "Lcom/talabat/darkstores/feature/categories/subcategories/sort/GetSortOnPLPEnabledUseCase;", "sortAndFilterOptionTracker", "Lcom/talabat/darkstores/data/tracking/sort/tracker/SortAndFilterOptionTracker;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/data/tracking/EventOrigin;Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;Lcom/talabat/darkstores/data/tracking/product/ProductTracker;Lcom/talabat/core/observabilityNew/domain/IScreenTracker;Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCase;Lcom/talabat/darkstores/feature/cart/BasketLifeTimeTooltipUseCase;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCase;Lcom/talabat/darkstores/feature/categories/subcategories/sort/GetSortOnPLPEnabledUseCase;Lcom/talabat/darkstores/data/tracking/sort/tracker/SortAndFilterOptionTracker;)V", "_categoriesLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/darkstores/common/Result;", "", "Lcom/talabat/darkstores/model/Category;", "_shelfItemsLiveData", "Lcom/talabat/darkstores/feature/categories/subcategories/shelf/ShelfItem;", "basketLifetimeTooltipLiveData", "Landroidx/lifecycle/LiveData;", "", "getBasketLifetimeTooltipLiveData", "()Landroidx/lifecycle/LiveData;", "basketLifetimeTooltipLiveDataMutable", "categoriesLiveData", "getCategoriesLiveData", "navigationActions", "Lcom/talabat/wrapper/EventWrapper;", "Landroidx/navigation/NavDirections;", "getNavigationActions", "navigationActionsMutable", "productsSentCount", "", "retrySubject", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "selectedShelfItem", "Lcom/talabat/talabatcommon/optional/Optional;", "selectedShelfItemSubject", "shelfItemsLiveData", "getShelfItemsLiveData", "shelfViewData", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesData;", "sortOptionPublishSubject", "subcategoriesData", "subcategorySwimalnesResponsePublishSubject", "Lcom/talabat/darkstores/data/discovery/model/SubcategorySwimalnesResponse;", "trackingEventSubject", "clearTag", "getEventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getSubcategoriesAndProducts", "Lkotlin/Pair;", "Lcom/models/ProductTrackingModel;", "swimlanes", "Lcom/talabat/darkstores/model/Swimlane;", "initControl", "initVariantA", "navigate", "action", "onCartIndicatorClick", "onProductAdded", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "quantity", "listPosition", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;)V", "onProductRemoved", "onQuantityChange", "count", "onReadyForInteractionDhDefinition", "onReadyForInteractionTlbDefinition", "onRetry", "onSearchBarClicked", "onSortApplied", "appliedSortOption", "onSortButtonClicked", "sortOption", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "selectProductsByTag", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "selectedTag", "products", "selectShelfItem", "name", "startImpressionTracking", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "startTraceDefinition", "stopImpressionTracking", "subscribeSelectedShelfItemSubject", "subcategorySwimlanesResponse", "Lio/reactivex/Single;", "subscribeTopLevelCategories", "updateImpressionData", "subcategoryItems", "updateScrollPosition", "position", "filterShelfProductsForTracking", "selectedItem", "getProducts", "Lio/reactivex/Observable;", "getProductsForShelfView", "mapToShelfItems", "Lcom/talabat/darkstores/data/discovery/model/TagResponse;", "toSubcategoryItems", "toTrackingModel", "index", "Companion", "Factory", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentViewModelNew extends BaseViewModel implements NewProductQuantityListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TRACKING_EVENTS_TO_SEND = 5;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<List<Category>>> _categoriesLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<List<ShelfItem>>> _shelfItemsLiveData = new MutableLiveData<>();
    @NotNull
    private final BasketLifeTimeTooltipUseCase basketLifeTimeTooltipUseCase;
    @NotNull
    private final MutableLiveData<Unit> basketLifetimeTooltipLiveDataMutable = new MutableLiveData<>();
    @NotNull
    private final BuildCartNavigationActionUseCase buildCartNavigationActionUseCase;
    @NotNull
    private final BuildSearchNavigationActionUseCase buildSearchNavigationAction;
    /* access modifiers changed from: private */
    @NotNull
    public final String categoryName;
    /* access modifiers changed from: private */
    @NotNull
    public final DarkstoresEventTracker darkStoreEventTracker;
    @NotNull
    private final DiscoveryRepo discoveryRepo;
    /* access modifiers changed from: private */
    @Nullable
    public final EventOrigin eventOrigin;
    @NotNull
    private final GetSortOnPLPEnabledUseCase getSortOnPLPEnabledUseCase;
    @NotNull
    private final ProductImpressionTracker impressionTracker;
    @NotNull
    private final LiveData<EventWrapper<NavDirections>> navigationActions;
    @NotNull
    private final MutableLiveData<EventWrapper<NavDirections>> navigationActionsMutable;
    @NotNull
    private final ProductTracker productTracker;
    /* access modifiers changed from: private */
    public int productsSentCount;
    @NotNull
    private final PublishSubject<Unit> retrySubject;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    @NotNull
    private final IScreenTracker screenTracker;
    @NotNull
    private Optional<String> selectedShelfItem;
    @NotNull
    private final PublishSubject<Optional<String>> selectedShelfItemSubject;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<SubcategoriesData>> shelfViewData = new MutableLiveData<>();
    @NotNull
    private final SortAndFilterOptionTracker sortAndFilterOptionTracker;
    @NotNull
    private final PublishSubject<Optional<String>> sortOptionPublishSubject;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<SubcategoriesData>> subcategoriesData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final PublishSubject<SubcategorySwimalnesResponse> subcategorySwimalnesResponsePublishSubject;
    /* access modifiers changed from: private */
    @NotNull
    public final String topLevelCategoryId;
    @NotNull
    private final PublishSubject<Integer> trackingEventSubject;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew$Companion;", "", "()V", "TRACKING_EVENTS_TO_SEND", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew$Factory;", "", "create", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew;", "topLevelCategoryId", "", "categoryName", "eventOrigin", "Lcom/talabat/darkstores/data/tracking/EventOrigin;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SubcategoriesFragmentViewModelNew create(@NotNull @Assisted("categoryId") String str, @NotNull @Assisted("categoryName") String str2, @Nullable EventOrigin eventOrigin);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public SubcategoriesFragmentViewModelNew(@NotNull DiscoveryRepo discoveryRepo2, @NotNull @Assisted("categoryId") String str, @NotNull @Assisted("categoryName") String str2, @Nullable @Assisted EventOrigin eventOrigin2, @NotNull DarkstoresEventTracker darkstoresEventTracker, @NotNull ProductTracker productTracker2, @NotNull IScreenTracker iScreenTracker, @NotNull ProductImpressionTracker productImpressionTracker, @NotNull BuildSearchNavigationActionUseCase buildSearchNavigationActionUseCase, @NotNull BasketLifeTimeTooltipUseCase basketLifeTimeTooltipUseCase2, @NotNull RxSchedulersFactory rxSchedulersFactory2, @NotNull BuildCartNavigationActionUseCase buildCartNavigationActionUseCase2, @NotNull GetSortOnPLPEnabledUseCase getSortOnPLPEnabledUseCase2, @NotNull SortAndFilterOptionTracker sortAndFilterOptionTracker2) {
        super(new CompositeDisposable());
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        Intrinsics.checkNotNullParameter(str, "topLevelCategoryId");
        Intrinsics.checkNotNullParameter(str2, "categoryName");
        Intrinsics.checkNotNullParameter(darkstoresEventTracker, "darkStoreEventTracker");
        Intrinsics.checkNotNullParameter(productTracker2, "productTracker");
        Intrinsics.checkNotNullParameter(iScreenTracker, "screenTracker");
        Intrinsics.checkNotNullParameter(productImpressionTracker, "impressionTracker");
        Intrinsics.checkNotNullParameter(buildSearchNavigationActionUseCase, "buildSearchNavigationAction");
        Intrinsics.checkNotNullParameter(basketLifeTimeTooltipUseCase2, "basketLifeTimeTooltipUseCase");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        Intrinsics.checkNotNullParameter(buildCartNavigationActionUseCase2, "buildCartNavigationActionUseCase");
        Intrinsics.checkNotNullParameter(getSortOnPLPEnabledUseCase2, "getSortOnPLPEnabledUseCase");
        Intrinsics.checkNotNullParameter(sortAndFilterOptionTracker2, "sortAndFilterOptionTracker");
        this.discoveryRepo = discoveryRepo2;
        this.topLevelCategoryId = str;
        this.categoryName = str2;
        this.eventOrigin = eventOrigin2;
        this.darkStoreEventTracker = darkstoresEventTracker;
        this.productTracker = productTracker2;
        this.screenTracker = iScreenTracker;
        this.impressionTracker = productImpressionTracker;
        this.buildSearchNavigationAction = buildSearchNavigationActionUseCase;
        this.basketLifeTimeTooltipUseCase = basketLifeTimeTooltipUseCase2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
        this.buildCartNavigationActionUseCase = buildCartNavigationActionUseCase2;
        this.getSortOnPLPEnabledUseCase = getSortOnPLPEnabledUseCase2;
        this.sortAndFilterOptionTracker = sortAndFilterOptionTracker2;
        MutableLiveData<EventWrapper<NavDirections>> mutableLiveData = new MutableLiveData<>();
        this.navigationActionsMutable = mutableLiveData;
        this.navigationActions = mutableLiveData;
        PublishSubject<Unit> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Unit>()");
        this.retrySubject = create;
        PublishSubject<Optional<String>> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Optional<String>>()");
        this.selectedShelfItemSubject = create2;
        PublishSubject<Integer> create3 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<Int>()");
        this.trackingEventSubject = create3;
        PublishSubject<Optional<String>> create4 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<Optional<String>>()");
        this.sortOptionPublishSubject = create4;
        this.selectedShelfItem = Optional.None.INSTANCE;
        PublishSubject<SubcategorySwimalnesResponse> create5 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<SubcategorySwimalnesResponse>()");
        this.subcategorySwimalnesResponsePublishSubject = create5;
        if (getSortOnPLPEnabledUseCase2.invoke()) {
            initVariantA();
        } else {
            initControl();
        }
    }

    private final List<ProductTrackingModel> filterShelfProductsForTracking(List<Swimlane> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (Swimlane products : list) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, products.getProducts());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next : arrayList) {
            if (((Product) next).getTags().contains(str)) {
                arrayList2.add(next);
            }
        }
        Iterable take = CollectionsKt___CollectionsKt.take(arrayList2, 5);
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(take, 10));
        int i11 = 0;
        for (Object next2 : take) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList3.add(toTrackingModel((Product) next2, i11));
            i11 = i12;
        }
        return arrayList3;
    }

    private final EventOriginType getEventOriginType() {
        EventOriginType fromTrackingName;
        EventOrigin eventOrigin2 = this.eventOrigin;
        if (eventOrigin2 == null || (fromTrackingName = EventOriginType.Companion.fromTrackingName(eventOrigin2.getTrackingName())) == null) {
            return EventOriginType.Category;
        }
        return fromTrackingName;
    }

    private final Observable<List<SubcategoryItem>> getProducts(Single<SubcategorySwimalnesResponse> single) {
        Observable<SubcategorySwimalnesResponse> observable = single.toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "toObservable()");
        return getProducts(observable);
    }

    /* access modifiers changed from: private */
    /* renamed from: getProducts$lambda-33  reason: not valid java name */
    public static final List m9895getProducts$lambda33(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "it");
        return subcategoriesFragmentViewModelNew.toSubcategoryItems(subcategorySwimalnesResponse);
    }

    private final Observable<List<SubcategoryItem>> getProductsForShelfView(Single<SubcategorySwimalnesResponse> single) {
        return single.flatMapObservable(new u(this)).distinctUntilChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForShelfView$lambda-38  reason: not valid java name */
    public static final ObservableSource m9896getProductsForShelfView$lambda38(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "subcategorySwimalnesResponse");
        ArrayList arrayList = new ArrayList();
        for (Swimlane products : subcategorySwimalnesResponse.getSwimlanes()) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, products.getProducts());
        }
        return subcategoriesFragmentViewModelNew.selectedShelfItemSubject.map(new k0(subcategoriesFragmentViewModelNew, arrayList));
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForShelfView$lambda-38$lambda-37  reason: not valid java name */
    public static final List m9897getProductsForShelfView$lambda38$lambda37(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, List list, Optional optional) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(list, "$products");
        Intrinsics.checkNotNullParameter(optional, "selectedTag");
        if (optional instanceof Optional.Some) {
            return subcategoriesFragmentViewModelNew.selectProductsByTag((String) ((Optional.Some) optional).getValue(), list);
        }
        if (Intrinsics.areEqual((Object) optional, (Object) Optional.None.INSTANCE)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForShelfView$lambda-43  reason: not valid java name */
    public static final ObservableSource m9898getProductsForShelfView$lambda43(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "subcategorySwimalnesResponse");
        ArrayList arrayList = new ArrayList();
        for (Swimlane products : subcategorySwimalnesResponse.getSwimlanes()) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, products.getProducts());
        }
        return subcategoriesFragmentViewModelNew.selectedShelfItemSubject.map(new o0(subcategoriesFragmentViewModelNew, arrayList));
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForShelfView$lambda-43$lambda-42  reason: not valid java name */
    public static final List m9899getProductsForShelfView$lambda43$lambda42(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, List list, Optional optional) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(list, "$products");
        Intrinsics.checkNotNullParameter(optional, "selectedTag");
        if (optional instanceof Optional.Some) {
            return subcategoriesFragmentViewModelNew.selectProductsByTag((String) ((Optional.Some) optional).getValue(), list);
        }
        if (Intrinsics.areEqual((Object) optional, (Object) Optional.None.INSTANCE)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Pair<List<String>, List<ProductTrackingModel>> getSubcategoriesAndProducts(List<Swimlane> list) {
        Iterable<Swimlane> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Swimlane headline : iterable) {
            arrayList.add(headline.getHeadline());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Swimlane products : iterable) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList2, products.getProducts());
        }
        Iterable<IndexedValue> take = CollectionsKt___CollectionsKt.take(CollectionsKt___CollectionsKt.drop(CollectionsKt___CollectionsKt.withIndex(arrayList2), this.productsSentCount), 5);
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(take, 10));
        for (IndexedValue indexedValue : take) {
            arrayList3.add(toTrackingModel((Product) indexedValue.component2(), indexedValue.component1()));
        }
        this.productsSentCount += arrayList3.size();
        return TuplesKt.to(arrayList, arrayList3);
    }

    private final void initControl() {
        Single cacheButRetryOnError = SingleExtensionsKt.cacheButRetryOnError(DiscoveryRepo.getSubcategorySwimlanes$default(this.discoveryRepo, this.topLevelCategoryId, FeedEndpointRequest.PageType.default_page, 1, (String) null, 8, (Object) null));
        CompositeDisposable a11 = a();
        Observable<List<SubcategoryItem>> products = getProducts((Single<SubcategorySwimalnesResponse>) cacheButRetryOnError);
        Intrinsics.checkNotNullExpressionValue(products, "subcategorySwimlanesResp…           .getProducts()");
        Observable<R> map = products.map(new SubcategoriesFragmentViewModelNew$initControl$$inlined$toResult$1());
        ResultKt$toResult$4 resultKt$toResult$4 = ResultKt$toResult$4.INSTANCE;
        Observable<R> startWith = map.onErrorReturn(resultKt$toResult$4).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith, "crossinline mapper: (Inp…artWith(Result.Loading())");
        Observable<R> repeatWhen = startWith.repeatWhen(new p0(this));
        Intrinsics.checkNotNullExpressionValue(repeatWhen, "subcategorySwimlanesResp…latMap { retrySubject } }");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) repeatWhen, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$initControl$3(this), 3, (Object) null));
        CompositeDisposable a12 = a();
        Observable<List<SubcategoryItem>> productsForShelfView = getProductsForShelfView((Single<SubcategorySwimalnesResponse>) cacheButRetryOnError);
        Intrinsics.checkNotNullExpressionValue(productsForShelfView, "subcategorySwimlanesResp…getProductsForShelfView()");
        Observable<R> startWith2 = productsForShelfView.map(new SubcategoriesFragmentViewModelNew$initControl$$inlined$toResult$2()).onErrorReturn(resultKt$toResult$4).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith2, "crossinline mapper: (Inp…artWith(Result.Loading())");
        Observable<R> repeatWhen2 = startWith2.repeatWhen(new n(this));
        Intrinsics.checkNotNullExpressionValue(repeatWhen2, "subcategorySwimlanesResp…peatWhen { retrySubject }");
        DisposableKt.plusAssign(a12, SubscribersKt.subscribeBy$default((Observable) repeatWhen2, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$initControl$6(this), 3, (Object) null));
        CompositeDisposable a13 = a();
        Observable<List<TagResponse>> observable = this.discoveryRepo.getTagsForCategory(this.topLevelCategoryId).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "discoveryRepo.getTagsFor…          .toObservable()");
        Observable<R> startWith3 = observable.map(new SubcategoriesFragmentViewModelNew$initControl$$inlined$toResult$3(this)).onErrorReturn(resultKt$toResult$4).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith3, "crossinline mapper: (Inp…artWith(Result.Loading())");
        Observable<R> repeatWhen3 = startWith3.repeatWhen(new o(this));
        Intrinsics.checkNotNullExpressionValue(repeatWhen3, "discoveryRepo.getTagsFor…latMap { retrySubject } }");
        DisposableKt.plusAssign(a13, SubscribersKt.subscribeBy$default((Observable) repeatWhen3, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$initControl$9(this), 3, (Object) null));
        subscribeTopLevelCategories();
        CompositeDisposable a14 = a();
        Observable<R> switchMapMaybe = this.trackingEventSubject.distinct().filter(new p(this)).switchMapMaybe(new q(cacheButRetryOnError, this));
        Intrinsics.checkNotNullExpressionValue(switchMapMaybe, "trackingEventSubject\n   …wimlanes) }\n            }");
        DisposableKt.plusAssign(a14, SubscribersKt.subscribeBy$default((Observable) switchMapMaybe, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$initControl$12(this), 3, (Object) null));
        subscribeSelectedShelfItemSubject(cacheButRetryOnError);
    }

    /* access modifiers changed from: private */
    /* renamed from: initControl$lambda-11  reason: not valid java name */
    public static final MaybeSource m9900initControl$lambda11(Single single, SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Integer num) {
        Intrinsics.checkNotNullParameter(single, "$subcategorySwimlanesResponse");
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(num, "it");
        return single.onErrorReturnItem(new SubcategorySwimalnesResponse(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList())).filter(new x()).map(new i0(subcategoriesFragmentViewModelNew));
    }

    /* access modifiers changed from: private */
    /* renamed from: initControl$lambda-11$lambda-10  reason: not valid java name */
    public static final Pair m9901initControl$lambda11$lambda10(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "it");
        return subcategoriesFragmentViewModelNew.getSubcategoriesAndProducts(subcategorySwimalnesResponse.getSwimlanes());
    }

    /* access modifiers changed from: private */
    /* renamed from: initControl$lambda-11$lambda-9  reason: not valid java name */
    public static final boolean m9902initControl$lambda11$lambda9(SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "it");
        return !subcategorySwimalnesResponse.getSwimlanes().isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: initControl$lambda-2  reason: not valid java name */
    public static final ObservableSource m9903initControl$lambda2(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Observable observable) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return observable.flatMap(new m0(subcategoriesFragmentViewModelNew));
    }

    /* access modifiers changed from: private */
    /* renamed from: initControl$lambda-2$lambda-1  reason: not valid java name */
    public static final ObservableSource m9904initControl$lambda2$lambda1(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Object obj) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(obj, "it");
        return subcategoriesFragmentViewModelNew.retrySubject;
    }

    /* access modifiers changed from: private */
    /* renamed from: initControl$lambda-4  reason: not valid java name */
    public static final ObservableSource m9905initControl$lambda4(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Observable observable) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return subcategoriesFragmentViewModelNew.retrySubject;
    }

    /* access modifiers changed from: private */
    /* renamed from: initControl$lambda-7  reason: not valid java name */
    public static final ObservableSource m9906initControl$lambda7(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Observable observable) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return observable.flatMap(new j0(subcategoriesFragmentViewModelNew));
    }

    /* access modifiers changed from: private */
    /* renamed from: initControl$lambda-7$lambda-6  reason: not valid java name */
    public static final ObservableSource m9907initControl$lambda7$lambda6(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Object obj) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(obj, "it");
        return subcategoriesFragmentViewModelNew.retrySubject;
    }

    /* access modifiers changed from: private */
    /* renamed from: initControl$lambda-8  reason: not valid java name */
    public static final boolean m9908initControl$lambda8(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Integer num) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(num, "it");
        if (num.intValue() > subcategoriesFragmentViewModelNew.productsSentCount || num.intValue() == 0) {
            return true;
        }
        return false;
    }

    private final void initVariantA() {
        Observable<R> switchMapSingle = this.sortOptionPublishSubject.startWith(Optional.None.INSTANCE).switchMapSingle(new v(this));
        Intrinsics.checkNotNullExpressionValue(switchMapSingle, "sortOptionPublishSubject…          )\n            }");
        CompositeDisposable a11 = a();
        Observable<R> flatMap = this.retrySubject.startWith(Unit.INSTANCE).flatMap(new w(switchMapSingle));
        Intrinsics.checkNotNullExpressionValue(flatMap, "retrySubject\n           …seObservable.toResult() }");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) flatMap, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$initVariantA$2(this), 3, (Object) null));
        CompositeDisposable a12 = a();
        Observable<SubcategorySwimalnesResponse> hide = this.subcategorySwimalnesResponsePublishSubject.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "subcategorySwimalnesResponsePublishSubject.hide()");
        Observable<List<SubcategoryItem>> products = getProducts(hide);
        Intrinsics.checkNotNullExpressionValue(products, "subcategorySwimalnesResp…           .getProducts()");
        Observable<R> map = products.map(new SubcategoriesFragmentViewModelNew$initVariantA$$inlined$toResult$1());
        ResultKt$toResult$4 resultKt$toResult$4 = ResultKt$toResult$4.INSTANCE;
        Observable<R> startWith = map.onErrorReturn(resultKt$toResult$4).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith, "crossinline mapper: (Inp…artWith(Result.Loading())");
        DisposableKt.plusAssign(a12, SubscribersKt.subscribeBy$default((Observable) startWith, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$initVariantA$4(this), 3, (Object) null));
        CompositeDisposable a13 = a();
        Observable<SubcategorySwimalnesResponse> hide2 = this.subcategorySwimalnesResponsePublishSubject.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "subcategorySwimalnesResponsePublishSubject.hide()");
        Observable<List<SubcategoryItem>> productsForShelfView = getProductsForShelfView(hide2);
        Intrinsics.checkNotNullExpressionValue(productsForShelfView, "subcategorySwimalnesResp…getProductsForShelfView()");
        Observable<R> startWith2 = productsForShelfView.map(new SubcategoriesFragmentViewModelNew$initVariantA$$inlined$toResult$2()).onErrorReturn(resultKt$toResult$4).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith2, "crossinline mapper: (Inp…artWith(Result.Loading())");
        DisposableKt.plusAssign(a13, SubscribersKt.subscribeBy$default((Observable) startWith2, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$initVariantA$6(this), 3, (Object) null));
        CompositeDisposable a14 = a();
        Observable<List<TagResponse>> observable = this.discoveryRepo.getTagsForCategory(this.topLevelCategoryId).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "discoveryRepo.getTagsFor…          .toObservable()");
        Observable<R> startWith3 = observable.map(new SubcategoriesFragmentViewModelNew$initVariantA$$inlined$toResult$3(this)).onErrorReturn(resultKt$toResult$4).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith3, "crossinline mapper: (Inp…artWith(Result.Loading())");
        DisposableKt.plusAssign(a14, SubscribersKt.subscribeBy$default((Observable) startWith3, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$initVariantA$8(this), 3, (Object) null));
        subscribeTopLevelCategories();
        CompositeDisposable a15 = a();
        Observable<R> combineLatest = Observable.combineLatest(this.trackingEventSubject.distinct().filter(new y(this)), this.subcategorySwimalnesResponsePublishSubject.hide().onErrorReturnItem(new SubcategorySwimalnesResponse(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList())).filter(new z()), new a0(this));
        Intrinsics.checkNotNullExpressionValue(combineLatest, "combineLatest(\n         …lnesResponse.swimlanes) }");
        DisposableKt.plusAssign(a15, SubscribersKt.subscribeBy$default((Observable) combineLatest, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$initVariantA$12(this), 3, (Object) null));
        subscribeSelectedShelfItemSubject();
    }

    /* access modifiers changed from: private */
    /* renamed from: initVariantA$lambda-18  reason: not valid java name */
    public static final SingleSource m9909initVariantA$lambda18(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Optional optional) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(optional, "appliedSortOption");
        String str = (String) optional.toNullable();
        if (str != null) {
            subcategoriesFragmentViewModelNew.subcategoriesData.postValue(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        } else {
            str = null;
        }
        return subcategoriesFragmentViewModelNew.discoveryRepo.getSubcategorySwimlanes(subcategoriesFragmentViewModelNew.topLevelCategoryId, FeedEndpointRequest.PageType.default_page, 1, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: initVariantA$lambda-19  reason: not valid java name */
    public static final ObservableSource m9910initVariantA$lambda19(Observable observable, Unit unit) {
        Intrinsics.checkNotNullParameter(observable, "$swimlaneResponseObservable");
        Intrinsics.checkNotNullParameter(unit, "it");
        return ResultKt.toResult(observable);
    }

    /* access modifiers changed from: private */
    /* renamed from: initVariantA$lambda-23  reason: not valid java name */
    public static final boolean m9911initVariantA$lambda23(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Integer num) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(num, "it");
        if (num.intValue() > subcategoriesFragmentViewModelNew.productsSentCount || num.intValue() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: initVariantA$lambda-24  reason: not valid java name */
    public static final boolean m9912initVariantA$lambda24(SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "it");
        return !subcategorySwimalnesResponse.getSwimlanes().isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: initVariantA$lambda-25  reason: not valid java name */
    public static final Pair m9913initVariantA$lambda25(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Integer num, SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(num, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "subcategorySwimalnesResponse");
        return subcategoriesFragmentViewModelNew.getSubcategoriesAndProducts(subcategorySwimalnesResponse.getSwimlanes());
    }

    /* access modifiers changed from: private */
    public final List<ShelfItem> mapToShelfItems(List<TagResponse> list) {
        HashSet hashSet = new HashSet();
        ArrayList<TagResponse> arrayList = new ArrayList<>();
        for (Object next : list) {
            if (hashSet.add(((TagResponse) next).getName())) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (TagResponse tagResponse : arrayList) {
            String name2 = tagResponse.getName();
            String imageUrl = tagResponse.getImageUrl();
            String color = tagResponse.getColor();
            Observable<R> map = this.selectedShelfItemSubject.map(new h0(tagResponse));
            Intrinsics.checkNotNullExpressionValue(map, "selectedShelfItemSubject…  )\n                    }");
            arrayList2.add(new ShelfItem(name2, imageUrl, color, map, this.selectedShelfItemSubject));
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    /* renamed from: mapToShelfItems$lambda-56$lambda-55  reason: not valid java name */
    public static final Boolean m9914mapToShelfItems$lambda56$lambda55(TagResponse tagResponse, Optional optional) {
        Intrinsics.checkNotNullParameter(tagResponse, "$tag");
        Intrinsics.checkNotNullParameter(optional, "it");
        if (optional instanceof Optional.Some) {
            return Boolean.valueOf(Intrinsics.areEqual((Object) (String) ((Optional.Some) optional).getValue(), (Object) tagResponse.getName()));
        }
        if (Intrinsics.areEqual((Object) optional, (Object) Optional.None.INSTANCE)) {
            return Boolean.FALSE;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public final void navigate(NavDirections navDirections) {
        this.navigationActionsMutable.postValue(new EventWrapper(navDirections));
    }

    /* access modifiers changed from: private */
    /* renamed from: onQuantityChange$lambda-50  reason: not valid java name */
    public static final boolean m9915onQuantityChange$lambda50(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "isBasketLifetimeTooltipEnabled");
        return bool.booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onQuantityChange$lambda-51  reason: not valid java name */
    public static final void m9916onQuantityChange$lambda51(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Boolean bool) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        subcategoriesFragmentViewModelNew.basketLifetimeTooltipLiveDataMutable.postValue(Unit.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void onReadyForInteractionTlbDefinition() {
        this.screenTracker.stopTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.TLB_QCOMMERCE_PLP_START_TO_INTERACTIVE.getValue()));
    }

    private final List<SubcategoryItem> selectProductsByTag(String str, List<Product> list) {
        SubcategoryHeadline subcategoryHeadline = new SubcategoryHeadline(str, 0, 0, (Integer) null, (List) null, 24, (DefaultConstructorMarker) null);
        ArrayList<Product> arrayList = new ArrayList<>();
        Iterator it = list.iterator();
        while (true) {
            boolean z11 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Iterable tags = ((Product) next).getTags();
            if (!(tags instanceof Collection) || !((Collection) tags).isEmpty()) {
                Iterator it2 = tags.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (StringsKt__StringsJVMKt.equals((String) it2.next(), str, true)) {
                            z11 = true;
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
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (Product subcategoryProduct : arrayList) {
            arrayList2.add(new SubcategoryProduct(subcategoryProduct, 0));
        }
        return CollectionsKt___CollectionsKt.plus(CollectionsKt__CollectionsJVMKt.listOf(subcategoryHeadline), arrayList2);
    }

    private final void subscribeSelectedShelfItemSubject(Single<SubcategorySwimalnesResponse> single) {
        CompositeDisposable a11 = a();
        Observable<R> switchMapMaybe = this.selectedShelfItemSubject.switchMapMaybe(new n0(this, single));
        Intrinsics.checkNotNullExpressionValue(switchMapMaybe, "selectedShelfItemSubject…          )\n            }");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) switchMapMaybe, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$subscribeSelectedShelfItemSubject$2(this), 3, (Object) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeSelectedShelfItemSubject$lambda-16  reason: not valid java name */
    public static final MaybeSource m9917subscribeSelectedShelfItemSubject$lambda16(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Single single, Optional optional) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(single, "$subcategorySwimlanesResponse");
        Intrinsics.checkNotNullParameter(optional, "optionalItem");
        subcategoriesFragmentViewModelNew.selectedShelfItem = optional;
        if (optional instanceof Optional.Some) {
            return single.onErrorReturnItem(new SubcategorySwimalnesResponse(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList())).filter(new r()).map(new s((String) ((Optional.Some) optional).getValue(), subcategoriesFragmentViewModelNew));
        }
        if (Intrinsics.areEqual((Object) optional, (Object) Optional.None.INSTANCE)) {
            return Maybe.empty();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeSelectedShelfItemSubject$lambda-16$lambda-15$lambda-13  reason: not valid java name */
    public static final boolean m9918subscribeSelectedShelfItemSubject$lambda16$lambda15$lambda13(SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "it");
        return !subcategorySwimalnesResponse.getSwimlanes().isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeSelectedShelfItemSubject$lambda-16$lambda-15$lambda-14  reason: not valid java name */
    public static final Pair m9919subscribeSelectedShelfItemSubject$lambda16$lambda15$lambda14(String str, SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(str, "$selectedItem");
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "subcategorySwimalnesResponse");
        return TuplesKt.to(str, subcategoriesFragmentViewModelNew.filterShelfProductsForTracking(subcategorySwimalnesResponse.getSwimlanes(), str));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeSelectedShelfItemSubject$lambda-28  reason: not valid java name */
    public static final MaybeSource m9920subscribeSelectedShelfItemSubject$lambda28(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Optional optional) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(optional, "optionalItem");
        subcategoriesFragmentViewModelNew.selectedShelfItem = optional;
        if (optional instanceof Optional.Some) {
            return Maybe.just((String) ((Optional.Some) optional).getValue());
        }
        if (Intrinsics.areEqual((Object) optional, (Object) Optional.None.INSTANCE)) {
            return Maybe.empty();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeSelectedShelfItemSubject$lambda-29  reason: not valid java name */
    public static final boolean m9921subscribeSelectedShelfItemSubject$lambda29(SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "it");
        return !subcategorySwimalnesResponse.getSwimlanes().isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeSelectedShelfItemSubject$lambda-30  reason: not valid java name */
    public static final Pair m9922subscribeSelectedShelfItemSubject$lambda30(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, String str, SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(str, "selectedItem");
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "subcategorySwimalnesResponse");
        return TuplesKt.to(str, subcategoriesFragmentViewModelNew.filterShelfProductsForTracking(subcategorySwimalnesResponse.getSwimlanes(), str));
    }

    private final void subscribeTopLevelCategories() {
        CompositeDisposable a11 = a();
        Observable<List<Category>> observable = this.discoveryRepo.getTopLevelCategories(FeedEndpointRequest.PageType.default_page).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "discoveryRepo.getTopLeve…          .toObservable()");
        Observable<Result<Type>> repeatWhen = ResultKt.toResult(observable).repeatWhen(new m(this));
        Intrinsics.checkNotNullExpressionValue(repeatWhen, "discoveryRepo.getTopLeve…latMap { retrySubject } }");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) repeatWhen, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$subscribeTopLevelCategories$2(this), 3, (Object) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeTopLevelCategories$lambda-32  reason: not valid java name */
    public static final ObservableSource m9923subscribeTopLevelCategories$lambda32(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Observable observable) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return observable.flatMap(new d0(subcategoriesFragmentViewModelNew));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeTopLevelCategories$lambda-32$lambda-31  reason: not valid java name */
    public static final ObservableSource m9924subscribeTopLevelCategories$lambda32$lambda31(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew, Object obj) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew, "this$0");
        Intrinsics.checkNotNullParameter(obj, "it");
        return subcategoriesFragmentViewModelNew.retrySubject;
    }

    private final List<SubcategoryItem> toSubcategoryItems(SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        List<SortOption> list;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        for (Object next : subcategorySwimalnesResponse.getSwimlanes()) {
            int i13 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Swimlane swimlane = (Swimlane) next;
            if (!this.getSortOnPLPEnabledUseCase.invoke() || i11 != 0) {
                list = CollectionsKt__CollectionsKt.emptyList();
            } else {
                list = subcategorySwimalnesResponse.getSortOptions();
            }
            SubcategoryHeadline subcategoryHeadline = new SubcategoryHeadline(swimlane.getHeadline(), i11, i12, (Integer) null, list, 8, (DefaultConstructorMarker) null);
            Iterable<Product> products = swimlane.getProducts();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(products, 10));
            for (Product subcategoryProduct : products) {
                arrayList2.add(new SubcategoryProduct(subcategoryProduct, i11));
            }
            List plus = CollectionsKt___CollectionsKt.plus(CollectionsKt__CollectionsJVMKt.listOf(subcategoryHeadline), arrayList2);
            i12 += plus.size();
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, plus);
            i11 = i13;
        }
        return arrayList;
    }

    private final ProductTrackingModel toTrackingModel(Product product, int i11) {
        Pair<String, String> priceAndCurrency = FloatExtensionsKt.getPriceAndCurrency(product.getPrice());
        return new ProductTrackingModel(product.getSku(), product.getName(), priceAndCurrency.component1(), priceAndCurrency.component2(), i11 + 1);
    }

    public final void clearTag() {
        this.selectedShelfItemSubject.onNext(Optional.None.INSTANCE);
    }

    @NotNull
    public final LiveData<Unit> getBasketLifetimeTooltipLiveData() {
        return this.basketLifetimeTooltipLiveDataMutable;
    }

    @NotNull
    public final LiveData<Result<List<Category>>> getCategoriesLiveData() {
        return this._categoriesLiveData;
    }

    @NotNull
    public final LiveData<EventWrapper<NavDirections>> getNavigationActions() {
        return this.navigationActions;
    }

    @NotNull
    public final LiveData<Result<List<ShelfItem>>> getShelfItemsLiveData() {
        return this._shelfItemsLiveData;
    }

    public final void onCartIndicatorClick() {
        CompositeDisposable a11 = a();
        BuildCartNavigationActionUseCase buildCartNavigationActionUseCase2 = this.buildCartNavigationActionUseCase;
        SubcategoriesFragmentNewDirections.Companion companion = SubcategoriesFragmentNewDirections.Companion;
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Single) buildCartNavigationActionUseCase2.invoke(new SubcategoriesFragmentViewModelNew$onCartIndicatorClick$1(companion), new SubcategoriesFragmentViewModelNew$onCartIndicatorClick$2(companion)), (Function1) null, (Function1) new SubcategoriesFragmentViewModelNew$onCartIndicatorClick$3(this), 1, (Object) null));
    }

    public void onProductAdded(@NotNull Product product, int i11, @Nullable Integer num) {
        Pair pair;
        Intrinsics.checkNotNullParameter(product, "product");
        Optional<String> optional = this.selectedShelfItem;
        if (optional instanceof Optional.Some) {
            pair = TuplesKt.to((String) ((Optional.Some) optional).getValue(), EventOriginType.CategoryShelfView);
        } else if (Intrinsics.areEqual((Object) optional, (Object) Optional.None.INSTANCE)) {
            pair = TuplesKt.to("", getEventOriginType());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        EventOriginType eventOriginType = (EventOriginType) pair.component2();
        Product product2 = product;
        int i12 = i11;
        Integer num2 = num;
        ProductTracker.addToCartClicked$default(this.productTracker, product2, i12, num2, this.darkStoreEventTracker.getScreenName(), eventOriginType, (String) pair.component1(), (SwimlaneTrackingData) null, (TrackingCategoryId) null, (String) null, (String) null, (String) null, (String) null, 4032, (Object) null);
    }

    public void onProductRemoved(@NotNull Product product, int i11, @Nullable Integer num) {
        Pair pair;
        Intrinsics.checkNotNullParameter(product, "product");
        Optional<String> optional = this.selectedShelfItem;
        if (optional instanceof Optional.Some) {
            pair = TuplesKt.to((String) ((Optional.Some) optional).getValue(), EventOriginType.CategoryShelfView);
        } else if (Intrinsics.areEqual((Object) optional, (Object) Optional.None.INSTANCE)) {
            pair = TuplesKt.to("", getEventOriginType());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        EventOriginType eventOriginType = (EventOriginType) pair.component2();
        Product product2 = product;
        int i12 = i11;
        Integer num2 = num;
        ProductTracker.removeFromCartClicked$default(this.productTracker, product2, i12, num2, this.darkStoreEventTracker.getScreenName(), eventOriginType, (String) pair.component1(), (SwimlaneTrackingData) null, (TrackingCategoryId) null, (String) null, (String) null, (String) null, 1984, (Object) null);
    }

    public final void onQuantityChange(@NotNull Product product, int i11) {
        Intrinsics.checkNotNullParameter(product, "product");
        if (i11 > 0) {
            CompositeDisposable a11 = a();
            Disposable subscribe = this.basketLifeTimeTooltipUseCase.isBasketLifetimeTooltipEnabled().subscribeOn(this.rxSchedulersFactory.io()).filter(new b0()).subscribe(new c0(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "basketLifeTimeTooltipUse…e(Unit)\n                }");
            DisposableKt.plusAssign(a11, subscribe);
        }
    }

    public final void onReadyForInteractionDhDefinition() {
        this.screenTracker.stopTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.QCOMMERCE_PLP_START_TO_INTERACTIVE.getValue()));
    }

    public final void onRetry() {
        this.retrySubject.onNext(Unit.INSTANCE);
    }

    public final void onSearchBarClicked() {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildSearchNavigationAction.invoke(new SubcategoriesFragmentViewModelNew$onSearchBarClicked$1(SubcategoriesFragmentNewDirections.Companion)), (Function1) null, (Function1) new SubcategoriesFragmentViewModelNew$onSearchBarClicked$2(this), 1, (Object) null));
    }

    public final void onSortApplied(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appliedSortOption");
        this.sortOptionPublishSubject.onNext(OptionalKt.toOptional(str));
    }

    public final void onSortButtonClicked(@NotNull List<SortOption> list) {
        Intrinsics.checkNotNullParameter(list, "sortOption");
        this.sortAndFilterOptionTracker.onSortButtonClicked(ScreenTrackingProvider.ScreenType.CATEGORY, ScreenTrackingProvider.ScreenName.CATEGORY, ScreenTrackingProvider.EventOrigin.CATEGORY_DETAILS_SORT);
        SubcategoriesFragmentNewDirections.Companion companion = SubcategoriesFragmentNewDirections.Companion;
        Object[] array = list.toArray(new SortOption[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        navigate(companion.actionSubcategoriesFragmentNewToCategorySortBottomSheet((SortOption[]) array));
    }

    @VisibleForTesting
    public final void selectShelfItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.selectedShelfItemSubject.onNext(new Optional.Some(str));
    }

    @NotNull
    public final LiveData<Result<SubcategoriesData>> shelfViewData() {
        return this.shelfViewData;
    }

    public final void startImpressionTracking(@NotNull RecyclerView recyclerView, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.impressionTracker.register(recyclerView, lifecycleOwner);
    }

    public final void startTraceDefinition() {
        IScreenTracker iScreenTracker = this.screenTracker;
        ScreenTrackerParams.Companion companion = ScreenTrackerParams.Companion;
        iScreenTracker.startTrace(companion.create(QCommerceScreenTracingNames.QCOMMERCE_PLP_START_TO_INTERACTIVE.getValue()));
        this.screenTracker.startTrace(companion.create(QCommerceScreenTracingNames.TLB_QCOMMERCE_PLP_START_TO_INTERACTIVE.getValue()));
    }

    public final void stopImpressionTracking() {
        this.impressionTracker.unregister();
    }

    @NotNull
    public final LiveData<Result<SubcategoriesData>> subcategoriesData() {
        return this.subcategoriesData;
    }

    public final void updateImpressionData(@NotNull List<? extends SubcategoryItem> list) {
        String str;
        Intrinsics.checkNotNullParameter(list, "subcategoryItems");
        ProductImpressionTracker productImpressionTracker = this.impressionTracker;
        String screenName = this.darkStoreEventTracker.getScreenName();
        if (screenName == null) {
            screenName = "NA";
        }
        EventOrigin eventOrigin2 = this.eventOrigin;
        if (eventOrigin2 != null) {
            str = eventOrigin2.getTrackingName();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        productImpressionTracker.updateSubcategoryItems(list, screenName, str);
    }

    public final void updateScrollPosition(int i11) {
        this.trackingEventSubject.onNext(Integer.valueOf(i11));
    }

    private final Observable<List<SubcategoryItem>> getProducts(Observable<SubcategorySwimalnesResponse> observable) {
        return observable.map(new t(this));
    }

    private final Observable<List<SubcategoryItem>> getProductsForShelfView(Observable<SubcategorySwimalnesResponse> observable) {
        return observable.flatMap(new l0(this)).distinctUntilChanged();
    }

    private final void subscribeSelectedShelfItemSubject() {
        Observable<R> switchMapMaybe = this.selectedShelfItemSubject.switchMapMaybe(new e0(this));
        Intrinsics.checkNotNullExpressionValue(switchMapMaybe, "selectedShelfItemSubject…}\n            )\n        }");
        CompositeDisposable a11 = a();
        Observable<R> combineLatest = Observable.combineLatest(switchMapMaybe, this.subcategorySwimalnesResponsePublishSubject.hide().onErrorReturnItem(new SubcategorySwimalnesResponse(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList())).filter(new f0()), new g0(this));
        Intrinsics.checkNotNullExpressionValue(combineLatest, "combineLatest(\n         …m\n            )\n        }");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) combineLatest, (Function1) null, (Function0) null, (Function1) new SubcategoriesFragmentViewModelNew$subscribeSelectedShelfItemSubject$5(this), 3, (Object) null));
    }
}
