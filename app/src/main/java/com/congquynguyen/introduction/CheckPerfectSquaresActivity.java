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
import java.util.Random;

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
                String quantityText = editTextNumbers.getText().toString().trim();
                if (!quantityText.isEmpty()) {
                    int quantity = Integer.parseInt(quantityText);

                    List<Integer> perfectSquares = generateRandomPerfectSquares(quantity);

                    if (!perfectSquares.isEmpty()) {
                        StringBuilder result = new StringBuilder();
                        for (int number : perfectSquares) {
                            result.append(number).append(" ");
                        }
                        textViewResult.setText("Số chính phương: " + result);
                    } else {
                        textViewResult.setText("Không có số chính phương nào.");
                    }
                } else {
                    Toast.makeText(CheckPerfectSquaresActivity.this, "Vui lòng nhập số lượng phần tử", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Hàm random dãy số chính phương
    private List<Integer> generateRandomPerfectSquares(int quantity) {
        List<Integer> perfectSquares = new ArrayList<>();
        Random random = new Random();
        int count = 0;

        while (count < quantity) {
            int randomNum = random.nextInt(100000) + 1;
            if (isPerfectSquare(randomNum)) {
                perfectSquares.add(randomNum);
                count++;
            }
        }
        return perfectSquares;
    }

    public boolean isPerfectSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }
}