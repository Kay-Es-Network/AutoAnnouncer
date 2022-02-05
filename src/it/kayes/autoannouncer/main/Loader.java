package it.kayes.autoannouncer.main;

import java.io.File;
import java.io.IOException;

public interface Loader {

    String DIRECTORY = "plugins/AutoAnnouncer";
    File CONFIG = new File("plugins/AutoAnnouncer" + File.separator + "config.yml");

    void load(File file) throws IOException;

}
