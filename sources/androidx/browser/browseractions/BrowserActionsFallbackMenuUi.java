package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.browser.R;
import androidx.core.widget.TextViewCompat;
import java.util.ArrayList;
import java.util.List;

@Deprecated
class BrowserActionsFallbackMenuUi implements AdapterView.OnItemClickListener {
    private static final String TAG = "BrowserActionskMenuUi";

    /* renamed from: b  reason: collision with root package name */
    public final Context f966b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f967c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public BrowserActionsFallMenuUiListener f968d;
    @Nullable
    private BrowserActionsFallbackMenuDialog mBrowserActionsDialog;
    private final List<BrowserActionItem> mMenuItems;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public interface BrowserActionsFallMenuUiListener {
        void onMenuShown(View view);
    }

    public BrowserActionsFallbackMenuUi(@NonNull Context context, @NonNull Uri uri, @NonNull List<BrowserActionItem> list) {
        this.f966b = context;
        this.f967c = uri;
        this.mMenuItems = buildFallbackMenuItemList(list);
    }

    private Runnable buildCopyAction() {
        return new Runnable() {
            public void run() {
                ((ClipboardManager) BrowserActionsFallbackMenuUi.this.f966b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", BrowserActionsFallbackMenuUi.this.f967c.toString()));
                Toast.makeText(BrowserActionsFallbackMenuUi.this.f966b, BrowserActionsFallbackMenuUi.this.f966b.getString(R.string.copy_toast_msg), 0).show();
            }
        };
    }

    @NonNull
    private List<BrowserActionItem> buildFallbackMenuItemList(List<BrowserActionItem> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BrowserActionItem(this.f966b.getString(R.string.fallback_menu_item_open_in_browser), buildOpenInBrowserAction()));
        arrayList.add(new BrowserActionItem(this.f966b.getString(R.string.fallback_menu_item_copy_link), buildCopyAction()));
        arrayList.add(new BrowserActionItem(this.f966b.getString(R.string.fallback_menu_item_share_link), buildShareAction()));
        arrayList.addAll(list);
        return arrayList;
    }

    private PendingIntent buildOpenInBrowserAction() {
        return PendingIntent.getActivity(this.f966b, 0, new Intent("android.intent.action.VIEW", this.f967c), 67108864);
    }

    private PendingIntent buildShareAction() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", this.f967c.toString());
        intent.setType("text/plain");
        return PendingIntent.getActivity(this.f966b, 0, intent, 67108864);
    }

    private BrowserActionsFallbackMenuView initMenuView(View view) {
        BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView) view.findViewById(R.id.browser_actions_menu_view);
        final TextView textView = (TextView) view.findViewById(R.id.browser_actions_header_text);
        textView.setText(this.f967c.toString());
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TextViewCompat.getMaxLines(textView) == Integer.MAX_VALUE) {
                    textView.setMaxLines(1);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    return;
                }
                textView.setMaxLines(Integer.MAX_VALUE);
                textView.setEllipsize((TextUtils.TruncateAt) null);
            }
        });
        ListView listView = (ListView) view.findViewById(R.id.browser_actions_menu_items);
        listView.setAdapter(new BrowserActionsFallbackMenuAdapter(this.mMenuItems, this.f966b));
        listView.setOnItemClickListener(this);
        return browserActionsFallbackMenuView;
    }

    public void displayMenu() {
        final View inflate = LayoutInflater.from(this.f966b).inflate(R.layout.browser_actions_context_menu_page, (ViewGroup) null);
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = new BrowserActionsFallbackMenuDialog(this.f966b, initMenuView(inflate));
        this.mBrowserActionsDialog = browserActionsFallbackMenuDialog;
        browserActionsFallbackMenuDialog.setContentView(inflate);
        if (this.f968d != null) {
            this.mBrowserActionsDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    BrowserActionsFallMenuUiListener browserActionsFallMenuUiListener = BrowserActionsFallbackMenuUi.this.f968d;
                    if (browserActionsFallMenuUiListener == null) {
                        Log.e(BrowserActionsFallbackMenuUi.TAG, "Cannot trigger menu item listener, it is null");
                    } else {
                        browserActionsFallMenuUiListener.onMenuShown(inflate);
                    }
                }
            });
        }
        this.mBrowserActionsDialog.show();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
        BrowserActionItem browserActionItem = this.mMenuItems.get(i11);
        if (browserActionItem.getAction() != null) {
            try {
                browserActionItem.getAction().send();
            } catch (PendingIntent.CanceledException e11) {
                Log.e(TAG, "Failed to send custom item action", e11);
            }
        } else if (browserActionItem.a() != null) {
            browserActionItem.a().run();
        }
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = this.mBrowserActionsDialog;
        if (browserActionsFallbackMenuDialog == null) {
            Log.e(TAG, "Cannot dismiss dialog, it has already been dismissed.");
        } else {
            browserActionsFallbackMenuDialog.dismiss();
        }
    }
}
