package com.talabat.feature.nfvinvendorsearch.presentation.fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class QCommerceFlutterFragment$route$2 extends Lambda implements Function0<FlutterRoute> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ QCommerceFlutterFragment f58624g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QCommerceFlutterFragment$route$2(QCommerceFlutterFragment qCommerceFlutterFragment) {
        super(0);
        this.f58624g = qCommerceFlutterFragment;
    }

    @NotNull
    public final FlutterRoute invoke() {
        Parcelable parcelable;
        Bundle arguments = this.f58624g.getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable(Constants.ARG_ROUTE, FlutterRoute.class);
            } else {
                parcelable = arguments.getParcelable(Constants.ARG_ROUTE);
            }
            FlutterRoute flutterRoute = (FlutterRoute) parcelable;
            if (flutterRoute != null) {
                return flutterRoute;
            }
        }
        throw new IllegalArgumentException("Route should be passed");
    }
}
