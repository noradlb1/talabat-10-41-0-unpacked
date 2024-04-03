package com.talabat.growth.ui.loyalty.guestUser;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyGuestUserFragment$setupUi$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoyaltyGuestUserFragment f60689g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyGuestUserFragment$setupUi$2(LoyaltyGuestUserFragment loyaltyGuestUserFragment) {
        super(0);
        this.f60689g = loyaltyGuestUserFragment;
    }

    public final void invoke() {
        FragmentActivity activity = this.f60689g.getActivity();
        if (activity != null) {
            Navigator.Companion companion = Navigator.Companion;
            Bundle bundle = new Bundle();
            bundle.putString("from", "rewards");
            Unit unit = Unit.INSTANCE;
            companion.navigate((Context) activity, new NavigatorModel(LegacyTalabatActions.OPEN_LOGIN_SCREEN_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
        }
    }
}
