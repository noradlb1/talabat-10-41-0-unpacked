package androidx.compose.ui.tooling;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComposeViewAdapter$init$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f10235g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ComposeViewAdapter f10236h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f10237i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f10238j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f10239k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Class<? extends PreviewParameterProvider<?>> f10240l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f10241m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter$init$3(Function0<Unit> function0, ComposeViewAdapter composeViewAdapter, long j11, String str, String str2, Class<? extends PreviewParameterProvider<?>> cls, int i11) {
        super(2);
        this.f10235g = function0;
        this.f10236h = composeViewAdapter;
        this.f10237i = j11;
        this.f10238j = str;
        this.f10239k = str2;
        this.f10240l = cls;
        this.f10241m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            EffectsKt.SideEffect(this.f10235g, composer, 0);
            ComposeViewAdapter composeViewAdapter = this.f10236h;
            final long j11 = this.f10237i;
            final String str = this.f10238j;
            final String str2 = this.f10239k;
            final Class<? extends PreviewParameterProvider<?>> cls = this.f10240l;
            final int i12 = this.f10241m;
            final ComposeViewAdapter composeViewAdapter2 = composeViewAdapter;
            composeViewAdapter.WrapPreview(ComposableLambdaKt.composableLambda(composer, -819908587, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        ComposeViewAdapter$init$3$1$composable$1 composeViewAdapter$init$3$1$composable$1 = new ComposeViewAdapter$init$3$1$composable$1(str, str2, composer, cls, i12, composeViewAdapter2);
                        if (j11 >= 0) {
                            final ComposeViewAdapter composeViewAdapter = composeViewAdapter2;
                            composeViewAdapter.setClock$ui_tooling_release(new PreviewAnimationClock(new Function0<Unit>() {
                                public final void invoke() {
                                    View childAt = composeViewAdapter.getChildAt(0);
                                    if (childAt != null) {
                                        View childAt2 = ((ComposeView) childAt).getChildAt(0);
                                        ViewRootForTest viewRootForTest = childAt2 instanceof ViewRootForTest ? (ViewRootForTest) childAt2 : null;
                                        if (viewRootForTest != null) {
                                            viewRootForTest.invalidateDescendants();
                                        }
                                        Snapshot.Companion.sendApplyNotifications();
                                        return;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
                                }
                            }));
                        }
                        composeViewAdapter$init$3$1$composable$1.invoke();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 70);
            return;
        }
        composer.skipToGroupEnd();
    }
}
