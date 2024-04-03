package com.deliveryhero.fluid.expression.placeholder;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\tHÂ\u0003J3\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u0019\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/fluid/expression/placeholder/Placeholder;", "ValueT", "", "Lcom/deliveryhero/fluid/expression/Expression;", "name", "", "type", "Lkotlin/reflect/KClass;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "(Ljava/lang/String;Lkotlin/reflect/KClass;Lcom/deliveryhero/fluid/telemetry/log/Logger;)V", "getName", "()Ljava/lang/String;", "getType", "()Lkotlin/reflect/KClass;", "component1", "component2", "component3", "copy", "equals", "", "other", "getOrNull", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "(Lcom/deliveryhero/fluid/template/data/TemplateUiData;)Ljava/lang/Object;", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Placeholder<ValueT> implements Expression<ValueT> {
    @NotNull
    private final Logger logger;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30197name;
    @NotNull
    private final KClass<ValueT> type;

    public Placeholder(@NotNull String str, @NotNull KClass<ValueT> kClass, @NotNull Logger logger2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.f30197name = str;
        this.type = kClass;
        this.logger = logger2;
    }

    private final Logger component3() {
        return this.logger;
    }

    public static /* synthetic */ Placeholder copy$default(Placeholder placeholder, String str, KClass<ValueT> kClass, Logger logger2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = placeholder.f30197name;
        }
        if ((i11 & 2) != 0) {
            kClass = placeholder.type;
        }
        if ((i11 & 4) != 0) {
            logger2 = placeholder.logger;
        }
        return placeholder.copy(str, kClass, logger2);
    }

    @NotNull
    public final String component1() {
        return this.f30197name;
    }

    @NotNull
    public final KClass<ValueT> component2() {
        return this.type;
    }

    @NotNull
    public final Placeholder<ValueT> copy(@NotNull String str, @NotNull KClass<ValueT> kClass, @NotNull Logger logger2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        return new Placeholder<>(str, kClass, logger2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) obj;
        return Intrinsics.areEqual((Object) this.f30197name, (Object) placeholder.f30197name) && Intrinsics.areEqual((Object) this.type, (Object) placeholder.type) && Intrinsics.areEqual((Object) this.logger, (Object) placeholder.logger);
    }

    @NotNull
    public ValueT get(@Nullable TemplateUiData templateUiData, @NotNull Expression<ValueT> expression) throws NullPointerException {
        return Expression.DefaultImpls.get(this, templateUiData, (Placeholder) expression);
    }

    @NotNull
    public final String getName() {
        return this.f30197name;
    }

    @Nullable
    public ValueT getOrNull(@Nullable TemplateUiData templateUiData, @NotNull Expression<ValueT> expression) {
        return Expression.DefaultImpls.getOrNull(this, templateUiData, expression);
    }

    @NotNull
    public final KClass<ValueT> getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.f30197name.hashCode() * 31) + this.type.hashCode()) * 31) + this.logger.hashCode();
    }

    @NotNull
    public String toString() {
        return "Placeholder(name=" + this.f30197name + ", type=" + this.type + ", logger=" + this.logger + ')';
    }

    @NotNull
    public ValueT get(@Nullable TemplateUiData templateUiData, @NotNull ValueT valuet) {
        return Expression.DefaultImpls.get(this, templateUiData, valuet);
    }

    @Nullable
    public ValueT getOrNull(@Nullable TemplateUiData templateUiData) {
        if (templateUiData == null) {
            return null;
        }
        try {
            return KClasses.cast(this.type, ((Expression) MapsKt__MapsKt.getValue(templateUiData.getPlaceholderValues(), this.f30197name)).getOrNull(templateUiData));
        } catch (Throwable th2) {
            LoggerKt.error(this.logger, th2, ErrorTypes.PLACEHOLDER, MapsKt__MapsKt.mapOf(TuplesKt.to("placeholder", this), TuplesKt.to("data", "data")));
            return null;
        }
    }
}
