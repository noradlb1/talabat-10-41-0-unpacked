package com.deliveryhero.fluid.expression.utils;

import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.literal.LiteralBuilder;
import com.deliveryhero.fluid.expression.placeholder.PlaceholderBuilder;
import com.deliveryhero.fluid.expression.reference.ReferenceBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u0013*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/fluid/expression/utils/ExpressionBuilderSerializer;", "ValueT", "", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "builder", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpressionBuilderSerializer<ValueT> implements KSerializer<ExpressionBuilder<ValueT>> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final char PREFIX_ESCAPE = '\\';
    private static final char PREFIX_PLACEHOLDER = '$';
    private static final char PREFIX_REFERENCE = '@';
    @NotNull
    private final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("Expression", PrimitiveKind.STRING.INSTANCE);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0001\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\u000b\"\b\b\u0001\u0010\t*\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\bJ\f\u0010\u000e\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010\u000f\u001a\u00020\u000b*\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/fluid/expression/utils/ExpressionBuilderSerializer$Companion;", "", "()V", "PREFIX_ESCAPE", "", "PREFIX_PLACEHOLDER", "PREFIX_REFERENCE", "decode", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "ValueT", "encoded", "", "encode", "decoded", "escape", "unescape", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String escape(String str) {
            boolean z11;
            boolean z12;
            Character firstOrNull = StringsKt___StringsKt.firstOrNull(str);
            boolean z13 = true;
            if (firstOrNull != null && firstOrNull.charValue() == '$') {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                Character firstOrNull2 = StringsKt___StringsKt.firstOrNull(str);
                if (firstOrNull2 != null && firstOrNull2.charValue() == '@') {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    z13 = false;
                }
            }
            if (!z13) {
                return str;
            }
            return '\\' + str;
        }

        private final String unescape(String str) {
            boolean z11;
            Character firstOrNull = StringsKt___StringsKt.firstOrNull(str);
            if (firstOrNull != null && firstOrNull.charValue() == '\\') {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                return str;
            }
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }

        @NotNull
        public final <ValueT> ExpressionBuilder<ValueT> decode(@NotNull String str) {
            boolean z11;
            boolean z12;
            Intrinsics.checkNotNullParameter(str, "encoded");
            Character firstOrNull = StringsKt___StringsKt.firstOrNull(str);
            boolean z13 = false;
            if (firstOrNull != null && firstOrNull.charValue() == '@') {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                Character firstOrNull2 = StringsKt___StringsKt.firstOrNull(str);
                if (firstOrNull2 != null && firstOrNull2.charValue() == '@') {
                    z13 = true;
                }
                if (z13) {
                    str = str.substring(1);
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                }
                return new ReferenceBuilder(str);
            }
            Character firstOrNull3 = StringsKt___StringsKt.firstOrNull(str);
            if (firstOrNull3 != null && firstOrNull3.charValue() == '$') {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                return new LiteralBuilder(unescape(str));
            }
            Character firstOrNull4 = StringsKt___StringsKt.firstOrNull(str);
            if (firstOrNull4 != null && firstOrNull4.charValue() == '$') {
                z13 = true;
            }
            if (z13) {
                str = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
            }
            return new PlaceholderBuilder(str);
        }

        @NotNull
        public final <ValueT> String encode(@NotNull ExpressionBuilder<ValueT> expressionBuilder) {
            Intrinsics.checkNotNullParameter(expressionBuilder, "decoded");
            if (expressionBuilder instanceof ReferenceBuilder) {
                String encodedValue = expressionBuilder.getEncodedValue();
                return ExpressionBuilderSerializer.PREFIX_REFERENCE + encodedValue;
            } else if (expressionBuilder instanceof PlaceholderBuilder) {
                String encodedValue2 = expressionBuilder.getEncodedValue();
                return '$' + encodedValue2;
            } else if (expressionBuilder instanceof LiteralBuilder) {
                return escape(expressionBuilder.getEncodedValue());
            } else {
                throw new UnsupportedOperationException("Encoding this raw expression is unsupported; Value: `" + expressionBuilder + '`');
            }
        }
    }

    public ExpressionBuilderSerializer(@NotNull KSerializer<ValueT> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "valueSerializer");
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    public ExpressionBuilder<ValueT> deserialize(@NotNull Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return Companion.decode(decoder.decodeString());
    }

    public void serialize(@NotNull Encoder encoder, @NotNull ExpressionBuilder<ValueT> expressionBuilder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(expressionBuilder, "builder");
        encoder.encodeString(Companion.encode(expressionBuilder));
    }
}
