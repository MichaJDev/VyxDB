package nl.vyx.pack.config.playerfile;

import java.io.File;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;

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
import nl.vyx.pack.Main;
import nl.vyx.pack.config.ConfigHandler;

public class PlayerDefaults implements Listener {

	Main main = Main.getInstance();
	ConfigHandler config;
	Permission playerRank = null;
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

	public PlayerDefaults(Main main) {
		this.main = main;
		config = new ConfigHandler(main);
	}

	@EventHandler
	public void onPlayerEvent(PlayerEvent e) {
		Player p = e.getPlayer();
		OfflinePlayer op = e.getPlayer();
		File pFile = new File(config.getPlayersFolder(), p.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(pFile);
		if (pFile.exists()) {
			cfg.set("Member.Default.DisplayName", p.getDisplayName());
			cfg.set("Member.Default.Name", p.getName());
			cfg.set("Member.Default.Rank", playerRank.getPrimaryGroup(p));
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
		} else {
			main.log("PlayerFile not found...! Please check DataFolder!!");
		}
	}
}
