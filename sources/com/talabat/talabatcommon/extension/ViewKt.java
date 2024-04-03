package com.talabat.talabatcommon.extension;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zu.a;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007\u001a&\u0010\u0007\u001a\u00020\u0003*\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\f\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b\u001a\u0014\u0010\u0010\u001a\u00020\u0004*\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u000b\u001a\n\u0010\u0013\u001a\u00020\u0003*\u00020\u0004\u001a&\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0002\b\u0017H\u0002\u001a\n\u0010\u0018\u001a\u00020\t*\u00020\u0004\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002\u001a\u0017\u0010\u0019\u001a\u00020\u0003*\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0002\u001a\u0012\u0010\u001e\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000b\u001a?\u0010 \u001a\u00020\u0003*\u00020\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010&\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0004\u001a/\u0010'\u001a\u00020\u0003*\u00020\u00042\b\b\u0001\u0010(\u001a\u00020\u000b2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0002\b\u0017H\u0007\u001aA\u0010*\u001a\u00020\u0003\"\n\b\u0000\u0010+\u0018\u0001*\u00020,*\u00020\u00042\b\b\u0002\u0010-\u001a\u00020.2\u0019\b\u0004\u0010/\u001a\u0013\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0002\b\u0017H\bø\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u00060"}, d2 = {"ANIMATION_DURATION", "", "cancelTransition", "", "Landroid/view/View;", "crossFade", "viewToFadeOut", "get", "visible", "", "hiddenVisibility", "", "(Landroid/view/View;Ljava/lang/Boolean;I)V", "getString", "", "id", "inflate", "Landroid/view/ViewGroup;", "layoutRes", "invisible", "invoke", "onClick", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "isVisible", "plusAssign", "Landroid/widget/ImageView;", "resId", "Landroid/widget/TextView;", "text", "setLayoutGravity", "gravity", "setMargin", "left", "", "top", "right", "bottom", "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "withLayout", "layoutId", "onInflate", "withViewModel", "VM", "Landroidx/lifecycle/ViewModel;", "host", "", "binder", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewKt {
    private static final long ANIMATION_DURATION = 200;

    @RequiresApi(21)
    public static final void cancelTransition(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTransitionName((String) null);
    }

    @ViewsDsl
    public static final void crossFade(@NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(view2, "viewToFadeOut");
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(200).setListener((Animator.AnimatorListener) null);
        view2.animate().alpha(0.0f).setDuration(200).setListener(new ViewKt$crossFade$1(view2));
    }

    @ViewsDsl
    public static final void get(@NotNull View view, @Nullable Boolean bool, int i11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        CoroutinesKt.runHandling$default((Function1) null, new ViewKt$get$1(view, bool, i11), 1, (Object) null);
    }

    public static /* synthetic */ void get$default(View view, Boolean bool, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 4;
        }
        get(view, bool, i11);
    }

    @NotNull
    public static final String getString(@NotNull View view, int i11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        String string = view.getContext().getString(i11);
        Intrinsics.checkNotNullExpressionValue(string, "this.context.getString(id)");
        return string;
    }

    @NotNull
    public static final View inflate(@NotNull ViewGroup viewGroup, @LayoutRes int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(layoutRes, this, false)");
        return inflate;
    }

    public static final void invisible(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    @ViewsDsl
    public static final void invoke(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        view.setOnClickListener(new a(function1, view));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m9349invoke$lambda2(Function1 function1, View view, View view2) {
        Intrinsics.checkNotNullParameter(function1, "$onClick");
        Intrinsics.checkNotNullParameter(view, "$this_invoke");
        function1.invoke(view);
    }

    public static final boolean isVisible(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @ViewsDsl
    public static final void plusAssign(@NotNull TextView textView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setText(str);
    }

    public static final void setLayoutGravity(@NotNull View view, int i11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = i11;
            view.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public static final void setMargin(@NotNull View view, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable Float f14) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (f11 != null) {
                i11 = (int) f11.floatValue();
            } else {
                i11 = marginLayoutParams.leftMargin;
            }
            if (f12 != null) {
                i12 = (int) f12.floatValue();
            } else {
                i12 = marginLayoutParams.topMargin;
            }
            if (f13 != null) {
                i13 = (int) f13.floatValue();
            } else {
                i13 = marginLayoutParams.rightMargin;
            }
            if (f14 != null) {
                i14 = (int) f14.floatValue();
            } else {
                i14 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i11, i12, i13, i14);
            if (f11 != null) {
                i15 = (int) f11.floatValue();
            } else {
                i15 = marginLayoutParams.getMarginStart();
            }
            if (f13 != null) {
                i16 = (int) f13.floatValue();
            } else {
                i16 = marginLayoutParams.getMarginEnd();
            }
            marginLayoutParams.setMarginStart(i15);
            marginLayoutParams.setMarginEnd(i16);
            view.setLayoutParams(marginLayoutParams);
            view.requestFocus();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public static /* synthetic */ void setMargin$default(View view, Float f11, Float f12, Float f13, Float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = null;
        }
        if ((i11 & 2) != 0) {
            f12 = null;
        }
        if ((i11 & 4) != 0) {
            f13 = null;
        }
        if ((i11 & 8) != 0) {
            f14 = null;
        }
        setMargin(view, f11, f12, f13, f14);
    }

    public static final void visible(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }

    @ViewsDsl
    public static final void withLayout(@NotNull View view, @LayoutRes int i11, @NotNull Function1<? super View, Unit> function1) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onInflate");
        Context context = view.getContext();
        ViewGroup viewGroup2 = null;
        if (view instanceof ViewGroup) {
            viewGroup = view;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup2 = viewGroup;
        }
        View inflate = View.inflate(context, i11, viewGroup2);
        if (inflate != null) {
            function1.invoke(inflate);
            return;
        }
        throw new UnsupportedOperationException("failed to inflate view for " + view);
    }

    @ViewsDsl
    public static final /* synthetic */ <VM extends ViewModel> void withViewModel(View view, Object obj, Function1<? super VM, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(obj, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(function1, "binder");
        Class<ViewModel> cls = ViewModel.class;
        if (obj instanceof AppCompatActivity) {
            ViewModelProvider of2 = ViewModelProviders.of((FragmentActivity) obj);
            Intrinsics.reifiedOperationMarker(4, "VM");
            function1.invoke(of2.get(cls));
        } else if (obj instanceof Fragment) {
            ViewModelProvider of3 = ViewModelProviders.of((Fragment) obj);
            Intrinsics.reifiedOperationMarker(4, "VM");
            function1.invoke(of3.get(cls));
        } else {
            throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
        }
    }

    public static /* synthetic */ void withViewModel$default(View view, Object obj, Function1 function1, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = view.getContext();
            Intrinsics.checkNotNullExpressionValue(obj, "context");
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(obj, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(function1, "binder");
        Class<ViewModel> cls = ViewModel.class;
        if (obj instanceof AppCompatActivity) {
            ViewModelProvider of2 = ViewModelProviders.of((FragmentActivity) obj);
            Intrinsics.reifiedOperationMarker(4, "VM");
            function1.invoke(of2.get(cls));
        } else if (obj instanceof Fragment) {
            ViewModelProvider of3 = ViewModelProviders.of((Fragment) obj);
            Intrinsics.reifiedOperationMarker(4, "VM");
            function1.invoke(of3.get(cls));
        } else {
            throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
        }
    }

    @ViewsDsl
    public static final void plusAssign(@NotNull TextView textView, int i11) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setText(i11);
    }

    @ViewsDsl
    public static final void plusAssign(@NotNull ImageView imageView, int i11) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        imageView.setImageResource(i11);
    }
}
