package com.designsystem.ds_image;

import android.content.Context;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import coil.request.ImageRequest;
import com.skydoves.landscapist.coil.CoilImageState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSRatioImageKt$DSRatioImage$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31284g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f31285h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f31286i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSImageRatio f31287j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f31288k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Color f31289l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Dp f31290m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31291n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f31292o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ContentScale f31293p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ String f31294q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSRatioImageKt$DSRatioImage$3(Modifier modifier, float f11, float f12, DSImageRatio dSImageRatio, float f13, Color color, Dp dp2, int i11, String str, ContentScale contentScale, String str2) {
        super(2);
        this.f31284g = modifier;
        this.f31285h = f11;
        this.f31286i = f12;
        this.f31287j = dSImageRatio;
        this.f31288k = f13;
        this.f31289l = color;
        this.f31290m = dp2;
        this.f31291n = i11;
        this.f31292o = str;
        this.f31293p = contentScale;
        this.f31294q = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.m544height3ABfNKs(SizeKt.m563width3ABfNKs(this.f31284g, this.f31285h), this.f31286i), this.f31287j.getValue(), false, 2, (Object) null);
            float f11 = this.f31288k;
            Color color = this.f31289l;
            Dp dp2 = this.f31290m;
            final String str = this.f31292o;
            final ContentScale contentScale = this.f31293p;
            final int i12 = this.f31291n;
            final String str2 = this.f31294q;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819894119, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        ImageRequest build = new ImageRequest.Builder((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).data(str).build();
                        Modifier testTag = TestTagKt.testTag(Modifier.Companion, RatioImageComposablesKt.RatioImageTestTag);
                        final ContentScale contentScale = contentScale;
                        final String str = str2;
                        final int i12 = i12;
                        RatioImageComposablesKt.CrossfadedRatioImage(build, contentScale, testTag, ComposableLambdaKt.composableLambda(composer, -819893888, true, new Function3<CoilImageState.Loading, Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((CoilImageState.Loading) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            @Composable
                            public final void invoke(@NotNull CoilImageState.Loading loading, @Nullable Composer composer, int i11) {
                                Intrinsics.checkNotNullParameter(loading, "it");
                                if (((i11 & 81) ^ 16) == 0 && composer.getSkipping()) {
                                    composer.skipToGroupEnd();
                                } else if (str != null) {
                                    composer.startReplaceableGroup(1585278650);
                                    String str = str;
                                    ContentScale contentScale = contentScale;
                                    int i12 = i12;
                                    RatioImageComposablesKt.RatioImageBlurredPlaceholder(str, contentScale, composer, ((i12 >> 15) & 112) | ((i12 >> 9) & 14));
                                    composer.endReplaceableGroup();
                                } else {
                                    composer.startReplaceableGroup(1585278767);
                                    RatioImageComposablesKt.RatioImageLocalPlaceholder(composer, 0);
                                    composer.endReplaceableGroup();
                                }
                            }
                        }), (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) null, ComposableSingletons$DSRatioImageKt.INSTANCE.m8357getLambda1$marshmallow_release(), composer, ((i12 >> 15) & 112) | 3464, 16);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i13 = this.f31291n;
            RatioImageComposablesKt.m8364RatioImageSurfaceyVuOV74(aspectRatio$default, f11, color, dp2, composableLambda, composer, ((i13 >> 18) & 112) | CpioConstants.C_ISBLK | ((i13 >> 18) & 896) | ((i13 >> 18) & 7168));
            return;
        }
        composer.skipToGroupEnd();
    }
}
