package com.braze.brazeplugin;

import android.content.Context;
import com.braze.configuration.CachedConfigurationProvider;
import com.braze.configuration.RuntimeAppConfigurationProvider;
import com.braze.ui.inappmessage.InAppMessageOperation;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/braze/brazeplugin/FlutterCachedConfiguration;", "Lcom/braze/configuration/CachedConfigurationProvider;", "context", "Landroid/content/Context;", "useCache", "", "(Landroid/content/Context;Z)V", "automaticIntegrationInAppMessageOperation", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "isAutomaticInitializationEnabled", "Companion", "braze_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FlutterCachedConfiguration extends CachedConfigurationProvider {
    @NotNull
    private static final String AUTOMATIC_INTEGRATION_IAM_OPERATION = "com_braze_flutter_automatic_integration_iam_operation";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ENABLE_AUTOMATIC_INTEGRATION_INITIALIZER = "com_braze_flutter_enable_automatic_integration_initializer";
    @NotNull
    private static final Map<String, InAppMessageOperation> IAM_OPERATION_ENUM_MAP;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/braze/brazeplugin/FlutterCachedConfiguration$Companion;", "", "()V", "AUTOMATIC_INTEGRATION_IAM_OPERATION", "", "ENABLE_AUTOMATIC_INTEGRATION_INITIALIZER", "IAM_OPERATION_ENUM_MAP", "", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "braze_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InAppMessageOperation[] values = InAppMessageOperation.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(values.length), 16));
        for (InAppMessageOperation inAppMessageOperation : values) {
            linkedHashMap.put(inAppMessageOperation.name(), inAppMessageOperation);
        }
        IAM_OPERATION_ENUM_MAP = linkedHashMap;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlutterCachedConfiguration(@NotNull Context context, boolean z11) {
        super(context, z11, (RuntimeAppConfigurationProvider) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public final InAppMessageOperation automaticIntegrationInAppMessageOperation() {
        String str;
        String stringValue = getStringValue(AUTOMATIC_INTEGRATION_IAM_OPERATION, "");
        if (stringValue != null) {
            str = stringValue.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        } else {
            str = null;
        }
        InAppMessageOperation inAppMessageOperation = IAM_OPERATION_ENUM_MAP.get(str);
        if (inAppMessageOperation == null) {
            return InAppMessageOperation.DISPLAY_NOW;
        }
        return inAppMessageOperation;
    }

    public final boolean isAutomaticInitializationEnabled() {
        return getBooleanValue(ENABLE_AUTOMATIC_INTEGRATION_INITIALIZER, true);
    }
}
