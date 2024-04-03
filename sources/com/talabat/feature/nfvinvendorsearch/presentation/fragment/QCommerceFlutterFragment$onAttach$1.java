package com.talabat.feature.nfvinvendorsearch.presentation.fragment;

import androidx.activity.OnBackPressedCallback;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/feature/nfvinvendorsearch/presentation/fragment/QCommerceFlutterFragment$onAttach$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceFlutterFragment$onAttach$1 extends OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QCommerceFlutterFragment f58623a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QCommerceFlutterFragment$onAttach$1(QCommerceFlutterFragment qCommerceFlutterFragment) {
        super(true);
        this.f58623a = qCommerceFlutterFragment;
    }

    public void handleOnBackPressed() {
        NavigationChannel navigationChannel;
        FlutterEngine flutterEngine = this.f58623a.getFlutterEngine();
        if (flutterEngine != null && (navigationChannel = flutterEngine.getNavigationChannel()) != null) {
            navigationChannel.popRoute();
        }
    }
}
