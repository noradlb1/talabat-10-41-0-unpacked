package kotlin.reflect.jvm.internal.impl.types;

import com.huawei.location.lite.common.util.filedownload.DownloadConstants;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeCheckerState {
    private final boolean allowedTypeVariable;
    /* access modifiers changed from: private */
    public int argumentsDepth;
    private final boolean isErrorTypeEqualsToAnything;
    private final boolean isStubTypeEqualsToAnything;
    @NotNull
    private final AbstractTypePreparator kotlinTypePreparator;
    @NotNull
    private final AbstractTypeRefiner kotlinTypeRefiner;
    @Nullable
    private ArrayDeque<SimpleTypeMarker> supertypesDeque;
    private boolean supertypesLocked;
    @Nullable
    private Set<SimpleTypeMarker> supertypesSet;
    @NotNull
    private final TypeSystemContext typeSystemContext;

    public interface ForkPointContext {

        public static final class Default implements ForkPointContext {
            private boolean result;

            public void fork(@NotNull Function0<Boolean> function0) {
                Intrinsics.checkNotNullParameter(function0, "block");
                if (!this.result) {
                    this.result = function0.invoke().booleanValue();
                }
            }

            public final boolean getResult() {
                return this.result;
            }
        }

        void fork(@NotNull Function0<Boolean> function0);
    }

    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    public static abstract class SupertypesPolicy {

        public static abstract class DoCustomTransform extends SupertypesPolicy {
            public DoCustomTransform() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class LowerIfFlexible extends SupertypesPolicy {
            @NotNull
            public static final LowerIfFlexible INSTANCE = new LowerIfFlexible();

            private LowerIfFlexible() {
                super((DefaultConstructorMarker) null);
            }

            @NotNull
            public SimpleTypeMarker transformType(@NotNull TypeCheckerState typeCheckerState, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                Intrinsics.checkNotNullParameter(typeCheckerState, "state");
                Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
                return typeCheckerState.getTypeSystemContext().lowerBoundIfFlexible(kotlinTypeMarker);
            }
        }

        public static final class None extends SupertypesPolicy {
            @NotNull
            public static final None INSTANCE = new None();

            private None() {
                super((DefaultConstructorMarker) null);
            }

            @NotNull
            public Void transformType(@NotNull TypeCheckerState typeCheckerState, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                Intrinsics.checkNotNullParameter(typeCheckerState, "state");
                Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        public static final class UpperIfFlexible extends SupertypesPolicy {
            @NotNull
            public static final UpperIfFlexible INSTANCE = new UpperIfFlexible();

            private UpperIfFlexible() {
                super((DefaultConstructorMarker) null);
            }

            @NotNull
            public SimpleTypeMarker transformType(@NotNull TypeCheckerState typeCheckerState, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                Intrinsics.checkNotNullParameter(typeCheckerState, "state");
                Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
                return typeCheckerState.getTypeSystemContext().upperBoundIfFlexible(kotlinTypeMarker);
            }
        }

        private SupertypesPolicy() {
        }

        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public abstract SimpleTypeMarker transformType(@NotNull TypeCheckerState typeCheckerState, @NotNull KotlinTypeMarker kotlinTypeMarker);
    }

    public TypeCheckerState(boolean z11, boolean z12, boolean z13, @NotNull TypeSystemContext typeSystemContext2, @NotNull AbstractTypePreparator abstractTypePreparator, @NotNull AbstractTypeRefiner abstractTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSystemContext2, "typeSystemContext");
        Intrinsics.checkNotNullParameter(abstractTypePreparator, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(abstractTypeRefiner, "kotlinTypeRefiner");
        this.isErrorTypeEqualsToAnything = z11;
        this.isStubTypeEqualsToAnything = z12;
        this.allowedTypeVariable = z13;
        this.typeSystemContext = typeSystemContext2;
        this.kotlinTypePreparator = abstractTypePreparator;
        this.kotlinTypeRefiner = abstractTypeRefiner;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            return typeCheckerState.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    @Nullable
    public Boolean addSubtypeConstraint(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2, boolean z11) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, DownloadConstants.PARAM_SUB_TYPE);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        return null;
    }

    public final void clear() {
        ArrayDeque<SimpleTypeMarker> arrayDeque = this.supertypesDeque;
        Intrinsics.checkNotNull(arrayDeque);
        arrayDeque.clear();
        Set<SimpleTypeMarker> set = this.supertypesSet;
        Intrinsics.checkNotNull(set);
        set.clear();
        this.supertypesLocked = false;
    }

    public boolean customIsSubtypeOf(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, DownloadConstants.PARAM_SUB_TYPE);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        return true;
    }

    @NotNull
    public LowerCapturedTypePolicy getLowerCapturedTypePolicy(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CapturedTypeMarker capturedTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, DownloadConstants.PARAM_SUB_TYPE);
        Intrinsics.checkNotNullParameter(capturedTypeMarker, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    @Nullable
    public final ArrayDeque<SimpleTypeMarker> getSupertypesDeque() {
        return this.supertypesDeque;
    }

    @Nullable
    public final Set<SimpleTypeMarker> getSupertypesSet() {
        return this.supertypesSet;
    }

    @NotNull
    public final TypeSystemContext getTypeSystemContext() {
        return this.typeSystemContext;
    }

    public final void initialize() {
        this.supertypesLocked = true;
        if (this.supertypesDeque == null) {
            this.supertypesDeque = new ArrayDeque<>(4);
        }
        if (this.supertypesSet == null) {
            this.supertypesSet = SmartSet.Companion.create();
        }
    }

    public final boolean isAllowedTypeVariable(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        if (!this.allowedTypeVariable || !this.typeSystemContext.isTypeVariableType(kotlinTypeMarker)) {
            return false;
        }
        return true;
    }

    public final boolean isErrorTypeEqualsToAnything() {
        return this.isErrorTypeEqualsToAnything;
    }

    public final boolean isStubTypeEqualsToAnything() {
        return this.isStubTypeEqualsToAnything;
    }

    @NotNull
    public final KotlinTypeMarker prepareType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        return this.kotlinTypePreparator.prepareType(kotlinTypeMarker);
    }

    @NotNull
    public final KotlinTypeMarker refineType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        return this.kotlinTypeRefiner.refineType(kotlinTypeMarker);
    }

    public boolean runForkingPoint(@NotNull Function1<? super ForkPointContext, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ForkPointContext.Default defaultR = new ForkPointContext.Default();
        function1.invoke(defaultR);
        return defaultR.getResult();
    }
}
