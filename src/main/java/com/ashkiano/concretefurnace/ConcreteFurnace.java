package com.ashkiano.concretefurnace;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class ConcreteFurnace extends JavaPlugin {

    @Override
    public void onEnable() {
        // Loop through all Concrete Powder colors
        for (Material powder : Material.values()) {
            if (!powder.name().endsWith("_CONCRETE_POWDER")) continue;

            String concreteName = powder.name().replace("_POWDER", "");
            Material concrete = Material.valueOf(concreteName);

            // Create a new furnace recipe for converting Concrete Powder to Concrete
            NamespacedKey key = new NamespacedKey(this, concreteName.toLowerCase());
            FurnaceRecipe recipe = new FurnaceRecipe(key, new ItemStack(concrete), powder, 0.1f, 200);

            // Register the recipe
            Bukkit.addRecipe(recipe);
        }
        Metrics metrics = new Metrics(this, 21223);
    }
}
