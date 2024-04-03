package com.talabat.feature.nfvinvendorsearch.presentation.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class QCommerceFlutterActivity$configurationParams$2 extends Lambda implements Function0<FlutterConfigurationParams> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ QCommerceFlutterActivity f58617g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QCommerceFlutterActivity$configurationParams$2(QCommerceFlutterActivity qCommerceFlutterActivity) {
        super(0);
        this.f58617g = qCommerceFlutterActivity;
    }

    @NotNull
    public final FlutterConfigurationParams invoke() {
        Bundle extras;
        Parcelable parcelable;
        Intent intent = this.f58617g.getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras.getParcelable(Constants.ARG_CONFIGURATION_PARAMS, FlutterConfigurationParams.class);
            } else {
                parcelable = extras.getParcelable(Constants.ARG_CONFIGURATION_PARAMS);
            }
            FlutterConfigurationParams flutterConfigurationParams = (FlutterConfigurationParams) parcelable;
            if (flutterConfigurationParams != null) {
                return flutterConfigurationParams;
            }
        }
        throw new IllegalArgumentException("FlutterConfigurationParams should be passed");
    }
}
