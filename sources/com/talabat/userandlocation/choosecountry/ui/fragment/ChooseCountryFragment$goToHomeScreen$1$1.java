package com.talabat.userandlocation.choosecountry.ui.fragment;

import android.content.Intent;
import com.talabat.helpers.GlobalConstants;
import com.talabat.userandlocation.choosecountry.presentation.Extras;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChooseCountryFragment$goToHomeScreen$1$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Extras f12266g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseCountryFragment$goToHomeScreen$1$1(Extras extras) {
        super(1);
        this.f12266g = extras;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$null");
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_LOCATION_WELCOME, this.f12266g.isFromLocationWelcomeScreen());
        intent.putExtra(GlobalConstants.ExtraNames.IS_LOAD_MAP_FROM_WELCOME, this.f12266g.isLoadMapFromWelcome());
        intent.putExtra("is_show_map_search", this.f12266g.isShowMapSearch());
        intent.putExtra(GlobalConstants.ExtraNames.SHOULD_FORCE_LOCATION_IN_HOME, this.f12266g.getShouldForceLocationSelection());
    }
}
