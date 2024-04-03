package org.koin.core.definition;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bj\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012'\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\f¢\u0006\u0002\b\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0011¢\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\r\u0010'\u001a\u0006\u0012\u0002\b\u00030\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J*\u0010)\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\f¢\u0006\u0002\b\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u0013\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0011HÆ\u0003J|\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042)\b\u0002\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0011HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u00100\u001a\u00020.2\n\u00101\u001a\u0006\u0012\u0002\b\u00030\u0006J\b\u00102\u001a\u000203H\u0016J$\u00104\u001a\u00020.2\n\u00101\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u00105\u001a\u00020\u0004J\b\u00106\u001a\u000207H\u0016R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R2\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\f¢\u0006\u0002\b\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R$\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00068"}, d2 = {"Lorg/koin/core/definition/BeanDefinition;", "T", "", "scopeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "primaryType", "Lkotlin/reflect/KClass;", "qualifier", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "kind", "Lorg/koin/core/definition/Kind;", "secondaryTypes", "", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function2;Lorg/koin/core/definition/Kind;Ljava/util/List;)V", "callbacks", "Lorg/koin/core/definition/Callbacks;", "getCallbacks", "()Lorg/koin/core/definition/Callbacks;", "setCallbacks", "(Lorg/koin/core/definition/Callbacks;)V", "getDefinition", "()Lkotlin/jvm/functions/Function2;", "getKind", "()Lorg/koin/core/definition/Kind;", "getPrimaryType", "()Lkotlin/reflect/KClass;", "getQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "getScopeQualifier", "getSecondaryTypes", "()Ljava/util/List;", "setSecondaryTypes", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hasType", "clazz", "hashCode", "", "is", "scopeDefinition", "toString", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BeanDefinition<T> {
    @NotNull
    private Callbacks<T> callbacks;
    @NotNull
    private final Function2<Scope, ParametersHolder, T> definition;
    @NotNull
    private final Kind kind;
    @NotNull
    private final KClass<?> primaryType;
    @Nullable
    private final Qualifier qualifier;
    @NotNull
    private final Qualifier scopeQualifier;
    @NotNull
    private List<? extends KClass<?>> secondaryTypes;

    public BeanDefinition(@NotNull Qualifier qualifier2, @NotNull KClass<?> kClass, @Nullable Qualifier qualifier3, @NotNull Function2<? super Scope, ? super ParametersHolder, ? extends T> function2, @NotNull Kind kind2, @NotNull List<? extends KClass<?>> list) {
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        Intrinsics.checkNotNullParameter(kClass, "primaryType");
        Intrinsics.checkNotNullParameter(function2, "definition");
        Intrinsics.checkNotNullParameter(kind2, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(list, "secondaryTypes");
        this.scopeQualifier = qualifier2;
        this.primaryType = kClass;
        this.qualifier = qualifier3;
        this.definition = function2;
        this.kind = kind2;
        this.secondaryTypes = list;
        this.callbacks = new Callbacks<>((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BeanDefinition copy$default(BeanDefinition beanDefinition, Qualifier qualifier2, KClass<?> kClass, Qualifier qualifier3, Function2<Scope, ParametersHolder, T> function2, Kind kind2, List<? extends KClass<?>> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier2 = beanDefinition.scopeQualifier;
        }
        if ((i11 & 2) != 0) {
            kClass = beanDefinition.primaryType;
        }
        KClass<?> kClass2 = kClass;
        if ((i11 & 4) != 0) {
            qualifier3 = beanDefinition.qualifier;
        }
        Qualifier qualifier4 = qualifier3;
        if ((i11 & 8) != 0) {
            function2 = beanDefinition.definition;
        }
        Function2<Scope, ParametersHolder, T> function22 = function2;
        if ((i11 & 16) != 0) {
            kind2 = beanDefinition.kind;
        }
        Kind kind3 = kind2;
        if ((i11 & 32) != 0) {
            list = beanDefinition.secondaryTypes;
        }
        return beanDefinition.copy(qualifier2, kClass2, qualifier4, function22, kind3, list);
    }

    @NotNull
    public final Qualifier component1() {
        return this.scopeQualifier;
    }

    @NotNull
    public final KClass<?> component2() {
        return this.primaryType;
    }

    @Nullable
    public final Qualifier component3() {
        return this.qualifier;
    }

    @NotNull
    public final Function2<Scope, ParametersHolder, T> component4() {
        return this.definition;
    }

    @NotNull
    public final Kind component5() {
        return this.kind;
    }

    @NotNull
    public final List<KClass<?>> component6() {
        return this.secondaryTypes;
    }

    @NotNull
    public final BeanDefinition<T> copy(@NotNull Qualifier qualifier2, @NotNull KClass<?> kClass, @Nullable Qualifier qualifier3, @NotNull Function2<? super Scope, ? super ParametersHolder, ? extends T> function2, @NotNull Kind kind2, @NotNull List<? extends KClass<?>> list) {
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        Intrinsics.checkNotNullParameter(kClass, "primaryType");
        Intrinsics.checkNotNullParameter(function2, "definition");
        Intrinsics.checkNotNullParameter(kind2, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(list, "secondaryTypes");
        return new BeanDefinition(qualifier2, kClass, qualifier3, function2, kind2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            BeanDefinition beanDefinition = (BeanDefinition) obj;
            if (Intrinsics.areEqual((Object) this.primaryType, (Object) beanDefinition.primaryType) && Intrinsics.areEqual((Object) this.qualifier, (Object) beanDefinition.qualifier) && Intrinsics.areEqual((Object) this.scopeQualifier, (Object) beanDefinition.scopeQualifier)) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
    }

    @NotNull
    public final Callbacks<T> getCallbacks() {
        return this.callbacks;
    }

    @NotNull
    public final Function2<Scope, ParametersHolder, T> getDefinition() {
        return this.definition;
    }

    @NotNull
    public final Kind getKind() {
        return this.kind;
    }

    @NotNull
    public final KClass<?> getPrimaryType() {
        return this.primaryType;
    }

    @Nullable
    public final Qualifier getQualifier() {
        return this.qualifier;
    }

    @NotNull
    public final Qualifier getScopeQualifier() {
        return this.scopeQualifier;
    }

    @NotNull
    public final List<KClass<?>> getSecondaryTypes() {
        return this.secondaryTypes;
    }

    public final boolean hasType(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        if (Intrinsics.areEqual((Object) this.primaryType, (Object) kClass) || this.secondaryTypes.contains(kClass)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        Qualifier qualifier2 = this.qualifier;
        if (qualifier2 == null) {
            i11 = 0;
        } else {
            i11 = qualifier2.hashCode();
        }
        return (((i11 * 31) + this.primaryType.hashCode()) * 31) + this.scopeQualifier.hashCode();
    }

    public final boolean is(@NotNull KClass<?> kClass, @Nullable Qualifier qualifier2, @NotNull Qualifier qualifier3) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(qualifier3, "scopeDefinition");
        if (!hasType(kClass) || !Intrinsics.areEqual((Object) this.qualifier, (Object) qualifier2) || !Intrinsics.areEqual((Object) this.scopeQualifier, (Object) qualifier3)) {
            return false;
        }
        return true;
    }

    public final void setCallbacks(@NotNull Callbacks<T> callbacks2) {
        Intrinsics.checkNotNullParameter(callbacks2, "<set-?>");
        this.callbacks = callbacks2;
    }

    public final void setSecondaryTypes(@NotNull List<? extends KClass<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.secondaryTypes = list;
    }

    @NotNull
    public String toString() {
        String str;
        String str2;
        String obj = this.kind.toString();
        String str3 = '\'' + KClassExtKt.getFullName(this.primaryType) + '\'';
        String str4 = "";
        if (this.qualifier == null || (str = Intrinsics.stringPlus(",qualifier:", getQualifier())) == null) {
            str = str4;
        }
        if (Intrinsics.areEqual((Object) this.scopeQualifier, (Object) ScopeRegistry.Companion.getRootScopeQualifier())) {
            str2 = str4;
        } else {
            str2 = Intrinsics.stringPlus(",scope:", getScopeQualifier());
        }
        if (!this.secondaryTypes.isEmpty()) {
            str4 = Intrinsics.stringPlus(",binds:", CollectionsKt___CollectionsKt.joinToString$default(this.secondaryTypes, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, BeanDefinition$toString$defOtherTypes$typesAsString$1.INSTANCE, 30, (Object) null));
        }
        return '[' + obj + AbstractJsonLexerKt.COLON + str3 + str + str2 + str4 + AbstractJsonLexerKt.END_LIST;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeanDefinition(Qualifier qualifier2, KClass kClass, Qualifier qualifier3, Function2 function2, Kind kind2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(qualifier2, kClass, (i11 & 4) != 0 ? null : qualifier3, function2, kind2, (i11 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
