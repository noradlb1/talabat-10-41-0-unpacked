package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bP\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fJ\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\fHÆ\u0003J\t\u0010T\u001a\u00020\fHÆ\u0003J\t\u0010U\u001a\u00020\fHÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\fHÆ\u0003J\t\u0010Y\u001a\u00020\fHÆ\u0003J\t\u0010Z\u001a\u00020\fHÆ\u0003J\t\u0010[\u001a\u00020\fHÆ\u0003J\t\u0010\\\u001a\u00020\fHÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\t\u0010_\u001a\u00020\u001aHÆ\u0003J\t\u0010`\u001a\u00020\u001aHÆ\u0003J\t\u0010a\u001a\u00020\fHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\t\u0010c\u001a\u00020\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\fHÆ\u0003J\t\u0010i\u001a\u00020\fHÆ\u0003Jû\u0001\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÆ\u0001J\u0013\u0010k\u001a\u00020\u001a2\b\u0010l\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010m\u001a\u00020\u0005HÖ\u0001J\t\u0010n\u001a\u00020oHÖ\u0001R\u001a\u0010\u001c\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u001a\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R\u001a\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u001a\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010!\"\u0004\b6\u0010#R\u001a\u0010\u0018\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010!\"\u0004\b?\u0010#R\u001a\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#R\u001a\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010!\"\u0004\bC\u0010#R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010!\"\u0004\bE\u0010#R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010!\"\u0004\bG\u0010#R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010%\"\u0004\bI\u0010'R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010%R\u001a\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#R\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010!\"\u0004\bN\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010%¨\u0006p"}, d2 = {"Landroidx/compose/ui/platform/DeviceRenderNodeData;", "", "uniqueId", "", "left", "", "top", "right", "bottom", "width", "height", "scaleX", "", "scaleY", "translationX", "translationY", "elevation", "ambientShadowColor", "spotShadowColor", "rotationZ", "rotationX", "rotationY", "cameraDistance", "pivotX", "pivotY", "clipToOutline", "", "clipToBounds", "alpha", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "(JIIIIIIFFFFFIIFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getAmbientShadowColor", "()I", "setAmbientShadowColor", "(I)V", "getBottom", "getCameraDistance", "setCameraDistance", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "getClipToOutline", "setClipToOutline", "getElevation", "setElevation", "getHeight", "getLeft", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getRight", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getRotationZ", "setRotationZ", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getSpotShadowColor", "setSpotShadowColor", "getTop", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getUniqueId", "()J", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeviceRenderNodeData {
    private float alpha;
    private int ambientShadowColor;
    private final int bottom;
    private float cameraDistance;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private float elevation;
    private final int height;
    private final int left;
    private float pivotX;
    private float pivotY;
    @Nullable
    private RenderEffect renderEffect;
    private final int right;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private int spotShadowColor;
    private final int top;
    private float translationX;
    private float translationY;
    private final long uniqueId;
    private final int width;

    public DeviceRenderNodeData(long j11, int i11, int i12, int i13, int i14, int i15, int i16, float f11, float f12, float f13, float f14, float f15, int i17, int i18, float f16, float f17, float f18, float f19, float f21, float f22, boolean z11, boolean z12, float f23, @Nullable RenderEffect renderEffect2) {
        this.uniqueId = j11;
        this.left = i11;
        this.top = i12;
        this.right = i13;
        this.bottom = i14;
        this.width = i15;
        this.height = i16;
        this.scaleX = f11;
        this.scaleY = f12;
        this.translationX = f13;
        this.translationY = f14;
        this.elevation = f15;
        this.ambientShadowColor = i17;
        this.spotShadowColor = i18;
        this.rotationZ = f16;
        this.rotationX = f17;
        this.rotationY = f18;
        this.cameraDistance = f19;
        this.pivotX = f21;
        this.pivotY = f22;
        this.clipToOutline = z11;
        this.clipToBounds = z12;
        this.alpha = f23;
        this.renderEffect = renderEffect2;
    }

    public static /* synthetic */ DeviceRenderNodeData copy$default(DeviceRenderNodeData deviceRenderNodeData, long j11, int i11, int i12, int i13, int i14, int i15, int i16, float f11, float f12, float f13, float f14, float f15, int i17, int i18, float f16, float f17, float f18, float f19, float f21, float f22, boolean z11, boolean z12, float f23, RenderEffect renderEffect2, int i19, Object obj) {
        DeviceRenderNodeData deviceRenderNodeData2 = deviceRenderNodeData;
        int i21 = i19;
        return deviceRenderNodeData.copy((i21 & 1) != 0 ? deviceRenderNodeData2.uniqueId : j11, (i21 & 2) != 0 ? deviceRenderNodeData2.left : i11, (i21 & 4) != 0 ? deviceRenderNodeData2.top : i12, (i21 & 8) != 0 ? deviceRenderNodeData2.right : i13, (i21 & 16) != 0 ? deviceRenderNodeData2.bottom : i14, (i21 & 32) != 0 ? deviceRenderNodeData2.width : i15, (i21 & 64) != 0 ? deviceRenderNodeData2.height : i16, (i21 & 128) != 0 ? deviceRenderNodeData2.scaleX : f11, (i21 & 256) != 0 ? deviceRenderNodeData2.scaleY : f12, (i21 & 512) != 0 ? deviceRenderNodeData2.translationX : f13, (i21 & 1024) != 0 ? deviceRenderNodeData2.translationY : f14, (i21 & 2048) != 0 ? deviceRenderNodeData2.elevation : f15, (i21 & 4096) != 0 ? deviceRenderNodeData2.ambientShadowColor : i17, (i21 & 8192) != 0 ? deviceRenderNodeData2.spotShadowColor : i18, (i21 & 16384) != 0 ? deviceRenderNodeData2.rotationZ : f16, (i21 & 32768) != 0 ? deviceRenderNodeData2.rotationX : f17, (i21 & 65536) != 0 ? deviceRenderNodeData2.rotationY : f18, (i21 & 131072) != 0 ? deviceRenderNodeData2.cameraDistance : f19, (i21 & 262144) != 0 ? deviceRenderNodeData2.pivotX : f21, (i21 & 524288) != 0 ? deviceRenderNodeData2.pivotY : f22, (i21 & 1048576) != 0 ? deviceRenderNodeData2.clipToOutline : z11, (i21 & 2097152) != 0 ? deviceRenderNodeData2.clipToBounds : z12, (i21 & 4194304) != 0 ? deviceRenderNodeData2.alpha : f23, (i21 & 8388608) != 0 ? deviceRenderNodeData2.renderEffect : renderEffect2);
    }

    public final long component1() {
        return this.uniqueId;
    }

    public final float component10() {
        return this.translationX;
    }

    public final float component11() {
        return this.translationY;
    }

    public final float component12() {
        return this.elevation;
    }

    public final int component13() {
        return this.ambientShadowColor;
    }

    public final int component14() {
        return this.spotShadowColor;
    }

    public final float component15() {
        return this.rotationZ;
    }

    public final float component16() {
        return this.rotationX;
    }

    public final float component17() {
        return this.rotationY;
    }

    public final float component18() {
        return this.cameraDistance;
    }

    public final float component19() {
        return this.pivotX;
    }

    public final int component2() {
        return this.left;
    }

    public final float component20() {
        return this.pivotY;
    }

    public final boolean component21() {
        return this.clipToOutline;
    }

    public final boolean component22() {
        return this.clipToBounds;
    }

    public final float component23() {
        return this.alpha;
    }

    @Nullable
    public final RenderEffect component24() {
        return this.renderEffect;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.right;
    }

    public final int component5() {
        return this.bottom;
    }

    public final int component6() {
        return this.width;
    }

    public final int component7() {
        return this.height;
    }

    public final float component8() {
        return this.scaleX;
    }

    public final float component9() {
        return this.scaleY;
    }

    @NotNull
    public final DeviceRenderNodeData copy(long j11, int i11, int i12, int i13, int i14, int i15, int i16, float f11, float f12, float f13, float f14, float f15, int i17, int i18, float f16, float f17, float f18, float f19, float f21, float f22, boolean z11, boolean z12, float f23, @Nullable RenderEffect renderEffect2) {
        return new DeviceRenderNodeData(j11, i11, i12, i13, i14, i15, i16, f11, f12, f13, f14, f15, i17, i18, f16, f17, f18, f19, f21, f22, z11, z12, f23, renderEffect2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceRenderNodeData)) {
            return false;
        }
        DeviceRenderNodeData deviceRenderNodeData = (DeviceRenderNodeData) obj;
        return this.uniqueId == deviceRenderNodeData.uniqueId && this.left == deviceRenderNodeData.left && this.top == deviceRenderNodeData.top && this.right == deviceRenderNodeData.right && this.bottom == deviceRenderNodeData.bottom && this.width == deviceRenderNodeData.width && this.height == deviceRenderNodeData.height && Intrinsics.areEqual((Object) Float.valueOf(this.scaleX), (Object) Float.valueOf(deviceRenderNodeData.scaleX)) && Intrinsics.areEqual((Object) Float.valueOf(this.scaleY), (Object) Float.valueOf(deviceRenderNodeData.scaleY)) && Intrinsics.areEqual((Object) Float.valueOf(this.translationX), (Object) Float.valueOf(deviceRenderNodeData.translationX)) && Intrinsics.areEqual((Object) Float.valueOf(this.translationY), (Object) Float.valueOf(deviceRenderNodeData.translationY)) && Intrinsics.areEqual((Object) Float.valueOf(this.elevation), (Object) Float.valueOf(deviceRenderNodeData.elevation)) && this.ambientShadowColor == deviceRenderNodeData.ambientShadowColor && this.spotShadowColor == deviceRenderNodeData.spotShadowColor && Intrinsics.areEqual((Object) Float.valueOf(this.rotationZ), (Object) Float.valueOf(deviceRenderNodeData.rotationZ)) && Intrinsics.areEqual((Object) Float.valueOf(this.rotationX), (Object) Float.valueOf(deviceRenderNodeData.rotationX)) && Intrinsics.areEqual((Object) Float.valueOf(this.rotationY), (Object) Float.valueOf(deviceRenderNodeData.rotationY)) && Intrinsics.areEqual((Object) Float.valueOf(this.cameraDistance), (Object) Float.valueOf(deviceRenderNodeData.cameraDistance)) && Intrinsics.areEqual((Object) Float.valueOf(this.pivotX), (Object) Float.valueOf(deviceRenderNodeData.pivotX)) && Intrinsics.areEqual((Object) Float.valueOf(this.pivotY), (Object) Float.valueOf(deviceRenderNodeData.pivotY)) && this.clipToOutline == deviceRenderNodeData.clipToOutline && this.clipToBounds == deviceRenderNodeData.clipToBounds && Intrinsics.areEqual((Object) Float.valueOf(this.alpha), (Object) Float.valueOf(deviceRenderNodeData.alpha)) && Intrinsics.areEqual((Object) this.renderEffect, (Object) deviceRenderNodeData.renderEffect);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public final boolean getClipToOutline() {
        return this.clipToOutline;
    }

    public final float getElevation() {
        return this.elevation;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    @Nullable
    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public final int getRight() {
        return this.right;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final int getSpotShadowColor() {
        return this.spotShadowColor;
    }

    public final int getTop() {
        return this.top;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final long getUniqueId() {
        return this.uniqueId;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int a11 = ((((((((((((((((((((((((((((((((((((((a.a(this.uniqueId) * 31) + this.left) * 31) + this.top) * 31) + this.right) * 31) + this.bottom) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.scaleX)) * 31) + Float.floatToIntBits(this.scaleY)) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + Float.floatToIntBits(this.elevation)) * 31) + this.ambientShadowColor) * 31) + this.spotShadowColor) * 31) + Float.floatToIntBits(this.rotationZ)) * 31) + Float.floatToIntBits(this.rotationX)) * 31) + Float.floatToIntBits(this.rotationY)) * 31) + Float.floatToIntBits(this.cameraDistance)) * 31) + Float.floatToIntBits(this.pivotX)) * 31) + Float.floatToIntBits(this.pivotY)) * 31;
        boolean z11 = this.clipToOutline;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (a11 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.clipToBounds;
        if (!z13) {
            z12 = z13;
        }
        int floatToIntBits = (((i11 + (z12 ? 1 : 0)) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        RenderEffect renderEffect2 = this.renderEffect;
        return floatToIntBits + (renderEffect2 == null ? 0 : renderEffect2.hashCode());
    }

    public final void setAlpha(float f11) {
        this.alpha = f11;
    }

    public final void setAmbientShadowColor(int i11) {
        this.ambientShadowColor = i11;
    }

    public final void setCameraDistance(float f11) {
        this.cameraDistance = f11;
    }

    public final void setClipToBounds(boolean z11) {
        this.clipToBounds = z11;
    }

    public final void setClipToOutline(boolean z11) {
        this.clipToOutline = z11;
    }

    public final void setElevation(float f11) {
        this.elevation = f11;
    }

    public final void setPivotX(float f11) {
        this.pivotX = f11;
    }

    public final void setPivotY(float f11) {
        this.pivotY = f11;
    }

    public final void setRenderEffect(@Nullable RenderEffect renderEffect2) {
        this.renderEffect = renderEffect2;
    }

    public final void setRotationX(float f11) {
        this.rotationX = f11;
    }

    public final void setRotationY(float f11) {
        this.rotationY = f11;
    }

    public final void setRotationZ(float f11) {
        this.rotationZ = f11;
    }

    public final void setScaleX(float f11) {
        this.scaleX = f11;
    }

    public final void setScaleY(float f11) {
        this.scaleY = f11;
    }

    public final void setSpotShadowColor(int i11) {
        this.spotShadowColor = i11;
    }

    public final void setTranslationX(float f11) {
        this.translationX = f11;
    }

    public final void setTranslationY(float f11) {
        this.translationY = f11;
    }

    @NotNull
    public String toString() {
        return "DeviceRenderNodeData(uniqueId=" + this.uniqueId + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", width=" + this.width + ", height=" + this.height + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", elevation=" + this.elevation + ", ambientShadowColor=" + this.ambientShadowColor + ", spotShadowColor=" + this.spotShadowColor + ", rotationZ=" + this.rotationZ + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", cameraDistance=" + this.cameraDistance + ", pivotX=" + this.pivotX + ", pivotY=" + this.pivotY + ", clipToOutline=" + this.clipToOutline + ", clipToBounds=" + this.clipToBounds + ", alpha=" + this.alpha + ", renderEffect=" + this.renderEffect + ')';
    }
}
