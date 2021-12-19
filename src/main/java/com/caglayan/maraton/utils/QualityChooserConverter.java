package com.caglayan.maraton.utils;

import com.caglayan.maraton.model.QualityType;
import javafx.util.StringConverter;

public class QualityChooserConverter <T> extends StringConverter <QualityType> {
    @Override
    public String toString(QualityType object) {
        if (object == null)
            return null;
        else
            return object.getQuality();
    }

    @Override
    public QualityType fromString(String string) {
        if (string == null)
            return null;
        else
            return QualityType.getByName(string);
    }
}
