package com.congquynguyen.introduction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckPrimeNumberActivity extends AppCompatActivity {

    private EditText editTextNumbers;
    private TextView textViewResult;
    private Button buttonCheckPrime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_prime);

        // Ánh xạ các view
        editTextNumbers = findViewById(R.id.editTextNumbers);
        textViewResult = findViewById(R.id.textViewResult);
        buttonCheckPrime = findViewById(R.id.buttonCheckPrime);

        // Set sự kiện
        buttonCheckPrime.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String input = editTextNumbers.getText().toString();

                if (input.isEmpty()) {
                    Toast.makeText(CheckPrimeNumberActivity.this, "Vui lòng nhập một số", Toast.LENGTH_SHORT).show();
                    return;
                }

                int number = Integer.parseInt(input);

                if (isPrime(number)) {
                    textViewResult.setText(number + " là số nguyên tố (có thể kiểm tra ở LOG).");
                } else {
                    textViewResult.setText(number + " không phải là số nguyên tố (có thể kiểm tra ở LOG).");
                }
            }
        });
    }
    public boolean isPrime(int number) {
        if (number <= 1) {
            Log.d("PrimeCheck", number + " không phải là số nguyên tố (<= 1).");
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                Log.d("PrimeCheck", number + " chia hết cho " + i + " nên không phải là số nguyên tố.");
                return false;
            }
        }
        Log.d("PrimeCheck", number + " là số nguyên tố.");
        return true;
    }

}
