package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "key", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentThreeDsFragment$navigateToResponseScreen$1 extends Lambda implements Function2<String, FragmentActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f11988g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletPaymentThreeDsFragment$navigateToResponseScreen$1(Intent intent) {
        super(2);
        this.f11988g = intent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (FragmentActivity) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull FragmentActivity fragmentActivity) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Navigator.Companion companion = Navigator.Companion;
        Intent intent = this.f11988g;
        if (intent == null || (bundle = intent.getExtras()) == null) {
            bundle = new Bundle();
        }
        companion.navigate((Context) fragmentActivity, new NavigatorModel(str, bundle, AnonymousClass1.INSTANCE));
    }
}
