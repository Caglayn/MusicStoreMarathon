package com.caglayan.maraton.utils;

import com.caglayan.maraton.model.GenreType;
import javafx.util.StringConverter;

public class GenreChooserConverter <T> extends StringConverter <GenreType> {
    @Override
    public String toString(GenreType object) {
        if (object == null)
            return null;
        else
            return object.getName();
    }

    @Override
    public GenreType fromString(String string) {
        if (string == null)
            return null;
        else
            return GenreType.getByName(string);
    }
}
