package kotlin.jvm.optionals;

import j$.util.Optional;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u0000\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005\"\n\b\u0001\u0010\u0001*\u0004\b\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a@\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005\"\n\b\u0001\u0010\u0001*\u0004\b\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a=\u0010\u000f\u001a\u00028\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0010\b\u0001\u0010\r*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\f*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u0001H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002H\u0007\u001a$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002H\u0007\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002H\u0007\u0002\u000b\n\u0002\b9\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"", "T", "j$/util/Optional", "getOrNull", "(Lj$/util/Optional;)Ljava/lang/Object;", "R", "defaultValue", "getOrDefault", "(Lj$/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Lj$/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "C", "destination", "toCollection", "(Lj$/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "", "toList", "", "toSet", "Lkotlin/sequences/Sequence;", "asSequence", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 7, 1})
public final class OptionalsKt {
    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalStdlibApi
    public static final <T> Sequence<T> asSequence(@NotNull Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        if (!optional.isPresent()) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return SequencesKt__SequencesKt.sequenceOf(optional.get());
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [j$.util.Optional<T>, java.lang.Object, j$.util.Optional] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.7")
    @kotlin.ExperimentalStdlibApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R, T extends R> R getOrDefault(@org.jetbrains.annotations.NotNull j$.util.Optional<T> r1, R r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            boolean r0 = r1.isPresent()
            if (r0 == 0) goto L_0x000f
            java.lang.Object r2 = r1.get()
        L_0x000f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.optionals.OptionalsKt.getOrDefault(j$.util.Optional, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [j$.util.Optional<T>, java.lang.Object, j$.util.Optional] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.7")
    @kotlin.ExperimentalStdlibApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R, T extends R> R getOrElse(@org.jetbrains.annotations.NotNull j$.util.Optional<T> r1, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r1.isPresent()
            if (r0 == 0) goto L_0x0015
            java.lang.Object r1 = r1.get()
            goto L_0x0019
        L_0x0015:
            java.lang.Object r1 = r2.invoke()
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.optionals.OptionalsKt.getOrElse(j$.util.Optional, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    @ExperimentalStdlibApi
    public static final <T> T getOrNull(@NotNull Optional<T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return optional.orElse(null);
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalStdlibApi
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Optional<T> optional, @NotNull C c11) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        Intrinsics.checkNotNullParameter(c11, "destination");
        if (optional.isPresent()) {
            T t11 = optional.get();
            Intrinsics.checkNotNullExpressionValue(t11, "get()");
            c11.add(t11);
        }
        return c11;
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalStdlibApi
    public static final <T> List<T> toList(@NotNull Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        if (optional.isPresent()) {
            return CollectionsKt__CollectionsJVMKt.listOf(optional.get());
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalStdlibApi
    public static final <T> Set<T> toSet(@NotNull Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        if (optional.isPresent()) {
            return SetsKt__SetsJVMKt.setOf(optional.get());
        }
        return SetsKt__SetsKt.emptySet();
    }
}
