package nl.vyx.pack.config.playerfile;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import nl.vyx.pack.Main;
import nl.vyx.pack.config.ConfigHandler;

public class EquippmentListener implements Listener {

	Main main = Main.getInstance();
	ConfigHandler config;

	public EquippmentListener(Main main) {
		this.main = main;
		config = new ConfigHandler(main);
	}

	// EVENT: Checks if the player changes inventory after it closes the
	// inventory EVERYTIME
	@EventHandler
	public void onPlayerChangeEquipment(InventoryCloseEvent e) {
		// Same BS variables ... lol
		Player p = (Player) e.getPlayer();
		File pFile = new File(config.getPlayersFolder(), p.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(pFile);

		// exists??
		if (pFile.exists()) {
			if (p.getMainHand() != null) {
				cfg.set("Member.Advanced.MainHand", p.getInventory().getItemInMainHand().toString());
			} else {
				cfg.set("Member.Advanced.MainHand", "Nothing in main-hand");
			}
			if (p.getInventory().getItemInOffHand() != null) {
				cfg.set("Member.Advanced.OffHand", p.getInventory().getItemInOffHand().toString());
			} else {
				cfg.set("Member.Advanced.OffHand", "Nothing in off-hand");
			}
			if (p.getInventory().getHelmet() != null) {
				cfg.set("Member.Advanced.Helmet", p.getInventory().getHelmet().toString());
			} else {
				cfg.set("Member.Advanced.Helmet", "Nothing equipped in Helmet slot");
			}
			if (p.getInventory().getChestplate() != null) {
				cfg.set("Member.Advanced.ChestPlate", p.getInventory().getChestplate().toString());
			} else {
				cfg.set("Member.Advanced.ChestPlate", "Nothing equipped in ChestPlater slot");
			}
			if (p.getInventory().getLeggings() != null) {
				cfg.set("Member.Advanced.Leggings", p.getInventory().getLeggings().toString());
			} else {
				cfg.set("Member.Advanced.Leggings", "Nothing equipped in Leggings slot");
			}
			if (p.getInventory().getBoots() != null) {
				cfg.set("Member.Advanced.Boots", p.getInventory().getBoots().toString());
			} else {
				cfg.set("Member.Advanced.Boots", "Nothing equipped in helmet slot");
			}
			config.safeCustomConfig(cfg, pFile);
		} else {
			main.log("Couldn't Find PlayerFile..! Please check DataFolder!!");
		}
	}

}
