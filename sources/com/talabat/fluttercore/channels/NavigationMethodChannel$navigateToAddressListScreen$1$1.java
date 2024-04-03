package com.talabat.fluttercore.channels;

import android.content.Intent;
import com.talabat.helpers.GlobalConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavigationMethodChannel$navigateToAddressListScreen$1$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f59768g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationMethodChannel$navigateToAddressListScreen$1$1(boolean z11) {
        super(1);
        this.f59768g = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$$receiver");
        intent.putExtra(GlobalConstants.ExtraNames.ISFORSELECTION, true);
        intent.putExtra("isOrderFlow", true);
        intent.putExtra("isFromCheckout", true);
        intent.putExtra("noAreaChange", true);
        intent.putExtra("isFromFlutter", true);
        intent.putExtra(NavigationMethodChannel.SHOW_ADD_ADDRESS_BUTTON, this.f59768g);
        intent.putExtra(GlobalConstants.FORCE_MAP.IS_ADD_ADDRESS_FROM_CHECKOUT, true);
    }
}
