package com.talabat.core.deeplink.data.handler.address;

import android.content.Intent;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.helpers.GlobalConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddressListHandler$handle$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f55796g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f55797h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f55798i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f55799j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f55800k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f55801l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f55802m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddressListHandler$handle$1(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
        super(1);
        this.f55796g = z11;
        this.f55797h = z12;
        this.f55798i = z13;
        this.f55799j = z14;
        this.f55800k = z15;
        this.f55801l = z16;
        this.f55802m = z17;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$navigateTo");
        intent.putExtra(GlobalConstants.ExtraNames.ISFORSELECTION, this.f55796g);
        intent.putExtra("isOrderFlow", this.f55797h);
        intent.putExtra("isFromCheckout", this.f55798i);
        intent.putExtra("noAreaChange", this.f55799j);
        intent.putExtra("isFromFlutter", this.f55800k);
        intent.putExtra(GlobalConstants.FORCE_MAP.IS_ADD_ADDRESS_FROM_CHECKOUT, this.f55801l);
        intent.putExtra(NavigationMethodChannel.SHOW_ADD_ADDRESS_BUTTON, this.f55802m);
    }
}
