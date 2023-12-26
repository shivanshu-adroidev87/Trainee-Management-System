package com.nucleus.project.bean;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomProperty extends PropertyEditorSupport{

    //Setting local Date
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(text,formatter);
            setValue(date);
    }
}
