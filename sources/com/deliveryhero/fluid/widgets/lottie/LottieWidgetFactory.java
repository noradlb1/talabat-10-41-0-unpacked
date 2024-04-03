package com.deliveryhero.fluid.widgets.lottie;

import android.content.Context;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.deliveryhero.fluid.widgets.lottie.RepeatCount;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import i5.b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J8\u0010\u000f\u001a\u00020\u0010*\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/fluid/widgets/lottie/LottieWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/lottie/LottieModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultsFactory", "Lkotlin/Function1;", "Lcom/deliveryhero/fluid/widgets/lottie/LottieWidget;", "create", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "setAnimationURL", "", "animation", "", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "defaults", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LottieWidgetFactory extends AndroidWidgetFactory<LottieModel> {
    @NotNull
    private final Function1<LottieWidget, LottieModel> defaultsFactory = new LottieWidgetFactory$defaultsFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieWidgetFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: com.deliveryhero.fluid.widgets.utils.WidgetTags} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: create$lambda-2$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8223create$lambda2$lambda1(com.deliveryhero.fluid.widgets.lottie.LottieWidgetFactory r8, com.deliveryhero.fluid.widgets.lottie.LottieWidget r9, com.deliveryhero.fluid.widgets.lottie.LottieModel r10, com.deliveryhero.fluid.Host r11, com.deliveryhero.fluid.template.data.TemplateUiData r12) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "$this_apply"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "$model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "$host"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.jvm.functions.Function1<com.deliveryhero.fluid.widgets.lottie.LottieWidget, com.deliveryhero.fluid.widgets.lottie.LottieModel> r0 = r8.defaultsFactory
            com.deliveryhero.fluid.widgets.WidgetModel r0 = r8.b(r9, r0)
            r6 = r0
            com.deliveryhero.fluid.widgets.lottie.LottieModel r6 = (com.deliveryhero.fluid.widgets.lottie.LottieModel) r6
            com.deliveryhero.fluid.widgets.WidgetModel$BaseProperties r0 = r10.getBaseProperties()
            r8.c(r9, r0, r11, r12)
            com.deliveryhero.fluid.expression.Expression r0 = r10.getAnimationResource()
            com.deliveryhero.fluid.expression.Expression r1 = r6.getAnimationResource()
            java.lang.Object r0 = r0.getOrNull(r12, r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.webkit.URLUtil.isHttpUrl(r0)
            if (r1 != 0) goto L_0x005a
            boolean r1 = android.webkit.URLUtil.isHttpsUrl(r0)
            if (r1 == 0) goto L_0x003f
            goto L_0x005a
        L_0x003f:
            com.deliveryhero.fluid.telemetry.log.Logger r8 = r11.getLogger()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "animation is not valid"
            r10.<init>(r11)
            com.deliveryhero.fluid.telemetry.log.ErrorTypes r11 = com.deliveryhero.fluid.telemetry.log.ErrorTypes.BINDING
            java.lang.String r12 = "animation_resource"
            kotlin.Pair r12 = kotlin.TuplesKt.to(r12, r0)
            java.util.Map r12 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r12)
            com.deliveryhero.fluid.telemetry.log.LoggerKt.error(r8, r10, r11, r12)
            goto L_0x006b
        L_0x005a:
            r1 = r8
            r2 = r9
            r3 = r0
            r4 = r10
            r5 = r12
            r7 = r11
            r1.setAnimationURL(r2, r3, r4, r5, r6, r7)
            i5.a r8 = new i5.a
            r8.<init>(r11, r0)
            r9.setFailureListener(r8)
        L_0x006b:
            java.lang.Object r8 = r9.getTag()
            boolean r10 = r8 instanceof com.deliveryhero.fluid.widgets.utils.WidgetTags
            r11 = 0
            if (r10 == 0) goto L_0x0077
            com.deliveryhero.fluid.widgets.utils.WidgetTags r8 = (com.deliveryhero.fluid.widgets.utils.WidgetTags) r8
            goto L_0x0078
        L_0x0077:
            r8 = r11
        L_0x0078:
            if (r8 != 0) goto L_0x007e
            com.deliveryhero.fluid.widgets.utils.WidgetTags r8 = com.deliveryhero.fluid.widgets.utils.WidgetTagsKt.initWidgetTags(r9)
        L_0x007e:
            java.lang.String r8 = r8.getLottieUrl()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)
            if (r8 != 0) goto L_0x009f
            java.lang.Object r8 = r9.getTag()
            boolean r10 = r8 instanceof com.deliveryhero.fluid.widgets.utils.WidgetTags
            if (r10 == 0) goto L_0x0093
            r11 = r8
            com.deliveryhero.fluid.widgets.utils.WidgetTags r11 = (com.deliveryhero.fluid.widgets.utils.WidgetTags) r11
        L_0x0093:
            if (r11 != 0) goto L_0x0099
            com.deliveryhero.fluid.widgets.utils.WidgetTags r11 = com.deliveryhero.fluid.widgets.utils.WidgetTagsKt.initWidgetTags(r9)
        L_0x0099:
            r11.setLottieUrl(r0)
            r9.playAnimation()
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.lottie.LottieWidgetFactory.m8223create$lambda2$lambda1(com.deliveryhero.fluid.widgets.lottie.LottieWidgetFactory, com.deliveryhero.fluid.widgets.lottie.LottieWidget, com.deliveryhero.fluid.widgets.lottie.LottieModel, com.deliveryhero.fluid.Host, com.deliveryhero.fluid.template.data.TemplateUiData):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8224create$lambda2$lambda1$lambda0(Host host, String str, Throwable th2) {
        Intrinsics.checkNotNullParameter(host, "$host");
        Logger logger = host.getLogger();
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LoggerKt.error(logger, th2, ErrorTypes.BINDING, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("animation_resource", str)));
    }

    private final void setAnimationURL(LottieWidget lottieWidget, String str, LottieModel lottieModel, TemplateUiData templateUiData, LottieModel lottieModel2, Host host) {
        Object obj;
        int i11;
        try {
            Result.Companion companion = Result.Companion;
            lottieWidget.setAnimationFromUrl(str);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6336isSuccessimpl(obj)) {
            Unit unit = (Unit) obj;
            RepeatCount repeatCount = lottieModel.getAnimationRepeatCount().get(templateUiData, lottieModel2.getAnimationRepeatCount());
            if (repeatCount instanceof RepeatCount.Finite) {
                i11 = ((RepeatCount.Finite) repeatCount).getValue();
            } else if (repeatCount instanceof RepeatCount.Infinite) {
                i11 = -1;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            lottieWidget.setRepeatCount(i11);
        }
        Throwable r32 = Result.m6332exceptionOrNullimpl(obj);
        if (r32 != null) {
            LoggerKt.error(host.getLogger(), r32, ErrorTypes.BINDING, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("animation_resource", str)));
        }
    }

    @NotNull
    public LottieWidget create(@NotNull LottieModel lottieModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(lottieModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        LottieWidget lottieWidget = new LottieWidget(getContext());
        templateUiDataHolder.observe(new b(this, lottieWidget, lottieModel, host));
        return lottieWidget;
    }
}
