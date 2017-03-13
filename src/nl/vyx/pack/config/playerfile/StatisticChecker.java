package nl.vyx.pack.config.playerfile;

import java.io.File;

import org.bukkit.Statistic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;

import nl.vyx.pack.Main;
import nl.vyx.pack.config.ConfigHandler;

public class StatisticChecker implements Listener {

	Main main = Main.getInstance();
	ConfigHandler config;

	public StatisticChecker(Main main) {
		this.main = main;
		config = new ConfigHandler(main);
	}
	
	@EventHandler
	public void StatisticsChecker(PlayerEvent e){
		Player p = e.getPlayer();
		File pFile = new File(config.getPlayersFolder(), p.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(pFile); 
		
		cfg.set("Member.Default.WhiteList", p.isWhitelisted());
		cfg.set("Member.Default.LastOnline", p.getLastPlayed());
		cfg.set("Member.Default.Kills", p.getStatistic(Statistic.PLAYER_KILLS));
		cfg.set("Member.Default.MobKills", p.getStatistic(Statistic.MOB_KILLS));
		cfg.set("Member.Default.Deaths", p.getStatistic(Statistic.DEATHS));
		cfg.set("Member.Default.ItemsCrafted", p.getStatistic(Statistic.CRAFT_ITEM));
		config.safeCustomConfig(cfg, pFile);
	}

}
