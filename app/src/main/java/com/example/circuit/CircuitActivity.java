package com.example.circuit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CircuitActivity extends AppCompatActivity {

    private TextView mCircuitName;
    private TextView mCircuitComponents;
    private TextView mCircuitMethodTitle;
    private TextView mCircuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuit);
        mCircuitName = (TextView)findViewById(R.id.text_circuit);
        mCircuitComponents = (TextView)findViewById(R.id.components);
        mCircuitMethodTitle = (TextView)findViewById(R.id.method);
        mCircuit = (TextView)findViewById(R.id.circuit);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("CircuitName");
        String Components = intent.getExtras().getString("CircuitComponents");
        String MethodTitle = intent.getExtras().getString("CircuitMethodTitle");
        String Circuit = intent.getExtras().getString("Circuit");

        mCircuitName.setText(Title);
        mCircuitComponents.setText(Components);
        mCircuitMethodTitle.setText(MethodTitle);
        mCircuit.setText(Circuit);

    }
}