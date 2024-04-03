package com.deliveryhero.fluid.expression.utils;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.expression.literal.LiteralBuilder;
import com.deliveryhero.fluid.expression.placeholder.PlaceholderBuilder;
import com.deliveryhero.fluid.expression.reference.ReferenceBuilder;
import com.deliveryhero.fluid.values.codecs.ValueCodec;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001aM\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u00020\tH\b\u001aV\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u00020\t\u001aY\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0018\u00010\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u00020\tH\b\u001ab\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\f\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0018\u00010\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\r"}, d2 = {"build", "Lcom/deliveryhero/fluid/expression/Expression;", "DecodedT", "", "EncodedT", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "codec", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec;", "args", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "type", "Lkotlin/reflect/KClass;", "", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExpressionBuilderUtilsKt {
    public static final /* synthetic */ <DecodedT, EncodedT> Expression<DecodedT> build(ExpressionBuilder<DecodedT> expressionBuilder, ValueCodec<DecodedT, EncodedT> valueCodec, ExpressionBuilder.Args args) {
        Intrinsics.checkNotNullParameter(valueCodec, "codec");
        Intrinsics.checkNotNullParameter(args, StepData.ARGS);
        Intrinsics.reifiedOperationMarker(4, "DecodedT");
        return build(expressionBuilder, Reflection.getOrCreateKotlinClass(Object.class), valueCodec, args);
    }

    public static final /* synthetic */ <DecodedT, EncodedT> List<Expression<DecodedT>> build(List<? extends ExpressionBuilder<DecodedT>> list, ValueCodec<DecodedT, EncodedT> valueCodec, ExpressionBuilder.Args args) {
        Intrinsics.checkNotNullParameter(valueCodec, "codec");
        Intrinsics.checkNotNullParameter(args, StepData.ARGS);
        Intrinsics.reifiedOperationMarker(4, "DecodedT");
        return build(list, Reflection.getOrCreateKotlinClass(Object.class), valueCodec, args);
    }

    @NotNull
    public static final <DecodedT, EncodedT> Expression<DecodedT> build(@Nullable ExpressionBuilder<DecodedT> expressionBuilder, @NotNull KClass<DecodedT> kClass, @NotNull ValueCodec<DecodedT, EncodedT> valueCodec, @NotNull ExpressionBuilder.Args args) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(valueCodec, "codec");
        Intrinsics.checkNotNullParameter(args, StepData.ARGS);
        if (expressionBuilder == null) {
            return new Literal(null);
        }
        if (expressionBuilder instanceof ReferenceBuilder) {
            return ((ReferenceBuilder) expressionBuilder).build(kClass, args.getValueProviders(), args.getLogger());
        }
        if (expressionBuilder instanceof PlaceholderBuilder) {
            return ((PlaceholderBuilder) expressionBuilder).build(kClass, valueCodec, args);
        }
        if (expressionBuilder instanceof LiteralBuilder) {
            return ((LiteralBuilder) expressionBuilder).build(valueCodec, args.getLogger());
        }
        throw new UnsupportedOperationException("Unsupported builder, please handle it here; Builder: `" + expressionBuilder + '`');
    }

    @NotNull
    public static final <DecodedT, EncodedT> List<Expression<DecodedT>> build(@Nullable List<? extends ExpressionBuilder<DecodedT>> list, @NotNull KClass<DecodedT> kClass, @NotNull ValueCodec<DecodedT, EncodedT> valueCodec, @NotNull ExpressionBuilder.Args args) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(valueCodec, "codec");
        Intrinsics.checkNotNullParameter(args, StepData.ARGS);
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<ExpressionBuilder> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ExpressionBuilder build : iterable) {
            arrayList.add(build(build, kClass, valueCodec, args));
        }
        return arrayList;
    }
}
