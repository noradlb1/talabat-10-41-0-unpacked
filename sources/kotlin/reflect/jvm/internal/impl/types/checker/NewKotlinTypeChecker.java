package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    @NotNull
    public static final Companion Companion = Companion.f24970a;

    public static final class Companion {
        @NotNull
        private static final NewKotlinTypeCheckerImpl Default = new NewKotlinTypeCheckerImpl(KotlinTypeRefiner.Default.INSTANCE, (KotlinTypePreparator) null, 2, (DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f24970a = new Companion();

        private Companion() {
        }

        @NotNull
        public final NewKotlinTypeCheckerImpl getDefault() {
            return Default;
        }
    }

    @NotNull
    KotlinTypeRefiner getKotlinTypeRefiner();

    @NotNull
    OverridingUtil getOverridingUtil();
}
