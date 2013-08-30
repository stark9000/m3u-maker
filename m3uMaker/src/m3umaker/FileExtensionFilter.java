/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3umaker;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xyBerWise
 */
public class FileExtensionFilter implements FilenameFilter {

    private Set<String> filteredExtensions;

    public FileExtensionFilter() {
        filteredExtensions = new HashSet<String>();

    }

    @Override
    public boolean accept(File dir, String name) {
        boolean accept = true;
        for (String filteredExtension : filteredExtensions) {
            accept = accept && !name.endsWith(filteredExtension);
        }
        return (name.endsWith(".mp3") || name.endsWith(".wma") || name.endsWith(".flac") || name.endsWith(".m4r")|| name.endsWith(".wav") || name.endsWith(".wavepack") || name.endsWith(".wma") || name.endsWith(".flac") || name.endsWith(".aac") || name.endsWith(".amr") || name.endsWith(".m4a") || name.endsWith(".ogg") || name.endsWith(".wav") || name.endsWith(".wavepack") || name.endsWith(".avi") || name.endsWith(".flv") || name.endsWith(".mp4") || name.endsWith(".wmv") || name.endsWith(".3gp") || name.endsWith(".rmvb") || name.endsWith(".mkv") || name.endsWith(".mpg") || name.endsWith(".vob") || name.endsWith(".mov"));
    }

    public void addFilteredExtension(String extension) {
        filteredExtensions.add(extension);
    }

}
