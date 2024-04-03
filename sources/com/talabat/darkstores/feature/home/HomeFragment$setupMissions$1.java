package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.HomeRecyclerViewItem;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionView;
import com.talabat.feature.mission.control.presentation.PrimaryMissionView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$setupMissions$1 extends Lambda implements Function1<Pair<? extends Vendor, ? extends Boolean>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56404g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$setupMissions$1(HomeFragment homeFragment) {
        super(1);
        this.f56404g = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<Vendor, Boolean>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Pair<Vendor, Boolean> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        Vendor component1 = pair.component1();
        boolean booleanValue = pair.component2().booleanValue();
        if (this.f56404g.getViewModel().shouldBuildUIUsingRecyclerView()) {
            if (!this.f56404g.getViewModel().isLifestyleMissionV2()) {
                this.f56404g.homeItemList.add(new HomeRecyclerViewItem.LifeStyleMissionV1Item(new MissionItemData(component1.getVendorId(), component1.getVendorCode(), !booleanValue, new Function2<String, String, Unit>(this.f56404g.getViewModel()) {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((String) obj, (String) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull String str, @NotNull String str2) {
                        Intrinsics.checkNotNullParameter(str, "p0");
                        Intrinsics.checkNotNullParameter(str2, "p1");
                        ((HomeFragmentViewModel) this.receiver).onLifestyleMissionControlClicked(str, str2);
                    }
                })));
            }
            this.f56404g.homeItemList.add(new HomeRecyclerViewItem.PrimaryMissionItem(new MissionItemData(component1.getVendorId(), component1.getVendorCode(), !booleanValue, new Function2<String, String, Unit>(this.f56404g.getViewModel()) {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str, "p0");
                    Intrinsics.checkNotNullParameter(str2, "p1");
                    ((HomeFragmentViewModel) this.receiver).onPrimaryMissionControlClicked(str, str2);
                }
            })));
            this.f56404g.submitHomeItemList();
            return;
        }
        if (!this.f56404g.getViewModel().isLifestyleMissionV2()) {
            ((LifeStyleMissionView) this.f56404g._$_findCachedViewById(R.id.lifeStyleMission)).load(component1.getVendorId(), component1.getVendorCode(), !booleanValue, new Function2<String, String, Unit>(this.f56404g.getViewModel()) {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str, "p0");
                    Intrinsics.checkNotNullParameter(str2, "p1");
                    ((HomeFragmentViewModel) this.receiver).onLifestyleMissionControlClicked(str, str2);
                }
            });
        }
        if (!this.f56404g.getViewModel().shouldShowTopAndMidCompactSwimlanesInsteadOfPrimaryMissions()) {
            ((PrimaryMissionView) this.f56404g._$_findCachedViewById(R.id.primaryMissionView)).load(component1.getVendorId(), component1.getVendorCode(), !booleanValue, new Function2<String, String, Unit>(this.f56404g.getViewModel()) {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str, "p0");
                    Intrinsics.checkNotNullParameter(str2, "p1");
                    ((HomeFragmentViewModel) this.receiver).onPrimaryMissionControlClicked(str, str2);
                }
            });
        }
    }
}
