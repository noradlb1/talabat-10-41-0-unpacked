package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class Layer {
    @Nullable
    private final BlurEffect blurEffect;
    private final LottieComposition composition;
    @Nullable
    private final DropShadowEffect dropShadowEffect;
    private final boolean hidden;
    private final List<Keyframe<Float>> inOutKeyframes;
    private final long layerId;
    private final String layerName;
    private final LayerType layerType;
    private final List<Mask> masks;
    private final MatteType matteType;
    private final long parentId;
    private final int preCompHeight;
    private final int preCompWidth;
    @Nullable
    private final String refId;
    private final List<ContentModel> shapes;
    private final int solidColor;
    private final int solidHeight;
    private final int solidWidth;
    private final float startFrame;
    @Nullable
    private final AnimatableTextFrame text;
    @Nullable
    private final AnimatableTextProperties textProperties;
    @Nullable
    private final AnimatableFloatValue timeRemapping;
    private final float timeStretch;
    private final AnimatableTransform transform;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j11, LayerType layerType2, long j12, @Nullable String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i11, int i12, int i13, float f11, float f12, int i14, int i15, @Nullable AnimatableTextFrame animatableTextFrame, @Nullable AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType2, @Nullable AnimatableFloatValue animatableFloatValue, boolean z11, @Nullable BlurEffect blurEffect2, @Nullable DropShadowEffect dropShadowEffect2) {
        this.shapes = list;
        this.composition = lottieComposition;
        this.layerName = str;
        this.layerId = j11;
        this.layerType = layerType2;
        this.parentId = j12;
        this.refId = str2;
        this.masks = list2;
        this.transform = animatableTransform;
        this.solidWidth = i11;
        this.solidHeight = i12;
        this.solidColor = i13;
        this.timeStretch = f11;
        this.startFrame = f12;
        this.preCompWidth = i14;
        this.preCompHeight = i15;
        this.text = animatableTextFrame;
        this.textProperties = animatableTextProperties;
        this.inOutKeyframes = list3;
        this.matteType = matteType2;
        this.timeRemapping = animatableFloatValue;
        this.hidden = z11;
        this.blurEffect = blurEffect2;
        this.dropShadowEffect = dropShadowEffect2;
    }

    public LottieComposition a() {
        return this.composition;
    }

    public List<Keyframe<Float>> b() {
        return this.inOutKeyframes;
    }

    public List<Mask> c() {
        return this.masks;
    }

    public MatteType d() {
        return this.matteType;
    }

    public String e() {
        return this.layerName;
    }

    public long f() {
        return this.parentId;
    }

    public int g() {
        return this.preCompHeight;
    }

    @Nullable
    public BlurEffect getBlurEffect() {
        return this.blurEffect;
    }

    @Nullable
    public DropShadowEffect getDropShadowEffect() {
        return this.dropShadowEffect;
    }

    public long getId() {
        return this.layerId;
    }

    public LayerType getLayerType() {
        return this.layerType;
    }

    public int h() {
        return this.preCompWidth;
    }

    @Nullable
    public String i() {
        return this.refId;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public List<ContentModel> j() {
        return this.shapes;
    }

    public int k() {
        return this.solidColor;
    }

    public int l() {
        return this.solidHeight;
    }

    public int m() {
        return this.solidWidth;
    }

    public float n() {
        return this.startFrame / this.composition.getDurationFrames();
    }

    @Nullable
    public AnimatableTextFrame o() {
        return this.text;
    }

    @Nullable
    public AnimatableTextProperties p() {
        return this.textProperties;
    }

    @Nullable
    public AnimatableFloatValue q() {
        return this.timeRemapping;
    }

    public float r() {
        return this.timeStretch;
    }

    public AnimatableTransform s() {
        return this.transform;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(e());
        sb2.append(StringUtils.LF);
        Layer layerModelForId = this.composition.layerModelForId(f());
        if (layerModelForId != null) {
            sb2.append("\t\tParents: ");
            sb2.append(layerModelForId.e());
            Layer layerModelForId2 = this.composition.layerModelForId(layerModelForId.f());
            while (layerModelForId2 != null) {
                sb2.append("->");
                sb2.append(layerModelForId2.e());
                layerModelForId2 = this.composition.layerModelForId(layerModelForId2.f());
            }
            sb2.append(str);
            sb2.append(StringUtils.LF);
        }
        if (!c().isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(c().size());
            sb2.append(StringUtils.LF);
        }
        if (!(m() == 0 || l() == 0)) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(m()), Integer.valueOf(l()), Integer.valueOf(k())}));
        }
        if (!this.shapes.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (ContentModel next : this.shapes) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append(next);
                sb2.append(StringUtils.LF);
            }
        }
        return sb2.toString();
    }
}
