/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3umaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author xyBerWise
 */
public class exFiles {

    public String mDIR;

    public List getFiles(String Mdir) {
        List<File> files = null;
        try {
            File dir = new File(Mdir);
            mDIR = dir.getCanonicalPath();
            String[] extensions = new String[]{"mp3", "wma", "flac", "aac", "amr", "m4a", "m4r", "ogg", "wav", "wavepack", "wma", "flac", "aac", "amr", "m4a", "m4r", "ogg", "wav", "wavepack", "avi", "flv", "mp4", "wmv", "3gp", "rmvb", "mkv", "mpg", "vob", "mov"};
            files = (List<File>) FileUtils.listFiles(dir, extensions, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }

    public List getFiles(String Mdir, String[] extensions) {
        List<File> files = null;
        try {
            File dir = new File(Mdir);
            mDIR = dir.getCanonicalPath();
            files = (List<File>) FileUtils.listFiles(dir, extensions, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }

    public void genFile(String M3UfileName, List Files) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(mDIR + "\\" + M3UfileName + ".m3u", true));
            System.out.println("----" + mDIR + M3UfileName);
            for (int i = 0; i < Files.size(); i++) {
                out.write(Files.get(i).toString());
                out.newLine();
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void genFile(String Path, String M3UfileName, List Files) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(Path + "\\" + M3UfileName + ".m3u", true));
            for (int i = 0; i < Files.size(); i++) {
                out.write(Files.get(i).toString());
                out.newLine();
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
