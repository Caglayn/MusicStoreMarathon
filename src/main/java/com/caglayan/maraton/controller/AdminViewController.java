package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.CDEntity;
import com.caglayan.maraton.entities.DVDEntity;
import com.caglayan.maraton.entities.VinylEntity;
import com.caglayan.maraton.model.GenreType;
import com.caglayan.maraton.model.QualityType;
import com.caglayan.maraton.model.dto.ArtistViewDto;
import com.caglayan.maraton.model.dto.CdViewDto;
import com.caglayan.maraton.model.dto.DvdViewDto;
import com.caglayan.maraton.model.dto.VinylViewDto;
import com.caglayan.maraton.utils.ArtistChooserConverter;
import com.caglayan.maraton.utils.ArtistProvider;
import com.caglayan.maraton.utils.GenreChooserConverter;
import com.caglayan.maraton.utils.QualityChooserConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class AdminViewController {

    @FXML
    private CheckBox chkbxCdCanSold;

    @FXML
    private CheckBox chkbxDvdCanSold;

    @FXML
    private CheckBox chkbxVinylCanSold;

    @FXML
    private TableColumn<CdViewDto, String> colCdAlbumName;

    @FXML
    private TableColumn<CdViewDto, String> colCdArtist;

    @FXML
    private TableColumn<CdViewDto, Boolean> colCdCanSold;

    @FXML
    private TableColumn<CdViewDto, Double> colCdDiscount;

    @FXML
    private TableColumn<CdViewDto, Long> colCdId;

    @FXML
    private TableColumn<CdViewDto, Double> colCdPrice;

    @FXML
    private TableColumn<DvdViewDto, String> colDvdAlbumName;

    @FXML
    private TableColumn<DvdViewDto, String> colDvdArtist;

    @FXML
    private TableColumn<DvdViewDto, Boolean> colDvdCanSold;

    @FXML
    private TableColumn<DvdViewDto, Double> colDvdDiscount;

    @FXML
    private TableColumn<DvdViewDto, Long> colDvdId;

    @FXML
    private TableColumn<DvdViewDto, Double> colDvdPrice;

    @FXML
    private TableColumn<DvdViewDto, String> colDvdQuality;

    @FXML
    private TableColumn<VinylViewDto, String> colVinylAlbumName;

    @FXML
    private TableColumn<VinylViewDto, String> colVinylArtist;

    @FXML
    private TableColumn<VinylViewDto, Boolean> colVinylCanSold;

    @FXML
    private TableColumn<VinylViewDto, Integer> colVinylDiameter;

    @FXML
    private TableColumn<VinylViewDto, Double> colVinylDiscount;

    @FXML
    private TableColumn<VinylViewDto, Long> colVinylId;

    @FXML
    private TableColumn<VinylViewDto, Double> colVinylPrice;

    @FXML
    private TableColumn<VinylViewDto, Double> colVinylSpeed;

    @FXML
    private ComboBox<ArtistViewDto> comboCdArtist;

    @FXML
    private ComboBox<GenreType> comboCdGenres;

    @FXML
    private ComboBox<ArtistViewDto> comboDvdArtist;

    @FXML
    private ComboBox<GenreType> comboDvdGenres;

    @FXML
    private ComboBox<QualityType> comboDvdQuality;

    @FXML
    private ComboBox<ArtistViewDto> comboVinylArtist;

    @FXML
    private ComboBox<GenreType> comboVinylGenres;

    @FXML
    private Tab tabCAlbums;

    @FXML
    private Tab tabDvdAlbums;

    @FXML
    private Tab tabVinylAlbums;

    @FXML
    private TableView<CdViewDto> tblCdAlbums;

    @FXML
    private TableView<DvdViewDto> tblDvdAlbums;

    @FXML
    private TableView<VinylViewDto> tblVinylAlbums;

    @FXML
    private TextField txtCdAlbumName;

    @FXML
    private TextField txtCdDiscount;

    @FXML
    private TextField txtCdId;

    @FXML
    private TextField txtCdPrice;

    @FXML
    private TextField txtDvdAlbumName;

    @FXML
    private TextField txtDvdDiscount;

    @FXML
    private TextField txtDvdId;

    @FXML
    private TextField txtDvdPrice;

    @FXML
    private TextField txtVinylAlbumName;

    @FXML
    private TextField txtVinylDiameter;

    @FXML
    private TextField txtVinylDiscount;

    @FXML
    private TextField txtVinylId;

    @FXML
    private TextField txtVinylPrice;

    @FXML
    private TextField txtVinylSpeed;

    private ObservableList<CdViewDto> cdAlbums;
    private ObservableList<DvdViewDto> dvdAlbums;
    private ObservableList<VinylViewDto> vinylAlbums;


    public AdminViewController() {
        initializeCdAlbums();
        initializeDvdAlbums();
        initializeVinylAlbums();
        System.out.println("**************************************** admin const calisti************************");
    }

    @FXML
    private void initialize() {
        initializeCdAlbumsTable();
        initializeDvdAlbumsTable();
        initializeVinylAlbumsTable();
        initializeTableListeners();
        initializeComboBoxes();
    }

    private void initializeComboBoxes() {
        this.comboCdArtist.setConverter(new ArtistChooserConverter<>());
        for (ArtistViewDto artist : ArtistProvider.getInstance().getAllArtists()) {
            this.comboCdArtist.getItems().add(artist);
        }

        this.comboDvdArtist.setConverter(new ArtistChooserConverter<>());
        for (ArtistViewDto artist : ArtistProvider.getInstance().getAllArtists()) {
            this.comboDvdArtist.getItems().add(artist);
        }

        this.comboVinylArtist.setConverter(new ArtistChooserConverter<>());
        for (ArtistViewDto artist : ArtistProvider.getInstance().getAllArtists()) {
            this.comboVinylArtist.getItems().add(artist);
        }

        this.comboCdGenres.setConverter(new GenreChooserConverter<>());
        for (GenreType genre : GenreType.getAllGenreTypes()) {
            this.comboCdGenres.getItems().add(genre);
        }

        this.comboDvdGenres.setConverter(new GenreChooserConverter<>());
        for (GenreType genre : GenreType.getAllGenreTypes()) {
            this.comboDvdGenres.getItems().add(genre);
        }

        this.comboVinylGenres.setConverter(new GenreChooserConverter<>());
        for (GenreType genre : GenreType.getAllGenreTypes()) {
            this.comboVinylGenres.getItems().add(genre);
        }

        this.comboDvdQuality.setConverter(new QualityChooserConverter<>());
        for (QualityType quality : QualityType.getAllQualities()) {
            this.comboDvdQuality.getItems().add(quality);
        }
    }

    private void initializeTableListeners() {
        tblCdAlbums.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showCdAlbumDetails(newValue));

        tblDvdAlbums.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showDvdAlbumDetails(newValue));

        tblVinylAlbums.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showVinylAlbumDetails(newValue));
    }

    private void showVinylAlbumDetails(VinylViewDto vinyl) {
        if (vinyl == null) {
            this.txtVinylId.setText("");
            this.txtVinylAlbumName.setText("");
            this.txtVinylPrice.setText("");
            this.txtVinylDiscount.setText("");
            this.txtVinylDiameter.setText("");
            this.txtVinylSpeed.setText("");
            this.comboVinylArtist.setValue(null);
            this.comboVinylGenres.setValue(null);
            this.chkbxVinylCanSold.setSelected(false);
        } else {
            this.txtVinylId.setText(Long.toString(vinyl.getId().get()));
            this.txtVinylAlbumName.setText(vinyl.getAlbumName().get() == null ? "" : vinyl.getAlbumName().get());
            this.txtVinylPrice.setText(Double.toString(vinyl.getPrice().get()));
            this.txtVinylDiscount.setText(Double.toString(vinyl.getDiscountRate().get()));

            if (vinyl.getArtist().get() == null)
                this.comboVinylArtist.getSelectionModel().clearSelection();
            else
                this.comboVinylArtist.setValue(vinyl.getArtist().get());

            if (vinyl.getGenres().size() == 0)
                this.comboVinylGenres.getSelectionModel().clearSelection();
            else
                this.comboVinylGenres.setValue(vinyl.getGenres().getFirst().get());

            this.chkbxVinylCanSold.setSelected(vinyl.getCanSold().get());
            this.txtVinylDiameter.setText(Integer.toString(vinyl.getDiameter().get()));
            this.txtVinylSpeed.setText(Double.toString(vinyl.getSpeed().get()));
        }
    }

    private void showDvdAlbumDetails(DvdViewDto dvd) {
        if (dvd == null) {
            this.txtDvdId.setText("");
            this.txtDvdAlbumName.setText("");
            this.txtDvdPrice.setText("");
            this.txtDvdDiscount.setText("");
            this.comboDvdArtist.setValue(null);
            this.comboDvdGenres.setValue(null);
            this.comboDvdQuality.setValue(null);
            this.chkbxDvdCanSold.setSelected(false);
        } else {
            this.txtDvdId.setText(Long.toString(dvd.getId().get()));
            this.txtDvdAlbumName.setText(dvd.getAlbumName().get() == null ? "" : dvd.getAlbumName().get());
            this.txtDvdPrice.setText(Double.toString(dvd.getPrice().get()));
            this.txtDvdDiscount.setText(Double.toString(dvd.getDiscountRate().get()));

            if (dvd.getArtist().get() == null)
                this.comboDvdArtist.getSelectionModel().clearSelection();
            else
                this.comboDvdArtist.setValue(dvd.getArtist().get());

            if (dvd.getGenres().size() == 0)
                this.comboDvdGenres.getSelectionModel().clearSelection();
            else
                this.comboDvdGenres.setValue(dvd.getGenres().getFirst().get());

            this.chkbxDvdCanSold.setSelected(dvd.getCanSold().get());

            if (dvd.getQuality().get() == null)
                this.comboDvdQuality.getSelectionModel().clearSelection();
            else
                this.comboDvdQuality.setValue(dvd.getQuality().get());
        }
    }

    private void showCdAlbumDetails(CdViewDto cd) {
        if (cd == null) {
            this.txtCdId.setText("");
            this.txtCdAlbumName.setText("");
            this.txtCdPrice.setText("");
            this.txtCdDiscount.setText("");
            this.comboCdArtist.setValue(null);
            this.comboCdGenres.setValue(null);
            this.chkbxCdCanSold.setSelected(false);
        } else {
            this.txtCdId.setText(Long.toString(cd.getId().get()));
            this.txtCdAlbumName.setText(cd.getAlbumName().get() == null ? "" : cd.getAlbumName().get());
            this.txtCdPrice.setText(Double.toString(cd.getPrice().get()));
            this.txtCdDiscount.setText(Double.toString(cd.getDiscountRate().get()));

            if (cd.getArtist().get() == null)
                this.comboCdArtist.getSelectionModel().clearSelection();
            else
                this.comboCdArtist.setValue(cd.getArtist().get());

            if (cd.getGenres().size() == 0)
                this.comboCdGenres.getSelectionModel().clearSelection();
            else
                this.comboCdGenres.setValue(cd.getGenres().getFirst().get());

            this.chkbxCdCanSold.setSelected(cd.getCanSold().get());
        }
    }

    private void initializeVinylAlbumsTable() {
        colVinylId.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        colVinylAlbumName.setCellValueFactory(cellData -> cellData.getValue().getAlbumName());
        colVinylPrice.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());
        colVinylCanSold.setCellValueFactory(cellData -> cellData.getValue().getCanSold());
        colVinylDiscount.setCellValueFactory(cellData -> cellData.getValue().getDiscountRate().asObject());
        colVinylDiameter.setCellValueFactory(cellData -> cellData.getValue().getDiameter().asObject());
        colVinylArtist.setCellValueFactory(cellData -> cellData.getValue().getArtistName());
        colVinylSpeed.setCellValueFactory(cellData -> cellData.getValue().getSpeed().asObject());
        tblVinylAlbums.setItems(this.getVinylAlbums());
    }

    private void initializeDvdAlbumsTable() {
        colDvdId.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        colDvdAlbumName.setCellValueFactory(cellData -> cellData.getValue().getAlbumName());
        colDvdPrice.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());
        colDvdCanSold.setCellValueFactory(cellData -> cellData.getValue().getCanSold());
        colDvdDiscount.setCellValueFactory(cellData -> cellData.getValue().getDiscountRate().asObject());
        colDvdArtist.setCellValueFactory(cellData -> cellData.getValue().getArtistName());
        colDvdQuality.setCellValueFactory(cellData -> {
            if (cellData.getValue().getQuality().get() != null) {
                return cellData.getValue().getQuality().get().asStringProperty();
            }
            return null;
        });

        tblDvdAlbums.setItems(this.getDvdAlbums());
    }

    private void initializeCdAlbumsTable() {
        colCdId.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        colCdAlbumName.setCellValueFactory(cellData -> cellData.getValue().getAlbumName());
        colCdPrice.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());
        colCdCanSold.setCellValueFactory(cellData -> cellData.getValue().getCanSold());
        colCdDiscount.setCellValueFactory(cellData -> cellData.getValue().getDiscountRate().asObject());
        colCdArtist.setCellValueFactory(cellData -> cellData.getValue().getArtistName());
        tblCdAlbums.setItems(this.getCdAlbums());


    }

    private void initializeCdAlbums() {
        CDEntityController cdEntityController = new CDEntityController();
        ArrayList<CDEntity> cdEntities = cdEntityController.list();
        for (CDEntity cdEntity : cdEntities) {
            this.addCdAlbum(new CdViewDto(cdEntity));
        }
    }

    private void initializeDvdAlbums() {
        DvdEntityController dvdEntityController = new DvdEntityController();
        ArrayList<DVDEntity> dvdEntities = dvdEntityController.list();
        for (DVDEntity dvdEntity : dvdEntities) {
            this.addDvdAlbum(new DvdViewDto(dvdEntity));
        }
    }

    private void initializeVinylAlbums() {
        VinylEntityController vinylEntityController = new VinylEntityController();
        ArrayList<VinylEntity> vinylEntities = vinylEntityController.list();
        for (VinylEntity vinylEntity : vinylEntities) {
            this.addVinylAlbum(new VinylViewDto(vinylEntity));
        }
    }

    private void addCdAlbum(CdViewDto cdAlbum) {
        this.getCdAlbums().add(cdAlbum);
    }

    private void addDvdAlbum(DvdViewDto dvdAlbum) {
        this.getDvdAlbums().add(dvdAlbum);
    }

    private void addVinylAlbum(VinylViewDto vinylAlbum) {
        this.getVinylAlbums().add(vinylAlbum);
    }

    public ObservableList<CdViewDto> getCdAlbums() {
        if (this.cdAlbums == null) {
            this.cdAlbums = FXCollections.observableArrayList();
        }
        return cdAlbums;
    }

    public ObservableList<DvdViewDto> getDvdAlbums() {
        if (this.dvdAlbums == null) {
            this.dvdAlbums = FXCollections.observableArrayList();
        }
        return dvdAlbums;
    }

    public ObservableList<VinylViewDto> getVinylAlbums() {
        if (this.vinylAlbums == null) {
            this.vinylAlbums = FXCollections.observableArrayList();
        }
        return vinylAlbums;
    }
}