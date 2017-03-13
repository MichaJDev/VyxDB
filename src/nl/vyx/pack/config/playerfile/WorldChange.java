package nl.vyx.pack.config.playerfile;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import nl.vyx.pack.Main;
import nl.vyx.pack.config.ConfigHandler;

public class WorldChange implements Listener {

	Main main = Main.getInstance();
	ConfigHandler config;
	public WorldChange(Main main){
		this.main = main;
		config = new ConfigHandler(main);
		
	}
	
	@EventHandler
	public void onPlayerLocationWorldChangeEvent(PlayerChangedWorldEvent e) {
		// same varaible shit
		Player p = e.getPlayer();
		File pFile = new File(config.getPlayersFolder(), p.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(pFile);
		// File exists
		if (pFile.exists()) {
			// changing Nodes in playerfile
			cfg.set("Member.Advanced.World", p.getLocation().getWorld().toString());
			cfg.set("Member.Advanced.Location.x", p.getLocation().getBlockX());
			cfg.set("Member.Advanced.Location.y", p.getLocation().getBlockY());
			cfg.set("Member.Advanced.Location.z", p.getLocation().getBlockZ());
			// saving
			config.safeCustomConfig(cfg, pFile);
		} else {
			// Couldn't find the file o.o
			main.log("Couldn't find PlayerFile..! Please check DataFolder!!");
		}
	}

}
