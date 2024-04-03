package com.talabat.splash.core.navigation;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Navigator$openChooseCountryScreen$1$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Navigator f61439g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f61440h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Boolean f61441i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Boolean f61442j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Navigator$openChooseCountryScreen$1$1(Navigator navigator, int i11, Boolean bool, Boolean bool2) {
        super(1);
        this.f61439g = navigator;
        this.f61440h = i11;
        this.f61441i = bool;
        this.f61442j = bool2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$null");
        Intent unused = this.f61439g.welcomeIntent(intent, this.f61440h, this.f61441i, this.f61442j);
    }
}
