package com.instabug.chat.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.instabug.chat.ChatPlugin;
import com.instabug.chat.R;
import com.instabug.chat.ui.chat.i;
import com.instabug.chat.ui.chats.h;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.BaseFragmentActivity;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.OrientationUtils;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public class ChatActivity extends BaseFragmentActivity implements c, h.a {

    public class a implements FragmentManager.OnBackStackChangedListener {
        public a() {
        }

        public void onBackStackChanged() {
            ChatActivity.this.a();
        }
    }

    public int a(Intent intent) {
        int intExtra = intent.getIntExtra("chat_process", -1);
        int i11 = Opcodes.IF_ICMPLT;
        if (intExtra != 161) {
            i11 = Opcodes.IF_ICMPGE;
            if (intExtra != 162) {
                i11 = Opcodes.IF_ICMPLE;
                if (intExtra != 164) {
                    return Opcodes.IF_ICMPNE;
                }
            }
        }
        return i11;
    }

    public void a() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        ArrayList arrayList = new ArrayList();
        for (Fragment next : fragments) {
            if (next.getView() != null) {
                arrayList.add(next);
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            View view = ((Fragment) arrayList.get(i11)).getView();
            if (view != null) {
                if (i11 == arrayList.size() - 1) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                    view.sendAccessibilityEvent(32768);
                } else {
                    ViewCompat.setImportantForAccessibility(view, 4);
                }
            }
        }
    }

    public void a(String str) {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((b) presenter).a(str);
        }
    }

    public void a(String str, com.instabug.chat.model.a aVar) {
        if (!isFinishing()) {
            getSupportFragmentManager().executePendingTransactions();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            int i11 = R.id.instabug_fragment_container;
            FragmentTransaction add = beginTransaction.add(i11, (Fragment) i.b(str, aVar), "chat_fragment");
            if (getSupportFragmentManager().findFragmentById(i11) != null) {
                add.addToBackStack("chat_fragment");
            }
            add.commit();
        }
    }

    public boolean b() {
        Bundle extras = getIntent().getExtras();
        return extras != null && extras.getBoolean("compose");
    }

    public void c(String str) {
        if (!isFinishing()) {
            try {
                getSupportFragmentManager().executePendingTransactions();
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                int i11 = R.id.instabug_fragment_container;
                FragmentTransaction add = beginTransaction.add(i11, (Fragment) i.e(str), "chat_fragment");
                if (getSupportFragmentManager().findFragmentById(i11) != null) {
                    add.addToBackStack("chat_fragment");
                }
                add.commitAllowingStateLoss();
            } catch (IllegalStateException e11) {
                InstabugSDKLogger.e("IBG-BR", "Couldn't show Chat fragment due to " + e11.getMessage());
            }
        }
    }

    public void finish() {
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((b) presenter).f();
        }
        super.finish();
    }

    public int getLayout() {
        return R.layout.instabug_activity;
    }

    public void i() {
        if (!isFinishing()) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("chats_fragment");
            if (!(findFragmentByTag instanceof h) || !findFragmentByTag.isResumed()) {
                getSupportFragmentManager().beginTransaction().replace(R.id.instabug_fragment_container, (Fragment) h.a(b()), "chats_fragment").commit();
            }
        }
    }

    public void initViews() {
    }

    @Nullable
    public com.instabug.chat.model.a m() {
        return (com.instabug.chat.model.a) getIntent().getSerializableExtra("attachment");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        for (Fragment onActivityResult : getSupportFragmentManager().getFragments()) {
            onActivityResult.onActivityResult(i11, i12, intent);
        }
    }

    @SuppressLint({"STARVATION"})
    public void onCreate(@Nullable Bundle bundle) {
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null) {
            chatPlugin.setState(1);
        }
        super.onCreate(bundle);
        OrientationUtils.handelOrientation(this);
        if (SettingsManager.getInstance().getTheme() != null) {
            setTheme(com.instabug.chat.util.a.b(SettingsManager.getInstance().getTheme()));
        }
        d dVar = new d(this);
        this.f34199i = dVar;
        dVar.a(a(getIntent()));
        getSupportFragmentManager().addOnBackStackChangedListener(new a());
        setTitle("");
    }

    public void onDestroy() {
        OrientationUtils.unlockOrientation(this);
        SDKCoreEventPublisher.post(new SDKCoreEvent(SDKCoreEvent.ForegroundStatus.TYPE_FOREGROUNDS_STATUS, SDKCoreEvent.ForegroundStatus.VALUE_AVAILABLE));
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        String stringExtra;
        super.onNewIntent(intent);
        if (a(intent) == 161 && (stringExtra = intent.getStringExtra("chat_number")) != null) {
            a(stringExtra);
        }
    }

    public void onResume() {
        super.onResume();
        BaseContract.Presenter presenter = this.f34199i;
        if (presenter != null) {
            ((b) presenter).i();
        }
    }

    public void onStop() {
        super.onStop();
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null && chatPlugin.getState() != 2) {
            chatPlugin.setState(0);
        }
    }

    @Nullable
    public String q() {
        return getIntent().getStringExtra("chat_number");
    }
}
