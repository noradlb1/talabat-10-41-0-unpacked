package com.talabat.home;

import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$iniThirdPartyGlobal$1 extends Lambda implements Function1<Boolean, Unit> {
    public static final HomeScreenActivity$iniThirdPartyGlobal$1 INSTANCE = new HomeScreenActivity$iniThirdPartyGlobal$1();

    public HomeScreenActivity$iniThirdPartyGlobal$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        GlobalDataModel.FunWithFlag.FunWithFlagChangeRetrofitBaseUrl = z11;
    }
}
