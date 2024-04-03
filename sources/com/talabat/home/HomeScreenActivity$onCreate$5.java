package com.talabat.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "flutterHomeEnabled", "", "flutterAccountEnabled", "homeOfOffersEnabled", "flutterOrdersListEnabled", "isFlutterSearchEnabled", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$onCreate$5 extends Lambda implements Function5<Boolean, Boolean, Boolean, Boolean, Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60886g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$onCreate$5(HomeScreenActivity homeScreenActivity) {
        super(5);
        this.f60886g = homeScreenActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), ((Boolean) obj4).booleanValue(), ((Boolean) obj5).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f60886g.addFragment(z11, z12, z13, z14, z15);
    }
}
