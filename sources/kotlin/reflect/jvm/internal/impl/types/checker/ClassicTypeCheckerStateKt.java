package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ClassicTypeCheckerStateKt {
    @NotNull
    public static final TypeCheckerState createClassicTypeCheckerState(boolean z11, boolean z12, @NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypePreparator kotlinTypePreparator, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "typeSystemContext");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new TypeCheckerState(z11, z12, true, classicTypeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }

    public static /* synthetic */ TypeCheckerState createClassicTypeCheckerState$default(boolean z11, boolean z12, ClassicTypeSystemContext classicTypeSystemContext, KotlinTypePreparator kotlinTypePreparator, KotlinTypeRefiner kotlinTypeRefiner, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        if ((i11 & 4) != 0) {
            classicTypeSystemContext = SimpleClassicTypeSystemContext.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            kotlinTypePreparator = KotlinTypePreparator.Default.INSTANCE;
        }
        if ((i11 & 16) != 0) {
            kotlinTypeRefiner = KotlinTypeRefiner.Default.INSTANCE;
        }
        return createClassicTypeCheckerState(z11, z12, classicTypeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }
}
