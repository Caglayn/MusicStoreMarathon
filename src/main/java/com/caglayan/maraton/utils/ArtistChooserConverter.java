package com.caglayan.maraton.utils;

import com.caglayan.maraton.model.dto.ArtistViewDto;
import javafx.util.StringConverter;

public class ArtistChooserConverter <T> extends StringConverter<ArtistViewDto> {
    @Override
    public String toString(ArtistViewDto object) {
        if (object == null)
            return null;
        else
            return object.getName().get();
    }

    @Override
    public ArtistViewDto fromString(String string) {
        if (string == null)
            return null;
        else
            return ArtistProvider.getInstance().getArtistByName(string);
    }
}
