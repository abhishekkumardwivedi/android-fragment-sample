package me.proft.fragmentstst;

public class Module {
    private String title;
    private String progress;
    private int icon;

    public Module(String title, String progress, int icon) {
        this.title = title;
        this.progress = progress;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProgress() {
        return progress;
    }

    public int getIcon() {
        return icon;
    }
}
