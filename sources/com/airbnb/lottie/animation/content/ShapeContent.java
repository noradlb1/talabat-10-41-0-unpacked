package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;

    /* renamed from: name  reason: collision with root package name */
    private final String f40460name;
    private final Path path = new Path();
    private final ShapeKeyframeAnimation shapeAnimation;
    @Nullable
    private List<ShapeModifierContent> shapeModifierContents;
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, ShapePath shapePath) {
        this.f40460name = shapePath.getName();
        this.hidden = shapePath.isHidden();
        this.lottieDrawable = lottieDrawable2;
        ShapeKeyframeAnimation createAnimation = shapePath.getShapePath().createAnimation();
        this.shapeAnimation = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public String getName() {
        return this.f40460name;
    }

    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        Path path2 = (Path) this.shapeAnimation.getValue();
        if (path2 == null) {
            return this.path;
        }
        this.path.set(path2);
        this.path.setFillType(Path.FillType.EVEN_ODD);
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    public void onValueChanged() {
        invalidate();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Content content = list.get(i11);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.b() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
            if (content instanceof ShapeModifierContent) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((ShapeModifierContent) content);
            }
        }
        this.shapeAnimation.setShapeModifiers(arrayList);
    }
}
