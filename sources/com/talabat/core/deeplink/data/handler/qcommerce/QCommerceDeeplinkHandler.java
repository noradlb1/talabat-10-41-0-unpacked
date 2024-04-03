package com.talabat.core.deeplink.data.handler.qcommerce;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.CallSuper;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.helpers.GlobalConstants;
import com.talabat.observabilityNew.squads.nfv.NFVEventType;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b0\u00101J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u0002*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0010\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001c\u0010\u0015\u001a\u00020\u00142\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001b\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0004R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R/\u0010'\u001a\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070$j\u0002`%¢\u0006\u0002\b&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R/\u0010)\u001a\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070$j\u0002`%¢\u0006\u0002\b&8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010(R/\u0010*\u001a\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070$j\u0002`%¢\u0006\u0002\b&8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010(R/\u0010+\u001a\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070$j\u0002`%¢\u0006\u0002\b&8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010(R/\u0010,\u001a\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070$j\u0002`%¢\u0006\u0002\b&8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010(R/\u0010-\u001a\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070$j\u0002`%¢\u0006\u0002\b&8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010(R;\u0010.\u001a)\u0012\u0004\u0012\u00020\u000e\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070$j\u0002`%¢\u0006\u0002\b&0\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/qcommerce/QCommerceDeeplinkHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "", "branchId", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "parsedLinkModel", "mapDeeplinkModelToFlutterRoute", "Landroid/net/Uri$Builder;", "eventOrigin", "toRoute", "", "isFlutterVLPEnabled", "", "key", "", "navigationTarget", "getOrThrow", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "trackObservability", "canHandle", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "b", "Lcom/talabat/core/navigation/domain/Navigator;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "Lkotlin/Function2;", "Lcom/talabat/core/deeplink/data/handler/qcommerce/RouteBuilderModifier;", "Lkotlin/ExtensionFunctionType;", "swimlaneRouteBuilderModifier", "Lkotlin/jvm/functions/Function2;", "campaignRouteBuilderModifier", "categoryRouteBuilderModifier", "productDetailsByIdRouteBuilderModifier", "productDetailsBySkuRouteBuilderModifier", "cartRouteBuilderModifier", "routeBuilderModifiers", "Ljava/util/Map;", "<init>", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0})
public abstract class QCommerceDeeplinkHandler implements Handler {
    @NotNull
    private final Function2<Uri.Builder, ParsedLinkModel, Uri.Builder> campaignRouteBuilderModifier;
    @NotNull
    private final Function2<Uri.Builder, ParsedLinkModel, Uri.Builder> cartRouteBuilderModifier;
    @NotNull
    private final Function2<Uri.Builder, ParsedLinkModel, Uri.Builder> categoryRouteBuilderModifier;
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final Function2<Uri.Builder, ParsedLinkModel, Uri.Builder> productDetailsByIdRouteBuilderModifier;
    @NotNull
    private final Function2<Uri.Builder, ParsedLinkModel, Uri.Builder> productDetailsBySkuRouteBuilderModifier;
    @NotNull
    private final Map<Integer, Function2<Uri.Builder, ParsedLinkModel, Uri.Builder>> routeBuilderModifiers;
    @NotNull
    private final Function2<Uri.Builder, ParsedLinkModel, Uri.Builder> swimlaneRouteBuilderModifier;
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    public QCommerceDeeplinkHandler(@NotNull Navigator navigator2, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.navigator = navigator2;
        this.talabatExperiment = iTalabatExperiment;
        this.observabilityManager = iObservabilityManager;
        QCommerceDeeplinkHandler$swimlaneRouteBuilderModifier$1 qCommerceDeeplinkHandler$swimlaneRouteBuilderModifier$1 = new QCommerceDeeplinkHandler$swimlaneRouteBuilderModifier$1(this);
        this.swimlaneRouteBuilderModifier = qCommerceDeeplinkHandler$swimlaneRouteBuilderModifier$1;
        QCommerceDeeplinkHandler$campaignRouteBuilderModifier$1 qCommerceDeeplinkHandler$campaignRouteBuilderModifier$1 = new QCommerceDeeplinkHandler$campaignRouteBuilderModifier$1(this);
        this.campaignRouteBuilderModifier = qCommerceDeeplinkHandler$campaignRouteBuilderModifier$1;
        QCommerceDeeplinkHandler$categoryRouteBuilderModifier$1 qCommerceDeeplinkHandler$categoryRouteBuilderModifier$1 = new QCommerceDeeplinkHandler$categoryRouteBuilderModifier$1(this);
        this.categoryRouteBuilderModifier = qCommerceDeeplinkHandler$categoryRouteBuilderModifier$1;
        QCommerceDeeplinkHandler$productDetailsByIdRouteBuilderModifier$1 qCommerceDeeplinkHandler$productDetailsByIdRouteBuilderModifier$1 = new QCommerceDeeplinkHandler$productDetailsByIdRouteBuilderModifier$1(this);
        this.productDetailsByIdRouteBuilderModifier = qCommerceDeeplinkHandler$productDetailsByIdRouteBuilderModifier$1;
        QCommerceDeeplinkHandler$productDetailsBySkuRouteBuilderModifier$1 qCommerceDeeplinkHandler$productDetailsBySkuRouteBuilderModifier$1 = new QCommerceDeeplinkHandler$productDetailsBySkuRouteBuilderModifier$1(this);
        this.productDetailsBySkuRouteBuilderModifier = qCommerceDeeplinkHandler$productDetailsBySkuRouteBuilderModifier$1;
        QCommerceDeeplinkHandler$cartRouteBuilderModifier$1 qCommerceDeeplinkHandler$cartRouteBuilderModifier$1 = QCommerceDeeplinkHandler$cartRouteBuilderModifier$1.INSTANCE;
        this.cartRouteBuilderModifier = qCommerceDeeplinkHandler$cartRouteBuilderModifier$1;
        this.routeBuilderModifiers = MapsKt__MapsKt.mapOf(TuplesKt.to(3, qCommerceDeeplinkHandler$cartRouteBuilderModifier$1), TuplesKt.to(7, qCommerceDeeplinkHandler$swimlaneRouteBuilderModifier$1), TuplesKt.to(1, qCommerceDeeplinkHandler$productDetailsByIdRouteBuilderModifier$1), TuplesKt.to(5, qCommerceDeeplinkHandler$productDetailsBySkuRouteBuilderModifier$1), TuplesKt.to(4, qCommerceDeeplinkHandler$categoryRouteBuilderModifier$1), TuplesKt.to(2, qCommerceDeeplinkHandler$campaignRouteBuilderModifier$1));
    }

    /* access modifiers changed from: private */
    public final String getOrThrow(Map<String, String> map, String str, int i11) {
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        throw new IllegalArgumentException("Missing key " + str + " for navigation target " + i11);
    }

    private final boolean isFlutterVLPEnabled() {
        return Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_ENABLE_FLUTTER_VLP, "", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    private final String mapDeeplinkModelToFlutterRoute(String str, ParsedLinkModel parsedLinkModel) {
        Integer num;
        Uri.Builder appendPath = new Uri.Builder().appendPath("qcommerce").appendPath("branches").appendPath(str);
        String str2 = parsedLinkModel.getData().get("eventOrigin");
        String str3 = null;
        try {
            Map<Integer, Function2<Uri.Builder, ParsedLinkModel, Uri.Builder>> map = this.routeBuilderModifiers;
            String str4 = parsedLinkModel.getData().get("t");
            if (str4 != null) {
                num = Integer.valueOf(Integer.parseInt(str4));
            } else {
                num = null;
            }
            Function2 function2 = map.get(num);
            if (function2 != null) {
                Uri.Builder buildUpon = appendPath.build().buildUpon();
                Intrinsics.checkNotNullExpressionValue(buildUpon, "baseRouteBuilder.build()…             .buildUpon()");
                str3 = toRoute((Uri.Builder) function2.invoke(buildUpon, parsedLinkModel), str2);
            }
        } catch (IllegalArgumentException e11) {
            trackObservability(e11, parsedLinkModel);
        }
        String str5 = parsedLinkModel.getData().get("shopClickOrigin");
        if (str5 == null) {
            str5 = "deeplink";
        }
        appendPath.appendQueryParameter("shopClickOrigin", str5);
        if (str3 != null) {
            appendPath.appendQueryParameter(GlobalConstants.ExtraNames.REDIRECT, str3);
        }
        Intrinsics.checkNotNullExpressionValue(appendPath, "baseRouteBuilder\n       …          }\n            }");
        return toRoute(appendPath, str2);
    }

    private final String toRoute(Uri.Builder builder, String str) {
        if (str == null) {
            str = "deeplink";
        }
        String uri = builder.appendQueryParameter("eventOrigin", str).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "appendQueryParameter(QUE…)\n            .toString()");
        String substring = uri.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    private final void trackObservability(Exception exc, ParsedLinkModel parsedLinkModel) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String name2 = NFVEventType.MobileUnexpectedScenariosQC.name();
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("deeplink", parsedLinkModel.toString());
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        pairArr[1] = TuplesKt.to("error", message);
        iObservabilityManager.track(ObservableAttributesNames.EVENT_DEEPLINK_PARSING, name2, MapsKt__MapsKt.mapOf(pairArr));
    }

    public final void b(@NotNull Context context, @NotNull String str, @NotNull ParsedLinkModel parsedLinkModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new FlutterScreen(new FlutterScreen.FlutterScreenData(mapDeeplinkModelToFlutterRoute(str, parsedLinkModel))), (Function1) null, 4, (Object) null);
    }

    @CallSuper
    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(isFlutterVLPEnabled());
    }
}
