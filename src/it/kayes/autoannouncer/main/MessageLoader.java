package it.kayes.autoannouncer.main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageLoader implements Loader {

    protected static final ArrayList<String[]> messages = new ArrayList<>();
    protected int loop;

    public MessageLoader() {
        new File(DIRECTORY).mkdir();
        try {
            this.load(CONFIG);
        } catch (IOException ignored) {}
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    @Override
    public void load(File file) throws IOException {
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (file.createNewFile()) {
            cfg.set("loop", 900);
            cfg.set("messages.1",new String[]{"&cProva","&bProva"});
            cfg.save(file);
        }


        this.loop = Math.abs(cfg.getInt("loop"));
        if (loop==0) loop = 900;

        if (cfg.getString("messages")!=null)
            for (String index : Objects.requireNonNull(cfg.getConfigurationSection("messages")).getKeys(false)) {
                List<String> message = cfg.getStringList("messages."+index);
                messages.add(message.toArray(new String[message.size()]));
            }


    }


}
