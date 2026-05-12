# 📱 Class Description: ModalNonDismissibleBottomSheet

________________________________________
## 1. General Information
*   **Class Name:** `ModalNonDismissibleBottomSheet`
*   **Type:** Fragment (specifically `BottomSheetDialogFragment`)
*   **Purpose:** This class demonstrates a Bottom Sheet that the user **cannot** close by dragging it down or by tapping outside of it. It forces the user to interact with the content or click a specific "Close" button.
*   **Interactions:** Launched from `MainActivity`.

________________________________________
## 3. Classroom Methods

### Method name: `onCreateDialog`
*   **Type:** `public`
*   **What it does:**
    1.  Creates the standard `BottomSheetDialog`.
    2.  Sets `setCancelable(false)`, which prevents the user from closing the sheet by tapping the background.
    3.  Adds an `OnShowListener`: when the sheet appears, it finds the internal `FrameLayout`.
    4.  Accesses the `BottomSheetBehavior` and sets `setDraggable(false)`. This is the "magic" line that prevents the user from sliding the sheet down with their finger.
*   **When called:** When the dialog is being initialized by the system.

### Method name: `onCreateView`
*   **Type:** `public`
*   **What it does:** Loads the layout and sets a click listener on the "Close" button. Since the sheet is non-draggable, this button is the **only way** for the user to close the panel.
*   **When called:** To build the visual content of the sheet.

________________________________________
## 4. Lifecycle
*   **onCreateDialog():** Disabling "drag-to-close" and "tap-outside-to-close" logic.
*   **onCreateView():** Providing the "Close" button for the user.

________________________________________
## 7. General logic
1. The user clicks "Modal Non-Dismissible Bottom Sheet".
2. The panel slides up.
3. The user tries to swipe it down or tap the background, but nothing happens.
4. The user is "forced" to read the content or take an action.
5. The user clicks the internal "Close" button to return.

________________________________________
## 8. Simplified explanation
Think of `ModalNonDismissibleBottomSheet` as a **Mandatory Popup**.
Imagine you are playing a game and a message pops up saying "Update Required". You shouldn't be able to just swipe it away and ignore it. This class creates a "stubborn" window that stays there until the user explicitly acknowledges it by clicking the button you provided.
