package com.talabat.home;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$onCreate$3 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60884g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$onCreate$3(HomeScreenActivity homeScreenActivity) {
        super(0);
        this.f60884g = homeScreenActivity;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(IsLocationAllowedProvider.INSTANCE.isLocationAllowed(this.f60884g));
    }
}
