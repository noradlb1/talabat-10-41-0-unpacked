package com.deliveryhero.fluid.serialization;

import com.deliveryhero.fluid.content.ContentBuilder;
import com.deliveryhero.fluid.content.DefaultContentBuilder;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import com.deliveryhero.fluid.widgets.collections.grid.horizontal.HorizontalGridModelBuilder;
import com.deliveryhero.fluid.widgets.collections.grid.horizontal.NativeHorizontalGridModelBuilder;
import com.deliveryhero.fluid.widgets.collections.grid.vertical.VerticalGridModelBuilder;
import com.deliveryhero.fluid.widgets.collections.list.ListModelBuilder;
import com.deliveryhero.fluid.widgets.collections.pager.CarouselModelBuilder;
import com.deliveryhero.fluid.widgets.collections.pager.PagerModelBuilder;
import com.deliveryhero.fluid.widgets.containers.column.ColumnModelBuilder;
import com.deliveryhero.fluid.widgets.containers.row.RowModelBuilder;
import com.deliveryhero.fluid.widgets.containers.stack.StackModelBuilder;
import com.deliveryhero.fluid.widgets.image.ImageModelBuilder;
import com.deliveryhero.fluid.widgets.lottie.LottieModelBuilder;
import com.deliveryhero.fluid.widgets.plain.PlainModelBuilder;
import com.deliveryhero.fluid.widgets.space.SpaceModelBuilder;
import com.deliveryhero.fluid.widgets.text.TextModelBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "TrackingModelT", "Lkotlinx/serialization/json/JsonBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class JsonFormatProvider$get$2 extends Lambda implements Function1<JsonBuilder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KSerializer<TrackingModelT> f30199g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<PolymorphicModuleBuilder<? super ContentBuilder<TrackingModelT>>, Unit> f30200h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<PolymorphicModuleBuilder<? super WidgetModelBuilder>, Unit> f30201i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonFormatProvider$get$2(KSerializer<TrackingModelT> kSerializer, Function1<? super PolymorphicModuleBuilder<? super ContentBuilder<TrackingModelT>>, Unit> function1, Function1<? super PolymorphicModuleBuilder<? super WidgetModelBuilder>, Unit> function12) {
        super(1);
        this.f30199g = kSerializer;
        this.f30200h = function1;
        this.f30201i = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JsonBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull JsonBuilder jsonBuilder) {
        Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
        jsonBuilder.setLenient(true);
        jsonBuilder.setIgnoreUnknownKeys(true);
        jsonBuilder.setCoerceInputValues(true);
        jsonBuilder.setUseAlternativeNames(true);
        jsonBuilder.setExplicitNulls(false);
        jsonBuilder.setEncodeDefaults(false);
        jsonBuilder.setPrettyPrint(true);
        KSerializer<TrackingModelT> kSerializer = this.f30199g;
        Function1<PolymorphicModuleBuilder<? super ContentBuilder<TrackingModelT>>, Unit> function1 = this.f30200h;
        Function1<PolymorphicModuleBuilder<? super WidgetModelBuilder>, Unit> function12 = this.f30201i;
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(Reflection.getOrCreateKotlinClass(ContentBuilder.class), (KSerializer) null);
        polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(DefaultContentBuilder.class), DefaultContentBuilder.Companion.serializer(kSerializer));
        function1.invoke(polymorphicModuleBuilder);
        polymorphicModuleBuilder.m7874default(new JsonFormatProvider$get$2$1$1$1(kSerializer));
        polymorphicModuleBuilder.buildTo(serializersModuleBuilder);
        PolymorphicModuleBuilder polymorphicModuleBuilder2 = new PolymorphicModuleBuilder(Reflection.getOrCreateKotlinClass(WidgetModelBuilder.class), (KSerializer) null);
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(ImageModelBuilder.class), ImageModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(LottieModelBuilder.class), LottieModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(PlainModelBuilder.class), PlainModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SpaceModelBuilder.class), SpaceModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(TextModelBuilder.class), TextModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(ColumnModelBuilder.class), ColumnModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(RowModelBuilder.class), RowModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(StackModelBuilder.class), StackModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(HorizontalGridModelBuilder.class), HorizontalGridModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(NativeHorizontalGridModelBuilder.class), NativeHorizontalGridModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(PagerModelBuilder.class), PagerModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(VerticalGridModelBuilder.class), VerticalGridModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(ListModelBuilder.class), ListModelBuilder.Companion.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(CarouselModelBuilder.class), CarouselModelBuilder.Companion.serializer());
        function12.invoke(polymorphicModuleBuilder2);
        polymorphicModuleBuilder2.buildTo(serializersModuleBuilder);
        jsonBuilder.setSerializersModule(serializersModuleBuilder.build());
    }
}
