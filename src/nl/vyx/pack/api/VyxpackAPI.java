package nl.vyx.pack.api;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import nl.vyx.pack.Main;
import nl.vyx.pack.config.ConfigHandler;

public class VyxpackAPI {
	Main main = Main.getInstance();
	ConfigHandler config;

	public VyxpackAPI(Main main) {
		this.main = main;
		config = new ConfigHandler(main);
	}

	/**
	 * Returns the main folder of VyxPack to be able to configure Config files
	 * or Player user files
	 * 
	 * @param p
	 *            Player
	 * @return Directory
	 */
	public File getPluginFolder() {
		return config.getMainFolder();
	}

	/**
	 * Returns the userdata folder of VyxPack to be able to configure Player
	 * userdata files
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Directory
	 */
	public File getPlayerFolder() {
		return config.getPlayersFolder();
	}

	/**
	 * Return the player files based on the given name
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return File
	 */
	public File getPlayerFile(Player p) {
		File file = new File(getPluginFolder(), p.getName() + ".yml");
		return file;
	}

	// Default
	/**
	 * Return the requested players name
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String
	 */

	public String getPlayerName(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Default.Name");
	}

	/**
	 * Return the requested players UUID
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String, UUID
	 */

	public String getPlayerUUID(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Default.UUID");
	}

	/**
	 * Return the requested players rank
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String, Rank
	 */

	public String getPlayerRank(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Default.Rank");
	}

	/**
	 * Return the requested players Display name
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String
	 */

	public String getPlayerDisplayName(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Default.DisplayName");
	}

	/**
	 * Return the requested players GameMode
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String, GameMode
	 */

	public String getPlayerGameMode(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Default.GameMode");
	}

	/**
	 * Return the requested boolean if player is whitelisted or not
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Boolean
	 */

	public Boolean getPlayerWhiteList(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getBoolean("Member.Default.WhiteListe");
	}

	/**
	 * Return the requested players last online date
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Long, Date
	 */

	public Long getPlayerLastOnline(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getLong("Member.Default.LastOnline");
	}

	/**
	 * Return the requested player's Kills
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String
	 */

	public String getPlayerKills(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Default.Kills");
	}

	/**
	 * Return the requested player's MobKills
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String
	 */

	public String getPlayerMobKills(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Default.MobKills");
	}

	/**
	 * Return the requested player's deaths
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String
	 */

	public String getPlayerDeaths(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Default.Deaths");
	}

	/**
	 * Return the requested player's amount of items crafted.
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String
	 */

	public int getPlayerItemsCrafterd(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getInt("Member.Default.ItemsCrafted");
	}

	// Advanced

	/**
	 * Return the requested player's IP Address
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String, IP
	 */

	public String getPlayerIP(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Advanced.IP");
	}

	/**
	 * Return the requested player's EXP amount
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Float
	 */

	public float getPlayerEXP(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return (float) cfg.getInt("Member.Advanced.Exp");
	}

	/**
	 * Return the requested player's World
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return String
	 */

	public String getPlayerWorld(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getString("Member.Advanced.World");
	}

	/**
	 * Return the requested players location Coord X
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */

	public Double getPlayerLocX(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Location.x");
	}

	/**
	 * Return the requested players location Coord Y
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerLocY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Location.y");
	}

	/**
	 * Return the requested players location Coord Z
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerLocZ(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Location.z");
	}

	// Money

	/**
	 * Return the requested players Balance through Essentials
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceESS(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.Essentials");
	}

	/**
	 * Return the requested players Balance through Bose7
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceBOSE(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.Bose");
	}

	/**
	 * Return the requested players Balance through CommandEx
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceCEX(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.CommandsEX");
	}

	/**
	 * Return the requested players Balance through CraftConomy
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceCRAFTCONOMY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.CraftConomy3");
	}

	/**
	 * Return the requested players Balance through CurrencyCore
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceCURRENCYCORE(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.CurrencyCore");
	}

	/**
	 * Return the requested players Balance through DigiCoin
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceDIGI(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.DigiCoin");
	}

	/**
	 * Return the requested players Balance through Dosh
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceDOSH(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.Dosh");
	}

	/**
	 * Return the requested players Balance through EconXP
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceECONXP(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.ExonXP");
	}

	/**
	 * Return the requested players Balance through Gold Is Money 2
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceGOLDISMONEY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.GoldIsMoney2");
	}

	/**
	 * Return the requested players Balance through Golden Chest
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceGOLDENCHEST(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.GolendeChestEconomy");
	}

	/**
	 * Return the requested players Balance through Gringotts
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceGRINGOTTS(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.Gringotts");
	}

	/**
	 * Return the requested players Balance through MiConomy
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceMICONOMY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.MiConomy");
	}

	/**
	 * Return the requested players Balance through McMoney
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceMCMONEY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.McMoney");
	}

	/**
	 * Return the requested players Balance through MineConomy
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceMINECONOMY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.MineConomy");
	}

	/**
	 * Return the requested players Balance through MinefaConomy
	 * 
	 * @param p
	 *            Player
	 * 
	 * @return Double
	 */
	public Double getPlayerBalanceMINEFACONOMY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.Minefaconomy");
	}

	/**
	 * Return the requested players Balance through MultiCurrency
	 * 
	 * @param p
	 *            Player
	 * @return Double
	 */
	public Double getPlayerBalanceMULTICURRENCY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.MultiCurrency");
	}

	/**
	 * Return the requested players Balance through SDF Economy
	 * 
	 * @param p
	 *            Player
	 * @return Double
	 */

	public Double getPlayerBalanceSDFECONOMY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.SDFEconomy");
	}

	/**
	 * Return the requested players Balance through TA Econ
	 * 
	 * @param p
	 *            Player
	 * @return Double
	 */
	public Double getPlayerBalanceTAECON(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.TAEcon");
	}

	/**
	 * Return the requested players Balance through XPBank
	 * 
	 * @param p
	 *            Player
	 * @return Double
	 */
	public Double getPlayerBalanceXPBANK(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.XPBank");
	}

	/**
	 * Return the requested players Balance through eWallet
	 * 
	 * @param p
	 *            Player
	 * @return Double
	 */
	public Double getPlayerBalanceEWALLET(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.eWallet");
	}

	/**
	 * Return the requested players Balance through iConomy7
	 * 
	 * @param p
	 *            Player
	 * @return Double
	 */
	public Double getPlayerBalanceICONOMY(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getDouble("Member.Advanced.Money.iConomy7");
	}

	/**
	 * Return the requested players Main Hand item
	 * 
	 * @param p
	 *            Player
	 * @return ItemStack
	 */
	public ItemStack getPlayerMainHand(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getItemStack("Member.Advanced.MainHand");
	}

	/**
	 * Returns the requested Players Off Hand item
	 * 
	 * @param p
	 *            Player
	 * @return ItemStack
	 */
	public ItemStack getPlayerOffHand(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getItemStack("Member.Advanced.OffHand");
	}

	/**
	 * Returns the requested players helmet
	 * 
	 * @param p
	 *            Player
	 * @return ItemStack
	 */
	public ItemStack getPlayerHelmet(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getItemStack("Member.Advanced.Helmet");
	}

	/**
	 * Returns the requested players Chestplate
	 * 
	 * @param p
	 *            Player
	 * @return ItemStack
	 */
	public ItemStack getPlayerChestPlate(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getItemStack("Member.Advanced.ChestPlate");
	}

	/**
	 * Returns the requested players leggings
	 * 
	 * @param p
	 *            Player
	 * @return ItemStack
	 */
	public ItemStack getPlayerLeggings(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getItemStack("Member.Advanced.Leggings");
	}

	/**
	 * Returns the requested players boots
	 * 
	 * @param p
	 *            Player Player
	 * @return ItemStack
	 */
	public ItemStack getPlayerBoots(Player p) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPlayerFile(p));
		return cfg.getItemStack("Member.Advanced.Boots");
	}

}
