# 📱 Class Description: CustomLegacyDialog

________________________________________
## 1. General Information
*   **Class Name:** `CustomLegacyDialog`
*   **Type:** Normal Class (extends `Dialog`)
*   **Purpose:** This class demonstrates the "old school" or manual way of creating custom popup windows in Android. It is responsible for showing a dialog where the user can enter their name and submit it.
*   **Interactions:** 
    *   It is created and shown by `MainActivity`.
    *   It uses a **Callback Interface** (`OnNameEnteredListener`) to send the entered name back to the Activity.

________________________________________
## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `etName` | `EditText` | An input field where the user types their name. | Used in `onCreate` to get text. |
| `bOk` | `Button` | The button the user clicks to confirm. | Used in `onCreate` to set a click listener. |
| `listener` | `OnNameEnteredListener` | An object that "listens" for the moment the user clicks OK. | Used to send data back to `MainActivity`. |

________________________________________
## 3. Classroom Methods

### Method name: `CustomLegacyDialog` (Constructor)
*   **Type:** `public`
*   **Return value:** N/A
*   **Parameters:**
    | Name | Type | Description |
    | :--- | :--- | :--- |
    | `context` | `Context` | The environment (usually `MainActivity`) where the dialog lives. |
    | `listener` | `OnNameEnteredListener` | The piece of code that will handle the result. |
*   **What it does:** Initializes the dialog and stores the listener so it can be used later.

### Method name: `onCreate`
*   **Type:** `protected`
*   **Return value:** `void`
*   **Parameters:** `Bundle savedInstanceState`
*   **What it does:**
    1.  Sets the layout using `setContentView(R.layout.custom_legacy_dialog)`.
    2.  Removes the default title bar (`FEATURE_NO_TITLE`).
    3.  Links UI elements (`etName`, `bOk`) to code.
    4.  Defines what happens when `bOk` is clicked: it gets the text, sends it to the listener, and closes the dialog.
    5.  Configures the window to be transparent and centered.
*   **When called:** Automatically when `dialog.show()` is called.

________________________________________
## 4. Lifecycle
*   This is not an Activity, but it has a mini-lifecycle:
*   **onCreate():** Set up the view.
*   **onStart() / onStop():** When the dialog appears or disappears.

________________________________________
## 5. Interface Interaction (UI)
*   **Elements:** `EditText` (input), `Button` (action).
*   **Connection:** `findViewById` inside `onCreate`.
*   **Events:** `setOnClickListener` on the OK button.

________________________________________
## 6. Interaction with other components
*   **Callback Interface:** This is the most important part. It defines a "contract" between the Dialog and the Activity. The Dialog says: "I don't know what to do with the name, but whoever uses me must provide a function `onNameEntered`."

________________________________________
## 7. General logic
1. `MainActivity` creates the dialog and says "Let me know when they enter a name."
2. The dialog shows an input field.
3. User types "Alice" and clicks OK.
4. The dialog calls the listener's `onNameEntered("Alice")` method.
5. The dialog closes itself (`dismiss`).

________________________________________
## 8. Simplified explanation
Think of `CustomLegacyDialog` as a **Messenger**.
Imagine you are in a room (MainActivity) and you need to ask someone their name, but you are busy. You send a messenger (this Dialog) to the user. The messenger has a form (the UI). Once the user fills the form and clicks OK, the messenger runs back to you and gives you the paper with the name on it.
This "running back" part is the **Listener**.
