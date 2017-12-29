package me.proft.fragmentstst;


import java.util.ArrayList;
import java.util.List;

public class Chapter {
    public static List<Chapter> items = new ArrayList<>();
    private String title;
    private String progress;
    private int icon;
    private List<Module> modules = new ArrayList<>();

    public Chapter(String title, String progress, int icon, List<Module> modules) {
        this.title = title;
        this.progress = progress;
        this.icon = icon;
        this.modules = modules;
    }

    public static void generate() {
        items.add(new Chapter("Math Training Level 2", "0", R.drawable.training,
                generateTrainings()));
        items.add(new Chapter("Search Topic", "10", R.drawable.search,
                generateSearch()));
        items.add(new Chapter("arithmetic", "15", R.drawable.arithmatics,
                generateArithmatics()));
        items.add(new Chapter("Algebra", "30", R.drawable.algebra,
                generateAlgebra()));
        items.add(new Chapter("Plain Geometry", "25", R.drawable.geometry,
                generateGeometry()));
    }

    private static List<Module> generateTrainings() {
        List<Module> items = new ArrayList<>();
        items.add(new Module("Courses", "0", R.drawable.training));
        items.add(new Module("Test Sets", "10", R.drawable.search));
        return items;
    }

    private static List<Module> generateSearch() {
        List<Module> items = new ArrayList<>();
        items.add(new Module("On Topic", "0", R.drawable.training));
        items.add(new Module("Adv Level", "10", R.drawable.search));
        return items;
    }

    private static List<Module> generateArithmatics() {
        List<Module> items = new ArrayList<>();
        items.add(new Module("Addition", "0", R.drawable.add));
        items.add(new Module("Subtraction", "10", R.drawable.subt));
        items.add(new Module("Multiplication", "15", R.drawable.mul));
        items.add(new Module("Division", "30", R.drawable.div));
        return items;
    }

    private static List<Module> generateAlgebra() {
        List<Module> items = new ArrayList<>();
        items.add(new Module("Square Root", "0", R.drawable.algebra));
        items.add(new Module("Exponential", "10", R.drawable.search));
        return items;
    }

    private static List<Module> generateGeometry() {
        List<Module> items = new ArrayList<>();
        items.add(new Module("Triangle", "0", R.drawable.training));
        items.add(new Module("Cuboid", "10", R.drawable.search));
        items.add(new Module("Polygon", "15", R.drawable.arithmatics));

        return items;
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

    public List<Module> getModules() {
        return modules;
    }

    public int getIcon() {
        return icon;
    }
}
