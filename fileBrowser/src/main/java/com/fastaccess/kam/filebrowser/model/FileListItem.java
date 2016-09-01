/*
 * Copyright (C) 2016 Angad Singh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fastaccess.kam.filebrowser.model;

/**
 * <p> Created by Angad Singh on 09-07-2016. </p>
 */

public class FileListItem implements Comparable<FileListItem> {
    private String filename, location;
    private boolean directory, marked;
    private long time;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    @Override public int compareTo(FileListItem fileListItem) {
        if (fileListItem.isDirectory() && isDirectory()) {
            return filename.toLowerCase().compareTo(fileListItem.getFilename().toLowerCase());
        } else if (!fileListItem.isDirectory() && !isDirectory()) {
            return filename.toLowerCase().compareTo(fileListItem.getFilename().toLowerCase());
        } else if (fileListItem.isDirectory() && !isDirectory()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override public String toString() {
        return "FileListItem{" +
                "filename='" + filename + '\'' +
                ", location='" + location + '\'' +
                ", directory=" + directory +
                ", marked=" + marked +
                ", time=" + time +
                '}';
    }
}