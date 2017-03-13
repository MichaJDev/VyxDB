package nl.vyx.pack;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import nl.vyx.pack.config.ConfigHandler;
import nl.vyx.pack.config.playerfile.ArmorChangeRightClick;
import nl.vyx.pack.config.playerfile.EquippmentListener;
import nl.vyx.pack.config.playerfile.ExpChange;
import nl.vyx.pack.config.playerfile.PlayerDefaults;
import nl.vyx.pack.config.playerfile.PlayerFileConfig;
import nl.vyx.pack.config.playerfile.PlayerMove;
import nl.vyx.pack.config.playerfile.StatisticChecker;
import nl.vyx.pack.config.playerfile.WorldChange;

public class Main extends JavaPlugin {

	static Main main;
	ConfigHandler cfg;
	public static net.milkbowl.vault.economy.Economy econ = null;

	/**
	 * Instantiate classes
	 * @return Main
	 */
	public static Main getInstance() {
		return main;
	}
	
	public void onEnable() {
		log("Getting Commands");
		getCommands();
		log("Getting Listeners");
		getListeners();
		log("Loading/Creating Config");
		cfg.CreateConfig();
		cfg.SafeConfig();
		log("Getting Vault Dependencies");
		if (!setupEconomy()) {
			getLogger().severe(String.format("Disabling - no Vault Dependencies found!"));
		}
	}

	public void onDisable() {
		log("Disabling Commands");
		log("Disabling Listeners");
		log("Saving Config");
	}

	public void getCommands() {

	}
	/**
	 * Gets Listeners
	 * @return Listeners
	 */
	public void getListeners() {
		getServer().getPluginManager().registerEvents(new PlayerFileConfig(this), this);
		getServer().getPluginManager().registerEvents(new PlayerDefaults(this), this);
		getServer().getPluginManager().registerEvents(new PlayerMove(this), this);
		getServer().getPluginManager().registerEvents(new WorldChange(this), this);
		getServer().getPluginManager().registerEvents(new ExpChange(this), this);
		getServer().getPluginManager().registerEvents(new EquippmentListener(this), this);
		getServer().getPluginManager().registerEvents(new ArmorChangeRightClick(this), this);
		getServer().getPluginManager().registerEvents(new StatisticChecker(this), this);
	}
	
	public void log(String msg) {
		getLogger().info(ChatColor.translateAlternateColorCodes('&', msg));
	}
	/**
	 * Gets Vault economy
	 * @return Economy
	 */
	public boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<net.milkbowl.vault.economy.Economy> rsp = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

}
