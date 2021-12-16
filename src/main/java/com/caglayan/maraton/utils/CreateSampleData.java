package com.caglayan.maraton.utils;

import com.caglayan.maraton.controller.*;
import com.caglayan.maraton.entities.*;
import com.caglayan.maraton.model.GenreType;

public class CreateSampleData {
    public static void createSample(){
        GenreEntityController genreEntityController = new GenreEntityController();
        genreEntityController.writeAllGenresToDb();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ////////////////////////////////////////////

        ArtistEntity artist1 = new ArtistEntity().builder().artistName("ali").artistLastName("can").description("artist iste").build();
        ArtistEntity artist2 = new ArtistEntity().builder().artistName("veli").artistLastName("can").description("artist iste").build();
        ArtistEntity artist3 = new ArtistEntity().builder().artistName("selami").artistLastName("can").description("artist iste").build();
        ArtistEntity artist4 = new ArtistEntity().builder().artistName("hasan").artistLastName("can").description("artist iste").build();
        ArtistEntity artist5 = new ArtistEntity().builder().artistName("huseyin").artistLastName("can").description("artist iste").build();
        ArtistEntity artist6 = new ArtistEntity().builder().artistName("osman").artistLastName("can").description("artist iste").build();
        ArtistEntity artist7 = new ArtistEntity().builder().artistName("mahmut").artistLastName("can").description("artist iste").build();
        ArtistEntity artist8 = new ArtistEntity().builder().artistName("ayse").artistLastName("can").description("artist iste").build();
        ArtistEntity artist9 = new ArtistEntity().builder().artistName("fatma").artistLastName("can").description("artist iste").build();
        ArtistEntity artist10 = new ArtistEntity().builder().artistName("hayriye").artistLastName("can").description("artist iste").build();

        ArtistEntityController artistEntityController = new ArtistEntityController();
        artistEntityController.create(artist1);
        artistEntityController.create(artist2);
        artistEntityController.create(artist3);
        artistEntityController.create(artist4);
        artistEntityController.create(artist5);
        artistEntityController.create(artist6);
        artistEntityController.create(artist7);
        artistEntityController.create(artist8);
        artistEntityController.create(artist9);
        artistEntityController.create(artist10);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ////////////////////////////////////////////////////////////////

        CDEntity cdEntity1 = new CDEntity().builder().albumName("album 1").price(10).canSold(true).build();
        CDEntity cdEntity2 = new CDEntity().builder().albumName("album 2").price(15).canSold(true).build();
        CDEntity cdEntity3 = new CDEntity().builder().albumName("album 3").price(20).canSold(true).build();
        CDEntity cdEntity4 = new CDEntity().builder().albumName("album 4").price(25).canSold(true).build();
        CDEntity cdEntity5 = new CDEntity().builder().albumName("album 5").price(30).canSold(false).build();

        /////////////////////////////////////////////////////////////////

        DVDEntity dvdEntity1 = new DVDEntity().builder().albumName("album 6").price(35).canSold(true).build();
        DVDEntity dvdEntity2 = new DVDEntity().builder().albumName("album 7").price(36).canSold(true).build();
        DVDEntity dvdEntity3 = new DVDEntity().builder().albumName("album 8").price(37).canSold(true).build();
        DVDEntity dvdEntity4 = new DVDEntity().builder().albumName("album 9").price(38).canSold(true).build();
        DVDEntity dvdEntity5 = new DVDEntity().builder().albumName("album 10").price(39).canSold(false).build();

        //////////////////////////////////////////////////////////////////

        VinylEntity vinylEntity1 = new VinylEntity().builder().albumName("album 11").price(40).canSold(true).build();
        VinylEntity vinylEntity2 = new VinylEntity().builder().albumName("album 12").price(41).canSold(true).build();
        VinylEntity vinylEntity3 = new VinylEntity().builder().albumName("album 13").price(42).canSold(true).build();
        VinylEntity vinylEntity4 = new VinylEntity().builder().albumName("album 14").price(43).canSold(true).build();
        VinylEntity vinylEntity5 = new VinylEntity().builder().albumName("album 15").price(44).canSold(false).build();

        ////////////////////////////////////////////////////////////////////

        artist1.addCdAlbum(cdEntity1);
        cdEntity1.setCdArtist(artist1);

        artist1.addDvdAlbum(dvdEntity1);
        dvdEntity1.setDvdArtist(artist1);

        artist1.addVinylAlbum(vinylEntity1);
        vinylEntity1.setVinylArtist(artist1);

        artist2.addCdAlbum(cdEntity2);
        cdEntity2.setCdArtist(artist2);

        artist3.addCdAlbum(cdEntity3);
        cdEntity3.setCdArtist(artist3);

        artist4.addCdAlbum(cdEntity4);
        cdEntity4.setCdArtist(artist4);

        artist5.addCdAlbum(cdEntity5);
        cdEntity5.setCdArtist(artist5);

        artist6.addDvdAlbum(dvdEntity2);
        dvdEntity2.setDvdArtist(artist6);

        artist7.addDvdAlbum(dvdEntity3);
        dvdEntity3.setDvdArtist(artist7);

        artist8.addDvdAlbum(dvdEntity4);
        dvdEntity4.setDvdArtist(artist8);

        artist9.addDvdAlbum(dvdEntity5);
        dvdEntity5.setDvdArtist(artist9);

        artist10.addVinylAlbum(vinylEntity2);
        vinylEntity2.setVinylArtist(artist10);

        artist4.addVinylAlbum(vinylEntity3);
        vinylEntity3.setVinylArtist(artist4);

        artist5.addVinylAlbum(vinylEntity4);
        vinylEntity4.setVinylArtist(artist5);

        artist6.addVinylAlbum(vinylEntity5);
        vinylEntity5.setVinylArtist(artist6);

        ///////////////////////////////////////////////////////////////

        cdEntity1.addGenre(new GenreEntity(GenreType.Classic));
        cdEntity2.addGenre(new GenreEntity(GenreType.Jazz));
        cdEntity3.addGenre(new GenreEntity(GenreType.Pop));
        cdEntity4.addGenre(new GenreEntity(GenreType.Hiphop));
        cdEntity5.addGenre(new GenreEntity(GenreType.Classic));

        CDEntityController cdEntityController = new CDEntityController();
        cdEntityController.create(cdEntity1);
        cdEntityController.create(cdEntity2);
        cdEntityController.create(cdEntity3);
        cdEntityController.create(cdEntity4);
        cdEntityController.create(cdEntity5);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dvdEntity1.addGenre(new GenreEntity(GenreType.Jazz));
        dvdEntity2.addGenre(new GenreEntity(GenreType.Pop));
        dvdEntity3.addGenre(new GenreEntity(GenreType.Hiphop));
        dvdEntity4.addGenre(new GenreEntity(GenreType.Jazz));
        dvdEntity5.addGenre(new GenreEntity(GenreType.Jazz));

        DvdEntityController dvdEntityController = new DvdEntityController();
        dvdEntityController.create(dvdEntity1);
        dvdEntityController.create(dvdEntity2);
        dvdEntityController.create(dvdEntity3);
        dvdEntityController.create(dvdEntity4);
        dvdEntityController.create(dvdEntity5);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        vinylEntity1.addGenre(new GenreEntity(GenreType.Classic));
        vinylEntity2.addGenre(new GenreEntity(GenreType.Classic));
        vinylEntity3.addGenre(new GenreEntity(GenreType.Classic));
        vinylEntity4.addGenre(new GenreEntity(GenreType.Jazz));
        vinylEntity5.addGenre(new GenreEntity(GenreType.Jazz));

        VinylEntityController vinylEntityController = new VinylEntityController();
        vinylEntityController.create(vinylEntity1);
        vinylEntityController.create(vinylEntity2);
        vinylEntityController.create(vinylEntity3);
        vinylEntityController.create(vinylEntity4);
        vinylEntityController.create(vinylEntity5);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //////////////////////////////////////////////////////////////////

        UserEntity userEntity1 = new UserEntity().builder().userName("admin").password("qwerty").build();
        UserEntity userEntity2 = new UserEntity().builder().userName("xxx1").userLastname("yyy1").eMail("x1@x1.com").build();
        UserEntity userEntity3 = new UserEntity().builder().userName("xxx2").userLastname("yyy2").eMail("x2@x2.com").build();
        UserEntity userEntity4 = new UserEntity().builder().userName("xxx3").userLastname("yyy3").eMail("x3@x3.com").build();
        UserEntity userEntity5 = new UserEntity().builder().userName("xxx4").userLastname("yyy4").eMail("x4@x4.com").build();

        UserEntityController userEntityController = new UserEntityController();
        userEntityController.create(userEntity1);
        userEntityController.create(userEntity2);
        userEntityController.create(userEntity3);
        userEntityController.create(userEntity4);
        userEntityController.create(userEntity5);

    }
}
