import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class CurrencyConverter extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String currencies[] = {
            "USD - US Dollar",
            "CAD - Canadian Dollar",
            "MXN - Mexican Peso",
            "EUR - Euro",
            "AUD - Australian Dollar",
            "GBP - British Pound",
            "RUB - Russian Ruble",
            "JPY - Japanese Yen",
            "CNY - Chinese Yuan",
            "INR - Indian Rupee"
        };

        final double USD_TO_CAD = 1.25, USD_TO_MXN = 20.0, USD_TO_EUR = 0.85, USD_TO_AUD = 1.35, USD_TO_GBP = 0.75, USD_TO_RUB = 73.0, USD_TO_JPY = 110.0, USD_TO_CNY = 6.45, USD_TO_INR = 74.0;
        final double CAD_TO_USD = 0.80, CAD_TO_MXN = 16.0, CAD_TO_EUR = 0.68, CAD_TO_AUD = 1.08, CAD_TO_GBP = 0.60, CAD_TO_RUB = 58.0, CAD_TO_JPY = 88.0, CAD_TO_CNY = 5.16, CAD_TO_INR = 59.2;
        final double MXN_TO_USD = 0.05, MXN_TO_CAD = 0.0625, MXN_TO_EUR = 0.0425, MXN_TO_AUD = 0.0675, MXN_TO_GBP = 0.0375, MXN_TO_RUB = 3.65, MXN_TO_JPY = 5.5, MXN_TO_CNY = 0.32, MXN_TO_INR = 3.7;
        final double EUR_TO_USD = 1.18, EUR_TO_CAD = 1.47, EUR_TO_MXN = 23.5, EUR_TO_AUD = 1.59, EUR_TO_GBP = 0.88, EUR_TO_RUB = 86.0, EUR_TO_JPY = 129.0, EUR_TO_CNY = 7.6, EUR_TO_INR = 87.0;
        final double AUD_TO_USD = 0.74, AUD_TO_CAD = 0.93, AUD_TO_MXN = 14.8, AUD_TO_EUR = 0.63, AUD_TO_GBP = 0.55, AUD_TO_RUB = 54.0, AUD_TO_JPY = 82.0, AUD_TO_CNY = 5.8, AUD_TO_INR = 43.0;
        final double GBP_TO_USD = 1.33, GBP_TO_CAD = 1.67, GBP_TO_MXN = 26.8, GBP_TO_EUR = 1.14, GBP_TO_AUD = 1.82, GBP_TO_RUB = 98.0, GBP_TO_JPY = 150.0, GBP_TO_CNY = 9.2, GBP_TO_INR = 100.0;
        final double RUB_TO_USD = 0.014, RUB_TO_CAD = 0.017, RUB_TO_MXN = 0.27, RUB_TO_EUR = 0.012, RUB_TO_AUD = 0.019, RUB_TO_GBP = 0.010, RUB_TO_JPY = 1.53, RUB_TO_CNY = 0.094, RUB_TO_INR = 1.02;
        final double JPY_TO_USD = 0.0091, JPY_TO_CAD = 0.011, JPY_TO_MXN = 0.18, JPY_TO_EUR = 0.0078, JPY_TO_AUD = 0.012, JPY_TO_GBP = 0.0067, JPY_TO_RUB = 0.65, JPY_TO_CNY = 0.00086, JPY_TO_INR = 0.74;
        final double CNY_TO_USD = 0.155, CNY_TO_CAD = 0.19, CNY_TO_MXN = 0.31, CNY_TO_EUR = 0.13, CNY_TO_AUD = 0.17, CNY_TO_GBP = 0.11, CNY_TO_RUB = 10.6, CNY_TO_JPY = 116.0, CNY_TO_INR = 11.5;
        final double INR_TO_USD = 0.013, INR_TO_CAD = 0.017, INR_TO_MXN = 0.27, INR_TO_EUR = 0.011, INR_TO_AUD = 0.023, INR_TO_GBP = 0.010, INR_TO_RUB = 0.98, INR_TO_JPY = 1.35, INR_TO_CNY = 0.087;

        Label headerLabel = new Label("Choose a currency to convert");

        ComboBox<String> fromCurrency = new ComboBox<>();
        fromCurrency.getItems().addAll(currencies);
        fromCurrency.setPromptText("From");

        ComboBox<String> toCurrency = new ComboBox<>();
        toCurrency.getItems().addAll(currencies);
        toCurrency.setPromptText("To");

        HBox selectorBox = new HBox(10, fromCurrency, toCurrency);
        selectorBox.setAlignment(Pos.CENTER);

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        HBox amountBox = new HBox(10, amountLabel, amountField);
        amountBox.setAlignment(Pos.CENTER);

        Label resultLabel = new Label("Converted Amount: ");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        HBox resultBox = new HBox(10, resultLabel, resultField);
        resultBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, headerLabel, selectorBox, amountBox, resultBox);
        root.setPadding(new Insets(25));
        root.setAlignment(Pos.CENTER);

        amountField.setOnKeyReleased(e -> {
            String from = fromCurrency.getValue();
            String to = toCurrency.getValue();

            double amount = Double.parseDouble(amountField.getText());
            double convertedAmount = 0.0;

            if (from.equals("USD - US Dollar") && to.equals("CAD - Canadian Dollar")) {
                convertedAmount = amount * USD_TO_CAD;
            } else if (from.equals("USD - US Dollar") && to.equals("MXN - Mexican Peso")) {
                convertedAmount = amount * USD_TO_MXN;
            } else if (from.equals("USD - US Dollar") && to.equals("EUR - Euro")) {
                convertedAmount = amount * USD_TO_EUR;
            } else if (from.equals("USD - US Dollar") && to.equals("AUD - Australian Dollar")) {
                convertedAmount = amount * USD_TO_AUD;
            } else if (from.equals("USD - US Dollar") && to.equals("GBP - British Pound")) {
                convertedAmount = amount * USD_TO_GBP;
            } else if (from.equals("USD - US Dollar") && to.equals("RUB - Russian Ruble")) {
                convertedAmount = amount * USD_TO_RUB;
            } else if (from.equals("USD - US Dollar") && to.equals("JPY - Japanese Yen")) {
                convertedAmount = amount * USD_TO_JPY;
            } else if (from.equals("USD - US Dollar") && to.equals("CNY - Chinese Yuan")) {
                convertedAmount = amount * USD_TO_CNY;
            } else if (from.equals("USD - US Dollar") && to.equals("INR - Indian Rupee")) {
                convertedAmount = amount * USD_TO_INR;
            } else if (from.equals("CAD - Canadian Dollar") && to.equals("USD - US Dollar")) {
                convertedAmount = amount * CAD_TO_USD;
            } else if (from.equals("CAD - Canadian Dollar") && to.equals("MXN - Mexican Peso")) {
                convertedAmount = amount * CAD_TO_MXN;
            } else if (from.equals("CAD - Canadian Dollar") && to.equals("EUR - Euro")) {
                convertedAmount = amount * CAD_TO_EUR;
            } else if (from.equals("CAD - Canadian Dollar") && to.equals("AUD - Australian Dollar")) {
                convertedAmount = amount * CAD_TO_AUD;
            } else if (from.equals("CAD - Canadian Dollar") && to.equals("GBP - British Pound")) {
                convertedAmount = amount * CAD_TO_GBP;
            } else if (from.equals("CAD - Canadian Dollar") && to.equals("RUB - Russian Ruble")) {
                convertedAmount = amount * CAD_TO_RUB;
            } else if (from.equals("CAD - Canadian Dollar") && to.equals("JPY - Japanese Yen")) {
                convertedAmount = amount * CAD_TO_JPY;
            } else if (from.equals("CAD - Canadian Dollar") && to.equals("CNY - Chinese Yuan")) {
                convertedAmount = amount * CAD_TO_CNY;
            } else if (from.equals("CAD - Canadian Dollar") && to.equals("INR - Indian Rupee")) {
                convertedAmount = amount * CAD_TO_INR;
            } else if (from.equals("MXN - Mexican Peso") && to.equals("USD - US Dollar")) {
                convertedAmount = amount * MXN_TO_USD;
            } else if (from.equals("MXN - Mexican Peso") && to.equals("CAD - Canadian Dollar")) {
                convertedAmount = amount * MXN_TO_CAD;
            } else if (from.equals("MXN - Mexican Peso") && to.equals("EUR - Euro")) {
                convertedAmount = amount * MXN_TO_EUR;
            } else if (from.equals("MXN - Mexican Peso") && to.equals("AUD - Australian Dollar")) {
                convertedAmount = amount * MXN_TO_AUD;
            } else if (from.equals("MXN - Mexican Peso") && to.equals("GBP - British Pound")) {
                convertedAmount = amount * MXN_TO_GBP;
            } else if (from.equals("MXN - Mexican Peso") && to.equals("RUB - Russian Ruble")) {
                convertedAmount = amount * MXN_TO_RUB;
            } else if (from.equals("MXN - Mexican Peso") && to.equals("JPY - Japanese Yen")) {
                convertedAmount = amount * MXN_TO_JPY;
            } else if (from.equals("MXN - Mexican Peso") && to.equals("CNY - Chinese Yuan")) {
                convertedAmount = amount * MXN_TO_CNY;
            } else if (from.equals("MXN - Mexican Peso") && to.equals("INR - Indian Rupee")) {
                convertedAmount = amount * MXN_TO_INR;
            } else if (from.equals("EUR - Euro") && to.equals("USD - US Dollar")) {
                convertedAmount = amount * EUR_TO_USD;
            } else if (from.equals("EUR - Euro") && to.equals("CAD - Canadian Dollar")) {
                convertedAmount = amount * EUR_TO_CAD;
            } else if (from.equals("EUR - Euro") && to.equals("MXN - Mexican Peso")) {
                convertedAmount = amount * EUR_TO_MXN;
            } else if (from.equals("EUR - Euro") && to.equals("AUD - Australian Dollar")) {
                convertedAmount = amount * EUR_TO_AUD;
            } else if (from.equals("EUR - Euro") && to.equals("GBP - British Pound")) {
                convertedAmount = amount * EUR_TO_GBP;
            } else if (from.equals("EUR - Euro") && to.equals("RUB - Russian Ruble")) {
                convertedAmount = amount * EUR_TO_RUB;
            } else if (from.equals("EUR - Euro") && to.equals("JPY - Japanese Yen")) {
                convertedAmount = amount * EUR_TO_JPY;
            } else if (from.equals("EUR - Euro") && to.equals("CNY - Chinese Yuan")) {
                convertedAmount = amount * EUR_TO_CNY;
            } else if (from.equals("EUR - Euro") && to.equals("INR - Indian Rupee")) {
                convertedAmount = amount * EUR_TO_INR;
            } else if (from.equals("AUD - Australian Dollar") && to.equals("USD - US Dollar")) {
                convertedAmount = amount * AUD_TO_USD;
            } else if (from.equals("AUD - Australian Dollar") && to.equals("CAD - Canadian Dollar")) {
                convertedAmount = amount * AUD_TO_CAD;
            } else if (from.equals("AUD - Australian Dollar") && to.equals("MXN - Mexican Peso")) {
                convertedAmount = amount * AUD_TO_MXN;
            } else if (from.equals("AUD - Australian Dollar") && to.equals("EUR - Euro")) {
                convertedAmount = amount * AUD_TO_EUR;
            } else if (from.equals("AUD - Australian Dollar") && to.equals("GBP - British Pound")) {
                convertedAmount = amount * AUD_TO_GBP;
            } else if (from.equals("AUD - Australian Dollar") && to.equals("RUB - Russian Ruble")) {
                convertedAmount = amount * AUD_TO_RUB;
            } else if (from.equals("AUD - Australian Dollar") && to.equals("JPY - Japanese Yen")) {
                convertedAmount = amount * AUD_TO_JPY;
            } else if (from.equals("AUD - Australian Dollar") && to.equals("CNY - Chinese Yuan")) {
                convertedAmount = amount * AUD_TO_CNY;
            } else if (from.equals("AUD - Australian Dollar") && to.equals("INR - Indian Rupee")) {
                convertedAmount = amount * AUD_TO_INR;
            } else if (from.equals("GBP - British Pound") && to.equals("USD - US Dollar")) {
                convertedAmount = amount * GBP_TO_USD;
            } else if (from.equals("GBP - British Pound") && to.equals("CAD - Canadian Dollar")) {
                convertedAmount = amount * GBP_TO_CAD;
            } else if (from.equals("GBP - British Pound") && to.equals("MXN - Mexican Peso")) {
                convertedAmount = amount * GBP_TO_MXN;
            } else if (from.equals("GBP - British Pound") && to.equals("EUR - Euro")) {
                convertedAmount = amount * GBP_TO_EUR;
            } else if (from.equals("GBP - British Pound") && to.equals("AUD - Australian Dollar")) {
                convertedAmount = amount * GBP_TO_AUD;
            } else if (from.equals("GBP - British Pound") && to.equals("RUB - Russian Ruble")) {
                convertedAmount = amount * GBP_TO_RUB;
            } else if (from.equals("GBP - British Pound") && to.equals("JPY - Japanese Yen")) {
                convertedAmount = amount * GBP_TO_JPY;
            } else if (from.equals("GBP - British Pound") && to.equals("CNY - Chinese Yuan")) {
                convertedAmount = amount * GBP_TO_CNY;
            } else if (from.equals("GBP - British Pound") && to.equals("INR - Indian Rupee")) {
                convertedAmount = amount * GBP_TO_INR;
            } else if (from.equals("RUB - Russian Ruble") && to.equals("USD - US Dollar")) {
                convertedAmount = amount * RUB_TO_USD;
            } else if (from.equals("RUB - Russian Ruble") && to.equals("CAD - Canadian Dollar")) {
                convertedAmount = amount * RUB_TO_CAD;
            } else if (from.equals("RUB - Russian Ruble") && to.equals("MXN - Mexican Peso")) {
                convertedAmount = amount * RUB_TO_MXN;
            } else if (from.equals("RUB - Russian Ruble") && to.equals("EUR - Euro")) {
                convertedAmount = amount * RUB_TO_EUR;
            } else if (from.equals("RUB - Russian Ruble") && to.equals("AUD - Australian Dollar")) {
                convertedAmount = amount * RUB_TO_AUD;
            } else if (from.equals("RUB - Russian Ruble") && to.equals("GBP - British Pound")) {
                convertedAmount = amount * RUB_TO_GBP;
            } else if (from.equals("RUB - Russian Ruble") && to.equals("JPY - Japanese Yen")) {
                convertedAmount = amount * RUB_TO_JPY;
            } else if (from.equals("RUB - Russian Ruble") && to.equals("CNY - Chinese Yuan")) {
                convertedAmount = amount * RUB_TO_CNY;
            } else if (from.equals("RUB - Russian Ruble") && to.equals("INR - Indian Rupee")) {
                convertedAmount = amount * RUB_TO_INR;
            } else if (from.equals("JPY - Japanese Yen") && to.equals("USD - US Dollar")) {
                convertedAmount = amount * JPY_TO_USD;
            } else if (from.equals("JPY - Japanese Yen") && to.equals("CAD - Canadian Dollar")) {
                convertedAmount = amount * JPY_TO_CAD;
            } else if (from.equals("JPY - Japanese Yen") && to.equals("MXN - Mexican Peso")) {
                convertedAmount = amount * JPY_TO_MXN;
            } else if (from.equals("JPY - Japanese Yen") && to.equals("EUR - Euro")) {
                convertedAmount = amount * JPY_TO_EUR;
            } else if (from.equals("JPY - Japanese Yen") && to.equals("AUD - Australian Dollar")) {
                convertedAmount = amount * JPY_TO_AUD;
            } else if (from.equals("JPY - Japanese Yen") && to.equals("GBP - British Pound")) {
                convertedAmount = amount * JPY_TO_GBP;
            } else if (from.equals("JPY - Japanese Yen") && to.equals("RUB - Russian Ruble")) {
                convertedAmount = amount * JPY_TO_RUB;
            } else if (from.equals("JPY - Japanese Yen") && to.equals("CNY - Chinese Yuan")) {
                convertedAmount = amount * JPY_TO_CNY;
            } else if (from.equals("JPY - Japanese Yen") && to.equals("INR - Indian Rupee")) {
                convertedAmount = amount * JPY_TO_INR;
            } else if (from.equals("CNY - Chinese Yuan") && to.equals("USD - US Dollar")) {
                convertedAmount = amount * CNY_TO_USD;
            } else if (from.equals("CNY - Chinese Yuan") && to.equals("CAD - Canadian Dollar")) {
                convertedAmount = amount * CNY_TO_CAD;
            } else if (from.equals("CNY - Chinese Yuan") && to.equals("MXN - Mexican Peso")) {
                convertedAmount = amount * CNY_TO_MXN;
            } else if (from.equals("CNY - Chinese Yuan") && to.equals("EUR - Euro")) {
                convertedAmount = amount * CNY_TO_EUR;
            } else if (from.equals("CNY - Chinese Yuan") && to.equals("AUD - Australian Dollar")) {
                convertedAmount = amount * CNY_TO_AUD;
            } else if (from.equals("CNY - Chinese Yuan") && to.equals("GBP - British Pound")) {
                convertedAmount = amount * CNY_TO_GBP;
            } else if (from.equals("CNY - Chinese Yuan") && to.equals("RUB - Russian Ruble")) {
                convertedAmount = amount * CNY_TO_RUB;
            } else if (from.equals("CNY - Chinese Yuan") && to.equals("JPY - Japanese Yen")) {
                convertedAmount = amount * CNY_TO_JPY;
            } else if (from.equals("CNY - Chinese Yuan") && to.equals("INR - Indian Rupee")) {
                convertedAmount = amount * CNY_TO_INR;
            } else if (from.equals("INR - Indian Rupee") && to.equals("USD - US Dollar")) {
                convertedAmount = amount * INR_TO_USD;
            } else if (from.equals("INR - Indian Rupee") && to.equals("CAD - Canadian Dollar")) {
                convertedAmount = amount * INR_TO_CAD;
            } else if (from.equals("INR - Indian Rupee") && to.equals("MXN - Mexican Peso")) {
                convertedAmount = amount * INR_TO_MXN;
            } else if (from.equals("INR - Indian Rupee") && to.equals("EUR - Euro")) {
                convertedAmount = amount * INR_TO_EUR;
            } else if (from.equals("INR - Indian Rupee") && to.equals("AUD - Australian Dollar")) {
                convertedAmount = amount * INR_TO_AUD;
            } else if (from.equals("INR - Indian Rupee") && to.equals("GBP - British Pound")) {
                convertedAmount = amount * INR_TO_GBP;
            } else if (from.equals("INR - Indian Rupee") && to.equals("RUB - Russian Ruble")) {
                convertedAmount = amount * INR_TO_RUB;
            } else if (from.equals("INR - Indian Rupee") && to.equals("JPY - Japanese Yen")) {
                convertedAmount = amount * INR_TO_JPY;
            } else if (from.equals("INR - Indian Rupee") && to.equals("CNY - Chinese Yuan")) {
                convertedAmount = amount * INR_TO_CNY;
            } else if (from.equals(to)) {
                convertedAmount = amount;
            }

            resultField.setText(String.format("%,.2f", convertedAmount));
        });

        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
