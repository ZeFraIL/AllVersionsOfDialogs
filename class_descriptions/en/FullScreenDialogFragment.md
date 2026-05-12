# 📱 Class Description: FullScreenDialogFragment

________________________________________
## 1. General Information
*   **Class Name:** `FullScreenDialogFragment`
*   **Type:** Fragment (specifically `DialogFragment`)
*   **Purpose:** This class provides a dialog that occupies the entire screen. It is used for complex tasks where a small popup isn't enough space (like adding a new contact or editing an item).
*   **Interactions:** 
    *   Launched from `MainActivity`.
    *   Uses a custom theme to remove standard dialog borders and make it full-screen.

________________________________________
## 2. Variables (Class Fields)
*   *Note: This class uses local variables for UI components.*

________________________________________
## 3. Classroom Methods

### Method name: `onCreate`
*   **Type:** `public`
*   **What it does:** Sets the style of the fragment. It uses `STYLE_NORMAL` and a special theme `Theme_AllVersionsOfDialogs_FullScreenDialog` which tells Android to ignore the usual dialog margins.
*   **When called:** When the fragment is first initialized.

### Method name: `onViewCreated`
*   **Type:** `public`
*   **Parameters:** `View view`, `Bundle savedInstanceState`
*   **What it does:**
    1.  Finds the `MaterialToolbar` at the top of the screen.
    2.  Sets the title and configures the "Back" arrow to close the dialog.
    3.  Finds the "OK" button and also sets it to close the dialog.
*   **When called:** After the layout has been loaded.

________________________________________
## 4. Lifecycle (Fragment)
*   **onCreate():** Setting the full-screen style.
*   **onCreateView():** Inflating (loading) the layout XML.
*   **onViewCreated():** Linking buttons to actions.

________________________________________
## 5. Interface Interaction (UI)
*   **Elements:** `MaterialToolbar` (top navigation), `Button` (confirm action).
*   **Events:** `setNavigationOnClickListener` and `setOnClickListener`.

________________________________________
## 7. General logic
1. User clicks "Fullscreen Dialog".
2. The fragment opens and covers the whole phone screen.
3. The user interacts with the full page.
4. User clicks "X" in the toolbar or "OK" at the bottom to return to the main screen.

________________________________________
## 8. Simplified explanation
Think of `FullScreenDialogFragment` as a **Temporary Room**.
Most dialogs are like a small window that opens. A full-screen dialog is like walking into a different room for a moment to do a specific task, and then walking back out when you're done. It's more immersive and allows for more complex interfaces.
