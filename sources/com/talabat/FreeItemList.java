package com.talabat;

import JsonModels.parser.UniversalGson;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.helpers.BitmapLruCache;
import com.talabat.helpers.TalabatBase;
import datamodels.BenefitItem;
import library.talabat.mvp.IGlobalPresenter;
import tracking.ScreenNames;

@Instrumented
public class FreeItemList extends TalabatBase {
    public static final int SELECT_CHOICES = 2;
    private Button close;
    /* access modifiers changed from: private */
    public BenefitItem[] freeItems;
    private ListView free_item_list;

    /* renamed from: i  reason: collision with root package name */
    public ImageLoader f54048i;

    /* renamed from: j  reason: collision with root package name */
    public Gson f54049j;
    private Toolbar mToolbar;

    public class FreeItemListHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54051a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54052b;

        /* renamed from: c  reason: collision with root package name */
        public NetworkImageView f54053c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f54054d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f54055e;

        public FreeItemListHolder() {
        }
    }

    public class FreeListAdapter extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f54057b;

        public FreeListAdapter() {
            this.f54057b = LayoutInflater.from(FreeItemList.this);
        }

        public int getCount() {
            return FreeItemList.this.freeItems.length;
        }

        public Object getItem(int i11) {
            return FreeItemList.this.freeItems[i11];
        }

        public long getItemId(int i11) {
            return 0;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            FreeItemListHolder freeItemListHolder;
            final BenefitItem benefitItem = FreeItemList.this.freeItems[i11];
            if (view == null) {
                view = this.f54057b.inflate(R.layout.free_item, (ViewGroup) null);
                freeItemListHolder = new FreeItemListHolder();
                freeItemListHolder.f54051a = (TextView) view.findViewById(R.id.item_name);
                freeItemListHolder.f54052b = (TextView) view.findViewById(R.id.item_description);
                freeItemListHolder.f54053c = (NetworkImageView) view.findViewById(R.id.menu_image);
                freeItemListHolder.f54054d = (ImageView) view.findViewById(R.id.image_not_available);
                freeItemListHolder.f54055e = (ProgressBar) view.findViewById(R.id.progressBar);
                view.setTag(freeItemListHolder);
            } else {
                freeItemListHolder = (FreeItemListHolder) view.getTag();
            }
            if (benefitItem.hasThumbnail()) {
                freeItemListHolder.f54055e.setVisibility(0);
                freeItemListHolder.f54053c.setImageUrl(FreeItemList.this.freeItems[i11].getImage(), FreeItemList.this.f54048i);
                freeItemListHolder.f54053c.setVisibility(0);
                freeItemListHolder.f54054d.setVisibility(8);
            } else {
                freeItemListHolder.f54053c.setVisibility(8);
                freeItemListHolder.f54054d.setVisibility(0);
                freeItemListHolder.f54055e.setVisibility(8);
            }
            freeItemListHolder.f54051a.setText(FreeItemList.this.freeItems[i11].f13837name);
            freeItemListHolder.f54052b.setText(FreeItemList.this.freeItems[i11].description);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String str;
                    String str2;
                    if (benefitItem.containsChoices) {
                        Intent intent = new Intent(FreeItemList.this, FreeItemDetails.class);
                        Gson gson = FreeItemList.this.f54049j;
                        BenefitItem benefitItem = benefitItem;
                        if (!(gson instanceof Gson)) {
                            str2 = gson.toJson((Object) benefitItem);
                        } else {
                            str2 = GsonInstrumentation.toJson(gson, (Object) benefitItem);
                        }
                        intent.putExtra("BenefitItem", str2);
                        FreeItemList.this.startActivityForResult(intent, 2);
                        return;
                    }
                    FreeItemList freeItemList = FreeItemList.this;
                    Intent intent2 = freeItemList.getIntent();
                    Gson gson2 = FreeItemList.this.f54049j;
                    BenefitItem benefitItem2 = benefitItem;
                    if (!(gson2 instanceof Gson)) {
                        str = gson2.toJson((Object) benefitItem2);
                    } else {
                        str = GsonInstrumentation.toJson(gson2, (Object) benefitItem2);
                    }
                    freeItemList.setResult(-1, intent2.putExtra("selectedFreeItem", str));
                    FreeItemList.this.finish();
                }
            });
            return view;
        }
    }

    public void destroyPresenter() {
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.FREE_ITEM_LIST;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 2 && i12 == -1) {
            setResult(-1, getIntent().putExtra("selectedFreeItem", intent.getStringExtra("selectedFreeItem")));
            finish();
        }
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        try {
            setContentView((int) R.layout.free_itemlist);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            this.free_item_list = (ListView) findViewById(R.id.free_item_list);
            String stringExtra = getIntent().getStringExtra("freeItems");
            Gson gson = UniversalGson.INSTANCE.gson;
            this.f54049j = gson;
            Class cls = BenefitItem[].class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(stringExtra, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, stringExtra, cls);
            }
            this.freeItems = (BenefitItem[]) obj;
            this.f54048i = new ImageLoader(Volley.newRequestQueue(this), new BitmapLruCache());
            this.free_item_list.setAdapter(new FreeListAdapter());
            setTitle(R.id.title, getString(R.string.free_items_list));
            this.free_item_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                }
            });
            setBackButton(R.id.back);
        } catch (Exception unused) {
            finish();
        }
    }

    public void onError() {
    }
}
