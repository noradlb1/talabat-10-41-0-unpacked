package com.talabat.feature.walletaddcard.presentation;

import com.talabat.talabatcommon.databinding.ActivityWallet3dsWebViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/databinding/ActivityWallet3dsWebViewBinding;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Wallet3DsActivity$binding$2 extends Lambda implements Function0<ActivityWallet3dsWebViewBinding> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Wallet3DsActivity f59434g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Wallet3DsActivity$binding$2(Wallet3DsActivity wallet3DsActivity) {
        super(0);
        this.f59434g = wallet3DsActivity;
    }

    @NotNull
    public final ActivityWallet3dsWebViewBinding invoke() {
        ActivityWallet3dsWebViewBinding inflate = ActivityWallet3dsWebViewBinding.inflate(this.f59434g.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }
}
