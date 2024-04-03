package com.talabat.core.deeplink.data.handler.addressform;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FlutterAddAddressFormHandler$handle$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f55803g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f55804h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f55805i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f55806j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlutterAddAddressFormHandler$handle$1(String str, String str2, String str3, String str4) {
        super(1);
        this.f55803g = str;
        this.f55804h = str2;
        this.f55805i = str3;
        this.f55806j = str4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$navigateTo");
        intent.putExtra("origin", this.f55803g);
        intent.putExtra("latitude", this.f55804h);
        intent.putExtra("longitude", this.f55805i);
        intent.putExtra("vendorId", this.f55806j);
    }
}
