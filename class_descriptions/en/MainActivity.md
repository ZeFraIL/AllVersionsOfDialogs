# 📱 Class Description: MainActivity

________________________________________
## 1. General Information
*   **Class Name:** `MainActivity`
*   **Type:** Activity
*   **Purpose:** This is the main entry point of the application. It acts as a dashboard or a "hub" that contains buttons to launch various types of dialogs and notifications. It is responsible for initializing the user interface (UI) and responding to user clicks.
*   **Interactions:** It interacts with almost every other component in the project:
    *   It creates and shows `AlertDialog` and `MaterialAlertDialogBuilder` instances.
    *   It launches `DialogFragment` subclasses like `MyDialogFragment`, `FullScreenDialogFragment`, etc.
    *   It starts other Activities like `PersistentBottomSheetActivity` and `DropdownMenuActivity` using **Intents**.

________________________________________
## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `selectedItem` | `int` | Stores the index of the item selected in a single-choice list. | Used in `showSingleChoiceAlertDialog` and `showMaterialSingleChoiceDialog`. |
| `selectedItems` | `ArrayList<Integer>` | Stores a list of indices selected in multi-choice dialogs. | Used in `showMultiChoiceAlertDialog` and `showMaterialMultiChoiceDialog`. |
| `progressDialog` | `AlertDialog` | A reference to the currently showing progress dialog. | Used to dismiss the dialog programmatically after a timer or task finishes. |

________________________________________
## 3. Classroom Methods

### Method name: `onCreate`
*   **Type:** `protected`
*   **Return value:** `void` (nothing)
*   **Parameters:**
    | Name | Type | Description |
    | :--- | :--- | :--- |
    | `savedInstanceState` | `Bundle` | Contains saved data from a previous session (if any). |
*   **What it does:**
    1.  Calls `super.onCreate` to perform standard activity setup.
    2.  Sets the visual layout using `setContentView(R.layout.activity_main)`.
    3.  Finds all buttons by their IDs and attaches "click listeners" to them. When a button is clicked, a specific method (like `showClassicAlertDialog`) is executed.
*   **When called:** Automatically by the Android system when the app starts.
*   **Important:** This is where the life of the Activity begins. If you forget to call `setContentView`, the screen will be empty.

### Method name: `showClassicAlertDialog`
*   **Type:** `private`
*   **Return value:** `void`
*   **Parameters:** None
*   **What it does:**
    1.  Uses `AlertDialog.Builder` to create a popup window.
    2.  Sets a Title, a Message, and three buttons (Positive, Negative, Neutral).
    3.  Calls `.show()` to make it visible.
*   **When called:** When the user clicks the "Classic Alert Dialog" button.

### Method name: `showProgressDialog`
*   **Type:** `private`
*   **Return value:** `void`
*   **What it does:**
    1.  Creates a non-cancelable Material dialog.
    2.  Starts a `CountDownTimer` for 5 seconds.
    3.  Every second, it updates the message showing the countdown.
    4.  When the timer hits zero, it dismisses the dialog.
*   **When called:** On button click.

________________________________________
## 4. Lifecycle (Activity)
*   **onCreate():** Called when the activity is first created. Here we set up the UI and listeners.
*   **onStart(), onResume():** Called when the activity becomes visible and ready for interaction.
*   **onPause(), onStop():** Called when the activity is no longer in the foreground (e.g., another app is opened).
*   **onDestroy():** Called before the activity is destroyed.

________________________________________
## 5. Interface Interaction (UI)
*   **Elements:** `Button`, `TextView`, `RadioGroup`, `RadioButton`.
*   **Connection:** Uses `findViewById(R.id.button_id)` to link XML elements to Java objects.
*   **Events:** Mostly `setOnClickListener` to handle button taps.

________________________________________
## 6. Interaction with other components
*   **Intents:** Uses `new Intent(this, TargetActivity.class)` to navigate to `PersistentBottomSheetActivity`.
*   **Fragment Manager:** Uses `getSupportFragmentManager()` to display `DialogFragment` instances.

________________________________________
## 7. General logic
1. The user sees a list of many buttons.
2. The user taps a button.
3. The corresponding Java method creates a "Builder" object.
4. The "Builder" configures the dialog's appearance.
5. The `.show()` method is called, and the user sees the popup.

________________________________________
## 8. Simplified explanation
Think of `MainActivity` as a **Remote Control**.
Each button on the remote control (the UI) is linked to a specific function (the code). When you press "Volume Up", the remote sends a signal to the TV. Here, when you press "Show Date Picker", the `MainActivity` sends a signal to the Android system to pop up a calendar. It is the "brain" that coordinates all the different types of popups you see in the app.
