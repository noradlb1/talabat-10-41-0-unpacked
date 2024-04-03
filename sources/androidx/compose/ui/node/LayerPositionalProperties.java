package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/node/LayerPositionalProperties;", "", "()V", "cameraDistance", "", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "translationX", "translationY", "copyFrom", "", "scope", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "other", "hasSameValuesAs", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class LayerPositionalProperties {
    private float cameraDistance = 8.0f;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private long transformOrigin = TransformOrigin.Companion.m3292getCenterSzJe1aQ();
    private float translationX;
    private float translationY;

    public final void copyFrom(@NotNull LayerPositionalProperties layerPositionalProperties) {
        Intrinsics.checkNotNullParameter(layerPositionalProperties, "other");
        this.scaleX = layerPositionalProperties.scaleX;
        this.scaleY = layerPositionalProperties.scaleY;
        this.translationX = layerPositionalProperties.translationX;
        this.translationY = layerPositionalProperties.translationY;
        this.rotationX = layerPositionalProperties.rotationX;
        this.rotationY = layerPositionalProperties.rotationY;
        this.rotationZ = layerPositionalProperties.rotationZ;
        this.cameraDistance = layerPositionalProperties.cameraDistance;
        this.transformOrigin = layerPositionalProperties.transformOrigin;
    }

    public final boolean hasSameValuesAs(@NotNull LayerPositionalProperties layerPositionalProperties) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(layerPositionalProperties, "other");
        if (this.scaleX == layerPositionalProperties.scaleX) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (this.scaleY == layerPositionalProperties.scaleY) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (this.translationX == layerPositionalProperties.translationX) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    if (this.translationY == layerPositionalProperties.translationY) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        if (this.rotationX == layerPositionalProperties.rotationX) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if (z15) {
                            if (this.rotationY == layerPositionalProperties.rotationY) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                if (this.rotationZ == layerPositionalProperties.rotationZ) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17) {
                                    if (this.cameraDistance == layerPositionalProperties.cameraDistance) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z18 && TransformOrigin.m3286equalsimpl0(this.transformOrigin, layerPositionalProperties.transformOrigin)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void copyFrom(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "scope");
        this.scaleX = graphicsLayerScope.getScaleX();
        this.scaleY = graphicsLayerScope.getScaleY();
        this.translationX = graphicsLayerScope.getTranslationX();
        this.translationY = graphicsLayerScope.getTranslationY();
        this.rotationX = graphicsLayerScope.getRotationX();
        this.rotationY = graphicsLayerScope.getRotationY();
        this.rotationZ = graphicsLayerScope.getRotationZ();
        this.cameraDistance = graphicsLayerScope.getCameraDistance();
        this.transformOrigin = graphicsLayerScope.m3061getTransformOriginSzJe1aQ();
    }
}
