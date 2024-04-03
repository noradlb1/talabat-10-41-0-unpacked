package androidx.navigation.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogNavigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DialogHostKt$DialogHost$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f36367g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolder f36368h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DialogNavigator f36369i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DialogNavigator.Destination f36370j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogHostKt$DialogHost$1$2(NavBackStackEntry navBackStackEntry, SaveableStateHolder saveableStateHolder, DialogNavigator dialogNavigator, DialogNavigator.Destination destination) {
        super(2);
        this.f36367g = navBackStackEntry;
        this.f36368h = saveableStateHolder;
        this.f36369i = dialogNavigator;
        this.f36370j = destination;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            final NavBackStackEntry navBackStackEntry = this.f36367g;
            final DialogNavigator dialogNavigator = this.f36369i;
            EffectsKt.DisposableEffect((Object) navBackStackEntry, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    return new DialogHostKt$DialogHost$1$2$1$invoke$$inlined$onDispose$1(dialogNavigator, navBackStackEntry);
                }
            }, composer, 8);
            final NavBackStackEntry navBackStackEntry2 = this.f36367g;
            SaveableStateHolder saveableStateHolder = this.f36368h;
            final DialogNavigator.Destination destination = this.f36370j;
            NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry2, saveableStateHolder, ComposableLambdaKt.composableLambda(composer, -497631156, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        destination.getContent$navigation_compose_release().invoke(navBackStackEntry2, composer, 8);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 456);
            return;
        }
        composer.skipToGroupEnd();
    }
}
