package com.designsystem.semantics;

import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\f\u0010\u0011\u001a\u00020\u0006*\u00020\nH\u0000\"\u001d\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"2\u0010\t\u001a\u00020\u0002*\u00020\n2\u0006\u0010\b\u001a\u00020\u00028@@@X\u0002ø\u0001\u0000¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"ElevationKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/unit/Dp;", "getElevationKey", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Invisible", "", "getInvisible", "<set-?>", "elevation", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getElevation", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", "setElevation-3ABfNKs", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;F)V", "elevation$delegate", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "invisible", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SemanticsPropertiesKt {
    @NotNull
    private static final SemanticsPropertyKey<Dp> ElevationKey;
    @NotNull
    private static final SemanticsPropertyKey<Unit> Invisible = new SemanticsPropertyKey<>("Invisible", (Function2) null, 2, (DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f33554a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "elevation", "getElevation(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1))};
    @NotNull
    private static final SemanticsPropertyKey elevation$delegate;

    static {
        SemanticsPropertyKey<Dp> semanticsPropertyKey = new SemanticsPropertyKey<>("ElevationKey", (Function2) null, 2, (DefaultConstructorMarker) null);
        ElevationKey = semanticsPropertyKey;
        elevation$delegate = semanticsPropertyKey;
    }

    public static final float getElevation(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return ((Dp) elevation$delegate.getValue(semanticsPropertyReceiver, f33554a[0])).m5492unboximpl();
    }

    @NotNull
    public static final SemanticsPropertyKey<Dp> getElevationKey() {
        return ElevationKey;
    }

    @NotNull
    public static final SemanticsPropertyKey<Unit> getInvisible() {
        return Invisible;
    }

    public static final void invisible(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(Invisible, Unit.INSTANCE);
    }

    /* renamed from: setElevation-3ABfNKs  reason: not valid java name */
    public static final void m8854setElevation3ABfNKs(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, float f11) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$elevation");
        elevation$delegate.setValue(semanticsPropertyReceiver, f33554a[0], Dp.m5476boximpl(f11));
    }
}
