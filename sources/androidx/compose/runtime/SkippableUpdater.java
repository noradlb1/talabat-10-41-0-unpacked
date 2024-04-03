package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0016\u001a\u00020\u00172\u001d\u0010\u0018\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001bH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0001\u0003\u0001\u00020\u0004ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/SkippableUpdater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Lkotlin/ExtensionFunctionType;", "update-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class SkippableUpdater<T> {
    @NotNull
    private final Composer composer;

    private /* synthetic */ SkippableUpdater(Composer composer2) {
        this.composer = composer2;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SkippableUpdater m2526boximpl(Composer composer2) {
        return new SkippableUpdater(composer2);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Composer m2527constructorimpl(@NotNull Composer composer2) {
        Intrinsics.checkNotNullParameter(composer2, "composer");
        return composer2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2528equalsimpl(Composer composer2, Object obj) {
        return (obj instanceof SkippableUpdater) && Intrinsics.areEqual((Object) composer2, (Object) ((SkippableUpdater) obj).m2533unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2529equalsimpl0(Composer composer2, Composer composer3) {
        return Intrinsics.areEqual((Object) composer2, (Object) composer3);
    }

    @PublishedApi
    public static /* synthetic */ void getComposer$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2530hashCodeimpl(Composer composer2) {
        return composer2.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2531toStringimpl(Composer composer2) {
        return "SkippableUpdater(composer=" + composer2 + ')';
    }

    /* renamed from: update-impl  reason: not valid java name */
    public static final void m2532updateimpl(Composer composer2, @NotNull Function1<? super Updater<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        composer2.startReplaceableGroup(509942095);
        function1.invoke(Updater.m2535boximpl(Updater.m2536constructorimpl(composer2)));
        composer2.endReplaceableGroup();
    }

    public boolean equals(Object obj) {
        return m2528equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m2530hashCodeimpl(this.composer);
    }

    public String toString() {
        return m2531toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Composer m2533unboximpl() {
        return this.composer;
    }
}
