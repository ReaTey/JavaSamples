package ThinkingInJava;

import java.io.File;

public class FindFile {

    private static boolean flag = false;

    public FindFile(String path, String filename) {
        func(path, filename);
    }

    private static void func(String path, String find) {
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
