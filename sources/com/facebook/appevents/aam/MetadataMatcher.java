package com.facebook.appevents.aam;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J$\u0010\f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/aam/MetadataMatcher;", "", "()V", "MAX_INDICATOR_LENGTH", "", "getAroundViewIndicators", "", "", "view", "Landroid/view/View;", "getCurrentViewIndicators", "getTextIndicators", "matchIndicator", "", "indicator", "keys", "indicators", "matchValue", "text", "rule", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class MetadataMatcher {
    @NotNull
    public static final MetadataMatcher INSTANCE = new MetadataMatcher();
    private static final int MAX_INDICATOR_LENGTH = 100;

    private MetadataMatcher() {
    }

    @JvmStatic
    @NotNull
    public static final List<String> getAroundViewIndicators(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        ViewGroup parentOfView = ViewHierarchy.getParentOfView(view);
        if (parentOfView != null) {
            for (View next : ViewHierarchy.getChildrenOfView(parentOfView)) {
                if (view != next) {
                    arrayList.addAll(INSTANCE.getTextIndicators(next));
                }
            }
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final List<String> getCurrentViewIndicators(@NotNull View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(ViewHierarchy.getHintOfView(view));
        Object tag = view.getTag();
        if (tag != null) {
            arrayList.add(tag.toString());
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription != null) {
            arrayList.add(contentDescription.toString());
        }
        try {
            if (view.getId() != -1) {
                String resourceName = view.getResources().getResourceName(view.getId());
                Intrinsics.checkNotNullExpressionValue(resourceName, "resourceName");
                Object[] array = new Regex("/").split(resourceName, 0).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    if (strArr.length == 2) {
                        arrayList.add(strArr[1]);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
        } catch (Resources.NotFoundException unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            if (str.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && str.length() <= 100) {
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                arrayList2.add(lowerCase);
            }
        }
        return arrayList2;
    }

    private final List<String> getTextIndicators(View view) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        if (view instanceof EditText) {
            return arrayList;
        }
        if (view instanceof TextView) {
            String obj = ((TextView) view).getText().toString();
            if (obj.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && obj.length() < 100) {
                String lowerCase = obj.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                arrayList.add(lowerCase);
            }
            return arrayList;
        }
        for (View textIndicators : ViewHierarchy.getChildrenOfView(view)) {
            arrayList.addAll(getTextIndicators(textIndicators));
        }
        return arrayList;
    }

    @JvmStatic
    public static final boolean matchIndicator(@NotNull List<String> list, @NotNull List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "indicators");
        Intrinsics.checkNotNullParameter(list2, UserMetadata.KEYDATA_FILENAME);
        for (String matchIndicator : list) {
            if (INSTANCE.matchIndicator(matchIndicator, list2)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean matchValue(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "rule");
        return new Regex(str2).matches(str);
    }

    private final boolean matchIndicator(String str, List<String> list) {
        for (String contains$default : list) {
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) contains$default, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
