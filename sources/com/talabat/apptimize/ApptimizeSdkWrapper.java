package com.talabat.apptimize;

import android.util.Log;
import com.apptimize.Apptimize;
import com.apptimize.ApptimizeVar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/apptimize/ApptimizeSdkWrapper;", "", "()V", "TAG", "", "getBooleanVariant", "", "experimentName", "defaultValue", "getDoubleVariant", "", "getIntVariant", "", "getStringVariant", "setAttribute", "", "attributeKey", "attributeValue", "setPilotTargetingId", "com_talabat_ThirdPartyLibs_Apptimize_Apptimize"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApptimizeSdkWrapper {
    @NotNull
    public static final ApptimizeSdkWrapper INSTANCE = new ApptimizeSdkWrapper();
    @NotNull
    public static final String TAG = "TalabatApptimize";

    private ApptimizeSdkWrapper() {
    }

    public final boolean getBooleanVariant(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        Boolean value = ApptimizeVar.createBoolean(str, Boolean.valueOf(z11)).value();
        Boolean bool = value;
        Log.i(TAG, "Apptimize BooleanVariant: experimentName: " + str + ", value: " + bool);
        Intrinsics.checkNotNullExpressionValue(value, "createBoolean(experiment…e, value: $it\")\n        }");
        return bool.booleanValue();
    }

    public final double getDoubleVariant(@NotNull String str, double d11) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        Double value = ApptimizeVar.createDouble(str, Double.valueOf(d11)).value();
        Log.i(TAG, "Apptimize DoubleVariant: experimentName: " + str + ", value: " + value);
        Intrinsics.checkNotNullExpressionValue(value, "createDouble(experimentN…e, value: $it\")\n        }");
        return value.doubleValue();
    }

    public final int getIntVariant(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        Integer value = ApptimizeVar.createInteger(str, Integer.valueOf(i11)).value();
        Log.i(TAG, "Apptimize IntVariant: experimentName: " + str + ", value: " + value);
        Intrinsics.checkNotNullExpressionValue(value, "createInteger(experiment…e, value: $it\")\n        }");
        return value.intValue();
    }

    @NotNull
    public final String getStringVariant(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        String value = ApptimizeVar.createString(str, str2).value();
        String str3 = value;
        Log.i(TAG, "Apptimize StringVariant: experimentName: " + str + ", value: " + str3);
        Intrinsics.checkNotNullExpressionValue(value, "createString(experimentN…e, value: $it\")\n        }");
        return str3;
    }

    public final void setAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "attributeKey");
        Intrinsics.checkNotNullParameter(str2, "attributeValue");
        Apptimize.setUserAttribute(str, str2);
        Unit unit = Unit.INSTANCE;
        Log.i(TAG, "Apptimize setUserAttribute: attributeKey: " + str + ", attributeValue: " + str2);
    }

    public final void setPilotTargetingId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "attributeValue");
        Apptimize.setPilotTargetingId(str);
        Unit unit = Unit.INSTANCE;
        Log.i(TAG, "Apptimize setPilotTargetingId: , attributeValue: " + str);
    }
}
