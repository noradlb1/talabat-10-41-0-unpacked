package datamodels;

import android.util.Pair;
import com.talabat.helpers.GlobalDataModel;
import java.util.ArrayList;
import java.util.Iterator;

public class ContinuousMenuListModel {
    private ArrayList<ContinuousMenuItemModel> menuListItems;
    ArrayList<Pair<MenuSection, Integer>> menuSectionsAndPositon = new ArrayList<>();
    private ArrayList<Integer> noSeperatorPositions = new ArrayList<>();

    public void createMenuDisplayModel(ArrayList<MenuSection> arrayList, ArrayList<MenuItem> arrayList2) {
        this.menuListItems = new ArrayList<>();
        Iterator<MenuSection> it = arrayList.iterator();
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            MenuSection next = it.next();
            this.noSeperatorPositions.add(Integer.valueOf(i11));
            this.menuListItems.add(new ContinuousMenuItemModel(1, next));
            this.menuSectionsAndPositon.add(new Pair(next, Integer.valueOf(i12)));
            i12++;
            i11++;
            Iterator<MenuItem> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                MenuItem next2 = it2.next();
                if (next2.price == 0.0f && !GlobalDataModel.MENU.priceOnSelectionItemAvailable) {
                    GlobalDataModel.MENU.priceOnSelectionItemAvailable = true;
                }
                if (next2.menuSectionId == next.f13863id) {
                    this.menuListItems.add(new ContinuousMenuItemModel(2, next2));
                    i12++;
                    i11++;
                }
            }
        }
    }

    public int getLastItemPosition() {
        return this.menuListItems.size() - 1;
    }

    public ContinuousMenuItemModel getMenuItemModelItemAtIndex(int i11) {
        return this.menuListItems.get(i11);
    }

    public int getMenuListItemCount() {
        return this.menuListItems.size();
    }

    public int getPositionOfMenuSection(MenuSection menuSection) {
        Iterator<Pair<MenuSection, Integer>> it = this.menuSectionsAndPositon.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            if (((MenuSection) next.first).f13863id == menuSection.f13863id) {
                return ((Integer) next.second).intValue();
            }
        }
        return 0;
    }
}
