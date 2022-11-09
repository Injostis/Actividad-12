import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class AddressBook {
    private HashMap<String, String> myMap = new HashMap<String, String>();

    public AddressBook() {
    }

    public HashMap<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(HashMap<String, String> myMap) {
        this.myMap = myMap;
    }

    public void load(){
        String inputFileName = "C:\\Users\\rod06\\OneDrive\\Escritorio\\Computación en Java\\input.txt";
        String a[];
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(inputFileName));
            String line;
            while((line = bufferedReader.readLine()) != null){
                a = line.split(", ");
                this.myMap.put(a[0], a[1]);
            }
        }catch(IOException e){
            System.out.println("IOException catched while reading: " + e.getMessage());
        }finally{
            try{
                if(bufferedReader != null){
                    bufferedReader.close();
                    System.out.println("Contactos cargados");
                }
            }catch(IOException e){
                System.out.println("IOException catched while reading: " + e.getMessage());
            }
        }
    }

    public void save(){
        Iterator<String> iterator = this.myMap.keySet().iterator();
        String inputFileName = "C:\\Users\\rod06\\OneDrive\\Escritorio\\Computación en Java\\input.txt";
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter = new BufferedWriter(new FileWriter(inputFileName));
            while(iterator.hasNext()){
                String key = iterator.next();
                bufferedWriter.write(key + ", " + this.myMap.get(key) + "\n");
            }
        }catch(IOException e){
            System.out.println("IOException catched while reading: " + e.getMessage());
        }finally{
            try{
                if(bufferedWriter != null){
                    bufferedWriter.close();
                    System.out.println("Cambios guardados");
                }
            }catch (IOException e){
                System.out.println("IOException catched while reading: " + e.getMessage());
            }
        }
    }
}