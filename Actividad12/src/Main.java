import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static AddressBook myBook = new AddressBook();

    public static void main(String[] args) {
        System.out.println("Bienvenido a su lista de contactos.");
        do {
            selectOption();
        } while (tryAgain());
    }

    public static void selectOption() {
        boolean repeat = true;
        while (repeat) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Seleccione una opción:");
                System.out.print("1 Cargar Datos\n" +
                        "2 Guardar Datos\n" +
                        "3 Mostrar Contactos\n" +
                        "4 Nuevo Contacto\n" +
                        "5 Eliminar Contacto\n" +
                        "0 Salir\n");
                int answer = sc.nextInt();
                switch (answer) {
                    case 0:
                        System.out.println("Hasta luego!");
                        System.exit(0);
                        break;
                    case 1:
                        myBook.load();
                        repeat = false;
                        break;
                    case 2:
                        myBook.save();
                        repeat = false;
                        break;
                    case 3:
                        list(myBook.getMyMap());
                        repeat = false;
                        break;
                    case 4:
                        getData();
                        repeat = false;
                        break;
                    case 5:
                        getTelephone();
                        repeat = false;
                        break;
                    default:
                        System.out.println("Opción inválida, vuelva a intentarlo.");
                }
            } catch (Exception e) {
                System.out.println("Opción inválida, vuelva a intentarlo.");
            }
        }
    }

    public static void list(HashMap<String, String> map) {
        Iterator<String> iterator = map.keySet().iterator();
        System.out.println("Contactos:\n");
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + "\t|\t" + map.get(key));
        }
    }

    public static void getData(){
        boolean repeat = true;
        while(repeat){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Inserte número de telefono");
                String tel = sc.nextLine();
                System.out.println("Inserte nombre del contacto");
                String name = sc.nextLine();
                create(myBook.getMyMap(), tel, name);
                repeat = false;
            }catch(Exception e){
                System.out.println("Datos incorrectos, vuelva a intentar");
            }
        }
    }

    public static void create(HashMap<String, String> map, String tel, String name){
        if(map.containsKey(tel)){
            System.out.println("Ese número ya ha sido registrado.");
        }else{
            map.put(tel, name);
            System.out.println("Contacto agregado");
        }
    }

    public static void getTelephone(){
        boolean repeat = true;
        while(repeat){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Inserte número de telefono");
                String tel = sc.nextLine();
                delete(myBook.getMyMap(), tel);
                repeat = false;
            }catch(Exception e){
                System.out.println("Datos incorrectos, vuelva a intentar");
            }
        }
    }

    public static void delete(HashMap<String, String> map, String tel){
        if(map.containsKey(tel)){
            map.remove(tel);
            System.out.println("Contacto eliminado");
        }else{
            System.out.println("Contacto no existente");
        }
    }

    public static boolean tryAgain(){
        boolean tryAgain = false;
        boolean repeat = true;
        try{
            while(repeat){
                Scanner sc = new Scanner(System.in);
                System.out.println("Quieres escoger otra opción? (Ss/Nn)");
                char answer = sc.next().charAt(0);
                switch(answer){
                    case 'S':
                    case 's':
                        tryAgain = true;
                        repeat = false;
                        break;
                    case 'N':
                    case 'n':
                        System.out.println("Hasta luego!");
                        repeat = false;
                        break;
                    default:
                        System.out.println("Opción inválida, vuelva a intentarlo.");
                }
            }
        }catch (Exception e){
            System.out.println("Opción inválida, vuelva a intentarlo.");
        }
        return tryAgain;
    }
}