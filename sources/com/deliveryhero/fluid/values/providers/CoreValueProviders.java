package com.deliveryhero.fluid.values.providers;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.expression.reference.providers.ValueProviders;
import com.deliveryhero.fluid.utils.ResourceType;
import com.deliveryhero.fluid.utils.ResourcesUtilsKt;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.ScalableLogicalPixel;
import com.deliveryhero.fluid.widgets.image.ImageAsset;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import com.deliveryhero.fluid.widgets.text.ResourceTextStyle;
import com.deliveryhero.fluid.widgets.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import x4.a;
import x4.b;
import x4.c;
import x4.d;
import x4.e;
import x4.f;
import x4.g;
import x4.h;
import x4.i;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0\u0006\"\b\b\u0000\u0010&*\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0002R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\t¨\u0006*"}, d2 = {"Lcom/deliveryhero/fluid/values/providers/CoreValueProviders;", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "boolean", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "", "getBoolean", "()Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "color", "Lcom/deliveryhero/fluid/values/Color;", "getColor", "float", "", "getFloat", "integer", "", "getInteger", "localImage", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "getLocalImage", "logicalPixel", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "getLogicalPixel", "resources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "scalableLogicalPixel", "Lcom/deliveryhero/fluid/values/ScalableLogicalPixel;", "getScalableLogicalPixel", "string", "", "getString", "textStyle", "Lcom/deliveryhero/fluid/widgets/text/TextStyle;", "getTextStyle", "get", "ValueT", "", "type", "Lkotlin/reflect/KClass;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CoreValueProviders implements ValueProviders {
    @NotNull

    /* renamed from: boolean  reason: not valid java name */
    private final ValueProvider<Boolean> f433boolean;
    @NotNull
    private final ValueProvider<Color> color;
    @NotNull

    /* renamed from: float  reason: not valid java name */
    private final ValueProvider<Float> f434float;
    @NotNull
    private final ValueProvider<Integer> integer;
    @NotNull
    private final ValueProvider<ImageLocator.Local> localImage;
    @NotNull
    private final ValueProvider<LogicalPixel> logicalPixel;
    private final Resources resources;
    @NotNull
    private final ValueProvider<ScalableLogicalPixel> scalableLogicalPixel;
    @NotNull
    private final ValueProvider<String> string;
    @NotNull
    private final ValueProvider<TextStyle> textStyle;

    public CoreValueProviders(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.resources = context.getResources();
        this.f433boolean = new a(context, this);
        this.color = new b(context);
        this.f434float = new c(context, this);
        this.integer = new d(context, this);
        this.logicalPixel = new e(context, this);
        this.scalableLogicalPixel = new f(context, this);
        this.string = new g(context, this);
        this.textStyle = new h(context);
        this.localImage = new i(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: boolean$lambda-0  reason: not valid java name */
    public static final boolean m8180boolean$lambda0(Context context, CoreValueProviders coreValueProviders, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(coreValueProviders, "this$0");
        Intrinsics.checkNotNullParameter(str, "name");
        return coreValueProviders.resources.getBoolean(ResourceType.BOOLEAN.getResourceId(context, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: color$lambda-1  reason: not valid java name */
    public static final Color m8181color$lambda1(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "name");
        return new Color(ContextCompat.getColor(context, ResourceType.COLOR.getResourceId(context, str)));
    }

    /* access modifiers changed from: private */
    /* renamed from: float$lambda-2  reason: not valid java name */
    public static final float m8182float$lambda2(Context context, CoreValueProviders coreValueProviders, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(coreValueProviders, "this$0");
        Intrinsics.checkNotNullParameter(str, "name");
        return ResourcesCompat.getFloat(coreValueProviders.resources, ResourceType.DIMENSION.getResourceId(context, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: integer$lambda-3  reason: not valid java name */
    public static final int m8183integer$lambda3(Context context, CoreValueProviders coreValueProviders, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(coreValueProviders, "this$0");
        Intrinsics.checkNotNullParameter(str, "name");
        return coreValueProviders.resources.getInteger(ResourceType.INTEGER.getResourceId(context, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: localImage$lambda-8  reason: not valid java name */
    public static final ImageLocator.Local m8184localImage$lambda8(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "name");
        return new ImageLocator.Local(new ImageAsset(ResourcesUtilsKt.getDrawableCompat(context, ResourceType.DRAWABLE.getResourceId(context, str), str)));
    }

    /* access modifiers changed from: private */
    /* renamed from: logicalPixel$lambda-4  reason: not valid java name */
    public static final LogicalPixel m8185logicalPixel$lambda4(Context context, CoreValueProviders coreValueProviders, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(coreValueProviders, "this$0");
        Intrinsics.checkNotNullParameter(str, "name");
        return new LogicalPixel(coreValueProviders.resources.getDimension(ResourceType.DIMENSION.getResourceId(context, str)) / context.getResources().getDisplayMetrics().density);
    }

    /* access modifiers changed from: private */
    /* renamed from: scalableLogicalPixel$lambda-5  reason: not valid java name */
    public static final ScalableLogicalPixel m8186scalableLogicalPixel$lambda5(Context context, CoreValueProviders coreValueProviders, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(coreValueProviders, "this$0");
        Intrinsics.checkNotNullParameter(str, "name");
        return new ScalableLogicalPixel(coreValueProviders.resources.getDimension(ResourceType.DIMENSION.getResourceId(context, str)) / context.getResources().getDisplayMetrics().scaledDensity);
    }

    /* access modifiers changed from: private */
    /* renamed from: string$lambda-6  reason: not valid java name */
    public static final String m8187string$lambda6(Context context, CoreValueProviders coreValueProviders, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(coreValueProviders, "this$0");
        Intrinsics.checkNotNullParameter(str, "name");
        return coreValueProviders.resources.getString(ResourceType.STRING.getResourceId(context, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: textStyle$lambda-7  reason: not valid java name */
    public static final TextStyle m8188textStyle$lambda7(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "name");
        return new ResourceTextStyle(ResourceType.STYLE.getResourceId(context, str));
    }

    @NotNull
    public <ValueT> ValueProvider<ValueT> get(@NotNull KClass<ValueT> kClass) {
        boolean z11;
        Intrinsics.checkNotNullParameter(kClass, "type");
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return getBoolean();
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Color.class))) {
            return getColor();
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return getFloat();
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return getInteger();
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(LogicalPixel.class))) {
            return getLogicalPixel();
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(ScalableLogicalPixel.class))) {
            return getScalableLogicalPixel();
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(String.class))) {
            return getString();
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(TextStyle.class))) {
            return getTextStyle();
        }
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(ImageLocator.Local.class))) {
            z11 = true;
        } else {
            z11 = Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(ImageLocator.class));
        }
        if (z11) {
            return getLocalImage();
        }
        throw new IllegalArgumentException("No providers found for value: `" + kClass + '`');
    }

    @NotNull
    public ValueProvider<Boolean> getBoolean() {
        return this.f433boolean;
    }

    @NotNull
    public ValueProvider<Color> getColor() {
        return this.color;
    }

    @NotNull
    public ValueProvider<Float> getFloat() {
        return this.f434float;
    }

    @NotNull
    public ValueProvider<Integer> getInteger() {
        return this.integer;
    }

    @NotNull
    public ValueProvider<ImageLocator.Local> getLocalImage() {
        return this.localImage;
    }

    @NotNull
    public ValueProvider<LogicalPixel> getLogicalPixel() {
        return this.logicalPixel;
    }

    @NotNull
    public ValueProvider<ScalableLogicalPixel> getScalableLogicalPixel() {
        return this.scalableLogicalPixel;
    }

    @NotNull
    public ValueProvider<String> getString() {
        return this.string;
    }

    @NotNull
    public ValueProvider<TextStyle> getTextStyle() {
        return this.textStyle;
    }
}
