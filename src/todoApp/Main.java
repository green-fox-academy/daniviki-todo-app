package todoApp;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Functions toDo = new Functions();


        if (args.length == 0) {
            toDo.printUsage();
        }else if (args[0].equals("-l")){
            toDo.listTasks();
        }else if (args[0].equals("-a")){
            toDo.addNewTask("Feed the monkey");
            toDo.listTasks();
        } else if (args[0].equals("-r") && args[1].equals(2)){
            toDo.removeTask(args);
            toDo.listTasks();
        }


    }
}
