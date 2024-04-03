package com.instabug.featuresrequest.ui.featuredetails;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.models.a;
import com.instabug.featuresrequest.models.g;
import com.instabug.featuresrequest.utils.b;
import com.instabug.featuresrequest.utils.h;
import com.instabug.featuresrequest.utils.n;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

@Instrumented
public class k extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f46778b;

    /* renamed from: c  reason: collision with root package name */
    public d f46779c;

    public k(ArrayList arrayList, d dVar) {
        this.f46778b = arrayList;
        this.f46779c = dVar;
    }

    private void a(Context context, a aVar, ImageView imageView) {
        AssetsCacheManager.getAssetEntity(AssetsCacheManager.createEmptyEntity(context, aVar.c(), AssetEntity.AssetType.IMAGE), new i(this, aVar));
    }

    private void a(Context context, j jVar, a aVar) {
        b(context, jVar, aVar);
        TextView textView = jVar.f46773c;
        if (textView != null) {
            textView.setTypeface(textView.getTypeface(), 1);
        }
        RelativeLayout relativeLayout = jVar.f46771a;
        if (relativeLayout != null) {
            relativeLayout.getBackground().setAlpha(13);
            if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                b.a(jVar.f46771a, ColorUtils.setAlphaComponent(SettingsManager.getInstance().getPrimaryColor(), 255));
            } else {
                b.a(jVar.f46771a, ContextCompat.getColor(context, 17170443));
            }
        }
    }

    private void a(Context context, j jVar, g gVar) {
        TextView textView;
        if (jVar.f46776f != null && (textView = jVar.f46777g) != null) {
            textView.setText(com.instabug.featuresrequest.utils.a.a(context, gVar.a()));
            h.a(gVar.c(), gVar.d(), jVar.f46776f, context);
            jVar.f46776f.setTextColor(Color.parseColor(gVar.d()));
            TextView textView2 = jVar.f46776f;
            textView2.setText(" " + jVar.f46776f.getText());
        }
    }

    public void b(Context context, j jVar, a aVar) {
        TextView textView = jVar.f46773c;
        if (textView != null) {
            textView.setTypeface(textView.getTypeface(), 0);
            jVar.f46773c.setText((aVar.f() == null || aVar.f().equalsIgnoreCase("null") || TextUtils.isEmpty(aVar.f().trim())) ? LocaleUtils.getLocaleStringResource(Instabug.getLocale(context), R.string.feature_request_owner_anonymous_word, context) : aVar.f());
        }
        if (jVar.f46772b != null) {
            if (aVar.d() == null) {
                a(context, aVar, jVar.f46772b);
                jVar.f46772b.setImageResource(R.drawable.ibg_core_ic_avatar);
            } else {
                try {
                    jVar.f46772b.setImageBitmap(BitmapFactoryInstrumentation.decodeStream(new FileInputStream(new File(aVar.d()))));
                } catch (FileNotFoundException e11) {
                    InstabugSDKLogger.e("IBG-FR", "Can't set avatar image in feature detail comments", e11);
                }
            }
        }
        TextView textView2 = jVar.f46774d;
        if (textView2 != null) {
            textView2.setText(com.instabug.featuresrequest.utils.a.a(context, aVar.a()));
        }
        String localeStringResource = LocaleUtils.getLocaleStringResource(Instabug.getLocale(context), R.string.feature_request_str_more, context);
        String localeStringResource2 = LocaleUtils.getLocaleStringResource(Instabug.getLocale(context), R.string.feature_request_str_less, context);
        TextView textView3 = jVar.f46775e;
        if (textView3 != null && localeStringResource != null && localeStringResource2 != null) {
            n.a(textView3, aVar.e(), localeStringResource, localeStringResource2, aVar.j(), new g(this, aVar));
        }
    }

    public int getCount() {
        return this.f46778b.size();
    }

    public Object getItem(int i11) {
        return this.f46778b.get(i11);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public int getItemViewType(int i11) {
        if (this.f46778b.get(i11) instanceof a) {
            return ((a) this.f46778b.get(i11)).i() ? 1 : 0;
        }
        return 2;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        j jVar;
        int itemViewType = getItemViewType(i11);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(itemViewType != 1 ? itemViewType != 2 ? R.layout.ib_fr_item_comment : R.layout.ib_fr_item_status_change : R.layout.ib_fr_item_admin_comment, viewGroup, false);
            jVar = new j(view);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        if (itemViewType == 1) {
            a(view.getContext(), jVar, (a) getItem(i11));
        } else if (itemViewType != 2) {
            b(view.getContext(), jVar, (a) getItem(i11));
        } else {
            a(view.getContext(), jVar, (g) getItem(i11));
        }
        return view;
    }
}
