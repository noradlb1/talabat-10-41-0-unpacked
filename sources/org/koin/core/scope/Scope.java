package org.koin.core.scope;

import com.instabug.library.model.session.config.SessionsConfigParameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.annotation.KoinInternalApi;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.MissingPropertyException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.instance.InstanceContext;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.time.MeasureKt;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010-\u001a\u00020.H\u0002J\u0006\u0010/\u001a\u00020.J\t\u00100\u001a\u00020\u0003HÆ\u0003J\r\u00101\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u000e\u00103\u001a\u00020\nHÀ\u0003¢\u0006\u0002\b4J5\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u001b\u00106\u001a\u00020.2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000008H\u0000¢\u0006\u0002\b9JH\u0010:\u001a\u00020.\"\u0006\b\u0000\u0010;\u0018\u00012\u0006\u0010<\u001a\u0002H;2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?082\b\b\u0002\u0010@\u001a\u00020\bH\b¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003JA\u0010D\u001a\u0004\u0018\u0001H;\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\b\u0010=\u001a\u0004\u0018\u00010\u00032\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0002¢\u0006\u0002\u0010IJA\u0010J\u001a\u0002H;\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`H¢\u0006\u0002\u0010IJA\u0010J\u001a\u0002H;\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0016\b\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\bø\u0001\u0000¢\u0006\u0002\u0010KJ\u001b\u0010L\u001a\b\u0012\u0004\u0012\u0002H;08\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u0001H\bJ\u001e\u0010L\u001a\b\u0012\u0004\u0012\u0002H;08\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?J!\u0010M\u001a\u0004\u0018\u0001H;\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?H\u0002¢\u0006\u0002\u0010NJ\u0006\u0010O\u001a\u00020\nJC\u0010P\u001a\u0004\u0018\u0001H;\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`H¢\u0006\u0002\u0010IJC\u0010P\u001a\u0004\u0018\u0001H;\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0016\b\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\bø\u0001\u0000¢\u0006\u0002\u0010KJ\u001d\u0010Q\u001a\u0002H;\"\b\b\u0000\u0010;*\u00020\u00012\u0006\u0010R\u001a\u00020\u0005¢\u0006\u0002\u0010SJ%\u0010Q\u001a\u0002H;\"\b\b\u0000\u0010;*\u00020\u00012\u0006\u0010R\u001a\u00020\u00052\u0006\u0010T\u001a\u0002H;¢\u0006\u0002\u0010UJ\u001f\u0010V\u001a\u0004\u0018\u0001H;\"\b\b\u0000\u0010;*\u00020\u00012\u0006\u0010R\u001a\u00020\u0005¢\u0006\u0002\u0010SJ\u0012\u0010W\u001a\u00020\u00002\n\u0010X\u001a\u00060\u0005j\u0002`\u0006J\u001c\u0010Y\u001a\u0004\u0018\u0001H;\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u0001H\b¢\u0006\u0002\u0010\u001eJ\t\u0010Z\u001a\u00020[HÖ\u0001JL\u0010\\\u001a\b\u0012\u0004\u0012\u0002H;0]\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010^\u001a\u00020_2\u0016\b\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\bø\u0001\u0000JN\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H;0]\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010^\u001a\u00020_2\u0016\b\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\bø\u0001\u0000J\u0006\u0010a\u001a\u00020\bJ\u001f\u0010b\u001a\u00020.2\u0012\u0010c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000d\"\u00020\u0000¢\u0006\u0002\u0010eJ5\u0010f\u001a\u00020.\"\b\b\u0000\u0010;*\u00020\u00012\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0006\u0010<\u001a\u0002H;¢\u0006\u0002\u0010gJ\u000e\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\u000eJ?\u0010j\u001a\u0002H;\"\u0004\b\u0000\u0010;2\b\u0010=\u001a\u0004\u0018\u00010\u00032\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\u0014\u0010k\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0002¢\u0006\u0002\u0010lJG\u0010m\u001a\u0002H;\"\u0004\b\u0000\u0010;2\b\u0010=\u001a\u0004\u0018\u00010\u00032\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\u0006\u0010n\u001a\u00020o2\u0014\u0010k\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0002¢\u0006\u0002\u0010pJ\u001e\u0010q\u001a\u00020r2\b\u0010=\u001a\u0004\u0018\u00010\u00032\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?H\u0002J\b\u0010s\u001a\u00020\u0005H\u0016J\u001f\u0010t\u001a\u00020.2\u0012\u0010c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000d\"\u00020\u0000¢\u0006\u0002\u0010eR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010#R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00000\rj\b\u0012\u0004\u0012\u00020\u0000`\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u0002\u0007\n\u0005\b20\u0001¨\u0006u"}, d2 = {"Lorg/koin/core/scope/Scope;", "", "scopeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "id", "", "Lorg/koin/core/scope/ScopeID;", "isRoot", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/qualifier/Qualifier;Ljava/lang/String;ZLorg/koin/core/Koin;)V", "_callbacks", "Ljava/util/ArrayList;", "Lorg/koin/core/scope/ScopeCallback;", "Lkotlin/collections/ArrayList;", "_closed", "get_koin$annotations", "()V", "get_koin", "()Lorg/koin/core/Koin;", "_parameterStack", "Lkotlin/collections/ArrayDeque;", "Lorg/koin/core/parameter/ParametersHolder;", "get_parameterStack$annotations", "get_parameterStack", "()Lkotlin/collections/ArrayDeque;", "_source", "get_source$annotations", "get_source", "()Ljava/lang/Object;", "set_source", "(Ljava/lang/Object;)V", "closed", "getClosed", "()Z", "getId", "()Ljava/lang/String;", "linkedScopes", "logger", "Lorg/koin/core/logger/Logger;", "getLogger", "()Lorg/koin/core/logger/Logger;", "getScopeQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "clearData", "", "close", "component1", "component2", "component3", "component4", "component4$koin_core", "copy", "create", "links", "", "create$koin_core", "declare", "T", "instance", "qualifier", "secondaryTypes", "Lkotlin/reflect/KClass;", "allowOverride", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "equals", "other", "findInOtherScope", "clazz", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "get", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getFromSource", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getKoin", "getOrNull", "getProperty", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getPropertyOrNull", "getScope", "scopeID", "getSource", "hashCode", "", "inject", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "injectOrNull", "isNotClosed", "linkTo", "scopes", "", "([Lorg/koin/core/scope/Scope;)V", "refreshScopeInstance", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Ljava/lang/Object;)V", "registerCallback", "callback", "resolveInstance", "parameterDef", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "resolveValue", "instanceContext", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/instance/InstanceContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwDefinitionNotFound", "", "toString", "unlink", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Scope {
    @NotNull
    private final ArrayList<ScopeCallback> _callbacks;
    /* access modifiers changed from: private */
    public boolean _closed;
    @NotNull
    private final Koin _koin;
    @NotNull
    private final ArrayDeque<ParametersHolder> _parameterStack;
    @Nullable
    private Object _source;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f62739id;
    private final boolean isRoot;
    @NotNull
    private final ArrayList<Scope> linkedScopes;
    @NotNull
    private final Qualifier scopeQualifier;

    public Scope(@NotNull Qualifier qualifier, @NotNull String str, boolean z11, @NotNull Koin koin) {
        Intrinsics.checkNotNullParameter(qualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(koin, "_koin");
        this.scopeQualifier = qualifier;
        this.f62739id = str;
        this.isRoot = z11;
        this._koin = koin;
        this.linkedScopes = new ArrayList<>();
        this._callbacks = new ArrayList<>();
        this._parameterStack = new ArrayDeque<>();
    }

    /* access modifiers changed from: private */
    public final void clearData() {
        this._source = null;
        if (this._koin.getLogger().isAt(Level.DEBUG)) {
            Logger logger = this._koin.getLogger();
            logger.info("closing scope:'" + this.f62739id + '\'');
        }
        for (ScopeCallback onScopeClose : this._callbacks) {
            onScopeClose.onScopeClose(this);
        }
        this._callbacks.clear();
    }

    public static /* synthetic */ Scope copy$default(Scope scope, Qualifier qualifier, String str, boolean z11, Koin koin, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = scope.scopeQualifier;
        }
        if ((i11 & 2) != 0) {
            str = scope.f62739id;
        }
        if ((i11 & 4) != 0) {
            z11 = scope.isRoot;
        }
        if ((i11 & 8) != 0) {
            koin = scope._koin;
        }
        return scope.copy(qualifier, str, z11, koin);
    }

    public static /* synthetic */ void declare$default(Scope scope, Object obj, Qualifier qualifier, List list, boolean z11, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i11 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        Intrinsics.checkNotNullParameter(list2, "secondaryTypes");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.INSTANCE;
        Intrinsics.needClassReification();
        koinPlatformTools.m10944synchronized(scope, new Scope$declare$1(scope, obj, qualifier2, list2, z11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0007 A[LOOP:0: B:1:0x0007->B:4:0x0017, LOOP_START, PHI: r1 
      PHI: (r1v1 T) = (r1v0 T), (r1v5 T) binds: [B:0:0x0000, B:4:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T findInOtherScope(kotlin.reflect.KClass<?> r4, org.koin.core.qualifier.Qualifier r5, kotlin.jvm.functions.Function0<? extends org.koin.core.parameter.ParametersHolder> r6) {
        /*
            r3 = this;
            java.util.ArrayList<org.koin.core.scope.Scope> r0 = r3.linkedScopes
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0007:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            java.lang.Object r1 = r0.next()
            org.koin.core.scope.Scope r1 = (org.koin.core.scope.Scope) r1
            java.lang.Object r1 = r1.getOrNull(r4, r5, r6)
            if (r1 == 0) goto L_0x0007
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.findInOtherScope(kotlin.reflect.KClass, org.koin.core.qualifier.Qualifier, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    public static /* synthetic */ Object get$default(Scope scope, Qualifier qualifier, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    private final <T> T getFromSource(KClass<?> kClass) {
        if (kClass.isInstance(this._source)) {
            return this._source;
        }
        return null;
    }

    public static /* synthetic */ Object getOrNull$default(Scope scope, Qualifier qualifier, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    @PublishedApi
    public static /* synthetic */ void get_koin$annotations() {
    }

    @KoinInternalApi
    public static /* synthetic */ void get_parameterStack$annotations() {
    }

    @KoinInternalApi
    public static /* synthetic */ void get_source$annotations() {
    }

    public static /* synthetic */ Lazy inject$default(Scope scope, Qualifier qualifier, LazyThreadSafetyMode lazyThreadSafetyMode, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.needClassReification();
        return LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Scope$inject$1(scope, qualifier, function0));
    }

    public static /* synthetic */ Lazy injectOrNull$default(Scope scope, Qualifier qualifier, LazyThreadSafetyMode lazyThreadSafetyMode, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qualifier = null;
        }
        if ((i11 & 2) != 0) {
            lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.needClassReification();
        return LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Scope$injectOrNull$1(scope, qualifier, function0));
    }

    public static /* synthetic */ void refreshScopeInstance$default(Scope scope, KClass kClass, Qualifier qualifier, Object obj, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            qualifier = null;
        }
        scope.refreshScopeInstance(kClass, qualifier, obj);
    }

    /* access modifiers changed from: private */
    public final <T> T resolveInstance(Qualifier qualifier, KClass<?> kClass, Function0<? extends ParametersHolder> function0) {
        ParametersHolder parametersHolder;
        if (!this._closed) {
            if (function0 == null) {
                parametersHolder = null;
            } else {
                parametersHolder = (ParametersHolder) function0.invoke();
            }
            if (parametersHolder != null) {
                this._koin.getLogger().log(Level.DEBUG, (Function0<String>) new Scope$resolveInstance$1(parametersHolder));
                this._parameterStack.addFirst(parametersHolder);
            }
            T resolveValue = resolveValue(qualifier, kClass, new InstanceContext(this._koin, this, parametersHolder), function0);
            if (parametersHolder != null) {
                this._koin.getLogger().log(Level.DEBUG, (Function0<String>) Scope$resolveInstance$2.INSTANCE);
                this._parameterStack.removeFirstOrNull();
            }
            return resolveValue;
        }
        throw new ClosedScopeException("Scope '" + this.f62739id + "' is closed");
    }

    private final <T> T resolveValue(Qualifier qualifier, KClass<?> kClass, InstanceContext instanceContext, Function0<? extends ParametersHolder> function0) {
        T resolveInstance$koin_core = this._koin.getInstanceRegistry().resolveInstance$koin_core(qualifier, kClass, this.scopeQualifier, instanceContext);
        if (resolveInstance$koin_core == null) {
            Logger logger = get_koin().getLogger();
            Level level = Level.DEBUG;
            logger.log(level, (Function0<String>) new Scope$resolveValue$1$1(kClass, qualifier));
            ParametersHolder firstOrNull = get_parameterStack().firstOrNull();
            T t11 = null;
            if (firstOrNull == null) {
                resolveInstance$koin_core = null;
            } else {
                resolveInstance$koin_core = firstOrNull.getOrNull(kClass);
            }
            if (resolveInstance$koin_core == null) {
                get_koin().getLogger().log(level, (Function0<String>) new Scope$resolveValue$2$1(kClass, qualifier));
                Object obj = get_source();
                if (obj != null && kClass.isInstance(obj)) {
                    t11 = get_source();
                }
                resolveInstance$koin_core = t11;
                if (resolveInstance$koin_core == null) {
                    get_koin().getLogger().log(level, (Function0<String>) new Scope$resolveValue$3$1(kClass, qualifier));
                    resolveInstance$koin_core = findInOtherScope(kClass, qualifier, function0);
                    if (resolveInstance$koin_core == null) {
                        get_parameterStack().clear();
                        get_koin().getLogger().log(level, (Function0<String>) Scope$resolveValue$4$1.INSTANCE);
                        throwDefinitionNotFound(qualifier, kClass);
                        throw new KotlinNothingValueException();
                    }
                }
            }
        }
        return resolveInstance$koin_core;
    }

    private final Void throwDefinitionNotFound(Qualifier qualifier, KClass<?> kClass) {
        String str = "";
        if (qualifier != null) {
            String str2 = " & qualifier:'" + qualifier + '\'';
            if (str2 != null) {
                str = str2;
            }
        }
        throw new NoBeanDefFoundException("|- No definition found for class:'" + KClassExtKt.getFullName(kClass) + '\'' + str + ". Check your definitions!");
    }

    public final void close() {
        KoinPlatformTools.INSTANCE.m10944synchronized(this, new Scope$close$1(this));
    }

    @NotNull
    public final Qualifier component1() {
        return this.scopeQualifier;
    }

    @NotNull
    public final String component2() {
        return this.f62739id;
    }

    public final boolean component3() {
        return this.isRoot;
    }

    @NotNull
    public final Koin component4$koin_core() {
        return this._koin;
    }

    @NotNull
    public final Scope copy(@NotNull Qualifier qualifier, @NotNull String str, boolean z11, @NotNull Koin koin) {
        Intrinsics.checkNotNullParameter(qualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(koin, "_koin");
        return new Scope(qualifier, str, z11, koin);
    }

    public final void create$koin_core(@NotNull List<Scope> list) {
        Intrinsics.checkNotNullParameter(list, "links");
        this.linkedScopes.addAll(list);
    }

    public final /* synthetic */ <T> void declare(T t11, Qualifier qualifier, List<? extends KClass<?>> list, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "secondaryTypes");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.INSTANCE;
        Intrinsics.needClassReification();
        koinPlatformTools.m10944synchronized(this, new Scope$declare$1(this, t11, qualifier, list, z11));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        Scope scope = (Scope) obj;
        return Intrinsics.areEqual((Object) this.scopeQualifier, (Object) scope.scopeQualifier) && Intrinsics.areEqual((Object) this.f62739id, (Object) scope.f62739id) && this.isRoot == scope.isRoot && Intrinsics.areEqual((Object) this._koin, (Object) scope._koin);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final boolean getClosed() {
        return this._closed;
    }

    @NotNull
    public final String getId() {
        return this.f62739id;
    }

    @NotNull
    public final Koin getKoin() {
        return this._koin;
    }

    @NotNull
    public final Logger getLogger() {
        return this._koin.getLogger();
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    @NotNull
    public final <T> T getProperty(@NotNull String str, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(t11, "defaultValue");
        return this._koin.getProperty(str, t11);
    }

    @Nullable
    public final <T> T getPropertyOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this._koin.getProperty(str);
    }

    @NotNull
    public final Scope getScope(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "scopeID");
        return getKoin().getScope(str);
    }

    @NotNull
    public final Qualifier getScopeQualifier() {
        return this.scopeQualifier;
    }

    @Deprecated(message = "No need to use getSource(). You can an use get() directly.", replaceWith = @ReplaceWith(expression = "get()", imports = {}))
    public final /* synthetic */ <T> T getSource() {
        T t11 = get_source();
        Intrinsics.reifiedOperationMarker(2, "T");
        return t11;
    }

    @NotNull
    public final Koin get_koin() {
        return this._koin;
    }

    @NotNull
    public final ArrayDeque<ParametersHolder> get_parameterStack() {
        return this._parameterStack;
    }

    @Nullable
    public final Object get_source() {
        return this._source;
    }

    public int hashCode() {
        int hashCode = ((this.scopeQualifier.hashCode() * 31) + this.f62739id.hashCode()) * 31;
        boolean z11 = this.isRoot;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this._koin.hashCode();
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.needClassReification();
        return LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Scope$inject$1(this, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.needClassReification();
        return LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Scope$injectOrNull$1(this, qualifier, function0));
    }

    public final boolean isNotClosed() {
        return !getClosed();
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    public final void linkTo(@NotNull Scope... scopeArr) {
        Intrinsics.checkNotNullParameter(scopeArr, "scopes");
        if (!this.isRoot) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(this.linkedScopes, (T[]) scopeArr);
            return;
        }
        throw new IllegalStateException("Can't add scope link to a root scope".toString());
    }

    public final <T> void refreshScopeInstance(@NotNull KClass<?> kClass, @Nullable Qualifier qualifier, @NotNull T t11) {
        ScopedInstanceFactory scopedInstanceFactory;
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(t11, "instance");
        if (!this._closed) {
            InstanceFactory<?> resolveDefinition$koin_core = this._koin.getInstanceRegistry().resolveDefinition$koin_core(kClass, qualifier, this.scopeQualifier);
            if (resolveDefinition$koin_core instanceof ScopedInstanceFactory) {
                scopedInstanceFactory = (ScopedInstanceFactory) resolveDefinition$koin_core;
            } else {
                scopedInstanceFactory = null;
            }
            if (scopedInstanceFactory != null) {
                Logger logger = get_koin().getLogger();
                logger.debug("|- '" + KClassExtKt.getFullName(kClass) + "' refresh with " + t11);
                scopedInstanceFactory.refreshInstance(getId(), t11);
                return;
            }
            return;
        }
        throw new ClosedScopeException("Scope '" + this.f62739id + "' is closed");
    }

    public final void registerCallback(@NotNull ScopeCallback scopeCallback) {
        Intrinsics.checkNotNullParameter(scopeCallback, "callback");
        this._callbacks.add(scopeCallback);
    }

    public final void set_source(@Nullable Object obj) {
        this._source = obj;
    }

    @NotNull
    public String toString() {
        return "['" + this.f62739id + "']";
    }

    public final void unlink(@NotNull Scope... scopeArr) {
        Intrinsics.checkNotNullParameter(scopeArr, "scopes");
        if (!this.isRoot) {
            boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(this.linkedScopes, (T[]) scopeArr);
            return;
        }
        throw new IllegalStateException("Can't remove scope link to a root scope".toString());
    }

    public static /* synthetic */ Object get$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            qualifier = null;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        return scope.get(kClass, qualifier, function0);
    }

    public static /* synthetic */ Object getOrNull$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            qualifier = null;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        return scope.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T get(@NotNull KClass<?> kClass, @Nullable Qualifier qualifier, @Nullable Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        if (!this._koin.getLogger().isAt(Level.DEBUG)) {
            return resolveInstance(qualifier, kClass, function0);
        }
        String str = "";
        if (qualifier != null) {
            String str2 = " with qualifier '" + qualifier + '\'';
            if (str2 != null) {
                str = str2;
            }
        }
        this._koin.getLogger().debug("+- '" + KClassExtKt.getFullName(kClass) + '\'' + str);
        Pair measureDurationForResult = MeasureKt.measureDurationForResult(new Scope$get$1(this, qualifier, kClass, function0));
        T component1 = measureDurationForResult.component1();
        double doubleValue = ((Number) measureDurationForResult.component2()).doubleValue();
        this._koin.getLogger().debug("|- '" + KClassExtKt.getFullName(kClass) + "' in " + doubleValue + " ms");
        return component1;
    }

    @NotNull
    public final <T> List<T> getAll(@NotNull KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Collection all$koin_core = this._koin.getInstanceRegistry().getAll$koin_core(kClass, new InstanceContext(this._koin, this, (ParametersHolder) null, 4, (DefaultConstructorMarker) null));
        ArrayList<Scope> arrayList = this.linkedScopes;
        ArrayList arrayList2 = new ArrayList();
        for (Scope all : arrayList) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList2, all.getAll(kClass));
        }
        return CollectionsKt___CollectionsKt.plus(all$koin_core, arrayList2);
    }

    @Nullable
    public final <T> T getOrNull(@NotNull KClass<?> kClass, @Nullable Qualifier qualifier, @Nullable Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        try {
            return get(kClass, qualifier, function0);
        } catch (ClosedScopeException unused) {
            Logger logger = this._koin.getLogger();
            logger.debug("|- Scope closed - no instance found for " + KClassExtKt.getFullName(kClass) + " on scope " + this);
            return null;
        } catch (NoBeanDefFoundException unused2) {
            Logger logger2 = this._koin.getLogger();
            logger2.debug("|- No instance found for " + KClassExtKt.getFullName(kClass) + " on scope " + this);
            return null;
        }
    }

    @NotNull
    public final <T> T getProperty(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        T property = this._koin.getProperty(str);
        if (property != null) {
            return property;
        }
        throw new MissingPropertyException("Property '" + str + "' not found");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Scope(Qualifier qualifier, String str, boolean z11, Koin koin, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(qualifier, str, (i11 & 4) != 0 ? false : z11, koin);
    }
}
