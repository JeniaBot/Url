import java.io.*;
import java.util.*;

public class Main {
    static List<String>url_list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        Url_txt("urls.txt");
         Set<String> set = new HashSet<>(url_list);
         Map<String, Integer> map = new LinkedHashMap<>();
        for (String r : set) {
            map.put(r,Collections.frequency(url_list, r));
        }

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10)
                .forEach(System.out::println);

    }

    public static void Url_txt(String url) throws IOException {
            File file = new File(url);
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
}
