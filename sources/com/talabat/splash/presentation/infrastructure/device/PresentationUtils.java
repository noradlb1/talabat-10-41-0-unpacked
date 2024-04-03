package com.talabat.splash.presentation.infrastructure.device;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.talabat.R;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.visa.checkout.Profile;
import java.util.Calendar;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wu.a;
import wu.b;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003J\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animateViewWithAlpha", "", "view", "Landroid/view/View;", "duration", "", "alpha", "", "changeLanguage", "getCalendar", "Ljava/util/Calendar;", "getDensity", "", "getDeviceHeightWidth", "Lkotlin/Pair;", "", "metrics", "Landroid/util/DisplayMetrics;", "onForceUpdatePopup", "title", "msg", "onAlertListener", "Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils$OnAlertListener;", "OnAlertListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PresentationUtils {
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils$OnAlertListener;", "", "onsetPositiveButtonClicked", "", "setNegativeButtonClicked", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnAlertListener {
        void onsetPositiveButtonClicked();

        void setNegativeButtonClicked();
    }

    @Inject
    public PresentationUtils(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: private */
    /* renamed from: onForceUpdatePopup$lambda-0  reason: not valid java name */
    public static final void m10910onForceUpdatePopup$lambda0(PresentationUtils presentationUtils, OnAlertListener onAlertListener, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(presentationUtils, "this$0");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        if (onAlertListener != null) {
            onAlertListener.onsetPositiveButtonClicked();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onForceUpdatePopup$lambda-1  reason: not valid java name */
    public static final void m10911onForceUpdatePopup$lambda1(PresentationUtils presentationUtils, OnAlertListener onAlertListener, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(presentationUtils, "this$0");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        if (onAlertListener != null) {
            onAlertListener.setNegativeButtonClicked();
        }
    }

    public final void animateViewWithAlpha(@NotNull View view, long j11, float f11) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAlpha(0.0f);
        view.animate().alpha(f11).setDuration(j11);
    }

    public final void changeLanguage() {
        Locale locale;
        Resources resources = this.context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        if (Intrinsics.areEqual((Object) GlobalDataModel.SelectedLanguage, (Object) GlobalConstants.ARABIC)) {
            locale = new Locale(ArchiveStreamFactory.AR, Profile.Country.KW);
        } else {
            locale = new Locale("en", Profile.Country.US);
        }
        configuration.locale = locale;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 23) {
            configuration.setLocales(new LocaleList(new Locale[]{locale}));
            this.context.createConfigurationContext(configuration);
        }
        configuration.setLayoutDirection(locale);
        if (i11 > 23) {
            configuration.setLocales(new LocaleList(new Locale[]{locale}));
            this.context.createConfigurationContext(configuration);
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    @NotNull
    public final Calendar getCalendar() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    public final String getDensity(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        int i11 = context2.getResources().getDisplayMetrics().densityDpi;
        if (context2.getResources().getBoolean(R.bool.isTablet)) {
            return "Tablet";
        }
        switch (i11) {
            case 120:
            case Opcodes.IF_ICMPNE:
            case 213:
            case PsExtractor.VIDEO_STREAM_MASK:
            case 280:
                return "HDPI";
            case 320:
                return "XHDPI";
            case 360:
            case 400:
            case 420:
            case 480:
                return "XXHDPI";
            case 560:
            case 640:
                return "XXXHDPI";
            default:
                return "";
        }
    }

    @NotNull
    public final Pair<Integer, Integer> getDeviceHeightWidth(@NotNull DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(displayMetrics, "metrics");
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    public final void onForceUpdatePopup(@NotNull Context context2, @NotNull String str, @NotNull String str2, @Nullable OnAlertListener onAlertListener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "msg");
        AlertDialog.Builder builder = new AlertDialog.Builder(context2, R.style.UpdateAlertDialogStyle);
        builder.setTitle((CharSequence) str);
        builder.setMessage((CharSequence) str2);
        String string = context2.getString(R.string.update_ok_btn);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…n.R.string.update_ok_btn)");
        String upperCase = string.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        builder.setPositiveButton((CharSequence) upperCase, (DialogInterface.OnClickListener) new a(this, onAlertListener));
        String string2 = context2.getString(R.string.f54881ok);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.ta…localization.R.string.ok)");
        String upperCase2 = string2.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase()");
        builder.setNegativeButton((CharSequence) upperCase2, (DialogInterface.OnClickListener) new b(this, onAlertListener));
        builder.show();
    }
}
