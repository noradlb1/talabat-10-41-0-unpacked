package coil.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.huawei.hms.push.AttributionReporter;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0005H\u0000\u001a\u0010\u0010\b\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u0002H\u0000\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u0015\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a\u001e\u0010\u0010\u001a\u0002H\u0011\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0012*\u00020\u0002H\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "resId", "", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getXmlDrawableCompat", "resources", "isPermissionGranted", "", "permission", "", "requireSystemService", "T", "", "(Landroid/content/Context;)Ljava/lang/Object;", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "-Contexts")
/* renamed from: coil.util.-Contexts  reason: invalid class name */
public final class Contexts {
    @NotNull
    public static final Drawable getDrawableCompat(@NotNull Context context, @DrawableRes int i11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Drawable drawable = AppCompatResources.getDrawable(context, i11);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Invalid resource ID: ", Integer.valueOf(i11)).toString());
    }

    @Nullable
    public static final Lifecycle getLifecycle(@Nullable Context context) {
        while (!(context instanceof LifecycleOwner)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return ((LifecycleOwner) context).getLifecycle();
    }

    @NotNull
    @SuppressLint({"ResourceType"})
    public static final Drawable getXmlDrawableCompat(@NotNull Context context, @NotNull Resources resources, @XmlRes int i11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        XmlResourceParser xml = resources.getXml(i11);
        Intrinsics.checkNotNullExpressionValue(xml, "resources.getXml(resId)");
        int next = xml.next();
        while (next != 2 && next != 1) {
            next = xml.next();
        }
        if (next == 2) {
            if (Build.VERSION.SDK_INT < 24) {
                String name2 = xml.getName();
                if (Intrinsics.areEqual((Object) name2, (Object) "vector")) {
                    VectorDrawableCompat createFromXmlInner = VectorDrawableCompat.createFromXmlInner(resources, xml, Xml.asAttributeSet(xml), context.getTheme());
                    Intrinsics.checkNotNullExpressionValue(createFromXmlInner, "createFromXmlInner(resou…es, parser, attrs, theme)");
                    return createFromXmlInner;
                } else if (Intrinsics.areEqual((Object) name2, (Object) "animated-vector")) {
                    AnimatedVectorDrawableCompat createFromXmlInner2 = AnimatedVectorDrawableCompat.createFromXmlInner(context, resources, xml, Xml.asAttributeSet(xml), context.getTheme());
                    Intrinsics.checkNotNullExpressionValue(createFromXmlInner2, "createFromXmlInner(this,…es, parser, attrs, theme)");
                    return createFromXmlInner2;
                }
            }
            return getDrawableCompat(resources, i11, context.getTheme());
        }
        throw new XmlPullParserException("No start tag found.");
    }

    public static final boolean isPermissionGranted(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
        if (ContextCompat.checkSelfPermission(context, str) == 0) {
            return true;
        }
        return false;
    }

    public static final /* synthetic */ <T> T requireSystemService(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        T systemService = ContextCompat.getSystemService(context, cls);
        if (systemService != null) {
            return systemService;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("System service of type ");
        Intrinsics.reifiedOperationMarker(4, "T");
        sb2.append(cls);
        sb2.append(" was not found.");
        throw new IllegalStateException(sb2.toString().toString());
    }

    @NotNull
    public static final Drawable getDrawableCompat(@NotNull Resources resources, @DrawableRes int i11, @Nullable Resources.Theme theme) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        Drawable drawable = ResourcesCompat.getDrawable(resources, i11, theme);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Invalid resource ID: ", Integer.valueOf(i11)).toString());
    }
}
