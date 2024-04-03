package com.talabat.feature.pickup.presentation;

import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_bottom_sheet_v2.DSFragmentManagerExtensionsKt;
import com.talabat.feature.pickup.data.events.valuePropBanner.ValuePropBannerClicked;
import com.talabat.feature.pickup.data.events.valuePropBanner.ValuePropSheetLoaded;
import com.talabat.feature.pickup.presentation.adapters.ValuePropBannerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupActivity$valuePropBannerAdapter$2 extends Lambda implements Function0<ValuePropBannerAdapter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f58659g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupActivity$valuePropBannerAdapter$2(PickupActivity pickupActivity) {
        super(0);
        this.f58659g = pickupActivity;
    }

    @NotNull
    public final ValuePropBannerAdapter invoke() {
        final PickupActivity pickupActivity = this.f58659g;
        return new ValuePropBannerAdapter(new Function0<Unit>() {
            public final void invoke() {
                pickupActivity.getTracker().track(ValuePropBannerClicked.INSTANCE);
                pickupActivity.getTracker().track(ValuePropSheetLoaded.INSTANCE);
                FragmentManager supportFragmentManager = pickupActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                DSBottomSheet findDSBottomSheet = DSFragmentManagerExtensionsKt.findDSBottomSheet(supportFragmentManager, ValuePropFragment.TAG);
                if (findDSBottomSheet == null) {
                    findDSBottomSheet = new DSBottomSheet();
                }
                findDSBottomSheet.setBody(new ValuePropFragment());
                findDSBottomSheet.show(pickupActivity.getSupportFragmentManager(), ValuePropFragment.TAG);
            }
        });
    }
}
