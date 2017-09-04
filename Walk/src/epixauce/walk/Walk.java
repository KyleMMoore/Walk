/*
 * Author: Kyle Moore (Epixauce)
 * Purpose: To Slow users to a better walking pace
 * For: Legends of the Fallen Minecraft Server
 */

package epixauce.walk;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import epixauce.walk.commands.*;

public class Walk extends JavaPlugin{

public final FileConfiguration config = getConfig(); //creates the config probably

public static Walk plugin; //declares instance variable

@Override
public void onEnable(){
	plugin = this;
	
	config.addDefault("WalkSpeed", .1); //adds a config argument for walking speed
	
	config.options().copyDefaults(true); //part of saving process
	saveConfig(); //saves
	
	this.getCommand("walk").setExecutor(new CommandWalk());
}

//allows users to access an instance of the main class from anywhere in project
public static Walk getInstance(){
	return plugin;
}

@Override
public void onDisable(){
	
}

}