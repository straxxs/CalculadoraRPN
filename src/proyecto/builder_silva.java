package proyecto;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;

public class builder_silva {

    private String cadenaOperacion = "";

    private JFrame frame;
    private JTextField display;
    private JButton boton2;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    builder_silva window = new builder_silva();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public builder_silva() {
        initialize();
    }

    private void agregar(String simbolo) {
        cadenaOperacion += simbolo;
        display.setText(cadenaOperacion);
    }

    private void calcular() {
        String resultado = ConexionCalculadora.procesar(cadenaOperacion);

        if (resultado.startsWith("Error:")) {
            display.setText(resultado);
            cadenaOperacion = "";
        } else {
            if (resultado.endsWith(".0")) {
                resultado = resultado.substring(0, resultado.length() - 2);
            }

            display.setText(resultado);
            cadenaOperacion = resultado;
        }
    }

    private void borrarTodo() {
        cadenaOperacion = "";
        display.setText("");
    }

    private void borrarUltimo() {
        if (!cadenaOperacion.isEmpty()) {
            cadenaOperacion = cadenaOperacion.substring(
                    0, cadenaOperacion.length() - 1);
            display.setText(cadenaOperacion);
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.decode("#14213d"));
        frame.setResizable(false);
        frame.setBounds(100, 100, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        java.net.URL urlIcono = getClass().getResource("/icono.png");
        if (urlIcono != null) {
            java.awt.Image icono = new javax.swing.ImageIcon(urlIcono).getImage();
            frame.setIconImage(icono);
        }

        JButton boton1 = new JButton("1");
        boton1.setMargin(new Insets(2, 5, 2, 5));
        boton1.setBackground(Color.decode("#FFFFFF"));
        boton1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                agregar("1");
            }
        });
        boton1.setBounds(40, 161, 40, 40);
        frame.getContentPane().add(boton1);

        boton2 = new JButton("2");
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("2");
            }
        });
        boton2.setBackground(Color.decode("#FFFFFF"));
        boton2.setMargin(new Insets(2, 5, 2, 5));
        boton2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton2.setBounds(90, 161, 40, 40);
        frame.getContentPane().add(boton2);

        JButton boton3 = new JButton("3");
        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("3");
            }
        });
        boton3.setBackground(Color.decode("#FFFFFF"));
        boton3.setMargin(new Insets(2, 5, 2, 5));
        boton3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton3.setBounds(142, 161, 40, 40);
        frame.getContentPane().add(boton3);

        JButton boton4 = new JButton("4");
        boton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("4");
            }
        });
        boton4.setBackground(Color.decode("#FFFFFF"));
        boton4.setMargin(new Insets(2, 5, 2, 5));
        boton4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton4.setBounds(40, 110, 40, 40);
        frame.getContentPane().add(boton4);

        JButton boton5 = new JButton("5");
        boton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("5");
            }
        });
        boton5.setBackground(Color.decode("#FFFFFF"));
        boton5.setMargin(new Insets(2, 5, 2, 5));
        boton5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton5.setBounds(90, 110, 40, 40);
        frame.getContentPane().add(boton5);

        JButton boton6 = new JButton("6");
        boton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("6");
            }
        });
        boton6.setBackground(Color.decode("#FFFFFF"));
        boton6.setMargin(new Insets(2, 5, 2, 5));
        boton6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton6.setBounds(142, 110, 40, 40);
        frame.getContentPane().add(boton6);

        JButton boton7 = new JButton("7");
        boton7.setMargin(new Insets(2, 5, 2, 5));
        boton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("7");
            }
        });
        boton7.setBackground(Color.decode("#FFFFFF"));
        boton7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton7.setBounds(40, 59, 40, 40);
        frame.getContentPane().add(boton7);

        JButton boton8 = new JButton("8");
        boton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("8");
            }
        });
        boton8.setBackground(Color.decode("#FFFFFF"));
        boton8.setMargin(new Insets(2, 5, 2, 5));
        boton8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton8.setBounds(90, 59, 40, 40);
        frame.getContentPane().add(boton8);

        JButton boton9 = new JButton("9");
        boton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("9");
            }
        });
        boton9.setBackground(Color.decode("#FFFFFF"));
        boton9.setMargin(new Insets(2, 5, 2, 5));
        boton9.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton9.setBounds(142, 59, 40, 40);
        frame.getContentPane().add(boton9);

        JButton boton0 = new JButton("0");
        boton0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("0");
            }
        });
        boton0.setBackground(Color.decode("#FFFFFF"));
        boton0.setMargin(new Insets(2, 5, 2, 5));
        boton0.setFont(new Font("Tahoma", Font.PLAIN, 15));
        boton0.setBounds(40, 212, 90, 40);
        frame.getContentPane().add(boton0);

        JButton botonigual = new JButton("=");
        botonigual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        botonigual.setBackground(Color.decode("#FCA311"));
        botonigual.setMargin(new Insets(2, 5, 2, 5));
        botonigual.setFont(new Font("Tahoma", Font.PLAIN, 15));
        botonigual.setBounds(192, 212, 40, 40);
        frame.getContentPane().add(botonigual);

        JButton botonmenos = new JButton("-");
        botonmenos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("-");
            }
        });
        botonmenos.setBackground(Color.decode("#babec2"));
        botonmenos.setMargin(new Insets(2, 5, 2, 5));
        botonmenos.setFont(new Font("Tahoma", Font.PLAIN, 15));
        botonmenos.setBounds(292, 110, 40, 40);
        frame.getContentPane().add(botonmenos);

        JButton botonmas = new JButton("+");
        botonmas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("+");
            }
        });
        botonmas.setBackground(Color.decode("#babec2"));
        botonmas.setMargin(new Insets(2, 5, 2, 5));
        botonmas.setFont(new Font("Tahoma", Font.PLAIN, 15));
        botonmas.setBounds(242, 110, 40, 40);
        frame.getContentPane().add(botonmas);

        display = new JTextField();
        display.setBackground(Color.decode("#000000"));
        display.setEnabled(true);
        display.setBounds(42, 11, 290, 40);
        frame.getContentPane().add(display);
        display.setColumns(10);
        display.setEditable(false);
        display.setFont(new Font("Tahoma", Font.PLAIN, 18));
        display.setForeground(Color.WHITE);
        display.setHorizontalAlignment(JTextField.RIGHT);
 

        JButton botonmulti = new JButton("x");
        botonmulti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("*");
            }
        });
        botonmulti.setBackground(Color.decode("#babec2"));
        botonmulti.setMargin(new Insets(2, 5, 2, 5));
        botonmulti.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botonmulti.setBounds(242, 161, 40, 40);
        frame.getContentPane().add(botonmulti);

        JButton botondiv = new JButton("/");
        botondiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("/");
            }
        });
        botondiv.setBackground(Color.decode("#babec2"));
        botondiv.setMargin(new Insets(2, 5, 2, 5));
        botondiv.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botondiv.setBounds(292, 161, 40, 40);
        frame.getContentPane().add(botondiv);

        JButton botonpot = new JButton("^");
        botonpot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("^");
            }
        });
        botonpot.setBackground(Color.decode("#babec2"));
        botonpot.setMargin(new Insets(2, 5, 2, 5));
        botonpot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botonpot.setBounds(242, 212, 40, 40);
        frame.getContentPane().add(botonpot);

        JButton botontetra = new JButton("#");
        botontetra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("#");
            }
        });
        botontetra.setBackground(Color.decode("#babec2"));
        botontetra.setMargin(new Insets(2, 5, 2, 5));
        botontetra.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botontetra.setBounds(292, 212, 40, 40);
        frame.getContentPane().add(botontetra);

        JButton botondecimal = new JButton(".");
        botondecimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar(".");
            }
        });
        botondecimal.setBackground(Color.decode("#FFFFFF"));
        botondecimal.setMargin(new Insets(2, 5, 2, 5));
        botondecimal.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botondecimal.setBounds(142, 212, 40, 40);
        frame.getContentPane().add(botondecimal);

        JButton botonborrar = new JButton("AC");
        botonborrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarTodo();
            }
        });
        botonborrar.setBackground(Color.decode("#babec2"));
        botonborrar.setMargin(new Insets(2, 5, 2, 5));
        botonborrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botonborrar.setBounds(242, 59, 90, 40);
        frame.getContentPane().add(botonborrar);

        JButton botoncerrar = new JButton(")");
        botoncerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar(")");
            }
        });
        botoncerrar.setBackground(Color.decode("#babec2"));
        botoncerrar.setMargin(new Insets(2, 5, 2, 5));
        botoncerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botoncerrar.setBounds(192, 161, 40, 40);
        frame.getContentPane().add(botoncerrar);

        JButton botonabrir = new JButton("(");
        botonabrir.setMargin(new Insets(2, 5, 2, 5));
        botonabrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregar("(");
            }
        });
        botonabrir.setBackground(Color.decode("#babec2"));
        botonabrir.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botonabrir.setBounds(192, 110, 40, 40);
        frame.getContentPane().add(botonabrir);

        JButton botonvolver = new JButton("⌫");
        botonvolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarUltimo();
            }
        });
        botonvolver.setBackground(Color.decode("#babec2"));
        botonvolver.setMargin(new Insets(2, 5, 2, 5));
        botonvolver.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
        botonvolver.setBounds(192, 59, 40, 40);
        frame.getContentPane().add(botonvolver);


    }
	public Color getBoton2Background() {
		return boton2.getBackground();
	}
	public void setBoton2Background(Color background) {
		boton2.setBackground(background);
	}
}