package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.newrelic.agent.android.agentdata.HexAttribute;
import fwfd.com.fwfsdk.constant.FWFConstants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum FunctionClassKind {
    Function(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, false),
    SuspendFunction(StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", true, false),
    KFunction(r8, "KFunction", false, true),
    KSuspendFunction(r8, "KSuspendFunction", true, true);
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;
    @NotNull
    private final FqName packageFqName;

    public static final class Companion {

        public static final class KindWithArity {
            private final int arity;
            @NotNull
            private final FunctionClassKind kind;

            public KindWithArity(@NotNull FunctionClassKind functionClassKind, int i11) {
                Intrinsics.checkNotNullParameter(functionClassKind, FWFConstants.EXPLANATION_TYPE_KIND);
                this.kind = functionClassKind;
                this.arity = i11;
            }

            @NotNull
            public final FunctionClassKind component1() {
                return this.kind;
            }

            public final int component2() {
                return this.arity;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof KindWithArity)) {
                    return false;
                }
                KindWithArity kindWithArity = (KindWithArity) obj;
                return this.kind == kindWithArity.kind && this.arity == kindWithArity.arity;
            }

            @NotNull
            public final FunctionClassKind getKind() {
                return this.kind;
            }

            public int hashCode() {
                return (this.kind.hashCode() * 31) + this.arity;
            }

            @NotNull
            public String toString() {
                return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Integer toInt(String str) {
            boolean z11;
            boolean z12;
            if (str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return null;
            }
            int length = str.length();
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                int charAt = str.charAt(i12) - '0';
                if (charAt < 0 || charAt >= 10) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (!z12) {
                    return null;
                }
                i11 = (i11 * 10) + charAt;
            }
            return Integer.valueOf(i11);
        }

        @Nullable
        public final FunctionClassKind byClassNamePrefix(@NotNull FqName fqName, @NotNull String str) {
            boolean z11;
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
            for (FunctionClassKind functionClassKind : FunctionClassKind.values()) {
                if (!Intrinsics.areEqual((Object) functionClassKind.getPackageFqName(), (Object) fqName) || !StringsKt__StringsJVMKt.startsWith$default(str, functionClassKind.getClassNamePrefix(), false, 2, (Object) null)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    return functionClassKind;
                }
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final FunctionClassKind getFunctionalClassKind(@NotNull String str, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            KindWithArity parseClassName = parseClassName(str, fqName);
            if (parseClassName != null) {
                return parseClassName.getKind();
            }
            return null;
        }

        @Nullable
        public final KindWithArity parseClassName(@NotNull String str, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            FunctionClassKind byClassNamePrefix = byClassNamePrefix(fqName, str);
            if (byClassNamePrefix == null) {
                return null;
            }
            String substring = str.substring(byClassNamePrefix.getClassNamePrefix().length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            Integer num = toInt(substring);
            if (num != null) {
                return new KindWithArity(byClassNamePrefix, num.intValue());
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private FunctionClassKind(FqName fqName, String str, boolean z11, boolean z12) {
        this.packageFqName = fqName;
        this.classNamePrefix = str;
        this.isSuspendType = z11;
        this.isReflectType = z12;
    }

    @NotNull
    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @NotNull
    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    @NotNull
    public final Name numberedClassName(int i11) {
        Name identifier = Name.identifier(this.classNamePrefix + i11);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"$classNamePrefix$arity\")");
        return identifier;
    }
}
