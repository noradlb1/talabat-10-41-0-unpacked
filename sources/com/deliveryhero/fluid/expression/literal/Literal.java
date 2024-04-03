package com.deliveryhero.fluid.expression.literal;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u0019\u0010\u000f\u001a\u0004\u0018\u00018\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/fluid/expression/literal/Literal;", "ValueT", "", "Lcom/deliveryhero/fluid/expression/Expression;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/deliveryhero/fluid/expression/literal/Literal;", "equals", "", "other", "getOrNull", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "(Lcom/deliveryhero/fluid/template/data/TemplateUiData;)Ljava/lang/Object;", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Literal<ValueT> implements Expression<ValueT> {
    @Nullable
    private final ValueT value;

    public Literal(@Nullable ValueT valuet) {
        this.value = valuet;
    }

    public static /* synthetic */ Literal copy$default(Literal literal, ValueT valuet, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            valuet = literal.value;
        }
        return literal.copy(valuet);
    }

    @Nullable
    public final ValueT component1() {
        return this.value;
    }

    @NotNull
    public final Literal<ValueT> copy(@Nullable ValueT valuet) {
        return new Literal<>(valuet);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Literal) && Intrinsics.areEqual((Object) this.value, (Object) ((Literal) obj).value);
    }

    @NotNull
    public ValueT get(@Nullable TemplateUiData templateUiData, @NotNull Expression<ValueT> expression) throws NullPointerException {
        return Expression.DefaultImpls.get(this, templateUiData, (Literal) expression);
    }

    @Nullable
    public ValueT getOrNull(@Nullable TemplateUiData templateUiData, @NotNull Expression<ValueT> expression) {
        return Expression.DefaultImpls.getOrNull(this, templateUiData, expression);
    }

    @Nullable
    public final ValueT getValue() {
        return this.value;
    }

    public int hashCode() {
        ValueT valuet = this.value;
        if (valuet == null) {
            return 0;
        }
        return valuet.hashCode();
    }

    @NotNull
    public String toString() {
        return "Literal(value=" + this.value + ')';
    }

    @NotNull
    public ValueT get(@Nullable TemplateUiData templateUiData, @NotNull ValueT valuet) {
        return Expression.DefaultImpls.get(this, templateUiData, valuet);
    }

    @Nullable
    public ValueT getOrNull(@Nullable TemplateUiData templateUiData) {
        return this.value;
    }
}
