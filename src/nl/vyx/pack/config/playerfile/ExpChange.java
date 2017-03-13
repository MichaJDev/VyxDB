package nl.vyx.pack.config.playerfile;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

import nl.vyx.pack.Main;
import nl.vyx.pack.config.ConfigHandler;

public class ExpChange implements Listener {

	Main main = Main.getInstance();
	ConfigHandler config;

	public ExpChange(Main main) {
		this.main = main;
		config = new ConfigHandler(main);
	}

	// EVENT: Checks if the Exp variables have changes
	@EventHandler
	public void onPlayerExpChange(PlayerExpChangeEvent e) {
		// bs variables
		Player p = e.getPlayer();
		File pFile = new File(config.getPlayersFolder(), p.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(pFile);
		// Exists...
		if (pFile.exists()) {
			cfg.set("Member.Advanced.Exp", p.getExp());
			config.safeCustomConfig(cfg, pFile);
		} else {
			main.log("PlayerFile not found...! Please check DataFolder!!");
		}
	}

}
