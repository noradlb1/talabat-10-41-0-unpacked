package com.newrelic.newrelic_mobile;

import android.content.Context;
import androidx.annotation.NonNull;
import com.newrelic.agent.android.NewRelic;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\u000e2\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/newrelic/newrelic_mobile/NewrelicMobilePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "context", "Landroid/content/Context;", "generateStackTraceElement", "Ljava/lang/StackTraceElement;", "errorElement", "", "", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "newrelic_mobile_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NewrelicMobilePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel channel;
    private Context context;

    private final StackTraceElement generateStackTraceElement(Map<String, String> map) {
        try {
            String str = map.get("file");
            String str2 = map.get(Constants.LINE);
            String str3 = map.get("class");
            String str4 = map.get("method");
            if (str2 == null) {
                return null;
            }
            if (str3 == null) {
                str3 = "";
            }
            return new StackTraceElement(str3, str4, str, Integer.parseInt(str2));
        } catch (Exception e11) {
            NewRelic.recordHandledException(e11);
            return null;
        }
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "newrelic_mobile");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
        this.context = applicationContext;
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: com.newrelic.agent.android.metric.MetricUnit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: android.content.Context} */
    /* JADX WARNING: type inference failed for: r12v9, types: [com.newrelic.agent.android.metric.MetricUnit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@org.jetbrains.annotations.NotNull @androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r26, @org.jetbrains.annotations.NotNull @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            java.lang.String r3 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r3 = r1.method
            if (r3 == 0) goto L_0x05ce
            int r4 = r3.hashCode()
            r5 = 0
            java.lang.String r6 = "eventAttributes"
            java.lang.String r7 = "endTime"
            java.lang.String r8 = "startTime"
            java.lang.String r9 = "httpMethod"
            java.lang.String r10 = "url"
            java.lang.String r11 = "value"
            r12 = 0
            java.lang.String r13 = "name"
            switch(r4) {
                case -1601242173: goto L_0x04a5;
                case -1457403788: goto L_0x044e;
                case -975596699: goto L_0x042a;
                case -922975080: goto L_0x03a3;
                case -863771842: goto L_0x0315;
                case -600912133: goto L_0x02f7;
                case -170296714: goto L_0x02e0;
                case -111868108: goto L_0x02bb;
                case 567362394: goto L_0x0270;
                case 623411280: goto L_0x0252;
                case 645367112: goto L_0x022f;
                case 649954421: goto L_0x020b;
                case 1293385783: goto L_0x0181;
                case 1385449135: goto L_0x015d;
                case 1552473178: goto L_0x0116;
                case 1595386861: goto L_0x00e3;
                case 1657343329: goto L_0x0082;
                case 1746647256: goto L_0x006d;
                case 1803970103: goto L_0x004f;
                case 2124686968: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x05ce
        L_0x0030:
            java.lang.String r4 = "removeAttribute"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x003a
            goto L_0x05ce
        L_0x003a:
            java.lang.Object r1 = r1.argument(r13)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = com.newrelic.agent.android.NewRelic.removeAttribute(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x004f:
            java.lang.String r4 = "endInteraction"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0059
            goto L_0x05ce
        L_0x0059:
            java.lang.String r3 = "interactionId"
            java.lang.Object r1 = r1.argument(r3)
            java.lang.String r1 = (java.lang.String) r1
            com.newrelic.agent.android.NewRelic.endInteraction(r1)
            java.lang.String r1 = "interaction Ended"
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x006d:
            java.lang.String r1 = "currentSessionId"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0077
            goto L_0x05ce
        L_0x0077:
            java.lang.String r1 = com.newrelic.agent.android.NewRelic.currentSessionId()
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x0082:
            java.lang.String r4 = "recordMetric"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x008c
            goto L_0x05ce
        L_0x008c:
            java.lang.Object r3 = r1.argument(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r13 = r3
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r3 = "category"
            java.lang.Object r3 = r1.argument(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r3 = r1.argument(r11)
            java.lang.Double r3 = (java.lang.Double) r3
            java.lang.String r4 = "countUnit"
            java.lang.Object r4 = r1.argument(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "valueUnit"
            java.lang.Object r1 = r1.argument(r5)
            java.lang.String r1 = (java.lang.String) r1
            if (r3 == 0) goto L_0x00da
            double r16 = r3.doubleValue()
            r15 = 0
            r18 = 0
            if (r4 == 0) goto L_0x00cb
            com.newrelic.agent.android.metric.MetricUnit r3 = com.newrelic.agent.android.metric.MetricUnit.valueOf(r4)
            r20 = r3
            goto L_0x00cd
        L_0x00cb:
            r20 = r12
        L_0x00cd:
            if (r1 == 0) goto L_0x00d3
            com.newrelic.agent.android.metric.MetricUnit r12 = com.newrelic.agent.android.metric.MetricUnit.valueOf(r1)
        L_0x00d3:
            r21 = r12
            com.newrelic.agent.android.NewRelic.recordMetric(r13, r14, r15, r16, r18, r20, r21)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x00da:
            java.lang.String r1 = "Recorded Metric"
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x00e3:
            java.lang.String r4 = "incrementAttribute"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00ed
            goto L_0x05ce
        L_0x00ed:
            java.lang.Object r3 = r1.argument(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.argument(r11)
            java.lang.Double r1 = (java.lang.Double) r1
            if (r1 == 0) goto L_0x0107
            double r4 = r1.doubleValue()
            boolean r1 = com.newrelic.agent.android.NewRelic.incrementAttribute(r3, r4)
            goto L_0x010b
        L_0x0107:
            boolean r1 = com.newrelic.agent.android.NewRelic.incrementAttribute(r3)
        L_0x010b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x0116:
            java.lang.String r4 = "setAttribute"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0120
            goto L_0x05ce
        L_0x0120:
            java.lang.Object r3 = r1.argument(r13)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.argument(r11)
            boolean r4 = r1 instanceof java.lang.String
            if (r4 == 0) goto L_0x0135
            java.lang.String r1 = (java.lang.String) r1
            boolean r5 = com.newrelic.agent.android.NewRelic.setAttribute((java.lang.String) r3, (java.lang.String) r1)
            goto L_0x0152
        L_0x0135:
            boolean r4 = r1 instanceof java.lang.Double
            if (r4 == 0) goto L_0x0144
            java.lang.Number r1 = (java.lang.Number) r1
            double r4 = r1.doubleValue()
            boolean r5 = com.newrelic.agent.android.NewRelic.setAttribute((java.lang.String) r3, (double) r4)
            goto L_0x0152
        L_0x0144:
            boolean r4 = r1 instanceof java.lang.Boolean
            if (r4 == 0) goto L_0x0152
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            boolean r5 = com.newrelic.agent.android.NewRelic.setAttribute((java.lang.String) r3, (boolean) r1)
        L_0x0152:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r5)
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x015d:
            java.lang.String r1 = "getPlatformVersion"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0167
            goto L_0x05ce
        L_0x0167:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Android "
            r1.append(r3)
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x0181:
            java.lang.String r4 = "recordError"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x018b
            goto L_0x05ce
        L_0x018b:
            java.lang.String r3 = "exception"
            java.lang.Object r3 = r1.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "reason"
            java.lang.Object r6 = r1.argument(r4)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "fatal"
            java.lang.Object r7 = r1.argument(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            java.lang.String r8 = "attributes"
            java.lang.Object r8 = r1.argument(r8)
            java.util.HashMap r8 = (java.util.HashMap) r8
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            r9.put(r4, r6)
            java.lang.String r4 = "isFatal"
            r9.put(r4, r7)
            if (r8 == 0) goto L_0x01bd
            r9.putAll(r8)
        L_0x01bd:
            com.newrelic.newrelic_mobile.FlutterError r4 = new com.newrelic.newrelic_mobile.FlutterError
            r4.<init>(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r6 = "stackTraceElements"
            java.lang.Object r1 = r1.argument(r6)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x01ec
            java.util.Iterator r1 = r1.iterator()
        L_0x01d6:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x01ec
            java.lang.Object r6 = r1.next()
            java.util.Map r6 = (java.util.Map) r6
            java.lang.StackTraceElement r6 = r0.generateStackTraceElement(r6)
            if (r6 == 0) goto L_0x01d6
            r3.add(r6)
            goto L_0x01d6
        L_0x01ec:
            java.lang.StackTraceElement[] r1 = new java.lang.StackTraceElement[r5]
            java.lang.Object[] r1 = r3.toArray(r1)
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r3)
            java.lang.StackTraceElement[] r1 = (java.lang.StackTraceElement[]) r1
            r4.setStackTrace(r1)
            boolean r1 = com.newrelic.agent.android.NewRelic.recordHandledException((java.lang.Exception) r4, (java.util.Map<java.lang.String, java.lang.Object>) r9)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x020b:
            java.lang.String r4 = "setMaxEventPoolSize"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0215
            goto L_0x05ce
        L_0x0215:
            java.lang.String r3 = "maxSize"
            java.lang.Object r1 = r1.argument(r3)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L_0x0226
            int r1 = r1.intValue()
            com.newrelic.agent.android.NewRelic.setMaxEventPoolSize(r1)
        L_0x0226:
            java.lang.String r1 = "maxSize set"
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x022f:
            java.lang.String r4 = "setUserId"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x023a
            goto L_0x05ce
        L_0x023a:
            java.lang.String r3 = "userId"
            java.lang.Object r1 = r1.argument(r3)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = com.newrelic.agent.android.NewRelic.setUserId(r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x0252:
            java.lang.String r4 = "startInteraction"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x025d
            goto L_0x05ce
        L_0x025d:
            java.lang.String r3 = "actionName"
            java.lang.Object r1 = r1.argument(r3)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = com.newrelic.agent.android.NewRelic.startInteraction(r1)
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x0270:
            java.lang.String r1 = "noticeDistributedTrace"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x027a
            goto L_0x05ce
        L_0x027a:
            com.newrelic.agent.android.distributedtracing.TraceContext r1 = com.newrelic.agent.android.NewRelic.noticeDistributedTrace(r12)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r4 = r1.asTraceAttributes()
            r3.putAll(r4)
            java.util.Set r1 = r1.getHeaders()
            java.util.Iterator r1 = r1.iterator()
        L_0x0292:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x02b4
            java.lang.Object r4 = r1.next()
            com.newrelic.agent.android.distributedtracing.TraceHeader r4 = (com.newrelic.agent.android.distributedtracing.TraceHeader) r4
            java.lang.String r5 = r4.getHeaderName()
            java.lang.String r6 = "header.headerName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r4 = r4.getHeaderValue()
            java.lang.String r6 = "header.headerValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r3.put(r5, r4)
            goto L_0x0292
        L_0x02b4:
            r2.success(r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x02bb:
            java.lang.String r4 = "recordBreadcrumb"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02c5
            goto L_0x05ce
        L_0x02c5:
            java.lang.Object r3 = r1.argument(r13)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.argument(r6)
            java.util.HashMap r1 = (java.util.HashMap) r1
            boolean r1 = com.newrelic.agent.android.NewRelic.recordBreadcrumb(r3, r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x02e0:
            java.lang.String r1 = "shutDown"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x02eb
            goto L_0x05ce
        L_0x02eb:
            com.newrelic.agent.android.NewRelic.shutdown()
            java.lang.String r1 = "agent is shutDown"
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x02f7:
            java.lang.String r4 = "setInteractionName"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0301
            goto L_0x05ce
        L_0x0301:
            java.lang.String r3 = "interactionName"
            java.lang.Object r1 = r1.argument(r3)
            java.lang.String r1 = (java.lang.String) r1
            com.newrelic.agent.android.NewRelic.setInteractionName(r1)
            java.lang.String r1 = "interaction Recorded"
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x0315:
            java.lang.String r4 = "noticeHttpTransaction"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x031f
            goto L_0x05ce
        L_0x031f:
            java.lang.Object r3 = r1.argument(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r10 = r3
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r3 = r1.argument(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r11 = r3
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r3 = "statusCode"
            java.lang.Object r3 = r1.argument(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            int r12 = r3.intValue()
            java.lang.Object r3 = r1.argument(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            long r13 = r3.longValue()
            java.lang.Object r3 = r1.argument(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            long r15 = r3.longValue()
            java.lang.String r3 = "bytesSent"
            java.lang.Object r3 = r1.argument(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            long r17 = r3.longValue()
            java.lang.String r3 = "bytesReceived"
            java.lang.Object r3 = r1.argument(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            long r19 = r3.longValue()
            java.lang.String r3 = "responseBody"
            java.lang.Object r3 = r1.argument(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r21 = r3
            java.lang.String r21 = (java.lang.String) r21
            java.lang.String r3 = "traceAttributes"
            java.lang.Object r1 = r1.argument(r3)
            r24 = r1
            java.util.HashMap r24 = (java.util.HashMap) r24
            r22 = 0
            r23 = 0
            com.newrelic.agent.android.NewRelic.noticeHttpTransaction(r10, r11, r12, r13, r15, r17, r19, r21, r22, r23, r24)
            java.lang.String r1 = "Http Transcation Recorded"
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x03a3:
            java.lang.String r4 = "recordCustomEvent"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x03ad
            goto L_0x05ce
        L_0x03ad:
            java.lang.String r3 = "eventType"
            java.lang.Object r3 = r1.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "eventName"
            java.lang.Object r4 = r1.argument(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r1 = r1.argument(r6)
            java.util.HashMap r1 = (java.util.HashMap) r1
            if (r1 == 0) goto L_0x03c9
            java.lang.Object r12 = r1.clone()
        L_0x03c9:
            java.lang.String r5 = "null cannot be cast to non-null type java.util.HashMap<*, *>{ kotlin.collections.TypeAliasesKt.HashMap<*, *> }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r5)
            java.util.HashMap r12 = (java.util.HashMap) r12
            java.util.Set r5 = r12.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x03d8:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x041b
            java.lang.Object r6 = r5.next()
            java.lang.Object r7 = r12.get(r6)
            boolean r8 = r7 instanceof java.util.HashMap
            if (r8 == 0) goto L_0x03d8
            r8 = r7
            java.util.HashMap r8 = (java.util.HashMap) r8
            java.util.Set r8 = r8.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x03f5:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0413
            java.lang.Object r9 = r8.next()
            r10 = r7
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r10 = r10.get(r9)
            if (r10 == 0) goto L_0x03f5
            java.lang.String r11 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r11)
            java.lang.String r9 = (java.lang.String) r9
            r1.put(r9, r10)
            goto L_0x03f5
        L_0x0413:
            java.util.Map r7 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r1)
            r7.remove(r6)
            goto L_0x03d8
        L_0x041b:
            boolean r1 = com.newrelic.agent.android.NewRelic.recordCustomEvent(r3, r4, r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x042a:
            java.lang.String r4 = "setMaxEventBufferTime"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0434
            goto L_0x05ce
        L_0x0434:
            java.lang.String r3 = "maxBufferTimeInSec"
            java.lang.Object r1 = r1.argument(r3)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L_0x0445
            int r1 = r1.intValue()
            com.newrelic.agent.android.NewRelic.setMaxEventBufferTime(r1)
        L_0x0445:
            java.lang.String r1 = "MaxEvent BufferTime set"
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x044e:
            java.lang.String r4 = "noticeNetworkFailure"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0458
            goto L_0x05ce
        L_0x0458:
            java.lang.Object r3 = r1.argument(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r10 = r3
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r3 = r1.argument(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r11 = r3
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r3 = r1.argument(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            long r12 = r3.longValue()
            java.lang.Object r3 = r1.argument(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Number r3 = (java.lang.Number) r3
            long r14 = r3.longValue()
            java.lang.String r3 = "errorCode"
            java.lang.Object r1 = r1.argument(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            com.newrelic.agent.android.util.NetworkFailure r16 = com.newrelic.agent.android.util.NetworkFailure.fromErrorCode(r1)
            com.newrelic.agent.android.NewRelic.noticeNetworkFailure((java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (com.newrelic.agent.android.util.NetworkFailure) r16)
            java.lang.String r1 = "Network Failure Recorded"
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x04a5:
            java.lang.String r4 = "startAgent"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x04b0
            goto L_0x05ce
        L_0x04b0:
            java.lang.String r3 = "applicationToken"
            java.lang.Object r3 = r1.argument(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "dartVersion"
            java.lang.Object r4 = r1.argument(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "loggingEnabled"
            java.lang.Object r5 = r1.argument(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            java.lang.String r6 = "analyticsEventEnabled"
            java.lang.Object r6 = r1.argument(r6)
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.Boolean"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x04e1
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.AnalyticsEvents
            com.newrelic.agent.android.NewRelic.enableFeature(r6)
            goto L_0x04e6
        L_0x04e1:
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.AnalyticsEvents
            com.newrelic.agent.android.NewRelic.disableFeature(r6)
        L_0x04e6:
            java.lang.String r6 = "networkRequestEnabled"
            java.lang.Object r6 = r1.argument(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x04fd
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.NetworkRequests
            com.newrelic.agent.android.NewRelic.enableFeature(r6)
            goto L_0x0502
        L_0x04fd:
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.NetworkRequests
            com.newrelic.agent.android.NewRelic.disableFeature(r6)
        L_0x0502:
            java.lang.String r6 = "networkErrorRequestEnabled"
            java.lang.Object r6 = r1.argument(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0519
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.NetworkErrorRequests
            com.newrelic.agent.android.NewRelic.enableFeature(r6)
            goto L_0x051e
        L_0x0519:
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.NetworkErrorRequests
            com.newrelic.agent.android.NewRelic.disableFeature(r6)
        L_0x051e:
            java.lang.String r6 = "httpResponseBodyCaptureEnabled"
            java.lang.Object r6 = r1.argument(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0535
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.HttpResponseBodyCapture
            com.newrelic.agent.android.NewRelic.enableFeature(r6)
            goto L_0x053a
        L_0x0535:
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.HttpResponseBodyCapture
            com.newrelic.agent.android.NewRelic.disableFeature(r6)
        L_0x053a:
            java.lang.String r6 = "crashReportingEnabled"
            java.lang.Object r6 = r1.argument(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0551
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.CrashReporting
            com.newrelic.agent.android.NewRelic.enableFeature(r6)
            goto L_0x0556
        L_0x0551:
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.CrashReporting
            com.newrelic.agent.android.NewRelic.disableFeature(r6)
        L_0x0556:
            java.lang.String r6 = "interactionTracingEnabled"
            java.lang.Object r6 = r1.argument(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x056d
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.InteractionTracing
            com.newrelic.agent.android.NewRelic.enableFeature(r6)
            goto L_0x0572
        L_0x056d:
            com.newrelic.agent.android.FeatureFlag r6 = com.newrelic.agent.android.FeatureFlag.InteractionTracing
            com.newrelic.agent.android.NewRelic.disableFeature(r6)
        L_0x0572:
            java.lang.String r6 = "fedRampEnabled"
            java.lang.Object r1 = r1.argument(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r7)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0589
            com.newrelic.agent.android.FeatureFlag r1 = com.newrelic.agent.android.FeatureFlag.FedRampEnabled
            com.newrelic.agent.android.NewRelic.enableFeature(r1)
            goto L_0x058e
        L_0x0589:
            com.newrelic.agent.android.FeatureFlag r1 = com.newrelic.agent.android.FeatureFlag.FedRampEnabled
            com.newrelic.agent.android.NewRelic.disableFeature(r1)
        L_0x058e:
            com.newrelic.agent.android.NewRelic r1 = com.newrelic.agent.android.NewRelic.withApplicationToken(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            boolean r3 = r5.booleanValue()
            com.newrelic.agent.android.NewRelic r1 = r1.withLoggingEnabled(r3)
            r3 = 5
            com.newrelic.agent.android.NewRelic r1 = r1.withLogLevel(r3)
            com.newrelic.agent.android.ApplicationFramework r3 = com.newrelic.agent.android.ApplicationFramework.Flutter
            java.lang.String r5 = "1.0.3"
            com.newrelic.agent.android.NewRelic r1 = r1.withApplicationFramework(r3, r5)
            android.content.Context r3 = r0.context
            if (r3 != 0) goto L_0x05b4
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x05b5
        L_0x05b4:
            r12 = r3
        L_0x05b5:
            r1.start(r12)
            java.lang.String r1 = "DartVersion"
            com.newrelic.agent.android.NewRelic.setAttribute((java.lang.String) r1, (java.lang.String) r4)
            com.newrelic.agent.android.stats.StatsEngine r1 = com.newrelic.agent.android.stats.StatsEngine.get()
            java.lang.String r3 = "Supportability/Mobile/Android/Flutter/Agent/1.0.3"
            r1.inc(r3)
            java.lang.String r1 = "Agent Started"
            r2.success(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x05d3
        L_0x05ce:
            r27.notImplemented()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x05d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.newrelic_mobile.NewrelicMobilePlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
