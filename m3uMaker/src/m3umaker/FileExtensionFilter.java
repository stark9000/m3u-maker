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
        return accept;
    }

    public void addFilteredExtension(String extension) {
        filteredExtensions.add(extension);
    }
}
