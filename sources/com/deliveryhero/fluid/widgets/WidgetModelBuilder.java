package com.deliveryhero.fluid.widgets;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate;
import com.deliveryhero.fluid.expression.placeholder.PlaceholderSurrogate$$serializer;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderUtilsKt;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.Color$$serializer;
import com.deliveryhero.fluid.values.LinearGradientOrientation;
import com.deliveryhero.fluid.values.LinearGradientOrientation$$serializer;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.LogicalPixel$$serializer;
import com.deliveryhero.fluid.values.Shape;
import com.deliveryhero.fluid.values.Shape$$serializer;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.values.codecs.scalar.BooleanCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ColorCodec;
import com.deliveryhero.fluid.values.codecs.scalar.HorizontalAlignmentCodec;
import com.deliveryhero.fluid.values.codecs.scalar.IntegerCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LinearGradientOrientationCodec;
import com.deliveryhero.fluid.values.codecs.scalar.LogicalPixelCodec;
import com.deliveryhero.fluid.values.codecs.scalar.ShapeCodec;
import com.deliveryhero.fluid.values.codecs.scalar.SizeCodec;
import com.deliveryhero.fluid.values.codecs.scalar.StringCodec;
import com.deliveryhero.fluid.values.codecs.scalar.VerticalAlignmentCodec;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.deliveryhero.fluid.widgets.containers.HorizontalAlignment;
import com.deliveryhero.fluid.widgets.containers.VerticalAlignment;
import com.deliveryhero.fluid.widgets.utils.WidgetModelBuilderDelegates;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b`\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 Ï\u00012\u00020\u0001:\u0002Ï\u0001B\b¢\u0006\u0005\bÉ\u0001\u0010\u0017B\u0005\b\u0017\u0012\u0007\u0010Ê\u0001\u001a\u000206\u0012\u0007\u0010Ë\u0001\u001a\u000206\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0001\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0010\b\u0001\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%\u0012\u0010\b\u0001\u0010.\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%\u0012\u0010\b\u0001\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010%\u0012\u0010\b\u0001\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010%\u0012\u0010\b\u0001\u0010;\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010%\u0012\u0016\b\u0001\u0010A\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0%\u0018\u00010?\u0012\u0010\b\u0001\u0010I\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010%\u0012\u0010\b\u0001\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010%\u0012\u0010\b\u0001\u0010S\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0010\b\u0001\u0010W\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0010\b\u0001\u0010[\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0010\b\u0001\u0010_\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0010\b\u0001\u0010c\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0010\b\u0001\u0010k\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0010\b\u0001\u0010o\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010%\u0012\u0010\b\u0001\u0010s\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0010\b\u0001\u0010w\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010%\u0012\u0010\b\u0001\u0010{\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0010\b\u0001\u0010\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0011\b\u0001\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0011\b\u0001\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0011\b\u0001\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0011\b\u0001\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0011\b\u0001\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0011\b\u0001\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%\u0012\u0012\b\u0001\u0010´\u0001\u001a\u000b\u0012\u0005\u0012\u00030³\u0001\u0018\u00010%\u0012\u0012\b\u0001\u0010¹\u0001\u001a\u000b\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010%\u0012\u0011\b\u0001\u0010½\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010%\u0012\u0011\b\u0001\u0010Á\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010%\u0012\u0011\b\u0001\u0010Å\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010%\u0012\n\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u0001¢\u0006\u0006\bÉ\u0001\u0010Î\u0001J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0004R*\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0011\u0012\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b$\u0010\u0017\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R0\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b'\u0010(\u0012\u0004\b-\u0010\u0017\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R0\u0010.\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b.\u0010(\u0012\u0004\b1\u0010\u0017\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R0\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b3\u0010(\u0012\u0004\b5\u0010\u0017\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R0\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b7\u0010(\u0012\u0004\b:\u0010\u0017\u001a\u0004\b8\u0010*\"\u0004\b9\u0010,R0\u0010;\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b;\u0010(\u0012\u0004\b>\u0010\u0017\u001a\u0004\b<\u0010*\"\u0004\b=\u0010,R6\u0010A\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0%\u0018\u00010?8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bA\u0010B\u0012\u0004\bG\u0010\u0017\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR0\u0010I\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bI\u0010(\u0012\u0004\bL\u0010\u0017\u001a\u0004\bJ\u0010*\"\u0004\bK\u0010,R0\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bN\u0010(\u0012\u0004\bQ\u0010\u0017\u001a\u0004\bO\u0010*\"\u0004\bP\u0010,R0\u0010S\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bS\u0010(\u0012\u0004\bV\u0010\u0017\u001a\u0004\bT\u0010*\"\u0004\bU\u0010,R0\u0010W\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bW\u0010(\u0012\u0004\bZ\u0010\u0017\u001a\u0004\bX\u0010*\"\u0004\bY\u0010,R0\u0010[\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b[\u0010(\u0012\u0004\b^\u0010\u0017\u001a\u0004\b\\\u0010*\"\u0004\b]\u0010,R0\u0010_\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b_\u0010(\u0012\u0004\bb\u0010\u0017\u001a\u0004\b`\u0010*\"\u0004\ba\u0010,R$\u0010c\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\bc\u0010(\u0012\u0004\bd\u0010\u0017R;\u0010j\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8F@FX\u0002¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010*\"\u0004\bi\u0010,R0\u0010k\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bk\u0010(\u0012\u0004\bn\u0010\u0017\u001a\u0004\bl\u0010*\"\u0004\bm\u0010,R0\u0010o\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bo\u0010(\u0012\u0004\br\u0010\u0017\u001a\u0004\bp\u0010*\"\u0004\bq\u0010,R0\u0010s\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bs\u0010(\u0012\u0004\bv\u0010\u0017\u001a\u0004\bt\u0010*\"\u0004\bu\u0010,R0\u0010w\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bw\u0010(\u0012\u0004\bz\u0010\u0017\u001a\u0004\bx\u0010*\"\u0004\by\u0010,R0\u0010{\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b{\u0010(\u0012\u0004\b~\u0010\u0017\u001a\u0004\b|\u0010*\"\u0004\b}\u0010,R3\u0010\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001b\n\u0004\b\u0010(\u0012\u0005\b\u0001\u0010\u0017\u001a\u0005\b\u0001\u0010*\"\u0005\b\u0001\u0010,R5\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b\u0001\u0010(\u0012\u0005\b\u0001\u0010\u0017\u001a\u0005\b\u0001\u0010*\"\u0005\b\u0001\u0010,R5\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b\u0001\u0010(\u0012\u0005\b\u0001\u0010\u0017\u001a\u0005\b\u0001\u0010*\"\u0005\b\u0001\u0010,R?\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010g\u001a\u0005\b\u0001\u0010*\"\u0005\b\u0001\u0010,R?\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010g\u001a\u0005\b\u0001\u0010*\"\u0005\b\u0001\u0010,R?\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010g\u001a\u0005\b\u0001\u0010*\"\u0005\b\u0001\u0010,R5\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b\u0001\u0010(\u0012\u0005\b\u0001\u0010\u0017\u001a\u0005\b\u0001\u0010*\"\u0005\b\u0001\u0010,R5\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b\u0001\u0010(\u0012\u0005\b\u0001\u0010\u0017\u001a\u0005\b\u0001\u0010*\"\u0005\b\u0001\u0010,R5\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b\u0001\u0010(\u0012\u0005\b¢\u0001\u0010\u0017\u001a\u0005\b \u0001\u0010*\"\u0005\b¡\u0001\u0010,R5\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b£\u0001\u0010(\u0012\u0005\b¦\u0001\u0010\u0017\u001a\u0005\b¤\u0001\u0010*\"\u0005\b¥\u0001\u0010,R?\u0010ª\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8F@FX\u0002¢\u0006\u0015\n\u0005\b§\u0001\u0010g\u001a\u0005\b¨\u0001\u0010*\"\u0005\b©\u0001\u0010,R?\u0010®\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8F@FX\u0002¢\u0006\u0015\n\u0005\b«\u0001\u0010g\u001a\u0005\b¬\u0001\u0010*\"\u0005\b­\u0001\u0010,R?\u0010²\u0001\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010%8F@FX\u0002¢\u0006\u0015\n\u0005\b¯\u0001\u0010g\u001a\u0005\b°\u0001\u0010*\"\u0005\b±\u0001\u0010,R6\u0010´\u0001\u001a\u000b\u0012\u0005\u0012\u00030³\u0001\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b´\u0001\u0010(\u0012\u0005\b·\u0001\u0010\u0017\u001a\u0005\bµ\u0001\u0010*\"\u0005\b¶\u0001\u0010,R6\u0010¹\u0001\u001a\u000b\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b¹\u0001\u0010(\u0012\u0005\b¼\u0001\u0010\u0017\u001a\u0005\bº\u0001\u0010*\"\u0005\b»\u0001\u0010,R5\u0010½\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\b½\u0001\u0010(\u0012\u0005\bÀ\u0001\u0010\u0017\u001a\u0005\b¾\u0001\u0010*\"\u0005\b¿\u0001\u0010,R5\u0010Á\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\bÁ\u0001\u0010(\u0012\u0005\bÄ\u0001\u0010\u0017\u001a\u0005\bÂ\u0001\u0010*\"\u0005\bÃ\u0001\u0010,R5\u0010Å\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0005\bÅ\u0001\u0010(\u0012\u0005\bÈ\u0001\u0010\u0017\u001a\u0005\bÆ\u0001\u0010*\"\u0005\bÇ\u0001\u0010,¨\u0006Ð\u0001"}, d2 = {"Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "args", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "build", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "a", "", "id", "Ljava/lang/String;", "getId$core_release", "()Ljava/lang/String;", "setId$core_release", "(Ljava/lang/String;)V", "getId$core_release$annotations", "()V", "hash", "getHash$core_release", "setHash$core_release", "getHash$core_release$annotations", "", "Lcom/deliveryhero/fluid/expression/placeholder/PlaceholderSurrogate;", "placeholders", "Ljava/util/Set;", "getPlaceholders", "()Ljava/util/Set;", "setPlaceholders", "(Ljava/util/Set;)V", "getPlaceholders$annotations", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "Lcom/deliveryhero/fluid/values/Size;", "width", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "getWidth", "()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "setWidth", "(Lcom/deliveryhero/fluid/expression/ExpressionBuilder;)V", "getWidth$annotations", "height", "getHeight", "setHeight", "getHeight$annotations", "", "isVisible", "setVisible", "isVisible$annotations", "", "expansionResistancePriority", "getExpansionResistancePriority", "setExpansionResistancePriority", "getExpansionResistancePriority$annotations", "compressionResistancePriority", "getCompressionResistancePriority", "setCompressionResistancePriority", "getCompressionResistancePriority$annotations", "", "Lcom/deliveryhero/fluid/values/Color;", "backgroundColors", "Ljava/util/List;", "getBackgroundColors", "()Ljava/util/List;", "setBackgroundColors", "(Ljava/util/List;)V", "getBackgroundColors$annotations", "Lcom/deliveryhero/fluid/values/Shape;", "backgroundShape", "getBackgroundShape", "setBackgroundShape", "getBackgroundShape$annotations", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "backgroundLinearGradientOrientation", "getBackgroundLinearGradientOrientation", "setBackgroundLinearGradientOrientation", "getBackgroundLinearGradientOrientation$annotations", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "backgroundCornerRadiusTopLeft", "getBackgroundCornerRadiusTopLeft", "setBackgroundCornerRadiusTopLeft", "getBackgroundCornerRadiusTopLeft$annotations", "backgroundCornerRadiusTopRight", "getBackgroundCornerRadiusTopRight", "setBackgroundCornerRadiusTopRight", "getBackgroundCornerRadiusTopRight$annotations", "backgroundCornerRadiusBottomRight", "getBackgroundCornerRadiusBottomRight", "setBackgroundCornerRadiusBottomRight", "getBackgroundCornerRadiusBottomRight$annotations", "backgroundCornerRadiusBottomLeft", "getBackgroundCornerRadiusBottomLeft", "setBackgroundCornerRadiusBottomLeft", "getBackgroundCornerRadiusBottomLeft$annotations", "backgroundRadius", "getBackgroundRadius$annotations", "<set-?>", "backgroundCornerRadiusAll$delegate", "Lcom/deliveryhero/fluid/widgets/utils/WidgetModelBuilderDelegates$PropertyGroup;", "getBackgroundCornerRadiusAll", "setBackgroundCornerRadiusAll", "backgroundCornerRadiusAll", "borderWidth", "getBorderWidth", "setBorderWidth", "getBorderWidth$annotations", "borderColor", "getBorderColor", "setBorderColor", "getBorderColor$annotations", "elevation", "getElevation", "setElevation", "getElevation$annotations", "clipToBounds", "getClipToBounds", "setClipToBounds", "getClipToBounds$annotations", "paddingLeading", "getPaddingLeading", "setPaddingLeading", "getPaddingLeading$annotations", "paddingTop", "getPaddingTop", "setPaddingTop", "getPaddingTop$annotations", "paddingTrailing", "getPaddingTrailing", "setPaddingTrailing", "getPaddingTrailing$annotations", "paddingBottom", "getPaddingBottom", "setPaddingBottom", "getPaddingBottom$annotations", "paddingAll$delegate", "getPaddingAll", "setPaddingAll", "paddingAll", "paddingHorizontal$delegate", "getPaddingHorizontal", "setPaddingHorizontal", "paddingHorizontal", "paddingVertical$delegate", "getPaddingVertical", "setPaddingVertical", "paddingVertical", "marginLeading", "getMarginLeading", "setMarginLeading", "getMarginLeading$annotations", "marginTop", "getMarginTop", "setMarginTop", "getMarginTop$annotations", "marginTrailing", "getMarginTrailing", "setMarginTrailing", "getMarginTrailing$annotations", "marginBottom", "getMarginBottom", "setMarginBottom", "getMarginBottom$annotations", "marginAll$delegate", "getMarginAll", "setMarginAll", "marginAll", "marginHorizontal$delegate", "getMarginHorizontal", "setMarginHorizontal", "marginHorizontal", "marginVertical$delegate", "getMarginVertical", "setMarginVertical", "marginVertical", "Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "horizontalAlignment", "getHorizontalAlignment", "setHorizontalAlignment", "getHorizontalAlignment$annotations", "Lcom/deliveryhero/fluid/widgets/containers/VerticalAlignment;", "verticalAlignment", "getVerticalAlignment", "setVerticalAlignment", "getVerticalAlignment$annotations", "accessibilityId", "getAccessibilityId", "setAccessibilityId", "getAccessibilityId$annotations", "accessibilityLabel", "getAccessibilityLabel", "setAccessibilityLabel", "getAccessibilityLabel$annotations", "onClick", "getOnClick", "setOnClick", "getOnClick$annotations", "<init>", "seen1", "seen2", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Ljava/util/List;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lcom/deliveryhero/fluid/expression/ExpressionBuilder;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "Companion", "core_release"}, k = 1, mv = {1, 6, 0})
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public abstract class WidgetModelBuilder {
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, WidgetModelBuilder$Companion$$cachedSerializer$delegate$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f30237a;
    @Nullable
    private ExpressionBuilder<String> accessibilityId;
    @Nullable
    private ExpressionBuilder<String> accessibilityLabel;
    @Nullable
    private List<? extends ExpressionBuilder<Color>> backgroundColors;
    @NotNull
    private final WidgetModelBuilderDelegates.PropertyGroup backgroundCornerRadiusAll$delegate;
    @Nullable
    private ExpressionBuilder<LogicalPixel> backgroundCornerRadiusBottomLeft;
    @Nullable
    private ExpressionBuilder<LogicalPixel> backgroundCornerRadiusBottomRight;
    @Nullable
    private ExpressionBuilder<LogicalPixel> backgroundCornerRadiusTopLeft;
    @Nullable
    private ExpressionBuilder<LogicalPixel> backgroundCornerRadiusTopRight;
    @Nullable
    private ExpressionBuilder<LinearGradientOrientation> backgroundLinearGradientOrientation;
    /* access modifiers changed from: private */
    @Nullable
    public ExpressionBuilder<LogicalPixel> backgroundRadius;
    @Nullable
    private ExpressionBuilder<Shape> backgroundShape;
    @Nullable
    private ExpressionBuilder<Color> borderColor;
    @Nullable
    private ExpressionBuilder<LogicalPixel> borderWidth;
    @Nullable
    private ExpressionBuilder<Boolean> clipToBounds;
    @Nullable
    private ExpressionBuilder<Integer> compressionResistancePriority;
    @Nullable
    private ExpressionBuilder<LogicalPixel> elevation;
    @Nullable
    private ExpressionBuilder<Integer> expansionResistancePriority;
    @Nullable
    private String hash;
    @Nullable
    private ExpressionBuilder<Size> height;
    @Nullable
    private ExpressionBuilder<HorizontalAlignment> horizontalAlignment;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private String f30238id;
    @Nullable
    private ExpressionBuilder<Boolean> isVisible;
    @NotNull
    private final WidgetModelBuilderDelegates.PropertyGroup marginAll$delegate;
    @Nullable
    private ExpressionBuilder<LogicalPixel> marginBottom;
    @NotNull
    private final WidgetModelBuilderDelegates.PropertyGroup marginHorizontal$delegate;
    @Nullable
    private ExpressionBuilder<LogicalPixel> marginLeading;
    @Nullable
    private ExpressionBuilder<LogicalPixel> marginTop;
    @Nullable
    private ExpressionBuilder<LogicalPixel> marginTrailing;
    @NotNull
    private final WidgetModelBuilderDelegates.PropertyGroup marginVertical$delegate;
    @Nullable
    private ExpressionBuilder<String> onClick;
    @NotNull
    private final WidgetModelBuilderDelegates.PropertyGroup paddingAll$delegate;
    @Nullable
    private ExpressionBuilder<LogicalPixel> paddingBottom;
    @NotNull
    private final WidgetModelBuilderDelegates.PropertyGroup paddingHorizontal$delegate;
    @Nullable
    private ExpressionBuilder<LogicalPixel> paddingLeading;
    @Nullable
    private ExpressionBuilder<LogicalPixel> paddingTop;
    @Nullable
    private ExpressionBuilder<LogicalPixel> paddingTrailing;
    @NotNull
    private final WidgetModelBuilderDelegates.PropertyGroup paddingVertical$delegate;
    @NotNull
    private Set<PlaceholderSurrogate> placeholders;
    @Nullable
    private ExpressionBuilder<VerticalAlignment> verticalAlignment;
    @Nullable
    private ExpressionBuilder<Size> width;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return WidgetModelBuilder.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer<WidgetModelBuilder> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    static {
        Class<WidgetModelBuilder> cls = WidgetModelBuilder.class;
        f30237a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "backgroundCornerRadiusAll", "getBackgroundCornerRadiusAll()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "paddingAll", "getPaddingAll()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "paddingHorizontal", "getPaddingHorizontal()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "paddingVertical", "getPaddingVertical()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "marginAll", "getMarginAll()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "marginHorizontal", "getMarginHorizontal()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "marginVertical", "getMarginVertical()Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", 0))};
    }

    public WidgetModelBuilder() {
        this.placeholders = SetsKt__SetsKt.emptySet();
        this.backgroundCornerRadiusAll$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).backgroundRadius;
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).backgroundRadius = (ExpressionBuilder) obj;
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getBackgroundCornerRadiusTopLeft();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setBackgroundCornerRadiusTopLeft((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getBackgroundCornerRadiusTopRight();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setBackgroundCornerRadiusTopRight((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getBackgroundCornerRadiusBottomRight();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setBackgroundCornerRadiusBottomRight((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getBackgroundCornerRadiusBottomLeft();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setBackgroundCornerRadiusBottomLeft((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.paddingAll$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingLeading();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingLeading((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingTop();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingTop((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingTrailing();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingTrailing((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingBottom();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingBottom((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.paddingHorizontal$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingLeading();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingLeading((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingTrailing();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingTrailing((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.paddingVertical$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingTop();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingTop((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingBottom();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingBottom((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.marginAll$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginLeading();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginLeading((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginTop();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginTop((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginTrailing();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginTrailing((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginBottom();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginBottom((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.marginHorizontal$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginLeading();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginLeading((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginTrailing();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginTrailing((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.marginVertical$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginTop();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginTop((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginBottom();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginBottom((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("accessibility_tag")
    public static /* synthetic */ void getAccessibilityId$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("accessibility_label")
    public static /* synthetic */ void getAccessibilityLabel$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("background_colors")
    public static /* synthetic */ void getBackgroundColors$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("background_radius_bottom_left")
    public static /* synthetic */ void getBackgroundCornerRadiusBottomLeft$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("background_radius_bottom_right")
    public static /* synthetic */ void getBackgroundCornerRadiusBottomRight$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("background_radius_top_left")
    public static /* synthetic */ void getBackgroundCornerRadiusTopLeft$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("background_radius_top_right")
    public static /* synthetic */ void getBackgroundCornerRadiusTopRight$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("background_gradient_orientation")
    public static /* synthetic */ void getBackgroundLinearGradientOrientation$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @Deprecated(message = "Use backgroundCornerRadiusAll or corner specific background radii instead")
    @CoreContract.DeprecatedOn(version = CoreContract.Version.V2)
    @SerialName("background_radius")
    private static /* synthetic */ void getBackgroundRadius$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("background_shape")
    public static /* synthetic */ void getBackgroundShape$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("border_color")
    public static /* synthetic */ void getBorderColor$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("border_width")
    public static /* synthetic */ void getBorderWidth$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("clip_to_bounds")
    public static /* synthetic */ void getClipToBounds$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("compression_resistance_priority")
    public static /* synthetic */ void getCompressionResistancePriority$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("elevation")
    public static /* synthetic */ void getElevation$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("expansion_resistance_priority")
    public static /* synthetic */ void getExpansionResistancePriority$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @Deprecated(message = "Move when versioning is supported")
    @SerialName("hash")
    public static /* synthetic */ void getHash$core_release$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("horizontal_alignment")
    public static /* synthetic */ void getHorizontalAlignment$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @Deprecated(message = "Move when versioning is supported")
    @SerialName("id")
    public static /* synthetic */ void getId$core_release$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("margin_bottom")
    public static /* synthetic */ void getMarginBottom$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("margin_leading")
    public static /* synthetic */ void getMarginLeading$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("margin_top")
    public static /* synthetic */ void getMarginTop$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("margin_trailing")
    public static /* synthetic */ void getMarginTrailing$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("on_click")
    public static /* synthetic */ void getOnClick$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("padding_bottom")
    public static /* synthetic */ void getPaddingBottom$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("padding_leading")
    public static /* synthetic */ void getPaddingLeading$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("padding_top")
    public static /* synthetic */ void getPaddingTop$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("padding_trailing")
    public static /* synthetic */ void getPaddingTrailing$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @Deprecated(message = "Move when versioning is supported")
    @SerialName("placeholders")
    public static /* synthetic */ void getPlaceholders$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("vertical_alignment")
    public static /* synthetic */ void getVerticalAlignment$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    @SerialName("is_visible")
    public static /* synthetic */ void isVisible$annotations() {
    }

    @JvmStatic
    public static final void write$Self(@NotNull WidgetModelBuilder widgetModelBuilder, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        boolean z11;
        Intrinsics.checkNotNullParameter(widgetModelBuilder, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z12 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || widgetModelBuilder.f30238id != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, widgetModelBuilder.f30238id);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || widgetModelBuilder.hash != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, widgetModelBuilder.hash);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && Intrinsics.areEqual((Object) widgetModelBuilder.placeholders, (Object) SetsKt__SetsKt.emptySet())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 2, new LinkedHashSetSerializer(PlaceholderSurrogate$$serializer.INSTANCE), widgetModelBuilder.placeholders);
        }
        Class<Size> cls = Size.class;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || widgetModelBuilder.width != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, new ExpressionBuilderSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(cls), new Annotation[0])), widgetModelBuilder.width);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || widgetModelBuilder.height != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, new ExpressionBuilderSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(cls), new Annotation[0])), widgetModelBuilder.height);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || widgetModelBuilder.isVisible != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, new ExpressionBuilderSerializer(BooleanSerializer.INSTANCE), widgetModelBuilder.isVisible);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || widgetModelBuilder.expansionResistancePriority != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, new ExpressionBuilderSerializer(IntSerializer.INSTANCE), widgetModelBuilder.expansionResistancePriority);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || widgetModelBuilder.compressionResistancePriority != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, new ExpressionBuilderSerializer(IntSerializer.INSTANCE), widgetModelBuilder.compressionResistancePriority);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || widgetModelBuilder.backgroundColors != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, new ArrayListSerializer(new ExpressionBuilderSerializer(Color$$serializer.INSTANCE)), widgetModelBuilder.backgroundColors);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || widgetModelBuilder.backgroundShape != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, new ExpressionBuilderSerializer(Shape$$serializer.INSTANCE), widgetModelBuilder.backgroundShape);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) || widgetModelBuilder.backgroundLinearGradientOrientation != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 10, new ExpressionBuilderSerializer(LinearGradientOrientation$$serializer.INSTANCE), widgetModelBuilder.backgroundLinearGradientOrientation);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 11) || widgetModelBuilder.backgroundCornerRadiusTopLeft != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 11, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.backgroundCornerRadiusTopLeft);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 12) || widgetModelBuilder.backgroundCornerRadiusTopRight != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 12, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.backgroundCornerRadiusTopRight);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 13) || widgetModelBuilder.backgroundCornerRadiusBottomRight != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 13, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.backgroundCornerRadiusBottomRight);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 14) || widgetModelBuilder.backgroundCornerRadiusBottomLeft != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 14, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.backgroundCornerRadiusBottomLeft);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 15) || widgetModelBuilder.backgroundRadius != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 15, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.backgroundRadius);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 16) || widgetModelBuilder.borderWidth != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 16, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.borderWidth);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 17) || widgetModelBuilder.borderColor != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 17, new ExpressionBuilderSerializer(Color$$serializer.INSTANCE), widgetModelBuilder.borderColor);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 18) || widgetModelBuilder.elevation != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 18, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.elevation);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 19) || widgetModelBuilder.clipToBounds != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 19, new ExpressionBuilderSerializer(BooleanSerializer.INSTANCE), widgetModelBuilder.clipToBounds);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 20) || widgetModelBuilder.paddingLeading != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 20, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.paddingLeading);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 21) || widgetModelBuilder.paddingTop != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 21, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.paddingTop);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 22) || widgetModelBuilder.paddingTrailing != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 22, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.paddingTrailing);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 23) || widgetModelBuilder.paddingBottom != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 23, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.paddingBottom);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 24) || widgetModelBuilder.marginLeading != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 24, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.marginLeading);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 25) || widgetModelBuilder.marginTop != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 25, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.marginTop);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 26) || widgetModelBuilder.marginTrailing != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 26, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.marginTrailing);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 27) || widgetModelBuilder.marginBottom != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 27, new ExpressionBuilderSerializer(LogicalPixel$$serializer.INSTANCE), widgetModelBuilder.marginBottom);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 28) || widgetModelBuilder.horizontalAlignment != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 28, new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.containers.HorizontalAlignment", HorizontalAlignment.values())), widgetModelBuilder.horizontalAlignment);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 29) || widgetModelBuilder.verticalAlignment != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 29, new ExpressionBuilderSerializer(new EnumSerializer("com.deliveryhero.fluid.widgets.containers.VerticalAlignment", VerticalAlignment.values())), widgetModelBuilder.verticalAlignment);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 30) || widgetModelBuilder.accessibilityId != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 30, new ExpressionBuilderSerializer(StringSerializer.INSTANCE), widgetModelBuilder.accessibilityId);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 31) || widgetModelBuilder.accessibilityLabel != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 31, new ExpressionBuilderSerializer(StringSerializer.INSTANCE), widgetModelBuilder.accessibilityLabel);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 32) || widgetModelBuilder.onClick != null) {
            z12 = true;
        }
        if (z12) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 32, new ExpressionBuilderSerializer(StringSerializer.INSTANCE), widgetModelBuilder.onClick);
        }
    }

    @NotNull
    public final WidgetModel.BaseProperties a(@NotNull ExpressionBuilder.Args args) {
        ExpressionBuilder.Args args2 = args;
        Intrinsics.checkNotNullParameter(args2, StepData.ARGS);
        ExpressionBuilder<Size> expressionBuilder = this.width;
        SizeCodec sizeCodec = SizeCodec.INSTANCE;
        Class<Size> cls = Size.class;
        Expression<DecodedT> build = ExpressionBuilderUtilsKt.build(expressionBuilder, Reflection.getOrCreateKotlinClass(cls), sizeCodec, args2);
        Expression<DecodedT> build2 = ExpressionBuilderUtilsKt.build(this.height, Reflection.getOrCreateKotlinClass(cls), sizeCodec, args2);
        ExpressionBuilder<Boolean> expressionBuilder2 = this.isVisible;
        BooleanCodec booleanCodec = BooleanCodec.INSTANCE;
        Class<Boolean> cls2 = Boolean.class;
        Expression<DecodedT> build3 = ExpressionBuilderUtilsKt.build(expressionBuilder2, Reflection.getOrCreateKotlinClass(cls2), booleanCodec, args2);
        ExpressionBuilder<Integer> expressionBuilder3 = this.expansionResistancePriority;
        IntegerCodec integerCodec = IntegerCodec.INSTANCE;
        Class<Integer> cls3 = Integer.class;
        Expression<DecodedT> build4 = ExpressionBuilderUtilsKt.build(expressionBuilder3, Reflection.getOrCreateKotlinClass(cls3), integerCodec, args2);
        Expression<DecodedT> build5 = ExpressionBuilderUtilsKt.build(this.compressionResistancePriority, Reflection.getOrCreateKotlinClass(cls3), integerCodec, args2);
        List<? extends ExpressionBuilder<Color>> list = this.backgroundColors;
        ColorCodec colorCodec = ColorCodec.INSTANCE;
        Class<Color> cls4 = Color.class;
        List<Expression<DecodedT>> build6 = ExpressionBuilderUtilsKt.build(list, Reflection.getOrCreateKotlinClass(cls4), colorCodec, args2);
        Expression<DecodedT> build7 = ExpressionBuilderUtilsKt.build(this.backgroundShape, Reflection.getOrCreateKotlinClass(Shape.class), ShapeCodec.INSTANCE, args2);
        Expression<DecodedT> build8 = ExpressionBuilderUtilsKt.build(this.backgroundLinearGradientOrientation, Reflection.getOrCreateKotlinClass(LinearGradientOrientation.class), LinearGradientOrientationCodec.INSTANCE, args2);
        ExpressionBuilder<LogicalPixel> expressionBuilder4 = this.backgroundCornerRadiusTopLeft;
        LogicalPixelCodec logicalPixelCodec = LogicalPixelCodec.INSTANCE;
        Class<LogicalPixel> cls5 = LogicalPixel.class;
        Expression<DecodedT> expression = build;
        LogicalPixelCodec logicalPixelCodec2 = logicalPixelCodec;
        Expression<DecodedT> build9 = ExpressionBuilderUtilsKt.build(expressionBuilder4, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec, args2);
        Expression<DecodedT> build10 = ExpressionBuilderUtilsKt.build(this.backgroundCornerRadiusTopRight, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build11 = ExpressionBuilderUtilsKt.build(this.backgroundCornerRadiusBottomRight, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build12 = ExpressionBuilderUtilsKt.build(this.backgroundCornerRadiusBottomLeft, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build13 = ExpressionBuilderUtilsKt.build(this.borderWidth, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build14 = ExpressionBuilderUtilsKt.build(this.borderColor, Reflection.getOrCreateKotlinClass(cls4), colorCodec, args2);
        Expression<DecodedT> build15 = ExpressionBuilderUtilsKt.build(this.elevation, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build16 = ExpressionBuilderUtilsKt.build(this.clipToBounds, Reflection.getOrCreateKotlinClass(cls2), booleanCodec, args2);
        Expression<DecodedT> build17 = ExpressionBuilderUtilsKt.build(this.paddingLeading, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build18 = ExpressionBuilderUtilsKt.build(this.paddingTop, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build19 = ExpressionBuilderUtilsKt.build(this.paddingTrailing, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build20 = ExpressionBuilderUtilsKt.build(this.paddingBottom, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build21 = ExpressionBuilderUtilsKt.build(this.marginLeading, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build22 = ExpressionBuilderUtilsKt.build(this.marginTop, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build23 = ExpressionBuilderUtilsKt.build(this.marginTrailing, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build24 = ExpressionBuilderUtilsKt.build(this.marginBottom, Reflection.getOrCreateKotlinClass(cls5), logicalPixelCodec2, args2);
        Expression<DecodedT> build25 = ExpressionBuilderUtilsKt.build(this.horizontalAlignment, Reflection.getOrCreateKotlinClass(HorizontalAlignment.class), HorizontalAlignmentCodec.INSTANCE, args2);
        Expression<DecodedT> build26 = ExpressionBuilderUtilsKt.build(this.verticalAlignment, Reflection.getOrCreateKotlinClass(VerticalAlignment.class), VerticalAlignmentCodec.INSTANCE, args2);
        ExpressionBuilder<String> expressionBuilder5 = this.accessibilityId;
        StringCodec stringCodec = StringCodec.INSTANCE;
        Class<String> cls6 = String.class;
        return new WidgetModel.BaseProperties(expression, build2, build3, build4, build5, build6, build7, build8, build9, build10, build11, build12, build13, build14, build15, build16, build17, build18, build19, build20, build21, build22, build23, build24, build25, build26, ExpressionBuilderUtilsKt.build(this.onClick, Reflection.getOrCreateKotlinClass(cls6), stringCodec, args2), ExpressionBuilderUtilsKt.build(expressionBuilder5, Reflection.getOrCreateKotlinClass(cls6), stringCodec, args2), ExpressionBuilderUtilsKt.build(this.accessibilityLabel, Reflection.getOrCreateKotlinClass(cls6), stringCodec, args2));
    }

    @NotNull
    public abstract WidgetModel build(@NotNull ExpressionBuilder.Args args);

    @Nullable
    public final ExpressionBuilder<String> getAccessibilityId() {
        return this.accessibilityId;
    }

    @Nullable
    public final ExpressionBuilder<String> getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    @Nullable
    public final List<ExpressionBuilder<Color>> getBackgroundColors() {
        return this.backgroundColors;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getBackgroundCornerRadiusAll() {
        return this.backgroundCornerRadiusAll$delegate.getValue(this, f30237a[0]);
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getBackgroundCornerRadiusBottomLeft() {
        return this.backgroundCornerRadiusBottomLeft;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getBackgroundCornerRadiusBottomRight() {
        return this.backgroundCornerRadiusBottomRight;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getBackgroundCornerRadiusTopLeft() {
        return this.backgroundCornerRadiusTopLeft;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getBackgroundCornerRadiusTopRight() {
        return this.backgroundCornerRadiusTopRight;
    }

    @Nullable
    public final ExpressionBuilder<LinearGradientOrientation> getBackgroundLinearGradientOrientation() {
        return this.backgroundLinearGradientOrientation;
    }

    @Nullable
    public final ExpressionBuilder<Shape> getBackgroundShape() {
        return this.backgroundShape;
    }

    @Nullable
    public final ExpressionBuilder<Color> getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final ExpressionBuilder<Boolean> getClipToBounds() {
        return this.clipToBounds;
    }

    @Nullable
    public final ExpressionBuilder<Integer> getCompressionResistancePriority() {
        return this.compressionResistancePriority;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getElevation() {
        return this.elevation;
    }

    @Nullable
    public final ExpressionBuilder<Integer> getExpansionResistancePriority() {
        return this.expansionResistancePriority;
    }

    @Nullable
    public final String getHash$core_release() {
        return this.hash;
    }

    @Nullable
    public final ExpressionBuilder<Size> getHeight() {
        return this.height;
    }

    @Nullable
    public final ExpressionBuilder<HorizontalAlignment> getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    @Nullable
    public final String getId$core_release() {
        return this.f30238id;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getMarginAll() {
        return this.marginAll$delegate.getValue(this, f30237a[4]);
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getMarginBottom() {
        return this.marginBottom;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getMarginHorizontal() {
        return this.marginHorizontal$delegate.getValue(this, f30237a[5]);
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getMarginLeading() {
        return this.marginLeading;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getMarginTop() {
        return this.marginTop;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getMarginTrailing() {
        return this.marginTrailing;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getMarginVertical() {
        return this.marginVertical$delegate.getValue(this, f30237a[6]);
    }

    @Nullable
    public final ExpressionBuilder<String> getOnClick() {
        return this.onClick;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getPaddingAll() {
        return this.paddingAll$delegate.getValue(this, f30237a[1]);
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getPaddingBottom() {
        return this.paddingBottom;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getPaddingHorizontal() {
        return this.paddingHorizontal$delegate.getValue(this, f30237a[2]);
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getPaddingLeading() {
        return this.paddingLeading;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getPaddingTop() {
        return this.paddingTop;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getPaddingTrailing() {
        return this.paddingTrailing;
    }

    @Nullable
    public final ExpressionBuilder<LogicalPixel> getPaddingVertical() {
        return this.paddingVertical$delegate.getValue(this, f30237a[3]);
    }

    @NotNull
    public final Set<PlaceholderSurrogate> getPlaceholders() {
        return this.placeholders;
    }

    @Nullable
    public final ExpressionBuilder<VerticalAlignment> getVerticalAlignment() {
        return this.verticalAlignment;
    }

    @Nullable
    public final ExpressionBuilder<Size> getWidth() {
        return this.width;
    }

    @Nullable
    public final ExpressionBuilder<Boolean> isVisible() {
        return this.isVisible;
    }

    public final void setAccessibilityId(@Nullable ExpressionBuilder<String> expressionBuilder) {
        this.accessibilityId = expressionBuilder;
    }

    public final void setAccessibilityLabel(@Nullable ExpressionBuilder<String> expressionBuilder) {
        this.accessibilityLabel = expressionBuilder;
    }

    public final void setBackgroundColors(@Nullable List<? extends ExpressionBuilder<Color>> list) {
        this.backgroundColors = list;
    }

    public final void setBackgroundCornerRadiusAll(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.backgroundCornerRadiusAll$delegate.setValue(this, f30237a[0], expressionBuilder);
    }

    public final void setBackgroundCornerRadiusBottomLeft(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.backgroundCornerRadiusBottomLeft = expressionBuilder;
    }

    public final void setBackgroundCornerRadiusBottomRight(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.backgroundCornerRadiusBottomRight = expressionBuilder;
    }

    public final void setBackgroundCornerRadiusTopLeft(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.backgroundCornerRadiusTopLeft = expressionBuilder;
    }

    public final void setBackgroundCornerRadiusTopRight(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.backgroundCornerRadiusTopRight = expressionBuilder;
    }

    public final void setBackgroundLinearGradientOrientation(@Nullable ExpressionBuilder<LinearGradientOrientation> expressionBuilder) {
        this.backgroundLinearGradientOrientation = expressionBuilder;
    }

    public final void setBackgroundShape(@Nullable ExpressionBuilder<Shape> expressionBuilder) {
        this.backgroundShape = expressionBuilder;
    }

    public final void setBorderColor(@Nullable ExpressionBuilder<Color> expressionBuilder) {
        this.borderColor = expressionBuilder;
    }

    public final void setBorderWidth(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.borderWidth = expressionBuilder;
    }

    public final void setClipToBounds(@Nullable ExpressionBuilder<Boolean> expressionBuilder) {
        this.clipToBounds = expressionBuilder;
    }

    public final void setCompressionResistancePriority(@Nullable ExpressionBuilder<Integer> expressionBuilder) {
        this.compressionResistancePriority = expressionBuilder;
    }

    public final void setElevation(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.elevation = expressionBuilder;
    }

    public final void setExpansionResistancePriority(@Nullable ExpressionBuilder<Integer> expressionBuilder) {
        this.expansionResistancePriority = expressionBuilder;
    }

    public final void setHash$core_release(@Nullable String str) {
        this.hash = str;
    }

    public final void setHeight(@Nullable ExpressionBuilder<Size> expressionBuilder) {
        this.height = expressionBuilder;
    }

    public final void setHorizontalAlignment(@Nullable ExpressionBuilder<HorizontalAlignment> expressionBuilder) {
        this.horizontalAlignment = expressionBuilder;
    }

    public final void setId$core_release(@Nullable String str) {
        this.f30238id = str;
    }

    public final void setMarginAll(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.marginAll$delegate.setValue(this, f30237a[4], expressionBuilder);
    }

    public final void setMarginBottom(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.marginBottom = expressionBuilder;
    }

    public final void setMarginHorizontal(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.marginHorizontal$delegate.setValue(this, f30237a[5], expressionBuilder);
    }

    public final void setMarginLeading(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.marginLeading = expressionBuilder;
    }

    public final void setMarginTop(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.marginTop = expressionBuilder;
    }

    public final void setMarginTrailing(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.marginTrailing = expressionBuilder;
    }

    public final void setMarginVertical(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.marginVertical$delegate.setValue(this, f30237a[6], expressionBuilder);
    }

    public final void setOnClick(@Nullable ExpressionBuilder<String> expressionBuilder) {
        this.onClick = expressionBuilder;
    }

    public final void setPaddingAll(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.paddingAll$delegate.setValue(this, f30237a[1], expressionBuilder);
    }

    public final void setPaddingBottom(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.paddingBottom = expressionBuilder;
    }

    public final void setPaddingHorizontal(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.paddingHorizontal$delegate.setValue(this, f30237a[2], expressionBuilder);
    }

    public final void setPaddingLeading(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.paddingLeading = expressionBuilder;
    }

    public final void setPaddingTop(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.paddingTop = expressionBuilder;
    }

    public final void setPaddingTrailing(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.paddingTrailing = expressionBuilder;
    }

    public final void setPaddingVertical(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        this.paddingVertical$delegate.setValue(this, f30237a[3], expressionBuilder);
    }

    public final void setPlaceholders(@NotNull Set<PlaceholderSurrogate> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.placeholders = set;
    }

    public final void setVerticalAlignment(@Nullable ExpressionBuilder<VerticalAlignment> expressionBuilder) {
        this.verticalAlignment = expressionBuilder;
    }

    public final void setVisible(@Nullable ExpressionBuilder<Boolean> expressionBuilder) {
        this.isVisible = expressionBuilder;
    }

    public final void setWidth(@Nullable ExpressionBuilder<Size> expressionBuilder) {
        this.width = expressionBuilder;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ WidgetModelBuilder(int i11, int i12, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("id") String str, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("hash") String str2, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Move when versioning is supported") @SerialName("placeholders") Set set, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("width") ExpressionBuilder expressionBuilder, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("height") ExpressionBuilder expressionBuilder2, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("is_visible") ExpressionBuilder expressionBuilder3, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("expansion_resistance_priority") ExpressionBuilder expressionBuilder4, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("compression_resistance_priority") ExpressionBuilder expressionBuilder5, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_colors") List list, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_shape") ExpressionBuilder expressionBuilder6, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_gradient_orientation") ExpressionBuilder expressionBuilder7, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_top_left") ExpressionBuilder expressionBuilder8, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_top_right") ExpressionBuilder expressionBuilder9, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_bottom_right") ExpressionBuilder expressionBuilder10, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("background_radius_bottom_left") ExpressionBuilder expressionBuilder11, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @Deprecated(message = "Use backgroundCornerRadiusAll or corner specific background radii instead") @CoreContract.DeprecatedOn(version = CoreContract.Version.V2) @SerialName("background_radius") ExpressionBuilder expressionBuilder12, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("border_width") ExpressionBuilder expressionBuilder13, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("border_color") ExpressionBuilder expressionBuilder14, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("elevation") ExpressionBuilder expressionBuilder15, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("clip_to_bounds") ExpressionBuilder expressionBuilder16, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_leading") ExpressionBuilder expressionBuilder17, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_top") ExpressionBuilder expressionBuilder18, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_trailing") ExpressionBuilder expressionBuilder19, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("padding_bottom") ExpressionBuilder expressionBuilder20, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_leading") ExpressionBuilder expressionBuilder21, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_top") ExpressionBuilder expressionBuilder22, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_trailing") ExpressionBuilder expressionBuilder23, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("margin_bottom") ExpressionBuilder expressionBuilder24, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("horizontal_alignment") ExpressionBuilder expressionBuilder25, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("vertical_alignment") ExpressionBuilder expressionBuilder26, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("accessibility_tag") ExpressionBuilder expressionBuilder27, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("accessibility_label") ExpressionBuilder expressionBuilder28, @CoreContract.CreatedOn(version = CoreContract.Version.V1) @SerialName("on_click") ExpressionBuilder expressionBuilder29, SerializationConstructorMarker serializationConstructorMarker) {
        int i13 = i11;
        if ((i13 & 1) == 0) {
            this.f30238id = null;
        } else {
            this.f30238id = str;
        }
        if ((i13 & 2) == 0) {
            this.hash = null;
        } else {
            this.hash = str2;
        }
        this.placeholders = (i13 & 4) == 0 ? SetsKt__SetsKt.emptySet() : set;
        if ((i13 & 8) == 0) {
            this.width = null;
        } else {
            this.width = expressionBuilder;
        }
        if ((i13 & 16) == 0) {
            this.height = null;
        } else {
            this.height = expressionBuilder2;
        }
        if ((i13 & 32) == 0) {
            this.isVisible = null;
        } else {
            this.isVisible = expressionBuilder3;
        }
        if ((i13 & 64) == 0) {
            this.expansionResistancePriority = null;
        } else {
            this.expansionResistancePriority = expressionBuilder4;
        }
        if ((i13 & 128) == 0) {
            this.compressionResistancePriority = null;
        } else {
            this.compressionResistancePriority = expressionBuilder5;
        }
        if ((i13 & 256) == 0) {
            this.backgroundColors = null;
        } else {
            this.backgroundColors = list;
        }
        if ((i13 & 512) == 0) {
            this.backgroundShape = null;
        } else {
            this.backgroundShape = expressionBuilder6;
        }
        if ((i13 & 1024) == 0) {
            this.backgroundLinearGradientOrientation = null;
        } else {
            this.backgroundLinearGradientOrientation = expressionBuilder7;
        }
        if ((i13 & 2048) == 0) {
            this.backgroundCornerRadiusTopLeft = null;
        } else {
            this.backgroundCornerRadiusTopLeft = expressionBuilder8;
        }
        if ((i13 & 4096) == 0) {
            this.backgroundCornerRadiusTopRight = null;
        } else {
            this.backgroundCornerRadiusTopRight = expressionBuilder9;
        }
        if ((i13 & 8192) == 0) {
            this.backgroundCornerRadiusBottomRight = null;
        } else {
            this.backgroundCornerRadiusBottomRight = expressionBuilder10;
        }
        if ((i13 & 16384) == 0) {
            this.backgroundCornerRadiusBottomLeft = null;
        } else {
            this.backgroundCornerRadiusBottomLeft = expressionBuilder11;
        }
        if ((32768 & i13) == 0) {
            this.backgroundRadius = null;
        } else {
            this.backgroundRadius = expressionBuilder12;
        }
        this.backgroundCornerRadiusAll$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).backgroundRadius;
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).backgroundRadius = (ExpressionBuilder) obj;
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getBackgroundCornerRadiusTopLeft();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setBackgroundCornerRadiusTopLeft((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getBackgroundCornerRadiusTopRight();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setBackgroundCornerRadiusTopRight((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getBackgroundCornerRadiusBottomRight();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setBackgroundCornerRadiusBottomRight((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getBackgroundCornerRadiusBottomLeft();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setBackgroundCornerRadiusBottomLeft((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        if ((65536 & i13) == 0) {
            this.borderWidth = null;
        } else {
            this.borderWidth = expressionBuilder13;
        }
        if ((131072 & i13) == 0) {
            this.borderColor = null;
        } else {
            this.borderColor = expressionBuilder14;
        }
        if ((262144 & i13) == 0) {
            this.elevation = null;
        } else {
            this.elevation = expressionBuilder15;
        }
        if ((524288 & i13) == 0) {
            this.clipToBounds = null;
        } else {
            this.clipToBounds = expressionBuilder16;
        }
        if ((1048576 & i13) == 0) {
            this.paddingLeading = null;
        } else {
            this.paddingLeading = expressionBuilder17;
        }
        if ((2097152 & i13) == 0) {
            this.paddingTop = null;
        } else {
            this.paddingTop = expressionBuilder18;
        }
        if ((4194304 & i13) == 0) {
            this.paddingTrailing = null;
        } else {
            this.paddingTrailing = expressionBuilder19;
        }
        if ((8388608 & i13) == 0) {
            this.paddingBottom = null;
        } else {
            this.paddingBottom = expressionBuilder20;
        }
        this.paddingAll$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingLeading();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingLeading((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingTop();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingTop((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingTrailing();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingTrailing((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingBottom();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingBottom((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.paddingHorizontal$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingLeading();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingLeading((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingTrailing();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingTrailing((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.paddingVertical$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingTop();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingTop((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getPaddingBottom();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setPaddingBottom((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        if ((16777216 & i13) == 0) {
            this.marginLeading = null;
        } else {
            this.marginLeading = expressionBuilder21;
        }
        if ((33554432 & i13) == 0) {
            this.marginTop = null;
        } else {
            this.marginTop = expressionBuilder22;
        }
        if ((67108864 & i13) == 0) {
            this.marginTrailing = null;
        } else {
            this.marginTrailing = expressionBuilder23;
        }
        if ((134217728 & i13) == 0) {
            this.marginBottom = null;
        } else {
            this.marginBottom = expressionBuilder24;
        }
        this.marginAll$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginLeading();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginLeading((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginTop();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginTop((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginTrailing();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginTrailing((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginBottom();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginBottom((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.marginHorizontal$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginLeading();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginLeading((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginTrailing();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginTrailing((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.marginVertical$delegate = new WidgetModelBuilderDelegates.PropertyGroup(new KMutableProperty0[]{new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginTop();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginTop((ExpressionBuilder) obj);
            }
        }, new MutablePropertyReference0Impl(this) {
            @Nullable
            public Object get() {
                return ((WidgetModelBuilder) this.receiver).getMarginBottom();
            }

            public void set(@Nullable Object obj) {
                ((WidgetModelBuilder) this.receiver).setMarginBottom((ExpressionBuilder) obj);
            }
        }}, (Function1) null, 2, (DefaultConstructorMarker) null);
        if ((268435456 & i13) == 0) {
            this.horizontalAlignment = null;
        } else {
            this.horizontalAlignment = expressionBuilder25;
        }
        if ((536870912 & i13) == 0) {
            this.verticalAlignment = null;
        } else {
            this.verticalAlignment = expressionBuilder26;
        }
        if ((1073741824 & i13) == 0) {
            this.accessibilityId = null;
        } else {
            this.accessibilityId = expressionBuilder27;
        }
        if ((i13 & Integer.MIN_VALUE) == 0) {
            this.accessibilityLabel = null;
        } else {
            this.accessibilityLabel = expressionBuilder28;
        }
        if ((i12 & 1) == 0) {
            this.onClick = null;
        } else {
            this.onClick = expressionBuilder29;
        }
    }
}
