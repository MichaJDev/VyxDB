
package nl.vyx.pack.config.playerfile;

import java.io.File;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import nl.vyx.pack.Main;
import nl.vyx.pack.config.ConfigHandler;

public class ArmorChangeRightClick implements Listener {

	Main main = Main.getInstance();
	ConfigHandler config;

	public ArmorChangeRightClick(Main main) {
		this.main = main;
		config = new ConfigHandler(main);
	}

	// EVENT: If the player rightclick equipps armor.
	/**
	 * Event to check armor change events by rightclicking
	 * 
	 * @param e
	 */
	@EventHandler
	public void onPlayerChangeArmorByRightClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		// Leather itemStacks
		ItemStack LeatherHelmet = new ItemStack(Material.LEATHER_HELMET);
		ItemStack LeatherChest = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack LeatherLegs = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack LeatherBoots = new ItemStack(Material.LEATHER_BOOTS);
		// Chain itemStacks
		ItemStack ChainHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemStack ChainChest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack ChainLegs = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack ChainBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
		// Gold itemStacks
		ItemStack GoldHelmet = new ItemStack(Material.GOLD_HELMET);
		ItemStack GoldChest = new ItemStack(Material.GOLD_CHESTPLATE);
		ItemStack GoldLegs = new ItemStack(Material.GOLD_LEGGINGS);
		ItemStack GoldBoots = new ItemStack(Material.GOLD_BOOTS);
		// Iron itemStacks
		ItemStack IronHelmet = new ItemStack(Material.IRON_HELMET);
		ItemStack IronChest = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack IronLegs = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack IronBoots = new ItemStack(Material.IRON_BOOTS);
		// Dia itemStacks
		ItemStack DiaHelmet = new ItemStack(Material.DIAMOND_HELMET);
		ItemStack DiaChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack DiaLegs = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemStack DiaBoots = new ItemStack(Material.DIAMOND_BOOTS);
		// Getting Main hand item
		ItemStack MainHand = new ItemStack(p.getInventory().getItemInMainHand());
		// Checking what "Action" the player makes
		Action act = e.getAction();
		// Checking if it's interacting through rightclicking in the air and
		// what kind of Armor it is or if it's even Armor
		if ((act == Action.RIGHT_CLICK_AIR && act == Action.RIGHT_CLICK_BLOCK) && (MainHand == LeatherHelmet
				|| MainHand == LeatherChest || MainHand == LeatherLegs || MainHand == LeatherBoots
				|| MainHand == ChainHelmet || MainHand == ChainChest || MainHand == ChainLegs || MainHand == ChainBoots
				|| MainHand == GoldHelmet || MainHand == GoldChest || MainHand == GoldLegs || MainHand == GoldBoots
				|| MainHand == IronHelmet || MainHand == IronChest || MainHand == IronLegs || MainHand == IronBoots
				|| MainHand == DiaHelmet || MainHand == DiaChest || MainHand == DiaLegs || MainHand == DiaBoots)) {
			File pFile = new File(config.getPlayersFolder(), p.getName() + ".yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(pFile);
			// if exists
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
				main.log("PlayerFile not found...! Please check DataFolder!!");
			}
		}
	}

}
