package fr.titi.infinity.utils;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class InfinityTab extends ItemGroup {

    public static final InfinityTab TAB = new InfinityTab(ItemGroup.TABS.length, "infinitytab");

    public int tabinfinity;

    public InfinityTab(int i, String name) {
        super(i, name);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.STAR.get());
    }

    @Override
    public boolean hasSearchBar() {
        return tabinfinity == TAB.tabinfinity;
    }

    public int getSearchbarWidth() {
        return 89;
    }

}
