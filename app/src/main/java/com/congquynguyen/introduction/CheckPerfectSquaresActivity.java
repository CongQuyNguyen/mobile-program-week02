package com.congquynguyen.introduction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CheckPerfectSquaresActivity extends AppCompatActivity {

    private EditText editTextNumbers;
    private TextView textViewResult;
    private Button buttonCheckPerfectSquares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_perfect_squares);

        // Khởi tạo các view (nhận từ layout)
        editTextNumbers = findViewById(R.id.editTextNumbers);
        textViewResult = findViewById(R.id.textViewResult);
        buttonCheckPerfectSquares = findViewById(R.id.buttonCheckPerfectSquares);

        // Sự kiện khi nhấn nút Button
        buttonCheckPerfectSquares.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Lấy dãy số nhập vào từ EditText
                String inputText = editTextNumbers.getText().toString().trim();
                if (!inputText.isEmpty()) {

                    // Tách dãy số thành mảng số nguyên (do em nhận vào một dãy - dùng regex để tách)
                    String[] numberStrings = inputText.split("\\s+");

                    List<Integer> numbers = new ArrayList<>();
                    for (String num : numberStrings) {
                        try {
                            numbers.add(Integer.parseInt(num));
                        } catch (NumberFormatException e) {
                            Toast.makeText(CheckPerfectSquaresActivity.this, "Dãy số không hợp lệ", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    StringBuilder result = new StringBuilder();
                    for (int number : numbers) {
                        if (isPerfectSquare(number)) {
                            result.append(number).append(" ");
                        }
                    }

                    // Hiển thị kết quả trên TextView
                    if (result.length() > 0) {
                        textViewResult.setText("Số chính phương: " + result);
                    } else {
                        textViewResult.setText("Không có số chính phương nào.");
                    }

                    // Hiển thị Toast nếu có số chính phương
                    if (result.length() > 0) {
                        Toast.makeText(CheckPerfectSquaresActivity.this, "Các số chính phương: " + result, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CheckPerfectSquaresActivity.this, "Vui lòng nhập dãy số", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Hàm kiểm tra số chính phương
    public boolean isPerfectSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }
}
