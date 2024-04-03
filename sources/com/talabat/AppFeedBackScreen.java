package com.talabat;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.materialedittext.MaterialEditText;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.feedback.DaggerAppFeedBackScreenComponent;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.helpers.CustomDialog;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcore.logger.LogManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.appfeedback.AppFeedbackPresenter;
import library.talabat.mvp.appfeedback.AppFeedbackView;
import library.talabat.mvp.appfeedback.IAppFeedbackPresenter;
import tracking.ScreenNames;

public class AppFeedBackScreen extends TalabatBase implements AppFeedbackView {
    private ImageButton appFeedbackBackButton;
    private MaterialEditText appFeedbackEmail;
    private Button appFeedbackLiveChat;
    private MaterialEditText appFeedbackMesage;
    /* access modifiers changed from: private */
    public MaterialEditText appFeedbackMobile;
    private Button appFeedbackNo;
    /* access modifiers changed from: private */
    public Button appFeedbackSend;
    private Button appfeedbackContactMe;
    private View contactMeButtonGroup;
    private CustomDialog dialog;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f53656i;
    /* access modifiers changed from: private */
    public IAppFeedbackPresenter iAppFeedbackPresenter;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public ConfigurationLocalRepository f53657j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public IHelpCenterDeeplinkBuilder f53658k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public DeepLinkNavigator f53659l;
    private TextView liveChatTxt;

    /* renamed from: m  reason: collision with root package name */
    public CardView f53660m;
    /* access modifiers changed from: private */
    public String mScreenName = "";

    /* renamed from: n  reason: collision with root package name */
    public CardView f53661n;

    /* renamed from: o  reason: collision with root package name */
    public CardView f53662o;

    /* renamed from: p  reason: collision with root package name */
    public CardView f53663p;

    /* renamed from: q  reason: collision with root package name */
    public CardView f53664q;
    private RatingBar ratingBarAppFeedback;

    private void setUpinitialView() {
        this.appFeedbackSend.setEnabled(false);
        this.appFeedbackSend.setAlpha(0.5f);
        this.f53664q.setVisibility(8);
    }

    public static RatingBar tintRatingBar(RatingBar ratingBar, int i11) {
        if (ratingBar.getProgressDrawable() instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) ratingBar.getProgressDrawable();
            Drawable wrap = DrawableCompat.wrap(layerDrawable.getDrawable(2));
            DrawableCompat.setTint(wrap, i11);
            Drawable[] drawableArr = new Drawable[3];
            drawableArr[2] = wrap;
            drawableArr[0] = layerDrawable.getDrawable(0);
            drawableArr[1] = layerDrawable.getDrawable(1);
            ratingBar.setProgressDrawable(new LayerDrawable(drawableArr));
        } else {
            Drawable wrap2 = DrawableCompat.wrap(ratingBar.getProgressDrawable());
            DrawableCompat.setTint(wrap2, i11);
            ratingBar.setProgressDrawable(wrap2);
        }
        return ratingBar;
    }

    public void destroyPresenter() {
        this.iAppFeedbackPresenter = null;
    }

    public String getAppVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public String getDateAndTime() {
        String format = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa").format(Calendar.getInstance().getTime());
        System.out.println(format);
        return format;
    }

    public String getEmail() {
        return this.appFeedbackEmail.getText().toString().trim();
    }

    public String getFeedbackMessage() {
        return this.appFeedbackMesage.getText().toString().trim();
    }

    public float getFeedbackRating() {
        return this.ratingBarAppFeedback.getRating();
    }

    public String getMobileNumber() {
        return this.appFeedbackMobile.getText().toString().trim();
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.APP_FEEDBACK_SCREEN;
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerAppFeedBackScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (HelpCenterFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(HelpCenterFeatureApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.app_feedback_screen);
        try {
            this.iAppFeedbackPresenter = new AppFeedbackPresenter(this.f53656i, this, this, this.f53657j);
            this.mScreenName = getIntent().getStringExtra("feedbackScreenName");
            this.appFeedbackMobile = (MaterialEditText) findViewById(R.id.app_feedback_mobile);
            this.appFeedbackEmail = (MaterialEditText) findViewById(R.id.app_feedback_email);
            this.appFeedbackSend = (Button) findViewById(R.id.app_feedback_send);
            this.appFeedbackNo = (Button) findViewById(R.id.app_feedback_no);
            this.appfeedbackContactMe = (Button) findViewById(R.id.app_feedback_contact_me);
            this.ratingBarAppFeedback = (RatingBar) findViewById(R.id.ratingbar_app_feedback);
            this.appFeedbackLiveChat = (Button) findViewById(R.id.app_feedback_live_chat);
            this.appFeedbackMesage = (MaterialEditText) findViewById(R.id.feedback);
            this.appFeedbackBackButton = (ImageButton) findViewById(R.id.app_feedback_back);
            this.f53660m = (CardView) findViewById(R.id.rate_card_view);
            this.f53661n = (CardView) findViewById(R.id.type_feedback_view);
            this.f53662o = (CardView) findViewById(R.id.app_feedback_live_chat_card);
            this.f53663p = (CardView) findViewById(R.id.thanks_view);
            this.contactMeButtonGroup = findViewById(R.id.contact_me_button_group);
            this.f53664q = (CardView) findViewById(R.id.app_feedback_contact_me_view);
            this.liveChatTxt = (TextView) findViewById(R.id.live_chat_txt);
            this.ratingBarAppFeedback.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                public void onRatingChanged(RatingBar ratingBar, float f11, boolean z11) {
                    if (f11 > 0.0f) {
                        AppFeedBackScreen.this.appFeedbackSend.setEnabled(true);
                        AppFeedBackScreen.this.appFeedbackSend.setAlpha(1.0f);
                        return;
                    }
                    AppFeedBackScreen.this.appFeedbackSend.setEnabled(false);
                    AppFeedBackScreen.this.appFeedbackSend.setAlpha(0.5f);
                }
            });
            this.appFeedbackLiveChat.setText(getString(R.string.feed_back_screen_back_help_center_title));
            this.liveChatTxt.setText(getString(R.string.feedback_need_hlp_help_center_txt));
            this.appFeedbackLiveChat.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AppFeedBackScreen appFeedBackScreen = AppFeedBackScreen.this;
                    appFeedBackScreen.f53659l.navigateTo(appFeedBackScreen, appFeedBackScreen.f53658k.build("", ""), (Function0<Unit>) null);
                }
            });
            this.appFeedbackSend.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AppFeedBackScreen.this.iAppFeedbackPresenter.validateFeedbackSubmit(AppFeedBackScreen.this.mScreenName);
                }
            });
            this.appfeedbackContactMe.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AppFeedBackScreen.this.iAppFeedbackPresenter.sendFeedback(!TalabatUtils.isNullOrEmpty(AppFeedBackScreen.this.appFeedbackMobile.getText().toString()), AppFeedBackScreen.this.mScreenName);
                }
            });
            this.appFeedbackNo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AppFeedBackScreen.this.finish();
                }
            });
            this.appFeedbackBackButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AppFeedBackScreen.this.finish();
                }
            });
            setUpinitialView();
            this.appFeedbackMesage.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.appFeedbackEmail.setImeOptions(6);
            this.appFeedbackEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                    if (i11 != 6) {
                        return false;
                    }
                    AppFeedBackScreen.this.iAppFeedbackPresenter.sendFeedback(!TalabatUtils.isNullOrEmpty(AppFeedBackScreen.this.appFeedbackMobile.getText().toString()), AppFeedBackScreen.this.mScreenName);
                    return false;
                }
            });
        } catch (Exception e11) {
            LogManager.logException(e11);
            finish();
        }
    }

    public void onError() {
    }

    public void onPause() {
        super.onPause();
        pauseBannerForNextScreen();
        GlobalDataModel.isFeedbackShowing = false;
    }

    public void onValidationError(int i11) {
        if (i11 == 302) {
            this.appFeedbackMobile.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.appFeedbackMobile.setError(getString(R.string.required));
        } else if (i11 == 303) {
            this.appFeedbackEmail.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.appFeedbackEmail.setError(getString(R.string.invalid_email));
        }
    }

    public void sendtoAddContactDetailsPage() {
        this.f53660m.setVisibility(8);
        this.f53661n.setVisibility(8);
        this.f53662o.setVisibility(8);
        this.appFeedbackSend.setVisibility(8);
        this.contactMeButtonGroup.setVisibility(0);
        this.f53663p.setVisibility(8);
        this.f53664q.setVisibility(0);
    }

    public void setMobilenumber(String str) {
        this.appFeedbackMobile.setText(str);
    }

    public void showFeedbackThankYouPopup() {
        CustomDialog customDialog = this.dialog;
        if (customDialog != null && customDialog.isShowing()) {
            this.dialog.dismiss();
        }
        Toast.makeText(this, getString(R.string.feedback_thank_you_title), 0).show();
        finish();
    }

    public void showLoading() {
        if (this.dialog == null) {
            this.dialog = new CustomDialog(this);
        }
        this.dialog.show();
    }
}
