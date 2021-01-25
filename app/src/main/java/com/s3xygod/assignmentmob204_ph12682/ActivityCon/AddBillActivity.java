package com.s3xygod.assignmentmob204_ph12682.ActivityCon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.BillDAO;
import com.s3xygod.assignmentmob204_ph12682.model.Bill;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddBillActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText edNgayMua, edMaHoaDon;
    BillDAO hoaDonDAO;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("THÊM HOÁ ĐƠN");
        setContentView(R.layout.activity_add_bill);
        edNgayMua = findViewById(R.id.edNgayMua);
        edMaHoaDon = findViewById(R.id.edMaHoaDon);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
    }

    private void setDate(final Calendar calendar) {
        edNgayMua.setText(sdf.format(calendar.getTime()));
    }

    public void datePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "date");
    }

    public void ADDHoaDon(View view) {
        hoaDonDAO = new BillDAO(AddBillActivity.this);
        try {
            if (validation() < 0) {
                Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                Bill hoaDon = new Bill(edMaHoaDon.getText().toString(), sdf.parse(edNgayMua.getText().toString()));
                if (hoaDonDAO.insertBill(hoaDon) > 0) {
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddBillActivity.this, BillInfoActivity.class);
                    Bundle b = new Bundle();
                    b.putString("MAHOADON", edMaHoaDon.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại",
                            Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }

    public int validation() {
        if (edMaHoaDon.getText().toString().isEmpty() || edNgayMua.getText().toString().isEmpty()) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public static class DatePickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
    }
}