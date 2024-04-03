package com.instabug.library.ui.onboarding;

import android.annotation.SuppressLint;
import android.os.Handler;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressLint({"SF_SWITCH_NO_DEFAULT", "SF_SWITCH_NO_DEFAULT"})
public class e extends BasePresenter {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final b f51983a = ((b) this.f34200f.get());

    public e(b bVar) {
        super(bVar);
    }

    private List b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h());
        arrayList.add(c());
        arrayList.add(e());
        return arrayList;
    }

    private f c() {
        String str;
        int a11 = a(c(u()));
        b bVar = this.f51983a;
        String str2 = null;
        if (bVar != null) {
            String placeHolder = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BETA_WELCOME_MESSAGE_HOW_TO_REPORT_STEP_TITLE, bVar.getLocalizedString(R.string.ib_str_beta_welcome_how_to_report_step_title));
            int i11 = d.f51982b[c(u()).ordinal()];
            if (i11 == 1) {
                str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BETA_WELCOME_MESSAGE_HOW_TO_REPORT_STEP_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_how_to_report_step_content_floating));
            } else if (i11 == 2) {
                str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BETA_WELCOME_MESSAGE_HOW_TO_REPORT_STEP_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_how_to_report_step_content_screenshot));
            } else if (i11 == 3) {
                str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BETA_WELCOME_MESSAGE_HOW_TO_REPORT_STEP_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_how_to_report_step_content_swipe));
            } else if (i11 == 4) {
                str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BETA_WELCOME_MESSAGE_HOW_TO_REPORT_STEP_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_how_to_report_step_content_shake));
            }
            String str3 = str2;
            str2 = placeHolder;
            str = str3;
        } else {
            str = null;
        }
        return f.a(a11, str2, str);
    }

    private f e() {
        String str;
        String str2;
        int i11;
        b bVar = this.f51983a;
        if (bVar != null) {
            str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BETA_WELCOME_MESSAGE_FINISH_STEP_TITLE, bVar.getLocalizedString(R.string.ib_str_beta_welcome_finishing_step_title));
            str = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BETA_WELCOME_MESSAGE_FINISH_STEP_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_finishing_step_content));
        } else {
            str2 = null;
            str = null;
        }
        if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            i11 = R.drawable.ibg_core_ic_onboarding_stay_updated;
        } else {
            i11 = R.drawable.ibg_core_ic_onboarding_stay_updated_dark;
        }
        return f.a(i11, str2, str);
    }

    private List f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(g());
        return arrayList;
    }

    private f g() {
        String str;
        int a11 = a(c(u()));
        b bVar = this.f51983a;
        String str2 = null;
        if (bVar != null) {
            String placeHolder = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.LIVE_WELCOME_MESSAGE_TITLE, bVar.getLocalizedString(R.string.ib_str_live_welcome_message_title));
            int i11 = d.f51982b[c(u()).ordinal()];
            if (i11 == 1) {
                str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.LIVE_WELCOME_MESSAGE_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_how_to_report_step_content_floating));
            } else if (i11 == 2) {
                str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.LIVE_WELCOME_MESSAGE_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_how_to_report_step_content_screenshot));
            } else if (i11 == 3) {
                str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.LIVE_WELCOME_MESSAGE_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_how_to_report_step_content_swipe));
            } else if (i11 == 4) {
                str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.LIVE_WELCOME_MESSAGE_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_how_to_report_step_content_shake));
            }
            String str3 = str2;
            str2 = placeHolder;
            str = str3;
        } else {
            str = null;
        }
        return f.a(a11, str2, str, true);
    }

    private f h() {
        String str;
        String str2;
        int i11;
        b bVar = this.f51983a;
        if (bVar != null) {
            str2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BETA_WELCOME_MESSAGE_WELCOME_STEP_TITLE, bVar.getLocalizedString(R.string.ib_str_beta_welcome_step_title));
            str = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.BETA_WELCOME_MESSAGE_WELCOME_STEP_CONTENT, this.f51983a.getLocalizedString(R.string.ib_str_beta_welcome_step_content));
        } else {
            str2 = null;
            str = null;
        }
        if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            i11 = R.drawable.ibg_core_ic_onboarding_welcome;
        } else {
            i11 = R.drawable.ibg_core_ic_onboarding_welcome_dark;
        }
        return f.a(i11, str2, str);
    }

    private void i() {
        b bVar = this.f51983a;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void a(@Nullable WelcomeMessage.State state) {
        i();
        if (state == null) {
            state = WelcomeMessage.State.BETA;
        }
        if (d.f51981a[state.ordinal()] != 2) {
            j();
            return;
        }
        k();
        a();
    }

    public void j() {
        List b11 = b();
        b bVar = this.f51983a;
        if (bVar != null) {
            bVar.a(b11);
        }
    }

    public void k() {
        List f11 = f();
        b bVar = this.f51983a;
        if (bVar != null) {
            bVar.a(f11);
            new Handler().postDelayed(new c(this), 5000);
        }
    }

    @VisibleForTesting
    @SuppressLint({"NULL_DEREFERENCE"})
    public List u() {
        if (InvocationManager.getInstance().getCurrentInstabugInvocationEvents() != null) {
            return Arrays.asList(InvocationManager.getInstance().getCurrentInstabugInvocationEvents());
        }
        return new ArrayList();
    }

    private void a() {
        b bVar = this.f51983a;
        if (bVar != null) {
            bVar.c();
        }
    }

    @DrawableRes
    private int a(InstabugInvocationEvent instabugInvocationEvent) {
        int i11 = d.f51982b[instabugInvocationEvent.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                        return R.drawable.ibg_core_ic_onboarding_shake;
                    }
                    return R.drawable.ibg_core_ic_onboarding_shake_dark;
                } else if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                    return R.drawable.ibg_core_ic_onboarding_swipe;
                } else {
                    return R.drawable.ibg_core_ic_onboarding_swipe_dark;
                }
            } else if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                return R.drawable.ibg_core_ic_onboarding_screenshot;
            } else {
                return R.drawable.ibg_core_ic_onboarding_screenshot_dark;
            }
        } else if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            return R.drawable.ibg_core_ic_onboarding_floating_btn;
        } else {
            return R.drawable.ibg_core_ic_onboarding_floating_btn_dark;
        }
    }

    @VisibleForTesting
    public InstabugInvocationEvent c(List list) {
        if (list.size() == 1) {
            return (InstabugInvocationEvent) list.get(0);
        }
        InstabugInvocationEvent instabugInvocationEvent = InstabugInvocationEvent.SHAKE;
        if (list.contains(instabugInvocationEvent)) {
            return instabugInvocationEvent;
        }
        InstabugInvocationEvent instabugInvocationEvent2 = InstabugInvocationEvent.SCREENSHOT;
        if (list.contains(instabugInvocationEvent2)) {
            return instabugInvocationEvent2;
        }
        InstabugInvocationEvent instabugInvocationEvent3 = InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT;
        if (list.contains(instabugInvocationEvent3)) {
            return instabugInvocationEvent3;
        }
        return InstabugInvocationEvent.FLOATING_BUTTON;
    }
}
