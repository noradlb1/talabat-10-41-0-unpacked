package com.talabat.adapters.restaurantslist.viewholders;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.flutter.CollectionsFlutterFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/adapters/restaurantslist/viewholders/CollectionsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionsViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        Context context = getContainerView().getContext();
        if (context != null) {
            FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "containerView.context as…y).supportFragmentManager");
            Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.collectionsFlutterFragment);
            if (findFragmentById != null) {
                supportFragmentManager.beginTransaction().remove(findFragmentById).commit();
            }
            supportFragmentManager.beginTransaction().replace((int) R.id.collectionsFlutterFragment, (Fragment) new CollectionsFlutterFragment(), "collections").commit();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
