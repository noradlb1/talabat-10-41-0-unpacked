package com.talabat.offering.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.offering.domain.entities.Background;
import com.talabat.offering.domain.entities.CallToAction;
import com.talabat.offering.domain.entities.Header;
import com.talabat.offering.domain.entities.HeaderText;
import com.talabat.offering.domain.entities.OfferCollection;
import com.talabat.offering.domain.usecases.business.GetOfferCollectionUseCase;
import com.talabat.offering.presentation.displaymodel.HeaderDisplayModel;
import com.talabat.offering.presentation.viewmodel.mapper.OfferCollectionDisplayModelMapper;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.offering.presentation.viewmodel.OfferCollectionViewModel$getOfferCollectionData$1", f = "OfferCollectionViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class OfferCollectionViewModel$getOfferCollectionData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61141h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionViewModel f61142i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f61143j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ double f61144k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ double f61145l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionViewModel$getOfferCollectionData$1(OfferCollectionViewModel offerCollectionViewModel, int i11, double d11, double d12, Continuation<? super OfferCollectionViewModel$getOfferCollectionData$1> continuation) {
        super(2, continuation);
        this.f61142i = offerCollectionViewModel;
        this.f61143j = i11;
        this.f61144k = d11;
        this.f61145l = d12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OfferCollectionViewModel$getOfferCollectionData$1(this.f61142i, this.f61143j, this.f61144k, this.f61145l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OfferCollectionViewModel$getOfferCollectionData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Boolean bool;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61141h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetOfferCollectionUseCase access$getOfferCollectionUseCase$p = this.f61142i.offerCollectionUseCase;
            int i12 = this.f61143j;
            double d11 = this.f61144k;
            double d12 = this.f61145l;
            this.f61141h = 1;
            obj = access$getOfferCollectionUseCase$p.invoke(i12, d11, d12, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OfferCollection offerCollection = (OfferCollection) obj;
        if (offerCollection.getProductId() != null) {
            MutableLiveData<HeaderDisplayModel> headerViewData = this.f61142i.getHeaderViewData();
            OfferCollectionDisplayModelMapper offerCollectionDisplayModelMapper = OfferCollectionDisplayModelMapper.INSTANCE;
            HeaderText headerText = offerCollection.getHeaderText();
            CallToAction callToAction = offerCollection.getCallToAction();
            Header header = offerCollection.getHeader();
            String str = null;
            if (header != null) {
                bool = header.getHasTermsNCodn();
            } else {
                bool = null;
            }
            headerViewData.postValue(offerCollectionDisplayModelMapper.mapHeaderView(headerText, callToAction, bool, this.f61142i.getHeaderViewState().getValue()));
            this.f61142i.getPopupData().postValue(offerCollectionDisplayModelMapper.mapPopupData(offerCollection.getCallToAction()));
            MutableLiveData<HeaderDisplayModel> backgroundData = this.f61142i.getBackgroundData();
            Background background = offerCollection.getBackground();
            Header header2 = offerCollection.getHeader();
            if (header2 != null) {
                str = header2.getForegroundImg();
            }
            backgroundData.postValue(offerCollectionDisplayModelMapper.mapBackgroundView(background, str));
            this.f61142i.getVendors().postValue(offerCollectionDisplayModelMapper.mapVendorsView(offerCollection.getRestaurants()));
            this.f61142i.getPolygonQuickFilterData().setValue(new Pair(offerCollection.getPolygonEvents(), offerCollection.getFilter()));
            this.f61142i.getCTAStatus(offerCollection.getProductId());
        }
        return Unit.INSTANCE;
    }
}
