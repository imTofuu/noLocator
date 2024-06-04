package org.imtofuu.nolocator;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {

        Inventory inv = event.getPlayer().getInventory();
        for(ItemStack itemStack : inv.getContents()) {
            if(itemStack.getType() == Material.MAP) {
                event.getPlayer().damage(Double.MAX_VALUE);
            }
        }

    }

    @EventHandler
    public void playerPickUp(EntityPickupItemEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        if(event.getItem().getItemStack().getType() == Material.MAP) {
            event.getEntity().damage(Double.MAX_VALUE);
        }
    }

}
