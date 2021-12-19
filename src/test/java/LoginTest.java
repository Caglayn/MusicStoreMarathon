import com.caglayan.maraton.controller.*;
import com.caglayan.maraton.entities.*;
import com.caglayan.maraton.model.GenreType;
import com.caglayan.maraton.model.QualityType;
import com.caglayan.maraton.utils.ConsoleReader;

import java.util.ArrayList;

public class LoginTest {
//    public static void main(String[] args) {
//        String userName;
//        String password;
//        System.out.println("Kullanici adi girin : ");
//        userName = ConsoleReader.getInstance().readString();
//        System.out.println("Sifre girin : ");
//        password = ConsoleReader.getInstance().readString();
//
//        UserEntityController userEntityController = new UserEntityController();
//        UserEntity user =  userEntityController.findByNameAndPassword(userName, password);
//
//        if (user == null){
//            System.out.println("Hatali giris yaptiniz..");
//        }
//        else if (user.getIsAdmin()){
//            System.out.println("Admin girisi basarili");
//            adminMenuLoop();
//        }
//        else {
//            System.out.println("Kullanici girisi basarili");
//            userMenuLoop();
//        }
//    }
//
//    public static void userMenuLoop(){
//        do {
//            showUserMenu();
//            int userSelection = ConsoleReader.getInstance().readInt();
//            if (userSelection == 0){
//                System.out.println("Cikis yapiliyor tesekkurler..");
//                break;
//            }
//            goUserSelection(userSelection);
//        }while (true);
//    }
//
//    public static void showUserMenu(){
//        System.out.println("1 - Album detaylari goruntule");
//        System.out.println("2 - Siparis ver");
//        System.out.println("3 - Indirimdeki albumleri gor");
//        System.out.println("4 - Turune gore albumler");
//        System.out.println("5 - Sanatciya gore albumler");
//        System.out.println("0 - Cikis yap");
//    }
//
//    private static void goUserSelection(int userSelection) {
//        switch (userSelection){
//            case 1:
//                showAlbumDetails();
//                break;
//            case 2:
//                break;
//            case 3:
//                showDiscountedProducts();
//                break;
////            case 4:
////                break;
//            default:
//                System.out.println("Hatali giris yaptiniz tekrar deneyin.");
//                break;
//        }
//    }
//
//    private static void showDiscountedProducts() {
//        CDEntityController cdEntityController = new CDEntityController();
//        ArrayList<CDEntity> cdAlbums = cdEntityController.getDiscountedAlbums();
//        DvdEntityController dvdEntityController = new DvdEntityController();
//        ArrayList<DVDEntity> dvdAlbums = dvdEntityController.getDiscountedAlbums();
//        VinylEntityController vinylEntityController = new VinylEntityController();
//        ArrayList<VinylEntity> vinylAlbums = vinylEntityController.getDiscountedAlbums();
//
//        cdAlbums.forEach(i-> System.out.println(i));
//        dvdAlbums.forEach(i-> System.out.println(i));
//        vinylAlbums.forEach(i -> System.out.println(i));
//    }
//
//    private static void showAlbumDetails() {
//        System.out.println("1 - CD albumler\n2 - DVD albumler\n3 - Vinyl albumler");
//        switch (ConsoleReader.getInstance().readInt()){
//            case 1:
//                showCdDetails();
//                break;
//            case 2:
//                showDvdDetails();
//                break;
//            case 3:
//                showVinylDetails();
//                break;
//            default:
//                System.out.println("Hatali giris yaptiniz.");
//                break;
//        }
//    }
//
//    private static void showVinylDetails() {
//        VinylEntityController vinylEntityController = new VinylEntityController();
//        ArrayList<VinylEntity> vinylAlbums = vinylEntityController.list();
//        vinylAlbums.forEach(i-> System.out.println(i));
//    }
//
//    private static void showDvdDetails() {
//        DvdEntityController dvdEntityController = new DvdEntityController();
//        ArrayList<DVDEntity> dvdAlbums = dvdEntityController.list();
//        dvdAlbums.forEach(i-> System.out.println(i));
//    }
//
//    private static void showCdDetails() {
//        CDEntityController cdEntityController = new CDEntityController();
//        ArrayList<CDEntity> cdAlbums = cdEntityController.list();
//        cdAlbums.forEach(i-> System.out.println(i));
//    }
//
//    public static void adminMenuLoop(){
//        do {
//            showAdminMenu();
//            int userSelection = ConsoleReader.getInstance().readInt();
//            if (userSelection == 0){
//                System.out.println("Cikis yapiliyor tesekkurler..");
//                break;
//            }
//            goAdminSelection(userSelection);
//        }while (true);
//    }
//
//    public static void showAdminMenu(){
//        System.out.println("1 - CD Albumleri duzenle");
//        System.out.println("2 - DVD Albumleri duzenle");
//        System.out.println("3 - Vinyl Albumleri duzenle");
//        System.out.println("4 - Siparisleri goruntule");
//        System.out.println("0 - Cikis yap");
//    }
//
//    private static void goAdminSelection(int userSelection) {
//        switch (userSelection){
//            case 1:
//                cdAlbumsOperations();
//                break;
//            case 2:
//                dvdAlbumsOperations();
//                break;
//            case 3:
//                vinylAlbumsOperations();
//                break;
//            case 4:
//                break;
//            default:
//                System.out.println("Hatali giris yaptiniz tekrar deneyin.");
//                break;
//        }
//    }
//
//    private static void vinylAlbumsOperations() {
//        VinylEntityController vinylEntityController = new VinylEntityController();
//        ArrayList<VinylEntity> vinylEntities = vinylEntityController.list();
//        vinylEntities.stream().forEach(i -> System.out.println(i));
//
//        System.out.println("Duzenleme yapmak istediginiz Album id sini girin, yeni kayit olusturmak icin 0 girin");
//        int userInputId = ConsoleReader.getInstance().readInt();
//
//        if (userInputId == 0){
//            createNewVinylAlbum();
//        }
//        else if (userInputId > 0){
//            VinylEntity vinylAlbum = vinylEntities.stream().filter(i -> i.getVinylId() == userInputId).toList().get(0);
//            if (vinylAlbum != null){
//                System.out.println("Guncellemek icin 1 silmek icin 0 girin : ");
//                if(ConsoleReader.getInstance().readInt()==0){
//                    vinylEntityController.delete(vinylAlbum);
//                    System.out.println("Silme basarili .....");
//                }
//                else{
//                    editVinylAlbum(vinylAlbum);
//                }
//            }
//            else {
//                System.out.println("Hatali giris yaptiniz.");
//            }
//        }
//    }
//
//    private static void editVinylAlbum(VinylEntity vinylAlbum) {
//        System.out.println("Album adini girin : ");
//        vinylAlbum.setAlbumName(ConsoleReader.getInstance().readString());
//        System.out.println("Fiyat girin :");
//        vinylAlbum.setPrice(ConsoleReader.getInstance().readDouble());
//        System.out.println("Satilmaya uygunsa 1 degilse 0 girin");
//        if (ConsoleReader.getInstance().readInt()==0){
//            vinylAlbum.setCanSold(false);
//        }
//        else {
//            vinylAlbum.setCanSold(true);
//        }
//        System.out.println("Indirim varsa oran girin yoksa 0 girin : ");
//        vinylAlbum.setDiscountRate(ConsoleReader.getInstance().readDouble());
//
//        GenreType.getAllGenres().forEach(i -> System.out.println(i.getGenreId() + " - " + i.getGenreName()));
//        System.out.println("Albumun turunu girin : ");
//        vinylAlbum.addGenre(new GenreEntity(GenreType.getById(ConsoleReader.getInstance().readInt())));
//
//        System.out.println("Artist adi girin : ");
//        String userInputName = ConsoleReader.getInstance().readString();
//        ArtistEntityController artistEntityController = new ArtistEntityController();
//        ArrayList<ArtistEntity> artists = artistEntityController.findByName(userInputName);
//        artists.forEach(i -> System.out.println(i));
//        System.out.println("Secmek istediginiz artist id sini girin : ");
//        int userInputArtistId = ConsoleReader.getInstance().readInt();
//        ArtistEntity artist = artists.stream().filter(i -> i.getArtistId() == userInputArtistId).toList().get(0);
//        vinylAlbum.setVinylArtist(artist);
//
//        VinylEntityController vinylEntityController = new VinylEntityController();
//        vinylEntityController.update(vinylAlbum);
//        System.out.println("Guncelleme basarili...");
//    }
//
//    private static void createNewVinylAlbum() {
//        VinylEntity newVinylEntity = new VinylEntity();
//        System.out.println("Album adini girin : ");
//        newVinylEntity.setAlbumName(ConsoleReader.getInstance().readString());
//        System.out.println("Fiyat girin :");
//        newVinylEntity.setPrice(ConsoleReader.getInstance().readDouble());
//        System.out.println("Satilmaya uygunsa 1 degilse 0 girin");
//        if (ConsoleReader.getInstance().readInt()==0){
//            newVinylEntity.setCanSold(false);
//        }
//        else {
//            newVinylEntity.setCanSold(true);
//        }
//        System.out.println("Indirim varsa oran girin yoksa 0 girin : ");
//        newVinylEntity.setDiscountRate(ConsoleReader.getInstance().readDouble());
//
//        GenreType.getAllGenres().forEach(i -> System.out.println(i.getGenreId() + " - " + i.getGenreName()));
//        System.out.println("Albumun turunu girin : ");
//        newVinylEntity.addGenre(new GenreEntity(GenreType.getById(ConsoleReader.getInstance().readInt())));
//
//        System.out.println("Plak capini girin : ");
//        newVinylEntity.setDiameter(ConsoleReader.getInstance().readInt());
//
//        System.out.println("Plak calma hizi girin : ");
//        newVinylEntity.setSpeed(ConsoleReader.getInstance().readDouble());
//
//        System.out.println("Artist adi girin : ");
//        String userInputName = ConsoleReader.getInstance().readString();
//        ArtistEntityController artistEntityController = new ArtistEntityController();
//        ArrayList<ArtistEntity> artists = artistEntityController.findByName(userInputName);
//        artists.forEach(i -> System.out.println(i));
//        System.out.println("Secmek istediginiz artist id sini girin : ");
//        int userInputArtistId = ConsoleReader.getInstance().readInt();
//        ArtistEntity artist = artists.stream().filter(i -> i.getArtistId() == userInputArtistId).toList().get(0);
//        newVinylEntity.setVinylArtist(artist);
//
//        VinylEntityController vinylEntityController = new VinylEntityController();
//        vinylEntityController.create(newVinylEntity);
//        System.out.println("Ekleme basarili....");
//    }
//
//    private static void dvdAlbumsOperations() {
//        DvdEntityController dvdEntityController = new DvdEntityController();
//        ArrayList<DVDEntity> dvdEntities = dvdEntityController.list();
//        dvdEntities.stream().forEach(i -> System.out.println(i));
//
//        System.out.println("Duzenleme yapmak istediginiz Album id sini girin, yeni kayit olusturmak icin 0 girin");
//        int userInputId = ConsoleReader.getInstance().readInt();
//
//        if (userInputId == 0){
//            createNewDvdAlbum();
//        }
//        else if (userInputId > 0){
//            DVDEntity dvdAlbum = dvdEntities.stream().filter(i -> i.getDvdId() == userInputId).toList().get(0);
//            if (dvdAlbum != null){
//                System.out.println("Guncellemek icin 1 silmek icin 0 girin : ");
//                if(ConsoleReader.getInstance().readInt()==0){
//                    dvdEntityController.delete(dvdAlbum);
//                    System.out.println("Silme basarili .....");
//                }
//                else{
//                    editDvdAlbum(dvdAlbum);
//                }
//            }
//            else {
//                System.out.println("Hatali giris yaptiniz.");
//            }
//        }
//    }
//
//    private static void editDvdAlbum(DVDEntity dvdAlbum) {
//        System.out.println("Album adini girin : ");
//        dvdAlbum.setAlbumName(ConsoleReader.getInstance().readString());
//        System.out.println("Fiyat girin :");
//        dvdAlbum.setPrice(ConsoleReader.getInstance().readDouble());
//        System.out.println("Satilmaya uygunsa 1 degilse 0 girin");
//        if (ConsoleReader.getInstance().readInt()==0){
//            dvdAlbum.setCanSold(false);
//        }
//        else {
//            dvdAlbum.setCanSold(true);
//        }
//        System.out.println("Indirim varsa oran girin yoksa 0 girin : ");
//        dvdAlbum.setDiscountRate(ConsoleReader.getInstance().readDouble());
//
//        GenreType.getAllGenres().forEach(i -> System.out.println(i.getGenreId() + " - " + i.getGenreName()));
//        System.out.println("Albumun turunu girin : ");
//        dvdAlbum.addGenre(new GenreEntity(GenreType.getById(ConsoleReader.getInstance().readInt())));
//
//        QualityType.getAllQualities().forEach(i-> System.out.println(i.getId() + " - " + i.getQuality()));
//        System.out.println("Albumun cozunurlugunu girin : ");
//        dvdAlbum.setQuality(QualityType.getById(ConsoleReader.getInstance().readInt()));
//
//        System.out.println("Artist adi girin : ");
//        String userInputName = ConsoleReader.getInstance().readString();
//        ArtistEntityController artistEntityController = new ArtistEntityController();
//        ArrayList<ArtistEntity> artists = artistEntityController.findByName(userInputName);
//        artists.forEach(i -> System.out.println(i));
//        System.out.println("Secmek istediginiz artist id sini girin : ");
//        int userInputArtistId = ConsoleReader.getInstance().readInt();
//        ArtistEntity artist = artists.stream().filter(i -> i.getArtistId() == userInputArtistId).toList().get(0);
//        dvdAlbum.setDvdArtist(artist);
//
//        DvdEntityController dvdEntityController = new DvdEntityController();
//        dvdEntityController.update(dvdAlbum);
//        System.out.println("Guncelleme basarili...");
//    }
//
//    private static void createNewDvdAlbum() {
//        DVDEntity newDvdEntity = new DVDEntity();
//        System.out.println("Album adini girin : ");
//        newDvdEntity.setAlbumName(ConsoleReader.getInstance().readString());
//        System.out.println("Fiyat girin :");
//        newDvdEntity.setPrice(ConsoleReader.getInstance().readDouble());
//        System.out.println("Satilmaya uygunsa 1 degilse 0 girin");
//        if (ConsoleReader.getInstance().readInt()==0){
//            newDvdEntity.setCanSold(false);
//        }
//        else {
//            newDvdEntity.setCanSold(true);
//        }
//        System.out.println("Indirim varsa oran girin yoksa 0 girin : ");
//        newDvdEntity.setDiscountRate(ConsoleReader.getInstance().readDouble());
//
//        GenreType.getAllGenres().forEach(i -> System.out.println(i.getGenreId() + " - " + i.getGenreName()));
//        System.out.println("Albumun turunu girin : ");
//        newDvdEntity.addGenre(new GenreEntity(GenreType.getById(ConsoleReader.getInstance().readInt())));
//
//        QualityType.getAllQualities().forEach(i-> System.out.println(i.getId() + " - " + i.getQuality()));
//        System.out.println("Albumun cozunurlugunu girin : ");
//        newDvdEntity.setQuality(QualityType.getById(ConsoleReader.getInstance().readInt()));
//
//        System.out.println("Artist adi girin : ");
//        String userInputName = ConsoleReader.getInstance().readString();
//        ArtistEntityController artistEntityController = new ArtistEntityController();
//        ArrayList<ArtistEntity> artists = artistEntityController.findByName(userInputName);
//        artists.forEach(i -> System.out.println(i));
//        System.out.println("Secmek istediginiz artist id sini girin : ");
//        int userInputArtistId = ConsoleReader.getInstance().readInt();
//        ArtistEntity artist = artists.stream().filter(i -> i.getArtistId() == userInputArtistId).toList().get(0);
//        newDvdEntity.setDvdArtist(artist);
//
//        DvdEntityController dvdEntityController = new DvdEntityController();
//        dvdEntityController.create(newDvdEntity);
//        System.out.println("Ekleme basarili....");
//    }
//
//    private static void cdAlbumsOperations() {
//        CDEntityController cdEntityController = new CDEntityController();
//        ArrayList<CDEntity> cdEntities = cdEntityController.list();
//        cdEntities.stream().forEach(i -> System.out.println(i));
//
//        System.out.println("Duzenleme yapmak istediginiz Album id sini girin, yeni kayit olusturmak icin 0 girin");
//        int userInputId = ConsoleReader.getInstance().readInt();
//
//        if (userInputId == 0){
//            createNewCdAlbum();
//        }
//        else if (userInputId > 0){
//            CDEntity cdAlbum = cdEntities.stream().filter(i -> i.getCdId() == userInputId).toList().get(0);
//            if (cdAlbum != null){
//                System.out.println("Guncellemek icin 1 silmek icin 0 girin : ");
//                if(ConsoleReader.getInstance().readInt()==0){
//                    cdEntityController.delete(cdAlbum);
//                    System.out.println("Silme basarili .....");
//                }
//                else{
//                    editCdAlbum(cdAlbum);
//                }
//            }
//            else {
//                System.out.println("Hatali giris yaptiniz.");
//            }
//        }
//    }
//
//    private static void editCdAlbum(CDEntity cdAlbum) {
//        System.out.println("Album adini girin : ");
//        cdAlbum.setAlbumName(ConsoleReader.getInstance().readString());
//        System.out.println("Fiyat girin :");
//        cdAlbum.setPrice(ConsoleReader.getInstance().readDouble());
//        System.out.println("Satilmaya uygunsa 1 degilse 0 girin");
//        if (ConsoleReader.getInstance().readInt()==0){
//            cdAlbum.setCanSold(false);
//        }
//        else {
//            cdAlbum.setCanSold(true);
//        }
//        System.out.println("Indirim varsa oran girin yoksa 0 girin : ");
//        cdAlbum.setDiscountRate(ConsoleReader.getInstance().readDouble());
//
//        GenreType.getAllGenres().forEach(i -> System.out.println(i.getGenreId() + " - " + i.getGenreName()));
//        System.out.println("Albumun turunu girin : ");
//        cdAlbum.addGenre(new GenreEntity(GenreType.getById(ConsoleReader.getInstance().readInt())));
//
//        System.out.println("Artist adi girin : ");
//        String userInputName = ConsoleReader.getInstance().readString();
//        ArtistEntityController artistEntityController = new ArtistEntityController();
//        ArrayList<ArtistEntity> artists = artistEntityController.findByName(userInputName);
//        artists.forEach(i -> System.out.println(i));
//        System.out.println("Secmek istediginiz artist id sini girin : ");
//        int userInputArtistId = ConsoleReader.getInstance().readInt();
//        ArtistEntity artist = artists.stream().filter(i -> i.getArtistId() == userInputArtistId).toList().get(0);
//        cdAlbum.setCdArtist(artist);
//
//        CDEntityController cdEntityController = new CDEntityController();
//        cdEntityController.update(cdAlbum);
//        System.out.println("Guncelleme basarili...");
//    }
//
//    private static void createNewCdAlbum() {
//        CDEntity newCdEntity = new CDEntity();
//        System.out.println("Album adini girin : ");
//        newCdEntity.setAlbumName(ConsoleReader.getInstance().readString());
//        System.out.println("Fiyat girin :");
//        newCdEntity.setPrice(ConsoleReader.getInstance().readDouble());
//        System.out.println("Satilmaya uygunsa 1 degilse 0 girin");
//        if (ConsoleReader.getInstance().readInt()==0){
//            newCdEntity.setCanSold(false);
//        }
//        else {
//            newCdEntity.setCanSold(true);
//        }
//        System.out.println("Indirim varsa oran girin yoksa 0 girin : ");
//        newCdEntity.setDiscountRate(ConsoleReader.getInstance().readDouble());
//
//        GenreType.getAllGenres().forEach(i -> System.out.println(i.getGenreId() + " - " + i.getGenreName()));
//        System.out.println("Albumun turunu girin : ");
//        newCdEntity.addGenre(new GenreEntity(GenreType.getById(ConsoleReader.getInstance().readInt())));
//
//        System.out.println("Artist adi girin : ");
//        String userInputName = ConsoleReader.getInstance().readString();
//        ArtistEntityController artistEntityController = new ArtistEntityController();
//        ArrayList<ArtistEntity> artists = artistEntityController.findByName(userInputName);
//        artists.forEach(i -> System.out.println(i));
//        System.out.println("Secmek istediginiz artist id sini girin : ");
//        int userInputArtistId = ConsoleReader.getInstance().readInt();
//        ArtistEntity artist = artists.stream().filter(i -> i.getArtistId() == userInputArtistId).toList().get(0);
//        newCdEntity.setCdArtist(artist);
//
//        CDEntityController cdEntityController = new CDEntityController();
//        cdEntityController.create(newCdEntity);
//        System.out.println("Ekleme basarili....");
//    }
}

