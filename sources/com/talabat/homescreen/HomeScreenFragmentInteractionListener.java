package com.talabat.homescreen;

import com.talabat.homescreen.adapter.model.vetrical.VerticalItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/talabat/homescreen/HomeScreenFragmentInteractionListener;", "", "getAvailableVerticals", "", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem;", "onGemExpired", "", "onLeavingHomeTab", "onReturningToHomeTab", "refreshHomeScreen", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HomeScreenFragmentInteractionListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onGemExpired(@NotNull HomeScreenFragmentInteractionListener homeScreenFragmentInteractionListener) {
        }
    }

    @NotNull
    List<VerticalItem> getAvailableVerticals();

    void onGemExpired();

    void onLeavingHomeTab();

    void onReturningToHomeTab();

    void refreshHomeScreen();
}
