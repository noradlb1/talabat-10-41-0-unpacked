package com.instabug.chat.ui.chat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cc.b;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.instabug.chat.ChatPlugin;
import com.instabug.chat.R;
import com.instabug.chat.cache.k;
import com.instabug.chat.model.a;
import com.instabug.chat.ui.annotation.c;
import com.instabug.chat.ui.annotation.d;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.ToolbarFragment;
import com.instabug.library.internal.InstabugMediaProjectionIntent;
import com.instabug.library.internal.video.RequestPermissionActivityLauncher;
import com.instabug.library.internal.video.VideoPlayerFragment;
import com.instabug.library.screenshot.ScreenshotProvider;
import com.instabug.library.ui.custom.InstabugAlertDialog;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PermissionsUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.util.SystemServiceUtils;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED", "ERADICATE_FIELD_NOT_NULLABLE"})
public class i extends ToolbarFragment implements e, View.OnClickListener, f0, b, c {
    @Nullable
    public ImageButton I;
    @Nullable
    public ImageView J;

    /* renamed from: a  reason: collision with root package name */
    private String f46222a;

    /* renamed from: b  reason: collision with root package name */
    private h0 f46223b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f46224c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f46225d;

    public static i b(String str, a aVar) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putString("chat_number", str);
        bundle.putSerializable("attachment", aVar);
        iVar.setArguments(bundle);
        return iVar;
    }

    public static i e(String str) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putString("chat_number", str);
        iVar.setArguments(bundle);
        return iVar;
    }

    private Intent s() {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 24) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
        } else {
            intent = new Intent("android.intent.action.PICK");
        }
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        return Intent.createChooser(intent, getLocalizedString(R.string.instabug_str_pick_media_chooser_title));
    }

    private void t() {
        if (getActivity() != null && this.C != null) {
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.instabug_fragment_container, (Fragment) c.a((b) this), "attachments_bottom_sheet_fragment").addToBackStack("attachments_bottom_sheet_fragment").commit();
        }
    }

    private void u() {
        PermissionsUtils.requestPermission((Fragment) this, PermissionUtil.READ_EXTERNAL_PERMISSION, (int) Opcodes.IF_ICMPGE, (Runnable) new g(this), (Runnable) new h(this));
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null) {
            chatPlugin.setState(2);
        }
    }

    private void w() {
        if (getActivity() == null) {
            return;
        }
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.RECORD_AUDIO") != 0) {
            requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, Opcodes.IF_ICMPGT);
        } else {
            x();
        }
    }

    private void x() {
        MediaProjectionManager mediaProjectionManager;
        if (getActivity() != null && (mediaProjectionManager = (MediaProjectionManager) getActivity().getSystemService("media_projection")) != null) {
            if (InstabugMediaProjectionIntent.getMediaProjectionIntent() != null) {
                BaseContract.Presenter presenter = this.C;
                if (presenter != null) {
                    ((d) presenter).a(InstabugMediaProjectionIntent.getMediaProjectionIntent());
                    return;
                }
                return;
            }
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 3890);
        }
    }

    public void a() {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((d) presenter).a();
        }
    }

    public void a(Uri uri, String str) {
        d dVar = (d) this.C;
        if (!(getActivity() == null || dVar == null)) {
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.instabug_fragment_container, (Fragment) d.a(dVar.d().i(), dVar.d().getId(), uri, str), "annotation_fragment_for_chat").addToBackStack("annotation_fragment_for_chat").commit();
        }
        this.C = dVar;
    }

    public void a(String str) {
        if (getActivity() != null) {
            SystemServiceUtils.hideInputMethod(getActivity());
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.instabug_fragment_container, (Fragment) p.a(str), "image_attachment_viewer_fragment").addToBackStack("image_attachment_viewer_fragment").commit();
        }
    }

    public void a(String str, Uri uri) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public void a(String str, Uri uri, String str2) {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null && str != null && str.equals(((d) presenter).d().getId())) {
            d dVar = (d) this.C;
            dVar.a(dVar.a(dVar.d().getId(), ((d) this.C).a(uri, str2)));
        }
    }

    public void a(List list) {
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            this.f46223b.a(((d) presenter).a(list));
        }
    }

    public void b() {
        u();
    }

    public void b(String str) {
        if (getActivity() != null) {
            SystemServiceUtils.hideInputMethod(getActivity());
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.instabug_fragment_container, (Fragment) VideoPlayerFragment.newInstance(str), VideoPlayerFragment.TAG).addToBackStack(VideoPlayerFragment.TAG).commit();
        }
    }

    public void d() {
        if (getActivity() != null) {
            new InstabugAlertDialog.Builder(getActivity()).setTitle(getLocalizedString(com.instabug.library.R.string.instabug_str_video_length_limit_warning_title)).setMessage(getLocalizedString(com.instabug.library.R.string.instabug_str_video_length_limit_warning_message)).setPositiveButton(getLocalizedString(R.string.instabug_str_ok), new b()).show();
        }
    }

    public void d(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "Unable to view this url " + str + "\nError message: " + e11.getMessage());
        }
    }

    public void e() {
        ImageView imageView = this.J;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void f() {
        if (getActivity() != null) {
            RequestPermissionActivityLauncher.start(getActivity(), false, false, (ScreenshotProvider.ScreenshotCapturingListener) null);
        }
    }

    public void g() {
        v();
    }

    public void h() {
        if (getActivity() != null) {
            new InstabugAlertDialog.Builder(getActivity()).setTitle(getLocalizedString(R.string.instabug_str_bugreport_file_size_limit_warning_title)).setMessage(getLocalizedString(R.string.instabug_str_bugreport_file_size_limit_warning_message, 50L)).setPositiveButton(getLocalizedString(R.string.instabug_str_ok), new cc.c()).show();
        }
    }

    public void j() {
        ImageView imageView;
        if (this.F != null && (imageView = this.J) != null) {
            Colorizer.applyPrimaryColorTint(imageView);
            this.J.setOnClickListener(this);
        }
    }

    public int k0() {
        return R.layout.instabug_fragment_chat;
    }

    public String l0() {
        com.instabug.chat.model.d a11 = k.a(this.f46222a);
        if (a11 == null) {
            return getLocalizedString(R.string.instabug_str_empty);
        }
        String i11 = a11.i();
        this.f46225d = i11;
        return i11;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void m0(View view, @Nullable Bundle bundle) {
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.instabug_btn_toolbar_right);
        if (imageButton != null) {
            imageButton.setVisibility(8);
        }
        ListView listView = (ListView) view.findViewById(R.id.instabug_lst_messages);
        EditText editText = (EditText) view.findViewById(R.id.instabug_edit_text_new_message);
        this.f46224c = editText;
        if (editText != null) {
            editText.setHint(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.CONVERSATION_TEXT_FIELD_HINT, getLocalizedString(R.string.instabug_str_sending_message_hint)));
            this.f46224c.setInputType(16385);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.instabug_btn_send);
        if (getContext() != null) {
            Drawable primaryColorTintedDrawable = Colorizer.getPrimaryColorTintedDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ibg_core_ic_send));
            if (imageView != null) {
                imageView.setImageDrawable(primaryColorTintedDrawable);
                imageView.setContentDescription(getLocalizedString(R.string.ibg_chat_send_message_btn_content_description));
            }
        }
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        h0 h0Var = new h0(new ArrayList(), getActivity(), listView, this);
        this.f46223b = h0Var;
        if (listView != null) {
            listView.setAdapter(h0Var);
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.instabug_btn_toolbar_left);
        this.I = imageButton2;
        if (imageButton2 != null) {
            imageButton2.setTag(R.id.TAG_BTN_BACK, "instabug_btn_back");
            this.I.setContentDescription(getLocalizedString(R.string.ibg_chat_back_to_conversations_btn_content_description));
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.instabug_btn_attach);
        this.J = imageView2;
        if (imageView2 != null) {
            imageView2.setContentDescription(getLocalizedString(R.string.ibg_chat_add_attachment_btn_content_description));
        }
    }

    public void n() {
        ImageButton imageButton = this.I;
        if (imageButton != null) {
            imageButton.setImageResource(R.drawable.ibg_core_ic_close);
        }
    }

    public void o() {
        ImageButton imageButton = this.I;
        if (imageButton != null) {
            imageButton.setImageResource(R.drawable.ibg_core_ic_back);
            this.I.setRotation((float) getResources().getInteger(R.integer.instabug_icon_lang_rotation));
        }
    }

    public void o0() {
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((d) presenter).a(i11, i12, intent);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.instabug_btn_send) {
            String obj = this.f46224c.getText().toString();
            if (!TextUtils.isEmpty(obj.trim())) {
                BaseContract.Presenter presenter = this.C;
                if (presenter != null) {
                    d dVar = (d) presenter;
                    dVar.a(dVar.a(dVar.d().getId(), obj));
                }
                this.f46224c.setText("");
            }
        } else if (view.getId() == R.id.instabug_btn_attach && getActivity() != null) {
            SystemServiceUtils.hideInputMethod(getActivity());
            t();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getArguments() != null) {
            this.f46222a = getArguments().getString("chat_number");
        }
        this.C = new l(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((d) presenter).c();
        }
        this.f46224c = null;
        this.J = null;
        this.I = null;
    }

    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != 0) {
            if (i11 != 163) {
                return;
            }
        } else if (i11 == 162) {
            BaseContract.Presenter presenter = this.C;
            if (presenter != null) {
                ((d) presenter).j();
                return;
            }
            return;
        } else if (i11 != 163) {
            super.onRequestPermissionsResult(i11, strArr, iArr);
            return;
        }
        x();
    }

    public void onStart() {
        BaseContract.Presenter presenter;
        super.onStart();
        BaseContract.Presenter presenter2 = this.C;
        if (presenter2 != null) {
            ((d) presenter2).h();
        }
        a aVar = getArguments() != null ? (a) getArguments().getSerializable("attachment") : null;
        if (!(aVar == null || (presenter = this.C) == null)) {
            ((d) presenter).a(aVar);
        }
        if (getArguments() != null) {
            getArguments().clear();
        }
    }

    public void onStop() {
        super.onStop();
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((d) presenter).e();
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((d) presenter).b(this.f46222a);
        }
        ViewCompat.setAccessibilityDelegate(view, new f(this));
    }

    public void p() {
        this.f46223b.notifyDataSetChanged();
    }

    public void r() {
        startActivityForResult(s(), Opcodes.IF_ICMPLT);
    }

    public void v() {
        if (!com.instabug.chat.screenrecording.c.a().b()) {
            w();
        } else if (getContext() != null) {
            Toast.makeText(getContext(), R.string.instabug_str_video_encoder_busy, 0).show();
        }
    }
}
