package com.talabat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.pay.DaggerPayfortCardPaymentListScreenComponent;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.payfortcardlist.IPayfortCardListPresenter;
import library.talabat.mvp.payfortcardlist.PayfortCardListPresenter;
import library.talabat.mvp.payfortcardlist.PayfortSavedCardListView;
import tracking.ScreenNames;

public class PayfortCardPaymentListScreen extends TalabatBase implements PayfortSavedCardListView {
    /* access modifiers changed from: private */
    public IPayfortCardListPresenter PayfortCardListPresenter;
    private Button addCardbtn;
    private ImageButton backBtn;
    private RelativeLayout cardAvilableView;
    private RecyclerView cardList;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    private Button deleteAllSavedCard;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f54508i;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    private savedCardRecyclerViewAdapter mAdapter;
    private Button noCardAddCardButton;
    private View noCardView;
    private ArrayList<TokenisationCreditCard> tokenisationCreditCards;

    public class savedCardRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
        private ArrayList<TokenisationCreditCard> cardList;
        private Context mContext;
        private RadioButton[] radioButtons;

        public class CustomViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public LinearLayout f54516h;

            /* renamed from: i  reason: collision with root package name */
            public RadioButton f54517i;

            /* renamed from: j  reason: collision with root package name */
            public ImageView f54518j;

            /* renamed from: k  reason: collision with root package name */
            public TextView f54519k;

            /* renamed from: l  reason: collision with root package name */
            public TextView f54520l;

            /* renamed from: m  reason: collision with root package name */
            public TextView f54521m;

            /* renamed from: n  reason: collision with root package name */
            public Button f54522n;

            /* renamed from: o  reason: collision with root package name */
            public TextView f54523o;

            public CustomViewHolder(View view) {
                super(view);
                this.f54516h = (LinearLayout) view.findViewById(R.id.main_container);
                this.f54517i = (RadioButton) view.findViewById(R.id.card_selector);
                this.f54518j = (ImageView) view.findViewById(R.id.card_img);
                this.f54519k = (TextView) view.findViewById(R.id.card_no);
                this.f54520l = (TextView) view.findViewById(R.id.card_holder_name);
                this.f54521m = (TextView) view.findViewById(R.id.card_expiry_date);
                this.f54522n = (Button) view.findViewById(R.id.card_edit_btn);
                this.f54523o = (TextView) view.findViewById(R.id.card_expired_label);
            }
        }

        public savedCardRecyclerViewAdapter(Context context, ArrayList<TokenisationCreditCard> arrayList) {
            this.mContext = context;
            this.cardList = arrayList;
            this.radioButtons = new RadioButton[arrayList.size()];
        }

        public int getItemCount() {
            ArrayList<TokenisationCreditCard> arrayList = this.cardList;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        public void updateList(ArrayList<TokenisationCreditCard> arrayList) {
            this.cardList = arrayList;
        }

        public void onBindViewHolder(CustomViewHolder customViewHolder, int i11) {
            final TokenisationCreditCard tokenisationCreditCard = this.cardList.get(i11);
            this.radioButtons[i11] = customViewHolder.f54517i;
            if (tokenisationCreditCard.expiremonth > 0 && tokenisationCreditCard.expireyear > 0) {
                TextView textView = customViewHolder.f54521m;
                textView.setText("" + tokenisationCreditCard.expiremonth + "/" + tokenisationCreditCard.expireyear);
            }
            if (!TalabatUtils.isNullOrEmpty(tokenisationCreditCard.cardnumber)) {
                customViewHolder.f54519k.setText(tokenisationCreditCard.cardnumber);
            }
            customViewHolder.f54520l.setVisibility(8);
            if (!TalabatUtils.isNullOrEmpty(tokenisationCreditCard.cardtype)) {
                if (tokenisationCreditCard.cardtype.toLowerCase().contains("VISA".toLowerCase())) {
                    customViewHolder.f54518j.setImageResource(R.drawable.icon_tokenization_visa);
                } else if (tokenisationCreditCard.cardtype.toLowerCase().contains("MASTERCARD".toLowerCase())) {
                    customViewHolder.f54518j.setImageResource(R.drawable.icon_tokenization_mastercard);
                } else if (tokenisationCreditCard.cardtype.toLowerCase().contains("AMEX".toLowerCase())) {
                    customViewHolder.f54518j.setImageResource(R.drawable.icon_amex_checkout);
                } else if (tokenisationCreditCard.cardtype.toLowerCase().contains(GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_DINERSCLUB.toLowerCase())) {
                    customViewHolder.f54518j.setImageResource(R.drawable.bt_ic_dinersclub);
                } else if (tokenisationCreditCard.cardtype.toLowerCase().contains(GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_JCB.toLowerCase())) {
                    customViewHolder.f54518j.setImageResource(R.drawable.bt_ic_jcb);
                } else if (tokenisationCreditCard.cardtype.toLowerCase().contains("DISCOVER".toLowerCase())) {
                    customViewHolder.f54518j.setImageResource(R.drawable.bt_ic_discover);
                } else if (tokenisationCreditCard.cardtype.toLowerCase().contains(GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_MAESTRO.toLowerCase())) {
                    customViewHolder.f54518j.setImageResource(R.drawable.bt_ic_maestro);
                } else {
                    customViewHolder.f54518j.setImageResource(R.drawable.bt_ic_unknown);
                }
            }
            if (tokenisationCreditCard.isValidCard) {
                customViewHolder.f54523o.setText(R.string.expires_in);
            } else {
                customViewHolder.f54523o.setText(R.string.delete_card_expired_label);
            }
            customViewHolder.f54522n.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    new AlertDialog.Builder(PayfortCardPaymentListScreen.this, R.style.AlertDialogTheme).setTitle(R.string.delete_card_title).setMessage(R.string.delete_card_message).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i11) {
                            PayfortCardPaymentListScreen.this.startLodingPopup();
                            PayfortCardPaymentListScreen.this.PayfortCardListPresenter.deleteSavedCardButtonClicked(tokenisationCreditCard);
                        }
                    }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i11) {
                        }
                    }).show();
                }
            });
        }

        public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.payfort_card_list_item, (ViewGroup) null));
        }
    }

    public void deleteAllSavedCardList() {
        finish();
    }

    public void deleteCardFail(String str) {
        stopLodingPopup();
        if (TalabatUtils.isNullOrEmpty(str)) {
            str = getResources().getString(R.string.server_error_msg);
        }
        Toast.makeText(this, str, 1).show();
    }

    public void destroyPresenter() {
    }

    public Context getContext() {
        return this;
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.SAVED_CARD_LIST_SCREEN;
    }

    public Context getcontext() {
        return this;
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        DaggerPayfortCardPaymentListScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        try {
            setContentView((int) R.layout.payfort_card_payment_manage_screen);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.noCardView = findViewById(R.id.no_card_view);
            this.cardAvilableView = (RelativeLayout) findViewById(R.id.card_available_view);
            this.noCardAddCardButton = (Button) findViewById(R.id.no_card_add_card);
            this.cardList = (RecyclerView) findViewById(R.id.card_list);
            this.backBtn = (ImageButton) findViewById(R.id.back);
            this.deleteAllSavedCard = (Button) findViewById(R.id.delete_all_card);
            PayfortCardListPresenter payfortCardListPresenter = new PayfortCardListPresenter(this.f54508i, this.configurationLocalRepository, this.locationConfigurationRepository, this);
            this.PayfortCardListPresenter = payfortCardListPresenter;
            payfortCardListPresenter.setUpViews();
            this.backBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PayfortCardPaymentListScreen.this.finish();
                }
            });
            this.deleteAllSavedCard.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }

    public void refreshSavedCardList(ArrayList<TokenisationCreditCard> arrayList, String str) {
        stopLodingPopup();
        if (arrayList == null || arrayList.size() <= 0) {
            this.noCardView.setVisibility(0);
            this.cardList.setVisibility(8);
        } else {
            this.noCardView.setVisibility(8);
            this.cardList.setVisibility(0);
            savedCardRecyclerViewAdapter savedcardrecyclerviewadapter = this.mAdapter;
            if (savedcardrecyclerviewadapter != null) {
                savedcardrecyclerviewadapter.updateList(arrayList);
                this.mAdapter.notifyDataSetChanged();
            }
        }
        if (!TalabatUtils.isNullOrEmpty(str)) {
            Toast.makeText(this, str, 1).show();
        }
    }

    public void savedCreditCardListLoaded(ArrayList<TokenisationCreditCard> arrayList) {
        this.tokenisationCreditCards = arrayList;
        if (arrayList == null || arrayList.size() <= 0) {
            this.noCardView.setVisibility(0);
            this.cardList.setVisibility(8);
            return;
        }
        this.noCardView.setVisibility(8);
        this.cardList.setVisibility(0);
        this.mAdapter = new savedCardRecyclerViewAdapter(this, this.tokenisationCreditCards);
        this.cardList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.cardList.setAdapter(this.mAdapter);
    }
}
