package com.talabat.growth.ui.loyalty.history;

import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"GA_SCREEN_NAME", "", "PAGE_SIZE", "", "setBackButtonWithAction", "", "Lcom/designsystem/ds_navigation_bar/DSNavigationBar;", "tabAction", "Lkotlin/Function0;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyHistoryFragmentKt {
    @NotNull
    private static final String GA_SCREEN_NAME = "Points History Screen";
    private static final int PAGE_SIZE = 20;

    /* access modifiers changed from: private */
    public static final void setBackButtonWithAction(DSNavigationBar dSNavigationBar, Function0<Unit> function0) {
        dSNavigationBar.setLeadingIconButton(new DSIconButtonModel(R.drawable.ds_arrow_back, function0));
    }
}
