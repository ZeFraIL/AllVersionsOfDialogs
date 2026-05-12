# 📱 Class Description: PersistentBottomSheetActivity

________________________________________
## 1. General Information
*   **Class Name:** `PersistentBottomSheetActivity`
*   **Type:** Activity
*   **Purpose:** This Activity demonstrates a "Persistent Bottom Sheet". Unlike a popup that covers the screen, a persistent bottom sheet is a view that is part of the screen layout and can be pulled up or pushed down.
*   **Interactions:** Launched from `MainActivity`.

________________________________________
## 2. Variables (Class Fields)
| Name | Type | Purpose | Where is it used |
| :--- | :--- | :--- | :--- |
| `bottomSheetBehavior` | `BottomSheetBehavior` | Controls the state (expanded, collapsed) of the bottom sheet. | Used in `onCreate` to respond to button clicks. |

________________________________________
## 3. Classroom Methods

### Method name: `onCreate`
*   **Type:** `protected`
*   **What it does:**
    1.  Loads the layout.
    2.  Finds the `FrameLayout` that acts as the bottom sheet.
    3.  Initializes the `bottomSheetBehavior` from that view.
    4.  Sets up two buttons: one to force the sheet to "Expand" (show fully) and one to "Collapse" (hide partially).
*   **When called:** When the Activity starts.

________________________________________
## 4. Lifecycle (Activity)
*   **onCreate():** Setup UI and Behavior logic.

________________________________________
## 5. Interface Interaction (UI)
*   **Elements:** `FrameLayout` (the sheet), `Button` (to expand), `Button` (to collapse).
*   **Connection:** `findViewById`.
*   **Events:** `setOnClickListener` to change the `bottomSheetBehavior` state.

________________________________________
## 7. General logic
1. The user opens the screen.
2. A small portion of the bottom sheet might be visible at the bottom.
3. User clicks "Expand" -> The sheet slides up to cover most of the screen.
4. User clicks "Collapse" -> The sheet slides back down.
5. User can also manually drag the sheet with their finger.

________________________________________
## 8. Simplified explanation
Think of `PersistentBottomSheetActivity` as a **Drawer in a desk**.
The desk is the screen. The drawer is always there. You can pull the drawer out to see what's inside, or push it back in so it doesn't take up space. It doesn't leave the desk; it's just tucked away.
