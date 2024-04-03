package com.instabug.chat.ui.chats;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.annotation.Nullable;
import com.instabug.chat.R;
import com.instabug.chat.model.d;
import com.instabug.chat.ui.ChatActivity;
import com.instabug.library.Feature;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.ToolbarFragment;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class h extends ToolbarFragment implements f, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private d f46271a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f46272b;

    /* renamed from: c  reason: collision with root package name */
    private a f46273c;

    public interface a {
        void a(String str);
    }

    public static h a(boolean z11) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putBoolean("compose_key", z11);
        hVar.setArguments(bundle);
        return hVar;
    }

    public void a(ArrayList arrayList) {
        this.f46272b = arrayList;
    }

    public boolean c() {
        if (getFragmentManager() != null) {
            return getFragmentManager().findFragmentById(R.id.instabug_fragment_container) instanceof h;
        }
        return false;
    }

    public int k0() {
        return R.layout.instabug_fragment_chats;
    }

    public void l() {
        this.f46271a.a((List) this.f46272b);
        this.f46271a.notifyDataSetChanged();
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String l0() {
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.CONVERSATIONS_LIST_TITLE, getLocalizedString(R.string.instabug_str_conversations));
    }

    public void m0(View view, @Nullable Bundle bundle) {
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.instabug_btn_toolbar_right);
        if (imageButton != null) {
            imageButton.setVisibility(8);
        }
        ListView listView = (ListView) view.findViewById(R.id.instabug_lst_chats);
        if (listView != null) {
            listView.setOnItemClickListener(this);
            d dVar = new d(this.f46272b);
            this.f46271a = dVar;
            listView.setAdapter(dVar);
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.instabug_btn_toolbar_left);
        if (imageButton2 != null) {
            imageButton2.setTag(R.id.TAG_BTN_CLOSE, "instabug_btn_close");
            imageButton2.setContentDescription(getLocalizedString(R.string.ibg_chats_conversations_close_content_description));
        }
    }

    public void o0() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (InstabugCore.isFeatureEnabled(Feature.REPLIES)) {
            InstabugCore.isFeatureEnabled(Feature.CHATS);
        }
        setRetainInstance(true);
        if (getActivity() != null && (getActivity() instanceof ChatActivity)) {
            this.f46273c = (a) getActivity();
        }
        this.C = new k(this);
        this.f46272b = new ArrayList();
    }

    public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
        a aVar = this.f46273c;
        if (aVar != null) {
            aVar.a(((d) adapterView.getItemAtPosition(i11)).getId());
        }
    }

    public void onStart() {
        super.onStart();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((e) presenter).b();
        }
        if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
            new Handler().postDelayed(new g(this), 300);
        }
    }

    public void onStop() {
        super.onStop();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((e) presenter).g();
        }
    }
}
