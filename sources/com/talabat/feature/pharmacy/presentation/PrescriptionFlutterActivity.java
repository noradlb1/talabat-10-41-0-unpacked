package com.talabat.feature.pharmacy.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.talabat.feature.pharmacy.model.BannerData;
import com.talabat.feature.pharmacy.presentation.channel.PrescriptionChannelCallback;
import com.talabat.feature.pharmacy.presentation.channel.PrescriptionMethodCallHandler;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/pharmacy/presentation/PrescriptionFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/feature/pharmacy/presentation/channel/PrescriptionChannelCallback;", "()V", "bannerData", "Lcom/talabat/feature/pharmacy/model/BannerData;", "destination", "Lcom/talabat/feature/pharmacy/presentation/PrescriptionDestinations;", "backToHomeScreen", "", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getOrderDetails", "", "", "", "getRoute", "onBackPressed", "onBackPressedFromFlutter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTapToClose", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "Companion", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionFlutterActivity extends TalabatFlutterFragmentActivity implements PrescriptionChannelCallback {
    @NotNull
    private static final String BUNDLE_DETAILS_DATA = "PrescriptionFlutterActivity.DetailsDataMap";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DETAILS_DATA = "PrescriptionFlutterActivity.DetailsData";
    @NotNull
    private static final String DETSINATION = "PrescriptionFlutterActivity.Destination";
    @NotNull
    public static final String PRESCRIPTION_CHANNEL = "com.talabat.flutter/prescription";
    @Nullable
    private BannerData bannerData;
    @NotNull
    private PrescriptionDestinations destination = PrescriptionDestinations.MAIN;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/pharmacy/presentation/PrescriptionFlutterActivity$Companion;", "", "()V", "BUNDLE_DETAILS_DATA", "", "DETAILS_DATA", "DETSINATION", "PRESCRIPTION_CHANNEL", "openActivity", "", "context", "Landroid/app/Activity;", "destination", "Lcom/talabat/feature/pharmacy/presentation/PrescriptionDestinations;", "details", "Lcom/talabat/feature/pharmacy/model/BannerData;", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void openActivity$default(Companion companion, Activity activity, PrescriptionDestinations prescriptionDestinations, BannerData bannerData, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                bannerData = null;
            }
            companion.openActivity(activity, prescriptionDestinations, bannerData);
        }

        public final void openActivity(@NotNull Activity activity, @NotNull PrescriptionDestinations prescriptionDestinations, @Nullable BannerData bannerData) {
            Intrinsics.checkNotNullParameter(activity, "context");
            Intrinsics.checkNotNullParameter(prescriptionDestinations, "destination");
            Intent intent = new Intent(activity, PrescriptionFlutterActivity.class);
            intent.putExtra(PrescriptionFlutterActivity.DETSINATION, prescriptionDestinations);
            if (bannerData != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(PrescriptionFlutterActivity.BUNDLE_DETAILS_DATA, bannerData);
                Unit unit = Unit.INSTANCE;
                intent.putExtra(PrescriptionFlutterActivity.DETAILS_DATA, bundle);
            }
            activity.startActivity(intent);
        }
    }

    public PrescriptionFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    private final void backToHomeScreen() {
        finish();
    }

    @NotNull
    public TalabatFlutterEntryPoints getEntryPoint() {
        return this.destination.getEntryPoint();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.toMap();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.Object> getOrderDetails() {
        /*
            r1 = this;
            com.talabat.feature.pharmacy.model.BannerData r0 = r1.bannerData
            if (r0 == 0) goto L_0x000a
            java.util.Map r0 = r0.toMap()
            if (r0 != 0) goto L_0x000e
        L_0x000a:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.emptyMap()
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.pharmacy.presentation.PrescriptionFlutterActivity.getOrderDetails():java.util.Map");
    }

    @NotNull
    public String getRoute() {
        return this.destination.getRoute();
    }

    public void onBackPressed() {
        backToHomeScreen();
    }

    public void onBackPressedFromFlutter() {
        backToHomeScreen();
    }

    public void onCreate(@Nullable Bundle bundle) {
        Serializable serializable;
        Object obj;
        Bundle bundle2;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        BannerData bannerData2 = null;
        if (extras != null) {
            serializable = extras.getSerializable(DETSINATION);
        } else {
            serializable = null;
        }
        if (serializable != null) {
            this.destination = (PrescriptionDestinations) serializable;
            Bundle extras2 = getIntent().getExtras();
            if (extras2 == null || (bundle2 = extras2.getBundle(DETAILS_DATA)) == null) {
                obj = null;
            } else {
                obj = bundle2.getSerializable(BUNDLE_DETAILS_DATA);
            }
            if (obj instanceof BannerData) {
                bannerData2 = (BannerData) obj;
            }
            this.bannerData = bannerData2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.feature.pharmacy.presentation.PrescriptionDestinations");
    }

    public void onTapToClose() {
        finish();
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), PRESCRIPTION_CHANNEL).setMethodCallHandler(new PrescriptionMethodCallHandler(this));
    }
}
