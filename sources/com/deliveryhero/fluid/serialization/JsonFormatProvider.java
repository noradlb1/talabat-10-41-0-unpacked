package com.deliveryhero.fluid.serialization;

import com.deliveryhero.fluid.content.ContentBuilder;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\b\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00100\u000b\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\b\u000e¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/serialization/JsonFormatProvider;", "", "()V", "get", "Lkotlinx/serialization/json/Json;", "TrackingModelT", "trackingModelSerializer", "Lkotlinx/serialization/KSerializer;", "baseJson", "customWidgetRegisterer", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "", "Lkotlin/ExtensionFunctionType;", "customContentRegisterer", "Lcom/deliveryhero/fluid/content/ContentBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JsonFormatProvider {
    @NotNull
    public static final JsonFormatProvider INSTANCE = new JsonFormatProvider();

    private JsonFormatProvider() {
    }

    public static /* synthetic */ Json get$default(JsonFormatProvider jsonFormatProvider, KSerializer kSerializer, Json json, Function1 function1, Function1 function12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            json = Json.Default;
        }
        if ((i11 & 8) != 0) {
            function12 = JsonFormatProvider$get$1.INSTANCE;
        }
        return jsonFormatProvider.get(kSerializer, json, function1, function12);
    }

    @NotNull
    public final <TrackingModelT> Json get(@NotNull KSerializer<TrackingModelT> kSerializer, @NotNull Json json, @NotNull Function1<? super PolymorphicModuleBuilder<? super WidgetModelBuilder>, Unit> function1, @NotNull Function1<? super PolymorphicModuleBuilder<? super ContentBuilder<TrackingModelT>>, Unit> function12) {
        Intrinsics.checkNotNullParameter(kSerializer, "trackingModelSerializer");
        Intrinsics.checkNotNullParameter(json, "baseJson");
        Intrinsics.checkNotNullParameter(function1, "customWidgetRegisterer");
        Intrinsics.checkNotNullParameter(function12, "customContentRegisterer");
        return JsonKt.Json(json, new JsonFormatProvider$get$2(kSerializer, function12, function1));
    }
}
