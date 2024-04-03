package com.talabat.fluttercore.channels;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import com.talabat.fluttercore.mappers.FWFProjectNameMapper;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u001c\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u001c\u0010\u000f\u001a\u00020\t2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/fluttercore/channels/ExperimentMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/fluttercore/channels/ExperimentMethodChannelCallback;", "getBooleanVariant", "", "arguments", "", "", "", "getDoubleVariant", "", "getIntVariant", "", "getStringVariant", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "experimentMethodChannelCallback", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExperimentMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private static final String ARGUMENT_KEY_DEFAULT_VALUE = "defaultValue";
    @NotNull
    private static final String ARGUMENT_KEY_EXPERIMENT_NAME = "experimentName";
    @NotNull
    private static final String ARGUMENT_KEY_STRATEGY = "strategy";
    @NotNull
    private static final String ARGUMENT_PROJECT_NAME = "project";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_BOOLEAN_VARIANT = "getBooleanVariant";
    @NotNull
    private static final String GET_DOUBLE_VARIANT = "getDoubleVariant";
    @NotNull
    private static final String GET_INT_VARIANT = "getIntVariant";
    @NotNull
    private static final String GET_STRING_VARIANT = "getStringVariant";
    @Nullable
    private ExperimentMethodChannelCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/fluttercore/channels/ExperimentMethodChannel$Companion;", "", "()V", "ARGUMENT_KEY_DEFAULT_VALUE", "", "ARGUMENT_KEY_EXPERIMENT_NAME", "ARGUMENT_KEY_STRATEGY", "ARGUMENT_PROJECT_NAME", "GET_BOOLEAN_VARIANT", "GET_DOUBLE_VARIANT", "GET_INT_VARIANT", "GET_STRING_VARIANT", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean getBooleanVariant(Map<String, ? extends Object> map) {
        String str;
        Object obj = map.get(ARGUMENT_PROJECT_NAME);
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        FWFProjectName fwfProjectFromProjectName = FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str);
        Object obj2 = map.get(ARGUMENT_KEY_EXPERIMENT_NAME);
        if (obj2 != null) {
            FWFKeyObject fWFKeyObject = new FWFKeyObject((String) obj2, fwfProjectFromProjectName);
            Object obj3 = map.get(ARGUMENT_KEY_DEFAULT_VALUE);
            if (obj3 != null) {
                boolean booleanValue = ((Boolean) obj3).booleanValue();
                Object obj4 = map.get("strategy");
                if (obj4 != null) {
                    Locale locale = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
                    String upperCase = ((String) obj4).toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    TalabatExperimentDataSourceStrategy valueOf = TalabatExperimentDataSourceStrategy.valueOf(upperCase);
                    ExperimentMethodChannelCallback experimentMethodChannelCallback = this.callback;
                    if (experimentMethodChannelCallback != null) {
                        return experimentMethodChannelCallback.getBooleanVariant(fWFKeyObject, booleanValue, valueOf);
                    }
                    return booleanValue;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final double getDoubleVariant(Map<String, ? extends Object> map) {
        String str;
        Object obj = map.get(ARGUMENT_PROJECT_NAME);
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        FWFProjectName fwfProjectFromProjectName = FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str);
        Object obj2 = map.get(ARGUMENT_KEY_EXPERIMENT_NAME);
        if (obj2 != null) {
            FWFKeyObject fWFKeyObject = new FWFKeyObject((String) obj2, fwfProjectFromProjectName);
            Object obj3 = map.get(ARGUMENT_KEY_DEFAULT_VALUE);
            if (obj3 != null) {
                double doubleValue = ((Double) obj3).doubleValue();
                Object obj4 = map.get("strategy");
                if (obj4 != null) {
                    Locale locale = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
                    String upperCase = ((String) obj4).toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    TalabatExperimentDataSourceStrategy valueOf = TalabatExperimentDataSourceStrategy.valueOf(upperCase);
                    ExperimentMethodChannelCallback experimentMethodChannelCallback = this.callback;
                    if (experimentMethodChannelCallback != null) {
                        return experimentMethodChannelCallback.getDoubleVariant(fWFKeyObject, doubleValue, valueOf);
                    }
                    return doubleValue;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final int getIntVariant(Map<String, ? extends Object> map) {
        String str;
        Object obj = map.get(ARGUMENT_PROJECT_NAME);
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        FWFProjectName fwfProjectFromProjectName = FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str);
        Object obj2 = map.get(ARGUMENT_KEY_EXPERIMENT_NAME);
        if (obj2 != null) {
            FWFKeyObject fWFKeyObject = new FWFKeyObject((String) obj2, fwfProjectFromProjectName);
            Object obj3 = map.get(ARGUMENT_KEY_DEFAULT_VALUE);
            if (obj3 != null) {
                int intValue = ((Integer) obj3).intValue();
                Object obj4 = map.get("strategy");
                if (obj4 != null) {
                    Locale locale = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
                    String upperCase = ((String) obj4).toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    TalabatExperimentDataSourceStrategy valueOf = TalabatExperimentDataSourceStrategy.valueOf(upperCase);
                    ExperimentMethodChannelCallback experimentMethodChannelCallback = this.callback;
                    if (experimentMethodChannelCallback != null) {
                        return experimentMethodChannelCallback.getIntVariant(fWFKeyObject, intValue, valueOf);
                    }
                    return intValue;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final String getStringVariant(Map<String, ? extends Object> map) {
        String str;
        String stringVariant;
        Object obj = map.get(ARGUMENT_PROJECT_NAME);
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        FWFProjectName fwfProjectFromProjectName = FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str);
        Object obj2 = map.get(ARGUMENT_KEY_EXPERIMENT_NAME);
        if (obj2 != null) {
            FWFKeyObject fWFKeyObject = new FWFKeyObject((String) obj2, fwfProjectFromProjectName);
            Object obj3 = map.get(ARGUMENT_KEY_DEFAULT_VALUE);
            if (obj3 != null) {
                String str2 = (String) obj3;
                Object obj4 = map.get("strategy");
                if (obj4 != null) {
                    Locale locale = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
                    String upperCase = ((String) obj4).toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    TalabatExperimentDataSourceStrategy valueOf = TalabatExperimentDataSourceStrategy.valueOf(upperCase);
                    ExperimentMethodChannelCallback experimentMethodChannelCallback = this.callback;
                    if (experimentMethodChannelCallback == null || (stringVariant = experimentMethodChannelCallback.getStringVariant(fWFKeyObject, str2, valueOf)) == null) {
                        return str2;
                    }
                    return stringVariant;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1714451405:
                    if (str.equals(GET_BOOLEAN_VARIANT)) {
                        Object obj = methodCall.arguments;
                        if (obj != null) {
                            result.success(Boolean.valueOf(getBooleanVariant((Map) obj)));
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    }
                    break;
                case -918344770:
                    if (str.equals(GET_DOUBLE_VARIANT)) {
                        Object obj2 = methodCall.arguments;
                        if (obj2 != null) {
                            result.success(Double.valueOf(getDoubleVariant((Map) obj2)));
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    }
                    break;
                case -788004994:
                    if (str.equals(GET_STRING_VARIANT)) {
                        Object obj3 = methodCall.arguments;
                        if (obj3 != null) {
                            result.success(getStringVariant((Map) obj3));
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    }
                    break;
                case 1495649676:
                    if (str.equals(GET_INT_VARIANT)) {
                        Object obj4 = methodCall.arguments;
                        if (obj4 != null) {
                            result.success(Integer.valueOf(getIntVariant((Map) obj4)));
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    public final void setCallback(@Nullable ExperimentMethodChannelCallback experimentMethodChannelCallback) {
        this.callback = experimentMethodChannelCallback;
    }
}
