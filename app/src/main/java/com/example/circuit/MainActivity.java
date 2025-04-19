package com.example.circuit;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrecyclerView;
    RecyclerViewAdapter myAdapter;
    TextView noMatchText;

    List<Circuits> circuits1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circuits1 = new ArrayList<>();
        circuits1.add(new Circuits(" Wi-Fi Controlled LED ","1 NodeMCU ESP8266\n" +
                "1 LED (any color) \n" +
                "1 220Ω Resistor\n" +
                "1 Breadboard\n" +
                "5 Jumper Wires (Male-to-Male)\n" +
                "1 Micro USB Cable\n" +
                "1 Laptop with Arduino IDE", "Connections","1. LED + Resistor\n" +
                "- LED Anode (longer leg) → Connect to one end of 220Ω resistor.\n" +
                "- Other end of 220Ω resistor → Connect to D1 pin (GPIO5) on NodeMCU.\n" +
                "- LED Cathode (shorter leg) → Connect to GND pin on NodeMCU.\n\n" +
                "2. NodeMCU Power\n" +
                "- Vin → Used only if powering external components (not used here).\n" +
                "- GND → Common ground (used for LED).\n" +
                "- Micro USB → Used to power NodeMCU and upload code.\n",R.drawable.p1));

        circuits1.add(new Circuits("Temperature & Humidity Monitor","1 NodeMCU ESP8266\n" +
                "1 DHT11 Temperature & Humidity Sensor \n" +
                "1 10kΩ Pull-up Resistor (optional for DHT11 data pin stability)\n" +
                "1 Breadboard\n" +
                "1 Micro USB Cable\n" +
                "~6 Jumper Wires (Male-to-Male) \n" +
                "1 Laptop with Arduino IDE", "Connections","NodeMCU with DHT11 Sensor\n" +
                "- DHT11 VCC pin → Connect to 3V3 pin of NodeMCU\n" +
                "- DHT11 DATA pin → Connect to D2 (GPIO4) pin of NodeMCU\n" +
                "- DHT11 GND pin → Connect to GND pin of NodeMCU\n" +
                "- (Optional) 10kΩ Resistor → Connect between VCC and DATA pin of DHT11 (used as a pull-up resistor for signal stability)\n",R.drawable.p2));

        circuits1.add(new Circuits(" IoT Home Automation with Blynk","NodeMCU ESP8266 – 1\n" +
                "Relay Module (1-channel or 4-channel) – 1 (or more, based on devices)\n" +
                "Home Appliances (e.g., LED, fan, bulb) – 1 or more (simulated using LEDs if testing)\n" +
                "Breadboard – 1 (optional, for prototyping)\n" +
                "Jumper Wires (Male-to-Male) – ~6-10\n" +
                "Micro USB Cable – 1\n" +
                "Smartphone with Blynk App installed – 1\n" +
                "Laptop with Arduino IDE – 1", "Connections","1.NodeMCU to Relay Module (Assuming 1-Channel Relay):\n" +
                "- VCC of Relay Module → Connect to 3V3 pin of NodeMCU\n" +
                "- GND of Relay Module → Connect to GND pin of NodeMCU\n" +
                "- IN (Signal Pin) of Relay Module → Connect to D1 (GPIO5) on NodeMCU\n\n" +
                "2.Relay to Load (e.g., Bulb or Fan) – Simulated using LED for testing:\n" +
                "- Common (COM) → Connect to one terminal of AC load or LED\n" +
                "- Normally Open (NO) → Connect to Live wire (through switch or directly if LED is used)\n" +
                "- Other terminal of Load → Connect to Neutral (for AC) or GND (for LED test)\n",R.drawable.p3));

        circuits1.add(new Circuits("IoT Weather Station","NodeMCU ESP8266 – 1\n" +
                "DHT11/DHT22 Temperature & Humidity Sensor – 1\n" +
                "Breadboard – 1\n" +
                "Jumper Wires (Male-to-Male) – ~6\n" +
                "Micro USB Cable – 1\n" +
                "Smartphone with Blynk App or any Web Dashboard – 1\n" +
                "Laptop with Arduino IDE – 1", "Connections","1.DHT11/DHT22 Sensor Connections to NodeMCU:\n" +
                "- VCC (DHT11/DHT22) → Connect to 3V3 pin of NodeMCU\n" +
                "- DATA (DHT11/DHT22) → Connect to D2 (GPIO4) pin of NodeMCU\n" +
                "- GND (DHT11/DHT22) → Connect to GND pin of NodeMCU\n\n" +
                "2.NodeMCU Connections:\n" +
                "- NodeMCU 3V3 Pin → Connects to VCC of DHT11/DHT22\n" +
                "- NodeMCU D2 Pin (GPIO4) → Connects to DATA pin of DHT11/DHT22\n" +
                "- NodeMCU GND Pin → Connects to GND pin of DHT11/DHT22\n",R.drawable.p4));

        circuits1.add(new Circuits("Smart Dustbin","NodeMCU ESP8266 – 1\n" +
                "Ultrasonic Sensor (HC-SR04) – 1\n" +
                "Breadboard – 1\n" +
                "Jumper Wires (Male-to-Male) – ~6\n" +
                "Micro USB Cable – 1\n" +
                "Smartphone with Blynk App or Web Dashboard – 1\n" +
                "Laptop with Arduino IDE – 1\n" +
                "External Power Supply (5V) – 1", "Connections","1.Ultrasonic Sensor (HC-SR04) Connections:\n" +
                "- VCC of HC-SR04 → Connect to 5V pin of NodeMCU\n" +
                "- GND of HC-SR04 → Connect to GND pin of NodeMCU\n" +
                "- Trigger (TRIG) Pin of HC-SR04 → Connect to D2 (GPIO4) pin of NodeMCU\n" +
                "- Echo (ECHO) Pin of HC-SR04 → Connect to D1 (GPIO5) pin of NodeMCU\n\n" +
                "2.NodeMCU Power Connections:\n" +
                "- 3V3 Pin of NodeMCU → Power the board through Micro USB Cable\n" +
                "- GND Pin of NodeMCU → Common ground with ultrasonic sensor and other components\n",R.drawable.p5));

        circuits1.add(new Circuits(" IoT-Based Water Level Indicator","NodeMCU ESP8266 – 1\n" +
                "Water Level Sensor (or float switch) – 1\n" +
                "Breadboard – 1\n" +
                "Jumper Wires (Male-to-Male) – ~6\n" +
                "Micro USB Cable – 1\n" +
                "Smartphone with Blynk App or Web Dashboard – 1\n" +
                "Laptop with Arduino IDE – 1\n" +
                "External Power Supply (5V) – 1", "Connections","1.Water Level Sensor to NodeMCU:\n" +
                "- VCC of Water Level Sensor → Connect to 3V3 pin of NodeMCU\n" +
                "- GND of Water Level Sensor → Connect to GND pin of NodeMCU\n" +
                "- Signal Pin (S) of Water Level Sensor → Connect to D2 (GPIO4) pin of NodeMCU\n\n" +
                "2.NodeMCU Power Supply Connections:\n" +
                "- NodeMCU 3V3 Pin → Connect to 3.3V on the breadboard or power it via Micro USB\n" +
                "- NodeMCU GND Pin → Common ground between sensor and NodeMCU",R.drawable.p6));

        circuits1.add(new Circuits("Gas Leak Detector","NodeMCU ESP8266 – 1\n" +
                "MQ-2 Gas Sensor Module – 1\n" +
                "Buzzer (optional, for local alarm) – 1\n" +
                "Jumper Wires (Male-to-Male) – ~8\n" +
                "Laptop with Arduino IDE – 1\n" +
                "Smartphone with Blynk App (or any IoT dashboard like ThingSpeak) – 1\n" +
                "Breadboard or PCB – 1\n" +
                "Micro USB Cable for NodeMCU – 1\n" +
                "5V Power Supply", "Connections","1.MQ-2 Gas Sensor to NodeMCU:\n" +
                "- VCC → Connect to 3V3 of NodeMCU\n" +
                "- GND → Connect to GND of NodeMCU\n" +
                "- A0 (Analog Output) → Connect to A0 of NodeMCU\n\n" +
                "2.Buzzer to NodeMCU (optional):\n" +
                "- Positive pin of Buzzer → Connect to D5 (GPIO14)\n" +
                "- Negative pin of Buzzer → Connect to GND\n\n" +
                "3.NodeMCU Power Supply:\n" +
                "- Power the NodeMCU via Micro USB or a regulated 5V power supply\n" +
                "- Ensure a common ground for all components",R.drawable.p7));

        circuits1.add(new Circuits("IoT-Based Soil Moisture Sensor","NodeMCU ESP8266 – 1\n" +
                "Soil Moisture Sensor (Analog type) – 1\n" +
                "10KΩ Resistor (optional for pull-down in some sensor modules) – 1\n" +
                "Breadboard – 1\n" +
                "Jumper Wires (Male-to-Male) – ~6\n" +
                "Micro USB Cable (for powering NodeMCU) – 1\n" +
                "Blynk App / ThingSpeak / Firebase (for monitoring on phone) – 1\n" +
                "Laptop with Arduino IDE installed – 1", "Connections","1.Soil Moisture Sensor to NodeMCU:\n" +
                "- VCC of Soil Sensor → Connect to 3V3 pin of NodeMCU\n" +
                "- GND of Soil Sensor → Connect to GND pin of NodeMCU\n" +
                "- A0 (Analog Output) → Connect to A0 pin of NodeMCU\n\n" +
                "2.NodeMCU Power Supply:\n" +
                "- NodeMCU powered via USB cable or 5V regulated adapter\n" +
                "- Make sure all grounds (GND) are connected together",R.drawable.p8));

        circuits1.add(new Circuits("Smart Door Lock","NodeMCU ESP8266 – 1\n" +
                "Servo Motor (e.g., SG90 or MG90S) – 1\n" +
                "Smartphone with Blynk App installed – 1\n" +
                "Micro USB Cable – 1\n" +
                "Jumper Wires (Male-to-Male) – ~6\n" +
                "Breadboard – 1\n" +
                "5V External Power Supply (for Servo, optional) – 1\n" +
                "Laptop with Arduino IDE – 1", "Connections","1.Servo Motor to NodeMCU:\n" +
                "- Red Wire (VCC) → Connect to Vin on NodeMCU (or 5V external power)\n" +
                "- Brown/Black Wire (GND) → Connect to GND on NodeMCU\n" +
                "- Orange/Yellow Wire (Signal) → Connect to D4 (GPIO2) on NodeMCU\n\n" +
                "2.NodeMCU to Power & Wi-Fi:\n" +
                "- Connect NodeMCU to laptop or USB charger via Micro USB cable\n" +
                "- It will connect to your Wi-Fi network and the Blynk server",R.drawable.p9));

        circuits1.add(new Circuits("IoT-Based Fire Alarm","NodeMCU ESP8266 – 1\n" +
                "Flame Sensor Module – 1\n" +
                "Buzzer (for local sound alert) – 1\n" +
                "Smartphone with Blynk App installed – 1\n" +
                "Jumper Wires (Male-to-Male) – ~8\n" +
                "Breadboard – 1\n" +
                "Micro USB Cable (for powering NodeMCU) – 1\n" +
                "Laptop with Arduino IDE – 1", "Connections","1.Flame Sensor to NodeMCU:\n" +
                "- VCC → Connect to 3.3V on NodeMCU\n" +
                "- GND → Connect to GND on NodeMCU\n" +
                "- DO (Digital Output) → Connect to D2 (GPIO4) on NodeMCU\n\n" +
                "2.Buzzer to NodeMCU:\n" +
                "- Positive (Long leg) → Connect to D3 (GPIO0) on NodeMCU\n" +
                "- Negative (Short leg) → Connect to GND on NodeMCU\n\n" +
                "3.NodeMCU to Power & Wi-Fi:\n" +
                "- Connect NodeMCU to Laptop/Power Bank/Charger via Micro USB Cable\n" +
                "- Ensure NodeMCU is connected to Wi-Fi and Blynk cloud\n",R.drawable.p10));

        circuits1.add(new Circuits("Smart Street Light System","NodeMCU ESP8266 – 1\n" +
                "LDR (Light Dependent Resistor) – 1\n" +
                "PIR Motion Sensor – 1\n" +
                "LED or Relay Module (to control actual street lights) – 1\n" +
                "Smartphone with Blynk App installed – 1\n" +
                "Breadboard – 1\n" +
                "Jumper Wires (Male-to-Male) – ~10\n" +
                "Micro USB Cable (for NodeMCU power) – 1\n" +
                "Laptop with Arduino IDE – 1", "Connections","1.LDR (with voltage divider) to NodeMCU:\n" +
                "- One leg of LDR → 3.3V\n" +
                "- Other leg of LDR → A0 (Analog pin)\n" +
                "- Also connect a 10kΩ resistor from A0 to GND to form a voltage divider\n\n" +
                "2.PIR Sensor to NodeMCU:\n" +
                "- VCC → Connect to 3.3V\n" +
                "- GND → Connect to GND\n" +
                "- OUT → Connect to D5 (GPIO14)\n\n" +
                "3.LED (or Relay module for real light) to NodeMCU:\n" +
                "- Positive of LED or IN pin of Relay → D6 (GPIO12)\n" +
                "- GND → GND on NodeMCU",R.drawable.p11));

        circuits1.add(new Circuits("Raspberry Pi Surveillance Camera","Raspberry Pi 3/4 (with Raspbian OS installed) – 1\n" +
                "Raspberry Pi Camera Module v2 / USB Webcam – 1\n" +
                "Micro SD Card (16GB or higher) – 1\n" +
                "Raspberry Pi Power Adapter (5V 2.5A/3A) – 1\n" +
                "Jumper Wires (if using Pi Camera) – as needed\n" +
                "Wi-Fi Network Access\n" +
                "Keyboard, Mouse, and Monitor (for initial setup if needed", "Connections","1.If using Raspberry Pi Camera Module:\n" +
                "- Connect the Camera Ribbon Cable to the CSI (Camera Serial Interface) port on Raspberry Pi.\n" +
                "- Ensure the shiny connectors are facing the HDMI port side when inserting\n\n" +
                "2.If using USB Webcam:\n" +
                "- Plug the USB Webcam into any USB port on Raspberry Pi.\n\n" +
                "3.Power Supply:\n" +
                "- Connect the Power Adapter to the Raspberry Pi’s micro USB or USB-C power port\n\n" +
                "4.Network:\n" +
                "- Connect Raspberry Pi to Wi-Fi or use an Ethernet cable.\n",R.drawable.p12));

        circuits1.add(new Circuits(" IoT Energy Meter","NodeMCU ESP8266 – 1\n" +
                "Current Sensor Module (ACS712 or SCT-013) – 1\n" +
                "Voltage Sensor Module (ZMPT101B) – 1 (optional but recommended)\n" +
                "Smartphone with Blynk App or Thingspeak account – 1\n" +
                "Jumper Wires – ~10\n" +
                "Breadboard – 1\n" +
                "Load (e.g., bulb or fan) – 1\n" +
                "Power Supply (5V USB for NodeMCU) – 1\n" +
                "PC with Arduino IDE – 1", "Connections","1.ACS712 Current Sensor to NodeMCU:\n" +
                "- VCC → Connect to 3.3V\n" +
                "- GND → Connect to GND\n" +
                "- OUT → Connect to A0 (Analog pin on NodeMCU)\n\n" +
                "2.Voltage Sensor (ZMPT101B) to NodeMCU:\n" +
                "- VCC → Connect to 3.3V\n" +
                "- GND → Connect to GND\n" +
                "- OUT → Connect to A0",R.drawable.p13));

        circuits1.add(new Circuits("Smart Parking System","NodeMCU ESP8266 – 1\n" +
                "Ultrasonic Sensors (HC-SR04) – 3 to 5 (depending on the number of parking slots)\n" +
                "LEDs (Red & Green) – 1 pair per slot\n" +
                "Resistors (220Ω) – 1 per LED\n" +
                "Breadboard or PCB – 1\n" +
                "Micro USB Cable for NodeMCU Power – 1\n" +
                "Wi-Fi Connection\n" +
                "Blynk App or ThingSpeak Dashboard – 1\n" +
                "Jumper Wires – as needed", "Connections","1.Ultrasonic Sensor (HC-SR04) to NodeMCU:\n" +
                "- VCC → NodeMCU 3.3V\n" +
                "- GND → NodeMCU GND\n" +
                "- TRIG → Any Digital Pin (e.g., D1, D2, D3...)\n" +
                "- ECHO → Any Digital Pin (e.g., D5, D6, D7...)\n\n" +
                "2.LEDs (Red & Green) for Slot Indicators:\n" +
                "- Anode (+) of Red LED → NodeMCU Digital Pin (e.g., D4) via 220Ω resistor\n" +
                "- Anode (+) of Green LED → Another Digital Pin (e.g., D8) via 220Ω resistor\n" +
                "- Cathode (-) of both LEDs → GND\n\n" +
                "3.Power Supply:\n" +
                "- Connect NodeMCU to power via Micro USB cable (5V)",R.drawable.p14));

        circuits1.add(new Circuits("IoT Air Quality Monitor","NodeMCU ESP8266 – 1\n" +
                "MQ135 Air Quality Sensor (for detecting gases like ammonia, alcohol, CO2) – 1\n" +
                "MQ7 Carbon Monoxide (CO) Sensor (optional, for CO detection) – 1\n" +
                "Smartphone with Blynk App / ThingSpeak – 1\n" +
                "Breadboard – 1\n" +
                "Jumper Wires – ~10\n" +
                "Power Supply (Micro USB for NodeMCU) – 1\n" +
                "Resistors (10kΩ, 1kΩ) – 2\n" +
                "Temperature and Humidity Sensor (DHT11 or DHT22) – 1 (optional, for environmental conditions)\n" +
                "Wi-Fi Network Connection – 1", "Connections","1.MQ135 Air Quality Sensor to NodeMCU:\n" +
                "- VCC → 3.3V (NodeMCU)\n" +
                "- GND → GND (NodeMCU)\n" +
                "- AOUT (Analog Output) → A0 (Analog Pin on NodeMCU)\n" +
                "- DO (Digital Output) → Not used (if you are only using analog output)\n" +
                "2.MQ7 Carbon Monoxide (CO) Sensor (optional) to NodeMCU:\n" +
                "- VCC → 3.3V (NodeMCU)\n" +
                "- GND → GND (NodeMCU)\n" +
                "- AOUT → A0 (Analog Pin on NodeMCU)\n\n" +
                "3.DHT11 / DHT22 (Optional Temperature and Humidity Sensor) to NodeMCU:\n" +
                "- VCC → 3.3V (NodeMCU)\n" +
                "- GND → GND (NodeMCU)\n" +
                "- DATA → D2 (GPIO4 on NodeMCU)\n" +
                "- You can use internal pull-up resistor on D2.\n\n" +
                "4.Power Supply to NodeMCU:\n" +
                "- Micro USB Cable → Connect to NodeMCU for powering.",R.drawable.p15));

        myrecyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);
        TextView noMatchText = findViewById(R.id.no_match_text);
        myAdapter = new RecyclerViewAdapter(this, circuits1, noMatchText);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this,1));

        myrecyclerView.setAdapter(myAdapter);

        SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return true;
            }
        });

    }
}