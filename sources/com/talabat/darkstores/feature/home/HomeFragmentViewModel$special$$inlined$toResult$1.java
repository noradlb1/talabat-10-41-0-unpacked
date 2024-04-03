package com.talabat.darkstores.feature.home;

import android.util.Log;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.talabatcommon.extentions.StringUtils;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/common/Result;", "OutputType", "kotlin.jvm.PlatformType", "InputType", "", "it", "apply", "(Ljava/lang/Object;)Lcom/talabat/darkstores/common/Result;", "com/talabat/darkstores/common/ResultKt$toResult$3"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragmentViewModel$special$$inlined$toResult$1<T, R> implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragmentViewModel f56412b;

    public HomeFragmentViewModel$special$$inlined$toResult$1(HomeFragmentViewModel homeFragmentViewModel) {
        this.f56412b = homeFragmentViewModel;
    }

    public final Result<HomeFragmentData> apply(@NotNull FeedMultiListData feedMultiListData) {
        List<Swimlane> list;
        List<Swimlane> list2;
        Intrinsics.checkNotNullParameter(feedMultiListData, "it");
        FeedMultiListData feedMultiListData2 = feedMultiListData;
        String primaryMissionSwimlanesRequestId = feedMultiListData2.getPrimaryMissionSwimlanesRequestId();
        Log.i("HomeFragmentViewModel", "primaryMissionId: " + primaryMissionSwimlanesRequestId);
        Pair access$getCategories = this.f56412b.getCategories(feedMultiListData2.getCategories());
        List list3 = (List) access$getCategories.component1();
        List list4 = (List) access$getCategories.component2();
        SwimlanesTracker access$getSwimlanesTracker$p = this.f56412b.swimlanesTracker;
        String swimlaneRequestId = feedMultiListData2.getSwimlaneRequestId();
        Iterable<Swimlane> swimlanes = feedMultiListData2.getSwimlanes();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(swimlanes, 10));
        for (Swimlane headline : swimlanes) {
            arrayList.add(headline.getHeadline());
        }
        access$getSwimlanesTracker$p.swimlanesLoaded(swimlaneRequestId, arrayList, EventOriginType.VendorLanding, ScreenTrackingProvider.ScreenType.VENDOR_LANDING.getTrackingName(), ScreenTrackingProvider.ScreenName.VENDOR_LANDING.getTrackingName());
        boolean shouldShowTopAndMidCompactSwimlanesInsteadOfPrimaryMissions = this.f56412b.shouldShowTopAndMidCompactSwimlanesInsteadOfPrimaryMissions();
        if (shouldShowTopAndMidCompactSwimlanesInsteadOfPrimaryMissions) {
            SwimlanesTracker access$getSwimlanesTracker$p2 = this.f56412b.swimlanesTracker;
            String primaryMissionSwimlanesRequestId2 = feedMultiListData2.getPrimaryMissionSwimlanesRequestId();
            if (primaryMissionSwimlanesRequestId2 == null) {
                primaryMissionSwimlanesRequestId2 = StringUtils.empty(StringCompanionObject.INSTANCE);
            }
            String str = primaryMissionSwimlanesRequestId2;
            Iterable<Swimlane> plus = CollectionsKt___CollectionsKt.plus(feedMultiListData2.getTopSwimlanes(), feedMultiListData2.getHighlightedSwimlanes());
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10));
            for (Swimlane headline2 : plus) {
                arrayList2.add(headline2.getHeadline());
            }
            access$getSwimlanesTracker$p2.swimlanesLoaded(str, arrayList2, EventOriginType.VendorLanding, ScreenTrackingProvider.ScreenType.VENDOR_LANDING.getTrackingName(), ScreenTrackingProvider.ScreenName.VENDOR_LANDING.getTrackingName());
        }
        LifestyleMission lifestyleMission = feedMultiListData2.getLifestyleMission();
        List<Swimlane> swimlanes2 = feedMultiListData2.getSwimlanes();
        if (shouldShowTopAndMidCompactSwimlanesInsteadOfPrimaryMissions) {
            list = feedMultiListData2.getTopSwimlanes();
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List<Swimlane> list5 = list;
        if (shouldShowTopAndMidCompactSwimlanesInsteadOfPrimaryMissions) {
            list2 = feedMultiListData2.getHighlightedSwimlanes();
        } else {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return new Result.Success(new HomeFragmentData(list3, list4, lifestyleMission, swimlanes2, list5, list2));
    }
}
