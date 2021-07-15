import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<String>url_list = new ArrayList<String>();
        try {
            File file = new File("urls.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String str="";
            while (line != null) {
                int indexM = line.indexOf("/");
                if(indexM == - 1) {
                    str=line;
                } else {
                    str =line.substring(0,line.indexOf("/"));
                }
                url_list.add(str);
                line = reader.readLine();
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




        Set<String> set = new HashSet<String>(url_list);
        HashMap<String, Integer> map = new HashMap<>();
        for (String r : set) {
            map.put(r,Collections.frequency(url_list, r));

        }

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

    }
}
