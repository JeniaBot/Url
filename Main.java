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

        List<String> url_list_sort = new ArrayList<String>();
        Set<String> set = new HashSet<String>(url_list);
        for (String r : set) {
            int t =Collections.frequency(url_list, r);
            url_list_sort.add(t+":"+r);

        }

        Collections.sort(url_list_sort);

        for (String f:url_list_sort) {
            System.out.println(f);
        }
    }
}
