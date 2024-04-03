package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\f¢\u0006\u0002\u0010\u000e\u001a\\\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0013\u001af\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0015\u001ap\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0017\u001aj\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0019\"\u0004\u0018\u00010\u00122\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u001a\u001a\u0012\u0010\u001b\u001a\u00020\u0003*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003\"!\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"!\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u001e"}, d2 = {"WrapFocusEventModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEventModifier;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function3;", "WrapFocusRequesterModifier", "Landroidx/compose/ui/focus/FocusRequesterModifier;", "composed", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "fullyQualifiedName", "", "key1", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key3", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "keys", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "materialize", "Landroidx/compose/runtime/Composer;", "modifier", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ComposedModifierKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final Function3<FocusEventModifier, Composer, Integer, Modifier> WrapFocusEventModifier = ComposedModifierKt$WrapFocusEventModifier$1.INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public static final Function3<FocusRequesterModifier, Composer, Integer, Modifier> WrapFocusRequesterModifier = ComposedModifierKt$WrapFocusRequesterModifier$1.INSTANCE;

    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull Function1<? super InspectorInfo, Unit> function1, @NotNull Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new ComposedModifier(function1, function3));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, Function1<InspectorInfo, Unit> function1, Function3 function3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, function1, function3);
    }

    @NotNull
    public static final Modifier materialize(@NotNull Composer composer, @NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(composer, "<this>");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if (modifier.all(ComposedModifierKt$materialize$1.INSTANCE)) {
            return modifier;
        }
        composer.startReplaceableGroup(1219399079);
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.Companion, new ComposedModifierKt$materialize$result$1(composer));
        composer.endReplaceableGroup();
        return modifier2;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull String str, @Nullable Object obj, @NotNull Function1<? super InspectorInfo, Unit> function1, @NotNull Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(str, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new KeyedComposedModifier1(str, obj, function1, function3));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Function1<InspectorInfo, Unit> function1, Function3 function3, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, (Function1<? super InspectorInfo, Unit>) function1, (Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier>) function3);
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull String str, @Nullable Object obj, @Nullable Object obj2, @NotNull Function1<? super InspectorInfo, Unit> function1, @NotNull Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(str, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new KeyedComposedModifier2(str, obj, obj2, function1, function3));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, Function1<InspectorInfo, Unit> function1, Function3 function3, int i11, Object obj3) {
        if ((i11 & 8) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, function1, function3);
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull String str, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull Function1<? super InspectorInfo, Unit> function1, @NotNull Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(str, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new KeyedComposedModifier3(str, obj, obj2, obj3, function1, function3));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, Object obj3, Function1<InspectorInfo, Unit> function1, Function3 function3, int i11, Object obj4) {
        if ((i11 & 16) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, obj3, function1, function3);
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull String str, @NotNull Object[] objArr, @NotNull Function1<? super InspectorInfo, Unit> function1, @NotNull Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(str, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(objArr, UserMetadata.KEYDATA_FILENAME);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function3, "factory");
        return modifier.then(new KeyedComposedModifierN(str, objArr, function1, function3));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object[] objArr, Function1<InspectorInfo, Unit> function1, Function3 function3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, objArr, (Function1<? super InspectorInfo, Unit>) function1, (Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier>) function3);
    }
}
