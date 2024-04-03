package com.instabug.bug.screenshot.viewhierarchy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.R;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.instabug.library.util.InstabugSDKLogger;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e {
    private static Rect a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        return new Rect(i11, iArr[1], view.getWidth() + i11, iArr[1] + view.getHeight());
    }

    private static String a(int i11) {
        switch (i11) {
            case 0:
                return "leftOf";
            case 1:
                return "rightOf";
            case 2:
                return "above";
            case 3:
                return "below";
            case 4:
                return "alignBaseline";
            case 5:
                return "alignLeft";
            case 6:
                return "alignTop";
            case 7:
                return "alignRight";
            case 8:
                return "alignBottom";
            case 9:
                return "alignParentLeft";
            case 10:
                return "alignParentTop";
            case 11:
                return "alignParentRight";
            case 12:
                return "alignParentBottom";
            case 13:
                return "centerInParent";
            case 14:
                return "centerHorizontal";
            case 15:
                return "centerVertical";
            case 16:
                return "startOf";
            case 18:
                return "alignStart";
            case 19:
                return "alignEnd";
            case 20:
                return "alignParentStart";
            case 21:
                return "alignParentEnd";
            default:
                return "notIdentified";
        }
    }

    private static String a(Context context, int i11) {
        if (i11 == -1) {
            return String.valueOf(i11);
        }
        if (context != null) {
            try {
                if (!(context.getResources() == null || context.getResources().getResourceEntryName(i11) == null)) {
                    return context.getResources().getResourceEntryName(i11);
                }
            } catch (Resources.NotFoundException unused) {
                return String.valueOf(i11);
            }
        }
        return String.valueOf(i11);
    }

    public static JSONObject a(Activity activity, int i11) {
        return new JSONObject().put("w", activity.getWindow().getDecorView().getWidth() / i11).put("h", activity.getWindow().getDecorView().getHeight() / i11);
    }

    private static void a(Context context, RelativeLayout.LayoutParams layoutParams, JSONObject jSONObject) {
        jSONObject.put("margin_top", layoutParams.topMargin).put("margin_bottom", layoutParams.bottomMargin).put("margin_left", layoutParams.leftMargin).put("margin_right", layoutParams.rightMargin);
        int[] rules = layoutParams.getRules();
        for (int i11 = 0; i11 < rules.length; i11++) {
            int i12 = rules[i11];
            jSONObject.put(a(i11), (Object) i12 > 0 ? a(context, i12) : String.valueOf(i12));
        }
    }

    private static void a(FrameLayout.LayoutParams layoutParams, JSONObject jSONObject) {
        jSONObject.put("gravity", layoutParams.gravity).put("margin_top", layoutParams.topMargin).put("margin_bottom", layoutParams.bottomMargin).put("margin_left", layoutParams.leftMargin).put("margin_right", layoutParams.rightMargin);
    }

    private static void a(LinearLayout.LayoutParams layoutParams, JSONObject jSONObject) {
        jSONObject.put("gravity", layoutParams.gravity).put("margin_top", layoutParams.topMargin).put("margin_bottom", layoutParams.bottomMargin).put("margin_left", layoutParams.leftMargin).put("margin_right", layoutParams.rightMargin);
    }

    public static List b(b bVar) {
        ArrayList arrayList = new ArrayList();
        if (bVar != null) {
            arrayList.add(bVar);
            if (bVar.n()) {
                Iterator it = bVar.f().iterator();
                while (it.hasNext()) {
                    arrayList.addAll(b((b) it.next()));
                }
            }
        }
        return arrayList;
    }

    private static JSONObject b(View view) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resource_id", (Object) a(view.getContext(), view.getId())).put("height", view.getHeight()).put("width", view.getWidth()).put("padding_top", view.getPaddingTop()).put("padding_bottom", view.getPaddingBottom()).put("padding_right", view.getPaddingRight()).put("padding_left", view.getPaddingLeft()).put("visibility", view.getVisibility());
        jSONObject.put("padding_end", view.getPaddingEnd()).put("padding_start", view.getPaddingStart());
        jSONObject.put(Param.X, (double) view.getX()).put(Param.Y, (double) view.getY());
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            a((LinearLayout.LayoutParams) view.getLayoutParams(), jSONObject);
        } else if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            a((FrameLayout.LayoutParams) view.getLayoutParams(), jSONObject);
        } else if (view.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            a(view.getContext(), (RelativeLayout.LayoutParams) view.getLayoutParams(), jSONObject);
        }
        return jSONObject;
    }

    public static ReturnableExecutable c(b bVar) {
        return new c(bVar);
    }

    private static String c(View view) {
        return view.getClass().getSimpleName();
    }

    private static int d(b bVar) {
        int i11 = 0;
        int i12 = bVar.m() != null ? bVar.m().bottom : 0;
        int paddingBottom = bVar.l() != null ? bVar.l().getPaddingBottom() : 0;
        if (bVar.g() != null) {
            i11 = bVar.g().bottom;
        }
        return paddingBottom == 0 ? i12 : Math.min(i12, i11 - paddingBottom);
    }

    private static String d(View view) {
        String simpleName = view.getClass().getSimpleName();
        return !simpleName.equals("ProgressBar") ? !simpleName.equals("WebView") ? !simpleName.equals("MultiAutoCompleteTextView") ? !simpleName.equals("HorizontalScrollView") ? !simpleName.equals("VideoView") ? !simpleName.equals("TextView") ? !simpleName.equals("ImageButton") ? !simpleName.equals("TableRow") ? !simpleName.equals("RelativeLayout") ? !simpleName.equals("GridView") ? !simpleName.equals("RadioButton") ? !simpleName.equals("ToggleButton") ? !simpleName.equals("ImageView") ? !simpleName.equals("LinearLayout") ? !simpleName.equals("SearchView") ? !simpleName.equals("FrameLayout") ? !simpleName.equals("ListView") ? !simpleName.equals("AutoCompleteTextView") ? !simpleName.equals("EditText") ? !simpleName.equals("TableLayout") ? !simpleName.equals("Button") ? !simpleName.equals("ScrollView") ? "default" : "ScrollView" : "Button" : "TableLayout" : "EditText" : "AutoCompleteTextView" : "ListView" : "FrameLayout" : "SearchView" : ((LinearLayout) view).getOrientation() == 0 ? "HorizontalLinearLayout" : "VerticalLinearLayout" : "ImageView" : "ToggleButton" : "RadioButton" : "GridView" : "RelativeLayout" : "TableRow" : "ImageButton" : "TextView" : "VideoView" : "HorizontalScrollView" : "MultiAutoCompleteTextView" : "WebView" : "ProgressBar";
    }

    private static int e(b bVar) {
        int i11 = 0;
        int i12 = bVar.m() != null ? bVar.m().right : 0;
        int paddingRight = bVar.l() != null ? bVar.l().getPaddingRight() : 0;
        if (bVar.g() != null) {
            i11 = bVar.g().right;
        }
        return paddingRight == 0 ? i12 : Math.min(i12, i11 - paddingRight);
    }

    private static int f(b bVar) {
        int i11 = 0;
        int i12 = bVar.m() != null ? bVar.m().left : 0;
        int paddingLeft = bVar.l() != null ? bVar.l().getPaddingLeft() : 0;
        if (bVar.g() != null) {
            i11 = bVar.g().left;
        }
        return paddingLeft == 0 ? i12 : Math.max(i12, i11 + paddingLeft);
    }

    private static int g(b bVar) {
        int i11 = 0;
        int i12 = bVar.m() != null ? bVar.m().top : 0;
        int paddingTop = bVar.l() != null ? bVar.l().getPaddingTop() : 0;
        if (bVar.g() != null) {
            i11 = bVar.g().top;
        }
        return paddingTop == 0 ? i12 : Math.max(i12, i11 + paddingTop);
    }

    private static void h(b bVar) {
        if (bVar.l() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) bVar.l();
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                if (!(viewGroup.getChildAt(i11).getId() == R.id.instabug_extra_screenshot_button || viewGroup.getChildAt(i11).getId() == R.id.instabug_floating_button)) {
                    b bVar2 = new b();
                    bVar2.b(false);
                    bVar2.b(bVar.c() + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + i11);
                    bVar2.a(viewGroup.getChildAt(i11));
                    bVar2.b(bVar);
                    bVar2.a(bVar.j());
                    bVar.a(k(bVar2));
                }
            }
        }
    }

    @Nullable
    private static JSONObject i(b bVar) {
        if (bVar.m() != null) {
            return new JSONObject().put(Param.X, bVar.m().left / bVar.j()).put(Param.Y, bVar.m().top / bVar.j()).put("w", bVar.m().width() / bVar.j()).put("h", bVar.m().height() / bVar.j());
        }
        return null;
    }

    @Nullable
    private static Rect j(b bVar) {
        if (bVar.o()) {
            return bVar.g();
        }
        if (bVar.g() == null || bVar.h() == null) {
            return new Rect(0, 0, 0, 0);
        }
        Rect rect = new Rect(bVar.g().left, bVar.g().top, bVar.g().right, bVar.g().bottom);
        return rect.intersect(new Rect(f(bVar.h()), g(bVar.h()), e(bVar.h()), d(bVar.h()))) ? rect : new Rect(0, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    public static b k(b bVar) {
        if (bVar.l() != null && bVar.l().getVisibility() == 0) {
            try {
                bVar.c(c(bVar.l()));
                bVar.a(d(bVar.l()));
                bVar.b(b(bVar.l()));
                bVar.a(a(bVar.l()));
                bVar.b(j(bVar));
                bVar.a(i(bVar));
                if (bVar.l() instanceof ViewGroup) {
                    bVar.a(true);
                    h(bVar);
                } else {
                    bVar.a(false);
                }
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-BR", "inspect view hierarchy got error: " + e11.getMessage() + ",View hierarchy id:" + bVar.c(), e11);
            }
        }
        return bVar;
    }
}
