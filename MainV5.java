

import java.lang.reflect.Array;
import java.util.ArrayList;

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
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainV5 extends Application implements EventHandler<ActionEvent> {
	Timeslot emptyTimeSlot = new Timeslot();
	Speaker emptySpeaker = new Speaker();
	Room emptyRoom = new Room();
	Session emptySession = new Session();
	ArrayList<DB_Object> nullTimeslot = IFront.addToList(emptyTimeSlot);
	ArrayList<DB_Object> nullSpeaker = IFront.addToList(emptySpeaker);
	ArrayList<DB_Object> nullRoom = IFront.addToList(emptyRoom);
	ArrayList<DB_Object> nullSession = IFront.addToList(emptySession);

	Stage window;
	Label mainTitleLabel = labelMaker("Boston Code Camp Desktop Application");
	String styleSet = "-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
			+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;";
	String backgroundColor = "-fx-background-color: #ffffff;";
	String[] stringHours = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24" };
	String[] stringMinutes = { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" };
	Integer[] hours = { 00, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
	Integer[] minutes = { 00, 05, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 };

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	public void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		try {
			Label title = mainTitleLabel;
			title.setStyle("-fx-font: 24 arial;");
			title.setAlignment(Pos.TOP_CENTER);
			Separator separator = new Separator(Orientation.HORIZONTAL);

			ListView<DB_Object> timeSlot_List = new ListView<>(getTimeSlotItems(nullTimeslot));
			timeSlot_List.setCellFactory(param -> new ListCell<DB_Object>() {
				protected void updateItem(DB_Object item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getClass().toString() == null) {
						setText(null);
					} else {
						setText(item.getClass().toString());
					}
				}
			});

			final Button timeSlot_Remove = buttonMaker("Remove");
			timeSlot_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int timeSlot_RemoveIndex = timeSlot_List.getSelectionModel().getSelectedIndex();
					if (timeSlot_RemoveIndex != -1) {
						DB_Object timeSlot_ItemToRemove = timeSlot_List.getSelectionModel().getSelectedItem();

						final int timeSlot_RemoveNewIndex = (timeSlot_RemoveIndex == timeSlot_List.getItems().size()
								- 1) ? timeSlot_RemoveIndex - 1 : timeSlot_RemoveIndex;

						timeSlot_List.getItems().remove(timeSlot_RemoveIndex);
						timeSlot_List.getSelectionModel().select(timeSlot_RemoveNewIndex);
					}
				}
			});

			ListView<DB_Object> speaker_List = new ListView<>(getSpeakers(nullSpeaker));
			speaker_List.setCellFactory(param -> new ListCell<DB_Object>() {
				@Override
				protected void updateItem(DB_Object item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getClass().toString() == null) {
						setText(null);
					} else {
						setText(item.getClass().toString());
					}
				}
			});
			final Button speaker_Remove = buttonMaker("Remove");
			speaker_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int speaker_RemoveIndex = speaker_List.getSelectionModel().getSelectedIndex();
					if (speaker_RemoveIndex != -1) {
						DB_Object speaker_ItemToRemove = speaker_List.getSelectionModel().getSelectedItem();

						final int speaker_RemoveNewIndex = (speaker_RemoveIndex == speaker_List.getItems().size() - 1)
								? speaker_RemoveIndex - 1
								: speaker_RemoveIndex;

						speaker_List.getItems().remove(speaker_RemoveIndex);
						speaker_List.getSelectionModel().select(speaker_RemoveNewIndex);
					}
				}
			});

			ListView<DB_Object> room_List = new ListView<>(getRoomAndCapacity(nullRoom));
			room_List.setItems(getRoomAndCapacity(IFront.addToList(new Room())));
			room_List.setCellFactory(param -> new ListCell<DB_Object>() {
				@Override
				protected void updateItem(DB_Object item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.toString() == null) {
						setText(null);
					} else {
						setText(item.getClass().toString());
					}
				}
			});

			final Button room_Remove = buttonMaker("Remove");
			room_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int room_RemoveIndex = room_List.getSelectionModel().getSelectedIndex();
					if (room_RemoveIndex != -1) {
						DB_Object room_ItemToRemove = room_List.getSelectionModel().getSelectedItem();

						final int room_RemoveNewIndex = (room_RemoveIndex == room_List.getItems().size() - 1)
								? room_RemoveIndex - 1
								: room_RemoveIndex;

						room_List.getItems().remove(room_RemoveIndex);
						room_List.getSelectionModel().select(room_RemoveNewIndex);
					}
				}
			});

			ListView<DB_Object> session_List = new ListView<>(getSessions(nullSpeaker));
			session_List.setCellFactory(param -> new ListCell<DB_Object>() {
				@Override
				protected void updateItem(DB_Object item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getClass().toString() == null) {
						setText(null);
					} else {
						setText(item.getClass().toString());
					}
				}
			});

			final Button session_Remove = buttonMaker("Remove");
			session_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int session_RemoveIndex = session_List.getSelectionModel().getSelectedIndex();
					if (session_RemoveIndex != -1) {
						DB_Object session_ItemToRemove = session_List.getSelectionModel().getSelectedItem();

						final int session_RemoveNewIndex = (session_RemoveIndex == session_List.getItems().size() - 1)
								? session_RemoveIndex - 1
								: session_RemoveIndex;

						session_List.getItems().remove(session_RemoveIndex);
						session_List.getSelectionModel().select(session_RemoveNewIndex);
					}
				}
			});

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Button timeSlotAdd = buttonMaker("Add");
			Button timeSlotEdit = buttonMaker("Edit");
			HBox timeSlotButtons = new HBox(timeSlotAdd, timeSlotEdit);
			timeSlotButtons.setSpacing(5);
			timeSlotButtons.setAlignment(Pos.BOTTOM_CENTER);
			Label labelTimeSlot = labelMaker("Time Slot");
			labelTimeSlot.setStyle("-fx-font: 36 arial;");
			VBox timeSlot = new VBox(labelTimeSlot, timeSlot_List, timeSlotButtons, timeSlot_Remove);
			timeSlot.setAlignment(Pos.CENTER);
			timeSlot.setSpacing(10);
			timeSlot.setStyle(styleSet);

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Button speakerAdd = buttonMaker("Add");
			Button speakerEdit = buttonMaker("Edit");
			HBox speakerButtons = new HBox(speakerAdd, speakerEdit);
			speakerButtons.setSpacing(5);
			speakerButtons.setAlignment(Pos.BOTTOM_CENTER);
			Label labelSpeaker = labelMaker("Speaker");
			labelSpeaker.setStyle("-fx-font: 36 arial;");
			VBox speaker = new VBox(labelSpeaker, speaker_List, speakerButtons, speaker_Remove);
			speaker.setAlignment(Pos.CENTER);
			speaker.setSpacing(10);
			speaker.setStyle(styleSet);

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Button roomAdd = buttonMaker("Add");
			Button roomEdit = buttonMaker("Edit");
			HBox roomButtons = new HBox(roomAdd, roomEdit);
			roomButtons.setSpacing(5);
			roomButtons.setAlignment(Pos.BOTTOM_CENTER);
			Label labelRoom = labelMaker("Room");
			labelRoom.setStyle("-fx-font: 36 arial;");
			VBox room = new VBox(labelRoom, room_List, roomButtons, room_Remove);
			room.setAlignment(Pos.CENTER);
			room.setSpacing(10);
			room.setStyle(styleSet);

			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Button sessionAdd = buttonMaker("Add");
			Button sessionEdit = buttonMaker("Edit");
			HBox sessionButtons = new HBox(sessionAdd, sessionEdit);
			sessionButtons.setSpacing(5);
			sessionButtons.setAlignment(Pos.BOTTOM_CENTER);
			Label labelSession = labelMaker("Session");
			labelSession.setStyle("-fx-font: 36 arial;");
			VBox session = new VBox(labelSession, session_List, sessionButtons, session_Remove);
			session.setAlignment(Pos.CENTER);
			session.setSpacing(10);
			session.setStyle(styleSet);

			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Button home = buttonMaker("Home");
			HBox homeOption = new HBox(timeSlot, speaker, room, session);
			VBox homePage = new VBox(title, home, separator, homeOption);
			homePage.setSpacing(5);
			homePage.setAlignment(Pos.TOP_CENTER);
			homePage.setStyle(backgroundColor);
			Scene sceneHome = new Scene(homePage, 900, 400);
			// sceneHome.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setMinHeight(sceneHome.getHeight());
			window.setMinWidth(sceneHome.getWidth());
			window.show();
			window.setScene(sceneHome);
			window.setTitle("Software Engineering Desktop Application");

			// -Time Slot
			// Page-//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label timeSlotAdd_TitleLabel = mainTitleLabel;
			timeSlotAdd_TitleLabel.setStyle("-fx-font: 24 arial;");
			timeSlotAdd_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator timeSlotAdd_Separator = new Separator(Orientation.HORIZONTAL);

			Button timeSlotAdd_AddButton = buttonMaker("Add");
			Button timeSlotAdd_HomeButton = buttonMaker("Home");

			ListView<DB_Object> timeSlotAdd_List = new ListView<>(getTimeSlotItems(nullTimeslot));
			timeSlotAdd_List.setCellFactory(param -> new ListCell<DB_Object>() {
				protected void updateItem(DB_Object item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getClass().toString() == null) {
						setText(null);
					} else {
						setText(item.getClass().toString());
					}
				}
			});

			Label timeSlotAdd_Title = labelMaker("Add Time Slot");
			Label timeSlotAdd_StartTime = labelMaker("Start Time");
			Label timeSlotAdd_EndTime = labelMaker("End Time");
			Label timeSlotAdd_Duration = labelMaker("Duration");
			timeSlotAdd_Title.setFont(new Font("Arial", 48));

			ComboBox<String> timeSlotAdd_StartHour = new ComboBox<String>();
			timeSlotAdd_StartHour.getItems().addAll(stringHours);
			ComboBox<String> timeSlotAdd_StartMinute = new ComboBox<String>();
			timeSlotAdd_StartMinute.getItems().addAll(stringMinutes);
			ComboBox<String> timeSlotAdd_EndHour = new ComboBox<String>();
			timeSlotAdd_EndHour.getItems().addAll(stringHours);
			ComboBox<String> timeSlotAdd_EndMinute = new ComboBox<String>();
			timeSlotAdd_EndMinute.getItems().addAll(stringMinutes);

			ComboBox<String> timeSlotAdd_DurationComboBox = new ComboBox<String>();

			HBox timeSlotAdd_StartComboBox = new HBox(timeSlotAdd_StartHour, timeSlotAdd_StartMinute);
			timeSlotAdd_StartComboBox.setSpacing(5);
			timeSlotAdd_StartComboBox.setAlignment(Pos.CENTER);

			HBox timeSlotAdd_EndComboBox = new HBox(timeSlotAdd_EndHour, timeSlotAdd_EndMinute);
			timeSlotAdd_EndComboBox.setSpacing(5);
			timeSlotAdd_EndComboBox.setAlignment(Pos.CENTER);

			VBox timeSlotAddDuration = new VBox(timeSlotAdd_Duration, timeSlotAdd_DurationComboBox);
			timeSlotAddDuration.setSpacing(5);
			timeSlotAddDuration.setAlignment(Pos.CENTER);

			VBox timeSlotAdd_StartTimeInput = new VBox(timeSlotAdd_StartTime, timeSlotAdd_StartComboBox);
			timeSlotAdd_StartTimeInput.setSpacing(5);
			timeSlotAdd_StartTimeInput.setAlignment(Pos.CENTER);

			VBox timeSlotAdd_EndTimeInput = new VBox(timeSlotAdd_EndTime, timeSlotAdd_EndComboBox);
			timeSlotAdd_EndTimeInput.setSpacing(5);
			timeSlotAdd_EndTimeInput.setAlignment(Pos.CENTER);

			HBox timeSlotAdd_AllInputs = new HBox(timeSlotAdd_StartTimeInput, timeSlotAddDuration,
					timeSlotAdd_EndTimeInput);
			timeSlotAdd_AllInputs.setSpacing(5);
			timeSlotAdd_AllInputs.setAlignment(Pos.CENTER);

			VBox timeSlotAdd_Page = new VBox(timeSlotAdd_TitleLabel, timeSlotAdd_HomeButton, timeSlotAdd_Separator,
					timeSlotAdd_Title, timeSlotAdd_List, timeSlotAdd_AllInputs, timeSlotAdd_AddButton);
			timeSlotAdd_Page.setSpacing(5);
			timeSlotAdd_Page.setAlignment(Pos.TOP_CENTER);
			timeSlotAdd_Page.setStyle(backgroundColor);
			timeSlotAdd_Page.setStyle(styleSet);

			timeSlotAdd_AddButton.setOnAction(e -> {
				int timeSlotStartHour = Integer.parseInt(timeSlotAdd_StartHour.getValue());
				int timeSlotStartMinute = Integer.parseInt(timeSlotAdd_StartMinute.getValue());
				int timeSlotEndHour = Integer.parseInt(timeSlotAdd_EndHour.getValue());
				int timeSlotEndMinute = Integer.parseInt(timeSlotAdd_EndMinute.getValue());
				Timeslot temp = new Timeslot(-1, timeSlotStartHour, timeSlotStartMinute, timeSlotEndHour,
						timeSlotEndMinute);
				ArrayList<DB_Object> toAdd = IFront.addToList(temp);
				timeSlotAdd_List.setItems(getTimeSlotItems(toAdd));

			});

			Scene timeSlotAdd_Scene = new Scene(timeSlotAdd_Page, 900, 400);

			// -Speaker
			// Page-//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/////SHOULD WORK MAYBE/////
			
			Label speakerAdd_TitleLabel = mainTitleLabel;
			speakerAdd_TitleLabel.setStyle("-fx-font: 24 arial;");
			speakerAdd_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator speakerAdd_Separator = new Separator(Orientation.HORIZONTAL);

			Button speakerAdd_AddButton = buttonMaker("Add");
			Button speakerAdd_HomeButton = buttonMaker("Home");

			TableView<DB_Object> speakerAdd_Table = new TableView<>();
			speakerAdd_Table.setEditable(true);

			TableColumn<DB_Object, String> speakerAdd_FirstNameColumn = new TableColumn<>("First Name");
			speakerAdd_FirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("speakerFName"));
			TableColumn<DB_Object, String> speakerAdd_LastNameColumn = new TableColumn<>("Last Name");
			speakerAdd_LastNameColumn.setCellValueFactory(new PropertyValueFactory<>("speakerLName"));
			TableColumn<DB_Object, String> speakerAdd_EmailColumn = new TableColumn<>("Email");
			speakerAdd_EmailColumn.setCellValueFactory(new PropertyValueFactory<>("speakerEmail"));

			speakerAdd_Table.setItems(getSpeakers(nullSpeaker));

			speakerAdd_Table.getColumns().addAll(speakerAdd_FirstNameColumn, speakerAdd_LastNameColumn, speakerAdd_EmailColumn);
			speakerAdd_Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			Label speakerAdd_Title = labelMaker("Speaker Information");
			Label speakerAdd_FirstName = labelMaker("First Name");
			Label speakerAdd_LastName = labelMaker("Last Name");
			Label speakerAdd_Phone = labelMaker("Email");
			speakerAdd_Title.setFont(new Font("Arial", 48));

			TextField speakerAdd_FirstNameText = new TextField();
			TextField speakerAdd_LastNameText = new TextField();
			TextField speakerAdd_EmailText = new TextField();

			VBox speakerAdd_Labels = new VBox(speakerAdd_FirstName, speakerAdd_LastName, speakerAdd_Phone);
			speakerAdd_Labels.setSpacing(15);
			speakerAdd_Labels.setAlignment(Pos.CENTER_RIGHT);

			VBox speakerAdd_Texts = new VBox(speakerAdd_FirstNameText, speakerAdd_LastNameText, speakerAdd_EmailText);
			speakerAdd_Texts.setSpacing(5);
			speakerAdd_Texts.setAlignment(Pos.CENTER);

			HBox speakerAdd_LabelsAndTexts = new HBox(speakerAdd_Labels, speakerAdd_Texts);
			speakerAdd_LabelsAndTexts.setSpacing(5);
			speakerAdd_LabelsAndTexts.setAlignment(Pos.CENTER);

			VBox speakerAdd_Page = new VBox(speakerAdd_TitleLabel, speakerAdd_HomeButton, speakerAdd_Separator,
					speakerAdd_Title, speakerAdd_Table, speakerAdd_LabelsAndTexts, speakerAdd_AddButton);
			speakerAdd_Page.setSpacing(5);
			speakerAdd_Page.setAlignment(Pos.TOP_CENTER);
			speakerAdd_Page.setStyle(backgroundColor);
			speakerAdd_Page.setStyle(styleSet);

			speakerAdd_AddButton.setOnAction(e -> {
				String inputSpeakerAdd_FirstName = speakerAdd_FirstNameText.getText();
				String inputSpeakerAdd_LastName = speakerAdd_LastNameText.getText();
				String inputSpeakerAdd_Email = speakerAdd_EmailText.getText();
				Speaker temp = new Speaker(-1, inputSpeakerAdd_FirstName, inputSpeakerAdd_LastName,
						inputSpeakerAdd_Email);
				ArrayList<DB_Object> toAdd = IFront.addToList(temp);
				speakerAdd_Table.setItems(getSpeakers(toAdd));

			});

			Scene speakerAdd_Scene = new Scene(speakerAdd_Page, 900, 400);
		
			// -Room
			// Page-//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label roomAdd_TitleLabel = mainTitleLabel;
			roomAdd_TitleLabel.setStyle("-fx-font: 24 arial;");
			roomAdd_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator roomAdd_Separator = new Separator(Orientation.HORIZONTAL);

			TableView<DB_Object> roomAdd_Table = new TableView<>();
			roomAdd_Table.setEditable(false);

			TableColumn<DB_Object, String> roomAdd_NameColumn = new TableColumn<>("Name");
			roomAdd_NameColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));
			TableColumn<DB_Object, Integer> roomAdd_CapacityColumn = new TableColumn<>("Capacity");
			roomAdd_CapacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));

			roomAdd_Table.setItems(getRoomAndCapacity(nullRoom));

			roomAdd_Table.getColumns().addAll(roomAdd_NameColumn, roomAdd_CapacityColumn);
			roomAdd_Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			Button roomAdd_AddButton = buttonMaker("Add");
			Button roomAdd_HomeButton = buttonMaker("Home");

			Label roomAdd_NameLabel = labelMaker("Name");
			Label roomAdd_CapacityLabel = labelMaker("Capacity");
			Label roomAdd_Title = labelMaker("Add Room");
			roomAdd_Title.setFont(new Font("Arial", 48));

			TextField roomAdd_NameText = new TextField();
			TextField roomAdd_CapacityText = new TextField();

			roomAdd_AddButton.setOnAction(e -> {
				String inputRoomName = roomAdd_NameText.getText();
				String inputRoomCapacity = roomAdd_NameText.getText();
				if (inputRoomName == "" || inputRoomCapacity == null) {
					// Want to call addToList with null in order to get every entry from database
					// back
					roomAdd_Table.setItems(getRoomAndCapacity(nullRoom));
				} else {
					// Would call addToList to add a new entry to the database
					Room temp = new Room(-1, inputRoomName, inputRoomCapacity);
					ArrayList<DB_Object> toAdd = IFront.addToList(temp);
					roomAdd_Table.setItems(getRoomAndCapacity(toAdd));
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
			roomAdd_Page.setStyle(backgroundColor);
			roomAdd_Page.setStyle(styleSet);

			Scene roomAdd_Scene = new Scene(roomAdd_Page, 900, 400);

			// -Session
			// Page-//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label sessionAdd_TitleLabel = mainTitleLabel;
			sessionAdd_TitleLabel.setStyle("-fx-font: 24 arial;");
			sessionAdd_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator sessionAdd_Separator = new Separator(Orientation.HORIZONTAL);

			Button sessionAdd_AddButton = buttonMaker("Add");
			Button sessionAdd_HomeButton = buttonMaker("Home");

			ListView<DB_Object> sessionAdd_List = new ListView<>(getSessions(nullSession));
			sessionAdd_List.setCellFactory(param -> new ListCell<DB_Object>() {
				protected void updateItem(DB_Object item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getClass().toString() == null) {
						setText(null);
					} else {
						setText(item.getClass().toString());
					}
				}
			});

			// !!!ADD DROP DOWN MENUS FOR SPEAKER, ROOM, TIME SLOT
			Label sessionAdd_NameLabel = labelMaker("Name");
			Label sessionAdd_SpeakerLabel = labelMaker("Speaker");
			Label sessionAdd_RoomLabel = labelMaker("Room");
			Label sessionAdd_TimeSlotLabel = labelMaker("Time Slot");
			Label sessionAdd_Title = labelMaker("Add Session");
			sessionAdd_Title.setFont(new Font("Arial", 48));

			TextField sessionAdd_NameText = new TextField();

			ComboBox<String> sessionAdd_TimeSlotCombo = new ComboBox<String>();
			for (DB_Object ts : getTimeSlotItems(nullTimeslot)) {
				sessionAdd_TimeSlotCombo.getItems().add(ts.getClass().toString());
			}

			ComboBox<String> sessionAdd_SpeakerCombo = new ComboBox<String>();
			for (DB_Object s : getSpeakers(nullSpeaker)) {
				sessionAdd_SpeakerCombo.getItems().add(s.getClass().toString());
			}

			ComboBox<String> sessionAdd_RoomCombo = new ComboBox<String>();
			for (DB_Object r : getRoomAndCapacity(nullRoom)) {
				sessionAdd_RoomCombo.getItems().add(r.getClass().toString());
			}

			sessionAdd_AddButton.setOnAction(e -> {
				String inputSessionName = sessionAdd_NameText.getText();
				String inputSessionTimeSlot = sessionAdd_TimeSlotCombo.getValue();
				String inputSessionSpeaker = sessionAdd_SpeakerCombo.getValue();
				String inputSessionRoom = sessionAdd_RoomCombo.getValue();
				if(inputSessionName == "" && inputSessionTimeSlot == null && inputSessionRoom == "" && inputSessionSpeaker == ""){
					sessionAdd_List.setItems(getSessions(nullSession));
				}
				else{
					DB_Object tempTimeslot = findObject(nullTimeslot, inputSessionTimeSlot);
					DB_Object tempSpeaker = findObject(nullSpeaker, inputSessionTimeSlot);
					DB_Object tempRoom = findObject(nullRoom, inputSessionTimeSlot);
					ArrayList<DB_Object> temp = IFront.addToList(new Session(-1, inputSessionName, tempTimeslot, tempSpeaker, tempRoom));
					sessionAdd_List.setItems(getSessions(temp));
				}

			});

			HBox sessionAdd_LabelsAndTexts = new HBox(sessionAdd_NameLabel, sessionAdd_NameText,
					sessionAdd_TimeSlotLabel, sessionAdd_TimeSlotCombo, sessionAdd_SpeakerLabel,
					sessionAdd_SpeakerCombo, sessionAdd_RoomLabel, sessionAdd_RoomCombo);
			sessionAdd_LabelsAndTexts.setSpacing(5);
			sessionAdd_LabelsAndTexts.setAlignment(Pos.CENTER);

			VBox sessionAdd_Page = new VBox(sessionAdd_TitleLabel, sessionAdd_HomeButton, sessionAdd_Separator,
					sessionAdd_Title, sessionAdd_List, sessionAdd_LabelsAndTexts, sessionAdd_AddButton);
			sessionAdd_Page.setSpacing(5);
			sessionAdd_Page.setAlignment(Pos.TOP_CENTER);
			sessionAdd_Page.setStyle(backgroundColor);
			sessionAdd_Page.setStyle(styleSet);

			Scene sessionAdd_Scene = new Scene(sessionAdd_Page, 900, 400);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
			Label timeSlotEdit_TitleLabel = mainTitleLabel;
			timeSlotEdit_TitleLabel.setStyle("-fx-font: 24 arial;");
			timeSlotEdit_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator timeSlotEdit_Separator = new Separator(Orientation.HORIZONTAL);

			Button timeSlotEdit_DoneButton = buttonMaker("Done");
			Button timeSlotEdit_HomeButton = buttonMaker("Home");

			ListView<Object> timeSlotEdit_List = new ListView<>(getTimeSlotItems());
			timeSlotEdit_List.setCellFactory(param -> new ListCell<Object>() {

				protected void updateItem(timeSlotItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getTime() == null) {
						setText(null);
					} else {
						setText(item.getTime());
					}
				}
			});
			timeSlotEdit_List.setEditable(false);
			timeSlotEdit_List.setMouseTransparent(true);
			timeSlotEdit_List.setFocusTraversable(false);

			Label timeSlotEdit_Title = labelMaker("Edit Time Slot");
			Label timeSlotEdit_StartTime = labelMaker("Start Time");
			Label timeSlotEdit_EndTime = labelMaker("End Time");
			Label timeSlotEdit_Duration = labelMaker("Duration");
			timeSlotEdit_Title.setFont(new Font("Arial", 48));

			ComboBox<Integer> timeSlotEdit_StartHour = new ComboBox<Integer>();
			timeSlotEdit_StartHour.getItems().addAll(hours);
			ComboBox<Integer> timeSlotEdit_StartMinute = new ComboBox<Integer>();
			timeSlotEdit_StartMinute.getItems().addAll(minutes);
			ComboBox<Integer> timeSlotEdit_EndHour = new ComboBox<Integer>();
			timeSlotEdit_EndHour.getItems().addAll(hours);
			ComboBox<Integer> timeSlotEdit_EndMinute = new ComboBox<Integer>();
			timeSlotEdit_EndMinute.getItems().addAll(minutes);

			ComboBox<Integer> timeSlotEdit_DurationComboBox = new ComboBox<Integer>();

			// start hbox
			HBox timeSlotEdit_StartComboBox = new HBox(timeSlotEdit_StartHour, timeSlotEdit_StartMinute);
			timeSlotEdit_StartComboBox.setSpacing(5);
			timeSlotEdit_StartComboBox.setAlignment(Pos.CENTER);
			// end hbox
			HBox timeSlotEdit_EndComboBox = new HBox(timeSlotEdit_EndHour, timeSlotEdit_EndMinute);
			timeSlotEdit_EndComboBox.setSpacing(5);
			timeSlotEdit_EndComboBox.setAlignment(Pos.CENTER);

			// not centered please help
			VBox timeSlotEditDuration = new VBox(timeSlotEdit_Duration, timeSlotEdit_DurationComboBox);
			timeSlotEditDuration.setSpacing(5);
			timeSlotEditDuration.setAlignment(Pos.CENTER);

			VBox timeSlotEdit_StartTimeInput = new VBox(timeSlotEdit_StartTime, timeSlotEdit_StartComboBox);
			timeSlotEdit_StartTimeInput.setSpacing(5);
			timeSlotEdit_StartTimeInput.setAlignment(Pos.CENTER);

			VBox timeSlotEdit_EndTimeInput = new VBox(timeSlotEdit_EndTime, timeSlotEdit_EndComboBox);
			timeSlotEdit_EndTimeInput.setSpacing(5);
			timeSlotEdit_EndTimeInput.setAlignment(Pos.CENTER);

			HBox timeSlotEdit_AllInputs = new HBox(timeSlotEdit_StartTimeInput, timeSlotEditDuration,
					timeSlotEdit_EndTimeInput);
			timeSlotEdit_AllInputs.setSpacing(5);
			timeSlotEdit_AllInputs.setAlignment(Pos.CENTER);

			VBox timeSlotEdit_Page = new VBox(timeSlotEdit_TitleLabel, timeSlotEdit_HomeButton, timeSlotEdit_Separator,
					timeSlotEdit_Title, timeSlotEdit_List, timeSlotEdit_AllInputs, timeSlotEdit_DoneButton);
			timeSlotEdit_Page.setSpacing(5);
			timeSlotEdit_Page.setAlignment(Pos.TOP_CENTER);
			timeSlotEdit_Page.setStyle(backgroundColor);
			timeSlotEdit_Page.setStyle(styleSet);

			Scene timeSlotEdit_Scene = new Scene(timeSlotEdit_Page, 900, 400);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label speakerEdit_TitleLabel = mainTitleLabel;
			speakerEdit_TitleLabel.setStyle("-fx-font: 24 arial;");
			speakerEdit_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator speakerEdit_Separator = new Separator(Orientation.HORIZONTAL);

			Button speakerEdit_DoneButton = buttonMaker("Done");
			Button speakerEdit_HomeButton = buttonMaker("Home");

			TableView<Speaker> speakerEdit_Table = new TableView<>();
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
			Label speakerEdit_Title = labelMaker("Speaker Information");
			Label speakerEdit_FirstName = labelMaker("First Name");
			Label speakerEdit_LastName = labelMaker("Last Name");
			Label speakerEdit_Email = labelMaker("Email");
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
			speakerEdit_Page.setStyle(backgroundColor);
			speakerEdit_Page.setStyle(styleSet);

			Scene speakerEdit_Scene = new Scene(speakerEdit_Page, 900, 400);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label roomEdit_TitleLabel = mainTitleLabel;
			roomEdit_TitleLabel.setStyle("-fx-font: 24 arial;");
			roomEdit_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator roomEdit_Separator = new Separator(Orientation.HORIZONTAL);

			TableView<roomCap> roomEdit_Table = new TableView<>();
			roomEdit_Table.setEditable(true);

			TableColumn<Room, String> roomEdit_Name = new TableColumn<Room, String>("Name");
			roomEdit_Name.setCellValueFactory(new PropertyValueFactory<>("roomName"));
			TableColumn<Room, String> roomEdit_Capacity = new TableColumn("Capacity");
			roomEdit_Capacity.setCellValueFactory(new PropertyValueFactory<>("roomCapacity"));

			roomEdit_Table.setItems(getRoomAndCapacity());

			roomEdit_Table.getColumns().addAll(roomEdit_Name, roomEdit_Capacity);
			roomEdit_Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			// good
			Button roomEdit_DoneButton = buttonMaker("Done");
			Button roomEdit_HomeButton = buttonMaker("Home");
			// good
			Label roomEdit_NameLabel = labelMaker("Name");
			Label roomEdit_CapacityLabel = labelMaker("Capacity");
			Label roomEdit_Title = labelMaker("Edit Room");
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
			roomEdit_Page.setStyle(backgroundColor);
			roomEdit_Page.setStyle(styleSet);

			Scene roomEdit_Scene = new Scene(roomEdit_Page, 900, 400);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label sessionEdit_TitleLabel = mainTitleLabel;
			sessionEdit_TitleLabel.setStyle("-fx-font: 24 arial;");
			sessionEdit_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator sessionEdit_Separator = new Separator(Orientation.HORIZONTAL);

			Button sessionEdit_DoneButton = buttonMaker("Done");
			Button sessionEdit_HomeButton = buttonMaker("Home");

			ListView<sessionItem> sessionEdit_List = new ListView<>(getSessions());
			sessionEdit_List.setCellFactory(param -> new ListCell<sessionItem>() {
				@Override
				protected void updateItem(sessionItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getName() == null) {
						setText(null);
					} else {
						setText(item.getName());
					}
				}
			});

			sessionEdit_List.setEditable(false);
			sessionEdit_List.setMouseTransparent(true);
			sessionEdit_List.setFocusTraversable(false);

			Label sessionEdit_NameLabel = labelMaker("Name");
			Label sessionEdit_Title = labelMaker("Edit Session");
			sessionEdit_Title.setFont(new Font("Arial", 48));

			TextField sessionEdit_NameText = new TextField();

			ComboBox<String> sessionEdit_TimeSlotCombo = new ComboBox<String>(); // integer
			for (timeSlotItem ts : getTimeSlotItems()) {
				sessionEdit_TimeSlotCombo.getItems().add(ts.getTime());
			}

			ComboBox<String> sessionEdit_SpeakerCombo = new ComboBox<String>();
			for (speakerPerson s : getSpeakers()) {
				sessionEdit_SpeakerCombo.getItems().add(s.getFullName());
			}

			ComboBox<String> sessionEdit_RoomCombo = new ComboBox<String>();
			for (roomCap r : getRoomAndCapacity()) {
				sessionEdit_RoomCombo.getItems().add(r.getRoomName());
			}

			Label sessionEdit_TimeSlotLabel = labelMaker("Time Slot");
			Label sessionEdit_SpeakerLabel = labelMaker("Speaker");
			Label sessionEdit_RoomLabel = labelMaker("Room");

			HBox sessionEdit_LabelsAndTexts = new HBox(sessionEdit_NameLabel, sessionEdit_NameText,
					sessionEdit_TimeSlotLabel, sessionEdit_TimeSlotCombo, sessionEdit_SpeakerLabel,
					sessionEdit_SpeakerCombo, sessionEdit_RoomLabel, sessionEdit_RoomCombo);
			sessionEdit_LabelsAndTexts.setSpacing(5);
			sessionEdit_LabelsAndTexts.setAlignment(Pos.CENTER);

			VBox sessionEdit_Page = new VBox(sessionEdit_TitleLabel, sessionEdit_HomeButton, sessionEdit_Separator,
					sessionEdit_Title, sessionEdit_List, sessionEdit_LabelsAndTexts, sessionEdit_DoneButton);
			sessionEdit_Page.setSpacing(5);
			sessionEdit_Page.setAlignment(Pos.TOP_CENTER);
			sessionEdit_Page.setStyle(backgroundColor);
			sessionEdit_Page.setStyle(styleSet);

			Scene sessionEdit_Scene = new Scene(sessionEdit_Page, 900, 400);
*/
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
			timeSlotAdd.setOnAction(e -> window.setScene(timeSlotAdd_Scene));
			speakerAdd.setOnAction(e -> window.setScene(speakerAdd_Scene));
			roomAdd.setOnAction(e -> window.setScene(roomAdd_Scene));
			sessionAdd.setOnAction(e -> window.setScene(sessionAdd_Scene));

			timeSlotEdit.setOnAction(e -> {
				final int timeSlot_EditIndex = timeSlot_List.getSelectionModel().getSelectedIndex();
				timeSlotEdit_StartHour.setValue(getTimeSlotItems().get(timeSlot_EditIndex).getStartHour());
				timeSlotEdit_StartMinute.setValue(getTimeSlotItems().get(timeSlot_EditIndex).getStartMinute());
				timeSlotEdit_EndHour.setValue(getTimeSlotItems().get(timeSlot_EditIndex).getEndHour());
				timeSlotEdit_EndMinute.setValue(getTimeSlotItems().get(timeSlot_EditIndex).getEndMinute());
				window.setScene(timeSlotEdit_Scene);
			});

			speakerEdit.setOnAction(e -> {
				final int speaker_EditIndex = speaker_List.getSelectionModel().getSelectedIndex();
				speakerEdit_FirstNameText.setText(getSpeakers().get(speaker_EditIndex).getFirstName());
				speakerEdit_LastNameText.setText(getSpeakers().get(speaker_EditIndex).getLastName());
				speakerEdit_EmailText.setText(getSpeakers().get(speaker_EditIndex).getEmail());
				window.setScene(speakerEdit_Scene);
			});
			roomEdit.setOnAction(e -> {
				final int room_EditIndex = room_List.getSelectionModel().getSelectedIndex();
				roomEdit_NameText.setText(getRoomAndCapacity().get(room_EditIndex).getRoomName());
				roomEdit_CapacityText.setText(getRoomAndCapacity().get(room_EditIndex).getRoomCapacity());
				getRoomAndCapacity().get(room_EditIndex);
				window.setScene(roomEdit_Scene);
			});

			sessionEdit.setOnAction(e -> {

				final int session_EditIndex = session_List.getSelectionModel().getSelectedIndex();
				if (session_EditIndex != -1) {
					sessionEdit_NameText.setText(session_List.getItems().get(session_EditIndex).getName());
					sessionEdit_TimeSlotCombo.setValue(getSessions().get(session_EditIndex).getTimeSlot().getTime());
					sessionEdit_SpeakerCombo.setValue(getSessions().get(session_EditIndex).getSpeaker().getFullName());
					sessionEdit_RoomCombo.setValue(getSessions().get(session_EditIndex).getRoom().getRoomName());

				}

				window.setScene(sessionEdit_Scene);
			});

			home.setOnAction(e -> window.setScene(sceneHome));
			roomAdd_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			sessionAdd_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			speakerAdd_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			timeSlotAdd_HomeButton.setOnAction(e -> window.setScene(sceneHome));

			roomEdit_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			sessionEdit_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			speakerEdit_HomeButton.setOnAction(e -> window.setScene(sceneHome));
			timeSlotEdit_HomeButton.setOnAction(e -> window.setScene(sceneHome));
*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ObservableList<DB_Object> getTimeSlotItems(ArrayList<DB_Object> temp) {
		ObservableList<DB_Object> timeSlotList = FXCollections.observableArrayList();
		timeSlotList = addItem(timeSlotList, temp);
		return timeSlotList;
	}

	public ObservableList<DB_Object> getSpeakers(ArrayList<DB_Object> temp) {
		ObservableList<DB_Object> speakers = FXCollections.observableArrayList();
		speakers = addItem(speakers, temp);
		return speakers;
	}

	public ObservableList<DB_Object> getRoomAndCapacity(ArrayList<DB_Object> temp) {
		ObservableList<DB_Object> roomsAndCapacities = FXCollections.observableArrayList();
		roomsAndCapacities = addItem(roomsAndCapacities, temp);
		return roomsAndCapacities;
	}

	public ObservableList<DB_Object> getSessions(ArrayList<DB_Object> temp) {
		ObservableList<DB_Object> sessions = FXCollections.observableArrayList();
		sessions = addItem(sessions, temp);
		return sessions;
	}

	public ObservableList<DB_Object> addItem(ObservableList<DB_Object> viewableList, ArrayList<DB_Object> DBList) {
		viewableList.addAll(DBList);
		return viewableList;
	}

	public DB_Object findObject(ArrayList<DB_Object> DBList, String attribute){
		for(DB_Object index: DBList){
			if(index.getClass().toString() == attribute) {
				return index;
			}
		}
		return null;
	}

	public Label labelMaker(String label) {
		return new Label(label);
	}

	public Button buttonMaker(String buttonName) {
		return new Button(buttonName);
	}

}
