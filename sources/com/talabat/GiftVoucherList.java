package com.talabat;

import JsonModels.parser.UniversalGson;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.di.ApiContainer;
import com.talabat.di.DaggerGiftVoucherListComponent;
import com.talabat.helpers.TalabatBase;
import datamodels.GiftVoucherItem;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.giftvoucherlist.GiftVoucherListView;
import library.talabat.mvp.giftvoucherlist.GiftVoucherPresenter;
import library.talabat.mvp.giftvoucherlist.IGiftVoucherPresenter;
import tracking.ScreenNames;

@Instrumented
public class GiftVoucherList extends TalabatBase implements GiftVoucherListView {
    private TextView buyVoucherText;
    private View contentView;
    private View giftView;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f54089i;
    private float imageAmount;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public ConfigurationLocalRepository f54090j;

    /* renamed from: k  reason: collision with root package name */
    public GiftVoucherItem[] f54091k;
    private View loadingView;
    private Toolbar mToolbar;
    /* access modifiers changed from: private */
    public IGiftVoucherPresenter presenter;
    private ImageButton voucher1;
    private ImageButton voucher2;
    private ImageButton voucher3;
    private ImageButton voucher4;
    private ImageButton voucher5;
    private ImageButton voucher6;

    public void destroyPresenter() {
        this.presenter = null;
    }

    public void dismisLoading() {
        this.loadingView.setVisibility(8);
        this.contentView.setVisibility(0);
    }

    public int getDisplayImage(int i11, float f11) {
        if (i11 == Country.KUWAIT.getCountryId()) {
            if (f11 == 5.0f) {
                return R.drawable.gift_kd5;
            }
            if (f11 == 10.0f) {
                return R.drawable.gift_kd10;
            }
            if (f11 == 20.0f) {
                return R.drawable.gift_kd20;
            }
            if (f11 == 50.0f) {
                return R.drawable.gift_kd50;
            }
            if (f11 == 100.0f) {
                return R.drawable.gift_kd100;
            }
            if (f11 == 200.0f) {
                return R.drawable.gift_kd200;
            }
            return -1;
        } else if (i11 != Country.BAHRAIN.getCountryId()) {
            return -1;
        } else {
            if (f11 == 5.0f) {
                return R.drawable.gift_bd5;
            }
            if (f11 == 10.0f) {
                return R.drawable.gift_bd10;
            }
            if (f11 == 20.0f) {
                return R.drawable.gift_bd20;
            }
            if (f11 == 50.0f) {
                return R.drawable.gift_bd50;
            }
            if (f11 == 100.0f) {
                return R.drawable.gift_bd100;
            }
            if (f11 == 200.0f) {
                return R.drawable.gift_bd200;
            }
            return -1;
        }
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getScreenName() {
        return ScreenNames.GIFT_VOUCHER_LIST;
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        ApiContainer apiContainer = (ApiContainer) getApplication();
        DaggerGiftVoucherListComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.gift_voucher_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setBackButton(R.id.back);
            this.loadingView = findViewById(R.id.loading_layout);
            this.contentView = findViewById(R.id.gift_voucher_content_view);
            this.loadingView.setVisibility(0);
            this.contentView.setVisibility(8);
            this.voucher1 = (ImageButton) findViewById(R.id.voucher1);
            this.voucher2 = (ImageButton) findViewById(R.id.voucher2);
            this.voucher3 = (ImageButton) findViewById(R.id.voucher3);
            this.voucher4 = (ImageButton) findViewById(R.id.voucher4);
            this.voucher5 = (ImageButton) findViewById(R.id.voucher5);
            this.voucher6 = (ImageButton) findViewById(R.id.voucher6);
            this.giftView = findViewById(R.id.gift_voucher_content_amount);
            this.buyVoucherText = (TextView) findViewById(R.id.buy_voucher_message);
            this.voucher1.setVisibility(8);
            this.voucher2.setVisibility(8);
            this.voucher3.setVisibility(8);
            this.voucher4.setVisibility(8);
            this.voucher5.setVisibility(8);
            this.voucher6.setVisibility(8);
            GiftVoucherPresenter giftVoucherPresenter = new GiftVoucherPresenter(this.f54089i, this);
            this.presenter = giftVoucherPresenter;
            giftVoucherPresenter.setUpViews();
            this.voucher1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GiftVoucherList.this.presenter.onGiftVoucherSelected(GiftVoucherList.this.f54091k[0]);
                }
            });
            this.voucher2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GiftVoucherList.this.presenter.onGiftVoucherSelected(GiftVoucherList.this.f54091k[1]);
                }
            });
            this.voucher3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GiftVoucherList.this.presenter.onGiftVoucherSelected(GiftVoucherList.this.f54091k[2]);
                }
            });
            this.voucher4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GiftVoucherList.this.presenter.onGiftVoucherSelected(GiftVoucherList.this.f54091k[3]);
                }
            });
            this.voucher5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GiftVoucherList.this.presenter.onGiftVoucherSelected(GiftVoucherList.this.f54091k[4]);
                }
            });
            this.voucher6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GiftVoucherList.this.presenter.onGiftVoucherSelected(GiftVoucherList.this.f54091k[5]);
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    public void onError() {
    }

    public void onRedirectToGiftVoucherDetails(GiftVoucherItem giftVoucherItem) {
        String str;
        Intent intent = new Intent(this, GiftVoucherDetailsScreen.class);
        Gson gson = UniversalGson.INSTANCE.gson;
        intent.putExtra("imageId", giftVoucherItem.imageId);
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) giftVoucherItem);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) giftVoucherItem);
        }
        intent.putExtra("value", str);
        startActivity(intent);
    }

    public void setDescription(String str) {
        this.buyVoucherText.setText(str);
    }

    public void setGiftVoucherItems(GiftVoucherItem[] giftVoucherItemArr) {
        this.f54091k = giftVoucherItemArr;
        if (giftVoucherItemArr != null) {
            this.giftView.setVisibility(8);
            int countryId = this.f54090j.selectedCountry().getCountryId();
            if (giftVoucherItemArr.length > 0) {
                boolean z11 = true;
                for (GiftVoucherItem giftVoucherItem : giftVoucherItemArr) {
                    if (giftVoucherItem.amount > 0.0f) {
                        z11 = false;
                    }
                }
                if (z11) {
                    this.giftView.setVisibility(8);
                    Toast.makeText(this, getResources().getString(R.string.no_result_found), 0).show();
                    return;
                }
                this.giftView.setVisibility(0);
                GiftVoucherItem giftVoucherItem2 = giftVoucherItemArr[0];
                if (giftVoucherItem2.amount > 0.0f) {
                    this.voucher1.setVisibility(0);
                    giftVoucherItem2.imageId = getDisplayImage(countryId, giftVoucherItem2.amount);
                    this.voucher1.setImageResource(getDisplayImage(countryId, giftVoucherItem2.amount));
                } else {
                    this.voucher1.setVisibility(4);
                }
            }
            if (giftVoucherItemArr.length > 0) {
                GiftVoucherItem giftVoucherItem3 = giftVoucherItemArr[1];
                float f11 = giftVoucherItem3.amount;
                if (f11 > 0.0f) {
                    giftVoucherItem3.imageId = getDisplayImage(countryId, f11);
                    this.voucher2.setImageResource(getDisplayImage(countryId, giftVoucherItem3.amount));
                    this.voucher2.setVisibility(0);
                } else {
                    this.voucher2.setVisibility(4);
                }
            }
            if (giftVoucherItemArr.length > 0) {
                GiftVoucherItem giftVoucherItem4 = giftVoucherItemArr[2];
                float f12 = giftVoucherItem4.amount;
                if (f12 > 0.0f) {
                    giftVoucherItem4.imageId = getDisplayImage(countryId, f12);
                    this.voucher3.setImageResource(getDisplayImage(countryId, giftVoucherItem4.amount));
                    this.voucher3.setVisibility(0);
                } else {
                    this.voucher3.setVisibility(4);
                }
            }
            if (giftVoucherItemArr.length > 0) {
                GiftVoucherItem giftVoucherItem5 = giftVoucherItemArr[3];
                float f13 = giftVoucherItem5.amount;
                if (f13 > 0.0f) {
                    giftVoucherItem5.imageId = getDisplayImage(countryId, f13);
                    this.voucher4.setImageResource(getDisplayImage(countryId, giftVoucherItem5.amount));
                    this.voucher4.setVisibility(0);
                } else {
                    this.voucher4.setVisibility(4);
                }
            }
            if (giftVoucherItemArr.length > 0) {
                GiftVoucherItem giftVoucherItem6 = giftVoucherItemArr[4];
                float f14 = giftVoucherItem6.amount;
                if (f14 > 0.0f) {
                    giftVoucherItem6.imageId = getDisplayImage(countryId, f14);
                    this.voucher5.setImageResource(getDisplayImage(countryId, giftVoucherItem6.amount));
                    this.voucher5.setVisibility(0);
                } else {
                    this.voucher5.setVisibility(4);
                }
            }
            if (giftVoucherItemArr.length > 0) {
                GiftVoucherItem giftVoucherItem7 = giftVoucherItemArr[5];
                float f15 = giftVoucherItem7.amount;
                if (f15 > 0.0f) {
                    giftVoucherItem7.imageId = getDisplayImage(countryId, f15);
                    this.voucher6.setImageResource(getDisplayImage(countryId, giftVoucherItem7.amount));
                    this.voucher6.setVisibility(0);
                    return;
                }
                this.voucher6.setVisibility(4);
            }
        }
    }

    public void showLoading() {
        this.loadingView.setVisibility(0);
        this.contentView.setVisibility(8);
    }
}
