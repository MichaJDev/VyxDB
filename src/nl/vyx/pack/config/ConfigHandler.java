package nl.vyx.pack.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.vyx.pack.Main;

public class ConfigHandler {

	Main main = Main.getInstance();

	File cfgFile = new File(main.getDataFolder(), "config.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(cfgFile);

	public ConfigHandler(Main main) {
		this.main = main;
	}

	/**
	 * Reloads Config
	 */
	public void ReloadConfig() {
		main.reloadConfig();
	}

	/**
	 * Creates default config
	 */
	public void CreateConfig() {
		try {
			cfg.save(cfgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Saves config
	 */
	public void SafeConfig() {
		main.log("Saving Config");
		try {
			cfg.getDefaults();
			cfg.save(cfgFile);
			main.log("Config Saved!");
		} catch (IOException e) {
			main.log("Couldn\'t safe Config ");
			e.printStackTrace();
		}

	}

	/**
	 * Creates playerfile via name
	 * 
	 * @param name
	 */
	public void createPlayerConfig(String name) {
		File cfgFile = new File(main.getDataFolder(), name + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(cfgFile);

		try {
			cfgFile.createNewFile();
			cfg.save(cfgFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Saves custom config
	 * 
	 * @param cfg
	 * @param pFile
	 */
	public void safeCustomConfig(FileConfiguration cfg, File pFile) {
		try {
			cfg.options().copyDefaults(true);
			cfg.save(pFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Returns Playerfolder
	 * 
	 * @return Directory
	 */
	public File getPlayersFolder() {
		File userFolder = new File(getMainFolder() + File.separator + "User");
		if (!userFolder.exists()) {
			try {
				userFolder.mkdirs();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		return userFolder;
	}

	/**
	 * Gets main folder
	 * 
	 * @return Directory
	 */
	public File getMainFolder() {
		File mainFolder = main.getDataFolder();
		if (!mainFolder.exists()) {
			try {
				mainFolder.mkdirs();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		return mainFolder;
	}

}
