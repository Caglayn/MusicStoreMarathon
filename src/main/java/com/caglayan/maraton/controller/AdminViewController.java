package com.caglayan.maraton.controller;

import com.caglayan.maraton.entities.GenreEntity;
import javafx.event.ActionEvent;
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
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class AdminViewController {

    @FXML
    private Button btnCdDelete;

    @FXML
    private Button btnCdNewRecord;

    @FXML
    private Button btnCdUpdate;

    @FXML
    private Button btnDvdDelete;

    @FXML
    private Button btnDvdNewRecor;

    @FXML
    private Button btnDvdUpdate;

    @FXML
    private Button btnVinylDelete;

    @FXML
    private Button btnVinylNewRecord;

    @FXML
    private Button btnVinylUpdate;

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
            clearVinylAlbumDetails();
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

    private void clearVinylAlbumDetails() {
        this.txtVinylId.setText("");
        this.txtVinylAlbumName.setText("");
        this.txtVinylPrice.setText("");
        this.txtVinylDiscount.setText("");
        this.txtVinylDiameter.setText("");
        this.txtVinylSpeed.setText("");
        this.comboVinylArtist.getSelectionModel().clearSelection();
        this.comboVinylGenres.getSelectionModel().clearSelection();
        this.chkbxVinylCanSold.setSelected(false);
    }

    private void showDvdAlbumDetails(DvdViewDto dvd) {
        if (dvd == null) {
            clearDvdAlbumDetails();
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

    private void clearDvdAlbumDetails() {
        this.txtDvdId.setText("");
        this.txtDvdAlbumName.setText("");
        this.txtDvdPrice.setText("");
        this.txtDvdDiscount.setText("");
        this.comboDvdArtist.getSelectionModel().clearSelection();
        this.comboDvdGenres.getSelectionModel().clearSelection();
        this.comboDvdQuality.getSelectionModel().clearSelection();
        this.chkbxDvdCanSold.setSelected(false);
    }

    private void showCdAlbumDetails(CdViewDto cd) {
        if (cd == null) {
            clearCdAlbumDetails();
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

    private void clearCdAlbumDetails() {
        this.txtCdId.setText("");
        this.txtCdAlbumName.setText("");
        this.txtCdPrice.setText("");
        this.txtCdDiscount.setText("");
        this.comboCdArtist.getSelectionModel().clearSelection();
        this.comboCdGenres.getSelectionModel().clearSelection();
        this.chkbxCdCanSold.setSelected(false);
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
        this.cdAlbums = FXCollections.observableArrayList();
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

    @FXML
    void actionExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void actionShowAbout(ActionEvent event) {
        showInfoAlert("Record Store Application v1.0");
    }

    private void showWarningAlert(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning..!");
        alert.setHeaderText(message);
        alert.show();
    }

    private void showInfoAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(message);
        alert.show();
    }

    private boolean showConfirmationAlert(String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are you sure !");
        alert.setContentText(message);
        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton, cancelButton);

        Optional<ButtonType> type = alert.showAndWait();
        if (type.get() == okButton)
            return true;
        else
            return false;
    }

    @FXML
    void cdDeleteAction(ActionEvent event) {
        if (txtCdId.getText().isBlank())
            showWarningAlert("Please select a record first !");
        else{
            long deleteId = Long.valueOf(txtCdId.getText());

            boolean selection = showConfirmationAlert("Are you sure want to delete ?");
            if (selection){
                int deleteIndex = findCdIndexToBeDeleted(deleteId);
                if (deleteIndex != -1){
                    cdAlbums.remove(deleteIndex);
                    CDEntityController cdEntityController = new CDEntityController();
                    cdEntityController.delete(deleteId);
                    clearCdAlbumDetails();
                }
            }

        }
    }

    private int findCdIndexToBeDeleted(long deleteId) {
        for (int i = 0; i<cdAlbums.size();i++){
            if (cdAlbums.get(i).getId().get()==deleteId)
                return i;
        }
        return -1;
    }

    @FXML
    void cdNewRecordAction(ActionEvent event) {
        if(!this.txtCdId.getText().isBlank()){
            clearCdAlbumDetails();
            showInfoAlert("For create a new record, please press again new record button after filling all fields");
        }
        else {
            if (!txtCdAlbumName.getText().isBlank() && !txtCdPrice.getText().isBlank() && !txtCdDiscount.getText().isBlank()
            && (comboCdArtist.getValue()!=null) && (comboCdGenres.getValue()!=null) ) {
                CDEntityController cdEntityController = new CDEntityController();
                ArtistEntityController artistEntityController = new ArtistEntityController();
                CDEntity newCd = new CDEntity();
                newCd.setAlbumName(txtCdAlbumName.getText());
                newCd.setPrice(Double.valueOf(txtCdPrice.getText()));
                newCd.setCanSold(chkbxCdCanSold.isSelected());
                newCd.setCdArtist(artistEntityController.find(comboCdArtist.getValue().getId().get()));
                newCd.addGenre(new GenreEntity(comboCdGenres.getValue()));
                cdEntityController.create(newCd);
                initializeCdAlbums();
                initializeCdAlbumsTable();
                showInfoAlert("New record creation successful");
                clearCdAlbumDetails();
            }
            else {
                showWarningAlert("Please fill all fields");
            }
        }
    }

    @FXML
    void cdUpdateAction(ActionEvent event) {
        if (txtCdId.getText().isBlank())
            showWarningAlert("Please select a record first !");
        else {
            long updateId = Long.valueOf(txtCdId.getText());
            boolean selection = showConfirmationAlert("Are you sure want to update ?");
            if (selection){
                CDEntityController cdEntityController = new CDEntityController();
                ArtistEntityController artistEntityController = new ArtistEntityController();
                CDEntity updateEntity = cdEntityController.find(updateId);
                if (updateEntity != null){
                    updateEntity.setAlbumName(txtCdAlbumName.getText());
                    updateEntity.setPrice(Double.valueOf(txtCdPrice.getText()));
                    updateEntity.setCanSold(chkbxCdCanSold.isSelected());
                    updateEntity.setDiscountRate(Double.valueOf(txtCdDiscount.getText()));
                    if (comboCdArtist.getValue() != null)
                        updateEntity.setCdArtist(artistEntityController.find(comboCdArtist.getValue().getId().get()));
                    if (comboCdGenres.getValue() != null){
                        HashSet<GenreEntity> set = new HashSet<GenreEntity>();
                        set.add(new GenreEntity(comboCdGenres.getValue()));
                        updateEntity.setGenres(set);
                    }
                    cdEntityController.update(updateEntity);
                    initializeCdAlbums();
                    initializeCdAlbumsTable();
                    showInfoAlert("Update succesfull.");
                }
            }
        }
    }

    @FXML
    void dvdDeleteAction(ActionEvent event) {

    }

    @FXML
    void dvdNewRecorAcrion(ActionEvent event) {

    }

    @FXML
    void dvdUpdateAction(ActionEvent event) {

    }

    @FXML
    void vinylDeleteAction(ActionEvent event) {

    }

    @FXML
    void vinylNewRecordAction(ActionEvent event) {

    }

    @FXML
    void vinylUpdateAction(ActionEvent event) {

    }
}