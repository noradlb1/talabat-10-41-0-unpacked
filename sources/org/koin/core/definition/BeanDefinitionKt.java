package org.koin.core.definition;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aw\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062)\b\b\u0010\u0007\u001a#\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\bj\b\u0012\u0004\u0012\u0002H\u0002`\u000b¢\u0006\u0002\b\f2\u0012\b\u0002\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\bø\u0001\u0000\u001a$\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0006*>\u0010\u0015\u001a\u0004\b\u0000\u0010\u0002\"\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\b¢\u0006\u0002\b\f2\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\b¢\u0006\u0002\b\f*\n\u0010\u0016\"\u00020\u00122\u00020\u0012\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"createDefinition", "Lorg/koin/core/definition/BeanDefinition;", "T", "kind", "Lorg/koin/core/definition/Kind;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "scopeQualifier", "indexKey", "", "clazz", "typeQualifier", "Definition", "IndexKey", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BeanDefinitionKt {
    public static final /* synthetic */ <T> BeanDefinition<T> createDefinition(Kind kind, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2, List<? extends KClass<?>> list, Qualifier qualifier2) {
        Intrinsics.checkNotNullParameter(kind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(function2, "definition");
        Intrinsics.checkNotNullParameter(list, "secondaryTypes");
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, list);
    }

    public static /* synthetic */ BeanDefinition createDefinition$default(Kind kind, Qualifier qualifier, Function2 function2, List list, Qualifier qualifier2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            kind = Kind.Singleton;
        }
        Kind kind2 = kind;
        if ((i11 & 2) != 0) {
            qualifier = null;
        }
        Qualifier qualifier3 = qualifier;
        if ((i11 & 8) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        Intrinsics.checkNotNullParameter(kind2, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(function2, "definition");
        Intrinsics.checkNotNullParameter(list2, "secondaryTypes");
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(Object.class), qualifier3, function2, kind2, list2);
    }

    @NotNull
    public static final String indexKey(@NotNull KClass<?> kClass, @Nullable Qualifier qualifier, @NotNull Qualifier qualifier2) {
        String value;
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(qualifier2, "scopeQualifier");
        String str = "";
        if (!(qualifier == null || (value = qualifier.getValue()) == null)) {
            str = value;
        }
        return KClassExtKt.getFullName(kClass) + AbstractJsonLexerKt.COLON + str + AbstractJsonLexerKt.COLON + qualifier2;
    }
}
