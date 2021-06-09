import java.util.Scanner;

public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        testAddTodoList();
//        testRemoveTodoList();
//        testInput();
//        testViewShowTodolist();
//        testViewAddTodoList();
//          testViewRemoveTodolist();
        viewShowTodoList();
    }


    public static void showTodoList(){

        System.out.println("--------- Show To Do List Nandosan --------------");
        System.out.println("\n");

        for(var i = 0 ; i < model.length ; i++){
            var todo = model[i];
            var no = i + 1;

            if( todo != null ){
                System.out.println(no+". "+todo);
            }
        }

        System.out.println("\n");
        System.out.println("-------------------------------------------------");


    }

    public static void testShowTodoList(){
        model[0] = "Belajar java dasar";
        model[1] = "Belajar java advance";
        showTodoList();
    }

    public static String input(String input){
        System.out.println(input + " : " );
        String data = scanner.nextLine();
        return data;

    }

    public static void testInput(){
        var name = input("Nama ");
        System.out.println("Hi "+name);

        var channel = input("Channel ");
        System.out.println("Nama channel "+channel);
    }

    public static void addTodoList(String todo){

        var isFull = true;
        for(var i = 0; i < model.length ; i++){
            if(model[i] == null){
                isFull = false;
                break;
            }
        }

        if(isFull){
            var temp = model;
            model = new String[temp.length * 20];

            for(var i = 0 ; i< temp.length;i++){
                model[i] = temp[i];
            }
        }



        // tambahkan datanya jika array null
        for(var i = 0;i < model.length ; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList(){
        for(var i = 0; i < 25 ; i++){
            addTodoList("Contoh model ke - "+i);
        }

        showTodoList();
    }

    public static boolean removeTodoList(Integer number){

        if((number - 1) > model.length){
            return false;
        }else if(model[number - 1] == null){
            return false;
        }else {
            for(var i = number - 1;i < model.length;i++){
                if(i == (model.length) -1){
                    model[i] = null;
                }else{
                    model[i] = model[i+1];
                }
            }


            return true;
        }

    }

    public static void testRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        var result = removeTodoList(30);
        System.out.println(result);

        result = removeTodoList(3);

        showTodoList();

    }

    /**
     *  menampilkan view todo list
     */
    public static void viewShowTodoList(){
        while(true){
            showTodoList();

            System.out.println("Menu: ");
            System.out.println("1.Tambah ");
            System.out.println("2.Hapus ");
            System.out.println("x.Keluar ");

            var input = input("Pilih");

            if(input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Inputan tidak di kenali");
            }
        }
    }

    public static void testViewShowTodolist(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        addTodoList("Enam");

        viewShowTodoList();
    }

    /**
     *  menampilkan view add todo list
     */
    public static void viewAddTodoList(){
        System.out.println("Menambah To Do List");
        var todo = input("Todo (Jika input x maka batal");

        if(todo.equals("x")){

        }else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();
        showTodoList();
    }

    /**
     *  menampilkan view remove todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("Menghapus To Do List ");

        var number = input("Nomor yang di hapus (x Jika batal) ");

        if(number.equals("x")){

        }else{
            boolean success = removeTodoList(Integer.valueOf(number));

            if(!success){
                System.out.println("Gagal menghapus to do list "+number);
            }
        }

    }

    public static void testViewRemoveTodolist(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
