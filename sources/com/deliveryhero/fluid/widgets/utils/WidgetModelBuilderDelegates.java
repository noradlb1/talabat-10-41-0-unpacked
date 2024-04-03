package com.deliveryhero.fluid.widgets.utils;

import com.braze.models.FeatureFlag;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/deliveryhero/fluid/widgets/utils/WidgetModelBuilderDelegates;", "", "()V", "PropertyGroup", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WidgetModelBuilderDelegates {

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002Bb\u0012.\u0010\u0003\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00050\u0004\"\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0005\u0012+\b\u0002\u0010\u0007\u001a%\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rJ%\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J-\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006H\u0002R1\u0010\u0007\u001a%\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0004¢\u0006\u0002\n\u0000R&\u0010\u0003\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/fluid/widgets/utils/WidgetModelBuilderDelegates$PropertyGroup;", "ValueT", "", "properties", "", "Lkotlin/reflect/KMutableProperty0;", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "onSetValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "([Lkotlin/reflect/KMutableProperty0;Lkotlin/jvm/functions/Function1;)V", "[Lkotlin/reflect/KMutableProperty0;", "getValue", "thisRef", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "property", "Lkotlin/reflect/KProperty;", "setValue", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PropertyGroup<ValueT> {
        @NotNull
        private final Function1<ExpressionBuilder<ValueT>, Unit> onSetValue;
        @NotNull
        private final KMutableProperty0<ExpressionBuilder<ValueT>>[] properties;

        public PropertyGroup(@NotNull KMutableProperty0<ExpressionBuilder<ValueT>>[] kMutableProperty0Arr, @NotNull Function1<? super ExpressionBuilder<ValueT>, Unit> function1) {
            Intrinsics.checkNotNullParameter(kMutableProperty0Arr, FeatureFlag.PROPERTIES);
            Intrinsics.checkNotNullParameter(function1, "onSetValue");
            this.properties = kMutableProperty0Arr;
            this.onSetValue = function1;
        }

        @Nullable
        public final ExpressionBuilder<ValueT> getValue(@NotNull WidgetModelBuilder widgetModelBuilder, @NotNull KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(widgetModelBuilder, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            ExpressionBuilder<ValueT> expressionBuilder = (ExpressionBuilder) ((KMutableProperty0) ArraysKt___ArraysKt.first((T[]) this.properties)).get();
            KMutableProperty0<ExpressionBuilder<ValueT>>[] kMutableProperty0Arr = this.properties;
            int length = kMutableProperty0Arr.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = true;
                    break;
                } else if (!Intrinsics.areEqual((Object) kMutableProperty0Arr[i11].get(), (Object) expressionBuilder)) {
                    break;
                } else {
                    i11++;
                }
            }
            if (z11) {
                return expressionBuilder;
            }
            throw new IllegalArgumentException(("Grouped properties should have the same value. Properties: `" + this.properties + '`').toString());
        }

        public final void setValue(@NotNull WidgetModelBuilder widgetModelBuilder, @NotNull KProperty<?> kProperty, @Nullable ExpressionBuilder<ValueT> expressionBuilder) {
            Intrinsics.checkNotNullParameter(widgetModelBuilder, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            for (KMutableProperty0<ExpressionBuilder<ValueT>> kMutableProperty0 : this.properties) {
                kMutableProperty0.set(expressionBuilder);
            }
            this.onSetValue.invoke(expressionBuilder);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PropertyGroup(KMutableProperty0[] kMutableProperty0Arr, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(kMutableProperty0Arr, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function1);
        }
    }
}
