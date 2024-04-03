package com.facebook.appevents.suggestedevents;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0007R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventViewHierarchy;", "", "()V", "blacklistedViews", "", "Ljava/lang/Class;", "Landroid/view/View;", "getAllClickableViews", "view", "getDictionaryOfView", "Lorg/json/JSONObject;", "clickedView", "getTextOfChildren", "", "getTextOfViewRecursively", "hostView", "updateBasicInfo", "", "json", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class SuggestedEventViewHierarchy {
    @NotNull
    public static final SuggestedEventViewHierarchy INSTANCE = new SuggestedEventViewHierarchy();
    @NotNull
    private static final List<Class<? extends View>> blacklistedViews = CollectionsKt__CollectionsKt.listOf(Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class);

    private SuggestedEventViewHierarchy() {
    }

    @JvmStatic
    @NotNull
    public static final List<View> getAllClickableViews(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        for (Class<? extends View> isInstance : blacklistedViews) {
            if (isInstance.isInstance(view)) {
                return arrayList;
            }
        }
        if (view.isClickable()) {
            arrayList.add(view);
        }
        for (View allClickableViews : ViewHierarchy.getChildrenOfView(view)) {
            arrayList.addAll(getAllClickableViews(allClickableViews));
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final JSONObject getDictionaryOfView(@NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(view2, "clickedView");
        JSONObject jSONObject = new JSONObject();
        if (view == view2) {
            try {
                jSONObject.put(ViewHierarchyConstants.IS_INTERACTED_KEY, true);
            } catch (JSONException unused) {
            }
        }
        updateBasicInfo(view, jSONObject);
        JSONArray jSONArray = new JSONArray();
        for (View dictionaryOfView : ViewHierarchy.getChildrenOfView(view)) {
            jSONArray.put((Object) getDictionaryOfView(dictionaryOfView, view2));
        }
        jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, (Object) jSONArray);
        return jSONObject;
    }

    private final List<String> getTextOfChildren(View view) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        for (View next : ViewHierarchy.getChildrenOfView(view)) {
            String textOfView = ViewHierarchy.getTextOfView(next);
            if (textOfView.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(textOfView);
            }
            arrayList.addAll(getTextOfChildren(next));
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final String getTextOfViewRecursively(@NotNull View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(view, "hostView");
        String textOfView = ViewHierarchy.getTextOfView(view);
        if (textOfView.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return textOfView;
        }
        String join = TextUtils.join(" ", INSTANCE.getTextOfChildren(view));
        Intrinsics.checkNotNullExpressionValue(join, "join(\" \", childrenText)");
        return join;
    }

    @JvmStatic
    public static final void updateBasicInfo(@NotNull View view, @NotNull JSONObject jSONObject) {
        boolean z11;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        try {
            String textOfView = ViewHierarchy.getTextOfView(view);
            String hintOfView = ViewHierarchy.getHintOfView(view);
            jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, (Object) view.getClass().getSimpleName());
            jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, ViewHierarchy.getClassTypeBitmask(view));
            boolean z12 = true;
            if (textOfView.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                jSONObject.put("text", (Object) textOfView);
            }
            if (hintOfView.length() <= 0) {
                z12 = false;
            }
            if (z12) {
                jSONObject.put(ViewHierarchyConstants.HINT_KEY, (Object) hintOfView);
            }
            if (view instanceof EditText) {
                jSONObject.put(ViewHierarchyConstants.INPUT_TYPE_KEY, ((EditText) view).getInputType());
            }
        } catch (JSONException unused) {
        }
    }
}
