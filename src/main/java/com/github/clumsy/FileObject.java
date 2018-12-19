package com.github.clumsy;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;

@Getter
public class FileObject {
    private String name;
    private InputStream inputStream;
    private String type;
    private Long size;

    public FileObject(String name, InputStream inputStream, String type, Long size) {
        this.name = name;
        this.inputStream = inputStream;
        this.type = type;
        this.size = size;
    }
}