package androidx.navigation.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.ComposeNavigator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavHostKt$NavHost$4 extends Lambda implements Function3<String, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f36412g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<List<NavBackStackEntry>> f36413h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ComposeNavigator f36414i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolder f36415j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$4(MutableState<Boolean> mutableState, State<? extends List<NavBackStackEntry>> state, ComposeNavigator composeNavigator, SaveableStateHolder saveableStateHolder) {
        super(3);
        this.f36412g = mutableState;
        this.f36413h = state;
        this.f36414i = composeNavigator;
        this.f36415j = saveableStateHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull String str, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(str, "it");
        if ((i11 & 14) == 0) {
            i11 |= composer.changed((Object) str) ? 4 : 2;
        }
        if ((i11 & 91) != 18 || !composer.getSkipping()) {
            List r82 = NavHostKt.m9108NavHost$lambda5(this.f36413h);
            ListIterator listIterator = r82.listIterator(r82.size());
            while (listIterator.hasPrevious()) {
                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) listIterator.previous();
                if (Intrinsics.areEqual((Object) str, (Object) navBackStackEntry.getId())) {
                    Unit unit = Unit.INSTANCE;
                    MutableState<Boolean> mutableState = this.f36412g;
                    State<List<NavBackStackEntry>> state = this.f36413h;
                    ComposeNavigator composeNavigator = this.f36414i;
                    composer.startReplaceableGroup(-3686095);
                    boolean changed = composer.changed((Object) mutableState) | composer.changed((Object) state) | composer.changed((Object) composeNavigator);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new NavHostKt$NavHost$4$1$1(mutableState, state, composeNavigator);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceableGroup();
                    EffectsKt.DisposableEffect((Object) unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, composer, 0);
                    NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry, this.f36415j, ComposableLambdaKt.composableLambda(composer, 879893279, true, new Function2<Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(@Nullable Composer composer, int i11) {
                            if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                ((ComposeNavigator.Destination) navBackStackEntry.getDestination()).getContent$navigation_compose_release().invoke(navBackStackEntry, composer, 8);
                            } else {
                                composer.skipToGroupEnd();
                            }
                        }
                    }), composer, 456);
                    return;
                }
            }
            throw new NoSuchElementException("List contains no element matching the predicate.");
        }
        composer.skipToGroupEnd();
    }
}
