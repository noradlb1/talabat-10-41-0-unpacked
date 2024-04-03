package com.talabat.darkstores.feature.cart;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.talabat.feature.nfvinvendorsearch.presentation.activity.QCommerceFlutterActivity;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragment$onCheckoutClicked$1 extends Lambda implements Function2<FlutterConfigurationParams, FlutterRoute, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragment f56251g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragment$onCheckoutClicked$1(CartFragment cartFragment) {
        super(2);
        this.f56251g = cartFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((FlutterConfigurationParams) obj, (FlutterRoute) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
        Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
        if (this.f56251g.isAdded()) {
            this.f56251g.getCartFragmentViewModel().saveBasketUpsellBottomSheetShown();
            ActivityResultLauncher access$getStartForResult$p = this.f56251g.startForResult;
            QCommerceFlutterActivity.Companion companion = QCommerceFlutterActivity.Companion;
            FragmentActivity requireActivity = this.f56251g.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            access$getStartForResult$p.launch(companion.getIntent(requireActivity, flutterConfigurationParams, flutterRoute, FlutterActivityLaunchConfigs.BackgroundMode.transparent));
        }
    }
}
