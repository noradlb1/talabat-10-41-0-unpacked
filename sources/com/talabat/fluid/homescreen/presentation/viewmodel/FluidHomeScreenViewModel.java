package com.talabat.fluid.homescreen.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.deliveryhero.fluid.widgets.collections.list.ListCell;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignCacheUseCase;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.fluid.homescreen.domain.usecase.application.StopHomeScreenTraceUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackBannerComponentClickedUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackBannerSlideUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackEntryPointClicked;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackGroceryCategoriesUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroCarouselSlideUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentClickedUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentLoadUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackSecondaryBannerUseCases;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackShopClickedUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackShortCutsUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackSwimLaneUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackVoucherCodeEntryUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.UpdateSelectedRestaurantUseCaseImpl;
import com.talabat.fluid.homescreen.presentation.displaymodel.CollectionItem;
import com.talabat.fluid.homescreen.presentation.displaymodel.Component;
import com.talabat.fluid.homescreen.presentation.displaymodel.Configuration;
import com.talabat.fluid.homescreen.presentation.displaymodel.HeaderColour;
import com.talabat.fluid.homescreen.presentation.displaymodel.ItemType;
import com.talabat.fluid.homescreen.presentation.displaymodel.NavigationType;
import com.talabat.fluid.homescreen.presentation.displaymodel.SwimLaneEvent;
import com.talabat.fluid.homescreen.presentation.displaymodel.TrackingType;
import com.talabat.fluid.homescreen.presentation.displaymodel.TrackingTypes;
import com.talabat.fluid.homescreen.presentation.mapper.BannerAdItemMapper;
import com.talabat.fluid.homescreen.presentation.mapper.CollectionItemMapper;
import com.talabat.fluid.homescreen.presentation.mapper.EntryPointItem;
import com.talabat.fluid.homescreen.presentation.mapper.SwimLaneItemMapper;
import com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapper;
import com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapperKt;
import com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusDataMapper;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.homescreen.adapter.model.banner.BannerAdItem;
import com.talabat.homescreen.adapter.model.vetrical.VerticalItem;
import com.talabat.homescreen.orderstatus.domain.usecase.business.TrackOrderStatusLoadUseCase;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent;
import com.talabat.talabatcore.logger.LogManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 Ú\u00012\u00020\u0001:\u0002Ú\u0001Bç\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\u0006\u0010-\u001a\u00020.\u0012\u0006\u0010/\u001a\u000200\u0012\u0006\u00101\u001a\u000202\u0012\u0006\u00103\u001a\u000204\u0012\u0006\u00105\u001a\u000206\u0012\u0006\u00107\u001a\u000208¢\u0006\u0002\u00109J(\u0010t\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0u2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J\u0014\u0010x\u001a\u00020,2\n\u0010y\u001a\u00060zj\u0002`{H\u0002J\u0012\u0010|\u001a\u00020,2\b\u0010v\u001a\u0004\u0018\u00010}H\u0002J\u0014\u0010~\u001a\u00020z2\f\u0010\u001a\b\u0012\u0004\u0012\u00020B0AJ\u0007\u0010\u0001\u001a\u00020FJ\u0015\u0010\u0001\u001a\u00020z2\f\u0010\u001a\b\u0012\u0004\u0012\u00020B0AJ\u0007\u0010\u0001\u001a\u00020FJ&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J0\u0010\u0001\u001a\u00020,2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002JF\u0010\u0001\u001a\u00020,2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020z0A2\b\u0010\u0001\u001a\u00030\u00012\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0w2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010AH\u0002J\u001d\u0010\u0001\u001a\u00020,2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0w2\u0007\u0010\u0001\u001a\u00020FH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0w2\u0007\u0010\u0001\u001a\u00020FH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J\u001d\u0010\u0001\u001a\u00020,2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J&\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J\t\u0010\u0001\u001a\u00020,H\u0002J\u0013\u0010\u0001\u001a\u00020H2\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002J\u0013\u0010¢\u0001\u001a\u00020H2\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002J\u0011\u0010£\u0001\u001a\u00020H2\b\u0010 \u0001\u001a\u00030¡\u0001J\u001a\u0010¤\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020F2\b\u0010¥\u0001\u001a\u00030¡\u0001J\u0019\u0010¦\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020z2\u0007\u0010\u001a\u00030¡\u0001J\u0012\u0010§\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020BH\u0002J\u0007\u0010¨\u0001\u001a\u00020,J\u0007\u0010©\u0001\u001a\u00020,J\u0007\u0010ª\u0001\u001a\u00020,J\u0007\u0010«\u0001\u001a\u00020,J\u0007\u0010¬\u0001\u001a\u00020,J\u0013\u0010­\u0001\u001a\u00020,2\n\u0010y\u001a\u00060zj\u0002`{J\u0007\u0010®\u0001\u001a\u00020,J\u0012\u0010¯\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020BH\u0002J\u001f\u0010°\u0001\u001a\u00020,2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020z0A2\u0007\u0010\u001a\u00030¡\u0001J\b\u0010±\u0001\u001a\u00030²\u0001J\u0012\u0010³\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020FH\u0002J\t\u0010´\u0001\u001a\u00020,H\u0002J\u0015\u0010µ\u0001\u001a\u00020,2\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0002J\u0018\u0010¸\u0001\u001a\u00020,2\r\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020B0AH\u0002J\t\u0010¹\u0001\u001a\u00020,H\u0002J\u0013\u0010º\u0001\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0003\u0010»\u0001J\u0013\u0010¼\u0001\u001a\u00020,2\b\u0010½\u0001\u001a\u00030¾\u0001H\u0002J(\u0010¿\u0001\u001a\u00020,2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020z0A2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010AH\u0002J\u0012\u0010À\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020BH\u0002J\u0012\u0010Á\u0001\u001a\u00020,2\u0007\u0010Â\u0001\u001a\u00020BH\u0002J\u0012\u0010Ã\u0001\u001a\u00020,2\u0007\u0010Â\u0001\u001a\u00020BH\u0002J(\u0010Ä\u0001\u001a\u00020,2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020z0A2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010AH\u0002J\u0018\u0010Å\u0001\u001a\u00020,2\r\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020B0AH\u0002J#\u0010Ç\u0001\u001a\u00020,2\u0018\u0010v\u001a\u0014\u0012\u0004\u0012\u00020F\u0012\u0005\u0012\u00030È\u00010wj\u0003`É\u0001H\u0002J\u0010\u0010Ê\u0001\u001a\u00020,2\u0007\u0010Ë\u0001\u001a\u00020BJ\r\u0010Ì\u0001\u001a\u00020F*\u00020FH\u0002J\"\u0010Í\u0001\u001a\u0005\u0018\u00010\u0001*\u0014\u0012\u0004\u0012\u00020F\u0012\u0005\u0012\u00030È\u00010wj\u0003`É\u0001H\u0002J\u001c\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u0001*\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001*\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001*\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0wH\u0002J)\u0010Ô\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010Õ\u0001*\u0016\u0012\u0004\u0012\u00020F\u0012\f\u0012\n\u0012\u0005\u0012\u00030È\u00010Ö\u00010wH\u0002J\u0015\u0010×\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010Õ\u0001*\u00020BH\u0002J\u000e\u0010Ø\u0001\u001a\u00020D*\u00030·\u0001H\u0002J/\u0010Ù\u0001\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0w*\u0018\u0012\u0004\u0012\u00020F\u0012\u0005\u0012\u00030È\u0001\u0018\u00010wj\u0005\u0018\u0001`É\u0001H\u0002R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020>0;X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0@X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020D0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020F0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020H0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020H0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020K0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020F0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020N0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020P0;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0;X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020<0T¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020>0;¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0T¢\u0006\b\n\u0000\u001a\u0004\b[\u0010VR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020D0;¢\u0006\b\n\u0000\u001a\u0004\b]\u0010YR\u000e\u0010^\u001a\u00020_X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020F0T¢\u0006\b\n\u0000\u001a\u0004\ba\u0010VR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020H0T¢\u0006\b\n\u0000\u001a\u0004\bb\u0010VR\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020H0T¢\u0006\b\n\u0000\u001a\u0004\bc\u0010VR\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020K0T¢\u0006\b\n\u0000\u001a\u0004\be\u0010VR\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020F0T¢\u0006\b\n\u0000\u001a\u0004\bg\u0010VR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020N0;¢\u0006\b\n\u0000\u001a\u0004\bi\u0010YR\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020P0;¢\u0006\b\n\u0000\u001a\u0004\bk\u0010YR\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020R0T¢\u0006\b\n\u0000\u001a\u0004\bm\u0010VR\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R \u0010n\u001a\b\u0012\u0004\u0012\u00020o0AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006Û\u0001"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/viewmodel/FluidHomeScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "fetchHomeCollectionsUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase;", "shouldRateLastOrderUseCase", "Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "showItemReplacementBsUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase;", "trackHeroComponentLoadUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentLoadUseCase;", "trackHeroComponentClickedUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentClickedUseCase;", "trackBannerSlideUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackBannerSlideUseCase;", "trackHeroCarouselSlideUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroCarouselSlideUseCase;", "trackBannerComponentClickedUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackBannerComponentClickedUseCase;", "trackOrderStatusLoadUseCase", "Lcom/talabat/homescreen/orderstatus/domain/usecase/business/TrackOrderStatusLoadUseCase;", "verticalItemViewEntityMapper", "Lcom/talabat/fluid/homescreen/presentation/mapper/VerticalItemViewEntityMapper;", "trackEntryPointClicked", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackEntryPointClicked;", "trackShopClickedUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShopClickedUseCase;", "trackShortCutsUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShortCutsUseCase;", "bannerAdItemMapper", "Lcom/talabat/fluid/homescreen/presentation/mapper/BannerAdItemMapper;", "orderStatusDataMapper", "Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusDataMapper;", "trackSwimLaneUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSwimLaneUseCase;", "trackVoucherCodeEntryUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackVoucherCodeEntryUseCase;", "updateSelectedRestaurantUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/UpdateSelectedRestaurantUseCaseImpl;", "swimLaneItemMapper", "Lcom/talabat/fluid/homescreen/presentation/mapper/SwimLaneItemMapper;", "collectionItemMapper", "Lcom/talabat/fluid/homescreen/presentation/mapper/CollectionItemMapper;", "homeMapRedirectSetter", "Lkotlin/Function0;", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "voucherCampaignCacheUseCase", "Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignCacheUseCase;", "trackSecondaryBannerUseCases", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSecondaryBannerUseCases;", "stopHomeScreenTraceUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/application/StopHomeScreenTraceUseCase;", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "trackGroceryCategoriesUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackGroceryCategoriesUseCase;", "(Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase;Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentLoadUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentClickedUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackBannerSlideUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroCarouselSlideUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackBannerComponentClickedUseCase;Lcom/talabat/homescreen/orderstatus/domain/usecase/business/TrackOrderStatusLoadUseCase;Lcom/talabat/fluid/homescreen/presentation/mapper/VerticalItemViewEntityMapper;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackEntryPointClicked;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShopClickedUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShortCutsUseCase;Lcom/talabat/fluid/homescreen/presentation/mapper/BannerAdItemMapper;Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusDataMapper;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSwimLaneUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackVoucherCodeEntryUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/UpdateSelectedRestaurantUseCaseImpl;Lcom/talabat/fluid/homescreen/presentation/mapper/SwimLaneItemMapper;Lcom/talabat/fluid/homescreen/presentation/mapper/CollectionItemMapper;Lkotlin/jvm/functions/Function0;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignCacheUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSecondaryBannerUseCases;Lcom/talabat/fluid/homescreen/domain/usecase/application/StopHomeScreenTraceUseCase;Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackGroceryCategoriesUseCase;)V", "_bannerClickEvent", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "Lcom/talabat/homescreen/adapter/model/banner/BannerAdItem;", "_collectionClickedEvent", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/CollectionItem;", "_components", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/deliveryhero/fluid/widgets/collections/list/ListCell;", "_configuration", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/Configuration;", "_handleDeepLinkEvent", "", "_isLoadingVisible", "", "_isToolBarHidden", "_shouldShowItemReplacementBottomSheet", "Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase$ItemReplacementInfo;", "_shouldShowRatingBottomSheet", "_swimLaneClickedEvent", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/SwimLaneEvent;", "_transitionHeaderColour", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/HeaderColour;", "_verticalClickedEvent", "Lcom/talabat/fluid/homescreen/presentation/mapper/EntryPointItem;", "bannerClickEvent", "Landroidx/lifecycle/LiveData;", "getBannerClickEvent", "()Landroidx/lifecycle/LiveData;", "collectionClickedEvent", "getCollectionClickedEvent", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "components", "getComponents", "configuration", "getConfiguration", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleDeepLinkEvent", "getHandleDeepLinkEvent", "isLoadingVisible", "isToolBarHidden", "shouldShowItemReplacementBottomSheet", "getShouldShowItemReplacementBottomSheet", "shouldShowRatingBottomSheet", "getShouldShowRatingBottomSheet", "swimLaneClickedEvent", "getSwimLaneClickedEvent", "transitionHeaderColour", "getTransitionHeaderColour", "verticalClickedEvent", "getVerticalClickedEvent", "verticals", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem;", "getVerticals", "()Ljava/util/List;", "setVerticals", "(Ljava/util/List;)V", "applyTrackingWorkAround", "", "metadata", "", "changeHeaderColour", "scrollOffsetPixels", "", "Lcom/talabat/fluid/homescreen/ui/fragment/ScrollOffset;", "clearVoucherCampaignIfApplicable", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Metadata;", "getGroceryCategoriesComponentPosition", "collection", "getGroceryCategoriesComponentTag", "getPastOrdersComponentPosition", "getPastOrdersComponentTag", "handleBannerClick", "url", "handleCollectionItemClicked", "handleCollectionNavigation", "handleComponentClick", "component", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/Component;", "handleComponentSwiped", "itemPosition", "items", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "handleCustomNavigation", "handleDeepLinkWithItemTypeNavigation", "handleEntryPoints", "handleEntryPointsNavigation", "handleEntryPointsTracking", "it", "handleGroceryWidgetCategoryItemClick", "handleGroceryWidgetTitleItemClick", "handleGroceryWidgetViewStoreItemClick", "handleHero", "handleLoginClicked", "handlePickupClick", "handleSecondaryBannerClick", "handleSwimLaneItemClick", "handleTMartEntryPoint", "handleVoucherCodeEntry", "hideLoading", "isGroceryCategoriesComponent", "collectionData", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "isPastOrdersSwimLane", "isSecondaryBanner", "onClick", "data", "onComponentSwiped", "onEntryPointLoaded", "onGemExpired", "onLeavingHomeTab", "onPause", "onResume", "onReturningToHomeTab", "onScreenScrolled", "onStop", "onSwimLaneLoaded", "onSwiped", "onViewModelCreated", "Lkotlinx/coroutines/Job;", "postHandleDeepLinkEvent", "resetTrackingCache", "setupConfigurationIfAvailable", "configurationModel", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Configuration;", "showItemReplacementBottomSheet", "showLoading", "showRatingBottomSheet", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "track", "throwable", "", "trackAutoRotatingBanner", "trackBannerLoad", "trackHeroCarouselFirstBannerShown", "cell", "trackHeroCarouselLoad", "trackHeroCarouselShown", "trackLoadedComponents", "homeCollections", "trackOrderStatusLoad", "", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "trackSecondaryBannerShown", "listCell", "dropFirstChar", "getComponentOrNull", "getItemTypeOrNull", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/ItemType;", "getNavigationTypeOrNull", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/NavigationType;", "getTrackingType", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/TrackingType;", "retrieveCellsIfExists", "Lkotlin/sequences/Sequence;", "Lcom/deliveryhero/fluid/expression/Expression;", "toAllCollectionCells", "toConfiguration", "toStringMap", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModel extends ViewModel {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String HOME_COLLECTION_DEEPLINK_QUERY_VALUE = "home";
    @NotNull
    @Deprecated
    public static final String HOME_ORIGINATED_DEEPLINK_SUFFIX = "&from=home";
    @NotNull
    @Deprecated
    public static final String METADATA_COMPONENT_KEY = "component";
    @NotNull
    @Deprecated
    public static final String METADATA_ITEM_TYPE_KEY = "item_type";
    @NotNull
    @Deprecated
    public static final String METADATA_NAVIGATION_TYPE_KEY = "navigation_type";
    @NotNull
    @Deprecated
    public static final String METADATA_TRACKING_TYPE_KEY = "tracking_type";
    @NotNull
    @Deprecated
    public static final String PROPERTIES_GROCERY_CATEGORIES_ID = "grocery-widget-categories";
    @NotNull
    @Deprecated
    public static final String PROPERTIES_ID = "id";
    @NotNull
    @Deprecated
    public static final String PROPERTIES_PAST_ORDERS_ID = "past-orders";
    @NotNull
    private final SingleLiveEvent<BannerAdItem> _bannerClickEvent;
    @NotNull
    private final SingleLiveEvent<CollectionItem> _collectionClickedEvent;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<List<ListCell>> _components;
    @NotNull
    private final SingleLiveEvent<Configuration> _configuration;
    @NotNull
    private final SingleLiveEvent<String> _handleDeepLinkEvent;
    @NotNull
    private final SingleLiveEvent<Boolean> _isLoadingVisible;
    @NotNull
    private final SingleLiveEvent<Boolean> _isToolBarHidden;
    @NotNull
    private final SingleLiveEvent<ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo> _shouldShowItemReplacementBottomSheet;
    @NotNull
    private final SingleLiveEvent<String> _shouldShowRatingBottomSheet;
    @NotNull
    private final SingleLiveEvent<SwimLaneEvent> _swimLaneClickedEvent;
    @NotNull
    private final SingleLiveEvent<HeaderColour> _transitionHeaderColour;
    @NotNull
    private final SingleLiveEvent<EntryPointItem> _verticalClickedEvent;
    @NotNull
    private final BannerAdItemMapper bannerAdItemMapper;
    @NotNull
    private final LiveData<BannerAdItem> bannerClickEvent;
    @NotNull
    private final SingleLiveEvent<CollectionItem> collectionClickedEvent;
    @NotNull
    private final CollectionItemMapper collectionItemMapper;
    @NotNull
    private final LiveData<List<ListCell>> components;
    @NotNull
    private final SingleLiveEvent<Configuration> configuration;
    @NotNull
    private final CoroutineExceptionHandler exceptionHandler;
    /* access modifiers changed from: private */
    @NotNull
    public final FetchHomeCollectionsUseCase fetchHomeCollectionsUseCase;
    @NotNull
    private final LiveData<String> handleDeepLinkEvent;
    @NotNull
    private final Function0<Unit> homeMapRedirectSetter;
    /* access modifiers changed from: private */
    @NotNull
    public final HomeScreenPerformanceObservability homeScreenPerformanceObservability;
    @NotNull
    private final LiveData<Boolean> isLoadingVisible;
    @NotNull
    private final LiveData<Boolean> isToolBarHidden;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final OrderStatusDataMapper orderStatusDataMapper;
    @NotNull
    private final ShouldRateLastOrderUseCase shouldRateLastOrderUseCase;
    @NotNull
    private final LiveData<ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo> shouldShowItemReplacementBottomSheet;
    @NotNull
    private final LiveData<String> shouldShowRatingBottomSheet;
    @NotNull
    private final ShowItemReplacementBottomSheetUseCase showItemReplacementBsUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final StopHomeScreenTraceUseCase stopHomeScreenTraceUseCase;
    @NotNull
    private final SingleLiveEvent<SwimLaneEvent> swimLaneClickedEvent;
    @NotNull
    private final SwimLaneItemMapper swimLaneItemMapper;
    @NotNull
    private final TrackBannerComponentClickedUseCase trackBannerComponentClickedUseCase;
    @NotNull
    private final TrackBannerSlideUseCase trackBannerSlideUseCase;
    @NotNull
    private final TrackEntryPointClicked trackEntryPointClicked;
    @NotNull
    private final TrackGroceryCategoriesUseCase trackGroceryCategoriesUseCase;
    @NotNull
    private final TrackHeroCarouselSlideUseCase trackHeroCarouselSlideUseCase;
    @NotNull
    private final TrackHeroComponentClickedUseCase trackHeroComponentClickedUseCase;
    @NotNull
    private final TrackHeroComponentLoadUseCase trackHeroComponentLoadUseCase;
    @NotNull
    private final TrackOrderStatusLoadUseCase trackOrderStatusLoadUseCase;
    @NotNull
    private final TrackSecondaryBannerUseCases trackSecondaryBannerUseCases;
    @NotNull
    private final TrackShopClickedUseCase trackShopClickedUseCase;
    @NotNull
    private final TrackShortCutsUseCase trackShortCutsUseCase;
    @NotNull
    private final TrackSwimLaneUseCase trackSwimLaneUseCase;
    @NotNull
    private final TrackVoucherCodeEntryUseCase trackVoucherCodeEntryUseCase;
    @NotNull
    private final SingleLiveEvent<HeaderColour> transitionHeaderColour;
    @NotNull
    private final UpdateSelectedRestaurantUseCaseImpl updateSelectedRestaurantUseCase;
    @NotNull
    private final LiveData<EntryPointItem> verticalClickedEvent;
    /* access modifiers changed from: private */
    @NotNull
    public final VerticalItemViewEntityMapper verticalItemViewEntityMapper;
    @NotNull
    private List<VerticalItem> verticals;
    @NotNull
    private final VoucherCampaignCacheUseCase voucherCampaignCacheUseCase;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/viewmodel/FluidHomeScreenViewModel$Companion;", "", "()V", "HOME_COLLECTION_DEEPLINK_QUERY_VALUE", "", "HOME_ORIGINATED_DEEPLINK_SUFFIX", "METADATA_COMPONENT_KEY", "METADATA_ITEM_TYPE_KEY", "METADATA_NAVIGATION_TYPE_KEY", "METADATA_TRACKING_TYPE_KEY", "PROPERTIES_GROCERY_CATEGORIES_ID", "PROPERTIES_ID", "PROPERTIES_PAST_ORDERS_ID", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[Component.values().length];
            iArr[Component.HERO_CAROUSEL.ordinal()] = 1;
            iArr[Component.HERO.ordinal()] = 2;
            iArr[Component.LOGIN.ordinal()] = 3;
            iArr[Component.ACTIVE_ORDERS.ordinal()] = 4;
            iArr[Component.BANNER.ordinal()] = 5;
            iArr[Component.COLLECTION_CONTAINER.ordinal()] = 6;
            iArr[Component.ENTRYPOINT_CONTAINER.ordinal()] = 7;
            iArr[Component.VOUCHER_CODE_ENTRY.ordinal()] = 8;
            iArr[Component.SWIM_LANE_CONTAINER.ordinal()] = 9;
            iArr[Component.SECONDARY_BANNER.ordinal()] = 10;
            iArr[Component.ENTRY_POINT.ordinal()] = 11;
            iArr[Component.T_MART.ordinal()] = 12;
            iArr[Component.AUTO_ROTATING_BANNER.ordinal()] = 13;
            iArr[Component.COLLECTION_ITEM.ordinal()] = 14;
            iArr[Component.SWIM_LANE_ITEM.ordinal()] = 15;
            iArr[Component.PICKUP.ordinal()] = 16;
            iArr[Component.GROCERY_WIDGET_TITLE_ITEM.ordinal()] = 17;
            iArr[Component.GROCERY_WIDGET_CATEGORY_ITEM.ordinal()] = 18;
            iArr[Component.GROCERY_WIDGET_VIEW_STORE_ITEM.ordinal()] = 19;
            iArr[Component.GROCERY_WIDGET_CATEGORIES_COLLECTION.ordinal()] = 20;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NavigationType.values().length];
            iArr2[NavigationType.CUSTOM.ordinal()] = 1;
            iArr2[NavigationType.DEEP_LINK.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ItemType.values().length];
            iArr3[ItemType.COLLECTION.ordinal()] = 1;
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[TrackingTypes.values().length];
            iArr4[TrackingTypes.VERTICAL.ordinal()] = 1;
            iArr4[TrackingTypes.SHOP.ordinal()] = 2;
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FluidHomeScreenViewModel(com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase r33, com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase r34, com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase r35, com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentLoadUseCase r36, com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentClickedUseCase r37, com.talabat.fluid.homescreen.domain.usecase.business.TrackBannerSlideUseCase r38, com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroCarouselSlideUseCase r39, com.talabat.fluid.homescreen.domain.usecase.business.TrackBannerComponentClickedUseCase r40, com.talabat.homescreen.orderstatus.domain.usecase.business.TrackOrderStatusLoadUseCase r41, com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapper r42, com.talabat.fluid.homescreen.domain.usecase.business.TrackEntryPointClicked r43, com.talabat.fluid.homescreen.domain.usecase.business.TrackShopClickedUseCase r44, com.talabat.fluid.homescreen.domain.usecase.business.TrackShortCutsUseCase r45, com.talabat.fluid.homescreen.presentation.mapper.BannerAdItemMapper r46, com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusDataMapper r47, com.talabat.fluid.homescreen.domain.usecase.business.TrackSwimLaneUseCase r48, com.talabat.fluid.homescreen.domain.usecase.business.TrackVoucherCodeEntryUseCase r49, com.talabat.fluid.homescreen.domain.usecase.business.impl.UpdateSelectedRestaurantUseCaseImpl r50, com.talabat.fluid.homescreen.presentation.mapper.SwimLaneItemMapper r51, com.talabat.fluid.homescreen.presentation.mapper.CollectionItemMapper r52, kotlin.jvm.functions.Function0 r53, com.talabat.core.observabilityNew.domain.IObservabilityManager r54, com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignCacheUseCase r55, com.talabat.fluid.homescreen.domain.usecase.business.TrackSecondaryBannerUseCases r56, com.talabat.fluid.homescreen.domain.usecase.application.StopHomeScreenTraceUseCase r57, com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r58, com.talabat.fluid.homescreen.domain.usecase.business.TrackGroceryCategoriesUseCase r59, int r60, kotlin.jvm.internal.DefaultConstructorMarker r61) {
        /*
            r32 = this;
            r0 = r60
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x000f
            com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapper r1 = new com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapper
            r2 = 1
            r3 = 0
            r1.<init>(r3, r2, r3)
            r14 = r1
            goto L_0x0011
        L_0x000f:
            r14 = r42
        L_0x0011:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x001d
            com.talabat.fluid.homescreen.presentation.mapper.BannerAdItemMapper r0 = new com.talabat.fluid.homescreen.presentation.mapper.BannerAdItemMapper
            r0.<init>()
            r18 = r0
            goto L_0x001f
        L_0x001d:
            r18 = r46
        L_0x001f:
            r4 = r32
            r5 = r33
            r6 = r34
            r7 = r35
            r8 = r36
            r9 = r37
            r10 = r38
            r11 = r39
            r12 = r40
            r13 = r41
            r15 = r43
            r16 = r44
            r17 = r45
            r19 = r47
            r20 = r48
            r21 = r49
            r22 = r50
            r23 = r51
            r24 = r52
            r25 = r53
            r26 = r54
            r27 = r55
            r28 = r56
            r29 = r57
            r30 = r58
            r31 = r59
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel.<init>(com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase, com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase, com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase, com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentLoadUseCase, com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentClickedUseCase, com.talabat.fluid.homescreen.domain.usecase.business.TrackBannerSlideUseCase, com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroCarouselSlideUseCase, com.talabat.fluid.homescreen.domain.usecase.business.TrackBannerComponentClickedUseCase, com.talabat.homescreen.orderstatus.domain.usecase.business.TrackOrderStatusLoadUseCase, com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapper, com.talabat.fluid.homescreen.domain.usecase.business.TrackEntryPointClicked, com.talabat.fluid.homescreen.domain.usecase.business.TrackShopClickedUseCase, com.talabat.fluid.homescreen.domain.usecase.business.TrackShortCutsUseCase, com.talabat.fluid.homescreen.presentation.mapper.BannerAdItemMapper, com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusDataMapper, com.talabat.fluid.homescreen.domain.usecase.business.TrackSwimLaneUseCase, com.talabat.fluid.homescreen.domain.usecase.business.TrackVoucherCodeEntryUseCase, com.talabat.fluid.homescreen.domain.usecase.business.impl.UpdateSelectedRestaurantUseCaseImpl, com.talabat.fluid.homescreen.presentation.mapper.SwimLaneItemMapper, com.talabat.fluid.homescreen.presentation.mapper.CollectionItemMapper, kotlin.jvm.functions.Function0, com.talabat.core.observabilityNew.domain.IObservabilityManager, com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignCacheUseCase, com.talabat.fluid.homescreen.domain.usecase.business.TrackSecondaryBannerUseCases, com.talabat.fluid.homescreen.domain.usecase.application.StopHomeScreenTraceUseCase, com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability, com.talabat.fluid.homescreen.domain.usecase.business.TrackGroceryCategoriesUseCase, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final Map<String, String> applyTrackingWorkAround(Map<String, String> map) {
        Map<String, String> mutableMap = MapsKt__MapsKt.toMutableMap(map);
        String str = mutableMap.get("chainName");
        if (str != null) {
            mutableMap.put("shopName", str);
        }
        return mutableMap;
    }

    private final void changeHeaderColour(int i11) {
        Object obj;
        String str;
        boolean z11;
        if (i11 > 100) {
            obj = HeaderColour.White.INSTANCE;
        } else {
            Configuration value = this._configuration.getValue();
            HeaderColour.Custom custom = null;
            if (value != null) {
                str = value.getNavigationBarColor();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (str.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                custom = new HeaderColour.Custom(str);
            }
            obj = custom;
        }
        HeaderColour value2 = this._transitionHeaderColour.getValue();
        if (obj != null && !Intrinsics.areEqual(obj, (Object) value2)) {
            this._transitionHeaderColour.postValue(obj);
        }
    }

    /* access modifiers changed from: private */
    public final void clearVoucherCampaignIfApplicable(FetchHomeCollectionsUseCase.HomeCollectionResult.Metadata metadata) {
        HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = this.homeScreenPerformanceObservability;
        HomeScreenPerformanceObservability.Level level = HomeScreenPerformanceObservability.Level.INFO;
        HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(homeScreenPerformanceObservability2, level, "fluidHomeScreenViewModel.clearVoucherCampaignIfApplicable", (Map) null, 4, (Object) null);
        if (metadata != null && metadata.getClearVoucherCache()) {
            this.voucherCampaignCacheUseCase.clear();
        }
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(this.homeScreenPerformanceObservability, level, "fluidHomeScreenViewModel.clearVoucherCampaignIfApplicable", (Map) null, 4, (Object) null);
    }

    private final String dropFirstChar(String str) {
        return StringsKt___StringsKt.drop(str, 1);
    }

    private final Component getComponentOrNull(Map<String, ? extends Object> map) {
        Component.Companion companion = Component.Companion;
        Object obj = map.get(METADATA_COMPONENT_KEY);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return null;
        }
        return companion.from(str);
    }

    private final ItemType getItemTypeOrNull(Map<String, String> map) {
        ItemType.Companion companion = ItemType.Companion;
        String str = map.get(METADATA_ITEM_TYPE_KEY);
        if (str == null) {
            return null;
        }
        return companion.from(str);
    }

    private final NavigationType getNavigationTypeOrNull(Map<String, String> map) {
        NavigationType.Companion companion = NavigationType.Companion;
        String str = map.get(METADATA_NAVIGATION_TYPE_KEY);
        if (str == null) {
            return null;
        }
        return companion.from(str);
    }

    private final TrackingType getTrackingType(Map<String, String> map) {
        boolean z11;
        String str = map.get(METADATA_TRACKING_TYPE_KEY);
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return new TrackingType(StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null));
        }
        return null;
    }

    private final void handleBannerClick(String str, Map<String, String> map) {
        GlobalDataModel.ShopClickOrigin = "banner";
        this.trackBannerComponentClickedUseCase.trackBannerComponentClicked(map);
        this._bannerClickEvent.postValue(this.bannerAdItemMapper.mapFrom(str, map));
    }

    private final void handleCollectionItemClicked(String str, Map<String, String> map) {
        IntegrationKt.getDataSources().saveOfferAutoTriggered(true);
        this.trackShortCutsUseCase.trackShortCutsClicked(map);
        handleCollectionNavigation(str, map);
    }

    private final void handleCollectionNavigation(String str, Map<String, String> map) {
        this._collectionClickedEvent.setValue(this.collectionItemMapper.toCollectionItem(str, map));
    }

    private final void handleComponentClick(Component component, String str, Map<String, String> map) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[component.ordinal()];
        if (i11 == 2) {
            handleHero(str, map);
        } else if (i11 != 3) {
            if (i11 != 5) {
                if (i11 != 8) {
                    switch (i11) {
                        case 10:
                            handleSecondaryBannerClick(str, map);
                            return;
                        case 11:
                            handleEntryPoints(str, map);
                            return;
                        case 12:
                            handleTMartEntryPoint(str, map);
                            return;
                        case 13:
                            break;
                        case 14:
                            handleCollectionItemClicked(str + HOME_ORIGINATED_DEEPLINK_SUFFIX, map);
                            return;
                        case 15:
                            handleSwimLaneItemClick(map);
                            return;
                        case 16:
                            handlePickupClick(str, map);
                            return;
                        case 17:
                            handleGroceryWidgetTitleItemClick(str, map);
                            return;
                        case 18:
                            handleGroceryWidgetCategoryItemClick(str, map);
                            return;
                        case 19:
                            handleGroceryWidgetViewStoreItemClick(str, map);
                            return;
                        default:
                            String value = component.getValue();
                            LogManager.info("Clicked " + value);
                            postHandleDeepLinkEvent(str);
                            return;
                    }
                } else {
                    handleVoucherCodeEntry(str, map);
                    return;
                }
            }
            handleBannerClick(str, map);
        } else {
            handleLoginClicked(str, map);
        }
    }

    private final void handleComponentSwiped(List<Integer> list, Component component, Map<String, String> map, List<? extends Cell> list2) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[component.ordinal()];
        if (i11 == 1) {
            trackHeroCarouselShown(list, list2);
        } else if (i11 == 6) {
            this.trackShortCutsUseCase.trackShortCutsSwiped(map);
        } else if (i11 == 9) {
            this.trackSwimLaneUseCase.onSwimLaneSwiped(list, map, list2);
        } else if (i11 == 13) {
            trackAutoRotatingBanner(list, list2);
        } else if (i11 != 20) {
            LogManager.info("Swipe event of " + component + " not handled");
        } else {
            this.trackGroceryCategoriesUseCase.onCategoriesSwiped(list, list2);
        }
    }

    private final void handleCustomNavigation(Map<String, String> map) {
        boolean z11;
        String str = map.get(VerticalItemViewEntityMapperKt.VERTICAL_ITEM_KEY);
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            this._verticalClickedEvent.postValue(this.verticalItemViewEntityMapper.apply(map));
        }
    }

    private final void handleDeepLinkWithItemTypeNavigation(Map<String, String> map, String str) {
        int i11;
        ItemType itemTypeOrNull = getItemTypeOrNull(map);
        if (itemTypeOrNull == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$2[itemTypeOrNull.ordinal()];
        }
        if (i11 == 1) {
            handleCollectionNavigation(str, map);
        } else {
            postHandleDeepLinkEvent(str);
        }
    }

    private final void handleEntryPoints(String str, Map<String, String> map) {
        List<String> trackingTypeList;
        handleEntryPointsNavigation(map, str);
        TrackingType trackingType = getTrackingType(map);
        if (trackingType != null && (trackingTypeList = trackingType.getTrackingTypeList()) != null) {
            for (String handleEntryPointsTracking : trackingTypeList) {
                handleEntryPointsTracking(handleEntryPointsTracking, map);
            }
        }
    }

    private final void handleEntryPointsNavigation(Map<String, String> map, String str) {
        int i11;
        NavigationType navigationTypeOrNull = getNavigationTypeOrNull(map);
        if (navigationTypeOrNull == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$1[navigationTypeOrNull.ordinal()];
        }
        if (i11 == -1) {
            LogManager.debug("Entrypoint navigation type is null");
        } else if (i11 == 1) {
            handleCustomNavigation(map);
        } else if (i11 == 2) {
            handleDeepLinkWithItemTypeNavigation(map, str);
        }
    }

    private final void handleEntryPointsTracking(String str, Map<String, String> map) {
        int i11;
        TrackingTypes from = TrackingTypes.Companion.from(str);
        if (from == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$3[from.ordinal()];
        }
        if (i11 == -1) {
            LogManager.debug("Entrypoint tacking type is null");
        } else if (i11 == 1) {
            this.trackEntryPointClicked.trackEntryPointClicked(map);
        } else if (i11 == 2) {
            this.trackShopClickedUseCase.trackShopClicked(map);
        }
    }

    private final void handleGroceryWidgetCategoryItemClick(String str, Map<String, String> map) {
        this.trackGroceryCategoriesUseCase.trackCategoryItemClicked(map);
        postHandleDeepLinkEvent(str);
    }

    private final void handleGroceryWidgetTitleItemClick(String str, Map<String, String> map) {
        this.trackGroceryCategoriesUseCase.trackCategoriesTitleClicked(map);
        postHandleDeepLinkEvent(str);
    }

    private final void handleGroceryWidgetViewStoreItemClick(String str, Map<String, String> map) {
        this.trackGroceryCategoriesUseCase.trackCategoriesViewStoreClicked(map);
        postHandleDeepLinkEvent(str);
    }

    private final void handleHero(String str, Map<String, String> map) {
        this.homeMapRedirectSetter.invoke();
        handleDeepLinkWithItemTypeNavigation(map, str);
        this.trackHeroComponentClickedUseCase.trackHeroComponentClicked(map);
    }

    private final void handleLoginClicked(String str, Map<String, String> map) {
        SingleLiveEvent<String> singleLiveEvent = this._handleDeepLinkEvent;
        singleLiveEvent.postValue(str + HOME_ORIGINATED_DEEPLINK_SUFFIX);
        this.trackHeroComponentClickedUseCase.trackLoginComponentClicked(map);
    }

    private final void handlePickupClick(String str, Map<String, String> map) {
        this.homeMapRedirectSetter.invoke();
        postHandleDeepLinkEvent(str);
        this.trackEntryPointClicked.trackEntryPointClicked(applyTrackingWorkAround(map));
        this.trackShopClickedUseCase.trackShopClicked(map);
    }

    private final void handleSecondaryBannerClick(String str, Map<String, String> map) {
        this.trackSecondaryBannerUseCases.trackSecondaryBannerClicked(map);
        postHandleDeepLinkEvent(str);
    }

    private final void handleSwimLaneItemClick(Map<String, String> map) {
        GlobalDataModel.ShopClickOrigin = "swimlane";
        this.trackSwimLaneUseCase.onSwimLaneClicked(map);
        this.updateSelectedRestaurantUseCase.updateSelectedVendor(map);
        this.homeMapRedirectSetter.invoke();
        this._swimLaneClickedEvent.setValue(this.swimLaneItemMapper.toSwimLaneEvent(map));
    }

    private final void handleTMartEntryPoint(String str, Map<String, String> map) {
        this.homeMapRedirectSetter.invoke();
        postHandleDeepLinkEvent(str);
        this.trackEntryPointClicked.trackEntryPointClicked(applyTrackingWorkAround(map));
        this.trackShopClickedUseCase.trackShopClicked(map);
    }

    private final void handleVoucherCodeEntry(String str, Map<String, String> map) {
        SingleLiveEvent<String> singleLiveEvent = this._handleDeepLinkEvent;
        singleLiveEvent.postValue(str + HOME_ORIGINATED_DEEPLINK_SUFFIX);
        this.trackVoucherCodeEntryUseCase.onClicked(map);
    }

    /* access modifiers changed from: private */
    public final void hideLoading() {
        SingleLiveEvent<Boolean> singleLiveEvent = this._isLoadingVisible;
        Boolean bool = Boolean.FALSE;
        singleLiveEvent.postValue(bool);
        this._isToolBarHidden.postValue(bool);
    }

    private final boolean isGroceryCategoriesComponent(TemplateUiData templateUiData) {
        return getComponentOrNull(templateUiData.getMetadata()) == Component.GROCERY_WIDGET_CATEGORIES_COLLECTION;
    }

    private final boolean isPastOrdersSwimLane(TemplateUiData templateUiData) {
        if (getComponentOrNull(templateUiData.getMetadata()) != Component.SWIM_LANE_CONTAINER || !Intrinsics.areEqual(templateUiData.getMetadata().get("id"), (Object) PROPERTIES_PAST_ORDERS_ID)) {
            return false;
        }
        return true;
    }

    private final void onEntryPointLoaded(ListCell listCell) {
        this.verticals = SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.mapNotNull(SequencesKt___SequencesKt.mapNotNull(toAllCollectionCells(listCell), FluidHomeScreenViewModel$onEntryPointLoaded$1.INSTANCE), new FluidHomeScreenViewModel$onEntryPointLoaded$2(this)));
    }

    private final void onSwimLaneLoaded(ListCell listCell) {
        Map<String, Object> map;
        TemplateUiData data;
        Cell cell = (Cell) SequencesKt___SequencesKt.firstOrNull(toAllCollectionCells(listCell));
        if (cell == null || (data = cell.getData()) == null || (map = data.getMetadata()) == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        this.trackSwimLaneUseCase.onSwimLaneLoaded(toStringMap(map));
    }

    private final void postHandleDeepLinkEvent(String str) {
        this._handleDeepLinkEvent.postValue(str);
    }

    /* access modifiers changed from: private */
    public final void resetTrackingCache() {
        this.trackHeroCarouselSlideUseCase.resetTracking();
        this.trackBannerSlideUseCase.resetTracking();
        this.trackSwimLaneUseCase.resetTracking();
        this.trackSecondaryBannerUseCases.resetTracking();
    }

    private final Sequence<Cell> retrieveCellsIfExists(Map<String, ? extends Expression<Object>> map) {
        Sequence filter = SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(map.values()), FluidHomeScreenViewModel$retrieveCellsIfExists$1.INSTANCE), FluidHomeScreenViewModel$retrieveCellsIfExists$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return SequencesKt__SequencesKt.flattenSequenceOfIterable(filter);
    }

    /* access modifiers changed from: private */
    public final void setupConfigurationIfAvailable(FetchHomeCollectionsUseCase.HomeCollectionResult.Configuration configuration2) {
        if (configuration2 != null) {
            this._configuration.postValue(toConfiguration(configuration2));
        }
    }

    /* access modifiers changed from: private */
    public final void showItemReplacementBottomSheet(List<ListCell> list) {
        HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = this.homeScreenPerformanceObservability;
        HomeScreenPerformanceObservability.Level level = HomeScreenPerformanceObservability.Level.INFO;
        HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(homeScreenPerformanceObservability2, level, "fluidHomeScreenViewModel.showItemReplacementBottomSheet", (Map) null, 4, (Object) null);
        this._shouldShowItemReplacementBottomSheet.postValue(this.showItemReplacementBsUseCase.shouldShowItemReplacementBottomSheet(list));
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(this.homeScreenPerformanceObservability, level, "fluidHomeScreenViewModel.showItemReplacementBottomSheet", (Map) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        SingleLiveEvent<Boolean> singleLiveEvent = this._isLoadingVisible;
        Boolean bool = Boolean.TRUE;
        singleLiveEvent.postValue(bool);
        this._isToolBarHidden.postValue(bool);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showRatingBottomSheet(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel$showRatingBottomSheet$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel$showRatingBottomSheet$1 r0 = (com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel$showRatingBottomSheet$1) r0
            int r1 = r0.f59735k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59735k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel$showRatingBottomSheet$1 r0 = new com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel$showRatingBottomSheet$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f59733i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59735k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f59732h
            com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel r0 = (com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x002d }
            goto L_0x0056
        L_0x002d:
            r11 = move-exception
            goto L_0x005f
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r11)
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r4 = r10.homeScreenPerformanceObservability
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r5 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO
            java.lang.String r6 = "fluidHomeScreenViewModel.showRatingBottomSheet"
            r7 = 0
            r8 = 4
            r9 = 0
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(r4, r5, r6, r7, r8, r9)
            kotlin.Result$Companion r11 = kotlin.Result.Companion     // Catch:{ all -> 0x005d }
            com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase r11 = r10.shouldRateLastOrderUseCase     // Catch:{ all -> 0x005d }
            r0.f59732h = r10     // Catch:{ all -> 0x005d }
            r0.f59735k = r3     // Catch:{ all -> 0x005d }
            java.lang.Object r11 = r11.getEncryptedOrderIdForLastOrder(r0)     // Catch:{ all -> 0x005d }
            if (r11 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r0 = r10
        L_0x0056:
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x002d }
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)     // Catch:{ all -> 0x002d }
            goto L_0x0069
        L_0x005d:
            r11 = move-exception
            r0 = r10
        L_0x005f:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)
        L_0x0069:
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r11)
            if (r1 == 0) goto L_0x0085
            r1 = r11
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0079
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent<java.lang.String> r2 = r0._shouldShowRatingBottomSheet
            r2.postValue(r1)
        L_0x0079:
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r3 = r0.homeScreenPerformanceObservability
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r4 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO
            java.lang.String r5 = "fluidHomeScreenViewModel.showRatingBottomSheet"
            r6 = 0
            r7 = 4
            r8 = 0
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(r3, r4, r5, r6, r7, r8)
        L_0x0085:
            java.lang.Throwable r11 = kotlin.Result.m6332exceptionOrNullimpl(r11)
            if (r11 == 0) goto L_0x00b5
            com.talabat.talabatcore.logger.LogManager.logException(r11)
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r1 = r0.homeScreenPerformanceObservability
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r2 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO
            java.lang.String r11 = r11.getMessage()
            if (r11 != 0) goto L_0x009a
            java.lang.String r11 = ""
        L_0x009a:
            java.lang.String r3 = "error"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r3, r11)
            java.util.Map r11 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r11)
            java.lang.String r3 = "fluidHomeScreenViewModel.showRatingBottomSheet"
            r1.traceEvent(r2, r3, r11)
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r4 = r0.homeScreenPerformanceObservability
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r5 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.ERROR
            java.lang.String r6 = "fluidHomeScreenViewModel.showRatingBottomSheet"
            r7 = 0
            r8 = 4
            r9 = 0
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(r4, r5, r6, r7, r8, r9)
        L_0x00b5:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel.showRatingBottomSheet(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Sequence<Cell> toAllCollectionCells(ListCell listCell) {
        return retrieveCellsIfExists(listCell.getData().getPlaceholderValues());
    }

    private final Configuration toConfiguration(FetchHomeCollectionsUseCase.HomeCollectionResult.Configuration configuration2) {
        return new Configuration(dropFirstChar(configuration2.getNavigationBarColor()), dropFirstChar(configuration2.getLocationHintColor()), dropFirstChar(configuration2.getLocationTitleColor()), dropFirstChar(configuration2.getLocationArrowTintColor()));
    }

    private final Map<String, String> toStringMap(Map<String, ? extends Object> map) {
        if (map == null) {
            return MapsKt__MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    public final void track(Throwable th2) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        iObservabilityManager.trackUnExpectedScenario("FluidHomeScreenViewModelExceptions", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    private final void trackAutoRotatingBanner(List<Integer> list, List<? extends Cell> list2) {
        Integer num = (Integer) CollectionsKt___CollectionsKt.firstOrNull(list);
        if (num != null) {
            int intValue = num.intValue();
            if (CollectionsKt__CollectionsKt.getIndices(list2).contains(intValue)) {
                this.trackBannerSlideUseCase.trackBannerSlide(intValue, toStringMap(((Cell) list2.get(intValue)).getData().getMetadata()));
            }
        }
    }

    private final void trackBannerLoad(ListCell listCell) {
        Map<String, String> map;
        TemplateUiData data;
        Map<String, Object> metadata;
        TrackBannerSlideUseCase trackBannerSlideUseCase2 = this.trackBannerSlideUseCase;
        Cell cell = (Cell) SequencesKt___SequencesKt.firstOrNull(toAllCollectionCells(listCell));
        if (cell == null || (data = cell.getData()) == null || (metadata = data.getMetadata()) == null || (map = toStringMap(metadata)) == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        trackBannerSlideUseCase2.trackBannerSlide(0, map);
    }

    private final void trackHeroCarouselFirstBannerShown(ListCell listCell) {
        trackHeroCarouselShown(CollectionsKt__CollectionsJVMKt.listOf(0), SequencesKt___SequencesKt.toList(retrieveCellsIfExists(listCell.getData().getPlaceholderValues())));
    }

    private final void trackHeroCarouselLoad(ListCell listCell) {
        Map<String, Object> map;
        TemplateUiData data;
        Map<String, Object> metadata = listCell.getData().getMetadata();
        Cell cell = (Cell) SequencesKt___SequencesKt.firstOrNull(toAllCollectionCells(listCell));
        if (cell == null || (data = cell.getData()) == null || (map = data.getMetadata()) == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        this.trackHeroComponentLoadUseCase.trackHeroComponentLoad(MapsKt__MapsKt.plus(metadata, map));
        trackHeroCarouselFirstBannerShown(listCell);
    }

    private final void trackHeroCarouselShown(List<Integer> list, List<? extends Cell> list2) {
        Integer num = (Integer) CollectionsKt___CollectionsKt.firstOrNull(list);
        if (num != null) {
            int intValue = num.intValue();
            if (CollectionsKt__CollectionsKt.getIndices(list2).contains(intValue)) {
                this.trackHeroCarouselSlideUseCase.trackSlide(intValue, toStringMap(((Cell) list2.get(intValue)).getData().getMetadata()));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void trackLoadedComponents(List<ListCell> list) {
        int i11;
        HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(this.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "fluidHomeScreenViewModel.trackLoadedComponents", (Map) null, 4, (Object) null);
        for (ListCell listCell : list) {
            Component componentOrNull = getComponentOrNull(listCell.getData().getMetadata());
            if (componentOrNull == null) {
                i11 = -1;
            } else {
                i11 = WhenMappings.$EnumSwitchMapping$0[componentOrNull.ordinal()];
            }
            switch (i11) {
                case -1:
                    LogManager.error$default((Throwable) null, "Component could not be identified", 1, (Object) null);
                    break;
                case 1:
                    trackHeroCarouselLoad(listCell);
                    break;
                case 2:
                    this.trackHeroComponentLoadUseCase.trackHeroComponentLoad(listCell.getData().getMetadata());
                    break;
                case 3:
                    this.trackHeroComponentLoadUseCase.trackLoginComponentLoad(listCell.getData().getMetadata());
                    break;
                case 4:
                    trackOrderStatusLoad(listCell.getData().getMetadata());
                    break;
                case 5:
                    trackBannerLoad(listCell);
                    break;
                case 6:
                    this.trackShortCutsUseCase.trackShortCutsLoad(listCell.getData().getMetadata());
                    break;
                case 7:
                    onEntryPointLoaded(listCell);
                    break;
                case 8:
                    this.trackVoucherCodeEntryUseCase.onLoaded(MapsKt__MapsKt.toMap(listCell.getData().getMetadata()));
                    break;
                case 9:
                    onSwimLaneLoaded(listCell);
                    break;
                case 10:
                    this.trackSecondaryBannerUseCases.trackSecondaryBannerLoaded(toStringMap(listCell.getData().getMetadata()));
                    break;
                default:
                    String value = componentOrNull.getValue();
                    LogManager.info("Component load not tracked for: " + value);
                    break;
            }
        }
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(this.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "fluidHomeScreenViewModel.trackLoadedComponents", (Map) null, 4, (Object) null);
    }

    private final void trackOrderStatusLoad(Map<String, ? extends Object> map) {
        OrderStatusView.OrderStatusData orderStatusData = (OrderStatusView.OrderStatusData) CollectionsKt___CollectionsKt.firstOrNull(this.orderStatusDataMapper.invoke(toStringMap(map)));
        if (orderStatusData != null) {
            this.trackOrderStatusLoadUseCase.trackOrderStatusLoad(String.valueOf(orderStatusData.getOriginalOrderID()), orderStatusData.getChainId(), orderStatusData.getChainName());
        }
    }

    @NotNull
    public final LiveData<BannerAdItem> getBannerClickEvent() {
        return this.bannerClickEvent;
    }

    @NotNull
    public final SingleLiveEvent<CollectionItem> getCollectionClickedEvent() {
        return this.collectionClickedEvent;
    }

    @NotNull
    public final LiveData<List<ListCell>> getComponents() {
        return this.components;
    }

    @NotNull
    public final SingleLiveEvent<Configuration> getConfiguration() {
        return this.configuration;
    }

    public final int getGroceryCategoriesComponentPosition(@NotNull List<ListCell> list) {
        Intrinsics.checkNotNullParameter(list, GemAccessor.COMPONENT_COLLECTION);
        int i11 = 0;
        for (ListCell data : list) {
            if (isGroceryCategoriesComponent(data.getData())) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @NotNull
    public final String getGroceryCategoriesComponentTag() {
        return PROPERTIES_GROCERY_CATEGORIES_ID;
    }

    @NotNull
    public final LiveData<String> getHandleDeepLinkEvent() {
        return this.handleDeepLinkEvent;
    }

    public final int getPastOrdersComponentPosition(@NotNull List<ListCell> list) {
        Intrinsics.checkNotNullParameter(list, GemAccessor.COMPONENT_COLLECTION);
        int i11 = 0;
        for (ListCell data : list) {
            if (isPastOrdersSwimLane(data.getData())) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @NotNull
    public final String getPastOrdersComponentTag() {
        return PROPERTIES_PAST_ORDERS_ID;
    }

    @NotNull
    public final LiveData<ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo> getShouldShowItemReplacementBottomSheet() {
        return this.shouldShowItemReplacementBottomSheet;
    }

    @NotNull
    public final LiveData<String> getShouldShowRatingBottomSheet() {
        return this.shouldShowRatingBottomSheet;
    }

    @NotNull
    public final SingleLiveEvent<SwimLaneEvent> getSwimLaneClickedEvent() {
        return this.swimLaneClickedEvent;
    }

    @NotNull
    public final SingleLiveEvent<HeaderColour> getTransitionHeaderColour() {
        return this.transitionHeaderColour;
    }

    @NotNull
    public final LiveData<EntryPointItem> getVerticalClickedEvent() {
        return this.verticalClickedEvent;
    }

    @NotNull
    public final List<VerticalItem> getVerticals() {
        return this.verticals;
    }

    @NotNull
    public final LiveData<Boolean> isLoadingVisible() {
        return this.isLoadingVisible;
    }

    public final boolean isSecondaryBanner(@NotNull TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(templateUiData, "collectionData");
        if (getComponentOrNull(templateUiData.getMetadata()) == Component.SECONDARY_BANNER) {
            return true;
        }
        return false;
    }

    @NotNull
    public final LiveData<Boolean> isToolBarHidden() {
        return this.isToolBarHidden;
    }

    public final void onClick(@NotNull String str, @NotNull TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(templateUiData, "data");
        Component componentOrNull = getComponentOrNull(templateUiData.getMetadata());
        if (componentOrNull != null) {
            handleComponentClick(componentOrNull, str, toStringMap(templateUiData.getMetadata()));
        } else {
            LogManager.error$default((Throwable) null, "No component declared in metadata", 1, (Object) null);
        }
    }

    public final void onComponentSwiped(int i11, @NotNull TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(templateUiData, GemAccessor.COMPONENT_COLLECTION);
        if (!isPastOrdersSwimLane(templateUiData) && !isSecondaryBanner(templateUiData) && !isGroceryCategoriesComponent(templateUiData)) {
            onSwiped(CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i11)), templateUiData);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onGemExpired() {
        /*
            r10 = this;
            androidx.lifecycle.MutableLiveData<java.util.List<com.deliveryhero.fluid.widgets.collections.list.ListCell>> r0 = r10._components
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0012
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r0)
            if (r0 != 0) goto L_0x0017
        L_0x0012:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0017:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x002a
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x002a
        L_0x0028:
            r1 = r3
            goto L_0x0050
        L_0x002a:
            java.util.Iterator r1 = r0.iterator()
        L_0x002e:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0028
            java.lang.Object r4 = r1.next()
            com.deliveryhero.fluid.widgets.collections.list.ListCell r4 = (com.deliveryhero.fluid.widgets.collections.list.ListCell) r4
            com.deliveryhero.fluid.template.data.TemplateUiData r4 = r4.getData()
            java.util.Map r4 = r4.getMetadata()
            com.talabat.fluid.homescreen.presentation.displaymodel.Component r4 = r10.getComponentOrNull(r4)
            com.talabat.fluid.homescreen.presentation.displaymodel.Component r5 = com.talabat.fluid.homescreen.presentation.displaymodel.Component.GEM
            if (r4 != r5) goto L_0x004c
            r4 = r2
            goto L_0x004d
        L_0x004c:
            r4 = r3
        L_0x004d:
            if (r4 == 0) goto L_0x002e
            r1 = r2
        L_0x0050:
            if (r1 == 0) goto L_0x0095
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r4 = r10.homeScreenPerformanceObservability
            r4.generateTraceId()
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability$Level r5 = com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.Level.INFO
            java.lang.String r6 = "fluidHomeScreenViewModel.onGemExpired"
            r7 = 0
            r8 = 4
            r9 = 0
            com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability.DefaultImpls.traceEvent$default(r4, r5, r6, r7, r8, r9)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x006a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0090
            java.lang.Object r4 = r0.next()
            r5 = r4
            com.deliveryhero.fluid.widgets.collections.list.ListCell r5 = (com.deliveryhero.fluid.widgets.collections.list.ListCell) r5
            com.deliveryhero.fluid.template.data.TemplateUiData r5 = r5.getData()
            java.util.Map r5 = r5.getMetadata()
            com.talabat.fluid.homescreen.presentation.displaymodel.Component r5 = r10.getComponentOrNull(r5)
            com.talabat.fluid.homescreen.presentation.displaymodel.Component r6 = com.talabat.fluid.homescreen.presentation.displaymodel.Component.GEM
            if (r5 == r6) goto L_0x0089
            r5 = r2
            goto L_0x008a
        L_0x0089:
            r5 = r3
        L_0x008a:
            if (r5 == 0) goto L_0x006a
            r1.add(r4)
            goto L_0x006a
        L_0x0090:
            androidx.lifecycle.MutableLiveData<java.util.List<com.deliveryhero.fluid.widgets.collections.list.ListCell>> r0 = r10._components
            r0.postValue(r1)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel.onGemExpired():void");
    }

    public final void onLeavingHomeTab() {
        this.trackHeroCarouselSlideUseCase.pauseTracking();
    }

    public final void onPause() {
        this.trackHeroCarouselSlideUseCase.pauseTracking();
    }

    public final void onResume() {
        this.trackHeroCarouselSlideUseCase.resumeTracking();
    }

    public final void onReturningToHomeTab() {
        this.trackHeroCarouselSlideUseCase.resumeTracking();
    }

    public final void onScreenScrolled(int i11) {
        changeHeaderColour(i11);
    }

    public final void onStop() {
        resetTrackingCache();
    }

    public final void onSwiped(@NotNull List<Integer> list, @NotNull TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(list, VerticalItemViewEntityMapperKt.ITEM_POSITION_KEY);
        Intrinsics.checkNotNullParameter(templateUiData, GemAccessor.COMPONENT_COLLECTION);
        Component componentOrNull = getComponentOrNull(templateUiData.getMetadata());
        if (componentOrNull == null || !(!list.isEmpty())) {
            LogManager.error$default((Throwable) null, "No component declared in metadata", 1, (Object) null);
        } else {
            handleComponentSwiped(list, componentOrNull, toStringMap(templateUiData.getMetadata()), SequencesKt___SequencesKt.toList(retrieveCellsIfExists(templateUiData.getPlaceholderValues())));
        }
    }

    @NotNull
    public final Job onViewModelCreated() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.exceptionHandler, (CoroutineStart) null, new FluidHomeScreenViewModel$onViewModelCreated$1(this, (Continuation<? super FluidHomeScreenViewModel$onViewModelCreated$1>) null), 2, (Object) null);
    }

    public final void setVerticals(@NotNull List<VerticalItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.verticals = list;
    }

    public final void trackSecondaryBannerShown(@NotNull ListCell listCell) {
        Intrinsics.checkNotNullParameter(listCell, "listCell");
        this.trackSecondaryBannerUseCases.trackSecondaryBannerShown(toStringMap(listCell.getData().getMetadata()));
    }

    public FluidHomeScreenViewModel(@NotNull FetchHomeCollectionsUseCase fetchHomeCollectionsUseCase2, @NotNull ShouldRateLastOrderUseCase shouldRateLastOrderUseCase2, @NotNull ShowItemReplacementBottomSheetUseCase showItemReplacementBottomSheetUseCase, @NotNull TrackHeroComponentLoadUseCase trackHeroComponentLoadUseCase2, @NotNull TrackHeroComponentClickedUseCase trackHeroComponentClickedUseCase2, @NotNull TrackBannerSlideUseCase trackBannerSlideUseCase2, @NotNull TrackHeroCarouselSlideUseCase trackHeroCarouselSlideUseCase2, @NotNull TrackBannerComponentClickedUseCase trackBannerComponentClickedUseCase2, @NotNull TrackOrderStatusLoadUseCase trackOrderStatusLoadUseCase2, @NotNull VerticalItemViewEntityMapper verticalItemViewEntityMapper2, @NotNull TrackEntryPointClicked trackEntryPointClicked2, @NotNull TrackShopClickedUseCase trackShopClickedUseCase2, @NotNull TrackShortCutsUseCase trackShortCutsUseCase2, @NotNull BannerAdItemMapper bannerAdItemMapper2, @NotNull OrderStatusDataMapper orderStatusDataMapper2, @NotNull TrackSwimLaneUseCase trackSwimLaneUseCase2, @NotNull TrackVoucherCodeEntryUseCase trackVoucherCodeEntryUseCase2, @NotNull UpdateSelectedRestaurantUseCaseImpl updateSelectedRestaurantUseCaseImpl, @NotNull SwimLaneItemMapper swimLaneItemMapper2, @NotNull CollectionItemMapper collectionItemMapper2, @NotNull Function0<Unit> function0, @NotNull IObservabilityManager iObservabilityManager, @NotNull VoucherCampaignCacheUseCase voucherCampaignCacheUseCase2, @NotNull TrackSecondaryBannerUseCases trackSecondaryBannerUseCases2, @NotNull StopHomeScreenTraceUseCase stopHomeScreenTraceUseCase2, @NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability2, @NotNull TrackGroceryCategoriesUseCase trackGroceryCategoriesUseCase2) {
        FetchHomeCollectionsUseCase fetchHomeCollectionsUseCase3 = fetchHomeCollectionsUseCase2;
        ShouldRateLastOrderUseCase shouldRateLastOrderUseCase3 = shouldRateLastOrderUseCase2;
        ShowItemReplacementBottomSheetUseCase showItemReplacementBottomSheetUseCase2 = showItemReplacementBottomSheetUseCase;
        TrackHeroComponentLoadUseCase trackHeroComponentLoadUseCase3 = trackHeroComponentLoadUseCase2;
        TrackHeroComponentClickedUseCase trackHeroComponentClickedUseCase3 = trackHeroComponentClickedUseCase2;
        TrackBannerSlideUseCase trackBannerSlideUseCase3 = trackBannerSlideUseCase2;
        TrackHeroCarouselSlideUseCase trackHeroCarouselSlideUseCase3 = trackHeroCarouselSlideUseCase2;
        TrackBannerComponentClickedUseCase trackBannerComponentClickedUseCase3 = trackBannerComponentClickedUseCase2;
        TrackOrderStatusLoadUseCase trackOrderStatusLoadUseCase3 = trackOrderStatusLoadUseCase2;
        VerticalItemViewEntityMapper verticalItemViewEntityMapper3 = verticalItemViewEntityMapper2;
        TrackEntryPointClicked trackEntryPointClicked3 = trackEntryPointClicked2;
        TrackShopClickedUseCase trackShopClickedUseCase3 = trackShopClickedUseCase2;
        TrackShortCutsUseCase trackShortCutsUseCase3 = trackShortCutsUseCase2;
        BannerAdItemMapper bannerAdItemMapper3 = bannerAdItemMapper2;
        TrackSwimLaneUseCase trackSwimLaneUseCase3 = trackSwimLaneUseCase2;
        Intrinsics.checkNotNullParameter(fetchHomeCollectionsUseCase3, "fetchHomeCollectionsUseCase");
        Intrinsics.checkNotNullParameter(shouldRateLastOrderUseCase3, "shouldRateLastOrderUseCase");
        Intrinsics.checkNotNullParameter(showItemReplacementBottomSheetUseCase2, "showItemReplacementBsUseCase");
        Intrinsics.checkNotNullParameter(trackHeroComponentLoadUseCase3, "trackHeroComponentLoadUseCase");
        Intrinsics.checkNotNullParameter(trackHeroComponentClickedUseCase3, "trackHeroComponentClickedUseCase");
        Intrinsics.checkNotNullParameter(trackBannerSlideUseCase3, "trackBannerSlideUseCase");
        Intrinsics.checkNotNullParameter(trackHeroCarouselSlideUseCase3, "trackHeroCarouselSlideUseCase");
        Intrinsics.checkNotNullParameter(trackBannerComponentClickedUseCase3, "trackBannerComponentClickedUseCase");
        Intrinsics.checkNotNullParameter(trackOrderStatusLoadUseCase3, "trackOrderStatusLoadUseCase");
        Intrinsics.checkNotNullParameter(verticalItemViewEntityMapper3, "verticalItemViewEntityMapper");
        Intrinsics.checkNotNullParameter(trackEntryPointClicked3, "trackEntryPointClicked");
        Intrinsics.checkNotNullParameter(trackShopClickedUseCase3, "trackShopClickedUseCase");
        Intrinsics.checkNotNullParameter(trackShortCutsUseCase3, "trackShortCutsUseCase");
        Intrinsics.checkNotNullParameter(bannerAdItemMapper3, "bannerAdItemMapper");
        Intrinsics.checkNotNullParameter(orderStatusDataMapper2, "orderStatusDataMapper");
        Intrinsics.checkNotNullParameter(trackSwimLaneUseCase2, "trackSwimLaneUseCase");
        Intrinsics.checkNotNullParameter(trackVoucherCodeEntryUseCase2, "trackVoucherCodeEntryUseCase");
        Intrinsics.checkNotNullParameter(updateSelectedRestaurantUseCaseImpl, "updateSelectedRestaurantUseCase");
        Intrinsics.checkNotNullParameter(swimLaneItemMapper2, "swimLaneItemMapper");
        Intrinsics.checkNotNullParameter(collectionItemMapper2, "collectionItemMapper");
        Intrinsics.checkNotNullParameter(function0, "homeMapRedirectSetter");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(voucherCampaignCacheUseCase2, "voucherCampaignCacheUseCase");
        Intrinsics.checkNotNullParameter(trackSecondaryBannerUseCases2, "trackSecondaryBannerUseCases");
        Intrinsics.checkNotNullParameter(stopHomeScreenTraceUseCase2, "stopHomeScreenTraceUseCase");
        Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability2, "homeScreenPerformanceObservability");
        Intrinsics.checkNotNullParameter(trackGroceryCategoriesUseCase2, "trackGroceryCategoriesUseCase");
        this.fetchHomeCollectionsUseCase = fetchHomeCollectionsUseCase3;
        this.shouldRateLastOrderUseCase = shouldRateLastOrderUseCase3;
        this.showItemReplacementBsUseCase = showItemReplacementBottomSheetUseCase2;
        this.trackHeroComponentLoadUseCase = trackHeroComponentLoadUseCase3;
        this.trackHeroComponentClickedUseCase = trackHeroComponentClickedUseCase3;
        this.trackBannerSlideUseCase = trackBannerSlideUseCase3;
        this.trackHeroCarouselSlideUseCase = trackHeroCarouselSlideUseCase3;
        this.trackBannerComponentClickedUseCase = trackBannerComponentClickedUseCase3;
        this.trackOrderStatusLoadUseCase = trackOrderStatusLoadUseCase3;
        this.verticalItemViewEntityMapper = verticalItemViewEntityMapper3;
        this.trackEntryPointClicked = trackEntryPointClicked3;
        this.trackShopClickedUseCase = trackShopClickedUseCase3;
        this.trackShortCutsUseCase = trackShortCutsUseCase3;
        this.bannerAdItemMapper = bannerAdItemMapper3;
        this.orderStatusDataMapper = orderStatusDataMapper2;
        this.trackSwimLaneUseCase = trackSwimLaneUseCase2;
        this.trackVoucherCodeEntryUseCase = trackVoucherCodeEntryUseCase2;
        this.updateSelectedRestaurantUseCase = updateSelectedRestaurantUseCaseImpl;
        this.swimLaneItemMapper = swimLaneItemMapper2;
        this.collectionItemMapper = collectionItemMapper2;
        this.homeMapRedirectSetter = function0;
        this.observabilityManager = iObservabilityManager;
        this.voucherCampaignCacheUseCase = voucherCampaignCacheUseCase2;
        this.trackSecondaryBannerUseCases = trackSecondaryBannerUseCases2;
        this.stopHomeScreenTraceUseCase = stopHomeScreenTraceUseCase2;
        this.homeScreenPerformanceObservability = homeScreenPerformanceObservability2;
        this.trackGroceryCategoriesUseCase = trackGroceryCategoriesUseCase2;
        this.exceptionHandler = new FluidHomeScreenViewModel$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
        MutableLiveData<List<ListCell>> mutableLiveData = new MutableLiveData<>();
        this._components = mutableLiveData;
        SingleLiveEvent<Configuration> singleLiveEvent = new SingleLiveEvent<>();
        this._configuration = singleLiveEvent;
        SingleLiveEvent<HeaderColour> singleLiveEvent2 = new SingleLiveEvent<>();
        this._transitionHeaderColour = singleLiveEvent2;
        SingleLiveEvent<Boolean> singleLiveEvent3 = new SingleLiveEvent<>();
        this._isLoadingVisible = singleLiveEvent3;
        SingleLiveEvent<Boolean> singleLiveEvent4 = new SingleLiveEvent<>();
        this._isToolBarHidden = singleLiveEvent4;
        this.components = mutableLiveData;
        this.configuration = singleLiveEvent;
        this.transitionHeaderColour = singleLiveEvent2;
        this.isLoadingVisible = singleLiveEvent3;
        this.isToolBarHidden = singleLiveEvent4;
        this.verticals = CollectionsKt__CollectionsKt.emptyList();
        SingleLiveEvent<String> singleLiveEvent5 = new SingleLiveEvent<>();
        this._shouldShowRatingBottomSheet = singleLiveEvent5;
        SingleLiveEvent<String> singleLiveEvent6 = new SingleLiveEvent<>();
        this._handleDeepLinkEvent = singleLiveEvent6;
        SingleLiveEvent<EntryPointItem> singleLiveEvent7 = new SingleLiveEvent<>();
        this._verticalClickedEvent = singleLiveEvent7;
        SingleLiveEvent<BannerAdItem> singleLiveEvent8 = new SingleLiveEvent<>();
        this._bannerClickEvent = singleLiveEvent8;
        SingleLiveEvent<SwimLaneEvent> singleLiveEvent9 = new SingleLiveEvent<>();
        this._swimLaneClickedEvent = singleLiveEvent9;
        SingleLiveEvent<CollectionItem> singleLiveEvent10 = new SingleLiveEvent<>();
        this._collectionClickedEvent = singleLiveEvent10;
        SingleLiveEvent<ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo> singleLiveEvent11 = new SingleLiveEvent<>();
        this._shouldShowItemReplacementBottomSheet = singleLiveEvent11;
        this.shouldShowRatingBottomSheet = singleLiveEvent5;
        this.handleDeepLinkEvent = singleLiveEvent6;
        this.verticalClickedEvent = singleLiveEvent7;
        this.bannerClickEvent = singleLiveEvent8;
        this.swimLaneClickedEvent = singleLiveEvent9;
        this.collectionClickedEvent = singleLiveEvent10;
        this.shouldShowItemReplacementBottomSheet = singleLiveEvent11;
        onViewModelCreated();
    }
}
