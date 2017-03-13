//checks in what package its in
package nl.vyx.pack.config.playerfile;

//import to be able to use Files as Input and Output
import java.io.File;

import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerLoginEvent;

//Vault Imports communicating with the Library
import net.milkbowl.vault.economy.plugins.Economy_BOSE7;
import net.milkbowl.vault.economy.plugins.Economy_CommandsEX;
import net.milkbowl.vault.economy.plugins.Economy_Craftconomy3;
import net.milkbowl.vault.economy.plugins.Economy_CurrencyCore;
import net.milkbowl.vault.economy.plugins.Economy_DigiCoin;
import net.milkbowl.vault.economy.plugins.Economy_Dosh;
import net.milkbowl.vault.economy.plugins.Economy_EconXP;
import net.milkbowl.vault.economy.plugins.Economy_Essentials;
import net.milkbowl.vault.economy.plugins.Economy_GoldIsMoney2;
import net.milkbowl.vault.economy.plugins.Economy_GoldenChestEconomy;
import net.milkbowl.vault.economy.plugins.Economy_Gringotts;
import net.milkbowl.vault.economy.plugins.Economy_McMoney;
import net.milkbowl.vault.economy.plugins.Economy_MiConomy;
import net.milkbowl.vault.economy.plugins.Economy_MineConomy;
import net.milkbowl.vault.economy.plugins.Economy_Minefaconomy;
import net.milkbowl.vault.economy.plugins.Economy_MultiCurrency;
import net.milkbowl.vault.economy.plugins.Economy_SDFEconomy;
import net.milkbowl.vault.economy.plugins.Economy_TAEcon;
import net.milkbowl.vault.economy.plugins.Economy_XPBank;
import net.milkbowl.vault.economy.plugins.Economy_eWallet;
import net.milkbowl.vault.economy.plugins.Economy_iConomy6;
import net.milkbowl.vault.permission.Permission;
//Calling the main Class off my plugin to control it fully
import nl.vyx.pack.Main;
import nl.vyx.pack.config.ConfigHandler;

//Start of actuall Class
public class PlayerFileConfig implements Listener {
	Permission playerRank = null;
	// Getting all Economy variables
	Economy_Essentials EssEcon = null;
	Economy_BOSE7 BoseEcon = null;
	Economy_CommandsEX CEXEcon = null;
	Economy_Craftconomy3 CraftEcon = null;
	Economy_CurrencyCore CurrEcon = null;
	Economy_DigiCoin DigiEcon = null;
	Economy_Dosh DoshEcon = null;
	Economy_EconXP XPEcon = null;
	Economy_GoldIsMoney2 GIMEcon = null;
	Economy_GoldenChestEconomy GCEEcon = null;
	Economy_Gringotts GrinEcon = null;
	Economy_McMoney MCEcon = null;
	Economy_MiConomy MiEcon = null;
	Economy_MineConomy MineEcon = null;
	Economy_Minefaconomy MinefaEcon = null;
	Economy_MultiCurrency MultiEcon = null;
	Economy_SDFEconomy SDFEcon = null;
	Economy_TAEcon TAEcon = null;
	Economy_XPBank BankEcon = null;
	Economy_eWallet WalletEcon = null;
	Economy_iConomy6 iConomyEcon = null;
	Main main = Main.getInstance();
	ConfigHandler config;

	// Constructor to communicate outwards to the main class
	public PlayerFileConfig(Main main) {
		this.main = main;
		config = new ConfigHandler(main);
	}

	// EVENT: checking if its the players first join of the server.
	@EventHandler
	public void onPlayerFirstJoin(PlayerLoginEvent e) {
		// Getting the player logging in(Triggering the event)
		Player p = e.getPlayer();
		// Getting the offline data stored
		OfflinePlayer op = e.getPlayer();
		// Getting the playerfile of set member by name/
		File playerFile = new File(config.getPlayersFolder(), p.getName() + ".yml");
		// saying that the playerfile is a YAML/.yml File
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(playerFile);
		// checks if player has played before
		if (!p.hasPlayedBefore()) {
			// checks if the file already exists
			if (!playerFile.exists()) {
				// Creating player file <name>.yml
				config.createPlayerConfig(p.getName());
				// Telling console that it's creating the file
				main.log("Creating New Member File: " + p.getName() + ".yml");
				// Adding all default config nodes to the playerfile
				//
				// All default easy variables to work with
				cfg.addDefault("Member.Default.Name", p.getName().toString());
				cfg.addDefault("Member.Default.UUID", p.getUniqueId().toString());
				cfg.addDefault("Member.Default.DisplayName", p.getDisplayName().toString());
				cfg.addDefault("Member.Default.GameMode", p.getGameMode().toString());
				cfg.addDefault("Member.Default.Rank", playerRank.getPrimaryGroup(p).toString());
				cfg.addDefault("Member.Default.WhiteList", p.isWhitelisted());
				cfg.addDefault("Member.Default.LastOnline", p.getLastPlayed());
				cfg.addDefault("Member.Default.Kills", p.getStatistic(Statistic.PLAYER_KILLS));
				cfg.addDefault("Member.Default.MobKills", p.getStatistic(Statistic.MOB_KILLS));
				cfg.addDefault("Member.Default.Deaths", p.getStatistic(Statistic.DEATHS));
				cfg.addDefault("Member.Default.ItemsCrafted", p.getStatistic(Statistic.CRAFT_ITEM));
				// All Advanced variables to work with
				cfg.addDefault("Member.Advanced.IP", p.getAddress().getHostName());
				cfg.addDefault("Member.Advanced.Exp", p.getExp());
				cfg.addDefault("Member.Advanced.World", p.getWorld().toString());
				cfg.addDefault("Member.Advanced.Location.x", p.getLocation().getBlockX());
				cfg.addDefault("Member.Advanced.Location.y", p.getLocation().getBlockY());
				cfg.addDefault("Member.Advanced.Location.z", p.getLocation().getBlockZ());
				cfg.addDefault("Member.Advanced.Money.Essentials", EssEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.Bose7", BoseEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.CommandsEX", CEXEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.CraftConomy3", CraftEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.CurrencyCore", CurrEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.DigiCoin", DigiEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.Dosh", DoshEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.EconXP", XPEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.GoldIsMoney2", GIMEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.GoldenChestEconomy", GCEEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.Gringotts", GrinEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.McMoney", MCEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.MiConomy", MiEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.MineConomy", MineEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.Minefaconomy", MinefaEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.MultiCurrency", MultiEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.SDFEconomy", SDFEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.TAEcon", TAEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.XPBank", BankEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.eWallet", WalletEcon.getBalance(op));
				cfg.addDefault("Member.Advanced.Money.iConomy7", iConomyEcon.getBalance(op));
				// Checking if player has armor equipped also checking what
				// player is holding in both hands
				if (p.getMainHand() != null) {
					cfg.addDefault("Member.Advanced.MainHand", p.getInventory().getItemInMainHand().toString());
				} else {
					cfg.addDefault("Member.Advanced.MainHand", "Nothing in main-hand");
				}
				if (p.getInventory().getItemInOffHand() != null) {
					cfg.addDefault("Member.Advanced.OffHand", p.getInventory().getItemInOffHand().toString());
				} else {
					cfg.addDefault("Member.Advanced.OffHand", "Nothing in off-hand");
				}
				if (p.getInventory().getHelmet() != null) {
					cfg.addDefault("Member.Advanced.Helmet", p.getInventory().getHelmet().toString());
				} else {
					cfg.addDefault("Member.Advanced.Helmet", "Nothing equipped in Helmet slot");
				}
				if (p.getInventory().getChestplate() != null) {
					cfg.addDefault("Member.Advanced.ChestPlate", p.getInventory().getChestplate().toString());
				} else {
					cfg.addDefault("Member.Advanced.ChestPlate", "Nothing equipped in ChestPlater slot");
				}
				if (p.getInventory().getLeggings() != null) {
					cfg.addDefault("Member.Advanced.Leggings", p.getInventory().getLeggings().toString());
				} else {
					cfg.addDefault("Member.Advanced.Leggings", "Nothing equipped in Leggings slot");
				}
				if (p.getInventory().getBoots() != null) {
					cfg.addDefault("Member.Advanced.Boots", p.getInventory().getBoots().toString());
				} else {
					cfg.addDefault("Member.Advanced.Boots", "Nothing equipped in helmet slot");
				}
				// saving config file
				config.safeCustomConfig(cfg, playerFile);
				// Telling main to send the console that it's creating the file
				main.log("Member file created: " + p.getName() + ".yml");
				// if it does exist
			} else {
				// telling main to send the console that it already exists and
				// saving newest defaults
				main.log("PlayerFile Already Exists.. Saving newest defaults");
				// saving defaults
				config.safeCustomConfig(cfg, playerFile);
			}
		}
	}

	// EVENT: If the player has already played on the server
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e) {
		// Same Variable shit
		Player p = e.getPlayer();
		File playerFile = new File(config.getPlayersFolder(), p.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(playerFile);
		OfflinePlayer op = e.getPlayer();
		// if the playerfile already exists
		if (playerFile.exists()) {
			// telling console
			main.log("Saving Member File: " + p.getName() + ".yml");
			// setting new defaults from previous loggin
			cfg.set("Member.Default.Name", p.getName().toString());
			cfg.set("Member.Default.UUID", p.getUniqueId().toString());
			cfg.set("Member.Default.DisplayName", p.getDisplayName().toString());
			cfg.set("Member.Default.GameMode", p.getGameMode().toString());
			cfg.set("Member.Default.Rank", playerRank.getPrimaryGroup(p));
			cfg.set("Member.Default.WhiteList", p.isWhitelisted());
			cfg.set("Member.Advanced.IP", p.getAddress().getHostName());
			cfg.set("Member.Advanced.Exp", p.getExp());
			cfg.set("Member.Advanced.World", p.getWorld().toString());
			cfg.set("Member.Advanced.Location.x", p.getLocation().getBlockX());
			cfg.set("Member.Advanced.Location.y", p.getLocation().getBlockY());
			cfg.set("Member.Advanced.Location.z", p.getLocation().getBlockZ());
			cfg.set("Member.Advanced.Money.Essentials", EssEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.Bose7", BoseEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.CommandsEX", CEXEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.CraftConomy3", CraftEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.CurrencyCore", CurrEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.DigiCoin", DigiEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.Dosh", DoshEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.EconXP", XPEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.GoldIsMoney2", GIMEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.GoldenChestEconomy", GCEEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.Gringotts", GrinEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.McMoney", MCEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.MiConomy", MiEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.MineConomy", MineEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.Minefaconomy", MinefaEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.MultiCurrency", MultiEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.SDFEconomy", SDFEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.TAEcon", TAEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.XPBank", BankEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.eWallet", WalletEcon.getBalance(op));
			cfg.set("Member.Advanced.Money.iConomy7", iConomyEcon.getBalance(op));
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
			main.log("Member File Saved");
			// Just to be sure if it doesn't exists?
		} else {
			// Telling console it doesn't exist!
			main.log("Playerfile not found.. Creating..!");
			// creating file
			config.createPlayerConfig(p.getName());
			// telling console, creating file
			main.log("Creating New Member File: " + p.getName() + ".yml");
			// adding all default nodes
			cfg.addDefault("Member.Default.Name", p.getName().toString());
			cfg.addDefault("Member.Default.UUID", p.getUniqueId().toString());
			cfg.addDefault("Member.Default.DisplayName", p.getDisplayName().toString());
			cfg.addDefault("Member.Default.GameMode", p.getGameMode().toString());
			cfg.addDefault("Member.Default.Rank", playerRank.getPrimaryGroup(p));
			cfg.addDefault("Member.Default.WhiteList", p.isWhitelisted());
			cfg.addDefault("Member.Advanced.IP", p.getAddress().getHostName());
			cfg.addDefault("Member.Advanced.Exp", p.getExp());
			cfg.addDefault("Member.Advanced.World", p.getWorld().toString());
			cfg.addDefault("Member.Advanced.Location.x", p.getLocation().getBlockX());
			cfg.addDefault("Member.Advanced.Location.y", p.getLocation().getBlockY());
			cfg.addDefault("Member.Advanced.Location.z", p.getLocation().getBlockZ());
			cfg.addDefault("Member.Advanced.Money.Essentials", EssEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.Bose7", BoseEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.CommandsEX", CEXEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.CraftConomy3", CraftEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.CurrencyCore", CurrEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.DigiCoin", DigiEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.Dosh", DoshEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.EconXP", XPEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.GoldIsMoney2", GIMEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.GoldenChestEconomy", GCEEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.Gringotts", GrinEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.McMoney", MCEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.MiConomy", MiEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.MineConomy", MineEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.Minefaconomy", MinefaEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.MultiCurrency", MultiEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.SDFEconomy", SDFEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.TAEcon", TAEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.XPBank", BankEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.eWallet", WalletEcon.getBalance(op));
			cfg.addDefault("Member.Advanced.Money.iConomy7", iConomyEcon.getBalance(op));
			if (p.getMainHand() != null) {
				cfg.addDefault("Member.Advanced.MainHand", p.getInventory().getItemInMainHand().toString());
			} else {
				cfg.addDefault("Member.Advanced.MainHand", "Nothing in main-hand");
			}
			if (p.getInventory().getItemInOffHand() != null) {
				cfg.addDefault("Member.Advanced.OffHand", p.getInventory().getItemInOffHand().toString());
			} else {
				cfg.addDefault("Member.Advanced.OffHand", "Nothing in off-hand");
			}
			if (p.getInventory().getHelmet() != null) {
				cfg.addDefault("Member.Advanced.Helmet", p.getInventory().getHelmet().toString());
			} else {
				cfg.addDefault("Member.Advanced.Helmet", "Nothing equipped in Helmet slot");
			}
			if (p.getInventory().getChestplate() != null) {
				cfg.addDefault("Member.Advanced.ChestPlate", p.getInventory().getChestplate().toString());
			} else {
				cfg.addDefault("Member.Advanced.ChestPlate", "Nothing equipped in ChestPlater slot");
			}
			if (p.getInventory().getLeggings() != null) {
				cfg.addDefault("Member.Advanced.Leggings", p.getInventory().getLeggings().toString());
			} else {
				cfg.addDefault("Member.Advanced.Leggings", "Nothing equipped in Leggings slot");
			}
			if (p.getInventory().getBoots() != null) {
				cfg.addDefault("Member.Advanced.Boots", p.getInventory().getBoots().toString());
			} else {
				cfg.addDefault("Member.Advanced.Boots", "Nothing equipped in helmet slot");
			}
			// Again saving
			config.safeCustomConfig(cfg, playerFile);
			// telling console so.
			main.log("Member file created: " + p.getName() + ".yml");
		}
	}
	@EventHandler
	public void onGameModeChange(PlayerGameModeChangeEvent e){
		Player p = e.getPlayer();
		File pFile = new File(config.getPlayersFolder(), p.getName()+"yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(pFile);
		
		cfg.set("Member.Default.GameMode", p.getGameMode());
		config.safeCustomConfig(cfg, pFile);
	}
}