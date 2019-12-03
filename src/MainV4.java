import java.awt.Color;
import java.util.List;

import application.MainV3.roomCap;
import application.MainV3.speakerPerson;
import application.MainV4.timeSlotItem;
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

public class MainV4 extends Application implements EventHandler<ActionEvent> {
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
			Label labelSpeaker = new Label("main.Speaker");
			labelSpeaker.setStyle("-fx-font: 36 arial;");
			Label labelRoom = new Label("main.Room");
			labelRoom.setStyle("-fx-font: 36 arial;");
			Label labelSession = new Label("main.Session");
			labelSession.setStyle("-fx-font: 36 arial;");


			ListView<timeSlotItem> timeSlot_List = new ListView<>(getTimeSlotItems());
			timeSlot_List.setCellFactory(param -> new ListCell<timeSlotItem>() {
				@Override
				protected void updateItem(timeSlotItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getTime() == null) {
						setText(null);
					} else {
						setText(item.getTime());
					}
				}
			});

			final Button timeSlot_Remove = new Button("Remove");
			timeSlot_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int timeSlot_RemoveIndex = timeSlot_List.getSelectionModel().getSelectedIndex();
					if (timeSlot_RemoveIndex != -1) {
						timeSlotItem timeSlot_ItemToRemove = timeSlot_List.getSelectionModel().getSelectedItem();

						final int timeSlot_RemoveNewIndex = (timeSlot_RemoveIndex == timeSlot_List.getItems().size()
								- 1) ? timeSlot_RemoveIndex - 1 : timeSlot_RemoveIndex;

						timeSlot_List.getItems().remove(timeSlot_RemoveIndex);
						timeSlot_List.getSelectionModel().select(timeSlot_RemoveNewIndex);
					}
				}
			});

			ListView<speakerPerson> speaker_List = new ListView<>(getSpeakers());
			speaker_List.setCellFactory(param -> new ListCell<speakerPerson>() {
				@Override
				protected void updateItem(speakerPerson item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getFirstName() == null) {
						setText(null);
					} else {
						setText(item.getFullName());
					}
				}
			});
			final Button speaker_Remove = new Button("Remove");
			speaker_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int speaker_RemoveIndex = speaker_List.getSelectionModel().getSelectedIndex();
					if (speaker_RemoveIndex != -1) {
						speakerPerson speaker_ItemToRemove = speaker_List.getSelectionModel().getSelectedItem();

						final int speaker_RemoveNewIndex = (speaker_RemoveIndex == speaker_List.getItems().size() - 1)
								? speaker_RemoveIndex - 1 : speaker_RemoveIndex;

						speaker_List.getItems().remove(speaker_RemoveIndex);
						speaker_List.getSelectionModel().select(speaker_RemoveNewIndex);
					}
				}
			});

			ListView<roomCap> room_List = new ListView<>(getRoomAndCapacity());
			room_List.setItems(getRoomAndCapacity());
			room_List.setCellFactory(param -> new ListCell<roomCap>() {
				@Override
				protected void updateItem(roomCap item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getRoomName() == null) {
						setText(null);
					} else {
						setText(item.getRoomName());
					}
				}
			});

			final Button room_Remove = new Button("Remove");
			room_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int room_RemoveIndex = room_List.getSelectionModel().getSelectedIndex();
					if (room_RemoveIndex != -1) {
						roomCap room_ItemToRemove = room_List.getSelectionModel().getSelectedItem();

						final int room_RemoveNewIndex = (room_RemoveIndex == room_List.getItems().size() - 1)
								? room_RemoveIndex - 1 : room_RemoveIndex;

						room_List.getItems().remove(room_RemoveIndex);
						room_List.getSelectionModel().select(room_RemoveNewIndex);
					}
				}
			});


			ListView<sessionItem> session_List = new ListView<>(getSessions());
			session_List.setCellFactory(param -> new ListCell<sessionItem>() {
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

			final Button session_Remove = new Button("Remove");
			session_Remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final int session_RemoveIndex = session_List.getSelectionModel().getSelectedIndex();
					if (session_RemoveIndex != -1) {
						sessionItem session_ItemToRemove = session_List.getSelectionModel().getSelectedItem();

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
			// sceneHome.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			window.setMinHeight(sceneHome.getHeight());
			window.setMinWidth(sceneHome.getWidth());
			window.show();
			window.setScene(sceneHome);
			window.setTitle("Software Engineering Desktop Application");

			// -main.Room
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
			Label roomAdd_Title = new Label("Add main.Room");
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

			// HBox roomAdd_LabelsAndTexts = new HBox(roomAdd_Labels,
			// roomAdd_Texts);
			// roomAdd_LabelsAndTexts.setSpacing(5);
			// roomAdd_LabelsAndTexts.setAlignment(Pos.CENTER);

			VBox roomAdd_Page = new VBox(roomAdd_TitleLabel, roomAdd_HomeButton, roomAdd_Separator, roomAdd_Title,
					roomAdd_Table, roomAdd_LabelsAndTexts, roomAdd_AddButton);
			roomAdd_Page.setSpacing(5);
			roomAdd_Page.setAlignment(Pos.TOP_CENTER);
			roomAdd_Page.setStyle("-fx-background-color: #ffffff;");
			roomAdd_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene roomAdd_Scene = new Scene(roomAdd_Page, 900, 400);

			// -main.Session
			// Page-//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Label sessionAdd_TitleLabel = new Label("Boston Code Camp Desktop Application");
			sessionAdd_TitleLabel.setStyle("-fx-font: 24 arial;");
			sessionAdd_TitleLabel.setAlignment(Pos.TOP_CENTER);
			Separator sessionAdd_Separator = new Separator(Orientation.HORIZONTAL);

			Button sessionAdd_AddButton = new Button("Add");
			Button sessionAdd_HomeButton = new Button("Home");

			ListView<sessionItem> sessionAdd_List = new ListView<>(getSessions());
			sessionAdd_List.setCellFactory(param -> new ListCell<sessionItem>() {
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

			// !!!ADD DROP DOWN MENUS FOR SPEAKER, ROOM, TIME SLOT
			Label sessionAdd_NameLabel = new Label("Name");
			Label sessionAdd_SpeakerLabel = new Label("main.Speaker");
			Label sessionAdd_RoomLabel = new Label("main.Room");
			Label sessionAdd_TimeSlotLabel = new Label("Time Slot");
			Label sessionAdd_Title = new Label("Add main.Session");
			sessionAdd_Title.setFont(new Font("Arial", 48));

			TextField sessionAdd_NameText = new TextField();

			ComboBox<String> sessionAdd_TimeSlotCombo = new ComboBox<String>();
	
			for ( timeSlotItem ts : getTimeSlotItems()){
				sessionAdd_TimeSlotCombo.getItems().add(ts.getTime());
			}
			
			ComboBox<String> sessionAdd_SpeakerCombo = new ComboBox<String>();
			for ( speakerPerson s : getSpeakers()){
				sessionAdd_SpeakerCombo.getItems().add(s.getFullName());
			}
						
			ComboBox<String> sessionAdd_RoomCombo = new ComboBox<String>();
			for ( roomCap r : getRoomAndCapacity()){
				sessionAdd_RoomCombo.getItems().add(r.getRoomName());
			}
			

			sessionAdd_AddButton.setOnAction(e -> {
				String inputSessionName = sessionAdd_NameText.getText();
				
				//sessionList.add(new sessionItem(inputSessionName));

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
			sessionAdd_Page.setStyle("-fx-background-color: #ffffff;");
			sessionAdd_Page.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: #999999;");

			Scene sessionAdd_Scene = new Scene(sessionAdd_Page, 900, 400);

			// -main.Speaker
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

			Label speakerAdd_Title = new Label("main.Speaker Information");
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

			ListView<timeSlotItem> timeSlotAdd_List = new ListView<>(getTimeSlotItems());
			timeSlotAdd_List.setCellFactory(param -> new ListCell<timeSlotItem>() {
				@Override
				protected void updateItem(timeSlotItem item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null || item.getTime() == null) {
						setText(null);
					} else {
						setText(item.getTime());
					}
				}
			});

			Label timeSlotAdd_Title = new Label("Add Time Slot");
			Label timeSlotAdd_StartTime = new Label("Start Time");
			Label timeSlotAdd_EndTime = new Label("End Time");
			Label timeSlotAdd_Duration = new Label("Duration");
			timeSlotAdd_Title.setFont(new Font("Arial", 48));

			ComboBox<String> timeSlotAdd_StartHour = new ComboBox<String>();
			timeSlotAdd_StartHour.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
					"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
			ComboBox<String> timeSlotAdd_StartMinute = new ComboBox<String>();
			timeSlotAdd_StartMinute.getItems().addAll("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50",
					"55");
			ComboBox<String> timeSlotAdd_EndHour = new ComboBox<String>();
			timeSlotAdd_EndHour.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
					"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
			ComboBox<String> timeSlotAdd_EndMinute = new ComboBox<String>();
			timeSlotAdd_EndMinute.getItems().addAll("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50",
					"55");

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

			ListView<timeSlotItem> timeSlotEdit_List = new ListView<>(getTimeSlotItems());
			timeSlotEdit_List.setCellFactory(param -> new ListCell<timeSlotItem>() {
				@Override
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

			Label timeSlotEdit_Title = new Label("Edit Time Slot");
			Label timeSlotEdit_StartTime = new Label("Start Time");
			Label timeSlotEdit_EndTime = new Label("End Time");
			Label timeSlotEdit_Duration = new Label("Duration");
			timeSlotEdit_Title.setFont(new Font("Arial", 48));

			ComboBox<Integer> timeSlotEdit_StartHour = new ComboBox<Integer>();
			timeSlotEdit_StartHour.getItems().addAll(00,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
					12, 13,14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
			ComboBox<Integer> timeSlotEdit_StartMinute = new ComboBox<Integer>();
			timeSlotEdit_StartMinute.getItems().addAll(00, 05, 10, 15, 20, 25, 30, 35, 40, 45, 50,
					55);
			ComboBox<Integer> timeSlotEdit_EndHour = new ComboBox<Integer>();
			timeSlotEdit_EndHour.getItems().addAll(00,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
					12, 13,14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
			ComboBox<Integer> timeSlotEdit_EndMinute = new ComboBox<Integer>();
			timeSlotEdit_EndMinute.getItems().addAll(00, 05, 10, 15, 20, 25, 30, 35, 40, 45, 50,
					55);

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
			Label speakerEdit_Title = new Label("main.Speaker Information");
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
			Label roomEdit_Title = new Label("Edit main.Room");
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

			Label sessionEdit_NameLabel = new Label("Name");
			Label sessionEdit_Title = new Label("Edit main.Session");
			sessionEdit_Title.setFont(new Font("Arial", 48));

			TextField sessionEdit_NameText = new TextField();

			ComboBox<String> sessionEdit_TimeSlotCombo = new ComboBox<String>(); // integer
			for ( timeSlotItem ts : getTimeSlotItems()){
				sessionEdit_TimeSlotCombo.getItems().add(ts.getTime());
			}
			
			ComboBox<String> sessionEdit_SpeakerCombo = new ComboBox<String>();
			for ( speakerPerson s : getSpeakers()){
				sessionEdit_SpeakerCombo.getItems().add(s.getFullName());
			}
			
			ComboBox<String> sessionEdit_RoomCombo = new ComboBox<String>();
			for ( roomCap r : getRoomAndCapacity()){
				sessionEdit_RoomCombo.getItems().add(r.getRoomName());
			}
			

			Label sessionEdit_TimeSlotLabel = new Label("Time Slot");
			Label sessionEdit_SpeakerLabel = new Label("main.Speaker");
			Label sessionEdit_RoomLabel = new Label("main.Room");

			HBox sessionEdit_LabelsAndTexts = new HBox(sessionEdit_NameLabel, sessionEdit_NameText,
					sessionEdit_TimeSlotLabel, sessionEdit_TimeSlotCombo, sessionEdit_SpeakerLabel,
					sessionEdit_SpeakerCombo, sessionEdit_RoomLabel, sessionEdit_RoomCombo);
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

			timeSlotEdit.setOnAction(e ->{ 
			final int timeSlot_EditIndex= timeSlot_List.getSelectionModel().getSelectedIndex();
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

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public class roomCap {
		private String roomName;
		private String roomCapacity;

		public roomCap() {
			this.roomName = "";
			this.roomCapacity = "";
		}

		public roomCap(String roomName, String roomCapacity) {
			this.roomName = roomName;
			this.roomCapacity = roomCapacity;
		}

		public String getRoomName() {
			return roomName;
		}

		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}

		public String getRoomCapacity() {
			return roomCapacity;
		}

		public void setRoomCapacity(String roomCapacity) {
			this.roomCapacity = roomCapacity;
		}
	}

	public ObservableList<roomCap> getRoomAndCapacity() {
		ObservableList<roomCap> roomsAndCapacities = FXCollections.observableArrayList();
		roomsAndCapacities.add(new roomCap("Beatty 401", "150"));

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

		public String getFullName() {
			// TODO Auto-generated method stub
			return this.firstName + " " + this.lastName;
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

	public class sessionItem{
		private String name;
		private speakerPerson speaker;
		private roomCap room;
		private timeSlotItem timeSlot;

		public sessionItem() {
			this.name="";
			this.speaker=null;
			this.room=null;
			this.timeSlot=null;
		}

		public sessionItem(String name, speakerPerson speaker, roomCap room, timeSlotItem timeSlot) {
			this.name=name;
			this.speaker=speaker;
			this.room=room;
			this.timeSlot=timeSlot;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name) {
			this.name=name;
		}

		public speakerPerson getSpeaker() {
			return speaker;
		}

		public void setSpeaker(speakerPerson speaker) {
			this.speaker=speaker;
		}

		public roomCap getRoom() {
			return room;
		}

		public void setRoom(roomCap room) {
			this.room=room;
		}

		public timeSlotItem getTimeSlot() {
			return timeSlot;
		}

		public void setTimeSlot(timeSlotItem timeSlot) {
			this.timeSlot=timeSlot;
		}
	}

	public ObservableList<sessionItem> getSessions() {
		ObservableList<sessionItem> sessions = FXCollections.observableArrayList();
		sessions.add(new sessionItem("Test main.Session",new speakerPerson("John","Fawkner","fawknerj@wit.edu"),new roomCap("Beatty 401", "150"), new timeSlotItem(8,15,9,15)));
		return sessions;
	}



	public class timeSlotItem{
		private int startHour;
		private int startMinute;
		private int endHour;
		private int endMinute;

		public timeSlotItem() {
			this.startHour=0;
			this.startMinute=0;
			this.endHour=0;
			this.endHour=0;
		}

		public timeSlotItem(int startHour, int startMinute, int endHour, int endMinute) {
			this.startHour=startHour;
			this.startMinute=startMinute;
			this.endHour=endHour;
			this.endMinute=endMinute;
		}

		public int getStartHour() {
			return startHour;
		}

		public void setStartHour(int startHour) {
			this.startHour=startHour;
		}

		public int getStartMinute() {
			return startMinute;
		}

		public void setStartMinute(int startMinute) {
			this.startMinute=startMinute;
		}

		public int getEndHour() {
			return endHour;
		}

		public void setEndHour(int endHour) {
			this.endHour=endHour;
		}

		public int getEndMinute() {
			return endMinute;
		}

		public void setEndMinute(int endMinute) {
			this.endMinute=endMinute;
		}

		public String getTime() {
			return startHour+":"+startMinute+" - "+endHour+":"+endMinute;
		}
	}

	public ObservableList<timeSlotItem> getTimeSlotItems() {
		ObservableList<timeSlotItem> timeSlotList = FXCollections.observableArrayList();
		timeSlotList.add(new timeSlotItem(8,15,9,15));
		return timeSlotList;
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