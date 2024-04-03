package com.talabat.sidemenu;

import android.content.Context;
import com.talabat.configuration.country.Country;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTrackerConstants;
import datamodels.JMenuItem;
import datamodels.JMenuSection;
import java.util.ArrayList;
import java.util.Iterator;

public class SideMenuFactory {
    public static ArrayList<SideMenuHeader> createSideMenuItems(JMenuSection[] jMenuSectionArr, JMenuSection[] jMenuSectionArr2, Context context, Country country) {
        ArrayList<SideMenuHeader> arrayList = new ArrayList<>();
        if (jMenuSectionArr2 != null) {
            for (JMenuSection jMenuSection : jMenuSectionArr2) {
                if (isMenuValid(jMenuSection)) {
                    SideMenuHeader sideMenuHeader = new SideMenuHeader();
                    sideMenuHeader.setValue(jMenuSection, context, country);
                    for (JMenuItem jMenuItem : jMenuSection.items) {
                        if (isMenuValid(jMenuItem)) {
                            if (sideMenuHeader.subItems == null) {
                                sideMenuHeader.subItems = new ArrayList<>();
                            }
                            SideMenuItem sideMenuItem = new SideMenuItem();
                            sideMenuItem.setValue(jMenuItem, context, country);
                            sideMenuHeader.subItems.add(sideMenuItem);
                        }
                    }
                    arrayList.add(sideMenuHeader);
                }
            }
        }
        for (JMenuSection jMenuSection2 : jMenuSectionArr) {
            if (isMenuValid(jMenuSection2)) {
                SideMenuHeader sideMenuHeader2 = new SideMenuHeader();
                sideMenuHeader2.setValue(jMenuSection2, context, country);
                for (JMenuItem jMenuItem2 : jMenuSection2.items) {
                    if (isMenuValid(jMenuItem2)) {
                        if (sideMenuHeader2.subItems == null) {
                            sideMenuHeader2.subItems = new ArrayList<>();
                        }
                        SideMenuItem sideMenuItem2 = new SideMenuItem();
                        sideMenuItem2.setValue(jMenuItem2, context, country);
                        sideMenuHeader2.subItems.add(sideMenuItem2);
                    }
                }
                arrayList.add(sideMenuHeader2);
            }
        }
        return arrayList;
    }

    public static ArrayList<SidemenuExpandableListItem> getMenuExpandableList(ArrayList<SideMenuHeader> arrayList) {
        ArrayList<SidemenuExpandableListItem> arrayList2 = new ArrayList<>();
        arrayList2.add(new SidemenuExpandableListItem(new Object(), SideMenuViewType.PADDING));
        arrayList2.add(new SidemenuExpandableListItem(new Object(), SideMenuViewType.FINDRESTAURANT));
        Iterator<SideMenuHeader> it = arrayList.iterator();
        while (it.hasNext()) {
            SideMenuHeader next = it.next();
            int i11 = SideMenuViewType.HEADER;
            if (next.getRef().equalsIgnoreCase("tlife")) {
                i11 = 7;
            }
            if (next.getRef().equalsIgnoreCase("rewards")) {
                i11 = SideMenuViewType.REWARD;
            }
            if (next.getRef().equalsIgnoreCase("tPro")) {
                i11 = 8;
            }
            if (next.getRef().equalsIgnoreCase("tProSavings")) {
                i11 = 9;
            }
            if (next.getRef().equalsIgnoreCase("paylater")) {
                i11 = 10;
            }
            if (next.getRef().equalsIgnoreCase(GrowthTrackerConstants.VOUCHERS_FEATURE_NAME)) {
                i11 = 11;
            }
            arrayList2.add(new SidemenuExpandableListItem(next, i11));
        }
        return arrayList2;
    }

    private static boolean isMenuValid(Object obj) {
        int i11;
        if (obj instanceof JMenuItem) {
            int i12 = ((JMenuItem) obj).countryId;
            if (i12 == 0 || i12 == GlobalDataModel.SelectedCountryId) {
                return true;
            }
            return false;
        } else if (!(obj instanceof JMenuSection) || ((i11 = ((JMenuSection) obj).countryId) != 0 && i11 != GlobalDataModel.SelectedCountryId)) {
            return false;
        } else {
            return true;
        }
    }
}
