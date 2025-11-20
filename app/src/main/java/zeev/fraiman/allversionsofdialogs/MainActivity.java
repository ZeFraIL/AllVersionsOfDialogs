package zeev.fraiman.allversionsofdialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.method.CharacterPickerDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int selectedItem = 0;
    private ArrayList<Integer> selectedItems = new ArrayList<>();
    private AlertDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.classicAlertDialogButton).setOnClickListener(v -> showClassicAlertDialog());
        findViewById(R.id.customAlertDialogButton).setOnClickListener(v -> showCustomAlertDialog());
        findViewById(R.id.singleChoiceAlertDialogButton).setOnClickListener(v -> showSingleChoiceAlertDialog());
        findViewById(R.id.radioButtonsAlertDialogButton).setOnClickListener(v -> showRadioButtonsAlertDialog());
        findViewById(R.id.multiChoiceAlertDialogButton).setOnClickListener(v -> showMultiChoiceAlertDialog());
        //findViewById(R.id.titlelessButtonlessAlertDialogButton).setOnClickListener(v -> showTitlelessButtonlessAlertDialog());
        findViewById(R.id.customLegacyDialogButton).setOnClickListener(v -> showCustomLegacyDialog());
        findViewById(R.id.dialogFragmentButton).setOnClickListener(v -> showDialogFragment());
        findViewById(R.id.alertDialogInDialogFragmentButton).setOnClickListener(v -> showAlertDialogInDialogFragment());
        findViewById(R.id.fullscreenDialogFragmentButton).setOnClickListener(v -> showFullScreenDialogFragment());
        findViewById(R.id.transparentAnimatedDialogFragmentButton).setOnClickListener(v -> showTransparentAnimatedDialogFragment());
        findViewById(R.id.datePickerDialogButton).setOnClickListener(v -> showDatePickerDialog());
        findViewById(R.id.datePickerDialogSpinnerButton).setOnClickListener(v -> showDatePickerDialogSpinner());
        findViewById(R.id.datePickerDialogCalendarButton).setOnClickListener(v -> showDatePickerDialogCalendar());
        findViewById(R.id.timePickerDialog24hButton).setOnClickListener(v -> showTimePickerDialog24h());
        findViewById(R.id.timePickerDialog12hButton).setOnClickListener(v -> showTimePickerDialog12h());
        findViewById(R.id.dateRangePickerButton).setOnClickListener(v -> showDateRangePicker());
        findViewById(R.id.materialDatePickerButton).setOnClickListener(v -> showMaterialDatePicker());
        findViewById(R.id.materialTimePickerButton).setOnClickListener(v -> showMaterialTimePicker());
        findViewById(R.id.materialAlertDialogButton).setOnClickListener(v -> showMaterialAlertDialog());
        findViewById(R.id.materialSingleChoiceDialogButton).setOnClickListener(v -> showMaterialSingleChoiceDialog());
        findViewById(R.id.materialMultiChoiceDialogButton).setOnClickListener(v -> showMaterialMultiChoiceDialog());
        findViewById(R.id.materialListDialogButton).setOnClickListener(v -> showMaterialListDialog());
        findViewById(R.id.materialCustomContentButton).setOnClickListener(v -> showMaterialCustomContentDialog());
        findViewById(R.id.bottomSheetDialogButton).setOnClickListener(v -> showBottomSheetDialog());
        findViewById(R.id.bottomSheetDialogFragmentButton).setOnClickListener(v -> showBottomSheetDialogFragment());
        findViewById(R.id.modalNonDismissibleBottomSheetButton).setOnClickListener(v -> showModalNonDismissibleBottomSheet());
        findViewById(R.id.persistentBottomSheetActivityButton).setOnClickListener(v -> openPersistentBottomSheetActivity());
        findViewById(R.id.popupWindowButton).setOnClickListener(this::showPopupWindow);
        findViewById(R.id.popupMenuButton).setOnClickListener(this::showPopupMenu);
        findViewById(R.id.dropdownMenuActivityButton).setOnClickListener(v -> openDropdownMenuActivity());
        findViewById(R.id.toastButton).setOnClickListener(v -> showToast());
        findViewById(R.id.customToastButton).setOnClickListener(v -> showCustomToast());
        findViewById(R.id.snackbarButton).setOnClickListener(this::showSnackbar);
        findViewById(R.id.snackbarWithActionButton).setOnClickListener(this::showSnackbarWithAction);
        findViewById(R.id.progressDialogButton).setOnClickListener(v -> showProgressDialog());
        findViewById(R.id.circularProgressDialogButton).setOnClickListener(v -> showCircularProgressDialog());
        findViewById(R.id.horizontalProgressDialogButton).setOnClickListener(v -> showHorizontalProgressDialog());
        findViewById(R.id.customAnimatedDialogButton).setOnClickListener(v -> showCustomAnimatedDialog());
        findViewById(R.id.spotlightDialogButton).setOnClickListener(v -> showSpotlightDialog());
        findViewById(R.id.topRoundedDialogButton).setOnClickListener(v -> showTopRoundedDialog());
    }

    private void showClassicAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Classic Alert Dialog")
                .setMessage("This is a classic AlertDialog from the old builder.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .setNeutralButton("Later", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showCustomAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_custom, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).setView(dialogView).create();
        Button bCancel = dialogView.findViewById(R.id.bCancel);
        bCancel.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void showSingleChoiceAlertDialog() {
        final String[] items = {"Praha", "Brno", "Ostrava","Olomouc"};
        selectedItem = 0;
        TextView selectionText = new TextView(this);
        selectionText.setText("Selected: " + items[selectedItem]);
        selectionText.setPadding(50, 40, 50, 40);
        selectionText.setTextSize(18);
        selectionText.setGravity(Gravity.CENTER);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Single Choice Dialog")
                .setSingleChoiceItems(items, selectedItem, (d, which) -> {
                    selectedItem = which;
                    // Обновляем текст сразу при выборе
                    selectionText.setText("Selected: " + items[which]);
                })
                // Добавляем наш TextView как кастомную view
                .setView(selectionText)

                .setPositiveButton("OK", (d, which) -> {
                    Toast.makeText(this, "Selected as final: " + items[selectedItem], Toast.LENGTH_LONG).show();
                })
                .setNegativeButton("Cancel", (d, which) -> d.dismiss())
                .create();

        dialog.show();
    }

    private void showRadioButtonsAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_radio_buttons, null);
        RadioGroup radioGroup = dialogView.findViewById(R.id.radioGroup);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Radio Buttons Dialog")
                .setView(dialogView)
                .setPositiveButton("OK", (d, which) -> {
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    if (selectedId != -1) {
                        RadioButton rb = dialogView.findViewById(selectedId);
                        Toast.makeText(this, "Selected sa final: " + rb.getText(), Toast.LENGTH_LONG).show();
                    }
                    d.dismiss();
                })
                .setNegativeButton("Cancel", (d, which) -> d.dismiss())
                .create();
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != -1) { // -1
                RadioButton selectedRadioButton = dialogView.findViewById(checkedId);
                Toast.makeText(this,
                        "Selected: " + selectedRadioButton.getText(),
                        Toast.LENGTH_LONG).show();
            }
        });
        dialog.show();
    }

    private void showMultiChoiceAlertDialog() {
        final String[] items = {"Ford", "Opel", "Toyota"};
        final boolean[] checkedItems = {false, false, false};
        selectedItems.clear();

        new AlertDialog.Builder(this)
                .setTitle("Multi Choice Dialog")
                .setIcon(android.R.drawable.ic_dialog_alert)
                //.setMessage("You can see your choices in the Toast after clicking OK")
                .setMultiChoiceItems(items, checkedItems, (dialog, which, isChecked) -> {
                    if (isChecked) {
                        selectedItems.add(which);
                    } else {
                        selectedItems.remove(Integer.valueOf(which));
                    }
                })
                .setPositiveButton("OK", (dialog, which) -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < selectedItems.size(); i++) {
                        sb.append(items[selectedItems.get(i)]);
                        if (i != selectedItems.size() - 1) {
                            sb.append(", ");
                        }
                    }
                    Toast.makeText(MainActivity.this, "Selected: " + sb.toString(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    /*private void showTitlelessButtonlessAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_custom, null);
        new AlertDialog.Builder(this)
                .setView(dialogView)
                .show();
    }*/

    private void showCustomLegacyDialog() {
        CustomLegacyDialog dialog = new CustomLegacyDialog(this, name -> {
            if (!name.isEmpty()) {
                Toast.makeText(this, "Hello, " + name + "!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    private void showDialogFragment() {
        new MyDialogFragment().show(getSupportFragmentManager(), "my_dialog_fragment");
    }

    private void showAlertDialogInDialogFragment() {
        new AlertDialogInDialogFragment().show(getSupportFragmentManager(), "alert_dialog_in_dialog_fragment");
    }

    private void showFullScreenDialogFragment() {
        new FullScreenDialogFragment().show(getSupportFragmentManager(), "fullscreen_dialog_fragment");
    }

    private void showTransparentAnimatedDialogFragment() {
        new TransparentAnimatedDialogFragment().show(getSupportFragmentManager(), "transparent_animated_dialog_fragment");
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
            Toast.makeText(MainActivity.this, "Selected date: " + date, Toast.LENGTH_SHORT).show();
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void showDatePickerDialogSpinner() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                (view, year, month, dayOfMonth) -> {
                    String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                    Toast.makeText(MainActivity.this, "Selected date: " + date, Toast.LENGTH_SHORT).show();
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setSpinnersShown(true);
        datePickerDialog.getDatePicker().setCalendarViewShown(false);
        datePickerDialog.show();
    }

    private void showDatePickerDialogCalendar() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
            Toast.makeText(MainActivity.this, "Selected date: " + date, Toast.LENGTH_SHORT).show();
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setSpinnersShown(false);
        datePickerDialog.getDatePicker().setCalendarViewShown(true);
        datePickerDialog.show();
    }

    private void showTimePickerDialog24h() {
        Calendar calendar = Calendar.getInstance();
        new TimePickerDialog(this, (view, hourOfDay, minute) -> {
            String time = hourOfDay + ":" + minute;
            Toast.makeText(MainActivity.this, "Selected time: " + time, Toast.LENGTH_SHORT).show();
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
    }

    private void showTimePickerDialog12h() {
        Calendar calendar = Calendar.getInstance();
        new TimePickerDialog(this, (view, hourOfDay, minute) -> {
            String time = hourOfDay + ":" + minute;
            Toast.makeText(MainActivity.this, "Selected time: " + time, Toast.LENGTH_SHORT).show();
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
    }

    private void showDateRangePicker() {
        MaterialDatePicker<Pair<Long, Long>> picker = MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Select a date range")
                .build();
        picker.show(getSupportFragmentManager(), picker.toString());
        picker.addOnPositiveButtonClickListener(selection -> Toast.makeText(MainActivity.this, "Selected range: " + selection.first + " - " + selection.second, Toast.LENGTH_LONG).show());
    }

    private void showMaterialDatePicker() {
        MaterialDatePicker<Long> picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select a date")
                .build();
        picker.show(getSupportFragmentManager(), picker.toString());
        picker.addOnPositiveButtonClickListener(selection -> Toast.makeText(MainActivity.this, "Selected date: " + picker.getHeaderText(), Toast.LENGTH_LONG).show());
    }

    private void showMaterialTimePicker() {
        MaterialTimePicker picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select time")
                .build();
        picker.show(getSupportFragmentManager(), picker.toString());
        picker.addOnPositiveButtonClickListener(v -> Toast.makeText(MainActivity.this, "Selected time: " + picker.getHour() + ":" + picker.getMinute(), Toast.LENGTH_SHORT).show());
    }

    private void showMaterialAlertDialog() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material Alert Dialog")
                .setMessage("This is a dialog built with MaterialAlertDialogBuilder.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showMaterialSingleChoiceDialog() {
        final String[] items = {"Item 1", "Item 2", "Item 3"};
        selectedItem = 0;
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material Single Choice")
                .setSingleChoiceItems(items, selectedItem, (dialog, which) -> selectedItem = which)
                .setPositiveButton("OK", (dialog, which) -> {
                    Toast.makeText(MainActivity.this, "Selected: " + items[selectedItem], Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showMaterialMultiChoiceDialog() {
        final String[] items = {"Item 1", "Item 2", "Item 3"};
        final boolean[] checkedItems = {false, false, false};
        selectedItems.clear();
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material Multi Choice")
                .setMultiChoiceItems(items, checkedItems, (dialog, which, isChecked) -> {
                    if (isChecked) {
                        selectedItems.add(which);
                    } else {
                        selectedItems.remove(Integer.valueOf(which));
                    }
                })
                .setPositiveButton("OK", (dialog, which) -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < selectedItems.size(); i++) {
                        sb.append(items[selectedItems.get(i)]);
                        if (i != selectedItems.size() - 1) {
                            sb.append(", ");
                        }
                    }
                    Toast.makeText(MainActivity.this, "Selected: " + sb.toString(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showMaterialListDialog() {
        final String[] items = {"Item 1", "Item 2", "Item 3"};
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material List")
                .setItems(items, (dialog, which) -> {
                    Toast.makeText(MainActivity.this, "Selected: " + items[which], Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .show();
    }

    private void showMaterialCustomContentDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_custom, null);
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material Custom Content")
                .setView(dialogView)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetView.findViewById(R.id.closeButton).setOnClickListener(v -> bottomSheetDialog.dismiss());
        bottomSheetDialog.show();
    }

    private void showBottomSheetDialogFragment() {
        BottomSheetDialogFragment bottomSheetDialogFragment = new MyBottomSheetDialogFragment();
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }

    private void showModalNonDismissibleBottomSheet() {
        ModalNonDismissibleBottomSheet bottomSheet = new ModalNonDismissibleBottomSheet();
        bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
    }

    private void openPersistentBottomSheetActivity() {
        Intent intent = new Intent(this, PersistentBottomSheetActivity.class);
        startActivity(intent);
    }

    private void showPopupWindow(View anchor) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAsDropDown(anchor);
    }

    private void showPopupMenu(View anchor) {
        PopupMenu popup = new PopupMenu(this, anchor);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "Selected: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        });

        popup.show();
    }

    private void openDropdownMenuActivity() {
        Intent intent = new Intent(this, DropdownMenuActivity.class);
        startActivity(intent);
    }

    private void showToast() {
        Toast.makeText(this, "This is a simple Toast!", Toast.LENGTH_SHORT).show();
    }

    private void showCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);
        toast.show();
    }

    private void showSnackbar(View view) {
        Snackbar.make(view, "This is a simple Snackbar", Snackbar.LENGTH_LONG).show();
    }

    private void showSnackbarWithAction(View view) {
        Snackbar.make(view, "Snackbar with action", Snackbar.LENGTH_INDEFINITE)
                .setAction("UNDO", v -> {
                    Toast.makeText(MainActivity.this, "Action clicked!", Toast.LENGTH_SHORT).show();
                })
                .setActionTextColor(Color.YELLOW)
                .show();
    }

    private void showProgressDialog() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Please wait...");
        builder.setMessage("Closing in 5 seconds...");
        builder.setCancelable(false);

        progressDialog = builder.create();
        progressDialog.show();

        new CountDownTimer(5000, 1000) {
            int secondsLeft = 5;

            @Override
            public void onTick(long millisUntilFinished) {
                secondsLeft--;
                progressDialog.setMessage("Closed after " + secondsLeft + " sec...");
            }

            @Override
            public void onFinish() {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        }.start();
    }


    private void showCircularProgressDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_circular_progress, null);

        progressDialog = new MaterialAlertDialogBuilder(this)
                .setTitle("Loading")
                .setView(dialogView)
                .setCancelable(false)   // нельзя закрыть вручную
                .create();               // используем create(), а не show() сразу

        progressDialog.show();

        // Автоматически закрываем ровно через 5 секунд (БЕЗ показа счётчика)
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }, 5000);  // 5000 мс = 5 секунд
    }

    private void showHorizontalProgressDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_horizontal_progress, null);
        LinearProgressIndicator progressIndicator = dialogView.findViewById(R.id.horizontal_progress);

        AlertDialog dialog = new MaterialAlertDialogBuilder(this)
                .setTitle("Loading")
                .setView(dialogView)
                .setCancelable(false)
                .show();

        Handler handler = new Handler(Looper.getMainLooper());
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                final int progress = i;
                handler.post(() -> progressIndicator.setProgressCompat(progress, true));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            handler.post(dialog::dismiss);
        }).start();
    }


    private void showCustomAnimatedDialog() {
        Dialog dialog = new Dialog(this, R.style.CustomAnimatedDialog);
        dialog.setContentView(R.layout.dialog_custom_animated);
        dialog.findViewById(R.id.closeButton).setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void showSpotlightDialog() {
        DialogFragment dialogFragment = new SpotlightDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "spotlight_dialog_fragment");
    }

    private void showTopRoundedDialog() {
        DialogFragment dialogFragment = new TopRoundedDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "top_rounded_dialog_fragment");
    }
}
