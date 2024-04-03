package com.talabat.core.deeplink.data.handler.qcommerce;

import android.net.Uri;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroid/net/Uri$Builder;", "kotlin.jvm.PlatformType", "parsedDeeplinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class QCommerceDeeplinkHandler$productDetailsBySkuRouteBuilderModifier$1 extends Lambda implements Function2<Uri.Builder, ParsedLinkModel, Uri.Builder> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ QCommerceDeeplinkHandler f55825g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QCommerceDeeplinkHandler$productDetailsBySkuRouteBuilderModifier$1(QCommerceDeeplinkHandler qCommerceDeeplinkHandler) {
        super(2);
        this.f55825g = qCommerceDeeplinkHandler;
    }

    public final Uri.Builder invoke(@NotNull Uri.Builder builder, @NotNull ParsedLinkModel parsedLinkModel) {
        Intrinsics.checkNotNullParameter(builder, "$this$null");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedDeeplinkModel");
        Uri.Builder appendQueryParameter = builder.appendPath("product").appendQueryParameter("productSku", this.f55825g.getOrThrow(parsedLinkModel.getData(), "i", 5));
        Intrinsics.checkNotNullExpressionValue(appendQueryParameter, "appendPath(PATH_PRODUCT)…U_TYPE)\n                )");
        return appendQueryParameter;
    }
}
