package com.talabat.feature.unwrapped.presentation;

import com.talabat.feature.unwrapped.presentation.channels.UnwrappedMethodCallHandler;
import com.talabat.feature.unwrapped.presentation.channels.UnwrappedMethodChannelCallback;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/unwrapped/presentation/UnwrappedFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "Lcom/talabat/feature/unwrapped/presentation/channels/UnwrappedMethodChannelCallback;", "()V", "unwrappedMethodChannel", "Lio/flutter/plugin/common/MethodChannel;", "close", "", "getRoute", "", "getSource", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "Companion", "com_talabat_feature_unwrapped_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnwrappedFlutterActivity extends TalabatFlutterFragmentActivity implements UnwrappedMethodChannelCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String UNWRAPPED_METHOD_CHANNEL = "com.talabat.flutter/unwrapped";
    @NotNull
    public static final String UNWRAPPED_ROUTE = "/talabat-unwrapped";
    private MethodChannel unwrappedMethodChannel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/unwrapped/presentation/UnwrappedFlutterActivity$Companion;", "", "()V", "UNWRAPPED_METHOD_CHANNEL", "", "UNWRAPPED_ROUTE", "com_talabat_feature_unwrapped_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UnwrappedFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = (com.talabat.core.navigation.domain.screen.unwrapped.UnwrappedScreen.UnwrappedData) r0.getParcelableExtra("navigatorData");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getSource() {
        /*
            r2 = this;
            android.content.Intent r0 = r2.getIntent()
            if (r0 == 0) goto L_0x0015
            java.lang.String r1 = "navigatorData"
            android.os.Parcelable r0 = r0.getParcelableExtra(r1)
            com.talabat.core.navigation.domain.screen.unwrapped.UnwrappedScreen$UnwrappedData r0 = (com.talabat.core.navigation.domain.screen.unwrapped.UnwrappedScreen.UnwrappedData) r0
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = r0.getSource()
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 != 0) goto L_0x001a
            java.lang.String r0 = "deeplink"
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.unwrapped.presentation.UnwrappedFlutterActivity.getSource():java.lang.String");
    }

    public void close() {
        finish();
    }

    @NotNull
    public String getRoute() {
        String source = getSource();
        return "/talabat-unwrapped?source=" + source;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        this.unwrappedMethodChannel = new MethodChannel(flutterEngine.getDartExecutor(), UNWRAPPED_METHOD_CHANNEL);
        UnwrappedMethodCallHandler unwrappedMethodCallHandler = new UnwrappedMethodCallHandler();
        unwrappedMethodCallHandler.setCallback(this);
        MethodChannel methodChannel = this.unwrappedMethodChannel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unwrappedMethodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(unwrappedMethodCallHandler);
    }
}
