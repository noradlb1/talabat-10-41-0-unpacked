package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.checkout.frames.utils.constants.CountryPickerScreenConstants;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\t\u001a8\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001aR\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0000\u001a \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a$\u0010\u001f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"DefaultSelectionHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLandroidx/compose/runtime/Composer;I)V", "HandlePopup", "position", "Landroidx/compose/ui/geometry/Offset;", "handleReferencePoint", "Landroidx/compose/foundation/text/selection/HandleReferencePoint;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "HandlePopup-ULxng0E", "(JLandroidx/compose/foundation/text/selection/HandleReferencePoint;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "SelectionHandle-8fL75-g", "(JZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isHandleLtrDirection", "areHandlesCrossed", "isLeft", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "", "drawSelectionHandle", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidSelectionHandles_androidKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DefaultSelectionHandle(@NotNull Modifier modifier, boolean z11, @NotNull ResolvedTextDirection resolvedTextDirection, boolean z12, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(resolvedTextDirection, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        Composer startRestartGroup = composer.startRestartGroup(47957398);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) resolvedTextDirection)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i11 & 7168) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        if ((i12 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(47957398, i11, -1, "androidx.compose.foundation.text.selection.DefaultSelectionHandle (AndroidSelectionHandles.android.kt:95)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m560sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), z11, resolvedTextDirection, z12), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$DefaultSelectionHandle$1(modifier, z11, resolvedTextDirection, z12, i11));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.compose.foundation.text.selection.HandlePositionProvider} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: HandlePopup-ULxng0E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m943HandlePopupULxng0E(long r24, @org.jetbrains.annotations.NotNull androidx.compose.foundation.text.selection.HandleReferencePoint r26, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29) {
        /*
            r3 = r26
            r11 = r27
            r12 = r29
            java.lang.String r0 = "handleReferencePoint"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1409050158(0xffffffffac0399d2, float:-1.8701607E-12)
            r1 = r28
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r2 = r12 & 14
            r13 = r24
            if (r2 != 0) goto L_0x002a
            boolean r2 = r1.changed((long) r13)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r12
            goto L_0x002b
        L_0x002a:
            r2 = r12
        L_0x002b:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x003b
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0038
            r4 = 32
            goto L_0x003a
        L_0x0038:
            r4 = 16
        L_0x003a:
            r2 = r2 | r4
        L_0x003b:
            r4 = r12 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x004b
            boolean r4 = r1.changed((java.lang.Object) r11)
            if (r4 == 0) goto L_0x0048
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x004a
        L_0x0048:
            r4 = 128(0x80, float:1.794E-43)
        L_0x004a:
            r2 = r2 | r4
        L_0x004b:
            r4 = r2 & 731(0x2db, float:1.024E-42)
            r5 = 146(0x92, float:2.05E-43)
            if (r4 != r5) goto L_0x005d
            boolean r4 = r1.getSkipping()
            if (r4 != 0) goto L_0x0058
            goto L_0x005d
        L_0x0058:
            r1.skipToGroupEnd()
            goto L_0x00d8
        L_0x005d:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0069
            r4 = -1
            java.lang.String r5 = "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:224)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r2, r4, r5)
        L_0x0069:
            float r0 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r24)
            int r0 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r0)
            float r4 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r24)
            int r4 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r4)
            long r4 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r0, r4)
            androidx.compose.ui.unit.IntOffset r0 = androidx.compose.ui.unit.IntOffset.m5587boximpl(r4)
            r6 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r6)
            boolean r6 = r1.changed((java.lang.Object) r3)
            boolean r0 = r1.changed((java.lang.Object) r0)
            r0 = r0 | r6
            java.lang.Object r6 = r1.rememberedValue()
            if (r0 != 0) goto L_0x009e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r6 != r0) goto L_0x00a7
        L_0x009e:
            androidx.compose.foundation.text.selection.HandlePositionProvider r6 = new androidx.compose.foundation.text.selection.HandlePositionProvider
            r0 = 0
            r6.<init>(r3, r4, r0)
            r1.updateRememberedValue(r6)
        L_0x00a7:
            r1.endReplaceableGroup()
            r4 = r6
            androidx.compose.foundation.text.selection.HandlePositionProvider r4 = (androidx.compose.foundation.text.selection.HandlePositionProvider) r4
            r5 = 0
            androidx.compose.ui.window.PopupProperties r6 = new androidx.compose.ui.window.PopupProperties
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 1
            r21 = 0
            r22 = 15
            r23 = 0
            r15 = r6
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23)
            int r0 = r2 << 3
            r9 = r0 & 7168(0x1c00, float:1.0045E-41)
            r10 = 2
            r7 = r27
            r8 = r1
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00d8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00d8:
            androidx.compose.runtime.ScopeUpdateScope r6 = r1.endRestartGroup()
            if (r6 != 0) goto L_0x00df
            goto L_0x00f0
        L_0x00df:
            androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$HandlePopup$1 r7 = new androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$HandlePopup$1
            r0 = r7
            r1 = r24
            r3 = r26
            r4 = r27
            r5 = r29
            r0.<init>(r1, r3, r4, r5)
            r6.updateScope(r7)
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.m943HandlePopupULxng0E(long, androidx.compose.foundation.text.selection.HandleReferencePoint, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: SelectionHandle-8fL75-g  reason: not valid java name */
    public static final void m944SelectionHandle8fL75g(long j11, boolean z11, @NotNull ResolvedTextDirection resolvedTextDirection, boolean z12, @NotNull Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        HandleReferencePoint handleReferencePoint;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        ResolvedTextDirection resolvedTextDirection2 = resolvedTextDirection;
        Modifier modifier2 = modifier;
        int i19 = i11;
        Intrinsics.checkNotNullParameter(resolvedTextDirection2, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-616295642);
        long j12 = j11;
        if ((i19 & 14) == 0) {
            if (startRestartGroup.changed(j12)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i12 = i18 | i19;
        } else {
            i12 = i19;
        }
        boolean z13 = z11;
        if ((i19 & 112) == 0) {
            if (startRestartGroup.changed(z13)) {
                i17 = 32;
            } else {
                i17 = 16;
            }
            i12 |= i17;
        }
        if ((i19 & 896) == 0) {
            if (startRestartGroup.changed((Object) resolvedTextDirection2)) {
                i16 = 256;
            } else {
                i16 = 128;
            }
            i12 |= i16;
        }
        boolean z14 = z12;
        if ((i19 & 7168) == 0) {
            if (startRestartGroup.changed(z14)) {
                i15 = 2048;
            } else {
                i15 = 1024;
            }
            i12 |= i15;
        }
        if ((57344 & i19) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i14 = 16384;
            } else {
                i14 = 8192;
            }
            i12 |= i14;
        }
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        if ((458752 & i19) == 0) {
            if (startRestartGroup.changed((Object) function22)) {
                i13 = 131072;
            } else {
                i13 = 65536;
            }
            i12 |= i13;
        }
        int i21 = i12;
        if ((374491 & i21) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-616295642, i21, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:53)");
            }
            if (isLeft(z11, resolvedTextDirection, z12)) {
                handleReferencePoint = HandleReferencePoint.TopRight;
            } else {
                handleReferencePoint = HandleReferencePoint.TopLeft;
            }
            HandleReferencePoint handleReferencePoint2 = handleReferencePoint;
            AndroidSelectionHandles_androidKt$SelectionHandle$1 androidSelectionHandles_androidKt$SelectionHandle$1 = r0;
            AndroidSelectionHandles_androidKt$SelectionHandle$1 androidSelectionHandles_androidKt$SelectionHandle$12 = new AndroidSelectionHandles_androidKt$SelectionHandle$1(function2, modifier, z11, j11, i21, resolvedTextDirection, z12);
            m943HandlePopupULxng0E(j11, handleReferencePoint2, ComposableLambdaKt.composableLambda(startRestartGroup, 732099485, true, androidSelectionHandles_androidKt$SelectionHandle$1), startRestartGroup, (i21 & 14) | RendererCapabilities.MODE_SUPPORT_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$SelectionHandle$2(j11, z11, resolvedTextDirection, z12, modifier, function2, i11));
        }
    }

    @NotNull
    public static final ImageBitmap createHandleImage(@NotNull CacheDrawScope cacheDrawScope, float f11) {
        CacheDrawScope cacheDrawScope2 = cacheDrawScope;
        float f12 = f11;
        Intrinsics.checkNotNullParameter(cacheDrawScope2, "<this>");
        int ceil = ((int) ((float) Math.ceil((double) f12))) * 2;
        HandleImageCache handleImageCache = HandleImageCache.INSTANCE;
        ImageBitmap imageBitmap = handleImageCache.getImageBitmap();
        Canvas canvas = handleImageCache.getCanvas();
        CanvasDrawScope canvasDrawScope = handleImageCache.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || ceil > imageBitmap.getWidth() || ceil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m3095ImageBitmapx__hDU$default(ceil, ceil, ImageBitmapConfig.Companion.m3089getAlpha8_sVssgQ(), false, (ColorSpace) null, 24, (Object) null);
            handleImageCache.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            handleImageCache.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            handleImageCache.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        long Size = androidx.compose.ui.geometry.SizeKt.Size((float) imageBitmap2.getWidth(), (float) imageBitmap2.getHeight());
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long r72 = drawParams.m3375component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope2);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m3378setSizeuvyYCjk(Size);
        canvas2.save();
        CanvasDrawScope canvasDrawScope3 = canvasDrawScope2;
        b.K(canvasDrawScope3, Color.Companion.m2945getBlack0d7_KjU(), 0, canvasDrawScope2.m3425getSizeNHjbRc(), 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m2830getClear0nO6VwU(), 58, (Object) null);
        b.K(canvasDrawScope3, ColorKt.Color((long) CountryPickerScreenConstants.focusedBorderColor), Offset.Companion.m2692getZeroF1C5BW0(), androidx.compose.ui.geometry.SizeKt.Size(f12, f12), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
        ImageBitmap imageBitmap3 = imageBitmap2;
        b.x(canvasDrawScope2, ColorKt.Color((long) CountryPickerScreenConstants.focusedBorderColor), f11, OffsetKt.Offset(f12, f12), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m3378setSizeuvyYCjk(r72);
        return imageBitmap3;
    }

    @NotNull
    public static final Modifier drawSelectionHandle(@NotNull Modifier modifier, boolean z11, @NotNull ResolvedTextDirection resolvedTextDirection, boolean z12) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(resolvedTextDirection, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new AndroidSelectionHandles_androidKt$drawSelectionHandle$1(z11, resolvedTextDirection, z12), 1, (Object) null);
    }

    public static final boolean isHandleLtrDirection(@NotNull ResolvedTextDirection resolvedTextDirection, boolean z11) {
        Intrinsics.checkNotNullParameter(resolvedTextDirection, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        if ((resolvedTextDirection != ResolvedTextDirection.Ltr || z11) && (resolvedTextDirection != ResolvedTextDirection.Rtl || !z11)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean isLeft(boolean z11, ResolvedTextDirection resolvedTextDirection, boolean z12) {
        if (z11) {
            return isHandleLtrDirection(resolvedTextDirection, z12);
        }
        if (!isHandleLtrDirection(resolvedTextDirection, z12)) {
            return true;
        }
        return false;
    }
}
