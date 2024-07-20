import java.util.Scanner;

public class TodolistAppV1 {

    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
      viewShowTodo();
    }

    public static void showTodo(){
        for(int i = 0; i < model.length; i++){
            if (model[i] != null){
             System.out.println(i + 1 + ". " + model[i]);
            }
        }
    }

    public static void testShowTodo(){
        model[0] = "Belajar Java dasar";
        model[1] = "Belajar Java OOP";
        showTodo();
    }


    public static void addTodo(String todo){
        var isFull = true;
        // check if capacity is full?
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                isFull = false;
                break;
            }
        }
        //capacity resize to 2x
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
        for(int i = 0; i < model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodo(){
        for (int i = 0; i < 20; i++) {
            addTodo("Todo ke " + i);
        }
        showTodo();
    }

    public static boolean deleteTodo(Integer number){
            if((number - 1) >= model.length){
                return false;
            } else if (model[number - 1] == null){
                return false;
            }else {
                for(int i = (number - 1); i < model.length; i++){
                    if(i == model.length - 1){
                        model[i] = null;
                    }else {
                        model[i] = model[i + 1];
                    }
                }
                return true;
            }
    }

    public static void testDeleteTodo(){
        model[0] = "todo 1";
        model[1] = "todo 2";
        model[2] = "todo 3";
        var result = deleteTodo(2);
        System.out.println(result);
        showTodo();
    }

    public static String input(String prompt)
    {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public static void testInput(){
        System.out.println("hi " + input("nama"));
    }

    public static void viewShowTodo(){
        while (true){
            System.out.println("======TODOLIST======");
            showTodo();
            System.out.println("======MENU======");
            System.out.println("1. Add Todo");
            System.out.println("2. Delete Todo");
            System.out.println("3. Exit");

            var input = input("your choice");
            if (input.equals("1")){
                viewAddTodo();
            } else if (input.equals("2")) {
                viewDeleteTodo();
            } else if (input.equals("3")) {
                break;
            }else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void testViewShowTodo(){
        addTodo("Belajar Java dasar");
        addTodo("Belajar Java OOP");
        addTodo("Belajar Java Database");
        viewShowTodo();
    }
    public static void viewAddTodo(){
        System.out.println("====== ADD TODOLIST======");
        System.out.println("note: choose 'x' if an canceled ");
        var input = input("todo");
        if (input.equals("x")){
            // cancel
        }else{
            addTodo(input);
            showTodo();
        }
    }

    public static void testViewAddTodo(){
        addTodo("Belajar Java dasar");
        addTodo("Belajar Java OOP");
        viewAddTodo();
    }
    public static void viewDeleteTodo(){
        System.out.println("====== DELETE TODOLIST======");
        showTodo();
        System.out.println("note: choose 'x' if an canceled ");
        var input = input("number");
        if (input.equals("x")){
            //cancel
        }else {
            boolean success = deleteTodo(Integer.valueOf(input));
            if (!success){
                System.out.println("Delete failed for number " + input);
            }
            showTodo();
        }
    }

    public static void testViewDeleteTodo(){
        addTodo("Belajar Java dasar");
        addTodo("Belajar Java OOP");
        addTodo("Belajar Java Database");
        viewDeleteTodo();
    }


}
