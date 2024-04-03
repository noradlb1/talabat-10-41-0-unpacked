package com.designsystem.ds_navigation_bar;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarKt$DSNavigationBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Float> f32385g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Float> f32386h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f32387i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f32388j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Modifier f32389k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f32390l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarAnimationBehaviour f32391m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32392n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f32393o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBarKt$DSNavigationBar$1(State<Float> state, State<Float> state2, String str, String str2, Modifier modifier, DSIconButtonModel dSIconButtonModel, DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, int i11, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.f32385g = state;
        this.f32386h = state2;
        this.f32387i = str;
        this.f32388j = str2;
        this.f32389k = modifier;
        this.f32390l = dSIconButtonModel;
        this.f32391m = dSNavigationBarAnimationBehaviour;
        this.f32392n = i11;
        this.f32393o = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            String str = this.f32387i;
            String str2 = this.f32388j;
            Modifier modifier = this.f32389k;
            DSIconButtonModel dSIconButtonModel = this.f32390l;
            final Function2<Composer, Integer, Unit> function2 = this.f32393o;
            final int i12 = this.f32392n;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819892883, true, new Function3<Dp, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m8498invoke8Feqmps(((Dp) obj).m5492unboximpl(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                /* renamed from: invoke-8Feqmps  reason: not valid java name */
                public final void m8498invoke8Feqmps(float f11, @Nullable Composer composer, int i11) {
                    int i12;
                    int i13;
                    float f12 = f11;
                    Composer composer2 = composer;
                    if ((i11 & 14) == 0) {
                        if (composer2.changed(f11)) {
                            i13 = 4;
                        } else {
                            i13 = 2;
                        }
                        i12 = i11 | i13;
                    } else {
                        i12 = i11;
                    }
                    if (((i12 & 91) ^ 18) != 0 || !composer.getSkipping()) {
                        Modifier r12 = SizeKt.m565widthInVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m5478constructorimpl(f12 / ((float) 2)), 1, (Object) null);
                        long colorResource = ColorResources_androidKt.colorResource(17170445, composer2, 0);
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i14 = i12;
                        SurfaceKt.m1384SurfaceFjzlyU(r12, (Shape) null, colorResource, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -819893594, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                                    function2.invoke(composer, Integer.valueOf((i14 >> 12) & 14));
                                } else {
                                    composer.skipToGroupEnd();
                                }
                            }
                        }), composer, 1572864, 58);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour = this.f32391m;
            int i13 = this.f32392n;
            NavigationBarComposablesKt.NavigationBarSurface(str, str2, modifier, dSIconButtonModel, composableLambda, dSNavigationBarAnimationBehaviour, this.f32385g.getValue(), this.f32386h.getValue(), composer, ((i13 >> 3) & 14) | CpioConstants.C_ISBLK | ((i13 >> 3) & 112) | ((i13 << 6) & 896) | (i13 & 7168) | (i13 & Opcodes.ASM7));
            return;
        }
        composer.skipToGroupEnd();
    }
}
