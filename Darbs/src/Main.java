/**
 * Created by reatey on 25.04.17.
 */
import java.io.File;

public class Main {

    static boolean flag = false;

    public static void main(String[] args) {
        //func("/home/reatey/Downloads/ns-allinone-2.35/","install");
    }

    static void func(String path, String find) {
        File f = new File(path);
        String[] list = f.list();     //list of files
        if (list == null) {
            System.out.println("Empty");
            return;
        }
        for (String file : list) {      //searching for a match
            if (find.equals(file)) {
                flag = true;
                System.out.println(path + file + " || Found one");  //if found then exit
                return;
            }
            if (!path.endsWith("/")) {
                path += "/";
            }
            File tempfile = new File(path, file);
            //System.out.println(path + file);
            if (!file.equals(".") && !file.equals("..")) {        //!!!
                if (tempfile.isDirectory()) {      //if its folder
                    //path += file;
                    func(path + file, find);               //start recursive call
                    if (flag) return;
                }
            }
        }
    }

}

