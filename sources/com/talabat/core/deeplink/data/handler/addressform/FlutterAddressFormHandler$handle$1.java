package com.talabat.core.deeplink.data.handler.addressform;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FlutterAddressFormHandler$handle$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f55807g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlutterAddressFormHandler$handle$1(String str) {
        super(1);
        this.f55807g = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$navigateTo");
        intent.putExtra("talabatDeliveryAvailable", true);
        intent.putExtra("newaddressCreation", true);
        intent.putExtra("isAddressFromCartOrderFlow", true);
        intent.putExtra("isNewAddressCreationFromGrlFlow", true);
        intent.putExtra("address", "");
        intent.putExtra("isGlrEnabledRes", false);
        intent.putExtra("isFromHomeScreenMap", true);
        intent.putExtra("from", "Cart Screen");
        intent.putExtra("value", "");
        intent.putExtra("map_compulsory", true);
        intent.putExtra("isNewAddressFromCartOrderFlow", true);
        intent.putExtra("isFromMcdAddressFlow", false);
        intent.putExtra("nineCookiesEnabled", true);
        intent.putExtra("noAreaChange", true);
        intent.putExtra("isUpdateNowSelected", false);
        intent.putExtra("isFromFlutter", true);
        intent.putExtra("eventOrigin", this.f55807g);
    }
}
