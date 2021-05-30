package uni.c.calculator;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.*;


// calculator class
public class Calculator extends JPanel{

    private static final int WINDOW_WIDTH = 410;
    private static final int WINDOW_HEIGHT = 600;
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 70;
    private static final int MARGIN_X = 20;
    private static final int MARGIN_Y = 60;
    private JFrame finestra;
    private GestorePannelli gestore;

    private JFrame window;
    private JComboBox<String> comboCalcType;
    private JComboBox<String> comboTheme;
    private JTextField inputText; // Input
    private JButton buttonBack;
    private JButton btnBack;
    private JButton btnMod;
    private JButton btnDiv;
    private JButton btnMul;
    private JButton btnSub;
    private JButton btnAdd;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnPoint;
    private JButton btnEqual;
    private JButton btnRoot;
    private JButton btnPower;
    private JButton btnLog;


    private char operator = ' ';
    private boolean onCal = true;
    private boolean displayWrite = true;
    private double valType = 0;

    

    public Calculator(JFrame finestra,GestorePannelli gestore) {
        window = new JFrame("Calculator");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocationRelativeTo(null);
        this.gestore=gestore;
        this.finestra=finestra;

        comboTheme = initCombo(new String[]{"Simple", "Colored", "DarkTheme"}, 230, 30, "Theme", themeSwitchEventConsumer);

        comboCalcType = initCombo(new String[]{"Standard", "Scientific"}, 20, 30, "Calculator type", calcTypeSwitchEventConsumer);

        int[] x = {MARGIN_X, MARGIN_X + 90, 200, 290, 380};
        int[] y = {MARGIN_Y, MARGIN_Y + 100, MARGIN_Y + 180, MARGIN_Y + 260, MARGIN_Y + 340, MARGIN_Y + 420};

        inputText = new JTextField("0");
        inputText.setBounds(x[0], y[0], 350, 70);
        inputText.setEditable(false);
        inputText.setBackground(Color.WHITE);
        inputText.setFont(new Font("Comic Sans MS", Font.PLAIN, 33));
        window.add(inputText);

        buttonBack = initBtn("C", x[0], y[1], event -> {
            repaintFont();
            inputText.setText("0");
            operator = ' ';
            valType = 0;
        });

        btnBack = initBtn("<-", x[1], y[1], event -> {
            repaintFont();
            String str = inputText.getText();
            StringBuilder str2 = new StringBuilder();
            for (int i = 0; i < (str.length() - 1); i++) {
                str2.append(str.charAt(i));
            }
            if (str2.toString().equals("")) {
                inputText.setText("0");
            } else {
                inputText.setText(str2.toString());
            }
        });

        btnMod = initBtn("%", x[2], y[1], event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inputText.getText()))
                if (onCal) {
                    valType = calc(valType, inputText.getText(), operator);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(valType))) {
                        inputText.setText(String.valueOf((int) valType));
                    } else {
                        inputText.setText(String.valueOf(valType));
                    }
                    operator = '%';
                    onCal = false;
                    displayWrite = false;
                }
        });

        btnDiv = initBtn("/", x[3], y[1], event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inputText.getText()))
                if (onCal) {
                    valType = calc(valType, inputText.getText(), operator);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(valType))) {
                        inputText.setText(String.valueOf((int) valType));
                    } else {
                        inputText.setText(String.valueOf(valType));
                    }
                    operator = '/';
                    onCal = false;
                    displayWrite = false;
                } else {
                    operator = '/';
                }
        });

        btn7 = initBtn("7", x[0], y[2], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("7");
                } else {
                    inputText.setText(inputText.getText() + "7");
                }
            } else {
                inputText.setText("7");
                displayWrite = true;
            }
            onCal = true;
        });

        btn8 = initBtn("8", x[1], y[2], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("8");
                } else {
                    inputText.setText(inputText.getText() + "8");
                }
            } else {
                inputText.setText("8");
                displayWrite = true;
            }
            onCal = true;
        });

        btn9 = initBtn("9", x[2], y[2], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("9");
                } else {
                    inputText.setText(inputText.getText() + "9");
                }
            } else {
                inputText.setText("9");
                displayWrite = true;
            }
            onCal = true;
        });

        btnMul = initBtn("*", x[3], y[2], event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inputText.getText()))
                if (onCal) {
                    valType = calc(valType, inputText.getText(), operator);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(valType))) {
                        inputText.setText(String.valueOf((int) valType));
                    } else {
                        inputText.setText(String.valueOf(valType));
                    }
                    operator = '*';
                    onCal = false;
                    displayWrite = false;
                } else {
                    operator = '*';
                }
        });

        btn4 = initBtn("4", x[0], y[3], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("4");
                } else {
                    inputText.setText(inputText.getText() + "4");
                }
            } else {
                inputText.setText("4");
                displayWrite = true;
            }
            onCal = true;
        });

        btn5 = initBtn("5", x[1], y[3], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("5");
                } else {
                    inputText.setText(inputText.getText() + "5");
                }
            } else {
                inputText.setText("5");
                displayWrite = true;
            }
            onCal = true;
        });

        btn6 = initBtn("6", x[2], y[3], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("6");
                } else {
                    inputText.setText(inputText.getText() + "6");
                }
            } else {
                inputText.setText("6");
                displayWrite = true;
            }
            onCal = true;
        });

        btnSub = initBtn("-", x[3], y[3], event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inputText.getText()))
                if (onCal) {
                    valType = calc(valType, inputText.getText(), operator);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(valType))) {
                        inputText.setText(String.valueOf((int) valType));
                    } else {
                        inputText.setText(String.valueOf(valType));
                    }

                    operator = '-';
                    onCal = false;
                    displayWrite = false;
                } else {
                    operator = '-';
                }
        });

        btn1 = initBtn("1", x[0], y[4], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("1");
                } else {
                    inputText.setText(inputText.getText() + "1");
                }
            } else {
                inputText.setText("1");
                displayWrite = true;
            }
            onCal = true;
        });

        btn2 = initBtn("2", x[1], y[4], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("2");
                } else {
                    inputText.setText(inputText.getText() + "2");
                }
            } else {
                inputText.setText("2");
                displayWrite = true;
            }
            onCal = true;
        });

        btn3 = initBtn("3", x[2], y[4], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("3");
                } else {
                    inputText.setText(inputText.getText() + "3");
                }
            } else {
                inputText.setText("3");
                displayWrite = true;
            }
            onCal = true;
        });

        btnAdd = initBtn("+", x[3], y[4], event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inputText.getText()))
                if (onCal) {
                    valType = calc(valType, inputText.getText(), operator);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(valType))) {
                        inputText.setText(String.valueOf((int) valType));
                    } else {
                        inputText.setText(String.valueOf(valType));
                    }
                    operator = '+';
                    onCal = false;
                    displayWrite = false;
                } else {
                    operator = '+';
                }
        });

        btnPoint = initBtn(".", x[0], y[5], event -> {
            repaintFont();
            if (displayWrite) {
                if (!inputText.getText().contains(".")) {
                    inputText.setText(inputText.getText() + ".");
                }
            } else {
                inputText.setText("0.");
                displayWrite = true;
            }
            onCal = true;
        });

        btn0 = initBtn("0", x[1], y[5], event -> {
            repaintFont();
            if (displayWrite) {
                if (Pattern.matches("[0]*", inputText.getText())) {
                    inputText.setText("0");
                } else {
                    inputText.setText(inputText.getText() + "0");
                }
            } else {
                inputText.setText("0");
                displayWrite = true;
            }
            onCal = true;
        });

        btnEqual = initBtn("=", x[2], y[5], event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inputText.getText()))
                if (onCal) {
                    valType = calc(valType, inputText.getText(), operator);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(valType))) {
                        inputText.setText(String.valueOf((int) valType));
                    } else {
                        inputText.setText(String.valueOf(valType));
                    }
                    operator = '=';
                    displayWrite = false;
                }
        });
        btnEqual.setSize(2 * BUTTON_WIDTH + 10, BUTTON_HEIGHT);

        btnRoot = initBtn("√", x[4], y[1], event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inputText.getText()))
                if (onCal) {
                    valType = Math.sqrt(Double.parseDouble(inputText.getText()));
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(valType))) {
                        inputText.setText(String.valueOf((int) valType));
                    } else {
                        inputText.setText(String.valueOf(valType));
                    }
                    operator = '√';
                    displayWrite = false;
                }
        });
        btnRoot.setVisible(false);

        btnPower = initBtn("pow", x[4], y[2], event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inputText.getText()))
                if (onCal) {
                    valType = calc(valType, inputText.getText(), operator);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(valType))) {
                        inputText.setText(String.valueOf((int) valType));
                    } else {
                        inputText.setText(String.valueOf(valType));
                    }
                    operator = '^';
                    onCal = false;
                    displayWrite = false;
                } else {
                    operator = '^';
                }
        });
        btnPower.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        btnPower.setVisible(false);

        btnLog = initBtn("ln", x[4], y[3], event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inputText.getText()))
                if (onCal) {
                    valType = Math.log(Double.parseDouble(inputText.getText()));
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(valType))) {
                        inputText.setText(String.valueOf((int) valType));
                    } else {
                        inputText.setText(String.valueOf(valType));
                    }
                    operator = 'l';
                    displayWrite = false;
                }
        });
        btnLog.setVisible(false);

        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button clicked? = End The process
        window.setVisible(true);
    }

    private JComboBox<String> initCombo(String[] items, int x, int y, String toolTip, Consumer consumerEvent) {
        JComboBox<String> combo = new JComboBox<>(items);
        combo.setBounds(x, y, 140, 25);
        combo.setToolTipText(toolTip);
        combo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        combo.addItemListener(consumerEvent::accept);
        window.add(combo);

        return combo;
    }

    private JButton initBtn(String label, int x, int y, ActionListener event) {
        JButton btn = new JButton(label);
        btn.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        btn.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(event);
        btn.setFocusable(false);
        window.add(btn);

        return btn;
    }

    public double calc(double x, String input, char opt) {
        inputText.setFont(inputText.getFont().deriveFont(Font.PLAIN));
        double y = Double.parseDouble(input);
        switch (opt) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            case '%':
                return x % y;
            case '^':
                return Math.pow(x, y);
            default:
                inputText.setFont(inputText.getFont().deriveFont(Font.PLAIN));
                return y;
        }
    }

    private void repaintFont() {
        inputText.setFont(inputText.getFont().deriveFont(Font.PLAIN));
    }

    private Consumer<ItemEvent> calcTypeSwitchEventConsumer = event -> {
        if (event.getStateChange() != ItemEvent.SELECTED) return;

        String selectedItem = (String) event.getItem();
        switch (selectedItem) {
            case "Standard":
                window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
                btnRoot.setVisible(false);
                btnPower.setVisible(false);
                btnLog.setVisible(false);
                break;
            case "Scientific":
                window.setSize(WINDOW_WIDTH + 80, WINDOW_HEIGHT);
                btnRoot.setVisible(true);
                btnPower.setVisible(true);
                btnLog.setVisible(true);
                break;
            default:
                //n.b
                inputText.setFont(inputText.getFont().deriveFont(Font.PLAIN));
                return;
        }
    };

    private Consumer<ItemEvent> themeSwitchEventConsumer = event -> {
        if (event.getStateChange() != ItemEvent.SELECTED) return;

        String selectedTheme = (String) event.getItem();
        switch (selectedTheme) {
            case "Simple":
                window.getContentPane().setBackground(null);
                buttonBack.setBackground(null);
                btnBack.setBackground(null);
                btnMod.setBackground(null);
                btnDiv.setBackground(null);
                btnMul.setBackground(null);
                btnSub.setBackground(null);
                btnAdd.setBackground(null);
                btnRoot.setBackground(null);
                btnLog.setBackground(null);
                btnPower.setBackground(null);
                btnEqual.setBackground(null);
                btn0.setBackground(null);
                btn1.setBackground(null);
                btn2.setBackground(null);
                btn3.setBackground(null);
                btn4.setBackground(null);
                btn5.setBackground(null);
                btn6.setBackground(null);
                btn7.setBackground(null);
                btn8.setBackground(null);
                btn9.setBackground(null);
                btnPoint.setBackground(null);

                buttonBack.setForeground(Color.BLACK);
                btnBack.setForeground(Color.BLACK);
                btnMod.setForeground(Color.BLACK);
                btnDiv.setForeground(Color.BLACK);
                btnMul.setForeground(Color.BLACK);
                btnSub.setForeground(Color.BLACK);
                btnAdd.setForeground(Color.BLACK);
                btnEqual.setForeground(Color.BLACK);
                btnLog.setForeground(Color.BLACK);
                btnPower.setForeground(Color.BLACK);
                btnRoot.setForeground(Color.BLACK);
                break;
            case "Colored":
                window.getContentPane().setBackground(null);
                buttonBack.setBackground(Color.RED);
                btnBack.setBackground(Color.ORANGE);
                btnMod.setBackground(Color.GREEN);
                btnDiv.setBackground(Color.PINK);
                btnMul.setBackground(Color.PINK);
                btnSub.setBackground(Color.PINK);
                btnAdd.setBackground(Color.PINK);
                btnRoot.setBackground(Color.PINK);
                btnLog.setBackground(Color.PINK);
                btnPower.setBackground(Color.PINK);
                btnEqual.setBackground(Color.BLUE);
                btn0.setBackground(Color.WHITE);
                btn1.setBackground(Color.WHITE);
                btn2.setBackground(Color.WHITE);
                btn3.setBackground(Color.WHITE);
                btn4.setBackground(Color.WHITE);
                btn5.setBackground(Color.WHITE);
                btn6.setBackground(Color.WHITE);
                btn7.setBackground(Color.WHITE);
                btn8.setBackground(Color.WHITE);
                btn9.setBackground(Color.WHITE);
                btnPoint.setBackground(Color.WHITE);

                buttonBack.setForeground(Color.WHITE);
                btnBack.setForeground(Color.WHITE);
                btnMod.setForeground(Color.WHITE);
                btnDiv.setForeground(Color.WHITE);
                btnMul.setForeground(Color.WHITE);
                btnSub.setForeground(Color.WHITE);
                btnAdd.setForeground(Color.WHITE);
                btnEqual.setForeground(Color.WHITE);
                btnLog.setForeground(Color.WHITE);
                btnPower.setForeground(Color.WHITE);
                btnRoot.setForeground(Color.WHITE);
                break;
            case "DarkTheme":
                final Color primaryDarkColor = new Color(141, 38, 99);
                final Color secondaryDarkColor = new Color(171, 171, 171);

                window.getContentPane().setBackground(new Color(68, 68, 68));
                btn0.setBackground(secondaryDarkColor);
                btn1.setBackground(secondaryDarkColor);
                btn2.setBackground(secondaryDarkColor);
                btn3.setBackground(secondaryDarkColor);
                btn4.setBackground(secondaryDarkColor);
                btn5.setBackground(secondaryDarkColor);
                btn6.setBackground(secondaryDarkColor);
                btn7.setBackground(secondaryDarkColor);
                btn8.setBackground(secondaryDarkColor);
                btn9.setBackground(secondaryDarkColor);
                btnPoint.setBackground(secondaryDarkColor);

                buttonBack.setForeground(secondaryDarkColor);
                btnBack.setForeground(secondaryDarkColor);
                btnMod.setForeground(secondaryDarkColor);
                btnDiv.setForeground(secondaryDarkColor);
                btnMul.setForeground(secondaryDarkColor);
                btnSub.setForeground(secondaryDarkColor);
                btnAdd.setForeground(secondaryDarkColor);
                btnEqual.setForeground(secondaryDarkColor);
                btnLog.setForeground(secondaryDarkColor);
                btnPower.setForeground(secondaryDarkColor);
                btnRoot.setForeground(secondaryDarkColor);
                buttonBack.setBackground(primaryDarkColor);
                btnBack.setBackground(primaryDarkColor);
                btnMod.setBackground(primaryDarkColor);
                btnDiv.setBackground(primaryDarkColor);
                btnMul.setBackground(primaryDarkColor);
                btnSub.setBackground(primaryDarkColor);
                btnAdd.setBackground(primaryDarkColor);
                btnRoot.setBackground(primaryDarkColor);
                btnLog.setBackground(primaryDarkColor);
                btnPower.setBackground(primaryDarkColor);
                btnEqual.setBackground(primaryDarkColor);
                break;
            default:
                return;
        }
    };


}