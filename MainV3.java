package application;

import java.awt.Color;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainV3 extends Application implements EventHandler<ActionEvent> {
	Stage window;

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		try {
			Label title = new Label("Boston Code Camp Desktop Application");
			title.setStyle("-fx-font: 24 arial;");
			title.setAlignment(Pos.TOP_CENTER);
			Separator separator = new Separator(Orientation.HORIZONTAL);

			Label labelTimeSlot = new Label("Time Slot");
			labelTimeSlot.setStyle("-fx-font: 36 arial;");
			Label labelSpeaker = new Label("Speaker");
			labelSpeaker.setStyle("-fx-font: 36 arial;");
			Label labelRoom = new Label("Room");
			labelRoom.setStyle("-fx-font: 36 arial;");
			Label labelSession = new Label("Session");
			labelSession.setStyle("-fx-font: 36 arial;");

			ObservableList<listItem> timeSlotList = FXCollections.observableArrayList();
			timeSlotList.add(new listItem("Please"));
			timeSlotList.add(new listItem("Do It"));
			timeSlotList.add(new listItem("Sample Text"));
			timeSlotList.add(new listItem("Remove Me"));
			timeSlotList.add(new listItem("Remove Me Again"));

			ListView<listItem> timeSlot_List = new ListView<>(timeSlotList);
			timeSlot_List.setCellFactory(param -> new ListCell<listItem>() {
				@Override
				protected void updateItem(listItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getItem() == null) {
						setText(null);
					} else {
						setText(item.getItem());
					}
				}
			});

			final Button timeSlot_Remove = new Button("Remove");
			timeSlot_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int timeSlot_RemoveIndex = timeSlot_List.getSelectionModel().getSelectedIndex();
					if (timeSlot_RemoveIndex != -1) {
						listItem timeSlot_ItemToRemove = timeSlot_List.getSelectionModel().getSelectedItem();

						final int timeSlot_RemoveNewIndex = (timeSlot_RemoveIndex == timeSlot_List.getItems().size()
								- 1) ? timeSlot_RemoveIndex - 1 : timeSlot_RemoveIndex;

						timeSlot_List.getItems().remove(timeSlot_RemoveIndex);
						timeSlot_List.getSelectionModel().select(timeSlot_RemoveNewIndex);
					}
				}
			});

			ObservableList<listItem> speakerList = FXCollections.observableArrayList();
			speakerList.add(new listItem("Legs"));
			speakerList.add(new listItem("Sample Text"));
			speakerList.add(new listItem("Redundant"));
			speakerList.add(new listItem("Incredibly Redundant"));

			ListView<listItem> speaker_List = new ListView<>(speakerList);
			speaker_List.setCellFactory(param -> new ListCell<listItem>() {
				@Override
				protected void updateItem(listItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getItem() == null) {
						setText(null);
					} else {
						setText(item.getItem());
					}
				}
			});

			final Button speaker_Remove = new Button("Remove");
			speaker_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int speaker_RemoveIndex = speaker_List.getSelectionModel().getSelectedIndex();
					if (speaker_RemoveIndex != -1) {
						listItem speaker_ItemToRemove = speaker_List.getSelectionModel().getSelectedItem();

						final int speaker_RemoveNewIndex = (speaker_RemoveIndex == speaker_List.getItems().size() - 1)
								? speaker_RemoveIndex - 1 : speaker_RemoveIndex;

						speaker_List.getItems().remove(speaker_RemoveIndex);
						speaker_List.getSelectionModel().select(speaker_RemoveNewIndex);
					}
				}
			});

			ObservableList<listItem> roomList = FXCollections.observableArrayList();
			roomList.add(new listItem("Wumbo"));
			roomList.add(new listItem("Dumbo"));
			roomList.add(new listItem("Kachow"));
			roomList.add(new listItem("Sample Text"));
			roomList.add(new listItem("Pew Pew"));

			ListView<listItem> room_List = new ListView<>(roomList);
			room_List.setItems(roomList);
			room_List.setCellFactory(param -> new ListCell<listItem>() {
				@Override
				protected void updateItem(listItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getItem() == null) {
						setText(null);
					} else {
						setText(item.getItem());
					}
				}
			});

			final Button room_Remove = new Button("Remove");
			room_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int room_RemoveIndex = room_List.getSelectionModel().getSelectedIndex();
					if (room_RemoveIndex != -1) {
						listItem room_ItemToRemove = room_List.getSelectionModel().getSelectedItem();

						final int room_RemoveNewIndex = (room_RemoveIndex == room_List.getItems().size() - 1)
								? room_RemoveIndex - 1 : room_RemoveIndex;

						room_List.getItems().remove(room_RemoveIndex);
						room_List.getSelectionModel().select(room_RemoveNewIndex);
					}
				}
			});

			ObservableList<listItem> sessionList = FXCollections.observableArrayList();
			sessionList.add(new listItem("Sample Text"));
			sessionList.add(new listItem("Sample Text"));
			sessionList.add(new listItem("Funky"));
			sessionList.add(new listItem("Sample Text"));
			sessionList.add(new listItem("Talk"));
			sessionList.add(new listItem("Sample Text"));
			sessionList.add(new listItem("Sample Text"));
			sessionList.add(new listItem("Speech"));
			sessionList.add(new listItem("Sample Text"));
			sessionList.add(new listItem("Programming Session"));
			sessionList.add(new listItem("Sample Text"));
			sessionList.add(new listItem("Sample Text"));
			sessionList.add(new listItem("Remove Me"));
			sessionList.add(new listItem("Sample Text"));
			sessionList.add(new listItem("Aaaah"));
			sessionList.add(new listItem("Blah Blah Blah"));
			sessionList.add(new listItem("Annoying"));

			ListView<listItem> session_List = new ListView<>(sessionList);
			session_List.setCellFactory(param -> new ListCell<listItem>() {
				@Override
				protected void updateItem(listItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getItem() == null) {
						setText(null);
					} else {
						setText(item.getItem());
					}
				}
			});

			final Button session_Remove = new Button("Remove");
			session_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int session_RemoveIndex = session_List.getSelectionModel().getSelectedIndex();
					if (session_RemoveIndex != -1) {
						listItem session_ItemToRemove = session_List.getSelectionModel().getSelectedItem();

						final int session_RemoveNewIndex = (session_RemoveIndex == session_List.getItems().size() - 1)
								? session_RemoveIndex - 1 : session_RemoveIndex;

						session_List.getItems().remove(session_RemoveIndex);
						session_List.getSelectionModel().select(session_RemoveNewIndex);
					}
				}
			});

			Button timeSlotAdd = new Button("Add");
			Button timeSlotEdit = new Button("Edit");
			Button speakerAdd = new Button("Add");
			Button speakerEdit = new Button("Edit");
			Button roomAdd = new Button("Add");
			Button roomEdit = new Button("Edit");
			Button sessionAdd = new Button("Add");
			Button sessionEdit = new Button("Edit");
			Button home = new Button("Home");

			HBox timeSlotButtons = new HBox(timeSlotAdd, timeSlotEdit);
			timeSlotButtons.setSpacing(5);
			timeSlotButtons.setAlignment(Pos.BOTTOM_CENTER);
			HBox speakerButtons = new HBox(speakerAdd, speakerEdit);
			speakerButtons.setSpacing(5);
			speakerButtons.setAlignment(Pos.BOTTOM_CENTER);
			HBox roomButtons = new HBox(roomAdd, roomEdit);
			roomButtons.setSpacing(5);
			roomButtons.setAlignment(Pos.BOTTOM_CENTER);
			HBox sessionButtons = new HBox(sessionAdd, sessionEdit);
			sessionButtons.setSpacing(5);
			sessionButtons.setAlignment(Pos.BOTTOM_CENTER);

			VBox timeSlot = new VBox(labelTimeSlot, timeSlot_List, timeSlotButtons, timeSlot_Remove);
			timeSlot.setAlignment(Pos.CENTER);
			timeSlot.setSpacing(10);
			timeSlot.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");
			VBox speaker = new VBox(labelSpeaker, speaker_List, speakerButtons, speaker_Remove);
			speaker.setAlignment(Pos.CENTER);
			speaker.setSpacing(10);
			speaker.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");
			VBox room = new VBox(labelRoom, room_List, roomButtons, room_Remove);
			room.setAlignment(Pos.CENTER);
			room.setSpacing(10);
			room.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");
			VBox session = new VBox(labelSession, session_List, sessionButtons, session_Remove);
			session.setAlignment(Pos.CENTER);
			session.setSpacing(10);
			session.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			HBox homeOption = new HBox(timeSlot, speaker, room, session);
			VBox homePage = new VBox(title, home, separator, homeOption);
			homePage.setSpacing(5);
			homePage.setAlignment(Pos.TOP_CENTER);
			homePage.setStyle("-fx-background-color: #ffffff;");

			Scene sceneHome = new Scene(homePage, 900, 400);
			sceneHome.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			window.setMinHeight(sceneHome.getHeight());
			window.setMinWidth(sceneHome.getWidth());
			window.show();
			window.setScene(sceneHome);
			window.setTitle("Software Engineering Desktop Application");

			// -Room
			// Page-//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label roomAdd_TitleLabel = new Label("Boston Code Camp Desktop Application");
			roomAdd_TitleLabel.setStyle("-fx-font: 24 arial;");
			roomAdd_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator roomAdd_Separator = new Separator(Orientation.HORIZONTAL);

			TableView<roomCap> roomAdd_Table = new TableView<>();
			roomAdd_Table.setEditable(false);

			TableColumn<roomCap, String> roomAdd_NameColumn = new TableColumn<>("Name");
			roomAdd_NameColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));
			TableColumn<roomCap, Integer> roomAdd_CapacityColumn = new TableColumn<>("Capacity");
			roomAdd_CapacityColumn.setCellValueFactory(new PropertyValueFactory<>("roomCapacity"));

			roomAdd_Table.setItems(getRoomAndCapacity());

			roomAdd_Table.getColumns().addAll(roomAdd_NameColumn, roomAdd_CapacityColumn);
			roomAdd_Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			Button roomAdd_AddButton = new Button("Add");
			Button roomAdd_HomeButton = new Button("Home");

			Label roomAdd_NameLabel = new Label("Name");
			Label roomAdd_CapacityLabel = new Label("Capacity");
			Label roomAdd_Title = new Label("Add Room");
			roomAdd_Title.setFont(new Font("Arial", 48));

			TextField roomAdd_NameText = new TextField();
			TextField roomAdd_CapacityText = new TextField();

			roomAdd_AddButton.setOnAction(e -> {
				String inputRoomName = roomAdd_NameText.getText();
				String inputRoomCapacity = roomAdd_NameText.getText();
				if (inputRoomName == "" || inputRoomCapacity == null) {

				} else {

				}

			});

			VBox roomAdd_Labels = new VBox(roomAdd_NameLabel, roomAdd_CapacityLabel);
			roomAdd_Labels.setSpacing(15);
			roomAdd_Labels.setAlignment(Pos.CENTER_RIGHT);

			VBox roomAdd_Texts = new VBox(roomAdd_NameText, roomAdd_CapacityText);
			roomAdd_Texts.setSpacing(5);
			roomAdd_Texts.setAlignment(Pos.CENTER);

			HBox roomAdd_LabelsAndTexts = new HBox(roomAdd_Labels, roomAdd_Texts);
			roomAdd_LabelsAndTexts.setSpacing(5);
			roomAdd_LabelsAndTexts.setAlignment(Pos.CENTER);

			VBox roomAdd_Page = new VBox(roomAdd_TitleLabel, roomAdd_HomeButton, roomAdd_Separator, roomAdd_Title,
					roomAdd_Table, roomAdd_LabelsAndTexts, roomAdd_AddButton);
			roomAdd_Page.setSpacing(5);
			roomAdd_Page.setAlignment(Pos.TOP_CENTER);
			roomAdd_Page.setStyle("-fx-background-color: #ffffff;");
			roomAdd_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene roomAdd_Scene = new Scene(roomAdd_Page, 900, 400);

			// -Session
			// Page-//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label sessionAdd_TitleLabel = new Label("Boston Code Camp Desktop Application");
			sessionAdd_TitleLabel.setStyle("-fx-font: 24 arial;");
			sessionAdd_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator sessionAdd_Separator = new Separator(Orientation.HORIZONTAL);

			Button sessionAdd_AddButton = new Button("Add");
			Button sessionAdd_HomeButton = new Button("Home");

			ListView<listItem> sessionAdd_List = new ListView<>(sessionList);
			sessionAdd_List.setCellFactory(param -> new ListCell<listItem>() {
				@Override
				protected void updateItem(listItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getItem() == null) {
						setText(null);
					} else {
						setText(item.getItem());
					}
				}
			});

			// !!!ADD DROP DOWN MENUS FOR SPEAKER, ROOM, TIME SLOT
			Label sessionAdd_NameLabel = new Label("Name");
			Label sessionAdd_SpeakerLabel = new Label("Speaker");
			Label sessionAdd_RoomLabel = new Label("Room");
			Label sessionAdd_TimeLabel = new Label("Time Slot");
			Label sessionAdd_Title = new Label("Add Session");
			sessionAdd_Title.setFont(new Font("Arial", 48));

			TextField sessionAdd_NameText = new TextField();

			sessionAdd_AddButton.setOnAction(e -> {
				String inputSessionName = sessionAdd_NameText.getText();
				sessionList.add(new listItem(inputSessionName));

			});

			HBox sessionAdd_LabelsAndTexts = new HBox(sessionAdd_NameLabel, sessionAdd_NameText);
			sessionAdd_LabelsAndTexts.setSpacing(5);
			sessionAdd_LabelsAndTexts.setAlignment(Pos.CENTER);

			VBox sessionAdd_Page = new VBox(sessionAdd_TitleLabel, sessionAdd_HomeButton, sessionAdd_Separator,
					sessionAdd_Title, sessionAdd_List, sessionAdd_LabelsAndTexts, sessionAdd_AddButton);
			sessionAdd_Page.setSpacing(5);
			sessionAdd_Page.setAlignment(Pos.TOP_CENTER);
			sessionAdd_Page.setStyle("-fx-background-color: #ffffff;");
			sessionAdd_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene sessionAdd_Scene = new Scene(sessionAdd_Page, 900, 400);

			// -Speaker
			// Page-//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label speakerAdd_TitleLabel = new Label("Boston Code Camp Desktop Application");
			speakerAdd_TitleLabel.setStyle("-fx-font: 24 arial;");
			speakerAdd_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator speakerAdd_Separator = new Separator(Orientation.HORIZONTAL);

			Button speakerAdd_AddButton = new Button("Add");
			Button speakerAdd_HomeButton = new Button("Home");

			TableView<speakerPerson> speakerAdd_Table = new TableView<>();
			speakerAdd_Table.setEditable(true);

			TableColumn<speakerPerson, String> speakerAdd_FirstNameColumn = new TableColumn<>("First Name");
			speakerAdd_FirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			TableColumn<speakerPerson, String> speakerAdd_LastNameColumn = new TableColumn<>("Last Name");
			speakerAdd_LastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			TableColumn<speakerPerson, String> speakerAdd_EmailColumn = new TableColumn<>("Email");
			speakerAdd_EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

			speakerAdd_Table.setItems(getSpeakers());

			speakerAdd_Table.getColumns().addAll(speakerAdd_FirstNameColumn, speakerAdd_LastNameColumn,
					speakerAdd_EmailColumn);
			speakerAdd_Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			Label speakerAdd_Title = new Label("Speaker Information");
			Label speakerAdd_FirstName = new Label("First Name");
			Label speakerAdd_LastName = new Label("Last Name");
			Label speakerAdd_Phone = new Label("Email");
			speakerAdd_Title.setFont(new Font("Arial", 48));

			TextField speakerAdd_FirstNameText = new TextField();
			TextField speakerAdd_LastNameText = new TextField();
			TextField speakerAdd_PhoneText = new TextField();

			VBox speakerAdd_Labels = new VBox(speakerAdd_FirstName, speakerAdd_LastName, speakerAdd_Phone);
			speakerAdd_Labels.setSpacing(15);
			speakerAdd_Labels.setAlignment(Pos.CENTER_RIGHT);

			VBox speakerAdd_Texts = new VBox(speakerAdd_FirstNameText, speakerAdd_LastNameText, speakerAdd_PhoneText);
			speakerAdd_Texts.setSpacing(5);
			speakerAdd_Texts.setAlignment(Pos.CENTER);

			HBox speakerAdd_LabelsAndTexts = new HBox(speakerAdd_Labels, speakerAdd_Texts);
			speakerAdd_LabelsAndTexts.setSpacing(5);
			speakerAdd_LabelsAndTexts.setAlignment(Pos.CENTER);

			VBox speakerAdd_Page = new VBox(speakerAdd_TitleLabel, speakerAdd_HomeButton, speakerAdd_Separator,
					speakerAdd_Title, speakerAdd_Table, speakerAdd_LabelsAndTexts, speakerAdd_AddButton);
			speakerAdd_Page.setSpacing(5);
			speakerAdd_Page.setAlignment(Pos.TOP_CENTER);
			speakerAdd_Page.setStyle("-fx-background-color: #ffffff;");
			speakerAdd_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene speakerAdd_Scene = new Scene(speakerAdd_Page, 900, 400);

			// -Time Slot
			// Page-//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label timeSlotAdd_TitleLabel = new Label("Boston Code Camp Desktop Application");
			timeSlotAdd_TitleLabel.setStyle("-fx-font: 24 arial;");
			timeSlotAdd_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator timeSlotAdd_Separator = new Separator(Orientation.HORIZONTAL);

			Button timeSlotAdd_AddButton = new Button("Add");
			Button timeSlotAdd_HomeButton = new Button("Home");

			ListView<listItem> timeSlotAdd_List = new ListView<>(timeSlotList);
			timeSlotAdd_List.setCellFactory(param -> new ListCell<listItem>() {
				@Override
				protected void updateItem(listItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getItem() == null) {
						setText(null);
					} else {
						setText(item.getItem());
					}
				}
			});

			Label timeSlotAdd_Title = new Label("Add Time Slot");
			Label timeSlotAdd_StartTime = new Label("Start Time");
			Label timeSlotAdd_EndTime = new Label("End Time");
			Label timeSlotAdd_Duration = new Label("Duration");
			timeSlotAdd_Title.setFont(new Font("Arial", 48));

			ComboBox<Integer> timeSlotAdd_StartHour = new ComboBox<Integer>();
			timeSlotAdd_StartHour.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
			ComboBox<String> timeSlotAdd_StartMinute = new ComboBox<String>();
			timeSlotAdd_StartMinute.getItems().addAll("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50",
					"55");
			ComboBox<Integer> timeSlotAdd_EndHour = new ComboBox<Integer>();
			timeSlotAdd_EndHour.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
			ComboBox<String> timeSlotAdd_EndMinute = new ComboBox<String>();
			timeSlotAdd_EndMinute.getItems().addAll("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50",
					"55");

			ToggleGroup timeSlotAdd_StartAMPM = new ToggleGroup();

			RadioButton timeSlotAdd_StartAM = new RadioButton("A.M.");
			timeSlotAdd_StartAM.setToggleGroup(timeSlotAdd_StartAMPM);

			RadioButton timeSlotAdd_StartPM = new RadioButton("P.M.");
			timeSlotAdd_StartPM.setToggleGroup(timeSlotAdd_StartAMPM);

			ToggleGroup timeSlotAdd_EndAMPM = new ToggleGroup();

			RadioButton timeSlotAdd_EndAM = new RadioButton("A.M.");
			timeSlotAdd_EndAM.setToggleGroup(timeSlotAdd_EndAMPM);

			RadioButton timeSlotAdd_EndPM = new RadioButton("P.M.");
			timeSlotAdd_EndPM.setToggleGroup(timeSlotAdd_EndAMPM);

			ComboBox<Integer> timeSlotAdd_DurationComboBox= new ComboBox<Integer>();

			HBox timeSlotAdd_StartComboBox = new HBox(timeSlotAdd_StartHour, timeSlotAdd_StartMinute);
			timeSlotAdd_StartComboBox.setSpacing(5);
			timeSlotAdd_StartComboBox.setAlignment(Pos.CENTER);

			HBox timeSlotAdd_EndComboBox = new HBox(timeSlotAdd_EndHour, timeSlotAdd_EndMinute);
			timeSlotAdd_EndComboBox.setSpacing(5);
			timeSlotAdd_EndComboBox.setAlignment(Pos.CENTER);

			HBox timeSlotAdd_StartRadioButtons = new HBox(timeSlotAdd_StartAM, timeSlotAdd_StartPM);
			timeSlotAdd_StartRadioButtons.setSpacing(5);
			timeSlotAdd_StartRadioButtons.setAlignment(Pos.CENTER);

			HBox timeSlotAdd_EndRadioButtons = new HBox(timeSlotAdd_EndAM, timeSlotAdd_EndPM);
			timeSlotAdd_EndRadioButtons.setSpacing(5);
			timeSlotAdd_EndRadioButtons.setAlignment(Pos.CENTER);

			HBox timeSlotAddDuration = new HBox(timeSlotAdd_Duration, timeSlotAdd_DurationComboBox);
			timeSlotAddDuration.setSpacing(5);
			timeSlotAddDuration.setAlignment(Pos.CENTER);

			VBox timeSlotAdd_StartTimeInput = new VBox(timeSlotAdd_StartTime, timeSlotAdd_StartComboBox,
					timeSlotAdd_StartRadioButtons);
			timeSlotAdd_StartTimeInput.setSpacing(5);
			timeSlotAdd_StartTimeInput.setAlignment(Pos.CENTER);

			VBox timeSlotAdd_EndTimeInput = new VBox(timeSlotAdd_EndTime, timeSlotAdd_EndComboBox,
					timeSlotAdd_EndRadioButtons);
			timeSlotAdd_EndTimeInput.setSpacing(5);
			timeSlotAdd_EndTimeInput.setAlignment(Pos.CENTER);

			HBox timeSlotAdd_AllInputs = new HBox(timeSlotAdd_StartTimeInput, timeSlotAdd_EndTimeInput);
			timeSlotAdd_AllInputs.setSpacing(75);
			timeSlotAdd_AllInputs.setAlignment(Pos.CENTER);

			VBox timeSlotAdd_Page = new VBox(timeSlotAdd_TitleLabel, timeSlotAdd_HomeButton, timeSlotAdd_Separator,
					timeSlotAdd_Title, timeSlotAdd_List, timeSlotAdd_AllInputs, timeSlotAddDuration,
					timeSlotAdd_AddButton);
			timeSlotAdd_Page.setSpacing(5);
			timeSlotAdd_Page.setAlignment(Pos.TOP_CENTER);
			timeSlotAdd_Page.setStyle("-fx-background-color: #ffffff;");
			timeSlotAdd_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene timeSlotAdd_Scene = new Scene(timeSlotAdd_Page, 900, 400);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label timeSlotEdit_TitleLabel = new Label("Boston Code Camp Desktop Application");
			timeSlotEdit_TitleLabel.setStyle("-fx-font: 24 arial;");
			timeSlotEdit_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator timeSlotEdit_Separator = new Separator(Orientation.HORIZONTAL);

			Button timeSlotEdit_DoneButton = new Button("Done");
			Button timeSlotEdit_HomeButton = new Button("Home");

			ListView<listItem> timeSlotEdit_List = new ListView<>(timeSlotList);
			timeSlotEdit_List.setCellFactory(param -> new ListCell<listItem>() {
				@Override
				protected void updateItem(listItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getItem() == null) {
						setText(null);
					} else {
						setText(item.getItem());
					}
				}
			});

			timeSlotEdit_List.setEditable(false);
			timeSlotEdit_List.setMouseTransparent(true);
			timeSlotEdit_List.setFocusTraversable(false);

			Label timeSlotEdit_Title = new Label("Edit Time Slot");
			Label timeSlotEdit_StartTime = new Label("Start Time");
			Label timeSlotEdit_EndTime = new Label("End Time");
			Label timeSlotEdit_Duration = new Label("Duration");
			timeSlotEdit_Title.setFont(new Font("Arial", 48));

			ComboBox<Integer> timeSlotEdit_StartHour = new ComboBox<Integer>();
			timeSlotEdit_StartHour.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
			ComboBox<String> timeSlotEdit_StartMinute = new ComboBox<String>();
			timeSlotEdit_StartMinute.getItems().addAll("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50",
					"55");
			ComboBox<Integer> timeSlotEdit_EndHour = new ComboBox<Integer>();
			timeSlotEdit_EndHour.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
			ComboBox<String> timeSlotEdit_EndMinute = new ComboBox<String>();
			timeSlotEdit_EndMinute.getItems().addAll("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50",
					"55");
			
			ComboBox<Integer> timeSlotEdit_DurationComboBox = new ComboBox<Integer>();

			ToggleGroup timeSlotEdit_StartAMPM = new ToggleGroup();

			RadioButton timeSlotEdit_StartAM = new RadioButton("A.M.");
			timeSlotEdit_StartAM.setToggleGroup(timeSlotEdit_StartAMPM);

			RadioButton timeSlotEdit_StartPM = new RadioButton("P.M.");
			timeSlotEdit_StartPM.setToggleGroup(timeSlotEdit_StartAMPM);

			ToggleGroup timeSlotEdit_EndAMPM = new ToggleGroup();

			RadioButton timeSlotEdit_EndAM = new RadioButton("A.M.");
			timeSlotEdit_EndAM.setToggleGroup(timeSlotEdit_EndAMPM);

			RadioButton timeSlotEdit_EndPM = new RadioButton("P.M.");
			timeSlotEdit_EndPM.setToggleGroup(timeSlotEdit_EndAMPM);

			// start hbox
			HBox timeSlotEdit_StartComboBox = new HBox(timeSlotEdit_StartHour, timeSlotEdit_StartMinute);
			timeSlotEdit_StartComboBox.setSpacing(5);
			timeSlotEdit_StartComboBox.setAlignment(Pos.CENTER);
			// end hbox
			HBox timeSlotEdit_EndComboBox = new HBox(timeSlotEdit_EndHour, timeSlotEdit_EndMinute);
			timeSlotEdit_EndComboBox.setSpacing(5);
			timeSlotEdit_EndComboBox.setAlignment(Pos.CENTER);
			// start radio buttons
			HBox timeSlotEdit_StartRadioButtons = new HBox(timeSlotEdit_StartAM, timeSlotEdit_StartPM);
			timeSlotEdit_StartRadioButtons.setSpacing(5);
			timeSlotEdit_StartRadioButtons.setAlignment(Pos.CENTER);
			// end radio buttons
			HBox timeSlotEdit_EndRadioButtons = new HBox(timeSlotEdit_EndAM, timeSlotEdit_EndPM);
			timeSlotEdit_EndRadioButtons.setSpacing(5);
			timeSlotEdit_EndRadioButtons.setAlignment(Pos.CENTER);
			// not centered please help
			HBox timeSlotEditDuration = new HBox(timeSlotEdit_Duration, timeSlotEdit_DurationComboBox);
			timeSlotEditDuration.setSpacing(5);
			timeSlotEditDuration.setAlignment(Pos.CENTER);

			VBox timeSlotEdit_StartTimeInput = new VBox(timeSlotEdit_StartTime, timeSlotEdit_StartComboBox,
					timeSlotEdit_StartRadioButtons);
			timeSlotEdit_StartTimeInput.setSpacing(5);
			timeSlotEdit_StartTimeInput.setAlignment(Pos.CENTER);

			VBox timeSlotEdit_EndTimeInput = new VBox(timeSlotEdit_EndTime, timeSlotEdit_EndComboBox,
					timeSlotEdit_EndRadioButtons);
			timeSlotEdit_EndTimeInput.setSpacing(5);
			timeSlotEdit_EndTimeInput.setAlignment(Pos.CENTER);

			HBox timeSlotEdit_AllInputs = new HBox(timeSlotEdit_StartTimeInput, timeSlotEdit_EndTimeInput);
			timeSlotEdit_AllInputs.setSpacing(75);
			timeSlotEdit_AllInputs.setAlignment(Pos.CENTER);

			VBox timeSlotEdit_Page = new VBox(timeSlotEdit_TitleLabel, timeSlotEdit_HomeButton, timeSlotEdit_Separator,
					timeSlotEdit_Title, timeSlotEdit_List, timeSlotEdit_AllInputs, timeSlotEditDuration,
					timeSlotEdit_DoneButton);
			timeSlotEdit_Page.setSpacing(5);
			timeSlotEdit_Page.setAlignment(Pos.TOP_CENTER);
			timeSlotEdit_Page.setStyle("-fx-background-color: #ffffff;");
			timeSlotEdit_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene timeSlotEdit_Scene = new Scene(timeSlotEdit_Page, 900, 400);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label speakerEdit_TitleLabel = new Label("Boston Code Camp Desktop Application");
			speakerEdit_TitleLabel.setStyle("-fx-font: 24 arial;");
			speakerEdit_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator speakerEdit_Separator = new Separator(Orientation.HORIZONTAL);

			Button speakerEdit_DoneButton = new Button("Done");
			Button speakerEdit_HomeButton = new Button("Home");

			TableView<speakerPerson> speakerEdit_Table = new TableView<>();
			speakerEdit_Table.setEditable(true);

			TableColumn<speakerPerson, String> speakerEdit_FirstNameColumn = new TableColumn<>("First Name");
			speakerEdit_FirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			TableColumn<speakerPerson, String> speakerEdit_LastNameColumn = new TableColumn<>("Last Name");
			speakerEdit_LastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			TableColumn<speakerPerson, String> speakerEdit_EmailColumn = new TableColumn<>("Email");
			speakerEdit_EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

			speakerEdit_Table.setItems(getSpeakers());

			speakerEdit_Table.getColumns().addAll(speakerEdit_FirstNameColumn, speakerEdit_LastNameColumn,
					speakerEdit_EmailColumn);
			speakerEdit_Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			// good
			Label speakerEdit_Title = new Label("Speaker Information");
			Label speakerEdit_FirstName = new Label("First Name");
			Label speakerEdit_LastName = new Label("Last Name");
			Label speakerEdit_Email = new Label("Email");
			speakerEdit_Title.setFont(new Font("Arial", 48));
			// good
			TextField speakerEdit_FirstNameText = new TextField();
			TextField speakerEdit_LastNameText = new TextField();
			TextField speakerEdit_EmailText = new TextField();
			// good
			VBox speakerEdit_Labels = new VBox(speakerEdit_FirstName, speakerEdit_LastName, speakerEdit_Email);
			speakerEdit_Labels.setSpacing(15);
			speakerEdit_Labels.setAlignment(Pos.CENTER_RIGHT);
			// good
			VBox speakerEdit_Texts = new VBox(speakerEdit_FirstNameText, speakerEdit_LastNameText,
					speakerEdit_EmailText);
			speakerEdit_Texts.setSpacing(5);
			speakerEdit_Texts.setAlignment(Pos.CENTER);
			// good
			HBox speakerEdit_LabelsAndTexts = new HBox(speakerEdit_Labels, speakerEdit_Texts);
			speakerEdit_LabelsAndTexts.setSpacing(5);
			speakerEdit_LabelsAndTexts.setAlignment(Pos.CENTER);
			// good
			VBox speakerEdit_Page = new VBox(speakerEdit_TitleLabel, speakerEdit_HomeButton, speakerEdit_Separator,
					speakerEdit_Title, speakerEdit_Table, speakerEdit_LabelsAndTexts, speakerEdit_DoneButton);
			speakerEdit_Page.setSpacing(5);
			speakerEdit_Page.setAlignment(Pos.TOP_CENTER);
			speakerEdit_Page.setStyle("-fx-background-color: #ffffff;");
			speakerEdit_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene speakerEdit_Scene = new Scene(speakerEdit_Page, 900, 400);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label roomEdit_TitleLabel = new Label("Boston Code Camp Desktop Application");
			roomEdit_TitleLabel.setStyle("-fx-font: 24 arial;");
			roomEdit_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator roomEdit_Separator = new Separator(Orientation.HORIZONTAL);

			TableView<roomCap> roomEdit_Table = new TableView<>();
			roomEdit_Table.setEditable(true);

			TableColumn<roomCap, String> roomEdit_Name = new TableColumn("Name");
			roomEdit_Name.setCellValueFactory(new PropertyValueFactory<>("roomName"));
			TableColumn<roomCap, String> roomEdit_Capacity = new TableColumn("Capacity");
			roomEdit_Capacity.setCellValueFactory(new PropertyValueFactory<>("roomCapacity"));
			
			roomEdit_Table.setItems(getRoomAndCapacity());

			roomEdit_Table.getColumns().addAll(roomEdit_Name, roomEdit_Capacity);
			roomEdit_Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
			// good
			Button roomEdit_DoneButton = new Button("Done");
			Button roomEdit_HomeButton = new Button("Home");
			// good
			Label roomEdit_NameLabel = new Label("Name");
			Label roomEdit_CapacityLabel = new Label("Capacity");
			Label roomEdit_Title = new Label("Edit Room");
			roomEdit_Title.setFont(new Font("Arial", 48));
			// good
			TextField roomEdit_NameText = new TextField();
			TextField roomEdit_CapacityText = new TextField();
			// good
			VBox roomEdit_Labels = new VBox(roomEdit_NameLabel, roomEdit_CapacityLabel);
			roomEdit_Labels.setSpacing(15);
			roomEdit_Labels.setAlignment(Pos.CENTER_RIGHT);
			// good, adding the text fields to a vbox
			VBox roomEdit_Texts = new VBox(roomEdit_NameText, roomEdit_CapacityText);
			roomEdit_Texts.setSpacing(5);
			roomEdit_Texts.setAlignment(Pos.CENTER);
			// good
			HBox roomEdit_LabelsAndTexts = new HBox(roomEdit_Labels, roomEdit_Texts);
			roomEdit_LabelsAndTexts.setSpacing(5);
			roomEdit_LabelsAndTexts.setAlignment(Pos.CENTER);
			// good
			VBox roomEdit_Page = new VBox(roomEdit_TitleLabel, roomEdit_HomeButton, roomEdit_Separator, roomEdit_Title,
					roomEdit_Table, roomEdit_LabelsAndTexts, roomEdit_DoneButton);
			roomEdit_Page.setSpacing(5);
			roomEdit_Page.setAlignment(Pos.TOP_CENTER);
			roomEdit_Page.setStyle("-fx-background-color: #ffffff;");
			roomEdit_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene roomEdit_Scene = new Scene(roomEdit_Page, 900, 400);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label sessionEdit_TitleLabel = new Label("Boston Code Camp Desktop Application");
			sessionEdit_TitleLabel.setStyle("-fx-font: 24 arial;");
			sessionEdit_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator sessionEdit_Separator = new Separator(Orientation.HORIZONTAL);

			Button sessionEdit_DoneButton = new Button("Done");
			Button sessionEdit_HomeButton = new Button("Home");

			ListView<listItem> sessionEdit_List = new ListView<>(sessionList);
			sessionEdit_List.setCellFactory(param -> new ListCell<listItem>() {
				@Override
				protected void updateItem(listItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getItem() == null) {
						setText(null);
					} else {
						setText(item.getItem());
					}
				}
			});

			sessionEdit_List.setEditable(false);
			sessionEdit_List.setMouseTransparent(true);
			sessionEdit_List.setFocusTraversable(false);

			Label sessionEdit_NameLabel = new Label("Name");
			Label sessionEdit_Title = new Label("Edit Session");
			sessionEdit_Title.setFont(new Font("Arial", 48));

			TextField sessionEdit_NameText = new TextField();
			HBox sessionEdit_LabelsAndTexts = new HBox(sessionEdit_NameLabel, sessionEdit_NameText);
			sessionEdit_LabelsAndTexts.setSpacing(5);
			sessionEdit_LabelsAndTexts.setAlignment(Pos.CENTER);
			VBox sessionEdit_Page = new VBox(sessionEdit_TitleLabel, sessionEdit_HomeButton, sessionEdit_Separator,
					sessionEdit_Title, sessionEdit_List, sessionEdit_LabelsAndTexts, sessionEdit_DoneButton);
			sessionEdit_Page.setSpacing(5);
			sessionEdit_Page.setAlignment(Pos.TOP_CENTER);
			sessionEdit_Page.setStyle("-fx-background-color: #ffffff;");
			sessionEdit_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene sessionEdit_Scene = new Scene(sessionEdit_Page, 900, 400);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			timeSlotAdd.setOnAction(e -> window.setScene(timeSlotAdd_Scene));
			speakerAdd.setOnAction(e -> window.setScene(speakerAdd_Scene));
			roomAdd.setOnAction(e -> window.setScene(roomAdd_Scene));
			sessionAdd.setOnAction(e -> window.setScene(sessionAdd_Scene));

			timeSlotEdit.setOnAction(e -> window.setScene(timeSlotEdit_Scene));
			speakerEdit.setOnAction(e -> window.setScene(speakerEdit_Scene));
			roomEdit.setOnAction(e -> window.setScene(roomEdit_Scene));
			sessionEdit.setOnAction(e -> window.setScene(sessionEdit_Scene));

			home.setOnAction(e -> window.setScene(sceneHome));
			roomAdd_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			sessionAdd_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			speakerAdd_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			timeSlotAdd_HomeButton.setOnAction(e -> window.setScene(sceneHome));

			roomEdit_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			sessionEdit_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			speakerEdit_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			timeSlotEdit_HomeButton.setOnAction(e -> window.setScene(sceneHome));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public class roomCap {
		private String roomName;
		private int roomCapacity;

		public roomCap() {
			this.roomName = "";
			this.roomCapacity = 0;
		}

		public roomCap(String roomName, int roomCapacity) {
			this.roomName = roomName;
			this.roomCapacity = roomCapacity;
		}

		public String getRoomName() {
			return roomName;
		}

		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}

		public int getRoomCapacity() {
			return roomCapacity;
		}

		public void setRoomCapacity(int roomCapacity) {
			this.roomCapacity = roomCapacity;
		}
	}

	public ObservableList<roomCap> getRoomAndCapacity() {
		ObservableList<roomCap> roomsAndCapacities = FXCollections.observableArrayList();
		roomsAndCapacities.add(new roomCap("Red 517", 76));
		roomsAndCapacities.add(new roomCap("White 121", 50));
		roomsAndCapacities.add(new roomCap("Dawny 211", 32));
		roomsAndCapacities.add(new roomCap("Crabs 12", 200));

		return roomsAndCapacities;
	}

	public class speakerPerson {
		private String firstName;
		private String lastName;
		private String email;

		public speakerPerson() {
			this.firstName = "";
			this.lastName = "";
			this.email = "";
		}

		public speakerPerson(String firstName, String lastName, String email) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}

	public ObservableList<speakerPerson> getSpeakers() {
		ObservableList<speakerPerson> speakers = FXCollections.observableArrayList();
		speakers.add(new speakerPerson("John", "Fawkner", "fawknerj@gmail.com"));
		speakers.add(new speakerPerson("John", "Fawkner", "fawknerj@gmail.com"));
		speakers.add(new speakerPerson("John", "Fawkner", "fawknerj@gmail.com"));
		speakers.add(new speakerPerson("John", "Fawkner", "fawknerj@gmail.com"));

		return speakers;
	}

	public static class listItem {
		private final String item;

		public listItem(String item) {
			this.item = item;
		}

		public String getItem() {
			return item;
		}
	}
}