package com.deliveryhero.fluid.expression;

import com.deliveryhero.fluid.expression.reference.providers.ValueProviders;
import com.deliveryhero.fluid.expression.utils.ExpressionBuilderSerializer;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.template.data.DataDecoder;
import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0007R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "ValueT", "", "encodedValue", "", "getEncodedValue", "()Ljava/lang/String;", "Args", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable(with = ExpressionBuilderSerializer.class)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public interface ExpressionBuilder<ValueT> {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/fluid/expression/ExpressionBuilder$Args;", "", "dataDecoder", "Lcom/deliveryhero/fluid/template/data/DataDecoder;", "valueProviders", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "(Lcom/deliveryhero/fluid/template/data/DataDecoder;Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;Lcom/deliveryhero/fluid/telemetry/log/Logger;)V", "getDataDecoder", "()Lcom/deliveryhero/fluid/template/data/DataDecoder;", "getLogger", "()Lcom/deliveryhero/fluid/telemetry/log/Logger;", "getValueProviders", "()Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Args {
        @NotNull
        private final DataDecoder dataDecoder;
        @NotNull
        private final Logger logger;
        @NotNull
        private final ValueProviders valueProviders;

        public Args(@NotNull DataDecoder dataDecoder2, @NotNull ValueProviders valueProviders2, @NotNull Logger logger2) {
            Intrinsics.checkNotNullParameter(dataDecoder2, "dataDecoder");
            Intrinsics.checkNotNullParameter(valueProviders2, "valueProviders");
            Intrinsics.checkNotNullParameter(logger2, "logger");
            this.dataDecoder = dataDecoder2;
            this.valueProviders = valueProviders2;
            this.logger = logger2;
        }

        public static /* synthetic */ Args copy$default(Args args, DataDecoder dataDecoder2, ValueProviders valueProviders2, Logger logger2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                dataDecoder2 = args.dataDecoder;
            }
            if ((i11 & 2) != 0) {
                valueProviders2 = args.valueProviders;
            }
            if ((i11 & 4) != 0) {
                logger2 = args.logger;
            }
            return args.copy(dataDecoder2, valueProviders2, logger2);
        }

        @NotNull
        public final DataDecoder component1() {
            return this.dataDecoder;
        }

        @NotNull
        public final ValueProviders component2() {
            return this.valueProviders;
        }

        @NotNull
        public final Logger component3() {
            return this.logger;
        }

        @NotNull
        public final Args copy(@NotNull DataDecoder dataDecoder2, @NotNull ValueProviders valueProviders2, @NotNull Logger logger2) {
            Intrinsics.checkNotNullParameter(dataDecoder2, "dataDecoder");
            Intrinsics.checkNotNullParameter(valueProviders2, "valueProviders");
            Intrinsics.checkNotNullParameter(logger2, "logger");
            return new Args(dataDecoder2, valueProviders2, logger2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Args)) {
                return false;
            }
            Args args = (Args) obj;
            return Intrinsics.areEqual((Object) this.dataDecoder, (Object) args.dataDecoder) && Intrinsics.areEqual((Object) this.valueProviders, (Object) args.valueProviders) && Intrinsics.areEqual((Object) this.logger, (Object) args.logger);
        }

        @NotNull
        public final DataDecoder getDataDecoder() {
            return this.dataDecoder;
        }

        @NotNull
        public final Logger getLogger() {
            return this.logger;
        }

        @NotNull
        public final ValueProviders getValueProviders() {
            return this.valueProviders;
        }

        public int hashCode() {
            return (((this.dataDecoder.hashCode() * 31) + this.valueProviders.hashCode()) * 31) + this.logger.hashCode();
        }

        @NotNull
        public String toString() {
            return "Args(dataDecoder=" + this.dataDecoder + ", valueProviders=" + this.valueProviders + ", logger=" + this.logger + ')';
        }
    }

    @NotNull
    String getEncodedValue();
}
