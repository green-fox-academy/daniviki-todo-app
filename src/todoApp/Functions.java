package todoApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Functions {
    private Path filePath = Paths.get("todoApp/text.txt");
    private List<String> lines = new ArrayList<>();

    public void printUsage(){
        System.out.println("Command Line Todo application\n" +
                "=============================\n" +
                "\n" +
                "Command line arguments:\n" +
                " -l   Lists all the tasks\n" +
                " -a   Adds a new task\n" +
                " -r   Removes an task\n" +
                " -c   Completes an task");
    }

    public void listTasks() {
        try {
            lines = Files.readAllLines(filePath);
            if (lines.size() > 0) {
                for( String line : lines ) {
                    System.out.println(line);
                }
            } else {
                System.out.println("No todos for today! :)");
            }
        } catch (IOException ex) {
            System.out.println("File doesnt exists.");
        }
    }

    public void addNewTask(String string) {
        
        try {
            lines = Files.readAllLines(filePath);
            lines.add(string);
            Files.write(Paths.get("todoApp/text.txt"),lines );
        }catch (IOException ex) {
            System.out.println("Unable to add: no task provided");
        }
    }

    public void removeTask(String [] args) {
        int number = Integer.parseInt(args[1]);
        try {
            lines = Files.readAllLines(filePath);
            lines.remove(number - 1);
            Files.write(Paths.get("todoApp/text.txt"),lines );
        }catch (IOException ex) {
            System.out.println("Unable to add: no task provided");
        }

    }

}
